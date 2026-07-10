package com.google.googlex.gcam.creativecamera.seedark;

import defpackage.mqm;

final class SeeDarkSession$$Lambda$7 implements Runnable {
    public final mqm arg$1;

    private SeeDarkSession$$Lambda$7(mqm mqmVar) {
        this.arg$1 = mqmVar;
    }

    static Runnable get$Lambda(mqm mqmVar) {
        return new SeeDarkSession$$Lambda$7(mqmVar);
    }

    @Override
    public final void run() {
        this.arg$1.close();
    }
}
