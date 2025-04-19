/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_434
 *  net.minecraft.class_437
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.exploit.dev.PortalGod;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import net.minecraft.class_310;
import net.minecraft.class_434;
import net.minecraft.class_437;

public class NoTerrainScreen
extends Module {
    public NoTerrainScreen() {
        NoTerrainScreen a;
        NoTerrainScreen noTerrainScreen = a;
        super(CameraState.ALLATORIxDEMO("w=j\nq-R'L\nV+P7P"), Module.Category.Player);
        noTerrainScreen.setChinese(GameInfo.ALLATORIxDEMO("\u6cb9\u6709\u52b8\u8f7d\u9866\u9769"));
    }

    @EventHandler
    public void onUpdate(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        NoTerrainScreen a2 = this;
        if (PortalGod.INSTANCE.isOn()) {
            return;
        }
        if (NoTerrainScreen.mc.field_1755 instanceof class_434) {
            NoTerrainScreen.mc.field_1755 = null;
        }
    }
}
