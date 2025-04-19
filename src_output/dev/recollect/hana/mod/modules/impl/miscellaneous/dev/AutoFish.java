/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_2596
 *  net.minecraft.class_2767
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_634
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.packet.Packet;
import net.minecraft.class_1268;
import net.minecraft.class_2596;
import net.minecraft.class_2767;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_634;
import net.minecraft.class_6880;
import net.minecraft.class_746;

public class AutoFish
extends Module {
    private /* synthetic */ void recastRod() {
        AutoFish a;
        AutoFish autoFish = a;
        a = new class_2886(class_1268.field_5808, 0);
        AutoFish.mc.field_1724.field_3944.method_52787((class_2596)a);
        AutoFish.mc.field_1724.field_3944.method_52787((class_2596)a);
    }

    public AutoFish() {
        AutoFish a;
        AutoFish autoFish = a;
        super(Packet.ALLATORIxDEMO("}ng[OGa]"), Module.Category.Misc);
        autoFish.setDescription(HoleUtils.ALLATORIxDEMO("LA\u0006;BhK~Pb\u0005/&_[~[i[7gQ\\1MdZ>"));
        autoFish.setChinese(Packet.ALLATORIxDEMO("\u81e3\u5286\u9481\u9c49"));
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        Object a = receive;
        AutoFish a2 = this;
        if ((a = ((PacketEvent)a).getPacket()) instanceof class_2767 && ((class_3414)((class_2767)a).method_11894().comp_349()).equals((Object)class_3417.field_14660)) {
            a2.recastRod();
        }
    }
}
