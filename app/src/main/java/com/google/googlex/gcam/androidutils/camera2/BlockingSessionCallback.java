package com.google.googlex.gcam.androidutils.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.os.ConditionVariable;
import android.util.Log;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingSessionCallback extends CameraCaptureSession.StateCallback {
    public static final int NUM_STATES = 5;
    public static final int SESSION_ACTIVE = 3;
    public static final int SESSION_CLOSED = 4;
    public static final int SESSION_CONFIGURED = 0;
    public static final int SESSION_CONFIGURE_FAILED = 1;
    public static final int SESSION_READY = 2;
    public static final String TAG = "BlockingSessionCallback";
    public static final boolean VERBOSE = Log.isLoggable(TAG, Log.VERBOSE);
    public static final String[] sStateNames = {"SESSION_CONFIGURED", "SESSION_CONFIGURE_FAILED", "SESSION_READY", "SESSION_ACTIVE", "SESSION_CLOSED"};
    public final CameraCaptureSession.StateCallback mProxy;
    public final SessionFuture mSessionFuture;
    public final StateChangeListener mStateChangeListener;
    public final StateWaiter mStateWaiter;

    class SessionFuture implements Future {
        public ConditionVariable mCondVar;
        public volatile CameraCaptureSession mSession;

        private SessionFuture() {
            this.mCondVar = new ConditionVariable(false);
        }

        @Override
        public boolean cancel(boolean z) {
            return false;
        }

        @Override
        public CameraCaptureSession get() {
            this.mCondVar.block();
            return this.mSession;
        }

        @Override
        public CameraCaptureSession get(long j, TimeUnit timeUnit) {
            if (this.mCondVar.block(timeUnit.convert(j, TimeUnit.MILLISECONDS))) {
                if (this.mSession == null) {
                    throw new AssertionError();
                }
                return this.mSession;
            }
            String valueOf = String.valueOf(timeUnit);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
            sb.append("Failed to receive session after ");
            sb.append(j);
            sb.append(" ");
            sb.append(valueOf);
            try {
                throw new TimeoutException(sb.toString());
            } catch (TimeoutException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return this.mSession != null;
        }

        public void setSession(CameraCaptureSession cameraCaptureSession) {
            this.mSession = cameraCaptureSession;
            this.mCondVar.open();
        }
    }

    public BlockingSessionCallback() {
        this.mSessionFuture = new SessionFuture();
        this.mStateWaiter = new StateWaiter(sStateNames);
        this.mStateChangeListener = this.mStateWaiter.getListener();
        this.mProxy = null;
    }

    public BlockingSessionCallback(CameraCaptureSession.StateCallback stateCallback) {
        this.mSessionFuture = new SessionFuture();
        this.mStateWaiter = new StateWaiter(sStateNames);
        this.mStateChangeListener = this.mStateWaiter.getListener();
        if (stateCallback != null) {
            this.mProxy = stateCallback;
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    public StateWaiter getStateWaiter() {
        return this.mStateWaiter;
    }

    @Override
    public void onActive(CameraCaptureSession cameraCaptureSession) {
        this.mSessionFuture.setSession(cameraCaptureSession);
        CameraCaptureSession.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onActive(cameraCaptureSession);
        }
        this.mStateChangeListener.onStateChanged(3);
    }

    @Override
    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        this.mSessionFuture.setSession(cameraCaptureSession);
        CameraCaptureSession.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onClosed(cameraCaptureSession);
        }
        this.mStateChangeListener.onStateChanged(4);
    }

    @Override
    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.mSessionFuture.setSession(cameraCaptureSession);
        CameraCaptureSession.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onConfigureFailed(cameraCaptureSession);
        }
        this.mStateChangeListener.onStateChanged(1);
    }

    @Override
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        this.mSessionFuture.setSession(cameraCaptureSession);
        CameraCaptureSession.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onConfigured(cameraCaptureSession);
        }
        this.mStateChangeListener.onStateChanged(0);
    }

    @Override
    public void onReady(CameraCaptureSession cameraCaptureSession) {
        this.mSessionFuture.setSession(cameraCaptureSession);
        CameraCaptureSession.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onReady(cameraCaptureSession);
        }
        this.mStateChangeListener.onStateChanged(2);
    }

    public CameraCaptureSession waitAndGetSession(long j) {
        //try {
            return this.mSessionFuture.get(j, TimeUnit.MILLISECONDS);
        //} catch (TimeoutException e) {
        //    throw new TimeoutRuntimeException(String.format("Failed to get session after %s milliseconds", Long.valueOf(j)), e);
        //}
    }
}
