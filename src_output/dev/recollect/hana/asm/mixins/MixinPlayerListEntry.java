/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_640
 *  net.minecraft.class_8685
 *  net.minecraft.class_8685$class_7920
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.client.dev.Cape;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import net.minecraft.class_2960;
import net.minecraft.class_640;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_640.class})
public abstract class MixinPlayerListEntry {
    private static final class_2960 Future = new class_2960("minecraft", "textures/capes/future.png");
    private static final class_2960 Rusherhack = new class_2960("minecraft", "textures/capes/rusherhack.png");
    private static final class_2960 Hyper = new class_2960("minecraft", "textures/capes/hyper.png");
    private static final class_2960 Vape = new class_2960("minecraft", "textures/capes/vape.png");
    private static final class_2960 Anime = new class_2960("minecraft", "textures/capes/anime.png");
    private static final class_2960 OF = new class_2960("minecraft", "textures/capes/of.png");
    private static final class_2960 Moon = new class_2960("minecraft", "textures/capes/moon.png");
    private static final class_2960 Reimu = new class_2960("minecraft", "textures/capes/reimu.png");
    private static final class_2960 Azureware = new class_2960("minecraft", "textures/capes/azureware.png");
    private static final class_2960 Hanabi = new class_2960("minecraft", "textures/capes/hanabi.png");
    private static final class_2960 Steam = new class_2960("minecraft", "textures/capes/steam.png");
    private static final class_2960 FDP = new class_2960("minecraft", "textures/capes/fdp.png");

    @Inject(method={"getSkinTextures"}, at={@At(value="TAIL")}, cancellable=true)
    private void getSkinTextures(CallbackInfoReturnable<class_8685> cir) {
        if (Cape.getInstance().isOn()) {
            class_8685 oldTextures = (class_8685)cir.getReturnValue();
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.FUTURE) {
                class_2960 capeTexture = Future;
                class_8685 Textures = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture, capeTexture, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.RUSHERHACK) {
                class_2960 capeTexture2 = Rusherhack;
                class_8685 Textures2 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture2, capeTexture2, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures2);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.HYPER) {
                class_2960 capeTexture3 = Hyper;
                class_8685 Textures3 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture3, capeTexture3, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures3);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Vape) {
                class_2960 capeTexture4 = Vape;
                class_8685 Textures4 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture4, capeTexture4, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures4);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Anime) {
                class_2960 capeTexture5 = Anime;
                class_8685 Textures5 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture5, capeTexture5, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures5);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.OF) {
                class_2960 capeTexture6 = OF;
                class_8685 Textures6 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture6, capeTexture6, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures6);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Moon) {
                class_2960 capeTexture7 = Moon;
                class_8685 Textures7 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture7, capeTexture7, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures7);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Reimu) {
                class_2960 capeTexture8 = Reimu;
                class_8685 Textures8 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture8, capeTexture8, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures8);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Azureware) {
                class_2960 capeTexture9 = Azureware;
                class_8685 Textures9 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture9, capeTexture9, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures9);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Hanabi) {
                class_2960 capeTexture10 = Hanabi;
                class_8685 Textures10 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture10, capeTexture10, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures10);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.Steam) {
                class_2960 capeTexture11 = Steam;
                class_8685 Textures11 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture11, capeTexture11, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures11);
            }
            if (Cape.getInstance().cape.getValue() == Cape.CapeMode.FDP) {
                class_2960 capeTexture12 = FDP;
                class_8685 Textures12 = new class_8685(oldTextures.comp_1626(), oldTextures.comp_1911(), capeTexture12, capeTexture12, oldTextures.comp_1629(), oldTextures.comp_1630());
                cir.setReturnValue((Object)Textures12);
            }
        }
    }
}
