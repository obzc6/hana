/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap
 *  net.minecraft.class_1011
 *  net.minecraft.class_1043
 *  net.minecraft.class_1044
 *  net.minecraft.class_1060
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  org.lwjgl.BufferUtils
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.gui.nullpoint.font.Glyph;
import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.lwjgl.BufferUtils;

class GlyphMap {
    class_2960 bindToTexture;
    private static final int PADDING = 5;
    int width;
    char toExcl;
    int height;
    boolean generated;
    private final Char2ObjectArrayMap<Glyph> glyphs;
    char fromIncl;
    Font[] font;

    /*
     * WARNING - void declaration
     */
    public GlyphMap(char c, char c2, Font[] arrfont, class_2960 class_29602) {
        GlyphMap a;
        GlyphMap a2;
        void a3;
        void a4;
        void a5;
        GlyphMap glyphMap = glyphMap2;
        GlyphMap glyphMap2 = class_29602;
        GlyphMap glyphMap3 = a2 = glyphMap;
        GlyphMap glyphMap4 = a2;
        GlyphMap glyphMap5 = a2;
        a2.glyphs = new Char2ObjectArrayMap();
        a2.generated = false;
        glyphMap4.fromIncl = a4;
        glyphMap4.toExcl = a3;
        glyphMap3.font = a5;
        glyphMap3.bindToTexture = a;
    }

    public static void registerBufferedImageTexture(class_2960 class_29602, BufferedImage bufferedImage) {
        class_1043 a = bufferedImage;
        class_2960 a2 = class_29602;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)a, Tab.ALLATORIxDEMO("\u0007m\u0007"), byteArrayOutputStream);
            a = byteArrayOutputStream.toByteArray();
            a = BufferUtils.createByteBuffer((int)((byte[])a).length).put((byte[])a);
            a.flip();
            a = new class_1043(class_1011.method_4324((ByteBuffer)a));
            Wrapper.mc.execute(() -> {
                class_2960 a = a;
                class_2960 a2 = a2;
                Wrapper.mc.method_1531().method_4616(a2, (class_1044)a);
            });
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public void destroy() {
        GlyphMap a;
        class_310.method_1551().method_1531().method_4615(a.bindToTexture);
        GlyphMap glyphMap = a;
        a.glyphs.clear();
        a.width = -1;
        glyphMap.height = -1;
        glyphMap.generated = false;
    }

    public boolean contains(char c) {
        char a = c;
        GlyphMap a2 = this;
        return a >= a2.fromIncl && a < a2.toExcl;
    }

    public Glyph getGlyph(char c) {
        char a = c;
        GlyphMap a2 = this;
        if (!a2.generated) {
            a2.generate();
        }
        return (Glyph)a2.glyphs.get(a);
    }

    public void generate() {
        Object object;
        Glyph a2;
        BufferedImage bufferedImage;
        Object object2;
        GlyphMap glyphMap = a2;
        if (glyphMap.generated) {
            return;
        }
        GlyphMap glyphMap2 = glyphMap;
        int n = glyphMap2.toExcl - glyphMap2.fromIncl - 1;
        int n2 = (int)(Math.ceil(Math.sqrt(n)) * 1.5);
        glyphMap2.glyphs.clear();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        ArrayList<Glyph> arrayList = new ArrayList<Glyph>();
        Object object3 = new AffineTransform();
        object3 = new FontRenderContext((AffineTransform)object3, true, true);
        int n10 = n3;
        while (n10 <= n) {
            GlyphMap glyphMap3 = glyphMap;
            char c = (char)(glyphMap3.fromIncl + n3);
            object = glyphMap3.getFontForGlyph(c);
            object2 = ((Font)object).getStringBounds(String.valueOf(c), (FontRenderContext)object3);
            int a2 = (int)Math.ceil(((RectangularShape)object2).getWidth());
            ++n3;
            int n11 = (int)Math.ceil(((RectangularShape)object2).getHeight());
            n5 = Math.max(n5, n7 + a2);
            n6 = Math.max(n6, n8 + n11);
            if (n4 >= n2) {
                n7 = 0;
                n8 += n9 + 5;
                n4 = 0;
                n9 = 0;
            }
            n9 = Math.max(n9, n11);
            arrayList.add(new Glyph(n7, n8, a2, n11, c, glyphMap));
            ++n4;
            n7 += a2 + 5;
            n10 = n3;
        }
        BufferedImage bufferedImage2 = bufferedImage = new BufferedImage(Math.max(n5 + 5, 1), Math.max(n6 + 5, 1), 2);
        glyphMap.width = bufferedImage.getWidth();
        glyphMap.height = bufferedImage2.getHeight();
        Object object4 = object = bufferedImage2.createGraphics();
        Object object5 = object;
        ((Graphics)object5).setColor(new Color(255, 255, 255, 0));
        GlyphMap glyphMap4 = glyphMap;
        ((Graphics)object4).fillRect(0, 0, glyphMap4.width, glyphMap4.height);
        ((Graphics)object5).setColor(Color.WHITE);
        ((Graphics2D)object4).setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        ((Graphics2D)object4).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        ((Graphics2D)object4).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Object object6 = object2 = arrayList.iterator();
        while (object6.hasNext()) {
            a2 = (Glyph)object2.next();
            Object object7 = object;
            ((Graphics)object7).setFont(glyphMap.getFontForGlyph(a2.value()));
            FontMetrics fontMetrics = ((Graphics)object7).getFontMetrics();
            ((Graphics2D)object7).drawString(String.valueOf(a2.value()), a2.u(), a2.v() + fontMetrics.getAscent());
            object6 = object2;
            glyphMap.glyphs.put(a2.value(), (Object)a2);
        }
        GlyphMap.registerBufferedImageTexture(glyphMap.bindToTexture, bufferedImage);
        glyphMap.generated = true;
    }

    private /* synthetic */ Font getFontForGlyph(char a) {
        GlyphMap a2;
        GlyphMap glyphMap = a2;
        Font[] arrfont = glyphMap.font;
        int n = arrfont.length;
        int n2 = a2 = 0;
        while (n2 < n) {
            Font font = arrfont[a2];
            if (font.canDisplay(a)) {
                return font;
            }
            n2 = ++a2;
        }
        return glyphMap.font[0];
    }
}
