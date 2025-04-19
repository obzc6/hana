/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1262
 *  net.minecraft.class_1703
 *  net.minecraft.class_1723
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_308
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3936
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_465
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.opengl.GL11
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.modules.impl.miscellaneous.ShulkerViewer;
import java.awt.Color;
import net.minecraft.class_1262;
import net.minecraft.class_1703;
import net.minecraft.class_1723;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_308;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3936;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_465;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_465.class})
public abstract class MixinHandledScreen<T extends class_1703>
extends class_437
implements class_3936<T> {
    @Shadow
    @Nullable
    protected class_1735 field_2787;
    @Shadow
    protected int field_2776;
    @Shadow
    protected int field_2800;

    protected MixinHandledScreen(class_2561 title) {
        super(title);
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void onRender(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (this.field_2787 != null && !this.field_2787.method_7677().method_7960() && this.field_22787.field_1724.field_7498.method_34255().method_7960() && this.hasItems(this.field_2787.method_7677()) && ShulkerViewer.INSTANCE.isOn()) {
            this.renderShulkerToolTip(context, mouseX, mouseY, this.field_2787.method_7677());
        }
    }

    public void renderShulkerToolTip(class_332 context, int mouseX, int mouseY, class_1799 stack) {
        try {
            class_2487 compoundTag = stack.method_7941("BlockEntityTag");
            class_2371 itemStacks = class_2371.method_10213((int)27, (Object)class_1799.field_8037);
            class_1262.method_5429((class_2487)compoundTag, (class_2371)itemStacks);
            this.draw(context, (class_2371<class_1799>)itemStacks, mouseX, mouseY);
        }
        catch (Exception compoundTag) {
            // empty catch block
        }
    }

    private void draw(class_332 context, class_2371<class_1799> itemStacks, int mouseX, int mouseY) {
        RenderSystem.disableDepthTest();
        GL11.glClear((int)256);
        this.drawBackground(context, mouseX += 8, mouseY -= 82);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        class_308.method_24211();
        int row = 0;
        int i = 0;
        for (class_1799 itemStack : itemStacks) {
            context.method_51427(itemStack, mouseX + 8 + i * 18, mouseY + 7 + row * 18);
            context.method_51431(Wrapper.mc.field_1772, itemStack, mouseX + 8 + i * 18, mouseY + 7 + row * 18);
            if (++i < 9) continue;
            i = 0;
            ++row;
        }
        class_308.method_24210();
        RenderSystem.enableDepthTest();
    }

    private void drawBackground(class_332 context, int x, int y) {
        Render2DUtil.drawRect(context.method_51448(), (float)x, (float)y, 176.0f, 67.0f, new Color(0, 0, 0, 120));
    }

    private boolean hasItems(class_1799 itemStack) {
        class_2487 compoundTag = itemStack.method_7941("BlockEntityTag");
        return compoundTag != null && compoundTag.method_10573("Items", 9);
    }
}
