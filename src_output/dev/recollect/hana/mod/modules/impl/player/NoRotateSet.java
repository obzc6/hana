/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.asm.accessors.IPlayerPositionLookS2CPacket;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class NoRotateSet
extends Module {
    public static NoRotateSet INSTANCE;

    public NoRotateSet() {
        NoRotateSet a;
        NoRotateSet noRotateSet = a;
        super(Alt.ALLATORIxDEMO("\u0002l\u000b}<E\nw\u001bf-"), Module.Category.Player);
        noRotateSet.setChinese(CrystalUtil.ALLATORIxDEMO("\u6587\u5f1b\u5267\u8f5c\u5974"));
        INSTANCE = noRotateSet;
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive a) {
        NoRotateSet a22;
        NoRotateSet noRotateSet = a22;
        if (NoRotateSet.nullCheck()) {
            return;
        }
        a22 = a.getPacket();
        if (a22 instanceof class_2708) {
            a = (class_2708)a22;
            float a22 = NoRotateSet.mc.field_1724.method_36454();
            float f = NoRotateSet.mc.field_1724.method_36455();
            ((IPlayerPositionLookS2CPacket)((Object)a)).setYaw(a22);
            ((IPlayerPositionLookS2CPacket)((Object)a)).setPitch(f);
        }
    }
}
