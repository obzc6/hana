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
 *  net.minecraft.class_312
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import net.minecraft.class_1268;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class MCP
extends Module {
    private final BooleanSetting inventory;
    boolean click;
    public static MCP INSTANCE;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        block5 : {
            block4 : {
                var1_2 = a;
                if (MCP.nullCheck()) {
                    return;
                }
                if (!MCP.mc.field_1729.method_35707()) {
                    var1_2.click = false;
                    return;
                }
                if (var1_2.click != false) return;
                if (MCP.mc.field_1724.method_6047().method_7909() != class_1802.field_8634) break block4;
                EntityUtil.sendLook((class_2828)new class_2828.class_2831(MCP.mc.field_1724.method_36454(), MCP.mc.field_1724.method_36455(), MCP.mc.field_1724.method_24828()));
                MCP.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
                v0 = var1_2;
                break block5;
            }
            a = var1_2.findItem(class_1802.field_8634);
            if (a == -1) ** GOTO lbl28
            var2_3 = MCP.mc.field_1724.method_31548().field_7545;
            v1 = var1_2;
            v1.doSwap(a);
            EntityUtil.sendLook((class_2828)new class_2828.class_2831(MCP.mc.field_1724.method_36454(), MCP.mc.field_1724.method_36455(), MCP.mc.field_1724.method_24828()));
            MCP.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, 0));
            v2 = var1_2;
            if (v1.inventory.getValue()) {
                v2.doSwap(a);
                EntityUtil.syncInventory();
                v0 = var1_2;
            } else {
                v2.doSwap(var2_3);
lbl28: // 2 sources:
                v0 = var1_2;
            }
        }
        v0.click = true;
    }

    public MCP() {
        MCP a;
        MCP mCP = a;
        MCP mCP2 = a;
        super(SocketClient.ALLATORIxDEMO("e]k"), Module.Category.Misc);
        MCP mCP3 = a;
        mCP3.inventory = mCP2.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u0013z6w(;t^\u0001q\u0001P\u0015"), true));
        mCP.click = false;
        mCP.setChinese(SocketClient.ALLATORIxDEMO("\u4e20\u9506\u73d3\u73db"));
        INSTANCE = mCP;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        MCP a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, MCP.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public int findItem(class_1792 class_17922) {
        MCP a = class_17922;
        MCP a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findItemInventorySlot((class_1792)a);
        }
        return InventoryUtil.findItem((class_1792)a);
    }
}
