/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.class_2477
 *  net.minecraft.class_2583
 *  net.minecraft.class_327
 *  net.minecraft.class_341
 *  net.minecraft.class_5222
 *  net.minecraft.class_5225
 *  net.minecraft.class_5348
 *  net.minecraft.class_5348$class_5246
 *  net.minecraft.class_5481
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import com.google.common.collect.Lists;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import net.minecraft.class_2477;
import net.minecraft.class_2583;
import net.minecraft.class_327;
import net.minecraft.class_341;
import net.minecraft.class_5222;
import net.minecraft.class_5225;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_341.class})
public class MixinChatMessages {
    @Final
    @Shadow
    private static class_5481 field_25263;

    @Shadow
    private static String method_1849(String message) {
        return "";
    }

    @Inject(method={"breakRenderedChatMessageLines"}, at={@At(value="HEAD")}, cancellable=true)
    private static void breakRenderedChatMessageLinesHook(class_5348 message, int width, class_327 textRenderer, CallbackInfoReturnable<List<class_5481>> cir) {
        class_5222 textCollector = new class_5222();
        message.method_27658((style, messagex) -> {
            textCollector.method_27462(class_5348.method_29431((String)MixinChatMessages.method_1849(messagex), (class_2583)style));
            return Optional.empty();
        }, class_2583.field_24360);
        ArrayList list = Lists.newArrayList();
        textRenderer.method_27527().method_29971(textCollector.method_27463(), width, class_2583.field_24360, (text, lastLineWrapped) -> {
            class_5481 orderedText = class_2477.method_10517().method_30934(text);
            class_5481 o = lastLineWrapped != false ? class_5481.method_30742((class_5481)field_25263, (class_5481)orderedText) : orderedText;
            list.add(o);
            ChatSetting.chatMessage.put(o, message);
        });
        cir.setReturnValue((Object)(list.isEmpty() ? Lists.newArrayList((Object[])new class_5481[]{class_5481.field_26385}) : list));
    }
}
