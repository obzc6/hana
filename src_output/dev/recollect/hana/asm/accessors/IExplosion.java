/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1927
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_1297;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1927.class})
public interface IExplosion {
    @Mutable
    @Accessor(value="x")
    public void setX(double var1);

    @Mutable
    @Accessor(value="y")
    public void setY(double var1);

    @Mutable
    @Accessor(value="z")
    public void setZ(double var1);

    @Mutable
    @Accessor(value="power")
    public void setPower(float var1);

    @Mutable
    @Accessor(value="entity")
    public void setEntity(class_1297 var1);

    @Mutable
    @Accessor(value="world")
    public void setWorld(class_1937 var1);

    @Mutable
    @Accessor(value="world")
    public class_1937 getWorld();
}
