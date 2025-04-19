/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1810
 *  net.minecraft.class_2244
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.SilentDouble;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1810;
import net.minecraft.class_2244;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class AutoCity
extends Module {
    public static AutoCity INSTANCE;
    private final BooleanSetting surround;
    public final SliderSetting targetRange;
    private final BooleanSetting burrow;

    @Override
    public void onUpdate() {
        AutoCity a;
        AutoCity autoCity = a;
        a = CombatUtil.getClosestEnemy(autoCity.targetRange.getValue());
        if (a == null) {
            return;
        }
        AutoCity autoCity2 = autoCity;
        AutoCity autoCity3 = a;
        autoCity2.doBreak((class_1657)autoCity3);
        autoCity2.doBreak((class_1657)autoCity3);
    }

    private /* synthetic */ void doBreak(class_1657 a) {
        Object[] arrobject;
        AutoCity a222;
        AutoCity autoCity = a222;
        class_2338 class_23382 = EntityUtil.getEntityPos((class_1297)a, true);
        if (autoCity.burrow.getValue()) {
            double[] arrd;
            Object object;
            Object object2;
            int n;
            int n2;
            reference var12_23;
            int n3;
            int n4;
            reference var17_27;
            double[] arrd2 = new double[3];
            arrd2[0] = -0.8;
            arrd2[1] = 0.5;
            arrd2[2] = 1.1;
            arrobject = arrd2;
            double[] arrd3 = new double[3];
            arrd3[0] = 0.3;
            arrd3[1] = -0.3;
            arrd3[2] = 0.0;
            double[] arrd4 = arrd3;
            for (class_1657 a222 : CombatUtil.getEnemies(autoCity.targetRange.getValue())) {
                int n5;
                Object[] arrobject2 = arrobject;
                int n6 = arrobject2.length;
                int n7 = n5 = 0;
                while (n7 < n6) {
                    int n8;
                    arrd = arrobject2[n5];
                    var12_23 = arrd4;
                    n3 = ((double[])var12_23).length;
                    int n9 = n8 = 0;
                    while (n9 < n3) {
                        int n10;
                        object2 = var12_23[n8];
                        var17_27 = arrd4;
                        n4 = ((double[])var17_27).length;
                        int n11 = n10 = 0;
                        while (n11 < n4) {
                            object = var17_27[n10];
                            BlockPosX blockPosX = new BlockPosX(a222.method_23317() + object2, a222.method_23318() + arrd, a222.method_23321() + object);
                            if (autoCity.isObsidian(blockPosX) && blockPosX.equals((Object)SpeedMine.breakPos)) {
                                return;
                            }
                            n11 = ++n10;
                        }
                        n9 = ++n8;
                    }
                    n7 = ++n5;
                }
            }
            double[] arrd5 = new double[2];
            arrd5[0] = 0.5;
            arrd5[1] = 1.1;
            arrobject = arrd5;
            Object[] arrobject3 = arrd5;
            int a222 = arrobject3.length;
            int n12 = n2 = 0;
            while (n12 < a222) {
                double d = arrobject3[n2];
                arrd = arrd4;
                n = arrd.length;
                Object object3 = 0;
                var12_23 = (reference)0;
                while (object3 < n) {
                    n3 = (int)arrd[var12_23];
                    object2 = (Object)new BlockPosX(a.method_23317() + n3, a.method_23318() + d, a.method_23321() + n3);
                    if (autoCity.isObsidian((class_2338)object2)) {
                        SpeedMine.INSTANCE.mine((class_2338)object2);
                        return;
                    }
                    object3 = ++var12_23;
                }
                n12 = ++n2;
            }
            arrobject3 = arrobject;
            a222 = arrobject3.length;
            int n13 = n2 = 0;
            while (n13 < a222) {
                double d = arrobject3[n2];
                arrd = arrd4;
                n = arrd.length;
                Object object4 = 0;
                var12_23 = (reference)0;
                while (object4 < n) {
                    double[] arrd6 = arrd4;
                    n3 = (int)arrd[var12_23];
                    object2 = arrd6;
                    int n14 = arrd6.length;
                    Object object5 = 0;
                    var17_27 = (reference)0;
                    while (object5 < n14) {
                        n4 = object2[var17_27];
                        object = (Object)new BlockPosX(a.method_23317() + n4, a.method_23318() + d, a.method_23321() + n3);
                        if (autoCity.isObsidian((class_2338)object)) {
                            SpeedMine.INSTANCE.mine((class_2338)object);
                            return;
                        }
                        object5 = ++var17_27;
                    }
                    object4 = ++var12_23;
                }
                n13 = ++n2;
            }
        }
        if (autoCity.surround.getValue()) {
            int n;
            arrobject = class_2350.values();
            int n15 = arrobject.length;
            int n16 = n = 0;
            while (n16 < n15) {
                class_2350 a222 = arrobject[n];
                if (a222 != class_2350.field_11036 && a222 != class_2350.field_11033 && BlockUtil.isAir(class_23382.method_10093(a222)) && !a.method_5829().method_994(new class_238(class_23382.method_10093(a222)))) {
                    return;
                }
                n16 = ++n;
            }
            arrobject = class_2350.values();
            n15 = arrobject.length;
            int n17 = n = 0;
            while (n17 < n15) {
                class_2350 a222 = arrobject[n];
                if (a222 != class_2350.field_11036 && a222 != class_2350.field_11033 && !SpeedMine.godBlocks.contains((Object)BlockUtil.getBlock(class_23382.method_10093(a222))) && !(BlockUtil.getBlock(class_23382.method_10093(a222)) instanceof class_2244)) {
                    SpeedMine.INSTANCE.mine(class_23382.method_10093(a222));
                    return;
                }
                n17 = ++n;
            }
        }
    }

    public AutoCity() {
        AutoCity a;
        AutoCity autoCity = a;
        AutoCity autoCity2 = a;
        super(TimeHelper.ALLATORIxDEMO("f\u0010T\r~\u0016\u0003L"), Module.Category.Combat);
        AutoCity autoCity3 = a;
        autoCity3.burrow = autoCity2.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("o\u001eB\u0004R\f"), true));
        autoCity2.surround = autoCity2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("t\u0010R\u0010R\n\u0019Q"), true));
        autoCity.targetRange = autoCity2.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("\"J\u001f`$Y9Q\u0018Z\u001e"), 6.0, 0.0, 8.0, 0.1));
        autoCity.setChinese(TimeHelper.ALLATORIxDEMO("\u81d7\u52d7\u6361\u812f"));
        INSTANCE = autoCity;
    }

    private /* synthetic */ boolean isObsidian(class_2338 class_23382) {
        AutoCity a = class_23382;
        AutoCity a2 = this;
        return (BlockUtil.getBlock((class_2338)a) == class_2246.field_10540 || BlockUtil.getBlock((class_2338)a) == class_2246.field_10443) && BlockUtil.getClickSideStrict((class_2338)a) != null && (!a.equals((Object)SpeedMine.secondPos) || !(AutoCity.mc.field_1724.method_6047().method_7909() instanceof class_1810) && !SilentDouble.INSTANCE.isOn());
    }
}
