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
package dev.recollect.hana.mod.modules.impl.vanilla;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.SilentDouble;
import dev.recollect.hana.mod.modules.impl.vanilla.VSpeedMine;
import dev.recollect.hana.mod.modules.settings.Setting;
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
import org.bytedeco.javacv.BaseChildSettings;

public class VAutoCity
extends Module {
    public final SliderSetting targetRange;
    private final BooleanSetting surround;
    private final BooleanSetting burrow;
    public static VAutoCity INSTANCE;

    private /* synthetic */ void doBreak(class_1657 a) {
        Object[] arrobject;
        VAutoCity a222;
        VAutoCity vAutoCity = a222;
        class_2338 class_23382 = EntityUtil.getEntityPos((class_1297)a, true);
        if (vAutoCity.burrow.getValue()) {
            int n;
            int n2;
            Object object;
            double[] arrd;
            Object object2;
            reference var17_27;
            int n3;
            reference var12_23;
            int n4;
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
            for (class_1657 a222 : CombatUtil.getEnemies(vAutoCity.targetRange.getValue())) {
                int n5;
                Object[] arrobject2 = arrobject;
                int n6 = arrobject2.length;
                int n7 = n5 = 0;
                while (n7 < n6) {
                    int n8;
                    arrd = arrobject2[n5];
                    var12_23 = arrd4;
                    n = ((double[])var12_23).length;
                    int n9 = n8 = 0;
                    while (n9 < n) {
                        int n10;
                        object2 = var12_23[n8];
                        var17_27 = arrd4;
                        n2 = ((double[])var17_27).length;
                        int n11 = n10 = 0;
                        while (n11 < n2) {
                            object = var17_27[n10];
                            BlockPosX blockPosX = new BlockPosX(a222.method_23317() + object2, a222.method_23318() + arrd, a222.method_23321() + object);
                            if (vAutoCity.isObsidian(blockPosX) && blockPosX.equals((Object)VSpeedMine.breakPos)) {
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
            int n12 = n3 = 0;
            while (n12 < a222) {
                double d = arrobject3[n3];
                arrd = arrd4;
                n4 = arrd.length;
                Object object3 = 0;
                var12_23 = (reference)0;
                while (object3 < n4) {
                    n = (int)arrd[var12_23];
                    object2 = (Object)new BlockPosX(a.method_23317() + n, a.method_23318() + d, a.method_23321() + n);
                    if (vAutoCity.isObsidian((class_2338)object2)) {
                        VSpeedMine.INSTANCE.mine((class_2338)object2);
                        return;
                    }
                    object3 = ++var12_23;
                }
                n12 = ++n3;
            }
            arrobject3 = arrobject;
            a222 = arrobject3.length;
            int n13 = n3 = 0;
            while (n13 < a222) {
                double d = arrobject3[n3];
                arrd = arrd4;
                n4 = arrd.length;
                Object object4 = 0;
                var12_23 = (reference)0;
                while (object4 < n4) {
                    double[] arrd6 = arrd4;
                    n = (int)arrd[var12_23];
                    object2 = arrd6;
                    int n14 = arrd6.length;
                    Object object5 = 0;
                    var17_27 = (reference)0;
                    while (object5 < n14) {
                        n2 = object2[var17_27];
                        object = (Object)new BlockPosX(a.method_23317() + n2, a.method_23318() + d, a.method_23321() + n);
                        if (vAutoCity.isObsidian((class_2338)object)) {
                            VSpeedMine.INSTANCE.mine((class_2338)object);
                            return;
                        }
                        object5 = ++var17_27;
                    }
                    object4 = ++var12_23;
                }
                n13 = ++n3;
            }
        }
        if (vAutoCity.surround.getValue()) {
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
                if (a222 != class_2350.field_11036 && a222 != class_2350.field_11033 && !VSpeedMine.godBlocks.contains((Object)BlockUtil.getBlock(class_23382.method_10093(a222))) && !(BlockUtil.getBlock(class_23382.method_10093(a222)) instanceof class_2244)) {
                    VSpeedMine.INSTANCE.mine(class_23382.method_10093(a222));
                    return;
                }
                n17 = ++n;
            }
        }
    }

    public VAutoCity() {
        VAutoCity a;
        VAutoCity vAutoCity = a;
        VAutoCity vAutoCity2 = a;
        super(Setting.ALLATORIxDEMO("\u000e]*o7E,8v"), Module.Category.Combat);
        VAutoCity vAutoCity3 = a;
        vAutoCity3.burrow = vAutoCity2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("e&H<\u001fs"), true));
        vAutoCity2.surround = vAutoCity2.add(new BooleanSetting(Setting.ALLATORIxDEMO("O*i*i0\"k"), true));
        vAutoCity.targetRange = vAutoCity2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("RF!G1S\u0001[ \u0017a"), 6.0, 0.0, 400.0, 0.1));
        vAutoCity.setChinese(Setting.ALLATORIxDEMO("\u5399\u720d\u635a\u8115"));
        INSTANCE = vAutoCity;
    }

    @Override
    public void onUpdate() {
        VAutoCity a;
        VAutoCity vAutoCity = a;
        a = CombatUtil.getClosestEnemy(vAutoCity.targetRange.getValue());
        if (a == null) {
            return;
        }
        VAutoCity vAutoCity2 = vAutoCity;
        VAutoCity vAutoCity3 = a;
        vAutoCity2.doBreak((class_1657)vAutoCity3);
        vAutoCity2.doBreak((class_1657)vAutoCity3);
    }

    private /* synthetic */ boolean isObsidian(class_2338 class_23382) {
        VAutoCity a = class_23382;
        VAutoCity a2 = this;
        return (BlockUtil.getBlock((class_2338)a) == class_2246.field_10540 || BlockUtil.getBlock((class_2338)a) == class_2246.field_10443) && BlockUtil.getClickSideStrict((class_2338)a) != null && (!a.equals((Object)VSpeedMine.secondPos) || !(VAutoCity.mc.field_1724.method_6047().method_7909() instanceof class_1810) && !SilentDouble.INSTANCE.isOn());
    }
}
