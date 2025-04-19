/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
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
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_2753
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_1297;
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
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class HoleKick
extends Module {
    private final BooleanSetting attackCrystal;
    private final BooleanSetting preferAnchor;
    private final BooleanSetting pistonPacket;
    public static HoleKick INSTANCE;
    public final BooleanSetting yawDeceive;
    private final SliderSetting updateDelay;
    private final BooleanSetting powerPacket;
    private final Timer timer;
    private final BooleanSetting inventory;
    private final BooleanSetting rotate;
    private final BooleanSetting allowWeb;
    private final BooleanSetting autoDisable;
    private final SliderSetting surroundCheck;
    private final SliderSetting placeRange;
    private final BooleanSetting noEating;
    private final BooleanSetting selfGround;
    private final BooleanSetting onlyGround;
    private final SliderSetting range;
    private final BooleanSetting mine;

    private /* synthetic */ class_2248 getBlock(class_2338 class_23382) {
        HoleKick a = class_23382;
        HoleKick a2 = this;
        return HoleKick.mc.field_1687.method_8320((class_2338)a).method_26204();
    }

    public int findBlock(class_2248 class_22482) {
        HoleKick a = class_22482;
        HoleKick a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    static boolean isTargetHere(class_2338 class_23382, class_1297 class_12972) {
        class_2338 a = class_12972;
        class_2338 a2 = class_23382;
        return new class_238(a2).method_994(a.method_5829());
    }

    @Override
    public void onUpdate() {
        HoleKick a;
        HoleKick holeKick = a;
        if (holeKick.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            return;
        }
        HoleKick holeKick2 = holeKick;
        if (!holeKick2.timer.passedMs(holeKick2.updateDelay.getValue())) {
            return;
        }
        if (holeKick.selfGround.getValue() && !HoleKick.mc.field_1724.method_24828()) {
            if (holeKick.autoDisable.getValue()) {
                holeKick.disable();
            }
            return;
        }
        if (holeKick.findBlock(class_2246.field_10002) == -1 || holeKick.findClass(class_2665.class) == -1) {
            if (holeKick.autoDisable.getValue()) {
                holeKick.disable();
            }
            return;
        }
        if (holeKick.noEating.getValue() && EntityUtil.isUsing()) {
            return;
        }
        Iterator<class_1657> iterator = CombatUtil.getEnemies(holeKick.range.getValue()).iterator();
        block0 : do {
            Iterator<class_1657> iterator2 = iterator;
            while (iterator2.hasNext()) {
                int n;
                int n2;
                float f;
                int n3;
                class_2350 class_23502;
                class_2338 class_23382;
                class_2338 class_23383;
                class_2350[] arrclass_2350;
                BlockPosX blockPosX;
                Object object;
                int n4;
                int n5;
                a = iterator.next();
                if (!holeKick.canPush((class_1657)a).booleanValue()) {
                    iterator2 = iterator;
                    continue;
                }
                class_2338 class_23384 = new float[3];
                class_23384[0] = -0.25f;
                class_23384[1] = 0.0f;
                class_23384[2] = 0.25f;
                class_2338 class_23385 = class_23384;
                Object object2 = class_23384;
                int n6 = ((float[])object2).length;
                int n7 = n4 = 0;
                while (n7 < n6) {
                    f = object2[n4];
                    class_23383 = class_23385;
                    n5 = ((float[])class_23383).length;
                    int n8 = n = 0;
                    while (n8 < n5) {
                        object = class_23383[n];
                        blockPosX = new BlockPosX(a.method_23317() + (double)f, a.method_23318() + 0.5, a.method_23321() + (double)object);
                        arrclass_2350 = class_2350.values();
                        n3 = arrclass_2350.length;
                        int n9 = n2 = 0;
                        while (n9 < n3) {
                            class_23502 = arrclass_2350[n2];
                            if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && HoleKick.isTargetHere(class_23382 = blockPosX.method_10093(class_23502), (class_1297)a)) {
                                if (HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238(class_23382))) {
                                    if (holeKick.tryPush(blockPosX.method_10093(class_23502.method_10153()), class_23502)) {
                                        holeKick.timer.reset();
                                        return;
                                    }
                                    if (holeKick.tryPush(blockPosX.method_10093(class_23502.method_10153()).method_10084(), class_23502)) {
                                        holeKick.timer.reset();
                                        return;
                                    }
                                }
                            }
                            n9 = ++n2;
                        }
                        n8 = ++n;
                    }
                    n7 = ++n4;
                }
                if (!HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 2.5, a.method_23321())))) {
                    object2 = class_2350.values();
                    n6 = ((class_2350[])object2).length;
                    int n10 = n4 = 0;
                    while (n10 < n6) {
                        float f2 = object2[n4];
                        if (f2 != class_2350.field_11036 && f2 != class_2350.field_11033) {
                            HoleKick holeKick3 = a;
                            class_23383 = EntityUtil.getEntityPos((class_1297)holeKick3).method_10093((class_2350)f2);
                            class_238 class_2383 = holeKick3.method_5829().method_997(new class_243((double)f2.method_10148(), (double)f2.method_10164(), (double)f2.method_10165()));
                            if (holeKick.getBlock(class_23383.method_10084()) != class_2246.field_10379 && !HoleKick.mc.field_1687.method_39454((class_1297)a, class_2383.method_989(0.0, 1.0, 0.0)) && !HoleKick.isTargetHere(class_23383, (class_1297)a)) {
                                if (holeKick.tryPush(EntityUtil.getEntityPos((class_1297)a).method_10093(f2.method_10153()).method_10084(), (class_2350)f2)) {
                                    holeKick.timer.reset();
                                    return;
                                }
                                if (holeKick.tryPush(EntityUtil.getEntityPos((class_1297)a).method_10093(f2.method_10153()), (class_2350)f2)) {
                                    holeKick.timer.reset();
                                    return;
                                }
                            }
                        }
                        n10 = ++n4;
                    }
                }
                object2 = class_23385;
                n6 = ((float[])object2).length;
                int n11 = n4 = 0;
                do {
                    if (n11 >= n6) continue block0;
                    f = object2[n4];
                    class_23383 = class_23385;
                    n5 = ((float[])class_23383).length;
                    int n12 = n = 0;
                    while (n12 < n5) {
                        object = (Object)class_23383[n];
                        blockPosX = new BlockPosX(a.method_23317() + (double)f, a.method_23318() + 0.5, a.method_23321() + (double)object);
                        arrclass_2350 = class_2350.values();
                        n3 = arrclass_2350.length;
                        int n13 = n2 = 0;
                        while (n13 < n3) {
                            class_23502 = arrclass_2350[n2];
                            if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && HoleKick.isTargetHere(class_23382 = blockPosX.method_10093(class_23502), (class_1297)a)) {
                                if (holeKick.tryPush(blockPosX.method_10093(class_23502.method_10153()).method_10084(), class_23502)) {
                                    holeKick.timer.reset();
                                    return;
                                }
                                if (holeKick.tryPush(blockPosX.method_10093(class_23502.method_10153()), class_23502)) {
                                    holeKick.timer.reset();
                                    return;
                                }
                            }
                            n13 = ++n2;
                        }
                        n12 = ++n;
                    }
                    n11 = ++n4;
                } while (true);
            }
            break;
        } while (true);
        if (holeKick.autoDisable.getValue()) {
            holeKick.disable();
        }
    }

    @Override
    public void onEnable() {
        AutoCrystal.INSTANCE.lastBreakTimer.reset();
        HanaAura.INSTANCE.lastBreakTimer.reset();
        AlienCrystal.INSTANCE.lastBreakTimer.reset();
    }

    private /* synthetic */ Boolean canPush(class_1657 class_16572) {
        int n;
        class_2338 class_23382;
        HoleKick a = class_16572;
        HoleKick a2 = this;
        if (a2.onlyGround.getValue() && !a.method_24828()) {
            return false;
        }
        if (!a2.allowWeb.getValue() && HoleKick.isInWeb((class_1657)a)) {
            return false;
        }
        class_2338 class_23383 = new float[3];
        class_23383[0] = -0.25f;
        class_23383[1] = 0.0f;
        class_23383[2] = 0.25f;
        class_2338 class_23384 = class_23383;
        int n2 = 0;
        if (HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317() + 1.0, a.method_23318() + 0.5, a.method_23321())))) {
            ++n2;
        }
        if (HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317() - 1.0, a.method_23318() + 0.5, a.method_23321())))) {
            ++n2;
        }
        if (HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321() + 1.0)))) {
            ++n2;
        }
        if (HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321() - 1.0)))) {
            ++n2;
        }
        Object object = class_23384;
        int n3 = ((float[])object).length;
        int n4 = n = 0;
        while (n4 < n3) {
            int n5;
            float f = object[n];
            class_23382 = class_23384;
            int n6 = ((float[])class_23382).length;
            int n7 = n5 = 0;
            while (n7 < n6) {
                int n8;
                float f2 = class_23382[n5];
                BlockPosX blockPosX = new BlockPosX(a.method_23317() + (double)f, a.method_23318() + 0.5, a.method_23321() + (double)f2);
                class_2350[] arrclass_2350 = class_2350.values();
                int n9 = arrclass_2350.length;
                int n10 = n8 = 0;
                while (n10 < n9) {
                    class_2350 class_23502 = arrclass_2350[n8];
                    if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && HoleKick.isTargetHere((class_2338)(class_23502 = blockPosX.method_10093(class_23502)), (class_1297)a)) {
                        if (HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)class_23502))) {
                            return true;
                        }
                        if ((double)n2 > a2.surroundCheck.getValue() - 1.0) {
                            return true;
                        }
                    }
                    n10 = ++n8;
                }
                n7 = ++n5;
            }
            n4 = ++n;
        }
        if (!HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 2.5, a.method_23321())))) {
            object = class_2350.values();
            n3 = ((class_2350[])object).length;
            int n11 = n = 0;
            while (n11 < n3) {
                float f = object[n];
                if (f != class_2350.field_11036 && f != class_2350.field_11033) {
                    HoleKick holeKick = a;
                    class_23382 = EntityUtil.getEntityPos((class_1297)holeKick).method_10093((class_2350)f);
                    class_238 class_2383 = holeKick.method_5829().method_997(new class_243((double)f.method_10148(), (double)f.method_10164(), (double)f.method_10165()));
                    if (a2.getBlock(class_23382.method_10084()) != class_2246.field_10379 && !HoleKick.mc.field_1687.method_39454((class_1297)a, class_2383.method_989(0.0, 1.0, 0.0)) && !HoleKick.isTargetHere(class_23382, (class_1297)a) && HoleKick.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321())))) {
                        return true;
                    }
                }
                n11 = ++n;
            }
        }
        return (double)n2 > a2.surroundCheck.getValue() - 1.0 || CombatUtil.isHard(new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321()));
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        HoleKick a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, HoleKick.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public int findClass(Class class_) {
        Class a = class_;
        HoleKick a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(a);
        }
        return InventoryUtil.findClass(a);
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

    public HoleKick() {
        HoleKick a;
        HoleKick holeKick = a;
        HoleKick holeKick2 = a;
        super(Alt.ALLATORIxDEMO("t\tr!_'-"), Module.Category.Combat);
        HoleKick holeKick3 = a;
        holeKick3.rotate = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("f\u000f]\u001c\u0017R"), true));
        holeKick2.yawDeceive = holeKick2.add(new BooleanSetting(Alt.ALLATORIxDEMO("K)K\"{'q'j#"), true));
        holeKick2.preferAnchor = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("2\u0013PR\u0005AJu\u000eJ\u0015\fE"), true));
        holeKick2.pistonPacket = holeKick2.add(new BooleanSetting(Alt.ALLATORIxDEMO("K(a<S\bN%w%y2"), false));
        holeKick2.powerPacket = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("e[\u0017V\u0015d\u0001J\u0016\u0006C"), true));
        holeKick2.noEating = holeKick2.add(new BooleanSetting(Alt.ALLATORIxDEMO("\u0004s<U\by\u0014u;o#"), true));
        holeKick2.attackCrystal = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("#GQ\u0001X$F\u0019Z\t\u0002["), true));
        holeKick2.mine = holeKick2.add(new BooleanSetting(Alt.ALLATORIxDEMO("Y'r#"), true));
        holeKick2.allowWeb = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("r\u000bX\u000f^*\u0006U"), true));
        holeKick2.updateDelay = holeKick2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u0000q\"}?"), 100, 0, 1000));
        holeKick2.selfGround = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("g\u0005_\u0001s\u0012F\b\rS"), true));
        holeKick2.onlyGround = holeKick2.add(new BooleanSetting(Alt.ALLATORIxDEMO("]&P\u001fY6{;r\""), false));
        holeKick2.autoDisable = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("tA\u0014\\#]\u0013H\u001f\u000fR"), true));
        holeKick2.range = holeKick2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u0016u {#"), 5.0, 0.0, 6.0));
        holeKick2.placeRange = holeKick2.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("d\fR\u0004Q2H\u0013\u0004R"), 5.0, 0.0, 6.0));
        holeKick2.surroundCheck = holeKick2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u0011n3`'I\bz\u0007|+-"), 2, 0, 4));
        holeKick2.inventory = holeKick2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("+\u000fCQ\u000eG\bF\u0019z\n\u0002G"), true));
        holeKick.timer = new Timer();
        holeKick.setChinese(Alt.ALLATORIxDEMO("\u6d2f\u5810\u63b4\u4efc"));
        INSTANCE = holeKick;
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
                int[] arrn = new int[3];
                arrn[0] = 0;
                arrn[1] = 1;
                arrn[2] = 2;
                int[] arrn2 = arrn;
                int n8 = arrn.length;
                int n9 = n7 = 0;
                while (n9 < n8) {
                    int a222 = arrn2[n7];
                    class_1657 a222 = new BlockPosX(class_2432.method_10216() + (double)f, class_2432.method_10214(), class_2432.method_10215() + (double)f2).method_10086(a222);
                    if (HoleKick.isTargetHere((class_2338)a222, (class_1297)class_16572) && HoleKick.mc.field_1687.method_8320((class_2338)a222).method_26204() == class_2246.field_10343) {
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
     * WARNING - void declaration
     */
    private /* synthetic */ boolean tryPush(class_2338 class_23382, class_2350 class_23502) {
        void a;
        int n;
        HoleKick a2 = class_23382;
        HoleKick a3 = this;
        if (!BlockUtil.isAir(a2.method_10093((class_2350)a))) {
            return false;
        }
        if (a3.isTrueFacing((class_2338)a2, (class_2350)a) && BlockUtil.clientCanPlace((class_2338)a2)) {
            int n2;
            boolean bl = false;
            if (BlockUtil.getPlaceSide((class_2338)a2, a3.placeRange.getValue()) != null) {
                class_2350[] arrclass_2350;
                CombatUtil.modifyPos = a2;
                CombatUtil.modifyBlockState = class_2246.field_10560.method_9564();
                class_2350[] arrclass_23502 = class_2350.values();
                n = arrclass_23502.length;
                int n3 = n2 = 0;
                while (n3 < n) {
                    arrclass_2350 = arrclass_23502[n2];
                    if (a3.getBlock(a2.method_10093((class_2350)arrclass_2350)) == class_2246.field_10002) {
                        bl = true;
                        break;
                    }
                    n3 = ++n2;
                }
                arrclass_23502 = class_2350.values();
                n = arrclass_23502.length;
                int n4 = n2 = 0;
                while (n4 < n) {
                    arrclass_2350 = arrclass_23502[n2];
                    if (bl) break;
                    if (BlockUtil.canPlace(a2.method_10093((class_2350)arrclass_2350), a3.placeRange.getValue())) {
                        bl = true;
                    }
                    n4 = ++n2;
                }
                CombatUtil.modifyPos = null;
                if (bl) {
                    int n5 = a3.findClass(class_2665.class);
                    class_2350 class_23503 = BlockUtil.getPlaceSide((class_2338)a2);
                    if (class_23503 != null) {
                        class_2350 class_23504;
                        int n6;
                        HoleKick holeKick;
                        if (a3.rotate.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23503), class_23503.method_10153());
                        }
                        if (a3.yawDeceive.getValue()) {
                            HoleKick.pistonFacing(a.method_10153());
                        }
                        n2 = HoleKick.mc.field_1724.method_31548().field_7545;
                        HoleKick holeKick2 = a3;
                        holeKick2.doSwap(n5);
                        BlockUtil.placeBlock((class_2338)a2, false, a3.pistonPacket.getValue());
                        HoleKick holeKick3 = a3;
                        if (holeKick2.inventory.getValue()) {
                            holeKick3.doSwap(n5);
                            EntityUtil.syncInventory();
                            holeKick = a3;
                        } else {
                            holeKick3.doSwap(n2);
                            holeKick = a3;
                        }
                        if (holeKick.rotate.getValue() && a3.yawDeceive.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23503), class_23503.method_10153());
                        }
                        arrclass_2350 = class_2350.values();
                        int n7 = arrclass_2350.length;
                        int n8 = n6 = 0;
                        while (n8 < n7) {
                            class_23504 = arrclass_2350[n6];
                            if (a3.getBlock(a2.method_10093(class_23504)) == class_2246.field_10002) {
                                if (a3.autoDisable.getValue()) {
                                    a3.disable();
                                }
                                return true;
                            }
                            n8 = ++n6;
                        }
                        arrclass_2350 = class_2350.values();
                        n7 = arrclass_2350.length;
                        int n9 = n6 = 0;
                        while (n9 < n7) {
                            class_23504 = arrclass_2350[n6];
                            if (BlockUtil.canPlace(a2.method_10093(class_23504), a3.placeRange.getValue())) {
                                int n10 = HoleKick.mc.field_1724.method_31548().field_7545;
                                HoleKick holeKick4 = a3;
                                int n11 = holeKick4.findBlock(class_2246.field_10002);
                                holeKick4.doSwap(n11);
                                BlockUtil.placeBlock(a2.method_10093(class_23504), a3.rotate.getValue(), a3.powerPacket.getValue());
                                HoleKick holeKick5 = a3;
                                if (holeKick4.inventory.getValue()) {
                                    holeKick5.doSwap(n11);
                                    EntityUtil.syncInventory();
                                } else {
                                    holeKick5.doSwap(n10);
                                }
                                return true;
                            }
                            n9 = ++n6;
                        }
                        return true;
                    }
                }
            } else {
                class_2350 class_23505;
                class_2350 class_23506;
                int n12;
                class_2350 class_23507;
                block43 : {
                    class_23505 = null;
                    class_2350[] arrclass_2350 = class_2350.values();
                    n2 = arrclass_2350.length;
                    int n13 = n12 = 0;
                    while (n13 < n2) {
                        class_23506 = arrclass_2350[n12];
                        if (class_23505 != null) {
                            class_23507 = class_23505;
                            break block43;
                        }
                        HoleKick holeKick = a2;
                        CombatUtil.modifyPos = holeKick.method_10093(class_23506);
                        CombatUtil.modifyBlockState = class_2246.field_10002.method_9564();
                        if (BlockUtil.getPlaceSide((class_2338)holeKick) != null) {
                            class_23505 = class_23506;
                        }
                        CombatUtil.modifyPos = null;
                        if (class_23505 != null && !BlockUtil.canPlace(a2.method_10093(class_23505))) {
                            class_23505 = null;
                        }
                        n13 = ++n12;
                    }
                    class_23507 = class_23505;
                }
                if (class_23507 != null) {
                    HoleKick holeKick;
                    int n14 = HoleKick.mc.field_1724.method_31548().field_7545;
                    HoleKick holeKick6 = a3;
                    n2 = holeKick6.findBlock(class_2246.field_10002);
                    holeKick6.doSwap(n2);
                    BlockUtil.placeBlock(a2.method_10093(class_23505), a3.rotate.getValue(), a3.powerPacket.getValue());
                    HoleKick holeKick7 = a3;
                    if (holeKick6.inventory.getValue()) {
                        holeKick7.doSwap(n2);
                        EntityUtil.syncInventory();
                        holeKick = a2;
                    } else {
                        holeKick7.doSwap(n14);
                        holeKick = a2;
                    }
                    CombatUtil.modifyPos = holeKick.method_10093(class_23505);
                    CombatUtil.modifyBlockState = class_2246.field_10002.method_9564();
                    n12 = a3.findClass(class_2665.class);
                    class_23506 = BlockUtil.getPlaceSide((class_2338)a2);
                    if (class_23506 != null) {
                        HoleKick holeKick8;
                        if (a3.rotate.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23506), class_23506.method_10153());
                        }
                        if (a3.yawDeceive.getValue()) {
                            HoleKick.pistonFacing(a.method_10153());
                        }
                        int n15 = HoleKick.mc.field_1724.method_31548().field_7545;
                        HoleKick holeKick9 = a3;
                        holeKick9.doSwap(n12);
                        BlockUtil.placeBlock((class_2338)a2, false, a3.pistonPacket.getValue());
                        HoleKick holeKick10 = a3;
                        if (holeKick9.inventory.getValue()) {
                            holeKick10.doSwap(n12);
                            EntityUtil.syncInventory();
                            holeKick8 = a3;
                        } else {
                            holeKick10.doSwap(n15);
                            holeKick8 = a3;
                        }
                        if (holeKick8.rotate.getValue() && a3.yawDeceive.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23506), class_23506.method_10153());
                        }
                    }
                    CombatUtil.modifyPos = null;
                    return true;
                }
            }
        }
        if (a3.getBlock((class_2338)a2) instanceof class_2665 && a3.getBlockState((class_2338)a2).method_11654((class_2769)class_2318.field_10927) == a) {
            class_2350[] arrclass_2350 = class_2350.values();
            int n16 = arrclass_2350.length;
            int n17 = n = 0;
            while (n17 < n16) {
                class_2350 class_23508 = arrclass_2350[n];
                if (a3.getBlock(a2.method_10093(class_23508)) == class_2246.field_10002) {
                    if (a3.autoDisable.getValue()) {
                        a3.disable();
                        return true;
                    }
                    return false;
                }
                n17 = ++n;
            }
            arrclass_2350 = class_2350.values();
            n16 = arrclass_2350.length;
            int n18 = n = 0;
            while (n18 < n16) {
                class_2350 class_23509 = arrclass_2350[n];
                if (BlockUtil.canPlace(a2.method_10093(class_23509), a3.placeRange.getValue())) {
                    int n19 = HoleKick.mc.field_1724.method_31548().field_7545;
                    HoleKick holeKick = a3;
                    int n20 = holeKick.findBlock(class_2246.field_10002);
                    holeKick.doSwap(n20);
                    BlockUtil.placeBlock(a2.method_10093(class_23509), a3.rotate.getValue(), a3.powerPacket.getValue());
                    HoleKick holeKick11 = a3;
                    if (holeKick.inventory.getValue()) {
                        holeKick11.doSwap(n20);
                        EntityUtil.syncInventory();
                    } else {
                        holeKick11.doSwap(n19);
                    }
                    return true;
                }
                n18 = ++n;
            }
        }
        return false;
    }

    private /* synthetic */ class_2680 getBlockState(class_2338 class_23382) {
        HoleKick a = class_23382;
        HoleKick a2 = this;
        return HoleKick.mc.field_1687.method_8320((class_2338)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isTrueFacing(class_2338 class_23382, class_2350 class_23502) {
        void a;
        float[] a2 = class_23382;
        float[] a3 = this;
        if (a3.yawDeceive.getValue()) {
            return true;
        }
        class_2350 class_23503 = BlockUtil.getPlaceSide((class_2338)a2);
        if (class_23503 == null) {
            return false;
        }
        return MathUtil.getFacingOrder((a2 = EntityUtil.getLegitRotations(new class_243((double)a2.method_10263() + 0.5 + (double)class_23503.method_10163().method_10263() * 0.5, (double)a2.method_10264() + 0.5 + (double)class_23503.method_10163().method_10264() * 0.5, (double)a2.method_10260() + 0.5 + (double)class_23503.method_10163().method_10260() * 0.5)))[0], a2[1]).method_10153() == a;
    }
}
