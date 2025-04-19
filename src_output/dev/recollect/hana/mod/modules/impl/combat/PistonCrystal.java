/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_2753
 *  net.minecraft.class_2769
 *  net.minecraft.class_2824
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ThunderExplosionUtil;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_2824;
import net.minecraft.class_2848;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class PistonCrystal
extends Module {
    private final SliderSetting placeRange;
    private final BooleanSetting rotate;
    private final SliderSetting stageSetting;
    private final BooleanSetting fire;
    private final BooleanSetting onlyGround;
    private final BooleanSetting inventory;
    public boolean getPos;
    private final BooleanSetting checkLook;
    private final BooleanSetting newRotate;
    private float lastYaw;
    private final SliderSetting crystalStage;
    private final SliderSetting range;
    private class_1657 target;
    private final SliderSetting yawStep;
    private final SliderSetting pistonMaxStage;
    private final SliderSetting powerStage;
    public double distance;
    private final BooleanSetting switchPos;
    public static PistonCrystal INSTANCE;
    public class_2350 bestFacing;
    private float lastPitch;
    private final BooleanSetting endSwing;
    private final SliderSetting pistonStage;
    private final BooleanSetting packet;
    private final Timer crystalTimer;
    private final SliderSetting powerMaxStage;
    public final BooleanSetting yawDeceive;
    public class_2338 bestPos;
    private final BooleanSetting preferAnchor;
    public class_243 directionVec;
    private final BooleanSetting noEating;
    private final Timer timer;
    private final SliderSetting crystalMaxStage;
    private final BooleanSetting onlyStatic;
    private final BooleanSetting autoYaw;
    private final SliderSetting posUpdateDelay;
    public final EnumSetting<Page> page;
    public class_2338 bestOPos;
    private final BooleanSetting eatingBreak;
    public SliderSetting speed;
    private final BooleanSetting preferCrystal;
    private final SliderSetting updateDelay;
    private final SliderSetting fov;
    private final SliderSetting fireMaxStage;
    public int stage;
    private final BooleanSetting debug;
    private final SliderSetting fireStage;

    private /* synthetic */ boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.newRotate.getValue()) {
            RotateManager.lastEvent.cancelRotate();
            EntityUtil.faceVector((class_243)a);
            return true;
        }
        a2.directionVec = a;
        a = EntityUtil.getLegitRotations((class_243)a);
        if (Math.abs(class_3532.method_15393((float)(arrf[0] - a2.lastYaw))) < a2.fov.getValueFloat() && Math.abs(class_3532.method_15393((float)(a[1] - a2.lastPitch))) < a2.fov.getValueFloat()) {
            if (a2.packet.getValue()) {
                EntityUtil.sendYawAndPitch(a[0], a[1]);
            }
            return true;
        }
        return !a2.checkLook.getValue();
    }

    private static /* synthetic */ boolean canFire(class_2338 a) {
        if (BlockUtil.canReplace(a.method_10074())) {
            return false;
        }
        if (PistonCrystal.mc.field_1687 != null && !PistonCrystal.mc.field_1687.method_22347(a)) {
            return false;
        }
        if (!BlockUtil.canClick(a.method_10093(class_2350.field_11033))) {
            return false;
        }
        return BlockUtil.isStrictDirection(a.method_10074(), class_2350.field_11036);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void placeCrystal(class_2338 class_23382, class_2350 class_23502) {
        void a;
        void a2;
        PistonCrystal pistonCrystal = this;
        if (!BlockUtil.canPlaceCrystal(a2.method_10093((class_2350)a))) {
            return;
        }
        int n = pistonCrystal.findItem(class_1802.field_8301);
        if (n == -1) {
            return;
        }
        int a3 = 0;
        if (PistonCrystal.mc.field_1724 != null) {
            a3 = PistonCrystal.mc.field_1724.method_31548().field_7545;
        }
        PistonCrystal pistonCrystal2 = pistonCrystal;
        pistonCrystal2.doSwap(n);
        pistonCrystal2.placeCrystal(a2.method_10093((class_2350)a), pistonCrystal.rotate.getValue());
        PistonCrystal pistonCrystal3 = pistonCrystal;
        if (pistonCrystal.inventory.getValue()) {
            pistonCrystal3.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        pistonCrystal3.doSwap(a3);
    }

    /*
     * WARNING - void declaration
     */
    public void placeCrystal(class_2338 class_23382, boolean bl) {
        void a;
        PistonCrystal a2 = class_23382;
        PistonCrystal a3 = this;
        a2 = a2.method_10074();
        class_2350 class_23502 = BlockUtil.getClickSide((class_2338)a2);
        a3.clickBlock((class_2338)a2, class_23502, (boolean)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void getPos(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383) {
        void a;
        void a2;
        PistonCrystal a3 = class_23382;
        PistonCrystal a4 = this;
        if (PistonCrystal.mc.field_1687 != null && a4.switchPos.getValue() && a4.bestPos != null && a4.bestPos.equals((Object)a3) && PistonCrystal.mc.field_1687.method_22347(a4.bestPos)) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a3, a4.placeRange.getValue()) && !(a4.getBlock((class_2338)a3) instanceof class_2665)) {
            return;
        }
        if (a4.findClass(class_2665.class) == -1) {
            return;
        }
        if (!(a4.getBlock((class_2338)a3) instanceof class_2665)) {
            if (PistonCrystal.mc.field_1724 != null && (PistonCrystal.mc.field_1724.method_23318() - (double)a3.method_10264() <= -2.0 || PistonCrystal.mc.field_1724.method_23318() - (double)a3.method_10264() >= 3.0) && BlockUtil.distanceToXZ((double)a3.method_10263() + 0.5, (double)a3.method_10260() + 0.5) < 2.6) {
                return;
            }
            if (!a4.isTrueFacing((class_2338)a3, (class_2350)a2)) {
                return;
            }
        }
        if (!PistonCrystal.mc.field_1687.method_22347(a3.method_10079((class_2350)a2, -1)) || PistonCrystal.mc.field_1687.method_8320(a3.method_10079((class_2350)a2, -1)).method_26204() == class_2246.field_10036 || a4.getBlock(a3.method_10093(a2.method_10153())) == class_2246.field_10008 && !a4.checkCrystal2(a3.method_10093(a2.method_10153()))) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a3, a4.placeRange.getValue()) && !a4.isPiston((class_2338)a3, (class_2350)a2)) {
            return;
        }
        if (!((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(a3.method_46558()))) < a4.distance) && a4.bestPos != null) {
            return;
        }
        PistonCrystal pistonCrystal = a4;
        PistonCrystal pistonCrystal2 = a4;
        pistonCrystal2.bestPos = a3;
        pistonCrystal2.bestOPos = a;
        pistonCrystal.bestFacing = a2;
        pistonCrystal.distance = class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(a3.method_46558())));
        pistonCrystal.getPos = true;
        a4.crystalTimer.reset();
    }

    public int findClass(Class class_) {
        Class a = class_;
        PistonCrystal a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(a);
        }
        return InventoryUtil.findClass(a);
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.newRotate.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf.directionVec), arrf2.yawStep.getValueFloat());
            if (a2 != null) {
                arrf.lastYaw = a2[0];
            }
            if (a2 != null) {
                arrf.lastPitch = a2[1];
            }
            RotateEvent rotateEvent = a;
            float[] arrf3 = arrf;
            rotateEvent.setYaw(arrf3.lastYaw);
            rotateEvent.setPitch(arrf3.lastPitch);
            return;
        }
        float[] arrf4 = arrf;
        arrf4.lastYaw = Hana.ROTATE.lastYaw;
        arrf4.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ boolean checkCrystal2(class_2338 a) {
        Object a2;
        PistonCrystal pistonCrystal = a2;
        if (PistonCrystal.mc.field_1687 != null) {
            for (class_1297 class_12972 : PistonCrystal.mc.field_1687.method_18467(class_1297.class, new class_238(a))) {
                if (!(class_12972 instanceof class_1511) || !EntityUtil.getEntityPos(class_12972).equals((Object)a)) continue;
                return true;
            }
        }
        return false;
    }

    private /* synthetic */ boolean checkCrystal(class_2338 class_23382) {
        Object a = class_23382;
        PistonCrystal a2 = this;
        if (PistonCrystal.mc.field_1687 != null) {
            a = PistonCrystal.mc.field_1687.method_18467(class_1511.class, new class_238((class_2338)a)).iterator();
            while (a.hasNext()) {
                PistonCrystal pistonCrystal = a2;
                if (!(ThunderExplosionUtil.calculateDamage(((class_1297)a.next()).method_19538(), pistonCrystal.target, pistonCrystal.target, 6.0f) > 6.0f)) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doRedStone(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383) {
        int n;
        class_2350[] arrclass_2350;
        int n2;
        void a;
        void a2;
        class_2350 class_23503;
        PistonCrystal a3 = class_23382;
        PistonCrystal a4 = this;
        if (PistonCrystal.mc.field_1687 != null && !PistonCrystal.mc.field_1687.method_22347(a3.method_10079((class_2350)a2, -1)) && a4.getBlock(a3.method_10079((class_2350)a2, -1)) != class_2246.field_10036 && a4.getBlock(a3.method_10093(a2.method_10153())) != class_2246.field_10008) {
            return;
        }
        class_2350[] arrclass_23502 = class_2350.values();
        int n3 = arrclass_23502.length;
        int n4 = n = 0;
        while (n4 < n3) {
            arrclass_2350 = arrclass_23502[n];
            if (a4.getBlock(a3.method_10093((class_2350)arrclass_2350)) == class_2246.field_10002) {
                return;
            }
            n4 = ++n;
        }
        int n5 = a4.findBlock(class_2246.field_10002);
        if (n5 == -1) {
            return;
        }
        n3 = 0;
        if (PistonCrystal.mc.field_1724 != null) {
            n3 = PistonCrystal.mc.field_1724.method_31548().field_7545;
        }
        if ((class_23503 = BlockUtil.getBestNeighboring((class_2338)a3, (class_2350)a2)) != null && class_23503 != a2.method_10153() && BlockUtil.canPlace(a3.method_10093(class_23503), a4.placeRange.getValue()) && !a3.method_10093(class_23503).equals((Object)a)) {
            PistonCrystal pistonCrystal = a4;
            pistonCrystal.doSwap(n5);
            PistonCrystal pistonCrystal2 = a4;
            pistonCrystal.placeBlock(a3.method_10093(class_23503), pistonCrystal2.rotate.getValue(), a4.endSwing.getValue());
            PistonCrystal pistonCrystal3 = a4;
            if (pistonCrystal2.inventory.getValue()) {
                pistonCrystal3.doSwap(n5);
                EntityUtil.syncInventory();
                return;
            }
            pistonCrystal3.doSwap(n3);
            return;
        }
        arrclass_2350 = class_2350.values();
        int n6 = arrclass_2350.length;
        int n7 = n2 = 0;
        while (n7 < n6) {
            class_2350 class_23504 = arrclass_2350[n2];
            if (BlockUtil.canPlace(a3.method_10093(class_23504), a4.placeRange.getValue()) && !a3.method_10093(class_23504).equals((Object)a) && class_23504 != a2.method_10153()) {
                PistonCrystal pistonCrystal = a4;
                pistonCrystal.doSwap(n5);
                pistonCrystal.placeBlock(a3.method_10093(class_23504), a4.rotate.getValue(), a4.endSwing.getValue());
                PistonCrystal pistonCrystal4 = a4;
                if (a4.inventory.getValue()) {
                    pistonCrystal4.doSwap(n5);
                    EntityUtil.syncInventory();
                    return;
                }
                pistonCrystal4.doSwap(n3);
                return;
            }
            n7 = ++n2;
        }
    }

    public PistonCrystal() {
        PistonCrystal a;
        PistonCrystal pistonCrystal = a;
        super(GaussianFilter.ALLATORIxDEMO("vs\u0005;L&g=Z!Jy\u0018"), Module.Category.Combat);
        PistonCrystal pistonCrystal2 = a;
        pistonCrystal2.page = pistonCrystal.add(new EnumSetting<Page>(SocketClient.ALLATORIxDEMO("kEb"), Page.General));
        pistonCrystal.rotate = pistonCrystal.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u001dL&_l\u0011"), false, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }));
        a.newRotate = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("\\Xohp[kVb"), false, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("}.T\u0001J}\u0004"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("j~LaGs"), false, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("` A,H\u001eQw\u001f"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("LMq"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawDeceive = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u0016B?`*@7Wn\u0011"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }));
        a.autoYaw = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("YOk@SCp"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }));
        a.preferAnchor = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("J\u0004*E-V\u000eM1Vw\u0006"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.preferCrystal = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("xN|QwO[Hf\\~Ck"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u001fO)G*q3P\u0011"), 5.0, 1.0, 8.0, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.range = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("MV`Z}NMNdEb"), 4.0, 1.0, 8.0, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.updateDelay = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u001fO)G*g7Ry\r"), 100, 0, 500, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.posUpdateDelay = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("LGv\\l_[JfC~"), 500, 0, 1000, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.stageSetting = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("p&_\u0011"), 4, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.pistonStage = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("I^aIwTL[kEb"), 1, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.pistonMaxStage = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u001aOi\u0002 M\u0005E7p&_\u0011"), 1, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.powerStage = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("g}J}HL[kEb"), 3, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.powerMaxStage = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("vu\u0001*Q\u0005E7p&_\u0011"), 3, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.crystalStage = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("kNaIyVL[kEb"), 4, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.crystalMaxStage = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("h8_i\u0002.O\u0005E7p&_\u0011"), 4, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.fireStage = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("TTj_L[kEb"), 2, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.fireMaxStage = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\\\u001f=F\u0005E7p&_\u0011"), 2, 1, 10, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.speed = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("pyBL_oGc"), 8, 0, 20, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventory = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("ot\u0000*M<K=Z\u0001Iy\u0004"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.endSwing = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("xv^LXcL`"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.debug = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("g7\\m\u0013"), false, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.fire = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("icPb"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.switchPos = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u001cT;J{\u001c"), false, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.onlyGround = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("dwQ~}m@Lc"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.onlyStatic = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("; U!J(s3Kk\u0011"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.noEating = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("sw~[cL`"), true, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.eatingBreak = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("3.W!J(a [y\u001f"), false, object -> {
            Object a = object;
            PistonCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        PistonCrystal pistonCrystal3 = a;
        PistonCrystal pistonCrystal4 = a;
        PistonCrystal pistonCrystal5 = a;
        PistonCrystal pistonCrystal6 = a;
        PistonCrystal pistonCrystal7 = a;
        PistonCrystal pistonCrystal8 = a;
        pistonCrystal8.target = null;
        pistonCrystal8.directionVec = null;
        pistonCrystal7.lastYaw = 0.0f;
        pistonCrystal7.lastPitch = 0.0f;
        pistonCrystal6.timer = new Timer();
        pistonCrystal6.crystalTimer = new Timer();
        pistonCrystal6.bestPos = null;
        pistonCrystal5.bestOPos = null;
        pistonCrystal5.bestFacing = null;
        pistonCrystal4.distance = 100.0;
        pistonCrystal4.getPos = false;
        pistonCrystal3.stage = 1;
        pistonCrystal3.setChinese(SocketClient.ALLATORIxDEMO("\u6d24\u5871\u63a2\u6c16\u6671"));
        INSTANCE = pistonCrystal3;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        PistonCrystal a3 = this;
        if (a2 < 0.01f) {
            a2 = 0.01f;
        }
        if (a2 > 1.0f) {
            a2 = 1.0f;
        }
        if (a2 < 1.0f && a != null) {
            void v2;
            float f2;
            float f3 = a3.lastYaw;
            float f4 = class_3532.method_15393((float)(a[0] - f3));
            if (Math.abs(f2) > 90.0f * a2) {
                float f5 = f4;
                a[0] = f3 + f5 * (90.0f * a2 / Math.abs(f5));
            }
            f3 = a3.lastPitch;
            f4 = a[1] - f3;
            if (Math.abs((float)v2) > 90.0f * a2) {
                float f6 = f4;
                a[1] = f3 + f6 * (90.0f * a2 / Math.abs(f6));
            }
        }
        if (a != null) {
            float[] arrf2 = new float[2];
            arrf2[0] = a[0];
            arrf2[1] = a[1];
            return arrf2;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public boolean check(boolean bl, boolean bl2, boolean bl3) {
        void a;
        void a2;
        boolean a3 = bl3;
        PistonCrystal a4 = this;
        if (MovementUtil.isMoving() && a2 != false) {
            return true;
        }
        if (a != false && a3) {
            return true;
        }
        if (a4.findBlock(class_2246.field_10002) == -1) {
            return true;
        }
        if (a4.findClass(class_2665.class) == -1) {
            return true;
        }
        return a4.findItem(class_1802.field_8301) == -1;
    }

    public int findBlock(class_2248 class_22482) {
        PistonCrystal a = class_22482;
        PistonCrystal a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doPistonAura(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383) {
        void a;
        void a2;
        PistonCrystal a3 = class_23382;
        PistonCrystal a4 = this;
        if ((double)a4.stage >= a4.stageSetting.getValue()) {
            a4.stage = 0;
        }
        ++a4.stage;
        if (PistonCrystal.mc.field_1687 != null && PistonCrystal.mc.field_1687.method_22347((class_2338)a3)) {
            if (BlockUtil.canPlace((class_2338)a3)) {
                if ((double)a4.stage >= a4.pistonStage.getValue() && (double)a4.stage <= a4.pistonMaxStage.getValue()) {
                    PistonCrystal pistonCrystal;
                    class_243 class_2432;
                    class_2350 class_23503 = BlockUtil.getPlaceSide((class_2338)a3);
                    if (class_23503 == null) {
                        return;
                    }
                    int n = 0;
                    if (PistonCrystal.mc.field_1724 != null) {
                        n = PistonCrystal.mc.field_1724.method_31548().field_7545;
                    }
                    class_2338 class_23384 = a3.method_10093(class_23503);
                    class_2350 class_23504 = class_23503.method_10153();
                    if (a4.rotate.getValue() && !a4.faceVector(class_2432 = a3.method_46558().method_1019(new class_243((double)class_23503.method_10163().method_10263() * 0.5, (double)class_23503.method_10163().method_10264() * 0.5, (double)class_23503.method_10163().method_10260() * 0.5)))) {
                        return;
                    }
                    if (a4.shouldYawCheck()) {
                        PistonCrystal.pistonFacing((class_2350)a2);
                    }
                    PistonCrystal pistonCrystal2 = a4;
                    int n2 = pistonCrystal2.findClass(class_2665.class);
                    pistonCrystal2.doSwap(n2);
                    pistonCrystal2.placeBlock((class_2338)a3, false, a4.endSwing.getValue());
                    PistonCrystal pistonCrystal3 = a4;
                    if (a4.inventory.getValue()) {
                        pistonCrystal3.doSwap(n2);
                        EntityUtil.syncInventory();
                        pistonCrystal = a4;
                    } else {
                        pistonCrystal3.doSwap(n);
                        pistonCrystal = a4;
                    }
                    if (pistonCrystal.rotate.getValue()) {
                        EntityUtil.facePosSide(class_23384, class_23504);
                    }
                }
            } else {
                return;
            }
        }
        if ((double)a4.stage >= a4.powerStage.getValue() && (double)a4.stage <= a4.powerMaxStage.getValue()) {
            void v3 = a2;
            a4.doRedStone((class_2338)a3, (class_2350)v3, a.method_10093((class_2350)v3));
        }
        if ((double)a4.stage >= a4.crystalStage.getValue() && (double)a4.stage <= a4.crystalMaxStage.getValue()) {
            a4.placeCrystal((class_2338)a, (class_2350)a2);
        }
        if ((double)a4.stage >= a4.fireStage.getValue() && (double)a4.stage <= a4.fireMaxStage.getValue()) {
            a4.doFire((class_2338)a, (class_2350)a2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        void a2;
        PistonCrystal a3 = class_23382;
        PistonCrystal a4 = this;
        class_243 class_2432 = new class_243((double)a3.method_10263() + 0.5 + (double)a2.method_10163().method_10263() * 0.5, (double)a3.method_10264() + 0.5 + (double)a2.method_10163().method_10264() * 0.5, (double)a3.method_10260() + 0.5 + (double)a2.method_10163().method_10260() * 0.5);
        if (a != false && !a4.faceVector(class_2432)) {
            return false;
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        a3 = new class_3965(class_2432, (class_2350)a2, (class_2338)a3, false);
        if (PistonCrystal.mc.field_1724 != null) {
            PistonCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a3, BlockUtil.getWorldActionId(PistonCrystal.mc.field_1687)));
        }
        return true;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        PistonCrystal a2 = this;
        if (a2.inventory.getValue()) {
            if (PistonCrystal.mc.field_1724 != null) {
                InventoryUtil.inventorySwap(a, PistonCrystal.mc.field_1724.method_31548().field_7545);
                return;
            }
        } else {
            InventoryUtil.switchToSlot(a);
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void getPos(class_2338 class_23382, class_2350 class_23502) {
        void a;
        PistonCrystal a2 = class_23502;
        PistonCrystal a3 = this;
        if (!BlockUtil.canPlaceCrystal(a.method_10093((class_2350)a2)) && !a3.checkCrystal2(a.method_10093((class_2350)a2))) {
            return;
        }
        PistonCrystal pistonCrystal = a3;
        void v1 = a;
        PistonCrystal pistonCrystal2 = a3;
        void v3 = a;
        PistonCrystal pistonCrystal3 = a3;
        void v5 = a;
        PistonCrystal pistonCrystal4 = a3;
        void v7 = a;
        PistonCrystal pistonCrystal5 = a2;
        a3.getPos(a.method_10079((class_2350)pistonCrystal5, 3), (class_2350)a2, (class_2338)a);
        a3.getPos(v7.method_10079((class_2350)pistonCrystal5, 3).method_10084(), (class_2350)a2, (class_2338)a);
        PistonCrystal pistonCrystal6 = a2;
        void v10 = a;
        int n = a.method_10093((class_2350)pistonCrystal6).method_10263() - v10.method_10263();
        int n2 = v10.method_10093((class_2350)pistonCrystal6).method_10260() - a.method_10260();
        pistonCrystal4.getPos(v7.method_10079((class_2350)a2, 3).method_10069(n2, 0, n), (class_2350)a2, (class_2338)a);
        pistonCrystal4.getPos(a.method_10079((class_2350)a2, 3).method_10069(-n2, 0, -n), (class_2350)a2, (class_2338)a);
        a3.getPos(v5.method_10079((class_2350)a2, 3).method_10069(n2, 1, n), (class_2350)a2, (class_2338)a);
        pistonCrystal3.getPos(v5.method_10079((class_2350)a2, 3).method_10069(-n2, 1, -n), (class_2350)a2, (class_2338)a);
        pistonCrystal3.getPos(a.method_10079((class_2350)a2, 2), (class_2350)a2, (class_2338)a);
        a3.getPos(v3.method_10079((class_2350)a2, 2).method_10084(), (class_2350)a2, (class_2338)a);
        pistonCrystal2.getPos(v3.method_10079((class_2350)a2, 2).method_10069(n2, 0, n), (class_2350)a2, (class_2338)a);
        pistonCrystal2.getPos(a.method_10079((class_2350)a2, 2).method_10069(-n2, 0, -n), (class_2350)a2, (class_2338)a);
        pistonCrystal.getPos(v1.method_10079((class_2350)a2, 2).method_10069(n2, 1, n), (class_2350)a2, (class_2338)a);
        pistonCrystal.getPos(v1.method_10079((class_2350)a2, 2).method_10069(-n2, 1, -n), (class_2350)a2, (class_2338)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doFire(class_2338 class_23382, class_2350 class_23502) {
        int[] arrn;
        void a;
        int n;
        int n2;
        int[] arrn2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int[] a2 = class_23502;
        int[] a3 = this;
        if (!a3.fire.getValue()) {
            return;
        }
        int n9 = a3.findItem(class_1802.field_8884);
        if (n9 == -1) {
            return;
        }
        int n10 = 0;
        if (PistonCrystal.mc.field_1724 != null) {
            n10 = PistonCrystal.mc.field_1724.method_31548().field_7545;
        }
        int[] arrn3 = new int[3];
        arrn3[0] = 0;
        arrn3[1] = a2.method_10165();
        arrn3[2] = -a2.method_10165();
        int[] arrn4 = arrn3;
        int[] arrn5 = new int[2];
        arrn5[0] = 0;
        arrn5[1] = 1;
        int[] arrn6 = arrn5;
        int[] arrn7 = new int[3];
        arrn7[0] = 0;
        arrn7[1] = a2.method_10148();
        arrn7[2] = -a2.method_10148();
        a2 = arrn7;
        int[] arrn8 = arrn4;
        int n11 = arrn8.length;
        int n12 = n8 = 0;
        while (n12 < n11) {
            n4 = arrn8[n8];
            arrn2 = arrn6;
            n2 = arrn2.length;
            int n13 = n5 = 0;
            while (n13 < n2) {
                n = arrn2[n5];
                arrn = a2;
                n7 = arrn.length;
                int n14 = n6 = 0;
                while (n14 < n7) {
                    n3 = arrn[n6];
                    if (a3.getBlock(a.method_10069(n4, n, n3)) == class_2246.field_10036) {
                        return;
                    }
                    n14 = ++n6;
                }
                n13 = ++n5;
            }
            n12 = ++n8;
        }
        arrn8 = arrn4;
        n11 = arrn8.length;
        int n15 = n8 = 0;
        while (n15 < n11) {
            n4 = arrn8[n8];
            arrn2 = arrn6;
            n2 = arrn2.length;
            int n16 = n5 = 0;
            while (n16 < n2) {
                n = arrn2[n5];
                arrn = a2;
                n7 = arrn.length;
                int n17 = n6 = 0;
                while (n17 < n7) {
                    n3 = arrn[n6];
                    if (PistonCrystal.canFire(a.method_10069(n4, n, n3))) {
                        int[] arrn9 = a3;
                        arrn9.doSwap(n9);
                        arrn9.placeFire(a.method_10069(n4, n, n3));
                        int[] arrn10 = a3;
                        if (arrn9.inventory.getValue()) {
                            arrn10.doSwap(n9);
                            EntityUtil.syncInventory();
                            return;
                        }
                        arrn10.doSwap(n10);
                        return;
                    }
                    n17 = ++n6;
                }
                n16 = ++n5;
            }
            n15 = ++n8;
        }
    }

    private /* synthetic */ void getBestPos(class_2338 a) {
        PistonCrystal a2;
        PistonCrystal pistonCrystal = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n = arrclass_2350.length;
        int n2 = a2 = 0;
        while (n2 < n) {
            class_2350 class_23502 = arrclass_2350[a2];
            if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036) {
                pistonCrystal.getPos(a, class_23502);
            }
            n2 = ++a2;
        }
    }

    private /* synthetic */ boolean shouldYawCheck() {
        PistonCrystal a;
        return a.yawDeceive.getValue() || a.autoYaw.getValue() && !EntityUtil.isInsideBlock();
    }

    public int findItem(class_1792 class_17922) {
        PistonCrystal a = class_17922;
        PistonCrystal a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findItemInventorySlot((class_1792)a);
        }
        return InventoryUtil.findItem((class_1792)a);
    }

    /*
     * WARNING - void declaration
     */
    public void placeBlock(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        class_2350 a2;
        void a3;
        void a4;
        class_2350 class_23502 = this;
        if (BlockUtil.airPlace()) {
            int n;
            a2 = class_2350.values();
            int n2 = ((class_2350[])a2).length;
            int n3 = n = 0;
            while (n3 < n2) {
                class_2350 class_23503 = a2[n];
                if (PistonCrystal.mc.field_1687 != null && PistonCrystal.mc.field_1687.method_22347(a.method_10093(class_23503))) {
                    class_23502.clickBlock((class_2338)a, class_23503, (boolean)a4);
                    return;
                }
                n3 = ++n;
            }
        }
        if ((a2 = BlockUtil.getPlaceSide((class_2338)a)) == null) {
            return;
        }
        class_243 class_2432 = new class_243((double)a.method_10263() + 0.5 + (double)a2.method_10163().method_10263() * 0.5, (double)a.method_10264() + 0.5 + (double)a2.method_10163().method_10264() * 0.5, (double)a.method_10260() + 0.5 + (double)a2.method_10163().method_10260() * 0.5);
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        class_3965 class_39652 = new class_3965(class_2432, a2, (class_2338)a, false);
        BlockUtil.placedPos.add((class_2338)a);
        boolean bl3 = false;
        if (PistonCrystal.mc.field_1724 != null) {
            bl3 = PistonCrystal.mc.field_1724.method_5624();
        }
        boolean bl4 = false;
        if (PistonCrystal.mc.field_1687 != null) {
            boolean bl5 = bl4 = BlockUtil.needSneak(PistonCrystal.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !PistonCrystal.mc.field_1724.method_5715();
        }
        if (bl3) {
            PistonCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)PistonCrystal.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl4) {
            PistonCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)PistonCrystal.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a.method_10093(a2), a2.method_10153(), (boolean)a4);
        if (bl4) {
            PistonCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)PistonCrystal.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl3) {
            PistonCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)PistonCrystal.mc.field_1724, class_2848.class_2849.field_12981));
        }
        if (a3 != false) {
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
    }

    @Override
    public String getInfo() {
        PistonCrystal a;
        if (a.target != null) {
            return a.target.method_5477().getString();
        }
        return null;
    }

    public void placeFire(class_2338 class_23382) {
        PistonCrystal a;
        PistonCrystal a2 = class_23382;
        PistonCrystal pistonCrystal = a = this;
        pistonCrystal.clickBlock(a2.method_10093(class_2350.field_11033), class_2350.field_11036, pistonCrystal.rotate.getValue());
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isPiston(class_2338 class_23382, class_2350 class_23502) {
        void a;
        PistonCrystal a2 = class_23382;
        PistonCrystal a3 = this;
        if (PistonCrystal.mc.field_1687 != null && !(PistonCrystal.mc.field_1687.method_8320((class_2338)a2).method_26204() instanceof class_2665)) {
            return false;
        }
        if (((class_2350)PistonCrystal.mc.field_1687.method_8320((class_2338)a2).method_11654((class_2769)class_2318.field_10927)).method_10153() != a) {
            return false;
        }
        return PistonCrystal.mc.field_1687.method_22347(a2.method_10079((class_2350)a, -1)) || a3.getBlock(a2.method_10079((class_2350)a, -1)) == class_2246.field_10036 || a3.getBlock(a2.method_10093(a.method_10153())) == class_2246.field_10008;
    }

    public void onTick() {
        PistonCrystal a;
        if (a.pistonStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.pistonStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.fireStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.fireStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.powerStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.powerStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.crystalStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.crystalStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.pistonMaxStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.pistonMaxStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.fireMaxStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.fireMaxStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.powerMaxStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.powerMaxStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.crystalMaxStage.getValue() > a.stageSetting.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.crystalMaxStage.setValue(pistonCrystal.stageSetting.getValue());
        }
        if (a.crystalMaxStage.getValue() < a.crystalStage.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.crystalStage.setValue(pistonCrystal.crystalMaxStage.getValue());
        }
        if (a.powerMaxStage.getValue() < a.powerStage.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.powerStage.setValue(pistonCrystal.powerMaxStage.getValue());
        }
        if (a.pistonMaxStage.getValue() < a.pistonStage.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.pistonStage.setValue(pistonCrystal.pistonMaxStage.getValue());
        }
        if (a.fireMaxStage.getValue() < a.fireStage.getValue()) {
            PistonCrystal pistonCrystal = a;
            pistonCrystal.fireStage.setValue(pistonCrystal.fireMaxStage.getValue());
        }
    }

    /*
     * WARNING - void declaration
     */
    public void attackCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        Object a = class_23382;
        PistonCrystal a2 = this;
        if ((a = PistonCrystal.mc.field_1687.method_18467(class_1511.class, new class_238((class_2338)a)).iterator()).hasNext()) {
            void a3;
            void a4;
            a = (class_1511)a.next();
            a2.attackCrystal((class_1297)a, (boolean)a4, (boolean)a3);
            return;
        }
    }

    public static void pistonFacing(class_2350 a) {
        if (a == class_2350.field_11034) {
            EntityUtil.sendYawAndPitch(-90.0f, 5.0f);
            return;
        }
        if (a == class_2350.field_11039) {
            EntityUtil.sendYawAndPitch(90.0f, 5.0f);
            return;
        }
        if (a == class_2350.field_11043) {
            EntityUtil.sendYawAndPitch(180.0f, 5.0f);
            return;
        }
        if (a == class_2350.field_11035) {
            EntityUtil.sendYawAndPitch(0.0f, 5.0f);
        }
    }

    private /* synthetic */ class_2248 getBlock(class_2338 class_23382) {
        PistonCrystal a = class_23382;
        PistonCrystal a2 = this;
        if (PistonCrystal.mc.field_1687 != null) {
            return PistonCrystal.mc.field_1687.method_8320((class_2338)a).method_26204();
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public void attackCrystal(class_1297 class_12972, boolean bl, boolean bl2) {
        void a;
        PistonCrystal a2 = class_12972;
        PistonCrystal a3 = this;
        if (!CombatUtil.breakTimer.passedMs((long)(CombatSetting.INSTANCE.attackDelay.getValue() * 1000.0))) {
            return;
        }
        if (a != false && EntityUtil.isUsing()) {
            return;
        }
        if (a2 != null) {
            void a4;
            CombatUtil.breakTimer.reset();
            if (a4 != false && CombatSetting.INSTANCE.attackRotate.getValue()) {
                if (!a3.faceVector(new class_243(a2.method_23317(), a2.method_23318() + 0.25, a2.method_23321()))) {
                    return;
                }
            }
            PistonCrystal.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34206((class_1297)a2, (boolean)PistonCrystal.mc.field_1724.method_5715()));
            PistonCrystal.mc.field_1724.method_7350();
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
    }

    private /* synthetic */ boolean isTrueFacing(class_2338 a, class_2350 a2) {
        PistonCrystal a3;
        PistonCrystal pistonCrystal = a3;
        if (pistonCrystal.shouldYawCheck()) {
            return true;
        }
        a3 = BlockUtil.getPlaceSide(a);
        if (a3 == null) {
            a3 = class_2350.field_11036;
        }
        return class_2350.method_10150((double)EntityUtil.getLegitRotations(a.method_10093((a3 = a3.method_10153()).method_10153()).method_46558().method_1019(new class_243((double)a3.method_10163().method_10263() * 0.5, (double)a3.method_10163().method_10264() * 0.5, (double)a3.method_10163().method_10260() * 0.5)))[0]) == a2;
    }

    @Override
    public void onUpdate() {
        PistonCrystal pistonCrystal;
        PistonCrystal a;
        PistonCrystal pistonCrystal2 = pistonCrystal = a;
        pistonCrystal2.onTick();
        pistonCrystal.directionVec = null;
        pistonCrystal.target = CombatUtil.getClosestEnemy(pistonCrystal2.range.getValue());
        if (pistonCrystal.target == null) {
            return;
        }
        if (pistonCrystal.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            return;
        }
        if (pistonCrystal.preferCrystal.getValue() && HanaAura.crystalPos != null) {
            return;
        }
        if (pistonCrystal.noEating.getValue() && EntityUtil.isUsing()) {
            return;
        }
        if (PistonCrystal.mc.field_1724 != null) {
            boolean bl;
            PistonCrystal pistonCrystal3;
            PistonCrystal pistonCrystal4 = pistonCrystal;
            if (!PistonCrystal.mc.field_1724.method_24828()) {
                bl = true;
                pistonCrystal3 = pistonCrystal;
            } else {
                bl = false;
                pistonCrystal3 = pistonCrystal;
            }
            if (pistonCrystal4.check(pistonCrystal4.onlyStatic.getValue(), bl, pistonCrystal3.onlyGround.getValue())) {
                return;
            }
        }
        a = EntityUtil.getEntityPos((class_1297)pistonCrystal.target, true);
        if (!EntityUtil.isUsing() || pistonCrystal.eatingBreak.getValue()) {
            if (pistonCrystal.checkCrystal(a.method_10086(0))) {
                PistonCrystal pistonCrystal5 = pistonCrystal;
                pistonCrystal5.attackCrystal(a.method_10086(0), pistonCrystal5.rotate.getValue(), false);
            }
            if (pistonCrystal.checkCrystal(a.method_10086(1))) {
                PistonCrystal pistonCrystal6 = pistonCrystal;
                pistonCrystal6.attackCrystal(a.method_10086(1), pistonCrystal6.rotate.getValue(), false);
            }
            if (pistonCrystal.checkCrystal(a.method_10086(2))) {
                PistonCrystal pistonCrystal7 = pistonCrystal;
                pistonCrystal7.attackCrystal(a.method_10086(2), pistonCrystal7.rotate.getValue(), false);
            }
        }
        if (PistonCrystal.mc.field_1687 != null && pistonCrystal.bestPos != null) {
            PistonCrystal.mc.field_1687.method_8320(pistonCrystal.bestPos).method_26204();
        }
        PistonCrystal pistonCrystal8 = pistonCrystal;
        if (pistonCrystal8.crystalTimer.passedMs(pistonCrystal8.posUpdateDelay.getValueInt())) {
            PistonCrystal pistonCrystal9 = pistonCrystal;
            PistonCrystal pistonCrystal10 = pistonCrystal;
            pistonCrystal.stage = 0;
            pistonCrystal10.distance = 100.0;
            pistonCrystal10.getPos = false;
            pistonCrystal9.getBestPos(a.method_10086(2));
            pistonCrystal9.getBestPos(a.method_10084());
        }
        PistonCrystal pistonCrystal11 = pistonCrystal;
        if (!pistonCrystal11.timer.passedMs(pistonCrystal11.updateDelay.getValueInt())) {
            return;
        }
        if (pistonCrystal.getPos && pistonCrystal.bestPos != null) {
            boolean bl;
            PistonCrystal pistonCrystal12;
            PistonCrystal pistonCrystal13 = pistonCrystal;
            pistonCrystal13.timer.reset();
            if (pistonCrystal13.debug.getValue()) {
                PistonCrystal pistonCrystal14 = pistonCrystal;
                CommandManager.sendChatMessage("[Debug] PistonPos:" + String.valueOf((Object)pistonCrystal.bestPos) + " Facing:" + String.valueOf((Object)pistonCrystal.bestFacing) + " CrystalPos:" + String.valueOf((Object)pistonCrystal14.bestOPos.method_10093(pistonCrystal14.bestFacing)));
            }
            PistonCrystal pistonCrystal15 = pistonCrystal;
            if (!PistonCrystal.mc.field_1724.method_24828()) {
                bl = true;
                pistonCrystal12 = pistonCrystal;
            } else {
                bl = false;
                pistonCrystal12 = pistonCrystal;
            }
            if (pistonCrystal15.check(pistonCrystal15.onlyStatic.getValue(), bl, pistonCrystal12.onlyGround.getValue())) {
                return;
            }
            PistonCrystal pistonCrystal16 = pistonCrystal;
            pistonCrystal16.doPistonAura(pistonCrystal16.bestPos, pistonCrystal16.bestFacing, pistonCrystal.bestOPos);
        }
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Misc;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Rotate;

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Page() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
            // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        static {
            General = new Page(Snow.ALLATORIxDEMO("\"e:c e<"), 0);
            Misc = new Page(FPSManager.ALLATORIxDEMO("@\u00024B"), 1);
            Rotate = new Page(Snow.ALLATORIxDEMO("R;r3p5"), 2);
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[3];
            arrpage[0] = General;
            arrpage[1] = Misc;
            arrpage[2] = Rotate;
            return arrpage;
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }
    }

}
