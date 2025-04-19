/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1661
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.movement;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_4587;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;
import org.lwjgl.opengl.GL11;

public class Scaffold
extends Module {
    public final SliderSetting rotateTime;
    private class_2338 pos;
    private final Timer towerTimer;
    private final Timer timer;
    private final BooleanSetting airCheck;
    public final SliderSetting sliderSpeed;
    private float[] angle;
    private final BooleanSetting rotate;
    private final BooleanSetting render;
    private static class_243 lastVec3d;
    private final BooleanSetting outline;
    private final BooleanSetting tower;
    public final SliderSetting yCheck;
    private final BooleanSetting box;
    private final BooleanSetting sameY;
    public final ColorSetting color;
    private final BooleanSetting esp;
    private final BooleanSetting down;

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        Scaffold a2 = this;
        if (a2.render.getValue()) {
            void a3;
            if (a2.esp.getValue()) {
                double d;
                GL11.glEnable((int)3042);
                double d2 = 0.01;
                double d3 = d = 0.0;
                while (d3 < 0.8) {
                    double d4 = d;
                    HoleSnap.doCircle((class_4587)a3, ColorUtil.injectAlpha(a2.color.getValue(), (int)Math.min((double)(a2.color.getValue().getAlpha() * 2) / (0.8 / d2), 255.0)), d4, new class_243(MathUtil.interpolate(Scaffold.mc.field_1724.field_6038, Scaffold.mc.field_1724.method_23317(), a), MathUtil.interpolate(Scaffold.mc.field_1724.field_5971, Scaffold.mc.field_1724.method_23318(), a), MathUtil.interpolate(Scaffold.mc.field_1724.field_5989, Scaffold.mc.field_1724.method_23321(), a)), 5);
                    d3 = d4 + d2;
                }
                RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3042);
            }
            if (a2.pos != null) {
                void v2;
                class_243 class_2432 = a2.pos.method_46558();
                if (lastVec3d == null) {
                    v2 = a3;
                    lastVec3d = class_2432;
                } else {
                    lastVec3d = new class_243(AnimateUtil.animate(lastVec3d.method_10216(), class_2432.field_1352, a2.sliderSpeed.getValue()), AnimateUtil.animate(lastVec3d.method_10214(), class_2432.field_1351, a2.sliderSpeed.getValue()), AnimateUtil.animate(lastVec3d.method_10215(), class_2432.field_1350, a2.sliderSpeed.getValue()));
                    v2 = a3;
                }
                Render3DUtil.draw3DBox((class_4587)v2, new class_238(lastVec3d.method_1031(0.5, 0.5, 0.5), lastVec3d.method_1031(-0.5, -0.5, -0.5)), ColorUtil.injectAlpha(a2.color.getValue(), a2.color.getValue().getAlpha()), a2.outline.getValue(), a2.box.getValue());
            }
        }
    }

    @EventHandler(priority=100)
    public void onRotation(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        Scaffold a2 = this;
        if (a2.rotate.getValue()) {
            Scaffold scaffold = a2;
            if (!scaffold.timer.passedMs(scaffold.rotateTime.getValueInt()) && a2.angle != null) {
                Object object = a;
                ((RotateEvent)object).setYaw(a2.angle[0]);
                ((RotateEvent)object).setPitch(a2.angle[1]);
            }
        }
    }

    @Override
    public void onEnable() {
        lastVec3d = null;
        a.pos = null;
    }

    public Scaffold() {
        Scaffold a;
        Scaffold scaffold = a;
        super(HoleUtils.ALLATORIxDEMO("r}IqM{Ox"), Module.Category.Movement);
        Scaffold scaffold2 = a;
        scaffold2.tower = scaffold.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0007U9\u0015v"), true));
        scaffold.rotate = scaffold.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("zx_uWy"), false));
        scaffold.rotateTime = scaffold.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("l6E$u<N/\u0004a"), 1000.0, 0.0, 3000.0, 10.0));
        scaffold.render = scaffold.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("zrEpFn"), true).setParent());
        scaffold.color = scaffold.add(new ColorSetting(BaseChildSettings.ALLATORIxDEMO("\u0010U\"\u001fv"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.render.isOpen();
        }));
        a.esp = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("QpL"), true, object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.render.isOpen();
        }));
        a.box = a.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\f\u001f|"), true, object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.render.isOpen();
        }));
        a.outline = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("Q]cG}My"), true, object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.render.isOpen();
        }));
        a.sliderSpeed = a.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("UK:D1U\u0000J+\u0015`"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.render.isOpen();
        }));
        Scaffold scaffold3 = a;
        scaffold3.sameY = scaffold3.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("dJyFE"), false).setParent());
        scaffold3.yCheck = scaffold3.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("~\u0010R+\u0013o"), 2.5, 2.5, 12.0, object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.sameY.getValue();
        }));
        a.airCheck = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("`wZTCq@w"), true, object -> {
            Object a = object;
            Scaffold a2 = this;
            return a2.sameY.getValue();
        }));
        a.down = a.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("~!\u0007j"), true));
        a.timer = new Timer();
        a.angle = null;
        a.towerTimer = new Timer();
        a.setChinese(HoleUtils.ALLATORIxDEMO("\u81c1\u52bc\u640e\u8df3"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        Scaffold a;
        Scaffold scaffold = a;
        int n = InventoryUtil.findBlock();
        if (n == -1) {
            return;
        }
        a = EntityUtil.getPlayerPos().method_10074();
        if (BlockUtil.clientCanPlace((class_2338)a, false)) {
            Scaffold scaffold2;
            int n2 = Scaffold.mc.field_1724.method_31548().field_7545;
            if (BlockUtil.getPlaceSide((class_2338)a) == null) {
                int n3;
                double d = 1000.0;
                class_2338 class_23382 = null;
                class_2350[] arrclass_2350 = class_2350.values();
                int n4 = arrclass_2350.length;
                int n5 = n3 = 0;
                while (n5 < n4) {
                    class_2350 class_23502 = arrclass_2350[n3];
                    if (class_23502 != class_2350.field_11036 && BlockUtil.canPlace(a.method_10093(class_23502)) && (class_23382 == null || Scaffold.mc.field_1724.method_5707(a.method_10093(class_23502).method_46558()) < d)) {
                        class_23382 = a.method_10093(class_23502);
                        d = Scaffold.mc.field_1724.method_5707(a.method_10093(class_23502).method_46558());
                    }
                    n5 = ++n3;
                }
                if (class_23382 == null) return;
                a = class_23382;
                scaffold2 = scaffold;
            } else {
                scaffold2 = scaffold;
            }
            if (scaffold2.rotate.getValue()) {
                class_2350 class_23503 = BlockUtil.getPlaceSide((class_2338)a);
                scaffold.angle = EntityUtil.getLegitRotations(a.method_10093(class_23503).method_46558().method_1031((double)class_23503.method_10153().method_10163().method_10263() * 0.5, (double)class_23503.method_10153().method_10163().method_10264() * 0.5, (double)class_23503.method_10153().method_10163().method_10260() * 0.5));
                scaffold.timer.reset();
            }
            InventoryUtil.switchToSlot(n);
            Scaffold scaffold3 = scaffold;
            BlockUtil.placeBlock((class_2338)a, scaffold3.rotate.getValue(), false);
            InventoryUtil.switchToSlot(n2);
            scaffold.pos = a;
            if (scaffold3.tower.getValue() && Scaffold.mc.field_1690.field_1903.method_1434() && !MovementUtil.isMoving()) {
                MovementUtil.setMotionY(0.42);
                MovementUtil.setMotionX(0.0);
                MovementUtil.setMotionZ(0.0);
                if (scaffold.towerTimer.passedMs(1500L)) {
                    MovementUtil.setMotionY(-0.28);
                    scaffold.towerTimer.reset();
                }
            } else {
                scaffold.towerTimer.reset();
            }
        }
        class_2338 class_23383 = null;
        if (BlockUtil.clientCanPlace(!scaffold.sameY.getValue() || Scaffold.mc.field_1724.method_23318() - (double)scaffold.pos.method_10264() > (double)scaffold.yCheck.getValueInt() || scaffold.airCheck.getValue() && !BlockUtil.canReplace(new class_2338((int)Scaffold.mc.field_1724.method_23317(), (int)(Scaffold.mc.field_1724.method_23318() - 1.0), (int)Scaffold.mc.field_1724.method_23321())) || MovementUtil.isJumping() && !MovementUtil.isMoving() || new class_2338((int)Scaffold.mc.field_1724.method_23317(), (int)(Scaffold.mc.field_1724.method_23318() - 1.0), (int)Scaffold.mc.field_1724.method_23321()).method_10264() < scaffold.pos.method_10264() ? (class_23383 = new class_2338((int)Scaffold.mc.field_1724.method_23317(), (int)(Scaffold.mc.field_1724.method_23318() - 1.0), (int)Scaffold.mc.field_1724.method_23321())) : (class_23383 = new class_2338((int)Scaffold.mc.field_1724.method_23317(), scaffold.pos.method_10264(), (int)Scaffold.mc.field_1724.method_23321())), false)) {
            scaffold.pos = class_23383;
        }
        if (!MovementUtil.isJumping()) {
            scaffold.timer.reset();
        }
        if (!scaffold.down.getValue() || !Scaffold.mc.field_1690.field_1894.method_1434()) return;
        Scaffold scaffold4 = scaffold;
        scaffold4.pos = new class_2338((int)Scaffold.mc.field_1724.method_23317(), (int)(Scaffold.mc.field_1724.method_23318() - 2.0), (int)Scaffold.mc.field_1724.method_23321());
    }
}
