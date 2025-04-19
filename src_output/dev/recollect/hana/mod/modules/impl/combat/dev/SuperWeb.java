/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
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
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_4587
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
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1268;
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
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class SuperWeb
extends Module {
    private final BooleanSetting checkLook;
    public static boolean ignore;
    private final BooleanSetting onlyTick;
    private final SliderSetting fov;
    private float lastPitch;
    public static SuperWeb INSTANCE;
    private final BooleanSetting usingPause;
    private float lastYaw;
    public final SliderSetting targetRange;
    private final BooleanSetting inventorySwap;
    public final SliderSetting blocksPer;
    private final Timer timer;
    public final SliderSetting placeDelay;
    private final BooleanSetting face;
    private final SliderSetting yawStep;
    private final BooleanSetting feet;
    public static boolean force;
    private final BooleanSetting rotate;
    private final BooleanSetting newRotate;
    int progress;
    public final SliderSetting offset;
    public final SliderSetting predictTicks;
    private final ArrayList<class_2338> pos;
    public final SliderSetting maxWebs;
    private final BooleanSetting packet;
    public final SliderSetting placeRange;
    public class_243 directionVec;
    private final BooleanSetting down;
    private final BooleanSetting detectMining;
    private final BooleanSetting preferAnchor;
    public final EnumSetting<Page> page;

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

    static {
        force = false;
        ignore = false;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        SuperWeb a3 = this;
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
    private /* synthetic */ boolean isTargetHere(class_2338 class_23382, class_1657 class_16572) {
        void a;
        SuperWeb a2 = class_16572;
        SuperWeb a3 = this;
        return new class_238((class_2338)a).method_994(a2.method_5829());
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

    @Override
    public void onDisable() {
        force = false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        int a;
        void a2;
        void a3;
        SuperWeb a4 = class_23382;
        SuperWeb a5 = this;
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a != 0 && !a5.faceVector(class_2432)) {
            return false;
        }
        a = SuperWeb.mc.field_1724.method_31548().field_7545;
        a5.doSwap((int)a2);
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a3, (class_2338)a4, false);
        SuperWeb.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(SuperWeb.mc.field_1687)));
        if (a5.inventorySwap.getValue()) {
            a5.doSwap((int)a2);
            EntityUtil.syncInventory();
        } else {
            a5.doSwap(a);
        }
        return true;
    }

    private /* synthetic */ int getWebSlot() {
        SuperWeb a;
        if (a.inventorySwap.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10343);
        }
        return InventoryUtil.findBlock(class_2246.field_10343);
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        SuperWeb a2 = this;
        if (!a2.onlyTick.getValue()) {
            a2.onUpdate();
        }
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        SuperWeb a2 = this;
        if (a2.inventorySwap.getValue()) {
            InventoryUtil.inventorySwap(a, SuperWeb.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public SuperWeb() {
        SuperWeb a;
        SuperWeb superWeb = a;
        super(RadiusUtils.ALLATORIxDEMO("`\u0012D\u0005[*\u0006U"), Module.Category.Combat);
        SuperWeb superWeb2 = a;
        superWeb2.page = superWeb.add(new EnumSetting<Page>(RenderHelper.ALLATORIxDEMO("'iZ'"), Page.General));
        superWeb.placeDelay = superWeb.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("d\fR\u0004Q$L\u0011\u0002N"), 50, 0, 500, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.blocksPer = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("W\u0001}\t~\u0004XX0"), 2, 1, 10, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.predictTicks = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("1GQ\u0004Z\u0004@4@\u001e\bD"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.preferAnchor = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("o2\u000fs\b`+{\u0014`R0"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("%P@\u0005P\u0013y\tG\u0014\rP"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.onlyTick = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("\"|\u0006l#a^)"), false, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.feet = a.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("o\u0018\u0006C"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.face = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("1i^'"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.maxWebs = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("*U\u0018~\u0018\u0001D"), 2.0, 1.0, 8.0, 1.0, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.down = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("3gJ,"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventorySwap = a.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("\"\u000fCQ\u000eG\bF\u0019z\n\u0002G"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.usingPause = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("?f\u0004|\rE\u0016}N'"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.offset = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("{\u0006O\u000e\u0006C"), 0.25, 0.0, 0.3, 0.01, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO(":y\fq\u000fG\u0016fZ'"), 5.0, 0.0, 6.0, 0.1, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("aU\u0012T\u0002@2H\u0013\u0004R"), 8.0, 0.0, 8.0, 0.1, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("8z\u0003iI'"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO(".V\u0010f\u000f]\u001c\u0017R"), false, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("K\u000bb$|X2"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("d\u0001J\u0016\u0006C"), false, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("V\u0005w\t~;gR)"), true, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO(";\fA"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            SuperWeb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        SuperWeb superWeb3 = a;
        SuperWeb superWeb4 = a;
        SuperWeb superWeb5 = a;
        a.timer = new Timer();
        superWeb5.directionVec = null;
        superWeb5.lastYaw = 0.0f;
        superWeb4.lastPitch = 0.0f;
        superWeb4.progress = 0;
        superWeb3.pos = new ArrayList();
        superWeb3.setChinese(RenderHelper.ALLATORIxDEMO("\u7087\u9e56\u8710\u86e6\u7f13"));
        INSTANCE = superWeb3;
    }

    private /* synthetic */ boolean placeWeb(class_2338 class_23382) {
        SuperWeb a = class_23382;
        SuperWeb a2 = this;
        if (a2.pos.contains(a)) {
            return false;
        }
        SuperWeb superWeb = a2;
        superWeb.pos.add((class_2338)a);
        if (superWeb.progress >= a2.blocksPer.getValueInt()) {
            return false;
        }
        if (a2.getWebSlot() == -1) {
            return false;
        }
        if (a2.detectMining.getValue() && Hana.BREAK.isMining((class_2338)a)) {
            return false;
        }
        if (BlockUtil.getPlaceSide((class_2338)a, a2.placeRange.getValue()) != null && (SuperWeb.mc.field_1687.method_22347((class_2338)a) || ignore && BlockUtil.getBlock((class_2338)a) == class_2246.field_10343) && a.method_10264() < 320) {
            int n = SuperWeb.mc.field_1724.method_31548().field_7545;
            int n2 = a2.getWebSlot();
            SuperWeb superWeb2 = a2;
            if (!superWeb2.placeBlock((class_2338)a, superWeb2.rotate.getValue(), n2)) {
                return false;
            }
            BlockUtil.placedPos.add((class_2338)a);
            ++a2.progress;
            SuperWeb superWeb3 = a2;
            if (a2.inventorySwap.getValue()) {
                superWeb3.doSwap(n2);
                EntityUtil.syncInventory();
            } else {
                superWeb3.doSwap(n);
            }
            force = false;
            a2.timer.reset();
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean placeBlock(class_2338 class_23382, boolean bl, int n) {
        void a;
        void a2;
        void a3;
        SuperWeb superWeb = this;
        SuperWeb a4 = BlockUtil.getPlaceSide((class_2338)a3);
        if (a4 == null) {
            if (BlockUtil.airPlace()) {
                return superWeb.clickBlock((class_2338)a3, class_2350.field_11033, (boolean)a2, (int)a);
            }
            return false;
        }
        return superWeb.clickBlock(a3.method_10093((class_2350)a4), a4.method_10153(), (boolean)a2, (int)a);
    }

    @Override
    public void onUpdate() {
        SuperWeb a;
        if (force) {
            ignore = true;
        }
        a.update();
        ignore = false;
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        SuperWeb a2 = this;
        if (!a2.onlyTick.getValue()) {
            a2.onUpdate();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ void update() {
        v0 = var3_1 = a;
        if (!v0.timer.passedMs(v0.placeDelay.getValueInt())) {
            return;
        }
        v1 = var3_1;
        var3_1.pos.clear();
        v1.progress = 0;
        v1.directionVec = null;
        if (var3_1.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            return;
        }
        if (var3_1.getWebSlot() == -1) {
            return;
        }
        if (Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) {
            return;
        }
        if (var3_1.usingPause.getValue() && SuperWeb.mc.field_1724.method_6115()) {
            return;
        }
        var13_2 = CombatUtil.getEnemies(var3_1.targetRange.getValue()).iterator();
        block0 : do lbl-1000: // 4 sources:
        {
            block25 : {
                v2 = var13_2;
                block1 : while (v2.hasNext() != false) {
                    block24 : {
                        block23 : {
                            v3 = var9_13 = var13_2.next();
                            a = var3_1.predictTicks.getValue() > 0.0 ? CombatUtil.getEntityPosVec(v3, var3_1.predictTicks.getValueInt()) : v3.method_19538();
                            var4_5 = 0;
                            if (var3_1.down.getValue()) {
                                var3_1.placeWeb(new BlockPosX(a.method_10216(), a.method_10214() - 0.8, a.method_10215()));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.1, a.method_10214() - 0.3, a.method_10215() + 0.1));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.1, a.method_10214() - 0.3, a.method_10215() + 0.1));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.1, a.method_10214() - 0.3, a.method_10215() - 0.1));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.1, a.method_10214() - 0.3, a.method_10215() - 0.1));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() - 0.8, a.method_10215() + 0.3));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() - 0.8, a.method_10215() - 0.3));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() - 0.8, a.method_10215() + 0.3));
                                var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() - 0.8, a.method_10215() - 0.3));
                            }
                            var5_6 = new ArrayList<BlockPosX>();
                            v4 = new float[3];
                            v4[0] = 0.0f;
                            v4[1] = var3_1.offset.getValueFloat();
                            v4[2] = -var3_1.offset.getValueFloat();
                            var6_8 = v4;
                            var7_9 = v4.length;
                            v5 = var8_12 = 0;
                            do {
                                if (v5 < var7_9) {
                                    var2_4 = var6_8[var8_12];
                                    v6 = new float[3];
                                    v6[0] = 0.0f;
                                    v6[1] = var3_1.offset.getValueFloat();
                                    v6[2] = -var3_1.offset.getValueFloat();
                                    var10_14 /* !! */  = v6;
                                    var11_15 = v6.length;
                                    v7 = var12_18 = 0;
                                } else {
                                    if ((float)var4_5 >= var3_1.maxWebs.getValueFloat() && !SuperWeb.ignore) {
                                        v2 = var13_2;
                                        continue block1;
                                    }
                                    var6_7 = false;
                                    if (var3_1.feet.getValue()) {
                                        v8 = new float[3];
                                        v8[0] = 0.0f;
                                        v8[1] = var3_1.offset.getValueFloat();
                                        v8[2] = -var3_1.offset.getValueFloat();
                                        var7_10 = v8;
                                        var8_12 = v8.length;
                                        v9 = 0;
                                        var2_4 = 0;
                                        break;
                                    }
                                    break block23;
                                }
                                while (v7 < var11_15) {
                                    var1_3 = var10_14 /* !! */ [var12_18];
                                    v10 = new float[3];
                                    v10[0] = 0.0f;
                                    v10[1] = 1.0f;
                                    v10[2] = -1.0f;
                                    var14_19 /* !! */  = v10;
                                    var15_20 = v10.length;
                                    v11 = var16_23 = 0;
                                    while (v11 < var15_20) {
                                        var17_25 = var14_19 /* !! */ [var16_23];
                                        var17_24 = new BlockPosX(a.method_10216() + (double)var2_4, a.method_10214() + (double)var17_25, a.method_10215() + (double)var1_3);
                                        if (!var5_6.contains((Object)var17_24)) {
                                            v12 = var17_24;
                                            var5_6.add(v12);
                                            if (var3_1.isTargetHere(v12, var9_13) && SuperWeb.mc.field_1687.method_8320((class_2338)var17_24).method_26204() == class_2246.field_10343 && !Hana.BREAK.isMining(var17_24)) {
                                                ++var4_5;
                                            }
                                        }
                                        v11 = ++var16_23;
                                    }
                                    v7 = ++var12_18;
                                }
                                v5 = ++var8_12;
                            } while (true);
                            while (v9 < var8_12) {
                                var10_14 /* !! */  = (float[])var7_10[var2_4];
                                v13 = new float[3];
                                v13[0] = 0.0f;
                                v13[1] = var3_1.offset.getValueFloat();
                                v13[2] = -var3_1.offset.getValueFloat();
                                var11_16 = v13;
                                var12_18 = v13.length;
                                v14 = 0;
                                var1_3 = 0;
                                while (v14 < var12_18) {
                                    var14_19 /* !! */  = (float[])var11_16[var1_3];
                                    var15_21 = new BlockPosX(a.method_10216() + (double)var10_14 /* !! */ , a.method_10214(), a.method_10215() + (double)var14_19 /* !! */ );
                                    v15 = var3_1;
                                    v15.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214(), a.method_10215() + 0.2));
                                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214(), a.method_10215() - 0.2));
                                    var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214(), a.method_10215() + 0.2));
                                    var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214(), a.method_10215() + 0.3));
                                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214(), a.method_10215() - 0.3));
                                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214(), a.method_10215() + 0.3));
                                    var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214(), a.method_10215() - 0.3));
                                    if (v15.isTargetHere(var15_21, var9_13) && var3_1.placeWeb(var15_21) && (float)(++var4_5) >= var3_1.maxWebs.getValueFloat()) {
                                        v16 = var6_7 = true;
                                        break block24;
                                    }
                                    v14 = (int)(++var1_3);
                                }
                                v9 = (int)(++var2_4);
                            }
                        }
                        v16 = var6_7;
                    }
                    if (v16) {
                        v2 = var13_2;
                        continue;
                    }
                    break block25;
                }
                return;
            }
            if (!var3_1.face.getValue()) ** GOTO lbl-1000
            v17 = new float[3];
            v17[0] = 0.0f;
            v17[1] = var3_1.offset.getValueFloat();
            v17[2] = -var3_1.offset.getValueFloat();
            var7_11 = v17;
            var8_12 = v17.length;
            v18 = 0;
            var2_4 = 0;
            do {
                if (v18 >= var8_12) ** GOTO lbl-1000
                var10_14 /* !! */  = (float[])var7_11[var2_4];
                v19 = new float[3];
                v19[0] = 0.0f;
                v19[1] = var3_1.offset.getValueFloat();
                v19[2] = -var3_1.offset.getValueFloat();
                var11_17 = v19;
                var12_18 = v19.length;
                v20 = 0;
                var1_3 = 0;
                while (v20 < var12_18) {
                    var14_19 /* !! */  = (float[])var11_17[var1_3];
                    var15_22 = new BlockPosX(a.method_10216() + (double)var10_14 /* !! */ , a.method_10214() + 1.1, a.method_10215() + (double)var14_19 /* !! */ );
                    v21 = var3_1;
                    v21.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214() + 1.5, a.method_10215() + 0.2));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214() + 1.5, a.method_10215() + 0.2));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214() + 1.5, a.method_10215() - 0.2));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214() + 1.5, a.method_10215() - 0.2));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() + 1.2, a.method_10215() + 0.3));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() + 1.2, a.method_10215() - 0.3));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() - 0.3, a.method_10214() + 1.2, a.method_10215() + 0.3));
                    var3_1.placeWeb(new BlockPosX(a.method_10216() + 0.3, a.method_10214() + 1.2, a.method_10215() - 0.3));
                    if (v21.isTargetHere(var15_22, var9_13) && var3_1.placeWeb(var15_22) && (float)(++var4_5) >= var3_1.maxWebs.getValueFloat()) continue block0;
                    v20 = (int)(++var1_3);
                }
                v18 = (int)(++var2_4);
            } while (true);
            break;
        } while (true);
    }

    @Override
    public String getInfo() {
        SuperWeb a;
        if (a.pos.isEmpty()) {
            return null;
        }
        return RadiusUtils.ALLATORIxDEMO("\u0017\\\u0015P\u0006\\\u0001");
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page General;
        private static final /* synthetic */ Page[] $VALUES;

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

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        static {
            General = new Page(Snow.ALLATORIxDEMO("\"e:c e<"), 0);
            Rotate = new Page(GaussianKernel.ALLATORIxDEMO("\u000e!.),/"), 1);
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            return arrpage;
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

}
