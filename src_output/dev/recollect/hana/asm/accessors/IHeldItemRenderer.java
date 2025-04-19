/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_759
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_1799;
import net.minecraft.class_759;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_759.class})
public interface IHeldItemRenderer {
    @Accessor(value="equipProgressMainHand")
    public void setEquippedProgressMainHand(float var1);

    @Accessor(value="equipProgressOffHand")
    public void setEquippedProgressOffHand(float var1);

    @Accessor(value="equipProgressMainHand")
    public float getEquippedProgressMainHand();

    @Accessor(value="equipProgressOffHand")
    public float getEquippedProgressOffHand();

    @Accessor(value="mainHand")
    public void setItemStackMainHand(class_1799 var1);

    @Accessor(value="offHand")
    public void setItemStackOffHand(class_1799 var1);
}
