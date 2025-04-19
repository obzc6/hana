/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_634
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.SendMessageEvent;
import dev.recollect.hana.api.managers.CommandManager;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_634.class})
public abstract class MixinClientPlayNetworkHandler {
    @Unique
    private boolean nullpoint_ignoreChatMessage;

    @Shadow
    public abstract void method_45729(String var1);

    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendChatMessage(String message, CallbackInfo ci) {
        if (this.nullpoint_ignoreChatMessage) {
            return;
        }
        if (message.startsWith(Hana.PREFIX)) {
            Hana.COMMAND.command(message.split(" "));
            ci.cancel();
        } else {
            SendMessageEvent event = new SendMessageEvent(message);
            Hana.EVENT_BUS.post(event);
            if (event.isCancelled()) {
                ci.cancel();
            } else if (!event.message.equals(event.defaultMessage)) {
                this.nullpoint_ignoreChatMessage = true;
                this.method_45729(event.message);
                this.nullpoint_ignoreChatMessage = false;
                ci.cancel();
            }
        }
    }
}
