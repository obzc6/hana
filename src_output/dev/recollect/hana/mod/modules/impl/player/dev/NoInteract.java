/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2336
 *  net.minecraft.class_2338
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2336;
import net.minecraft.class_2338;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class NoInteract
extends Module {
    public NoInteract() {
        super(ObsidianHelper.ALLATORIxDEMO(" M\nP6Z6w;Y#]%['"), Module.Category.Player);
        NoInteract a;
    }

    @EventHandler
    public void onPacket(PacketEvent.Send a) {
        NoInteract a2;
        NoInteract noInteract = a2;
        if (NoInteract.nullCheck() || !((a2 = a.getPacket()) instanceof class_2885)) {
            return;
        }
        class_2885 class_28852 = (class_2885)a2;
        a2 = NoInteract.mc.field_1687.method_8320(class_28852.method_12543().method_17777()).method_26204();
        if (!NoInteract.mc.field_1724.method_5715() && (a2 instanceof class_2281 || a2 instanceof class_2336)) {
            a.cancel();
        }
    }
}
