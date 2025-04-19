/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1828
 *  net.minecraft.class_1844
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2596
 *  net.minecraft.class_2838
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.entity;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1738;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1828;
import net.minecraft.class_1844;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2596;
import net.minecraft.class_2838;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class InventoryUtil
implements Wrapper {
    static int lastSlot = -1;
    static int lastSelect = -1;

    public static int findItemInventorySlot(class_1792 a) {
        class_1792 class_17922 = a;
        int n = a = 0;
        while (n < 45) {
            if (InventoryUtil.mc.field_1724.method_31548().method_5438(a).method_7909() == class_17922) {
                if (a < 9) {
                    return a + 36;
                }
                return a;
            }
            n = ++a;
        }
        return -1;
    }

    public static int getItemCount(Class a2) {
        Class class_ = a2;
        int a2 = 0;
        for (Map.Entry<Integer, class_1799> entry : InventoryUtil.getInventoryAndHotbarSlots().entrySet()) {
            if (!(entry.getValue().method_7909() instanceof class_1747) || !class_.isInstance((Object)((class_1747)entry.getValue().method_7909()).method_7711())) continue;
            a2 += entry.getValue().method_7947();
        }
        return a2;
    }

    public static int findBlock() {
        int n;
        int n2 = n = 0;
        while (n2 < 9) {
            class_1799 class_17992 = InventoryUtil.getStackInSlot(n);
            if (class_17992.method_7909() instanceof class_1747 && !BlockUtil.shiftBlocks.contains((Object)class_2248.method_9503((class_1792)class_17992.method_7909())) && ((class_1747)class_17992.method_7909()).method_7711() != class_2246.field_10343) {
                return n;
            }
            n2 = ++n;
        }
        return -1;
    }

    public static int getItemCount(class_1792 a) {
        class_1792 class_17922 = a;
        int n = 0;
        a = InventoryUtil.getInventoryAndHotbarSlots().entrySet().iterator();
        Iterator<Map.Entry<Integer, Object>> iterator = a;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)a.next();
            if (((class_1799)entry.getValue()).method_7909() != class_17922) {
                iterator = a;
                continue;
            }
            n += ((class_1799)entry.getValue()).method_7947();
            iterator = a;
        }
        return n;
    }

    public static void switchToSlot(int a) {
        InventoryUtil.mc.field_1724.method_31548().field_7545 = a;
        mc.method_1562().method_52787((class_2596)new class_2868(a));
    }

    public static int findPotInventorySlot(class_1291 a) {
        int n;
        class_1291 class_12912 = a;
        int n2 = n = 0;
        while (n2 < 45) {
            a = InventoryUtil.mc.field_1724.method_31548().method_5438(n);
            if (a != class_1799.field_8037 && a.method_7909() instanceof class_1828) {
                a = new ArrayList(class_1844.method_8067((class_1799)a)).iterator();
                while (a.hasNext()) {
                    if (((class_1293)a.next()).method_5579() != class_12912) continue;
                    if (n < 9) {
                        return n + 36;
                    }
                    return n;
                }
            }
            n2 = ++n;
        }
        return -1;
    }

    public static boolean holdingItem(Class a2) {
        Class class_ = a2;
        class_1799 class_17992 = InventoryUtil.mc.field_1724.method_6047();
        boolean a2 = InventoryUtil.isInstanceOf(class_17992, class_);
        if (!a2) {
            a2 = InventoryUtil.isInstanceOf(class_17992, class_);
        }
        return a2;
    }

    public static int findPot(class_1291 a) {
        int n;
        class_1291 class_12912 = a;
        int n2 = n = 0;
        while (n2 < 9) {
            a = InventoryUtil.getStackInSlot(n);
            if (a != class_1799.field_8037 && a.method_7909() instanceof class_1828) {
                a = new ArrayList(class_1844.method_8067((class_1799)a)).iterator();
                while (a.hasNext()) {
                    if (((class_1293)a.next()).method_5579() != class_12912) continue;
                    return n;
                }
            }
            n2 = ++n;
        }
        return -1;
    }

    public static int findBlockInventorySlot(class_2248 a) {
        return InventoryUtil.findItemInventorySlot(class_1792.method_7867((class_2248)a));
    }

    public static int getClassCount(Class a) {
        Class class_ = a;
        int n = 0;
        Iterator<Map.Entry<Integer, class_1799>> iterator = InventoryUtil.getInventoryAndHotbarSlots().entrySet().iterator();
        block0 : do {
            Iterator<Map.Entry<Integer, class_1799>> iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = iterator.next();
                if (a.getValue() == class_1799.field_8037) {
                    iterator2 = iterator;
                    continue;
                }
                if (class_.isInstance((Object)((class_1799)a.getValue()).method_7909())) {
                    n += ((class_1799)a.getValue()).method_7947();
                }
                if (!(((class_1799)a.getValue()).method_7909() instanceof class_1747)) continue block0;
                if (!class_.isInstance((Object)((class_1747)((class_1799)a.getValue()).method_7909()).method_7711())) {
                    iterator2 = iterator;
                    continue;
                }
                n += ((class_1799)a.getValue()).method_7947();
                iterator2 = iterator;
            }
            break;
        } while (true);
        return n;
    }

    public static void doSwap(int a) {
        InventoryUtil.inventorySwap(a, InventoryUtil.mc.field_1724.method_31548().field_7545);
        InventoryUtil.switchToSlot(a);
    }

    public static int getArmorCount(class_1738.class_8051 a) {
        class_1738.class_8051 class_80512 = a;
        int n = 0;
        a = InventoryUtil.getInventoryAndHotbarSlots().entrySet().iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                Map.Entry entry = (Map.Entry)a.next();
                if (!(((class_1799)entry.getValue()).method_7909() instanceof class_1738)) continue block0;
                if (((class_1738)((class_1799)entry.getValue()).method_7909()).method_48398() != class_80512) {
                    object = a;
                    continue;
                }
                n += ((class_1799)entry.getValue()).method_7947();
                object = a;
            }
            break;
        } while (true);
        return n;
    }

    public static boolean isInstanceOf(class_1799 a, Class a2) {
        class_1799 class_17992 = a;
        if (class_17992 == null) {
            return false;
        }
        a = class_17992.method_7909();
        if (a2.isInstance((Object)a)) {
            return true;
        }
        if (a instanceof class_1747) {
            a = class_2248.method_9503((class_1792)a);
            return a2.isInstance((Object)a);
        }
        return false;
    }

    public InventoryUtil() {
        InventoryUtil a;
    }

    public static Map<Integer, class_1799> getInventoryAndHotbarSlots() {
        int n;
        HashMap<Integer, class_1799> hashMap = new HashMap<Integer, class_1799>();
        int n2 = n = 0;
        while (n2 <= 44) {
            hashMap.put(n, InventoryUtil.mc.field_1724.method_31548().method_5438(n++));
            n2 = n;
        }
        return hashMap;
    }

    public static int findClassInventorySlot(Class a) {
        Class class_ = a;
        int n = a = 0;
        while (n < 45) {
            class_1799 class_17992 = InventoryUtil.mc.field_1724.method_31548().method_5438(a);
            if (class_17992 != class_1799.field_8037) {
                if (class_.isInstance((Object)class_17992.method_7909())) {
                    if (a < 9) {
                        return a + 36;
                    }
                    return a;
                }
                if (class_17992.method_7909() instanceof class_1747 && class_.isInstance((Object)((class_1747)class_17992.method_7909()).method_7711())) {
                    if (a < 9) {
                        return a + 36;
                    }
                    return a;
                }
            }
            n = ++a;
        }
        return -1;
    }

    public static int getPotionCount(class_1291 a2) {
        int n;
        class_1291 class_12912 = a2;
        int a2 = 0;
        int n2 = n = 0;
        while (n2 < 45) {
            class_1799 class_17992 = InventoryUtil.mc.field_1724.method_31548().method_5438(n);
            if (class_1792.method_7880((class_1792)class_17992.method_7909()) == class_1792.method_7880((class_1792)class_1802.field_8436)) {
                Iterator iterator = class_1844.method_8067((class_1799)class_17992).iterator();
                while (iterator.hasNext()) {
                    if (((class_1293)iterator.next()).method_5579() != class_12912) continue;
                    a2 += class_17992.method_7947();
                }
            }
            n2 = ++n;
        }
        return a2;
    }

    public static int findUnBlock() {
        int n;
        int n2 = n = 0;
        while (n2 < 9) {
            if (!(InventoryUtil.getStackInSlot(n).method_7909() instanceof class_1747)) {
                return n;
            }
            n2 = ++n;
        }
        return -1;
    }

    public static int findItem(class_1792 a) {
        class_1792 class_17922 = a;
        int n = a = 0;
        while (n < 9) {
            if (class_1792.method_7880((class_1792)InventoryUtil.getStackInSlot(a).method_7909()) == class_1792.method_7880((class_1792)class_17922)) {
                return a;
            }
            n = ++a;
        }
        return -1;
    }

    public static void inventorySwap(int n, int n2) {
        int a = n2;
        int a2 = n;
        if (a2 == lastSlot) {
            InventoryUtil.switchToSlot(lastSelect);
            lastSlot = -1;
            lastSelect = -1;
            return;
        }
        if (a2 - 36 == a) {
            return;
        }
        if (CombatSetting.INSTANCE.invSwapBypass.getValue()) {
            if (a2 - 36 >= 0) {
                lastSlot = a2;
                lastSelect = a;
                InventoryUtil.switchToSlot(a2 - 36);
                return;
            }
            mc.method_1562().method_52787((class_2596)new class_2838(a2));
            return;
        }
        InventoryUtil.mc.field_1761.method_2906(InventoryUtil.mc.field_1724.field_7512.field_7763, a2, a, class_1713.field_7791, (class_1657)InventoryUtil.mc.field_1724);
    }

    public static Map<Integer, class_1799> getNoArmorInventoryAndHotbarSlots() {
        int n;
        HashMap<Integer, class_1799> hashMap = new HashMap<Integer, class_1799>();
        int n2 = n = 0;
        while (n2 <= 35) {
            hashMap.put(n, InventoryUtil.mc.field_1724.method_31548().method_5438(n++));
            n2 = n;
        }
        return hashMap;
    }

    public static int getPotCount(class_1291 a) {
        class_1291 class_12912 = a;
        int n = 0;
        a = InventoryUtil.getInventoryAndHotbarSlots().entrySet().iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                Map.Entry entry = (Map.Entry)a.next();
                if (!(((class_1799)entry.getValue()).method_7909() instanceof class_1828)) {
                    object = a;
                    continue;
                }
                Iterator iterator = new ArrayList(class_1844.method_8067((class_1799)((class_1799)entry.getValue()))).iterator();
                do {
                    if (!iterator.hasNext()) continue block0;
                } while (((class_1293)iterator.next()).method_5579() != class_12912);
                n += ((class_1799)entry.getValue()).method_7947();
                continue block0;
            }
            break;
        } while (true);
        return n;
    }

    public static int findClass(Class a) {
        Class class_ = a;
        int n = a = 0;
        while (n < 9) {
            class_1799 class_17992 = InventoryUtil.getStackInSlot(a);
            if (class_17992 != class_1799.field_8037) {
                if (class_.isInstance((Object)class_17992.method_7909())) {
                    return a;
                }
                if (class_17992.method_7909() instanceof class_1747 && class_.isInstance((Object)((class_1747)class_17992.method_7909()).method_7711())) {
                    return a;
                }
            }
            n = ++a;
        }
        return -1;
    }

    public static boolean CheckArmorType(class_1792 class_17922, class_1738.class_8051 class_80512) {
        class_1792 a = class_80512;
        class_1792 a2 = class_17922;
        return a2 instanceof class_1738 && ((class_1738)a2).method_48398() == a;
    }

    public static class_1799 getStackInSlot(int a) {
        return InventoryUtil.mc.field_1724.method_31548().method_5438(a);
    }

    public static int findBlock(class_2248 a) {
        class_2248 class_22482 = a;
        int n = a = 0;
        while (n < 9) {
            class_1799 class_17992 = InventoryUtil.getStackInSlot(a);
            if (class_17992 != class_1799.field_8037 && class_17992.method_7909() instanceof class_1747 && ((class_1747)class_17992.method_7909()).method_7711() == class_22482) {
                return a;
            }
            n = ++a;
        }
        return -1;
    }

    public static int getEmptySlotCount() {
        Iterator<Map.Entry<Integer, class_1799>> iterator;
        int n = 0;
        Iterator<Map.Entry<Integer, class_1799>> iterator2 = iterator = InventoryUtil.getNoArmorInventoryAndHotbarSlots().entrySet().iterator();
        while (iterator2.hasNext()) {
            if (iterator.next().getValue() != class_1799.field_8037) {
                iterator2 = iterator;
                continue;
            }
            ++n;
            iterator2 = iterator;
        }
        return n;
    }
}
