/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;

public class BreakESP
extends Module {
    public final BooleanSetting box;
    public final BooleanSetting outline;
    private final EnumSetting<FadeUtils.Quad> quad;
    public static BreakESP INSTANCE;
    private final ColorSetting color;
    public final SliderSetting animationTime;

    @Override
    public void onRender3D(class_4587 a, float a22) {
        MineManager.BreakData a3;
        BreakESP breakESP = a3;
        Iterator<MineManager.BreakData> a22 = new HashMap<Integer, MineManager.BreakData>(Hana.BREAK.breakMap).values().iterator();
        block0 : do {
            Iterator<MineManager.BreakData> iterator = a22;
            while (iterator.hasNext()) {
                a3 = a22.next();
                if (a3 == null) continue block0;
                if (a3.getEntity() == null) {
                    iterator = a22;
                    continue;
                }
                double d = 0.5 * (1.0 - a3.fade.getQuad(breakESP.quad.getValue()));
                double d2 = d;
                Render3DUtil.draw3DBox(a, new class_238(a3.pos).method_1002(d2, d2, d2).method_1002(-d, -d, -d), breakESP.color.getValue(), breakESP.outline.getValue(), breakESP.box.getValue());
                Render3DUtil.drawText3D(a3.getEntity().method_5477().getString(), a3.pos.method_46558().method_1031(0.0, 0.1, 0.0), -1);
                Render3DUtil.drawText3D(class_2561.method_30163((String)(BreakESP.mc.field_1687.method_22347(a3.pos) ? RenderHelper.ALLATORIxDEMO("3|_$\"V") : FadeUtils.ALLATORIxDEMO("\"C\u0012G]\u000e/w"))), a3.pos.method_46558().method_1031(0.0, -0.1, 0.0), 0.0, 0.0, 1.0, new Color(0, 255, 51));
                iterator = a22;
            }
            break;
        } while (true);
    }

    public BreakESP() {
        BreakESP a;
        BreakESP breakESP = a;
        BreakESP breakESP2 = a;
        super(FadeUtils.ALLATORIxDEMO(")H\t\\\u001aeh:"), Module.Category.Render);
        BreakESP breakESP3 = a;
        breakESP3.color = breakESP2.add(new ColorSetting(RenderHelper.ALLATORIxDEMO("V\u0018dR0"), new Color(255, 255, 255, 100)));
        breakESP2.outline = breakESP2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("u\u0019I\u001dIU\u000f"), false));
        breakESP2.box = breakESP2.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("JR:"), true));
        breakESP2.animationTime = breakESP2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("EW\u0001\u0001\\\u001fS\u0003S%IV\u000f"), 500, 0, 2000));
        breakESP.quad = breakESP2.add(new EnumSetting<FadeUtils.Quad>(RenderHelper.ALLATORIxDEMO("&}\\&"), FadeUtils.Quad.In));
        breakESP.setChinese(FadeUtils.ALLATORIxDEMO("\u7845\u576f\u6605\u7950"));
        INSTANCE = breakESP;
    }
}
