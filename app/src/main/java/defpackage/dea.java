package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.google.googlex.gcam.BurstSpec;
import com.google.googlex.gcam.FrameRequest;
import com.google.googlex.gcam.FrameRequestVector;

import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;

@TargetApi(23)
final class dea {
   private final lzp a;
   private final lzj b;
   private final dfw c;
   private final dfa d;
   private final kib e;
   private final boolean f;

   dea(lzp lzp0, lzk lzk0, dfw dfw0, dfa dfa0, kib kib0, mmb mmb0) {
      this.a = lzp0;
      this.c = dfw0;
      this.d = dfa0;
      this.e = kib0;
      this.f = mmb0.b() == mmt.a;
      this.b = lzk0.a("HdrPBurstTkr");
   }

   private final HashMap<Long, gtu> a(gtt gtt0, int v) {
      HashMap<Long, gtu> hashMap0 = new HashMap<>();
      this.a.a("HdrPlus#pdDataPayload");
      for (int i = 0; i < v; i++) {
         gtu gtu0;
         try {
            gtu0 = (gtu) gtt0.a();
         } catch (mbl | InterruptedException e) {
            gtu0 = null;
            continue;
         }
         try {
            if (gtu0.i()) {
               hashMap0.put(gtu0.f(), gtu0);
            } else {
               gtu0.close();
            }
            continue;
         } catch (/* mbl | InterruptedException */ Exception e) {
         }
         if (gtu0 != null) {
            gtu0.close();
         }
      }
      this.a.a();
      return hashMap0;
   }

   private final mqc a(dhm p0, int v, int v1, gtt p3, HashMap<Long, gtu> p4, Face[] p5)
         throws InterruptedException, mbl {
      gtu gtu0 = null;
      int frameNum = v + 1;
      this.a.a("Frame" + frameNum + "of" + v1);

      try {
         try {
            gtu0 = (gtu) p3.a();
            ozs ozs0 = gtu0.j();
            ohr.b(ozs0);
            mqc mqc0 = (mqc) ozs0.get();

            if (gtu0.i()) {
               gtu prior = p4.remove(Long.valueOf(gtu0.f()));
               this.c.a(p0, v, mqc0, gtu0, prior, p5);
               this.b.d(String.format("Acquired frame %d of %d for shot %d at time %d.", frameNum, v1,
                     p0.a(), gtu0.f()));
            } else {
               gtu0.close();
               this.b.f(String.format(
                     "Payload frame %d of %d for shot %d at time %d did not contain a valid image! Marking frame as invalid.",
                     frameNum, v1, p0.a(), gtu0.f()));
               this.c.a(p0, v, mqc0, null, null, null);
            }
            return mqc0;

         } catch (ExecutionException e) {
            this.b.b(
                  String.format("Could not acquire frame %d of %d for shot %d!", frameNum, v1, p0.a()),
                  e);
            if (gtu0 != null)
               gtu0.close();
            throw new mbl(e);

         } catch (InterruptedException e) {
            this.b.b(
                  String.format("Could not acquire frame %d of %d for shot %d!", frameNum, v1, p0.a()),
                  e);
            if (gtu0 != null)
               gtu0.close();
            throw e;
         }
      } finally {
         this.a.a();
      }
   }

   private final void a(dhm dhm0, int v, int v1, mqc mqc0) {
      int v2 = dhm0.a();
      this.b.f("Marking frame " + (v + 1) + " of " + v1 + " as invalid for shot " + v2 + ".");
      this.c.a(dhm0, v, mqc0, null, null, null);
   }

   private final boolean a(dhm p0, FrameRequestVector p1, her p2, grj p3, gtt p4, gtt p5, gqe p6, lyu p7, izx p8,
         Face[] p9) {
      int totalFrames = (int) p1.size();
      int burstSize = Math.min(totalFrames, p4.d());

      p3.a(p4);
      if (p5 != null) {
         p3.a(p5);
      }
      p2.a(burstSize);
      p3.a(grr.c(p2));
      p3.a(CaptureRequest.CONTROL_CAPTURE_INTENT, Integer.valueOf(0));
      if (kve.a != null) {
         p3.a(kve.a, Integer.valueOf(this.a(this.f)));
      }

      FrameRequest fr0 = p1.get(0);
      float exposure = fr0.getDesired_exposure_time_ms();
      float gain = fr0.getDesired_analog_gain();
      float digital = fr0.getDesired_digital_gain();
      this.d.a(fr0, p3);

      ArrayList<grh> requests = new ArrayList<>(burstSize);
      requests.add(new grj(p3).c());
      for (int i = 1; i < burstSize; i++) {
         FrameRequest fr = p1.get(i);
         float e = fr.getDesired_exposure_time_ms();
         float g = fr.getDesired_analog_gain();
         float d = fr.getDesired_digital_gain();
         if (e != exposure || g != gain || d != digital) {
            this.d.a(fr, p3);
            exposure = e;
            gain = g;
            digital = d;
         }
         requests.add(new grj(p3).c());
      }

      try {
         this.b.b("Submitting an HDR+ payload burst of " + burstSize
               + " frames for shot " + p0.a());
         p6.a(requests, 2);
      } catch (mbl e0) {
         this.b.c(String.format("Failed to submit frame requests for shot %d.", p0.a()));
         return false;
      }
      p7.close();

      HashMap<Long, gtu> payloadFrames = new HashMap<>();
      try {
         this.a.a("HdrPlus#payload");
         if (p5 != null) {
            payloadFrames = this.a(p5, burstSize);
         }
      } catch (/* mbl | InterruptedException */ Exception e0) {
         return recoverOrAbort(p0, payloadFrames, null, 0, burstSize, totalFrames);
      } catch (Throwable t) {
         closeAll(payloadFrames);
         this.a.a();
         throw t;
      }

      mqc lastGood = null;
      int idx = 0;
      try {
         // Acquire up to burstSize frames; frame 0 is also forwarded to `p8`.
         while (idx < burstSize) {
            int thisIdx = idx;
            lastGood = this.a(p0, idx, totalFrames, p4, payloadFrames, p9);
            if (thisIdx == 0) {
               p8.a(lastGood); // may throw and the exception is caught below, idx stays at thisIdx
            }
            idx = thisIdx + 1;
         }

         // All burstSize frames acquired: forward remaining metadata, then finalize.
         for (; idx < totalFrames && lastGood != null; idx++) {
            this.a(p0, idx, totalFrames, lastGood);
         }
         return endPayloadAndFinish(p0, payloadFrames, burstSize, totalFrames);

      } catch (mbl | InterruptedException e0) {
         // Failure anywhere above (acquiring a frame, forwarding frame 0 to `p8`,
         // the tail metadata loop, or EndPayloadFrames/EndShotCapture itself)
         // funnels into the same recovery/abort decision.
         return recoverOrAbort(p0, payloadFrames, lastGood, idx, burstSize, totalFrames);
      } catch (Throwable t) {
         closeAll(payloadFrames);
         this.a.a();
         throw t;
      }
   }

