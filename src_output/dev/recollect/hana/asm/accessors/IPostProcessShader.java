/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_276
 *  net.minecraft.class_283
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_276;
import net.minecraft.class_283;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_283.class})
public interface IPostProcessShader {
    @Mutable
    @Accessor(value="input")
    public void setInput(class_276 var1);

    @Mutable
    @Accessor(value="output")
    public void setOutput(class_276 var1);
}
