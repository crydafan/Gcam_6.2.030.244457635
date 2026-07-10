package com.google.googlex.gcam.creativecamera.seedark;

import com.FixBSG;
import com.google.googlex.gcam.ShotParams;
import com.google.googlex.gcam.hdrplus.MetadataConverter;

import defpackage.lys;

public abstract class SeeDarkShotParams {

    public abstract static class Builder {
        public abstract SeeDarkShotParams build();

        public abstract Builder setImageRotation(lys lysVar);
    }

    public static Builder builder() {
        return new AutoValue_SeeDarkShotParams.Builder().setImageRotation(lys.CLOCKWISE_0);
    }

    public abstract lys imageRotation();

    public ShotParams toShotParams() {
        ShotParams shotParams = new ShotParams();
        shotParams.setImage_rotation(MetadataConverter.getImageRotation(imageRotation().e));
        shotParams.setManually_rotate_final_jpg(true);
        shotParams.setFinal_jpg_quality(FixBSG.sJPGQuality);
        return shotParams;
    }
}
