/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_1309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1309.class})
public interface ILivingEntity {
    @Accessor(value="lastAttackedTicks")
    public int getLastAttackedTicks();

    @Accessor(value="jumpingCooldown")
    public int getLastJumpCooldown();

    @Accessor(value="jumpingCooldown")
    public void setLastJumpCooldown(int var1);
}
