/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4050
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.asm.accessors.IPlayerMoveC2SPacket;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4050;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class RotateManager
implements Wrapper {
    public float lastPitch;
    private static float prevRenderYawOffset;
    public float rotatePitch;
    public float rotateYaw;
    private static float prevPitch;
    private static float rotationYawHead;
    private static float prevRotationYawHead;
    public static class_243 directionVec;
    public float lastYaw;
    private int ticksExisted;
    private static float renderYawOffset;
    public static final Timer ROTATE_TIMER;
    public static UpdateWalkingEvent lastEvent;
    private static float renderPitch;

    public static float getPrevRotationYawHead() {
        return prevRotationYawHead;
    }

    public static float getPrevPitch() {
        return prevPitch;
    }

    public RotateManager() {
        RotateManager a;
        RotateManager rotateManager = a;
        RotateManager rotateManager2 = a;
        rotateManager2.rotateYaw = 0.0f;
        rotateManager2.rotatePitch = 0.0f;
        rotateManager.lastYaw = 0.0f;
        rotateManager.lastPitch = 0.0f;
        Hana.EVENT_BUS.subscribe(a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float getRenderYawOffset(float f, float f2) {
        float f3;
        void a;
        void a2;
        void v3;
        RotateManager rotateManager = this;
        float f4 = a2;
        double d = RotateManager.mc.field_1724.method_23317() - RotateManager.mc.field_1724.field_6014;
        double d2 = RotateManager.mc.field_1724.method_23321() - RotateManager.mc.field_1724.field_5969;
        double d3 = d;
        double d4 = d2;
        if (d3 * d3 + d4 * d4 > 0.002500000176951289) {
            float a3 = (float)class_3532.method_15349((double)d2, (double)d) * 57.295776f - 90.0f;
            float f5 = class_3532.method_15379((float)(class_3532.method_15393((float)a) - a3));
            f4 = 95.0f < f5 && f5 < 265.0f ? a3 - 180.0f : a3;
        }
        if (RotateManager.mc.field_1724.field_6251 > 0.0f) {
            f4 = a;
        }
        f4 = a2 + class_3532.method_15393((float)(f4 - a2)) * 0.3f;
        float a3 = class_3532.method_15393((float)(a - f4));
        if (f3 < -75.0f) {
            a3 = -75.0f;
            v3 = a;
        } else {
            if (a3 >= 75.0f) {
                a3 = 75.0f;
            }
            v3 = a;
        }
        f4 = v3 - a3;
        float f6 = a3;
        if (f6 * f6 > 2500.0f) {
            f4 += a3 * 0.2f;
        }
        return f4;
    }

    /*
     * WARNING - void declaration
     */
    public void setRotation(float f, float f2, boolean bl) {
        void a;
        void a2;
        float a3 = f;
        RotateManager a4 = this;
        if (RotateManager.mc.field_1724 == null) {
            return;
        }
        if (RotateManager.mc.field_1724.field_6012 == a4.ticksExisted && a2 == false) {
            return;
        }
        a4.ticksExisted = RotateManager.mc.field_1724.field_6012;
        prevPitch = renderPitch;
        prevRenderYawOffset = renderYawOffset;
        renderYawOffset = a4.getRenderYawOffset(a3, prevRenderYawOffset);
        prevRotationYawHead = rotationYawHead;
        rotationYawHead = a3;
        renderPitch = a;
    }

    public float[] getRotation(class_243 a) {
        RotateManager a2;
        RotateManager rotateManager = a2;
        a2 = EntityUtil.getEyesPos();
        return rotateManager.getRotation((class_243)a2, a);
    }

    @EventHandler(priority=-200)
    public void onPacketSend(PacketEvent.Send a) {
        class_2828 class_28282;
        RotateManager a22;
        RotateManager rotateManager = a22;
        if (RotateManager.mc.field_1724 == null || a.isCancelled()) {
            return;
        }
        if (!EntityUtil.rotating && CombatSetting.INSTANCE.rotateSync.getValue() && (a22 = a.getPacket()) instanceof class_2828) {
            class_28282 = (class_2828)a22;
            if (!class_28282.method_36172()) {
                return;
            }
            class_2828 class_28283 = class_28282;
            float a22 = class_28283.method_12271(114514.0f);
            float f = class_28283.method_12270(114514.0f);
            if (a22 == RotateManager.mc.field_1724.method_36454() && f == RotateManager.mc.field_1724.method_36455()) {
                ((IPlayerMoveC2SPacket)a.getPacket()).setYaw(rotateManager.rotateYaw);
                ((IPlayerMoveC2SPacket)a.getPacket()).setPitch(rotateManager.rotatePitch);
            }
        }
        if ((a22 = a.getPacket()) instanceof class_2828) {
            class_28282 = (class_2828)a22;
            if (!class_28282.method_36172()) {
                return;
            }
            RotateManager rotateManager2 = rotateManager;
            rotateManager.lastYaw = class_28282.method_12271(rotateManager.lastYaw);
            rotateManager.lastPitch = class_28282.method_12270(rotateManager2.lastPitch);
            rotateManager.setRotation(rotateManager2.lastYaw, rotateManager.lastPitch, false);
        }
    }

    public String getDirection4D(boolean a) {
        RotateManager a22;
        RotateManager rotateManager = a22;
        int a22 = rotateManager.getYaw4D();
        if (a22 == 0) {
            return TimerManager.ALLATORIxDEMO("*$\n9\u0016l\f=\u000eO");
        }
        if (a22 == 1) {
            return Tab.ALLATORIxDEMO(";l\u0019|Kz\u001czh");
        }
        if (a22 == 2) {
            return (a ? TimerManager.ALLATORIxDEMO("\u00d4\u00f3\u0005") : "") + "North (-Z)";
        }
        if (a22 == 3) {
            return Tab.ALLATORIxDEMO(")h\u0019|Kz\u001azh");
        }
        return TimerManager.ALLATORIxDEMO("5$\u001e)\u0017\"C8zH");
    }

    public void snapBack() {
        mc.method_1562().method_52787((class_2596)new class_2828.class_2830(RotateManager.mc.field_1724.method_23317(), RotateManager.mc.field_1724.method_23318(), RotateManager.mc.field_1724.method_23321(), Hana.ROTATE.rotateYaw, Hana.ROTATE.rotatePitch, RotateManager.mc.field_1724.method_24828()));
    }

    @EventHandler(priority=100)
    public void onReceivePacket(PacketEvent.Receive receive) {
        Object a = receive;
        RotateManager a2 = this;
        Object t = ((PacketEvent)a).getPacket();
        if (t instanceof class_2708) {
            a = (class_2708)t;
            a2.lastYaw = a.method_11736();
            a2.lastPitch = a.method_11739();
            RotateManager rotateManager = a2;
            rotateManager.setRotation(a2.lastYaw, rotateManager.lastPitch, true);
        }
    }

    public static float getPrevRenderYawOffset() {
        return prevRenderYawOffset;
    }

    /*
     * WARNING - void declaration
     */
    public boolean inFov(float f, float f2, float f3) {
        void a;
        void a2;
        float a3 = f3;
        RotateManager a4 = this;
        return class_3532.method_15356((float)a, (float)a4.rotateYaw) + Math.abs((float)(a2 - a4.rotatePitch)) <= a3;
    }

    public int getYaw4D() {
        return class_3532.method_15357((double)((double)(RotateManager.mc.field_1724.method_36454() * 4.0f / 360.0f) + 0.5)) & 3;
    }

    /*
     * WARNING - void declaration
     */
    public boolean inFov(class_243 class_2432, float f) {
        float[] a;
        void a2;
        float[] a3 = class_2432;
        float[] arrf = a = this;
        a3 = arrf.getRotation(new class_243(RotateManager.mc.field_1724.method_23317(), RotateManager.mc.field_1724.method_23318() + (double)RotateManager.mc.field_1724.method_18381(RotateManager.mc.field_1724.method_18376()), RotateManager.mc.field_1724.method_23321()), (class_243)a3);
        return arrf.inFov(a3[0], a3[1], (float)a2);
    }

    public static float getRenderYawOffset() {
        return renderYawOffset;
    }

    public static float getRenderPitch() {
        return renderPitch;
    }

    public static float getRotationYawHead() {
        return rotationYawHead;
    }

    @EventHandler
    public void onUpdateWalkingPost(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        RotateManager a2 = this;
        if (a.getStage() == Event.Stage.Post) {
            RotateManager rotateManager = a2;
            rotateManager.setRotation(a2.lastYaw, rotateManager.lastPitch, false);
        }
    }

    /*
     * WARNING - void declaration
     */
    public float[] getRotation(class_243 class_2432, class_243 class_2433) {
        void a32;
        RotateManager a22 = class_2432;
        RotateManager a = this;
        void v0 = a32;
        double d = v0.field_1352 - ((class_243)a22).field_1352;
        double d2 = v0.field_1351 - ((class_243)a22).field_1351;
        double d3 = v0.field_1350 - ((class_243)a22).field_1350;
        double d4 = d;
        double d5 = d3;
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        float a22 = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float a32 = (float)(-Math.toDegrees(Math.atan2(d2, d6)));
        float[] arrf = new float[2];
        arrf[0] = class_3532.method_15393((float)a22);
        arrf[1] = class_3532.method_15393((float)a32);
        return arrf;
    }

    static {
        ROTATE_TIMER = new Timer();
        directionVec = null;
    }

    @EventHandler(priority=101)
    public void onRotation(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (RotateManager.mc.field_1724 == null) {
            return;
        }
        if (directionVec != null && !ROTATE_TIMER.passed((long)(CombatSetting.INSTANCE.rotateTime.getValue() * 1000.0))) {
            a2 = EntityUtil.getLegitRotations(directionVec);
            RotateEvent rotateEvent = a;
            rotateEvent.setYaw(a2[0]);
            rotateEvent.setPitch(a2[1]);
        }
    }
}
