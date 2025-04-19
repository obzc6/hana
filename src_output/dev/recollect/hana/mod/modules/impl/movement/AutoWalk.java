/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;

public class AutoWalk
extends Module {
    public static AutoWalk INSTANCE;

    public AutoWalk() {
        AutoWalk a;
        AutoWalk autoWalk = a;
        super(BOEntityUtils.ALLATORIxDEMO("e}fQHRt_"), Module.Category.Movement);
        autoWalk.setChinese(ProjectionUtils.ALLATORIxDEMO("\u81c2\u52c6\u8d5f\u8d86"));
        INSTANCE = autoWalk;
    }

    @Override
    public void onDisable() {
        AutoWalk.mc.field_1690.field_1894.method_23481(false);
    }

    @Override
    public void onUpdate() {
        AutoWalk.mc.field_1690.field_1894.method_23481(true);
    }
}
