/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class AutoFuck
extends Module {
    private static final class_310 mc = class_310.method_1551();
    private boolean wasSneaking = false;

    public AutoFuck() {
        super(BufferRing.ALLATORIxDEMO("\u000f\u000f=\u0012\u0012\u0015}A"), TimeHelper.ALLATORIxDEMO("VU\u0016HEF\u0017^\u0014V\u0014"), Module.Category.Player);
        AutoFuck a;
    }

    @Override
    public void onDisable() {
        AutoFuck.mc.field_1690.field_1832.method_23481(AutoFuck.mc.field_1690.field_1832.method_1434());
    }

    @Override
    public void onUpdate() {
        AutoFuck a;
        AutoFuck autoFuck = a;
        class_304 class_3042 = AutoFuck.mc.field_1690.field_1832;
        boolean bl = a = !AutoFuck.mc.field_1724.method_5715() || AutoFuck.mc.field_1690.field_1832.method_1434();
        if (a != class_3042.method_1434()) {
            class_3042.method_23481(a);
        }
    }
}
