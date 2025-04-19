/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.Renderer;
import java.awt.Color;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class Crosshair
extends Module {
    public final SliderSetting thickness;
    public final SliderSetting interval;
    private final ColorSetting color;
    public final SliderSetting length;
    public static Crosshair INSTANCE;

    public Crosshair() {
        Crosshair a;
        Crosshair crosshair = a;
        Crosshair crosshair2 = a;
        super(Renderer.ALLATORIxDEMO("#h\bn\u0013h\u001c#E"), Module.Category.Render);
        Crosshair crosshair3 = a;
        crosshair3.color = crosshair2.add(new ColorSetting(FPSManager.ALLATORIxDEMO("5b\u0007(S"), new Color(255, 255, 255, 255)));
        crosshair2.length = crosshair2.add(new SliderSetting(Renderer.ALLATORIxDEMO("Q\u0005n\u001a>_"), 5.0, 0.0, 20.0, 0.1));
        crosshair2.thickness = crosshair2.add(new SliderSetting(FPSManager.ALLATORIxDEMO("\"\u0018s\u001dc\u000e4R"), 2.0, 0.0, 20.0, 0.1));
        crosshair.interval = crosshair2.add(new SliderSetting(Renderer.ALLATORIxDEMO("S\ti\u0005r\u000b+["), 2.0, 0.0, 20.0, 0.1));
        crosshair.setChinese(FPSManager.ALLATORIxDEMO("\u819c\u5b97\u4e22\u5181\u663e"));
        INSTANCE = crosshair;
    }

    public void draw(class_332 a) {
        Crosshair a22;
        Crosshair crosshair = a22;
        a = a.method_51448();
        float f = (float)mc.method_22683().method_4486() / 2.0f;
        float a22 = (float)mc.method_22683().method_4502() / 2.0f;
        class_332 class_3322 = a;
        float f2 = f;
        Render2DUtil.drawRect((class_4587)a, f - crosshair.thickness.getValueFloat() / 2.0f, a22 - crosshair.length.getValueFloat() - crosshair.interval.getValueFloat(), crosshair.thickness.getValueFloat(), crosshair.length.getValueFloat(), crosshair.color.getValue());
        Render2DUtil.drawRect((class_4587)a, f2 - crosshair.thickness.getValueFloat() / 2.0f, a22 + crosshair.interval.getValueFloat(), crosshair.thickness.getValueFloat(), crosshair.length.getValueFloat(), crosshair.color.getValue());
        Render2DUtil.drawRect((class_4587)class_3322, f2 + crosshair.interval.getValueFloat(), a22 - crosshair.thickness.getValueFloat() / 2.0f, crosshair.length.getValueFloat(), crosshair.thickness.getValueFloat(), crosshair.color.getValue());
        Render2DUtil.drawRect((class_4587)class_3322, f - crosshair.interval.getValueFloat() - crosshair.length.getValueFloat(), a22 - crosshair.thickness.getValueFloat() / 2.0f, crosshair.length.getValueFloat(), crosshair.thickness.getValueFloat(), crosshair.color.getValue());
    }
}
