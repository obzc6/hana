/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1661
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_2244
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2480
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1661;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2244;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2480;
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseSettings;

public class ChestStealer
extends Module {
    private final SliderSetting turtle;
    class_2338 openPos;
    private final SliderSetting disableTime;
    private final SliderSetting speed;
    private final SliderSetting anchor;
    private final BooleanSetting inventory;
    final int[] stealCountList;
    private final SliderSetting totem;
    private final SliderSetting web;
    private final Timer timer;
    private final SliderSetting bed;
    public final BooleanSetting rotate;
    private final SliderSetting redstone;
    private final SliderSetting pearl;
    private final BooleanSetting open;
    private final SliderSetting obsidian;
    private final SliderSetting glowstone;
    private final SliderSetting minRange;
    class_2338 placePos;
    private final SliderSetting gapple;
    private final Timer disableTimer;
    private final SliderSetting exp;
    private final BooleanSetting autoDisable;
    private final SliderSetting crystal;
    private final BooleanSetting smart;
    private final BooleanSetting mine;
    boolean opend;
    private final BooleanSetting take;
    private final BooleanSetting place;
    private final SliderSetting piston;
    private final SliderSetting range;
    private final BooleanSetting preferOpen;

    public ChestStealer() {
        ChestStealer a;
        ChestStealer chestStealer = a;
        super(BaseSettings.ALLATORIxDEMO("npYzL^Ae]eNl"), Module.Category.Player);
        ChestStealer chestStealer2 = a;
        chestStealer2.autoDisable = chestStealer.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("jcN}zv@wXmH"), true));
        chestStealer.disableTime = chestStealer.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("\\UzYoYeh`F{"), 500, 0, 1000));
        chestStealer.rotate = chestStealer.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("M\\b[uH"), true));
        chestStealer.place = chestStealer.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("PPhH{"), true));
        chestStealer.inventory = chestStealer.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("Ei]sTfQmJEM`]"), true));
        chestStealer.preferOpen = chestStealer.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("llJkPrsyNp"), true));
        chestStealer.open = chestStealer.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("YJdC"), true));
        chestStealer.range = chestStealer.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("R]gL{"), 4.0, 0.0, 6.0, 0.1));
        chestStealer.minRange = chestStealer.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("_WqawTfH"), 1.0, 0.0, 3.0, 0.1));
        chestStealer.mine = chestStealer.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("q`E{"), true));
        chestStealer.take = chestStealer.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("B[jH"), true));
        chestStealer.smart = chestStealer.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("SQhYj"), true, a.take::getValue).setParent());
        a.crystal = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("}mJeN`A"), 256, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.exp = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("LSn"), 256, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.totem = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("gyNd@"), 6, 0, 36, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.gapple = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("raLyG{"), 128, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.obsidian = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("]\\lZrS`C"), 64, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.web = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("^N|"), 64, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.glowstone = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("}~Qh@bUoH"), 256, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.anchor = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("tn_aDl"), 256, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.pearl = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("cs[sA"), 16, 0, 64, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.piston = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("eiO}Dp"), 128, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.redstone = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("@[{`bUoH"), 128, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.bed = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("KNz"), 256, 0, 512, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.speed = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("}`Wr`f_dI"), 1, 0, 8, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.turtle = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("auN}G{"), 1, 0, 8, object -> {
            Object a = object;
            ChestStealer a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        ChestStealer chestStealer3 = a;
        ChestStealer chestStealer4 = a;
        int[] arrn = new int[14];
        arrn[0] = 0;
        arrn[1] = 0;
        arrn[2] = 0;
        arrn[3] = 0;
        arrn[4] = 0;
        arrn[5] = 0;
        arrn[6] = 0;
        arrn[7] = 0;
        arrn[8] = 0;
        arrn[9] = 0;
        arrn[10] = 0;
        arrn[11] = 0;
        arrn[12] = 0;
        arrn[13] = 0;
        chestStealer4.stealCountList = arrn;
        chestStealer4.timer = new Timer();
        chestStealer3.placePos = null;
        chestStealer3.disableTimer = new Timer();
        chestStealer3.opend = false;
    }

    private /* synthetic */ void placeBlock(class_2338 class_23382) {
        ChestStealer a = class_23382;
        ChestStealer a2 = this;
        BlockUtil.clickBlock(a.method_10093(class_2350.field_11033), class_2350.field_11036, a2.rotate.getValue());
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onUpdate() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 2[WHILELOOP]
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
    public void onEnable() {
        ChestStealer a;
        ChestStealer chestStealer = a;
        chestStealer.openPos = null;
        chestStealer.disableTimer.reset();
        chestStealer.placePos = null;
        if (ChestStealer.nullCheck()) {
            return;
        }
        int n = ChestStealer.mc.field_1724.method_31548().field_7545;
        if (!chestStealer.place.getValue()) {
            return;
        }
        double d = 100.0;
        ChestStealer chestStealer2 = null;
        Iterator<class_2338> iterator = BlockUtil.getSphere((float)chestStealer.range.getValue()).iterator();
        block0 : do {
            Iterator<class_2338> iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = iterator.next();
                if (!ChestStealer.mc.field_1687.method_22347(a.method_10084())) {
                    iterator2 = iterator;
                    continue;
                }
                if (chestStealer.preferOpen.getValue() && ChestStealer.mc.field_1687.method_8320((class_2338)a).method_26204() instanceof class_2480) {
                    return;
                }
                if ((double)class_3532.method_15355((float)((float)ChestStealer.mc.field_1724.method_5707(a.method_46558()))) < chestStealer.minRange.getValue()) {
                    iterator2 = iterator;
                    continue;
                }
                if (!BlockUtil.clientCanPlace((class_2338)a, false) || !BlockUtil.isStrictDirection(a.method_10093(class_2350.field_11033), class_2350.field_11036)) continue block0;
                if (!BlockUtil.canClick(a.method_10093(class_2350.field_11033))) {
                    iterator2 = iterator;
                    continue;
                }
                if (chestStealer2 != null && !((double)class_3532.method_15355((float)((float)ChestStealer.mc.field_1724.method_5707(a.method_46558()))) < d)) continue block0;
                d = class_3532.method_15355((float)((float)ChestStealer.mc.field_1724.method_5707(a.method_46558())));
                chestStealer2 = a;
                continue block0;
            }
            break;
        } while (true);
        if (chestStealer2 != null) {
            ChestStealer chestStealer3;
            if (chestStealer.findShulker() == -1) {
                CommandManager.sendChatMessage(BOEntityUtils.ALLATORIxDEMO("\u0090uto\ftCU`lNdX}F?UyOoI"));
                return;
            }
            ChestStealer chestStealer4 = chestStealer;
            if (chestStealer.inventory.getValue()) {
                int n2 = chestStealer4.findShulker();
                InventoryUtil.inventorySwap(n2, n);
                chestStealer3 = chestStealer;
                ChestStealer chestStealer5 = chestStealer2;
                chestStealer.placeBlock((class_2338)chestStealer5);
                chestStealer.placePos = chestStealer5;
                InventoryUtil.inventorySwap(n2, n);
            } else {
                InventoryUtil.switchToSlot(chestStealer4.findShulker());
                chestStealer3 = chestStealer;
                ChestStealer chestStealer6 = chestStealer2;
                chestStealer.placeBlock((class_2338)chestStealer6);
                chestStealer.placePos = chestStealer6;
                InventoryUtil.switchToSlot(n);
            }
            chestStealer3.timer.reset();
            return;
        }
        CommandManager.sendChatMessage(BaseSettings.ALLATORIxDEMO("\u00bdLj%a)dp\rhf^N}\u001cyW~\u0015fS|Ez"));
    }

    @Override
    public void onDisable() {
        ChestStealer a;
        a.opend = false;
        if (a.mine.getValue() && a.placePos != null) {
            SpeedMine.INSTANCE.mine(a.placePos);
        }
    }

    private /* synthetic */ void disable2() {
        ChestStealer a;
        ChestStealer chestStealer = a;
        if (chestStealer.disableTimer.passedMs(chestStealer.disableTime.getValueInt())) {
            a.disable();
        }
    }

    private /* synthetic */ boolean needSteal(class_1799 class_17992) {
        ChestStealer a = class_17992;
        ChestStealer a2 = this;
        if (a.method_7909().equals((Object)class_1802.field_8301) && a2.stealCountList[0] > 0) {
            a2.stealCountList[0] = a2.stealCountList[0] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8287) && a2.stealCountList[1] > 0) {
            a2.stealCountList[true] = a2.stealCountList[1] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8288) && a2.stealCountList[2] > 0) {
            a2.stealCountList[2] = a2.stealCountList[2] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8367) && a2.stealCountList[3] > 0) {
            a2.stealCountList[3] = a2.stealCountList[3] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_2246.field_10540.method_8389()) && a2.stealCountList[4] > 0) {
            a2.stealCountList[4] = a2.stealCountList[4] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_2246.field_10343.method_8389()) && a2.stealCountList[5] > 0) {
            a2.stealCountList[5] = a2.stealCountList[5] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_2246.field_10171.method_8389()) && a2.stealCountList[6] > 0) {
            a2.stealCountList[6] = a2.stealCountList[6] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_2246.field_23152.method_8389()) && a2.stealCountList[7] > 0) {
            a2.stealCountList[7] = a2.stealCountList[7] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8634) && a2.stealCountList[8] > 0) {
            a2.stealCountList[8] = a2.stealCountList[8] - a.method_7947();
            return true;
        }
        if (a.method_7909() instanceof class_1747 && ((class_1747)a.method_7909()).method_7711() instanceof class_2665 && a2.stealCountList[9] > 0) {
            a2.stealCountList[9] = a2.stealCountList[9] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_2246.field_10002.method_8389()) && a2.stealCountList[10] > 0) {
            a2.stealCountList[10] = a2.stealCountList[10] - a.method_7947();
            return true;
        }
        if (a.method_7909() instanceof class_1747 && ((class_1747)a.method_7909()).method_7711() instanceof class_2244 && a2.stealCountList[11] > 0) {
            a2.stealCountList[11] = a2.stealCountList[11] - a.method_7947();
            return true;
        }
        if (class_1792.method_7880((class_1792)a.method_7909()) == class_1792.method_7880((class_1792)class_1802.field_8436)) {
            for (class_1293 class_12932 : class_1844.method_8067((class_1799)a)) {
                if (class_12932.method_5579() == class_1294.field_5904) {
                    if (a2.stealCountList[12] <= 0) continue;
                    a2.stealCountList[12] = a2.stealCountList[12] - a.method_7947();
                    return true;
                }
                if (class_12932.method_5579() != class_1294.field_5907 || a2.stealCountList[13] <= 0) continue;
                a2.stealCountList[13] = a2.stealCountList[13] - a.method_7947();
                return true;
            }
        }
        return false;
    }

    public int findShulker() {
        ChestStealer a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(class_2480.class);
        }
        return InventoryUtil.findClass(class_2480.class);
    }

    private /* synthetic */ void update() {
        ChestStealer a;
        ChestStealer chestStealer = a;
        chestStealer.stealCountList[0] = (int)(a.crystal.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8301));
        ChestStealer chestStealer2 = a;
        chestStealer.stealCountList[1] = (int)(chestStealer2.exp.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8287));
        chestStealer2.stealCountList[2] = (int)(a.totem.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8288));
        chestStealer.stealCountList[3] = (int)(a.gapple.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8367));
        chestStealer.stealCountList[4] = (int)(a.obsidian.getValue() - (double)InventoryUtil.getItemCount(class_2246.field_10540.method_8389()));
        chestStealer.stealCountList[5] = (int)(a.web.getValue() - (double)InventoryUtil.getItemCount(class_2246.field_10343.method_8389()));
        chestStealer.stealCountList[6] = (int)(a.glowstone.getValue() - (double)InventoryUtil.getItemCount(class_2246.field_10171.method_8389()));
        chestStealer.stealCountList[7] = (int)(a.anchor.getValue() - (double)InventoryUtil.getItemCount(class_2246.field_23152.method_8389()));
        chestStealer.stealCountList[8] = (int)(a.pearl.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8634));
        chestStealer.stealCountList[9] = (int)(a.piston.getValue() - (double)InventoryUtil.getItemCount(class_2246.field_10560.method_8389()) - (double)InventoryUtil.getItemCount(class_2246.field_10615.method_8389()));
        chestStealer.stealCountList[10] = (int)(a.redstone.getValue() - (double)InventoryUtil.getItemCount(class_2246.field_10002.method_8389()));
        chestStealer.stealCountList[11] = (int)(a.bed.getValue() - (double)InventoryUtil.getItemCount(class_2244.class));
        chestStealer.stealCountList[12] = (int)(a.speed.getValue() - (double)InventoryUtil.getPotionCount(class_1294.field_5904));
        chestStealer.stealCountList[13] = (int)(a.turtle.getValue() - (double)InventoryUtil.getPotionCount(class_1294.field_5907));
    }
}
