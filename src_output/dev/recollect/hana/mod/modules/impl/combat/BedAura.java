/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1748
 *  net.minecraft.class_1937
 *  net.minecraft.class_2244
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_5321
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.ClientInfo;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.video.FileUtil;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1748;
import net.minecraft.class_1937;
import net.minecraft.class_2244;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_5321;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

@Beta
public class BedAura
extends Module {
    private final Timer placeTimer;
    private final FadeUtils animation;
    private class_238 nowBB;
    private final SliderSetting outlineAlpha;
    private final Timer noPosTimer;
    public static BedAura INSTANCE;
    private final BooleanSetting outline;
    public final EnumSetting<Page> page;
    private final SliderSetting fadeTime;
    private final BooleanSetting noUsing;
    private class_2338 renderPos;
    private final FadeUtils fadeUtils;
    public class_243 directionVec;
    private final SliderSetting breakDelay;
    private final BooleanSetting yawDeceive;
    private final Timer delayTimer;
    private final BooleanSetting checkLook;
    private final BooleanSetting shrink;
    private class_238 lastBB;
    private class_1657 displayTarget;
    private final SliderSetting antiSuicide;
    private final SliderSetting animationTime;
    private final Timer calcTimer;
    private final SliderSetting fov;
    private final SliderSetting boxAlpha;
    private final BooleanSetting reset;
    private final ColorSetting color;
    public static class_2338 placePos;
    public final EnumSetting<Mode> mode;
    private final BooleanSetting random;
    private final SliderSetting placeDelay;
    private final BooleanSetting newRotate;
    private final SliderSetting updateDelay;
    private final SliderSetting targetRange;
    private final SliderSetting calcDelay;
    private final BooleanSetting breakOnlyHasCrystal;
    private final SliderSetting yawStep;
    private float lastPitch;
    private final SliderSetting startFadeTime;
    private final SliderSetting range;
    private final SliderSetting placeMaxSelf;
    private final BooleanSetting smart;
    private final BooleanSetting inventorySwap;
    private float lastYaw;
    private final BooleanSetting sync;
    private final BooleanSetting rotate;
    private final BooleanSetting box;
    private final BooleanSetting checkMine;
    private final Timer breakTimer;
    private final BooleanSetting Break;
    private final SliderSetting predictTicks;
    public float lastDamage;
    private final BooleanSetting terrainIgnore;
    double lastSize;
    private final BooleanSetting place;
    private final EnumSetting<SwingSide> swingMode;
    private final EnumSetting<AnchorAura.CalcMode> calcMode;
    private final SliderSetting placeMinDamage;
    private final BooleanSetting render;

    private /* synthetic */ void animUpdate() {
        BedAura a;
        BedAura bedAura = a;
        bedAura.fadeUtils.setLength((long)(bedAura.fadeTime.getValue() * 1000.0));
        if (placePos != null) {
            a.lastBB = new class_238(placePos);
            a.noPosTimer.reset();
            if (a.nowBB == null) {
                a.nowBB = a.lastBB;
            }
            if (a.renderPos == null || !a.renderPos.equals((Object)placePos)) {
                BedAura bedAura2 = a;
                bedAura2.animation.setLength(bedAura2.animationTime.getValue() * 1000.0 <= 0.0 ? 0L : (long)(Math.abs(a.nowBB.field_1323 - a.lastBB.field_1323) + Math.abs(a.nowBB.field_1322 - a.lastBB.field_1322) + Math.abs(a.nowBB.field_1321 - a.lastBB.field_1321) <= 5.0 ? (double)((long)((Math.abs(a.nowBB.field_1323 - a.lastBB.field_1323) + Math.abs(a.nowBB.field_1322 - a.lastBB.field_1322) + Math.abs(a.nowBB.field_1321 - a.lastBB.field_1321)) * (a.animationTime.getValue() * 1000.0))) : a.animationTime.getValue() * 5000.0));
                a.animation.reset();
                a.renderPos = placePos;
            }
        }
        BedAura bedAura3 = a;
        if (!bedAura3.noPosTimer.passedMs((long)(bedAura3.startFadeTime.getValue() * 1000.0))) {
            a.fadeUtils.reset();
        }
        BedAura bedAura4 = a;
        double d = bedAura4.animation.easeOutQuad();
        if (bedAura4.nowBB != null && a.lastBB != null) {
            if (Math.abs(a.nowBB.field_1323 - a.lastBB.field_1323) + Math.abs(a.nowBB.field_1322 - a.lastBB.field_1322) + Math.abs(a.nowBB.field_1321 - a.lastBB.field_1321) > 16.0) {
                a.nowBB = a.lastBB;
            }
            if (a.lastSize != d) {
                BedAura bedAura5 = a;
                bedAura5.nowBB = new class_238(a.nowBB.field_1323 + (a.lastBB.field_1323 - a.nowBB.field_1323) * d, a.nowBB.field_1322 + (a.lastBB.field_1322 - a.nowBB.field_1322) * d, a.nowBB.field_1321 + (a.lastBB.field_1321 - a.nowBB.field_1321) * d, a.nowBB.field_1320 + (a.lastBB.field_1320 - a.nowBB.field_1320) * d, a.nowBB.field_1325 + (a.lastBB.field_1325 - a.nowBB.field_1325) * d, a.nowBB.field_1324 + (a.lastBB.field_1324 - a.nowBB.field_1324) * d);
                bedAura5.lastSize = d;
            }
        }
    }

    @Override
    public void onUpdate() {
        BedAura a;
        a.update();
    }

    private /* synthetic */ void update() {
        Iterator a;
        BedAura bedAura = a;
        if (BedAura.nullCheck()) {
            return;
        }
        BedAura bedAura2 = bedAura;
        bedAura2.animUpdate();
        if (!bedAura2.delayTimer.passedMs((long)bedAura.updateDelay.getValue())) {
            return;
        }
        if (bedAura.noUsing.getValue() && EntityUtil.isUsing()) {
            placePos = null;
            return;
        }
        if (BedAura.mc.field_1724.method_5715()) {
            placePos = null;
            return;
        }
        if (BedAura.mc.field_1687.method_27983().equals((Object)class_1937.field_25179)) {
            placePos = null;
            return;
        }
        if (bedAura.breakOnlyHasCrystal.getValue() && bedAura.getBed() == -1) {
            placePos = null;
            return;
        }
        BedAura bedAura3 = bedAura;
        bedAura3.delayTimer.reset();
        if (bedAura3.calcTimer.passedMs(bedAura.calcDelay.getValueInt())) {
            Object object;
            bedAura.calcTimer.reset();
            placePos = null;
            bedAura.lastDamage = 0.0f;
            ArrayList<PlayerAndPredict> arrayList = new ArrayList<PlayerAndPredict>();
            Object object2 = CombatUtil.getEnemies(bedAura.targetRange.getRange()).iterator();
            Iterator<class_1657> iterator = object2;
            while (iterator.hasNext()) {
                object = object2.next();
                iterator = object2;
                arrayList.add(new PlayerAndPredict(bedAura, (class_1657)object));
            }
            object2 = new PlayerAndPredict(bedAura, (class_1657)BedAura.mc.field_1724);
            object = BlockUtil.getSphere((float)bedAura.range.getValue()).iterator();
            block1 : do {
                Object object3 = object;
                while (object3.hasNext()) {
                    class_2338 class_23382 = (class_2338)object.next();
                    if (!bedAura.canPlaceBed(class_23382) && !(BlockUtil.getBlock(class_23382) instanceof class_2244)) {
                        object3 = object;
                        continue;
                    }
                    a = arrayList.iterator();
                    do {
                        PlayerAndPredict playerAndPredict;
                        float f;
                        Iterator iterator2 = a;
                        do {
                            float f2;
                            if (!iterator2.hasNext()) continue block1;
                            playerAndPredict = (PlayerAndPredict)a.next();
                            BedAura bedAura4 = bedAura;
                            PlayerAndPredict playerAndPredict2 = playerAndPredict;
                            f = bedAura4.calculateDamage(class_23382, playerAndPredict2.player, playerAndPredict2.predict);
                            Object object4 = object2;
                            float f3 = bedAura4.calculateDamage(class_23382, ((PlayerAndPredict)object4).player, ((PlayerAndPredict)object4).predict);
                            if ((double)f2 > bedAura.placeMaxSelf.getValue()) {
                                iterator2 = a;
                                continue;
                            }
                            if (bedAura.antiSuicide.getValue() > 0.0 && (double)f3 > (double)(BedAura.mc.field_1724.method_6032() + BedAura.mc.field_1724.method_6067()) - bedAura.antiSuicide.getValue()) {
                                iterator2 = a;
                                continue;
                            }
                            if (!(f < EntityUtil.getHealth((class_1297)playerAndPredict.player))) break;
                            if (f < bedAura.placeMinDamage.getValueFloat()) {
                                iterator2 = a;
                                continue;
                            }
                            if (!bedAura.smart.getValue() || !(f < f3)) break;
                            iterator2 = a;
                        } while (true);
                        if (placePos != null && !(f > bedAura.lastDamage)) continue;
                        bedAura.displayTarget = playerAndPredict.player;
                        placePos = class_23382;
                        bedAura.lastDamage = f;
                    } while (true);
                }
                break;
            } while (true);
        }
        if (placePos != null) {
            bedAura.doBed(placePos);
        }
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (placePos != null && arrf.newRotate.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.yawStep.getValueFloat());
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

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        BedAura a3 = this;
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
            float f4 = class_3532.method_15393((float)(a[0] - a3.lastYaw));
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
     * Exception decompiling
     */
    public float calculateDamage(class_243 var1_1, class_1657 var2_2, class_1657 var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[DOLOOP]], but top level block is 1[CASE]
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

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        BedAura a2 = this;
        a2.update();
    }

    @Override
    public void onEnable() {
        BedAura a;
        BedAura bedAura = a;
        bedAura.lastYaw = Hana.ROTATE.lastYaw;
        bedAura.lastPitch = Hana.ROTATE.lastPitch;
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        BedAura a222 = class_23382;
        BedAura a3 = this;
        CombatUtil.modifyPos = a222;
        CombatUtil.modifyBlockState = class_2246.field_10124.method_9564();
        float a222 = a3.calculateDamage(CombatUtil.modifyPos.method_46558(), (class_1657)a2, (class_1657)a);
        CombatUtil.modifyPos = null;
        return a222;
    }

    private /* synthetic */ void doBreak(class_2338 class_23382) {
        BedAura a = class_23382;
        BedAura a2 = this;
        if (!a2.Break.getValue()) {
            return;
        }
        if (BedAura.mc.field_1687.method_8320((class_2338)a).method_26204() instanceof class_2244) {
            class_2350 class_23502 = BlockUtil.getClickSide((class_2338)a);
            class_243 class_2432 = new class_243((double)a.method_10263() + 0.5 + (double)class_23502.method_10163().method_10263() * 0.5, (double)a.method_10264() + 0.5 + (double)class_23502.method_10163().method_10264() * 0.5, (double)a.method_10260() + 0.5 + (double)class_23502.method_10163().method_10260() * 0.5);
            if (a2.rotate.getValue() && !a2.faceVector(class_2432)) {
                return;
            }
            BedAura bedAura = a2;
            if (!bedAura.breakTimer.passedMs((long)bedAura.breakDelay.getValue())) {
                return;
            }
            a2.breakTimer.reset();
            EntityUtil.swingHand(class_1268.field_5808, a2.swingMode.getValue());
            a = new class_3965(class_2432, class_23502, (class_2338)a, false);
            BedAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a, BlockUtil.getWorldActionId(BedAura.mc.field_1687)));
        }
    }

    public boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.newRotate.getValue()) {
            EntityUtil.faceVector((class_243)a);
            return true;
        }
        a2.directionVec = a;
        a = EntityUtil.getLegitRotations((class_243)a);
        if (Math.abs(class_3532.method_15393((float)(arrf[0] - a2.lastYaw))) < a2.fov.getValueFloat() && Math.abs(class_3532.method_15393((float)(a[1] - a2.lastPitch))) < a2.fov.getValueFloat()) {
            if (a2.sync.getValue()) {
                EntityUtil.sendYawAndPitch(a[0], a[1]);
            }
            return true;
        }
        return !a2.checkLook.getValue();
    }

    private /* synthetic */ void doPlace(class_2338 class_23382) {
        class_2350 class_23502;
        class_2350 class_23503;
        class_243 class_2432;
        int n;
        BedAura a;
        int n2;
        BedAura a2;
        block10 : {
            int n3;
            a = class_23382;
            a2 = this;
            if (!a2.place.getValue()) {
                return;
            }
            n2 = a2.getBed();
            if (n2 == -1) {
                placePos = null;
                return;
            }
            n = BedAura.mc.field_1724.method_31548().field_7545;
            class_23502 = null;
            class_2432 = class_2350.values();
            int n4 = ((class_2350[])class_2432).length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                class_2350 class_23504 = class_2432[n3];
                if (class_23504 != class_2350.field_11036 && class_23504 != class_2350.field_11033 && BlockUtil.clientCanPlace(a.method_10093(class_23504), false) && BlockUtil.canClick(a.method_10093(class_23504).method_10074()) && (!a2.checkMine.getValue() || !BlockUtil.isMining(a.method_10093(class_23504)))) {
                    class_23503 = class_23502 = class_23504;
                    break block10;
                }
                n5 = ++n3;
            }
            class_23503 = class_23502;
        }
        if (class_23503 != null) {
            class_2432 = new class_243((double)a.method_10263() + 0.5 + (double)class_2350.field_11036.method_10163().method_10263() * 0.5, (double)a.method_10264() + 0.5 + (double)class_2350.field_11036.method_10163().method_10264() * 0.5, (double)a.method_10260() + 0.5 + (double)class_2350.field_11036.method_10163().method_10260() * 0.5);
            if (a2.rotate.getValue() && !a2.faceVector(class_2432)) {
                return;
            }
            BedAura bedAura = a2;
            if (!bedAura.placeTimer.passedMs((long)bedAura.placeDelay.getValue())) {
                return;
            }
            BedAura bedAura2 = a2;
            bedAura2.placeTimer.reset();
            a2.doSwap(n2);
            if (bedAura2.yawDeceive.getValue()) {
                HoleKick.pistonFacing(class_23502.method_10153());
            }
            BlockUtil.clickBlock(a.method_10093(class_23502).method_10074(), class_2350.field_11036, false);
            if (a2.rotate.getValue() && a2.sync.getValue()) {
                EntityUtil.faceVector(class_2432);
            }
            BedAura bedAura3 = a2;
            if (a2.inventorySwap.getValue()) {
                bedAura3.doSwap(n2);
                EntityUtil.syncInventory();
                return;
            }
            bedAura3.doSwap(n);
        }
    }

    @Override
    public String getInfo() {
        BedAura a;
        if (a.displayTarget != null && placePos != null) {
            return a.displayTarget.method_5477().getString();
        }
        return super.getInfo();
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        BedAura a2 = this;
        if (a2.inventorySwap.getValue()) {
            InventoryUtil.inventorySwap(a, BedAura.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isTrueFacing(class_2338 class_23382, class_2350 class_23502) {
        void a;
        BedAura a2 = class_23502;
        BedAura a3 = this;
        if (a3.yawDeceive.getValue()) {
            return true;
        }
        return class_2350.method_10150((double)EntityUtil.getLegitRotations(a.method_46558().method_1019(new class_243(0.0, -0.5, 0.0)))[0]) == a2;
    }

    public int getBed() {
        BedAura a;
        if (a.inventorySwap.getValue()) {
            return InventoryUtil.findClassInventorySlot(class_1748.class);
        }
        return InventoryUtil.findClass(class_1748.class);
    }

    public BedAura() {
        BedAura a;
        BedAura bedAura = a;
        super(ClientInfo.ALLATORIxDEMO("\u000bf*_&&x"), Module.Category.Combat);
        BedAura bedAura2 = a;
        bedAura2.page = bedAura.add(new EnumSetting<Page>(Snow.ALLATORIxDEMO("C&g1"), Page.General));
        bedAura.mode = bedAura.add(new EnumSetting<Mode>(ClientInfo.ALLATORIxDEMO("A+z\u001e;}"), Mode.NullPoint));
        bedAura.yawDeceive = bedAura.add(new BooleanSetting(Snow.ALLATORIxDEMO("\\0W0q#v.v1"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.checkMine = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\u0012~w+g=N'p::~"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noUsing = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u0015d%I\u001as\u0010r2s1"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.calcMode = a.add(new EnumSetting<AnchorAura.CalcMode>(ClientInfo.ALLATORIxDEMO("G(o-S<0|"), AnchorAura.CalcMode.OyVey, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(Snow.ALLATORIxDEMO("\u0013d.n3"), SwingSide.Server, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.antiSuicide = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("Zm:m\u001av'}:0|"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(Snow.ALLATORIxDEMO("\u0004d#G\u0011`\u0012r)g1"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.updateDelay = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("Ns*e=f\n{?5`"), 50, 0, 1000, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.calcDelay = a.add(new SliderSetting(Snow.ALLATORIxDEMO("\u0012A\u0018w\u0004v+a-"), 200, 0, 1000, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventorySwap = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\u000f8mf p&q7M$5i"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("F/g&t1"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\u0000a>Q!j2 |"), false, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(Snow.ALLATORIxDEMO("-u7@3e$"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("Q/p7;t"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.sync = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("@>n7"), false, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\rl,`%R<;r"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(Snow.ALLATORIxDEMO("\u0001o\""), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.place = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\u001er27|"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.placeDelay = a.add(new SliderSetting(Snow.ALLATORIxDEMO("U=A\u0017q\u0004v+a-"), 300, 0, 1000, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc && a2.place.getValue();
        }));
        a.Break = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\fl65r"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.breakDelay = a.add(new SliderSetting(Snow.ALLATORIxDEMO("G#E\u0015\u0004v+a-"), 300, 0, 1000, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc && a2.Break.getValue();
        }));
        a.range = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u001c=3|"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.placeMinDamage = a.add(new SliderSetting(Snow.ALLATORIxDEMO("\u001cI\u001aP!~&g1"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.placeMaxSelf = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u000b7cP+h/G/s23|"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.smart = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u0013~&r "), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("L h0K/m\u00111}"), false, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Calc && a2.Break.getValue();
        }));
        a.render = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("F%}#e&"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.shrink = a.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("P&l::r"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.outline = a.add(new BooleanSetting(Snow.ALLATORIxDEMO(";a4.n1"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setParent());
        a.outlineAlpha = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u0019nw\"m'f\u000fr#<x"), 150, 0, 255, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.outline.isOpen() && a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u0005o,"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setParent());
        a.boxAlpha = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("F&{\u000fr#<x"), 70, 0, 255, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.box.isOpen() && a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.reset = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u0012v4e "), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.color = a.add(new ColorSetting(ClientInfo.ALLATORIxDEMO("\rq?;k"), new Color(255, 255, 255), object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.animationTime = a.add(new SliderSetting(Snow.ALLATORIxDEMO("6j9h0T\u001d{.G.m1"), 2.0, 0.0, 8.0, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u0015\"zq:B(g+J:9|"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.fadeTime = a.add(new SliderSetting(Snow.ALLATORIxDEMO("f\u0015p%G.m1"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.predictTicks = a.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u0006if*m*w\u001aw0?j"), 4, 0, 10, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Predict;
        }));
        a.terrainIgnore = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("#a\"w0I\u001a]'}(r1"), true, object -> {
            Object a = object;
            BedAura a2 = this;
            return a2.page.getValue() == Page.Predict;
        }));
        BedAura bedAura3 = a;
        BedAura bedAura4 = a;
        BedAura bedAura5 = a;
        BedAura bedAura6 = a;
        BedAura bedAura7 = a;
        bedAura7.delayTimer = new Timer();
        bedAura7.calcTimer = new Timer();
        bedAura7.breakTimer = new Timer();
        bedAura7.placeTimer = new Timer();
        bedAura7.noPosTimer = new Timer();
        bedAura7.fadeUtils = new FadeUtils(500L);
        bedAura7.animation = new FadeUtils(500L);
        bedAura6.lastSize = 0.0;
        bedAura6.lastYaw = 0.0f;
        bedAura5.lastPitch = 0.0f;
        bedAura5.directionVec = null;
        bedAura4.renderPos = null;
        bedAura4.lastBB = null;
        bedAura3.nowBB = null;
        bedAura3.setChinese(ClientInfo.ALLATORIxDEMO("\u5ed9\u511d\u73b6"));
        INSTANCE = bedAura3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        double d;
        BedAura a;
        float a22 = f;
        BedAura bedAura = a = this;
        bedAura.update();
        double d2 = d = bedAura.noPosTimer.passedMs(a.startFadeTime.getValue() * 1000.0) ? a.fadeUtils.easeOutQuad() : 0.0;
        if (a.nowBB != null && a.render.getValue() && d < 1.0) {
            void a3;
            BedAura bedAura2 = a;
            class_238 a22 = bedAura2.nowBB;
            if (bedAura2.shrink.getValue()) {
                a22 = a.nowBB.method_1002(d * 0.5, d * 0.5, d * 0.5);
                a22 = a22.method_1002(-d * 0.5, -d * 0.5, -d * 0.5);
            }
            if (a.box.getValue()) {
                Render3DUtil.drawFill((class_4587)a3, a22, ColorUtil.injectAlpha(a.color.getValue(), (int)(a.boxAlpha.getValue() * Math.abs(d - 1.0))));
            }
            if (a.outline.getValue()) {
                Render3DUtil.drawBox((class_4587)a3, a22, ColorUtil.injectAlpha(a.color.getValue(), (int)(a.outlineAlpha.getValue() * Math.abs(d - 1.0))));
                return;
            }
        } else if (a.reset.getValue()) {
            a.nowBB = null;
        }
    }

    private /* synthetic */ boolean canPlaceBed(class_2338 a) {
        BedAura a2;
        BedAura bedAura = a2;
        if (!(!BlockUtil.canReplace(a) || bedAura.checkMine.getValue() && BlockUtil.isMining(a))) {
            int n;
            class_2350[] arrclass_2350 = class_2350.values();
            int n2 = arrclass_2350.length;
            int n3 = n = 0;
            while (n3 < n2) {
                a2 = arrclass_2350[n];
                if (a2 != class_2350.field_11036 && a2 != class_2350.field_11033 && BlockUtil.isStrictDirection(a.method_10093((class_2350)a2).method_10074(), class_2350.field_11036) && bedAura.isTrueFacing(a.method_10093((class_2350)a2), a2.method_10153()) && BlockUtil.clientCanPlace(a.method_10093((class_2350)a2), false) && BlockUtil.canClick(a.method_10093((class_2350)a2).method_10074()) && (!bedAura.checkMine.getValue() || !BlockUtil.isMining(a.method_10093((class_2350)a2)))) {
                    return true;
                }
                n3 = ++n;
            }
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public void doBed(class_2338 var1_1) {
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

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Render;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Predict;
        private static final /* synthetic */ Page[] $VALUES;

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
            Page[] arrpage = new Page[5];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            arrpage[2] = Calc;
            arrpage[3] = Predict;
            arrpage[4] = Render;
            return arrpage;
        }

        static {
            General = new Page(UserInfo.ALLATORIxDEMO("0\u0006(\u00002\u0006."), 0);
            Rotate = new Page(ClientInfo.ALLATORIxDEMO("Q!j2 |"), 1);
            Calc = new Page(UserInfo.ALLATORIxDEMO("&!\u000b!"), 2);
            Predict = new Page(ClientInfo.ALLATORIxDEMO("\u0019q+z:7m"), 3);
            Render = new Page(UserInfo.ALLATORIxDEMO("1#\u000b$\u00020"), 4);
            $VALUES = Page.$values();
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Scanner;
        public static final /* enum */ Mode NullPoint;

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[2];
            arrmode[0] = NullPoint;
            arrmode[1] = Scanner;
            return arrmode;
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            NullPoint = new Mode(SocketClient.ALLATORIxDEMO("\u0001vJMTEfEz"), 0);
            Scanner = new Mode(FileUtil.ALLATORIxDEMO("\u0004y\u0014\u0010u\r"), 1);
            $VALUES = Mode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Mode() {
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

    public class PlayerAndPredict {
        final class_1657 player;
        final /* synthetic */ BedAura this$0;
        final class_1657 predict;

        public PlayerAndPredict(BedAura bedAura, class_1657 class_16572) {
            Iterator a;
            PlayerAndPredict a2 = class_16572;
            PlayerAndPredict a3 = this;
            a3.this$0 = a;
            a3.player = a2;
            if (((BedAura)a).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a3;
                playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(Packet.ALLATORIxDEMO("-\noK\u0019; \u00076\r1\u0017+\u0015=\u001b\b.9\u0005(\u000f\u001c >\u0019(\r(\n+\u0002/\b>\u0019")), MathUtil.ALLATORIxDEMO("5\u000b4)\u001a\f\u0010=\u000b\r\u0001\u0000\u001bMFP")), (BedAura)((Object)a)){
                    final /* synthetic */ BedAura val$this$0;
                    final /* synthetic */ PlayerAndPredict this$1;
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
                        object.this$1 = a6;
                        object.val$this$0 = a;
                        super((class_1937)a4, (class_2338)a2, (float)a3, (GameProfile)a5);
                    }

                    public boolean method_7337() {
                        return false;
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, BedAura.INSTANCE.predictTicks.getValueInt(), true)));
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
