/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  net.minecraft.class_1309
 *  net.minecraft.class_1764
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1806
 *  net.minecraft.class_1839
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 *  net.minecraft.class_759
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.HeldItemRendererEvent;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.impl.render.ViewModel;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_1309;
import net.minecraft.class_1764;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1806;
import net.minecraft.class_1839;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_759;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_759.class})
public abstract class MixinHeldItemRenderer {
    @Inject(method={"renderFirstPersonItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V")}, cancellable=true)
    private void onRenderItem(class_742 player, float tickDelta, float pitch, class_1268 hand, float swingProgress, class_1799 item, float equipProgress, class_4587 matrices, class_4597 vertexConsumers, int light, CallbackInfo ci) {
        HeldItemRendererEvent event = new HeldItemRendererEvent(hand, item, equipProgress, matrices);
        Hana.EVENT_BUS.post(event);
    }

    @Shadow
    public abstract void method_3233(class_1309 var1, class_1799 var2, class_811 var3, boolean var4, class_4587 var5, class_4597 var6, int var7);

    @Shadow
    protected abstract void method_3218(class_4587 var1, float var2, class_1306 var3, class_1799 var4);

    @Inject(method={"renderFirstPersonItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderItemHook(class_742 player, float tickDelta, float pitch, class_1268 hand, float swingProgress, class_1799 item, float equipProgress, class_4587 matrices, class_4597 vertexConsumers, int light, CallbackInfo ci) {
        if (ViewModel.INSTANCE.isOn() && ViewModel.INSTANCE.swingAnimation.getValue() && !item.method_7960() && !(item.method_7909() instanceof class_1806)) {
            ci.cancel();
            this.renderFirstPersonItemCustom(player, tickDelta, pitch, hand, swingProgress, item, equipProgress, matrices, vertexConsumers, light);
        }
    }

    private void renderFirstPersonItemCustom(class_742 player, float tickDelta, float pitch, class_1268 hand, float swingProgress, class_1799 item, float equipProgress, class_4587 matrices, class_4597 vertexConsumers, int light) {
        if (!player.method_31550()) {
            boolean bl = hand == class_1268.field_5808;
            class_1306 arm = bl ? player.method_6068() : player.method_6068().method_5928();
            matrices.method_22903();
            if (item.method_31574(class_1802.field_8399)) {
                int i;
                boolean bl2 = class_1764.method_7781((class_1799)item);
                boolean bl3 = arm == class_1306.field_6183;
                int n = i = bl3 ? 1 : -1;
                if (player.method_6115() && player.method_6014() > 0 && player.method_6058() == hand) {
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    matrices.method_46416((float)i * -0.4785682f, -0.094387f, 0.05731531f);
                    matrices.method_22907(class_7833.field_40714.rotationDegrees(-11.935f));
                    matrices.method_22907(class_7833.field_40716.rotationDegrees((float)i * 65.3f));
                    matrices.method_22907(class_7833.field_40718.rotationDegrees((float)i * -9.785f));
                    float f = (float)item.method_7935() - ((float)Wrapper.mc.field_1724.method_6014() - tickDelta + 1.0f);
                    float g = f / (float)class_1764.method_7775((class_1799)item);
                    if (g > 1.0f) {
                        g = 1.0f;
                    }
                    if (g > 0.1f) {
                        float h = class_3532.method_15374((float)((f - 0.1f) * 1.3f));
                        float j = g - 0.1f;
                        float k = h * j;
                        matrices.method_46416(k * 0.0f, k * 0.004f, k * 0.0f);
                    }
                    matrices.method_46416(g * 0.0f, g * 0.0f, g * 0.04f);
                    matrices.method_22905(1.0f, 1.0f, 1.0f + g * 0.2f);
                    matrices.method_22907(class_7833.field_40715.rotationDegrees((float)i * 45.0f));
                } else {
                    float f = -0.4f * class_3532.method_15374((float)(class_3532.method_15355((float)swingProgress) * 3.1415927f));
                    float g = 0.2f * class_3532.method_15374((float)(class_3532.method_15355((float)swingProgress) * 6.2831855f));
                    float h = -0.2f * class_3532.method_15374((float)(swingProgress * 3.1415927f));
                    matrices.method_46416((float)i * f, g, h);
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    this.applySwingOffset(matrices, arm, swingProgress);
                    if (bl2 && swingProgress < 0.001f && bl) {
                        matrices.method_46416((float)i * -0.641864f, 0.0f, 0.0f);
                        matrices.method_22907(class_7833.field_40716.rotationDegrees((float)i * 10.0f));
                    }
                }
                HeldItemRendererEvent event = new HeldItemRendererEvent(hand, item, equipProgress, matrices);
                Hana.EVENT_BUS.post(event);
                this.method_3233((class_1309)player, item, bl3 ? class_811.field_4322 : class_811.field_4321, !bl3, matrices, vertexConsumers, light);
            } else {
                boolean bl2;
                boolean bl3 = bl2 = arm == class_1306.field_6183;
                if (player.method_6115() && player.method_6014() > 0 && player.method_6058() == hand) {
                    int l = bl2 ? 1 : -1;
                    switch (item.method_7976()) {
                        case field_8952: 
                        case field_8949: {
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            break;
                        }
                        case field_8950: 
                        case field_8946: {
                            if (ViewModel.INSTANCE.eatAnimation.getValue()) {
                                this.applyEatOrDrinkTransformationCustom(matrices, tickDelta, arm, item);
                            } else {
                                this.method_3218(matrices, tickDelta, arm, item);
                            }
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            break;
                        }
                        case field_8953: {
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            matrices.method_46416((float)l * -0.2785682f, 0.18344387f, 0.15731531f);
                            matrices.method_22907(class_7833.field_40714.rotationDegrees(-13.935f));
                            matrices.method_22907(class_7833.field_40716.rotationDegrees((float)l * 35.3f));
                            matrices.method_22907(class_7833.field_40718.rotationDegrees((float)l * -9.785f));
                            float m = (float)item.method_7935() - ((float)Wrapper.mc.field_1724.method_6014() - tickDelta + 1.0f);
                            float f = m / 20.0f;
                            f = (f * f + f * 2.0f) / 3.0f;
                            if (f > 1.0f) {
                                f = 1.0f;
                            }
                            if (f > 0.1f) {
                                float g = class_3532.method_15374((float)((m - 0.1f) * 1.3f));
                                float h = f - 0.1f;
                                float j = g * h;
                                matrices.method_46416(j * 0.0f, j * 0.004f, j * 0.0f);
                            }
                            matrices.method_46416(f * 0.0f, f * 0.0f, f * 0.04f);
                            matrices.method_22905(1.0f, 1.0f, 1.0f + f * 0.2f);
                            matrices.method_22907(class_7833.field_40715.rotationDegrees((float)l * 45.0f));
                            break;
                        }
                        case field_8951: {
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            matrices.method_46416((float)l * -0.5f, 0.7f, 0.1f);
                            matrices.method_22907(class_7833.field_40714.rotationDegrees(-55.0f));
                            matrices.method_22907(class_7833.field_40716.rotationDegrees((float)l * 35.3f));
                            matrices.method_22907(class_7833.field_40718.rotationDegrees((float)l * -9.785f));
                            float m = (float)item.method_7935() - ((float)Wrapper.mc.field_1724.method_6014() - tickDelta + 1.0f);
                            float f = m / 10.0f;
                            if (f > 1.0f) {
                                f = 1.0f;
                            }
                            if (f > 0.1f) {
                                float g = class_3532.method_15374((float)((m - 0.1f) * 1.3f));
                                float h = f - 0.1f;
                                float j = g * h;
                                matrices.method_46416(j * 0.0f, j * 0.004f, j * 0.0f);
                            }
                            matrices.method_46416(0.0f, 0.0f, f * 0.2f);
                            matrices.method_22905(1.0f, 1.0f, 1.0f + f * 0.2f);
                            matrices.method_22907(class_7833.field_40715.rotationDegrees((float)l * 45.0f));
                            break;
                        }
                        case field_42717: {
                            this.applyBrushTransformation(matrices, tickDelta, arm, item, equipProgress);
                        }
                    }
                } else if (player.method_6123()) {
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    int l = bl2 ? 1 : -1;
                    matrices.method_46416((float)l * -0.4f, 0.8f, 0.3f);
                    matrices.method_22907(class_7833.field_40716.rotationDegrees((float)l * 65.0f));
                    matrices.method_22907(class_7833.field_40718.rotationDegrees((float)l * -85.0f));
                } else {
                    matrices.method_46416(0.0f, 0.0f, 0.0f);
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    this.applySwingOffset(matrices, arm, swingProgress);
                }
                HeldItemRendererEvent event = new HeldItemRendererEvent(hand, item, equipProgress, matrices);
                Hana.EVENT_BUS.post(event);
                this.method_3233((class_1309)player, item, bl2 ? class_811.field_4322 : class_811.field_4321, !bl2, matrices, vertexConsumers, light);
            }
            matrices.method_22909();
        }
    }

    private void applyEquipOffset(@NotNull class_4587 matrices, class_1306 arm, float equipProgress) {
        int i = arm == class_1306.field_6183 ? 1 : -1;
        matrices.method_46416((float)i * 0.56f, -0.52f + equipProgress * -0.6f, -0.72f);
    }

    private void applySwingOffset(@NotNull class_4587 matrices, class_1306 arm, float swingProgress) {
        int i = arm == class_1306.field_6183 ? 1 : -1;
        float f = class_3532.method_15374((float)(swingProgress * swingProgress * 3.1415927f));
        matrices.method_22907(class_7833.field_40716.rotationDegrees((float)i * (45.0f + f * -20.0f)));
        float g = class_3532.method_15374((float)(class_3532.method_15355((float)swingProgress) * 3.1415927f));
        matrices.method_22907(class_7833.field_40718.rotationDegrees((float)i * g * -20.0f));
        matrices.method_22907(class_7833.field_40714.rotationDegrees(g * -80.0f));
        matrices.method_22907(class_7833.field_40716.rotationDegrees((float)i * -45.0f));
    }

    private void applyEatOrDrinkTransformationCustom(class_4587 matrices, float tickDelta, class_1306 arm, @NotNull class_1799 stack) {
        float h;
        float f = (float)Wrapper.mc.field_1724.method_6014() - tickDelta + 1.0f;
        float g = f / (float)stack.method_7935();
        if (g < 0.8f) {
            h = class_3532.method_15379((float)(class_3532.method_15362((float)(f / 4.0f * 3.1415927f)) * 0.005f));
            matrices.method_46416(0.0f, h, 0.0f);
        }
        h = 1.0f - (float)Math.pow(g, 27.0);
        int i = arm == class_1306.field_6183 ? 1 : -1;
        matrices.method_22904((double)(h * 0.6f * (float)i) * ViewModel.INSTANCE.eatX.getValue(), (double)(h * -0.5f) * ViewModel.INSTANCE.eatY.getValue(), (double)(h * 0.0f));
        matrices.method_22907(class_7833.field_40716.rotationDegrees((float)i * h * 90.0f));
        matrices.method_22907(class_7833.field_40714.rotationDegrees(h * 10.0f));
        matrices.method_22907(class_7833.field_40718.rotationDegrees((float)i * h * 30.0f));
    }

    @Inject(method={"applyEatOrDrinkTransformation"}, at={@At(value="HEAD")}, cancellable=true)
    private void applyEatOrDrinkTransformationHook(class_4587 matrices, float tickDelta, class_1306 arm, class_1799 stack, CallbackInfo ci) {
        if (ViewModel.INSTANCE.isOn() && ViewModel.INSTANCE.eatAnimation.getValue()) {
            this.applyEatOrDrinkTransformationCustom(matrices, tickDelta, arm, stack);
            ci.cancel();
        }
    }

    private void applyBrushTransformation(class_4587 matrices, float tickDelta, class_1306 arm, @NotNull class_1799 stack, float equipProgress) {
        this.applyEquipOffset(matrices, arm, equipProgress);
        float f = (float)Wrapper.mc.field_1724.method_6014() - tickDelta + 1.0f;
        float g = 1.0f - f / (float)stack.method_7935();
        float m = -15.0f + 75.0f * class_3532.method_15362((float)(g * 45.0f * 3.1415927f));
        if (arm != class_1306.field_6183) {
            matrices.method_22904(0.1, 0.83, 0.35);
            matrices.method_22907(class_7833.field_40714.rotationDegrees(-80.0f));
            matrices.method_22907(class_7833.field_40716.rotationDegrees(-90.0f));
            matrices.method_22907(class_7833.field_40714.rotationDegrees(m));
            matrices.method_22904(-0.3, 0.22, 0.35);
        } else {
            matrices.method_22904(-0.25, 0.22, 0.35);
            matrices.method_22907(class_7833.field_40714.rotationDegrees(-80.0f));
            matrices.method_22907(class_7833.field_40716.rotationDegrees(90.0f));
            matrices.method_22907(class_7833.field_40718.rotationDegrees(0.0f));
            matrices.method_22907(class_7833.field_40714.rotationDegrees(m));
        }
    }

}
