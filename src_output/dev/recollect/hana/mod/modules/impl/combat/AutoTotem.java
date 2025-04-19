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
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class AutoTotem
extends Module {
    private final BooleanSetting mainHand;
    private final Timer timer;
    private final SliderSetting health;
    int totems;

    private /* synthetic */ void update() {
        block5 : {
            AutoTotem autoTotem;
            block8 : {
                AutoTotem autoTotem2;
                block7 : {
                    int a22;
                    block6 : {
                        AutoTotem a22;
                        autoTotem2 = a22;
                        if (AutoTotem.nullCheck()) {
                            return;
                        }
                        autoTotem2.totems = InventoryUtil.getItemCount(class_1802.field_8288);
                        if (!(AutoTotem.mc.field_1755 == null || AutoTotem.mc.field_1755 instanceof class_408 || AutoTotem.mc.field_1755 instanceof class_490 || AutoTotem.mc.field_1755 instanceof ClickGuiScreen)) {
                            return;
                        }
                        if (!autoTotem2.timer.passedMs(200L)) {
                            return;
                        }
                        if ((double)(AutoTotem.mc.field_1724.method_6032() + AutoTotem.mc.field_1724.method_6067()) > autoTotem2.health.getValue()) {
                            return;
                        }
                        if (AutoTotem.mc.field_1724.method_6047().method_7909() == class_1802.field_8288 || AutoTotem.mc.field_1724.method_6079().method_7909() == class_1802.field_8288) {
                            return;
                        }
                        a22 = InventoryUtil.findItemInventorySlot(class_1802.field_8288);
                        if (a22 == -1) break block5;
                        if (!autoTotem2.mainHand.getValue()) break block6;
                        InventoryUtil.switchToSlot(0);
                        if (AutoTotem.mc.field_1724.method_31548().method_5438(0).method_7909() == class_1802.field_8288) break block7;
                        AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)AutoTotem.mc.field_1724);
                        AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, 36, 0, class_1713.field_7790, (class_1657)AutoTotem.mc.field_1724);
                        AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)AutoTotem.mc.field_1724);
                        EntityUtil.syncInventory();
                        autoTotem = autoTotem2;
                        break block8;
                    }
                    AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)AutoTotem.mc.field_1724);
                    AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, 45, 0, class_1713.field_7790, (class_1657)AutoTotem.mc.field_1724);
                    AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, a22, 0, class_1713.field_7790, (class_1657)AutoTotem.mc.field_1724);
                    EntityUtil.syncInventory();
                }
                autoTotem = autoTotem2;
            }
            autoTotem.timer.reset();
        }
    }

    public AutoTotem() {
        AutoTotem a;
        AutoTotem autoTotem = a;
        AutoTotem autoTotem2 = a;
        AutoTotem autoTotem3 = a;
        super(FadeUtils.ALLATORIxDEMO("|\u001eN\u0003i\u001eT^\u0007"), Module.Category.Combat);
        AutoTotem autoTotem4 = a;
        autoTotem4.mainHand = autoTotem3.add(new BooleanSetting(TimerManager.ALLATORIxDEMO("3-\u0010%,7@x"), false));
        autoTotem2.health = autoTotem3.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("$X\u0010LO\u0002"), 16.0, 0.0, 36.0, 0.1));
        autoTotem2.totems = 0;
        autoTotem2.timer = new Timer();
        autoTotem.setChinese(TimerManager.ALLATORIxDEMO("\u818e\u52fe\u56d0\u8162"));
        autoTotem.setDescription(FadeUtils.ALLATORIxDEMO("\u0005`\u0004N\u001cA\u001eR2a\u0006W\b\u0000\u0012T\u0018UX\u000b\tYKN\u0003I\u0014MHD"));
    }

    @Override
    public String getInfo() {
        AutoTotem a;
        return String.valueOf(a.totems);
    }

    @Override
    public void onUpdate() {
        AutoTotem a;
        a.update();
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AutoTotem a2 = this;
        a2.update();
    }
}
