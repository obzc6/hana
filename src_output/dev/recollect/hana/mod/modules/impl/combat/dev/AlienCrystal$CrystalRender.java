/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.text.DecimalFormat;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4587;

private class AlienCrystal.CrystalRender {
    final /* synthetic */ AlienCrystal this$0;

    private /* synthetic */ AlienCrystal.CrystalRender(AlienCrystal object) {
        Object a = object;
        object = this;
        ((AlienCrystal.CrystalRender)object).this$0 = a;
        object();
    }

    @EventHandler
    public void onRender3D(Render3DEvent a) {
        AlienCrystal.CrystalRender crystalRender;
        AlienCrystal.CrystalRender a2;
        AlienCrystal.CrystalRender crystalRender2;
        AlienCrystal.CrystalRender crystalRender3 = a2;
        Object object = a2 = crystalRender3.this$0.sync.getValue() && crystalPos != null ? crystalRender3.this$0.syncPos : crystalPos;
        if (a2 != null) {
            crystalRender3.this$0.placeVec3d = a2.method_10074().method_46558();
        }
        if (crystalRender3.this$0.placeVec3d == null) {
            return;
        }
        if (crystalRender3.this$0.fadeSpeed.getValue() >= 1.0) {
            crystalRender3.this$0.currentFade = crystalRender3.this$0.noPosTimer.passedMs((long)(crystalRender3.this$0.startFadeTime.getValue() * 1000.0)) ? 0.0 : 0.5;
            crystalRender2 = crystalRender3;
        } else {
            AlienCrystal.CrystalRender crystalRender4;
            double d;
            if (crystalRender3.this$0.noPosTimer.passedMs((long)(crystalRender3.this$0.startFadeTime.getValue() * 1000.0))) {
                d = 0.0;
                crystalRender4 = crystalRender3;
            } else {
                d = 0.5;
                crystalRender4 = crystalRender3;
            }
            crystalRender3.this$0.currentFade = AnimateUtil.animate(crystalRender3.this$0.currentFade, d, crystalRender4.this$0.fadeSpeed.getValue() / 10.0);
            crystalRender2 = crystalRender3;
        }
        if (crystalRender2.this$0.currentFade == 0.0) {
            crystalRender3.this$0.curVec3d = null;
            return;
        }
        if (crystalRender3.this$0.curVec3d == null || crystalRender3.this$0.sliderSpeed.getValue() >= 1.0) {
            AlienCrystal.CrystalRender crystalRender5 = crystalRender3;
            crystalRender = crystalRender5;
            crystalRender5.this$0.curVec3d = crystalRender5.this$0.placeVec3d;
        } else {
            crystalRender = crystalRender3;
            crystalRender3.this$0.curVec3d = new class_243(AnimateUtil.animate(crystalRender3.this$0.curVec3d.field_1352, crystalRender3.this$0.placeVec3d.field_1352, crystalRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(crystalRender3.this$0.curVec3d.field_1351, crystalRender3.this$0.placeVec3d.field_1351, crystalRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(crystalRender3.this$0.curVec3d.field_1350, crystalRender3.this$0.placeVec3d.field_1350, crystalRender3.this$0.sliderSpeed.getValue() / 10.0));
        }
        if (crystalRender.this$0.render.getValue()) {
            Render3DEvent render3DEvent;
            AlienCrystal.CrystalRender crystalRender6 = a2 = new class_238(crystalRender3.this$0.curVec3d, crystalRender3.this$0.curVec3d);
            if (crystalRender3.this$0.shrink.getValue()) {
                a2 = crystalRender6.method_1014(crystalRender3.this$0.currentFade);
                render3DEvent = a;
            } else {
                a2 = crystalRender6.method_1014(0.5);
                render3DEvent = a;
            }
            a = render3DEvent.getMatrixStack();
            if (crystalRender3.this$0.fill.booleanValue) {
                Render3DUtil.drawFill((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(crystalRender3.this$0.fill.getValue(), (int)((double)crystalRender3.this$0.fill.getValue().getAlpha() * crystalRender3.this$0.currentFade * 2.0)));
            }
            if (crystalRender3.this$0.box.booleanValue) {
                Render3DUtil.drawLine((class_238)a2, ColorUtil.injectAlpha(crystalRender3.this$0.box.getValue(), (int)((double)crystalRender3.this$0.box.getValue().getAlpha() * crystalRender3.this$0.currentFade * 2.0)), crystalRender3.this$0.lineWidth.getValueInt());
            }
        }
        if (crystalRender3.this$0.text.booleanValue && crystalRender3.this$0.lastDamage > 0.0f && !crystalRender3.this$0.noPosTimer.passedMs((long)(crystalRender3.this$0.startFadeTime.getValue() * 1000.0))) {
            Render3DUtil.drawText3D(crystalRender3.this$0.df.format(crystalRender3.this$0.lastDamage), crystalRender3.this$0.curVec3d, crystalRender3.this$0.text.getValue());
        }
    }
}
