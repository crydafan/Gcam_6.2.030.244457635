package defpackage;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.location.Location;
import android.util.DisplayMetrics;
import android.util.Pair;

import com.FixBSG;
import com.google.googlex.gcam.AeShotParams;
import com.google.googlex.gcam.AndroidJniUtils;
import com.google.googlex.gcam.AwbInfo;
import com.google.googlex.gcam.BurstSpec;
import com.google.googlex.gcam.ClientExifMetadata;
import com.google.googlex.gcam.ClientInterleavedU8Allocator;
import com.google.googlex.gcam.FrameMetadata;
import com.google.googlex.gcam.Gcam;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.GyroSampleVector;
import com.google.googlex.gcam.IccProfile;
import com.google.googlex.gcam.ImageSaverParams;
import com.google.googlex.gcam.InterleavedWriteViewU16;
import com.google.googlex.gcam.LocationData;
import com.google.googlex.gcam.MergeMethod;
import com.google.googlex.gcam.PostviewParams;
import com.google.googlex.gcam.RawWriteView;
import com.google.googlex.gcam.ResamplingMethod;
import com.google.googlex.gcam.ShotCallbacks;
import com.google.googlex.gcam.ShotParams;
import com.google.googlex.gcam.SpatialGainMap;
import com.google.googlex.gcam.ViewfinderProcessingOptions;
import com.google.googlex.gcam.WhiteBalanceMode;
import com.google.googlex.gcam.clientallocator.UniqueYuvClientAllocator;
import com.google.googlex.gcam.hdrplus.ImageConverter;
import com.google.googlex.gcam.hdrplus.ImageProxyAndHardwareBufferReleaseCallback;
import com.google.googlex.gcam.hdrplus.InputView;
import com.google.googlex.gcam.hdrplus.MetadataConverter;

import java.io.File;
import java.util.Locale;

final class dfx implements dfw {
    private static final String c = pra.a("HdrPlusSession");
    private final lrm A;
    private final lzj B;
    private final lzp C;
    public final dgg b;
    private Gcam d;
    private final ded e;
    private final kib f;
    private final lrm g;
    private final dgr h;
    private final DisplayMetrics i;
    private final dfa j;
    private final ImageConverter k;
    private final mmb l;
    private final gpp m;
    private final lyw n;
    private final qdx o;
    private final frg p;
    private final lpu q;
    private final gnf r;
    private final cvv s;
    private final qdx t;
    private String u = null;
    private final jab v;
    private final cba w;
    private final chh x;
    private final deg y;
    private final dds z;

    dfx(DisplayMetrics displayMetrics, ded dedVar, dgg dggVar, dfa dfaVar, ImageConverter imageConverter, mmb mmbVar, gkf gkfVar, hkx hkxVar, gpp gppVar, Gcam gcam, ViewfinderProcessingOptions viewfinderProcessingOptions, qdx qdxVar, kib kibVar, frg frgVar, lpu lpuVar, gnf gnfVar, dgr dgrVar, qdx qdxVar2, cvv cvvVar, jab jabVar, cba cbaVar, chh chhVar, deg degVar, dds ddsVar, lsg lsgVar, lzj lzjVar, lzp lzpVar) {
        this.i = displayMetrics;
        this.e = dedVar;
        this.b = dggVar;
        this.j = dfaVar;
        this.k = imageConverter;
        this.l = mmbVar;
        this.m = gppVar;
        this.d = gcam;
        this.g = gkfVar.b;
        this.f = kibVar;
        this.p = frgVar;
        this.q = lpuVar;
        this.r = gnfVar;
        this.h = dgrVar;
        this.s = cvvVar;
        this.t = qdxVar2;
        this.v = jabVar;
        this.w = cbaVar;
        this.x = chhVar;
        this.y = degVar;
        this.z = ddsVar;
        this.A = lsgVar;
        this.n = hkxVar.c;
        this.o = qdxVar;
        this.C = lzpVar;
        this.B = lzjVar.a("HdrPlusSession");
        gcam.ConfigureViewfinderProcessing(viewfinderProcessingOptions);
    }

