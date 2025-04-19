/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class Step
extends Module {
    public final BooleanSetting onlyMoving;
    public final SliderSetting stepHeight;
    public static Step INSTANCE;

    @Override
    public void onUpdate() {
        Step a;
        if (Step.nullCheck()) {
            return;
        }
        if (Step.mc.field_1724.method_5715() || !Step.mc.field_1724.field_5976 || Step.mc.field_1724.method_5771() || Step.mc.field_1724.method_5799() || !Step.mc.field_1724.method_24828() || !EntityUtil.isInsideBlock() && HoleKick.isInWeb((class_1657)Step.mc.field_1724)) {
            Step.mc.field_1724.method_49477(0.6f);
            return;
        }
        Step.mc.field_1724.method_49477(a.stepHeight.getValueFloat());
    }

    public Step() {
        Step a;
        Step step = a;
        Step step2 = a;
        super(BlockUpUtil.ALLATORIxDEMO("ks\u0017="), Module.Category.Movement);
        Step step3 = a;
        step3.stepHeight = step2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("$X\u0018GS\u001e"), 1.0, 0.0, 5.0, 0.5));
        step.onlyMoving = step2.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("jtNdhuNn\u001c*"), true));
        step.setChinese(FadeUtils.ALLATORIxDEMO("\u6b14\u886c\u8fbe\u52c3"));
        INSTANCE = step;
    }

    @Override
    public void onDisable() {
        if (Step.nullCheck()) {
            return;
        }
        Step.mc.field_1724.method_49477(0.6f);
    }
}
