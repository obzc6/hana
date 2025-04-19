/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1661
 *  net.minecraft.class_1739
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2828
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_490
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.vanilla;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.ClickBlockEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.TPUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IPlayerMoveC2SPacket;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1739;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2828;
import net.minecraft.class_2846;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_490;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class VSpeedMine
extends Module {
    private final SliderSetting crystalDamage;
    private final BooleanSetting checkDamage;
    private final SliderSetting range;
    public static boolean sendGroundPacket;
    private final BooleanSetting outline;
    private final BooleanSetting bypassGround;
    public static double secondProgress;
    public static double progress;
    private final BooleanSetting autoColor;
    private final SliderSetting damage;
    public final BooleanSetting preferWeb;
    private final BooleanSetting usingPause;
    public final BooleanSetting hotBar;
    private final BooleanSetting swing;
    public final BindSetting obsidian;
    private final EnumSetting<FadeUtils.Quad> quad;
    int lastSlot;
    private final BooleanSetting crystal;
    private final SliderSetting lineWidth;
    private final BooleanSetting spamPlace;
    private final BooleanSetting onlyHeadBomber;
    private final SliderSetting placeDelay;
    public static class_2338 secondPos;
    private final SliderSetting delay;
    public final ColorSetting color;
    public final Timer secondTimer;
    private final BooleanSetting cancelPacket;
    private final SliderSetting time;
    private final Timer delayTimer;
    private final Timer placeTimer;
    public final ColorSetting endboxColor;
    private final BooleanSetting bold;
    public static class_2338 breakPos;
    static DecimalFormat df;
    public final ColorSetting endColor;
    private final SliderSetting bypassTime;
    private final BooleanSetting switchReset;
    private final BooleanSetting doubleBreak;
    private boolean startMine;
    private final BindSetting enderChest;
    private final SliderSetting maxBreak;
    private final FadeUtils secondAnim;
    private final BooleanSetting mineAir;
    private final BooleanSetting onlyGround;
    private final BooleanSetting endSwing;
    private final BooleanSetting wait;
    private final BooleanSetting text;
    private final BooleanSetting afterBreak;
    public static VSpeedMine INSTANCE;
    private final BooleanSetting rotate;
    private final BooleanSetting checkGround;
    public final BooleanSetting farCancel;
    private int breakNumber;
    private final Timer mineTimer;
    public final BooleanSetting ghostHand;
    public final ColorSetting doubleColor;
    public static final List<class_2248> godBlocks;
    private final BooleanSetting box;
    private final FadeUtils animationTime;
    private final BooleanSetting instant;
    private final BooleanSetting waitPlace;

    public void mine(class_2338 class_23382) {
        VSpeedMine a = class_23382;
        VSpeedMine a2 = this;
        if (VSpeedMine.nullCheck() || VSpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        if (a2.isOff()) {
            return;
        }
        if (godBlocks.contains((Object)VSpeedMine.mc.field_1687.method_8320((class_2338)a).method_26204())) {
            return;
        }
        if (a.equals((Object)breakPos)) {
            return;
        }
        if (breakPos != null && a2.preferWeb.getValue() && BlockUtil.getBlock(breakPos) == class_2246.field_10343) {
            return;
        }
        breakPos = a;
        a2.mineTimer.reset();
        a2.animationTime.reset();
        a2.startMine();
    }

    private /* synthetic */ void lambda$update$13() {
        VSpeedMine a;
        BlockUtil.placeBlock(breakPos, a.rotate.getValue(), true);
    }

    private /* synthetic */ boolean shouldCrystal() {
        VSpeedMine a;
        return a.crystal.getValue() && (!a.onlyHeadBomber.getValue() || a.obsidian.isPressed());
    }

    /*
     * Exception decompiling
     */
    public float getDigSpeed(class_2680 var1_2, class_1799 var2_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 1[CASE]
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

    @Override
    public void onLogin() {
        a.startMine = false;
        breakPos = null;
        secondPos = null;
    }

    private /* synthetic */ void lambda$update$15() {
        VSpeedMine a;
        BlockUtil.placeCrystal(breakPos.method_10084(), a.rotate.getValue());
    }

    @Override
    public String getInfo() {
        VSpeedMine a;
        if (a.instant.getValue()) {
            return GaussianKernel.ALLATORIxDEMO("+:5' 6>");
        }
        return BaseChildSettings.ALLATORIxDEMO("2B;Z(D1");
    }

    @Override
    public void onUpdate() {
        VSpeedMine a;
        a.update();
    }

    private /* synthetic */ void lambda$update$14() {
        VSpeedMine a;
        BlockUtil.placeBlock(breakPos, a.rotate.getValue(), true);
    }

    private static /* synthetic */ void lambda$update$18() {
        VSpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, breakPos, BlockUtil.getClickSide(breakPos)));
    }

    private static /* synthetic */ void lambda$update$17() {
        VSpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, breakPos, BlockUtil.getClickSide(breakPos)));
    }

    @Override
    public void onDisable() {
        a.startMine = false;
        breakPos = null;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a4 = f;
        VSpeedMine a2 = this;
        a2.update();
        if (!VSpeedMine.mc.field_1724.method_7337()) {
            double d;
            double d2;
            void a3;
            if (secondPos != null) {
                int a4 = a2.getTool(secondPos);
                if (a4 == -1) {
                    a4 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                }
                VSpeedMine vSpeedMine = a2;
                d = vSpeedMine.getBreakTime(secondPos, a4);
                secondProgress = (double)vSpeedMine.secondTimer.getPassedTimeMs() / d;
                if (vSpeedMine.isAir(secondPos)) {
                    secondPos = null;
                    return;
                }
                d2 = secondProgress > 1.0 ? 1.0 : secondProgress;
                VSpeedMine vSpeedMine2 = a2;
                double d3 = (1.0 - vSpeedMine2.secondAnim.getQuad(vSpeedMine2.quad.getValue())) * 0.5;
                if (!a2.bold.getValue()) {
                    double d4 = d3;
                    Render3DUtil.draw3DBox((class_4587)a3, new class_238(secondPos).method_1002(d4, d4, d4).method_1002(-d3, -d3, -d3), ColorUtil.injectAlpha(a2.doubleColor.getValue(), (int)((double)a2.doubleColor.getValue().getAlpha() * d2)), a2.outline.getValue(), a2.box.getValue());
                } else {
                    double d5 = d3;
                    Render3DUtil.drawLine(new class_238(secondPos).method_1002(d5, d5, d5).method_1002(-d3, -d3, -d3), ColorUtil.injectAlpha(a2.doubleColor.getValue(), (int)((double)a2.doubleColor.getValue().getAlpha() * d2)), a2.lineWidth.getValueInt());
                    double d6 = d3;
                    Render3DUtil.drawFill((class_4587)a3, new class_238(secondPos).method_1002(d6, d6, d6).method_1002(-d3, -d3, -d3), ColorUtil.injectAlpha(a2.doubleColor.getValue(), (int)((double)a2.doubleColor.getValue().getAlpha() * d2)));
                }
            } else {
                secondProgress = 0.0;
            }
            if (breakPos != null) {
                VSpeedMine vSpeedMine;
                double d7;
                int n = a2.getTool(breakPos);
                Object a4 = n;
                if (n == -1) {
                    a4 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                }
                VSpeedMine vSpeedMine3 = a2;
                d = vSpeedMine3.getBreakTime(breakPos, (int)a4);
                progress = (double)vSpeedMine3.mineTimer.getPassedTimeMs() / d;
                vSpeedMine3.animationTime.setLength((long)a2.getBreakTime(breakPos, (int)a4));
                VSpeedMine vSpeedMine4 = a2;
                d2 = (1.0 - vSpeedMine4.animationTime.getQuad(vSpeedMine4.quad.getValue())) * 0.5;
                Color color = a2.color.getValue();
                double d8 = d7 = progress > 1.0 ? 1.0 : progress;
                if (!a2.bold.getValue()) {
                    VSpeedMine vSpeedMine5;
                    Color color2;
                    double d9 = d2;
                    if (a2.autoColor.getValue()) {
                        color2 = new Color((int)(255.0 * d7), (int)(255.0 * d7), 0);
                        vSpeedMine5 = a2;
                    } else if (!a2.endColor.booleanValue) {
                        color2 = color;
                        vSpeedMine5 = a2;
                    } else if (d7 >= 1.0) {
                        color2 = a2.endColor.getValue();
                        vSpeedMine5 = a2;
                    } else {
                        color2 = color;
                        vSpeedMine5 = a2;
                    }
                    Render3DUtil.draw3DBox((class_4587)a3, new class_238(breakPos).method_1002(d9, d9, d9).method_1002(-d2, -d2, -d2), ColorUtil.injectAlpha(color2, (int)(!vSpeedMine5.endColor.booleanValue ? (double)color.getAlpha() * d7 : (d7 >= 1.0 ? (double)a2.endColor.getValue().getAlpha() * d7 : (double)color.getAlpha() * d7))), a2.outline.getValue(), a2.box.getValue());
                    vSpeedMine = a2;
                } else {
                    VSpeedMine vSpeedMine6;
                    Color color3;
                    Color color4;
                    VSpeedMine vSpeedMine7;
                    double d10 = d2;
                    if (a2.autoColor.getValue()) {
                        color4 = new Color((int)(255.0 * d7), (int)(255.0 * d7), 0);
                        vSpeedMine6 = a2;
                    } else if (!a2.endColor.booleanValue) {
                        color4 = color;
                        vSpeedMine6 = a2;
                    } else if (d7 >= 1.0) {
                        color4 = a2.endboxColor.getValue();
                        vSpeedMine6 = a2;
                    } else {
                        color4 = color;
                        vSpeedMine6 = a2;
                    }
                    Render3DUtil.drawLine(new class_238(breakPos).method_1002(d10, d10, d10).method_1002(-d2, -d2, -d2), ColorUtil.injectAlpha(color4, (int)(!vSpeedMine6.endColor.booleanValue ? (double)color.getAlpha() * d7 : (d7 >= 1.0 ? (double)a2.endColor.getValue().getAlpha() * d7 : (double)color.getAlpha() * d7))), a2.lineWidth.getValueInt());
                    double d11 = d2;
                    if (a2.autoColor.getValue()) {
                        color3 = new Color((int)(255.0 * d7), (int)(255.0 * d7), 0);
                        vSpeedMine7 = a2;
                    } else if (!a2.endColor.booleanValue) {
                        color3 = color;
                        vSpeedMine7 = a2;
                    } else if (d7 >= 1.0) {
                        color3 = a2.endColor.getValue();
                        vSpeedMine7 = a2;
                    } else {
                        color3 = color;
                        vSpeedMine7 = a2;
                    }
                    Render3DUtil.drawFill((class_4587)a3, new class_238(breakPos).method_1002(d11, d11, d11).method_1002(-d2, -d2, -d2), ColorUtil.injectAlpha(color3, (int)(!vSpeedMine7.endColor.booleanValue ? (double)color.getAlpha() * d7 : (d7 >= 1.0 ? (double)a2.endColor.getValue().getAlpha() * d7 : (double)color.getAlpha() * d7))));
                    vSpeedMine = a2;
                }
                if (!vSpeedMine.text.getValue()) return;
                if (a2.isAir(breakPos)) {
                    Render3DUtil.drawText3D(GaussianKernel.ALLATORIxDEMO("55/'(6-"), breakPos.method_46558(), -1);
                    return;
                }
                if ((double)((int)a2.mineTimer.getPassedTimeMs()) < d) {
                    Render3DUtil.drawText3D(df.format(progress * 100.0) + "%", breakPos.method_46558(), -1);
                    return;
                }
                Render3DUtil.drawText3D(BaseChildSettings.ALLATORIxDEMO("\rxM':["), breakPos.method_46558(), -1);
                return;
            }
            progress = 0.0;
            return;
        }
        progress = 0.0;
        secondProgress = 0.0;
    }

    private /* synthetic */ void lambda$update$16() {
        VSpeedMine a;
        BlockUtil.placeCrystal(breakPos.method_10084(), a.rotate.getValue());
    }

    private /* synthetic */ int findBlock(class_2248 class_22482) {
        VSpeedMine a = class_22482;
        VSpeedMine a2 = this;
        if (!a2.hotBar.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    private /* synthetic */ boolean canBreak(class_2338 class_23382) {
        VSpeedMine a = class_23382;
        VSpeedMine a2 = this;
        return VSpeedMine.mc.field_1687.method_8320((class_2338)a).method_26204().method_36555() != -1.0f;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doSwap(int n, int n2) {
        int a = n2;
        VSpeedMine a2 = this;
        if (a2.hotBar.getValue()) {
            void a3;
            InventoryUtil.switchToSlot((int)a3);
            return;
        }
        InventoryUtil.inventorySwap(a, VSpeedMine.mc.field_1724.method_31548().field_7545);
    }

    /*
     * WARNING - void declaration
     */
    public int getTool(class_2338 class_23382) {
        void a;
        VSpeedMine vSpeedMine = this;
        if (vSpeedMine.hotBar.getValue()) {
            int a2;
            int n = -1;
            float f = 1.0f;
            int n2 = a2 = 0;
            while (n2 < 9) {
                float f2;
                float f3;
                class_1799 class_17992 = VSpeedMine.mc.field_1724.method_31548().method_5438(a2);
                if (class_17992 != class_1799.field_8037 && (f3 = (float)class_1890.method_8225((class_1887)class_1893.field_9131, (class_1799)class_17992)) + (f2 = class_17992.method_7924(VSpeedMine.mc.field_1687.method_8320((class_2338)a))) > f) {
                    f = f3 + f2;
                    n = a2;
                }
                n2 = ++a2;
            }
            return n;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        float f = 1.0f;
        for (Map.Entry entry : InventoryUtil.getInventoryAndHotbarSlots().entrySet()) {
            float f5;
            float f4;
            if (((class_1799)entry.getValue()).method_7909() instanceof class_1739 || !((f4 = (float)class_1890.method_8225((class_1887)class_1893.field_9131, (class_1799)((class_1799)entry.getValue()))) + (f5 = ((class_1799)entry.getValue()).method_7924(VSpeedMine.mc.field_1687.method_8320((class_2338)a))) > f)) continue;
            f = f4 + f5;
            atomicInteger.set((Integer)entry.getKey());
        }
        return atomicInteger.get();
    }

    private /* synthetic */ int findCrystal() {
        VSpeedMine a;
        if (!a.hotBar.getValue()) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return InventoryUtil.findItem(class_1802.field_8301);
    }

    private /* synthetic */ void startMine() {
        VSpeedMine a2;
        VSpeedMine vSpeedMine = a2;
        if (vSpeedMine.rotate.getValue()) {
            a2 = BlockUtil.getClickSide(breakPos).method_10163();
            EntityUtil.faceVector(breakPos.method_46558().method_1019(new class_243((double)a2.method_10263() * 0.5, (double)a2.method_10264() * 0.5, (double)a2.method_10260() * 0.5)));
        }
        TPUtil.tp(() -> VSpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, breakPos, BlockUtil.getClickSide(breakPos))), breakPos.method_46558());
        if (vSpeedMine.doubleBreak.getValue()) {
            if (secondPos == null || vSpeedMine.isAir(secondPos)) {
                int a2 = vSpeedMine.getTool(breakPos);
                if (a2 == -1) {
                    a2 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                }
                VSpeedMine vSpeedMine2 = vSpeedMine;
                double d = vSpeedMine2.getBreakTime(breakPos, a2, 1.0);
                vSpeedMine2.secondAnim.reset();
                VSpeedMine vSpeedMine3 = vSpeedMine;
                vSpeedMine3.secondAnim.setLength((long)d);
                vSpeedMine3.secondTimer.reset();
                secondPos = breakPos;
            }
            TPUtil.tp(() -> VSpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, breakPos, BlockUtil.getClickSide(breakPos))), breakPos.method_46558());
            TPUtil.tp(() -> VSpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, breakPos, BlockUtil.getClickSide(breakPos))), breakPos.method_46558());
        }
        if (vSpeedMine.swing.getValue()) {
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
        vSpeedMine.breakNumber = 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void update() {
        block57 : {
            var2_6 = a;
            if (VSpeedMine.nullCheck()) {
                return;
            }
            if (VSpeedMine.mc.field_1724.method_29504()) {
                VSpeedMine.secondPos = null;
            }
            if (VSpeedMine.secondPos != null && var2_6.secondTimer.passed(var2_6.getBreakTime(VSpeedMine.secondPos, VSpeedMine.mc.field_1724.method_31548().field_7545, 1.3))) {
                VSpeedMine.secondPos = null;
            }
            if (VSpeedMine.secondPos != null && var2_6.isAir(VSpeedMine.secondPos)) {
                VSpeedMine.secondPos = null;
            }
            if (VSpeedMine.mc.field_1724.method_7337()) {
                v0 = var2_6;
                v0.startMine = false;
                v0.breakNumber = 0;
                VSpeedMine.breakPos = null;
                return;
            }
            if (VSpeedMine.breakPos == null) {
                v1 = var2_6;
                v1.breakNumber = 0;
                v1.startMine = false;
                return;
            }
            if (var2_6.isAir(VSpeedMine.breakPos)) {
                var2_6.breakNumber = 0;
            }
            if ((double)var2_6.breakNumber > var2_6.maxBreak.getValue() - 1.0 && var2_6.maxBreak.getValue() > 0.0 || !var2_6.wait.getValue() && var2_6.isAir(VSpeedMine.breakPos) && !var2_6.instant.getValue()) {
                if (VSpeedMine.breakPos.equals((Object)VSpeedMine.secondPos)) {
                    VSpeedMine.secondPos = null;
                }
                var2_6.startMine = false;
                var2_6.breakNumber = false ? 1 : 0;
                VSpeedMine.breakPos = null;
                return;
            }
            if (VSpeedMine.godBlocks.contains((Object)VSpeedMine.mc.field_1687.method_8320(VSpeedMine.breakPos).method_26204())) {
                VSpeedMine.breakPos = null;
                var2_6.startMine = false;
                return;
            }
            if (var2_6.usingPause.getValue() && EntityUtil.isUsing()) {
                return;
            }
            if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(VSpeedMine.breakPos.method_46558()))) > var2_6.range.getValue()) {
                if (var2_6.farCancel.getValue() == false) return;
                v2 = var2_6;
                v2.startMine = false;
                v2.breakNumber = 0;
                VSpeedMine.breakPos = null;
                return;
            }
            if (VSpeedMine.breakPos.equals((Object)AnchorAura.INSTANCE.currentPos)) {
                return;
            }
            if (!(var2_6.hotBar.getValue() || VSpeedMine.mc.field_1755 == null || VSpeedMine.mc.field_1755 instanceof class_408 || VSpeedMine.mc.field_1755 instanceof class_490 || VSpeedMine.mc.field_1755 instanceof ClickGuiScreen)) {
                return;
            }
            var4_7 = var2_6.getTool(VSpeedMine.breakPos);
            if (var4_7 == -1) {
                var4_7 = VSpeedMine.mc.field_1724.method_31548().field_7545;
            }
            if (var2_6.isAir(VSpeedMine.breakPos)) {
                if (var2_6.shouldCrystal()) {
                    a = class_2350.values();
                    var3_8 = a.length;
                    v3 = var1_10 = 0;
                    while (v3 < var3_8) {
                        var5_15 = a[var1_10];
                        CombatUtil.attackCrystal(VSpeedMine.breakPos.method_10093(var5_15), var2_6.rotate.getValue(), true);
                        v3 = ++var1_10;
                    }
                }
                v4 = var2_6;
                if (v4.placeTimer.passedMs(v4.placeDelay.getValue()) && BlockUtil.canPlace(VSpeedMine.breakPos) && VSpeedMine.mc.field_1755 == null) {
                    if (var2_6.enderChest.isPressed()) {
                        a = var2_6.findBlock(class_2246.field_10443);
                        if (a != -1) {
                            var3_8 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                            v5 = var2_6;
                            v6 = a;
                            v5.doSwap(v6, v6);
                            TPUtil.tp((java.lang.Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, lambda$update$13(), ()V)((VSpeedMine)v5), VSpeedMine.breakPos.method_46558());
                            v7 = var2_6;
                            v7.doSwap(var3_8, a);
                            v7.placeTimer.reset();
                        }
                    } else if (var2_6.obsidian.isPressed() && (a = var2_6.findBlock(class_2246.field_10540)) != -1) {
                        var3_8 = 0;
                        if (var2_6.shouldCrystal()) {
                            for (class_2350 var5_15 : VSpeedMine.mc.field_1687.method_18467(class_1297.class, new class_238(VSpeedMine.breakPos.method_10084()))) {
                                if (!(var5_15 instanceof class_1511)) continue;
                                v8 = var3_8 = 1;
                                break;
                            }
                        } else {
                            v8 = var3_8;
                        }
                        if (v8 == 0 || var2_6.spamPlace.getValue()) {
                            var1_12 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                            v9 = var2_6;
                            v10 = a;
                            v9.doSwap(v10, v10);
                            TPUtil.tp((java.lang.Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, lambda$update$14(), ()V)((VSpeedMine)v9), VSpeedMine.breakPos.method_46558());
                            v11 = var2_6;
                            v11.doSwap(var1_12, a);
                            v11.placeTimer.reset();
                        }
                    }
                }
                v12 = var2_6;
                var2_6.breakNumber = 0;
            } else {
                if (VSpeedMine.canPlaceCrystal(VSpeedMine.breakPos.method_10084(), true)) {
                    if (var2_6.waitPlace.getValue()) {
                        a = class_2350.values();
                        var3_8 = a.length;
                        v13 = var1_13 = 0;
                        while (v13 < var3_8) {
                            var5_15 = a[var1_13];
                            if (VSpeedMine.breakPos.method_10093(var5_15).equals((Object)HanaAura.crystalPos)) {
                                if (!HanaAura.INSTANCE.canPlaceCrystal(HanaAura.crystalPos, false, false)) break;
                                return;
                            }
                            v13 = ++var1_13;
                        }
                    }
                    if (var2_6.shouldCrystal()) {
                        v14 = var2_6;
                        if (v14.placeTimer.passedMs(v14.placeDelay.getValue())) {
                            if (var2_6.checkDamage.getValue()) {
                                if ((double)var2_6.mineTimer.getPassedTimeMs() / var2_6.getBreakTime(VSpeedMine.breakPos, var4_7) >= var2_6.crystalDamage.getValue() && (a = var2_6.findCrystal()) != -1) {
                                    var3_8 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                                    v15 = var2_6;
                                    v16 = a;
                                    v15.doSwap(v16, v16);
                                    TPUtil.tp((java.lang.Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, lambda$update$15(), ()V)((VSpeedMine)v15), VSpeedMine.breakPos.method_46558());
                                    v17 = var2_6;
                                    v17.doSwap(var3_8, a);
                                    v17.placeTimer.reset();
                                    if (var2_6.waitPlace.getValue()) {
                                        return;
                                    }
                                }
                            } else {
                                a = var2_6.findCrystal();
                                if (a != -1) {
                                    var3_8 = VSpeedMine.mc.field_1724.method_31548().field_7545;
                                    v18 = var2_6;
                                    v19 = a;
                                    v18.doSwap(v19, v19);
                                    TPUtil.tp((java.lang.Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, lambda$update$16(), ()V)((VSpeedMine)v18), VSpeedMine.breakPos.method_46558());
                                    v20 = var2_6;
                                    v20.doSwap(var3_8, a);
                                    v20.placeTimer.reset();
                                    if (var2_6.waitPlace.getValue()) {
                                        return;
                                    }
                                }
                            }
                        } else if (var2_6.startMine) {
                            return;
                        }
                    }
                }
                v12 = var2_6;
            }
            if (!v12.delayTimer.passedMs((long)var2_6.delay.getValue())) {
                return;
            }
            if (!var2_6.startMine) break block57;
            if (var2_6.isAir(VSpeedMine.breakPos)) {
                return;
            }
            if (var2_6.onlyGround.getValue() && !VSpeedMine.mc.field_1724.method_24828()) {
                return;
            }
            if (var2_6.mineTimer.passedMs((long)var2_6.getBreakTime(VSpeedMine.breakPos, var4_7)) == false) return;
            a = VSpeedMine.mc.field_1724.method_31548().field_7545;
            if (var2_6.hotBar.getValue()) {
                v21 = var3_8 = var4_7 != a ? 1 : 0;
            } else {
                if (var4_7 < 9) {
                    var4_7 += 36;
                }
                v21 = var3_8 = a + 36 != var4_7 ? 1 : 0;
            }
            if (v21 == 0) ** GOTO lbl168
            v22 = var4_7;
            if (var2_6.hotBar.getValue()) {
                InventoryUtil.switchToSlot(v22);
                v23 = var2_6;
            } else {
                InventoryUtil.inventorySwap(v22, VSpeedMine.mc.field_1724.method_31548().field_7545);
lbl168: // 2 sources:
                v23 = var2_6;
            }
            if (v23.rotate.getValue()) {
                EntityUtil.facePosSide(VSpeedMine.breakPos, BlockUtil.getClickSide(VSpeedMine.breakPos));
            }
            if (var2_6.endSwing.getValue()) {
                EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
            }
            TPUtil.tp((java.lang.Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, lambda$update$17(), ()V)(), VSpeedMine.breakPos.method_46558());
            if (var3_8 == 0 || !var2_6.ghostHand.getValue()) ** GOTO lbl182
            if (var2_6.hotBar.getValue()) {
                InventoryUtil.switchToSlot(a);
                v24 = var2_6;
            } else {
                InventoryUtil.inventorySwap(var4_7, VSpeedMine.mc.field_1724.method_31548().field_7545);
                EntityUtil.syncInventory();
lbl182: // 2 sources:
                v24 = var2_6;
            }
            ++v24.breakNumber;
            v25 = var2_6;
            v25.delayTimer.reset();
            if (v25.afterBreak.getValue() == false) return;
            if (var2_6.shouldCrystal() == false) return;
            var1_14 = class_2350.values();
            var5_16 = var1_14.length;
            v26 = a = 0;
            while (v26 < var5_16) {
                var3_9 = var1_14[a];
                CombatUtil.attackCrystal(VSpeedMine.breakPos.method_10093(var3_9), var2_6.rotate.getValue(), true);
                v26 = ++a;
            }
            return;
        }
        if (!var2_6.mineAir.getValue() && var2_6.isAir(VSpeedMine.breakPos)) {
            return;
        }
        v27 = var2_6;
        v28 = var2_6;
        v27.animationTime.setLength((long)v28.getBreakTime(VSpeedMine.breakPos, var4_7));
        v28.mineTimer.reset();
        if (v27.swing.getValue()) {
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
        TPUtil.tp((java.lang.Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, lambda$update$18(), ()V)(), VSpeedMine.breakPos.method_46558());
        var2_6.delayTimer.reset();
    }

    private static /* synthetic */ void faceVector(class_243 a, RotateEvent a2) {
        float[] arrf = a;
        a = EntityUtil.getLegitRotations((class_243)arrf);
        a2.setRotation(a[0], a[1]);
    }

    static {
        class_2248[] arrclass_2248 = new class_2248[10];
        arrclass_2248[0] = class_2246.field_10525;
        arrclass_2248[1] = class_2246.field_27098;
        arrclass_2248[2] = class_2246.field_10164;
        arrclass_2248[3] = class_2246.field_27097;
        arrclass_2248[4] = class_2246.field_10382;
        arrclass_2248[5] = class_2246.field_9987;
        arrclass_2248[6] = class_2246.field_10499;
        arrclass_2248[7] = class_2246.field_10027;
        arrclass_2248[8] = class_2246.field_10316;
        arrclass_2248[9] = class_2246.field_10398;
        godBlocks = Arrays.asList(arrclass_2248);
        progress = 0.0;
        secondProgress = 0.0;
        sendGroundPacket = false;
        df = new DecimalFormat(GaussianKernel.ALLATORIxDEMO("qvz"));
    }

    private /* synthetic */ boolean isAir(class_2338 class_23382) {
        VSpeedMine a = class_23382;
        VSpeedMine a2 = this;
        return VSpeedMine.mc.field_1687.method_22347((class_2338)a) || BlockUtil.getBlock((class_2338)a) == class_2246.field_10036 && BlockUtil.hasCrystal((class_2338)a);
    }

    @EventHandler(priority=-100)
    public void onRotate(RotateEvent a) {
        VSpeedMine a22;
        VSpeedMine vSpeedMine = a22;
        if (VSpeedMine.nullCheck() || VSpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        if (vSpeedMine.onlyGround.getValue() && !VSpeedMine.mc.field_1724.method_24828()) {
            return;
        }
        if (vSpeedMine.rotate.getValue() && breakPos != null && !vSpeedMine.isAir(breakPos) && vSpeedMine.time.getValue() > 0.0) {
            double d;
            if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(breakPos.method_46558()))) > vSpeedMine.range.getValue()) {
                return;
            }
            int a22 = vSpeedMine.getTool(breakPos);
            if (a22 == -1) {
                a22 = VSpeedMine.mc.field_1724.method_31548().field_7545;
            }
            if ((d = vSpeedMine.getBreakTime(breakPos, a22) - vSpeedMine.time.getValue()) <= 0.0 || vSpeedMine.mineTimer.passedMs((long)d)) {
                VSpeedMine.facePosFacing(breakPos, BlockUtil.getClickSide(breakPos), a);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void facePosFacing(class_2338 class_23382, class_2350 class_23502, RotateEvent rotateEvent) {
        void a;
        class_2338 a2 = class_23502;
        class_2338 a3 = class_23382;
        VSpeedMine.faceVector(a3.method_46558().method_1019(new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5)), (RotateEvent)a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean noEntity(class_2338 a, boolean a2) {
        Object object = a;
        a = VSpeedMine.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)object)).iterator();
        block0 : do {
            Object object2 = a;
            while (object2.hasNext()) {
                class_1297 class_12972 = (class_1297)a.next();
                if (class_12972 instanceof class_1542 && a2) continue block0;
                if (!(class_12972 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return false;
                object2 = a;
            }
            break;
        } while (true);
        return true;
    }

    public static boolean canPlaceCrystal(class_2338 a, boolean a2) {
        class_2338 class_23382 = a;
        class_2338 class_23383 = class_23382.method_10074();
        a = class_23383.method_10084();
        return !(BlockUtil.getBlock(class_23383) != class_2246.field_9987 && BlockUtil.getBlock(class_23383) != class_2246.field_10540 || BlockUtil.getClickSideStrict(class_23383) == null || !VSpeedMine.noEntity(a, a2) || !VSpeedMine.noEntity(a.method_10084(), a2) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a.method_10084()) != class_2246.field_10124);
    }

    @EventHandler
    public void onAttackBlock(ClickBlockEvent clickBlockEvent) {
        ClickBlockEvent a = clickBlockEvent;
        VSpeedMine a2 = this;
        if (VSpeedMine.nullCheck() || VSpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        a.cancel();
        if (godBlocks.contains((Object)VSpeedMine.mc.field_1687.method_8320(a.getBlockPos()).method_26204())) {
            return;
        }
        if (a.getBlockPos().equals((Object)breakPos)) {
            return;
        }
        breakPos = a.getBlockPos();
        a2.mineTimer.reset();
        a2.animationTime.reset();
        if (godBlocks.contains((Object)VSpeedMine.mc.field_1687.method_8320(a.getBlockPos()).method_26204())) {
            return;
        }
        a2.startMine();
    }

    /*
     * WARNING - void declaration
     */
    public final double getBreakTime(class_2338 class_23382, int n, double d) {
        void a;
        void a2;
        int a3 = n;
        VSpeedMine a4 = this;
        return (double)(1.0f / a4.getBlockStrength((class_2338)a2, VSpeedMine.mc.field_1724.method_31548().method_5438(a3)) / 20.0f * 1000.0f) * a;
    }

    /*
     * WARNING - void declaration
     */
    public final double getBreakTime(class_2338 class_23382, int n) {
        void a;
        VSpeedMine a2;
        int a3 = n;
        VSpeedMine vSpeedMine = a2 = this;
        return vSpeedMine.getBreakTime((class_2338)a, a3, vSpeedMine.damage.getValue());
    }

    @EventHandler(priority=-200)
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        VSpeedMine a2 = this;
        if (VSpeedMine.nullCheck() || VSpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        if (a.getPacket() instanceof class_2828) {
            if (a2.bypassGround.getValue() && breakPos != null && !a2.isAir(breakPos) && a2.bypassTime.getValue() > 0.0 && class_3532.method_15355((float)((float)breakPos.method_46558().method_1025(EntityUtil.getEyesPos()))) <= a2.range.getValueFloat() + 2.0f) {
                double d;
                int n = a2.getTool(breakPos);
                if (n == -1) {
                    n = VSpeedMine.mc.field_1724.method_31548().field_7545;
                }
                if ((d = a2.getBreakTime(breakPos, n) - a2.bypassTime.getValue()) <= 0.0 || a2.mineTimer.passedMs((long)d)) {
                    sendGroundPacket = true;
                    ((IPlayerMoveC2SPacket)a.getPacket()).setOnGround(true);
                    return;
                }
            } else {
                sendGroundPacket = false;
            }
            return;
        }
        Object t = a.getPacket();
        if (t instanceof class_2868) {
            class_2868 class_28682 = (class_2868)t;
            if (class_28682.method_12442() != a2.lastSlot) {
                a2.lastSlot = class_28682.method_12442();
                if (a2.switchReset.getValue()) {
                    a2.startMine = false;
                    a2.mineTimer.reset();
                    a2.animationTime.reset();
                }
            }
            return;
        }
        if (!(a.getPacket() instanceof class_2846)) {
            return;
        }
        if (((class_2846)a.getPacket()).method_12363() == class_2846.class_2847.field_12968) {
            if (breakPos == null || !((class_2846)a.getPacket()).method_12362().equals((Object)breakPos)) {
                if (a2.cancelPacket.getValue()) {
                    a.cancel();
                }
                return;
            }
            a2.startMine = true;
            return;
        }
        if (((class_2846)a.getPacket()).method_12363() == class_2846.class_2847.field_12973) {
            if (breakPos == null || !((class_2846)a.getPacket()).method_12362().equals((Object)breakPos)) {
                if (a2.cancelPacket.getValue()) {
                    a.cancel();
                }
                return;
            }
            if (!a2.instant.getValue()) {
                a2.startMine = false;
            }
        }
    }

    public VSpeedMine() {
        VSpeedMine a;
        VSpeedMine vSpeedMine = a;
        super(GaussianKernel.ALLATORIxDEMO("\u000f\u0018\u0000\u00071\"\u001e(6/"), Module.Category.Combat);
        VSpeedMine vSpeedMine2 = a;
        vSpeedMine2.delay = vSpeedMine.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("\u0017_\"\u0011}"), 50.0, 0.0, 500.0, 1.0));
        vSpeedMine.damage = vSpeedMine.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0010'> ?/"), 0.699999988079071, 0.0, 2.0, 0.01));
        vSpeedMine.range = vSpeedMine.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("\u0001[ \u0017a"), 60.0, 3.0, 300.0, 0.1));
        vSpeedMine.maxBreak = vSpeedMine.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("=\u0003,\u0004!$9!"), 3.0, 0.0, 20.0, 1.0));
        vSpeedMine.preferWeb = vSpeedMine.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0003R1A6H\u0019\u0015f"), true));
        vSpeedMine.instant = vSpeedMine.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("+:5' 6>"), false));
        vSpeedMine.cancelPacket = vSpeedMine.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("1gI0E8w2Y%\u0015p"), false));
        vSpeedMine.wait = vSpeedMine.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0004 1>"), true, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return !a2.instant.getValue();
        }));
        a.mineAir = a.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0019N=_\u000f\u0019v"), true, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.wait.getValue();
        }));
        VSpeedMine vSpeedMine3 = a;
        vSpeedMine3.farCancel = vSpeedMine3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\r\u0011\u0010\u0017'=\"=&"), false));
        vSpeedMine3.hotBar = vSpeedMine3.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("o<T6F!i9\u0011t"), false));
        vSpeedMine3.ghostHand = vSpeedMine3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\f\u0018\r'2\u001b 6."), true));
        vSpeedMine3.checkGround = vSpeedMine3.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("EO6C?`!U;\u001e`"), true));
        vSpeedMine3.onlyGround = vSpeedMine3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0016%\u001c\u001b\u00134<46."), true));
        vSpeedMine3.doubleBreak = vSpeedMine3.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("BH&B8B\u0011H+\u0011o"), true));
        vSpeedMine3.usingPause = vSpeedMine3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\f8\u0019\f3\u001624+/"), false));
        vSpeedMine3.swing = vSpeedMine3.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0000M'\u001ec"), true));
        vSpeedMine3.endSwing = vSpeedMine3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("5\f0\u0015$(6-"), false));
        vSpeedMine3.bypassGround = vSpeedMine3.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("0W2S'`!U;\u001e`"), true));
        vSpeedMine3.bypassTime = vSpeedMine3.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u001b2\u0000\u0003'5\u0007(5/"), 400, 0, 2000, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.bypassGround.getValue();
        }));
        VSpeedMine vSpeedMine4 = a;
        vSpeedMine4.rotate = vSpeedMine4.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("u<N/\u0004a"), true));
        vSpeedMine4.time = vSpeedMine4.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0007(5/"), 100, 0, 2000, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.rotate.getValue();
        }));
        VSpeedMine vSpeedMine5 = a;
        vSpeedMine5.switchReset = vSpeedMine5.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("UP:T7O\u0001_=\u0015p"), false));
        vSpeedMine5.crystal = vSpeedMine5.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("!&? 59&"), false).setParent());
        vSpeedMine5.onlyHeadBomber = vSpeedMine5.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("d1\u001eo6A0e<W,\u0015v"), false, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.waitPlace = a.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u001c\u0011\u000b \u0016? ;/"), false, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.spamPlace = a.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0000P5J\u0003V/\u0013a"), false, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.afterBreak = a.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0018-\u0004\u0007&\u0004!$9!"), true, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.checkDamage = a.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("o:\u0006cD'p&H4H+\u0003w"), true, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.crystalDamage = a.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO(" \u0010;!!$+9"), 0.699999988079071, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.crystal.isOpen() && a2.checkDamage.getValue();
        }));
        VSpeedMine vSpeedMine6 = a;
        vSpeedMine6.obsidian = vSpeedMine6.add(new BindSetting(BaseChildSettings.ALLATORIxDEMO("o6T:^'\u0011j"), -1));
        vSpeedMine6.enderChest = vSpeedMine6.add(new BindSetting(GaussianKernel.ALLATORIxDEMO("\u001c%\u0014\u0007&\u0005;$+>"), -1));
        vSpeedMine6.placeDelay = vSpeedMine6.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("w?A7B\u0017_\"\u0011}"), 100, 0, 1000));
        vSpeedMine6.quad = vSpeedMine6.add(new EnumSetting<FadeUtils.Quad>(GaussianKernel.ALLATORIxDEMO("\u000249."), FadeUtils.Quad.In));
        vSpeedMine6.autoColor = vSpeedMine6.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0012U H\u0010U\"\u001fv"), true));
        vSpeedMine6.color = vSpeedMine6.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("\u0005<-78"), new Color(255, 255, 255, 100)));
        vSpeedMine6.endColor = vSpeedMine6.add(new ColorSetting(BaseChildSettings.ALLATORIxDEMO("e:C\u0010U\"\u001fv"), new Color(25, 255, 50, 100))).injectBoolean(false);
        vSpeedMine6.endboxColor = vSpeedMine6.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("\u000f7/2\r,\u0005<-78"), new Color(25, 255, 50, 100), object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.endColor.booleanValue;
        }));
        a.doubleColor = a.add(new ColorSetting(BaseChildSettings.ALLATORIxDEMO("BH&B8B\u0010U\"\u001fv"), new Color(88, 94, 255, 100), object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.doubleBreak.getValue();
        }));
        VSpeedMine vSpeedMine7 = a;
        vSpeedMine7.bold = vSpeedMine7.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0011.4."), false)).setParent();
        vSpeedMine7.lineWidth = vSpeedMine7.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("\u001fI:B\u0004S*\u0004l"), 4, 1, 5, object -> {
            Object a = object;
            VSpeedMine a2 = this;
            return a2.bold.isOpen();
        }));
        VSpeedMine vSpeedMine8 = a;
        VSpeedMine vSpeedMine9 = a;
        VSpeedMine vSpeedMine10 = a;
        VSpeedMine vSpeedMine11 = a;
        VSpeedMine vSpeedMine12 = a;
        VSpeedMine vSpeedMine13 = a;
        vSpeedMine13.text = vSpeedMine13.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0007$ >"), true));
        vSpeedMine13.box = vSpeedMine13.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\f\u001f|"), true));
        vSpeedMine12.outline = vSpeedMine13.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("-!2?(6/"), true));
        vSpeedMine11.lastSlot = -1;
        vSpeedMine12.mineTimer = new Timer();
        vSpeedMine11.animationTime = new FadeUtils(1000L);
        vSpeedMine11.secondAnim = new FadeUtils(1000L);
        vSpeedMine10.startMine = false;
        vSpeedMine9.breakNumber = 0;
        vSpeedMine10.secondTimer = new Timer();
        vSpeedMine9.delayTimer = new Timer();
        vSpeedMine8.placeTimer = new Timer();
        vSpeedMine8.setChinese(BaseChildSettings.ALLATORIxDEMO("\u53cc\u7272\u539f\u5375\u6312"));
        INSTANCE = vSpeedMine8;
    }

    /*
     * WARNING - void declaration
     */
    public float getBlockStrength(class_2338 class_23382, class_1799 class_17992) {
        void a;
        void a2;
        float f;
        VSpeedMine vSpeedMine = this;
        class_2680 class_26802 = VSpeedMine.mc.field_1687.method_8320((class_2338)a2);
        float a3 = class_26802.method_26214((class_1922)VSpeedMine.mc.field_1687, (class_2338)a2);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!vSpeedMine.canBreak((class_2338)a2)) {
            return vSpeedMine.getDigSpeed(class_26802, (class_1799)a) / a3 / 100.0f;
        }
        return vSpeedMine.getDigSpeed(class_26802, (class_1799)a) / a3 / 30.0f;
    }

    public float getDestroySpeed(class_2680 a, class_1799 a2) {
        VSpeedMine a222;
        VSpeedMine vSpeedMine = a222;
        float a222 = 1.0f;
        if (a2 != null && !a2.method_7960()) {
            a222 *= a2.method_7924(a);
        }
        return a222;
    }
}
