package com.google.googlex.gcam.androidutils.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ImageMetadataSynchronizer {
    public static final String TAG = "ImageMetadataSynchronizer";
    public CameraCaptureSession.CaptureCallback mCaptureCallback;
    public final LinkedList mPendingCaptureResultQueue = new LinkedList();
    public final List<ImageReader> mImageReaders = new ArrayList();
    public final List<LinkedList<Image>> mPendingImageQueues = new ArrayList();
    public final List mImagesAcquired = new ArrayList();
    public final List<Pair<Callback, Handler>> mCallbacks = new ArrayList();
    public boolean mClosed = false;

    public interface Callback {
        void onDataAvailable(Output output);
    }

    public static class CaptureRequestTag {
        public ArrayList mTargets;
        public Object mUserTag;

        public CaptureRequestTag() {
            this.mTargets = new ArrayList();
        }

        public CaptureRequestTag(Object obj) {
            this.mTargets = new ArrayList();
            this.mUserTag = obj;
        }

        public CaptureRequestTag(List list) {
            this.mTargets = new ArrayList(list);
        }

        public CaptureRequestTag(List list, Object obj) {
            this.mTargets = new ArrayList(list);
            this.mUserTag = obj;
        }

        public static CaptureRequestTag getCaptureRequestTag(CaptureResult captureResult) {
            Object tag;
            if (captureResult == null || (tag = captureResult.getRequest().getTag()) == null || !(tag instanceof CaptureRequestTag)) {
                return null;
            }
            return (CaptureRequestTag) tag;
        }

        public static Object getUserTag(CaptureResult captureResult) {
            CaptureRequestTag captureRequestTag = getCaptureRequestTag(captureResult);
            if (captureRequestTag != null) {
                return captureRequestTag.mUserTag;
            }
            return null;
        }

        public static boolean userTagEquals(CaptureResult captureResult, Object obj) {
            CaptureRequestTag captureRequestTag = getCaptureRequestTag(captureResult);
            if (captureRequestTag != null) {
                return captureRequestTag.mUserTag.equals(obj);
            }
            return false;
        }
    }

    public class Output {
        public ArrayList mDroppedImageReaderIndices;
        public ArrayList mImages = new ArrayList();
        public boolean mImagesWereDropped;
        public CaptureResult mResult;
        public final ImageMetadataSynchronizer mSynchronizer;

        Output(int i, ImageMetadataSynchronizer imageMetadataSynchronizer) {
            for (int i2 = 0; i2 < i; i2++) {
                this.mImages.add(null);
            }
            this.mDroppedImageReaderIndices = new ArrayList();
            this.mSynchronizer = imageMetadataSynchronizer;
        }

        public void close() {
            this.mDroppedImageReaderIndices = null;
            for (int i = 0; i < this.mImages.size(); i++) {
                Image image = (Image) this.mImages.get(i);
                if (image != null) {
                    image.close();
                    this.mSynchronizer.notifyImageClosed(i);
                }
            }
            this.mImages.clear();
            this.mResult = null;
        }
    }

    public ImageMetadataSynchronizer(List list, Handler handler) {
        createCaptureCallback();
        this.mImageReaders.addAll(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.mPendingImageQueues.add(new LinkedList());
            this.mImagesAcquired.add(0);
            int finalI = i;
            ((ImageReader) list.get(i)).setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                @Override
                public void onImageAvailable(ImageReader imageReader) {
                    synchronized (ImageMetadataSynchronizer.this) {
                        if (ImageMetadataSynchronizer.this.mClosed) {
                            return;
                        }
                        int intValue = ((Integer) ImageMetadataSynchronizer.this.mImagesAcquired.get(finalI)).intValue();
                        if (intValue < imageReader.getMaxImages()) {
                            Image acquireNextImage = imageReader.acquireNextImage();
                            ImageMetadataSynchronizer.this.mImagesAcquired.set(finalI, Integer.valueOf(intValue + 1));
                            ImageMetadataSynchronizer.this.handleImageLocked(finalI, acquireNextImage);
                        }
                    }
                }
            }, handler);
        }
    }

    private static boolean allIndexedImagesNotNull(Output output, ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            i++;
            if (output.mImages.get(intValue) == null) {
                return false;
            }
        }
        return true;
    }

    private void createCaptureCallback() {
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
            @Override
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                if (!ImageMetadataSynchronizer.this.mClosed) {
                    synchronized (ImageMetadataSynchronizer.this) {
                        ImageMetadataSynchronizer.this.handleCaptureResultLocked(totalCaptureResult);
                    }
                }
            }
        };
    }

    public void handleCaptureResultLocked(CaptureResult captureResult) {
        CaptureRequestTag captureRequestTag = CaptureRequestTag.getCaptureRequestTag(captureResult);
        if (captureRequestTag != null) {
            if (captureRequestTag.mTargets.size() == 0) {
                return;
            }
            this.mPendingCaptureResultQueue.addLast(captureResult);
            sweepQueuesLocked();
            return;
        }
        throw new IllegalArgumentException("CaptureResult is missing a CaptureRequestTag.");
    }

    public void handleImageLocked(int i, Image image) {
        ((LinkedList) this.mPendingImageQueues.get(i)).addLast(image);
        sweepQueuesLocked();
    }

    public synchronized void notifyImageClosed(int i) {
        int intValue = ((Integer) this.mImagesAcquired.get(i)).intValue();
        if (intValue <= 0) {
            throw new IllegalStateException("Output.close() called when synchronizer thinks there are none acquired.");
        }
        this.mImagesAcquired.set(i, Integer.valueOf(intValue - 1));
    }

    private void postCallbackWithSynchronizedOutputLocked(final Output output) {
        if (this.mCallbacks.isEmpty()) {
            output.close();
            return;
        }
        for (Pair<Callback, Handler> pair : this.mCallbacks) {
            final Callback callback = (Callback) pair.first;
            if (callback != null) {
                Handler handler = (Handler) pair.second;
                if (handler != null) {
                    handler.post(() -> callback.onDataAvailable(output));
                } else {
                    callback.onDataAvailable(output);
                }
            }
        }
    }

    private boolean sweepImageQueues(Output output) {
        CaptureResult captureResult = output.mResult;
        CaptureRequestTag captureRequestTag = (CaptureRequestTag) captureResult.getRequest().getTag();
        long longValue = ((Long) captureResult.get(CaptureResult.SENSOR_TIMESTAMP)).longValue();
        ArrayList arrayList = captureRequestTag.mTargets;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            output.mImages.set(intValue, (Image) ((LinkedList) this.mPendingImageQueues.get(intValue)).peekFirst());
        }
        output.mDroppedImageReaderIndices.clear();
        while (allIndexedImagesNotNull(output, captureRequestTag.mTargets)) {
            ArrayList arrayList2 = captureRequestTag.mTargets;
            int size2 = arrayList2.size();
            boolean z = false;
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = ((Integer) arrayList2.get(i2)).intValue();
                if (longValue > ((Image) output.mImages.get(intValue2)).getTimestamp()) {
                    Log.v(TAG, "Dropping Image due to dropped CaptureResult.");
                    ((Image) output.mImages.get(intValue2)).close();
                    ((LinkedList) this.mPendingImageQueues.get(intValue2)).removeFirst();
                    output.mImages.set(intValue2, (Image) ((LinkedList) this.mPendingImageQueues.get(intValue2)).peekFirst());
                    z = true;
                }
            }
            if (!z) {
                output.mImagesWereDropped = false;
                ArrayList arrayList3 = captureRequestTag.mTargets;
                int size3 = arrayList3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    int intValue3 = ((Integer) arrayList3.get(i3)).intValue();
                    if (longValue < ((Image) output.mImages.get(intValue3)).getTimestamp()) {
                        output.mDroppedImageReaderIndices.add(Integer.valueOf(intValue3));
                        output.mImages.set(intValue3, null);
                        output.mImagesWereDropped = true;
                    } else {
                        ((LinkedList) this.mPendingImageQueues.get(intValue3)).removeFirst();
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void sweepQueuesLocked() {
        int size = this.mPendingImageQueues.size();
        while (!this.mPendingCaptureResultQueue.isEmpty()) {
            Output output = new Output(size, this);
            output.mResult = (CaptureResult) this.mPendingCaptureResultQueue.peekFirst();
            if (!sweepImageQueues(output)) {
                return;
            }
            this.mPendingCaptureResultQueue.removeFirst();
            postCallbackWithSynchronizedOutputLocked(output);
        }
    }

    public synchronized void close() {
        if (this.mClosed) {
            Log.w(TAG, "Already closed!");
            return;
        }
        this.mClosed = true;
        for (LinkedList<Image> linkedList : this.mPendingImageQueues) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((Image) it.next()).close();
            }
            linkedList.clear();
        }
        this.mPendingImageQueues.clear();
        this.mPendingCaptureResultQueue.clear();
        for (ImageReader imageReader : this.mImageReaders) {
            imageReader.close();
        }
    }

    protected void finalize() {
        close();
    }

    public CameraCaptureSession.CaptureCallback getCaptureCallback() {
        return this.mCaptureCallback;
    }

    public List getImageReaders() {
        return Collections.unmodifiableList(this.mImageReaders);
    }

    public synchronized void registerCallback(Callback callback, Handler handler) {
        this.mCallbacks.add(Pair.create(callback, handler));
    }

    public synchronized void unregisterCallback(Callback callback, Handler handler) {
        this.mCallbacks.remove(Pair.create(callback, handler));
    }
}
