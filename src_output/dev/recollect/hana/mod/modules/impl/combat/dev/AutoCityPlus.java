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
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2560
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.AntiCrawl;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.ClientInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
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
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2560;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoCityPlus
extends Module {
    private final BooleanSetting burrow;
    private final BooleanSetting down;
    private final BooleanSetting face;
    private final BooleanSetting lowVersion;
    public final SliderSetting targetRange;
    public final SliderSetting range;
    private final BooleanSetting usingPause;
    private final BooleanSetting surround;
    public static AutoCityPlus INSTANCE;

    private /* synthetic */ boolean canBreak(class_2338 class_23382) {
        AutoCityPlus a = this;
        AutoCityPlus a2 = class_23382;
        return !(!a.isObsidian((class_2338)a2) || BlockUtil.getClickSideStrict((class_2338)a2) == null && !SpeedMine.breakPos.equals((Object)a2) || a2.equals((Object)SpeedMine.secondPos) && AutoCityPlus.mc.field_1724.method_6047().method_7909() instanceof class_1810);
    }

    private /* synthetic */ boolean isObsidian(class_2338 class_23382) {
        AutoCityPlus a = class_23382;
        AutoCityPlus a2 = this;
        return AutoCityPlus.mc.field_1724.method_33571().method_1022(a.method_46558()) <= a2.range.getValue() && (BlockUtil.getBlock((class_2338)a) == class_2246.field_10540 || BlockUtil.getBlock((class_2338)a) == class_2246.field_10443 || BlockUtil.getBlock((class_2338)a) == class_2246.field_22108 || BlockUtil.getBlock((class_2338)a) == class_2246.field_23152) && BlockUtil.getClickSideStrict((class_2338)a) != null;
    }

    private /* synthetic */ boolean canCrystal(class_2338 class_23382) {
        AutoCityPlus a = class_23382;
        AutoCityPlus a2 = this;
        if (SpeedMine.godBlocks.contains((Object)BlockUtil.getBlock((class_2338)a)) || BlockUtil.getBlock((class_2338)a) instanceof class_2244 || BlockUtil.getBlock((class_2338)a) instanceof class_2560 || !a2.canPlaceCrystal((class_2338)a, true) || BlockUtil.getClickSideStrict((class_2338)a) == null) {
            return false;
        }
        return !SpeedMine.godBlocks.contains((Object)BlockUtil.getBlock(a.method_10084())) && !(BlockUtil.getBlock(a.method_10084()) instanceof class_2244) && !(BlockUtil.getBlock(a.method_10084()) instanceof class_2560) && BlockUtil.getClickSideStrict(a.method_10084()) != null;
    }

    private /* synthetic */ void doMine(class_2338 class_23382) {
        AutoCityPlus a = this;
        AutoCityPlus a2 = class_23382;
        if (a.canBreak((class_2338)a2)) {
            SpeedMine.INSTANCE.mine((class_2338)a2);
            return;
        }
        if (a.canBreak(a2.method_10084())) {
            SpeedMine.INSTANCE.mine(a2.method_10084());
        }
    }

    private /* synthetic */ int getAir(class_2338 a) {
        AutoCityPlus a22;
        AutoCityPlus autoCityPlus = a22;
        int a22 = 0;
        if (!autoCityPlus.canBreak(a)) {
            ++a22;
        }
        if (!autoCityPlus.canBreak(a.method_10084())) {
            ++a22;
        }
        return a22;
    }

    public AutoCityPlus() {
        AutoCityPlus a;
        AutoCityPlus autoCityPlus = a;
        AutoCityPlus autoCityPlus2 = a;
        super(TimeHelper.ALLATORIxDEMO("4BT\rd\fT\u001bm\u0013\u0002F"), Module.Category.Combat);
        AutoCityPlus autoCityPlus3 = a;
        autoCityPlus3.burrow = autoCityPlus2.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("A;l!;n"), true));
        autoCityPlus2.face = autoCityPlus2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("{\u001e\u0014P"), true));
        autoCityPlus2.down = autoCityPlus2.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("Z<#w"), false));
        autoCityPlus2.surround = autoCityPlus2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("t\u0010R\u0010R\n\u0019Q"), true));
        autoCityPlus2.lowVersion = autoCityPlus2.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("/}e+"), false));
        autoCityPlus2.targetRange = autoCityPlus2.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("cA\u0010@\u0000T0\\\u0011\u0010P"), 6.0, 0.0, 8.0, 0.1).setSuffix(ClientInfo.ALLATORIxDEMO("t")));
        autoCityPlus2.range = autoCityPlus2.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("0\\\u0011\u0010P"), 6.0, 0.0, 8.0, 0.1).setSuffix(ClientInfo.ALLATORIxDEMO("t")));
        autoCityPlus.usingPause = autoCityPlus2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("yO7T\fN\u0005p\u0016\u0019P"), true));
        autoCityPlus.setChinese(ClientInfo.ALLATORIxDEMO("\u81a4\u52b6\u6345\u814e2"));
        INSTANCE = autoCityPlus;
    }

    public boolean canPlaceCrystal(class_2338 a, boolean a2) {
        AutoCityPlus a3;
        AutoCityPlus autoCityPlus = a3;
        a = a.method_10074();
        a3 = a.method_10084();
        return !(BlockUtil.getBlock(a) != class_2246.field_9987 && BlockUtil.getBlock(a) != class_2246.field_10540 && a2 || BlockUtil.hasEntityBlockCrystal((class_2338)a3, true, true) || BlockUtil.hasEntityBlockCrystal(a3.method_10084(), true, true) || autoCityPlus.lowVersion.getValue() && !AutoCityPlus.mc.field_1687.method_22347(a3.method_10084()));
    }

    private /* synthetic */ void doBreak(class_1657 a2) {
        double d;
        reference var12_41;
        int n;
        class_2350 class_23502;
        Object object;
        reference var17_46;
        Object object2;
        int n2;
        int n3;
        Object object3;
        AutoCityPlus a332222;
        int n4;
        AutoCityPlus autoCityPlus = a332222;
        class_2338 class_23382 = EntityUtil.getEntityPos((class_1297)a2, true);
        class_2350 class_23503 = new double[3];
        class_23503[0] = -0.8;
        class_23503[1] = 0.5;
        class_23503[2] = 1.1;
        Object object4 = class_23503;
        double[] arrd = new double[2];
        arrd[0] = 0.3;
        arrd[1] = -0.3;
        double[] arrd2 = arrd;
        for (class_1657 a332222 : CombatUtil.getEnemies(autoCityPlus.targetRange.getValue())) {
            int n5;
            class_23502 = object4;
            int n6 = ((double[])class_23502).length;
            int n7 = n5 = 0;
            while (n7 < n6) {
                int n8;
                d = class_23502[n5];
                var12_41 = arrd2;
                n = ((double[])var12_41).length;
                int n9 = n8 = 0;
                while (n9 < n) {
                    int n10;
                    object3 = var12_41[n8];
                    var17_46 = arrd2;
                    n3 = ((double[])var17_46).length;
                    int n11 = n10 = 0;
                    while (n11 < n3) {
                        object2 = var17_46[n10];
                        BlockPosX blockPosX = new BlockPosX(a332222.method_23317() + object3, a332222.method_23318() + d, a332222.method_23321() + object2);
                        if (autoCityPlus.canBreak(blockPosX) && blockPosX.equals((Object)SpeedMine.breakPos)) {
                            return;
                        }
                        n11 = ++n10;
                    }
                    n9 = ++n8;
                }
                n7 = ++n5;
            }
        }
        Object object5 = new ArrayList();
        if (autoCityPlus.down.getValue()) {
            object5.add(Float.valueOf(-0.8f));
        }
        if (autoCityPlus.burrow.getValue()) {
            object5.add(Float.valueOf(0.5f));
        }
        if (autoCityPlus.face.getValue()) {
            object5.add(Float.valueOf(1.1f));
        }
        Iterator a332222 = object5.iterator();
        while (a332222.hasNext()) {
            double d2 = ((Float)a332222.next()).floatValue();
            double[] arrd3 = arrd2;
            d = arrd3.length;
            int n12 = n2 = 0;
            while (n12 < d) {
                var12_41 = (reference)arrd3[n2];
                object = new BlockPosX(a2.method_23317() + var12_41, a2.method_23318() + d2, a2.method_23321() + var12_41);
                if (autoCityPlus.canBreak((class_2338)object)) {
                    SpeedMine.INSTANCE.mine((class_2338)object);
                    return;
                }
                n12 = ++n2;
            }
        }
        a332222 = object5.iterator();
        while (a332222.hasNext()) {
            double d3 = ((Float)a332222.next()).floatValue();
            double[] arrd4 = arrd2;
            d = arrd4.length;
            int n13 = n2 = 0;
            while (n13 < d) {
                var12_41 = (reference)arrd4[n2];
                object = arrd2;
                object3 = ((double[])object).length;
                int n14 = n4 = 0;
                while (n14 < object3) {
                    var17_46 = (reference)object[n4];
                    BlockPosX blockPosX = new BlockPosX(a2.method_23317() + var17_46, a2.method_23318() + d3, a2.method_23321() + var12_41);
                    if (autoCityPlus.canBreak(blockPosX)) {
                        SpeedMine.INSTANCE.mine(blockPosX);
                        return;
                    }
                    n14 = ++n4;
                }
                n13 = ++n2;
            }
        }
        if (autoCityPlus.surround.getValue()) {
            if (!autoCityPlus.lowVersion.getValue()) {
                int n15;
                int a332222;
                object4 = class_2350.values();
                int n16 = ((class_2350[])object4).length;
                int n17 = n15 = 0;
                while (n17 < n16) {
                    double a332222 = object4[n15];
                    if (a332222 != class_2350.field_11036 && a332222 != class_2350.field_11033 && !(Math.sqrt(AutoCityPlus.mc.field_1724.method_33571().method_1025(class_23382.method_10093((class_2350)a332222).method_46558())) > autoCityPlus.range.getValue()) && (AutoCityPlus.mc.field_1687.method_22347(class_23382.method_10093((class_2350)a332222)) || class_23382.method_10093((class_2350)a332222).equals((Object)SpeedMine.breakPos)) && autoCityPlus.canPlaceCrystal(class_23382.method_10093((class_2350)a332222), false)) {
                        return;
                    }
                    n17 = ++n15;
                }
                object4 = new ArrayList();
                class_2350[] arrclass_2350 = class_2350.values();
                n15 = arrclass_2350.length;
                int n18 = a332222 = 0;
                while (n18 < n15) {
                    class_23502 = arrclass_2350[a332222];
                    if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && !(Math.sqrt(AutoCityPlus.mc.field_1724.method_33571().method_1025(class_23382.method_10093(class_23502).method_46558())) > autoCityPlus.range.getValue()) && autoCityPlus.canBreak(class_23382.method_10093(class_23502)) && autoCityPlus.canPlaceCrystal(class_23382.method_10093(class_23502), true)) {
                        ((ArrayList)object4).add(class_23382.method_10093(class_23502));
                    }
                    n18 = ++a332222;
                }
                if (!((ArrayList)object4).isEmpty()) {
                    SpeedMine.INSTANCE.mine(object4.stream().min(Comparator.comparingDouble(a -> a.method_19770((class_2374)AutoCityPlus.mc.field_1724.method_33571()))).get());
                } else {
                    arrclass_2350 = class_2350.values();
                    n15 = arrclass_2350.length;
                    int n19 = a332222 = 0;
                    while (n19 < n15) {
                        class_23502 = arrclass_2350[a332222];
                        if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && !(Math.sqrt(AutoCityPlus.mc.field_1724.method_33571().method_1025(class_23382.method_10093(class_23502).method_46558())) > autoCityPlus.range.getValue()) && autoCityPlus.canBreak(class_23382.method_10093(class_23502)) && autoCityPlus.canPlaceCrystal(class_23382.method_10093(class_23502), false)) {
                            ((ArrayList)object4).add(class_23382.method_10093(class_23502));
                        }
                        n19 = ++a332222;
                    }
                    if (!((ArrayList)object4).isEmpty()) {
                        SpeedMine.INSTANCE.mine(object4.stream().min(Comparator.comparingDouble(a -> a.method_19770((class_2374)AutoCityPlus.mc.field_1724.method_33571()))).get());
                    }
                }
            } else {
                int a332222;
                int n20;
                object4 = class_2350.values();
                int n21 = ((class_2350[])object4).length;
                int n22 = n20 = 0;
                while (n22 < n21) {
                    double a332222 = object4[n20];
                    if (a332222 != class_2350.field_11036 && a332222 != class_2350.field_11033 && !(AutoCityPlus.mc.field_1724.method_33571().method_1022(class_23382.method_10093((class_2350)a332222).method_46558()) > autoCityPlus.range.getValue()) && AutoCityPlus.mc.field_1687.method_22347(class_23382.method_10093((class_2350)a332222)) && AutoCityPlus.mc.field_1687.method_22347(class_23382.method_10093((class_2350)a332222).method_10084()) && autoCityPlus.canPlaceCrystal(class_23382.method_10093((class_2350)a332222), false)) {
                        return;
                    }
                    n22 = ++n20;
                }
                object4 = new ArrayList();
                class_2350[] arrclass_2350 = class_2350.values();
                n20 = arrclass_2350.length;
                int n23 = a332222 = 0;
                while (n23 < n20) {
                    class_23502 = arrclass_2350[a332222];
                    if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && !(Math.sqrt(AutoCityPlus.mc.field_1724.method_33571().method_1025(class_23382.method_10093(class_23502).method_46558())) > autoCityPlus.range.getValue()) && autoCityPlus.canCrystal(class_23382.method_10093(class_23502))) {
                        ((ArrayList)object4).add(class_23382.method_10093(class_23502));
                    }
                    n23 = ++a332222;
                }
                int n24 = 0;
                class_2350 class_23504 = null;
                Iterator a332222 = ((ArrayList)object4).iterator();
                while (a332222.hasNext()) {
                    class_23502 = (class_2338)a332222.next();
                    if (autoCityPlus.getAir((class_2338)class_23502) < n24) continue;
                    n24 = autoCityPlus.getAir((class_2338)class_23502);
                }
                if (class_23504 != null) {
                    autoCityPlus.doMine((class_2338)class_23504);
                }
            }
        }
        if (SpeedMine.breakPos == null && autoCityPlus.burrow.getValue()) {
            int n25;
            double[] arrd5 = new double[3];
            arrd5[0] = 0.0;
            arrd5[1] = 0.3;
            arrd5[2] = -0.3;
            arrd2 = arrd5;
            double[] arrd6 = new double[2];
            arrd6[0] = 0.5;
            arrd6[1] = 1.1;
            object4 = arrd6;
            object5 = arrd6;
            int a332222 = ((double[])object5).length;
            int n26 = n25 = 0;
            while (n26 < a332222) {
                double d4 = object5[n25];
                double[] arrd7 = arrd2;
                n2 = arrd7.length;
                Object object6 = 0;
                var12_41 = (reference)0;
                while (object6 < n2) {
                    n = (int)arrd7[var12_41];
                    object3 = (Object)new BlockPosX(a2.method_23317() + n, a2.method_23318() + d4, a2.method_23321() + n);
                    if (autoCityPlus.isObsidian((class_2338)object3)) {
                        SpeedMine.INSTANCE.mine((class_2338)object3);
                        return;
                    }
                    object6 = ++var12_41;
                }
                n26 = ++n25;
            }
            object5 = object4;
            a332222 = ((Object)object5).length;
            int n27 = n25 = 0;
            while (n27 < a332222) {
                double d5 = object5[n25];
                double[] arrd8 = arrd2;
                n2 = arrd8.length;
                Object object7 = 0;
                var12_41 = (reference)0;
                while (object7 < n2) {
                    double[] arrd9 = arrd2;
                    n = (int)arrd8[var12_41];
                    object3 = arrd9;
                    n4 = arrd9.length;
                    Object object8 = 0;
                    var17_46 = (reference)0;
                    while (object8 < n4) {
                        n3 = object3[var17_46];
                        object2 = (Object)new BlockPosX(a2.method_23317() + n3, a2.method_23318() + d5, a2.method_23321() + n);
                        if (autoCityPlus.isObsidian((class_2338)object2)) {
                            SpeedMine.INSTANCE.mine((class_2338)object2);
                            return;
                        }
                        object8 = ++var17_46;
                    }
                    object7 = ++var12_41;
                }
                n27 = ++n25;
            }
        }
    }

    @Override
    public void onUpdate() {
        AutoCityPlus a;
        AutoCityPlus autoCityPlus = a;
        if (autoCityPlus.usingPause.getValue() && EntityUtil.isUsing()) {
            return;
        }
        if (AntiCrawl.INSTANCE.work) {
            return;
        }
        a = CombatUtil.getClosestEnemy(autoCityPlus.targetRange.getValue());
        if (a == null) {
            return;
        }
        autoCityPlus.doBreak((class_1657)a);
    }
}
