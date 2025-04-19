/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.impl.render.HotbarAnimation;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_329;
import net.minecraft.class_332;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_329.class})
public class MixinInGameHud {
    @Unique
    private double hotbarX = 0.0;

    @Inject(method={"renderPortalOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderPortalOverlay(class_332 context, float nauseaStrength, CallbackInfo ci) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.portal.getValue()) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;enableBlend()V", remap=false, ordinal=3)}, method={"render(Lnet/minecraft/client/gui/DrawContext;F)V"})
    private void onRender(class_332 context, float tickDelta, CallbackInfo ci) {
        Hana.MODULE.render2D(context);
    }

    @Inject(method={"clear"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/ChatHud;clear(Z)V")}, cancellable=true)
    private void onClear(CallbackInfo info) {
        if (ChatSetting.INSTANCE.isOn() && ChatSetting.INSTANCE.keepHistory.getValue()) {
            info.cancel();
        }
    }

    @ModifyArg(method={"renderHotbar"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V", ordinal=1), index=1)
    private int selectedSlotX(int x) {
        if (HotbarAnimation.INSTANCE.isOn()) {
            this.hotbarX = AnimateUtil.animate(this.hotbarX, x, HotbarAnimation.INSTANCE.hotbarSpeed.getValue(), HotbarAnimation.INSTANCE.animMode.getValue());
            return (int)this.hotbarX;
        }
        return x;
    }
}
