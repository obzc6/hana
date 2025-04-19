/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.JumpEvent;
import dev.recollect.hana.api.events.impl.MotionEvent;
import dev.recollect.hana.api.events.impl.PlayerMoveEvent;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.video.Renderer;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class StrafeFix
extends Module {
    private float yaw;
    private float pitch;
    boolean shouldMoveFix;

    /*
     * WARNING - void declaration
     */
    public void setRotation(float f, float f2) {
        StrafeFix a;
        void a2;
        float a3 = f2;
        StrafeFix strafeFix = a = this;
        a.yaw = a2;
        strafeFix.pitch = a3;
        strafeFix.shouldMoveFix = true;
    }

    @EventHandler
    public void onPlayerJump(JumpEvent jumpEvent) {
        JumpEvent a = jumpEvent;
        StrafeFix a2 = this;
        if (StrafeFix.mc.field_1724 != null && a2.shouldMoveFix) {
            a.setYaw(a2.yaw);
        }
    }

    public StrafeFix() {
        StrafeFix a;
        StrafeFix strafeFix = a;
        super(Renderer.ALLATORIxDEMO("3n\u0015|\u0006e;#O"), Module.Category.Movement);
        strafeFix.setChinese(Setting.ALLATORIxDEMO("\u4ff5\u5955\u7073\u6d7e\u52e4\u4f53"));
    }

    @EventHandler
    public void onStrafe(PlayerMoveEvent playerMoveEvent) {
        PlayerMoveEvent a = playerMoveEvent;
        StrafeFix a2 = this;
        if (StrafeFix.mc.field_1724 != null && a2.shouldMoveFix) {
            a.setYaw(a2.yaw);
        }
    }

    @EventHandler
    public void onMotionUpdate(MotionEvent motionEvent) {
        MotionEvent a = motionEvent;
        StrafeFix a2 = this;
        if (StrafeFix.mc.field_1724 != null && a2.shouldMoveFix) {
            a.setYaw(a2.yaw);
            a.setPitch(a2.pitch);
            a2.shouldMoveFix = false;
        }
    }
}
