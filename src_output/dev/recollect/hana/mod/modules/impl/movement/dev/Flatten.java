/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1303
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1661
 *  net.minecraft.class_1667
 *  net.minecraft.class_1683
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1667;
import net.minecraft.class_1683;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class Flatten
extends Module {
    private final SliderSetting blocksPer;
    int progress;
    private final BooleanSetting checkMine;
    private final BooleanSetting rotate;
    private final BooleanSetting usingPause;
    private final SliderSetting delay;
    public static Flatten INSTANCE;
    private final BooleanSetting inventory;
    private final Timer timer;

    /*
     * WARNING - void declaration
     */
    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        void a22;
        Flatten flatten = this;
        if (a22.isPost()) {
            return;
        }
        flatten.progress = 0;
        if (flatten.usingPause.getValue() && Flatten.mc.field_1724.method_6115()) {
            return;
        }
        if (!Flatten.mc.field_1724.method_24828()) {
            return;
        }
        Flatten flatten2 = flatten;
        if (!flatten2.timer.passedMs(flatten2.delay.getValueInt())) {
            return;
        }
        int a22 = Flatten.mc.field_1724.method_31548().field_7545;
        int n = flatten.getBlock();
        if (n == -1) {
            return;
        }
        if (!EntityUtil.isInsideBlock()) {
            return;
        }
        class_2338 class_23382 = new BlockPosX(Flatten.mc.field_1724.method_23317() + 0.5, Flatten.mc.field_1724.method_23318() + 0.5, Flatten.mc.field_1724.method_23321() + 0.5).method_10074();
        class_2338 class_23383 = new BlockPosX(Flatten.mc.field_1724.method_23317() - 0.5, Flatten.mc.field_1724.method_23318() + 0.5, Flatten.mc.field_1724.method_23321() + 0.5).method_10074();
        class_2338 class_23384 = new BlockPosX(Flatten.mc.field_1724.method_23317() + 0.5, Flatten.mc.field_1724.method_23318() + 0.5, Flatten.mc.field_1724.method_23321() - 0.5).method_10074();
        Flatten a = new BlockPosX(Flatten.mc.field_1724.method_23317() - 0.5, Flatten.mc.field_1724.method_23318() + 0.5, Flatten.mc.field_1724.method_23321() - 0.5).method_10074();
        if (!(flatten.canPlace(class_23382) || flatten.canPlace(class_23383) || flatten.canPlace(class_23384) || flatten.canPlace((class_2338)a))) {
            return;
        }
        Flatten flatten3 = flatten;
        Flatten flatten4 = flatten;
        Flatten flatten5 = flatten;
        flatten5.doSwap(n);
        flatten5.tryPlaceObsidian(class_23382, flatten5.rotate.getValue());
        flatten4.tryPlaceObsidian(class_23383, flatten4.rotate.getValue());
        flatten3.tryPlaceObsidian(class_23384, flatten4.rotate.getValue());
        flatten3.tryPlaceObsidian((class_2338)a, flatten3.rotate.getValue());
        Flatten flatten6 = flatten;
        if (flatten.inventory.getValue()) {
            flatten6.doSwap(n);
            EntityUtil.syncInventory();
            return;
        }
        flatten6.doSwap(a22);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean hasEntity(class_2338 a) {
        Flatten a2;
        Flatten flatten = a2;
        a = BlockUtil.getEntities(new class_238((class_2338)a)).iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                a2 = (class_1297)a.next();
                if (a2 == Flatten.mc.field_1724) {
                    object = a;
                    continue;
                }
                if (!a2.method_5805() || a2 instanceof class_1542 || a2 instanceof class_1303 || a2 instanceof class_1683 || a2 instanceof class_1667 || a2 instanceof class_1511) continue block0;
                if (!(a2 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                object = a;
            }
            break;
        } while (true);
        return false;
    }

    public Flatten() {
        Flatten a;
        Flatten flatten = a;
        Flatten flatten2 = a;
        super(Snow.ALLATORIxDEMO("\u0007y p$j5"), Module.Category.Movement);
        Flatten flatten3 = a;
        flatten3.rotate = flatten2.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("ahVw]x"), true));
        flatten2.checkMine = flatten2.add(new BooleanSetting(Snow.ALLATORIxDEMO("I<t1v5X(j9a<"), true));
        flatten2.inventory = flatten2.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("|EiC|GhA~qaHm"), true));
        flatten2.usingPause = flatten2.add(new BooleanSetting(Snow.ALLATORIxDEMO("U'|/r\u0011e%|>"), true));
        flatten2.blocksPer = flatten2.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("P_hPlQFLo"), 2, 1, 8));
        flatten2.delay = flatten2.add(new SliderSetting(Snow.ALLATORIxDEMO("\u0005a<n\""), 100, 0, 1000));
        flatten2.timer = new Timer();
        flatten.progress = 0;
        flatten.setChinese(BetterDynamicAnimation.ALLATORIxDEMO("\u5849\u5e65\u8133\u4e16"));
        INSTANCE = flatten;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        Flatten a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, Flatten.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void tryPlaceObsidian(class_2338 class_23382, boolean bl) {
        Flatten a = this;
        Flatten a2 = class_23382;
        if (a.canPlace((class_2338)a2)) {
            void a3;
            if (a.checkMine.getValue() && Hana.BREAK.isMining((class_2338)a2)) {
                return;
            }
            if (!((double)a.progress < a.blocksPer.getValue())) {
                return;
            }
            class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)a2);
            if (class_23502 == null) {
                if (BlockUtil.airPlace()) {
                    BlockUtil.placedPos.add((class_2338)a2);
                    BlockUtil.clickBlock((class_2338)a2, class_2350.field_11033, (boolean)a3);
                    a.timer.reset();
                    ++a.progress;
                    return;
                }
                return;
            }
            ++a.progress;
            BlockUtil.placedPos.add((class_2338)a2);
            BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), (boolean)a3);
            a.timer.reset();
        }
    }

    private /* synthetic */ boolean canPlace(class_2338 class_23382) {
        Flatten a = class_23382;
        Flatten a2 = this;
        if (BlockUtil.getPlaceSide((class_2338)a) == null) {
            return false;
        }
        if (!BlockUtil.canReplace((class_2338)a)) {
            return false;
        }
        return !a2.hasEntity((class_2338)a);
    }

    private /* synthetic */ int getBlock() {
        Flatten a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }
}
