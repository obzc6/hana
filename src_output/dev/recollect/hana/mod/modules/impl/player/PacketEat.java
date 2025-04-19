/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import net.minecraft.class_1268;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2846;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class PacketEat
extends Module {
    private final BooleanSetting sync;
    public static PacketEat INSTANCE;

    @EventHandler
    public void onPacket(PacketEvent.Send a) {
        PacketEat a2;
        PacketEat packetEat = a2;
        a2 = a.getPacket();
        if (a2 instanceof class_2846 && ((class_2846)a2).method_12363() == class_2846.class_2847.field_12974 && PacketEat.mc.field_1724.method_6030().method_7909().method_19263()) {
            a.cancel();
        }
    }

    public PacketEat() {
        PacketEat a;
        PacketEat packetEat = a;
        super(Setting.ALLATORIxDEMO("\b}<p=r\u0000-{"), Module.Category.Player);
        packetEat.sync = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("O}gr"), false));
        packetEat.setChinese(Setting.ALLATORIxDEMO("\u5394\u5349\u540c"));
        INSTANCE = packetEat;
    }

    @Override
    public void onUpdate() {
        PacketEat a;
        if (PacketEat.nullCheck()) {
            return;
        }
        if (a.sync.getValue() && PacketEat.mc.field_1724.method_6115() && PacketEat.mc.field_1724.method_6030().method_7909().method_19263()) {
            PacketEat.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, BlockUtil.getWorldActionId(PacketEat.mc.field_1687)));
        }
    }
}