   private boolean recoverOrAbort(dhm p0, HashMap<Long, gtu> payloadFrames, mqc lastGood,
         int fromIdx, int burstSize, int totalFrames) {
      try {
         if (lastGood == null) {
            this.b.c("Failed to receive any frames. Aborting capture for shot " + p0.a());
            return closeAndReturn(payloadFrames, false);
         }

         this.a.b("HdrPlus#recoverPayload");
         this.b.f("Attempting to recover HDR+ burst " + p0.a() + " by supplying null for the remaining frames.");
         for (int j = fromIdx; j < burstSize; j++) {
            this.a(p0, j, totalFrames, lastGood);
         }

         if (this.c.d(p0)) {
            this.b.f("Payload recovery succeeded for shot " + p0.a() + ".");
            return endShotAndReturn(p0, payloadFrames);
         }
         this.b.c("Payload recovery failed for shot " + p0.a() + "!");
         return closeAndReturn(payloadFrames, false);

      } catch (Throwable t) {
         // Recovery itself has no second-level fallback: any failure here,
         // mbl/InterruptedException included, closes everything and rethrows.
         closeAll(payloadFrames);
         this.a.a();
         throw t;
      }
   }

   private boolean endPayloadAndFinish(dhm p0, HashMap<Long, gtu> payloadFrames, int burstSize, int totalFrames) {
      this.a.b("HdrPlus#endPayload");
      if (this.c.d(p0)) {
         this.b.d(String.format("EndPayloadFrames succeeded for shot %d.", p0.a()));
         return endShotAndReturn(p0, payloadFrames);
      }
      this.b.c(String.format("EndPayloadFrames failed for shot %d.", p0.a()));
      return closeAndReturn(payloadFrames, false);
   }

   private boolean endShotAndReturn(dhm p0, HashMap<Long, gtu> payloadFrames) {
      boolean ok = this.c.b(p0);
      this.b.d(String.format("EndShotCapture succeeded for shot %d.", p0.a()));
      return closeAndReturn(payloadFrames, ok);
   }

   private boolean closeAndReturn(HashMap<Long, gtu> payloadFrames, boolean result) {
      closeAll(payloadFrames);
      this.a.a();
      return result;
   }

   private void closeAll(HashMap<Long, gtu> payloadFrames) {
      for (gtu f : payloadFrames.values())
         f.close();
   }

   final int a(boolean z) {
      return !this.e.a.d() && !this.e.a.e() || (z) ? 0 : 2;
   }

   final boolean a(dhm p0, BurstSpec p1, her p2, grj p3, gvk p4, nyp p5, gqe p6, lyu p7, izx p8, hiy p9) {
      this.a.a("HdrPlusPayload" + p0.a());

      FrameRequestVector frameRequests = p1.getFrame_requests();
      int frameCount = (int) frameRequests.size();

      Face[] faces = null;
      if (p9 != null) {
         mqc captureResult = (mqc) p9.a();
         if (captureResult != null) {
            faces = captureResult.a(CaptureResult.STATISTICS_FACES);
         }
      }

      try (gtt gtt0 = esk.a(p4, frameCount);
            gtt gtt1 = p5.b() ? esk.a((gvk) p5.c(), frameCount) : null) {

         if (gtt0 != null && (!p5.b() || gtt1 != null)) {
            this.c.a(p0, p1);
            boolean result = this.a(p0, frameRequests, p2, new grj(p3), gtt0, gtt1, p6, p7, p8, faces);
            this.a.a();
            return result;
         }

         this.b.c(String.format("Failed to allocate at least %d frames for shot %d's payload requests.",
               2, p0.a()));
         this.a.a();
         return false;
      }
   }
}
