/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2338
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2338;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class SilentDouble
extends Module {
    public static int slotMain;
    public static SilentDouble INSTANCE;
    private final SliderSetting minHealth;
    private final BooleanSetting usingPause;
    public static int swithc2;

    @Override
    public void onUpdate() {
        SilentDouble a;
        a.update();
    }

    public SilentDouble() {
        SilentDouble a;
        SilentDouble silentDouble = a;
        SilentDouble silentDouble2 = a;
        super(TimerManager.ALLATORIxDEMO("w\u0015.\u00108=$\u00114By"), Module.Category.Combat);
        SilentDouble silentDouble3 = a;
        silentDouble3.usingPause = silentDouble2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("yO7T\fN\u0005p\u0016\u0019P"), true));
        silentDouble.minHealth = silentDouble2.add(new SliderSetting(TimerManager.ALLATORIxDEMO("\u0006\u0017\"1.\u0005:Zt"), 0, 0, 36));
        silentDouble.setChinese(TimeHelper.ALLATORIxDEMO("\u9b01\u6234\u53bb\u6323"));
        INSTANCE = silentDouble;
    }

    public void update() {
        SilentDouble a;
        if (a.usingPause.getValue() && EntityUtil.isUsing()) {
            return;
        }
        if (!SpeedMine.INSTANCE.isOn()) {
            CommandManager.sendChatMessage(TimerManager.ALLATORIxDEMO("\u00c22)!n\u00d2$\u00c283\"\u0011#\u0015\u000e\r8\u0010x"));
            a.disable();
            return;
        }
        if (SilentDouble.mc.field_1724.method_6032() + SilentDouble.mc.field_1724.method_6067() <= a.minHealth.getValueFloat()) {
            return;
        }
        if (SpeedMine.secondPos != null && SpeedMine.INSTANCE.getTool(SpeedMine.secondPos) == -1) {
            return;
        }
        if (SpeedMine.secondPos != null && !SpeedMine.INSTANCE.secondTimer.passed(SpeedMine.INSTANCE.getBreakTime(SpeedMine.secondPos, SpeedMine.INSTANCE.getTool(SpeedMine.secondPos) == -1 ? SilentDouble.mc.field_1724.method_31548().field_7545 : SpeedMine.INSTANCE.getTool(SpeedMine.secondPos), 0.89))) {
            slotMain = SilentDouble.mc.field_1724.method_31548().field_7545;
        }
        if (SpeedMine.secondPos != null && SpeedMine.INSTANCE.secondTimer.passed(SpeedMine.INSTANCE.getBreakTime(SpeedMine.secondPos, SpeedMine.INSTANCE.getTool(SpeedMine.secondPos), 0.9))) {
            if (SilentDouble.mc.field_1724.method_6047().method_7909() == class_1802.field_8367 || SilentDouble.mc.field_1724.method_6047().method_7909() == class_1802.field_8233) {
                if (!SilentDouble.mc.field_1690.field_1904.method_1434()) {
                    SilentDouble.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(SpeedMine.INSTANCE.getTool(SpeedMine.secondPos)));
                    swithc2 = 1;
                } else if (swithc2 == 1) {
                    SilentDouble.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(slotMain));
                    EntityUtil.syncInventory();
                }
            } else {
                SilentDouble.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(SpeedMine.INSTANCE.getTool(SpeedMine.secondPos)));
                swithc2 = 1;
            }
        }
        if (SpeedMine.secondPos != null && SpeedMine.INSTANCE.secondTimer.passed(SpeedMine.INSTANCE.getBreakTime(SpeedMine.secondPos, SpeedMine.INSTANCE.getTool(SpeedMine.secondPos), 1.2)) && swithc2 == 1) {
            SilentDouble.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(slotMain));
            EntityUtil.syncInventory();
        }
    }
}
