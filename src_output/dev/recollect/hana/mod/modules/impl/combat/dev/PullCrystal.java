/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
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
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2665
 *  net.minecraft.class_2753
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ThunderExplosionUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.util.Iterator;
import java.util.List;
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
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2665;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class PullCrystal
extends Module {
    private final BooleanSetting fire;
    private final Timer timer;
    private final BooleanSetting rotate;
    private final SliderSetting range;
    private final BooleanSetting onlyGround;
    private final SliderSetting updateDelay;
    public static class_2338 crystalPos;
    private final BooleanSetting inventory;
    private final BooleanSetting onlyStatic;
    public final BooleanSetting checkMine;
    private final SliderSetting pistonDelay;
    public static class_2338 powerPos;
    private class_1657 target;
    public static PullCrystal INSTANCE;
    private final BooleanSetting multiPlace;
    private final BooleanSetting noEating;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean pistonActive(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383) {
        void a;
        void a2;
        PullCrystal a3 = this;
        PullCrystal a4 = class_23383;
        if (a3.pistonActive((class_2338)a2, (class_2350)a, (class_2338)a4, false)) {
            return true;
        }
        return a3.pistonActive((class_2338)a2, (class_2350)a, (class_2338)a4, true);
    }

    public int findClass(Class class_) {
        Class a = class_;
        PullCrystal a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(a);
        }
        return InventoryUtil.findClass(a);
    }

    private /* synthetic */ boolean power(class_2338 a) {
        PullCrystal a2;
        int n;
        PullCrystal pullCrystal = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                class_2338 class_23382 = a;
                PullCrystal pullCrystal2 = a2;
                int n4 = class_23382.method_10093((class_2350)pullCrystal2).method_10263() - a.method_10263();
                int n5 = class_23382.method_10093((class_2350)pullCrystal2).method_10260() - a.method_10260();
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, -2), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, -2).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, -2).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, 1).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, 1).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, -1).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePower(a.method_10079((class_2350)a2, -1).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
            }
            n3 = ++n;
        }
        return false;
    }

    private /* synthetic */ boolean breakCrystal(class_2338 class_23382) {
        Object a = class_23382;
        PullCrystal a2 = this;
        Object object = a = PullCrystal.mc.field_1687.method_18467(class_1511.class, new class_238((class_2338)a)).iterator();
        while (object.hasNext()) {
            class_1511 class_15112 = (class_1511)a.next();
            PullCrystal pullCrystal = a2;
            if (!(ThunderExplosionUtil.calculateDamage(class_15112.method_19538(), pullCrystal.target, pullCrystal.target, 6.0f) > 6.0f)) {
                object = a;
                continue;
            }
            CombatUtil.attackCrystal((class_1297)class_15112, a2.rotate.getValue(), true);
            return true;
        }
        return false;
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

    private /* synthetic */ boolean canPlace(class_2338 class_23382) {
        PullCrystal a = class_23382;
        PullCrystal a2 = this;
        if (a2.checkMine.getValue() && BlockUtil.isMining((class_2338)a)) {
            return false;
        }
        return BlockUtil.canPlace((class_2338)a, a2.range.getValueFloat());
    }

    private /* synthetic */ boolean piston(class_2338 a) {
        PullCrystal a2;
        int n;
        PullCrystal pullCrystal = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                class_2338 class_23382 = a;
                PullCrystal pullCrystal2 = a2;
                int n4 = class_23382.method_10093((class_2350)pullCrystal2).method_10263() - a.method_10263();
                int n5 = class_23382.method_10093((class_2350)pullCrystal2).method_10260() - a.method_10260();
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, -2), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, -2).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, -2).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, 1).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, 1).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, -1).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.placePiston(a.method_10079((class_2350)a2, -1).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
            }
            n3 = ++n;
        }
        return false;
    }

    @Override
    public String getInfo() {
        PullCrystal a;
        if (a.target != null) {
            return a.target.method_5477().getString();
        }
        return null;
    }

    public int findItem(class_1792 class_17922) {
        PullCrystal a = class_17922;
        PullCrystal a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findItemInventorySlot((class_1792)a);
        }
        return InventoryUtil.findItem((class_1792)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean placePower(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383) {
        void a;
        void a2;
        PullCrystal a3 = this;
        PullCrystal a4 = class_23383;
        if (a3.placePower((class_2338)a2, (class_2350)a, (class_2338)a4, false)) {
            return true;
        }
        return a3.placePower((class_2338)a2, (class_2350)a, (class_2338)a4, true);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean placeRedStone(class_2338 class_23382, class_2350 class_23502, int n, class_2338 class_23383) {
        int n2;
        void a;
        int n3;
        void a2;
        void a3;
        PullCrystal a4 = class_23382;
        PullCrystal a5 = this;
        class_2350 class_23503 = class_2350.values();
        int n4 = ((class_2350[])class_23503).length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            class_2350 class_23504 = class_23503[n2];
            if (BlockUtil.getBlock(a4.method_10093(class_23504)) == class_2246.field_10002) {
                powerPos = a4.method_10093(class_23504);
                return true;
            }
            n5 = ++n2;
        }
        class_23503 = BlockUtil.getBestNeighboring((class_2338)a4, (class_2350)a2);
        n4 = a5.findBlock(class_2246.field_10002);
        if (class_23503 != null && !a4.method_10093(class_23503).equals((Object)a3.method_10079((class_2350)a2, -1)) && !a4.method_10093(class_23503).equals((Object)a3.method_10079((class_2350)a2, -1).method_10084()) && BlockUtil.canPlace(powerPos = a4.method_10093(class_23503))) {
            PullCrystal pullCrystal = a5;
            pullCrystal.doSwap(n4);
            BlockUtil.placeBlock(a4.method_10093(class_23503), a5.rotate.getValue());
            PullCrystal pullCrystal2 = a5;
            if (pullCrystal.inventory.getValue()) {
                pullCrystal2.doSwap(n4);
                EntityUtil.syncInventory();
            } else {
                pullCrystal2.doSwap((int)a);
            }
            return true;
        }
        class_2350[] arrclass_2350 = class_2350.values();
        int n6 = arrclass_2350.length;
        int n7 = n3 = 0;
        while (n7 < n6) {
            class_2350 class_23505 = arrclass_2350[n3];
            if (!a4.method_10093(class_23505).equals((Object)a4.method_10079((class_2350)a2, -1)) && !a4.method_10093(class_23505).equals((Object)a3.method_10079((class_2350)a2, -1)) && !a4.method_10093(class_23505).equals((Object)a3.method_10079((class_2350)a2, -1).method_10084()) && BlockUtil.canPlace(a4.method_10093(class_23505))) {
                powerPos = a4.method_10093(class_23505);
                a5.doSwap(n4);
                BlockUtil.placeBlock(a4.method_10093(class_23505), true);
                PullCrystal pullCrystal = a5;
                if (a5.inventory.getValue()) {
                    pullCrystal.doSwap(n4);
                    EntityUtil.syncInventory();
                } else {
                    pullCrystal.doSwap((int)a);
                }
                return true;
            }
            n7 = ++n3;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean placePiston(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383, boolean bl) {
        void a;
        int a2;
        void a3;
        PullCrystal a4 = class_23382;
        PullCrystal a5 = this;
        if (a2 != 0) {
            a4 = a4.method_10084();
        }
        if (!BlockUtil.canPlaceCrystal(a.method_10079((class_2350)a3, -1)) && !BlockUtil.hasCrystal(a.method_10079((class_2350)a3, -1))) {
            return false;
        }
        if (!a5.canPlace((class_2338)a4) && !(BlockUtil.getBlock((class_2338)a4) instanceof class_2665)) {
            return false;
        }
        if (BlockUtil.getBlock((class_2338)a4) instanceof class_2665 && ((class_2350)BlockUtil.getState((class_2338)a4).method_11654((class_2769)class_2318.field_10927)).method_10153() != a3) {
            return false;
        }
        if (BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) == class_2246.field_10379 || BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) == class_2246.field_10008) {
            return true;
        }
        if (!PullCrystal.mc.field_1687.method_22347(a4.method_10079((class_2350)a3, -1)) && BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) != class_2246.field_10379 && BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) != class_2246.field_10008) {
            return false;
        }
        if ((PullCrystal.mc.field_1724.method_23318() - (double)a4.method_10074().method_10264() <= -1.0 || PullCrystal.mc.field_1724.method_23318() - (double)a4.method_10074().method_10264() >= 2.0) && BlockUtil.distanceToXZ((double)a4.method_10263() + 0.5, (double)a4.method_10260() + 0.5) < 2.6) {
            return false;
        }
        a2 = PullCrystal.mc.field_1724.method_31548().field_7545;
        if (a5.canPlace((class_2338)a4)) {
            PullCrystal pullCrystal;
            PullCrystal pullCrystal2 = a4;
            class_2350 class_23503 = BlockUtil.getPlaceSide((class_2338)pullCrystal2);
            EntityUtil.facePosSide((class_2338)pullCrystal2, class_23503);
            PullCrystal pullCrystal3 = a5;
            PullCrystal.pistonFacing((class_2350)a3);
            int n = pullCrystal3.findClass(class_2665.class);
            pullCrystal3.doSwap(n);
            BlockUtil.placeBlock((class_2338)pullCrystal2, false);
            PullCrystal pullCrystal4 = a5;
            if (a5.inventory.getValue()) {
                pullCrystal4.doSwap(n);
                EntityUtil.syncInventory();
                pullCrystal = a4;
            } else {
                pullCrystal4.doSwap(a2);
                pullCrystal = a4;
            }
            EntityUtil.facePosSide((class_2338)pullCrystal, class_23503);
            if (a5.multiPlace.getValue() && a5.placeRedStone((class_2338)a4, (class_2350)a3, a2, (class_2338)a)) {
                return true;
            }
            return true;
        }
        return a5.placeRedStone((class_2338)a4, (class_2350)a3, a2, (class_2338)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doFire(class_2338 class_23382, class_2350 class_23502) {
        int n;
        int n2;
        int n3;
        int n4;
        void a;
        int[] arrn;
        int n5;
        int n6;
        int[] arrn2;
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
        int n10 = PullCrystal.mc.field_1724.method_31548().field_7545;
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
        int n12 = n6 = 0;
        while (n12 < n11) {
            n = arrn8[n6];
            arrn = arrn6;
            n4 = arrn.length;
            int n13 = n2 = 0;
            while (n13 < n4) {
                n5 = arrn[n2];
                arrn2 = a2;
                n7 = arrn2.length;
                int n14 = n3 = 0;
                while (n14 < n7) {
                    n8 = arrn2[n3];
                    if (BlockUtil.getBlock(a.method_10069(n, n5, n8)) == class_2246.field_10036) {
                        return;
                    }
                    n14 = ++n3;
                }
                n13 = ++n2;
            }
            n12 = ++n6;
        }
        arrn8 = arrn4;
        n11 = arrn8.length;
        int n15 = n6 = 0;
        while (n15 < n11) {
            n = arrn8[n6];
            arrn = arrn6;
            n4 = arrn.length;
            int n16 = n2 = 0;
            while (n16 < n4) {
                n5 = arrn[n2];
                arrn2 = a2;
                n7 = arrn2.length;
                int n17 = n3 = 0;
                while (n17 < n7) {
                    n8 = arrn2[n3];
                    if (PullCrystal.canFire(a.method_10069(n, n5, n8))) {
                        int[] arrn9 = a3;
                        arrn9.doSwap(a3.findItem(class_1802.field_8884));
                        arrn9.placeFire(a.method_10069(n, n5, n8));
                        int[] arrn10 = a3;
                        if (a3.inventory.getValue()) {
                            arrn10.doSwap(n9);
                            EntityUtil.syncInventory();
                            return;
                        }
                        arrn10.doSwap(n10);
                        return;
                    }
                    n17 = ++n3;
                }
                n16 = ++n2;
            }
            n15 = ++n6;
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean placePiston(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383) {
        void a;
        void a2;
        PullCrystal a3 = this;
        PullCrystal a4 = class_23383;
        if (a3.placePiston((class_2338)a2, (class_2350)a, (class_2338)a4, false)) {
            return true;
        }
        return a3.placePiston((class_2338)a2, (class_2350)a, (class_2338)a4, true);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        PullCrystal a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, PullCrystal.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ void placeFire(class_2338 class_23382) {
        PullCrystal a = class_23382;
        PullCrystal a2 = this;
        BlockUtil.clickBlock(a.method_10093(class_2350.field_11033), class_2350.field_11036, a2.rotate.getValue());
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean placePower(class_2338 class_23382, class_2350 class_23502, class_2338 class_23383, boolean bl) {
        void a;
        int a2;
        void a3;
        PullCrystal a4 = class_23382;
        PullCrystal a5 = this;
        if (a2 != 0) {
            a4 = a4.method_10084();
        }
        if (!BlockUtil.canPlaceCrystal(a.method_10079((class_2350)a3, -1)) && !BlockUtil.hasCrystal(a.method_10079((class_2350)a3, -1))) {
            return false;
        }
        if (!(BlockUtil.getBlock((class_2338)a4) instanceof class_2665)) {
            return false;
        }
        if (((class_2350)BlockUtil.getState((class_2338)a4).method_11654((class_2769)class_2318.field_10927)).method_10153() != a3) {
            return false;
        }
        if (BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) == class_2246.field_10379 || BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) == class_2246.field_10008) {
            return true;
        }
        if (!PullCrystal.mc.field_1687.method_22347(a4.method_10079((class_2350)a3, -1)) && BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) != class_2246.field_10379 && BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) != class_2246.field_10008 && BlockUtil.getBlock(a4.method_10079((class_2350)a3, -1)) != class_2246.field_10036) {
            return false;
        }
        a2 = PullCrystal.mc.field_1724.method_31548().field_7545;
        return a5.placeRedStone((class_2338)a4, (class_2350)a3, a2, (class_2338)a);
    }

    public int findBlock(class_2248 class_22482) {
        PullCrystal a = class_22482;
        PullCrystal a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    private static /* synthetic */ boolean canFire(class_2338 a) {
        if (BlockUtil.canReplace(a.method_10074()) || !BlockUtil.canClick(a.method_10074())) {
            return false;
        }
        return PullCrystal.mc.field_1687.method_22347(a);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean pistonActive(class_2338 var1_1, class_2350 var2_2, class_2338 var3_3, boolean var4_4) {
        block10 : {
            a = var2_2;
            a = this;
            if (a != false) {
                a = a.method_10084();
            }
            if (!BlockUtil.canPlaceCrystal(a.method_10079((class_2350)a, -1)) && !BlockUtil.hasCrystal(a.method_10079((class_2350)a, -1))) {
                return false;
            }
            if (!(BlockUtil.getBlock(a) instanceof class_2665)) {
                return false;
            }
            if (((class_2350)BlockUtil.getState(a).method_11654((class_2769)class_2318.field_10927)).method_10153() != a) {
                return false;
            }
            if (BlockUtil.getBlock(a.method_10079((class_2350)a, -1)) == class_2246.field_10008) {
                return true;
            }
            if (BlockUtil.getBlock(a.method_10079((class_2350)a, -1)) != class_2246.field_10379) {
                return false;
            }
            a = class_2350.values();
            var5_6 = a.length;
            v0 = var6_7 = 0;
            while (v0 < var5_6) {
                var7_8 = a[var6_7];
                if (BlockUtil.getBlock(a.method_10093(var7_8)) != class_2246.field_10002) {
                    v0 = ++var6_7;
                    continue;
                }
                break block10;
            }
            return false;
        }
        if (BlockUtil.hasCrystal(a.method_10079((class_2350)a, -1))) ** GOTO lbl40
        var8_9 = PullCrystal.mc.field_1724.method_31548().field_7545;
        v1 = a;
        PullCrystal.crystalPos = a.method_10079((class_2350)a, -1);
        var9_10 = a.findItem(class_1802.field_8301);
        v1.doSwap(var9_10);
        BlockUtil.placeCrystal(a.method_10079((class_2350)a, -1), a.rotate.getValue());
        v2 = a;
        if (v1.inventory.getValue()) {
            v2.doSwap(var9_10);
            EntityUtil.syncInventory();
            v3 = a;
        } else {
            v2.doSwap(var8_9);
lbl40: // 2 sources:
            v3 = a;
        }
        v3.doFire((class_2338)a, (class_2350)a);
        PullCrystal.powerPos = a.method_10093(var7_8);
        SpeedMine.INSTANCE.mine(a.method_10093(var7_8));
        return true;
    }

    private /* synthetic */ boolean doPullCrystal(class_2338 class_23382) {
        PullCrystal a = this;
        PullCrystal a2 = class_23382;
        if (a.pull(a2.method_10086(2))) {
            return true;
        }
        if (a.pull(a2.method_10084())) {
            return true;
        }
        if (a.power(a2.method_10086(2))) {
            return true;
        }
        if (a.power(a2.method_10084())) {
            return true;
        }
        PullCrystal pullCrystal = a;
        if (pullCrystal.timer.passedMs(pullCrystal.pistonDelay.getValueInt())) {
            if (a.piston(a2.method_10086(2))) {
                return true;
            }
            return a.piston(a2.method_10084());
        }
        return false;
    }

    public PullCrystal() {
        PullCrystal a;
        PullCrystal pullCrystal = a;
        PullCrystal pullCrystal2 = a;
        super(BaseChildSettings.ALLATORIxDEMO("VR?L\u0017U*I:\u0011h"), RenderHelper.ALLATORIxDEMO("\u0003z\n0\u001fy3K\u001e`Zu\u0005c\u001b(\u0001o\u0016cK!\u00065\f|\u000e5\u0015gR/"), Module.Category.Combat);
        PullCrystal pullCrystal3 = a;
        pullCrystal3.range = pullCrystal2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("\u0001[ \u0017a"), 5.0, 1.0, 8.0));
        pullCrystal2.rotate = pullCrystal2.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("8z\u0003iI'"), true));
        pullCrystal2.fire = pullCrystal2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("|'\u0002a"), true));
        pullCrystal2.checkMine = pullCrystal2.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("V\u0005w\t~:aS'"), true));
        pullCrystal2.noEating = pullCrystal2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("n;b2N'\u001ec"), true));
        pullCrystal2.multiPlace = pullCrystal2.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("'`\u0001f\u0003E\u001bi^'"), false));
        pullCrystal2.onlyGround = pullCrystal2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u001dU\u000f\u0019v"), true));
        pullCrystal2.onlyStatic = pullCrystal2.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("#}'z\u0001aS%"), true));
        pullCrystal2.inventory = pullCrystal2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u001f\u001cpB=T;U*i9\u0011t"), true));
        pullCrystal2.updateDelay = pullCrystal2.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("\u0015\u001aq\ff\u000fQ\u0012d\\;"), 100, 0, 500));
        a.pistonDelay = a.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("VN T;I\u0017_\"\u0011}"), 200, 0, 500));
        a.target = null;
        pullCrystal.timer = new Timer();
        pullCrystal.setChinese(RenderHelper.ALLATORIxDEMO("\u6d2e\u5829\u62c1\u6c09\u6634"));
        INSTANCE = pullCrystal;
    }

    /*
     * WARNING - void declaration
     */
    public boolean check(boolean bl, boolean bl2, boolean bl3) {
        void a;
        void a2;
        boolean a3 = bl3;
        PullCrystal a4 = this;
        if (MovementUtil.isMoving() && a != false) {
            return true;
        }
        if (a2 != false && a3) {
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

    private /* synthetic */ boolean pull(class_2338 a) {
        PullCrystal a2;
        int n;
        PullCrystal pullCrystal = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                class_2338 class_23382 = a;
                PullCrystal pullCrystal2 = a2;
                int n4 = class_23382.method_10093((class_2350)pullCrystal2).method_10263() - a.method_10263();
                int n5 = class_23382.method_10093((class_2350)pullCrystal2).method_10260() - a.method_10260();
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, -2), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, -2).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, -2).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, 1).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, 1).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, -1).method_10069(n5, 0, n4), (class_2350)a2, a)) {
                    return true;
                }
                if (pullCrystal.pistonActive(a.method_10079((class_2350)a2, -1).method_10069(-n5, 0, -n4), (class_2350)a2, a)) {
                    return true;
                }
            }
            n3 = ++n;
        }
        return false;
    }

    @Override
    public void onUpdate() {
        PullCrystal pullCrystal;
        boolean bl;
        PullCrystal a;
        PullCrystal pullCrystal2;
        PullCrystal pullCrystal3 = pullCrystal2 = a;
        if (!pullCrystal3.timer.passedMs((long)pullCrystal3.updateDelay.getValue())) {
            return;
        }
        if (pullCrystal2.noEating.getValue() && EntityUtil.isUsing()) {
            pullCrystal2.target = null;
            return;
        }
        PullCrystal pullCrystal4 = pullCrystal2;
        if (!PullCrystal.mc.field_1724.method_24828()) {
            bl = true;
            pullCrystal = pullCrystal2;
        } else {
            bl = false;
            pullCrystal = pullCrystal2;
        }
        if (pullCrystal4.check(pullCrystal4.onlyStatic.getValue(), bl, pullCrystal.onlyGround.getValue())) {
            pullCrystal2.target = null;
            return;
        }
        PullCrystal pullCrystal5 = pullCrystal2;
        pullCrystal5.target = CombatUtil.getClosestEnemy(pullCrystal5.range.getValue());
        if (pullCrystal5.target == null) {
            return;
        }
        PullCrystal pullCrystal6 = pullCrystal2;
        a = EntityUtil.getEntityPos((class_1297)pullCrystal6.target);
        if (pullCrystal6.breakCrystal(a.method_10086(0))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.breakCrystal(a.method_10086(1))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.breakCrystal(a.method_10086(2))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.breakCrystal(a.method_10086(3))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.doPullCrystal((class_2338)a)) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.doPullCrystal(new BlockPosX(pullCrystal2.target.method_23317() + 0.1, pullCrystal2.target.method_23318() + 0.5, pullCrystal2.target.method_23321() + 0.1))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.doPullCrystal(new BlockPosX(pullCrystal2.target.method_23317() - 0.1, pullCrystal2.target.method_23318() + 0.5, pullCrystal2.target.method_23321() + 0.1))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.doPullCrystal(new BlockPosX(pullCrystal2.target.method_23317() + 0.1, pullCrystal2.target.method_23318() + 0.5, pullCrystal2.target.method_23321() - 0.1))) {
            pullCrystal2.timer.reset();
            return;
        }
        if (pullCrystal2.doPullCrystal(new BlockPosX(pullCrystal2.target.method_23317() - 0.1, pullCrystal2.target.method_23318() + 0.5, pullCrystal2.target.method_23321() - 0.1))) {
            pullCrystal2.timer.reset();
            return;
        }
    }
}
