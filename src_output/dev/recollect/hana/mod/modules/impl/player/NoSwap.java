/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_2596
 *  net.minecraft.class_2735
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.asm.accessors.IUpdateSelectedSlotS2CPacket;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_1661;
import net.minecraft.class_2596;
import net.minecraft.class_2735;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class NoSwap
extends Module {
    public static NoSwap INSTANCE;

    public NoSwap() {
        NoSwap a;
        NoSwap noSwap = a;
        super(Alt.ALLATORIxDEMO("N5E;f-"), Module.Category.Player);
        noSwap.setChinese(Snow.ALLATORIxDEMO("\u65db\u5f2e\u5229\u5205\u636b\u727a\u54d9"));
        INSTANCE = noSwap;
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive a) {
        NoSwap a22;
        NoSwap noSwap = a22;
        if (NoSwap.nullCheck()) {
            return;
        }
        a22 = a.getPacket();
        if (a22 instanceof class_2735) {
            a = (class_2735)a22;
            int a22 = NoSwap.mc.field_1724.method_31548().field_7545;
            if (a.method_11803() != a22) {
                ((IUpdateSelectedSlotS2CPacket)((Object)a)).setslot(a22);
                InventoryUtil.switchToSlot(a22);
                EntityUtil.syncInventory();
            }
        }
    }
}
