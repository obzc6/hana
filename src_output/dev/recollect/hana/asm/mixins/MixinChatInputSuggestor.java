/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_342
 *  net.minecraft.class_4587
 *  net.minecraft.class_4717
 *  net.minecraft.class_5481
 *  org.apache.commons.lang3.StringUtils
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_4587;
import net.minecraft.class_4717;
import net.minecraft.class_5481;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4717.class})
public abstract class MixinChatInputSuggestor {
    @Final
    @Shadow
    class_342 field_21599;
    @Shadow
    private CompletableFuture<Suggestions> field_21611;
    @Final
    @Shadow
    private List<class_5481> field_21607;
    @Unique
    private boolean showOutline = false;

    @Shadow
    public abstract void method_23920(boolean var1);

    @Inject(at={@At(value="HEAD")}, method={"render"})
    private void onRender(class_332 context, int mouseX, int mouseY, CallbackInfo ci) {
        if (this.showOutline) {
            int x = this.field_21599.method_46426() - 3;
            int y = this.field_21599.method_46427() - 3;
            Render2DUtil.drawRect(context.method_51448(), (float)x, (float)y, (float)(this.field_21599.method_25368() + 1), 1.0f, ChatSetting.INSTANCE.color.getValue().getRGB());
            Render2DUtil.drawRect(context.method_51448(), (float)x, (float)(y + this.field_21599.method_25364() + 1), (float)(this.field_21599.method_25368() + 1), 1.0f, ChatSetting.INSTANCE.color.getValue().getRGB());
            Render2DUtil.drawRect(context.method_51448(), (float)x, (float)y, 1.0f, (float)(this.field_21599.method_25364() + 1), ChatSetting.INSTANCE.color.getValue().getRGB());
            Render2DUtil.drawRect(context.method_51448(), (float)(x + this.field_21599.method_25368() + 1), (float)y, 1.0f, (float)(this.field_21599.method_25364() + 2), ChatSetting.INSTANCE.color.getValue().getRGB());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/widget/TextFieldWidget;getCursor()I", ordinal=0)}, method={"refresh()V"})
    private void onRefresh(CallbackInfo ci) {
        String string2;
        int cursorPos;
        String prefix = Hana.PREFIX;
        String string = this.field_21599.method_1882();
        this.showOutline = string.startsWith(prefix);
        if (string.length() <= 0 || !prefix.startsWith(string2 = string.substring(0, cursorPos = this.field_21599.method_1881())) && !string2.startsWith(prefix)) return;
        int j = 0;
        Matcher matcher = Pattern.compile("(\\s+)").matcher(string2);
        while (matcher.find()) {
            j = matcher.end();
        }
        SuggestionsBuilder builder = new SuggestionsBuilder(string2, j);
        if (string2.length() < prefix.length()) {
            if (!prefix.startsWith(string2)) return;
            builder.suggest(prefix);
        } else {
            if (!string2.startsWith(prefix)) return;
            int count = StringUtils.countMatches((CharSequence)string2, (CharSequence)" ");
            List<String> seperated = Arrays.asList(string2.split(" "));
            if (count == 0) {
                for (Object strObj : Hana.COMMAND.getCommands().keySet().toArray()) {
                    String str = (String)strObj;
                    builder.suggest(Hana.PREFIX + str + " ");
                }
            } else {
                if (seperated.size() < 1) {
                    return;
                }
                Command c = Hana.COMMAND.getCommandBySyntax(seperated.get(0).substring(prefix.length()));
                if (c == null) {
                    this.field_21607.add(class_2561.method_30163((String)("\u00a7cno commands found: \u00a7e" + seperated.get(0).substring(prefix.length()))).method_30937());
                    return;
                }
                String[] suggestions = c.getAutocorrect(count, seperated);
                if (suggestions == null || suggestions.length == 0) {
                    return;
                }
                for (String str : suggestions) {
                    builder.suggest(str + " ");
                }
            }
        }
        this.field_21611 = builder.buildFuture();
        this.method_23920(false);
    }
}
