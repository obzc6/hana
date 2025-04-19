/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.impl.render.CrystalPlaceESP;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_638;

class CrystalPlaceESP.1
implements Iterable<class_1297> {
    final /* synthetic */ CrystalPlaceESP this$0;

    CrystalPlaceESP.1(CrystalPlaceESP crystalPlaceESP) {
        CrystalPlaceESP a = crystalPlaceESP;
        CrystalPlaceESP.1 a2 = this;
        a2.this$0 = a;
    }

    @Override
    public Iterator<class_1297> iterator() {
        return Wrapper.mc.field_1687.method_18112().iterator();
    }
}
