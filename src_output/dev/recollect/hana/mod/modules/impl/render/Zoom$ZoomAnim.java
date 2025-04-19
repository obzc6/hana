/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.modules.impl.render.Zoom;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;

public class Zoom.ZoomAnim {
    final /* synthetic */ Zoom this$0;

    public Zoom.ZoomAnim(Zoom zoom) {
        Zoom a = zoom;
        Zoom.ZoomAnim a2 = this;
        a2.this$0 = a;
    }

    @EventHandler
    public void onRender3D(Render3DEvent render3DEvent) {
        Render3DEvent a = render3DEvent;
        Zoom.ZoomAnim a2 = this;
        if (a2.this$0.isOn()) {
            a2.this$0.currentFov = AnimateUtil.animate(a2.this$0.currentFov, a2.this$0.fov.getValue(), a2.this$0.animSpeed.getValue());
            on = true;
            return;
        }
        if (on) {
            Zoom.ZoomAnim zoomAnim = a2;
            a2.this$0.currentFov = AnimateUtil.animate(zoomAnim.this$0.currentFov, 0.0, a2.this$0.animSpeed.getValue());
            if ((int)zoomAnim.this$0.currentFov == 0) {
                on = false;
            }
        }
    }
}
