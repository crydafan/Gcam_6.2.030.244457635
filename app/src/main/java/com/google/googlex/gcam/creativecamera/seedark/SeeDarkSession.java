package com.google.googlex.gcam.creativecamera.seedark;

import android.hardware.HardwareBuffer;
import android.util.Log;
import android.view.Surface;

import com.google.googlex.gcam.GcamSwigLoader;
import com.google.googlex.gcam.JniUtilsJniLoader;
import com.google.googlex.gcam.StaticMetadata;
import com.google.googlex.gcam.SwigHacks;
import com.google.googlex.gcam.hdrplus.ImageConverter;
import com.google.googlex.gcam.hdrplus.MetadataConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import defpackage.lys;
import defpackage.lyu;
import defpackage.mmb;
import defpackage.mpz;
import defpackage.mqm;
import defpackage.nys;
import defpackage.ohr;

public class SeeDarkSession implements lyu {
    public static final String TAG = "SeeDarkSession";
    public boolean closed;
    public Future<Void> finishFuture;
    public Future<Void> frameFuture;
    public final ImageConverter imageConverter;
    public final Object lock;
    public final MetadataConverter metadataConverter;
    public long nativeHandle;
    public final SeeDarkNative seeDarkNative;
    public final ExecutorService singleThreadExecutor;

    static {
        GcamSwigLoader.initialize();
        JniUtilsJniLoader.initialize();
    }

    SeeDarkSession(StaticMetadata staticMetadata, final String str, final String str2, SeeDarkNative seeDarkNative, ImageConverter imageConverter, MetadataConverter metadataConverter, ExecutorService executorService) {
        this.lock = new Object();
        this.closed = false;
        this.nativeHandle = 0L;
        this.seeDarkNative = seeDarkNative;
        this.imageConverter = imageConverter;
        this.metadataConverter = metadataConverter;
        this.singleThreadExecutor = executorService;
        final long nativePointer = SwigHacks.getNativePointer(staticMetadata);
        executorService.execute(() -> lambda$new$0$SeeDarkSession(nativePointer, str, str2));
    }

    public SeeDarkSession(mmb mmbVar, String str, String str2) {
        this(MetadataConverter.convertToGcamStaticMetadata(mmbVar), str, str2, new SeeDarkNativeImpl(), new ImageConverter(), new MetadataConverter(mmbVar), Executors.newSingleThreadExecutor());
    }

    static final void lambda$processAndCloseFrame$3$SeeDarkSession(HardwareBuffer hardwareBuffer, mqm mqmVar) {
        hardwareBuffer.close();
        mqmVar.close();
    }

    public void abortCapture() {
        synchronized (this.lock) {
            if (this.closed) {
                Log.i(TAG, "Unable to abortCapture(): the session is closing or already closed.");
            } else {
                this.singleThreadExecutor.execute(this::lambda$abortCapture$7$SeeDarkSession);
            }
        }
    }

