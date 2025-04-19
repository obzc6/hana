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
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import org.bytedeco.javacv.BufferRing;

public class AutoCrystal.CrystalRender {
    final /* synthetic */ AutoCrystal this$0;

    public AutoCrystal.CrystalRender(AutoCrystal autoCrystal) {
        AutoCrystal a = autoCrystal;
        AutoCrystal.CrystalRender a2 = this;
        a2.this$0 = a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onRender3D(Render3DEvent a) {
        var2_2 = a;
        if (AutoCrystal.crystalPos != null) {
            var2_2.this$0.noPosTimer.reset();
            AutoCrystal.placeVec3d = AutoCrystal.crystalPos.method_10074().method_46558();
        }
        if (AutoCrystal.placeVec3d == null) {
            return;
        }
        if (var2_2.this$0.fadeSpeed.getValue() >= 1.0) {
            var2_2.this$0.fade = var2_2.this$0.noPosTimer.passedMs((long)(var2_2.this$0.startFadeTime.getValue() * 1000.0)) != false ? 0.0 : 0.5;
            v0 = var2_2;
        } else {
            if (var2_2.this$0.noPosTimer.passedMs((long)(var2_2.this$0.startFadeTime.getValue() * 1000.0))) {
                v1 = 0.0;
                v2 = var2_2;
            } else {
                v1 = 0.5;
                v2 = var2_2;
            }
            var2_2.this$0.fade = AnimateUtil.animate(var2_2.this$0.fade, v1, v2.this$0.fadeSpeed.getValue() / 10.0);
            v0 = var2_2;
        }
        if (v0.this$0.fade == 0.0) {
            AutoCrystal.curVec3d = null;
            return;
        }
        if (AutoCrystal.curVec3d == null || var2_2.this$0.sliderSpeed.getValue() >= 1.0) {
            AutoCrystal.curVec3d = AutoCrystal.placeVec3d;
            v3 = var2_2;
        } else {
            AutoCrystal.curVec3d = new class_243(AnimateUtil.animate(AutoCrystal.curVec3d.field_1352, AutoCrystal.placeVec3d.field_1352, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoCrystal.curVec3d.field_1351, AutoCrystal.placeVec3d.field_1351, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoCrystal.curVec3d.field_1350, AutoCrystal.placeVec3d.field_1350, var2_2.this$0.sliderSpeed.getValue() / 10.0));
            v3 = var2_2;
        }
        if (!v3.this$0.render.getValue()) ** GOTO lbl47
        v4 = a = new class_238(AutoCrystal.curVec3d, AutoCrystal.curVec3d);
        if (var2_2.this$0.shrink.getValue()) {
            a = v4.method_1014(var2_2.this$0.fade);
            v5 = a;
        } else {
            a = v4.method_1014(0.5);
            v5 = a;
        }
        a = v5.getMatrixStack();
        if (var2_2.this$0.fill.booleanValue) {
            Render3DUtil.drawFill((class_4587)a, (class_238)a, ColorUtil.injectAlpha(var2_2.this$0.fill.getValue(), (int)((double)var2_2.this$0.fill.getValue().getAlpha() * var2_2.this$0.fade * 2.0)));
        }
        if (!var2_2.this$0.box.booleanValue) ** GOTO lbl47
        if (!var2_2.this$0.bold.getValue()) {
            v6 = var2_2;
            v7 = v6;
            Render3DUtil.drawBox((class_4587)a, (class_238)a, ColorUtil.injectAlpha(v6.this$0.box.getValue(), (int)((double)var2_2.this$0.box.getValue().getAlpha() * var2_2.this$0.fade * 2.0)));
        } else {
            Render3DUtil.drawLine((class_238)a, ColorUtil.injectAlpha(var2_2.this$0.box.getValue(), (int)((double)var2_2.this$0.box.getValue().getAlpha() * var2_2.this$0.fade * 2.0)), var2_2.this$0.lineWidth.getValueInt());
lbl47: // 3 sources:
            v7 = var2_2;
        }
        if (v7.this$0.text.booleanValue == false) return;
        if (!(var2_2.this$0.lastDamage > 0.0f)) return;
        v8 = new Object[1];
        v8[0] = Float.valueOf(var2_2.this$0.lastDamage);
        Render3DUtil.drawText3D(String.format(BufferRing.ALLATORIxDEMO("6\tV6"), v8), AutoCrystal.curVec3d, var2_2.this$0.text.getValue());
    }
}
