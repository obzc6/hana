/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2371
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ExplosionUtil;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.video.FileUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameConverter;

public class HanaCrystalBase
extends Module {
    private final SliderSetting forceMaxHealth;
    private final SliderSetting targetRange;
    public static Thread thread;
    final Timer noPosTimer;
    public float tempDamage;
    private final SliderSetting wallRange;
    public class_1657 displayTarget;
    private final BooleanSetting breakOnlyHasCrystal;
    private final BooleanSetting smart;
    private final BooleanSetting lite;
    private final BooleanSetting armorBreaker;
    private final BooleanSetting auto;
    private class_2338 tempPos;
    private final BooleanSetting random;
    private final BooleanSetting eatingPause;
    private final SliderSetting placeDelay;
    private final BooleanSetting forcePlace;
    private final BooleanSetting yawStep;
    private final SliderSetting maxDurable;
    private final Timer delayTimer;
    private final SliderSetting minDamage;
    private final BooleanSetting checkLook;
    private float lastYaw;
    private final SliderSetting steps;
    private final Timer placeTimer;
    private final SliderSetting range;
    private final BooleanSetting rotate;
    private final SliderSetting updateDelay;
    private final BooleanSetting useThread;
    public class_243 directionVec;
    private final SliderSetting placeRange;
    private final BooleanSetting detectMining;
    private final EnumSetting<Page> page;
    private final BooleanSetting packet;
    private final SliderSetting autoMinDamage;
    private final BooleanSetting inventory;
    private final SliderSetting forceMin;
    public float lastDamage;
    private final SliderSetting hurtTime;
    private final SliderSetting armorBreakerDamage;
    private final SliderSetting noSuicide;
    private final BooleanSetting terrainIgnore;
    private final SliderSetting fov;
    private float lastPitch;
    public float breakDamage;
    private final BooleanSetting doCrystal;
    private final SliderSetting maxSelf;
    private final SliderSetting predictTicks;
    public static class_2338 crystalPos;
    public static HanaCrystalBase INSTANCE;

    public static class_2248 getBlock(class_2338 a) {
        return HanaCrystalBase.mc.field_1687.method_8320(a).method_26204();
    }

    @Override
    public void onUpdate() {
        HanaCrystalBase hanaCrystalBase;
        block4 : {
            HanaCrystalBase hanaCrystalBase2;
            block3 : {
                block2 : {
                    HanaCrystalBase a22;
                    hanaCrystalBase2 = a22;
                    if (!hanaCrystalBase2.useThread.getValue()) break block2;
                    if (thread != null && thread.isAlive()) break block3;
                    thread = new Thread(() -> {
                        HanaCrystalBase a;
                        while (INSTANCE.isOn() && a.useThread.getValue()) {
                            a.updateCrystalPos();
                        }
                        crystalPos = null;
                        a.tempPos = null;
                    });
                    try {
                        thread.start();
                        hanaCrystalBase = hanaCrystalBase2;
                    }
                    catch (Exception a22) {
                        hanaCrystalBase = hanaCrystalBase2;
                        a22.printStackTrace();
                    }
                    break block4;
                }
                hanaCrystalBase2.updateCrystalPos();
            }
            hanaCrystalBase = hanaCrystalBase2;
        }
        hanaCrystalBase.doInteract();
    }

    private /* synthetic */ void update() {
        Object object;
        HanaCrystalBase a;
        HanaCrystalBase hanaCrystalBase = a;
        if (HanaCrystalBase.nullCheck()) {
            return;
        }
        HanaCrystalBase hanaCrystalBase2 = hanaCrystalBase;
        if (!hanaCrystalBase2.delayTimer.passedMs((long)hanaCrystalBase2.updateDelay.getValue())) {
            return;
        }
        if (hanaCrystalBase.eatingPause.getValue() && HanaCrystalBase.mc.field_1724.method_6115()) {
            hanaCrystalBase.tempPos = null;
            return;
        }
        if (Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) {
            hanaCrystalBase.tempPos = null;
            return;
        }
        if (hanaCrystalBase.breakOnlyHasCrystal.getValue() && !HanaCrystalBase.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !HanaCrystalBase.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !HanaAura.INSTANCE.findCrystal()) {
            hanaCrystalBase.tempPos = null;
            return;
        }
        hanaCrystalBase.delayTimer.reset();
        hanaCrystalBase.breakDamage = 0.0f;
        hanaCrystalBase.tempPos = null;
        hanaCrystalBase.tempDamage = 0.0f;
        ArrayList<PlayerAndPredict> arrayList = new ArrayList<PlayerAndPredict>();
        Object object2 = CombatUtil.getEnemies(hanaCrystalBase.targetRange.getValueFloat()).iterator();
        while (object2.hasNext()) {
            object = object2.next();
            if (((class_1657)object).field_6235 > hanaCrystalBase.hurtTime.getValueInt()) continue;
            arrayList.add(new PlayerAndPredict(hanaCrystalBase, (class_1657)object));
        }
        object2 = new PlayerAndPredict(hanaCrystalBase, (class_1657)HanaCrystalBase.mc.field_1724);
        if (!arrayList.isEmpty()) {
            object = BlockUtil.getSphere((float)hanaCrystalBase.range.getValue() + 1.0f).iterator();
            block1 : do {
                Object object3 = object;
                while (object3.hasNext()) {
                    a = (class_2338)object.next();
                    CombatUtil.modifyPos = null;
                    if (HanaCrystalBase.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > hanaCrystalBase.range.getValue()) {
                        object3 = object;
                        continue;
                    }
                    if (!hanaCrystalBase.canPlaceCrystal((class_2338)a, true, false)) {
                        object3 = object;
                        continue;
                    }
                    CombatUtil.modifyPos = a.method_10074();
                    CombatUtil.modifyBlockState = class_2246.field_10540.method_9564();
                    if (hanaCrystalBase.behindWall((class_2338)a)) {
                        object3 = object;
                        continue;
                    }
                    if (!hanaCrystalBase.canTouch(a.method_10074())) {
                        object3 = object;
                        continue;
                    }
                    Iterator iterator = arrayList.iterator();
                    block3 : do {
                        PlayerAndPredict playerAndPredict;
                        float f;
                        Iterator iterator2 = iterator;
                        do {
                            float f2;
                            if (!iterator2.hasNext()) continue block1;
                            playerAndPredict = (PlayerAndPredict)iterator.next();
                            if (a.method_10074().method_10264() > playerAndPredict.player.method_31478()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (hanaCrystalBase.lite.getValue() && hanaCrystalBase.liteCheck(a.method_46558().method_1031(0.0, -0.5, 0.0), playerAndPredict.predict.method_19538())) {
                                iterator2 = iterator;
                                continue;
                            }
                            HanaCrystalBase hanaCrystalBase3 = hanaCrystalBase;
                            PlayerAndPredict playerAndPredict2 = playerAndPredict;
                            f = hanaCrystalBase3.calculateDamage((class_2338)a, playerAndPredict2.player, playerAndPredict2.predict);
                            if (hanaCrystalBase3.tempPos != null && !(f > hanaCrystalBase.tempDamage)) continue block3;
                            Object object4 = object2;
                            float f3 = hanaCrystalBase.calculateDamage((class_2338)a, ((PlayerAndPredict)object4).player, ((PlayerAndPredict)object4).predict);
                            if ((double)f2 > hanaCrystalBase.maxSelf.getValue()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (hanaCrystalBase.noSuicide.getValue() > 0.0 && (double)f3 > (double)(HanaCrystalBase.mc.field_1724.method_6032() + HanaCrystalBase.mc.field_1724.method_6067()) - hanaCrystalBase.noSuicide.getValue()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (!(f < EntityUtil.getHealth((class_1297)playerAndPredict.player))) break;
                            if ((double)f < hanaCrystalBase.getDamage(playerAndPredict.player)) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (!hanaCrystalBase.smart.getValue()) break;
                            if (hanaCrystalBase.getDamage(playerAndPredict.player) == hanaCrystalBase.forceMin.getValue()) {
                                if (!((double)f < (double)f3 - 2.5)) break;
                                iterator2 = iterator;
                                continue;
                            }
                            if (!(f < f3)) break;
                            iterator2 = iterator;
                        } while (true);
                        HanaCrystalBase hanaCrystalBase4 = hanaCrystalBase;
                        hanaCrystalBase4.displayTarget = playerAndPredict.player;
                        hanaCrystalBase4.tempPos = a.method_10074();
                        hanaCrystalBase.tempDamage = f;
                    } while (true);
                }
                break;
            } while (true);
            CombatUtil.modifyPos = null;
            if (hanaCrystalBase.tempPos != null) {
                HanaCrystalBase hanaCrystalBase5 = hanaCrystalBase;
                if (!BlockUtil.canPlace(hanaCrystalBase5.tempPos, hanaCrystalBase5.placeRange.getValue())) {
                    HanaCrystalBase hanaCrystalBase6 = hanaCrystalBase;
                    hanaCrystalBase6.tempPos = null;
                    hanaCrystalBase6.tempDamage = 0.0f;
                }
            }
        }
        if (hanaCrystalBase.doCrystal.getValue() && hanaCrystalBase.tempPos != null) {
            HanaCrystalBase hanaCrystalBase7 = hanaCrystalBase;
            hanaCrystalBase7.doPlace(hanaCrystalBase7.tempPos);
        }
    }

    private /* synthetic */ boolean canTouch(class_2338 a) {
        HanaCrystalBase a2;
        HanaCrystalBase hanaCrystalBase = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(HanaCrystalBase.mc.field_1724.method_33571()) <= hanaCrystalBase.range.getValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onLogin() {
        HanaCrystalBase a;
        if (a.useThread.getValue()) {
            a.updateCrystalPos();
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        HanaCrystalBase a3 = this;
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
        float[] arrf2 = new float[2];
        arrf2[0] = a[0];
        arrf2[1] = a[1];
        return arrf2;
    }

    private /* synthetic */ double getDamage(class_1657 class_16572) {
        Object a = class_16572;
        HanaCrystalBase a2 = this;
        if (a2.forcePlace.getValue() && (double)EntityUtil.getHealth((class_1297)a) <= a2.forceMaxHealth.getValue() && !SpeedMine.INSTANCE.obsidian.isPressed() && !PistonCrystal.INSTANCE.isOn()) {
            return a2.forceMin.getValue();
        }
        if (a2.armorBreaker.getValue()) {
            Object object = a = a.method_31548().field_7548.iterator();
            while (object.hasNext()) {
                class_1799 class_17992 = (class_1799)a.next();
                if (class_17992.method_7960()) {
                    object = a;
                    continue;
                }
                if ((double)EntityUtil.getDamagePercent(class_17992) > a2.maxDurable.getValue()) {
                    object = a;
                    continue;
                }
                return a2.armorBreakerDamage.getValue();
            }
        }
        if (PistonCrystal.INSTANCE.isOn()) {
            return a2.autoMinDamage.getValueFloat();
        }
        return a2.minDamage.getValue();
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.rotate.getValue() && arrf.yawStep.getValue() && arrf.directionVec != null && !arrf.noPosTimer.passed(1000L)) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.steps.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            if (arrf2.random.getValue() && new Random().nextBoolean()) {
                float[] arrf3 = arrf;
                arrf.lastPitch = Math.min(new Random().nextFloat() * 2.0f + arrf.lastPitch, 90.0f);
            }
            RotateEvent rotateEvent = a;
            float[] arrf4 = arrf;
            rotateEvent.setYaw(arrf4.lastYaw);
            rotateEvent.setPitch(arrf4.lastPitch);
            return;
        }
        float[] arrf5 = arrf;
        arrf5.lastYaw = Hana.ROTATE.lastYaw;
        arrf5.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ void doPlace(class_2338 class_23382) {
        HanaCrystalBase hanaCrystalBase;
        HanaCrystalBase a;
        HanaCrystalBase hanaCrystalBase2;
        HanaCrystalBase a2 = class_23382;
        HanaCrystalBase hanaCrystalBase3 = a = this;
        if (!hanaCrystalBase3.placeTimer.passedMs((long)hanaCrystalBase3.placeDelay.getValue())) {
            return;
        }
        if (a.detectMining.getValue() && Hana.BREAK.isMining((class_2338)a2)) {
            return;
        }
        int n = a.getBlock();
        if (n == -1) {
            return;
        }
        class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)a2);
        if (class_23502 == null) {
            return;
        }
        class_243 class_2432 = new class_243((double)a2.method_10263() + 0.5 + (double)class_23502.method_10163().method_10263() * 0.5, (double)a2.method_10264() + 0.5 + (double)class_23502.method_10163().method_10264() * 0.5, (double)a2.method_10260() + 0.5 + (double)class_23502.method_10163().method_10260() * 0.5);
        if (!BlockUtil.canPlace((class_2338)a2, a.placeRange.getValue())) {
            return;
        }
        if (a.rotate.getValue() && !a.faceVector(class_2432)) {
            return;
        }
        int n2 = HanaCrystalBase.mc.field_1724.method_31548().field_7545;
        a.doSwap(n);
        if (BlockUtil.airPlace()) {
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock((class_2338)a2, class_2350.field_11033, false, class_1268.field_5808);
            hanaCrystalBase = a;
        } else {
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), false, class_1268.field_5808);
            hanaCrystalBase = a;
        }
        HanaCrystalBase hanaCrystalBase4 = a;
        if (hanaCrystalBase.inventory.getValue()) {
            hanaCrystalBase4.doSwap(n);
            EntityUtil.syncInventory();
            hanaCrystalBase2 = a;
        } else {
            hanaCrystalBase4.doSwap(n2);
            hanaCrystalBase2 = a;
        }
        if (hanaCrystalBase2.rotate.getValue() && !a.yawStep.getValue() && CombatSetting.INSTANCE.rotateSync.getValue()) {
            Hana.ROTATE.snapBack();
        }
        a.placeTimer.reset();
    }

    @Override
    public void onThread() {
        HanaCrystalBase a;
        if (a.useThread.getValue()) {
            a.updateCrystalPos();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean noEntityBlockCrystal(class_2338 var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        a = BlockUtil.getEntities(new class_238((class_2338)a)).iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = a;
            while (v0.hasNext() != false) {
                a = a.next();
                if (!a.method_5805() || a != false && a instanceof class_1542) ** GOTO lbl-1000
                if (a instanceof class_1531 && CombatSetting.INSTANCE.obsMode.getValue()) {
                    v0 = a;
                    continue;
                }
                if (a instanceof class_1511 == false) return false;
                if (a == false) {
                    return false;
                }
                if (HanaCrystalBase.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(HanaCrystalBase.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return false;
                v0 = a;
            }
            return true;
            break;
        } while (true);
    }

    public HanaCrystalBase() {
        HanaCrystalBase a;
        HanaCrystalBase hanaCrystalBase = a;
        super(GameInfo.ALLATORIxDEMO("^h}GcpLS}hLwke"), Module.Category.Combat);
        HanaCrystalBase hanaCrystalBase2 = a;
        hanaCrystalBase.placeTimer = new Timer();
        hanaCrystalBase2.delayTimer = new Timer();
        hanaCrystalBase.page = hanaCrystalBase.add(new EnumSetting<Page>(Vec3.ALLATORIxDEMO("^\u0005\u0017"), Page.General));
        hanaCrystalBase.inventory = hanaCrystalBase.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("XrrtgKHn}]ayp"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("X\u0013e\u001e\\!Q\u001f`\rv\u0015"), false, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("pIp}Fytd"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("3p\u000fV;{&o\u0011k\u0017"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Pp{XBhVoxe"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u001f")));
        a.updateDelay = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Qam^Sy@kzyy"), 50, 0, 1000, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Vec3.ALLATORIxDEMO("u\u0001")));
        a.wallRange = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("^^KpVoxe"), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u001f")));
        a.rotate = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Nkzwle"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.yawStep = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("\f}\u0001]\u0010}\u0002"), false, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Wzshs"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("N\u0017`\u0000w\u001f"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Lem}}t"), false, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("8W0\u001dB\u000bw\u0019"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Pwv"), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.auto = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("O\u0011l\u001d"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.autoMinDamage = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("O[qn"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact && a2.auto.getValue();
        }).setSuffix(Vec3.ALLATORIxDEMO("\u0000u\u0015")));
        a.minDamage = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("[qn"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u0000u\u0015")));
        a.maxSelf = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("]stf"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u0000u\u0015")));
        a.range = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Voxe"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u001f")));
        a.placeRange = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Ae^DyVoxe"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u001f")));
        a.noSuicide = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("GPtimm|e"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u0000u\u0015")));
        a.smart = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Wcwjt"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.placeDelay = a.add(new SliderSetting(Vec3.ALLATORIxDEMO("A\u0017^6y2k\by\u000b"), 300, 0, 1000, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(GameInfo.ALLATORIxDEMO("us")));
        a.useThread = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO(".L0H\u001e|\u0001y\u0016"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.doCrystal = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Gpe\\csTbw{e"), false, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.lite = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("B\rl\u0017"), false, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.predictTicks = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("wnaj{t"), 4, 0, 10, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(Vec3.ALLATORIxDEMO("\u0002g\u0007s\u0001")));
        a.terrainIgnore = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("EyvchVIUc`yje"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.forcePlace = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("W\u0014M6y&b\u0005{\u0017"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.forceMaxHealth = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("EPPyvZ~yn"), 7, 0, 36, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(Vec3.ALLATORIxDEMO("t\u0013o\bl\u001a")));
        a.forceMin = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("yHngk[qn"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(Vec3.ALLATORIxDEMO("\u0000u\u0015")));
        a.armorBreaker = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("]v|fMenao}}r"), true, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.maxDurable = a.add(new SliderSetting(Vec3.ALLATORIxDEMO("\\\u001aG\u0011i\u0004o\u0006t\u0017"), 8, 0, 100, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO("%")));
        a.armorBreakerDamage = a.add(new SliderSetting(Vec3.ALLATORIxDEMO("S\tZ4w\u0013|)q\u001c"), 3.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO("rug")));
        a.hurtTime = a.add(new SliderSetting(Vec3.ALLATORIxDEMO("w n\u0002Z\ru\u0017"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            HanaCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        HanaCrystalBase hanaCrystalBase3 = a;
        HanaCrystalBase hanaCrystalBase4 = a;
        hanaCrystalBase4.lastYaw = 0.0f;
        hanaCrystalBase4.lastPitch = 0.0f;
        hanaCrystalBase4.noPosTimer = new Timer();
        hanaCrystalBase3.directionVec = null;
        hanaCrystalBase3.setChinese(GameInfo.ALLATORIxDEMO("\u8296\u82ad\u6c30\u6678\u9ec7\u66c4\u77f3"));
        INSTANCE = hanaCrystalBase3;
    }

    private /* synthetic */ int getBlock() {
        HanaCrystalBase a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        HanaCrystalBase a3 = class_23382;
        HanaCrystalBase a4 = this;
        return a4.calculateDamage(a3.method_10074(), new class_243((double)a3.method_10263() + 0.5, (double)a3.method_10264(), (double)a3.method_10260() + 0.5), (class_1657)a, (class_1657)a2);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        HanaCrystalBase a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, HanaCrystalBase.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ void doInteract() {
        a.directionVec = null;
        if (crystalPos != null) {
            HanaCrystalBase a;
            a.doPlace(crystalPos);
        }
    }

    private /* synthetic */ boolean behindWall(class_2338 a) {
        HanaCrystalBase a2;
        HanaCrystalBase hanaCrystalBase = a2;
        a2 = new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        a2 = HanaCrystalBase.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), (class_243)a2, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)HanaCrystalBase.mc.field_1724));
        if (a2 == null || a2.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return HanaCrystalBase.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > hanaCrystalBase.wallRange.getValue();
    }

    @Override
    public String getInfo() {
        HanaCrystalBase a;
        if (a.displayTarget != null && a.lastDamage > 0.0f) {
            return a.displayTarget.method_5477().getString() + ", " + new DecimalFormat(Vec3.ALLATORIxDEMO("T6B")).format(a.lastDamage);
        }
        return null;
    }

    @Override
    public void onDisable() {
        crystalPos = null;
        a.tempPos = null;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean liteCheck(class_243 class_2432, class_243 class_2433) {
        void a;
        HanaCrystalBase a2 = class_2433;
        HanaCrystalBase a3 = this;
        return !HanaCrystalBase.canSee((class_243)a, (class_243)a2) && !HanaCrystalBase.canSee((class_243)a, a2.method_1031(0.0, 1.8, 0.0));
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        HanaCrystalBase a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        class_2338 a2;
        void a3;
        HanaCrystalBase hanaCrystalBase = this;
        a2 = a2.method_10074();
        HanaCrystalBase a4 = a2.method_10084();
        class_2338 class_23383 = a4.method_10084();
        return !(HanaCrystalBase.getBlock(a2) != class_2246.field_9987 && HanaCrystalBase.getBlock(a2) != class_2246.field_10540 && !BlockUtil.canPlace(a2, hanaCrystalBase.placeRange.getValue()) || BlockUtil.getClickSideStrict(a2) == null || !hanaCrystalBase.noEntityBlockCrystal((class_2338)a4, (boolean)a, (boolean)a3) || !hanaCrystalBase.noEntityBlockCrystal(class_23383, (boolean)a, (boolean)a3) || !HanaCrystalBase.mc.field_1687.method_22347((class_2338)a4) && (!BlockUtil.hasCrystal((class_2338)a4) || HanaCrystalBase.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && !HanaCrystalBase.mc.field_1687.method_22347(class_23383));
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_243 class_2432, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        void a222;
        HanaCrystalBase a3 = class_2432;
        HanaCrystalBase a4 = this;
        CombatUtil.modifyPos = a222;
        CombatUtil.modifyBlockState = class_2246.field_10540.method_9564();
        if (a4.terrainIgnore.getValue()) {
            CombatUtil.terrainIgnore = true;
        }
        float a222 = ExplosionUtil.calculateDamage(a3.method_10216(), a3.method_10214(), a3.method_10215(), (class_1297)a2, (class_1297)a, 6.0f);
        CombatUtil.modifyPos = null;
        CombatUtil.terrainIgnore = false;
        return a222;
    }

    private /* synthetic */ void updateCrystalPos() {
        HanaCrystalBase a;
        HanaCrystalBase hanaCrystalBase = a;
        hanaCrystalBase.update();
        hanaCrystalBase.lastDamage = hanaCrystalBase.tempDamage;
        crystalPos = hanaCrystalBase.tempPos;
    }

    public static boolean canSee(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return (a = HanaCrystalBase.mc.field_1687.method_17742(new class_3959(a2, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)HanaCrystalBase.mc.field_1724))) == null || a.method_17783() == class_239.class_240.field_1333;
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        HanaCrystalBase a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
    }

    @Override
    public void onEnable() {
        HanaCrystalBase a;
        INSTANCE = a;
    }

    public boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.yawStep.getValue()) {
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

    private static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page General = new Page(FrameConverter.ALLATORIxDEMO("Q\u0017\n~D*"), 0);
        public static final /* enum */ Page Rotate;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Interact;
        public static final /* enum */ Page Misc;

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[5];
            arrpage[0] = General;
            arrpage[1] = Interact;
            arrpage[2] = Misc;
            arrpage[3] = Rotate;
            arrpage[4] = Calc;
            return arrpage;
        }

        static {
            Interact = new Page(BetterDynamicAnimation.ALLATORIxDEMO("^MRwRuAb"), 1);
            Misc = new Page(FrameConverter.ALLATORIxDEMO("\"eV%"), 2);
            Rotate = new Page(BetterDynamicAnimation.ALLATORIxDEMO("t}TuVs"), 3);
            Calc = new Page(FrameConverter.ALLATORIxDEMO(",mI%"), 4);
            $VALUES = Page.$values();
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

    private class PlayerAndPredict {
        final /* synthetic */ HanaCrystalBase this$0;
        final class_1657 player;
        final class_1657 predict;

        private /* synthetic */ PlayerAndPredict(HanaCrystalBase object, class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.this$0 = object;
            a2.player = a;
            if (((HanaCrystalBase)object).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Timer.ALLATORIxDEMO("\u0003\u000e\u0013\u001d\"*\b\u0005\u0019\b2>\u0016\u0002\u0000\f\u0007\u000b\u0014\u0002\u0005\b\u0012\u0004ZW\u000e\u0001\b\u0000\u0001\u0002\u0012\u001f^S")), FileUtil.ALLATORIxDEMO("A\f@.n\u000bd:\nu\u0007oJ2W")), (HanaCrystalBase)object, (class_1657)a){
                    final /* synthetic */ HanaCrystalBase val$this$0;
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ class_1657 val$player;

                    public boolean method_24828() {
                        1 a;
                        return a.val$player.method_24828();
                    }
                    {
                        void a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        1 a6;
                        1 v0 = this_;
                        1 this_ = class_16572;
                        class_1657 class_16573 = class_16572 = v0;
                        class_16573.this$1 = a2;
                        class_16573.val$this$0 = hanaCrystalBase;
                        class_16572.val$player = a6;
                        class_16572((class_1937)a4, (class_2338)a5, (float)a3, (GameProfile)a);
                    }

                    public boolean method_7325() {
                        return false;
                    }

                    public boolean method_7337() {
                        return false;
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, ((HanaCrystalBase)object).predictTicks.getValueInt(), true)));
                playerAndPredict.predict.method_6033(a.method_6032());
                playerAndPredict.predict.field_6014 = ((class_1657)a).field_6014;
                playerAndPredict.predict.field_5969 = ((class_1657)a).field_5969;
                playerAndPredict.predict.field_6036 = ((class_1657)a).field_6036;
                playerAndPredict.predict.method_24830(a.method_24828());
                playerAndPredict.predict.method_31548().method_7377(a.method_31548());
                playerAndPredict.predict.method_18380(a.method_18376());
                Object object2 = object = new ArrayList(a.method_6026()).iterator();
                while (object2.hasNext()) {
                    class_1293 class_12932 = (class_1293)object.next();
                    object2 = object;
                    a2.predict.method_6092(class_12932);
                }
            } else {
                a2.predict = a;
            }
        }

    }

}
