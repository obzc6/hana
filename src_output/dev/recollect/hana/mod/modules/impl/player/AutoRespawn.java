/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_418
 *  net.minecraft.class_437
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.user.User;
import net.minecraft.class_310;
import net.minecraft.class_418;
import net.minecraft.class_437;
import net.minecraft.class_746;

public class AutoRespawn
extends Module {
    public AutoRespawn() {
        AutoRespawn a;
        AutoRespawn autoRespawn = a;
        super(Animation.ALLATORIxDEMO("\\E\\ZGjDnZx"), Module.Category.Player);
        autoRespawn.setDescription(User.ALLATORIxDEMO("~VWPCSBCIWQM\u0018]|wIVZPNO=vBSR\u0000FL[\u0012\\MD\u0013"));
        autoRespawn.setChinese(Animation.ALLATORIxDEMO("\u81de\u52a7\u91e0\u7509"));
    }

    @Override
    public void onUpdate() {
        if (AutoRespawn.mc.field_1755 instanceof class_418) {
            AutoRespawn.mc.field_1724.method_7331();
            mc.method_1507(null);
        }
    }
}
