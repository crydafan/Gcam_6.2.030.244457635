package com.google.googlex.gcam.creativecamera.seedark;

import com.google.googlex.gcam.creativecamera.seedark.ShotStatusCallback;

final class AutoValue_ShotStatusCallback extends ShotStatusCallback {
    public final Runnable onComplete;
    public final Runnable onError;
    public final Runnable onFinish;
    public final long shotId;

    static final class Builder extends ShotStatusCallback.Builder {
        public Runnable onComplete;
        public Runnable onError;
        public Runnable onFinish;
        public Long shotId;

        Builder() {
        }

        @Override
        public final ShotStatusCallback build() {
            String str = "";
            if (this.shotId == null) {
                str = String.valueOf(str).concat(" shotId");
            }
            if (this.onFinish == null) {
                str = String.valueOf(str).concat(" onFinish");
            }
            if (this.onError == null) {
                str = String.valueOf(str).concat(" onError");
            }
            if (this.onComplete == null) {
                str = String.valueOf(str).concat(" onComplete");
            }
            if (!str.isEmpty()) {
                String valueOf = String.valueOf(str);
                throw new IllegalStateException(valueOf.length() == 0 ? new String("Missing required properties:") : "Missing required properties:".concat(valueOf));
            }
            return new AutoValue_ShotStatusCallback(this.shotId.longValue(), this.onFinish, this.onError, this.onComplete);
        }

        @Override
        public final ShotStatusCallback.Builder setOnComplete(Runnable runnable) {
            if (runnable != null) {
                this.onComplete = runnable;
                return this;
            }
            throw new NullPointerException("Null onComplete");
        }

        @Override
        public final ShotStatusCallback.Builder setOnError(Runnable runnable) {
            if (runnable != null) {
                this.onError = runnable;
                return this;
            }
            throw new NullPointerException("Null onError");
        }

        @Override
        public final ShotStatusCallback.Builder setOnFinish(Runnable runnable) {
            if (runnable != null) {
                this.onFinish = runnable;
                return this;
            }
            throw new NullPointerException("Null onFinish");
        }

        @Override
        public final ShotStatusCallback.Builder setShotId(long j) {
            this.shotId = Long.valueOf(j);
            return this;
        }
    }

    private AutoValue_ShotStatusCallback(long j, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        this.shotId = j;
        this.onFinish = runnable;
        this.onError = runnable2;
        this.onComplete = runnable3;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof ShotStatusCallback) {
                ShotStatusCallback shotStatusCallback = (ShotStatusCallback) obj;
                if (this.shotId == shotStatusCallback.shotId() && this.onFinish.equals(shotStatusCallback.onFinish()) && this.onError.equals(shotStatusCallback.onError()) && this.onComplete.equals(shotStatusCallback.onComplete())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.shotId;
        return this.onComplete.hashCode() ^ ((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.onFinish.hashCode()) * 1000003) ^ this.onError.hashCode()) * 1000003);
    }

    @Override
    public final Runnable onComplete() {
        return this.onComplete;
    }

    @Override
    public final Runnable onError() {
        return this.onError;
    }

    @Override
    public final Runnable onFinish() {
        return this.onFinish;
    }

    @Override
    public final long shotId() {
        return this.shotId;
    }

    public final String toString() {
        long j = this.shotId;
        String valueOf = String.valueOf(this.onFinish);
        String valueOf2 = String.valueOf(this.onError);
        String valueOf3 = String.valueOf(this.onComplete);
        int length = String.valueOf(valueOf).length();
        StringBuilder sb = new StringBuilder(length + 81 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("ShotStatusCallback{shotId=");
        sb.append(j);
        sb.append(", onFinish=");
        sb.append(valueOf);
        sb.append(", onError=");
        sb.append(valueOf2);
        sb.append(", onComplete=");
        sb.append(valueOf3);
        sb.append("}");
        return sb.toString();
    }
}
