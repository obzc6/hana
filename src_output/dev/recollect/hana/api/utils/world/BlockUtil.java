/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1303
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1667
 *  net.minecraft.class_1683
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_1923
 *  net.minecraft.class_2244
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2818
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_7202
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.world;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.asm.accessors.IClientWorld;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.Placement;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1667;
import net.minecraft.class_1683;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1923;
import net.minecraft.class_2244;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2848;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_7202;
import net.minecraft.class_746;

public class BlockUtil
implements Wrapper {
    public static final List<class_2248> shiftBlocks;
    public static final ArrayList<class_2338> placedPos;

    public static ArrayList<class_2586> getTileEntities() {
        return BlockUtil.getLoadedChunks().flatMap(a -> a.method_12214().values().stream()).collect(Collectors.toCollection(ArrayList::new));
    }

    public static class_7202 getUpdateManager(class_638 a) {
        return ((IClientWorld)a).acquirePendingUpdateManager();
    }

    static {
        class_2248[] arrclass_2248 = new class_2248[30];
        arrclass_2248[0] = class_2246.field_10443;
        arrclass_2248[1] = class_2246.field_10034;
        arrclass_2248[2] = class_2246.field_10380;
        arrclass_2248[3] = class_2246.field_9980;
        arrclass_2248[4] = class_2246.field_10486;
        arrclass_2248[5] = class_2246.field_40285;
        arrclass_2248[6] = class_2246.field_10246;
        arrclass_2248[7] = class_2246.field_42740;
        arrclass_2248[8] = class_2246.field_10535;
        arrclass_2248[9] = class_2246.field_10333;
        arrclass_2248[10] = class_2246.field_10312;
        arrclass_2248[11] = class_2246.field_10228;
        arrclass_2248[12] = class_2246.field_10200;
        arrclass_2248[13] = class_2246.field_10608;
        arrclass_2248[14] = class_2246.field_10485;
        arrclass_2248[15] = class_2246.field_10199;
        arrclass_2248[16] = class_2246.field_10407;
        arrclass_2248[17] = class_2246.field_10063;
        arrclass_2248[18] = class_2246.field_10203;
        arrclass_2248[19] = class_2246.field_10600;
        arrclass_2248[20] = class_2246.field_10275;
        arrclass_2248[21] = class_2246.field_10051;
        arrclass_2248[22] = class_2246.field_10140;
        arrclass_2248[23] = class_2246.field_10532;
        arrclass_2248[24] = class_2246.field_10268;
        arrclass_2248[25] = class_2246.field_10605;
        arrclass_2248[26] = class_2246.field_10373;
        arrclass_2248[27] = class_2246.field_10055;
        arrclass_2248[28] = class_2246.field_10068;
        arrclass_2248[29] = class_2246.field_10371;
        shiftBlocks = Arrays.asList(arrclass_2248);
        placedPos = new ArrayList();
    }

    public static boolean isMining(class_2338 a) {
        return Hana.BREAK.isMining(a) || a.equals((Object)SpeedMine.breakPos);
    }

    public static int getWorldActionId(class_638 a2) {
        class_638 class_6382 = a2;
        class_7202 class_72022 = BlockUtil.getUpdateManager(class_6382);
        int a2 = class_72022.method_41942();
        class_72022.close();
        return a2;
    }

    /*
     * WARNING - void declaration
     */
    public static void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, class_1268 class_12682) {
        void a;
        void a2;
        class_2338 a3 = class_12682;
        class_2338 a4 = class_23382;
        BlockUtil.clickBlock(a4, (class_2350)a2, (boolean)a, (class_1268)a3, CombatSetting.INSTANCE.packetPlace.getValue());
    }

    public static List<class_1511> getEndCrystals(class_238 a2) {
        class_238 class_2382 = a2;
        ArrayList<class_1511> arrayList = new ArrayList<class_1511>();
        for (class_238 a2 : BlockUtil.mc.field_1687.method_18112()) {
            if (!(a2 instanceof class_1511) || !(a2 = (class_1511)a2).method_5829().method_994(class_2382)) continue;
            arrayList.add((class_1511)a2);
        }
        return arrayList;
    }

    public static boolean needSneak(class_2248 a) {
        return shiftBlocks.contains((Object)a);
    }

    public static Stream<class_2338> getAllInBoxStream(class_2338 class_23382, int n) {
        int a = n;
        class_2338 a2 = class_23382;
        int n2 = a;
        return BlockUtil.getAllInBoxStream(a2.method_10069(-a, -a, -a), a2.method_10069(n2, n2, n2));
    }

    public static boolean clientCanPlace(class_2338 a) {
        return BlockUtil.clientCanPlace(a, false);
    }

    /*
     * WARNING - void declaration
     */
    public static ArrayList<class_2350> checkAxis(double d, class_2350 class_23502, class_2350 class_23503, boolean bl) {
        void a;
        void a2;
        double a3;
        class_2350 class_23504 = class_23502;
        ArrayList<class_2350> a4 = new ArrayList<class_2350>();
        if (a3 < -0.5) {
            a4.add(class_23504);
        }
        if (a3 > 0.5) {
            a4.add((class_2350)a2);
        }
        if (a != false) {
            if (!a4.contains((Object)class_23504)) {
                a4.add(class_23504);
            }
            if (!a4.contains(a2)) {
                a4.add((class_2350)a2);
            }
        }
        return a4;
    }

    public static List<class_1297> getEntities(class_238 a2) {
        class_238 class_2382 = a2;
        ArrayList<class_1297> arrayList = new ArrayList<class_1297>();
        for (class_238 a2 : BlockUtil.mc.field_1687.method_18112()) {
            if (a2 == null || !a2.method_5829().method_994(class_2382)) continue;
            arrayList.add((class_1297)a2);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ class_1923 lambda$getLoadedChunks$1(class_1923 class_19232, class_1923 class_19233, class_1923 class_19234) {
        class_1923 a22 = class_19234;
        class_1923 a = class_19232;
        class_1923 class_19235 = a22;
        int a22 = class_19235.field_9181;
        int n = class_19235.field_9180;
        if (++a22 > a.field_9181) {
            void a3;
            ++n;
            a22 = a3.field_9181;
        }
        return new class_1923(a22, n);
    }

    /*
     * WARNING - void declaration
     */
    public static void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, class_1268 class_12682, SwingSide swingSide) {
        void a;
        void a2;
        void a3;
        class_2338 a4 = class_23502;
        class_2338 a5 = class_23382;
        class_243 class_2432 = new class_243((double)a5.method_10263() + 0.5 + (double)a4.method_10163().method_10263() * 0.5, (double)a5.method_10264() + 0.5 + (double)a4.method_10163().method_10264() * 0.5, (double)a5.method_10260() + 0.5 + (double)a4.method_10163().method_10260() * 0.5);
        if (a3 != false) {
            EntityUtil.faceVector(class_2432);
        }
        EntityUtil.swingHand((class_1268)a2, (SwingSide)a);
        a4 = new class_3965(class_2432, (class_2350)a4, a5, false);
        BlockUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2885((class_1268)a2, (class_3965)a4, BlockUtil.getWorldActionId(BlockUtil.mc.field_1687)));
    }

    public static double distanceToXZ(double a, double a2, double a3, double a4) {
        a2 = a4 - a2;
        double d = a3 -= a;
        double d2 = a2;
        return Math.sqrt(d * d + d2 * d2);
    }

    public static ArrayList<class_2338> getSphere(float a) {
        return BlockUtil.getSphere(a, BlockUtil.mc.field_1724.method_33571());
    }

    public static boolean canBlockFacing(class_2338 a) {
        class_2338 class_23382 = a;
        boolean bl = false;
        class_2350[] arrclass_2350 = class_2350.values();
        int n = arrclass_2350.length;
        int n2 = a = 0;
        while (n2 < n) {
            class_2350 class_23502 = arrclass_2350[a];
            if (BlockUtil.canClick(class_23382.method_10093(class_23502))) {
                bl = true;
            }
            n2 = ++a;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean canPlace(class_2338 class_23382, double d, boolean bl) {
        void a;
        boolean a2 = bl;
        class_2338 a3 = class_23382;
        if (BlockUtil.getPlaceSide(a3, (double)a) == null) {
            return false;
        }
        if (!BlockUtil.canReplace(a3)) {
            return false;
        }
        return !BlockUtil.hasEntity(a3, a2);
    }

    public static boolean isStrictDirection(class_2338 a3, class_2350 a2) {
        class_2338 class_23382 = a3;
        class_2680 class_26802 = BlockUtil.mc.field_1687.method_8320(class_23382);
        boolean a3 = class_26802.method_26204() == class_2246.field_10124 || class_26802.method_26234((class_1922)BlockUtil.mc.field_1687, class_23382) || BlockUtil.getBlock(class_23382) == class_2246.field_10343;
        return BlockUtil.isStrictDirection(class_23382, a2, a3);
    }

    /*
     * WARNING - void declaration
     */
    public static boolean isHole(class_2338 class_23382, boolean bl, boolean bl2, boolean bl3) {
        void a;
        void a2;
        int n;
        class_2338 class_23383 = class_23382;
        int n2 = 0;
        class_2350[] arrclass_2350 = class_2350.values();
        int n3 = arrclass_2350.length;
        int n4 = n = 0;
        while (n4 < n3) {
            void a3;
            class_2338 a4 = arrclass_2350[n];
            if (a4 != class_2350.field_11036 && a4 != class_2350.field_11033 && (a3 != false && !BlockUtil.mc.field_1687.method_22347(class_23383.method_10093((class_2350)a4)) || CombatUtil.isHard(class_23383.method_10093((class_2350)a4)))) {
                ++n2;
            }
            n4 = ++n;
        }
        return (a2 == false || BlockUtil.getBlock(class_23383) == class_2246.field_10124 && BlockUtil.getBlock(class_23383.method_10069(0, 1, 0)) == class_2246.field_10124 && BlockUtil.getBlock(class_23383.method_10069(0, 2, 0)) == class_2246.field_10124) && n2 > 3 && (a == false || BlockUtil.getState(class_23383.method_10069(0, -1, 0)).method_51366());
    }

    public static class_2350 getClickSide(class_2338 a) {
        int n;
        class_2338 class_23382 = a;
        if (class_23382.equals((Object)EntityUtil.getPlayerPos())) {
            return class_2350.field_11036;
        }
        class_2350 class_23502 = null;
        double d = 100.0;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a = arrclass_2350[n];
            if (EntityUtil.canSee(class_23382, (class_2350)a) && !((double)class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558()))) > d)) {
                class_23502 = a;
                d = class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558())));
            }
            n3 = ++n;
        }
        if (class_23502 != null) {
            return class_23502;
        }
        class_23502 = class_2350.field_11036;
        arrclass_2350 = class_2350.values();
        n2 = arrclass_2350.length;
        int n4 = n = 0;
        while (n4 < n2) {
            a = arrclass_2350[n];
            if ((CombatSetting.INSTANCE.placement.getValue() != Placement.Strict || BlockUtil.isStrictDirection(class_23382, (class_2350)a) && BlockUtil.isAir(class_23382.method_10093((class_2350)a))) && !((double)class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558()))) > d)) {
                class_23502 = a;
                d = class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558())));
            }
            n4 = ++n;
        }
        return class_23502;
    }

    public static ArrayList<class_2338> getAllInBox(class_2338 class_23382, class_2338 class_23383) {
        int n;
        class_2338 a = class_23383;
        class_2338 a2 = class_23382;
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        class_2338 class_23384 = new class_2338(Math.min(a2.method_10263(), a.method_10263()), Math.min(a2.method_10264(), a.method_10264()), Math.min(a2.method_10260(), a.method_10260()));
        a = new class_2338(Math.max(a2.method_10263(), a.method_10263()), Math.max(a2.method_10264(), a.method_10264()), Math.max(a2.method_10260(), a.method_10260()));
        int n2 = n = class_23384.method_10263();
        while (n2 <= a.method_10263()) {
            int n3 = class_23384.method_10264();
            while (n3 <= a.method_10264()) {
                int n4;
                int n5 = class_23384.method_10260();
                while (n5 <= a.method_10260()) {
                    int n6;
                    arrayList.add(new class_2338(n, n4, n6++));
                    n5 = n6;
                }
                n3 = ++n4;
            }
            n2 = ++n;
        }
        return arrayList;
    }

    public BlockUtil() {
        BlockUtil a;
    }

    public static class_2680 getState(class_2338 a) {
        return BlockUtil.mc.field_1687.method_8320(a);
    }

    /*
     * WARNING - void declaration
     */
    public static void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, class_1268 class_12682, boolean bl2) {
        void a;
        void a2;
        void a3;
        class_2338 a4 = class_23502;
        class_2338 a5 = class_23382;
        class_243 class_2432 = new class_243((double)a5.method_10263() + 0.5 + (double)a4.method_10163().method_10263() * 0.5, (double)a5.method_10264() + 0.5 + (double)a4.method_10163().method_10264() * 0.5, (double)a5.method_10260() + 0.5 + (double)a4.method_10163().method_10260() * 0.5);
        if (a3 != false) {
            EntityUtil.faceVector(class_2432);
        }
        EntityUtil.swingHand((class_1268)a2, CombatSetting.INSTANCE.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a4, a5, false);
        if (a != false) {
            BlockUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(BlockUtil.mc.field_1687)));
            return;
        }
        BlockUtil.mc.field_1761.method_2896(BlockUtil.mc.field_1724, (class_1268)a2, (class_3965)a4);
    }

    public static void placeCrystal(class_2338 a, boolean a2) {
        class_2338 class_23382 = a;
        boolean bl = BlockUtil.mc.field_1724.method_6079().method_7909() == class_1802.field_8301;
        class_2338 class_23383 = class_23382.method_10074();
        a = BlockUtil.getClickSide(class_23383);
        class_243 class_2432 = class_23383.method_46558().method_1031((double)a.method_10163().method_10263() * 0.5, (double)a.method_10163().method_10264() * 0.5, (double)a.method_10163().method_10260() * 0.5);
        if (a2) {
            EntityUtil.faceVector(class_2432);
        }
        BlockUtil.clickBlock(class_23383, (class_2350)a, false, bl ? class_1268.field_5810 : class_1268.field_5808);
    }

    /*
     * WARNING - void declaration
     */
    public static class_2350 getBestNeighboring(class_2338 class_23382, class_2350 class_23502) {
        void a;
        class_2350[] arrclass_2350;
        int n;
        int n2;
        class_2338 class_23383 = class_23382;
        class_2338 class_23384 = class_2350.values();
        int n3 = ((class_2350[])class_23384).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            arrclass_2350 = class_23384[n2];
            if (!(a != null && class_23383.method_10093((class_2350)arrclass_2350).equals((Object)class_23383.method_10079((class_2350)a, -1)) || arrclass_2350 == class_2350.field_11033 || BlockUtil.getPlaceSide(class_23383, false, true) == null)) {
                return arrclass_2350;
            }
            n4 = ++n2;
        }
        class_23384 = null;
        double d = 0.0;
        arrclass_2350 = class_2350.values();
        int n5 = arrclass_2350.length;
        int n6 = n = 0;
        while (n6 < n5) {
            class_2338 a2 = arrclass_2350[n];
            if (!(a != null && class_23383.method_10093((class_2350)a2).equals((Object)class_23383.method_10079((class_2350)a, -1)) || a2 == class_2350.field_11033 || BlockUtil.getPlaceSide(class_23383) == null || class_23384 != null && !(BlockUtil.mc.field_1724.method_5707(class_23383.method_10093((class_2350)a2).method_46558()) < d))) {
                class_23384 = a2;
                d = BlockUtil.mc.field_1724.method_5707(class_23383.method_10093((class_2350)a2).method_46558());
            }
            n6 = ++n;
        }
        return class_23384;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean hasEntity(class_2338 a, boolean a2) {
        class_2338 class_23382 = a;
        Iterator iterator = BlockUtil.mc.field_1687.method_18467(class_1297.class, new class_238(class_23382)).iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = (class_1297)iterator.next();
                if (!a.method_5805() || a instanceof class_1542 || a instanceof class_1303 || a instanceof class_1683 || a instanceof class_1667 || a2 && a instanceof class_1511) continue block0;
                if (!(a instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                iterator2 = iterator;
            }
            break;
        } while (true);
        return false;
    }

    public static boolean canPlace(class_2338 a) {
        return BlockUtil.canPlace(a, 1000.0);
    }

    /*
     * WARNING - void declaration
     */
    public static class_2350 getPlaceSide(class_2338 class_23382, double d) {
        int n;
        class_2338 a;
        class_2338 class_23383 = class_23382;
        double d2 = 114514.0;
        class_2338 class_23384 = null;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a = arrclass_2350[n];
            if (BlockUtil.canClick(class_23383.method_10093((class_2350)a)) && !BlockUtil.canReplace(class_23383.method_10093((class_2350)a)) && !(CombatSetting.INSTANCE.placement.getValue() == Placement.Legit ? !EntityUtil.canSee(class_23383.method_10093((class_2350)a), a.method_10153()) : CombatSetting.INSTANCE.placement.getValue() == Placement.Strict && !BlockUtil.isStrictDirection(class_23383.method_10093((class_2350)a), a.method_10153()))) {
                void a2;
                double d3;
                double d4 = BlockUtil.mc.field_1724.method_5707(class_23383.method_46558().method_1031((double)a.method_10163().method_10263() * 0.5, (double)a.method_10163().method_10264() * 0.5, (double)a.method_10163().method_10260() * 0.5));
                if (!((double)class_3532.method_15355((float)((float)d3)) > a2) && (class_23384 == null || d4 < d2)) {
                    class_23384 = a;
                    d2 = d4;
                }
            }
            n3 = ++n;
        }
        if (class_23384 == null && BlockUtil.airPlace()) {
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n4 = n = 0;
            while (n4 < n2) {
                a = arrclass_2350[n];
                if (BlockUtil.mc.field_1687.method_22347(class_23383.method_10093((class_2350)a))) {
                    return a;
                }
                n4 = ++n;
            }
        }
        return class_23384;
    }

    public static void placeBlock(class_2338 class_23382, boolean bl) {
        boolean a = bl;
        class_2338 a2 = class_23382;
        BlockUtil.placeBlock(a2, a, CombatSetting.INSTANCE.packetPlace.getValue());
    }

    public static class_2350 getPlaceSide(class_2338 a) {
        return BlockUtil.getPlaceSide(a, CombatSetting.INSTANCE.placement.getValue() == Placement.Strict, CombatSetting.INSTANCE.placement.getValue() == Placement.Legit);
    }

    public static class_2350 getClickSideStrict(class_2338 a) {
        int n;
        class_2338 class_23382 = a;
        class_2338 class_23383 = null;
        double d = 100.0;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a = arrclass_2350[n];
            if (EntityUtil.canSee(class_23382, (class_2350)a) && !((double)class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558()))) > d)) {
                class_23383 = a;
                d = class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558())));
            }
            n3 = ++n;
        }
        if (class_23383 != null) {
            return class_23383;
        }
        class_23383 = null;
        arrclass_2350 = class_2350.values();
        n2 = arrclass_2350.length;
        int n4 = n = 0;
        while (n4 < n2) {
            a = arrclass_2350[n];
            if ((CombatSetting.INSTANCE.placement.getValue() != Placement.Strict || BlockUtil.isStrictDirection(class_23382, (class_2350)a) && BlockUtil.isAir(class_23382.method_10093((class_2350)a))) && !((double)class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558()))) > d)) {
                class_23383 = a;
                d = class_3532.method_15355((float)((float)BlockUtil.mc.field_1724.method_5707(class_23382.method_10093((class_2350)a).method_46558())));
            }
            n4 = ++n;
        }
        return class_23383;
    }

    public static Stream<class_2338> getAllInBoxStream(class_2338 class_23382, class_2338 class_23383) {
        class_2338 a = class_23383;
        class_2338 a2 = class_23382;
        class_2338 class_23385 = new class_2338(Math.min(a2.method_10263(), a.method_10263()), Math.min(a2.method_10264(), a.method_10264()), Math.min(a2.method_10260(), a.method_10260()));
        a = new class_2338(Math.max(a2.method_10263(), a.method_10263()), Math.max(a2.method_10264(), a.method_10264()), Math.max(a2.method_10260(), a.method_10260()));
        class_2338 class_23386 = class_23385;
        return Stream.iterate(class_23386, class_23384 -> {
            void a;
            class_2338 a22 = class_23384;
            class_2338 a3 = a;
            class_2338 class_23385 = a22;
            int a22 = class_23385.method_10263();
            int n = class_23385.method_10264();
            int n2 = class_23385.method_10260();
            if (++a22 > a3.method_10263()) {
                ++n;
                a22 = a.method_10263();
            }
            if (n > a3.method_10264()) {
                ++n2;
                n = a.method_10264();
            }
            if (n2 > a3.method_10260()) {
                throw new IllegalStateException(ColorUtil.ALLATORIxDEMO("h.n\u0013Q6= c\nH4&\"i5yrgyh$kh"));
            }
            return new class_2338(a22, n, n2);
        }).limit((a.method_10263() - class_23385.method_10263() + 1) * (a.method_10264() - class_23385.method_10264() + 1) * (a.method_10260() - class_23385.method_10260() + 1));
    }

    /*
     * WARNING - void declaration
     */
    public static void placeBlock(class_2338 class_23382, boolean bl, boolean bl2, boolean bl3) {
        class_2350 class_23502;
        void a;
        void a2;
        void a3;
        class_2338 class_23383 = class_23382;
        if (BlockUtil.airPlace()) {
            int n;
            class_23502 = class_2350.values();
            int a222 = ((class_2350[])class_23502).length;
            int n2 = n = 0;
            while (n2 < a222) {
                class_2350 class_23503 = class_23502[n];
                if (BlockUtil.mc.field_1687.method_22347(class_23383.method_10093(class_23503))) {
                    BlockUtil.clickBlock(class_23383, class_23503, (boolean)a3, class_1268.field_5808, (boolean)a);
                    return;
                }
                n2 = ++n;
            }
        }
        if ((class_23502 = BlockUtil.getPlaceSide(class_23383)) == null) {
            return;
        }
        class_2338 a222 = new class_243((double)class_23383.method_10263() + 0.5 + (double)class_23502.method_10163().method_10263() * 0.5, (double)class_23383.method_10264() + 0.5 + (double)class_23502.method_10163().method_10264() * 0.5, (double)class_23383.method_10260() + 0.5 + (double)class_23502.method_10163().method_10260() * 0.5);
        if (a3 != false) {
            EntityUtil.faceVector((class_243)a222);
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        class_3965 class_39652 = new class_3965((class_243)a222, class_23502, class_23383, false);
        placedPos.add(class_23383);
        boolean bl4 = false;
        if (BlockUtil.mc.field_1724 != null) {
            bl4 = BlockUtil.mc.field_1724.method_5624();
        }
        boolean a222 = false;
        if (BlockUtil.mc.field_1687 != null) {
            boolean bl5 = a222 = BlockUtil.needSneak(BlockUtil.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !BlockUtil.mc.field_1724.method_5715();
        }
        if (bl4) {
            BlockUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)BlockUtil.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (a222) {
            BlockUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)BlockUtil.mc.field_1724, class_2848.class_2849.field_12979));
        }
        BlockUtil.clickBlock(class_23383.method_10093(class_23502), class_23502.method_10153(), (boolean)a3, class_1268.field_5808, (boolean)a);
        if (a222) {
            BlockUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)BlockUtil.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl4) {
            BlockUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)BlockUtil.mc.field_1724, class_2848.class_2849.field_12981));
        }
        if (a2 != false) {
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
    }

    public static boolean airPlace() {
        return CombatSetting.INSTANCE.placement.getValue() == Placement.AirPlace;
    }

    public static ArrayList<class_2338> getSphere(float f, class_243 class_2432) {
        double d;
        class_243 a = class_2432;
        float a2 = f;
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        double d2 = d = a.method_10216() - (double)a2;
        while (d2 < a.method_10216() + (double)a2) {
            double d3 = a.method_10214() - (double)a2;
            while (d3 < a.method_10214() + (double)a2) {
                double d4;
                double d5 = a.method_10215() - (double)a2;
                while (d5 < a.method_10215() + (double)a2) {
                    double d6;
                    BlockPosX blockPosX = new BlockPosX(d, d4, d6);
                    if (!arrayList.contains((Object)blockPosX)) {
                        arrayList.add(blockPosX);
                    }
                    d5 = d6 + 1.0;
                }
                d3 = d4 + 1.0;
            }
            d2 = d + 1.0;
        }
        return arrayList;
    }

    public static ArrayList<class_2338> getAllInBox(class_2338 class_23382, int n) {
        int a = n;
        class_2338 a2 = class_23382;
        int n2 = a;
        return BlockUtil.getAllInBox(a2.method_10069(-a, -a, -a), a2.method_10069(n2, n2, n2));
    }

    /*
     * WARNING - void declaration
     */
    public static void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        boolean a2 = bl;
        class_2338 a3 = class_23382;
        BlockUtil.clickBlock(a3, (class_2350)a, a2, class_1268.field_5808);
    }

    public static Stream<class_2818> getLoadedChunks() {
        class_1923 class_19232;
        int n = Math.max(2, BlockUtil.mc.field_1690.method_38521()) + 3;
        int n2 = n * 2 + 1;
        class_1923 class_19233 = BlockUtil.mc.field_1724.method_31476();
        class_1923 class_19234 = class_19232 = new class_1923(class_19233.field_9181 - n, class_19233.field_9180 - n);
        return Stream.iterate(class_19234, arg_0 -> BlockUtil.lambda$getLoadedChunks$1(new class_1923(class_19233.field_9181 + n, class_19233.field_9180 + n), class_19234, arg_0)).limit((long)n2 * (long)n2).filter(a -> {
            class_1923 class_19232 = a;
            return BlockUtil.mc.field_1687.method_8393(class_19232.field_9181, class_19232.field_9180);
        }).map(a -> {
            class_1923 class_19232 = a;
            return BlockUtil.mc.field_1687.method_8497(class_19232.field_9181, class_19232.field_9180);
        }).filter(Objects::nonNull);
    }

    public static boolean isHole(class_2338 a) {
        return BlockUtil.isHole(a, true, false, false);
    }

    public static boolean isAir(class_2338 a) {
        return BlockUtil.mc.field_1687.method_22347(a);
    }

    public static boolean canClick(class_2338 a) {
        return BlockUtil.mc.field_1687.method_8320(a).method_51367() && (!shiftBlocks.contains((Object)BlockUtil.getBlock(a)) && !(BlockUtil.getBlock(a) instanceof class_2244) || BlockUtil.mc.field_1724.method_5715());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean hasCrystal(class_2338 a) {
        Object object = a;
        a = BlockUtil.mc.field_1687.method_18467(class_1511.class, new class_238((class_2338)object)).iterator();
        block0 : do {
            Object object2 = a;
            while (object2.hasNext()) {
                class_1297 class_12972 = (class_1297)a.next();
                if (!class_12972.method_5805()) continue block0;
                if (class_12972 instanceof class_1511) return true;
                object2 = a;
            }
            break;
        } while (true);
        return false;
    }

    public static boolean canPlaceCrystal(class_2338 a) {
        class_2338 class_23382 = a;
        class_2338 class_23383 = class_23382.method_10074();
        a = class_23383.method_10084();
        return !(BlockUtil.getBlock(class_23383) != class_2246.field_9987 && BlockUtil.getBlock(class_23383) != class_2246.field_10540 || BlockUtil.getClickSideStrict(class_23383) == null || BlockUtil.getBlock(a) != class_2246.field_10124 || BlockUtil.hasEntityBlockCrystal(a, false) || BlockUtil.hasEntityBlockCrystal(a.method_10084(), false) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a.method_10084()) != class_2246.field_10124);
    }

    public static class_2248 getBlock(class_2338 a) {
        return BlockUtil.getState(a).method_26204();
    }

    public static double distanceToXZ(double a, double a2) {
        double d = BlockUtil.mc.field_1724.method_23317() - a;
        a2 = BlockUtil.mc.field_1724.method_23321() - a2;
        double d2 = d;
        double d3 = a2;
        return Math.sqrt(d2 * d2 + d3 * d3);
    }

    /*
     * WARNING - void declaration
     */
    public static boolean isStrictDirection(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        class_2338 a2 = class_23502;
        class_2338 a3 = class_23382;
        if (EntityUtil.getPlayerPos().method_10264() - a3.method_10264() >= 0 && a2 == class_2350.field_11033) {
            return false;
        }
        if (BlockUtil.getBlock(a3.method_10093((class_2350)a2)) == class_2246.field_10540 || BlockUtil.getBlock(a3.method_10093((class_2350)a2)) == class_2246.field_9987 || BlockUtil.getBlock(a3.method_10093((class_2350)a2)) == class_2246.field_23152) {
            return false;
        }
        class_243 class_2432 = EntityUtil.getEyesPos();
        class_243 class_2433 = a3.method_46558();
        ArrayList<class_2350> arrayList = new ArrayList<class_2350>();
        arrayList.addAll(BlockUtil.checkAxis(class_2432.field_1352 - class_2433.field_1352, class_2350.field_11039, class_2350.field_11034, a == false));
        arrayList.addAll(BlockUtil.checkAxis(class_2432.field_1351 - class_2433.field_1351, class_2350.field_11033, class_2350.field_11036, true));
        arrayList.addAll(BlockUtil.checkAxis(class_2432.field_1350 - class_2433.field_1350, class_2350.field_11043, class_2350.field_11035, a == false));
        return arrayList.contains((Object)a2);
    }

    /*
     * WARNING - void declaration
     */
    public static void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, boolean bl2) {
        void a;
        void a2;
        boolean a3 = bl2;
        class_2338 a4 = class_23382;
        BlockUtil.clickBlock(a4, (class_2350)a2, (boolean)a, class_1268.field_5808, a3);
    }

    /*
     * WARNING - void declaration
     */
    public static class_2350 getPlaceSide(class_2338 class_23382, boolean bl, boolean bl2) {
        class_2338 a;
        int n;
        class_2338 class_23383 = class_23382;
        double d = 114514.0;
        class_2338 class_23384 = null;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            void a2;
            void a3;
            a = arrclass_2350[n];
            if (BlockUtil.canClick(class_23383.method_10093((class_2350)a)) && !BlockUtil.canReplace(class_23383.method_10093((class_2350)a)) && (a3 == false || EntityUtil.canSee(class_23383.method_10093((class_2350)a), a.method_10153())) && (a2 == false || BlockUtil.isStrictDirection(class_23383.method_10093((class_2350)a), a.method_10153()))) {
                double d2 = BlockUtil.mc.field_1724.method_5707(class_23383.method_46558().method_1031((double)a.method_10163().method_10263() * 0.5, (double)a.method_10163().method_10264() * 0.5, (double)a.method_10163().method_10260() * 0.5));
                if (class_23384 == null || d2 < d) {
                    class_23384 = a;
                    d = d2;
                }
            }
            n3 = ++n;
        }
        if (class_23384 == null && BlockUtil.airPlace()) {
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n4 = n = 0;
            while (n4 < n2) {
                a = arrclass_2350[n];
                if (BlockUtil.mc.field_1687.method_22347(class_23383.method_10093((class_2350)a))) {
                    return a;
                }
                n4 = ++n;
            }
        }
        return class_23384;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean hasEntityBlockCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        class_2338 class_23383 = class_23382;
        Iterator iterator = BlockUtil.mc.field_1687.method_18467(class_1297.class, new class_238(class_23383)).iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                void a;
                void a2;
                class_2338 a3 = (class_1297)iterator.next();
                if (!a3.method_5805() || a2 != false && a3 instanceof class_1542 || a != false && a3 instanceof class_1511) continue block0;
                if (!(a3 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                iterator2 = iterator;
            }
            break;
        } while (true);
        return false;
    }

    public static boolean canReplace(class_2338 a) {
        return BlockUtil.getState(a).method_45474();
    }

    public static void placeBlock(class_2338 a, boolean a2, boolean a3) {
        class_2350 class_23502 = a;
        if (BlockUtil.airPlace()) {
            int n;
            a = class_2350.values();
            int n2 = ((class_2350[])a).length;
            int n3 = n = 0;
            while (n3 < n2) {
                class_2350 class_23503 = a[n];
                if (BlockUtil.mc.field_1687.method_22347(class_23502.method_10093(class_23503))) {
                    BlockUtil.clickBlock((class_2338)class_23502, class_23503, a2, class_1268.field_5808, a3);
                    return;
                }
                n3 = ++n;
            }
        }
        if ((a = BlockUtil.getPlaceSide((class_2338)class_23502)) == null) {
            return;
        }
        placedPos.add((class_2338)class_23502);
        BlockUtil.clickBlock(class_23502.method_10093(a), a.method_10153(), a2, class_1268.field_5808, a3);
    }

    public static boolean canPlace(class_2338 a, double a2) {
        if (BlockUtil.getPlaceSide(a, a2) == null) {
            return false;
        }
        if (!BlockUtil.canReplace(a)) {
            return false;
        }
        return !BlockUtil.hasEntity(a, false);
    }

    public static boolean clientCanPlace(class_2338 class_23382, boolean bl) {
        boolean a = bl;
        class_2338 a2 = class_23382;
        if (!BlockUtil.canReplace(a2)) {
            return false;
        }
        return !BlockUtil.hasEntity(a2, a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean hasEntityBlockCrystal(class_2338 a, boolean a2) {
        Object object = a;
        a = BlockUtil.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)object)).iterator();
        block0 : do {
            Object object2 = a;
            while (object2.hasNext()) {
                class_1297 class_12972 = (class_1297)a.next();
                if (!class_12972.method_5805() || a2 && class_12972 instanceof class_1511) continue block0;
                if (!(class_12972 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                object2 = a;
            }
            break;
        } while (true);
        return false;
    }
}
