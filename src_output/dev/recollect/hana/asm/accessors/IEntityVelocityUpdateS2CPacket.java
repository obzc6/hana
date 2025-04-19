/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2743
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_2743;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_2743.class})
public interface IEntityVelocityUpdateS2CPacket {
    @Mutable
    @Accessor(value="velocityX")
    public void setX(int var1);

    @Mutable
    @Accessor(value="velocityY")
    public void setY(int var1);

    @Mutable
    @Accessor(value="velocityZ")
    public void setZ(int var1);
}
