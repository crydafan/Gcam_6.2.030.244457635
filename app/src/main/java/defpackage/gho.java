package defpackage;

import com.google.googlex.gcam.AeShotParams;
import com.google.googlex.gcam.ExifMetadata;
import com.google.googlex.gcam.SpatialGainMap;
import com.google.googlex.gcam.Tuning;

public final class gho {
    public final ExifMetadata a;
    public final Tuning b;
    public final AeShotParams c;
    public final SpatialGainMap d;

    public gho(ExifMetadata exifMetadata, Tuning tuning, AeShotParams aeShotParams, SpatialGainMap spatialGainMap) {
        this.a = exifMetadata;
        this.b = tuning;
        this.c = aeShotParams;
        this.d = spatialGainMap;
    }
}