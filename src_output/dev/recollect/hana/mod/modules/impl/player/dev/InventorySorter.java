/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1723
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1723;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class InventorySorter
extends Module {
    private final BooleanSetting stack;
    private final BooleanSetting sort;
    private final Timer timer;
    private final SliderSetting delay;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean canMerge(class_1799 class_17992, class_1799 class_17993) {
        void a;
        InventorySorter a2 = class_17993;
        InventorySorter a3 = this;
        return a.method_7909() == a2.method_7909() && a.method_7964().equals((Object)a2.method_7964());
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ int getMinId(int n, int n2) {
        void a;
        int a2 = n2;
        InventorySorter a3 = this;
        void v0 = a = a + true;
        while (v0 < 36) {
            int n3;
            class_1799 class_17992 = InventorySorter.mc.field_1724.method_31548().method_5438((int)a);
            if (!class_17992.method_7960() && (n3 = class_1792.method_7880((class_1792)class_17992.method_7909())) < a2) {
                a2 = n3;
            }
            v0 = ++a;
        }
        return a2;
    }

    public InventorySorter() {
        InventorySorter a;
        InventorySorter inventorySorter = a;
        super(RadiusUtils.ALLATORIxDEMO("%A\r\u0004[@\u000fA\u001eg\u000f[\t\u0006E"), Module.Category.Player);
        InventorySorter inventorySorter2 = a;
        inventorySorter2.stack = inventorySorter.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("\u0000\u0013#\u0013>"), true));
        inventorySorter.sort = inventorySorter.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("z\u0012\u0011C"), true));
        inventorySorter.delay = inventorySorter.add(new SliderSetting(UserInfo.ALLATORIxDEMO("\u0017\u0002.\u0011,"), 0.1, 0.0, 5.0, 0.01).setSuffix(RadiusUtils.ALLATORIxDEMO("D")));
        inventorySorter.timer = new Timer();
    }

    @Override
    public void onUpdate() {
        Object object;
        InventorySorter inventorySorter;
        int n;
        InventorySorter a;
        InventorySorter inventorySorter2 = inventorySorter = a;
        if (!inventorySorter2.timer.passedS(inventorySorter2.delay.getValue())) {
            return;
        }
        if (!(InventorySorter.mc.field_1755 == null || InventorySorter.mc.field_1755 instanceof class_408 || InventorySorter.mc.field_1755 instanceof class_490 || InventorySorter.mc.field_1755 instanceof ClickGuiScreen || InventorySorter.mc.field_1755 instanceof class_433)) {
            return;
        }
        if (inventorySorter.stack.getValue()) {
            int n2 = a = 9;
            while (n2 < 36) {
                class_1799 class_17992 = InventorySorter.mc.field_1724.method_31548().method_5438(a);
                if (!class_17992.method_7960() && class_17992.method_7946() && class_17992.method_7947() != class_17992.method_7914()) {
                    int n3 = n = 35;
                    while (n3 >= 9) {
                        if (a != n) {
                            class_1799 class_17993 = InventorySorter.mc.field_1724.method_31548().method_5438(n);
                            object = (Object)class_17993;
                            if (class_17993.method_7947() != object.method_7914() && inventorySorter.canMerge(class_17992, (class_1799)object)) {
                                InventorySorter.mc.field_1761.method_2906(InventorySorter.mc.field_1724.field_7498.field_7763, a, 0, class_1713.field_7790, (class_1657)InventorySorter.mc.field_1724);
                                InventorySorter.mc.field_1761.method_2906(InventorySorter.mc.field_1724.field_7498.field_7763, n, 0, class_1713.field_7790, (class_1657)InventorySorter.mc.field_1724);
                                InventorySorter.mc.field_1761.method_2906(InventorySorter.mc.field_1724.field_7498.field_7763, a, 0, class_1713.field_7790, (class_1657)InventorySorter.mc.field_1724);
                                inventorySorter.timer.reset();
                                return;
                            }
                        }
                        n3 = --n;
                    }
                }
                n2 = ++a;
            }
        }
        if (inventorySorter.sort.getValue()) {
            int n4 = a = 9;
            while (n4 < 36) {
                int n5 = class_1792.method_7880((class_1792)InventorySorter.mc.field_1724.method_31548().method_5438(a).method_7909());
                if (InventorySorter.mc.field_1724.method_31548().method_5438(a).method_7960()) {
                    n5 = 114514;
                }
                if ((n = inventorySorter.getMinId(a, n5)) < n5) {
                    int n6 = object = 35;
                    while (n6 > a) {
                        class_1799 class_17994 = InventorySorter.mc.field_1724.method_31548().method_5438(object);
                        if (!class_17994.method_7960() && class_1792.method_7880((class_1792)class_17994.method_7909()) == n) {
                            InventorySorter.mc.field_1761.method_2906(InventorySorter.mc.field_1724.field_7498.field_7763, a, 0, class_1713.field_7790, (class_1657)InventorySorter.mc.field_1724);
                            InventorySorter.mc.field_1761.method_2906(InventorySorter.mc.field_1724.field_7498.field_7763, object, 0, class_1713.field_7790, (class_1657)InventorySorter.mc.field_1724);
                            InventorySorter.mc.field_1761.method_2906(InventorySorter.mc.field_1724.field_7498.field_7763, a, 0, class_1713.field_7790, (class_1657)InventorySorter.mc.field_1724);
                            inventorySorter.timer.reset();
                            return;
                        }
                        n6 = --object;
                    }
                }
                n4 = ++a;
            }
        }
    }
}
