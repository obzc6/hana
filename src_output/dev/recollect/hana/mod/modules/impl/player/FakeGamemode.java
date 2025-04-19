/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1934
 *  net.minecraft.class_310
 *  net.minecraft.class_636
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_1934;
import net.minecraft.class_310;
import net.minecraft.class_636;

public class FakeGamemode
extends Module {
    boolean set = false;

    @Override
    public void onDisable() {
        FakeGamemode a;
        if (a.set) {
            a.set = false;
            if (FakeGamemode.mc.field_1761.method_2920() == class_1934.field_9220) {
                FakeGamemode.mc.field_1761.method_2907(FakeGamemode.mc.field_1761.method_28107());
            }
        }
    }

    @Override
    public void onEnable() {
        if (FakeGamemode.nullCheck()) {
            return;
        }
        if (FakeGamemode.mc.field_1761.method_2920() == class_1934.field_9220) {
            return;
        }
        a.set = true;
        FakeGamemode.mc.field_1761.method_2907(class_1934.field_9220);
    }

    public FakeGamemode() {
        super(MathUtil.ALLATORIxDEMO("*\u0011\u000f\u001d+\u0011\u0003\u0017\b\u0016\u0000\u001d"), Module.Category.Player);
        FakeGamemode a;
        a.setChinese(NCPRaytracer.ALLATORIxDEMO("\u506c\u6e37\u622f\u6a2f\u5f2e"));
    }
}
