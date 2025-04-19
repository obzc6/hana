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
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.UserInfo;
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

public class AutoPearl
extends Module {
    boolean shouldThrow;
    public static boolean throwing = false;
    public static AutoPearl INSTANCE;
    private final BooleanSetting inventory;

    @Override
    public void onEnable() {
        AutoPearl a;
        if (AutoPearl.nullCheck()) {
            a.disable();
            return;
        }
        if (a.getBind().isHoldEnable()) {
            a.shouldThrow = true;
            return;
        }
        AutoPearl autoPearl = a;
        autoPearl.throwPearl(AutoPearl.mc.field_1724.method_36454(), AutoPearl.mc.field_1724.method_36455());
        autoPearl.disable();
    }

    @Override
    public void onDisable() {
        AutoPearl a;
        if (AutoPearl.nullCheck()) {
            return;
        }
        if (a.shouldThrow && a.getBind().isHoldEnable()) {
            a.shouldThrow = false;
            a.throwPearl(AutoPearl.mc.field_1724.method_36454(), AutoPearl.mc.field_1724.method_36455());
        }
    }

    public AutoPearl() {
        AutoPearl a;
        AutoPearl autoPearl = a;
        AutoPearl autoPearl2 = a;
        super(SocketClient.ALLATORIxDEMO("z^z@ZYxPk"), Module.Category.Misc);
        AutoPearl autoPearl3 = a;
        autoPearl3.inventory = autoPearl2.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("\u001a\u0003>7\u0019\u0013-\u0011?#\"\u000f;"), true));
        autoPearl.shouldThrow = false;
        autoPearl.setChinese(SocketClient.ALLATORIxDEMO("\u81d6\u52b1\u73ef\u73e7"));
        INSTANCE = autoPearl;
    }

    public void throwPearl(float a, float a2) {
        AutoPearl a32;
        AutoPearl autoPearl = a32;
        throwing = true;
        if (AutoPearl.mc.field_1724.method_6047().method_7909() == class_1802.field_8634) {
            EntityUtil.sendLook((class_2828)new class_2828.class_2831(a, a2, AutoPearl.mc.field_1724.method_24828()));
            AutoPearl.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
        } else if (autoPearl.inventory.getValue() && (a32 = InventoryUtil.findItemInventorySlot(class_1802.field_8634)) != -1) {
            InventoryUtil.inventorySwap(a32, AutoPearl.mc.field_1724.method_31548().field_7545);
            EntityUtil.sendLook((class_2828)new class_2828.class_2831(a, a2, AutoPearl.mc.field_1724.method_24828()));
            AutoPearl.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
            InventoryUtil.inventorySwap(a32, AutoPearl.mc.field_1724.method_31548().field_7545);
            EntityUtil.syncInventory();
        } else {
            int a32 = InventoryUtil.findItem(class_1802.field_8634);
            if (a32 != -1) {
                int n = AutoPearl.mc.field_1724.method_31548().field_7545;
                InventoryUtil.switchToSlot(a32);
                EntityUtil.sendLook((class_2828)new class_2828.class_2831(a, a2, AutoPearl.mc.field_1724.method_24828()));
                AutoPearl.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
                InventoryUtil.switchToSlot(n);
            }
        }
        throwing = false;
    }
}
