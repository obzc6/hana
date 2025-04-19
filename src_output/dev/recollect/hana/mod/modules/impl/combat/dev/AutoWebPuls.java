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
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.MineManager;
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
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
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
import org.bytedeco.javacv.BaseSettings;
import org.bytedeco.javacv.BufferRing;

public class AutoWebPuls
extends Module {
    public final SliderSetting placeRange;
    private float lastPitch;
    public final SliderSetting targetRange;
    private final BooleanSetting leg;
    private final BooleanSetting noHole;
    public final SliderSetting predictTicks;
    private final BooleanSetting checkLook;
    public final EnumSetting<Page> page;
    public final SliderSetting blocksPer;
    private final ArrayList<class_2338> pos;
    private float lastYaw;
    private final BooleanSetting down;
    public final SliderSetting surCheck;
    public class_243 directionVec;
    private final BooleanSetting extendFace;
    private final BooleanSetting detectMining;
    private final SliderSetting yawStep;
    private final BooleanSetting noMine;
    public static boolean place = false;
    private final BooleanSetting extend;
    private final BooleanSetting packet;
    private final Timer timer;
    public final SliderSetting placeDelay;
    private final BooleanSetting checkMine;
    private final BooleanSetting inventorySwap;
    private final BooleanSetting rotate;
    private final BooleanSetting newRotate;
    private final SliderSetting fov;
    public final SliderSetting multiPlace;
    int progress;
    private final SliderSetting tickDelay;
    private final BooleanSetting usingPause;
    public static AutoWebPuls INSTANCE;

    private /* synthetic */ int getWebSlot() {
        AutoWebPuls a;
        if (a.inventorySwap.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10343);
        }
        return InventoryUtil.findBlock(class_2246.field_10343);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ class_243 predictPlayerPosition(class_1657 class_16572, double d) {
        void a;
        void a2;
        AutoWebPuls autoWebPuls = this;
        void v0 = a;
        class_243 class_2432 = v0.method_19538();
        AutoWebPuls a3 = v0.method_18798();
        boolean bl = v0.method_24828() && a.method_18798().field_1351 == 0.0;
        double d2 = 0.42;
        double d3 = 0.08;
        if (bl) {
            a3 = new class_243(((class_243)a3).field_1352, d2, ((class_243)a3).field_1350);
        }
        return new class_243(class_2432.field_1352 + ((class_243)a3).field_1352 * a2, class_2432.field_1351 + ((class_243)a3).field_1351 * a2 - 0.5 * d3 * a2 * a2, class_2432.field_1350 + ((class_243)a3).field_1350 * a2);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoWebPuls a2 = this;
        if (a2.inventorySwap.getValue()) {
            InventoryUtil.inventorySwap(a, AutoWebPuls.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public AutoWebPuls() {
        AutoWebPuls a;
        AutoWebPuls autoWebPuls = a;
        super(OnlineUserInfo.ALLATORIxDEMO("Q\u0012A-{>Qo"), Module.Category.Combat);
        AutoWebPuls autoWebPuls2 = a;
        autoWebPuls2.page = autoWebPuls.add(new EnumSetting<Page>(BaseSettings.ALLATORIxDEMO("eaMz"), Page.General));
        autoWebPuls.placeDelay = autoWebPuls.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("r9q\u0004P\u0006I7R="), 50, 0, 500, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.surCheck = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("ZI^Z]eIt"), 3, 0, 4, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.blocksPer = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0017|\bV)_\u000bV6"), 2, 1, 10, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.tickDelay = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("Z`_G]PlKf"), 100.0, 0.0, 500.0, 1.0, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(OnlineUserInfo.ALLATORIxDEMO("^7")));
        a.multiPlace = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("v{eHEIYaIz"), 2, 1, 14, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.predictTicks = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("u G1y\u0004A\u0016E8X7"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("xlOkjHap[iDx"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.extend = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("p:X>] "), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.extendFace = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("~v}YB}saIz"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.leg = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u0017V#"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.down = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("qo]q"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noHole = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("{-d4_!"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventorySwap = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("rR^`}S^`fwKo"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.usingPause = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("w&y\tR\u0012M.@!"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("kbh_IKTnMz"), 5.0, 0.0, 6.0, 0.1, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0006C'w\u0002A\u0010M5T!"), 8.0, 0.0, 8.0, 0.1, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.checkMine = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("MaYOrxiDz"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noMine = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("{-a2]!"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("~vAa^z"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u001bu\u0010g-X:G!"), false, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("eMnftOo"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("e#O0V0"), false, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("MaYOryoEt"), true, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u001d\\2"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            AutoWebPuls a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        AutoWebPuls autoWebPuls3 = a;
        AutoWebPuls autoWebPuls4 = a;
        AutoWebPuls autoWebPuls5 = a;
        a.timer = new Timer();
        autoWebPuls5.directionVec = null;
        autoWebPuls5.lastYaw = 0.0f;
        autoWebPuls4.lastPitch = 0.0f;
        autoWebPuls4.progress = 0;
        autoWebPuls3.pos = new ArrayList();
        autoWebPuls3.setChinese(BaseSettings.ALLATORIxDEMO("\u81c6\u52b1\u872d\u86db\u7f7b4"));
        INSTANCE = autoWebPuls3;
    }

    /*
     * WARNING - void declaration
     */
    public boolean clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        void a;
        int a2;
        void a3;
        AutoWebPuls a4 = class_23382;
        AutoWebPuls a5 = this;
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a2 != 0 && !a5.faceVector(class_2432)) {
            return false;
        }
        a2 = AutoWebPuls.mc.field_1724.method_31548().field_7545;
        a5.doSwap((int)a);
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a3, (class_2338)a4, false);
        AutoWebPuls.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(AutoWebPuls.mc.field_1687)));
        if (a5.inventorySwap.getValue()) {
            a5.doSwap((int)a);
            EntityUtil.syncInventory();
        } else {
            a5.doSwap(a2);
        }
        return true;
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
        if (var3_2.usingPause.getValue() && AutoWebPuls.mc.field_1724.method_6115()) {
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
                            if (!(!var3_2.leg.getValue() || var3_2.noHole.getValue() && BlockUtil.isHole(EntityUtil.getEntityPos((class_1297)var11_11, true)))) {
                                var3_2.placeWeb(new BlockPosX(a.method_10216(), a.method_10214(), a.method_10215()));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214(), a.method_10215() + 0.2));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214(), a.method_10215() - 0.2));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214(), a.method_10215() + 0.2));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214(), a.method_10215() + 0.3));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214(), a.method_10215() - 0.3));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214(), a.method_10215() + 0.3));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214(), a.method_10215() - 0.3));
                                v2 = a;
                                continue;
                            }
                            if (var3_2.down.getValue()) {
                                var3_2.placeWeb(new BlockPosX(a.method_10216(), a.method_10214() - 0.8, a.method_10215()));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.1, a.method_10214() - 0.3, a.method_10215() + 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.1, a.method_10214() - 0.3, a.method_10215() + 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.1, a.method_10214() - 0.3, a.method_10215() - 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.1, a.method_10214() - 0.3, a.method_10215() - 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() - 0.8, a.method_10215() + 0.3));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() - 0.8, a.method_10215() - 0.3));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() - 0.8, a.method_10215() + 0.3));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() - 0.8, a.method_10215() - 0.3));
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
                                        v13 = var3_2;
                                        v13.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214() + 1.5, a.method_10215() + 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214() + 1.5, a.method_10215() + 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214() + 1.5, a.method_10215() - 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214() + 1.5, a.method_10215() - 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() + 1.2, a.method_10215() + 0.3));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() + 1.2, a.method_10215() - 0.3));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() + 1.2, a.method_10215() + 0.3));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() + 1.2, a.method_10215() - 0.3));
                                        if (v13.isTargetHere(var16_19, var11_11) && AutoWebPuls.mc.field_1687.method_8320((class_2338)var16_19).method_26204() == class_2246.field_10343 && !BlockUtil.isMining(var16_19)) {
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
                                v14 = new float[3];
                                v14[0] = 0.0f;
                                v14[1] = 0.3f;
                                v14[2] = -0.3f;
                                var9_9 = v14;
                                var10_10 = v14.length;
                                v15 = var2_3 = 0;
                                while (v15 < var10_10) {
                                    var12_12 = var9_9[var2_3];
                                    var13_15 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214(), a.method_10215() + (double)var12_12);
                                    if (!var13_15.equals((Object)new BlockPosX(a.method_10216(), a.method_10214(), a.method_10215())) && var3_2.isTargetHere(var13_15, var11_11) && var3_2.placeWeb(var13_15)) {
                                        v16 = var4_4 = true;
                                        break block22;
                                    }
                                    v15 = ++var2_3;
                                }
                                v10 = ++var7_7;
                            }
                        }
                        v16 = var4_4;
                    }
                    if (v16) {
                        v2 = a;
                        continue;
                    }
                    break block23;
                }
                return;
            }
            if (!var3_2.extendFace.getValue()) ** GOTO lbl-1000
            v17 = new float[3];
            v17[0] = 0.0f;
            v17[1] = 0.3f;
            v17[2] = -0.3f;
            var5_5 = v17;
            var6_6 = v17.length;
            v18 = var7_7 = 0;
            do {
                if (v18 >= var6_6) ** GOTO lbl-1000
                var8_8 = var5_5[var7_7];
                v19 = new float[3];
                v19[0] = 0.0f;
                v19[1] = 0.3f;
                v19[2] = -0.3f;
                var9_9 = v19;
                var10_10 = v19.length;
                v20 = var2_3 = 0;
                while (v20 < var10_10) {
                    var12_12 = var9_9[var2_3];
                    var13_16 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214() + 1.1, a.method_10215() + (double)var12_12);
                    if (var3_2.isTargetHere(var13_16, var11_11) && var3_2.placeWeb(var13_16)) continue block0;
                    v20 = ++var2_3;
                }
                v18 = ++var7_7;
            } while (true);
            break;
        } while (true);
    }

    @Override
    public String getInfo() {
        AutoWebPuls a;
        if (a.pos.isEmpty()) {
            return null;
        }
        return OnlineUserInfo.ALLATORIxDEMO("\u0002\u0015^+B<\u001dj");
    }

    private /* synthetic */ boolean placeWeb(class_2338 class_23382) {
        AutoWebPuls a;
        AutoWebPuls a2 = class_23382;
        AutoWebPuls autoWebPuls = a = this;
        a.timer.passedMs(autoWebPuls.tickDelay.getValueInt());
        if (autoWebPuls.pos.contains(a2)) {
            return false;
        }
        AutoWebPuls autoWebPuls2 = a;
        autoWebPuls2.pos.add((class_2338)a2);
        if (autoWebPuls2.progress >= a.multiPlace.getValueInt()) {
            return false;
        }
        if (a.getWebSlot() == -1) {
            return false;
        }
        if (a.checkMine.getValue() && (Hana.BREAK.isMining((class_2338)a2) || !a.noMine.getValue() && a2.equals((Object)SpeedMine.breakPos))) {
            return false;
        }
        if (BlockUtil.getPlaceSide((class_2338)a2, a.placeRange.getValue()) != null && AutoWebPuls.mc.field_1687.method_22347((class_2338)a2)) {
            int n = a.getWebSlot();
            AutoWebPuls autoWebPuls3 = a;
            if (!autoWebPuls3.placeBlock((class_2338)a2, autoWebPuls3.rotate.getValue(), n)) {
                return false;
            }
            if (a.noMine.getValue() && a2.equals((Object)SpeedMine.breakPos)) {
                SpeedMine.breakPos = null;
            }
            AutoWebPuls autoWebPuls4 = a;
            ++autoWebPuls4.progress;
            autoWebPuls4.timer.reset();
            place = false;
            return true;
        }
        return false;
    }

    public boolean surCheck(class_1657 a3) {
        AutoWebPuls a2;
        AutoWebPuls autoWebPuls = a2;
        int a3 = 0;
        a2 = EntityUtil.getPlayerPos();
        if (BlockUtil.getBlock(a2.method_10069(0, 0, 1)) == class_2246.field_9987) {
            ++a3;
        }
        if (BlockUtil.getBlock(a2.method_10069(0, 0, -1)) == class_2246.field_9987) {
            ++a3;
        }
        if (BlockUtil.getBlock(a2.method_10069(1, 0, 0)) == class_2246.field_9987) {
            ++a3;
        }
        if (BlockUtil.getBlock(a2.method_10069(-1, 0, 0)) == class_2246.field_9987) {
            ++a3;
        }
        return (double)a3 < autoWebPuls.surCheck.getValue();
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

    /*
     * WARNING - void declaration
     */
    public boolean placeBlock(class_2338 class_23382, boolean bl, int n) {
        void a;
        void a2;
        class_2350 a3;
        void a4;
        class_2350 class_23502 = this;
        if (BlockUtil.airPlace()) {
            int n2;
            a3 = class_2350.values();
            int n3 = ((class_2350[])a3).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                class_2350 class_23503 = a3[n2];
                if (AutoWebPuls.mc.field_1687.method_22347(a2.method_10093(class_23503))) {
                    return class_23502.clickBlock((class_2338)a2, class_23503, (boolean)a4, (int)a);
                }
                n4 = ++n2;
            }
        }
        if ((a3 = BlockUtil.getPlaceSide((class_2338)a2)) == null) {
            return false;
        }
        class_243 class_2432 = new class_243((double)a2.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a2.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a2.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, a3, (class_2338)a2, false);
        BlockUtil.placedPos.add((class_2338)a2);
        boolean bl2 = false;
        if (AutoWebPuls.mc.field_1724 != null) {
            bl2 = AutoWebPuls.mc.field_1724.method_5624();
        }
        boolean bl3 = false;
        if (AutoWebPuls.mc.field_1687 != null) {
            boolean bl4 = bl3 = AutoWebPuls.needSneak(AutoWebPuls.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !AutoWebPuls.mc.field_1724.method_5715();
        }
        if (bl2) {
            AutoWebPuls.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AutoWebPuls.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl3) {
            AutoWebPuls.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AutoWebPuls.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a2.method_10093(a3), a3.method_10153(), (boolean)a4, (int)a);
        if (bl3) {
            AutoWebPuls.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AutoWebPuls.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl2) {
            AutoWebPuls.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AutoWebPuls.mc.field_1724, class_2848.class_2849.field_12981));
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isTargetHere(class_2338 class_23382, class_1657 class_16572) {
        void a;
        AutoWebPuls a2 = class_16572;
        AutoWebPuls a3 = this;
        return new class_238((class_2338)a).method_994(a2.method_5829());
    }

    public static boolean needSneak(class_2248 a) {
        return BlockUtil.shiftBlocks.contains((Object)a);
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

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        AutoWebPuls a3 = this;
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

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page WebPredictor;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page General;

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

        static {
            General = new Page(MathUtil.ALLATORIxDEMO("\n\u0005\u0012\u0003\b\u0005\u0014"), 0);
            Rotate = new Page(BufferRing.ALLATORIxDEMO("\u001b\u0012 \u0001jO"), 1);
            WebPredictor = new Page(MathUtil.ALLATORIxDEMO("%\u000bGi#(\u0004\u0015\u0005\u000e\u000b\n"), 2);
            $VALUES = Page.$values();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[3];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            arrpage[2] = WebPredictor;
            return arrpage;
        }
    }

}
