/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.modules.impl.combat.AutoAnchor;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4587;

public class AutoAnchor.AnchorRender {
    final /* synthetic */ AutoAnchor this$0;

    public AutoAnchor.AnchorRender(AutoAnchor autoAnchor) {
        AutoAnchor a = autoAnchor;
        AutoAnchor.AnchorRender a2 = this;
        a2.this$0 = a;
    }

    @EventHandler
    public void onRender3D(Render3DEvent a) {
        AutoAnchor.AnchorRender anchorRender;
        AutoAnchor.AnchorRender anchorRender2;
        AutoAnchor.AnchorRender a2;
        AutoAnchor.AnchorRender anchorRender3 = a2;
        if (anchorRender3.this$0.currentPos != null) {
            anchorRender3.this$0.noPosTimer.reset();
            placeVec3d = anchorRender3.this$0.currentPos.method_46558();
        }
        if (placeVec3d == null) {
            return;
        }
        if (anchorRender3.this$0.fadeSpeed.getValue() >= 1.0) {
            anchorRender3.this$0.fade = anchorRender3.this$0.noPosTimer.passedMs((long)(anchorRender3.this$0.startFadeTime.getValue() * 1000.0)) ? 0.0 : 0.5;
            anchorRender = anchorRender3;
        } else {
            AutoAnchor.AnchorRender anchorRender4;
            double d;
            if (anchorRender3.this$0.noPosTimer.passedMs((long)(anchorRender3.this$0.startFadeTime.getValue() * 1000.0))) {
                d = 0.0;
                anchorRender4 = anchorRender3;
            } else {
                d = 0.5;
                anchorRender4 = anchorRender3;
            }
            anchorRender3.this$0.fade = AnimateUtil.animate(anchorRender3.this$0.fade, d, anchorRender4.this$0.fadeSpeed.getValue() / 10.0);
            anchorRender = anchorRender3;
        }
        if (anchorRender.this$0.fade == 0.0) {
            curVec3d = null;
            return;
        }
        if (curVec3d == null || anchorRender3.this$0.sliderSpeed.getValue() >= 1.0) {
            curVec3d = placeVec3d;
            anchorRender2 = anchorRender3;
        } else {
            curVec3d = new class_243(AnimateUtil.animate(AutoAnchor.curVec3d.field_1352, AutoAnchor.placeVec3d.field_1352, anchorRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoAnchor.curVec3d.field_1351, AutoAnchor.placeVec3d.field_1351, anchorRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoAnchor.curVec3d.field_1350, AutoAnchor.placeVec3d.field_1350, anchorRender3.this$0.sliderSpeed.getValue() / 10.0));
            anchorRender2 = anchorRender3;
        }
        if (anchorRender2.this$0.render.getValue()) {
            Render3DEvent render3DEvent;
            AutoAnchor.AnchorRender anchorRender5 = a2 = new class_238(curVec3d, curVec3d);
            if (anchorRender3.this$0.shrink.getValue()) {
                a2 = anchorRender5.method_1014(anchorRender3.this$0.fade);
                render3DEvent = a;
            } else {
                a2 = anchorRender5.method_1014(0.5);
                render3DEvent = a;
            }
            a = render3DEvent.getMatrixStack();
            if (anchorRender3.this$0.fill.booleanValue) {
                Render3DUtil.drawFill((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.fill.getValue(), (int)((double)anchorRender3.this$0.fill.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)));
            }
            if (anchorRender3.this$0.box.booleanValue) {
                Render3DUtil.drawBox((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.box.getValue(), (int)((double)anchorRender3.this$0.box.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)));
            }
        }
    }
}
