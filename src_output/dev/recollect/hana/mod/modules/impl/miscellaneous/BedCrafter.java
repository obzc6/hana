/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1714
 *  net.minecraft.class_1739
 *  net.minecraft.class_1748
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1860
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_299
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_516
 *  net.minecraft.class_5455
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_8786
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1714;
import net.minecraft.class_1739;
import net.minecraft.class_1748;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1860;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_299;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_516;
import net.minecraft.class_5455;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_8786;

@Beta
public class BedCrafter
extends Module {
    public static BedCrafter INSTANCE;
    private final BooleanSetting disable;
    private final SliderSetting beds;
    private final SliderSetting range;
    boolean open;
    private final BooleanSetting rotate;

    private /* synthetic */ void doPlace() {
        boolean bl;
        BedCrafter bedCrafter;
        class_2338 class_23382;
        class_2338 class_23383;
        block5 : {
            BedCrafter a22;
            bedCrafter = a22;
            class_23383 = null;
            double d = 100.0;
            bl = true;
            for (class_2338 a22 : BlockUtil.getSphere(bedCrafter.range.getValueFloat())) {
                if (BedCrafter.mc.field_1687.method_8320(a22).method_26204() == class_2246.field_9980 && BlockUtil.getClickSideStrict(a22) != null) {
                    bl = false;
                    class_23382 = class_23383 = a22;
                    break block5;
                }
                if (!BlockUtil.canPlace(a22) || class_23383 != null && !((double)class_3532.method_15355((float)((float)BedCrafter.mc.field_1724.method_5707(a22.method_46558()))) < d)) continue;
                class_23383 = a22;
                d = class_3532.method_15355((float)((float)BedCrafter.mc.field_1724.method_5707(a22.method_46558())));
            }
            class_23382 = class_23383;
        }
        if (class_23382 != null) {
            if (!bl) {
                class_2338 class_23384 = class_23383;
                BlockUtil.clickBlock(class_23384, BlockUtil.getClickSide(class_23384), bedCrafter.rotate.getValue());
                return;
            }
            if (InventoryUtil.findItem(class_1792.method_7867((class_2248)class_2246.field_9980)) == -1) {
                return;
            }
            int n = BedCrafter.mc.field_1724.method_31548().field_7545;
            InventoryUtil.switchToSlot(InventoryUtil.findItem(class_1792.method_7867((class_2248)class_2246.field_9980)));
            BlockUtil.placeBlock(class_23383, bedCrafter.rotate.getValue());
            InventoryUtil.switchToSlot(n);
        }
    }

    public BedCrafter() {
        BedCrafter a;
        BedCrafter bedCrafter = a;
        BedCrafter bedCrafter2 = a;
        super(TimerManager.ALLATORIxDEMO(";.\u001a\u000f\u000b*\u0002\"Kn"), Module.Category.Misc);
        BedCrafter bedCrafter3 = a;
        bedCrafter3.rotate = bedCrafter2.add(new BooleanSetting(Setting.ALLATORIxDEMO("I7r$8j"), false));
        bedCrafter2.range = bedCrafter2.add(new SliderSetting(TimerManager.ALLATORIxDEMO("\u0019\u00058Iy"), 5, 0, 8));
        bedCrafter2.beds = bedCrafter2.add(new SliderSetting(Setting.ALLATORIxDEMO("D (|"), 5, 1, 30));
        bedCrafter2.disable = bedCrafter2.add(new BooleanSetting(TimerManager.ALLATORIxDEMO("\b\u00108\u00054By"), true));
        bedCrafter.open = false;
        bedCrafter.setChinese(Setting.ALLATORIxDEMO("\u81b2\u52ae\u544d\u625c\u5e85"));
        INSTANCE = bedCrafter;
    }

    @Override
    public void onUpdate() {
        Object a;
        BedCrafter bedCrafter = a;
        if (BedCrafter.getEmptySlots() == 0) {
            if (BedCrafter.mc.field_1724.field_7512 instanceof class_1714) {
                BedCrafter.mc.field_1724.method_7346();
            }
            if (bedCrafter.disable.getValue()) {
                bedCrafter.disable();
            }
            return;
        }
        if (BedCrafter.mc.field_1724.field_7512 instanceof class_1714) {
            bedCrafter.open = true;
            boolean bl = false;
            Iterator iterator = BedCrafter.mc.field_1724.method_3130().method_1393().iterator();
            block0 : while (iterator.hasNext()) {
                for (class_8786 class_87862 : ((class_516)iterator.next()).method_2648(true)) {
                    int n;
                    if (!(class_87862.comp_1933().method_8110(BedCrafter.mc.field_1687.method_30349()).method_7909() instanceof class_1748)) continue;
                    int n2 = 0;
                    int n3 = n = 0;
                    while (n3 < BedCrafter.getEmptySlots()) {
                        bl = true;
                        if (n2 >= bedCrafter.beds.getValueInt()) continue block0;
                        ++n2;
                        BedCrafter.mc.field_1761.method_2912(BedCrafter.mc.field_1724.field_7512.field_7763, class_87862, false);
                        BedCrafter.mc.field_1761.method_2906(BedCrafter.mc.field_1724.field_7512.field_7763, 0, 1, class_1713.field_7794, (class_1657)BedCrafter.mc.field_1724);
                        n3 = ++n;
                    }
                    continue block0;
                }
            }
            if (!bl) {
                if (BedCrafter.mc.field_1724.field_7512 instanceof class_1714) {
                    BedCrafter.mc.field_1724.method_7346();
                }
                if (bedCrafter.disable.getValue()) {
                    bedCrafter.disable();
                    return;
                }
            }
        } else {
            if (bedCrafter.disable.getValue() && bedCrafter.open) {
                bedCrafter.disable();
                return;
            }
            bedCrafter.doPlace();
        }
    }

    public static int getEmptySlots() {
        int n;
        int n2 = 0;
        int n3 = n = 0;
        while (n3 < 36) {
            class_1799 class_17992 = BedCrafter.mc.field_1724.method_31548().method_5438(n);
            if (class_17992 == null || class_17992.method_7909() instanceof class_1739) {
                ++n2;
            }
            n3 = ++n;
        }
        return n2;
    }

    @Override
    public void onDisable() {
        a.open = false;
    }
}
