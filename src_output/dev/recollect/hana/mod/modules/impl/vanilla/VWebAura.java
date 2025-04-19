/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
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
package dev.recollect.hana.mod.modules.impl.vanilla;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.TPUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.vanilla.VSpeedMine;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2848;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class VWebAura
extends Module {
    public final SliderSetting placeRange;
    private float lastPitch;
    private final BooleanSetting down;
    private final BooleanSetting leg;
    public static VWebAura INSTANCE;
    private final BooleanSetting checkMine;
    public final SliderSetting placeDelay;
    public class_243 directionVec;
    private final BooleanSetting noMine;
    private final SliderSetting fov;
    private final BooleanSetting checkLook;
    public final SliderSetting multiPlace;
    private final BooleanSetting extendFace;
    public final SliderSetting predictTicks;
    private final SliderSetting yawStep;
    private final BooleanSetting packet;
    private final BooleanSetting newRotate;
    private final BooleanSetting rotate;
    private final BooleanSetting noHole;
    private final Timer timer;
    private final BooleanSetting inventorySwap;
    private final BooleanSetting usingPause;
    int progress;
    public final SliderSetting targetRange;
    public final SliderSetting blocksPer;
    private float lastYaw;
    private final BooleanSetting detectMining;
    public static boolean place;
    private final ArrayList<class_2338> pos;
    public final EnumSetting<Page> page;
    private final BooleanSetting extend;

    @Override
    public String getInfo() {
        VWebAura a;
        if (a.pos.isEmpty()) {
            return null;
        }
        return User.ALLATORIxDEMO("fa`QOSF\u0000\u001c");
    }

    static {
        place = false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        void a;
        void a2;
        int a3;
        VWebAura a4 = class_23382;
        VWebAura a5 = this;
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a.method_10163().method_10260() * 0.5);
        if (a3 != 0 && !a5.faceVector(class_2432)) {
            return false;
        }
        a3 = VWebAura.mc.field_1724.method_31548().field_7545;
        a5.doSwap((int)a2);
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        TPUtil.tp(() -> VWebAura.lambda$clickBlock$22(new class_3965(class_2432, (class_2350)a, (class_2338)a4, false)), a4.method_46558());
        if (a5.inventorySwap.getValue()) {
            a5.doSwap((int)a2);
            EntityUtil.syncInventory();
        } else {
            a5.doSwap(a3);
        }
        return true;
    }

    private /* synthetic */ int getWebSlot() {
        VWebAura a;
        if (a.inventorySwap.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10343);
        }
        return InventoryUtil.findBlock(class_2246.field_10343);
    }

    public static boolean needSneak(class_2248 a) {
        return BlockUtil.shiftBlocks.contains((Object)a);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent a) {
        var3_2 = a;
        if (a.isPost() != false) return;
        v0 = var3_2;
        if (!v0.timer.passedMs(v0.placeDelay.getValueInt())) {
            return;
        }
        v1 = var3_2;
        var3_2.pos.clear();
        v1.progress = 0;
        v1.directionVec = null;
        if (var3_2.getWebSlot() == -1) {
            return;
        }
        if (var3_2.usingPause.getValue() && VWebAura.mc.field_1724.method_6115()) {
            return;
        }
        a = CombatUtil.getEnemies(var3_2.targetRange.getValue()).iterator();
        block0 : do lbl-1000: // 5 sources:
        {
            block23 : {
                v2 = a;
                block1 : while (v2.hasNext() != false) {
                    block22 : {
                        block21 : {
                            v3 = var11_11 = a.next();
                            v4 /* !! */  = a = var3_2.predictTicks.getValue() > 0.0 ? CombatUtil.getEntityPosVecWithY(v3, var3_2.predictTicks.getValueInt()) : v3.method_19538();
                            if (var3_2.leg.getValue() && (!var3_2.noHole.getValue() || !BlockUtil.isHole(EntityUtil.getEntityPos((class_1297)var11_11, true))) && var3_2.placeWeb(new BlockPosX(a.method_10216(), a.method_10214(), a.method_10215()))) {
                                v2 = a;
                                continue;
                            }
                            if (var3_2.down.getValue()) {
                                var3_2.placeWeb(new BlockPosX(a.method_10216(), a.method_10214() - 0.8, a.method_10215()));
                            }
                            var4_4 = false;
                            if (!var3_2.extend.getValue() && !var3_2.extendFace.getValue()) ** GOTO lbl-1000
                            v5 = new float[3];
                            v5[0] = 0.0f;
                            v5[1] = 0.3f;
                            v5[2] = -0.3f;
                            var5_5 = v5;
                            var6_6 = v5.length;
                            v6 = var7_7 = 0;
                            do {
                                if (v6 < var6_6) {
                                    var8_8 = var5_5[var7_7];
                                    v7 = new float[3];
                                    v7[0] = 0.0f;
                                    v7[1] = 0.3f;
                                    v7[2] = -0.3f;
                                    var9_9 = v7;
                                    var10_10 = v7.length;
                                    v8 = var2_3 = 0;
                                } else {
                                    if (var4_4) {
                                        v2 = a;
                                        continue block1;
                                    }
                                    if (var3_2.extend.getValue()) {
                                        v9 = new float[3];
                                        v9[0] = 0.0f;
                                        v9[1] = 0.3f;
                                        v9[2] = -0.3f;
                                        var5_5 = v9;
                                        var6_6 = v9.length;
                                        v10 = var7_7 = 0;
                                        break;
                                    }
                                    break block21;
                                }
                                while (v8 < var10_10) {
                                    var12_12 = var9_9[var2_3];
                                    v11 = new float[3];
                                    v11[0] = 0.0f;
                                    v11[1] = 1.0f;
                                    v11[2] = -1.0f;
                                    var13_14 = v11;
                                    var14_17 = v11.length;
                                    v12 = var15_18 = 0;
                                    while (v12 < var14_17) {
                                        var16_20 = var13_14[var15_18];
                                        var16_19 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214() + (double)var16_20, a.method_10215() + (double)var12_12);
                                        if (var3_2.isTargetHere(var16_19, var11_11) && VWebAura.mc.field_1687.method_8320((class_2338)var16_19).method_26204() == class_2246.field_10343 && !BlockUtil.isMining(var16_19)) {
                                            var4_4 = true;
                                        }
                                        v12 = ++var15_18;
                                    }
                                    v8 = ++var2_3;
                                }
                                v6 = ++var7_7;
                            } while (true);
                            while (v10 < var6_6) {
                                var8_8 = var5_5[var7_7];
                                v13 = new float[3];
                                v13[0] = 0.0f;
                                v13[1] = 0.3f;
                                v13[2] = -0.3f;
                                var9_9 = v13;
                                var10_10 = v13.length;
                                v14 = var2_3 = 0;
                                while (v14 < var10_10) {
                                    var12_12 = var9_9[var2_3];
                                    var13_15 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214(), a.method_10215() + (double)var12_12);
                                    if (!var13_15.equals((Object)new BlockPosX(a.method_10216(), a.method_10214(), a.method_10215())) && var3_2.isTargetHere(var13_15, var11_11) && var3_2.placeWeb(var13_15)) {
                                        v15 = var4_4 = true;
                                        break block22;
                                    }
                                    v14 = ++var2_3;
                                }
                                v10 = ++var7_7;
                            }
                        }
                        v15 = var4_4;
                    }
                    if (v15) {
                        v2 = a;
                        continue;
                    }
                    break block23;
                }
                return;
            }
            if (!var3_2.extendFace.getValue()) ** GOTO lbl-1000
            v16 = new float[3];
            v16[0] = 0.0f;
            v16[1] = 0.3f;
            v16[2] = -0.3f;
            var5_5 = v16;
            var6_6 = v16.length;
            v17 = var7_7 = 0;
            do {
                if (v17 >= var6_6) ** GOTO lbl-1000
                var8_8 = var5_5[var7_7];
                v18 = new float[3];
                v18[0] = 0.0f;
                v18[1] = 0.3f;
                v18[2] = -0.3f;
                var9_9 = v18;
                var10_10 = v18.length;
                v19 = var2_3 = 0;
                while (v19 < var10_10) {
                    var12_12 = var9_9[var2_3];
                    var13_16 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214() + 1.1, a.method_10215() + (double)var12_12);
                    if (var3_2.isTargetHere(var13_16, var11_11) && var3_2.placeWeb(var13_16)) continue block0;
                    v19 = ++var2_3;
                }
                v17 = ++var7_7;
            } while (true);
            break;
        } while (true);
    }

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

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        VWebAura a2 = this;
        if (a2.inventorySwap.getValue()) {
            InventoryUtil.inventorySwap(a, VWebAura.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public VWebAura() {
        VWebAura a;
        VWebAura vWebAura = a;
        super(BetterDynamicAnimation.ALLATORIxDEMO("PeWdttTs"), Module.Category.Combat);
        VWebAura vWebAura2 = a;
        vWebAura2.page = vWebAura.add(new EnumSetting<Page>(User.ALLATORIxDEMO("m@IW"), Page.General));
        vWebAura.placeDelay = vWebAura.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("u}gQWBPmGk"), 50, 0, 500, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.blocksPer = a.add(new SliderSetting(User.ALLATORIxDEMO("sb}YMNqK@"), 2, 1, 10, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.multiPlace = a.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("hdjF[VY`Ew"), 2, 1, 10, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.predictTicks = a.add(new SliderSetting(User.ALLATORIxDEMO("zDHUgqNrTBEA"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("fsQteFo[hHu"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.extend = a.add(new BooleanSetting(User.ALLATORIxDEMO("^ID@V"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.extendFace = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("`irW\\bs`Ew"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.leg = a.add(new BooleanSetting(User.ALLATORIxDEMO("mKU"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.down = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("qnQ|"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noHole = a.add(new BooleanSetting(User.ALLATORIxDEMO("tIuNBW"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventorySwap = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("mL`@r]@fvGb"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.usingPause = a.add(new BooleanSetting(User.ALLATORIxDEMO("xBg|]v\\T]W"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("u}gQWTToAw"), 5.0, 0.0, 300.0, 0.1, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(User.ALLATORIxDEMO("bLCiwNt\\OIW"), 8.0, 0.0, 300.0, 0.1, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.checkMine = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("RnWQmxhHw"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noMine = a.add(new BooleanSetting(User.ALLATORIxDEMO("tIpH@W"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("`iA`Rw"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(User.ALLATORIxDEMO("kehII@ZW"), false, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("kSqfuCb"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(User.ALLATORIxDEMO("jG^JKF"), false, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("RnWQmynIy"), true, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(User.ALLATORIxDEMO("gAD"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            VWebAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        VWebAura vWebAura3 = a;
        VWebAura vWebAura4 = a;
        VWebAura vWebAura5 = a;
        a.timer = new Timer();
        vWebAura5.directionVec = null;
        vWebAura5.lastYaw = 0.0f;
        vWebAura4.lastPitch = 0.0f;
        vWebAura4.progress = 0;
        vWebAura3.pos = new ArrayList();
        vWebAura3.setChinese(BetterDynamicAnimation.ALLATORIxDEMO("\u53ad\u727a\u871e\u86ee\u7f50\u516f\u73bd"));
        INSTANCE = vWebAura3;
    }

    @EventHandler(priority=98)
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.newRotate.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.yawStep.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            RotateEvent rotateEvent = a;
            rotateEvent.setYaw(arrf.lastYaw);
            rotateEvent.setPitch(arrf.lastPitch);
            return;
        }
        float[] arrf3 = arrf;
        arrf3.lastYaw = Hana.ROTATE.lastYaw;
        arrf3.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ boolean placeWeb(class_2338 class_23382) {
        VWebAura a = class_23382;
        VWebAura a2 = this;
        if (a2.pos.contains(a)) {
            return false;
        }
        VWebAura vWebAura = a2;
        vWebAura.pos.add((class_2338)a);
        if (vWebAura.progress >= a2.multiPlace.getValueInt()) {
            return false;
        }
        if (a2.getWebSlot() == -1) {
            return false;
        }
        if (a2.checkMine.getValue() && (Hana.BREAK.isMining((class_2338)a) || !a2.noMine.getValue() && a.equals((Object)VSpeedMine.breakPos))) {
            return false;
        }
        if (BlockUtil.getPlaceSide((class_2338)a, a2.placeRange.getValue()) != null && VWebAura.mc.field_1687.method_22347((class_2338)a)) {
            int n = a2.getWebSlot();
            VWebAura vWebAura2 = a2;
            if (!vWebAura2.placeBlock((class_2338)a, vWebAura2.rotate.getValue(), n)) {
                return false;
            }
            if (a2.noMine.getValue() && a.equals((Object)VSpeedMine.breakPos)) {
                VSpeedMine.breakPos = null;
            }
            VWebAura vWebAura3 = a2;
            ++vWebAura3.progress;
            vWebAura3.timer.reset();
            place = false;
            return true;
        }
        return false;
    }

    private static /* synthetic */ void lambda$clickBlock$22(class_3965 a) {
        VWebAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, a, BlockUtil.getWorldActionId(VWebAura.mc.field_1687)));
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        VWebAura a3 = this;
        if (a2 < 0.01f) {
            a2 = 0.01f;
        }
        if (a2 > 1.0f) {
            a2 = 1.0f;
        }
        if (a2 < 1.0f && a != null) {
            float f2;
            void v2;
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
        float[] arrf2 = new float[2];
        arrf2[0] = a[0];
        arrf2[1] = a[1];
        return arrf2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean placeBlock(class_2338 class_23382, boolean bl, int n) {
        void a;
        class_2350 a2;
        void a3;
        void a4;
        class_2350 class_23502 = this;
        if (BlockUtil.airPlace()) {
            int n2;
            a2 = class_2350.values();
            int n3 = ((class_2350[])a2).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                class_2350 class_23503 = a2[n2];
                if (VWebAura.mc.field_1687.method_22347(a4.method_10093(class_23503))) {
                    return class_23502.clickBlock((class_2338)a4, class_23503, (boolean)a3, (int)a);
                }
                n4 = ++n2;
            }
        }
        if ((a2 = BlockUtil.getPlaceSide((class_2338)a4)) == null) {
            return false;
        }
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a2.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a2.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a2.method_10163().method_10260() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, a2, (class_2338)a4, false);
        BlockUtil.placedPos.add((class_2338)a4);
        boolean bl2 = false;
        if (VWebAura.mc.field_1724 != null) {
            bl2 = VWebAura.mc.field_1724.method_5624();
        }
        boolean bl3 = false;
        if (VWebAura.mc.field_1687 != null) {
            boolean bl4 = bl3 = VWebAura.needSneak(VWebAura.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !VWebAura.mc.field_1724.method_5715();
        }
        if (bl2) {
            VWebAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VWebAura.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl3) {
            VWebAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VWebAura.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a4.method_10093(a2), a2.method_10153(), (boolean)a3, (int)a);
        if (bl3) {
            VWebAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VWebAura.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl2) {
            VWebAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VWebAura.mc.field_1724, class_2848.class_2849.field_12981));
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isTargetHere(class_2338 class_23382, class_1657 class_16572) {
        void a;
        VWebAura a2 = class_16572;
        VWebAura a3 = this;
        return new class_238((class_2338)a).method_994(a2.method_5829());
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Rotate;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;

        static {
            General = new Page(MathUtil.ALLATORIxDEMO("\n\u0005\u0012\u0003\b\u0005\u0014"), 0);
            Rotate = new Page(Setting.ALLATORIxDEMO("I7r$8j"), 1);
            $VALUES = Page.$values();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            return arrpage;
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

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

}