    @Override
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.singleThreadExecutor.execute(this::lambda$close$1$SeeDarkSession);
            this.singleThreadExecutor.shutdown();
        }
    }

    public void finishCapture() {
        synchronized (this.lock) {
            if (this.closed) {
                Log.e(TAG, "Unable to finishCapture(): the session is closing or already closed.");
            } else {
                this.finishFuture = this.singleThreadExecutor.submit(this::lambda$finishCapture$6$SeeDarkSession);
            }
        }
    }

    final void lambda$abortCapture$7$SeeDarkSession() {
        this.seeDarkNative.abortCapture(this.nativeHandle);
    }

    final void lambda$close$1$SeeDarkSession() {
        this.seeDarkNative.notifySurfaceChanged(this.nativeHandle, null);
        this.seeDarkNative.delete(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    final Void lambda$finishCapture$6$SeeDarkSession() {
        this.seeDarkNative.finishCapture(this.nativeHandle);
        return null;
    }

    final void lambda$new$0$SeeDarkSession(long j, String str, String str2) {
        this.nativeHandle = this.seeDarkNative.create(j, nys.b(str), nys.b(str2));
        ohr.b(this.nativeHandle != 0, "Failed to creative native SeeDarkSession.");
    }

    final void lambda$onSurfaceChanged$2$SeeDarkSession(Surface surface) {
        this.seeDarkNative.notifySurfaceChanged(this.nativeHandle, surface);
    }

    final Void lambda$processAndCloseFrame$4$SeeDarkSession(mqm mqmVar, final mqm mqmVar2, mpz mpzVar, lys lysVar) {
        try {
            long nativePointer = SwigHacks.getNativePointer(this.imageConverter.wrapRawWriteView(mqmVar));
            mqmVar.getClass();
            Runnable runnable = SeeDarkSession$$Lambda$7.get$Lambda(mqmVar);
            long nativePointer2 = SwigHacks.getNativePointer(this.imageConverter.wrapYuvWriteView(mqmVar2));
            final HardwareBuffer hardwareBuffer = (HardwareBuffer) ohr.b(mqmVar2.g());
            seeDarkNative.processAndCloseFrame(nativeHandle, nativePointer, runnable, nativePointer2, hardwareBuffer,
                    () -> lambda$processAndCloseFrame$3$SeeDarkSession(hardwareBuffer, mqmVar2),
                    SwigHacks.getNativePointer(metadataConverter.convertToGcamFrameMetadata(mpzVar)),
                    SwigHacks.getNativePointer(metadataConverter.convertToSpatialGainMap(mpzVar)), MetadataConverter.getImageRotation(lysVar.e));
        } catch (Exception e) {
            Log.e(TAG, "Could not process frame" + mqmVar.f(), e);
            mqmVar.close();
            mqmVar2.close();
        }
        return null;
    }

    final void lambda$startCapture$5$SeeDarkSession(SeeDarkShotParams seeDarkShotParams, String str, ShotStatusCallback shotStatusCallback) {
        this.seeDarkNative.startCapture(this.nativeHandle, SwigHacks.getNativePointer(seeDarkShotParams.toShotParams()), str, shotStatusCallback.onFinish(), shotStatusCallback.onError(), shotStatusCallback.onComplete());
    }

    public void onSurfaceChanged(final Surface surface) {
        synchronized (lock) {
            if (closed) {
                return;
            }
            singleThreadExecutor.execute(() -> lambda$onSurfaceChanged$2$SeeDarkSession(surface));
        }
    }

    public void processAndCloseFrame(final mqm mqmVar, final mqm mqmVar2, final mpz mpzVar, final lys lysVar) {
        synchronized (this.lock) {
            if (this.closed) {
                Log.e(TAG, "Unable to process new image: the session is closing or already closed.");
                mqmVar.close();
                mqmVar2.close();
                return;
            }
            boolean z2 = frameFuture != null && !frameFuture.isDone() && !frameFuture.isCancelled();
            boolean z = finishFuture != null && !finishFuture.isDone() && !finishFuture.isCancelled();
            if (!z2 && !z) {
                frameFuture = singleThreadExecutor.submit(() -> lambda$processAndCloseFrame$4$SeeDarkSession(mqmVar, mqmVar2, mpzVar, lysVar));
                return;
            }
            Log.v(TAG, "Viewfinder ignored frame " + mqmVar2.f());
            mqmVar.close();
            mqmVar2.close();
        }
    }

    public void startCapture(final String str, final SeeDarkShotParams seeDarkShotParams, final ShotStatusCallback shotStatusCallback) {
        synchronized (this.lock) {
            if (this.closed) {
                Log.e(TAG, "Unable to startCapture(): the session is closing or already closed.");
            } else {
                singleThreadExecutor.execute(() -> lambda$startCapture$5$SeeDarkSession(seeDarkShotParams, str, shotStatusCallback));
            }
        }
    }
}