    private AeShotParams a(float f, hhb hhbVar) {
        AeShotParams aeShotParams = new AeShotParams();
        aeShotParams.setExposure_compensation(f);
        aeShotParams.setTarget_width(this.n.a);
        aeShotParams.setTarget_height(this.n.b);
        if (this.h == dgr.PORTRAIT) {
            aeShotParams.setUx_mode(3);
        } else if (this.h == dgr.LONG_EXPOSURE) {
            aeShotParams.setUx_mode(4);
        } else {
            boolean z = false;
            if (this.h != dgr.REGULAR) {
                throw new IllegalStateException(String.format("Unknown HdrPlusType: %s.", this.h));
            }
            if (hhbVar != hhb.OFF) {
                z = true;
            }
            ohr.a(z, "Invalid HDR+ mode.");
            if (hhbVar == hhb.AUTO) {
                aeShotParams.setUx_mode(1);
            } else if (hhbVar == hhb.ON) {
                aeShotParams.setUx_mode(2);
            }
        }
        return aeShotParams;
    }

    private GyroSampleVector a(mpz mpzVar) {
        long longValue = (Long) ohr.b((Long) mpzVar.a(CaptureResult.SENSOR_TIMESTAMP));
        long longValue2 = (Long) ohr.b((Long) mpzVar.a(CaptureResult.SENSOR_EXPOSURE_TIME)) + longValue + MetadataConverter.getReadoutTimeNs(this.l);
        nyp nypVar = (nyp) this.t.get();
        if (nypVar.b()) {
            moi moiVar = (moi) nypVar.c();
            this.C.a("gyro");
            GyroSampleVector gyroSampleVector = (GyroSampleVector) moiVar.a((-5000000) + longValue, longValue2 + 5000000, ddv.a);
            this.C.a();
            return gyroSampleVector;
        }
        return null;
    }

    private dgs a(hhb hhbVar, mqm mqmVar, mpz mpzVar, lyw lywVar) {
        ohr.b(mqmVar);
        ohr.b(this.k.isCompatibleRawFormat(mqmVar.b()));
        dgs dgsVar = new dgs();
        dgsVar.a = this.k.wrapRawWriteView(mqmVar);
        dgsVar.b = this.j.a(mpzVar, null, a(mpzVar));
        dgsVar.c = this.j.a(mpzVar);
        dgsVar.d = a(this.j.a((Integer) ohr.b((Integer) mpzVar.a(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION))), hhbVar);
        Rect rect = (Rect) ohr.b((Rect) mpzVar.a(CaptureResult.SCALER_CROP_REGION));
        if (!rect.isEmpty()) {
            this.j.a(dgsVar.d, rect, (MeteringRectangle[]) mpzVar.a(CaptureResult.CONTROL_AE_REGIONS), lywVar);
            return dgsVar;
        }
        String valueOf = String.valueOf(rect);
        String sb = "Invalid scaler crop region: " + valueOf;
        this.B.c(sb);
        return null;
    }

