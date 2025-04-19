/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
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
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.vanilla;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.TPUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.user.User;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
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
import net.minecraft.class_2848;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class VAnchorAura
extends Module {
    private final SliderSetting updateDelay;
    private final SliderSetting spamDelay;
    private final BooleanSetting terrainIgnore;
    private final Timer timer;
    static class_243 curVec3d;
    private final BooleanSetting noSuicide;
    public final SliderSetting breakMin;
    private final SliderSetting lineWidth;
    static class_243 placeVec3d;
    private final BooleanSetting random;
    private final EnumSetting<Aura.TargetESP> mode;
    final ColorSetting fill;
    final BooleanSetting render;
    private final EnumSetting<SwingSide> swingMode;
    double fade;
    private final Timer delayTimer;
    private final EnumSetting<PlaceMode> placeMode;
    private final BooleanSetting bold;
    private final BooleanSetting packet;
    public final SliderSetting minDamage;
    public class_243 directionVec;
    public final SliderSetting predictTicks;
    private final SliderSetting placeDelay;
    private final BooleanSetting spamPlace;
    private final SliderSetting steps;
    private final SliderSetting calcDelay;
    private final BooleanSetting spam;
    public class_2338 currentPos;
    private float lastPitch;
    public final SliderSetting targetRange;
    private final BooleanSetting usingPause;
    final BooleanSetting shrink;
    final ColorSetting box;
    private final BooleanSetting light;
    private final SliderSetting maxSelfDamage;
    public class_1657 displayTarget;
    private final BooleanSetting rotate;
    private final Timer updateTimer;
    private final BooleanSetting inSpam;
    private final SliderSetting minPrefer;
    public double lastDamage;
    private final ColorSetting color;
    private final BooleanSetting inventory;
    private final BooleanSetting breakCrystal;
    public static VAnchorAura INSTANCE;
    private final BooleanSetting mineSpam;
    private final BooleanSetting checkLook;
    private final ArrayList<class_2338> chargeList;
    private final SliderSetting fov;
    private final EnumSetting<CalcMode> calcMode;
    final SliderSetting startFadeTime;
    private float lastYaw;
    final Timer noPosTimer;
    public class_2338 tempPos;
    private final SliderSetting tickDelay;
    final SliderSetting sliderSpeed;
    private final BooleanSetting yawStep;
    final SliderSetting fadeSpeed;
    public final SliderSetting headDamage;
    private final Timer calcTimer;
    public final SliderSetting range;
    public final EnumSetting<Page> page;

    /*
     * Exception decompiling
     */
    public void anchor() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 6[WHILELOOP]
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

    private static /* synthetic */ void lambda$clickBlock$48(class_3965 a) {
        VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, a, BlockUtil.getWorldActionId(VAnchorAura.mc.field_1687)));
    }

    public int findBlock(class_2248 class_22482) {
        VAnchorAura a = class_22482;
        VAnchorAura a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    private static /* synthetic */ void lambda$clickBlocks$46(class_3965 a) {
        VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, a, BlockUtil.getWorldActionId(VAnchorAura.mc.field_1687)));
    }

    /*
     * WARNING - void declaration
     */
    public void clickBlocks(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        void a2;
        VAnchorAura a3 = class_23502;
        VAnchorAura a4 = this;
        class_243 class_2432 = new class_243((double)a2.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a2.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a2.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a != false && !a4.faceVector(class_2432)) {
            return;
        }
        EntityUtil.swingHand(class_1268.field_5808, a4.swingMode.getValue());
        a3 = new class_3965(class_2432, (class_2350)a3, (class_2338)a2, false);
        if (VAnchorAura.mc.field_1761 != null) {
            TPUtil.tp(() -> VAnchorAura.lambda$clickBlocks$45((class_3965)a3), a2.method_46558());
        }
        if (VAnchorAura.mc.field_1724 != null) {
            TPUtil.tp(() -> VAnchorAura.lambda$clickBlocks$46((class_3965)a3), a2.method_46558());
        }
    }

    public void update() {
        VAnchorAura a;
        if (VAnchorAura.nullCheck()) {
            return;
        }
        VAnchorAura vAnchorAura = a;
        vAnchorAura.anchor();
        vAnchorAura.currentPos = vAnchorAura.tempPos;
    }

    public void globalPlace(class_2338 a) {
        VAnchorAura a22;
        VAnchorAura vAnchorAura = a22;
        int n = vAnchorAura.findBlock(class_2246.field_23152);
        int a22 = 0;
        if (VAnchorAura.mc.field_1724 != null) {
            a22 = VAnchorAura.mc.field_1724.method_31548().field_7545;
        }
        VAnchorAura vAnchorAura2 = vAnchorAura;
        vAnchorAura2.doSwap(n);
        vAnchorAura2.placeBlock(a, vAnchorAura2.rotate.getValue());
        if (vAnchorAura.inventory.getValue()) {
            vAnchorAura.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        vAnchorAura.doSwap(a22);
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

    public void GlowPlaceable(class_2338 a) {
        VAnchorAura a22;
        VAnchorAura vAnchorAura = a22;
        int n = vAnchorAura.findBlock(class_2246.field_10171);
        int a22 = 0;
        if (VAnchorAura.mc.field_1724 != null) {
            a22 = VAnchorAura.mc.field_1724.method_31548().field_7545;
        }
        class_2338 class_23382 = a;
        VAnchorAura vAnchorAura2 = vAnchorAura;
        vAnchorAura2.doSwap(n);
        vAnchorAura2.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), vAnchorAura.rotate.getValue());
        if (vAnchorAura.inventory.getValue()) {
            vAnchorAura.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        vAnchorAura.doSwap(a22);
    }

    @Override
    public void onEnable() {
        VAnchorAura a;
        VAnchorAura vAnchorAura = a;
        vAnchorAura.lastYaw = Hana.ROTATE.lastYaw;
        vAnchorAura.lastPitch = Hana.ROTATE.lastPitch;
    }

    private static /* synthetic */ void lambda$clickBlock$47(class_3965 a) {
        VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, a, BlockUtil.getWorldActionId(VAnchorAura.mc.field_1687)));
    }

    /*
     * WARNING - void declaration
     */
    public void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        void a;
        void a2;
        void a3;
        VAnchorAura a4 = class_23502;
        VAnchorAura a5 = this;
        class_243 class_2432 = new class_243((double)a3.method_10263() + 0.5 + (double)a4.method_10163().method_10263() * 0.5, (double)a3.method_10264() + 0.5 + (double)a4.method_10163().method_10264() * 0.5, (double)a3.method_10260() + 0.5 + (double)a4.method_10163().method_10260() * 0.5);
        if (a2 != false && !a5.faceVector(class_2432)) {
            return;
        }
        a5.doSwap((int)a);
        EntityUtil.swingHand(class_1268.field_5808, a5.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a4, (class_2338)a3, false);
        if (VAnchorAura.mc.field_1724 != null) {
            TPUtil.tp(() -> VAnchorAura.lambda$clickBlock$48((class_3965)a4), a3.method_46558());
        }
        if (a5.inventory.getValue()) {
            a5.doSwap((int)a);
            EntityUtil.syncInventory();
        }
    }

    /*
     * Exception decompiling
     */
    public double getAnchorDamage(class_2338 var1_1, class_1657 var2_2, class_1657 var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[DOLOOP]], but top level block is 3[CASE]
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

    private static /* synthetic */ void lambda$clickBlocks$45(class_3965 a) {
        VAnchorAura.mc.field_1761.method_2896(VAnchorAura.mc.field_1724, class_1268.field_5808, a);
    }

    public VAnchorAura() {
        VAnchorAura a;
        VAnchorAura vAnchorAura = a;
        super(FPSManager.ALLATORIxDEMO("uQ\u0018t\u0019\u0004L\u001e5@"), Module.Category.Combat);
        VAnchorAura vAnchorAura2 = a;
        vAnchorAura2.page = vAnchorAura.add(new EnumSetting<Page>(TimeHelper.ALLATORIxDEMO("m\u001e\u0010P"), Page.General));
        vAnchorAura.light = vAnchorAura.add(new BooleanSetting(FPSManager.ALLATORIxDEMO(":d\f/U"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventory = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("#\u001bAE\fS\nR\u001bn\b\u0016E"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.range = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("$l\u0005 D"), 5.0, 0.0, 100.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("X")));
        a.targetRange = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("wq\u0004p\u0014d$l\u0005 D"), 8.0, 0.0, 100.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("X")));
        a.tickDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("\"~\u0012{2h\u0007&X"), 100.0, 165.0, 500.0, 1.0, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001aF")));
        a.placeMode = a.add(new EnumSetting<PlaceMode>(FPSManager.ALLATORIxDEMO("&{\u0010s\u0013@\u0004#D"), PlaceMode.tick, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakCrystal = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("7EE\u0003L&R\u001bN\u000b\u0016Y"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.spam = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("^\u001b&L"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setParent());
        a.mineSpam = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("o\fK\u001cm\u000bS\u0016\u0019R"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General && a2.spam.isOpen();
        }));
        a.spamPlace = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("K\n4U"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setParent());
        a.inSpam = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("\"_E\ft\u0015A\u000fP\u0016\u0019R"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General && a2.spamPlace.isOpen();
        }));
        a.usingPause = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("E\u0005~\u001fw&l\u001e4D"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(TimeHelper.ALLATORIxDEMO("1J\u0016\u0019R"), SwingSide.Server, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("2h\u0007&X"), 100.0, 0.0, 500.0, 1.0, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001aF")));
        a.spamDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("%g\u0010}2h\u0007&X"), 200.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001aF")));
        a.calcDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("5v\u001ds2h\u0007&X"), 200.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001aF")));
        a.updateDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("v`\u0012v\u0005u2h\u0007&X"), 50, 0, 1000, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001aF")));
        a.rotate = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("B\u0019y\n3D"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.yawStep = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("<A\u0015n\u000b\u0012E"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("%y\u000e7R"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.01, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("p\u0003^\u0014\u0012A"), false, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("B\u0017c\u000f(L"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("!O\u0000C\tq\u0010\u0018^"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("-(W"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.calcMode = a.add(new EnumSetting<CalcMode>(TimeHelper.ALLATORIxDEMO("d\u0004L\u0001p\u0010\u0013P"), CalcMode.Meteor, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.noSuicide = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("8x\"e\u001fn\u0002#D"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.terrainIgnore = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO(">\u0010ER\u0003N\u000bi\u0005S\u0010\u0005P"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.minDamage = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("&.O"), 4.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001b\u001aR")));
        a.breakMin = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("\u0000[`\u001ax\u0002y\u0019c&.O"), 4.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001b\u001aR")));
        a.headDamage = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("0x\u0003s\u0013E\u000e&E"), 7.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001b\u001aR")));
        a.minPrefer = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("@\u0004h\r\"S"), 7.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001b\u001aR")));
        a.maxSelfDamage = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("<q\u000e^\u000e+G"), 8.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u001b\u001aR")));
        a.predictTicks = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("!b\u0013i\u0002$U"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(TimeHelper.ALLATORIxDEMO("\u0016T\u001c\u001cF")));
        a.mode = a.add(new EnumSetting<Aura.TargetESP>(FPSManager.ALLATORIxDEMO("\"v\u0003w\u0013y.\u0014q"), Aura.TargetESP.Jello, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(TimeHelper.ALLATORIxDEMO("cA\u0010@\u0000T!R\u0013\u0018G"), new Color(255, 255, 255, 250), object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.render = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("B\u0013c\u000f\"S"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.shrink = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("s\nO\u0016\u0019^"), true, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new ColorSetting(FPSManager.ALLATORIxDEMO(")(Y"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.bold = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("\u0010\u001bQ"), false, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue() && a2.box.booleanValue;
        })).setParent();
        a.lineWidth = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO(":~\u001fu!d\u000f3I"), 4, 1, 5, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue() && a2.bold.isOpen() && a2.box.booleanValue;
        }));
        a.fill = a.add(new ColorSetting(TimeHelper.ALLATORIxDEMO("{\u0016\u001bY"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.sliderSpeed = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("p|\u001fs\u0014b%}\u000e\"E"), 0.2, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("1S\u0004R\u0016{\u001e\u0013P"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setSuffix(FPSManager.ALLATORIxDEMO("R")));
        a.fadeSpeed = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("$F\u0001E1M\u001a\u0012Q"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            VAnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        VAnchorAura vAnchorAura3 = a;
        VAnchorAura vAnchorAura4 = a;
        VAnchorAura vAnchorAura5 = a;
        VAnchorAura vAnchorAura6 = a;
        vAnchorAura6.chargeList = new ArrayList();
        vAnchorAura6.updateTimer = new Timer();
        vAnchorAura6.delayTimer = new Timer();
        vAnchorAura6.calcTimer = new Timer();
        vAnchorAura6.noPosTimer = new Timer();
        vAnchorAura5.directionVec = null;
        vAnchorAura5.lastPitch = 0.0f;
        vAnchorAura4.lastYaw = 0.0f;
        vAnchorAura4.fade = 0.0;
        vAnchorAura3.timer = new Timer();
        vAnchorAura3.setChinese(FPSManager.ALLATORIxDEMO("\u53e9\u7245\u91a6\u7558\u953b"));
        INSTANCE = vAnchorAura3;
        Hana.EVENT_BUS.subscribe(new AnchorRender(a));
    }

    @Override
    public void onUpdate() {
        VAnchorAura a;
        a.update();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        VAnchorAura a2 = this;
        a2.update();
        if (VAnchorAura.INSTANCE.displayTarget != null && VAnchorAura.INSTANCE.currentPos != null) {
            void a3;
            Aura.doRender((class_4587)a3, a, (class_1297)VAnchorAura.INSTANCE.displayTarget, a2.color.getValue(), a2.mode.getValue());
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        VAnchorAura a3 = this;
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
        if (a != null) {
            float[] arrf2 = new float[2];
            arrf2[0] = a[0];
            arrf2[1] = a[1];
            return arrf2;
        }
        return null;
    }

    public void placeBlock(class_2338 a, boolean a2) {
        class_2350 a3;
        class_2350 class_23502 = a3;
        if (BlockUtil.airPlace()) {
            int n;
            a3 = class_2350.values();
            int n2 = ((class_2350[])a3).length;
            int n3 = n = 0;
            while (n3 < n2) {
                class_2350 class_23503 = a3[n];
                if (VAnchorAura.mc.field_1687 != null && VAnchorAura.mc.field_1687.method_22347(a.method_10093(class_23503))) {
                    class_23502.clickBlock(a, class_23503, a2);
                    return;
                }
                n3 = ++n;
            }
        }
        if ((a3 = BlockUtil.getPlaceSide(a)) == null) {
            return;
        }
        BlockUtil.placedPos.add(a);
        class_243 class_2432 = new class_243((double)a.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, a3, a, false);
        boolean bl = false;
        if (VAnchorAura.mc.field_1724 != null) {
            bl = VAnchorAura.mc.field_1724.method_5624();
        }
        boolean bl2 = false;
        if (VAnchorAura.mc.field_1687 != null) {
            boolean bl3 = bl2 = BlockUtil.needSneak(VAnchorAura.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !VAnchorAura.mc.field_1724.method_5715();
        }
        if (bl) {
            VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VAnchorAura.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl2) {
            VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VAnchorAura.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a.method_10093(a3), a3.method_10153(), a2);
        if (bl2) {
            VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VAnchorAura.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl) {
            VAnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)VAnchorAura.mc.field_1724, class_2848.class_2849.field_12981));
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
    }

    public void TickBreak(class_2338 a) {
        VAnchorAura a22;
        VAnchorAura vAnchorAura = a22;
        int n = InventoryUtil.findItem(class_1802.field_8367);
        int a22 = 0;
        if (VAnchorAura.mc.field_1724 != null) {
            a22 = VAnchorAura.mc.field_1724.method_31548().field_7545;
        }
        class_2338 class_23382 = a;
        VAnchorAura vAnchorAura2 = vAnchorAura;
        vAnchorAura2.doSwap(n);
        vAnchorAura2.clickBlocks(class_23382, BlockUtil.getClickSide(class_23382), vAnchorAura.rotate.getValue());
        if (vAnchorAura.inventory.getValue()) {
            vAnchorAura.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        vAnchorAura.doSwap(a22);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        VAnchorAura a2 = this;
        if (a2.inventory.getValue()) {
            if (VAnchorAura.mc.field_1724 != null) {
                InventoryUtil.inventorySwap(a, VAnchorAura.mc.field_1724.method_31548().field_7545);
                return;
            }
        } else {
            InventoryUtil.switchToSlot(a);
        }
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        VAnchorAura a2 = this;
        a2.update();
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.currentPos != null && arrf.yawStep.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf.directionVec), arrf2.steps.getValueFloat());
            if (a2 != null) {
                arrf.lastYaw = a2[0];
            }
            if (a2 != null) {
                arrf.lastPitch = a2[1];
            }
            if (arrf.random.getValue() && new Random().nextBoolean()) {
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

    private /* synthetic */ void lambda$anchor$44() {
        VAnchorAura a;
        CombatUtil.attackCrystal(new class_2338((class_2382)a.tempPos), a.rotate.getValue(), false);
    }

    /*
     * WARNING - void declaration
     */
    public void placeBlock(class_2338 class_23382, boolean bl, int n) {
        class_2350 a;
        void a2;
        void a3;
        void a4;
        class_2350 class_23502 = this;
        if (BlockUtil.airPlace()) {
            int n2;
            a = class_2350.values();
            int n3 = ((class_2350[])a).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                class_2350 class_23503 = a[n2];
                if (VAnchorAura.mc.field_1687 != null && VAnchorAura.mc.field_1687.method_22347(a4.method_10093(class_23503))) {
                    class_23502.clickBlock((class_2338)a4, class_23503, (boolean)a3, (int)a2);
                    return;
                }
                n4 = ++n2;
            }
        }
        if ((a = BlockUtil.getPlaceSide((class_2338)a4)) == null) {
            return;
        }
        BlockUtil.placedPos.add((class_2338)a4);
        class_23502.clickBlock(a4.method_10093(a), a.method_10153(), (boolean)a3, (int)a2);
    }

    @Override
    public void onDisable() {
        VAnchorAura a;
        VAnchorAura vAnchorAura = a;
        vAnchorAura.currentPos = null;
        vAnchorAura.tempPos = null;
    }

    @Override
    public String getInfo() {
        VAnchorAura a;
        if (a.displayTarget != null && a.currentPos != null) {
            return a.displayTarget.method_5477().getString();
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        void a2;
        VAnchorAura a3 = class_23502;
        VAnchorAura a4 = this;
        class_243 class_2432 = new class_243((double)a2.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a2.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a2.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a != false && !a4.faceVector(class_2432)) {
            return;
        }
        EntityUtil.swingHand(class_1268.field_5808, a4.swingMode.getValue());
        a3 = new class_3965(class_2432, (class_2350)a3, (class_2338)a2, false);
        if (VAnchorAura.mc.field_1724 != null) {
            TPUtil.tp(() -> VAnchorAura.lambda$clickBlock$47((class_3965)a3), a2.method_46558());
        }
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Render;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Rotate;
        private static final /* synthetic */ Page[] $VALUES;

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[4];
            arrpage[0] = General;
            arrpage[1] = Calc;
            arrpage[2] = Rotate;
            arrpage[3] = Render;
            return arrpage;
        }

        static {
            General = new Page(GameInfo.ALLATORIxDEMO("ryjpyl"), 0);
            Calc = new Page(GaussianFilter.ALLATORIxDEMO("\u0011_t\u0017"), 1);
            Rotate = new Page(GameInfo.ALLATORIxDEMO("Nkncle"), 2);
            Render = new Page(GaussianFilter.ALLATORIxDEMO("\u001dF<Z}\u0006"), 3);
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

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }
    }

    public static final class PlaceMode
    extends Enum<PlaceMode> {
        public static final /* enum */ PlaceMode NullPoint;
        private static final /* synthetic */ PlaceMode[] $VALUES;
        public static final /* enum */ PlaceMode tick;

        private static /* synthetic */ PlaceMode[] $values() {
            PlaceMode[] arrplaceMode = new PlaceMode[2];
            arrplaceMode[0] = tick;
            arrplaceMode[1] = NullPoint;
            return arrplaceMode;
        }

        public static PlaceMode[] values() {
            return (PlaceMode[])$VALUES.clone();
        }

        static {
            tick = new PlaceMode(HoleUtils.ALLATORIxDEMO("WuAv"), 0);
            NullPoint = new PlaceMode(User.ALLATORIxDEMO("xwrLlD^DB"), 1);
            $VALUES = PlaceMode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ PlaceMode() {
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

        public static PlaceMode valueOf(String a) {
            return Enum.valueOf(PlaceMode.class, a);
        }
    }

    public static final class CalcMode
    extends Enum<CalcMode> {
        public static final /* enum */ CalcMode Mio;
        public static final /* enum */ CalcMode Meteor;
        private static final /* synthetic */ CalcMode[] $VALUES;
        public static final /* enum */ CalcMode Thunder;
        public static final /* enum */ CalcMode Edit;
        public static final /* enum */ CalcMode OyVey;

        private static /* synthetic */ CalcMode[] $values() {
            CalcMode[] arrcalcMode = new CalcMode[5];
            arrcalcMode[0] = OyVey;
            arrcalcMode[1] = Meteor;
            arrcalcMode[2] = Thunder;
            arrcalcMode[3] = Edit;
            arrcalcMode[4] = Mio;
            return arrcalcMode;
        }

        public static CalcMode[] values() {
            return (CalcMode[])$VALUES.clone();
        }

        static {
            OyVey = new CalcMode(Packet.ALLATORIxDEMO("}gozA"), 0);
            Meteor = new CalcMode(Snow.ALLATORIxDEMO("C?q4k\""), 1);
            Thunder = new CalcMode(Packet.ALLATORIxDEMO("D}Gp]zJ"), 2);
            Edit = new CalcMode(Snow.ALLATORIxDEMO("@5m$"), 3);
            Mio = new CalcMode(Packet.ALLATORIxDEMO("tvW"), 4);
            $VALUES = CalcMode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ CalcMode() {
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

        public static CalcMode valueOf(String a) {
            return Enum.valueOf(CalcMode.class, a);
        }
    }

    public class AnchorRender {
        final /* synthetic */ VAnchorAura this$0;

        public AnchorRender(VAnchorAura vAnchorAura) {
            VAnchorAura a = vAnchorAura;
            AnchorRender a2 = this;
            a2.this$0 = a;
        }

        @EventHandler
        public void onRender3D(Render3DEvent a) {
            AnchorRender anchorRender;
            AnchorRender anchorRender2;
            AnchorRender a2;
            AnchorRender anchorRender3 = a2;
            if (anchorRender3.this$0.currentPos != null) {
                anchorRender3.this$0.noPosTimer.reset();
                placeVec3d = anchorRender3.this$0.currentPos.method_46558();
            }
            if (placeVec3d == null) {
                return;
            }
            if (anchorRender3.this$0.fadeSpeed.getValue() >= 1.0) {
                anchorRender3.this$0.fade = anchorRender3.this$0.noPosTimer.passedMs((long)(anchorRender3.this$0.startFadeTime.getValue() * 1000.0)) ? 0.0 : 0.5;
                anchorRender = anchorRender3;
            } else {
                double d;
                AnchorRender anchorRender4;
                if (anchorRender3.this$0.noPosTimer.passedMs((long)(anchorRender3.this$0.startFadeTime.getValue() * 1000.0))) {
                    d = 0.0;
                    anchorRender4 = anchorRender3;
                } else {
                    d = 0.5;
                    anchorRender4 = anchorRender3;
                }
                anchorRender3.this$0.fade = AnimateUtil.animate(anchorRender3.this$0.fade, d, anchorRender4.this$0.fadeSpeed.getValue() / 10.0);
                anchorRender = anchorRender3;
            }
            if (anchorRender.this$0.fade == 0.0) {
                curVec3d = null;
                return;
            }
            if (curVec3d == null || anchorRender3.this$0.sliderSpeed.getValue() >= 1.0) {
                curVec3d = placeVec3d;
                anchorRender2 = anchorRender3;
            } else {
                curVec3d = new class_243(AnimateUtil.animate(VAnchorAura.curVec3d.field_1352, VAnchorAura.placeVec3d.field_1352, anchorRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(VAnchorAura.curVec3d.field_1351, VAnchorAura.placeVec3d.field_1351, anchorRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(VAnchorAura.curVec3d.field_1350, VAnchorAura.placeVec3d.field_1350, anchorRender3.this$0.sliderSpeed.getValue() / 10.0));
                anchorRender2 = anchorRender3;
            }
            if (anchorRender2.this$0.render.getValue()) {
                Render3DEvent render3DEvent;
                AnchorRender anchorRender5 = a2 = new class_238(curVec3d, curVec3d);
                if (anchorRender3.this$0.shrink.getValue()) {
                    a2 = anchorRender5.method_1014(anchorRender3.this$0.fade);
                    render3DEvent = a;
                } else {
                    a2 = anchorRender5.method_1014(0.5);
                    render3DEvent = a;
                }
                a = render3DEvent.getMatrixStack();
                if (anchorRender3.this$0.fill.booleanValue) {
                    Render3DUtil.drawFill((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.fill.getValue(), (int)((double)anchorRender3.this$0.fill.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)));
                }
                if (anchorRender3.this$0.box.booleanValue) {
                    if (!anchorRender3.this$0.bold.getValue()) {
                        Render3DUtil.drawBox((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.box.getValue(), (int)((double)anchorRender3.this$0.box.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)));
                        return;
                    }
                    Render3DUtil.drawLine((class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.box.getValue(), (int)((double)anchorRender3.this$0.box.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)), anchorRender3.this$0.lineWidth.getValueInt());
                }
            }
        }
    }

    public static class PlayerAndPredict {
        public final class_1657 player;
        public final class_1657 predict;

        public PlayerAndPredict(class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.player = a;
            if (VAnchorAura.INSTANCE.predictTicks.getValueFloat() > 0.0f) {
                Iterator iterator;
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(BaseChildSettings.ALLATORIxDEMO("\u001di\rz<M\u0016b\u0007o,Y\be\u001ek\u0019l\ne\u001bo\fcD0\u0010f\u0016g\u001fe\fx@4")), ObsidianHelper.ALLATORIxDEMO("x1y\u0013W6]\u0007F7L:Vw\u000bj"))){
                    final /* synthetic */ PlayerAndPredict this$0;

                    public boolean method_7337() {
                        return false;
                    }
                    {
                        1 a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        1 v0 = this_;
                        1 this_ = gameProfile;
                        1 a6 = v0;
                        a6.this$0 = a5;
                        super((class_1937)a4, (class_2338)a3, (float)a2, (GameProfile)a);
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, VAnchorAura.INSTANCE.predictTicks.getValueInt(), true)));
                playerAndPredict.predict.method_6033(a.method_6032());
                playerAndPredict.predict.field_6014 = ((class_1657)a).field_6014;
                playerAndPredict.predict.field_5969 = ((class_1657)a).field_5969;
                playerAndPredict.predict.field_6036 = ((class_1657)a).field_6036;
                playerAndPredict.predict.method_24830(a.method_24828());
                PlayerAndPredict playerAndPredict2 = a;
                playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
                playerAndPredict.predict.method_18380(a.method_18376());
                Iterator iterator2 = iterator = playerAndPredict2.method_6026().iterator();
                while (iterator2.hasNext()) {
                    class_1293 class_12932 = (class_1293)iterator.next();
                    iterator2 = iterator;
                    a2.predict.method_6092(class_12932);
                }
            } else {
                a2.predict = a;
            }
        }

    }

}
