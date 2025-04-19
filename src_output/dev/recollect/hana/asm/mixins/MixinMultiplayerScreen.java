/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_437
 *  net.minecraft.class_500
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.gui.nullpoint.alts.AltScreen;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_500;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_500.class})
public class MixinMultiplayerScreen
extends class_437 {
    protected MixinMultiplayerScreen(class_2561 title) {
        super(title);
    }

    @Inject(at={@At(value="TAIL")}, method={"init()V"})
    private void onInit(CallbackInfo ci) {
        this.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)"Alt Manager"), b -> this.field_22787.method_1507((class_437)new AltScreen((class_437)((class_500)this)))).method_46434(this.field_22789 / 2 + 4 + 50, 7, 100, 20).method_46431());
    }
}
