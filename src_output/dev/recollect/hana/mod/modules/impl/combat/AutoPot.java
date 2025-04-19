/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1661
 *  net.minecraft.class_1753
 *  net.minecraft.class_1764
 *  net.minecraft.class_1779
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1803
 *  net.minecraft.class_1828
 *  net.minecraft.class_1835
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4048
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.asm.accessors.IEntity;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1661;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1779;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1803;
import net.minecraft.class_1828;
import net.minecraft.class_1835;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4048;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoPot
extends Module {
    public final SliderSetting effectRange;
    private final SliderSetting pitch;
    private final SliderSetting predictTicks;
    private final BooleanSetting inventory;
    public final SliderSetting delay;
    public final SliderSetting health;
    private final BooleanSetting hcehck;
    private final Timer timer;
    public final BooleanSetting debug;
    private final BooleanSetting rotate;

    private /* synthetic */ float getDistance(class_1792 class_17922) {
        AutoPot a = class_17922;
        AutoPot a2 = this;
        if (a instanceof class_1753) {
            return 1.0f;
        }
        return 0.4f;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ class_243 calcTrajectory(class_1792 class_17922, float f, float f2) {
        float f3;
        float a;
        void a2;
        AutoPot autoPot;
        float f4;
        float a32 = f;
        AutoPot a4 = this;
        double d = MathUtil.interpolate(AutoPot.mc.field_1724.field_6014, AutoPot.mc.field_1724.method_23317(), mc.method_1488());
        double d2 = MathUtil.interpolate(AutoPot.mc.field_1724.field_6036, AutoPot.mc.field_1724.method_23318(), mc.method_1488());
        double d3 = MathUtil.interpolate(AutoPot.mc.field_1724.field_5969, AutoPot.mc.field_1724.method_23321(), mc.method_1488());
        d2 = d2 + (double)AutoPot.mc.field_1724.method_18381(AutoPot.mc.field_1724.method_18376()) - 0.1000000014901161;
        d -= (double)(class_3532.method_15362((float)(a32 / 180.0f * 3.1415927f)) * 0.16f);
        d3 -= (double)(class_3532.method_15374((float)(a32 / 180.0f * 3.1415927f)) * 0.16f);
        float f5 = a4.getDistance((class_1792)a2);
        double d4 = -class_3532.method_15374((float)(a32 / 180.0f * 3.1415927f)) * class_3532.method_15362((float)(a / 180.0f * 3.1415927f)) * f5;
        double d5 = -class_3532.method_15374((float)((a - (float)a4.getThrowPitch((class_1792)a2)) / 180.0f * 3.141593f)) * f5;
        double d6 = class_3532.method_15362((float)(a32 / 180.0f * 3.1415927f)) * class_3532.method_15362((float)(a / 180.0f * 3.1415927f)) * f5;
        a32 = (float)AutoPot.mc.field_1724.method_6048() / 20.0f;
        a32 = (a32 * a32 + a32 * 2.0f) / 3.0f;
        if (f3 > 1.0f) {
            a32 = 1.0f;
        }
        double d7 = d4;
        double d8 = d5;
        double d9 = d6;
        a = class_3532.method_15355((float)((float)(d7 * d7 + d8 * d8 + d9 * d9)));
        d4 /= (double)a;
        d5 /= (double)a;
        d6 /= (double)a;
        if (a2 instanceof class_1753) {
            f4 = a32 * 2.0f;
            autoPot = a4;
        } else if (a2 instanceof class_1764) {
            f4 = 2.2f;
            autoPot = a4;
        } else {
            f4 = 1.0f;
            autoPot = a4;
        }
        a32 = f4 * autoPot.getThrowVelocity((class_1792)a2);
        d4 *= (double)a32;
        d5 *= (double)a32;
        d6 *= (double)a32;
        if (!AutoPot.mc.field_1724.method_24828()) {
            d5 += AutoPot.mc.field_1724.method_18798().method_10214();
        }
        int n = a = 0;
        while (n < 300) {
            void v7;
            class_243 a32 = new class_243(d, d2, d3);
            if (AutoPot.mc.field_1687.method_8320(new class_2338((int)(d += d4), (int)(d2 += d5), (int)(d3 += d6))).method_26204() == class_2246.field_10382) {
                d4 *= 0.8;
                d5 *= 0.8;
                d6 *= 0.8;
                v7 = a2;
            } else {
                d4 *= 0.99;
                d5 *= 0.99;
                d6 *= 0.99;
                v7 = a2;
            }
            d5 = v7 instanceof class_1753 ? (d5 -= 0.05000000074505806) : (AutoPot.mc.field_1724.method_6047().method_7909() instanceof class_1764 ? (d5 -= 0.05000000074505806) : (d5 -= 0.029999999329447746));
            class_243 class_2432 = new class_243(d, d2, d3);
            a32 = AutoPot.mc.field_1687.method_17742(new class_3959(a32, class_2432, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)AutoPot.mc.field_1724));
            if (a32 != null && a32.method_17783() == class_239.class_240.field_1332) {
                return a32.method_17784();
            }
            n = ++a;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a4 = f;
        AutoPot a2 = this;
        if (a2.debug.getValue()) {
            void a3;
            AutoPot autoPot = a2;
            class_243 a4 = autoPot.calcTrajectory(class_1802.field_8436, Hana.ROTATE.rotateYaw, autoPot.pitch.getValueFloat());
            void v1 = a3;
            Render3DUtil.draw3DBox((class_4587)v1, new class_238((class_2338)new BlockPosX(a4.field_1352, a4.field_1351, a4.field_1350)), new Color(255, 255, 255, 80));
            Render3DUtil.draw3DBox((class_4587)v1, ((IEntity)AutoPot.mc.field_1724).getDimensions().method_30757(AutoPot.mc.field_1724.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)AutoPot.mc.field_1724, a2.predictTicks.getValueInt(), true))).method_1009(0.0, 0.1, 0.0), new Color(0, 255, 255, 80), false, true);
        }
    }

    private /* synthetic */ void doPot() {
        AutoPot a22;
        AutoPot autoPot = a22;
        int n = AutoPot.mc.field_1724.method_31548().field_7545;
        int a22 = autoPot.findPot(class_1294.field_5907);
        if (a22 == -1) {
            CommandManager.sendChatMessage(ColorUtil.ALLATORIxDEMO("\u00a0#]z@Dl4=\u0010i$4sDD4h.b"));
            autoPot.disable();
            return;
        }
        AutoPot autoPot2 = autoPot;
        autoPot2.timer.reset();
        autoPot.doSwap(a22);
        if (autoPot2.rotate.getValue()) {
            EntityUtil.sendYawAndPitch(Hana.ROTATE.rotateYaw, autoPot.pitch.getValueFloat());
        }
        AutoPot.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, EntityUtil.getWorldActionId(AutoPot.mc.field_1687)));
        if (autoPot.inventory.getValue()) {
            autoPot.doSwap(a22);
            EntityUtil.syncInventory();
            return;
        }
        autoPot.doSwap(n);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoPot a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AutoPot.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public AutoPot() {
        AutoPot a;
        AutoPot autoPot = a;
        super(NpSocketClient.ALLATORIxDEMO("\u0006M\fh\u0017s("), Module.Category.Combat);
        AutoPot autoPot2 = a;
        autoPot2.rotate = autoPot.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u000ft4g~)"), true).setParent());
        autoPot.pitch = autoPot.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("(n34"), 86, 80, 90, object -> {
            Object a = object;
            AutoPot a2 = this;
            return a2.rotate.isOpen();
        }));
        AutoPot autoPot3 = a;
        autoPot3.inventory = autoPot3.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("Of88u.s/b\u0013qk<"), true));
        autoPot3.delay = autoPot3.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("<b+}%"), 1050, 0, 2000));
        autoPot3.hcehck = autoPot3.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u00068z6h5X(ci'"), false).setParent());
        autoPot3.health = autoPot3.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("p\u001df+h4"), 20, 0, 36, object -> {
            Object a = object;
            AutoPot a2 = this;
            return a2.hcehck.isOpen();
        }).setSuffix(ColorUtil.ALLATORIxDEMO("B\u001c")));
        AutoPot autoPot4 = a;
        autoPot4.effectRange = autoPot4.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\u0018z:b$L*f){9"), 3.0, 0.0, 6.0, 0.1));
        autoPot4.predictTicks = autoPot4.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("L/~$oi8"), 2, 0, 10).setSuffix(NpSocketClient.ALLATORIxDEMO("\fn$w/")));
        a.debug = autoPot4.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("%d+"), false));
        a.timer = new Timer();
        a.setChinese(NpSocketClient.ALLATORIxDEMO("\u81ed\u52ef\u8373\u6c68"));
    }

    private /* synthetic */ float getThrowVelocity(class_1792 class_17922) {
        AutoPot a = class_17922;
        AutoPot a2 = this;
        if (a instanceof class_1828 || a instanceof class_1803) {
            return 0.5f;
        }
        if (a instanceof class_1779) {
            return 0.59f;
        }
        if (a instanceof class_1835) {
            return 2.0f;
        }
        return 1.5f;
    }

    public int findPot(class_1291 class_12912) {
        AutoPot a = class_12912;
        AutoPot a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findPotInventorySlot((class_1291)a);
        }
        return InventoryUtil.findPot((class_1291)a);
    }

    @Override
    public void onUpdate() {
        Object a;
        AutoPot autoPot;
        AutoPot autoPot2 = autoPot = a;
        if (!autoPot2.timer.passedMs(autoPot2.delay.getValueInt())) {
            return;
        }
        if (autoPot.hcehck.getValue() && (double)(AutoPot.mc.field_1724.method_6032() + AutoPot.mc.field_1724.method_6067()) >= autoPot.health.getValue()) {
            return;
        }
        AutoPot autoPot3 = autoPot;
        if (AutoPot.mc.field_1724.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)AutoPot.mc.field_1724, autoPot.predictTicks.getValueInt(), true)).method_1025(autoPot3.calcTrajectory(class_1802.field_8436, Hana.ROTATE.rotateYaw, autoPot3.pitch.getValueFloat())) > autoPot.effectRange.getValue()) {
            return;
        }
        for (class_1293 class_12932 : new ArrayList(AutoPot.mc.field_1724.method_6026())) {
            if (class_12932.method_5579() != class_1294.field_5907 || class_12932.method_5578() + 1 <= 1) continue;
            return;
        }
        autoPot.doPot();
    }

    private /* synthetic */ int getThrowPitch(class_1792 class_17922) {
        AutoPot a = class_17922;
        AutoPot a2 = this;
        if (a instanceof class_1828 || a instanceof class_1803 || a instanceof class_1779) {
            return 20;
        }
        return 0;
    }

    @Override
    public String getInfo() {
        return String.valueOf(InventoryUtil.getPotCount(class_1294.field_5907));
    }
}
