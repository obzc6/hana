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
package dev.recollect.hana.mod.modules.impl.combat.dev;

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
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.video.Renderer;
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
import org.bytedeco.javacv.BaseChildSettings;

public class AlienCrystalBase
extends Module {
    private final BooleanSetting forcePlace;
    private float lastYaw;
    public static AlienCrystalBase INSTANCE;
    private final SliderSetting placeRange;
    private final BooleanSetting terrainIgnore;
    public static class_2338 crystalPos;
    private final BooleanSetting doCrystal;
    private final BooleanSetting useThread;
    private final SliderSetting wallRange;
    public class_243 directionVec;
    private final BooleanSetting breakOnlyHasCrystal;
    private final SliderSetting forceMaxHealth;
    private final BooleanSetting random;
    public float lastDamage;
    private final SliderSetting armorBreakerDamage;
    private final SliderSetting updateDelay;
    private final SliderSetting predictTicks;
    private final BooleanSetting auto;
    public float tempDamage;
    private final SliderSetting placeDelay;
    private final SliderSetting hurtTime;
    private final BooleanSetting rotate;
    public static Thread thread;
    private final SliderSetting maxSelf;
    private final SliderSetting targetRange;
    final Timer noPosTimer;
    private final SliderSetting steps;
    public class_1657 displayTarget;
    private final Timer delayTimer;
    private final BooleanSetting smart;
    private final BooleanSetting eatingPause;
    private final BooleanSetting armorBreaker;
    private final SliderSetting fov;
    private final SliderSetting minDamage;
    private final SliderSetting autoMinDamage;
    private float lastPitch;
    private final BooleanSetting detectMining;
    private final BooleanSetting lite;
    private final BooleanSetting inventory;
    private final BooleanSetting checkLook;
    private final EnumSetting<Page> page;
    private final SliderSetting range;
    private final SliderSetting noSuicide;
    private final BooleanSetting packet;
    private class_2338 tempPos;
    private final SliderSetting forceMin;
    private final Timer placeTimer;
    private final SliderSetting maxDurable;
    public float breakDamage;
    private final BooleanSetting yawStep;

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AlienCrystalBase a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AlienCrystalBase.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ void updateCrystalPos() {
        AlienCrystalBase a;
        AlienCrystalBase alienCrystalBase = a;
        alienCrystalBase.update();
        alienCrystalBase.lastDamage = alienCrystalBase.tempDamage;
        crystalPos = alienCrystalBase.tempPos;
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AlienCrystalBase a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
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

    @Override
    public String getInfo() {
        AlienCrystalBase a;
        if (a.displayTarget != null && a.lastDamage > 0.0f) {
            return a.displayTarget.method_5477().getString() + ", " + new DecimalFormat(OLEPOSSUtils.ALLATORIxDEMO("\u0015}\u001c")).format(a.lastDamage);
        }
        return null;
    }

    private /* synthetic */ int getBlock() {
        AlienCrystalBase a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    private /* synthetic */ void doPlace(class_2338 class_23382) {
        AlienCrystalBase alienCrystalBase;
        AlienCrystalBase alienCrystalBase2;
        AlienCrystalBase a;
        AlienCrystalBase a2 = class_23382;
        AlienCrystalBase alienCrystalBase3 = a = this;
        if (!alienCrystalBase3.placeTimer.passedMs((long)alienCrystalBase3.placeDelay.getValue())) {
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
        int n2 = AlienCrystalBase.mc.field_1724.method_31548().field_7545;
        a.doSwap(n);
        if (BlockUtil.airPlace()) {
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock((class_2338)a2, class_2350.field_11033, false, class_1268.field_5808);
            alienCrystalBase = a;
        } else {
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), false, class_1268.field_5808);
            alienCrystalBase = a;
        }
        AlienCrystalBase alienCrystalBase4 = a;
        if (alienCrystalBase.inventory.getValue()) {
            alienCrystalBase4.doSwap(n);
            EntityUtil.syncInventory();
            alienCrystalBase2 = a;
        } else {
            alienCrystalBase4.doSwap(n2);
            alienCrystalBase2 = a;
        }
        if (alienCrystalBase2.rotate.getValue() && !a.yawStep.getValue() && CombatSetting.INSTANCE.rotateSync.getValue()) {
            Hana.ROTATE.snapBack();
        }
        a.placeTimer.reset();
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        AlienCrystalBase a3 = this;
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

    public static class_2248 getBlock(class_2338 a) {
        return AlienCrystalBase.mc.field_1687.method_8320(a).method_26204();
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        AlienCrystalBase a3 = class_23382;
        AlienCrystalBase a4 = this;
        return a4.calculateDamage(a3.method_10074(), new class_243((double)a3.method_10263() + 0.5, (double)a3.method_10264(), (double)a3.method_10260() + 0.5), (class_1657)a, (class_1657)a2);
    }

    @Override
    public void onDisable() {
        crystalPos = null;
        a.tempPos = null;
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_243 class_2432, class_1657 class_16572, class_1657 class_16573) {
        void a22;
        void a;
        void a3;
        AlienCrystalBase a4 = class_2432;
        AlienCrystalBase a5 = this;
        CombatUtil.modifyPos = a22;
        CombatUtil.modifyBlockState = class_2246.field_10540.method_9564();
        if (a5.terrainIgnore.getValue()) {
            CombatUtil.terrainIgnore = true;
        }
        float a22 = ExplosionUtil.calculateDamage(a4.method_10216(), a4.method_10214(), a4.method_10215(), (class_1297)a3, (class_1297)a, 6.0f);
        CombatUtil.modifyPos = null;
        CombatUtil.terrainIgnore = false;
        return a22;
    }

    private /* synthetic */ double getDamage(class_1657 class_16572) {
        Object a = class_16572;
        AlienCrystalBase a2 = this;
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

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean liteCheck(class_243 class_2432, class_243 class_2433) {
        void a;
        AlienCrystalBase a2 = class_2433;
        AlienCrystalBase a3 = this;
        return !AlienCrystalBase.canSee((class_243)a, (class_243)a2) && !AlienCrystalBase.canSee((class_243)a, a2.method_1031(0.0, 1.8, 0.0));
    }

    private /* synthetic */ void update() {
        AlienCrystalBase a;
        Object object;
        AlienCrystalBase alienCrystalBase = a;
        if (AlienCrystalBase.nullCheck()) {
            return;
        }
        AlienCrystalBase alienCrystalBase2 = alienCrystalBase;
        if (!alienCrystalBase2.delayTimer.passedMs((long)alienCrystalBase2.updateDelay.getValue())) {
            return;
        }
        if (alienCrystalBase.eatingPause.getValue() && AlienCrystalBase.mc.field_1724.method_6115()) {
            alienCrystalBase.tempPos = null;
            return;
        }
        if (Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) {
            alienCrystalBase.tempPos = null;
            return;
        }
        if (alienCrystalBase.breakOnlyHasCrystal.getValue() && !AlienCrystalBase.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !AlienCrystalBase.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !AlienCrystal.INSTANCE.findCrystal()) {
            alienCrystalBase.tempPos = null;
            return;
        }
        alienCrystalBase.delayTimer.reset();
        alienCrystalBase.breakDamage = 0.0f;
        alienCrystalBase.tempPos = null;
        alienCrystalBase.tempDamage = 0.0f;
        ArrayList<PlayerAndPredict> arrayList = new ArrayList<PlayerAndPredict>();
        Object object2 = CombatUtil.getEnemies(alienCrystalBase.targetRange.getValueFloat()).iterator();
        while (object2.hasNext()) {
            object = object2.next();
            if (((class_1657)object).field_6235 > alienCrystalBase.hurtTime.getValueInt()) continue;
            arrayList.add(new PlayerAndPredict(alienCrystalBase, (class_1657)object));
        }
        object2 = new PlayerAndPredict(alienCrystalBase, (class_1657)AlienCrystalBase.mc.field_1724);
        if (!arrayList.isEmpty()) {
            object = BlockUtil.getSphere((float)alienCrystalBase.range.getValue() + 1.0f).iterator();
            block1 : do {
                Object object3 = object;
                while (object3.hasNext()) {
                    a = (class_2338)object.next();
                    CombatUtil.modifyPos = null;
                    if (AlienCrystalBase.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > alienCrystalBase.range.getValue()) {
                        object3 = object;
                        continue;
                    }
                    if (!alienCrystalBase.canPlaceCrystal((class_2338)a, true, false)) {
                        object3 = object;
                        continue;
                    }
                    CombatUtil.modifyPos = a.method_10074();
                    CombatUtil.modifyBlockState = class_2246.field_10540.method_9564();
                    if (alienCrystalBase.behindWall((class_2338)a)) {
                        object3 = object;
                        continue;
                    }
                    if (!alienCrystalBase.canTouch(a.method_10074())) {
                        object3 = object;
                        continue;
                    }
                    Iterator iterator = arrayList.iterator();
                    block3 : do {
                        float f;
                        PlayerAndPredict playerAndPredict;
                        Iterator iterator2 = iterator;
                        do {
                            float f2;
                            if (!iterator2.hasNext()) continue block1;
                            playerAndPredict = (PlayerAndPredict)iterator.next();
                            if (a.method_10074().method_10264() > playerAndPredict.player.method_31478()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (alienCrystalBase.lite.getValue() && alienCrystalBase.liteCheck(a.method_46558().method_1031(0.0, -0.5, 0.0), playerAndPredict.predict.method_19538())) {
                                iterator2 = iterator;
                                continue;
                            }
                            AlienCrystalBase alienCrystalBase3 = alienCrystalBase;
                            PlayerAndPredict playerAndPredict2 = playerAndPredict;
                            f = alienCrystalBase3.calculateDamage((class_2338)a, playerAndPredict2.player, playerAndPredict2.predict);
                            if (alienCrystalBase3.tempPos != null && !(f > alienCrystalBase.tempDamage)) continue block3;
                            Object object4 = object2;
                            float f3 = alienCrystalBase.calculateDamage((class_2338)a, ((PlayerAndPredict)object4).player, ((PlayerAndPredict)object4).predict);
                            if ((double)f2 > alienCrystalBase.maxSelf.getValue()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (alienCrystalBase.noSuicide.getValue() > 0.0 && (double)f3 > (double)(AlienCrystalBase.mc.field_1724.method_6032() + AlienCrystalBase.mc.field_1724.method_6067()) - alienCrystalBase.noSuicide.getValue()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (!(f < EntityUtil.getHealth((class_1297)playerAndPredict.player))) break;
                            if ((double)f < alienCrystalBase.getDamage(playerAndPredict.player)) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (!alienCrystalBase.smart.getValue()) break;
                            if (alienCrystalBase.getDamage(playerAndPredict.player) == alienCrystalBase.forceMin.getValue()) {
                                if (!((double)f < (double)f3 - 2.5)) break;
                                iterator2 = iterator;
                                continue;
                            }
                            if (!(f < f3)) break;
                            iterator2 = iterator;
                        } while (true);
                        AlienCrystalBase alienCrystalBase4 = alienCrystalBase;
                        alienCrystalBase4.displayTarget = playerAndPredict.player;
                        alienCrystalBase4.tempPos = a.method_10074();
                        alienCrystalBase.tempDamage = f;
                    } while (true);
                }
                break;
            } while (true);
            CombatUtil.modifyPos = null;
            if (alienCrystalBase.tempPos != null) {
                AlienCrystalBase alienCrystalBase5 = alienCrystalBase;
                if (!BlockUtil.canPlace(alienCrystalBase5.tempPos, alienCrystalBase5.placeRange.getValue())) {
                    AlienCrystalBase alienCrystalBase6 = alienCrystalBase;
                    alienCrystalBase6.tempPos = null;
                    alienCrystalBase6.tempDamage = 0.0f;
                }
            }
        }
        if (alienCrystalBase.doCrystal.getValue() && alienCrystalBase.tempPos != null) {
            AlienCrystalBase alienCrystalBase7 = alienCrystalBase;
            alienCrystalBase7.doPlace(alienCrystalBase7.tempPos);
        }
    }

    private /* synthetic */ boolean behindWall(class_2338 a) {
        AlienCrystalBase a2;
        AlienCrystalBase alienCrystalBase = a2;
        a2 = new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        a2 = AlienCrystalBase.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), (class_243)a2, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AlienCrystalBase.mc.field_1724));
        if (a2 == null || a2.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return AlienCrystalBase.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > alienCrystalBase.wallRange.getValue();
    }

    private /* synthetic */ boolean canTouch(class_2338 a) {
        AlienCrystalBase a2;
        AlienCrystalBase alienCrystalBase = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(AlienCrystalBase.mc.field_1724.method_33571()) <= alienCrystalBase.range.getValue()) {
                return true;
            }
        }
        return false;
    }

    public AlienCrystalBase() {
        AlienCrystalBase a;
        AlienCrystalBase alienCrystalBase = a;
        super(Renderer.ALLATORIxDEMO("F\u0016x\t&vo\u0019i\u0013|\fB\u001c9R"), Module.Category.Combat);
        AlienCrystalBase alienCrystalBase2 = a;
        alienCrystalBase.placeTimer = new Timer();
        alienCrystalBase2.delayTimer = new Timer();
        alienCrystalBase.page = alienCrystalBase.add(new EnumSetting<Page>(OLEPOSSUtils.ALLATORIxDEMO("\u0018Ve\u0018"), Page.General));
        alienCrystalBase.inventory = alienCrystalBase.add(new BooleanSetting(Renderer.ALLATORIxDEMO("%&Cx\u000en\bo\u0019S\n+G"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("D\u001a!O1Y\u0018C&^l\u001a"), false, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("U\tq\u0019H\u0012&S"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO(":4^;C2z)Bq\u0018"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("a|\u0012}\u0002i2a\u0013-R"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("\u0010")));
        a.updateDelay = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("`m\u0004{\u0013x$e\u0011+N"), 50, 0, 1000, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("o\u000e")));
        a.wallRange = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("7{\u000bq2a\u0013-R"), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("\u0010")));
        a.rotate = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("O\u000ft\u001c>R"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.yawStep = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("t4]\u001bCg\r"), false, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("3t\u0018:D"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0007K&Sm\u0010"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("M\u0001c\u0016/C"), false, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("i:H6A\u0004Xm\u0016"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(Renderer.ALLATORIxDEMO(";%A"), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.auto = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\tBv\u0012"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.autoMinDamage = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("A0#Y"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact && a2.auto.getValue();
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("So\u001a")));
        a.minDamage = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("0#Y"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("So\u001a")));
        a.maxSelf = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("S\u0018&Q"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("So\u001a")));
        a.range = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("2a\u0013-R"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("\u0010")));
        a.placeRange = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("M\f{\u0004x2a\u0013-R"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("\u0010")));
        a.noSuicide = a.add(new SliderSetting(Renderer.ALLATORIxDEMO(".u4h\tc\u0014.R"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("So\u001a")));
        a.smart = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("3m\u001c8C"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.placeDelay = a.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0005F3N0n-[c\u0004"), 300, 0, 1000, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Renderer.ALLATORIxDEMO("'D")));
        a.useThread = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("!H\u0001B:Rc\u0019"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.doCrystal = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("v|\fy#r0l\u001c)R"), false, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.lite = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0004^v\u0018"), false, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.predictTicks = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("7o\u0005d\u0014)C"), 4, 0, 10, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("^!Ti\u000e")));
        a.terrainIgnore = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("8-Go\u0001s\tT\u0007n\u00128R"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.forcePlace = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0013E N0z$Va\u0018"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.forceMaxHealth = a.add(new SliderSetting(Renderer.ALLATORIxDEMO(",u\u0010x\u0012T\u0015+Y"), 7, 0, 36, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("=O)[v\u0015")));
        a.forceMin = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("\\\bo\u0003e0#Y"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(OLEPOSSUtils.ALLATORIxDEMO("So\u001a")));
        a.armorBreaker = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("\tGp\u000fh%o\u0005a\u0016/E"), true, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.maxDurable = a.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0018K*i X)Un\u0018"), 8, 0, 100, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(Renderer.ALLATORIxDEMO("\u0012")));
        a.armorBreakerDamage = a.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0017X7L>O:zk\u0013"), 3.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(Renderer.ALLATORIxDEMO("\u0019'P")));
        a.hurtTime = a.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u001aX'^\u001c^o\u0018"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            AlienCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        AlienCrystalBase alienCrystalBase3 = a;
        AlienCrystalBase alienCrystalBase4 = a;
        alienCrystalBase4.lastYaw = 0.0f;
        alienCrystalBase4.lastPitch = 0.0f;
        alienCrystalBase4.noPosTimer = new Timer();
        alienCrystalBase3.directionVec = null;
        alienCrystalBase3.setChinese(Renderer.ALLATORIxDEMO("\u590c\u6678\u4ea7\u6c54\u6676\u9eac\u6696\u77c4"));
        INSTANCE = alienCrystalBase3;
    }

    @Override
    public void onEnable() {
        AlienCrystalBase a;
        INSTANCE = a;
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        void a2;
        class_2338 a3;
        AlienCrystalBase alienCrystalBase = this;
        a3 = a3.method_10074();
        AlienCrystalBase a4 = a3.method_10084();
        class_2338 class_23383 = a4.method_10084();
        return !(AlienCrystalBase.getBlock(a3) != class_2246.field_9987 && AlienCrystalBase.getBlock(a3) != class_2246.field_10540 && !BlockUtil.canPlace(a3, alienCrystalBase.placeRange.getValue()) || BlockUtil.getClickSideStrict(a3) == null || !alienCrystalBase.noEntityBlockCrystal((class_2338)a4, (boolean)a, (boolean)a2) || !alienCrystalBase.noEntityBlockCrystal(class_23383, (boolean)a, (boolean)a2) || !AlienCrystalBase.mc.field_1687.method_22347((class_2338)a4) && (!BlockUtil.hasCrystal((class_2338)a4) || AlienCrystalBase.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && !AlienCrystalBase.mc.field_1687.method_22347(class_23383));
    }

    private /* synthetic */ void doInteract() {
        a.directionVec = null;
        if (crystalPos != null) {
            AlienCrystalBase a;
            a.doPlace(crystalPos);
        }
    }

    @Override
    public void onThread() {
        AlienCrystalBase a;
        if (a.useThread.getValue()) {
            a.updateCrystalPos();
        }
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        AlienCrystalBase a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
    }

    public static boolean canSee(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return (a = AlienCrystalBase.mc.field_1687.method_17742(new class_3959(a2, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AlienCrystalBase.mc.field_1724))) == null || a.method_17783() == class_239.class_240.field_1333;
    }

    @Override
    public void onLogin() {
        AlienCrystalBase a;
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
                if (AlienCrystalBase.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(AlienCrystalBase.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return false;
                v0 = a;
            }
            return true;
            break;
        } while (true);
    }

    @Override
    public void onUpdate() {
        AlienCrystalBase alienCrystalBase;
        block4 : {
            AlienCrystalBase alienCrystalBase2;
            block3 : {
                block2 : {
                    AlienCrystalBase a22;
                    alienCrystalBase2 = a22;
                    if (!alienCrystalBase2.useThread.getValue()) break block2;
                    if (thread != null && thread.isAlive()) break block3;
                    thread = new Thread(() -> {
                        AlienCrystalBase a;
                        while (INSTANCE.isOn() && a.useThread.getValue()) {
                            a.updateCrystalPos();
                        }
                        crystalPos = null;
                        a.tempPos = null;
                    });
                    try {
                        thread.start();
                        alienCrystalBase = alienCrystalBase2;
                    }
                    catch (Exception a22) {
                        alienCrystalBase = alienCrystalBase2;
                        a22.printStackTrace();
                    }
                    break block4;
                }
                alienCrystalBase2.updateCrystalPos();
            }
            alienCrystalBase = alienCrystalBase2;
        }
        alienCrystalBase.doInteract();
    }

    private static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Interact;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Misc;
        public static final /* enum */ Page Rotate;

        static {
            General = new Page(GameInfo.ALLATORIxDEMO("ryjpyl"), 0);
            Interact = new Page(BaseChildSettings.ALLATORIxDEMO("i:S6H/\u0013p"), 1);
            Misc = new Page(GameInfo.ALLATORIxDEMO("Wkkc"), 2);
            Rotate = new Page(BaseChildSettings.ALLATORIxDEMO("u<N/\u0004a"), 3);
            Calc = new Page(GameInfo.ALLATORIxDEMO("Yctc"), 4);
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

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[5];
            arrpage[0] = General;
            arrpage[1] = Interact;
            arrpage[2] = Misc;
            arrpage[3] = Rotate;
            arrpage[4] = Calc;
            return arrpage;
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

    private class PlayerAndPredict {
        final /* synthetic */ AlienCrystalBase this$0;
        final class_1657 player;
        final class_1657 predict;

        private /* synthetic */ PlayerAndPredict(AlienCrystalBase object, class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.this$0 = object;
            a2.player = a;
            if (((AlienCrystalBase)object).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Snow.ALLATORIxDEMO("2ft#\u0002S;o-e*0}&s\u0013F\"m3g\u0007H%q3e3b0j4`%q")), Start.ALLATORIxDEMO("vzT{\u00104XGEqEvH,Hl")), (AlienCrystalBase)object, (class_1657)a){
                    final /* synthetic */ AlienCrystalBase val$this$0;
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ class_1657 val$player;
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
                        class_16573.val$this$0 = alienCrystalBase;
                        class_16572.val$player = a6;
                        class_16572((class_1937)a, (class_2338)a5, (float)a4, (GameProfile)a3);
                    }

                    public boolean method_24828() {
                        1 a;
                        return a.val$player.method_24828();
                    }

                    public boolean method_7337() {
                        return false;
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, ((AlienCrystalBase)object).predictTicks.getValueInt(), true)));
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
