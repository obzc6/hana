/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1829
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_408
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.SnowAnimation;
import java.util.function.Predicate;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1829;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_408;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class OffHand
extends Module {
    private final BooleanSetting crystal;
    private final Timer timer;
    private final SliderSetting health;
    private final BooleanSetting mainHand;
    int totems;
    private final BooleanSetting gapple;

    @Override
    public void onUpdate() {
        OffHand a;
        a.update();
    }

    public static int findItemInventorySlot(class_1792 a) {
        class_1792 class_17922 = a;
        int n = a = 44;
        while (n >= 0) {
            if (OffHand.mc.field_1724.method_31548().method_5438(a).method_7909() == class_17922) {
                if (a < 9) {
                    return a + 36;
                }
                return a;
            }
            n = --a;
        }
        return -1;
    }

    @Override
    public String getInfo() {
        OffHand a;
        return String.valueOf(a.totems);
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        OffHand a2 = this;
        a2.update();
    }

    public OffHand() {
        OffHand a;
        OffHand offHand = a;
        super(TimerManager.ALLATORIxDEMO("\u0003\u001f-,7@x"), Module.Category.Combat);
        OffHand offHand2 = a;
        offHand2.mainHand = offHand.add(new BooleanSetting(SnowAnimation.ALLATORIxDEMO("Y+T\rz\rV\u0002"), false));
        offHand.crystal = offHand.add(new BooleanSetting(TimerManager.ALLATORIxDEMO("\u000f\u000b2\u0017\"Op"), false, object -> {
            Object a = object;
            OffHand a2 = this;
            return !a2.mainHand.getValue();
        }));
        a.gapple = a.add(new BooleanSetting(SnowAnimation.ALLATORIxDEMO("z\u0002B\u001cT\u0003"), false, object -> {
            Object a = object;
            OffHand a2 = this;
            return !a2.mainHand.getValue();
        }));
        a.health = a.add(new SliderSetting(TimerManager.ALLATORIxDEMO("1.\u0005:Zt"), 16.0, 0.0, 36.0, 0.1));
        a.totems = 0;
        a.timer = new Timer();
        a.setChinese(SnowAnimation.ALLATORIxDEMO("\u5257\u622d"));
    }

    private /* synthetic */ void update() {
        block10 : {
            OffHand offHand;
            block13 : {
                OffHand offHand2;
                block12 : {
                    int a22;
                    block11 : {
                        OffHand a22;
                        offHand2 = a22;
                        if (OffHand.nullCheck()) {
                            return;
                        }
                        offHand2.totems = InventoryUtil.getItemCount(class_1802.field_8288);
                        if (!(OffHand.mc.field_1755 == null || OffHand.mc.field_1755 instanceof class_408 || OffHand.mc.field_1755 instanceof class_490 || OffHand.mc.field_1755 instanceof ClickGuiScreen || OffHand.mc.field_1755 instanceof class_433)) {
                            return;
                        }
                        if (!offHand2.timer.passedMs(200L)) {
                            return;
                        }
                        if (offHand2.gapple.getValue() && !offHand2.mainHand.getValue() && OffHand.mc.field_1724.method_6047().method_7909() instanceof class_1829 && OffHand.mc.field_1690.field_1904.method_1434()) {
                            if (OffHand.mc.field_1724.method_6079().method_7909() != class_1802.field_8367 && OffHand.mc.field_1724.method_6079().method_7909() != class_1802.field_8463) {
                                int a22 = OffHand.findItemInventorySlot(class_1802.field_8367);
                                if (a22 == -1) {
                                    a22 = OffHand.findItemInventorySlot(class_1802.field_8463);
                                }
                                if (a22 != -1) {
                                    OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                                    OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, 45, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                                    OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                                    EntityUtil.syncInventory();
                                    offHand2.timer.reset();
                                }
                            }
                            return;
                        }
                        if ((double)(OffHand.mc.field_1724.method_6032() + OffHand.mc.field_1724.method_6067()) > offHand2.health.getValue()) {
                            int a22;
                            if (!offHand2.mainHand.getValue() && offHand2.crystal.getValue() && OffHand.mc.field_1724.method_6079().method_7909() != class_1802.field_8301 && (a22 = OffHand.findItemInventorySlot(class_1802.field_8301)) != -1) {
                                OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                                OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, 45, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                                OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                                EntityUtil.syncInventory();
                                offHand2.timer.reset();
                            }
                            return;
                        }
                        if (OffHand.mc.field_1724.method_6047().method_7909() == class_1802.field_8288 || OffHand.mc.field_1724.method_6079().method_7909() == class_1802.field_8288) {
                            return;
                        }
                        a22 = OffHand.findItemInventorySlot(class_1802.field_8288);
                        if (a22 == -1) break block10;
                        if (!offHand2.mainHand.getValue()) break block11;
                        InventoryUtil.switchToSlot(0);
                        if (OffHand.mc.field_1724.method_31548().method_5438(0).method_7909() == class_1802.field_8288) break block12;
                        OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                        OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, 36, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                        OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                        EntityUtil.syncInventory();
                        offHand = offHand2;
                        break block13;
                    }
                    OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                    OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, 45, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                    OffHand.mc.field_1761.method_2906(OffHand.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)OffHand.mc.field_1724);
                    EntityUtil.syncInventory();
                }
                offHand = offHand2;
            }
            offHand.timer.reset();
        }
    }
}
