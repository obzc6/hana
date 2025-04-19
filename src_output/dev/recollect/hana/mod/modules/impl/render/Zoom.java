/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_7172
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_7172;
import org.bytedeco.javacv.BufferRing;

public class Zoom
extends Module {
    final SliderSetting fov;
    public static boolean on = false;
    public double currentFov;
    final SliderSetting animSpeed;
    public static Zoom INSTANCE;

    @Override
    public void onEnable() {
        if ((Integer)Zoom.mc.field_1690.method_41808().method_41753() == 70) {
            Zoom.mc.field_1690.method_41808().method_41748((Object)71);
        }
    }

    public Zoom() {
        Zoom a;
        Zoom zoom = a;
        Zoom zoom2 = a;
        super(PacketBuffer.ALLATORIxDEMO(".|\u0019|"), Module.Category.Render);
        Zoom zoom3 = a;
        zoom3.animSpeed = zoom2.add(new SliderSetting(BufferRing.ALLATORIxDEMO("< \u0013$.$\u0005{N"), 0.1, 0.0, 1.0, 0.01));
        zoom.fov = zoom2.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("U\u0019g"), 60.0, -130.0, 130.0, 1.0));
        zoom.setChinese(BufferRing.ALLATORIxDEMO("\u7f37\u6514"));
        INSTANCE = zoom;
        Hana.EVENT_BUS.subscribe(new ZoomAnim(a));
    }

    public class ZoomAnim {
        final /* synthetic */ Zoom this$0;

        public ZoomAnim(Zoom zoom) {
            Zoom a = zoom;
            ZoomAnim a2 = this;
            a2.this$0 = a;
        }

        @EventHandler
        public void onRender3D(Render3DEvent render3DEvent) {
            Render3DEvent a = render3DEvent;
            ZoomAnim a2 = this;
            if (a2.this$0.isOn()) {
                a2.this$0.currentFov = AnimateUtil.animate(a2.this$0.currentFov, a2.this$0.fov.getValue(), a2.this$0.animSpeed.getValue());
                on = true;
                return;
            }
            if (on) {
                ZoomAnim zoomAnim = a2;
                a2.this$0.currentFov = AnimateUtil.animate(zoomAnim.this$0.currentFov, 0.0, a2.this$0.animSpeed.getValue());
                if ((int)zoomAnim.this$0.currentFov == 0) {
                    on = false;
                }
            }
        }
    }

}
