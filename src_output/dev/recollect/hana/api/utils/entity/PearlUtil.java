/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.entity;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import net.minecraft.class_1268;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class PearlUtil
implements Wrapper {
    private static /* synthetic */ void doSwap(int n, boolean bl) {
        int a = bl ? 1 : 0;
        int a2 = n;
        if (a != 0) {
            InventoryUtil.inventorySwap(a2, PearlUtil.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a2);
    }

    public static void doPearl(float f, float f2, boolean bl) {
        boolean a = bl;
        float a2 = f;
        if (PearlUtil.mc.field_1724.method_6047().method_7909() == class_1802.field_8634) {
            EntityUtil.sendLook((class_2828)new class_2828.class_2831(PearlUtil.mc.field_1724.method_36454(), PearlUtil.mc.field_1724.method_36455(), PearlUtil.mc.field_1724.method_24828()));
            PearlUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
            return;
        }
        int a3 = PearlUtil.findItem(class_1802.field_8634, a);
        if (a3 != -1) {
            int n = PearlUtil.mc.field_1724.method_31548().field_7545;
            PearlUtil.doSwap(a3, a);
            EntityUtil.sendLook((class_2828)new class_2828.class_2831(PearlUtil.mc.field_1724.method_36454(), PearlUtil.mc.field_1724.method_36455(), PearlUtil.mc.field_1724.method_24828()));
            PearlUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
            if (a) {
                PearlUtil.doSwap(a3, true);
                EntityUtil.syncInventory();
                return;
            }
            PearlUtil.doSwap(n, false);
        }
    }

    public PearlUtil() {
        PearlUtil a;
    }

    public static int findItem(class_1792 class_17922, boolean bl) {
        boolean a = bl;
        class_1792 a2 = class_17922;
        if (a) {
            return InventoryUtil.findItemInventorySlot(a2);
        }
        return InventoryUtil.findItem(a2);
    }
}
