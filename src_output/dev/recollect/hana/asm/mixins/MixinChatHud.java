/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_303
 *  net.minecraft.class_303$class_7590
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_338
 *  net.minecraft.class_4587
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 *  net.minecraft.class_7469
 *  net.minecraft.class_7591
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.ReceiveMessageEvent;
import dev.recollect.hana.api.interfaces.IChatHud;
import dev.recollect.hana.api.interfaces.IChatHudLine;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_2561;
import net.minecraft.class_303;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_338;
import net.minecraft.class_4587;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import net.minecraft.class_7469;
import net.minecraft.class_7591;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_338.class})
public abstract class MixinChatHud
implements IChatHud {
    @Shadow
    @Final
    private List<class_303.class_7590> field_2064;
    @Shadow
    @Final
    private List<class_303> field_2061;
    @Unique
    private int nullpoint_nextId = 0;
    @Unique
    private final HashMap<class_303.class_7590, FadeUtils> map = new HashMap();
    @Unique
    private class_303.class_7590 last;

    @Shadow
    public abstract void method_1812(class_2561 var1);

    @Override
    public void nullpoint_nextgen_master$add(class_2561 message, int id) {
        this.nullpoint_nextId = id;
        this.method_1812(message);
        this.nullpoint_nextId = 0;
    }

    @Inject(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V"}, at={@At(value="INVOKE", target="Ljava/util/List;add(ILjava/lang/Object;)V", ordinal=0, shift=At.Shift.AFTER)})
    private void onAddMessageAfterNewChatHudLineVisible(class_2561 message, class_7469 signature, int ticks, class_7591 indicator, boolean refresh, CallbackInfo info) {
        ((IChatHudLine)this.field_2064.get(0)).nullpoint_nextgen_master$setId(this.nullpoint_nextId);
    }

    @Inject(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V"}, at={@At(value="INVOKE", target="Ljava/util/List;add(ILjava/lang/Object;)V", ordinal=1, shift=At.Shift.AFTER)})
    private void onAddMessageAfterNewChatHudLine(class_2561 message, class_7469 signature, int ticks, class_7591 indicator, boolean refresh, CallbackInfo info) {
        ((IChatHudLine)this.field_2061.get(0)).nullpoint_nextgen_master$setId(this.nullpoint_nextId);
    }

    @Inject(at={@At(value="HEAD")}, method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V"})
    private void onAddMessage(class_2561 message, @Nullable class_7469 signature, int ticks, @Nullable class_7591 indicator, boolean refresh, CallbackInfo info) {
        if (this.nullpoint_nextId != 0) {
            this.field_2064.removeIf(msg -> msg == null || ((IChatHudLine)msg).nullpoint_nextgen_master$getId() == this.nullpoint_nextId);
            this.field_2061.removeIf(msg -> msg == null || ((IChatHudLine)msg).nullpoint_nextgen_master$getId() == this.nullpoint_nextId);
        }
    }

    @Redirect(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V"}, at=@At(value="INVOKE", target="Ljava/util/List;size()I", ordinal=2, remap=false))
    public int chatLinesSize(List<class_303.class_7590> list) {
        return ChatSetting.INSTANCE.isOn() && ChatSetting.INSTANCE.infiniteChat.getValue() ? -2147483647 : list.size();
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I"))
    private int drawStringWithShadow(class_332 drawContext, class_327 textRenderer, class_5481 text, int x, int y, int color) {
        if (ChatSetting.chatMessage.containsKey((Object)text) && ChatSetting.chatMessage.get((Object)text).getString().startsWith("\u00a7(")) {
            if (ChatSetting.INSTANCE.pulse.booleanValue) {
                return TextUtil.drawStringPulse(drawContext, text, x, y, ColorUtil.injectAlpha(ChatSetting.INSTANCE.color.getValue(), color >> 24 & 255), ColorUtil.injectAlpha(ChatSetting.INSTANCE.pulse.getValue(), color >> 24 & 255), ChatSetting.INSTANCE.pulseSpeed.getValue(), ChatSetting.INSTANCE.pulseCounter.getValueInt());
            }
            return drawContext.method_35720(textRenderer, text, x, y, ColorUtil.injectAlpha(ChatSetting.INSTANCE.color.getValue(), color >> 24 & 255).getRGB());
        }
        return drawContext.method_35720(textRenderer, text, x, y, color);
    }

    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Ljava/util/List;get(I)Ljava/lang/Object;", ordinal=0, remap=false))
    private int get(int i) {
        this.last = this.field_2064.get(i);
        if (this.last != null && !this.map.containsKey((Object)this.last)) {
            this.map.put(this.last, new FadeUtils(ChatSetting.INSTANCE.animateTime.getValueInt()).reset());
        }
        return i;
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I", ordinal=0, shift=At.Shift.BEFORE)})
    private void translate(class_332 context, int currentTick, int mouseX, int mouseY, CallbackInfo ci) {
        if (this.map.containsKey((Object)this.last)) {
            context.method_51448().method_22904(ChatSetting.INSTANCE.animateOffset.getValue() * (1.0 - this.map.get((Object)this.last).getQuad(ChatSetting.INSTANCE.animQuad.getValue())), 0.0, 0.0);
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"}, cancellable=true)
    public void onAddMessage(class_2561 message, class_7469 signature, class_7591 indicator, CallbackInfo ci) {
        ReceiveMessageEvent event = new ReceiveMessageEvent(message.getString());
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }
}
