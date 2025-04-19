/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_2791
 *  net.minecraft.class_2818
 *  net.minecraft.class_2874
 *  net.minecraft.class_3695
 *  net.minecraft.class_5269
 *  net.minecraft.class_5294
 *  net.minecraft.class_5294$class_5297
 *  net.minecraft.class_5321
 *  net.minecraft.class_5455
 *  net.minecraft.class_638
 *  net.minecraft.class_6880
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.EntitySpawnEvent;
import dev.recollect.hana.mod.modules.impl.render.Ambience;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.util.function.Supplier;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2791;
import net.minecraft.class_2818;
import net.minecraft.class_2874;
import net.minecraft.class_3695;
import net.minecraft.class_5269;
import net.minecraft.class_5294;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_638.class})
public abstract class MixinClientWorld
extends class_1937 {
    @Unique
    private final class_5294 overworld = new class_5294.class_5297();

    protected MixinClientWorld(class_5269 properties, class_5321<class_1937> registryRef, class_5455 registryManager, class_6880<class_2874> dimensionEntry, Supplier<class_3695> profiler, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Inject(method={"getSkyColor"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetSkyColor(class_243 cameraPos, float tickDelta, CallbackInfoReturnable<class_243> info) {
        if (Ambience.INSTANCE.isOn() && Ambience.INSTANCE.sky.booleanValue) {
            Color sky = Ambience.INSTANCE.sky.getValue();
            info.setReturnValue((Object)new class_243((double)sky.getRed() / 255.0, (double)sky.getGreen() / 255.0, (double)sky.getBlue() / 255.0));
        }
    }

    public float method_8430(float delta) {
        return NoRender.INSTANCE.isOn() && NoRender.INSTANCE.weather.getValue() ? 0.0f : super.method_8430(delta);
    }

    public float method_8478(float delta) {
        return NoRender.INSTANCE.isOn() && NoRender.INSTANCE.weather.getValue() ? 0.0f : super.method_8478(delta);
    }

    @Inject(method={"addEntity"}, at={@At(value="HEAD")}, cancellable=true)
    public void onAddEntity(class_1297 entity, CallbackInfo ci) {
        EntitySpawnEvent event = new EntitySpawnEvent(entity);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"getDimensionEffects"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetSkyProperties(CallbackInfoReturnable<class_5294> info) {
        if (Ambience.INSTANCE.isOn() && Ambience.INSTANCE.forceOverworld.getValue()) {
            info.setReturnValue((Object)this.overworld);
        }
    }

    @Inject(method={"getCloudsColor"}, at={@At(value="HEAD")}, cancellable=true)
    private void hookGetCloudsColor(float tickDelta, CallbackInfoReturnable<class_243> cir) {
        if (Ambience.INSTANCE.isOn() && Ambience.INSTANCE.cloud.booleanValue) {
            Color sky = Ambience.INSTANCE.cloud.getValue();
            cir.setReturnValue((Object)new class_243((double)sky.getRed() / 255.0, (double)sky.getGreen() / 255.0, (double)sky.getBlue() / 255.0));
        }
    }
}
