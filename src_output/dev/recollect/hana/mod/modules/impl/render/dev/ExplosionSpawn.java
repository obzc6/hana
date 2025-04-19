/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_757
 *  net.minecraft.class_824
 *  org.joml.Matrix4f
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.math.Easing;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_757;
import net.minecraft.class_824;
import org.joml.Matrix4f;

public class ExplosionSpawn
extends Module {
    public final SliderSetting size;
    public final ColorSetting color;
    private final SliderSetting extraCount;
    public static final CopyOnWriteArrayList<Pos> spawnList = new CopyOnWriteArrayList();
    private final BooleanSetting extra;
    private final SliderSetting distance;
    private final SliderSetting animationTime;
    public static ExplosionSpawn INSTANCE;
    private final EnumSetting<Easing> ease;
    public final SliderSetting minSize;
    public final SliderSetting height;
    public final SliderSetting up;
    private final SliderSetting time;
    private final SliderSetting delay;
    private final Timer timer;
    private final SliderSetting fadeTime;

    @Override
    public void onRender3D(class_4587 a, float a22) {
        Pos a3;
        ExplosionSpawn explosionSpawn = a3;
        if (!spawnList.isEmpty()) {
            RenderSystem.enableBlend();
            boolean a22 = true;
            Iterator<Pos> iterator = spawnList.iterator();
            block0 : do {
                Iterator<Pos> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    Pos pos;
                    a3 = iterator.next();
                    if (pos.time.easeOutQuad() >= 1.0) {
                        iterator2 = iterator;
                        continue;
                    }
                    double d = a3.firstFade.ease(explosionSpawn.ease.getValue());
                    ExplosionSpawn explosionSpawn2 = explosionSpawn;
                    Color color = explosionSpawn2.color.getValue();
                    color = ColorUtil.injectAlpha(color, (int)((double)color.getAlpha() * Math.abs(1.0 - a3.fadeTime.easeOutQuad())));
                    a22 = false;
                    if (explosionSpawn2.extra.getValue()) {
                        double d2;
                        double d3 = d2 = 0.0;
                        do {
                            if (!(d3 < explosionSpawn.extraCount.getValue() * 0.001 * explosionSpawn.distance.getValue())) continue block0;
                            ExplosionSpawn.drawCircle(a, color, explosionSpawn.size.getValue() * d + explosionSpawn.minSize.getValue() - d2, new class_243(a3.pos.method_10216(), a3.pos.method_10214() + 1.0 + 1.0 * d * explosionSpawn.up.getValue() + explosionSpawn.height.getValue() - 1.5, a3.pos.method_10215()));
                            d3 = d2 + 0.001 * explosionSpawn.distance.getValue();
                        } while (true);
                    }
                    ExplosionSpawn.drawCircle(a, color, explosionSpawn.size.getValue() * d + explosionSpawn.minSize.getValue(), new class_243(a3.pos.method_10216(), a3.pos.method_10214() + 1.0 + 1.0 * d * explosionSpawn.up.getValue() + explosionSpawn.height.getValue() - 1.5, a3.pos.method_10215()));
                    continue block0;
                }
                break;
            } while (true);
            if (a22) {
                spawnList.clear();
            }
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderSystem.disableBlend();
        }
    }

    @Override
    public void onEnable() {
        spawnList.clear();
    }

    public void add(class_2338 class_23382) {
        ExplosionSpawn a;
        ExplosionSpawn a2 = class_23382;
        ExplosionSpawn explosionSpawn = a = this;
        if (explosionSpawn.timer.passedMs(explosionSpawn.delay.getValue())) {
            a.timer.reset();
            spawnList.add(new Pos(a2.method_46558(), a.animationTime.getValueInt(), a.time.getValueInt(), a.fadeTime.getValueInt()));
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCircle(class_4587 class_45872, Color color, double d, class_243 class_2432) {
        double d2;
        Object a = color;
        class_4587 a2 = class_45872;
        class_243 class_2433 = ExplosionSpawn.mc.method_31975().field_4344.method_19326();
        RenderSystem.disableDepthTest();
        Matrix4f matrix4f = a2.method_23760().method_23761();
        class_289 class_2892 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34539);
        RenderSystem.setShaderColor((float)((float)((Color)a).getRed() / 255.0f), (float)((float)((Color)a).getGreen() / 255.0f), (float)((float)((Color)a).getBlue() / 255.0f), (float)((float)((Color)a).getAlpha() / 255.0f));
        class_2872.method_1328(class_293.class_5596.field_29345, class_290.field_1592);
        double d3 = d2 = 0.0;
        while (d3 <= 364.5) {
            void a3;
            void a4;
            double d4 = Math.sin(Math.toRadians(d2)) * a3;
            double d5 = Math.cos(Math.toRadians(d2)) * a3;
            a = new class_243(a4.field_1352 + d4, a4.field_1351, a4.field_1350 + d5).method_1031(-class_2433.field_1352, -class_2433.field_1351, -class_2433.field_1350);
            class_2872.method_22918(matrix4f, (float)((class_243)a).field_1352, (float)((class_243)a).field_1351, (float)((class_243)a).field_1350).method_1344();
            d3 = d2 + 4.5;
        }
        class_2892.method_1350();
        RenderSystem.enableDepthTest();
    }

    public ExplosionSpawn() {
        ExplosionSpawn a;
        ExplosionSpawn explosionSpawn = a;
        super(WebUtils.ALLATORIxDEMO("\u0011ev#<i=r=I>fs#"), Module.Category.Render);
        ExplosionSpawn explosionSpawn2 = a;
        explosionSpawn2.color = explosionSpawn.add(new ColorSetting(Timer.ALLATORIxDEMO("wKE\u0001\u0011"), new Color(-557395713, true)));
        explosionSpawn.size = explosionSpawn.add(new SliderSetting(WebUtils.ALLATORIxDEMO("P2b\u001dn~("), 0.5, 0.1, 5.0, 0.01));
        explosionSpawn.minSize = explosionSpawn.add(new SliderSetting(Timer.ALLATORIxDEMO("~PZw@\u0014\u0006"), 0.1, 0.0, 1.0, 0.01));
        explosionSpawn.up = explosionSpawn.add(new SliderSetting(WebUtils.ALLATORIxDEMO("Q="), 0.1, 0.0, 1.0, 0.01));
        explosionSpawn.height = explosionSpawn.add(new SliderSetting(Timer.ALLATORIxDEMO("qQMN\u0006\u0017"), 0.5, -1.0, 1.0, 0.01));
        explosionSpawn.extra = explosionSpawn.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("\u0003hv("), true).setParent());
        explosionSpawn.extraCount = explosionSpawn.add(new SliderSetting(Timer.ALLATORIxDEMO("z[QG\u001a\u0010"), 5, 1, 10, object -> {
            Object a = object;
            ExplosionSpawn a2 = this;
            return a2.extra.isOpen();
        }));
        a.distance = a.add(new SliderSetting(WebUtils.ALLATORIxDEMO("\u0010t n/ig("), 10, 0, 50, object -> {
            Object a = object;
            ExplosionSpawn a2 = this;
            return a2.extra.isOpen();
        }));
        ExplosionSpawn explosionSpawn3 = a;
        ExplosionSpawn explosionSpawn4 = a;
        explosionSpawn4.delay = explosionSpawn4.add(new SliderSetting(Timer.ALLATORIxDEMO("pAE\u000f\u001a"), 300, 0, 1000));
        explosionSpawn4.time = explosionSpawn4.add(new SliderSetting(WebUtils.ALLATORIxDEMO("\u001ani("), 500, 0, 5000));
        explosionSpawn4.animationTime = explosionSpawn4.add(new SliderSetting(Timer.ALLATORIxDEMO("r\u0002\bTUJZVZp@\u0003\u0006"), 500, 0, 5000));
        explosionSpawn4.fadeTime = explosionSpawn4.add(new SliderSetting(WebUtils.ALLATORIxDEMO("\u0012|7\u001ani("), 200, 0, 5000));
        explosionSpawn4.ease = explosionSpawn4.add(new EnumSetting<Easing>(Timer.ALLATORIxDEMO("aH\u001d\u0006"), Easing.CubicInOut));
        explosionSpawn3.timer = new Timer();
        explosionSpawn3.setChinese(WebUtils.ALLATORIxDEMO("\u000e?s1s\u6c67\u666c\u6570\u7f69\u727d\u6505"));
        INSTANCE = explosionSpawn3;
    }

    public static class Pos {
        public final FadeUtils fadeTime;
        public final FadeUtils time;
        public final FadeUtils firstFade;
        public final class_243 pos;

        /*
         * WARNING - void declaration
         */
        public Pos(class_243 class_2432, int n, int n2, int n3) {
            Pos a;
            void a2;
            void a3;
            void a4;
            void a5;
            int n4 = n3;
            Pos pos = a = this;
            Pos pos2 = a;
            pos2.firstFade = new FadeUtils((long)a4);
            pos.time = new FadeUtils((long)a2);
            pos.fadeTime = new FadeUtils((long)a3);
            pos.pos = a5;
        }
    }

}
