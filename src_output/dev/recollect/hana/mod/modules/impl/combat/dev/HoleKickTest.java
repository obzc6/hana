/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_2753
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class HoleKickTest
extends Module {
    private final BooleanSetting attackCrystal;
    private final BooleanSetting onlyGround;
    private final SliderSetting surroundCheck;
    private final BooleanSetting autoDisable;
    private final BooleanSetting selfGround;
    private final SliderSetting updateDelay;
    public final BooleanSetting yawDeceive;
    public static HoleKickTest INSTANCE;
    private final BooleanSetting inventory;
    private final BooleanSetting pistonPacket;
    private final BooleanSetting noEating;
    private final BooleanSetting preferAnchor;
    private final BooleanSetting onlyBurrow;
    private final BooleanSetting mine;
    private final SliderSetting range;
    private final BooleanSetting checkPiston;
    private final BooleanSetting rotate;
    private final BooleanSetting redStonePacket;
    private final BooleanSetting allowWeb;
    private class_1657 displayTarget;
    private final BooleanSetting pullBack;
    private final Timer timer;
    private final SliderSetting placeRange;

    public boolean doPush(class_2338 a, class_1657 a2) {
        HoleKickTest a3;
        HoleKickTest holeKickTest = a3;
        if (holeKickTest.checkPiston.getValue() && holeKickTest.checkPiston(a)) {
            return true;
        }
        if (!HoleKickTest.mc.field_1687.method_8320(a.method_10086(2)).method_51366()) {
            class_2350[] arrclass_2350;
            int n;
            class_2350[] arrclass_23502;
            class_2350 class_23502;
            int n2;
            HoleKickTest holeKickTest2;
            class_2350 class_23503;
            int n3;
            int n4;
            block45 : {
                arrclass_2350 = class_2350.values();
                n2 = arrclass_2350.length;
                int n5 = n = 0;
                while (n5 < n2) {
                    class_23502 = arrclass_2350[n];
                    if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036 && holeKickTest.getBlock((class_2338)(a3 = a.method_10093(class_23502).method_10084())) instanceof class_2665 && !holeKickTest.getBlockState(a3.method_10079(class_23502, -2)).method_51366() && (holeKickTest.getBlock(a3.method_10079(class_23502, -2).method_10084()) == class_2246.field_10124 || holeKickTest.getBlock(a3.method_10079(class_23502, -2).method_10084()) == class_2246.field_10002) && ((class_2350)holeKickTest.getBlockState((class_2338)a3).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23502) {
                        arrclass_23502 = class_2350.values();
                        n4 = arrclass_23502.length;
                        int n6 = n3 = 0;
                        while (n6 < n4) {
                            class_23503 = arrclass_23502[n3];
                            if (holeKickTest.getBlock(a3.method_10093(class_23503)) == class_2246.field_10002) {
                                if (holeKickTest.mine.getValue()) {
                                    holeKickTest.mine(a3.method_10093(class_23503));
                                }
                                if (holeKickTest.autoDisable.getValue()) {
                                    holeKickTest.disable();
                                }
                                return true;
                            }
                            n6 = ++n3;
                        }
                    }
                    n5 = ++n;
                }
                arrclass_2350 = class_2350.values();
                n2 = arrclass_2350.length;
                int n7 = n = 0;
                while (n7 < n2) {
                    class_23502 = arrclass_2350[n];
                    if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036 && holeKickTest.getBlock((class_2338)(a3 = a.method_10093(class_23502).method_10084())) instanceof class_2665 && !holeKickTest.getBlockState(a3.method_10079(class_23502, -2)).method_51366() && (holeKickTest.getBlock(a3.method_10079(class_23502, -2).method_10084()) == class_2246.field_10124 || holeKickTest.getBlock(a3.method_10079(class_23502, -2).method_10084()) == class_2246.field_10002) && ((class_2350)holeKickTest.getBlockState((class_2338)a3).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23502 && holeKickTest.doPower((class_2338)a3)) {
                        return true;
                    }
                    n7 = ++n;
                }
                arrclass_2350 = class_2350.values();
                n2 = arrclass_2350.length;
                int n8 = n = 0;
                while (n8 < n2) {
                    class_23502 = arrclass_2350[n];
                    if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036) {
                        a3 = a.method_10093(class_23502).method_10084();
                        if (!(HoleKickTest.mc.field_1724.method_23318() - a2.method_23318() <= -1.0) && !(HoleKickTest.mc.field_1724.method_23318() - a2.method_23318() >= 2.0) || !(BlockUtil.distanceToXZ((double)a3.method_10263() + 0.5, (double)a3.method_10260() + 0.5) < 2.6)) {
                            HoleKickTest holeKickTest3 = a3;
                            holeKickTest.attackCrystal((class_2338)holeKickTest3);
                            if (holeKickTest.isTrueFacing((class_2338)holeKickTest3, class_23502) && BlockUtil.clientCanPlace((class_2338)a3, false) && !holeKickTest.getBlockState(a3.method_10079(class_23502, -2)).method_51366() && !holeKickTest.getBlockState(a3.method_10079(class_23502, -2).method_10084()).method_51366()) {
                                if (BlockUtil.getPlaceSide((class_2338)a3) == null && holeKickTest.downPower((class_2338)a3)) {
                                    holeKickTest2 = holeKickTest;
                                    break block45;
                                }
                                holeKickTest.doPiston(class_23502, (class_2338)a3, holeKickTest.mine.getValue());
                                return true;
                            }
                        }
                    }
                    n8 = ++n;
                }
                holeKickTest2 = holeKickTest;
            }
            if (holeKickTest2.getBlock(a) == class_2246.field_10124 && holeKickTest.onlyBurrow.getValue() || !holeKickTest.pullBack.getValue()) {
                if (holeKickTest.autoDisable.getValue()) {
                    holeKickTest.disable();
                }
                return true;
            }
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n9 = n = 0;
            while (n9 < n2) {
                class_23502 = arrclass_2350[n];
                if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036) {
                    a3 = a.method_10093(class_23502).method_10084();
                    arrclass_23502 = class_2350.values();
                    n4 = arrclass_23502.length;
                    int n10 = n3 = 0;
                    while (n10 < n4) {
                        class_23503 = arrclass_23502[n3];
                        if (holeKickTest.getBlock((class_2338)a3) instanceof class_2665 && holeKickTest.getBlock(a3.method_10093(class_23503)) == class_2246.field_10002 && ((class_2350)holeKickTest.getBlockState((class_2338)a3).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23502) {
                            HoleKickTest holeKickTest4 = holeKickTest;
                            holeKickTest4.mine(a3.method_10093(class_23503));
                            if (holeKickTest4.autoDisable.getValue()) {
                                holeKickTest.disable();
                            }
                            return true;
                        }
                        n10 = ++n3;
                    }
                }
                n9 = ++n;
            }
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n11 = n = 0;
            while (n11 < n2) {
                class_23502 = arrclass_2350[n];
                if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036) {
                    a3 = a.method_10093(class_23502).method_10084();
                    arrclass_23502 = class_2350.values();
                    n4 = arrclass_23502.length;
                    int n12 = n3 = 0;
                    while (n12 < n4) {
                        class_23503 = arrclass_23502[n3];
                        if (holeKickTest.getBlock((class_2338)a3) instanceof class_2665 && holeKickTest.getBlock(a3.method_10093(class_23503)) == class_2246.field_10124 && ((class_2350)holeKickTest.getBlockState((class_2338)a3).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23502) {
                            HoleKickTest holeKickTest5 = a3;
                            holeKickTest.attackCrystal(holeKickTest5.method_10093(class_23503));
                            if (!holeKickTest.doPower((class_2338)holeKickTest5, class_23503)) {
                                holeKickTest.mine(a3.method_10093(class_23503));
                                return true;
                            }
                        }
                        n12 = ++n3;
                    }
                }
                n11 = ++n;
            }
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n13 = n = 0;
            while (n13 < n2) {
                class_23502 = arrclass_2350[n];
                if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036) {
                    a3 = a.method_10093(class_23502).method_10084();
                    if (!(HoleKickTest.mc.field_1724.method_23318() - a2.method_23318() <= -1.0) && !(HoleKickTest.mc.field_1724.method_23318() - a2.method_23318() >= 2.0) || !(BlockUtil.distanceToXZ((double)a3.method_10263() + 0.5, (double)a3.method_10260() + 0.5) < 2.6)) {
                        HoleKickTest holeKickTest6 = a3;
                        holeKickTest.attackCrystal((class_2338)holeKickTest6);
                        if (holeKickTest.isTrueFacing((class_2338)holeKickTest6, class_23502) && BlockUtil.clientCanPlace((class_2338)a3, false) && !holeKickTest.downPower((class_2338)a3)) {
                            holeKickTest.doPiston(class_23502, (class_2338)a3, true);
                            return true;
                        }
                    }
                }
                n13 = ++n;
            }
        } else {
            int n;
            class_2350 class_23504;
            class_2350[] arrclass_2350 = class_2350.values();
            int n14 = arrclass_2350.length;
            int n15 = n = 0;
            while (n15 < n14) {
                class_23504 = arrclass_2350[n];
                if (class_23504 != class_2350.field_11033 && class_23504 != class_2350.field_11036 && holeKickTest.getBlock((class_2338)(a3 = a.method_10093(class_23504).method_10084())) instanceof class_2665 && (HoleKickTest.mc.field_1687.method_22347(a3.method_10079(class_23504, -2)) && HoleKickTest.mc.field_1687.method_22347(a3.method_10079(class_23504, -2).method_10074()) || HoleKickTest.isTargetHere(a3.method_10079(class_23504, 2), (class_1297)a2)) && ((class_2350)holeKickTest.getBlockState((class_2338)a3).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23504) {
                    int n16;
                    class_2350[] arrclass_23503 = class_2350.values();
                    int n17 = arrclass_23503.length;
                    int n18 = n16 = 0;
                    while (n18 < n17) {
                        class_2350 class_23505 = arrclass_23503[n16];
                        if (holeKickTest.getBlock(a3.method_10093(class_23505)) == class_2246.field_10002) {
                            if (holeKickTest.mine.getValue()) {
                                holeKickTest.mine(a3.method_10093(class_23505));
                            }
                            if (holeKickTest.autoDisable.getValue()) {
                                holeKickTest.disable();
                            }
                            return true;
                        }
                        n18 = ++n16;
                    }
                }
                n15 = ++n;
            }
            arrclass_2350 = class_2350.values();
            n14 = arrclass_2350.length;
            int n19 = n = 0;
            while (n19 < n14) {
                class_23504 = arrclass_2350[n];
                if (class_23504 != class_2350.field_11033 && class_23504 != class_2350.field_11036 && holeKickTest.getBlock((class_2338)(a3 = a.method_10093(class_23504).method_10084())) instanceof class_2665 && (HoleKickTest.mc.field_1687.method_22347(a3.method_10079(class_23504, -2)) && HoleKickTest.mc.field_1687.method_22347(a3.method_10079(class_23504, -2).method_10074()) || HoleKickTest.isTargetHere(a3.method_10079(class_23504, 2), (class_1297)a2)) && ((class_2350)holeKickTest.getBlockState((class_2338)a3).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23504 && holeKickTest.doPower((class_2338)a3)) {
                    return true;
                }
                n19 = ++n;
            }
            arrclass_2350 = class_2350.values();
            n14 = arrclass_2350.length;
            int n20 = n = 0;
            while (n20 < n14) {
                class_23504 = arrclass_2350[n];
                if (class_23504 != class_2350.field_11033 && class_23504 != class_2350.field_11036) {
                    a3 = a.method_10093(class_23504).method_10084();
                    if (!(HoleKickTest.mc.field_1724.method_23318() - a2.method_23318() <= -1.0) && !(HoleKickTest.mc.field_1724.method_23318() - a2.method_23318() >= 2.0) || !(BlockUtil.distanceToXZ((double)a3.method_10263() + 0.5, (double)a3.method_10260() + 0.5) < 2.6)) {
                        HoleKickTest holeKickTest7 = a3;
                        holeKickTest.attackCrystal((class_2338)holeKickTest7);
                        if (holeKickTest.isTrueFacing((class_2338)holeKickTest7, class_23504) && BlockUtil.clientCanPlace((class_2338)a3, false) && (HoleKickTest.mc.field_1687.method_22347(a3.method_10079(class_23504, -2)) && HoleKickTest.mc.field_1687.method_22347(a3.method_10079(class_23504, -2).method_10074()) || HoleKickTest.isTargetHere(a3.method_10079(class_23504, 2), (class_1297)a2)) && !holeKickTest.getBlockState(a3.method_10079(class_23504, -2).method_10084()).method_51366()) {
                            if (BlockUtil.getPlaceSide((class_2338)a3) != null || !holeKickTest.downPower((class_2338)a3)) {
                                holeKickTest.doPiston(class_23504, (class_2338)a3, holeKickTest.mine.getValue());
                                return true;
                            }
                            break;
                        }
                    }
                }
                n20 = ++n;
            }
        }
        return false;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        HoleKickTest a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, HoleKickTest.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void attackCrystal(class_2338 a) {
        Iterator a2;
        HoleKickTest holeKickTest = a2;
        if (!holeKickTest.attackCrystal.getValue()) {
            return;
        }
        a2 = HoleKickTest.mc.field_1687.method_18112().iterator();
        block0 : do {
            Iterator iterator = a2;
            do {
                if (!iterator.hasNext()) {
                    return;
                }
                class_1297 class_12972 = (class_1297)a2.next();
                if (!(class_12972 instanceof class_1511)) continue block0;
                if (!((double)class_3532.method_15355((float)((float)class_12972.method_5649((double)a.method_10263() + 0.5, (double)a.method_10264(), (double)a.method_10260() + 0.5))) > 2.0)) {
                    CombatUtil.attackCrystal(class_12972, holeKickTest.rotate.getValue(), false);
                    return;
                }
                iterator = a2;
            } while (true);
            break;
        } while (true);
    }

    private /* synthetic */ class_2248 getBlock(class_2338 class_23382) {
        HoleKickTest a = class_23382;
        HoleKickTest a2 = this;
        return HoleKickTest.mc.field_1687.method_8320((class_2338)a).method_26204();
    }

    @Override
    public void onEnable() {
        AutoCrystal.INSTANCE.lastBreakTimer.reset();
        HanaAura.INSTANCE.lastBreakTimer.reset();
        AlienCrystal.INSTANCE.lastBreakTimer.reset();
    }

    private /* synthetic */ boolean doPower(class_2338 a) {
        class_2350 a2;
        int n;
        class_2350 class_23502 = a2;
        a2 = BlockUtil.getBestNeighboring(a, null);
        if (a2 != null) {
            class_2350 class_23503 = class_23502;
            class_23503.attackCrystal(a.method_10093(a2));
            if (!class_23503.doPower(a, a2)) {
                return true;
            }
        }
        a2 = class_2350.values();
        int n2 = ((class_2350[])a2).length;
        int n3 = n = 0;
        while (n3 < n2) {
            class_2350 class_23504 = a2[n];
            class_2350 class_23505 = class_23502;
            class_23505.attackCrystal(a.method_10093(class_23504));
            if (!class_23505.doPower(a, class_23504)) {
                return true;
            }
            n3 = ++n;
        }
        return false;
    }

    private /* synthetic */ boolean isTrueFacing(class_2338 a, class_2350 a2) {
        HoleKickTest a3;
        HoleKickTest holeKickTest = a3;
        if (holeKickTest.yawDeceive.getValue()) {
            return true;
        }
        a3 = BlockUtil.getPlaceSide(a);
        if (a3 == null) {
            a3 = class_2350.field_11036;
        }
        a3 = a3.method_10153();
        return class_2350.method_10150((double)EntityUtil.getLegitRotations(a.method_10093(a3.method_10153()).method_46558().method_1019(new class_243((double)a3.method_10163().method_10263() * 0.5, (double)a3.method_10163().method_10264() * 0.5, (double)a3.method_10163().method_10260() * 0.5)))[0]) == a2;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doPiston(class_2350 class_23502, class_2338 class_23382, boolean bl) {
        void a;
        HoleKickTest holeKickTest = this;
        if (BlockUtil.canPlace((class_2338)a, holeKickTest.placeRange.getValue())) {
            HoleKickTest holeKickTest2;
            HoleKickTest holeKickTest3 = holeKickTest;
            int n = holeKickTest3.findClass(class_2665.class);
            HoleKickTest a2 = BlockUtil.getPlaceSide((class_2338)a);
            if (holeKickTest3.rotate.getValue()) {
                EntityUtil.facePosSide(a.method_10093((class_2350)a2), a2.method_10153());
            }
            if (holeKickTest.yawDeceive.getValue()) {
                void a222;
                HoleKickTest.pistonFacing((class_2350)a222);
            }
            int a222 = HoleKickTest.mc.field_1724.method_31548().field_7545;
            HoleKickTest holeKickTest4 = holeKickTest;
            holeKickTest4.doSwap(n);
            BlockUtil.placeBlock((class_2338)a, false, holeKickTest.pistonPacket.getValue());
            if (holeKickTest4.inventory.getValue()) {
                HoleKickTest holeKickTest5 = holeKickTest;
                holeKickTest2 = holeKickTest5;
                holeKickTest5.doSwap(n);
                EntityUtil.syncInventory();
            } else {
                HoleKickTest holeKickTest6 = holeKickTest;
                holeKickTest2 = holeKickTest6;
                holeKickTest6.doSwap(a222);
            }
            if (holeKickTest2.rotate.getValue()) {
                EntityUtil.facePosSide(a.method_10093((class_2350)a2), a2.method_10153());
            }
            class_2350[] a222 = class_2350.values();
            n = a222.length;
            int n2 = a2 = 0;
            while (n2 < n) {
                class_2350 class_23503 = a222[a2];
                if (holeKickTest.getBlock(a.method_10093(class_23503)) == class_2246.field_10002) {
                    void a3;
                    if (a3 != false) {
                        holeKickTest.mine(a.method_10093(class_23503));
                    }
                    if (holeKickTest.autoDisable.getValue()) {
                        holeKickTest.disable();
                    }
                    return;
                }
                n2 = ++a2;
            }
            holeKickTest.doPower((class_2338)a);
        }
    }

    private /* synthetic */ boolean downPower(class_2338 a) {
        class_2350[] a22;
        class_2350[] arrclass_2350 = a22;
        if (BlockUtil.getPlaceSide(a) == null) {
            int n;
            boolean bl;
            block7 : {
                int n2;
                boolean bl2 = true;
                a22 = class_2350.values();
                n = a22.length;
                int n3 = n2 = 0;
                while (n3 < n) {
                    class_2350 class_23502 = a22[n2];
                    if (arrclass_2350.getBlock(a.method_10093(class_23502)) == class_2246.field_10002) {
                        bl = bl2 = false;
                        break block7;
                    }
                    n3 = ++n2;
                }
                bl = bl2;
            }
            if (bl) {
                if (!BlockUtil.canPlace(a.method_10069(0, -1, 0), arrclass_2350.placeRange.getValue())) {
                    return true;
                }
                int a22 = HoleKickTest.mc.field_1724.method_31548().field_7545;
                class_2350[] arrclass_23502 = arrclass_2350;
                n = arrclass_23502.findBlock(class_2246.field_10002);
                arrclass_23502.doSwap(n);
                BlockUtil.placeBlock(a.method_10069(0, -1, 0), arrclass_2350.rotate.getValue(), arrclass_2350.redStonePacket.getValue());
                class_2350[] arrclass_23503 = arrclass_2350;
                if (arrclass_23502.inventory.getValue()) {
                    arrclass_23503.doSwap(n);
                    EntityUtil.syncInventory();
                } else {
                    arrclass_23503.doSwap(a22);
                }
            }
        }
        return false;
    }

    @Override
    public String getInfo() {
        HoleKickTest a;
        if (a.displayTarget != null) {
            return a.displayTarget.method_5477().getString();
        }
        return null;
    }

    public int findBlock(class_2248 class_22482) {
        HoleKickTest a = class_22482;
        HoleKickTest a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    public int findClass(Class class_) {
        Class a = class_;
        HoleKickTest a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(a);
        }
        return InventoryUtil.findClass(a);
    }

    public static boolean isInWeb(class_1657 a222) {
        int n;
        class_1657 class_16572 = a222;
        class_243 class_2432 = class_16572.method_19538();
        float[] arrf = new float[3];
        arrf[0] = 0.0f;
        arrf[1] = 0.3f;
        arrf[2] = -0.3f;
        float[] arrf2 = arrf;
        int n2 = arrf.length;
        int n3 = n = 0;
        while (n3 < n2) {
            int n4;
            float f = arrf2[n];
            float[] arrf3 = new float[3];
            arrf3[0] = 0.0f;
            arrf3[1] = 0.3f;
            arrf3[2] = -0.3f;
            float[] arrf4 = arrf3;
            int n5 = arrf3.length;
            int n6 = n4 = 0;
            while (n6 < n5) {
                int n7;
                float f2 = arrf4[n4];
                float[] arrf5 = new float[3];
                arrf5[0] = 0.0f;
                arrf5[1] = 1.0f;
                arrf5[2] = -1.0f;
                float[] arrf6 = arrf5;
                int n8 = arrf5.length;
                int n9 = n7 = 0;
                while (n9 < n8) {
                    float a222 = arrf6[n7];
                    Object a222 = new BlockPosX(class_2432.method_10216() + (double)f, class_2432.method_10214() + (double)a222, class_2432.method_10215() + (double)f2);
                    if (HoleKickTest.isTargetHere((class_2338)a222, (class_1297)class_16572) && HoleKickTest.mc.field_1687.method_8320((class_2338)a222).method_26204() == class_2246.field_10343) {
                        return true;
                    }
                    n9 = ++n7;
                }
                n6 = ++n4;
            }
            n3 = ++n;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        HoleKickTest a;
        HoleKickTest holeKickTest;
        HoleKickTest holeKickTest2 = holeKickTest = a;
        if (!holeKickTest2.timer.passedMs(holeKickTest2.updateDelay.getValue())) {
            return;
        }
        if (holeKickTest.selfGround.getValue() && !HoleKickTest.mc.field_1724.method_24828()) {
            if (!holeKickTest.autoDisable.getValue()) return;
            holeKickTest.disable();
            return;
        }
        if (holeKickTest.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            return;
        }
        if (holeKickTest.findBlock(class_2246.field_10002) == -1 || holeKickTest.findClass(class_2665.class) == -1) {
            if (!holeKickTest.autoDisable.getValue()) return;
            holeKickTest.disable();
            return;
        }
        if (holeKickTest.noEating.getValue() && EntityUtil.isUsing()) {
            return;
        }
        holeKickTest.timer.reset();
        Iterator<class_1657> iterator = CombatUtil.getEnemies(holeKickTest.range.getValue()).iterator();
        block0 : do {
            Iterator<class_1657> iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = iterator.next();
                if (!holeKickTest.canPush((class_1657)a).booleanValue() || !a.method_24828() && holeKickTest.onlyGround.getValue()) continue block0;
                if (HoleKickTest.isInWeb((class_1657)a) && !holeKickTest.allowWeb.getValue()) {
                    iterator2 = iterator;
                    continue;
                }
                holeKickTest.displayTarget = a;
                if (holeKickTest.doPush(EntityUtil.getEntityPos((class_1297)holeKickTest.displayTarget), (class_1657)a)) return;
                iterator2 = iterator;
            }
            break;
        } while (true);
        if (holeKickTest.autoDisable.getValue()) {
            holeKickTest.disable();
        }
        holeKickTest.displayTarget = null;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean doPower(class_2338 class_23382, class_2350 class_23502) {
        void a;
        HoleKickTest a22 = class_23382;
        HoleKickTest a3 = this;
        if (!BlockUtil.canPlace(a22.method_10093((class_2350)a), a3.placeRange.getValue())) {
            return true;
        }
        int n = HoleKickTest.mc.field_1724.method_31548().field_7545;
        HoleKickTest holeKickTest = a3;
        int a22 = holeKickTest.findBlock(class_2246.field_10002);
        holeKickTest.doSwap(a22);
        BlockUtil.placeBlock(a22.method_10093((class_2350)a), a3.rotate.getValue(), a3.redStonePacket.getValue());
        if (holeKickTest.inventory.getValue()) {
            a3.doSwap(a22);
            EntityUtil.syncInventory();
        } else {
            a3.doSwap(n);
        }
        return false;
    }

    static boolean isTargetHere(class_2338 class_23382, class_1297 class_12972) {
        class_2338 a = class_12972;
        class_2338 a2 = class_23382;
        return new class_238(a2).method_994(a.method_5829());
    }

    private /* synthetic */ Boolean canPush(class_1657 class_16572) {
        HoleKickTest a = class_16572;
        HoleKickTest a2 = this;
        int n = 0;
        if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317() + 1.0, a.method_23318() + 0.5, a.method_23321()))) {
            ++n;
        }
        if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317() - 1.0, a.method_23318() + 0.5, a.method_23321()))) {
            ++n;
        }
        if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321() + 1.0))) {
            ++n;
        }
        if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321() - 1.0))) {
            ++n;
        }
        if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 2.5, a.method_23321()))) {
            int n2;
            class_2350[] arrclass_2350 = class_2350.values();
            int n3 = arrclass_2350.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                class_2350 class_23502 = arrclass_2350[n2];
                if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && (HoleKickTest.mc.field_1687.method_22347((class_2338)(class_23502 = EntityUtil.getEntityPos((class_1297)a).method_10093(class_23502))) && HoleKickTest.mc.field_1687.method_22347(class_23502.method_10084()) || HoleKickTest.isTargetHere((class_2338)class_23502, (class_1297)a))) {
                    if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321()))) {
                        return true;
                    }
                    return (double)n > a2.surroundCheck.getValue() - 1.0;
                }
                n4 = ++n2;
            }
            return false;
        }
        if (!HoleKickTest.mc.field_1687.method_22347((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321()))) {
            return true;
        }
        return (double)n > a2.surroundCheck.getValue() - 1.0;
    }

    private /* synthetic */ void mine(class_2338 class_23382) {
        HoleKickTest a = class_23382;
        HoleKickTest a2 = this;
        SpeedMine.INSTANCE.mine((class_2338)a);
    }

    public HoleKickTest() {
        HoleKickTest a;
        HoleKickTest holeKickTest = a;
        super(OnlineUserInfo.ALLATORIxDEMO("k;G9_\nF9g!G7"), Module.Category.Combat);
        HoleKickTest holeKickTest2 = a;
        holeKickTest2.preferAnchor = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("w\u0013J\u000fu$`\tT\u0019_\u0004"), true));
        holeKickTest.rotate = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("w=G%@&"), true));
        holeKickTest.yawDeceive = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("v\bg\u0012D\u0004R\u0018F\u0013"), true));
        holeKickTest.pistonPacket = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("s=X({\ru3P/Q7"), true));
        holeKickTest.redStonePacket = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\u000eC2[\u0006~3q\u0006T\u001aU\u0002"), true));
        holeKickTest.noEating = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("Z\f`3G-Z$"), true));
        holeKickTest.attackCrystal = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("e\u0013J\b{\u0015S\u001eD\u0005Q\u001a"), true));
        holeKickTest.mine = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("~-Z&"), false));
        holeKickTest.allowWeb = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("Q:M\b@&U\u0014"), true));
        holeKickTest.updateDelay = holeKickTest.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0001[8u\u0017@\u0016V(U:"), 100, 0, 500));
        holeKickTest.selfGround = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("|\f|0f\u0015X\u0004^\u0012"), true));
        holeKickTest.onlyGround = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("d2x\u001ab \\1Z'"), false));
        holeKickTest.checkPiston = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\"G\fs=q\u000eD\u0005_\u0018"), false));
        holeKickTest.autoDisable = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u0015^({'L!R&X&"), false));
        holeKickTest.pullBack = holeKickTest.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("@#M\u000bu\u0010S\u001d"), true).setParent());
        holeKickTest.onlyBurrow = holeKickTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("d2x\u001ag'A6[4"), true, object -> {
            Object a = object;
            HoleKickTest a2 = this;
            return a2.pullBack.isOpen();
        }));
        HoleKickTest holeKickTest3 = a;
        HoleKickTest holeKickTest4 = a;
        holeKickTest4.range = holeKickTest4.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("5V\u001fW\u0013"), 5.0, 0.0, 6.0));
        holeKickTest4.placeRange = holeKickTest4.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("{0u\u0000@\u0000R*S&"), 5.0, 0.0, 6.0));
        holeKickTest4.surroundCheck = holeKickTest4.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("8R\u0013]\u0006e8E$_\u0014S\u001d"), 2, 0, 4));
        holeKickTest4.inventory = holeKickTest4.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u0017M\"N2`\fW+`3U3"), false));
        holeKickTest4.timer = new Timer();
        holeKickTest3.displayTarget = null;
        holeKickTest3.setChinese(ProjectionUtils.ALLATORIxDEMO("\u0018q?\u6d0c\u582f\u6398\u4ecc"));
        INSTANCE = holeKickTest3;
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

    private /* synthetic */ boolean checkPiston(class_2338 a) {
        HoleKickTest a2;
        int n;
        HoleKickTest holeKickTest = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            class_2338 class_23382;
            a2 = arrclass_2350[n];
            if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036 && holeKickTest.getBlock((class_23382 = a.method_10084()).method_10093((class_2350)a2)) instanceof class_2665 && ((class_2350)holeKickTest.getBlockState(class_23382.method_10093((class_2350)a2)).method_11654((class_2769)class_2318.field_10927)).method_10153() == a2) {
                int n4;
                class_2350[] arrclass_23502 = class_2350.values();
                int n5 = arrclass_23502.length;
                int n6 = n4 = 0;
                while (n6 < n5) {
                    class_2350 class_23502 = arrclass_23502[n4];
                    if (holeKickTest.getBlock(class_23382.method_10093((class_2350)a2).method_10093(class_23502)) == class_2246.field_10002 && holeKickTest.mine.getValue()) {
                        HoleKickTest holeKickTest2 = holeKickTest;
                        holeKickTest2.mine(class_23382.method_10093((class_2350)a2).method_10093(class_23502));
                        if (holeKickTest2.autoDisable.getValue()) {
                            holeKickTest.disable();
                        }
                        return true;
                    }
                    n6 = ++n4;
                }
            }
            n3 = ++n;
        }
        return false;
    }

    private /* synthetic */ class_2680 getBlockState(class_2338 class_23382) {
        HoleKickTest a = class_23382;
        HoleKickTest a2 = this;
        return HoleKickTest.mc.field_1687.method_8320((class_2338)a);
    }
}
