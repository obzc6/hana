/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_155
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_766
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 *  org.spongepowered.asm.mixin.Shadow
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.video.VideoPlayer;
import java.awt.Color;
import net.minecraft.class_155;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_766;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={class_442.class})
public class MixinTitleScreen
extends class_437 {
    @Final
    @Shadow
    private boolean field_18222;
    @Shadow
    private long field_17772;
    @Final
    @Shadow
    private static class_2960 field_17775;
    @Final
    @Shadow
    private class_766 field_2585;

    protected MixinTitleScreen(class_2561 title) {
        super(title);
    }

    @Overwrite
    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        super.method_25394(context, mouseX, mouseY, delta);
        if (this.field_17772 == 0L && this.field_18222) {
            this.field_17772 = class_156.method_658();
        }
        float f = this.field_18222 ? (float)(class_156.method_658() - this.field_17772) / 1000.0f : 1.0f;
        this.field_2585.method_3317(delta, class_3532.method_15363((float)f, (float)0.0f, (float)1.0f));
        RenderSystem.enableBlend();
        VideoPlayer.render(this.field_22789, this.field_22790);
        context.method_51422(1.0f, 1.0f, 1.0f, this.field_18222 ? (float)class_3532.method_15386((float)class_3532.method_15363((float)f, (float)0.0f, (float)1.0f)) : 1.0f);
        context.method_25293(field_17775, 0, 0, this.field_22789, this.field_22790, 0.0f, 0.0f, 16, 128, 16, 128);
        context.method_51422(1.0f, 1.0f, 1.0f, 1.0f);
        float g = this.field_18222 ? class_3532.method_15363((float)(f - 1.0f), (float)0.0f, (float)1.0f) : 1.0f;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableDepthTest();
        if (this.field_17772 == 0L && this.field_18222) {
            this.field_17772 = class_156.method_658();
        }
        float L = this.field_18222 ? (float)(class_156.method_658() - this.field_17772) / 1000.0f : 1.0f;
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)L);
        VideoPlayer.render(this.field_22789, this.field_22790);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        context.method_51422(1.0f, 1.0f, 1.0f, g);
        context.method_51422(1.0f, 1.0f, 1.0f, 1.0f);
        int i = class_3532.method_15386((float)(g * 255.0f)) << 24;
        if ((i & -67108864) != 0) {
            String string = "Minecraft " + class_155.method_16673().method_48019();
            assert (this.field_22787 != null);
            if (this.field_22787.method_1530()) {
                string = string + " Demo";
            }
            string = "\u00a7bHanaClient -RecollectWink- for " + string;
            int color = new Color(255, 255, 255, 200).getRGB();
            context.method_25303(this.field_22793, string, 2, this.field_22790 - 10, 16777215 | i);
        }
    }
}
