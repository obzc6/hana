/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_310
 *  net.minecraft.class_4048
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IEntity;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_310;
import net.minecraft.class_4048;
import net.minecraft.class_4587;
import net.minecraft.class_638;

public class ESP
extends Module {
    private final ColorSetting player;
    private final ColorSetting chest;
    private final ColorSetting item;

    public ESP() {
        ESP a;
        ESP eSP = a;
        ESP eSP2 = a;
        super(GaussianKernel.ALLATORIxDEMO("9>/"), Module.Category.Render);
        ESP eSP3 = a;
        eSP3.item = eSP2.add(new ColorSetting(GaussianFilter.ALLATORIxDEMO("\u001bJ}\u0019"), new Color(255, 255, 255, 100)).injectBoolean(true));
        eSP2.player = eSP2.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("(\u0006\u000f\u0005\b\r"), new Color(255, 255, 255, 100)).injectBoolean(true));
        eSP.chest = eSP.add(new ColorSetting(GaussianFilter.ALLATORIxDEMO("`:[k\u0000"), new Color(255, 255, 255, 100)).injectBoolean(false));
        eSP.setChinese(GaussianKernel.ALLATORIxDEMO("\u9062\u89b9"));
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        Object a32;
        Object object;
        ESP eSP = a32;
        if (eSP.item.booleanValue || eSP.player.booleanValue) {
            for (Object a32 : ESP.mc.field_1687.method_18112()) {
                if (a32 instanceof class_1542 && eSP.item.booleanValue) {
                    object = eSP.item.getValue();
                    Render3DUtil.draw3DBox(a, ((IEntity)a32).getDimensions().method_30757(new class_243(MathUtil.interpolate(((class_1297)a32).field_6038, a32.method_23317(), a22), MathUtil.interpolate(((class_1297)a32).field_5971, a32.method_23318(), a22), MathUtil.interpolate(((class_1297)a32).field_5989, a32.method_23321(), a22))), (Color)object, false, true);
                    continue;
                }
                if (!(a32 instanceof class_1657) || !eSP.player.booleanValue) continue;
                object = eSP.player.getValue();
                Render3DUtil.draw3DBox(a, ((IEntity)a32).getDimensions().method_30757(new class_243(MathUtil.interpolate(((class_1297)a32).field_6038, a32.method_23317(), a22), MathUtil.interpolate(((class_1297)a32).field_5971, a32.method_23318(), a22), MathUtil.interpolate(((class_1297)a32).field_5989, a32.method_23321(), a22))).method_1009(0.0, 0.1, 0.0), (Color)object, false, true);
            }
        }
        if (eSP.chest.booleanValue) {
            ArrayList<class_2586> arrayList = BlockUtil.getTileEntities();
            a32 = arrayList.iterator();
            while (a32.hasNext()) {
                object = (class_2586)a32.next();
                if (!(object instanceof class_2595)) continue;
                class_238 a22 = new class_238(object.method_11016());
                Render3DUtil.draw3DBox(a, a22, eSP.chest.getValue());
            }
        }
    }
}
