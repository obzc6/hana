/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.ClientInfo;
import dev.recollect.hana.video.FileUtil;
import java.awt.Color;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class AnimSample
extends Module {
    public final ColorSetting color;
    public SliderSetting sliderSpeed;
    private final BooleanSetting outline;
    private final BooleanSetting box;
    private static class_243 lastVec3d;

    public AnimSample() {
        AnimSample a;
        AnimSample animSample = a;
        AnimSample animSample2 = a;
        super(ClientInfo.ALLATORIxDEMO("B m$P/s#8|"), Module.Category.Render);
        AnimSample animSample3 = a;
        animSample3.color = animSample2.add(new ColorSetting(FileUtil.ALLATORIxDEMO(")v\u001a\r"), new Color(255, 255, 255, 100)));
        animSample2.box = animSample2.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\u0011;a"), true));
        animSample2.outline = animSample2.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("8p\u001eu\u001f~\u001a"), true));
        animSample.sliderSpeed = animSample.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("Ho'`,q\u001dn61}"), 0.2, 0.01, 1.0, 0.01));
        animSample.setChinese(FileUtil.ALLATORIxDEMO("\u6313\u63f2\u6627\u794c\u52b8\u7544"));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a4 = f;
        AnimSample a2 = this;
        if (!AnimSample.mc.field_1724.method_7337() && SpeedMine.breakPos != null) {
            void a3;
            class_243 a4 = SpeedMine.breakPos.method_46558();
            lastVec3d = lastVec3d == null ? a4 : new class_243(Component.animate(lastVec3d.method_10216(), a4.field_1352, a2.sliderSpeed.getValue()), Component.animate(lastVec3d.method_10214(), a4.field_1351, a2.sliderSpeed.getValue()), Component.animate(lastVec3d.method_10215(), a4.field_1350, a2.sliderSpeed.getValue()));
            Render3DUtil.draw3DBox((class_4587)a3, new class_238(lastVec3d.method_1031(0.5, 0.5, 0.5), lastVec3d.method_1031(-0.5, -0.5, -0.5)), ColorUtil.injectAlpha(a2.color.getValue(), a2.color.getValue().getAlpha()), a2.outline.getValue(), a2.box.getValue());
        }
    }
}
