/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.asm.accessors.ILivingEntity;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class NoJumpDelay
extends Module {
    public static NoJumpDelay INSTANCE;
    private final SliderSetting delay;

    public NoJumpDelay() {
        NoJumpDelay a;
        NoJumpDelay noJumpDelay = a;
        super(NpSocketClient.ALLATORIxDEMO("\u0016C&x t\u0000l%p("), Module.Category.Movement);
        NoJumpDelay noJumpDelay2 = a;
        noJumpDelay.delay = noJumpDelay.add(new SliderSetting(FrameFilter.ALLATORIxDEMO("[&~:s"), 1, 0, 4));
        noJumpDelay.setChinese(NpSocketClient.ALLATORIxDEMO("\u6ca5\u674d\u8dfa\u8d8a\u5ee7\u8f8e"));
    }

    @Override
    public void onEnable() {
        TipUtils.lol();
    }

    @Override
    public void onUpdate() {
        NoJumpDelay a;
        if ((double)((ILivingEntity)NoJumpDelay.mc.field_1724).getLastJumpCooldown() > a.delay.getValue()) {
            ((ILivingEntity)NoJumpDelay.mc.field_1724).setLastJumpCooldown((int)a.delay.getValue());
        }
    }
}
