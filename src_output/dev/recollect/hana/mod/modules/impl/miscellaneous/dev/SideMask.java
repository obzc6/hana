/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.SnowAnimation;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class SideMask
extends Module {
    public SideMask() {
        SideMask a;
        SideMask sideMask = a;
        super(SnowAnimation.ALLATORIxDEMO("B&Y\u0006b\u0010D\u0002"), Module.Category.Misc);
        sideMask.setChinese(BaseChildSettings.ALLATORIxDEMO("s=C6w/\u0003o"));
    }

    @Override
    public void onUpdate() {
        SideMask a22;
        SideMask sideMask = a22;
        if (SideMask.mc.field_1724 == null || SideMask.mc.field_1687 == null) {
            return;
        }
        if (SideMask.mc.field_1724.method_7325()) {
            return;
        }
        float a22 = 360.0f;
        a22 = 6.2831855f * a22 / 20.0f;
        a22 = SideMask.mc.field_1724.method_36454() + a22;
        float f = SideMask.mc.field_1724.method_36455();
        SideMask.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2831(a22, f, SideMask.mc.field_1724.method_24828()));
    }
}
