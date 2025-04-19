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

import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.render.BreakESP;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_638;

public static class MineManager.BreakData {
    public final int entityId;
    public final class_2338 pos;
    public final FadeUtils fade;

    public class_1297 getEntity() {
        MineManager.BreakData a;
        MineManager.BreakData breakData = a;
        if (Wrapper.mc.field_1687 == null) {
            return null;
        }
        a = Wrapper.mc.field_1687.method_8469(breakData.entityId);
        if (a instanceof class_1657) {
            return a;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public MineManager.BreakData(class_2338 class_23382, int n) {
        void a;
        MineManager.BreakData a2;
        int a3 = n;
        MineManager.BreakData breakData = a2 = this;
        breakData.pos = a;
        breakData.entityId = a3;
        MineManager.BreakData breakData2 = a2;
        breakData.fade = new FadeUtils((long)BreakESP.INSTANCE.animationTime.getValue());
    }
}
