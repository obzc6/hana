/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2561
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_419
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.xibao.BackgroundWidget;
import dev.recollect.hana.xibao.SnowAnimation;
import dev.recollect.hana.xibao.XibaoPlusPlusConfig;
import java.util.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2561;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_419;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_419.class})
@Environment(value=EnvType.CLIENT)
public class DisconnectedScreenMixin
extends class_437 {
    protected DisconnectedScreenMixin(class_2561 title) {
        super(title);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void initInject(CallbackInfo ci) {
        XibaoPlusPlusConfig.shouldPlayMusic = true;
        XibaoPlusPlusConfig.tempSnow = false;
        this.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43471((String)"gui.stopMusic"), button -> {
            XibaoPlusPlusConfig.shouldPlayMusic = !XibaoPlusPlusConfig.shouldPlayMusic;
        }).method_46434(this.field_22789 / 2 - 100, this.field_22790 - 22, 66, 20).method_46431());
        this.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43471((String)"gui.dropSnow"), button2 -> {
            SnowAnimation.INSTANCE = new SnowAnimation(XibaoPlusPlusConfig.random);
            XibaoPlusPlusConfig.tempSnow = !XibaoPlusPlusConfig.tempSnow;
        }).method_46434(this.field_22789 / 2 - 33, this.field_22790 - 22, 66, 20).method_46431());
        this.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43471((String)"gui.switchAlbum"), button3 -> XibaoPlusPlusConfig.switchAlbum()).method_46434(this.field_22789 / 2 + 34, this.field_22790 - 22, 66, 20).method_46431());
        if (XibaoPlusPlusConfig.displaySnow) {
            SnowAnimation.INSTANCE = new SnowAnimation(XibaoPlusPlusConfig.random);
        }
        this.method_37063((class_364)new BackgroundWidget());
    }
}
