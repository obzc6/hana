/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
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
 *  net.minecraft.class_2596
 *  net.minecraft.class_2824
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.CircleUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.combat.BedAura;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.combat.WebAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.AntiBurrow;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoWebPuls;
import dev.recollect.hana.mod.modules.impl.combat.dev.SuperWeb;
import dev.recollect.hana.mod.modules.impl.combat.dev.Testweb;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.FileUtil;
import dev.recollect.hana.xibao.Snow;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import net.minecraft.class_2596;
import net.minecraft.class_2824;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class HanaAura
extends Module {
    private final SliderSetting armorBreakerDamage;
    private float lastPitch;
    private final BooleanSetting checkFov;
    private final EnumSetting<Page> page;
    private final SliderSetting lineWidth;
    private final BooleanSetting webSync;
    private final SliderSetting autoMinDamage;
    private final BooleanSetting preferAnchor;
    private final Timer resetTimer;
    private final Timer switchTimer;
    private final SliderSetting WebMinDamage;
    private final BooleanSetting armorBreaker;
    final BooleanSetting circle;
    private final SliderSetting hurtTime;
    private final SliderSetting circleSize;
    public static HanaAura INSTANCE;
    static class_243 placeVec3d;
    private final SliderSetting slowMinDamage;
    private final BooleanSetting antiSurround;
    private final SliderSetting steps;
    private final SliderSetting switchCooldown;
    final FadeUtils fadeOut;
    private final BooleanSetting forcePlace;
    private final BooleanSetting rotate;
    public static class_2338 crystalPos;
    private final EnumSetting<SwingSide> swingMode;
    private final SliderSetting updateDelay;
    public static Thread thread;
    private final SliderSetting maxSelf;
    private final SliderSetting range;
    private final BooleanSetting lite;
    int p;
    private final BooleanSetting terrainIgnore;
    double fade;
    final SliderSetting startFadeTime;
    static class_243 curVec3d;
    private final SliderSetting predictTicks;
    private final SliderSetting placeDelay;
    private final SliderSetting breakDelay;
    private final SliderSetting noSuicide;
    public static class_2338 tempPos;
    private final BooleanSetting checkLook;
    final BooleanSetting render;
    private final SliderSetting slowDelay;
    public static final Timer placeTimer;
    private final BooleanSetting eatingPause;
    private final ColorSetting circleColor;
    public final Timer lastBreakTimer;
    private final BooleanSetting WebSyncMain;
    final ColorSetting text;
    private final BooleanSetting xuanzhuan;
    public final EnumSetting<CircleMode> drawMode;
    private final FadeUtils rotationFade;
    final BooleanSetting shrink;
    private final BooleanSetting slowPlace;
    public float tempDamage;
    final Timer noPosTimer;
    private final SliderSetting minDamage;
    final SliderSetting sliderSpeed;
    private final ColorSetting color;
    final ColorSetting synctext;
    private final BooleanSetting doCrystal;
    private final BooleanSetting bold;
    private final SliderSetting targetRange;
    final RadiusUtils radiusUtils;
    private final BooleanSetting afterBreak;
    private final SliderSetting forceMaxHealth;
    private final BooleanSetting onBreak;
    private float lastYaw;
    final ColorSetting fill;
    public class_1657 displayTarget;
    final ColorSetting box;
    private final BooleanSetting packet;
    private final EnumSetting<AnchorAura.CalcMode> calcMode;
    private final BooleanSetting breakOnlyHasCrystal;
    private final EnumSetting<Aura.TargetESP> mode;
    private final BooleanSetting breakRemove;
    private final SliderSetting forceMin;
    private final SliderSetting fov;
    public float lastDamage;
    final FadeUtils fadeIn;
    private final BooleanSetting yawStep;
    final SliderSetting fadeSpeed;
    public class_243 directionVec;
    private double currentRotation;
    private final BooleanSetting useThread;
    private final Timer delayTimer;
    private final BooleanSetting place;
    private final BooleanSetting spam;
    private final BooleanSetting smart;
    private final BooleanSetting random;
    private final SliderSetting synchealth;
    private final EnumSetting<SwapMode> autoSwap;
    private final SliderSetting minAge;
    private int lastHotbar;
    private final SliderSetting maxDurable;
    private final SliderSetting antiSurroundMax;
    private final BooleanSetting Break;
    private final SliderSetting resetDelay;
    private final SliderSetting wallRange;
    private final SliderSetting places;

    public static boolean canSee(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return (a = HanaAura.mc.field_1687.method_17742(new class_3959(a2, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)HanaAura.mc.field_1724))) == null || a.method_17783() == class_239.class_240.field_1333;
    }

    private /* synthetic */ int getCrystal() {
        HanaAura a;
        if (a.autoSwap.getValue() == SwapMode.Silent || a.autoSwap.getValue() == SwapMode.Normal) {
            return InventoryUtil.findItem(class_1802.field_8301);
        }
        if (a.autoSwap.getValue() == SwapMode.Inventory) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return -1;
    }

    private /* synthetic */ void doBreak(class_2338 class_23382) {
        HanaAura a;
        Iterator iterator;
        HanaAura a2 = class_23382;
        HanaAura hanaAura = a = this;
        hanaAura.lastBreakTimer.reset();
        if (!hanaAura.Break.getValue()) {
            return;
        }
        if (!CombatUtil.breakTimer.passedMs((long)a.breakDelay.getValue())) {
            return;
        }
        Iterator iterator2 = iterator = HanaAura.mc.field_1687.method_18467(class_1511.class, new class_238((double)a2.method_10263(), (double)a2.method_10264(), (double)a2.method_10260(), (double)(a2.method_10263() + 1), (double)(a2.method_10264() + 2), (double)(a2.method_10260() + 1))).iterator();
        while (iterator2.hasNext()) {
            class_1511 class_15112 = (class_1511)iterator.next();
            if (class_15112.field_6012 < a.minAge.getValueInt()) {
                iterator2 = iterator;
                continue;
            }
            if (a.rotate.getValue() && a.onBreak.getValue() && !a.faceVector(class_15112.method_19538().method_1031(0.0, 0.25, 0.0))) {
                return;
            }
            CombatUtil.breakTimer.reset();
            HanaAura.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34206((class_1297)class_15112, (boolean)HanaAura.mc.field_1724.method_5715()));
            EntityUtil.swingHand(class_1268.field_5808, a.swingMode.getValue());
            if (a.breakRemove.getValue()) {
                HanaAura.mc.field_1687.method_2945(class_15112.method_5628(), class_1297.class_5529.field_26998);
            }
            HanaAura hanaAura2 = a;
            if (hanaAura2.tempDamage >= hanaAura2.minDamage.getValueFloat() && a.spam.getValue()) {
                a.doPlace((class_2338)a2);
            }
            HanaAura hanaAura3 = a;
            if (!hanaAura3.switchTimer.passedMs((long)hanaAura3.switchCooldown.getValue())) {
                return;
            }
            if (a.WebSyncMain.getValue()) {
                HanaAura hanaAura4 = a;
                if (hanaAura4.lastDamage > hanaAura4.WebMinDamage.getValueFloat()) {
                    WebAura.place = true;
                    AutoWebPuls.place = true;
                    Testweb.place = true;
                    AntiBurrow.place = true;
                    SuperWeb.force = true;
                }
            }
            if (crystalPos == null || a.displayTarget == null) break;
            HanaAura hanaAura5 = a;
            if (!((double)a.lastDamage >= hanaAura5.getDamage(hanaAura5.displayTarget)) || !a.afterBreak.getValue() || a.yawStep.getValue() && a.checkFov.getValue() && !Hana.ROTATE.inFov(class_15112.method_19538(), a.fov.getValueFloat())) break;
            a.doPlace(crystalPos);
            return;
        }
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

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        HanaAura a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
        if (crystalPos != null) {
            a2.doCrystal(crystalPos);
        }
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        HanaAura a3 = class_23382;
        HanaAura a4 = this;
        return a4.calculateDamage(new class_243((double)a3.method_10263() + 0.5, (double)a3.method_10264(), (double)a3.method_10260() + 0.5), (class_1657)a2, (class_1657)a);
    }

    @Override
    public void onDisable() {
        crystalPos = null;
        tempPos = null;
    }

    private /* synthetic */ double getDamage(class_1657 class_16572) {
        Object a = class_16572;
        HanaAura a2 = this;
        if (!SpeedMine.INSTANCE.obsidian.isPressed() && a2.slowPlace.getValue()) {
            HanaAura hanaAura = a2;
            if (hanaAura.lastBreakTimer.passedMs((long)hanaAura.slowDelay.getValue()) && (!BedAura.INSTANCE.isOn() || BedAura.INSTANCE.getBed() == -1)) {
                return a2.slowMinDamage.getValue();
            }
        }
        if (a2.forcePlace.getValue() && (double)EntityUtil.getHealth((class_1297)a) <= a2.forceMaxHealth.getValue() && !SpeedMine.INSTANCE.obsidian.isPressed()) {
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

    public boolean findCrystal() {
        HanaAura a;
        if (a.autoSwap.getValue() == SwapMode.Off) {
            return false;
        }
        return a.getCrystal() != -1;
    }

    private /* synthetic */ void update() {
        Iterator a;
        HanaAura hanaAura;
        HanaAura hanaAura2 = a;
        if (HanaAura.nullCheck()) {
            return;
        }
        if (hanaAura2.webSync.getValue()) {
            HanaAura hanaAura3 = hanaAura2;
            if (hanaAura3.resetTimer.passedMs(hanaAura3.resetDelay.getValue())) {
                hanaAura2.p = 0;
                hanaAura2.resetTimer.reset();
            }
        }
        HanaAura hanaAura4 = hanaAura2;
        if (!hanaAura4.delayTimer.passedMs((long)hanaAura4.updateDelay.getValue())) {
            return;
        }
        if (hanaAura2.eatingPause.getValue() && EntityUtil.isUsing()) {
            hanaAura2.lastBreakTimer.reset();
            tempPos = null;
            return;
        }
        if (hanaAura2.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            hanaAura2.lastBreakTimer.reset();
            tempPos = null;
            return;
        }
        if (hanaAura2.breakOnlyHasCrystal.getValue() && !HanaAura.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !HanaAura.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !hanaAura2.findCrystal()) {
            hanaAura2.lastBreakTimer.reset();
            tempPos = null;
            return;
        }
        HanaAura hanaAura5 = hanaAura2;
        if (!hanaAura5.switchTimer.passedMs((long)hanaAura5.switchCooldown.getValue())) {
            return;
        }
        hanaAura2.delayTimer.reset();
        tempPos = null;
        hanaAura2.tempDamage = 0.0f;
        class_2338 class_23382 = new ArrayList();
        Object object = CombatUtil.getEnemies(hanaAura2.targetRange.getValue()).iterator();
        while (object.hasNext()) {
            a = object.next();
            if (((class_1657)a).field_6235 > hanaAura2.hurtTime.getValueInt()) continue;
            class_23382.add(new PlayerAndPredict(hanaAura2, (class_1657)a));
        }
        object = new PlayerAndPredict(hanaAura2, (class_1657)HanaAura.mc.field_1724);
        HanaAura hanaAura6 = hanaAura2;
        if (class_23382.isEmpty()) {
            hanaAura6.lastBreakTimer.reset();
            hanaAura = hanaAura2;
        } else {
            int n;
            Object object2;
            Object object3;
            Object object4;
            a = BlockUtil.getSphere((float)hanaAura6.range.getValue() + 1.0f).iterator();
            block1 : do {
                Iterator iterator = a;
                while (iterator.hasNext()) {
                    Object object5 = (class_2338)a.next();
                    if (hanaAura2.behindWall((class_2338)object5)) {
                        iterator = a;
                        continue;
                    }
                    if (HanaAura.mc.field_1724.method_33571().method_1022(object5.method_46558().method_1031(0.0, -0.5, 0.0)) > hanaAura2.range.getValue()) {
                        iterator = a;
                        continue;
                    }
                    if (!hanaAura2.canTouch(object5.method_10074())) {
                        iterator = a;
                        continue;
                    }
                    if (!hanaAura2.canPlaceCrystal((class_2338)object5, true, false)) {
                        iterator = a;
                        continue;
                    }
                    object3 = class_23382.iterator();
                    block3 : do {
                        Object object6 = object3;
                        do {
                            if (!object6.hasNext()) continue block1;
                            object4 = (PlayerAndPredict)object3.next();
                            if (hanaAura2.lite.getValue() && HanaAura.liteCheck(object5.method_46558().method_1031(0.0, -0.5, 0.0), object4.predict.method_19538())) {
                                object6 = object3;
                                continue;
                            }
                            Object object7 = object4;
                            n = (int)hanaAura2.calculateDamage((class_2338)object5, object7.player, object7.predict);
                            if (tempPos != null && !(n > hanaAura2.tempDamage)) continue block3;
                            Object object8 = object;
                            float f = hanaAura2.calculateDamage((class_2338)object5, ((PlayerAndPredict)object8).player, ((PlayerAndPredict)object8).predict);
                            object2 = f;
                            if ((double)f > hanaAura2.maxSelf.getValue()) {
                                object6 = object3;
                                continue;
                            }
                            if (hanaAura2.noSuicide.getValue() > 0.0 && (double)object2 > (double)(HanaAura.mc.field_1724.method_6032() + HanaAura.mc.field_1724.method_6067()) - hanaAura2.noSuicide.getValue()) {
                                object6 = object3;
                                continue;
                            }
                            if (!(n < EntityUtil.getHealth((class_1297)object4.player))) break;
                            if ((double)n < hanaAura2.getDamage(object4.player)) {
                                object6 = object3;
                                continue;
                            }
                            if (!hanaAura2.smart.getValue()) break;
                            if (hanaAura2.getDamage(object4.player) == hanaAura2.forceMin.getValue()) {
                                if (!((double)n < (double)object2 - 2.5)) break;
                                object6 = object3;
                                continue;
                            }
                            if (!(n < object2)) break;
                            object6 = object3;
                        } while (true);
                        hanaAura2.displayTarget = object4.player;
                        tempPos = object5;
                        hanaAura2.tempDamage = n;
                    } while (true);
                }
                break;
            } while (true);
            if (hanaAura2.antiSurround.getValue() && SpeedMine.breakPos != null && SpeedMine.progress >= 0.9 && !BlockUtil.hasEntity(SpeedMine.breakPos, false)) {
                HanaAura hanaAura7 = hanaAura2;
                if (hanaAura7.tempDamage <= hanaAura7.antiSurroundMax.getValueFloat()) {
                    for (Object object5 : class_23382) {
                        object3 = class_2350.values();
                        object4 = ((class_2350[])object3).length;
                        int n2 = n = 0;
                        while (n2 < object4) {
                            object2 = object3[n];
                            if (object2 != class_2350.field_11033 && object2 != class_2350.field_11036 && (class_23382 = new BlockPosX(object5.player.method_19538().method_1031(0.0, 0.5, 0.0)).method_10093((class_2350)object2)).equals((Object)SpeedMine.breakPos)) {
                                int n3;
                                if (hanaAura2.canPlaceCrystal(class_23382.method_10093((class_2350)object2), false, false)) {
                                    float f;
                                    Object object9 = object;
                                    float f2 = hanaAura2.calculateDamage(class_23382.method_10093((class_2350)object2), ((PlayerAndPredict)object9).player, ((PlayerAndPredict)object9).predict);
                                    if (!(!((double)f < hanaAura2.maxSelf.getValue()) || hanaAura2.noSuicide.getValue() > 0.0 && (double)f2 > (double)(HanaAura.mc.field_1724.method_6032() + HanaAura.mc.field_1724.method_6067()) - hanaAura2.noSuicide.getValue())) {
                                        tempPos = class_23382.method_10093((class_2350)object2);
                                        if (hanaAura2.doCrystal.getValue() && tempPos != null) {
                                            hanaAura2.doCrystal(tempPos);
                                        }
                                        return;
                                    }
                                }
                                class_2350[] arrclass_2350 = class_2350.values();
                                int n4 = arrclass_2350.length;
                                int n5 = n3 = 0;
                                while (n5 < n4) {
                                    class_2350 class_23502 = arrclass_2350[n3];
                                    if (class_23502 != class_2350.field_11033 && class_23502 != object2 && hanaAura2.canPlaceCrystal(class_23382.method_10093(class_23502), false, false)) {
                                        float f;
                                        Object object10 = object;
                                        float f3 = hanaAura2.calculateDamage(class_23382.method_10093(class_23502), ((PlayerAndPredict)object10).player, ((PlayerAndPredict)object10).predict);
                                        if (!(!((double)f < hanaAura2.maxSelf.getValue()) || hanaAura2.noSuicide.getValue() > 0.0 && (double)f3 > (double)(HanaAura.mc.field_1724.method_6032() + HanaAura.mc.field_1724.method_6067()) - hanaAura2.noSuicide.getValue())) {
                                            tempPos = class_23382.method_10093(class_23502);
                                            if (hanaAura2.doCrystal.getValue() && tempPos != null) {
                                                hanaAura2.doCrystal(tempPos);
                                            }
                                            return;
                                        }
                                    }
                                    n5 = ++n3;
                                }
                            }
                            n2 = ++n;
                        }
                    }
                }
            }
            hanaAura = hanaAura2;
        }
        if (hanaAura.doCrystal.getValue() && tempPos != null) {
            hanaAura2.doCrystal(tempPos);
        }
    }

    public void placeCrystal(class_2338 a) {
        HanaAura a22;
        class_1268 class_12682;
        HanaAura hanaAura;
        HanaAura hanaAura2 = a22;
        boolean a22 = HanaAura.mc.field_1724.method_6079().method_7909() == class_1802.field_8301;
        class_2338 class_23382 = a.method_10074();
        if (a22) {
            class_12682 = class_1268.field_5810;
            hanaAura = hanaAura2;
        } else {
            class_12682 = class_1268.field_5808;
            hanaAura = hanaAura2;
        }
        BlockUtil.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), false, class_12682, hanaAura.swingMode.getValue());
        if (hanaAura2.webSync.getValue() && hanaAura2.synchealth.getValue() <= (double)HanaAura.mc.field_1724.method_6032() && SuperWeb.INSTANCE.getInfo() != null) {
            ++hanaAura2.p;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean hasEntityBlockCrystal(class_2338 var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        a = HanaAura.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = a;
            while (v0.hasNext() != false) {
                a = (class_1297)a.next();
                if (!a.method_5805() || a != false && a instanceof class_1542) ** GOTO lbl-1000
                if (a instanceof class_1531 && CombatSetting.INSTANCE.obsMode.getValue()) {
                    v0 = a;
                    continue;
                }
                if (a instanceof class_1511 == false) return true;
                if (a == false) {
                    return true;
                }
                if (HanaAura.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(HanaAura.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return true;
                v0 = a;
            }
            return false;
            break;
        } while (true);
    }

    @Override
    public void onUpdate() {
        HanaAura a2;
        HanaAura hanaAura = a2;
        if (hanaAura.useThread.getValue()) {
            if (thread == null || !thread.isAlive()) {
                thread = new Thread(() -> {
                    HanaAura a;
                    while (INSTANCE.isOn() && a.useThread.getValue()) {
                        a.updateCrystalPos();
                    }
                    crystalPos = null;
                    tempPos = null;
                });
                try {
                    thread.start();
                }
                catch (Exception a2) {
                    a2.printStackTrace();
                }
            }
        } else {
            hanaAura.updateCrystalPos();
        }
        if (crystalPos != null) {
            hanaAura.doCrystal(crystalPos);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void doCrystal(class_2338 class_23382) {
        HanaAura a;
        HanaAura a2;
        block5 : {
            block4 : {
                a = class_23382;
                a2 = this;
                if (!a2.webSync.getValue()) break block4;
                HanaAura hanaAura = a2;
                if (hanaAura.p >= hanaAura.places.getValueInt()) break block5;
            }
            if (a2.canPlaceCrystal((class_2338)a, false, true)) {
                if (!HanaAura.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !HanaAura.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !a2.findCrystal()) return;
                a2.doPlace((class_2338)a);
                return;
            }
        }
        a2.doBreak((class_2338)a);
    }

    public HanaAura() {
        HanaAura a;
        HanaAura hanaAura = a;
        super(MathUtil.ALLATORIxDEMO("\b=\u001a\t2\u001a\u0012\u001d"), dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("F%p(d1"), Module.Category.Combat);
        HanaAura hanaAura2 = a;
        hanaAura2.page = hanaAura.add(new EnumSetting<Page>(MathUtil.ALLATORIxDEMO("#\u000e\u0007\u0019"), Page.General));
        hanaAura.preferAnchor = hanaAura.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0004}>f1RYU.p/o&"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(MathUtil.ALLATORIxDEMO(";\u0004\u0006\u000e\u001b"), SwingSide.Server, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u001ea I\u001as\u0010r2s1"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.switchCooldown = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO(" \u0017\u00154?\u001c8\u0012\u001a\u0013\u0019"), 100, 0, 1000, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("m'")));
        a.targetRange = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("'\u0001\u000e'9\u0000:\u0012\u0001\u0007\u0019"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("9")));
        a.updateDelay = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("&\u0010\u0018!(\u0011,\u0016\u0003\u0001\u0005"), 50, 0, 1000, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("m'")));
        a.wallRange = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("+!0\u0018:\u0012\u0001\u0007\u0019"), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("9")));
        a.rotate = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("&\u0007\u0007\u000e\u0014\u0019"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.onBreak = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO(";z\u0002a\"a?"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("\u0005\u0015\u001f \u001b\u0005\f"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0013g\"p'"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("&\t\u001d\u000b\u000f\u0011"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("D!p,e "), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("?(9\u0017\u0003?\u0000\u000f\u0017"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0001o\""), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkFov = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("<\u000e\u00109\u0010\u001b\u0007\u0018\u0006\u000e\u001b"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.autoMinDamage = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0004I\u0007`/}\ni:"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u000b\r\u001b")));
        a.minDamage = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\ni:"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u000b\r\u001b")));
        a.maxSelf = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("@\"l2"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u000b\r\u001b")));
        a.range = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0012r)g1"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u0011")));
        a.noSuicide = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u001aO'a)p.d1"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u000b\r\u001b")));
        a.place = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0010&c1"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setParent());
        a.placeDelay = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("0\u0010!?\u0011,\u0016\u0003\u0001\u0005"), 300, 0, 1000, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("m'")));
        a.autoSwap = a.add(new EnumSetting<SwapMode>(MathUtil.ALLATORIxDEMO("\u0001)\u0000\u0007 \u0018\u0001\f"), SwapMode.Off, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.spam = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("@7a9"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.afterBreak = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("!\u001a49\u0006*\u0001\n\u0001\u0017"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.Break = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0002a\"a?"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setParent());
        a.breakDelay = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("\"\u000e%=\u001f,\u0016\u0003\u0001\u0005"), 300, 0, 1000, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("m'")));
        a.minAge = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("9\u0001\u001d.\u0007\u0019"), 0, 0, 20, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("g.c?")));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("/\u0012\u0003\n(\u001d3\u001f\u0006\u0011\u0000\u001b\u0001\u0010"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }));
        a.breakRemove = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("F%~(v1"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }));
        a.mode = a.add(new EnumSetting<Aura.TargetESP>(MathUtil.ALLATORIxDEMO("(!.\u0013\r\u0007*3,"), Aura.TargetESP.Jello, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u000fa&G\u0011`\u0003|+o&"), new Color(255, 255, 255, 250), object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.text = a.add(new ColorSetting(MathUtil.ALLATORIxDEMO("'\n\u0018\b"), new Color(-1), object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }).injectBoolean(true));
        a.render = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("F%}#e&"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.shrink = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("'\u0000\u0001\u0006\u000e\u0017"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new ColorSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0005o,"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.bold = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("1\u0000\f\u0018"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.box.booleanValue;
        })).setParent();
        a.lineWidth = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0018I\u001aq\u0017z#t<"), 4, 1, 5, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.bold.isOpen() && a2.box.booleanValue;
        }));
        a.fill = a.add(new ColorSetting(MathUtil.ALLATORIxDEMO("5\u0006\f\u0010"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.sliderSpeed = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\bl=D\u0011f\u0013c\"e0"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("/4=\u0006\u001c5\u000e\u0004\u0019"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("'")));
        a.fadeSpeed = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO(":!8\u0011;\u0003\n\u0005\u0018"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.circle = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("W)a$l1"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.circleSize = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("0\t\u000e#0\u0011H \u0006\u001a\u0019"), 1.0, 0.5, 6.0, 0.1, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.circle.getValue();
        }));
        a.circleColor = a.add(new ColorSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("L2r7L\u00114\u0003|+o&"), new Color(255, 0, 0, 255), object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.circle.getValue();
        }));
        a.drawMode = a.add(new EnumSetting<CircleMode>(MathUtil.ALLATORIxDEMO(">\u0000\u0004\u0019"), CircleMode.Star, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.circle.getValue();
        }));
        a.xuanzhuan = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("]4t5T\u0011W)a$l1"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.circle.getValue();
        }));
        a.smart = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO(";\u001e\u000e\u0012\b"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.useThread = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0001S\u0011@(a\"a0"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.doCrystal = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("?\u000e\u001f\u00038/\u001f\u0006\u0011\u0000\u001b\u0001\u0010"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.lite = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("_.t1"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.calcMode = a.add(new EnumSetting<AnchorAura.CalcMode>(MathUtil.ALLATORIxDEMO("\u0003=\u0018\u000b>\u0000\u0004\u0019"), AnchorAura.CalcMode.OyVey, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.predictTicks = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("$f%w.c "), 4, 0, 10, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u001c\u001a\f\u000b\u000f")));
        a.terrainIgnore = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0000j)r5I\u001a]'}(r1"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.antiSurround = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO(".\u001d\u0014\u0015\u0013)\u0006\u001a\u001c\u001a\u000e\u0018"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.antiSurroundMax = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0003H\u0011z\f|0e&"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.antiSurround.isOpen();
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u000b\r\u001b")));
        a.slowPlace = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO(" }-v(u "), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.slowDelay = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO(";\u001a\r\u0019/)\u0000,\u0016\u0003\u0001\u0005"), 600, 0, 2000, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.slowPlace.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("m'")));
        a.slowMinDamage = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("4\u0015-9\u001b\u001d\u0007\"\t\u0012"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.slowPlace.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("#m3")));
        a.forcePlace = a.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("&\u00132?\u00118\u001f\u000e\u0003\u0019"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.forceMaxHealth = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0018O\u0003q2G/a:"), 7, 0, 36, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u001c\r\u0012\u0003\u0014\u0014")));
        a.forceMin = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("f\u001bf#v\ni:"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(MathUtil.ALLATORIxDEMO("\u000b\r\u001b")));
        a.armorBreaker = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("N)m;R6f%r,e&"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.maxDurable = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("-\u001d8\u0018\u0001\u001a\u0012\r\f\u0019"), 8, 0, 100, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("q")));
        a.armorBreakerDamage = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("\"\u000e%=\u001f\r\u0001\"\t\u0012"), 3.0, 0.0, 36.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("#m3")));
        a.hurtTime = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("\b)\u0006\u001c'\u0006\r\u0019"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.WebSyncMain = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\fe6s\rz#^&i:"), true, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync;
        }).setParent());
        a.WebMinDamage = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("8\u0016\u00021)20\t\u001e\u000e\u0007\u0019"), 10.0, 0.0, 36.0, 1.0, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync;
        }));
        a.webSync = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("#q\"@>n7"), false, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync;
        })).setParent();
        a.places = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("$\u0004\u0012\f\u0005\u000f"), 2, 1, 5, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync && a2.webSync.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("C\u0006m3g&l'")));
        a.resetDelay = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("2\u001939\u0000,\u0016\u0003\u0001\u0005"), 500, 0, 1000, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync && a2.webSync.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("m'")));
        a.synchealth = a.add(new SliderSetting(MathUtil.ALLATORIxDEMO("\u0013\u0005.?\u001c\r\u0012\u0003\u0014\u0014"), 12, 0, 36, object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync && a2.webSync.isOpen();
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("g9}$h$")));
        a.synctext = a.add(new ColorSetting(MathUtil.ALLATORIxDEMO("\u0013%\u001a\u000b\u0007\n\u0018\b"), new Color(-1), object -> {
            Object a = object;
            HanaAura a2 = this;
            return a2.page.getValue() == Page.Sync;
        }).injectBoolean(true));
        HanaAura hanaAura3 = a;
        HanaAura hanaAura4 = a;
        HanaAura hanaAura5 = a;
        HanaAura hanaAura6 = a;
        HanaAura hanaAura7 = a;
        HanaAura hanaAura8 = a;
        hanaAura8.resetTimer = new Timer();
        hanaAura8.switchTimer = new Timer();
        hanaAura8.delayTimer = new Timer();
        hanaAura8.lastBreakTimer = new Timer();
        hanaAura8.noPosTimer = new Timer();
        hanaAura7.lastYaw = 0.0f;
        hanaAura7.lastPitch = 0.0f;
        hanaAura6.lastHotbar = -1;
        hanaAura5.directionVec = null;
        hanaAura6.fadeIn = new FadeUtils(1000L);
        hanaAura5.fadeOut = new FadeUtils(1000L);
        hanaAura5.radiusUtils = new RadiusUtils(a.circleSize.getValue(), 1100L);
        hanaAura4.rotationFade = new FadeUtils(1000L);
        hanaAura4.currentRotation = 0.0;
        hanaAura3.fade = 0.0;
        hanaAura3.setChinese(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u82a2\u82f6\u5149\u73fb"));
        INSTANCE = hanaAura3;
        Hana.EVENT_BUS.subscribe(new CrystalRender(a));
    }

    private /* synthetic */ void updateCrystalPos() {
        HanaAura a;
        HanaAura hanaAura = a;
        hanaAura.update();
        hanaAura.lastDamage = hanaAura.tempDamage;
        crystalPos = tempPos;
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

    private /* synthetic */ void doPlace(class_2338 a) {
        HanaAura a22;
        HanaAura hanaAura = a22;
        if (!hanaAura.place.getValue()) {
            return;
        }
        if (!(HanaAura.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || HanaAura.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) || hanaAura.findCrystal())) {
            return;
        }
        if (!hanaAura.canTouch(a.method_10074())) {
            return;
        }
        class_2338 class_23382 = a.method_10074();
        a22 = BlockUtil.getClickSide(class_23382);
        a22 = class_23382.method_46558().method_1031((double)a22.method_10163().method_10263() * 0.5, (double)a22.method_10163().method_10264() * 0.5, (double)a22.method_10163().method_10260() * 0.5);
        if (hanaAura.rotate.getValue() && !hanaAura.faceVector((class_243)a22)) {
            return;
        }
        if (!placeTimer.passedMs((long)hanaAura.placeDelay.getValue())) {
            return;
        }
        placeTimer.reset();
        if (HanaAura.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || HanaAura.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301)) {
            hanaAura.placeCrystal(a);
            return;
        }
        if (hanaAura.findCrystal()) {
            int a22 = HanaAura.mc.field_1724.method_31548().field_7545;
            int n = hanaAura.getCrystal();
            if (n == -1) {
                return;
            }
            HanaAura hanaAura2 = hanaAura;
            hanaAura2.doSwap(n);
            hanaAura2.placeCrystal(a);
            if (hanaAura.autoSwap.getValue() == SwapMode.Silent) {
                hanaAura.doSwap(a22);
                return;
            }
            if (hanaAura.autoSwap.getValue() == SwapMode.Inventory) {
                hanaAura.doSwap(n);
                EntityUtil.syncInventory();
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        class_2338 a2;
        void a3;
        HanaAura hanaAura = this;
        a2 = a2.method_10074();
        HanaAura a4 = a2.method_10084();
        return !(BlockUtil.getBlock(a2) != class_2246.field_9987 && BlockUtil.getBlock(a2) != class_2246.field_10540 || BlockUtil.getClickSideStrict(a2) == null || hanaAura.hasEntityBlockCrystal((class_2338)a4, (boolean)a3, (boolean)a) || hanaAura.hasEntityBlockCrystal(a4.method_10084(), (boolean)a3, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10124 && (!hanaAura.hasEntityBlockCrystal((class_2338)a4, false, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a4.method_10084()) != class_2246.field_10124);
    }

    public boolean behindWall(class_2338 class_23382) {
        HanaAura a = class_23382;
        HanaAura a2 = this;
        class_243 class_2432 = CombatSetting.INSTANCE.lowVersion.getValue() ? new class_243((double)a.method_10263() + 0.5, (double)a.method_10264(), (double)a.method_10260() + 0.5) : new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        class_2432 = HanaAura.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), class_2432, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)HanaAura.mc.field_1724));
        if (class_2432 == null || class_2432.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return HanaAura.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > a2.wallRange.getValue();
    }

    /*
     * Exception decompiling
     */
    public float calculateDamage(class_243 var1_1, class_1657 var2_2, class_1657 var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[DOLOOP]], but top level block is 1[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        HanaAura a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
        if (crystalPos != null) {
            a2.doCrystal(crystalPos);
        }
        if (HanaAura.INSTANCE.displayTarget != null && !HanaAura.INSTANCE.noPosTimer.passedMs(500L)) {
            void a3;
            Aura.doRender((class_4587)a3, a, (class_1297)HanaAura.INSTANCE.displayTarget, a2.color.getValue(), a2.mode.getValue());
        }
    }

    @Override
    public void onEnable() {
        HanaAura a;
        a.lastYaw = Hana.ROTATE.lastYaw;
        a.lastPitch = Hana.ROTATE.lastPitch;
        a.lastBreakTimer.reset();
        HanaAura hanaAura = a;
        hanaAura.radiusUtils.reset();
        hanaAura.fadeIn.reset();
        a.rotationFade.reset();
        a.currentRotation = 0.0;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        HanaAura a2 = this;
        if (a2.autoSwap.getValue() == SwapMode.Silent || a2.autoSwap.getValue() == SwapMode.Normal) {
            InventoryUtil.switchToSlot(a);
            return;
        }
        if (a2.autoSwap.getValue() == SwapMode.Inventory) {
            InventoryUtil.inventorySwap(a, HanaAura.mc.field_1724.method_31548().field_7545);
        }
    }

    @EventHandler(priority=-199)
    public void onPacketSend(PacketEvent.Send send) {
        Object a = send;
        HanaAura a2 = this;
        if (((Event)a).isCancelled()) {
            return;
        }
        Object t = ((PacketEvent)a).getPacket();
        if (t instanceof class_2868 && (a = (class_2868)t).method_12442() != a2.lastHotbar) {
            a2.lastHotbar = a.method_12442();
            a2.switchTimer.reset();
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        HanaAura a3 = this;
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

    public static boolean liteCheck(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2432;
        class_243 a2 = class_2433;
        return !HanaAura.canSee(a, a2) && !HanaAura.canSee(a, a2.method_1031(0.0, 1.8, 0.0));
    }

    static {
        placeTimer = new Timer();
    }

    private /* synthetic */ boolean canTouch(class_2338 a) {
        HanaAura a2;
        HanaAura hanaAura = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(HanaAura.mc.field_1724.method_33571()) <= hanaAura.range.getValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getInfo() {
        HanaAura a;
        if (a.displayTarget != null && a.lastDamage > 0.0f) {
            return a.displayTarget.method_5477().getString() + ", " + new DecimalFormat(MathUtil.ALLATORIxDEMO("_NL")).format(a.lastDamage);
        }
        return null;
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Interact;
        public static final /* enum */ Page Render;
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page Sync;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Misc;

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        static {
            General = new Page(BOEntityUtils.ALLATORIxDEMO("HwPqJwV"), 0);
            Interact = new Page(Snow.ALLATORIxDEMO("zVvlvney"), 1);
            Misc = new Page(BOEntityUtils.ALLATORIxDEMO("YQeY"), 2);
            Rotate = new Page(Snow.ALLATORIxDEMO("Pfpnrh"), 3);
            Calc = new Page(BOEntityUtils.ALLATORIxDEMO("WYzY"), 4);
            Render = new Page(Snow.ALLATORIxDEMO("Pljkc"), 5);
            Sync = new Page(BOEntityUtils.ALLATORIxDEMO("GAxY"), 6);
            $VALUES = Page.$values();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[7];
            arrpage[0] = General;
            arrpage[1] = Interact;
            arrpage[2] = Misc;
            arrpage[3] = Rotate;
            arrpage[4] = Calc;
            arrpage[5] = Render;
            arrpage[6] = Sync;
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
    }

    public static final class SwapMode
    extends Enum<SwapMode> {
        private static final /* synthetic */ SwapMode[] $VALUES;
        public static final /* enum */ SwapMode Normal;
        public static final /* enum */ SwapMode Inventory;
        public static final /* enum */ SwapMode Off;
        public static final /* enum */ SwapMode Silent;

        static {
            Off = new SwapMode(CameraState.ALLATORIxDEMO("{?S"), 0);
            Normal = new SwapMode(BlockUpUtil.ALLATORIxDEMO("kuJj\u0013!"), 1);
            Silent = new SwapMode(CameraState.ALLATORIxDEMO("\u0000V4Q7A"), 2);
            Inventory = new SwapMode(BlockUpUtil.ALLATORIxDEMO("SLk@tLh\u00004"), 3);
            $VALUES = SwapMode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ SwapMode() {
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

        public static SwapMode valueOf(String a) {
            return Enum.valueOf(SwapMode.class, a);
        }

        public static SwapMode[] values() {
            return (SwapMode[])$VALUES.clone();
        }

        private static /* synthetic */ SwapMode[] $values() {
            SwapMode[] arrswapMode = new SwapMode[4];
            arrswapMode[0] = Off;
            arrswapMode[1] = Normal;
            arrswapMode[2] = Silent;
            arrswapMode[3] = Inventory;
            return arrswapMode;
        }
    }

    public static final class CircleMode
    extends Enum<CircleMode> {
        private static final /* synthetic */ CircleMode[] $VALUES;
        public static final /* enum */ CircleMode Circle2D;
        public static final /* enum */ CircleMode Star;
        public static final /* enum */ CircleMode Circle;

        public static CircleMode valueOf(String a) {
            return Enum.valueOf(CircleMode.class, a);
        }

        static {
            Star = new CircleMode(RenderHelper.ALLATORIxDEMO("$|\\0"), 0);
            Circle2D = new CircleMode(FileUtil.ALLATORIxDEMO("{>h\u0016}\u001b\";"), 1);
            Circle = new CircleMode(RenderHelper.ALLATORIxDEMO(")|\u0005kQ'"), 2);
            $VALUES = CircleMode.$values();
        }

        public static CircleMode[] values() {
            return (CircleMode[])$VALUES.clone();
        }

        private static /* synthetic */ CircleMode[] $values() {
            CircleMode[] arrcircleMode = new CircleMode[3];
            arrcircleMode[0] = Star;
            arrcircleMode[1] = Circle2D;
            arrcircleMode[2] = Circle;
            return arrcircleMode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ CircleMode() {
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
    }

    public class CrystalRender {
        final /* synthetic */ HanaAura this$0;

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @EventHandler
        public void onRender3D(Render3DEvent a) {
            block23 : {
                var2_2 = a;
                if (HanaAura.crystalPos != null) {
                    var2_2.this$0.noPosTimer.reset();
                    HanaAura.placeVec3d = HanaAura.crystalPos.method_10074().method_46558();
                }
                if (HanaAura.placeVec3d == null) {
                    return;
                }
                if (var2_2.this$0.fadeSpeed.getValue() >= 1.0) {
                    var2_2.this$0.fade = var2_2.this$0.noPosTimer.passedMs((long)(var2_2.this$0.startFadeTime.getValue() * 1000.0)) != false ? 0.0 : 0.5;
                    v0 = var2_2;
                } else {
                    if (var2_2.this$0.noPosTimer.passedMs((long)(var2_2.this$0.startFadeTime.getValue() * 1000.0))) {
                        v1 = 0.0;
                        v2 = var2_2;
                    } else {
                        v1 = 0.5;
                        v2 = var2_2;
                    }
                    var2_2.this$0.fade = AnimateUtil.animate(var2_2.this$0.fade, v1, v2.this$0.fadeSpeed.getValue() / 10.0);
                    v0 = var2_2;
                }
                if (v0.this$0.fade == 0.0) {
                    HanaAura.curVec3d = null;
                    return;
                }
                if (HanaAura.curVec3d == null || var2_2.this$0.sliderSpeed.getValue() >= 1.0) {
                    HanaAura.curVec3d = HanaAura.placeVec3d;
                    v3 = var2_2;
                } else {
                    HanaAura.curVec3d = new class_243(AnimateUtil.animate(HanaAura.curVec3d.field_1352, HanaAura.placeVec3d.field_1352, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(HanaAura.curVec3d.field_1351, HanaAura.placeVec3d.field_1351, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(HanaAura.curVec3d.field_1350, HanaAura.placeVec3d.field_1350, var2_2.this$0.sliderSpeed.getValue() / 10.0));
                    v3 = var2_2;
                }
                if (!v3.this$0.render.getValue()) break block23;
                v4 = a = new class_238(HanaAura.curVec3d, HanaAura.curVec3d);
                if (var2_2.this$0.shrink.getValue()) {
                    a = v4.method_1014(var2_2.this$0.fade);
                    v5 = a;
                } else {
                    a = v4.method_1014(0.5);
                    v5 = a;
                }
                a = v5.getMatrixStack();
                if (var2_2.this$0.fill.booleanValue) {
                    Render3DUtil.drawFill((class_4587)a, (class_238)a, ColorUtil.injectAlpha(var2_2.this$0.fill.getValue(), (int)((double)var2_2.this$0.fill.getValue().getAlpha() * var2_2.this$0.fade * 2.0)));
                }
                if (!var2_2.this$0.box.booleanValue) ** GOTO lbl47
                if (!var2_2.this$0.bold.getValue()) {
                    v6 = var2_2;
                    v7 = v6;
                    Render3DUtil.drawBox((class_4587)a, (class_238)a, ColorUtil.injectAlpha(v6.this$0.box.getValue(), (int)((double)var2_2.this$0.box.getValue().getAlpha() * var2_2.this$0.fade * 2.0)));
                } else {
                    Render3DUtil.drawLine((class_238)a, ColorUtil.injectAlpha(var2_2.this$0.box.getValue(), (int)((double)var2_2.this$0.box.getValue().getAlpha() * var2_2.this$0.fade * 2.0)), var2_2.this$0.lineWidth.getValueInt());
lbl47: // 2 sources:
                    v7 = var2_2;
                }
                if (v7.this$0.circle.getValue()) {
                    a = class_310.method_1551();
                    if (a.field_1724 == null) {
                        return;
                    }
                    a = a.field_1724;
                    v8 = var2_2;
                    var3_3 = v8.this$0.circleColor.getValue();
                    if (v8.this$0.circleSize.getValue() != var2_2.this$0.radiusUtils.getTargetRadius()) {
                        var2_2.this$0.radiusUtils.setTargetRadius(var2_2.this$0.circleSize.getValue());
                    }
                    v9 = var2_2;
                    var4_4 = var2_2.this$0.isOn() != false ? v9.this$0.fadeIn.ease(FadeUtils.Ease.In) : v9.this$0.fadeOut.ease(FadeUtils.Ease.Out);
                    var4_5 = (int)((double)var3_3.getAlpha() * var4_4);
                    var3_3 = new Color(var3_3.getRed(), var3_3.getGreen(), var3_3.getBlue(), var4_5);
                    v10 = var2_2;
                    var6_6 = (float)v10.this$0.radiusUtils.getCurrentRadius();
                    if (v10.this$0.xuanzhuan.getValue()) {
                        v11 = var2_2;
                        v11.this$0.currentRotation += var2_2.this$0.rotationFade.ease(FadeUtils.Ease.Out) * 360.0;
                        if (v11.this$0.rotationFade.isEnd()) {
                            var2_2.this$0.currentRotation = (var2_2.this$0.currentRotation % 360.0 + 360.0) % 360.0;
                        }
                    }
                    CircleUtil.drawCircle2D((class_4587)a, (class_1297)a, var3_3, var6_6, var2_2.this$0.currentRotation);
                    if (var2_2.this$0.drawMode.getValue() == CircleMode.Circle) {
                        CircleUtil.drawCircle((class_4587)a, (class_1297)a, var3_3, var6_6, var2_2.this$0.currentRotation);
                    }
                    if (var2_2.this$0.drawMode.getValue() == CircleMode.Circle2D) {
                        CircleUtil.drawCircle2D((class_4587)a, (class_1297)a, var3_3, var6_6, var2_2.this$0.currentRotation);
                    }
                    if (var2_2.this$0.drawMode.getValue() == CircleMode.Star) {
                        v12 = var6_6;
                        CircleUtil.drawStar2D((class_4587)a, (class_1297)a, var3_3, v12, v12, var2_2.this$0.currentRotation);
                    }
                }
            }
            if (var2_2.this$0.text.booleanValue && var2_2.this$0.lastDamage > 0.0f) {
                v13 = new Object[1];
                v13[0] = Float.valueOf(var2_2.this$0.lastDamage);
                Render3DUtil.drawText3D(String.format(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("!~!!"), v13), HanaAura.curVec3d, var2_2.this$0.text.getValue());
            }
            if (!(var2_2.this$0.synchealth.getValue() <= (double)Wrapper.mc.field_1724.method_6032())) return;
            if (var2_2.this$0.webSync.getValue() == false) return;
            Render3DUtil.drawText3D(String.format(String.valueOf((Object)var2_2.this$0.displayTarget.method_5477()), new Object[0]), new class_243(HanaAura.curVec3d.field_1352, HanaAura.curVec3d.field_1351 + 0.2, HanaAura.curVec3d.field_1350), var2_2.this$0.synctext.getValue());
            Render3DUtil.drawText3D(String.format("Sync:" + var2_2.this$0.lastDamage, new Object[0]), new class_243(HanaAura.curVec3d.field_1352, HanaAura.curVec3d.field_1351 - 0.2, HanaAura.curVec3d.field_1350), var2_2.this$0.synctext.getValue());
            Render3DUtil.drawText3D(String.format("" + var2_2.this$0.p, new Object[0]), new class_243(HanaAura.curVec3d.field_1352, HanaAura.curVec3d.field_1351 - 0.4, HanaAura.curVec3d.field_1350), var2_2.this$0.synctext.getValue());
        }

        public CrystalRender(HanaAura hanaAura) {
            HanaAura a = hanaAura;
            CrystalRender a2 = this;
            a2.this$0 = a;
        }
    }

    public class PlayerAndPredict {
        final /* synthetic */ HanaAura this$0;
        final class_1657 predict;
        final class_1657 player;

        public PlayerAndPredict(HanaAura hanaAura, class_1657 class_16572) {
            Iterator a;
            PlayerAndPredict a2 = class_16572;
            PlayerAndPredict a3 = this;
            a3.this$0 = a;
            a3.player = a2;
            if (((HanaAura)a).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a3;
                playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(BetterDynamicAnimation.ALLATORIxDEMO("\u0010$Re$\u0015\u001d)\u000b#\f9\u0016;\u000055\u0000\u0004+\u0015!!\u000e\u00037\u0015#\u0015$\u0016,\u0012&\u00037")), Alt.ALLATORIxDEMO("C;B\u0019l<f\r}=w0m}0`")), (HanaAura)((Object)a)){
                    final /* synthetic */ HanaAura val$this$0;
                    final /* synthetic */ PlayerAndPredict this$1;

                    public boolean method_7337() {
                        return false;
                    }

                    public boolean method_7325() {
                        return false;
                    }
                    {
                        Object a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        void a6;
                        1 v0 = object2;
                        Object object2 = object;
                        object = v0;
                        object.this$1 = a4;
                        object.val$this$0 = a;
                        super((class_1937)a6, (class_2338)a3, (float)a5, (GameProfile)a2);
                    }
                };
                a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, HanaAura.INSTANCE.predictTicks.getValueInt(), true)));
                playerAndPredict.predict.method_6033(a2.method_6032());
                playerAndPredict.predict.field_6014 = ((class_1657)a2).field_6014;
                playerAndPredict.predict.field_5969 = ((class_1657)a2).field_5969;
                playerAndPredict.predict.field_6036 = ((class_1657)a2).field_6036;
                playerAndPredict.predict.method_24830(a2.method_24828());
                PlayerAndPredict playerAndPredict2 = a2;
                playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
                playerAndPredict.predict.method_18380(a2.method_18376());
                Iterator iterator = a = playerAndPredict2.method_6026().iterator();
                while (iterator.hasNext()) {
                    class_1293 class_12932 = (class_1293)a.next();
                    iterator = a;
                    a3.predict.method_6092(class_12932);
                }
            } else {
                a3.predict = a2;
            }
        }

    }

}
