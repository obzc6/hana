/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_490;

public class XCarry
extends Module {
    class_437 lastScreen = null;

    @Override
    public void onUpdate() {
        if (!(XCarry.mc.field_1755 == null || XCarry.mc.field_1755 instanceof class_433 || XCarry.mc.field_1755 instanceof class_408 || XCarry.mc.field_1755 instanceof ClickGuiScreen)) {
            a.lastScreen = XCarry.mc.field_1755;
        }
    }

    @EventHandler
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        XCarry a2 = this;
        if (a2.lastScreen instanceof class_490 && a.getPacket() instanceof class_2815) {
            a.cancel();
        }
    }

    public XCarry() {
        super(GameInfo.ALLATORIxDEMO("WTneve"), Module.Category.Player);
        XCarry a;
        a.setChinese(Snow.ALLATORIxDEMO("\u545c\u6203\u6848\u4fce\u751e\u7271\u548d"));
    }
}
