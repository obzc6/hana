/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.asm.mixins.PlayerPositionLookS2CPacketAccessor;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import net.minecraft.class_1657;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class BRotateBypass
extends Module {
    final BooleanSetting burrowbypass;

    public BRotateBypass() {
        BRotateBypass a;
        BRotateBypass bRotateBypass = a;
        super(SocketClient.ALLATORIxDEMO("L^FCsJ~msMyNk"), Module.Category.Player);
        BRotateBypass bRotateBypass2 = a;
        bRotateBypass2.burrowbypass = bRotateBypass.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("gOLsXD`DjGx"), true));
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        BRotateBypass a2 = this;
        if (a.packet instanceof class_2708) {
            if (BRotateBypass.mc.field_1724 != null && a2.burrowbypass.getValue()) {
                if (BOEntityUtils.isBlockLag((class_1657)BRotateBypass.mc.field_1724)) {
                    return;
                }
            }
            if (BRotateBypass.mc.field_1724 != null) {
                ((PlayerPositionLookS2CPacketAccessor)a.packet).setPitch(BRotateBypass.mc.field_1724.method_36455());
            }
            if (BRotateBypass.mc.field_1724 != null) {
                ((PlayerPositionLookS2CPacketAccessor)a.packet).setYaw(BRotateBypass.mc.field_1724.method_36454());
            }
        }
    }
}
