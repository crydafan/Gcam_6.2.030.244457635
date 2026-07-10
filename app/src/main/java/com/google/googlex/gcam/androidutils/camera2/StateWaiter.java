package com.google.googlex.gcam.androidutils.camera2;

import android.os.SystemClock;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class StateWaiter {
    public static final String TAG = "StateWaiter";
    public static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    public final int mStateCount;
    public final String[] mStateNames;
    public final AtomicBoolean mWaiting = new AtomicBoolean(false);
    public final LinkedBlockingQueue mQueuedStates = new LinkedBlockingQueue();
    public final StateChangeListener mListener = new StateChangeListener() {
        @Override
        public void onStateChanged(int i) {
            StateWaiter stateWaiter = StateWaiter.this;
            stateWaiter.queueStateTransition(stateWaiter.checkStateInRange(i));
        }
    };

    public StateWaiter(String[] strArr) {
        this.mStateCount = strArr.length;
        int i = this.mStateCount;
        this.mStateNames = new String[i];
        System.arraycopy(strArr, 0, this.mStateNames, 0, i);
    }

    private final Collection checkStateCollectionInRange(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            checkStateInRange(((Integer) it.next()).intValue());
        }
        return collection;
    }

    public final int checkStateInRange(int i) {
        if (i < 0 || i >= this.mStateCount) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("State out of range ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return i;
    }

    public final void queueStateTransition(int i) {
        if (VERBOSE) {
            String valueOf = String.valueOf(getStateName(i));
            Log.v(TAG, valueOf.length() == 0 ? new String("setCurrentState - state now ") : "setCurrentState - state now ".concat(valueOf));
        }
        try {
            this.mQueuedStates.put(Integer.valueOf(i));
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException("Unable to set current state", e);
        }
    }

    public final void appendStateNames(StringBuilder sb, Collection collection) {
        checkStateCollectionInRange(collection);
        Iterator it = collection.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (!z) {
                sb.append(" ");
            }
            sb.append(getStateName(num.intValue()));
            z = false;
        }
    }

    public final StateChangeListener getListener() {
        return this.mListener;
    }

    public final String getStateName(int i) {
        return this.mStateNames[checkStateInRange(i)];
    }

    public final int waitForAnyOfStates(Collection collection, long j) {
        Integer num;
        checkStateCollectionInRange(collection);
        if (!this.mWaiting.getAndSet(true)) {
            try {
                try {
                    if (VERBOSE) {
                        StringBuilder sb = new StringBuilder("Waiting for state(s) ");
                        appendStateNames(sb, collection);
                        Log.v(TAG, sb.toString());
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j2 = j;
                    while (true) {
                        num = (Integer) this.mQueuedStates.poll(j2, TimeUnit.MILLISECONDS);
                        if (num != null) {
                            if (VERBOSE) {
                                String valueOf = String.valueOf(getStateName(num.intValue()));
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
                    }
                    this.mWaiting.set(false);
                    if (collection.contains(num)) {
                        return num.intValue();
                    }
                    StringBuilder sb2 = new StringBuilder("Timed out after ");
                    sb2.append(j);
                    sb2.append(" ms waiting for state(s) ");
                    appendStateNames(sb2, collection);
                    throw new TimeoutRuntimeException(sb2.toString());
                } catch (InterruptedException e) {
                    throw new UnsupportedOperationException("Does not support interrupts on waits", e);
                }
            } catch (Throwable th) {
                this.mWaiting.set(false);
                throw th;
            }
        }
        throw new IllegalStateException("Only one waiter allowed at a time");
    }

    public final void waitForState(int i, long j) {
        waitForAnyOfStates(Arrays.asList(Integer.valueOf(checkStateInRange(i))), j);
    }
}
