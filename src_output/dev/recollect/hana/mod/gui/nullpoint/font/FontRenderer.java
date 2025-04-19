/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.mojang.blaze3d.systems.RenderSystem
 *  it.unimi.dsi.fastutil.chars.Char2IntArrayMap
 *  it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap
 *  it.unimi.dsi.fastutil.chars.Char2ObjectFunction
 *  it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap
 *  it.unimi.dsi.fastutil.objects.Object2ObjectFunction
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  it.unimi.dsi.fastutil.objects.ObjectList
 *  it.unimi.dsi.fastutil.objects.ObjectListIterator
 *  it.unimi.dsi.fastutil.objects.ObjectSet
 *  net.minecraft.class_1041
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_287$class_7433
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_757
 *  org.jetbrains.annotations.Contract
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import com.google.common.base.Preconditions;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.font.Glyph;
import dev.recollect.hana.mod.gui.nullpoint.font.GlyphMap;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import dev.recollect.hana.xibao.SnowAnimation;
import it.unimi.dsi.fastutil.chars.Char2IntArrayMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectFunction;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.awt.Color;
import java.awt.Font;
import java.io.Closeable;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.class_1041;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_757;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class FontRenderer
implements Closeable {
    private int previousGameScale;
    private static final Object2ObjectArrayMap<class_2960, ObjectList<DrawEntry>> GLYPH_PAGE_CACHE;
    private static final int BLOCK_SIZE = 256;
    private final float originalSize;
    private static final Random RND;
    private static final char RND_END = 'z';
    private Font[] fonts;
    private int scaleMul;
    private static final char RND_START = 'a';
    private final ObjectList<GlyphMap> maps;
    private final Char2ObjectArrayMap<Glyph> allGlyphs;
    private static final Char2IntArrayMap colorCodes;

    public static int getGuiScale() {
        return (int)Wrapper.mc.method_22683().method_4495();
    }

    static {
        colorCodes = new Char2IntArrayMap(){
            {
                1 a;
                1 v0 = a;
                v0.put('0', 0);
                a.put('1', 170);
                a.put('2', 43520);
                a.put('3', 43690);
                a.put('4', 11141120);
                a.put('5', 11141290);
                a.put('6', 16755200);
                a.put('7', 11184810);
                a.put('8', 5592405);
                a.put('9', 5592575);
                a.put('A', 5635925);
                a.put('B', 5636095);
                a.put('C', 16733525);
                a.put('D', 16733695);
                a.put('E', 16777045);
                a.put('F', 16777215);
            }
        };
        GLYPH_PAGE_CACHE = new Object2ObjectArrayMap();
        RND = new Random();
    }

    @Override
    public void close() {
        FontRenderer a;
        FontRenderer fontRenderer = a;
        a = fontRenderer.maps.iterator();
        Object object = a;
        while (object.hasNext()) {
            ((GlyphMap)a.next()).destroy();
            object = a;
        }
        FontRenderer fontRenderer2 = fontRenderer;
        fontRenderer2.maps.clear();
        fontRenderer2.allGlyphs.clear();
    }

    @Contract(value="-> new", pure=true)
    @NotNull
    public static class_2960 randomIdentifier() {
        return new class_2960(SnowAnimation.ALLATORIxDEMO("Q\u0006@\u0011"), "temp/" + FontRenderer.randomString(32));
    }

    /*
     * WARNING - void declaration
     */
    public void drawCenteredString(class_4587 class_45872, String string, float f, float f2, float f3, float f4, float f5, float f6) {
        void a;
        void a2;
        void a3;
        void a4;
        FontRenderer a5;
        void a6;
        void a7;
        void a8;
        void a9;
        float f7 = f6;
        FontRenderer fontRenderer = a5 = this;
        void v1 = a9;
        fontRenderer.drawString((class_4587)a4, (String)v1, (float)(a8 - fontRenderer.getStringWidth((String)v1) / 2.0f), (float)a3, (float)a2, (float)a7, (float)a6, (float)a);
    }

    private /* synthetic */ void init(Font[] a, float a2) {
        FontRenderer a3;
        FontRenderer fontRenderer = a3;
        fontRenderer.scaleMul = fontRenderer.previousGameScale = FontRenderer.getGuiScale();
        fontRenderer.fonts = new Font[a.length];
        int n = a3 = 0;
        while (n < a.length) {
            int n2 = a3++;
            fontRenderer.fonts[n2] = a[n2].deriveFont(a2 * (float)fontRenderer.scaleMul);
            n = a3;
        }
    }

    @Contract(value="_ -> new", pure=true)
    public static int[] RGBIntToRGB(int a) {
        int n = a;
        int n2 = n >> 16 & 255;
        int n3 = n >> 8 & 255;
        a = n & 255;
        int[] arrn = new int[3];
        arrn[0] = n2;
        arrn[1] = n3;
        arrn[2] = a;
        return arrn;
    }

    /*
     * WARNING - void declaration
     */
    public void drawString(@NotNull class_4587 class_45872, @NotNull String string, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        void x22;
        void stack;
        void s2;
        float g;
        ObjectIterator objectIterator;
        float r;
        float b;
        int n;
        void y22;
        Object object;
        FontRenderer fontRenderer = this;
        fontRenderer.sizeCheck();
        float this22 = r;
        float f7 = g;
        float f8 = b;
        void v0 = stack;
        stack.method_22903();
        v0.method_46416((float)x22, (float)y22, 0.0f);
        v0.method_22905(1.0f / (float)fontRenderer.scaleMul, 1.0f / (float)fontRenderer.scaleMul, 1.0f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        RenderSystem.setShader(class_757::method_34543);
        class_287 x22 = class_289.method_1348().method_1349();
        Matrix4f y22 = stack.method_23760().method_23761();
        char[] arrc = s2.toCharArray();
        float f9 = 0.0f;
        float f10 = 0.0f;
        boolean bl2 = false;
        int n2 = 0;
        int n3 = n = 0;
        while (n3 < arrc.length) {
            char c = arrc[n];
            if (bl2) {
                void a2;
                bl2 = false;
                char c2 = Character.toUpperCase(c);
                if (colorCodes.containsKey(c2) && a2 == false) {
                    int n4 = colorCodes.get(c2);
                    object = FontRenderer.RGBIntToRGB(n4);
                    this22 = (float)object[0] / 255.0f;
                    f7 = (float)object[1] / 255.0f;
                    f8 = (float)object[2] / 255.0f;
                } else if (c2 == 'R') {
                    this22 = r;
                    f7 = g;
                    f8 = b;
                }
            } else if (c == '\u00a7') {
                bl2 = true;
            } else if (c == '\n') {
                f10 += fontRenderer.getStringHeight(s2.substring(n2, n)) * (float)fontRenderer.scaleMul;
                f9 = 0.0f;
                n2 = n + 1;
            } else {
                Glyph glyph = fontRenderer.locateGlyph1(c);
                if (glyph.value() != ' ') {
                    class_2960 class_29602 = glyph.owner().bindToTexture;
                    object = new DrawEntry(f9, f10, this22, f7, f8, glyph);
                    ((ObjectList)GLYPH_PAGE_CACHE.computeIfAbsent((Object)class_29602, a -> new ObjectArrayList())).add(object);
                }
                f9 += (float)glyph.width();
            }
            n3 = ++n;
        }
        ObjectIterator objectIterator2 = objectIterator = GLYPH_PAGE_CACHE.keySet().iterator();
        while (objectIterator2.hasNext()) {
            class_2960 class_29603 = (class_2960)objectIterator.next();
            RenderSystem.setShaderTexture((int)0, (class_2960)class_29603);
            List list = (List)GLYPH_PAGE_CACHE.get((Object)class_29603);
            x22.method_1328(class_293.class_5596.field_27382, class_290.field_1575);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                void a3;
                Iterator iterator2;
                object = (DrawEntry)iterator2.next();
                float s2 = object.atX;
                r = object.atY;
                g = object.r;
                b = object.g;
                float a2 = object.b;
                Glyph this22 = object.toDraw;
                GlyphMap glyphMap = this22.owner();
                f8 = this22.width();
                float f11 = this22.height();
                f9 = (float)this22.u() / (float)glyphMap.width;
                f10 = (float)this22.v() / (float)glyphMap.height;
                float f12 = (float)(this22.u() + this22.width()) / (float)glyphMap.width;
                this22 = (float)(this22.v() + this22.height()) / (float)glyphMap.height;
                iterator = iterator2;
                class_287 class_2872 = x22;
                Matrix4f matrix4f = y22;
                float f13 = s2;
                x22.method_22918(y22, f13 + 0.0f, r + f11, 0.0f).method_22913(f9, this22).method_22915(g, b, a2, (float)a3).method_1344();
                x22.method_22918(matrix4f, f13 + f8, r + f11, 0.0f).method_22913(f12, this22).method_22915(g, b, a2, (float)a3).method_1344();
                class_2872.method_22918(matrix4f, s2 + f8, r + 0.0f, 0.0f).method_22913(f12, f10).method_22915(g, b, a2, (float)a3).method_1344();
                class_2872.method_22918(y22, s2 + 0.0f, r + 0.0f, 0.0f).method_22913(f9, f10).method_22915(g, b, a2, (float)a3).method_1344();
            }
            class_286.method_43433((class_287.class_7433)x22.method_1326());
            objectIterator2 = objectIterator;
        }
        stack.method_22909();
        GLYPH_PAGE_CACHE.clear();
    }

    public float getStringWidth(String a) {
        int n;
        FontRenderer a22;
        FontRenderer fontRenderer = a22;
        a = FontRenderer.stripControlCodes((String)a).toCharArray();
        float a22 = 0.0f;
        float f = 0.0f;
        int n2 = a.length;
        int n3 = n = 0;
        while (n3 < n2) {
            char c = a[n];
            if (c == '\n') {
                f = Math.max(a22, f);
                a22 = 0.0f;
            } else {
                Glyph glyph = fontRenderer.locateGlyph1(c);
                float f2 = glyph == null ? 1.0f : (float)glyph.width();
                a22 += f2 / (float)fontRenderer.scaleMul;
            }
            n3 = ++n;
        }
        return Math.max(a22, f);
    }

    private static /* synthetic */ String randomString(int a2) {
        return IntStream.range(0, a2).mapToObj(a -> String.valueOf((char)RND.nextInt(97, 123))).collect(Collectors.joining());
    }

    /*
     * WARNING - void declaration
     */
    public void drawGradientString(@NotNull class_4587 class_45872, @NotNull String string, float f, float f2) {
        Object object;
        void a22;
        Glyph glyph;
        Object object2;
        int n;
        ObjectIterator objectIterator;
        void x22;
        void stack;
        void s2;
        FontRenderer fontRenderer = this;
        fontRenderer.sizeCheck();
        void v0 = stack;
        v0.method_22903();
        v0.method_46416((float)x22, (float)a22, 0.0f);
        v0.method_22905(1.0f / (float)fontRenderer.scaleMul, 1.0f / (float)fontRenderer.scaleMul, 1.0f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        RenderSystem.setShader(class_757::method_34543);
        class_287 x22 = class_289.method_1348().method_1349();
        Matrix4f a22 = stack.method_23760().method_23761();
        char[] arrc = s2.toCharArray();
        float f3 = 0.0f;
        float f4 = 0.0f;
        int n2 = 0;
        float f5 = 1.0f;
        int n3 = n = 0;
        while (n3 < arrc.length) {
            char c = arrc[n];
            object2 = Hana.GUI.getColor();
            f5 = (float)((Color)object2).getAlpha() / 255.0f;
            if (c == '\n') {
                f4 += fontRenderer.getStringHeight(s2.substring(n2, n)) * (float)fontRenderer.scaleMul;
                f3 = 0.0f;
                n2 = n + 1;
            } else {
                glyph = fontRenderer.locateGlyph1(c);
                if (glyph.value() != ' ') {
                    object = glyph.owner().bindToTexture;
                    DrawEntry drawEntry = new DrawEntry(f3, f4, (float)((Color)object2).getRed() / 255.0f, (float)((Color)object2).getGreen() / 255.0f, (float)((Color)object2).getBlue() / 255.0f, glyph);
                    ((ObjectList)GLYPH_PAGE_CACHE.computeIfAbsent(object, a -> new ObjectArrayList())).add((Object)drawEntry);
                }
                f3 += (float)glyph.width();
            }
            n3 = ++n;
        }
        ObjectIterator objectIterator2 = objectIterator = GLYPH_PAGE_CACHE.keySet().iterator();
        while (objectIterator2.hasNext()) {
            class_2960 class_29602 = (class_2960)objectIterator.next();
            RenderSystem.setShaderTexture((int)0, (class_2960)class_29602);
            object2 = (List)GLYPH_PAGE_CACHE.get((Object)class_29602);
            x22.method_1328(class_293.class_5596.field_27382, class_290.field_1575);
            Object object3 = object2.iterator();
            while (object3.hasNext()) {
                object = (DrawEntry)glyph.next();
                float f6 = object.atX;
                float s2 = object.atY;
                float f7 = object.r;
                f3 = object.g;
                f4 = object.b;
                Glyph glyph2 = object.toDraw;
                GlyphMap glyphMap = glyph2.owner();
                float f8 = glyph2.width();
                float f9 = glyph2.height();
                float f10 = (float)glyph2.u() / (float)glyphMap.width;
                float f11 = (float)glyph2.v() / (float)glyphMap.height;
                float f12 = (float)(glyph2.u() + glyph2.width()) / (float)glyphMap.width;
                float f13 = (float)(glyph2.v() + glyph2.height()) / (float)glyphMap.height;
                object3 = glyph;
                class_287 class_2872 = x22;
                Matrix4f matrix4f = a22;
                float f14 = f6;
                x22.method_22918(a22, f14 + 0.0f, s2 + f9, 0.0f).method_22913(f10, f13).method_22915(f7, f3, f4, f5).method_1344();
                x22.method_22918(matrix4f, f14 + f8, s2 + f9, 0.0f).method_22913(f12, f13).method_22915(f7, f3, f4, f5).method_1344();
                class_2872.method_22918(matrix4f, f6 + f8, s2 + 0.0f, 0.0f).method_22913(f12, f11).method_22915(f7, f3, f4, f5).method_1344();
                class_2872.method_22918(a22, f6 + 0.0f, s2 + 0.0f, 0.0f).method_22913(f10, f11).method_22915(f7, f3, f4, f5).method_1344();
            }
            class_286.method_43433((class_287.class_7433)x22.method_1326());
            objectIterator2 = objectIterator;
        }
        stack.method_22909();
        GLYPH_PAGE_CACHE.clear();
    }

    public float getStringHeight(String a) {
        int n;
        FontRenderer a22;
        FontRenderer fontRenderer = a22;
        if ((a = FontRenderer.stripControlCodes((String)a).toCharArray()).length == 0) {
            char[] arrc = new char[1];
            arrc[0] = 32;
            a = arrc;
        }
        float a22 = 0.0f;
        float f = 0.0f;
        int n2 = a.length;
        int n3 = n = 0;
        while (n3 < n2) {
            char c = a[n];
            if (c == '\n') {
                if (a22 == 0.0f) {
                    a22 = (float)fontRenderer.locateGlyph1(' ').height() / (float)fontRenderer.scaleMul;
                }
                f += a22;
                a22 = 0.0f;
            } else {
                a22 = Math.max((float)fontRenderer.locateGlyph1(c).height() / (float)fontRenderer.scaleMul, a22);
            }
            n3 = ++n;
        }
        return a22 + f;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    private /* synthetic */ GlyphMap generateMap(char c, char c2) {
        void a;
        char a2 = c;
        FontRenderer a3 = this;
        GlyphMap glyphMap = a2 = new GlyphMap(a2, (char)a, a3.fonts, FontRenderer.randomIdentifier());
        a3.maps.add((Object)glyphMap);
        return glyphMap;
    }

    private static /* synthetic */ int floorNearestMulN(int a) {
        return 256 * (int)Math.floor((double)a / 256.0);
    }

    private /* synthetic */ void sizeCheck() {
        FontRenderer a;
        if (FontRenderer.getGuiScale() != a.previousGameScale) {
            FontRenderer fontRenderer = a;
            fontRenderer.close();
            FontRenderer fontRenderer2 = a;
            fontRenderer2.init(fontRenderer.fonts, fontRenderer2.originalSize);
        }
    }

    /*
     * WARNING - void declaration
     */
    public FontRenderer(Font[] arrfont, float f) {
        void a;
        FontRenderer a2;
        float a3 = f;
        FontRenderer fontRenderer = a2 = this;
        FontRenderer fontRenderer2 = a2;
        a2.maps = new ObjectArrayList();
        fontRenderer2.allGlyphs = new Char2ObjectArrayMap();
        fontRenderer.scaleMul = 0;
        fontRenderer.previousGameScale = -1;
        Preconditions.checkArgument((boolean)(((void)a).length > 0), (Object)UserInfo.ALLATORIxDEMO("5?\u001b\u00131B%\u0003-\u00006\u0018uZPe"));
        a2.originalSize = a3;
        a2.init((Font[])a, a3);
    }

    private /* synthetic */ Glyph locateGlyph1(char c) {
        char a2 = c;
        FontRenderer a3 = this;
        return (Glyph)a3.allGlyphs.computeIfAbsent(a2, a -> {
            GlyphMap glyphMap2;
            FontRenderer a22;
            FontRenderer fontRenderer = a22;
            for (GlyphMap glyphMap2 : fontRenderer.maps) {
                if (!glyphMap2.contains(a)) continue;
                return glyphMap2.getGlyph(a);
            }
            int a22 = FontRenderer.floorNearestMulN(a);
            glyphMap2 = fontRenderer.generateMap((char)a22, (char)(a22 + 256));
            return glyphMap2.getGlyph(a);
        });
    }

    /*
     * WARNING - void declaration
     */
    public void drawString(@NotNull class_4587 class_45872, @NotNull String string, float f, float f2, float f3, float f4, float f5, float f6) {
        void y;
        void x;
        void g;
        void r;
        void stack;
        FontRenderer a;
        void s;
        void b;
        float f7 = f6;
        FontRenderer fontRenderer = a = this;
        fontRenderer.drawString((class_4587)stack, (String)s, (float)(x + 1.0f), (float)(y + 1.0f), 0.0f, 0.0f, 0.0f, (float)this, true);
        fontRenderer.drawString((class_4587)stack, (String)s, (float)x, (float)y, (float)r, (float)g, (float)b, (float)this, false);
    }

    @NotNull
    public static String stripControlCodes(@NotNull String text) {
        String string = text;
        char[] arrc = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int n = text = 0;
        while (n < arrc.length) {
            char c = arrc[text];
            if (c == '\u00a7') {
                ++text;
            } else {
                stringBuilder.append(c);
            }
            n = ++text;
        }
        return stringBuilder.toString();
    }

    static final class DrawEntry
    extends Record {
        private final Glyph toDraw;
        private final float b;
        private final float g;
        private final float r;
        private final float atY;
        private final float atX;

        @Override
        public final String toString() {
            DrawEntry a;
            return ObjectMethods.bootstrap(new MethodHandle[]{DrawEntry.class, "atX;atY;r;g;b;toDraw", }