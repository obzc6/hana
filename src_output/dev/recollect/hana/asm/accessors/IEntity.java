/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_4048
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_4048;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1297.class})
public interface IEntity {
    @Mutable
    @Accessor(value="pos")
    public void setPos(class_243 var1);

    @Accessor(value="dimensions")
    public class_4048 getDimensions();
}
