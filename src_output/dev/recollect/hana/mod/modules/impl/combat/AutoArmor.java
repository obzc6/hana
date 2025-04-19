/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1723
 *  net.minecraft.class_1738
 *  net.minecraft.class_1770
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1890
 *  net.minecraft.class_1900
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.ElytraFly;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1723;
import net.minecraft.class_1738;
import net.minecraft.class_1770;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1890;
import net.minecraft.class_1900;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class AutoArmor
extends Module {
    private int tickDelay;
    private final BooleanSetting noMove;
    public static AutoArmor INSTANCE;
    private final BooleanSetting autoElytra;
    private final SliderSetting delay;

    @Override
    public void onUpdate() {
        Map.Entry a2;
        AutoArmor autoArmor = a2;
        if (!(AutoArmor.mc.field_1755 == null || AutoArmor.mc.field_1755 instanceof class_408 || AutoArmor.mc.field_1755 instanceof class_490 || AutoArmor.mc.field_1755 instanceof ClickGuiScreen)) {
            return;
        }
        if (AutoArmor.mc.field_1724.field_7498 != AutoArmor.mc.field_1724.field_7512) {
            return;
        }
        if (MovementUtil.isMoving() && autoArmor.noMove.getValue()) {
            return;
        }
        if (autoArmor.tickDelay > 0) {
            --autoArmor.tickDelay;
            return;
        }
        autoArmor.tickDelay = autoArmor.delay.getValueInt();
        HashMap<class_1304, int[]> hashMap = new HashMap<class_1304, int[]>(4);
        int[] arrn = new int[4];
        arrn[0] = 36;
        arrn[1] = autoArmor.getProtection(AutoArmor.mc.field_1724.method_31548().method_5438(36));
        arrn[2] = -1;
        arrn[3] = -1;
        hashMap.put(class_1304.field_6166, arrn);
        int[] arrn2 = new int[4];
        arrn2[0] = 37;
        arrn2[1] = autoArmor.getProtection(AutoArmor.mc.field_1724.method_31548().method_5438(37));
        arrn2[2] = -1;
        arrn2[3] = -1;
        hashMap.put(class_1304.field_6172, arrn2);
        int[] arrn3 = new int[4];
        arrn3[0] = 38;
        arrn3[1] = autoArmor.getProtection(AutoArmor.mc.field_1724.method_31548().method_5438(38));
        arrn3[2] = -1;
        arrn3[3] = -1;
        hashMap.put(class_1304.field_6174, arrn3);
        int[] arrn4 = new int[4];
        arrn4[0] = 39;
        arrn4[1] = autoArmor.getProtection(AutoArmor.mc.field_1724.method_31548().method_5438(39));
        arrn4[2] = -1;
        arrn4[3] = -1;
        hashMap.put(class_1304.field_6169, arrn4);
        int n = 0;
        int n2 = n;
        while (n2 < 36) {
            if (AutoArmor.mc.field_1724.method_31548().method_5438(n).method_7909() instanceof class_1738 || AutoArmor.mc.field_1724.method_31548().method_5438(n).method_7909() == class_1802.field_8833) {
                int a2 = autoArmor.getProtection(AutoArmor.mc.field_1724.method_31548().method_5438(n));
                class_1304 class_13042 = AutoArmor.mc.field_1724.method_31548().method_5438(n).method_7909() instanceof class_1770 ? class_1304.field_6174 : ((class_1738)AutoArmor.mc.field_1724.method_31548().method_5438(n).method_7909()).method_7685();
                Iterator iterator = hashMap.entrySet().iterator();
                block1 : do {
                    Iterator iterator2 = iterator;
                    while (iterator2.hasNext()) {
                        Map.Entry entry = iterator.next();
                        if (autoArmor.autoElytra.getValue() && ElytraFly.INSTANCE.isOn() && entry.getKey() == class_1304.field_6174) {
                            if (!AutoArmor.mc.field_1724.method_31548().method_5438(38).method_7960() && AutoArmor.mc.field_1724.method_31548().method_5438(38).method_7909() instanceof class_1770 && class_1770.method_7804((class_1799)AutoArmor.mc.field_1724.method_31548().method_5438(38))) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (((int[])entry.getValue())[2] != -1 && !AutoArmor.mc.field_1724.method_31548().method_5438(((int[])entry.getValue())[2]).method_7960() && AutoArmor.mc.field_1724.method_31548().method_5438(((int[])entry.getValue())[2]).method_7909() instanceof class_1770 && class_1770.method_7804((class_1799)AutoArmor.mc.field_1724.method_31548().method_5438(((int[])entry.getValue())[2]))) {
                                iterator2 = iterator;
                                continue;
                            }
                            if (AutoArmor.mc.field_1724.method_31548().method_5438(n).method_7960() || !(AutoArmor.mc.field_1724.method_31548().method_5438(n).method_7909() instanceof class_1770) || !class_1770.method_7804((class_1799)AutoArmor.mc.field_1724.method_31548().method_5438(n))) continue block1;
                            ((int[])entry.getValue())[2] = n;
                            iterator2 = iterator;
                            continue;
                        }
                        if (a2 <= 0 || entry.getKey() != class_13042 || a2 <= ((int[])entry.getValue())[1] || a2 <= ((int[])entry.getValue())[3]) continue block1;
                        ((int[])entry.getValue())[2] = n;
                        ((int[])entry.getValue())[3] = a2;
                        continue block1;
                    }
                    break;
                } while (true);
            }
            n2 = ++n;
        }
        for (Map.Entry a2 : hashMap.entrySet()) {
            if (((int[])a2.getValue())[2] == -1) continue;
            if (((int[])a2.getValue())[1] == -1 && ((int[])a2.getValue())[2] < 9) {
                if (((int[])a2.getValue())[2] != AutoArmor.mc.field_1724.method_31548().field_7545) {
                    AutoArmor.mc.field_1724.method_31548().field_7545 = ((int[])a2.getValue())[2];
                    AutoArmor.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(((int[])a2.getValue())[2]));
                }
                AutoArmor.mc.field_1761.method_2906(AutoArmor.mc.field_1724.field_7512.field_7763, 36 + ((int[])a2.getValue())[2], 1, class_1713.field_7794, (class_1657)AutoArmor.mc.field_1724);
                EntityUtil.syncInventory();
                return;
            }
            if (AutoArmor.mc.field_1724.field_7498 == AutoArmor.mc.field_1724.field_7512) {
                int n3 = ((int[])a2.getValue())[0] - 34 + (39 - ((int[])a2.getValue())[0]) * 2;
                int n4 = ((int[])a2.getValue())[2] < 9 ? 36 + ((int[])a2.getValue())[2] : ((int[])a2.getValue())[2];
                AutoArmor.mc.field_1761.method_2906(AutoArmor.mc.field_1724.field_7512.field_7763, n4, 0, class_1713.field_7790, (class_1657)AutoArmor.mc.field_1724);
                AutoArmor.mc.field_1761.method_2906(AutoArmor.mc.field_1724.field_7512.field_7763, n3, 0, class_1713.field_7790, (class_1657)AutoArmor.mc.field_1724);
                if (((int[])a2.getValue())[1] != -1) {
                    AutoArmor.mc.field_1761.method_2906(AutoArmor.mc.field_1724.field_7512.field_7763, n4, 0, class_1713.field_7790, (class_1657)AutoArmor.mc.field_1724);
                }
                EntityUtil.syncInventory();
            }
            return;
        }
    }

    public AutoArmor() {
        AutoArmor a;
        AutoArmor autoArmor = a;
        AutoArmor autoArmor2 = a;
        super(BlockUpUtil.ALLATORIxDEMO("[WiJ[Jj\u001d?"), Module.Category.Combat);
        AutoArmor autoArmor3 = a;
        autoArmor3.noMove = autoArmor2.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("P]Q_wH"), false));
        autoArmor2.delay = autoArmor2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("^]k\u00134"), 3.0, 0.0, 10.0, 1.0));
        autoArmor2.autoElytra = autoArmor2.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("skuB[^eDsL"), true));
        autoArmor.tickDelay = 0;
        autoArmor.setChinese(BlockUpUtil.ALLATORIxDEMO("\u81d2\u52af\u7a0d\u757f"));
        INSTANCE = autoArmor;
    }

    private /* synthetic */ int getProtection(class_1799 class_17992) {
        AutoArmor a = class_17992;
        AutoArmor a2 = this;
        if (a.method_7909() instanceof class_1738 || a.method_7909() == class_1802.field_8833) {
            int n;
            int n2;
            int n3 = 0;
            if (a.method_7909() instanceof class_1770) {
                if (!class_1770.method_7804((class_1799)a)) {
                    return 0;
                }
                n3 = 1;
            }
            if (a.method_7942()) {
                for (Map.Entry entry : class_1890.method_8222((class_1799)a).entrySet()) {
                    if (!(entry.getKey() instanceof class_1900)) continue;
                    n3 += ((Integer)entry.getValue()).intValue();
                }
            }
            if (a.method_7909() instanceof class_1738) {
                n = ((class_1738)a.method_7909()).method_7687();
                n2 = n3;
            } else {
                n = 0;
                n2 = n3;
            }
            return n + n2;
        }
        if (!a.method_7960()) {
            return 0;
        }
        return -1;
    }
}
