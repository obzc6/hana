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
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2824
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
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
package dev.recollect.hana.mod.modules.impl.combat.dev;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ExplosionUtil;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.Easing;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.combat.WebAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoWebPuls;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaCrystalBase;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.render.dev.ExplosionSpawn;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2824;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AlienCrystal
extends Module {
    double currentFade;
    private final ColorSetting color;
    private final BooleanSetting useThread;
    private final BooleanSetting checkFov;
    private final BooleanSetting place;
    private final SliderSetting noSuicide;
    private final SliderSetting steps;
    private final SliderSetting yOffset;
    public final BooleanSetting airPlace;
    private class_2338 tempPos;
    private final SliderSetting predictTicks;
    private final SliderSetting hurtTime;
    private final SliderSetting minDamage;
    private final BooleanSetting forceWeb;
    private final BooleanSetting onBreak;
    private final SliderSetting updateDelay;
    public class_243 directionVec;
    private final BooleanSetting forcePlace;
    private final SliderSetting syncTimeout;
    private class_2338 syncPos;
    public final EnumSetting<Easing> ease;
    private final ColorSetting text;
    private final SliderSetting forceMaxHealth;
    private final Timer calcDelay;
    private final Timer noPosTimer;
    private final BooleanSetting breakOnlyHasCrystal;
    private final BooleanSetting shrink;
    private final SliderSetting slowMinDamage;
    private final ColorSetting hitColor;
    private final SliderSetting lineWidth;
    private final ColorSetting box;
    private final EnumSetting<TargetESP> mode;
    private final SliderSetting fadeSpeed;
    private class_2338 breakPos;
    private final SliderSetting range;
    private final ColorSetting fill;
    private final EnumSetting<SwingSide> swingMode;
    private final SliderSetting placeDelay;
    private final SliderSetting startFadeTime;
    private final SliderSetting antiSurroundMax;
    private final SliderSetting constantProgress;
    private final BooleanSetting armorBreaker;
    private final SliderSetting armorBreakerDamage;
    public float lastDamage;
    private final BooleanSetting breakSetting;
    private final BooleanSetting yawStep;
    private final BooleanSetting ignoreMine;
    private final Animation animation;
    public float tempDamage;
    DecimalFormat df;
    private final BooleanSetting antiSurround;
    private final EnumSetting<SwapMode> autoSwap;
    public float breakDamage;
    private final EnumSetting<Page> page;
    private final Timer placeTimer;
    private final SliderSetting maxDurable;
    private final SliderSetting maxSelf;
    private final BooleanSetting slowPlace;
    private final SliderSetting switchCooldown;
    private final BooleanSetting eatingPause;
    public final SliderSetting animationTime;
    private final SliderSetting priority;
    private final BooleanSetting afterBreak;
    private final BooleanSetting breakRemove;
    private final Timer syncTimer;
    private final BooleanSetting onlyTick;
    private final SliderSetting breakDelay;
    private final SliderSetting minAge;
    private class_243 curVec3d;
    private final SliderSetting wallRange;
    private final Timer switchTimer;
    private final BooleanSetting preferAnchor;
    private final SliderSetting fov;
    private final BooleanSetting rotate;
    public static AlienCrystal INSTANCE;
    private final SliderSetting autoMinDamage;
    private final BooleanSetting lite;
    private final BooleanSetting doCrystal;
    private final SliderSetting sliderSpeed;
    public static class_2338 crystalPos;
    private final SliderSetting waitHurt;
    private class_243 placeVec3d;
    private final SliderSetting targetRange;
    public class_1657 displayTarget;
    private final BooleanSetting terrainIgnore;
    private final BooleanSetting sync;
    private final SliderSetting slowDelay;
    private final BooleanSetting render;
    private final SliderSetting forceMin;
    public final Timer lastBreakTimer;
    public static Thread thread;
    public final BooleanSetting replace;
    private final BooleanSetting smart;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean liteCheck(class_243 class_2432, class_243 class_2433) {
        void a;
        AlienCrystal a2 = class_2433;
        AlienCrystal a3 = this;
        return !AlienCrystal.canSee((class_243)a, (class_243)a2) && !AlienCrystal.canSee((class_243)a, a2.method_1031(0.0, 1.8, 0.0));
    }

    @EventHandler
    public void onRotate(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        AlienCrystal a2 = this;
        if (a2.rotate.getValue() && a2.yawStep.getValue() && a2.directionVec != null && !a2.noPosTimer.passed(1000L)) {
            AlienCrystal alienCrystal = a2;
            a.setTarget(alienCrystal.directionVec, alienCrystal.steps.getValueFloat(), a2.priority.getValueFloat());
        }
    }

    @Override
    public void onEnable() {
        AlienCrystal a;
        crystalPos = null;
        a.tempPos = null;
        a.breakPos = null;
        a.displayTarget = null;
        a.syncTimer.reset();
        a.lastBreakTimer.reset();
    }

    @EventHandler(priority=-199)
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        AlienCrystal a2 = this;
        if (a.isCancelled()) {
            return;
        }
        if (a.getPacket() instanceof class_2868) {
            a2.switchTimer.reset();
        }
    }

    private /* synthetic */ double getDamage(class_1657 class_16572) {
        Object a = class_16572;
        AlienCrystal a2 = this;
        if (!SpeedMine.INSTANCE.obsidian.isPressed() && a2.slowPlace.getValue()) {
            AlienCrystal alienCrystal = a2;
            if (alienCrystal.lastBreakTimer.passedMs((long)alienCrystal.slowDelay.getValue()) && !PistonCrystal.INSTANCE.isOn()) {
                return a2.slowMinDamage.getValue();
            }
        }
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

    @Override
    public void onThread() {
    }

    public static boolean canSee(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return (a = AlienCrystal.mc.field_1687.method_17742(new class_3959(a2, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AlienCrystal.mc.field_1724))) == null || a.method_17783() == class_239.class_240.field_1333;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AlienCrystal a2 = this;
        if (a2.autoSwap.getValue() == SwapMode.Silent || a2.autoSwap.getValue() == SwapMode.Normal) {
            InventoryUtil.switchToSlot(a);
            return;
        }
        if (a2.autoSwap.getValue() == SwapMode.Inventory) {
            InventoryUtil.inventorySwap(a, AlienCrystal.mc.field_1724.method_31548().field_7545);
        }
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AlienCrystal a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
        if (!a2.onlyTick.getValue()) {
            a2.doInteract();
        }
    }

    @Override
    public void onUpdate() {
        AlienCrystal alienCrystal;
        block4 : {
            AlienCrystal alienCrystal2;
            block3 : {
                block2 : {
                    AlienCrystal a22;
                    alienCrystal2 = a22;
                    if (!alienCrystal2.useThread.getValue()) break block2;
                    if (thread != null && thread.isAlive()) break block3;
                    thread = new Thread(() -> {
                        AlienCrystal a;
                        while (INSTANCE.isOn() && a.useThread.getValue()) {
                            a.updateCrystalPos();
                        }
                        crystalPos = null;
                        a.tempPos = null;
                    });
                    try {
                        thread.start();
                        alienCrystal = alienCrystal2;
                    }
                    catch (Exception a22) {
                        alienCrystal = alienCrystal2;
                        a22.printStackTrace();
                    }
                    break block4;
                }
                alienCrystal2.updateCrystalPos();
            }
            alienCrystal = alienCrystal2;
        }
        alienCrystal.doInteract();
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
                if (AlienCrystal.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(AlienCrystal.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return false;
                v0 = a;
            }
            return true;
            break;
        } while (true);
    }

    private /* synthetic */ boolean shouldReturn() {
        AlienCrystal a;
        if (a.eatingPause.getValue() && AlienCrystal.mc.field_1724.method_6115() || Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) {
            a.lastBreakTimer.reset();
            return true;
        }
        if (a.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            a.lastBreakTimer.reset();
            return true;
        }
        return false;
    }

    private /* synthetic */ void placeCrystal(class_2338 a) {
        AlienCrystal a22;
        class_1268 class_12682;
        AlienCrystal alienCrystal;
        AlienCrystal alienCrystal2 = a22;
        ExplosionSpawn.INSTANCE.add(a);
        boolean a22 = AlienCrystal.mc.field_1724.method_6079().method_7909() == class_1802.field_8301;
        class_2338 class_23382 = a.method_10074();
        if (a22) {
            class_12682 = class_1268.field_5810;
            alienCrystal = alienCrystal2;
        } else {
            class_12682 = class_1268.field_5808;
            alienCrystal = alienCrystal2;
        }
        BlockUtil.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), false, class_12682, alienCrystal.swingMode.getValue());
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_243 class_2432, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        AlienCrystal a222 = class_2432;
        AlienCrystal a3 = this;
        if (a3.ignoreMine.getValue() && SpeedMine.breakPos != null && AlienCrystal.mc.field_1724.method_33571().method_1022(SpeedMine.breakPos.method_46558()) <= SpeedMine.INSTANCE.range.getValue() && SpeedMine.progress >= a3.constantProgress.getValue() / 100.0) {
            CombatUtil.modifyPos = SpeedMine.breakPos;
            CombatUtil.modifyBlockState = class_2246.field_10124.method_9564();
        }
        if (a3.terrainIgnore.getValue()) {
            CombatUtil.terrainIgnore = true;
        }
        float a222 = ExplosionUtil.calculateDamage(a222.method_10216(), a222.method_10214(), a222.method_10215(), (class_1297)a, (class_1297)a2, 6.0f);
        CombatUtil.modifyPos = null;
        CombatUtil.terrainIgnore = false;
        return a222;
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        class_2338 a2;
        void a3;
        AlienCrystal alienCrystal = this;
        a2 = a2.method_10074();
        AlienCrystal a4 = a2.method_10084();
        class_2338 class_23383 = a4.method_10084();
        return !(HanaCrystalBase.getBlock(a2) != class_2246.field_9987 && HanaCrystalBase.getBlock(a2) != class_2246.field_10540 || BlockUtil.getClickSideStrict(a2) == null || !alienCrystal.noEntityBlockCrystal((class_2338)a4, (boolean)a, (boolean)a3) || !alienCrystal.noEntityBlockCrystal(class_23383, (boolean)a, (boolean)a3) || !AlienCrystal.mc.field_1687.method_22347((class_2338)a4) && (!BlockUtil.hasCrystal((class_2338)a4) || HanaCrystalBase.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && !AlienCrystal.mc.field_1687.method_22347(class_23383));
    }

    public boolean behindWall(class_2338 a) {
        AlienCrystal a2;
        AlienCrystal alienCrystal = a2;
        a2 = new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        a2 = AlienCrystal.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), (class_243)a2, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AlienCrystal.mc.field_1724));
        if (a2 == null || a2.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return AlienCrystal.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > alienCrystal.wallRange.getValue();
    }

    private /* synthetic */ boolean faceVector(class_243 class_2432) {
        AlienCrystal a = class_2432;
        AlienCrystal a2 = this;
        if (!a2.yawStep.getValue()) {
            EntityUtil.faceVector((class_243)a);
            return true;
        }
        a2.directionVec = a;
        if (Hana.ROTATE.inFov((class_243)a, a2.fov.getValueFloat())) {
            return true;
        }
        return !a2.checkFov.getValue();
    }

    public AlienCrystal() {
        AlienCrystal a;
        AlienCrystal alienCrystal = a;
        super(Start.ALLATORIxDEMO("8;EgEF^{Bk\u001a9"), Module.Category.Combat);
        AlienCrystal alienCrystal2 = a;
        alienCrystal.lastBreakTimer = new Timer();
        alienCrystal2.placeTimer = new Timer();
        alienCrystal.noPosTimer = new Timer();
        alienCrystal.switchTimer = new Timer();
        alienCrystal.calcDelay = new Timer();
        alienCrystal.page = alienCrystal.add(new EnumSetting<Page>(GameInfo.ALLATORIxDEMO("Levl"), Page.General));
        alienCrystal.preferAnchor = alienCrystal.add(new BooleanSetting(Start.ALLATORIxDEMO(")%IdNwmlRw\u0014'"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("AxehTk}m"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(Start.ALLATORIxDEMO("QFv\u00152"), SwingSide.All, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("RehgxnA}qbl"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.switchCooldown = a.add(new SliderSetting(Start.ALLATORIxDEMO("\u0004[k_fDRPj\b0"), 100, 0, 1000, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(GameInfo.ALLATORIxDEMO("|z")));
        a.targetRange = a.add(new SliderSetting(Start.ALLATORIxDEMO("\u0003MpL`XPPq\u001c0"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(GameInfo.ALLATORIxDEMO("d")));
        a.updateDelay = a.add(new SliderSetting(Start.ALLATORIxDEMO("\u0002\\fJqIFTs\u001a,"), 50, 0, 1000, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(GameInfo.ALLATORIxDEMO("|z")));
        a.wallRange = a.add(new SliderSetting(Start.ALLATORIxDEMO("UJi@PPq\u001c0"), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(GameInfo.ALLATORIxDEMO("d")));
        a.rotate = a.add(new BooleanSetting(Start.ALLATORIxDEMO("~mE~\u000f0"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Rotation;
        }).setParent());
        a.onBreak = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("YgSnapb"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotation;
        }));
        a.yOffset = a.add(new SliderSetting(Start.ALLATORIxDEMO("\\cdWl\u001e!"), 0.05, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.onBreak.getValue() && a2.page.getValue() == Page.Rotation;
        }));
        a.yawStep = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("OhfOpty"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotation;
        }));
        a.steps = a.add(new SliderSetting(Start.ALLATORIxDEMO("QEz\u000b&"), 0.05, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotation;
        }));
        a.checkFov = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("XjpwZf~wmn"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotation;
        }));
        a.fov = a.add(new SliderSetting(Start.ALLATORIxDEMO("Y\u0014#"), 30, 0, 50, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkFov.getValue() && a2.page.getValue() == Page.Rotation;
        }));
        a.priority = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("^d`~nmep"), 10, 0, 100, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotation;
        }));
        a.autoMinDamage = a.add(new SliderSetting(Start.ALLATORIxDEMO("RBvXm_R\u0012;"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(GameInfo.ALLATORIxDEMO("`|n")));
        a.minDamage = a.add(new SliderSetting(Start.ALLATORIxDEMO("R\u0012;"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(GameInfo.ALLATORIxDEMO("`|n")));
        a.maxSelf = a.add(new SliderSetting(Start.ALLATORIxDEMO("bz\u00173"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(GameInfo.ALLATORIxDEMO("`|n")));
        a.range = a.add(new SliderSetting(Start.ALLATORIxDEMO("PPq\u001c0"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(GameInfo.ALLATORIxDEMO("d")));
        a.noSuicide = a.add(new SliderSetting(Start.ALLATORIxDEMO("LDVYkRv\u001f0"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(GameInfo.ALLATORIxDEMO("yy")));
        a.smart = a.add(new BooleanSetting(Start.ALLATORIxDEMO("Q\\~\t!"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.place = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Aperl"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setParent());
        a.placeDelay = a.add(new SliderSetting(Start.ALLATORIxDEMO("|nJfIFTs\u001a,"), 300, 0, 1000, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO("|z")));
        a.autoSwap = a.add(new EnumSetting<SwapMode>(Start.ALLATORIxDEMO("jpXmbh\u001a%"), SwapMode.Off, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.afterBreak = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Ezzs{Snapb"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.breakSetting = a.add(new BooleanSetting(Start.ALLATORIxDEMO("@Cz\u001a>"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setParent());
        a.breakDelay = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("FnkwbUyhpp"), 300, 0, 1000, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.breakSetting.isOpen();
        }).setSuffix(Start.ALLATORIxDEMO("\u0016&")));
        a.minAge = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("DxrEvl"), 0, 0, 20, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.breakSetting.isOpen();
        }).setSuffix(Start.ALLATORIxDEMO("Ev\u0018>")));
        a.breakRemove = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("[tqkgl"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.breakSetting.isOpen();
        }));
        a.onlyTick = a.add(new BooleanSetting(Start.ALLATORIxDEMO("dk@{ev\u0018>"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }));
        a.text = a.add(new ColorSetting(GameInfo.ALLATORIxDEMO("Hai}"), new Color(-1), object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }).injectBoolean(true));
        a.render = a.add(new BooleanSetting(Start.ALLATORIxDEMO("~g_{\u001e'"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.sync = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("O}j"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.shrink = a.add(new BooleanSetting(Start.ALLATORIxDEMO("jCv\u0015>"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new ColorSetting(GameInfo.ALLATORIxDEMO("F~q"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.lineWidth = a.add(new SliderSetting(Start.ALLATORIxDEMO("NBkIUX{\u000f="), 1.5, 0.01, 3.0, 0.01, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.fill = a.add(new ColorSetting(GameInfo.ALLATORIxDEMO("Zm}e"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.sliderSpeed = a.add(new SliderSetting(Start.ALLATORIxDEMO("\u0004@kO`^QAz\u001e1"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Ozw{eZeul"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setSuffix(Start.ALLATORIxDEMO("&")));
        a.fadeSpeed = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("ZorlBlatm"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.mode = a.add(new EnumSetting<TargetESP>(Start.ALLATORIxDEMO("VJwKgEZ(\u0005"), TargetESP.Jello, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(GameInfo.ALLATORIxDEMO("Cenis}Rsh~{"), new Color(255, 255, 255, 50), object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.hitColor = a.add(new ColorSetting(Start.ALLATORIxDEMO("clXA^s\u0014'"), new Color(255, 255, 255, 150), object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.animationTime = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("ga~i}zfHm|l"), 200.0, 0.0, 2000.0, 1.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.mode.is(TargetESP.Box);
        }));
        a.ease = a.add(new EnumSetting<Easing>(Start.ALLATORIxDEMO("t~\b0"), Easing.CubicInOut, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.mode.is(TargetESP.Box);
        }));
        a.useThread = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("I}s]ynapm"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.doCrystal = a.add(new BooleanSetting(Start.ALLATORIxDEMO("}o\u000b2MfbkXgC~\u0018!"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.lite = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("ZlboGA\\"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.predictTicks = a.add(new SliderSetting(Start.ALLATORIxDEMO("U^gUv\u0018!"), 4, 0, 10, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(GameInfo.ALLATORIxDEMO("eugzz")));
        a.terrainIgnore = a.add(new BooleanSetting(Start.ALLATORIxDEMO("S\u001c%^cBkee_p\t0"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.ignoreMine = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("M{`y{tQml"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.constantProgress = a.add(new SliderSetting(Start.ALLATORIxDEMO("{wCeCz\b&"), 90.0, 0.0, 100.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.ignoreMine.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO(",")));
        a.antiSurround = a.add(new BooleanSetting(Start.ALLATORIxDEMO("89Xkxp^p^j\u00151"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.antiSurroundMax = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Kfsg]sst{"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.antiSurround.isOpen();
        }).setSuffix(Start.ALLATORIxDEMO("{\u00162")));
        a.slowPlace = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("B`|ykd}"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.slowDelay = a.add(new SliderSetting(Start.ALLATORIxDEMO("->AgDpXFTs\u001a,"), 600, 0, 2000, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.slowPlace.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO("|z")));
        a.slowMinDamage = a.add(new SliderSetting(Start.ALLATORIxDEMO("xkF`CwER\u0012;"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.slowPlace.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO("`|n")));
        a.forcePlace = a.add(new BooleanSetting(Start.ALLATORIxDEMO("jmYfIR]~\u00180"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.forceMaxHealth = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("PaalcHlpg"), 7, 0, 36, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(Start.ALLATORIxDEMO("DgPs\u000f=")));
        a.forceMin = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Hy{ryIxg"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(Start.ALLATORIxDEMO("{\u00162")));
        a.armorBreaker = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Neis|T{t}ot{"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.maxDurable = a.add(new SliderSetting(Start.ALLATORIxDEMO("acSAYpP}\u00170"), 8, 0, 100, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO(",")));
        a.armorBreakerDamage = a.add(new SliderSetting(Start.ALLATORIxDEMO("npNdGgCR\u0012;"), 3.0, 0.0, 36.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(GameInfo.ALLATORIxDEMO("`|n")));
        a.hurtTime = a.add(new SliderSetting(Start.ALLATORIxDEMO("cp^vev\u00160"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.waitHurt = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Yw`eTqc}"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.syncTimeout = a.add(new SliderSetting(Start.ALLATORIxDEMO("\u0000Mk_QEoTP\u000e!"), 500.0, 0.0, 2000.0, 10.0, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.forceWeb = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Hy{ryStk"), true, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.airPlace = a.add(new BooleanSetting(Start.ALLATORIxDEMO("jl^R]~\u00180"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forceWeb.isOpen();
        }));
        a.replace = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Dlaperl"), false, object -> {
            Object a = object;
            AlienCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forceWeb.isOpen();
        }));
        AlienCrystal alienCrystal3 = a;
        AlienCrystal alienCrystal4 = a;
        a.animation = new Animation();
        alienCrystal4.directionVec = null;
        alienCrystal4.currentFade = 0.0;
        alienCrystal4.df = new DecimalFormat(Start.ALLATORIxDEMO("/Ue"));
        alienCrystal3.syncTimer = new Timer();
        alienCrystal3.setChinese(GameInfo.ALLATORIxDEMO("\u5907\u6603\u4ebe\u6c25\u667f"));
        INSTANCE = alienCrystal3;
        Hana.EVENT_BUS.subscribe(new CrystalRender(a));
    }

    private /* synthetic */ void doInteract() {
        AlienCrystal a;
        if (a.shouldReturn()) {
            return;
        }
        if (a.breakPos != null) {
            AlienCrystal alienCrystal = a;
            alienCrystal.doBreak(alienCrystal.breakPos);
            alienCrystal.breakPos = null;
        }
        if (crystalPos != null) {
            a.doCrystal(crystalPos);
        }
    }

    @Override
    public void onDisable() {
        crystalPos = null;
        a.tempPos = null;
    }

    private /* synthetic */ int getCrystal() {
        AlienCrystal a;
        if (a.autoSwap.getValue() == SwapMode.Silent || a.autoSwap.getValue() == SwapMode.Normal) {
            return InventoryUtil.findItem(class_1802.field_8301);
        }
        if (a.autoSwap.getValue() == SwapMode.Inventory) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ void getCrystalPos() {
        block41 : {
            block39 : {
                block40 : {
                    var2_1 = a;
                    if (AlienCrystal.nullCheck()) {
                        var2_1.lastBreakTimer.reset();
                        var2_1.tempPos = null;
                        return;
                    }
                    v0 = var2_1;
                    if (!v0.calcDelay.passedMs((long)v0.updateDelay.getValue())) {
                        return;
                    }
                    if (var2_1.breakOnlyHasCrystal.getValue() && !AlienCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !AlienCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !var2_1.findCrystal()) {
                        var2_1.lastBreakTimer.reset();
                        var2_1.tempPos = null;
                        return;
                    }
                    v1 = var2_1;
                    var9_2 = v1.shouldReturn();
                    v1.calcDelay.reset();
                    v2 = var2_1;
                    v2.breakPos = null;
                    v2.breakDamage = 0.0f;
                    var2_1.tempPos = null;
                    var2_1.tempDamage = 0.0f;
                    var6_3 = new ArrayList();
                    var7_5 = CombatUtil.getEnemies(var2_1.targetRange.getValueFloat()).iterator();
                    while (var7_5.hasNext()) {
                        var4_6 = var7_5.next();
                        if (var4_6.field_6235 > var2_1.hurtTime.getValueInt()) continue;
                        var6_3.add(new PlayerAndPredict(var2_1, (class_1657)var4_6));
                    }
                    var7_5 = new PlayerAndPredict(var2_1, (class_1657)AlienCrystal.mc.field_1724);
                    v3 = var2_1;
                    if (!var6_3.isEmpty()) break block40;
                    v3.lastBreakTimer.reset();
                    v4 = var2_1;
                    break block41;
                }
                var4_6 = BlockUtil.getSphere((float)v3.range.getValue() + 1.0f).iterator();
                block1 : do {
                    block37 : {
                        v5 = var4_6;
                        while (v5.hasNext()) {
                            var5_10 = (class_2338)var4_6.next();
                            if (var2_1.behindWall(var5_10)) {
                                v5 = var4_6;
                                continue;
                            }
                            if (AlienCrystal.mc.field_1724.method_33571().method_1022(var5_10.method_46558().method_1031(0.0, -0.5, 0.0)) > var2_1.range.getValue()) {
                                v5 = var4_6;
                                continue;
                            }
                            if (!var2_1.canTouch(var5_10.method_10074())) {
                                v5 = var4_6;
                                continue;
                            }
                            if (!var2_1.canPlaceCrystal(var5_10, true, false)) {
                                v5 = var4_6;
                                continue;
                            }
                            break block37;
                        }
                        var4_6 = AlienCrystal.mc.field_1687.method_18112().iterator();
                        break;
                    }
                    a = var6_3.iterator();
                    block3 : do {
                        v6 = a;
                        do {
                            if (!v6.hasNext()) continue block1;
                            var3_8 = (PlayerAndPredict)a.next();
                            if (var2_1.lite.getValue() && var2_1.liteCheck(var5_10.method_46558().method_1031(0.0, -0.5, 0.0), var3_8.predict.method_19538())) {
                                v6 = a;
                                continue;
                            }
                            v7 = var2_1;
                            v8 = var3_8;
                            var8_15 = (int)v7.calculateDamage(var5_10, v8.player, v8.predict);
                            if (v7.tempPos != null && !(var8_15 > var2_1.tempDamage)) continue block3;
                            v9 = var7_5;
                            var1_7 = var2_1.calculateDamage(var5_10, v9.player, v9.predict);
                            if ((double)v10 > var2_1.maxSelf.getValue()) {
                                v6 = a;
                                continue;
                            }
                            if (var2_1.noSuicide.getValue() > 0.0 && (double)var1_7 > (double)(AlienCrystal.mc.field_1724.method_6032() + AlienCrystal.mc.field_1724.method_6067()) - var2_1.noSuicide.getValue()) {
                                v6 = a;
                                continue;
                            }
                            if (!(var8_15 < EntityUtil.getHealth((class_1297)var3_8.player))) break;
                            if ((double)var8_15 < var2_1.getDamage(var3_8.player)) {
                                v6 = a;
                                continue;
                            }
                            if (!var2_1.smart.getValue()) break;
                            if (var2_1.getDamage(var3_8.player) == var2_1.forceMin.getValue()) {
                                if (!((double)var8_15 < (double)var1_7 - 2.5)) break;
                                v6 = a;
                                continue;
                            }
                            if (!(var8_15 < var1_7)) break;
                            v6 = a;
                        } while (true);
                        v11 = var2_1;
                        v11.displayTarget = var3_8.player;
                        v11.tempPos = var5_10;
                        var2_1.tempDamage = var8_15;
                    } while (true);
                    break;
                } while (true);
                block5 : do lbl-1000: // 3 sources:
                {
                    block38 : {
                        v12 = var4_6;
                        while (v12.hasNext()) {
                            var5_12 = (class_1297)var4_6.next();
                            if (!(var5_12 instanceof class_1511)) ** GOTO lbl-1000
                            a = (class_1511)var5_12;
                            if (!AlienCrystal.mc.field_1724.method_6057((class_1297)a) && AlienCrystal.mc.field_1724.method_33571().method_1022(a.method_19538()) > var2_1.wallRange.getValue()) {
                                v12 = var4_6;
                                continue;
                            }
                            if (AlienCrystal.mc.field_1724.method_33571().method_1022(a.method_19538()) > var2_1.range.getValue()) {
                                v12 = var4_6;
                                continue;
                            }
                            break block38;
                        }
                        if (var2_1.doCrystal.getValue() && var2_1.breakPos != null && !var9_2) {
                            v13 = var2_1;
                            v13.doBreak(v13.breakPos);
                            v13.breakPos = null;
                        }
                        if (!var2_1.antiSurround.getValue() || SpeedMine.breakPos == null || !(SpeedMine.progress >= 0.9) || BlockUtil.hasEntity(SpeedMine.breakPos, false)) break block39;
                        v14 = var2_1;
                        if (v14.tempDamage <= v14.antiSurroundMax.getValueFloat()) {
                            var4_6 = var6_3.iterator();
                            break;
                        }
                        break block39;
                    }
                    var3_8 = var6_3.iterator();
                    block7 : do {
                        v15 = var3_8;
                        do {
                            if (!v15.hasNext()) continue block5;
                            var8_16 = (PlayerAndPredict)var3_8.next();
                            v16 = var2_1;
                            v17 = var8_16;
                            var1_7 = v16.calculateDamage(a.method_19538(), v17.player, v17.predict);
                            if (v16.breakPos != null && !(var1_7 > var2_1.breakDamage)) continue block7;
                            v18 = var7_5;
                            var10_17 = var2_1.calculateDamage(a.method_19538(), v18.player, v18.predict);
                            if ((double)v19 > var2_1.maxSelf.getValue()) {
                                v15 = var3_8;
                                continue;
                            }
                            if (var2_1.noSuicide.getValue() > 0.0 && (double)var10_17 > (double)(AlienCrystal.mc.field_1724.method_6032() + AlienCrystal.mc.field_1724.method_6067()) - var2_1.noSuicide.getValue()) {
                                v15 = var3_8;
                                continue;
                            }
                            if (!(var1_7 < EntityUtil.getHealth((class_1297)var8_16.player))) break;
                            if ((double)var1_7 < var2_1.getDamage(var8_16.player)) {
                                v15 = var3_8;
                                continue;
                            }
                            if (!var2_1.smart.getValue()) break;
                            if (var2_1.getDamage(var8_16.player) == var2_1.forceMin.getValue()) {
                                if (!((double)var1_7 < (double)var10_17 - 2.5)) break;
                                v15 = var3_8;
                                continue;
                            }
                            if (!(var1_7 < var10_17)) break;
                            v15 = var3_8;
                        } while (true);
                        var2_1.breakPos = new BlockPosX(a.method_19538());
                        if (!(var1_7 > var2_1.tempDamage)) continue;
                        var2_1.displayTarget = var8_16.player;
                    } while (true);
                    break;
                } while (true);
                while (var4_6.hasNext()) {
                    var5_14 = (PlayerAndPredict)var4_6.next();
                    a = class_2350.values();
                    var3_9 = ((class_2350[])a).length;
                    v20 = var8_15 = 0;
                    while (v20 < var3_9) {
                        v21 = a[var8_15];
                        var1_7 = (float)v21;
                        if (v21 != class_2350.field_11033 && var1_7 != class_2350.field_11036 && (var10_18 = new BlockPosX(var5_14.player.method_19538().method_1031(0.0, 0.5, 0.0)).method_10093((class_2350)var1_7)).equals((Object)SpeedMine.breakPos)) {
                            if (var2_1.canPlaceCrystal(var10_18.method_10093((class_2350)var1_7), false, false)) {
                                v22 = var7_5;
                                var6_4 = var2_1.calculateDamage(var10_18.method_10093((class_2350)var1_7), v22.player, v22.predict);
                                if (!(!((double)v23 < var2_1.maxSelf.getValue()) || var2_1.noSuicide.getValue() > 0.0 && (double)var6_4 > (double)(AlienCrystal.mc.field_1724.method_6032() + AlienCrystal.mc.field_1724.method_6067()) - var2_1.noSuicide.getValue())) {
                                    var2_1.tempPos = var10_18.method_10093((class_2350)var1_7);
                                    if (var2_1.doCrystal.getValue() == false) return;
                                    if (var2_1.tempPos == null) return;
                                    if (var9_2 != false) return;
                                    v24 = var2_1;
                                    v24.doCrystal(v24.tempPos);
                                    return;
                                }
                            }
                            var6_3 = class_2350.values();
                            var11_19 = var6_3.length;
                            v25 = var12_20 = 0;
                            while (v25 < var11_19) {
                                var13_21 = var6_3[var12_20];
                                if (var13_21 != class_2350.field_11033 && var13_21 != var1_7 && var2_1.canPlaceCrystal(var10_18.method_10093(var13_21), false, false)) {
                                    v26 = var7_5;
                                    var14_22 = var2_1.calculateDamage(var10_18.method_10093(var13_21), v26.player, v26.predict);
                                    if (!(!((double)v27 < var2_1.maxSelf.getValue()) || var2_1.noSuicide.getValue() > 0.0 && (double)var14_22 > (double)(AlienCrystal.mc.field_1724.method_6032() + AlienCrystal.mc.field_1724.method_6067()) - var2_1.noSuicide.getValue())) {
                                        var2_1.tempPos = var10_18.method_10093(var13_21);
                                        if (var2_1.doCrystal.getValue() == false) return;
                                        if (var2_1.tempPos == null) return;
                                        if (var9_2 != false) return;
                                        v28 = var2_1;
                                        v28.doCrystal(v28.tempPos);
                                        return;
                                    }
                                }
                                v25 = ++var12_20;
                            }
                        }
                        v20 = ++var8_15;
                    }
                }
            }
            v4 = var2_1;
        }
        if (v4.doCrystal.getValue() == false) return;
        if (var2_1.tempPos == null) return;
        if (var9_2 != false) return;
        v29 = var2_1;
        v29.doCrystal(v29.tempPos);
    }

    private /* synthetic */ void doCrystal(class_2338 class_23382) {
        AlienCrystal a = this;
        AlienCrystal a2 = class_23382;
        if (a.canPlaceCrystal((class_2338)a2, false, false)) {
            a.doPlace((class_2338)a2);
            return;
        }
        a.doBreak((class_2338)a2);
    }

    public boolean findCrystal() {
        AlienCrystal a;
        if (a.autoSwap.getValue() == SwapMode.Off) {
            return false;
        }
        return a.getCrystal() != -1;
    }

    private /* synthetic */ void updateCrystalPos() {
        AlienCrystal a;
        AlienCrystal alienCrystal = a;
        alienCrystal.getCrystalPos();
        alienCrystal.lastDamage = alienCrystal.tempDamage;
        crystalPos = alienCrystal.tempPos;
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        AlienCrystal a = class_45872;
        AlienCrystal a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
        if (!a2.onlyTick.getValue()) {
            a2.doInteract();
        }
        if (a2.displayTarget != null && !a2.noPosTimer.passedMs(500L)) {
            AlienCrystal alienCrystal = a2;
            alienCrystal.doRender((class_4587)a, mc.method_1488(), (class_1297)alienCrystal.displayTarget, a2.mode.getValue());
        }
    }

    private /* synthetic */ void doBreak(class_2338 class_23382) {
        AlienCrystal a;
        AlienCrystal a2 = class_23382;
        AlienCrystal alienCrystal = a = this;
        alienCrystal.noPosTimer.reset();
        if (!alienCrystal.breakSetting.getValue()) {
            return;
        }
        if (a.displayTarget != null && a.displayTarget.field_6235 > a.waitHurt.getValueInt()) {
            AlienCrystal alienCrystal2 = a;
            if (!alienCrystal2.syncTimer.passed(alienCrystal2.syncTimeout.getValue())) {
                return;
            }
        }
        AlienCrystal alienCrystal3 = a;
        alienCrystal3.lastBreakTimer.reset();
        if (!alienCrystal3.switchTimer.passedMs((long)a.switchCooldown.getValue())) {
            return;
        }
        a.syncTimer.reset();
        Iterator<class_1511> iterator = BlockUtil.getEndCrystals(new class_238((double)a2.method_10263(), (double)a2.method_10264(), (double)a2.method_10260(), (double)(a2.method_10263() + 1), (double)(a2.method_10264() + 2), (double)(a2.method_10260() + 1))).iterator();
        Iterator<class_1511> iterator2 = iterator;
        while (iterator2.hasNext()) {
            class_1511 class_15112 = iterator.next();
            if (class_15112.field_6012 < a.minAge.getValueInt()) {
                iterator2 = iterator;
                continue;
            }
            if (a.rotate.getValue() && a.onBreak.getValue() && !a.faceVector(class_15112.method_19538().method_1031(0.0, a.yOffset.getValue(), 0.0))) {
                return;
            }
            if (!CombatUtil.breakTimer.passedMs((long)a.breakDelay.getValue())) {
                return;
            }
            AlienCrystal alienCrystal4 = a;
            alienCrystal4.animation.to = 1.0;
            alienCrystal4.animation.from = 1.0;
            CombatUtil.breakTimer.reset();
            a.syncPos = a2;
            mc.method_1562().method_52787((class_2596)class_2824.method_34206((class_1297)class_15112, (boolean)AlienCrystal.mc.field_1724.method_5715()));
            AlienCrystal.mc.field_1724.method_7350();
            EntityUtil.swingHand(class_1268.field_5808, a.swingMode.getValue());
            if (a.breakRemove.getValue()) {
                AlienCrystal.mc.field_1687.method_2945(class_15112.method_5628(), class_1297.class_5529.field_26998);
            }
            if (crystalPos != null && a.displayTarget != null) {
                AlienCrystal alienCrystal5 = a;
                if ((double)a.lastDamage >= alienCrystal5.getDamage(alienCrystal5.displayTarget) && a.afterBreak.getValue() && (!a.yawStep.getValue() || !a.checkFov.getValue() || Hana.ROTATE.inFov(class_15112.method_19538(), a.fov.getValueFloat()))) {
                    a.doPlace(crystalPos);
                }
            }
            if (a.forceWeb.getValue() && AutoWebPuls.INSTANCE.isOn()) {
                AutoWebPuls.place = true;
                WebAura.place = true;
            }
            if (a.rotate.getValue() && !a.yawStep.getValue() && CombatSetting.INSTANCE.rotateSync.getValue()) {
                Hana.ROTATE.snapBack();
            }
            return;
        }
    }

    @Override
    public String getInfo() {
        AlienCrystal a;
        if (a.displayTarget != null && a.lastDamage > 0.0f) {
            AlienCrystal alienCrystal = a;
            return alienCrystal.df.format(alienCrystal.lastDamage);
        }
        return null;
    }

    private /* synthetic */ void doPlace(class_2338 a) {
        AlienCrystal a22;
        AlienCrystal alienCrystal;
        AlienCrystal alienCrystal2 = alienCrystal = a22;
        alienCrystal2.noPosTimer.reset();
        if (!alienCrystal2.place.getValue()) {
            return;
        }
        if (!(AlienCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || AlienCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) || alienCrystal.findCrystal())) {
            return;
        }
        if (!alienCrystal.canTouch(a.method_10074())) {
            return;
        }
        class_2338 class_23382 = a.method_10074();
        class_2350 class_23502 = BlockUtil.getClickSide(class_23382);
        a22 = class_23382.method_46558().method_1031((double)class_23502.method_10163().method_10263() * 0.5, (double)class_23502.method_10163().method_10264() * 0.5, (double)class_23502.method_10163().method_10260() * 0.5);
        if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033) {
            a22 = a22.method_1031(0.0, 0.45, 0.0);
        }
        if (alienCrystal.rotate.getValue() && !alienCrystal.faceVector((class_243)a22)) {
            return;
        }
        AlienCrystal alienCrystal3 = alienCrystal;
        if (!alienCrystal3.placeTimer.passedMs((long)alienCrystal3.placeDelay.getValue())) {
            return;
        }
        if (AlienCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || AlienCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301)) {
            alienCrystal.placeTimer.reset();
            alienCrystal.syncPos = a;
            alienCrystal.placeCrystal(a);
            return;
        }
        alienCrystal.placeTimer.reset();
        alienCrystal.syncPos = a;
        int n = AlienCrystal.mc.field_1724.method_31548().field_7545;
        int a22 = alienCrystal.getCrystal();
        if (a22 == -1) {
            return;
        }
        AlienCrystal alienCrystal4 = alienCrystal;
        alienCrystal4.doSwap(a22);
        alienCrystal4.placeCrystal(a);
        if (alienCrystal.autoSwap.getValue() == SwapMode.Silent) {
            alienCrystal.doSwap(n);
            return;
        }
        if (alienCrystal.autoSwap.getValue() == SwapMode.Inventory) {
            alienCrystal.doSwap(a22);
            EntityUtil.syncInventory();
        }
    }

    private /* synthetic */ boolean canTouch(class_2338 a) {
        AlienCrystal a2;
        AlienCrystal alienCrystal = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(AlienCrystal.mc.field_1724.method_33571()) <= alienCrystal.range.getValue()) {
                return true;
            }
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public void doRender(class_4587 var1_1, float var2_2, class_1297 var3_3, TargetESP var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 1[CASE]
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
    public float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        AlienCrystal a3 = class_23382;
        AlienCrystal a4 = this;
        return a4.calculateDamage(new class_243((double)a3.method_10263() + 0.5, (double)a3.method_10264(), (double)a3.method_10260() + 0.5), (class_1657)a, (class_1657)a2);
    }

    private static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Rotation;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Interact;
        public static final /* enum */ Page Render;
        public static final /* enum */ Page Misc;

        static {
            General = new Page(Alt.ALLATORIxDEMO(":s\"u8s$"), 0);
            Interact = new Page(GaussianKernel.ALLATORIxDEMO("$\u0011(+();>"), 1);
            Misc = new Page(Alt.ALLATORIxDEMO("]#a+"), 2);
            Rotation = new Page(GaussianKernel.ALLATORIxDEMO("?\u0010(/.!7$"), 3);
            Calc = new Page(Alt.ALLATORIxDEMO("S+~+"), 4);
            Render = new Page(GaussianKernel.ALLATORIxDEMO("\u000e+4,=8"), 5);
            $VALUES = Page.$values();
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

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[6];
            arrpage[0] = General;
            arrpage[1] = Interact;
            arrpage[2] = Misc;
            arrpage[3] = Rotation;
            arrpage[4] = Calc;
            arrpage[5] = Render;
            return arrpage;
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

    private static final class SwapMode
    extends Enum<SwapMode> {
        private static final /* synthetic */ SwapMode[] $VALUES;
        public static final /* enum */ SwapMode Silent;
        public static final /* enum */ SwapMode Inventory;
        public static final /* enum */ SwapMode Off;
        public static final /* enum */ SwapMode Normal;

        private static /* synthetic */ SwapMode[] $values() {
            SwapMode[] arrswapMode = new SwapMode[4];
            arrswapMode[0] = Off;
            arrswapMode[1] = Normal;
            arrswapMode[2] = Silent;
            arrswapMode[3] = Inventory;
            return arrswapMode;
        }

        static {
            Off = new SwapMode(Tab.ALLATORIxDEMO(">>]"), 0);
            Normal = new SwapMode(ObsidianHelper.ALLATORIxDEMO("m'Z.H."), 1);
            Silent = new SwapMode(Tab.ALLATORIxDEMO("\\\u0005~\u00146O"), 2);
            Inventory = new SwapMode(ObsidianHelper.ALLATORIxDEMO("\u001eo\u001cF&\\,[;"), 3);
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

        public static SwapMode[] values() {
            return (SwapMode[])$VALUES.clone();
        }

        public static SwapMode valueOf(String a) {
            return Enum.valueOf(SwapMode.class, a);
        }
    }

    public static final class TargetESP
    extends Enum<TargetESP> {
        private static final /* synthetic */ TargetESP[] $VALUES;
        public static final /* enum */ TargetESP None;
        public static final /* enum */ TargetESP Box;
        public static final /* enum */ TargetESP Jello;

        public static TargetESP valueOf(String a) {
            return Enum.valueOf(TargetESP.class, a);
        }

        static {
            Box = new TargetESP(Hole.ALLATORIxDEMO("XF("), 0);
            Jello = new TargetESP(GaussianKernel.ALLATORIxDEMO(" \u000b\u0010\u0001\u0010"), 1);
            None = new TargetESP(Hole.ALLATORIxDEMO("-uG5"), 2);
            $VALUES = TargetESP.$values();
        }

        public static TargetESP[] values() {
            return (TargetESP[])$VALUES.clone();
        }

        private static /* synthetic */ TargetESP[] $values() {
            TargetESP[] arrtargetESP = new TargetESP[3];
            arrtargetESP[0] = Box;
            arrtargetESP[1] = Jello;
            arrtargetESP[2] = None;
            return arrtargetESP;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ TargetESP() {
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

    private class CrystalRender {
        final /* synthetic */ AlienCrystal this$0;

        private /* synthetic */ CrystalRender(AlienCrystal object) {
            Object a = object;
            object = this;
            ((CrystalRender)object).this$0 = a;
            object();
        }

        @EventHandler
        public void onRender3D(Render3DEvent a) {
            CrystalRender crystalRender;
            CrystalRender a2;
            CrystalRender crystalRender2;
            CrystalRender crystalRender3 = a2;
            Object object = a2 = crystalRender3.this$0.sync.getValue() && crystalPos != null ? crystalRender3.this$0.syncPos : crystalPos;
            if (a2 != null) {
                crystalRender3.this$0.placeVec3d = a2.method_10074().method_46558();
            }
            if (crystalRender3.this$0.placeVec3d == null) {
                return;
            }
            if (crystalRender3.this$0.fadeSpeed.getValue() >= 1.0) {
                crystalRender3.this$0.currentFade = crystalRender3.this$0.noPosTimer.passedMs((long)(crystalRender3.this$0.startFadeTime.getValue() * 1000.0)) ? 0.0 : 0.5;
                crystalRender2 = crystalRender3;
            } else {
                double d;
                CrystalRender crystalRender4;
                if (crystalRender3.this$0.noPosTimer.passedMs((long)(crystalRender3.this$0.startFadeTime.getValue() * 1000.0))) {
                    d = 0.0;
                    crystalRender4 = crystalRender3;
                } else {
                    d = 0.5;
                    crystalRender4 = crystalRender3;
                }
                crystalRender3.this$0.currentFade = AnimateUtil.animate(crystalRender3.this$0.currentFade, d, crystalRender4.this$0.fadeSpeed.getValue() / 10.0);
                crystalRender2 = crystalRender3;
            }
            if (crystalRender2.this$0.currentFade == 0.0) {
                crystalRender3.this$0.curVec3d = null;
                return;
            }
            if (crystalRender3.this$0.curVec3d == null || crystalRender3.this$0.sliderSpeed.getValue() >= 1.0) {
                CrystalRender crystalRender5 = crystalRender3;
                crystalRender = crystalRender5;
                crystalRender5.this$0.curVec3d = crystalRender5.this$0.placeVec3d;
            } else {
                crystalRender = crystalRender3;
                crystalRender3.this$0.curVec3d = new class_243(AnimateUtil.animate(crystalRender3.this$0.curVec3d.field_1352, crystalRender3.this$0.placeVec3d.field_1352, crystalRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(crystalRender3.this$0.curVec3d.field_1351, crystalRender3.this$0.placeVec3d.field_1351, crystalRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(crystalRender3.this$0.curVec3d.field_1350, crystalRender3.this$0.placeVec3d.field_1350, crystalRender3.this$0.sliderSpeed.getValue() / 10.0));
            }
            if (crystalRender.this$0.render.getValue()) {
                Render3DEvent render3DEvent;
                CrystalRender crystalRender6 = a2 = new class_238(crystalRender3.this$0.curVec3d, crystalRender3.this$0.curVec3d);
                if (crystalRender3.this$0.shrink.getValue()) {
                    a2 = crystalRender6.method_1014(crystalRender3.this$0.currentFade);
                    render3DEvent = a;
                } else {
                    a2 = crystalRender6.method_1014(0.5);
                    render3DEvent = a;
                }
                a = render3DEvent.getMatrixStack();
                if (crystalRender3.this$0.fill.booleanValue) {
                    Render3DUtil.drawFill((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(crystalRender3.this$0.fill.getValue(), (int)((double)crystalRender3.this$0.fill.getValue().getAlpha() * crystalRender3.this$0.currentFade * 2.0)));
                }
                if (crystalRender3.this$0.box.booleanValue) {
                    Render3DUtil.drawLine((class_238)a2, ColorUtil.injectAlpha(crystalRender3.this$0.box.getValue(), (int)((double)crystalRender3.this$0.box.getValue().getAlpha() * crystalRender3.this$0.currentFade * 2.0)), crystalRender3.this$0.lineWidth.getValueInt());
                }
            }
            if (crystalRender3.this$0.text.booleanValue && crystalRender3.this$0.lastDamage > 0.0f && !crystalRender3.this$0.noPosTimer.passedMs((long)(crystalRender3.this$0.startFadeTime.getValue() * 1000.0))) {
                Render3DUtil.drawText3D(crystalRender3.this$0.df.format(crystalRender3.this$0.lastDamage), crystalRender3.this$0.curVec3d, crystalRender3.this$0.text.getValue());
            }
        }
    }

    private class PlayerAndPredict {
        final class_1657 predict;
        final class_1657 player;
        final /* synthetic */ AlienCrystal this$0;

        private /* synthetic */ PlayerAndPredict(AlienCrystal object, class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.this$0 = object;
            a2.player = a;
            if (((AlienCrystal)object).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(PacketBuffer.ALLATORIxDEMO("A&\u000ejx\u001aA&W,P6J4\\:i\u000fX$I.}\u0001_8I,I+J#N)_8")), Snow.ALLATORIxDEMO("W~V\\xyrHixcuy8$%")), (AlienCrystal)object, (class_1657)a){
                    final /* synthetic */ AlienCrystal val$this$0;
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ class_1657 val$player;

                    public boolean method_7325() {
                        return false;
                    }

                    public boolean method_7337() {
                        return false;
                    }

                    public boolean method_24828() {
                        1 a;
                        return a.val$player.method_24828();
                    }
                    {
                        1 a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        void a6;
                        1 v0 = this_;
                        1 this_ = class_16572;
                        class_1657 class_16573 = class_16572 = v0;
                        class_16573.this$1 = a2;
                        class_16573.val$this$0 = alienCrystal;
                        class_16572.val$player = a;
                        class_16572((class_1937)a5, (class_2338)a6, (float)a4, (GameProfile)a3);
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, ((AlienCrystal)object).predictTicks.getValueInt(), true)));
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
