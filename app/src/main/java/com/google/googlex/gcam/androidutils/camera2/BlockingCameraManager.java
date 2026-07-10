package com.google.googlex.gcam.androidutils.camera2;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Objects;

public class BlockingCameraManager {
    public static final int OPEN_TIME_OUT_MS = 2000;
    public static final String TAG = "BlockingCameraManager";
    public static final boolean VERBOSE = Log.isLoggable(TAG, Log.VERBOSE);
    public final CameraManager mManager;

    public class BlockingOpenException extends Exception {
        public static final int ERROR_DISCONNECTED = 0;
        public static final long serialVersionUID = 12397123891238912L;
        public final int mError;

        public BlockingOpenException(int i, String str) {
            super(str);
            this.mError = i;
        }

        public int getCode() {
            return this.mError;
        }

        public boolean wasDisconnected() {
            return this.mError == 0;
        }

        public boolean wasError() {
            return this.mError != 0;
        }
    }

    class OpenListener extends CameraDevice.StateCallback {
        public static final int ERROR_UNINITIALIZED = -1;
        public final String mCameraId;
        public final CameraDevice.StateCallback mProxy;
        public final Object mLock = new Object();
        public final ConditionVariable mDeviceReady = new ConditionVariable();
        public CameraDevice mDevice = null;
        public boolean mSuccess = false;
        public int mError = -1;
        public boolean mDisconnected = false;
        public boolean mNoReply = true;
        public boolean mTimedOut = false;

        @SuppressLint("MissingPermission")
        OpenListener(BlockingCameraManager blockingCameraManager, CameraManager cameraManager, String str, CameraDevice.StateCallback stateCallback, Handler handler) {
            this.mCameraId = str;
            this.mProxy = stateCallback;
            try {
                cameraManager.openCamera(str, this, handler);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }

        private void assertInitialState() {
            BlockingCameraManager.assertEquals(null, this.mDevice);
            BlockingCameraManager.assertEquals(false, Boolean.valueOf(this.mDisconnected));
            BlockingCameraManager.assertEquals(-1, Integer.valueOf(this.mError));
            BlockingCameraManager.assertEquals(false, Boolean.valueOf(this.mSuccess));
        }

        CameraDevice blockUntilOpen() throws BlockingOpenException {
            CameraDevice cameraDevice;
            CameraDevice cameraDevice2;
            if (!this.mDeviceReady.block(2000L)) {
                synchronized (this.mLock) {
                    if (this.mNoReply) {
                        this.mTimedOut = true;
                        throw new TimeoutRuntimeException(String.format("Timed out after %d ms while trying to open camera device %s", Integer.valueOf((int) BlockingCameraManager.OPEN_TIME_OUT_MS), this.mCameraId));
                    }
                }
            }
            synchronized (this.mLock) {
                if (!this.mSuccess && (cameraDevice2 = this.mDevice) != null) {
                    cameraDevice2.close();
                }
                if (!this.mSuccess) {
                    if (this.mDisconnected) {
                        throw new BlockingOpenException(0, "Failed to open camera device: it is disconnected");
                    }
                    int i = this.mError;
                    if (i == -1) {
                        throw new AssertionError("Failed to open camera device (impl bug)");
                    }
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("Failed to open camera device: error code ");
                    sb.append(i);
                    throw new BlockingOpenException(i, sb.toString());
                }
                cameraDevice = this.mDevice;
            }
            return cameraDevice;
        }

        @Override
        public void onClosed(CameraDevice cameraDevice) {
            CameraDevice.StateCallback stateCallback = this.mProxy;
            if (stateCallback != null) {
                stateCallback.onClosed(cameraDevice);
            }
        }

        @Override
        public void onDisconnected(CameraDevice cameraDevice) {
            if (BlockingCameraManager.VERBOSE) {
                String valueOf = String.valueOf(cameraDevice != null ? cameraDevice.getId() : "null");
                Log.v(BlockingCameraManager.TAG, valueOf.length() == 0 ? new String("onDisconnected: camera ") : "onDisconnected: camera ".concat(valueOf));
            }
            synchronized (this.mLock) {
                assertInitialState();
                this.mNoReply = false;
                this.mDisconnected = true;
                this.mDevice = cameraDevice;
                this.mDeviceReady.open();
                if (this.mTimedOut && cameraDevice != null) {
                    cameraDevice.close();
                    return;
                }
                CameraDevice.StateCallback stateCallback = this.mProxy;
                if (stateCallback != null) {
                    stateCallback.onDisconnected(cameraDevice);
                }
            }
        }

        @Override
        public void onError(CameraDevice cameraDevice, int i) {
            if (BlockingCameraManager.VERBOSE) {
                String valueOf = String.valueOf(cameraDevice != null ? cameraDevice.getId() : "null");
                Log.v(BlockingCameraManager.TAG, valueOf.length() == 0 ? new String("onError: camera ") : "onError: camera ".concat(valueOf));
            }
            if (i > 0) {
                synchronized (this.mLock) {
                    this.mNoReply = false;
                    this.mError = i;
                    this.mDevice = cameraDevice;
                    this.mDeviceReady.open();
                    if (this.mTimedOut && cameraDevice != null) {
                        cameraDevice.close();
                        return;
                    }
                    CameraDevice.StateCallback stateCallback = this.mProxy;
                    if (stateCallback == null) {
                        return;
                    }
                    stateCallback.onError(cameraDevice, i);
                    return;
                }
            }
            throw new AssertionError("Expected error to be a positive number");
        }

        @Override
        public void onOpened(CameraDevice cameraDevice) {
            if (BlockingCameraManager.VERBOSE) {
                String valueOf = String.valueOf(cameraDevice != null ? cameraDevice.getId() : "null");
                Log.v(BlockingCameraManager.TAG, valueOf.length() == 0 ? new String("onOpened: camera ") : "onOpened: camera ".concat(valueOf));
            }
            synchronized (this.mLock) {
                assertInitialState();
                this.mNoReply = false;
                this.mSuccess = true;
                this.mDevice = cameraDevice;
                this.mDeviceReady.open();
                if (this.mTimedOut && cameraDevice != null) {
                    cameraDevice.close();
                    return;
                }
                CameraDevice.StateCallback stateCallback = this.mProxy;
                if (stateCallback != null) {
                    stateCallback.onOpened(cameraDevice);
                }
            }
        }
    }

    public BlockingCameraManager(CameraManager cameraManager) {
        if (cameraManager != null) {
            this.mManager = cameraManager;
            return;
        }
        throw new IllegalArgumentException("manager must not be null");
    }

    public static void assertEquals(Object obj, Object obj2) {
        if (Objects.equals(obj, obj2)) {
            return;
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19 + String.valueOf(valueOf2).length());
        sb.append("Expected ");
        sb.append(valueOf);
        sb.append(", but got ");
        sb.append(valueOf2);
        throw new AssertionError(sb.toString());
    }

    public CameraDevice openCamera(String str, CameraDevice.StateCallback stateCallback, Handler handler) throws BlockingOpenException {
        if (handler != null) {
            if (handler.getLooper() == Looper.myLooper()) {
                throw new IllegalArgumentException("handler's looper must not be the current looper");
            }
            return new OpenListener(this, this.mManager, str, stateCallback, handler).blockUntilOpen();
        }
        throw new IllegalArgumentException("handler must not be null");
    }
}
