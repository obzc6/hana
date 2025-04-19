/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_7172
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.RendererFontAdapter;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_7172;
import org.jetbrains.annotations.NotNull;

public final class FontRenderers {
    public static FontAdapter Arial;
    public static FontAdapter maxBold;
    public static FontAdapter icons;
    @NotNull
    public static final FontRenderers INSTANCE;
    public static FontAdapter lexend;
    public static FontAdapter bold;
    public int scaledHeight;
    public static FontAdapter big_icons;
    public static FontAdapter defaul;
    public static FontAdapter sigma;
    public static FontAdapter comfortaa;
    public static FontAdapter badaboom;
    public int scaledWidth;
    public int scaleFactor;
    public static FontAdapter biglexend;
    public static FontAdapter cn;
    class_310 mc;
    public static FontAdapter mid_icons;
    public static FontAdapter genShin;

    @NotNull
    public final FontAdapter getComfortaa() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = comfortaa;
        if (a != null) {
            return a;
        }
        return null;
    }

    public final void setDefault(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        defaul = fontAdapter2;
    }

    @NotNull
    public final FontAdapter getCn() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = cn;
        if (a != null) {
            return a;
        }
        return null;
    }

    public final void setBold(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        bold = fontAdapter2;
    }

    public final void setGenShin(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        genShin = fontAdapter2;
    }

    public final void setBigLexend(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        biglexend = fontAdapter2;
    }

    public final void setLexend(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        lexend = fontAdapter2;
    }

    public final void setMaxBold(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        maxBold = fontAdapter2;
    }

    public final void setMid_icons(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        mid_icons = fontAdapter2;
    }

    @NotNull
    public final FontAdapter getMaxBold() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = maxBold;
        if (a != null) {
            return a;
        }
        return null;
    }

    @NotNull
    public final FontAdapter getIcons() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = icons;
        if (a != null) {
            return a;
        }
        return null;
    }

    static {
        INSTANCE = new FontRenderers();
    }

    public final void setBig_icons(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        big_icons = fontAdapter2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final RendererFontAdapter createDefault(float f, @NotNull String string) throws IOException, FontFormatException {
        void size;
        FontRenderers fontRenderers = object;
        Object object = string;
        FontRenderers a = fontRenderers;
        object = Font.createFont(0, Objects.requireNonNull(Hana.class.getClassLoader().getResourceAsStream((String)object + ".ttf"))).deriveFont(1, (float)(size * 2.0f));
        return new RendererFontAdapter((Font)object, (float)(size * 2.0f));
    }

    @NotNull
    public final FontAdapter getDefault() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = defaul;
        if (a != null) {
            return a;
        }
        return null;
    }

    public final void setBadaboom(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        badaboom = fontAdapter2;
    }

    @NotNull
    public final FontAdapter getBold() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = bold;
        if (a != null) {
            return a;
        }
        return null;
    }

    public final void setIcons(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        icons = fontAdapter2;
    }

    @NotNull
    public final FontAdapter getMid_icons() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = mid_icons;
        if (a != null) {
            return a;
        }
        return null;
    }

    public final void setCn(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        cn = fontAdapter2;
    }

    public static RendererFontAdapter createArial(float a) {
        return new RendererFontAdapter(new Font(Alt.ALLATORIxDEMO("\tw6e2"), 0, (int)(a / 2.0f)), a / 2.0f);
    }

    @NotNull
    public final FontAdapter getLexend() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = lexend;
        if (a != null) {
            return a;
        }
        return null;
    }

    @NotNull
    public final RendererFontAdapter createIcons(float a) throws IOException, FontFormatException {
        Font a2;
        FontRenderers fontRenderers = a2;
        a2 = Font.createFont(0, Objects.requireNonNull(Hana.class.getClassLoader().getResourceAsStream(BOEntityUtils.ALLATORIxDEMO("SbBxI/YtJ")))).deriveFont(0, a * 2.0f);
        return new RendererFontAdapter(a2, a * 2.0f);
    }

    @NotNull
    public final FontAdapter getGenShin() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = genShin;
        if (a != null) {
            return a;
        }
        return null;
    }

    @NotNull
    public final FontAdapter getSigma() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = sigma;
        if (a != null) {
            return a;
        }
        return null;
    }

    @NotNull
    public final FontAdapter getBig_icons() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = big_icons;
        if (a != null) {
            return a;
        }
        return null;
    }

    public void updateResolution() {
        FontRenderers a22;
        FontRenderers fontRenderers;
        FontRenderers fontRenderers2 = fontRenderers = a22;
        fontRenderers2.scaledWidth = fontRenderers2.mc.method_22683().method_4486();
        fontRenderers.scaledHeight = fontRenderers2.mc.method_22683().method_4502();
        fontRenderers.scaleFactor = 1;
        boolean bl = fontRenderers.mc.method_1573();
        int a22 = fontRenderers.mc.field_1690.method_42437().hashCode();
        if (a22 == 0) {
            a22 = 1000;
        }
        FontRenderers fontRenderers3 = fontRenderers;
        while (fontRenderers3.scaleFactor < a22) {
            FontRenderers fontRenderers4 = fontRenderers;
            if (fontRenderers4.scaledWidth / (fontRenderers4.scaleFactor + 1) < 320) break;
            FontRenderers fontRenderers5 = fontRenderers;
            if (fontRenderers5.scaledHeight / (fontRenderers5.scaleFactor + 1) < 240) break;
            FontRenderers fontRenderers6 = fontRenderers;
            fontRenderers3 = fontRenderers6;
            ++fontRenderers6.scaleFactor;
        }
        if (bl && fontRenderers.scaleFactor % 2 != 0 && fontRenderers.scaleFactor != 1) {
            --fontRenderers.scaleFactor;
        }
        FontRenderers fontRenderers7 = fontRenderers;
        double d = (double)fontRenderers7.scaledWidth / (double)fontRenderers.scaleFactor;
        double d2 = (double)fontRenderers7.scaledHeight / (double)fontRenderers.scaleFactor;
        fontRenderers.scaledWidth = class_3532.method_15384((double)d);
        fontRenderers7.scaledHeight = class_3532.method_15384((double)d2);
    }

    @NotNull
    public final FontAdapter getBadaboom() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = badaboom;
        if (a != null) {
            return a;
        }
        return null;
    }

    public final void setSigma(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        sigma = fontAdapter2;
    }

    public final void setComfortaa(@NotNull FontAdapter fontAdapter) {
        FontRenderers fontRenderers = fontAdapter2;
        FontAdapter fontAdapter2 = fontAdapter;
        FontRenderers a = fontRenderers;
        comfortaa = fontAdapter2;
    }

    @NotNull
    public final RendererFontAdapter createSigma(float a) throws IOException, FontFormatException {
        Font a2;
        FontRenderers fontRenderers = a2;
        a2 = Font.createFont(0, Objects.requireNonNull(Hana.class.getClassLoader().getResourceAsStream(Alt.ALLATORIxDEMO(";l8)++p8")))).deriveFont(1, a * 2.0f);
        return new RendererFontAdapter(a2, a * 2.0f);
    }

    private /* synthetic */ FontRenderers() {
        FontRenderers fontRenderers;
        FontRenderers a22;
        FontRenderers fontRenderers2 = fontRenderers = a22;
        fontRenderers2.mc = class_310.method_1551();
        fontRenderers2.updateResolution();
        try {
            FontRenderers fontRenderers3 = fontRenderers;
            fontRenderers3.setBig_icons(fontRenderers3.createIcons(5.0f));
            fontRenderers.setSigma(fontRenderers3.createSigma(5.0f));
            return;
        }
        catch (FontFormatException | IOException a22) {
            a22.printStackTrace();
            return;
        }
    }

    public final FontAdapter getBigLexend() {
        FontAdapter a;
        FontRenderers fontRenderers = a;
        a = biglexend;
        if (a != null) {
            return a;
        }
        return null;
    }
}
