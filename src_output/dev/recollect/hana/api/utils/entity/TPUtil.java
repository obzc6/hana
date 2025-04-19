/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.entity;

import com.google.common.collect.Lists;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.path.PathUtils;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class TPUtil
implements Wrapper {
    public static ArrayList<Vec3> tp(Runnable runnable, class_243 class_2432) {
        Object a2 = class_2432;
        Runnable a3 = runnable;
        a2 = PathUtils.computePath((class_243)a2);
        a2.forEach(a -> TPUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(a.getX(), a.getY(), a.getZ(), false)));
        a3.run();
        a2 = Lists.reverse((List)a2);
        a2.forEach(a -> TPUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(a.getX(), a.getY(), a.getZ(), false)));
        if (CombatSetting.INSTANCE.test.getValue()) {
            TPUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, -0.354844, 0.0, false));
            TPUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, 0.325488, 0.0, false));
            TPUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, -0.15441, 0.0, false));
            TPUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, -0.15444, 0.0, false));
        }
        return new ArrayList<Vec3>((Collection<Vec3>)a2);
    }

    public TPUtil() {
        TPUtil a;
    }
}
