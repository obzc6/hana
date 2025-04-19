/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_2960
 *  org.apache.commons.lang3.RandomStringUtils
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.gui.nullpoint.font.Texture;
import java.awt.image.BufferedImage;
import net.minecraft.class_2960;
import org.apache.commons.lang3.RandomStringUtils;

public static class Render2DUtil.BlurredShadow {
    Texture id;

    public Render2DUtil.BlurredShadow(BufferedImage bufferedImage) {
        BufferedImage a = bufferedImage;
        Render2DUtil.BlurredShadow a2 = this;
        Render2DUtil.BlurredShadow blurredShadow = a2;
        blurredShadow.id = new Texture("texture/remote/" + RandomStringUtils.randomAlphanumeric((int)16));
        Render2DUtil.registerBufferedImageTexture(a2.id, a);
    }

    public void bind() {
        Render2DUtil.BlurredShadow a;
        RenderSystem.setShaderTexture((int)0, (class_2960)a.id);
    }
}
