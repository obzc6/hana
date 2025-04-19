/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_638
 *  net.minecraft.class_7202
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package dev.recollect.hana.asm.accessors;

import net.minecraft.class_638;
import net.minecraft.class_7202;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_638.class})
public interface IClientWorld {
    @Accessor(value="pendingUpdateManager")
    public class_7202 acquirePendingUpdateManager();
}
