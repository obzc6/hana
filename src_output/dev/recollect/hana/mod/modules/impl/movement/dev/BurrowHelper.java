/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
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
package dev.recollect.hana.mod.modules.impl.movement.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Animation;
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
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import java.awt.Color;
import java.util.Objects;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
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
import org.lwjgl.opengl.GL11;

public class BurrowHelper
extends Module {
    private final BooleanSetting tower;
    private class_2338 pos;
    private final BooleanSetting onlyObi;
    private final Timer towerTimer;
    private float[] angle;
    private final Timer timer;
    private final BooleanSetting rotate;
    private final BooleanSetting esp;
    private static class_243 lastVec3d;
    public final SliderSetting sliderSpeed;
    public final SliderSetting rotateTime;
    public final ColorSetting color;
    private final BooleanSetting outline;
    private final BooleanSetting render;
    private final BooleanSetting box;

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        BurrowHelper a2 = this;
        if (a2.render.getValue()) {
            void a3;
            if (a2.esp.getValue()) {
                double d;
                GL11.glEnable((int)3042);
                double d2 = 0.01;
                double d3 = d = 0.0;
                while (d3 < 0.8) {
                    HoleSnap.doCircle((class_4587)a3, ColorUtil.injectAlpha(a2.color.getValue(), (int)Math.min((double)(a2.color.getValue().getAlpha() * 2) / (0.8 / d2), 255.0)), d, new class_243(MathUtil.interpolate(Objects.requireNonNull(BurrowHelper.mc.field_1724).field_6038, BurrowHelper.mc.field_1724.method_23317(), a), MathUtil.interpolate(BurrowHelper.mc.field_1724.field_5971, BurrowHelper.mc.field_1724.method_23318(), a), MathUtil.interpolate(BurrowHelper.mc.field_1724.field_5989, BurrowHelper.mc.field_1724.method_23321(), a)), 5);
                    d3 = d + d2;
                }
                RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3042);
            }
            if (a2.pos != null) {
                class_243 class_2432 = a2.pos.method_46558();
                lastVec3d = lastVec3d == null ? class_2432 : new class_243(AnimateUtil.animate(lastVec3d.method_10216(), class_2432.field_1352, a2.sliderSpeed.getValue()), AnimateUtil.animate(lastVec3d.method_10214(), class_2432.field_1351, a2.sliderSpeed.getValue()), AnimateUtil.animate(lastVec3d.method_10215(), class_2432.field_1350, a2.sliderSpeed.getValue()));
                Render3DUtil.draw3DBox((class_4587)a3, new class_238(lastVec3d.method_1031(0.5, 0.5, 0.5), lastVec3d.method_1031(-0.5, -0.5, -0.5)), ColorUtil.injectAlpha(a2.color.getValue(), a2.color.getValue().getAlpha()), a2.outline.getValue(), a2.box.getValue());
            }
        }
    }

    @EventHandler(priority=100)
    public void onRotation(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        BurrowHelper a2 = this;
        if (a2.rotate.getValue()) {
            BurrowHelper burrowHelper = a2;
            if (!burrowHelper.timer.passedMs(burrowHelper.rotateTime.getValueInt()) && a2.angle != null) {
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

    public BurrowHelper() {
        BurrowHelper a;
        BurrowHelper burrowHelper = a;
        super(Animation.ALLATORIxDEMO("IETo@c{mJmTx"), Module.Category.Player);
        BurrowHelper burrowHelper2 = a;
        burrowHelper2.onlyObi = burrowHelper.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("_\u0005`\u0007V\u000bg"), true));
        burrowHelper.tower = burrowHelper.add(new BooleanSetting(Animation.ALLATORIxDEMO("\\IjTx"), true));
        burrowHelper.rotate = burrowHelper.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("9c\nx\u001dk"), false));
        burrowHelper.rotateTime = burrowHelper.add(new SliderSetting(Animation.ALLATORIxDEMO("XUTkJfagR|Eo"), 1000.0, 0.0, 3000.0, 10.0));
        burrowHelper.render = burrowHelper.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("9i\u0010}\f|"), true).setParent());
        burrowHelper.color = burrowHelper.add(new ColorSetting(Animation.ALLATORIxDEMO("KIq^x"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            BurrowHelper a2 = this;
            return a2.render.isOpen();
        }));
        a.esp = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\\:^"), true, object -> {
            Object a = object;
            BurrowHelper a2 = this;
            return a2.render.isOpen();
        }));
        a.box = a.add(new BooleanSetting(Animation.ALLATORIxDEMO("_^r"), true, object -> {
            Object a = object;
            BurrowHelper a2 = this;
            return a2.render.isOpen();
        }));
        a.outline = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("_\u001ex\u0012p\u0007k"), true, object -> {
            Object a = object;
            BurrowHelper a2 = this;
            return a2.render.isOpen();
        }));
        a.sliderSpeed = a.add(new SliderSetting(Animation.ALLATORIxDEMO("cJtKqA[VxTn"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            BurrowHelper a2 = this;
            return a2.render.isOpen();
        }));
        a.timer = new Timer();
        a.angle = null;
        a.towerTimer = new Timer();
        a.setChinese(PacketBuffer.ALLATORIxDEMO("\u57b5\u8103\u8fec\u52a7"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        BurrowHelper a;
        BurrowHelper burrowHelper;
        int n;
        BurrowHelper burrowHelper2 = a;
        int n2 = n = burrowHelper2.onlyObi.getValue() ? InventoryUtil.findItem(class_1802.field_8281) : InventoryUtil.findBlock();
        if (n == -1) {
            return;
        }
        a = EntityUtil.getPlayerPos().method_10074();
        if (!BlockUtil.clientCanPlace((class_2338)a, false)) return;
        int n3 = Objects.requireNonNull(BurrowHelper.mc.field_1724).method_31548().field_7545;
        if (BlockUtil.getPlaceSide((class_2338)a) == null) {
            int n4;
            double d = 1000.0;
            class_2338 class_23382 = null;
            class_2350[] arrclass_2350 = class_2350.values();
            int n5 = arrclass_2350.length;
            int n6 = n4 = 0;
            while (n6 < n5) {
                class_2350 class_23502 = arrclass_2350[n4];
                if (class_23502 != class_2350.field_11036 && BlockUtil.canPlace(a.method_10093(class_23502)) && (class_23382 == null || BurrowHelper.mc.field_1724.method_5707(a.method_10093(class_23502).method_46558()) < d)) {
                    class_23382 = a.method_10093(class_23502);
                    d = BurrowHelper.mc.field_1724.method_5707(a.method_10093(class_23502).method_46558());
                }
                n6 = ++n4;
            }
            if (class_23382 == null) return;
            a = class_23382;
            burrowHelper = burrowHelper2;
        } else {
            burrowHelper = burrowHelper2;
        }
        if (burrowHelper.rotate.getValue()) {
            class_2350 class_23503 = BlockUtil.getPlaceSide((class_2338)a);
            burrowHelper2.angle = EntityUtil.getLegitRotations(a.method_10093(class_23503).method_46558().method_1031((double)class_23503.method_10153().method_10163().method_10263() * 0.5, (double)class_23503.method_10153().method_10163().method_10264() * 0.5, (double)class_23503.method_10153().method_10163().method_10260() * 0.5));
            burrowHelper2.timer.reset();
        }
        InventoryUtil.switchToSlot(n);
        BurrowHelper burrowHelper3 = burrowHelper2;
        BlockUtil.placeBlock((class_2338)a, burrowHelper3.rotate.getValue(), false);
        InventoryUtil.switchToSlot(n3);
        burrowHelper2.pos = a;
        if (burrowHelper3.tower.getValue() && BurrowHelper.mc.field_1690.field_1903.method_1434() && !MovementUtil.isMoving()) {
            MovementUtil.setMotionY(0.42);
            MovementUtil.setMotionX(0.0);
            MovementUtil.setMotionZ(0.0);
            if (!burrowHelper2.towerTimer.passedMs(1500L)) return;
            MovementUtil.setMotionY(-0.28);
            burrowHelper2.towerTimer.reset();
            return;
        }
        burrowHelper2.towerTimer.reset();
    }
}
