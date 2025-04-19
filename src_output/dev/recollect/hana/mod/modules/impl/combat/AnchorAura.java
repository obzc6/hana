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
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.video.Renderer;
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
import org.bytedeco.javacv.BaseSettings;
import org.bytedeco.javacv.FrameFilter;

public class AnchorAura
extends Module {
    public final SliderSetting headDamage;
    private final BooleanSetting terrainIgnore;
    private final SliderSetting tickDelay;
    private final SliderSetting calcDelay;
    private final EnumSetting<CalcMode> calcMode;
    private final SliderSetting placeDelay;
    private final BooleanSetting mineSpam;
    private final BooleanSetting rotate;
    private final BooleanSetting noSuicide;
    private final Timer updateTimer;
    private final SliderSetting lineWidth;
    private final EnumSetting<Aura.TargetESP> mode;
    private final BooleanSetting bold;
    public final SliderSetting predictTicks;
    private final SliderSetting maxSelfDamage;
    private final SliderSetting fov;
    public double lastDamage;
    private final SliderSetting steps;
    public final SliderSetting range;
    private final EnumSetting<PlaceMode> placeMode;
    private final BooleanSetting yawStep;
    private final BooleanSetting inventory;
    private final Timer delayTimer;
    public class_2338 tempPos;
    public class_243 directionVec;
    final Timer noPosTimer;
    private final BooleanSetting spam;
    public final SliderSetting minDamage;
    final SliderSetting fadeSpeed;
    private float lastYaw;
    private final SliderSetting spamDelay;
    public class_1657 displayTarget;
    public static AnchorAura INSTANCE;
    private final SliderSetting updateDelay;
    public final EnumSetting<Page> page;
    private final BooleanSetting light;
    final ColorSetting text;
    private final EnumSetting<SwingSide> swingMode;
    final SliderSetting sliderSpeed;
    private final BooleanSetting random;
    double fade;
    final ColorSetting box;
    private final BooleanSetting inSpam;
    private final BooleanSetting packet;
    static class_243 placeVec3d;
    final BooleanSetting shrink;
    public final SliderSetting targetRange;
    public final SliderSetting breakMin;
    private final ColorSetting color;
    private final ArrayList<class_2338> chargeList;
    private final BooleanSetting usingPause;
    public class_2338 currentPos;
    private final Timer calcTimer;
    private final BooleanSetting checkLook;
    final ColorSetting fill;
    private final Timer timer;
    private float lastPitch;
    final SliderSetting startFadeTime;
    final BooleanSetting render;
    private final SliderSetting minPrefer;
    static class_243 curVec3d;
    private final BooleanSetting spamPlace;
    private final BooleanSetting breakCrystal;

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        AnchorAura a2 = this;
        a2.update();
        if (AnchorAura.INSTANCE.displayTarget != null && AnchorAura.INSTANCE.currentPos != null) {
            void a3;
            Aura.doRender((class_4587)a3, a, (class_1297)AnchorAura.INSTANCE.displayTarget, a2.color.getValue(), a2.mode.getValue());
        }
    }

    @Override
    public void onUpdate() {
        AnchorAura a;
        a.update();
    }

    /*
     * WARNING - void declaration
     */
    public void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        void a2;
        AnchorAura a3 = class_23382;
        AnchorAura a4 = this;
        class_243 class_2432 = new class_243((double)a3.method_10263() + 0.5 + (double)a2.method_10163().method_10263() * 0.5, (double)a3.method_10264() + 0.5 + (double)a2.method_10163().method_10264() * 0.5, (double)a3.method_10260() + 0.5 + (double)a2.method_10163().method_10260() * 0.5);
        if (a != false && !a4.faceVector(class_2432)) {
            return;
        }
        EntityUtil.swingHand(class_1268.field_5808, a4.swingMode.getValue());
        a3 = new class_3965(class_2432, (class_2350)a2, (class_2338)a3, false);
        if (AnchorAura.mc.field_1724 != null) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a3, BlockUtil.getWorldActionId(AnchorAura.mc.field_1687)));
        }
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AnchorAura a2 = this;
        a2.update();
    }

    public void globalPlace(class_2338 a) {
        AnchorAura a22;
        AnchorAura anchorAura = a22;
        int n = anchorAura.findBlock(class_2246.field_23152);
        int a22 = 0;
        if (AnchorAura.mc.field_1724 != null) {
            a22 = AnchorAura.mc.field_1724.method_31548().field_7545;
        }
        AnchorAura anchorAura2 = anchorAura;
        anchorAura2.doSwap(n);
        anchorAura2.placeBlock(a, anchorAura2.rotate.getValue());
        if (anchorAura.inventory.getValue()) {
            anchorAura.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        anchorAura.doSwap(a22);
    }

    public void TickBreak(class_2338 a) {
        AnchorAura a22;
        AnchorAura anchorAura = a22;
        int n = InventoryUtil.findItem(class_1802.field_8367);
        int a22 = 0;
        if (AnchorAura.mc.field_1724 != null) {
            a22 = AnchorAura.mc.field_1724.method_31548().field_7545;
        }
        class_2338 class_23382 = a;
        AnchorAura anchorAura2 = anchorAura;
        anchorAura2.doSwap(n);
        anchorAura2.clickBlocks(class_23382, BlockUtil.getClickSide(class_23382), anchorAura.rotate.getValue());
        if (anchorAura.inventory.getValue()) {
            anchorAura.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        anchorAura.doSwap(a22);
    }

    public int findBlock(class_2248 class_22482) {
        AnchorAura a = class_22482;
        AnchorAura a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
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
                if (AnchorAura.mc.field_1687 != null && AnchorAura.mc.field_1687.method_22347(a4.method_10093(class_23503))) {
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

    @Override
    public String getInfo() {
        AnchorAura a;
        if (a.displayTarget != null && a.currentPos != null) {
            return a.displayTarget.method_5477().getString();
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public double getAnchorDamage(class_2338 var1_1, class_1657 var2_2, class_1657 var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[DOLOOP]], but top level block is 3[CASE]
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
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        AnchorAura a3 = this;
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
        if (a != null) {
            float[] arrf2 = new float[2];
            arrf2[0] = a[0];
            arrf2[1] = a[1];
            return arrf2;
        }
        return null;
    }

    public void update() {
        AnchorAura a;
        if (AnchorAura.nullCheck()) {
            return;
        }
        AnchorAura anchorAura = a;
        anchorAura.anchor();
        anchorAura.currentPos = anchorAura.tempPos;
    }

    public AnchorAura() {
        AnchorAura a;
        AnchorAura anchorAura = a;
        super(PacketBuffer.ALLATORIxDEMO("(`9U\u0001{({\b|"), Module.Category.Combat);
        AnchorAura anchorAura2 = a;
        anchorAura2.page = anchorAura.add(new EnumSetting<Page>(FadeUtils.ALLATORIxDEMO("!A\\\u000f"), Page.General));
        anchorAura.light = anchorAura.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("E\u0000i\u0012i"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventory = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("|W\u001e\tS\u001fU\u001eD\"WZ\u001a"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.range = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("[\b`\u001dx"), 5.0, 0.0, 6.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("\u0007")));
        a.targetRange = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("G\b|=X\u001a[\b`\u001dx"), 8.0, 0.0, 16.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("\u0007")));
        a.tickDelay = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("Z3^\u0005M\fb\u001bd"), 100.0, 0.0, 500.0, 1.0, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("V\u0019")));
        a.placeMode = a.add(new EnumSetting<PlaceMode>(PacketBuffer.ALLATORIxDEMO("^6\\\rl$a\u001ex"), PlaceMode.tick, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakCrystal = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("{\u001a\t\\\u0000y\u001eD\u0002TZ\u0006"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.spam = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO(":~\u001bp"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setParent());
        a.mineSpam = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("#S\u0007C!T\u001fIU\r"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General && a2.spam.isOpen();
        }));
        a.spamPlace = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("/o\ti"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setParent());
        a.inSpam = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("n\u0000\tS8J\rP\u001cIU\r"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General && a2.spamPlace.isOpen();
        }));
        a.usingPause = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("<}3S\tY\b{\tx"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(FadeUtils.ALLATORIxDEMO("n\u0006IU\r"), SwingSide.Server, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeDelay = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("M\fb\u001bd"), 100.0, 0.0, 500.0, 1.0, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("V\u0019")));
        a.spamDelay = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("]*\\\u0003M\fb\u001bd"), 200.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("V\u0019")));
        a.calcDelay = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("M;Q\rM\fb\u001bd"), 200.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("V\u0019")));
        a.updateDelay = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("F\u0019j;I\u000bM\fb\u001bd"), 50, 0, 1000, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("V\u0019")));
        a.rotate = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("<f\u001do\u000ex"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.yawStep = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("c\rJ\"T^\u001a"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("Z\u001dk\nn"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.01, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("<\\\u0012K^\u001e"), false, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("<h\u0007j\u0015p"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("~\u0003_\u000fV=OT\u0001"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("H\u0015k"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.calcMode = a.add(new EnumSetting<CalcMode>(FadeUtils.ALLATORIxDEMO("([\u0000^<O_\u000f"), CalcMode.Meteor, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.noSuicide = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("@5n\u001b`\ng\u001ex"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.terrainIgnore = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("a\\\u001a\u001e\\\u0002T%Z\u001fOI\u000f"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.minDamage = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("C\u0013s"), 4.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("DV\r")));
        a.breakMin = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("1k\u0019b5N\u0007f\u0007C\u0013s"), 4.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("DV\r")));
        a.headDamage = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("H5O\rl!k\u001by"), 7.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("DV\r")));
        a.minPrefer = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO(">{\fh\u001fo"), 7.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("DV\r")));
        a.maxSelfDamage = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("p\u000fq:k\u0016{"), 8.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("DV\r")));
        a.predictTicks = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("m\u001cl\rg\u0019i"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FadeUtils.ALLATORIxDEMO("I\u0018CP\u0019")));
        a.mode = a.add(new EnumSetting<Aura.TargetESP>(PacketBuffer.ALLATORIxDEMO("Z;O\tl\u001dK)M"), Aura.TargetESP.Jello, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(FadeUtils.ALLATORIxDEMO("<\rO\f_\u0018~\u001eLT\u0018"), new Color(255, 255, 255, 250), object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.render = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("<l\u0007j\u001fo"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.shrink = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("?U\u0003IU\u0001"), true, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new ColorSetting(PacketBuffer.ALLATORIxDEMO("L\u0015e"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.bold = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("3OW\u000e"), false, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue() && a2.box.booleanValue;
        })).setParent();
        a.lineWidth = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("B3S\u000b^\u0000j\u000eu"), 4, 1, 5, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue() && a2.bold.isOpen() && a2.box.booleanValue;
        }));
        a.fill = a.add(new ColorSetting(FadeUtils.ALLATORIxDEMO("7IW\u0006"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.sliderSpeed = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("@\u0005g>X\u001cZ\u0019k\u001fy"), 0.2, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("n\u001f[\u001eI7A_\u000f"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setSuffix(PacketBuffer.ALLATORIxDEMO("n")));
        a.fadeSpeed = a.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("{\n^\tn\u0001E^\u000e"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.text = a.add(new ColorSetting(PacketBuffer.ALLATORIxDEMO("=k\u0002i"), new Color(-1), object -> {
            Object a = object;
            AnchorAura a2 = this;
            return a2.page.getValue() == Page.Render;
        }).injectBoolean(true));
        AnchorAura anchorAura3 = a;
        AnchorAura anchorAura4 = a;
        AnchorAura anchorAura5 = a;
        AnchorAura anchorAura6 = a;
        anchorAura6.chargeList = new ArrayList();
        anchorAura6.updateTimer = new Timer();
        anchorAura6.delayTimer = new Timer();
        anchorAura6.calcTimer = new Timer();
        anchorAura6.noPosTimer = new Timer();
        anchorAura5.directionVec = null;
        anchorAura5.lastPitch = 0.0f;
        anchorAura4.lastYaw = 0.0f;
        anchorAura4.fade = 0.0;
        anchorAura3.timer = new Timer();
        anchorAura3.setChinese(FadeUtils.ALLATORIxDEMO("\u91f0\u756e\u953a\u5172\u73c5"));
        INSTANCE = anchorAura3;
        Hana.EVENT_BUS.subscribe(new AnchorRender(a));
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AnchorAura a2 = this;
        if (a2.inventory.getValue()) {
            if (AnchorAura.mc.field_1724 != null) {
                InventoryUtil.inventorySwap(a, AnchorAura.mc.field_1724.method_31548().field_7545);
                return;
            }
        } else {
            InventoryUtil.switchToSlot(a);
        }
    }

    public void GlowPlaceable(class_2338 a) {
        AnchorAura a22;
        AnchorAura anchorAura = a22;
        int n = anchorAura.findBlock(class_2246.field_10171);
        int a22 = 0;
        if (AnchorAura.mc.field_1724 != null) {
            a22 = AnchorAura.mc.field_1724.method_31548().field_7545;
        }
        class_2338 class_23382 = a;
        AnchorAura anchorAura2 = anchorAura;
        anchorAura2.doSwap(n);
        anchorAura2.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), anchorAura.rotate.getValue());
        if (anchorAura.inventory.getValue()) {
            anchorAura.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        anchorAura.doSwap(a22);
    }

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

    @Override
    public void onDisable() {
        AnchorAura a;
        AnchorAura anchorAura = a;
        anchorAura.currentPos = null;
        anchorAura.tempPos = null;
    }

    /*
     * WARNING - void declaration
     */
    public void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        void a;
        void a2;
        void a3;
        AnchorAura a4 = class_23382;
        AnchorAura a5 = this;
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a != false && !a5.faceVector(class_2432)) {
            return;
        }
        a5.doSwap((int)a2);
        EntityUtil.swingHand(class_1268.field_5808, a5.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a3, (class_2338)a4, false);
        if (AnchorAura.mc.field_1724 != null) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(AnchorAura.mc.field_1687)));
        }
        if (a5.inventory.getValue()) {
            a5.doSwap((int)a2);
            EntityUtil.syncInventory();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void clickBlocks(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        void a2;
        AnchorAura a3 = class_23382;
        AnchorAura a4 = this;
        class_243 class_2432 = new class_243((double)a3.method_10263() + 0.5 + (double)a2.method_10163().method_10263() * 0.5, (double)a3.method_10264() + 0.5 + (double)a2.method_10163().method_10264() * 0.5, (double)a3.method_10260() + 0.5 + (double)a2.method_10163().method_10260() * 0.5);
        if (a != false && !a4.faceVector(class_2432)) {
            return;
        }
        EntityUtil.swingHand(class_1268.field_5808, a4.swingMode.getValue());
        a3 = new class_3965(class_2432, (class_2350)a2, (class_2338)a3, false);
        if (AnchorAura.mc.field_1761 != null) {
            AnchorAura.mc.field_1761.method_2896(AnchorAura.mc.field_1724, class_1268.field_5808, (class_3965)a3);
        }
        if (AnchorAura.mc.field_1724 != null) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a3, BlockUtil.getWorldActionId(AnchorAura.mc.field_1687)));
        }
    }

    @Override
    public void onEnable() {
        AnchorAura a;
        AnchorAura anchorAura = a;
        anchorAura.lastYaw = Hana.ROTATE.lastYaw;
        anchorAura.lastPitch = Hana.ROTATE.lastPitch;
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
                if (AnchorAura.mc.field_1687 != null && AnchorAura.mc.field_1687.method_22347(a.method_10093(class_23503))) {
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
        if (AnchorAura.mc.field_1724 != null) {
            bl = AnchorAura.mc.field_1724.method_5624();
        }
        boolean bl2 = false;
        if (AnchorAura.mc.field_1687 != null) {
            boolean bl3 = bl2 = BlockUtil.needSneak(AnchorAura.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !AnchorAura.mc.field_1724.method_5715();
        }
        if (bl) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AnchorAura.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl2) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AnchorAura.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a.method_10093(a3), a3.method_10153(), a2);
        if (bl2) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AnchorAura.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl) {
            AnchorAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)AnchorAura.mc.field_1724, class_2848.class_2849.field_12981));
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page General = new Page(BlockUpUtil.ALLATORIxDEMO("Z@t]u\u0013!"), 0);
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Render;
        private static final /* synthetic */ Page[] $VALUES;

        static {
            Calc = new Page(FrameFilter.ALLATORIxDEMO("\u0006u+u"), 1);
            Rotate = new Page(BlockUpUtil.ALLATORIxDEMO("wuLf\u0006("), 2);
            Render = new Page(FrameFilter.ALLATORIxDEMO("\u0011w+p\"d"), 3);
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

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[4];
            arrpage[0] = General;
            arrpage[1] = Calc;
            arrpage[2] = Rotate;
            arrpage[3] = Render;
            return arrpage;
        }
    }

    public static final class PlaceMode
    extends Enum<PlaceMode> {
        public static final /* enum */ PlaceMode NullPoint;
        public static final /* enum */ PlaceMode tick;
        private static final /* synthetic */ PlaceMode[] $VALUES;

        static {
            tick = new PlaceMode(Setting.ALLATORIxDEMO("r,/d"), 0);
            NullPoint = new PlaceMode(FrameFilter.ALLATORIxDEMO("X\u001aR!L)~)b"), 1);
            $VALUES = PlaceMode.$values();
        }

        public static PlaceMode valueOf(String a) {
            return Enum.valueOf(PlaceMode.class, a);
        }

        public static PlaceMode[] values() {
            return (PlaceMode[])$VALUES.clone();
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

        private static /* synthetic */ PlaceMode[] $values() {
            PlaceMode[] arrplaceMode = new PlaceMode[2];
            arrplaceMode[0] = tick;
            arrplaceMode[1] = NullPoint;
            return arrplaceMode;
        }
    }

    public static final class CalcMode
    extends Enum<CalcMode> {
        private static final /* synthetic */ CalcMode[] $VALUES;
        public static final /* enum */ CalcMode Wink;
        public static final /* enum */ CalcMode Edit;
        public static final /* enum */ CalcMode Thunder;
        public static final /* enum */ CalcMode OyVey;
        public static final /* enum */ CalcMode Meteor;
        public static final /* enum */ CalcMode Mio;

        public static CalcMode[] values() {
            return (CalcMode[])$VALUES.clone();
        }

        static {
            OyVey = new CalcMode(Renderer.ALLATORIxDEMO("/y+/N"), 0);
            Meteor = new CalcMode(BaseSettings.ALLATORIxDEMO("{fImS{"), 1);
            Thunder = new CalcMode(Renderer.ALLATORIxDEMO("3u\u0015n\u0019/E"), 2);
            Edit = new CalcMode(BaseSettings.ALLATORIxDEMO("xlU}"), 3);
            Mio = new CalcMode(Renderer.ALLATORIxDEMO("0#X"), 4);
            Wink = new CalcMode(BaseSettings.ALLATORIxDEMO("jaRb"), 5);
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

        private static /* synthetic */ CalcMode[] $values() {
            CalcMode[] arrcalcMode = new CalcMode[6];
            arrcalcMode[0] = OyVey;
            arrcalcMode[1] = Meteor;
            arrcalcMode[2] = Thunder;
            arrcalcMode[3] = Edit;
            arrcalcMode[4] = Mio;
            arrcalcMode[5] = Wink;
            return arrcalcMode;
        }

        public static CalcMode valueOf(String a) {
            return Enum.valueOf(CalcMode.class, a);
        }
    }

    public class AnchorRender {
        final /* synthetic */ AnchorAura this$0;

        public AnchorRender(AnchorAura anchorAura) {
            AnchorAura a = anchorAura;
            AnchorRender a2 = this;
            a2.this$0 = a;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @EventHandler
        public void onRender3D(Render3DEvent a) {
            var2_2 = a;
            if (var2_2.this$0.currentPos != null) {
                var2_2.this$0.noPosTimer.reset();
                AnchorAura.placeVec3d = var2_2.this$0.currentPos.method_46558();
            }
            if (AnchorAura.placeVec3d == null) {
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
                AnchorAura.curVec3d = null;
                return;
            }
            if (AnchorAura.curVec3d == null || var2_2.this$0.sliderSpeed.getValue() >= 1.0) {
                AnchorAura.curVec3d = AnchorAura.placeVec3d;
                v3 = var2_2;
            } else {
                AnchorAura.curVec3d = new class_243(AnimateUtil.animate(AnchorAura.curVec3d.field_1352, AnchorAura.placeVec3d.field_1352, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AnchorAura.curVec3d.field_1351, AnchorAura.placeVec3d.field_1351, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AnchorAura.curVec3d.field_1350, AnchorAura.placeVec3d.field_1350, var2_2.this$0.sliderSpeed.getValue() / 10.0));
                v3 = var2_2;
            }
            if (v3.this$0.render.getValue() == false) return;
            v4 = a = new class_238(AnchorAura.curVec3d, AnchorAura.curVec3d);
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
            if (v7.this$0.text.booleanValue == false) return;
            if (!(var2_2.this$0.lastDamage > 0.0)) return;
            v8 = new Object[1];
            v8[0] = var2_2.this$0.lastDamage;
            Render3DUtil.drawText3D(String.format(CrystalUtil.ALLATORIxDEMO("\u0004\u0004 "), v8), AnchorAura.curVec3d, var2_2.this$0.text.getValue());
            Render3DUtil.drawText3D(String.format(String.valueOf((Object)var2_2.this$0.displayTarget.method_5477()), new Object[0]), new class_243(AnchorAura.curVec3d.field_1352, AnchorAura.curVec3d.field_1351 + 0.2, AnchorAura.curVec3d.field_1350), var2_2.this$0.text.getValue());
        }
    }

    public static class PlayerAndPredict {
        public final class_1657 player;
        public final class_1657 predict;

        public PlayerAndPredict(class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.player = a;
            if (AnchorAura.INSTANCE.predictTicks.getValueFloat() > 0.0f) {
                Iterator iterator;
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Snow.ALLATORIxDEMO("6bt#\u0002S;o-e*0}&s\u0013F\"m3g\u0007H%q3e3b0j4`%q")), NpSocketClient.ALLATORIxDEMO("\\>]\u001cs9y\bb8h5rx/e"))){
                    final /* synthetic */ PlayerAndPredict this$0;
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
                        super((class_1937)a4, (class_2338)a2, (float)a3, (GameProfile)a);
                    }

                    public boolean method_7337() {
                        return false;
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, AnchorAura.INSTANCE.predictTicks.getValueInt(), true)));
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
