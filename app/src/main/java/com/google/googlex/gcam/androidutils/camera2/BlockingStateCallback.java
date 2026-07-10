package com.google.googlex.gcam.androidutils.camera2;

import android.hardware.camera2.CameraDevice;
import android.os.SystemClock;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingStateCallback extends CameraDevice.StateCallback {
    public static final int NUM_STATES = 4;
    public static final int STATE_CLOSED = 1;
    public static final int STATE_DISCONNECTED = 2;
    public static final int STATE_ERROR = 3;
    public static final int STATE_OPENED = 0;
    public static final String TAG = "BlockingStateCallback";
    public static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    public static final String[] mStateNames = {"STATE_OPENED", "STATE_CLOSED", "STATE_DISCONNECTED", "STATE_ERROR"};
    public final Object mLock;
    public final CameraDevice.StateCallback mProxy;
    public final LinkedBlockingQueue mRecentStates;
    public boolean mWaiting;

    public BlockingStateCallback() {
        this.mLock = new Object();
        this.mWaiting = false;
        this.mRecentStates = new LinkedBlockingQueue();
        this.mProxy = null;
    }

    public BlockingStateCallback(CameraDevice.StateCallback stateCallback) {
        this.mLock = new Object();
        this.mWaiting = false;
        this.mRecentStates = new LinkedBlockingQueue();
        this.mProxy = stateCallback;
    }

    public static void appendStates(StringBuilder sb, Collection collection) {
        Iterator it = collection.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (!z) {
                sb.append(" ");
            }
            sb.append(stateToString(num.intValue()));
            z = false;
        }
    }

    private void setCurrentState(int i) {
        if (VERBOSE) {
            String valueOf = String.valueOf(stateToString(i));
            Log.v(TAG, valueOf.length() == 0 ? new String("Camera device state now ") : "Camera device state now ".concat(valueOf));
        }
        try {
            this.mRecentStates.put(Integer.valueOf(i));
        } catch (InterruptedException e) {
            throw new RuntimeException("Unable to set device state", e);
        }
    }

    public static String stateToString(int i) {
        return mStateNames[i + 1];
    }

    @Override
    public void onClosed(CameraDevice cameraDevice) {
        CameraDevice.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onClosed(cameraDevice);
        }
        setCurrentState(1);
    }

    @Override
    public void onDisconnected(CameraDevice cameraDevice) {
        CameraDevice.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onDisconnected(cameraDevice);
        }
        setCurrentState(2);
    }

    @Override
    public void onError(CameraDevice cameraDevice, int i) {
        CameraDevice.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onError(cameraDevice, i);
        }
        setCurrentState(3);
    }

    @Override
    public void onOpened(CameraDevice cameraDevice) {
        CameraDevice.StateCallback stateCallback = this.mProxy;
        if (stateCallback != null) {
            stateCallback.onOpened(cameraDevice);
        }
        setCurrentState(0);
    }

    public int waitForAnyOfStates(Collection collection, long j) {
        Integer num;
        synchronized (this.mLock) {
            if (this.mWaiting) {
                throw new IllegalStateException("Only one waiter allowed at a time");
            }
            this.mWaiting = true;
        }
        if (VERBOSE) {
            StringBuilder sb = new StringBuilder("Waiting for state(s) ");
            appendStates(sb, collection);
            Log.v(TAG, sb.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = j;
        while (true) {
            try {
                num = (Integer) this.mRecentStates.poll(j2, TimeUnit.MILLISECONDS);
                if (num != null) {
                    if (VERBOSE) {
                        String valueOf = String.valueOf(stateToString(num.intValue()));
                        Log.v(TAG, valueOf.length() != 0 ? "  Saw transition to ".concat(valueOf) : new String("  Saw transition to "));
                    }
                    if (collection.contains(num)) {
                        break;
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    j2 -= elapsedRealtime2 - elapsedRealtime;
                    elapsedRealtime = elapsedRealtime2;
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                throw new UnsupportedOperationException("Does not support interrupts on waits", e);
            }
        }
        synchronized (this.mLock) {
            this.mWaiting = false;
        }
        if (collection.contains(num)) {
            return num.intValue();
        }
        StringBuilder sb2 = new StringBuilder("Timed out after ");
        sb2.append(j);
        sb2.append(" ms waiting for state(s) ");
        appendStates(sb2, collection);
        throw new TimeoutRuntimeException(sb2.toString());
    }

    public int waitForState(int i, long j) {
        return waitForAnyOfStates(Arrays.asList(Integer.valueOf(i)), j);
    }
}
