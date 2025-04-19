/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_636
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.mixins;

import net.minecraft.class_2338;
import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_636.class})
public interface IClientPlayerInteractionManager {
    @Accessor(value="currentBreakingProgress")
    public float getBreakingProgress();

    @Accessor(value="currentBreakingProgress")
    public void setCurrentBreakingProgress(float var1);

    @Accessor(value="currentBreakingPos")
    public class_2338 getCurrentBreakingBlockPos();
}
