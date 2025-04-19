/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
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
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
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

public class AutoPush
extends Module {
    private final BooleanSetting torch;
    private final BooleanSetting yawDeceive;
    private final BooleanSetting autoDisable;
    private final Timer timer;
    public static AutoPush INSTANCE;
    private final BooleanSetting inventory;
    private final SliderSetting updateDelay;
    private final BooleanSetting preferAnchor;
    private final BooleanSetting allowWeb;
    private final BooleanSetting noEating;
    private final BooleanSetting mine;
    private final SliderSetting placeRange;
    private final BooleanSetting rotate;
    private final BooleanSetting onlyGround;
    private final BooleanSetting powerPacket;
    private final SliderSetting range;
    private final BooleanSetting pistonPacket;
    private final BooleanSetting selfGround;
    private final SliderSetting surroundCheck;

    private /* synthetic */ class_2248 getBlockType() {
        AutoPush a;
        if (a.torch.getValue()) {
            return class_2246.field_10523;
        }
        return class_2246.field_10002;
    }

    private /* synthetic */ boolean facingCheck(class_2338 class_23382) {
        AutoPush a = class_23382;
        AutoPush a2 = this;
        if (CombatSetting.INSTANCE.lowVersion.getValue()) {
            return (a = MathUtil.getDirectionFromEntityLiving((class_2338)a, (class_1309)AutoPush.mc.field_1724)) != class_2350.field_11036 && a != class_2350.field_11033;
        }
        return true;
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
        AutoPush a = class_23382;
        AutoPush a2 = this;
        return AutoPush.mc.field_1687.method_8320((class_2338)a).method_26204();
    }

    public int findBlock(class_2248 class_22482) {
        AutoPush a = class_22482;
        AutoPush a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    public int findClass(Class class_) {
        Class a = class_;
        AutoPush a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(a);
        }
        return InventoryUtil.findClass(a);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoPush a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AutoPush.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean tryPush(class_2338 class_23382, class_2350 class_23502) {
        class_2680 class_26802;
        int n;
        class_2350 class_23503;
        void a;
        int n2;
        class_2350[] arrclass_2350;
        AutoPush a2 = class_23382;
        AutoPush a3 = this;
        if (!AutoPush.mc.field_1687.method_22347(a2.method_10093((class_2350)a))) {
            return false;
        }
        if (a3.isTrueFacing((class_2338)a2, (class_2350)a) && a3.facingCheck((class_2338)a2) && BlockUtil.clientCanPlace((class_2338)a2)) {
            boolean bl = false;
            if (BlockUtil.getPlaceSide((class_2338)a2, a3.placeRange.getValue()) != null) {
                CombatUtil.modifyPos = a2;
                CombatUtil.modifyBlockState = class_2246.field_10560.method_9564();
                arrclass_2350 = class_2350.values();
                n = arrclass_2350.length;
                int n3 = n2 = 0;
                while (n3 < n) {
                    class_23503 = arrclass_2350[n2];
                    if (a3.getBlock(a2.method_10093(class_23503)) == a3.getBlockType()) {
                        bl = true;
                        break;
                    }
                    n3 = ++n2;
                }
                arrclass_2350 = class_2350.values();
                n = arrclass_2350.length;
                int n4 = n2 = 0;
                while (n4 < n) {
                    class_23503 = arrclass_2350[n2];
                    if (bl) break;
                    if (BlockUtil.canPlace(a2.method_10093(class_23503), a3.placeRange.getValue())) {
                        bl = true;
                    }
                    n4 = ++n2;
                }
                CombatUtil.modifyPos = null;
                if (bl) {
                    int n5 = a3.findClass(class_2665.class);
                    class_2350 class_23504 = BlockUtil.getPlaceSide((class_2338)a2);
                    if (class_23504 != null) {
                        class_2350 class_23505;
                        int n6;
                        AutoPush autoPush;
                        if (a3.rotate.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23504), class_23504.method_10153());
                        }
                        if (a3.yawDeceive.getValue()) {
                            AutoPush.pistonFacing(a.method_10153());
                        }
                        n2 = AutoPush.mc.field_1724.method_31548().field_7545;
                        AutoPush autoPush2 = a3;
                        autoPush2.doSwap(n5);
                        BlockUtil.placeBlock((class_2338)a2, false, a3.pistonPacket.getValue());
                        AutoPush autoPush3 = a3;
                        if (autoPush2.inventory.getValue()) {
                            autoPush3.doSwap(n5);
                            EntityUtil.syncInventory();
                            autoPush = a3;
                        } else {
                            autoPush3.doSwap(n2);
                            autoPush = a3;
                        }
                        if (autoPush.rotate.getValue() && a3.yawDeceive.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23504), class_23504.method_10153());
                        }
                        if (a3.rotate.getValue() && CombatSetting.INSTANCE.rotateSync.getValue()) {
                            Hana.ROTATE.snapBack();
                        }
                        class_23503 = class_2350.values();
                        int n7 = ((class_2350[])class_23503).length;
                        int n8 = n6 = 0;
                        while (n8 < n7) {
                            class_23505 = class_23503[n6];
                            if (a3.getBlock(a2.method_10093(class_23505)) == a3.getBlockType()) {
                                if (a3.mine.getValue()) {
                                    SpeedMine.INSTANCE.mine(a2.method_10093(class_23505));
                                }
                                if (a3.autoDisable.getValue()) {
                                    a3.disable();
                                }
                                return true;
                            }
                            n8 = ++n6;
                        }
                        class_23503 = class_2350.values();
                        n7 = ((class_2350[])class_23503).length;
                        int n9 = n6 = 0;
                        while (n9 < n7) {
                            class_23505 = class_23503[n6];
                            if ((class_23505 != class_2350.field_11036 || !a3.torch.getValue()) && BlockUtil.canPlace(a2.method_10093(class_23505), a3.placeRange.getValue())) {
                                AutoPush autoPush4;
                                int n10 = AutoPush.mc.field_1724.method_31548().field_7545;
                                AutoPush autoPush5 = a3;
                                int n11 = autoPush5.findBlock(a3.getBlockType());
                                autoPush5.doSwap(n11);
                                BlockUtil.placeBlock(a2.method_10093(class_23505), a3.rotate.getValue(), a3.powerPacket.getValue());
                                AutoPush autoPush6 = a3;
                                if (autoPush5.inventory.getValue()) {
                                    autoPush6.doSwap(n11);
                                    EntityUtil.syncInventory();
                                    autoPush4 = a3;
                                } else {
                                    autoPush6.doSwap(n10);
                                    autoPush4 = a3;
                                }
                                if (autoPush4.mine.getValue()) {
                                    SpeedMine.INSTANCE.mine(a2.method_10093(class_23505));
                                }
                                return true;
                            }
                            n9 = ++n6;
                        }
                        return true;
                    }
                }
            } else {
                class_2350 class_23506;
                int n12;
                class_2350 class_23507;
                class_2350 class_23508;
                block49 : {
                    class_23506 = null;
                    class_2350[] arrclass_23502 = class_2350.values();
                    n2 = arrclass_23502.length;
                    int n13 = n12 = 0;
                    while (n13 < n2) {
                        class_23507 = arrclass_23502[n12];
                        if (class_23507 != class_2350.field_11036 || !a3.torch.getValue()) {
                            if (class_23506 != null) {
                                class_23508 = class_23506;
                                break block49;
                            }
                            CombatUtil.modifyPos = a2.method_10093(class_23507);
                            CombatUtil.modifyBlockState = a3.getBlockType().method_9564();
                            if (BlockUtil.getPlaceSide((class_2338)a2) != null) {
                                class_23506 = class_23507;
                            }
                            CombatUtil.modifyPos = null;
                            if (class_23506 != null && !BlockUtil.canPlace(a2.method_10093(class_23506))) {
                                class_23506 = null;
                            }
                        }
                        n13 = ++n12;
                    }
                    class_23508 = class_23506;
                }
                if (class_23508 != null) {
                    AutoPush autoPush;
                    int n14 = AutoPush.mc.field_1724.method_31548().field_7545;
                    AutoPush autoPush7 = a3;
                    n2 = autoPush7.findBlock(a3.getBlockType());
                    autoPush7.doSwap(n2);
                    BlockUtil.placeBlock(a2.method_10093(class_23506), a3.rotate.getValue(), a3.powerPacket.getValue());
                    AutoPush autoPush8 = a3;
                    if (autoPush7.inventory.getValue()) {
                        autoPush8.doSwap(n2);
                        EntityUtil.syncInventory();
                        autoPush = a3;
                    } else {
                        autoPush8.doSwap(n14);
                        autoPush = a3;
                    }
                    if (autoPush.mine.getValue()) {
                        SpeedMine.INSTANCE.mine(a2.method_10093(class_23506));
                    }
                    AutoPush autoPush9 = a3;
                    CombatUtil.modifyPos = a2.method_10093(class_23506);
                    CombatUtil.modifyBlockState = autoPush9.getBlockType().method_9564();
                    n12 = autoPush9.findClass(class_2665.class);
                    class_23507 = BlockUtil.getPlaceSide((class_2338)a2);
                    if (class_23507 != null) {
                        AutoPush autoPush10;
                        if (a3.rotate.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23507), class_23507.method_10153());
                        }
                        if (a3.yawDeceive.getValue()) {
                            AutoPush.pistonFacing(a.method_10153());
                        }
                        int n15 = AutoPush.mc.field_1724.method_31548().field_7545;
                        AutoPush autoPush11 = a3;
                        autoPush11.doSwap(n12);
                        BlockUtil.placeBlock((class_2338)a2, false, a3.pistonPacket.getValue());
                        AutoPush autoPush12 = a3;
                        if (autoPush11.inventory.getValue()) {
                            autoPush12.doSwap(n12);
                            EntityUtil.syncInventory();
                            autoPush10 = a3;
                        } else {
                            autoPush12.doSwap(n15);
                            autoPush10 = a3;
                        }
                        if (autoPush10.rotate.getValue() && a3.yawDeceive.getValue()) {
                            EntityUtil.facePosSide(a2.method_10093(class_23507), class_23507.method_10153());
                        }
                        if (a3.rotate.getValue() && CombatSetting.INSTANCE.rotateSync.getValue()) {
                            Hana.ROTATE.snapBack();
                        }
                    }
                    CombatUtil.modifyPos = null;
                    return true;
                }
            }
        }
        if ((class_26802 = AutoPush.mc.field_1687.method_8320((class_2338)a2)).method_26204() instanceof class_2665 && a3.getBlockState((class_2338)a2).method_11654((class_2769)class_2318.field_10927) == a) {
            arrclass_2350 = class_2350.values();
            n = arrclass_2350.length;
            int n16 = n2 = 0;
            while (n16 < n) {
                class_23503 = arrclass_2350[n2];
                if (a3.getBlock(a2.method_10093(class_23503)) == a3.getBlockType()) {
                    if (a3.autoDisable.getValue()) {
                        a3.disable();
                        return true;
                    }
                    return false;
                }
                n16 = ++n2;
            }
            arrclass_2350 = class_2350.values();
            n = arrclass_2350.length;
            int n17 = n2 = 0;
            while (n17 < n) {
                class_23503 = arrclass_2350[n2];
                if ((class_23503 != class_2350.field_11036 || !a3.torch.getValue()) && BlockUtil.canPlace(a2.method_10093(class_23503), a3.placeRange.getValue())) {
                    int n18 = AutoPush.mc.field_1724.method_31548().field_7545;
                    AutoPush autoPush = a3;
                    int n19 = autoPush.findBlock(a3.getBlockType());
                    autoPush.doSwap(n19);
                    BlockUtil.placeBlock(a2.method_10093(class_23503), a3.rotate.getValue(), a3.powerPacket.getValue());
                    AutoPush autoPush13 = a3;
                    if (autoPush.inventory.getValue()) {
                        autoPush13.doSwap(n19);
                        EntityUtil.syncInventory();
                    } else {
                        autoPush13.doSwap(n18);
                    }
                    return true;
                }
                n17 = ++n2;
            }
        }
        return false;
    }

    @Override
    public void onEnable() {
        AutoCrystal.INSTANCE.lastBreakTimer.reset();
        HanaAura.INSTANCE.lastBreakTimer.reset();
        AlienCrystal.INSTANCE.lastBreakTimer.reset();
    }

    private /* synthetic */ class_2680 getBlockState(class_2338 class_23382) {
        AutoPush a = class_23382;
        AutoPush a2 = this;
        return AutoPush.mc.field_1687.method_8320((class_2338)a);
    }

    public AutoPush() {
        AutoPush a;
        AutoPush autoPush = a;
        AutoPush autoPush2 = a;
        super(Alt.ALLATORIxDEMO("T+l-"), Module.Category.Combat);
        AutoPush autoPush3 = a;
        autoPush3.torch = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("\u0006P&G'"), false));
        autoPush2.preferAnchor = autoPush2.add(new BooleanSetting(Alt.ALLATORIxDEMO("S+}$B\u000fC6g6p7"), true));
        autoPush2.rotate = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("N\u0018M3K=K!"), true));
        autoPush2.yawDeceive = autoPush2.add(new BooleanSetting(Alt.ALLATORIxDEMO("A#P9g;a7i "), true));
        autoPush2.pistonPacket = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("h:P<s\u0019i3\\?A;"), false));
        autoPush2.powerPacket = autoPush2.add(new BooleanSetting(Alt.ALLATORIxDEMO("\tw5B\u000fR9g5z1"), true));
        autoPush2.noEating = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("\u0016B<u\u0019^\u0002^!W*"), true));
        autoPush2.mine = autoPush2.add(new BooleanSetting(Alt.ALLATORIxDEMO("I7q "), true));
        autoPush2.allowWeb = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("]\u001bU=H\u0003A-"), true));
        autoPush2.updateDelay = autoPush2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u001ca2~<"), 100, 0, 1000));
        autoPush2.selfGround = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("p-p\u0011~ P!J+"), true));
        autoPush2.onlyGround = autoPush2.add(new BooleanSetting(Alt.ALLATORIxDEMO("W,K\u0004E*k+q!"), false));
        autoPush2.autoDisable = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("\u0012V<s3P!^6H*"), true));
        autoPush2.range = autoPush2.add(new SliderSetting(Alt.ALLATORIxDEMO("\ne0x "), 5.0, 0.0, 6.0));
        autoPush2.placeRange = autoPush2.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("s$}\u0014\\\u0000^:C*"), 5.0, 0.0, 6.0));
        autoPush2.surroundCheck = autoPush2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u000bv+j-R\u0013f\u001bl;|."), 2, 0, 4));
        autoPush2.inventory = autoPush2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("\u001bV%F&h\u0018K+l#E?"), true));
        autoPush.timer = new Timer();
        autoPush.setChinese(Alt.ALLATORIxDEMO("\u596b\u661d\u4ee2\u6d3f\u5800\u63b7\u4eff"));
        INSTANCE = autoPush;
    }

    private /* synthetic */ Boolean canPush(class_1657 class_16572) {
        int n;
        class_2338 class_23382;
        AutoPush a = class_16572;
        AutoPush a2 = this;
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
        if (AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317() + 1.0, a.method_23318() + 0.5, a.method_23321())))) {
            ++n2;
        }
        if (AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317() - 1.0, a.method_23318() + 0.5, a.method_23321())))) {
            ++n2;
        }
        if (AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321() + 1.0)))) {
            ++n2;
        }
        if (AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321() - 1.0)))) {
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
                    if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && a2.isTargetHere((class_2338)(class_23502 = blockPosX.method_10093(class_23502)), (class_1297)a)) {
                        if (AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)class_23502))) {
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
        if (!AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 2.5, a.method_23321())))) {
            object = class_2350.values();
            n3 = ((class_2350[])object).length;
            int n11 = n = 0;
            while (n11 < n3) {
                float f = object[n];
                if (f != class_2350.field_11036 && f != class_2350.field_11033) {
                    AutoPush autoPush = a;
                    class_23382 = EntityUtil.getEntityPos((class_1297)autoPush).method_10093((class_2350)f);
                    class_238 class_2383 = autoPush.method_5829().method_997(new class_243((double)f.method_10148(), (double)f.method_10164(), (double)f.method_10165()));
                    if (a2.getBlock(class_23382.method_10084()) != class_2246.field_10379 && !AutoPush.mc.field_1687.method_39454((class_1297)a, class_2383.method_989(0.0, 1.0, 0.0)) && !a2.isTargetHere(class_23382, (class_1297)a) && AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321())))) {
                        return true;
                    }
                }
                n11 = ++n;
            }
        }
        return (double)n2 > a2.surroundCheck.getValue() - 1.0 || CombatUtil.isHard(new BlockPosX(a.method_23317(), a.method_23318() + 0.5, a.method_23321()));
    }

    @Override
    public void onUpdate() {
        AutoPush a;
        AutoPush autoPush;
        AutoPush autoPush2 = autoPush = a;
        if (!autoPush2.timer.passedMs(autoPush2.updateDelay.getValue())) {
            return;
        }
        if (autoPush.selfGround.getValue() && !AutoPush.mc.field_1724.method_24828()) {
            return;
        }
        if (autoPush.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            return;
        }
        AutoPush autoPush3 = autoPush;
        if (autoPush3.findBlock(autoPush3.getBlockType()) == -1 || autoPush.findClass(class_2665.class) == -1) {
            if (autoPush.autoDisable.getValue()) {
                autoPush.disable();
            }
            return;
        }
        if (autoPush.noEating.getValue() && AutoPush.mc.field_1724.method_6115()) {
            return;
        }
        if (Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) {
            return;
        }
        Iterator<class_1657> iterator = CombatUtil.getEnemies(autoPush.range.getValue()).iterator();
        block0 : do {
            Iterator<class_1657> iterator2 = iterator;
            while (iterator2.hasNext()) {
                int n;
                int n2;
                int n3;
                class_2350 class_23502;
                class_2350 class_23503;
                class_2350 class_23504;
                class_2338 class_23382;
                BlockPosX blockPosX;
                Object object;
                class_2350[] arrclass_2350;
                int n4;
                class_2338 class_23383;
                int n5;
                a = iterator.next();
                if (!autoPush.canPush((class_1657)a).booleanValue()) {
                    iterator2 = iterator;
                    continue;
                }
                Object[] arrobject = class_2350.values();
                int n6 = arrobject.length;
                int n7 = n = 0;
                while (n7 < n6) {
                    class_23502 = arrobject[n];
                    if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && autoPush.isTargetHere((class_2338)(object = EntityUtil.getEntityPos((class_1297)a).method_10093(class_23502)), (class_1297)a)) {
                        if (AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238(object))) {
                            if (autoPush.tryPush(EntityUtil.getEntityPos((class_1297)a).method_10093(class_23502.method_10153()), class_23502)) {
                                autoPush.timer.reset();
                                return;
                            }
                            if (autoPush.tryPush(EntityUtil.getEntityPos((class_1297)a).method_10093(class_23502.method_10153()).method_10084(), class_23502)) {
                                autoPush.timer.reset();
                                return;
                            }
                        }
                    }
                    n7 = ++n;
                }
                float[] arrf = new float[3];
                arrf[0] = -0.25f;
                arrf[1] = 0.0f;
                arrf[2] = 0.25f;
                arrobject = arrf;
                Object[] arrobject2 = arrf;
                n = arrobject2.length;
                Object object2 = 0;
                class_23502 = (class_2350)0;
                while (object2 < n) {
                    float f = arrobject2[class_23502];
                    class_23382 = arrobject;
                    n2 = ((class_2350[])class_23382).length;
                    int n8 = n5 = 0;
                    while (n8 < n2) {
                        class_23504 = class_23382[n5];
                        blockPosX = new BlockPosX(a.method_23317() + (double)f, a.method_23318() + 0.5, a.method_23321() + (double)class_23504);
                        arrclass_2350 = class_2350.values();
                        n3 = arrclass_2350.length;
                        int n9 = n4 = 0;
                        while (n9 < n3) {
                            class_23503 = arrclass_2350[n4];
                            if (class_23503 != class_2350.field_11036 && class_23503 != class_2350.field_11033 && autoPush.isTargetHere(class_23383 = blockPosX.method_10093(class_23503), (class_1297)a) && AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238(class_23383))) {
                                if (autoPush.tryPush(blockPosX.method_10093(class_23503.method_10153()), class_23503)) {
                                    autoPush.timer.reset();
                                    return;
                                }
                                if (autoPush.tryPush(blockPosX.method_10093(class_23503.method_10153()).method_10084(), class_23503)) {
                                    autoPush.timer.reset();
                                    return;
                                }
                            }
                            n9 = ++n4;
                        }
                        n8 = ++n5;
                    }
                    object2 = (Object)(++class_23502);
                }
                if (!AutoPush.mc.field_1687.method_39454((class_1297)a, new class_238((class_2338)new BlockPosX(a.method_23317(), a.method_23318() + 2.5, a.method_23321())))) {
                    arrobject2 = class_2350.values();
                    n = arrobject2.length;
                    Object object3 = 0;
                    class_23502 = (class_2350)0;
                    while (object3 < n) {
                        float f = arrobject2[class_23502];
                        object = f;
                        if (f != class_2350.field_11036 && object != class_2350.field_11033) {
                            AutoPush autoPush4 = a;
                            class_23382 = EntityUtil.getEntityPos((class_1297)autoPush4).method_10093((class_2350)object);
                            class_238 class_2383 = autoPush4.method_5829().method_997(new class_243((double)object.method_10148(), (double)object.method_10164(), (double)object.method_10165()));
                            if (autoPush.getBlock(class_23382.method_10084()) != class_2246.field_10379 && !AutoPush.mc.field_1687.method_39454((class_1297)a, class_2383.method_989(0.0, 1.0, 0.0)) && !autoPush.isTargetHere(class_23382, (class_1297)a)) {
                                if (autoPush.tryPush(EntityUtil.getEntityPos((class_1297)a).method_10093(object.method_10153()).method_10084(), (class_2350)object)) {
                                    autoPush.timer.reset();
                                    return;
                                }
                                if (autoPush.tryPush(EntityUtil.getEntityPos((class_1297)a).method_10093(object.method_10153()), (class_2350)object)) {
                                    autoPush.timer.reset();
                                    return;
                                }
                            }
                        }
                        object3 = (Object)(++class_23502);
                    }
                }
                arrobject2 = arrobject;
                n = arrobject2.length;
                Object object4 = 0;
                class_23502 = (class_2350)0;
                do {
                    if (object4 >= n) continue block0;
                    float f = arrobject2[class_23502];
                    class_23382 = arrobject;
                    n2 = ((class_2350[])class_23382).length;
                    int n10 = n5 = 0;
                    while (n10 < n2) {
                        class_23504 = class_23382[n5];
                        blockPosX = new BlockPosX(a.method_23317() + (double)f, a.method_23318() + 0.5, a.method_23321() + (double)class_23504);
                        arrclass_2350 = class_2350.values();
                        n3 = arrclass_2350.length;
                        int n11 = n4 = 0;
                        while (n11 < n3) {
                            class_23503 = arrclass_2350[n4];
                            if (class_23503 != class_2350.field_11036 && class_23503 != class_2350.field_11033 && autoPush.isTargetHere(class_23383 = blockPosX.method_10093(class_23503), (class_1297)a)) {
                                if (autoPush.tryPush(blockPosX.method_10093(class_23503.method_10153()).method_10084(), class_23503)) {
                                    autoPush.timer.reset();
                                    return;
                                }
                                if (autoPush.tryPush(blockPosX.method_10093(class_23503.method_10153()), class_23503)) {
                                    autoPush.timer.reset();
                                    return;
                                }
                            }
                            n11 = ++n4;
                        }
                        n10 = ++n5;
                    }
                    object4 = (Object)(++class_23502);
                } while (true);
            }
            break;
        } while (true);
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

    /*
     * WARNING - void declaration
     */
    boolean isTargetHere(class_2338 class_23382, class_1297 class_12972) {
        void a;
        AutoPush a2 = class_12972;
        AutoPush a3 = this;
        return new class_238((class_2338)a).method_994(a2.method_5829());
    }
}
