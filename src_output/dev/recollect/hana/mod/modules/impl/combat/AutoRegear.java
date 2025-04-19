/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1810
 *  net.minecraft.class_1829
 *  net.minecraft.class_1844
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2480
 *  net.minecraft.class_2596
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_2815
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1738;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1810;
import net.minecraft.class_1829;
import net.minecraft.class_1844;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2480;
import net.minecraft.class_2596;
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_2815;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoRegear
extends Module {
    private final BooleanSetting close;
    private final BooleanSetting preferOpen;
    private final SliderSetting cfruit;
    private final SliderSetting elytra;
    private final SliderSetting redstone;
    private final SliderSetting pickaxe;
    private final SliderSetting gapple;
    private final BooleanSetting inventory;
    private final SliderSetting empty;
    private final SliderSetting exp;
    final int[] stealCountList;
    public final BooleanSetting rotate;
    private final BooleanSetting mine;
    private final SliderSetting leggings;
    private final SliderSetting endChest;
    private final SliderSetting sword;
    private final SliderSetting turtleMaster;
    private final SliderSetting minRange;
    private final BooleanSetting take;
    private final BooleanSetting place;
    private final SliderSetting crystal;
    private final BooleanSetting open;
    private final SliderSetting totem;
    private final SliderSetting web;
    private final SliderSetting pearl;
    private final SliderSetting piston;
    private final BooleanSetting detectMining;
    class_2338 openPos;
    private final SliderSetting chestplate;
    class_2338 placePos;
    private final SliderSetting helmet;
    private final SliderSetting glowstone;
    private final BooleanSetting autoDisable;
    private final SliderSetting anchor;
    private final SliderSetting boots;
    boolean opend;
    private final Timer disableTimer;
    private final BooleanSetting smart;
    private final Timer timer;
    private final SliderSetting range;
    private final SliderSetting disableTime;

    public int findClass(Class class_) {
        Class a = class_;
        AutoRegear a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findClassInventorySlot(a);
        }
        return InventoryUtil.findClass(a);
    }

    private /* synthetic */ boolean needSteal(class_1799 class_17992) {
        AutoRegear a = class_17992;
        AutoRegear a2 = this;
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
        if (a.method_7909().equals((Object)class_1792.method_7867((class_2248)class_2246.field_10443)) && a2.stealCountList[4] > 0) {
            a2.stealCountList[4] = a2.stealCountList[4] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1792.method_7867((class_2248)class_2246.field_10343)) && a2.stealCountList[5] > 0) {
            a2.stealCountList[5] = a2.stealCountList[5] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1792.method_7867((class_2248)class_2246.field_10171)) && a2.stealCountList[6] > 0) {
            a2.stealCountList[6] = a2.stealCountList[6] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1792.method_7867((class_2248)class_2246.field_23152)) && a2.stealCountList[7] > 0) {
            a2.stealCountList[7] = a2.stealCountList[7] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8634) && a2.stealCountList[8] > 0) {
            a2.stealCountList[8] = a2.stealCountList[8] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8436) && a2.stealCountList[9] > 0) {
            Iterator iterator = new ArrayList(class_1844.method_8067((class_1799)a)).iterator();
            while (iterator.hasNext()) {
                if (((class_1293)iterator.next()).method_5579() != class_1294.field_5907) continue;
                a2.stealCountList[9] = a2.stealCountList[9] - a.method_7947();
                return true;
            }
        }
        if (InventoryUtil.CheckArmorType(a.method_7909(), class_1738.class_8051.field_41934) && a2.stealCountList[10] > 0) {
            a2.stealCountList[10] = a2.stealCountList[10] - a.method_7947();
            return true;
        }
        if (InventoryUtil.CheckArmorType(a.method_7909(), class_1738.class_8051.field_41935) && a2.stealCountList[11] > 0) {
            a2.stealCountList[11] = a2.stealCountList[11] - a.method_7947();
            return true;
        }
        if (InventoryUtil.CheckArmorType(a.method_7909(), class_1738.class_8051.field_41936) && a2.stealCountList[12] > 0) {
            a2.stealCountList[12] = a2.stealCountList[12] - a.method_7947();
            return true;
        }
        if (InventoryUtil.CheckArmorType(a.method_7909(), class_1738.class_8051.field_41937) && a2.stealCountList[13] > 0) {
            a2.stealCountList[13] = a2.stealCountList[13] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8833) && a2.stealCountList[14] > 0) {
            a2.stealCountList[14] = a2.stealCountList[14] - a.method_7947();
            return true;
        }
        if (a.method_7909() instanceof class_1829 && a2.stealCountList[15] > 0) {
            a2.stealCountList[15] = a2.stealCountList[15] - a.method_7947();
            return true;
        }
        if (a.method_7909() instanceof class_1810 && a2.stealCountList[16] > 0) {
            a2.stealCountList[16] = a2.stealCountList[16] - a.method_7947();
            return true;
        }
        if (a.method_7909() instanceof class_1747 && ((class_1747)a.method_7909()).method_7711() instanceof class_2665 && a2.stealCountList[17] > 0) {
            a2.stealCountList[17] = a2.stealCountList[17] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1792.method_7867((class_2248)class_2246.field_10002)) && a2.stealCountList[18] > 0) {
            a2.stealCountList[18] = a2.stealCountList[18] - a.method_7947();
            return true;
        }
        if (a.method_7909().equals((Object)class_1802.field_8233) && a2.stealCountList[19] > 0) {
            a2.stealCountList[19] = a2.stealCountList[19] - a.method_7947();
            return true;
        }
        return false;
    }

    private /* synthetic */ void disable2() {
        AutoRegear a;
        AutoRegear autoRegear = a;
        if (autoRegear.disableTimer.passedMs(autoRegear.disableTime.getValueInt())) {
            if (a.close.getValue()) {
                AutoRegear.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(AutoRegear.mc.field_1724.field_7512.field_7763));
                AutoRegear.mc.field_1724.method_7346();
            }
            a.disable();
        }
    }

    @Override
    public void onEnable() {
        AutoRegear a;
        AutoRegear autoRegear = a;
        autoRegear.openPos = null;
        autoRegear.disableTimer.reset();
        autoRegear.placePos = null;
        if (AutoRegear.nullCheck()) {
            return;
        }
        int n = AutoRegear.mc.field_1724.method_31548().field_7545;
        if (!autoRegear.place.getValue()) {
            return;
        }
        double d = 100.0;
        AutoRegear autoRegear2 = null;
        Iterator<class_2338> iterator = BlockUtil.getSphere((float)autoRegear.range.getValue()).iterator();
        block0 : do {
            Iterator<class_2338> iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = iterator.next();
                if (!BlockUtil.isAir(a.method_10084())) {
                    iterator2 = iterator;
                    continue;
                }
                if (autoRegear.preferOpen.getValue() && AutoRegear.mc.field_1687.method_8320((class_2338)a).method_26204() instanceof class_2480) {
                    return;
                }
                if ((double)class_3532.method_15355((float)((float)AutoRegear.mc.field_1724.method_5707(a.method_46558()))) < autoRegear.minRange.getValue()) {
                    iterator2 = iterator;
                    continue;
                }
                if (!BlockUtil.clientCanPlace((class_2338)a, false) || !BlockUtil.isStrictDirection(a.method_10093(class_2350.field_11033), class_2350.field_11036)) continue block0;
                if (!BlockUtil.canClick(a.method_10093(class_2350.field_11033))) {
                    iterator2 = iterator;
                    continue;
                }
                if (autoRegear.detectMining.getValue()) {
                    if (Hana.BREAK.isMining((class_2338)a)) continue block0;
                    if (a.equals((Object)SpeedMine.breakPos)) {
                        iterator2 = iterator;
                        continue;
                    }
                }
                if (autoRegear2 != null && !((double)class_3532.method_15355((float)((float)AutoRegear.mc.field_1724.method_5707(a.method_46558()))) < d)) continue block0;
                d = class_3532.method_15355((float)((float)AutoRegear.mc.field_1724.method_5707(a.method_46558())));
                autoRegear2 = a;
                continue block0;
            }
            break;
        } while (true);
        if (autoRegear2 != null) {
            AutoRegear autoRegear3;
            int n2 = autoRegear.findShulker();
            if (n2 == -1) {
                CommandManager.sendChatMessage(RadiusUtils.ALLATORIxDEMO("\u00cbY5\u00191\u001c&@[A\u000eF\u000bs)A\u0005S\u0010\u001f\r^\u0010V\b"));
                return;
            }
            autoRegear.doSwap(n2);
            autoRegear.placeBlock((class_2338)autoRegear2);
            autoRegear.placePos = autoRegear2;
            AutoRegear autoRegear4 = autoRegear;
            if (autoRegear.inventory.getValue()) {
                autoRegear4.doSwap(n2);
                EntityUtil.syncInventory();
                autoRegear3 = autoRegear;
            } else {
                autoRegear4.doSwap(n);
                autoRegear3 = autoRegear;
            }
            autoRegear3.timer.reset();
            return;
        }
        CommandManager.sendChatMessage(GaussianFilter.ALLATORIxDEMO("\u00e6N\u0018\u000e\u001a\u000b\u001aWiU$E\u0000jhT(XdN%S-K"));
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoRegear a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AutoRegear.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ void update() {
        AutoRegear a;
        AutoRegear autoRegear = a;
        autoRegear.stealCountList[0] = (int)(a.crystal.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8301));
        AutoRegear autoRegear2 = a;
        autoRegear.stealCountList[1] = (int)(autoRegear2.exp.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8287));
        autoRegear2.stealCountList[2] = (int)(a.totem.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8288));
        autoRegear.stealCountList[3] = (int)(a.gapple.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8367));
        autoRegear.stealCountList[4] = (int)(a.endChest.getValue() - (double)InventoryUtil.getItemCount(class_1792.method_7867((class_2248)class_2246.field_10443)));
        autoRegear.stealCountList[5] = (int)(a.web.getValue() - (double)InventoryUtil.getItemCount(class_1792.method_7867((class_2248)class_2246.field_10343)));
        autoRegear.stealCountList[6] = (int)(a.glowstone.getValue() - (double)InventoryUtil.getItemCount(class_1792.method_7867((class_2248)class_2246.field_10171)));
        autoRegear.stealCountList[7] = (int)(a.anchor.getValue() - (double)InventoryUtil.getItemCount(class_1792.method_7867((class_2248)class_2246.field_23152)));
        autoRegear.stealCountList[8] = (int)(a.pearl.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8634));
        autoRegear.stealCountList[9] = (int)(a.turtleMaster.getValue() - (double)InventoryUtil.getPotCount(class_1294.field_5907));
        autoRegear.stealCountList[10] = (int)(a.helmet.getValue() - (double)InventoryUtil.getArmorCount(class_1738.class_8051.field_41934));
        autoRegear.stealCountList[11] = (int)(a.chestplate.getValue() - (double)InventoryUtil.getArmorCount(class_1738.class_8051.field_41935));
        autoRegear.stealCountList[12] = (int)(a.leggings.getValue() - (double)InventoryUtil.getArmorCount(class_1738.class_8051.field_41936));
        autoRegear.stealCountList[13] = (int)(a.boots.getValue() - (double)InventoryUtil.getArmorCount(class_1738.class_8051.field_41937));
        autoRegear.stealCountList[14] = (int)(a.elytra.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8833));
        autoRegear.stealCountList[15] = (int)(a.sword.getValue() - (double)InventoryUtil.getClassCount(class_1829.class));
        autoRegear.stealCountList[16] = (int)(a.pickaxe.getValue() - (double)InventoryUtil.getClassCount(class_1810.class));
        autoRegear.stealCountList[17] = (int)(a.piston.getValue() - (double)InventoryUtil.getClassCount(class_2665.class));
        autoRegear.stealCountList[18] = (int)(a.redstone.getValue() - (double)InventoryUtil.getItemCount(class_1792.method_7867((class_2248)class_2246.field_10002)));
        autoRegear.stealCountList[19] = (int)(a.cfruit.getValue() - (double)InventoryUtil.getItemCount(class_1802.field_8233));
    }

    public AutoRegear() {
        AutoRegear a;
        AutoRegear autoRegear = a;
        super(RadiusUtils.ALLATORIxDEMO("u\u0015G\bf\u0005N\u0018\u0002E"), GaussianFilter.ALLATORIxDEMO("&~'PrN%D\u0017}c\\)X/D\"YtYt\u0012oQ-T#F<Wk\u001c"), Module.Category.Combat);
        AutoRegear autoRegear2 = a;
        autoRegear2.autoDisable = autoRegear.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("tA\u0014\\#]\u0013H\u001f\u000fR"), true));
        autoRegear.disableTime = autoRegear.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("2&P)F#F\u0006Wu\u0011"), 500, 0, 1000));
        autoRegear.rotate = autoRegear.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("f\u000f]\u001c\u0017R"), true));
        autoRegear.place = autoRegear.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("s>_{\u0011"), true));
        autoRegear.detectMining = autoRegear.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("%P@\u0005P\u0013y\tG\u0014\rP"), true));
        autoRegear.inventory = autoRegear.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("qt\u0000*M<K=Z\u0001Iy\u0004"), true));
        autoRegear.preferOpen = autoRegear.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("d\u0005A\u0001Q\u0012f\r\u0006Y"), true));
        autoRegear.open = autoRegear.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u001dN}\u001a"), true));
        autoRegear.close = autoRegear.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("#E\u0012\u0010R"), true));
        autoRegear.range = autoRegear.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("q3P\u0011"), 4.0, 0.0, 6.0));
        autoRegear.minRange = autoRegear.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("~\u000eZ2H\u0013\u0004R"), 1.0, 0.0, 3.0));
        autoRegear.mine = autoRegear.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u001fWv\u0011"), true));
        autoRegear.take = autoRegear.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("}\u001c\bR"), true));
        autoRegear.empty = autoRegear.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("f?Nl\r"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue();
        }));
        a.smart = a.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("3D\u001c\u0011C"), true, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue();
        }).setParent());
        a.helmet = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u0007F>S}\u0000"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.chestplate = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("w\bV\u0014@0E\u001c\u0017R"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.leggings = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u0004A(D;P\u0007"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.boots = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("\"F\u0012\u0017D"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.elytra = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\nO+Jj\u0015"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.sword = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("3^\u0012\u0011S"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.pickaxe = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("t&@9_`\u0011"), 1, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.crystal = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("$F\u0019Z\t\u0002["), 256, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.exp = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("{`\u0004"), 256, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.totem = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("4F\t\u0006Z"), 6, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.turtleMaster = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("lo\u0004;O-{\u0002B!J}\u0006"), 6, 0, 36, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.gapple = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("s\u0001Y\r\u000fR"), 128, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.cfruit = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\fE Kq\u0000"), 64, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.endChest = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("v\tP#A\u0018\u0010C"), 64, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.web = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("i}\u0016"), 64, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.glowstone = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("'_\bC\u0013]\u0012\rR"), 256, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.anchor = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u000eM1Vw\u0006"), 256, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.piston = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("d\tZ\t\fY"), 64, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.redstone = a.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u001aA+p&Qv\u0011"), 64, 0, 512, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        a.pearl = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("0L\u001c\u0011["), 16, 0, 64, object -> {
            Object a = object;
            AutoRegear a2 = this;
            return a2.take.getValue() && a2.smart.isOpen();
        }));
        AutoRegear autoRegear3 = a;
        int[] arrn = new int[20];
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
        arrn[14] = 0;
        arrn[15] = 0;
        arrn[16] = 0;
        arrn[17] = 0;
        arrn[18] = 0;
        arrn[19] = 0;
        a.stealCountList = arrn;
        autoRegear3.timer = new Timer();
        autoRegear3.placePos = null;
        autoRegear3.disableTimer = new Timer();
        a.opend = false;
        a.setChinese(GaussianFilter.ALLATORIxDEMO("\u81b8\u5296\u887d\u7ead"));
    }

    @Override
    public void onDisable() {
        AutoRegear a;
        a.opend = false;
        if (a.mine.getValue() && a.placePos != null) {
            SpeedMine.INSTANCE.mine(a.placePos);
        }
    }

    public int findShulker() {
        AtomicInteger a;
        AutoRegear autoRegear = a;
        a = new AtomicInteger(-1);
        if (autoRegear.findClass(class_2480.class) != -1) {
            a.set(autoRegear.findClass(class_2480.class));
        }
        return a.get();
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

    private /* synthetic */ void placeBlock(class_2338 class_23382) {
        AutoRegear a = class_23382;
        AutoRegear a2 = this;
        BlockUtil.clickBlock(a.method_10093(class_2350.field_11033), class_2350.field_11036, a2.rotate.getValue());
    }
}
