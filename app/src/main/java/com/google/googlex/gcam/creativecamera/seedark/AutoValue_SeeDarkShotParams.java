package com.google.googlex.gcam.creativecamera.seedark;

import defpackage.lys;

final class AutoValue_SeeDarkShotParams extends SeeDarkShotParams {
    public final lys imageRotation;

    static final class Builder extends SeeDarkShotParams.Builder {
        public lys imageRotation;

        Builder() {
        }

        @Override
        public SeeDarkShotParams build() {
            String str = "";
            if (this.imageRotation == null) {
                str = str.concat(" imageRotation");
            }
            if (!str.isEmpty()) {
                String valueOf = String.valueOf(str);
                throw new IllegalStateException(valueOf.length() == 0 ? new String("Missing required properties:") : "Missing required properties:".concat(valueOf));
            }
            return new AutoValue_SeeDarkShotParams(this.imageRotation);
        }

        @Override
        public final SeeDarkShotParams.Builder setImageRotation(lys lysVar) {
            if (lysVar != null) {
                this.imageRotation = lysVar;
                return this;
            }
            throw new NullPointerException("Null imageRotation");
        }
    }

    private AutoValue_SeeDarkShotParams(lys lysVar) {
        this.imageRotation = lysVar;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof SeeDarkShotParams)) {
                return false;
            }
            return this.imageRotation.equals(((SeeDarkShotParams) obj).imageRotation());
        }
        return true;
    }

    public final int hashCode() {
        return this.imageRotation.hashCode() ^ 1000003;
    }

    @Override
    public final lys imageRotation() {
        return this.imageRotation;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.imageRotation);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33);
        sb.append("SeeDarkShotParams{imageRotation=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
