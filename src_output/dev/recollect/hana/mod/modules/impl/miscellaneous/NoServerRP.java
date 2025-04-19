/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2720
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import java.util.UUID;
import net.minecraft.class_2596;
import net.minecraft.class_2720;
import net.minecraft.class_2856;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class NoServerRP
extends Module {
    @EventHandler
    public void onPacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        NoServerRP a2 = this;
        if (a.getPacket() instanceof class_2720) {
            NoServerRP.mc.field_1724.field_3944.method_52787((class_2596)new class_2856(NoServerRP.mc.field_1724.method_5667(), class_2856.class_2857.field_13016));
            a.cancel();
        }
    }

    public NoServerRP() {
        NoServerRP a;
        NoServerRP noServerRP = a;
        super(WebUtils.ALLATORIxDEMO("\u001du\u0007x!l+uV\u001d"), Module.Category.Misc);
        noServerRP.setChinese(FadeUtils.ALLATORIxDEMO("\u6c9b\u6765\u6730\u52d0\u5648i:"));
    }
}
