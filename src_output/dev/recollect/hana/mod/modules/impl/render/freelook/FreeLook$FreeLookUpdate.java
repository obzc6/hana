/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render.freelook;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.impl.render.freelook.FreeLook;

public class FreeLook.FreeLookUpdate {
    final /* synthetic */ FreeLook this$0;

    public FreeLook.FreeLookUpdate(FreeLook freeLook) {
        FreeLook a = freeLook;
        FreeLook.FreeLookUpdate a2 = this;
        a2.this$0 = a;
    }

    @EventHandler
    public void onRender3D(Render3DEvent render3DEvent) {
        FreeLook.FreeLookUpdate a;
        boolean bl;
        Object a2 = render3DEvent;
        FreeLook.FreeLookUpdate freeLookUpdate = a = this;
        a2 = freeLookUpdate.this$0.getCameraState();
        boolean bl2 = freeLookUpdate.this$0.isOn() && !((CameraState)a2).doLock;
        boolean bl3 = bl = !a.this$0.isOn() && ((CameraState)a2).doLock;
        if (bl2) {
            if (!((CameraState)a2).doTransition) {
                Object object = a2;
                ((CameraState)object).lookYaw = ((CameraState)object).originalYaw();
                ((CameraState)object).lookPitch = ((CameraState)object).originalPitch();
            }
            ((CameraState)a2).doLock = true;
        }
        if (bl) {
            ((CameraState)a2).doLock = false;
            ((CameraState)a2).doTransition = true;
            ((CameraState)a2).transitionInitialYaw = ((CameraState)a2).lookYaw;
            ((CameraState)a2).transitionInitialPitch = ((CameraState)a2).lookPitch;
        }
    }
}
