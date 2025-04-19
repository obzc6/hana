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
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
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

public class AutoCrystalBase
extends Module {
    private final BooleanSetting smart;
    private final EnumSetting<Page> page;
    private class_2338 tempPos;
    private final SliderSetting minDamage;
    private final BooleanSetting armorBreaker;
    private final BooleanSetting forcePlace;
    private final SliderSetting noSuicide;
    private final BooleanSetting checkLook;
    public float tempDamage;
    private final SliderSetting updateDelay;
    private final SliderSetting maxDurable;
    public static AutoCrystalBase INSTANCE;
    private final BooleanSetting terrainIgnore;
    private final Timer placeTimer;
    private final SliderSetting targetRange;
    private final BooleanSetting lite;
    private final BooleanSetting yawStep;
    private final BooleanSetting eatingPause;
    public class_1657 displayTarget;
    private final SliderSetting maxSelf;
    private final BooleanSetting rotate;
    public static Thread thread;
    private float lastPitch;
    private final SliderSetting placeRange;
    private final SliderSetting wallRange;
    private final SliderSetting placeDelay;
    private final Timer delayTimer;
    public static class_2338 crystalPos;
    public class_243 directionVec;
    private final BooleanSetting detectMining;
    private final BooleanSetting inventory;
    private final SliderSetting steps;
    private final SliderSetting range;
    private final SliderSetting forceMin;
    private final SliderSetting fov;
    final Timer noPosTimer;
    private final SliderSetting autoMinDamage;
    public float lastDamage;
    private final BooleanSetting random;
    private final SliderSetting forceMaxHealth;
    private final BooleanSetting auto;
    private final BooleanSetting packet;
    private final SliderSetting hurtTime;
    private final SliderSetting armorBreakerDamage;
    private final SliderSetting predictTicks;
    public float breakDamage;
    private float lastYaw;
    private final BooleanSetting doCrystal;
    private final BooleanSetting breakOnlyHasCrystal;
    private final BooleanSetting useThread;

    private /* synthetic */ void update() {
        Object object;
        AutoCrystalBase a;
        AutoCrystalBase autoCrystalBase = a;
        if (AutoCrystalBase.nullCheck()) {
            return;
        }
        AutoCrystalBase autoCrystalBase2 = autoCrystalBase;
        if (!autoCrystalBase2.delayTimer.passedMs((long)autoCrystalBase2.updateDelay.getValue())) {
            return;
        }
        if (autoCrystalBase.eatingPause.getValue() && AutoCrystalBase.mc.field_1724.method_6115()) {
            autoCrystalBase.tempPos = null;
            return;
        }
        if (Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) {
            autoCrystalBase.tempPos = null;
            return;
        }
        if (autoCrystalBase.breakOnlyHasCrystal.getValue() && !AutoCrystalBase.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !AutoCrystalBase.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !AutoCrystal.INSTANCE.findCrystal()) {
            autoCrystalBase.tempPos = null;
            return;
        }
        autoCrystalBase.delayTimer.reset();
        autoCrystalBase.breakDamage = 0.0f;
        autoCrystalBase.tempPos = null;
        autoCrystalBase.tempDamage = 0.0f;
        ArrayList<PlayerAndPredict> arrayList = new ArrayList<PlayerAndPredict>();
        Object object2 = CombatUtil.getEnemies(autoCrystalBase.targetRange.getValueFloat()).iterator();
        while (object2.hasNext()) {
            object = object2.next();
            if (((class_1657)object).field_6235 > autoCrystalBase.hurtTime.getValueInt()) continue;
            arrayList.add(new PlayerAndPredict(autoCrystalBase, (class_1657)object));
        }
        object2 = new PlayerAndPredict(autoCrystalBase, (class_1657)AutoCrystalBase.mc.field_1724);
        if (!arrayList.isEmpty()) {
            object = BlockUtil.getSphere((float)autoCrystalBase.range.getValue() + 1.0f).iterator();
            block1 : do {
                Object object3 = object;
                while (object3.hasNext()) {
                    a = (class_2338)object.next();
                    CombatUtil.modifyPos = null;
                    if (AutoCrystalBase.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > autoCrystalBase.range.getValue()) {
                        object3 = object;
                        continue;
                    }
                    if (!autoCrystalBase.canPlaceCrystal((class_2338)a, true, false)) {
                        object3 = object;
                        continue;
                    }
                    CombatUtil.modifyPos = a.method_10074();
                    CombatUtil.modifyBlockState = class_2246.field_10540.method_9564();
                    if (autoCrystalBase.behindWall((class_2338)a)) {
                        object3 = object;
                        continue;
                    }
                    if (!autoCrystalBase.canTouch(a.method_10074())) {
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
                            if (autoCrystalBase.lite.getValue() && autoCrystalBase.liteCheck(a.method_46558().method_1031(0.0, -0.5, 0.0), playerAndPredict.predict.method_19538())) {
                                iterator2 = iterator;
                                continue;
                            }
                            AutoCrystalBase autoCrystalBase3 = autoCrystalBase;
                            PlayerAndPredict playerAndPredict2 = playerAndPredict;
                            f = autoCrystalBase3.calculateDamage((class_2338)a, playerAndPredict2.player, playerAndPredict2.predict);
                            if (autoCrystalBase3.tempPos != null && !(f > autoCrystalBase.tempDamage)) continue block3;
                            Object object4 = object2;
                            float f3 = autoCrystalBase.calculateDamage((class_2338)a, ((PlayerAndPredict)object4).player, ((PlayerAndPredict)object4).predict);
                            if ((double)f2 > autoCrystalBase.maxSelf.getValue()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (autoCrystalBase.noSuicide.getValue() > 0.0 && (double)f3 > (double)(AutoCrystalBase.mc.field_1724.method_6032() + AutoCrystalBase.mc.field_1724.method_6067()) - autoCrystalBase.noSuicide.getValue()) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (!(f < EntityUtil.getHealth((class_1297)playerAndPredict.player))) break;
                            if ((double)f < autoCrystalBase.getDamage(playerAndPredict.player)) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (!autoCrystalBase.smart.getValue()) break;
                            if (autoCrystalBase.getDamage(playerAndPredict.player) == autoCrystalBase.forceMin.getValue()) {
                                if (!((double)f < (double)f3 - 2.5)) break;
                                iterator2 = iterator;
                                continue;
                            }
                            if (!(f < f3)) break;
                            iterator2 = iterator;
                        } while (true);
                        AutoCrystalBase autoCrystalBase4 = autoCrystalBase;
                        autoCrystalBase4.displayTarget = playerAndPredict.player;
                        autoCrystalBase4.tempPos = a.method_10074();
                        autoCrystalBase.tempDamage = f;
                    } while (true);
                }
                break;
            } while (true);
            CombatUtil.modifyPos = null;
            if (autoCrystalBase.tempPos != null) {
                AutoCrystalBase autoCrystalBase5 = autoCrystalBase;
                if (!BlockUtil.canPlace(autoCrystalBase5.tempPos, autoCrystalBase5.placeRange.getValue())) {
                    AutoCrystalBase autoCrystalBase6 = autoCrystalBase;
                    autoCrystalBase6.tempPos = null;
                    autoCrystalBase6.tempDamage = 0.0f;
                }
            }
        }
        if (autoCrystalBase.doCrystal.getValue() && autoCrystalBase.tempPos != null) {
            AutoCrystalBase autoCrystalBase7 = autoCrystalBase;
            autoCrystalBase7.doPlace(autoCrystalBase7.tempPos);
        }
    }

    public static class_2248 getBlock(class_2338 a) {
        return AutoCrystalBase.mc.field_1687.method_8320(a).method_26204();
    }

    @Override
    public void onEnable() {
        AutoCrystalBase a;
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

    public static boolean canSee(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return (a = AutoCrystalBase.mc.field_1687.method_17742(new class_3959(a2, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoCrystalBase.mc.field_1724))) == null || a.method_17783() == class_239.class_240.field_1333;
    }

    private /* synthetic */ boolean behindWall(class_2338 a) {
        AutoCrystalBase a2;
        AutoCrystalBase autoCrystalBase = a2;
        a2 = new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        a2 = AutoCrystalBase.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), (class_243)a2, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoCrystalBase.mc.field_1724));
        if (a2 == null || a2.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return AutoCrystalBase.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > autoCrystalBase.wallRange.getValue();
    }

    private /* synthetic */ int getBlock() {
        AutoCrystalBase a;
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
        AutoCrystalBase a3 = class_23382;
        AutoCrystalBase a4 = this;
        return a4.calculateDamage(a3.method_10074(), new class_243((double)a3.method_10263() + 0.5, (double)a3.method_10264(), (double)a3.method_10260() + 0.5), (class_1657)a, (class_1657)a2);
    }

    @Override
    public void onUpdate() {
        AutoCrystalBase autoCrystalBase;
        block4 : {
            AutoCrystalBase autoCrystalBase2;
            block3 : {
                block2 : {
                    AutoCrystalBase a22;
                    autoCrystalBase2 = a22;
                    if (!autoCrystalBase2.useThread.getValue()) break block2;
                    if (thread != null && thread.isAlive()) break block3;
                    thread = new Thread(() -> {
                        AutoCrystalBase a;
                        while (INSTANCE.isOn() && a.useThread.getValue()) {
                            a.updateCrystalPos();
                        }
                        crystalPos = null;
                        a.tempPos = null;
                    });
                    try {
                        thread.start();
                        autoCrystalBase = autoCrystalBase2;
                    }
                    catch (Exception a22) {
                        autoCrystalBase = autoCrystalBase2;
                        a22.printStackTrace();
                    }
                    break block4;
                }
                autoCrystalBase2.updateCrystalPos();
            }
            autoCrystalBase = autoCrystalBase2;
        }
        autoCrystalBase.doInteract();
    }

    private /* synthetic */ boolean canTouch(class_2338 a) {
        AutoCrystalBase a2;
        AutoCrystalBase autoCrystalBase = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(AutoCrystalBase.mc.field_1724.method_33571()) <= autoCrystalBase.range.getValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getInfo() {
        AutoCrystalBase a;
        if (a.displayTarget != null && a.lastDamage > 0.0f) {
            return a.displayTarget.method_5477().getString() + ", " + new DecimalFormat(Timer.ALLATORIxDEMO("\u000b\u0011\u0002")).format(a.lastDamage);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        AutoCrystalBase a3 = this;
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

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        class_2338 a2;
        void a3;
        AutoCrystalBase autoCrystalBase = this;
        a2 = a2.method_10074();
        AutoCrystalBase a4 = a2.method_10084();
        class_2338 class_23383 = a4.method_10084();
        return !(AutoCrystalBase.getBlock(a2) != class_2246.field_9987 && AutoCrystalBase.getBlock(a2) != class_2246.field_10540 && !BlockUtil.canPlace(a2, autoCrystalBase.placeRange.getValue()) || BlockUtil.getClickSideStrict(a2) == null || !autoCrystalBase.noEntityBlockCrystal((class_2338)a4, (boolean)a, (boolean)a3) || !autoCrystalBase.noEntityBlockCrystal(class_23383, (boolean)a, (boolean)a3) || !AutoCrystalBase.mc.field_1687.method_22347((class_2338)a4) && (!BlockUtil.hasCrystal((class_2338)a4) || AutoCrystalBase.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && !AutoCrystalBase.mc.field_1687.method_22347(class_23383));
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

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AutoCrystalBase a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
    }

    public AutoCrystalBase() {
        AutoCrystalBase a;
        AutoCrystalBase autoCrystalBase = a;
        super(PacketBuffer.ALLATORIxDEMO("N\u001a|\u0015^\u0005i*J\u001bq*n\r|"), Module.Category.Combat);
        AutoCrystalBase autoCrystalBase2 = a;
        autoCrystalBase.placeTimer = new Timer();
        autoCrystalBase2.delayTimer = new Timer();
        autoCrystalBase.page = autoCrystalBase.add(new EnumSetting<Page>(Timer.ALLATORIxDEMO("tH\t\u0006"), Page.General));
        autoCrystalBase.inventory = autoCrystalBase.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("A\u0014k\u0012~-Q\bd;x\u001fi"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("(\u0004MQ]Gt]J@\u0000\u0004"), false, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\u0016P\u0016d `\u0012}"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("$X@W]^dE\\\u001d\u0006"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("I\u0016b>[\u000eO\ta\u0019|"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Timer.ALLATORIxDEMO("\u000e")));
        a.updateDelay = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("H\u0007t8J\u001fY\rc\u001f`"), 50, 0, 1000, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Timer.ALLATORIxDEMO("\u0003\u0010")));
        a.wallRange = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("G8R\u0016O\ta\u0019|"), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Timer.ALLATORIxDEMO("\u000e")));
        a.rotate = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("(r\u001cn\n|"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.yawStep = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("jXCw]\u000b\u0013"), false, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("N\u001cj\u000ej"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("kUJM\u0001\u000e"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("*|\u000bd\u001bm"), false, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("wVVZ_hF\u0001\b"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("I\u0011o"), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.auto = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("e\\\u001a\f"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.autoMinDamage = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO(")B\u0017w"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact && a2.auto.getValue();
        }).setSuffix(Timer.ALLATORIxDEMO("M\u0003\u0004")));
        a.minDamage = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("B\u0017w"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Timer.ALLATORIxDEMO("M\u0003\u0004")));
        a.maxSelf = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO(";j\u0012"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Timer.ALLATORIxDEMO("M\u0003\u0004")));
        a.range = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("O\ta\u0019|"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Timer.ALLATORIxDEMO("\u000e")));
        a.placeRange = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("'|8]\u001fO\ta\u0019|"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Timer.ALLATORIxDEMO("\u000e")));
        a.noSuicide = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("^6m\u000ft\u000bf\u001a|"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(Timer.ALLATORIxDEMO("M\u0003\u0004")));
        a.smart = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("N\u0005n\fm"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.placeDelay = a.add(new SliderSetting(Timer.ALLATORIxDEMO("iX_P\\pAE\u000f\u001a"), 300, 0, 1000, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(PacketBuffer.ALLATORIxDEMO("\u0013j")));
        a.useThread = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("aMVm\\VL\u000f\u0007"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.doCrystal = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("^\u0016|:z\u0015M\u0004n\u001d|"), false, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.lite = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("h@\u001a\u0006"), false, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.predictTicks = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("n\bx\ff\u001dm"), 4, 0, 10, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(Timer.ALLATORIxDEMO("@MJ\u0005\u0010")));
        a.terrainIgnore = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\\\u001fo\u0005q0P3z\u0006`\f|"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.forcePlace = a.add(new BooleanSetting(Timer.ALLATORIxDEMO("[LP\\dHH\r\u0006"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.forceMaxHealth = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("\\6I\u001fo<g\u001fw"), 7, 0, 36, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(Timer.ALLATORIxDEMO("QQEE\u001a\u000b")));
        a.forceMin = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("\u001fQ\b~\rB\u0017w"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(Timer.ALLATORIxDEMO("M\u0003\u0004")));
        a.armorBreaker = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO(";o\u001a+|\bx\td\u001bk"), true, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.maxDurable = a.add(new SliderSetting(Timer.ALLATORIxDEMO("tUFwLFEK\u0002\u0006"), 8, 0, 100, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(PacketBuffer.ALLATORIxDEMO("<")));
        a.armorBreakerDamage = a.add(new SliderSetting(Timer.ALLATORIxDEMO("{F[RRQVd\u0007\r"), 3.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(PacketBuffer.ALLATORIxDEMO("k\u0013~")));
        a.hurtTime = a.add(new SliderSetting(Timer.ALLATORIxDEMO("vFK@p@\u0003\u0006"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            AutoCrystalBase a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        AutoCrystalBase autoCrystalBase3 = a;
        AutoCrystalBase autoCrystalBase4 = a;
        autoCrystalBase4.lastYaw = 0.0f;
        autoCrystalBase4.lastPitch = 0.0f;
        autoCrystalBase4.noPosTimer = new Timer();
        autoCrystalBase3.directionVec = null;
        autoCrystalBase3.setChinese(PacketBuffer.ALLATORIxDEMO("\u81d4\u52d2\u6c29\u661e\u9ede\u66a2\u77ea"));
        INSTANCE = autoCrystalBase3;
    }

    @Override
    public void onThread() {
        AutoCrystalBase a;
        if (a.useThread.getValue()) {
            a.updateCrystalPos();
        }
    }

    private /* synthetic */ double getDamage(class_1657 class_16572) {
        Object a = class_16572;
        AutoCrystalBase a2 = this;
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

    private /* synthetic */ void doInteract() {
        a.directionVec = null;
        if (crystalPos != null) {
            AutoCrystalBase a;
            a.doPlace(crystalPos);
        }
    }

    private /* synthetic */ void updateCrystalPos() {
        AutoCrystalBase a;
        AutoCrystalBase autoCrystalBase = a;
        autoCrystalBase.update();
        autoCrystalBase.lastDamage = autoCrystalBase.tempDamage;
        crystalPos = autoCrystalBase.tempPos;
    }

    @Override
    public void onLogin() {
        AutoCrystalBase a;
        if (a.useThread.getValue()) {
            a.updateCrystalPos();
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean liteCheck(class_243 class_2432, class_243 class_2433) {
        void a;
        AutoCrystalBase a2 = class_2433;
        AutoCrystalBase a3 = this;
        return !AutoCrystalBase.canSee((class_243)a, (class_243)a2) && !AutoCrystalBase.canSee((class_243)a, a2.method_1031(0.0, 1.8, 0.0));
    }

    private /* synthetic */ void doPlace(class_2338 class_23382) {
        AutoCrystalBase a;
        AutoCrystalBase autoCrystalBase;
        AutoCrystalBase autoCrystalBase2;
        AutoCrystalBase a2 = class_23382;
        AutoCrystalBase autoCrystalBase3 = a = this;
        if (!autoCrystalBase3.placeTimer.passedMs((long)autoCrystalBase3.placeDelay.getValue())) {
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
        int n2 = AutoCrystalBase.mc.field_1724.method_31548().field_7545;
        a.doSwap(n);
        if (BlockUtil.airPlace()) {
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock((class_2338)a2, class_2350.field_11033, false, class_1268.field_5808);
            autoCrystalBase = a;
        } else {
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), false, class_1268.field_5808);
            autoCrystalBase = a;
        }
        AutoCrystalBase autoCrystalBase4 = a;
        if (autoCrystalBase.inventory.getValue()) {
            autoCrystalBase4.doSwap(n);
            EntityUtil.syncInventory();
            autoCrystalBase2 = a;
        } else {
            autoCrystalBase4.doSwap(n2);
            autoCrystalBase2 = a;
        }
        if (autoCrystalBase2.rotate.getValue() && !a.yawStep.getValue() && CombatSetting.INSTANCE.rotateSync.getValue()) {
            Hana.ROTATE.snapBack();
        }
        a.placeTimer.reset();
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_243 class_2432, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        void a222;
        AutoCrystalBase a3 = class_2432;
        AutoCrystalBase a4 = this;
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
                if (AutoCrystalBase.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(AutoCrystalBase.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return false;
                v0 = a;
            }
            return true;
            break;
        } while (true);
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        AutoCrystalBase a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
    }

    @Override
    public void onDisable() {
        crystalPos = null;
        a.tempPos = null;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoCrystalBase a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AutoCrystalBase.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page General = new Page(BlockUpUtil.ALLATORIxDEMO("Z@t]u\u0013!"), 0);
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Misc;
        public static final /* enum */ Page Interact;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Rotate;

        static {
            Interact = new Page(ObsidianHelper.ALLATORIxDEMO("U\u0019Y#Y!J6"), 1);
            Misc = new Page(BlockUpUtil.ALLATORIxDEMO("un\u0001."), 2);
            Rotate = new Page(ObsidianHelper.ALLATORIxDEMO(")_!]'"), 3);
            Calc = new Page(BlockUpUtil.ALLATORIxDEMO("{f\u001e."), 4);
            $VALUES = Page.$values();
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
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

    private class PlayerAndPredict {
        final /* synthetic */ AutoCrystalBase this$0;
        final class_1657 player;
        final class_1657 predict;

        private /* synthetic */ PlayerAndPredict(AutoCrystalBase object, class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.this$0 = object;
            a2.player = a;
            if (((AutoCrystalBase)object).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Animation.ALLATORIxDEMO("\u0010+Vn \u001e\u0019\"\u000f(\b2\u00120\u0004>1\u000b\u0000 \u0011*%\u0005\u0007<\u0011(\u0011/\u0012'\u0016-\u0007<")), FrameConverter.ALLATORIxDEMO("(i\nhN'\u0006T\u001bb\u001be\u0016?\u0016")), (AutoCrystalBase)object, (class_1657)a){
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ AutoCrystalBase val$this$0;
                    final /* synthetic */ class_1657 val$player;

                    public boolean method_24828() {
                        1 a;
                        return a.val$player.method_24828();
                    }

                    public boolean method_7325() {
                        return false;
                    }
                    {
                        void a;
                        void a2;
                        void a3;
                        void a4;
                        1 a5;
                        void a6;
                        1 v0 = this_;
                        1 this_ = class_16572;
                        class_1657 class_16573 = class_16572 = v0;
                        class_16573.this$1 = a2;
                        class_16573.val$this$0 = autoCrystalBase;
                        class_16572.val$player = a5;
                        class_16572((class_1937)a4, (class_2338)a6, (float)a3, (GameProfile)a);
                    }

                    public boolean method_7337() {
                        return false;
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, ((AutoCrystalBase)object).predictTicks.getValueInt(), true)));
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