    private dhm a(int i, dhv dhvVar, het hetVar, PostviewParams postviewParams, hhb hhbVar, hha hhaVar, mqc source, boolean zsl, int baseFrameHint) {
        ImageSaverParams imageSaverParams;
        long l;
        FixBSG.GAwb = (this.r.b_() == gne.GOOGLE) ? 1 : 0;
        this.d = FixBSG.UpdateCameras(this.d);
        this.B.b("startShotCapture()");
        ohr.b(dhvVar);
        ShotParams shotParams = new ShotParams();
        shotParams.setImage_rotation(dds.a(beh.a(hetVar.a.a, this.l)));
        shotParams.setFinal_jpg_quality(FixBSG.sJPGQuality);
        shotParams.setManually_rotate_final_jpg(true);
        shotParams.setSave_merged_dng(dhvVar.f().b());
        shotParams.setCompress_merged_dng(true);
        shotParams.setAe(a(this.j.a((Integer) this.g.b_()), hhbVar));
        shotParams.setResampling_method_override(ResamplingMethod.kRaisr);
        this.s.a();
        this.s.b();
        if (!this.e.k.b.e) {
            shotParams.setIcc_output_profile_override(IccProfile.kSrgb);
        }
        shotParams.setFlash_mode(dfa.a(hhaVar));
        shotParams.setAllow_temporal_binning(ded.b(this.f));
        this.s.b();
        boolean allowSabre;
        shotParams.setRecompute_wb_on_base_frame(this.r.b_() == gne.GOOGLE);
        float f = (Float) this.A.b_();
        if (ded.a(this.f) && this.h != dgr.PORTRAIT) {
            if (f - 1.2f >= 0) {
                allowSabre = true;
            } else {
                allowSabre = this.h == dgr.LONG_EXPOSURE && !this.f.a.e();
            }
            this.s.b();
            shotParams.setAllow_sabre(allowSabre);
            int nonZslFrameCountOverride = this.e.t.d();
            shotParams.setNonzsl_frame_count_override(nonZslFrameCountOverride);
            this.s.b();
            if (allowSabre && this.h != dgr.LONG_EXPOSURE) {
                nonZslFrameCountOverride = Math.max(nonZslFrameCountOverride, 15);
            }
            if (this.h == dgr.LONG_EXPOSURE) {
                int lensFacing = ohr.b(this.l.a(CameraCharacteristics.LENS_FACING));
                if (allowSabre && lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                    nonZslFrameCountOverride = Math.max(nonZslFrameCountOverride, 15);
                } else {
                    nonZslFrameCountOverride = Math.max(nonZslFrameCountOverride, 13);
                }
                shotParams.setNonzsl_motion_ef_enabled(ded.a(this.s));
                shotParams.setTripod_detection_enabled(ded.a(this.s));
                if (ded.c(this.s)) {
                    shotParams.setDisable_align(true);
                    shotParams.setMerge_method_override(MergeMethod.kAverage);
                }
                if (ded.b(this.s)) {
                    shotParams.setMax_tripod_shot_capture_time_ms(30000.00f);
                }
            }
            shotParams.setNonzsl_frame_count_override(nonZslFrameCountOverride);
            if (this.r.b_() == gne.GOOGLE || this.r.b_() == gne.AUTO) {
                shotParams.setWb_mode(WhiteBalanceMode.kAuto);
            } else {
                shotParams.setWb_mode(WhiteBalanceMode.kManual);
            }
            String str = zsl ? "z" : "n";
            switch (this.h.ordinal()) {
                case 0: /*REGULAR*/
                    str = str.concat("r");
                    break;
                case 1: /*PORTRAIT*/
                    str = str.concat("p");
                    break;
                case 2: /*LONG_EXPOSURE*/
                    str = (str).concat("l");
                    break;
                default:
                    break;
            }
            shotParams.setSoftware_suffix(str);
            shotParams.setZsl(zsl);
            if (!zsl) {
                AwbInfo awbInfoCaptured = this.j.a.getAwbInfoCaptured(source);
                shotParams.setForce_wb(awbInfoCaptured);
                shotParams.setPrevious_viewfinder_wb(awbInfoCaptured);
            }
            ohr.a(baseFrameHint >= -1, "Incorrect base frame hint.");
            shotParams.setZsl_base_frame_index_hint(baseFrameHint);
            if (source != null) {
                float totalExposureTime = this.j.a.getTotalExposureTime(source);
                Integer integer = source.a(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
                float f1 = (integer != null) ? (float) integer / 100.00f : 1.0f;
                totalExposureTime = totalExposureTime * f1;
                shotParams.setPrevious_viewfinder_tet(totalExposureTime);
                this.B.e("takePicture - Using captured WB from viewfinder, Viewfinder TET = " + totalExposureTime);
                this.j.a(shotParams.getAe(), ohr.b(source.a(CaptureResult.SCALER_CROP_REGION)), source.a(CaptureResult.CONTROL_AE_REGIONS), this.n);
                dhm dhmVar = new dhm(dhvVar, this.i, hetVar, this.b.b.getExecute_finish_on(), this.v, this.w, this.x);
                ShotCallbacks shotCallback = new ShotCallbacks();
                if (dhmVar.t.a().b()) {
                    shotCallback.setProgress_callback(dhmVar.f);
                }
                shotCallback.setStatus_callback(dhmVar.g);
                if (dhmVar.t.b().b()) {
                    shotCallback.setBase_frame_callback(dhmVar.h);
                }
                ClientInterleavedU8Allocator clientInterleavedU8Allocator = dhmVar.n;
                if (clientInterleavedU8Allocator != null) {
                    shotCallback.setPostview_rgb_allocator(clientInterleavedU8Allocator);
                    shotCallback.setPostview_callback(dhmVar.i);
                } else {
                    UniqueYuvClientAllocator uniqueYuvClientAllocator = dhmVar.o;
                    if (uniqueYuvClientAllocator != null) {
                        shotCallback.setPostview_yuv_allocator(uniqueYuvClientAllocator);
                        shotCallback.setPostview_callback(dhmVar.i);
                    }
                }
                if (dhmVar.t.f().b()) {
                    shotCallback.setMerged_dng_callback(dhmVar.k);
                }
                if (dhmVar.t.g().b()) {
                    shotCallback.setMerged_pd_allocator(dhmVar.r);
                    shotCallback.setMerged_pd_callback(dhmVar.j);
                }
                clientInterleavedU8Allocator = dhmVar.p;
                if (clientInterleavedU8Allocator != null) {
                    shotCallback.setFinal_image_rgb_allocator(clientInterleavedU8Allocator);
                    shotCallback.setFinal_image_callback(dhmVar.l);
                }
                if (dhmVar.t.h().b()) {
                    shotCallback.setFinal_image_yuv_allocator(dhmVar.q);
                    shotCallback.setFinal_image_callback(dhmVar.l);
                }
                if (dhmVar.t.k().b()) {
                    shotCallback.setJpeg_callback(dhmVar.m);
                }
                nyp onyVar = (nyp) this.o.get();
                if (!this.m.a("persist.gcam.debug", true)) {
                    this.s.b();
                    imageSaverParams = null;
                } else if (onyVar.b()) {
                    ImageSaverParams imageSaverPa1 = new ImageSaverParams();
                    ios b5 = hetVar.b;
                    l = (b5 != null) ? b5.b() : System.currentTimeMillis();
                    if (((File) onyVar.c()).getFreeSpace() - 0x40000000 <= 0) {
                        this.x.a("Cache has less than 1GB free. Slowraw data may be silently deleted.", 1);
                    }
                    File uFile = (File) onyVar.c();
                    ohr.b(uFile);
                    if (!uFile.exists() || !uFile.isDirectory()) {
                        String valueOf = uFile.getAbsolutePath();
                        throw new RuntimeException(valueOf.length() == 0 ? "Gcam debug directory not valid or doesn't exist: " : "Gcam debug directory not valid or doesn't exist: ".concat(valueOf));
                    } else {
                        File uFile1 = new File(new File(uFile, "gcam"), this.z.a(l));
                        if (uFile1.mkdirs()) {
                            this.u = uFile1.getAbsolutePath();
                            imageSaverPa1.setDest_folder(this.u);
                            imageSaverParams = imageSaverPa1;
                        } else {
                            throw new RuntimeException("Could not create Gcam debug data folder.");
                        }
                    }
                } else {
                    imageSaverParams = null;
                }
                int i2;
                if (dhvVar.i().b()) {
                    i2 = 3;
                } else if (dhvVar.j().b()) {
                    i2 = 5;
                } else if (!dhvVar.h().b()) {
                    dhvVar.k().b();
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                this.C.a("Gcam::StartShotCapture");
                int StartShotCapture = this.d.StartShotCapture(i, shotParams, shotCallback, i2, postviewParams, imageSaverParams);
                this.C.a();
                ohr.a(StartShotCapture != GcamModule.getKInvalidShotId(), "Gcam::StartShotCapture() returned an invalid shot id.");
                hetVar.a.g.a(this.y.a(StartShotCapture));
                this.b.d.put(StartShotCapture, dhmVar);
                dfy dfyVar = new dfy(this, StartShotCapture);
                ohr.a(StartShotCapture != GcamModule.getKInvalidShotId());
                ohr.b(dhmVar.b == GcamModule.getKInvalidShotId());
                dhmVar.b = StartShotCapture;
                dhmVar.u = dfyVar;
                return dhmVar;
            } else {
                throw new IllegalArgumentException("source should not be null");
            }
        } else {
            allowSabre = f - 1.2f >= 0; // only one way to determine if we should allow sabre.
            this.s.b();
            shotParams.setAllow_sabre(allowSabre);
            int nonZslFrameCountOverride = this.e.t.d();
            shotParams.setNonzsl_frame_count_override(nonZslFrameCountOverride);
            this.s.b();
            if (allowSabre && this.h != dgr.LONG_EXPOSURE) {
                nonZslFrameCountOverride = Math.max(nonZslFrameCountOverride, 15);
            }
            if (this.h == dgr.LONG_EXPOSURE) {
                int lensFacing = ohr.b(this.l.a(CameraCharacteristics.LENS_FACING));
                if (allowSabre && lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                    nonZslFrameCountOverride = Math.max(nonZslFrameCountOverride, 15);
                } else {
                    nonZslFrameCountOverride = Math.max(nonZslFrameCountOverride, 13);
                }
                shotParams.setNonzsl_motion_ef_enabled(ded.a(this.s));
                shotParams.setTripod_detection_enabled(ded.a(this.s));
                if (ded.c(this.s)) {
                    shotParams.setDisable_align(true);
                    shotParams.setMerge_method_override(MergeMethod.kAverage);
                }
                if (ded.b(this.s)) {
                    shotParams.setMax_tripod_shot_capture_time_ms(30000.00f);
                }
            }
            shotParams.setNonzsl_frame_count_override(nonZslFrameCountOverride);
            if (this.r.b_() == gne.GOOGLE || this.r.b_() == gne.AUTO) {
                shotParams.setWb_mode(WhiteBalanceMode.kAuto);
            } else {
                shotParams.setWb_mode(WhiteBalanceMode.kManual);
            }
            String str = zsl ? "z" : "n";
            switch (this.h.ordinal()) {
                case 0: /*REGULAR*/
                    str = str.concat("r");
                    break;
                case 1: /*PORTRAIT*/
                    str = str.concat("p");
                    break;
                case 2: /*LONG_EXPOSURE*/
                    str = (str).concat("l");
                    break;
                default:
                    break;
            }
            shotParams.setSoftware_suffix(str);
            shotParams.setZsl(zsl);
            if (!zsl) {
                AwbInfo awbInfoCaptured = this.j.a.getAwbInfoCaptured(source);
                shotParams.setForce_wb(awbInfoCaptured);
                shotParams.setPrevious_viewfinder_wb(awbInfoCaptured);
            }
            ohr.a(baseFrameHint >= -1, "Incorrect base frame hint.");
            shotParams.setZsl_base_frame_index_hint(baseFrameHint);
            if (source != null) {
                float totalExposureTime = this.j.a.getTotalExposureTime(source);
                Integer integer = source.a(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
                float f1 = (integer != null) ? (float) integer / 100.00f : 1.0f;
                totalExposureTime = totalExposureTime * f1;
                shotParams.setPrevious_viewfinder_tet(totalExposureTime);
                this.B.e("takePicture - Using captured WB from viewfinder, Viewfinder TET = " + totalExposureTime);
                this.j.a(shotParams.getAe(), ohr.b(source.a(CaptureResult.SCALER_CROP_REGION)), source.a(CaptureResult.CONTROL_AE_REGIONS), this.n);
                dhm dhmVar = new dhm(dhvVar, this.i, hetVar, this.b.b.getExecute_finish_on(), this.v, this.w, this.x);
                ShotCallbacks shotCallback = new ShotCallbacks();
                if (dhmVar.t.a().b()) {
                    shotCallback.setProgress_callback(dhmVar.f);
                }
                shotCallback.setStatus_callback(dhmVar.g);
                if (dhmVar.t.b().b()) {
                    shotCallback.setBase_frame_callback(dhmVar.h);
                }
                ClientInterleavedU8Allocator clientInterleavedU8Allocator = dhmVar.n;
                if (clientInterleavedU8Allocator != null) {
                    shotCallback.setPostview_rgb_allocator(clientInterleavedU8Allocator);
                    shotCallback.setPostview_callback(dhmVar.i);
                } else {
                    UniqueYuvClientAllocator uniqueYuvClientAllocator = dhmVar.o;
                    if (uniqueYuvClientAllocator != null) {
                        shotCallback.setPostview_yuv_allocator(uniqueYuvClientAllocator);
                        shotCallback.setPostview_callback(dhmVar.i);
                    }
                }
                if (dhmVar.t.f().b()) {
                    shotCallback.setMerged_dng_callback(dhmVar.k);
                }
                if (dhmVar.t.g().b()) {
                    shotCallback.setMerged_pd_allocator(dhmVar.r);
                    shotCallback.setMerged_pd_callback(dhmVar.j);
                }
                clientInterleavedU8Allocator = dhmVar.p;
                if (clientInterleavedU8Allocator != null) {
                    shotCallback.setFinal_image_rgb_allocator(clientInterleavedU8Allocator);
                    shotCallback.setFinal_image_callback(dhmVar.l);
                }
                if (dhmVar.t.h().b()) {
                    shotCallback.setFinal_image_yuv_allocator(dhmVar.q);
                    shotCallback.setFinal_image_callback(dhmVar.l);
                }
                if (dhmVar.t.k().b()) {
                    shotCallback.setJpeg_callback(dhmVar.m);
                }
                nyp onyVar = (nyp) this.o.get();
                if (!this.m.a("persist.gcam.debug", true)) {
                    this.s.b();
                    imageSaverParams = null;
                } else if (onyVar.b()) {
                    ImageSaverParams imageSaverPa1 = new ImageSaverParams();
                    ios b5 = hetVar.b;
                    l = (b5 != null) ? b5.b() : System.currentTimeMillis();
                    if (((File) onyVar.c()).getFreeSpace() - 0x40000000 <= 0) {
                        this.x.a("Cache has less than 1GB free. Slowraw data may be silently deleted.", 1);
                    }
                    File uFile = (File) onyVar.c();
                    ohr.b(uFile);
                    if (!uFile.exists() || !uFile.isDirectory()) {
                        String valueOf = uFile.getAbsolutePath();
                        throw new RuntimeException(valueOf.length() == 0 ? "Gcam debug directory not valid or doesn't exist: " : "Gcam debug directory not valid or doesn't exist: ".concat(valueOf));
                    } else {
                        File uFile1 = new File(new File(uFile, "gcam"), this.z.a(l));
                        if (uFile1.mkdirs()) {
                            this.u = uFile1.getAbsolutePath();
                            imageSaverPa1.setDest_folder(this.u);
                            imageSaverParams = imageSaverPa1;
                        } else {
                            throw new RuntimeException("Could not create Gcam debug data folder.");
                        }
                    }
                } else {
                    imageSaverParams = null;
                }
                int i2;
                if (dhvVar.i().b()) {
                    i2 = 3;
                } else if (dhvVar.j().b()) {
                    i2 = 5;
                } else if (!dhvVar.h().b()) {
                    dhvVar.k().b();
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                this.C.a("Gcam::StartShotCapture");
                boolean b3 = false;
                int StartShotCapture = this.d.StartShotCapture(i, shotParams, shotCallback, i2, postviewParams, imageSaverParams);
                this.C.a();
                ohr.a(StartShotCapture != GcamModule.getKInvalidShotId(), "Gcam::StartShotCapture() returned an invalid shot id.");
                hetVar.a.g.a(this.y.a(StartShotCapture));
                this.b.d.put(StartShotCapture, dhmVar);
                dfy dfyVar = new dfy(this, StartShotCapture);
                ohr.a(StartShotCapture != GcamModule.getKInvalidShotId());
                if (dhmVar.b == GcamModule.getKInvalidShotId()) {
                    b3 = true;
                }
                ohr.b(b3);
                dhmVar.b = StartShotCapture;
                dhmVar.u = dfyVar;
                return dhmVar;
            } else {
                throw new IllegalArgumentException("source should not be null");
            }
        }
    }

    @Override
    public int a(int i) {
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < this.d.GetNumCameras(); i4++) {
            if (this.d.GetStaticMetadata(i4).getSensor_id() == i) {
                i2++;
                i3 = i4;
            }
        }
        if (i2 <= 0) {
            return -1;
        }
        return i3;
    }

    @Override
    public BurstSpec a(dhm dhmVar, hhb hhbVar, mqm mqmVar, mqc mqcVar) {
        this.B.b("buildPayloadBurstSpec()");
        if (!this.q.a()) {
            dgs dgsVar = (dgs) ohr.b(a(hhbVar, mqmVar, mqcVar, this.n));
            if (dgsVar.b != null && dgsVar.a != null && dgsVar.c != null) {
                return this.d.BuildPayloadBurstSpec(dhmVar.a(), dgsVar.a, dgsVar.b, dgsVar.c);
            }
            this.B.c("buildPayloadBurstSpec failed due to incomplete viewfinder frame. Out of memory?");
            return new BurstSpec();
        }
        try {
            throw new mbl("Camera already closed");
        } catch (mbl ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public dhm a(int i, dhv dhvVar, het hetVar, PostviewParams postviewParams, hhb hhbVar, hha hhaVar, mqc mqcVar) {
        this.C.a("HdrPlus#StartShotCapture");
        try {
            return a(i, dhvVar, hetVar, postviewParams, hhbVar, hhaVar, mqcVar, false, -1);
        } finally {
            this.C.a();
        }
    }

    @Override
    public dhm a(int i, dhv dhvVar, het hetVar, PostviewParams postviewParams, hhb hhbVar, hha hhaVar, mqc mqcVar, int i2) {
        this.C.a("HdrPlus#StartZslShotCapture");
        try {
            return a(i, dhvVar, hetVar, postviewParams, hhbVar, hhaVar, mqcVar, true, i2);
        } finally {
            this.C.a();
        }
    }

    @Override
    public lrm a() {
        return this.b.h;
    }

    @Override
    public void a(int i, hhb hhbVar, mqm mqmVar, mqc mqcVar) {
        InputView inputView;
        dgs a = a(hhbVar, mqmVar, mqcVar, this.n);
        if (a == null) {
            this.B.f("addViewfinderFrame() failed: convertToHdrPlusViewfinderFrame returned null.");
            return;
        }
        dgg dggVar = this.b;
        if (mqmVar != null) {
            ohr.b(dggVar.c.isCompatibleRawFormat(mqmVar.b()), "Incompatible Raw image format: %s", mqmVar.b());
            inputView = new InputView(dggVar.e.register(mqmVar).imageId, dggVar.c.wrapRawWriteView(mqmVar));
        } else {
            inputView = new InputView(GcamModule.getKInvalidImageId(), new RawWriteView());
        }
        this.d.AddViewfinderFrame(i, a.b, a.c, a.d, inputView.imageId, a.a);
    }

    @Override
    public void a(dhm dhmVar, int i, mqc mqcVar, mqm mqmVar, mqm mqmVar2, Face[] faceArr) {
        Pair<InputView, InputView> create;
        InputView inputView;
        ImageProxyAndHardwareBufferReleaseCallback.Key register;
        InputView inputView2;
        this.C.a("AddPayloadFrame-" + i);
        GyroSampleVector a = a(mqcVar);
        this.C.a("metadata");
        FrameMetadata a2 = this.j.a(mqcVar, faceArr, a);
        if (this.m.a("persist.gcam.debug", false)) {
            bdz.a("  Result frame " + i, mqcVar, new File((String) ohr.b(this.u), "payload_burst_actual_hal3.txt"));
        } else {
            this.s.b();
        }
        dhmVar.e.add(mqmVar != null ? mqmVar.f() : -1L);
        dhmVar.d.add(mqcVar);
        SpatialGainMap a3 = this.j.a(mqcVar);
        this.C.a();
        dgg dggVar = this.b;
        if (mqmVar != null) {
            ohr.b(dggVar.c.isCompatibleRawFormat(mqmVar.b()), "Incompatible Raw image format: %s", mqmVar.b());
            HardwareBuffer g = mqmVar.g();
            if (g != null) {
                ImageProxyAndHardwareBufferReleaseCallback.Key register2 = dggVar.e.register(mqmVar, g);
                inputView2 = new InputView(register2.hardwareBufferId, AndroidJniUtils.getAHardwareBufferPtr(g));
                register = register2;
            } else {
                register = dggVar.e.register(mqmVar);
                inputView2 = new InputView(GcamModule.getKInvalidImageId(), 0L);
            }
            create = Pair.create(new InputView(register.imageId, dggVar.c.wrapRawWriteView(mqmVar)), inputView2);
        } else {
            create = Pair.create(new InputView(GcamModule.getKInvalidImageId(), new RawWriteView()), new InputView(GcamModule.getKInvalidImageId(), 0L));
        }
        dgg dggVar2 = this.b;
        if (mqmVar2 != null) {
            nyp wrapPdWriteView = dggVar2.c.wrapPdWriteView(mqmVar2);
            inputView = !wrapPdWriteView.b() ? new InputView(GcamModule.getKInvalidImageId(), new InterleavedWriteViewU16()) : new InputView(dggVar2.e.register(mqmVar2).imageId, (InterleavedWriteViewU16) wrapPdWriteView.c());
        } else {
            inputView = new InputView(GcamModule.getKInvalidImageId(), new InterleavedWriteViewU16());
        }
        if (!this.d.AddPayloadFrame(dhmVar.a(), a2, a3, ((InputView) create.first).imageId, (RawWriteView) ((InputView) create.first).view, inputView.imageId, (InterleavedWriteViewU16) inputView.view, ((InputView) create.second).imageId, (Long) ((InputView) create.second).view)) {
            pra.b(c, String.format(Locale.ROOT, "addPayloadFrame for shot %d failed, closing input images at frame index %d.", dhmVar.a(), i));
            if (mqmVar != null) {
                mqmVar.close();
            }
            if (mqmVar2 != null) {
                mqmVar2.close();
            }
        }
        this.C.a();
    }

    @Override
    public void a(dhm dhmVar, BurstSpec burstSpec) {
        int a = dhmVar.a();
        String sb = "BeginPayloadFrames-" +
                a;
        this.C.a(sb);
        this.d.BeginPayloadFrames(dhmVar.a(), burstSpec);
        this.C.a();
    }

    @Override
    public boolean a(dhm dhmVar) {
        int a = dhmVar.a();
        String sb = "AbortShot-" +
                a;
        this.C.a(sb);
        boolean AbortShot = this.d.AbortShot(a);
        this.C.a();
        return AbortShot;
    }

    @Override
    public ded b() {
        return this.e;
    }

    @Override
    public void b(int i) {
        this.d.FlushViewfinder(i);
    }

    @Override
    public boolean b(dhm dhmVar) {
        int a = dhmVar.a();
        String sb = "EndShotCapture-" +
                a;
        this.C.a(sb);
        boolean EndShotCapture = this.d.EndShotCapture(a);
        this.C.a();
        return EndShotCapture;
    }

    @Override
    public void c(dhm dhmVar) {
        a(dhmVar, new BurstSpec());
    }

    @Override
    public boolean d(dhm dhmVar) {
        ClientExifMetadata clientExifMetadata;
        int a = dhmVar.a();
        String sb = "EndPayloadFrames-" +
                a;
        this.C.a(sb);
        this.C.a("location");
        nyp e = this.p.e();
        if (e.b()) {
            Location location = (Location) e.c();
            LocationData locationData = new LocationData();
            locationData.setAltitude(location.getAltitude());
            locationData.setDegree_of_precision(location.getAccuracy());
            locationData.setLatitude(location.getLatitude());
            locationData.setLongitude(location.getLongitude());
            locationData.setTimestamp_unix(location.getTime() / 1000);
            locationData.setProcessing_method(location.getProvider());
            clientExifMetadata = new ClientExifMetadata();
            clientExifMetadata.setLocation(locationData);
        } else {
            clientExifMetadata = null;
        }
        this.C.b("gcam");
        boolean EndPayloadFrames = this.d.EndPayloadFrames(a, clientExifMetadata, null, null);
        if (EndPayloadFrames) {
            this.C.b("progress");
            dhmVar.c.d.a(jzz.a(0x7f130297));
            dhmVar.c.d.a(this.a, 0.0f);
        } else {
            this.B.c("EndPayloadFrames() failed.");
        }
        this.C.a();
        this.C.a();
        return EndPayloadFrames;
    }
}