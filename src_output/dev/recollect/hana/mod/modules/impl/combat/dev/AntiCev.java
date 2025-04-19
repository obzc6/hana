/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class AntiCev
extends Module {
    private final BooleanSetting onlyGround;
    private final BooleanSetting checkMine;
    private final BooleanSetting breakCrystal;
    private final SliderSetting multiPlace;
    private final List<class_2338> crystalPos;
    private final BooleanSetting inventory;
    private final SliderSetting delay;
    final Timer timer;
    private class_2338 pos;
    public static AntiCev INSTANCE = new AntiCev();
    private final BooleanSetting eatingPause;
    private final BooleanSetting rotate;
    int progress;

    private /* synthetic */ boolean crystalHere(class_2338 a) {
        Iterator a2;
        AntiCev antiCev = a2;
        a2 = AntiCev.mc.field_1687.method_18467(class_1511.class, new class_238(a)).iterator();
        while (a2.hasNext()) {
            if (!EntityUtil.getEntityPos((class_1297)a2.next()).equals((Object)a)) continue;
            return true;
        }
        return false;
    }

    public AntiCev() {
        AntiCev a;
        AntiCev antiCev = a;
        AntiCev antiCev2 = a;
        super(BufferRing.ALLATORIxDEMO(";'\t=#{\\"), BetterDynamicAnimation.ALLATORIxDEMO("otpY\u0002uTs"), Module.Category.Combat);
        antiCev2.timer = new Timer();
        antiCev2.delay = a.add(new SliderSetting(BufferRing.ALLATORIxDEMO("91\fS"), 0, 0, 500));
        antiCev2.multiPlace = antiCev2.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("~rBnm`NwR`"), 1, 1, 8));
        antiCev2.rotate = antiCev2.add(new BooleanSetting(BufferRing.ALLATORIxDEMO("\u001b\u0012 \u0001jO"), true));
        antiCev2.onlyGround = antiCev2.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("|iBcCBMc_a"), false));
        antiCev2.breakCrystal = antiCev2.add(new BooleanSetting(BufferRing.ALLATORIxDEMO("^Z,\u001c%9;\u0004'\u0014F"), true));
        antiCev2.checkMine = antiCev2.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("DFg[o_`"), true));
        antiCev2.eatingPause = antiCev2.add(new BooleanSetting(BufferRing.ALLATORIxDEMO("m(\t'\u0014.-5\u0015mO"), true));
        a.inventory = a.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("{GkViZuvIqaPu"), false));
        a.progress = 0;
        antiCev.crystalPos = new ArrayList<class_2338>();
        antiCev.setChinese(BufferRing.ALLATORIxDEMO("\u53ad\u70a6\u591e"));
        INSTANCE = antiCev;
    }

    @Override
    public void onUpdate() {
        AntiCev a222;
        int n;
        AntiCev antiCev;
        AntiCev antiCev2 = antiCev = a222;
        if (!antiCev2.timer.passedMs(antiCev2.delay.getValue())) {
            return;
        }
        if (antiCev.eatingPause.getValue() && EntityUtil.isUsing()) {
            return;
        }
        antiCev.progress = 0;
        if (antiCev.pos != null && !antiCev.pos.equals((Object)EntityUtil.getPlayerPos(true))) {
            antiCev.crystalPos.clear();
        }
        antiCev.pos = EntityUtil.getPlayerPos(true);
        Object object = class_2350.values();
        int a222 = ((class_2350[])object).length;
        int n2 = n = 0;
        while (n2 < a222) {
            class_2350 class_23502 = object[n];
            if (class_23502 != class_2350.field_11033) {
                AntiCev antiCev3 = antiCev;
                if (!antiCev3.isGod(antiCev3.pos.method_10093(class_23502).method_10084())) {
                    AntiCev antiCev4 = antiCev;
                    if (antiCev4.crystalHere((class_2338)(class_23502 = antiCev4.pos.method_10093(class_23502).method_10086(2))) && !antiCev.crystalPos.contains((Object)class_23502)) {
                        antiCev.crystalPos.add((class_2338)class_23502);
                    }
                }
            }
            n2 = ++n;
        }
        if (antiCev.getBlock() == -1) {
            return;
        }
        if (antiCev.onlyGround.getValue() && !AntiCev.mc.field_1724.method_24828()) {
            return;
        }
        antiCev.crystalPos.removeIf(a -> !BlockUtil.clientCanPlace(a, true));
        object = antiCev.crystalPos.iterator();
        while (object.hasNext()) {
            class_2338 a222 = (class_2338)object.next();
            if (antiCev.crystalHere(a222) && antiCev.breakCrystal.getValue()) {
                CombatUtil.attackCrystal(a222, antiCev.rotate.getValue(), false);
            }
            if (!BlockUtil.canPlace(a222, 6.0, antiCev.breakCrystal.getValue())) continue;
            antiCev.placeBlock(a222);
        }
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AntiCev a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AntiCev.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ boolean isGod(class_2338 class_23382) {
        AntiCev a = class_23382;
        AntiCev a2 = this;
        return AntiCev.mc.field_1687.method_8320((class_2338)a).method_26204() == class_2246.field_9987;
    }

    private /* synthetic */ void placeBlock(class_2338 a) {
        AntiCev antiCev;
        AntiCev a22;
        AntiCev antiCev2 = a22;
        if (!((double)antiCev2.progress < antiCev2.multiPlace.getValue())) {
            return;
        }
        if (antiCev2.checkMine.getValue() && BlockUtil.isMining(a)) {
            return;
        }
        int n = AntiCev.mc.field_1724.method_31548().field_7545;
        int a22 = antiCev2.getBlock();
        if (a22 == -1) {
            return;
        }
        AntiCev antiCev3 = antiCev2;
        antiCev3.doSwap(a22);
        BlockUtil.placeBlock(a, antiCev3.rotate.getValue());
        AntiCev antiCev4 = antiCev2;
        if (antiCev2.inventory.getValue()) {
            antiCev4.doSwap(a22);
            EntityUtil.syncInventory();
            antiCev = antiCev2;
        } else {
            antiCev4.doSwap(n);
            antiCev = antiCev2;
        }
        ++antiCev.progress;
        antiCev2.timer.reset();
    }

    private /* synthetic */ int getBlock() {
        AntiCev a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }
}
