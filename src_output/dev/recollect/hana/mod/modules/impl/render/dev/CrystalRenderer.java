/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4608
 *  net.minecraft.class_630
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_7833
 *  net.minecraft.class_892
 *  org.joml.Quaternionf
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import net.minecraft.class_630;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_892;
import org.joml.Quaternionf;

public class CrystalRenderer
extends Module {
    public BooleanSetting cube;
    public static HashMap<class_1511, Double> spinMap = new HashMap();
    private final class_2960 crystalTexture2;
    public final SliderSetting floatOffset;
    public final SliderSetting spinValue;
    public BooleanSetting sync;
    public BooleanSetting cham;
    public final SliderSetting floatValue;
    public static HashMap<class_243, Double> posSpinMap = new HashMap();
    public BooleanSetting line;
    public static Random random;
    public static CrystalRenderer INSTANCE;
    public static HashMap<class_243, Double> posFloatMap;
    public BooleanSetting setting;
    private final ColorSetting crystalColor;
    public final SliderSetting spinAdd;
    public static HashMap<class_1511, Double> floatMap;

    public CrystalRenderer() {
        CrystalRenderer a;
        CrystalRenderer crystalRenderer = a;
        super(ColorUtil.ALLATORIxDEMO("T4y{:<w\by3%to>"), Module.Category.Render);
        CrystalRenderer crystalRenderer2 = a;
        crystalRenderer2.cube = crystalRenderer.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("^VuGUGxQbTm"), true));
        crystalRenderer.cham = crystalRenderer.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("K<$h.}1X(gg?"), true)).setParent();
        crystalRenderer.line = crystalRenderer.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("n[d"), true, object -> {
            Object a = object;
            CrystalRenderer a2 = this;
            return a2.cham.isOpen();
        }));
        a.crystalColor = a.add(new ColorSetting(ColorUtil.ALLATORIxDEMO("K<$h.}1X/je>"), new Color(-1825711896, true), object -> {
            Object a = object;
            CrystalRenderer a2 = this;
            return a2.cham.isOpen();
        }));
        CrystalRenderer crystalRenderer3 = a;
        crystalRenderer3.setting = crystalRenderer3.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("adPnWvNEPuV[f"), false).setParent());
        crystalRenderer3.spinValue = crystalRenderer3.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("H*u3H0co("), 1.0, 0.0, 3.0, 0.01, object -> {
            Object a = object;
            CrystalRenderer a2 = this;
            return a2.setting.isOpen();
        }));
        a.floatValue = a.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("e{MwARRsPe"), 1.0, 0.0, 3.0, 0.01, object -> {
            Object a = object;
            CrystalRenderer a2 = this;
            return a2.setting.isOpen();
        }));
        a.floatOffset = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\b1t;h\u0012}&uo8"), 0.0, -1.0, 1.0, 0.01, object -> {
            Object a = object;
            CrystalRenderer a2 = this;
            return a2.setting.isOpen();
        }));
        CrystalRenderer crystalRenderer4 = a;
        crystalRenderer4.sync = crystalRenderer4.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("qo[b"), true));
        crystalRenderer4.spinAdd = crystalRenderer4.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u000ek3r\u0013~7Gn("), 0.0, 0.0, 100.0, 1.0, object -> {
            Object a = object;
            CrystalRenderer a2 = this;
            return a2.sync.getValue();
        }));
        CrystalRenderer crystalRenderer5 = a;
        crystalRenderer5.crystalTexture2 = new class_2960(BetterDynamicAnimation.ALLATORIxDEMO("~QxGrTwX0pOFIJoZdVwY3\ff[f"));
        crystalRenderer5.setChinese(ColorUtil.ALLATORIxDEMO("\u6c74\u6670\u6634\u7976"));
        INSTANCE = crystalRenderer5;
    }

    public double getFloatAge(class_1511 class_15112) {
        CrystalRenderer a = class_15112;
        CrystalRenderer a2 = this;
        if (!a2.sync.getValue()) {
            return ((class_1511)a).field_7034;
        }
        if (floatMap.getOrDefault(a, -1.0) == -1.0) {
            CrystalRenderer crystalRenderer = a;
            floatMap.put((class_1511)crystalRenderer, posFloatMap.getOrDefault((Object)crystalRenderer.method_19538(), Double.valueOf(random.nextInt(10000))));
        }
        CrystalRenderer crystalRenderer = a;
        double d = floatMap.getOrDefault(crystalRenderer, posFloatMap.getOrDefault((Object)crystalRenderer.method_19538(), -1.0));
        if (d != -1.0) {
            return d;
        }
        d = random.nextInt(10000);
        posFloatMap.put(a.method_19538(), d);
        return d;
    }

    static {
        floatMap = new HashMap();
        posFloatMap = new HashMap();
        random = new Random();
    }

    public double getSpinAge(class_1511 class_15112) {
        CrystalRenderer a = class_15112;
        CrystalRenderer a2 = this;
        if (!a2.sync.getValue()) {
            return ((class_1511)a).field_7034;
        }
        if (spinMap.getOrDefault(a, -1.0) == -1.0) {
            CrystalRenderer crystalRenderer = a;
            spinMap.put((class_1511)crystalRenderer, posSpinMap.getOrDefault((Object)crystalRenderer.method_19538(), Double.valueOf(random.nextInt(10000))) + a2.spinAdd.getValue());
        }
        CrystalRenderer crystalRenderer = a;
        double d = spinMap.getOrDefault(crystalRenderer, posSpinMap.getOrDefault((Object)crystalRenderer.method_19538(), -1.0));
        if (d != -1.0) {
            return d;
        }
        d = random.nextInt(10000);
        posSpinMap.put(a.method_19538(), d);
        return d;
    }

    @Override
    public void onUpdate() {
        Iterator a;
        class_1297 class_12972;
        CrystalRenderer crystalRenderer = a;
        if (!crystalRenderer.sync.getValue()) {
            return;
        }
        ArrayList<class_1511> arrayList = new ArrayList<class_1511>();
        ArrayList<class_1511> arrayList2 = new ArrayList<class_1511>();
        a = CrystalRenderer.mc.field_1687.method_18112().iterator();
        Iterator<Object> iterator = a;
        while (iterator.hasNext()) {
            class_12972 = (class_1297)a.next();
            if (!(class_12972 instanceof class_1511)) {
                iterator = a;
                continue;
            }
            class_1511 class_15112 = (class_1511)class_12972;
            if (spinMap.getOrDefault((Object)class_15112, -1.0) != -1.0) {
                class_1511 class_15113 = class_15112;
                spinMap.put(class_15113, spinMap.get((Object)class_15113) + 1.0);
                posSpinMap.put(class_15112.method_19538(), spinMap.get((Object)class_15112));
            } else {
                arrayList.add(class_15112);
            }
            if (floatMap.getOrDefault((Object)class_15112, -1.0) != -1.0) {
                class_1511 class_15114 = class_15112;
                floatMap.put(class_15114, floatMap.get((Object)class_15114) + 1.0);
                posFloatMap.put(class_15112.method_19538(), floatMap.get((Object)class_15112));
                iterator = a;
                continue;
            }
            arrayList2.add(class_15112);
            iterator = a;
        }
        Iterator iterator2 = a = arrayList.iterator();
        while (iterator2.hasNext()) {
            class_12972 = (class_1511)a.next();
            if (spinMap.getOrDefault((Object)class_12972, -1.0) != -1.0) {
                iterator2 = a;
                continue;
            }
            class_1297 class_12973 = class_12972;
            spinMap.put((class_1511)class_12973, posSpinMap.getOrDefault((Object)class_12973.method_19538(), Double.valueOf(random.nextInt(10000))) + crystalRenderer.spinAdd.getValue());
            iterator2 = a;
        }
        a = arrayList2.iterator();
        Iterator iterator3 = a;
        while (iterator3.hasNext()) {
            class_12972 = (class_1511)a.next();
            if (floatMap.getOrDefault((Object)class_12972, -1.0) != -1.0) {
                iterator3 = a;
                continue;
            }
            class_1297 class_12974 = class_12972;
            floatMap.put((class_1511)class_12974, posFloatMap.getOrDefault((Object)class_12974.method_19538(), Double.valueOf(random.nextInt(10000))));
            iterator3 = a;
        }
    }

    public void setCrystalColor(Color color) {
        Color a = color;
        CrystalRenderer a2 = this;
        a2.crystalColor.setValue(a);
    }

    /*
     * WARNING - void declaration
     */
    public void renderCrystal(class_1511 class_15112, float f, float f2, class_4587 class_45872, int n, class_630 class_6302, class_630 class_6303) {
        void a;
        void a22;
        CrystalRenderer crystalRenderer;
        void a3;
        float a4;
        void a5;
        CrystalRenderer a6;
        CrystalRenderer crystalRenderer2 = crystalRenderer3;
        CrystalRenderer crystalRenderer3 = class_45872;
        CrystalRenderer a7 = crystalRenderer2;
        RenderSystem.enableBlend();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        class_289 a8 = class_289.method_1348();
        class_287 class_2872 = a8.method_1349();
        if (a7.line.getValue()) {
            RenderSystem.setShaderTexture((int)0, (class_2960)a7.crystalTexture2);
            RenderSystem.setShader(class_757::method_34546);
            crystalRenderer = a6;
            class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
        } else {
            RenderSystem.setShader(class_757::method_34546);
            crystalRenderer = a6;
            class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1592);
        }
        crystalRenderer.method_22903();
        void v2 = a22;
        float a22 = class_892.method_23155((class_1511)v2, (float)a4);
        a4 = ((float)v2.field_7034 + a4) * 3.0f;
        CrystalRenderer crystalRenderer4 = a6;
        CrystalRenderer crystalRenderer5 = a6;
        CrystalRenderer crystalRenderer6 = a6;
        crystalRenderer6.method_22903();
        Color color = a7.crystalColor.getValue();
        RenderSystem.setShaderColor((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        crystalRenderer5.method_22905(2.0f, 2.0f, 2.0f);
        crystalRenderer6.method_46416(0.0f, -0.5f, 0.0f);
        int n2 = class_4608.field_21444;
        crystalRenderer5.method_22907(class_7833.field_40716.rotationDegrees(a4));
        crystalRenderer5.method_46416(0.0f, 1.5f + a22 / 2.0f, 0.0f);
        CrystalRenderer crystalRenderer7 = a6;
        crystalRenderer5.method_22907(new Quaternionf().setAngleAxis(1.0471976f, (float)Math.sin(0.7853981633974483), (float)Math.sin(0.7853981633974483), (float)Math.sin(0.7853981633974483)));
        a.method_22698((class_4587)a6, (class_4588)class_2872, (int)a3, n2);
        crystalRenderer5.method_22905(0.875f, 0.875f, 0.875f);
        crystalRenderer5.method_22907(new Quaternionf().setAngleAxis(1.0471976f, (float)Math.sin(0.7853981633974483), 0.0f, (float)Math.sin(0.7853981633974483)));
        crystalRenderer5.method_22907(class_7833.field_40716.rotationDegrees(a4));
        a.method_22698((class_4587)a6, (class_4588)class_2872, (int)a3, n2);
        crystalRenderer5.method_22905(0.875f, 0.875f, 0.875f);
        crystalRenderer4.method_22907(new Quaternionf().setAngleAxis(1.0471976f, (float)Math.sin(0.7853981633974483), 0.0f, (float)Math.sin(0.7853981633974483)));
        crystalRenderer4.method_22907(class_7833.field_40716.rotationDegrees(a4));
        a5.method_22698((class_4587)a6, (class_4588)class_2872, (int)a3, n2);
        crystalRenderer4.method_22909();
        crystalRenderer4.method_22909();
        a8.method_1350();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.enableCull();
    }
}
