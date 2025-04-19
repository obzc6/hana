/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.awt.Color;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_4587;

public class BlockHighLight
extends Module {
    static class_243 curVec3d;
    double fade;
    final SliderSetting startFadeTime;
    final BooleanSetting shrink;
    final SliderSetting fadeSpeed;
    final ColorSetting fill;
    final ColorSetting box;
    final SliderSetting sliderSpeed;
    final BooleanSetting center;
    static class_243 placeVec3d;
    final Timer noPosTimer;

    public BlockHighLight() {
        BlockHighLight a;
        BlockHighLight blockHighLight = a;
        super(PacketBuffer.ALLATORIxDEMO(">w\u001cw<x\u001br\u0014W\u001as\u0007|"), Module.Category.Render);
        BlockHighLight blockHighLight2 = a;
        blockHighLight2.center = blockHighLight.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("L*n4y."), true));
        blockHighLight.shrink = blockHighLight.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("/s\u0001}\u0001c"), true));
        blockHighLight.box = blockHighLight.add(new ColorSetting(NpSocketClient.ALLATORIxDEMO("\u0002s$"), new Color(255, 255, 255, 255)).injectBoolean(true));
        blockHighLight.fill = blockHighLight.add(new ColorSetting(PacketBuffer.ALLATORIxDEMO("5}\u0003d"), new Color(255, 255, 255, 100)).injectBoolean(true));
        blockHighLight.sliderSpeed = blockHighLight.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\u0013H\re$}\u001cp%y8"), 0.2, 0.01, 1.0, 0.01));
        blockHighLight.startFadeTime = blockHighLight.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("c\u0006t\u000eo5u\u000bm"), 0.3, 0.0, 2.0, 0.01).setSuffix(NpSocketClient.ALLATORIxDEMO("/")));
        blockHighLight.fadeSpeed = blockHighLight.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("v\u0013q\u0019H\u0003q\nl"), 0.2, 0.01, 1.0, 0.01));
        blockHighLight.noPosTimer = new Timer();
        a.fade = 0.0;
        a.setChinese(NpSocketClient.ALLATORIxDEMO("\u65b9\u5717\u9ac4\u4ef2"));
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        BlockHighLight blockHighLight;
        BlockHighLight blockHighLight2;
        BlockHighLight a3;
        BlockHighLight blockHighLight3 = a3;
        if (BlockHighLight.mc.field_1765 == null || !((a3 = BlockHighLight.mc.field_1765) instanceof class_3965)) {
            return;
        }
        class_3965 a22 = (class_3965)a3;
        if (BlockHighLight.mc.field_1765.method_17783() == class_239.class_240.field_1332) {
            BlockHighLight blockHighLight4 = blockHighLight3;
            blockHighLight4.noPosTimer.reset();
            class_243 class_2432 = placeVec3d = blockHighLight4.center.getValue() ? a22.method_17777().method_46558() : BlockHighLight.mc.field_1765.method_17784();
        }
        if (placeVec3d == null) {
            return;
        }
        if (blockHighLight3.fadeSpeed.getValue() >= 1.0) {
            blockHighLight3.fade = blockHighLight3.noPosTimer.passedMs((long)(blockHighLight3.startFadeTime.getValue() * 1000.0)) ? 0.0 : 0.5;
            blockHighLight = blockHighLight3;
        } else {
            BlockHighLight blockHighLight5;
            double d;
            BlockHighLight blockHighLight6 = blockHighLight3;
            if (blockHighLight6.noPosTimer.passedMs((long)(blockHighLight6.startFadeTime.getValue() * 1000.0))) {
                d = 0.0;
                blockHighLight5 = blockHighLight3;
            } else {
                d = 0.5;
                blockHighLight5 = blockHighLight3;
            }
            blockHighLight3.fade = AnimateUtil.animate(blockHighLight3.fade, d, blockHighLight5.fadeSpeed.getValue() / 10.0);
            blockHighLight = blockHighLight3;
        }
        if (blockHighLight.fade == 0.0) {
            curVec3d = null;
            return;
        }
        curVec3d = curVec3d == null || blockHighLight3.sliderSpeed.getValue() >= 1.0 ? placeVec3d : new class_243(AnimateUtil.animate(BlockHighLight.curVec3d.field_1352, BlockHighLight.placeVec3d.field_1352, blockHighLight3.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(BlockHighLight.curVec3d.field_1351, BlockHighLight.placeVec3d.field_1351, blockHighLight3.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(BlockHighLight.curVec3d.field_1350, BlockHighLight.placeVec3d.field_1350, blockHighLight3.sliderSpeed.getValue() / 10.0));
        BlockHighLight blockHighLight7 = a3 = new class_238(curVec3d, curVec3d);
        if (blockHighLight3.shrink.getValue()) {
            a3 = blockHighLight7.method_1014(blockHighLight3.fade);
            blockHighLight2 = blockHighLight3;
        } else {
            a3 = blockHighLight7.method_1014(0.5);
            blockHighLight2 = blockHighLight3;
        }
        if (blockHighLight2.fill.booleanValue) {
            Render3DUtil.drawFill(a, (class_238)a3, ColorUtil.injectAlpha(blockHighLight3.fill.getValue(), (int)((double)blockHighLight3.fill.getValue().getAlpha() * blockHighLight3.fade * 2.0)));
        }
        if (blockHighLight3.box.booleanValue) {
            Render3DUtil.drawBox(a, (class_238)a3, ColorUtil.injectAlpha(blockHighLight3.box.getValue(), (int)((double)blockHighLight3.box.getValue().getAlpha() * blockHighLight3.fade * 2.0)));
        }
    }
}
