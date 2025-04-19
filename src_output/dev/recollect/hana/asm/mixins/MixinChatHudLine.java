/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_303
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.interfaces.IChatHudLine;
import net.minecraft.class_303;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_303.class})
public abstract class MixinChatHudLine
implements IChatHudLine {
    @Unique
    private int id = 0;

    @Override
    public int nullpoint_nextgen_master$getId() {
        return this.id;
    }

    @Override
    public void nullpoint_nextgen_master$setId(int id) {
        this.id = id;
    }
}
