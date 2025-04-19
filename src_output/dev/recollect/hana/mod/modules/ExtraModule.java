/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_4587;

public class ExtraModule
implements Wrapper {
    public ExtraModule() {
        ExtraModule a;
        Hana.EVENT_BUS.subscribe(a);
    }

    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        ExtraModule a2 = this;
    }
}
