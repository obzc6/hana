/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.CircleUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class HanaAura.CrystalRender {
    final /* synthetic */ HanaAura this$0;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onRender3D(Render3DEvent a) {
        block23 : {
            var2_2 = a;
            if (HanaAura.crystalPos != null) {
                var2_2.this$0.noPosTimer.reset();
                HanaAura.placeVec3d = HanaAura.crystalPos.method_10074().method_46558();
            }
            if (HanaAura.placeVec3d == null) {
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
                HanaAura.curVec3d = null;
                return;
            }
            if (HanaAura.curVec3d == null || var2_2.this$0.sliderSpeed.getValue() >= 1.0) {
                HanaAura.curVec3d = HanaAura.placeVec3d;
                v3 = var2_2;
            } else {
                HanaAura.curVec3d = new class_243(AnimateUtil.animate(HanaAura.curVec3d.field_1352, HanaAura.placeVec3d.field_1352, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(HanaAura.curVec3d.field_1351, HanaAura.placeVec3d.field_1351, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(HanaAura.curVec3d.field_1350, HanaAura.placeVec3d.field_1350, var2_2.this$0.sliderSpeed.getValue() / 10.0));
                v3 = var2_2;
            }
            if (!v3.this$0.render.getValue()) break block23;
            v4 = a = new class_238(HanaAura.curVec3d, HanaAura.curVec3d);
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
lbl47: // 2 sources:
                v7 = var2_2;
            }
            if (v7.this$0.circle.getValue()) {
                a = class_310.method_1551();
                if (a.field_1724 == null) {
                    return;
                }
                a = a.field_1724;
                v8 = var2_2;
                var3_3 = v8.this$0.circleColor.getValue();
                if (v8.this$0.circleSize.getValue() != var2_2.this$0.radiusUtils.getTargetRadius()) {
                    var2_2.this$0.radiusUtils.setTargetRadius(var2_2.this$0.circleSize.getValue());
                }
                v9 = var2_2;
                var4_4 = var2_2.this$0.isOn() != false ? v9.this$0.fadeIn.ease(FadeUtils.Ease.In) : v9.this$0.fadeOut.ease(FadeUtils.Ease.Out);
                var4_5 = (int)((double)var3_3.getAlpha() * var4_4);
                var3_3 = new Color(var3_3.getRed(), var3_3.getGreen(), var3_3.getBlue(), var4_5);
                v10 = var2_2;
                var6_6 = (float)v10.this$0.radiusUtils.getCurrentRadius();
                if (v10.this$0.xuanzhuan.getValue()) {
                    v11 = var2_2;
                    v11.this$0.currentRotation += var2_2.this$0.rotationFade.ease(FadeUtils.Ease.Out) * 360.0;
                    if (v11.this$0.rotationFade.isEnd()) {
                        var2_2.this$0.currentRotation = (var2_2.this$0.currentRotation % 360.0 + 360.0) % 360.0;
                    }
                }
                CircleUtil.drawCircle2D((class_4587)a, (class_1297)a, var3_3, var6_6, var2_2.this$0.currentRotation);
                if (var2_2.this$0.drawMode.getValue() == HanaAura.CircleMode.Circle) {
                    CircleUtil.drawCircle((class_4587)a, (class_1297)a, var3_3, var6_6, var2_2.this$0.currentRotation);
                }
                if (var2_2.this$0.drawMode.getValue() == HanaAura.CircleMode.Circle2D) {
                    CircleUtil.drawCircle2D((class_4587)a, (class_1297)a, var3_3, var6_6, var2_2.this$0.currentRotation);
                }
                if (var2_2.this$0.drawMode.getValue() == HanaAura.CircleMode.Star) {
                    v12 = var6_6;
                    CircleUtil.drawStar2D((class_4587)a, (class_1297)a, var3_3, v12, v12, var2_2.this$0.currentRotation);
                }
            }
        }
        if (var2_2.this$0.text.booleanValue && var2_2.this$0.lastDamage > 0.0f) {
            v13 = new Object[1];
            v13[0] = Float.valueOf(var2_2.this$0.lastDamage);
            Render3DUtil.drawText3D(String.format(Snow.ALLATORIxDEMO("!~!!"), v13), HanaAura.curVec3d, var2_2.this$0.text.getValue());
        }
        if (!(var2_2.this$0.synchealth.getValue() <= (double)Wrapper.mc.field_1724.method_6032())) return;
        if (var2_2.this$0.webSync.getValue() == false) return;
        Render3DUtil.drawText3D(String.format(String.valueOf((Object)var2_2.this$0.displayTarget.method_5477()), new Object[0]), new class_243(HanaAura.curVec3d.field_1352, HanaAura.curVec3d.field_1351 + 0.2, HanaAura.curVec3d.field_1350), var2_2.this$0.synctext.getValue());
        Render3DUtil.drawText3D(String.format("Sync:" + var2_2.this$0.lastDamage, new Object[0]), new class_243(HanaAura.curVec3d.field_1352, HanaAura.curVec3d.field_1351 - 0.2, HanaAura.curVec3d.field_1350), var2_2.this$0.synctext.getValue());
        Render3DUtil.drawText3D(String.format("" + var2_2.this$0.p, new Object[0]), new class_243(HanaAura.curVec3d.field_1352, HanaAura.curVec3d.field_1351 - 0.4, HanaAura.curVec3d.field_1350), var2_2.this$0.synctext.getValue());
    }

    public HanaAura.CrystalRender(HanaAura hanaAura) {
        HanaAura a = hanaAura;
        HanaAura.CrystalRender a2 = this;
        a2.this$0 = a;
    }
}
