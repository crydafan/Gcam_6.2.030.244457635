package com.google.googlex.gcam.androidutils.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;

public class BlockingCaptureCallback extends CameraCaptureSession.CaptureCallback {
    public static final int CAPTURE_COMPLETED = 2;
    public static final int CAPTURE_FAILED = 3;
    public static final int CAPTURE_PROGRESSED = 1;
    public static final int CAPTURE_SEQUENCE_ABORTED = 5;
    public static final int CAPTURE_SEQUENCE_COMPLETED = 4;
    public static final int CAPTURE_STARTED = 0;
    public final CameraCaptureSession.CaptureCallback mProxy;
    public final StateChangeListener mStateChangeListener;
    public final StateWaiter mStateWaiter;
    public static final String[] sStateNames = {"CAPTURE_STARTED", "CAPTURE_PROGRESSED", "CAPTURE_COMPLETED", "CAPTURE_FAILED", "CAPTURE_SEQUENCE_COMPLETED", "CAPTURE_SEQUENCE_ABORTED"};
    public static final String TAG = "BlockingCaptureCallback";
    public static final boolean VERBOSE = Log.isLoggable(TAG, Log.VERBOSE);

    public BlockingCaptureCallback() {
        this.mStateWaiter = new StateWaiter(sStateNames);
        this.mStateChangeListener = this.mStateWaiter.getListener();
        this.mProxy = null;
    }

    public BlockingCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback) {
        this.mStateWaiter = new StateWaiter(sStateNames);
        this.mStateChangeListener = this.mStateWaiter.getListener();
        if (captureCallback != null) {
            this.mProxy = captureCallback;
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    public StateWaiter getStateWaiter() {
        return this.mStateWaiter;
    }

    @Override
    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        CameraCaptureSession.CaptureCallback captureCallback = this.mProxy;
        if (captureCallback != null) {
            captureCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
        this.mStateChangeListener.onStateChanged(2);
    }

    @Override
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        CameraCaptureSession.CaptureCallback captureCallback = this.mProxy;
        if (captureCallback != null) {
            captureCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
        this.mStateChangeListener.onStateChanged(3);
    }

    @Override
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        CameraCaptureSession.CaptureCallback captureCallback = this.mProxy;
        if (captureCallback != null) {
            captureCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }
        this.mStateChangeListener.onStateChanged(1);
    }

    @Override
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        CameraCaptureSession.CaptureCallback captureCallback = this.mProxy;
        if (captureCallback != null) {
            captureCallback.onCaptureSequenceAborted(cameraCaptureSession, i);
        }
        this.mStateChangeListener.onStateChanged(5);
    }

    @Override
    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
        CameraCaptureSession.CaptureCallback captureCallback = this.mProxy;
        if (captureCallback != null) {
            captureCallback.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
        }
        this.mStateChangeListener.onStateChanged(4);
    }

    @Override
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
        CameraCaptureSession.CaptureCallback captureCallback = this.mProxy;
        if (captureCallback != null) {
            captureCallback.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        }
        this.mStateChangeListener.onStateChanged(0);
    }
}
