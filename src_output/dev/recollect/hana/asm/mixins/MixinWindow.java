/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_3262
 *  net.minecraft.class_7367
 *  net.minecraft.class_8518
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package dev.recollect.hana.asm.mixins;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_3262;
import net.minecraft.class_7367;
import net.minecraft.class_8518;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_1041.class})
public class MixinWindow {
    @Redirect(method={"setIcon"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/util/Icons;getIcons(Lnet/minecraft/resource/ResourcePack;)Ljava/util/List;"))
    private List<class_7367<InputStream>> onSetIcon(class_8518 instance, class_3262 resourcePack) throws IOException {
        InputStream stream16 = MixinWindow.class.getResourceAsStream("/assets/minecraft/icon.png");
        InputStream stream32 = MixinWindow.class.getResourceAsStream("/assets/minecraft/icon.png");
        if (stream16 == null || stream32 == null) {
            return instance.method_51418(resourcePack);
        }
        return List.of(() -> stream16, () -> stream32);
    }
}
