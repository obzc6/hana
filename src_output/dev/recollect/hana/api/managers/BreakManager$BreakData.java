/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.BreakManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.render.BreakESP;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_638;

public static class BreakManager.BreakData {
    public final int entityId;
    public final class_2338 pos;
    public final FadeUtils fade;

    /*
     * WARNING - void declaration
     */
    public BreakManager.BreakData(class_2338 class_23382, int n) {
        BreakManager.BreakData a;
        void a2;
        int a3 = n;
        BreakManager.BreakData breakData = a = this;
        breakData.pos = a2;
        breakData.entityId = a3;
        BreakManager.BreakData breakData2 = a;
        breakData.fade = new FadeUtils((long)BreakESP.INSTANCE.animationTime.getValue());
    }

    public class_1297 getEntity() {
        BreakManager.BreakData a;
        BreakManager.BreakData breakData = a;
        a = Wrapper.mc.field_1687.method_8469(breakData.entityId);
        if (a instanceof class_1657) {
            return a;
        }
        return null;
    }
}
