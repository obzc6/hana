/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1041
 *  net.minecraft.class_156
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_4011
 *  net.minecraft.class_4071
 *  net.minecraft.class_425
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.class_1041;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4011;
import net.minecraft.class_4071;
import net.minecraft.class_425;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_425.class})
public abstract class MixinSplashOverlay {
    @Unique
    private static final class_2960 SplashTexture = new class_2960("textures/splash.png");
    private static final class_310 mc = class_310.method_1551();
    @Final
    @Shadow
    private boolean field_18219;
    @Shadow
    private float field_17770;
    @Shadow
    private long field_17771 = -1L;
    @Shadow
    private long field_18220 = -1L;
    @Final
    @Shadow
    private class_4011 field_17767;
    @Final
    @Shadow
    private Consumer<Optional<Throwable>> field_18218;

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    public void render(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();
        this.renderCustom(context);
    }

    @Unique
    public void renderCustom(class_332 context) {
        int width = mc.method_22683().method_4486();
        int height = mc.method_22683().method_4502();
        long l = class_156.method_658();
        if (this.field_18219 && this.field_18220 == -1L) {
            this.field_18220 = l;
        }
        float f = this.field_17771 > -1L ? (float)(l - this.field_17771) / 1000.0f : -1.0f;
        float g = this.field_18220 > -1L ? (float)(l - this.field_18220) / 500.0f : -1.0f;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)0.1f);
        context.method_25290(SplashTexture, 0, 0, 0.0f, 0.0f, width, height, width, height);
        float t = this.field_17767.method_18229();
        this.field_17770 = class_3532.method_15363((float)(this.field_17770 * 0.95f + t * 0.050000012f), (float)0.0f, (float)1.0f);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        if (f >= 2.0f) {
            mc.method_18502(null);
        }
        if (this.field_17771 == -1L && this.field_17767.method_18787() && (!this.field_18219 || g >= 2.0f)) {
            try {
                this.field_17767.method_18849();
                this.field_18218.accept(Optional.empty());
            }
            catch (Throwable var23) {
                this.field_18218.accept(Optional.of(var23));
            }
            this.field_17771 = class_156.method_658();
            if (MixinSplashOverlay.mc.field_1755 != null) {
                MixinSplashOverlay.mc.field_1755.method_25423(mc, width, height);
            }
        }
    }
}
