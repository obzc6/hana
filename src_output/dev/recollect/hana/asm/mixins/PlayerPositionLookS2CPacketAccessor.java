/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.mixins;

import net.minecraft.class_1297;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1297.class})
public interface PlayerPositionLookS2CPacketAccessor {
    @Accessor(value="yaw")
    @Mutable
    public void setYaw(float var1);

    @Accessor(value="pitch")
    @Mutable
    public void setPitch(float var1);
}
