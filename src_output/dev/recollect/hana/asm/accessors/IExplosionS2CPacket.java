/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2664
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_2664;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_2664.class})
public interface IExplosionS2CPacket {
    @Mutable
    @Accessor(value="playerVelocityX")
    public void setX(float var1);

    @Mutable
    @Accessor(value="playerVelocityY")
    public void setY(float var1);

    @Mutable
    @Accessor(value="playerVelocityZ")
    public void setZ(float var1);

    @Accessor(value="playerVelocityX")
    public float getX();

    @Accessor(value="playerVelocityY")
    public float getY();

    @Accessor(value="playerVelocityZ")
    public float getZ();
}
