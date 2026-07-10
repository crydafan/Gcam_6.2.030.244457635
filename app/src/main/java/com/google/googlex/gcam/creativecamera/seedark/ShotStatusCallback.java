package com.google.googlex.gcam.creativecamera.seedark;

public abstract class ShotStatusCallback {

    public abstract static class Builder {
        public abstract ShotStatusCallback build();

        public abstract Builder setOnComplete(Runnable runnable);

        public abstract Builder setOnError(Runnable runnable);

        public abstract Builder setOnFinish(Runnable runnable);

        public abstract Builder setShotId(long j);
    }

    public static Builder builder() {
        return new AutoValue_ShotStatusCallback.Builder().setShotId(0L).setOnFinish(ShotStatusCallback$$Lambda$0.$instance).setOnError(ShotStatusCallback$$Lambda$1.$instance).setOnComplete(ShotStatusCallback$$Lambda$2.$instance);
    }

    static final void lambda$builder$0$ShotStatusCallback() {
    }

    static final void lambda$builder$1$ShotStatusCallback() {
    }

    static final void lambda$builder$2$ShotStatusCallback() {
    }

    public abstract Runnable onComplete();

    public abstract Runnable onError();

    public abstract Runnable onFinish();

    public abstract long shotId();
}
