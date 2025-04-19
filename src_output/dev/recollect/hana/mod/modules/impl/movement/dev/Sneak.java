/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;

public class Sneak
extends Module {
    public static Sneak INSTANCE;

    @Override
    public void onDisable() {
        Sneak.mc.field_1690.field_1832.method_23481(false);
    }

    public Sneak() {
        Sneak a;
        Sneak sneak = a;
        super(TimeHelper.ALLATORIxDEMO("1S\u001a\u0016^"), Module.Category.Movement);
        sneak.setChinese(Snow.ALLATORIxDEMO("\u81e3\u52a0\u8e71"));
        INSTANCE = sneak;
    }

    @Override
    public void onUpdate() {
        Sneak.mc.field_1690.field_1832.method_23481(true);
    }
}
