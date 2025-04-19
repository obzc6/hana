/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderer;
import dev.recollect.hana.xibao.Snow;
import java.awt.Font;
import net.minecraft.class_4587;

public class RendererFontAdapter
implements FontAdapter {
    final FontRenderer fontRenderer;
    final float si;

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawString(class_4587 class_45872, String string, float f, float f2, float f3, float f4, float f5, float f6) {
        void a;
        void a2;
        void a3;
        void a4;
        float a5;
        void a6;
        void a7;
        void a8;
        float f7 = f6;
        RendererFontAdapter a9 = this;
        a5 = (float)((int)(a5 * 255.0f)) / 255.0f;
        a9.fontRenderer.drawString((class_4587)a4, (String)a3, (float)a8, (float)(a7 - 3.0f), (float)a2, (float)a, (float)a6, a5);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawCenteredString(class_4587 class_45872, String string, double d, double d2, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        int a222;
        int n2 = n;
        RendererFontAdapter a5 = this;
        if ((a222 & -67108864) == 0) {
            a222 |= -16777216;
        }
        float f = (float)(a222 >> 24 & 255) / 255.0f;
        float f2 = (float)(a222 >> 16 & 255) / 255.0f;
        float f3 = (float)(a222 >> 8 & 255) / 255.0f;
        float a222 = (float)(a222 & 255) / 255.0f;
        a5.drawCenteredString((class_4587)a2, (String)a4, (double)a, (double)a3, f2, f3, a222, f);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawString(class_4587 class_45872, String string, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        void a8;
        float f7 = f6;
        RendererFontAdapter a9 = this;
        a9.drawString((class_4587)a4, (String)a3, (float)a8, (float)a7, (float)a2, (float)a, (float)a5, (float)a6);
    }

    public float getSize() {
        RendererFontAdapter a;
        return a.si;
    }

    @Override
    public float getFontHeight(String string) {
        String a = string;
        RendererFontAdapter a2 = this;
        return a2.getFontHeight();
    }

    @Override
    public float getWidth(String string) {
        String a = string;
        RendererFontAdapter a2 = this;
        return a2.fontRenderer.getStringWidth(a);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawString(class_4587 class_45872, String string, float f, float f2, int n) {
        void a;
        void a2;
        void a3;
        int a222;
        void a4;
        int n2 = n;
        RendererFontAdapter a5 = this;
        if ((a222 & -67108864) == 0) {
            a222 |= -16777216;
        }
        float f3 = (float)(a222 >> 24 & 255) / 255.0f;
        float f4 = (float)(a222 >> 16 & 255) / 255.0f;
        float f5 = (float)(a222 >> 8 & 255) / 255.0f;
        float a222 = (float)(a222 & 255) / 255.0f;
        a5.drawString((class_4587)a2, (String)a3, (float)a, (float)a4, f4, f5, a222, f3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawCenteredString(class_4587 class_45872, String string, double d, double d2, float f, float f2, float f3, float f4) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        void a8;
        float f5 = f4;
        RendererFontAdapter a9 = this;
        a9.fontRenderer.drawCenteredString((class_4587)a3, (String)a2, (float)a7, (float)a, (float)a8, (float)a5, (float)a4, (float)a6);
    }

    public FontRenderer getFontRenderer() {
        RendererFontAdapter a;
        return a.fontRenderer;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public String trimStringToWidth(String string, double d, boolean bl) {
        void a;
        String a2 = string;
        RendererFontAdapter a3 = this;
        return a3.trimStringToWidth(a2, (double)a);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public String trimStringToWidth(String string, double d) {
        int n;
        char[] a;
        RendererFontAdapter rendererFontAdapter = this;
        StringBuilder a2 = new StringBuilder();
        a = a.toCharArray();
        int n2 = a.length;
        int n3 = n = 0;
        while (n3 < n2) {
            void a3;
            char c = a[n];
            if ((double)rendererFontAdapter.getWidth(a2.toString() + c) >= a3) {
                return a2.toString();
            }
            a2.append(c);
            n3 = ++n;
        }
        return a2.toString();
    }

    /*
     * WARNING - void declaration
     */
    public RendererFontAdapter(Font font, float f) {
        void a;
        float a2 = f;
        RendererFontAdapter a3 = this;
        RendererFontAdapter rendererFontAdapter = a3;
        Font[] arrfont = new Font[1];
        arrfont[0] = a;
        rendererFontAdapter.fontRenderer = new FontRenderer(arrfont, a2);
        a3.si = a2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawGradientString(class_4587 class_45872, String string, float f, float f2, int n, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        float f3 = f2;
        RendererFontAdapter a5 = this;
        a5.fontRenderer.drawGradientString((class_4587)a2, (String)a, (float)a4, (float)(a3 - 3.0f));
    }

    @Override
    public float getFontHeight() {
        RendererFontAdapter a;
        return a.fontRenderer.getStringHeight(Snow.ALLATORIxDEMO("ckp|rza<#)"));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawString(class_4587 class_45872, String string, float f, float f2, int n, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n2 = n;
        RendererFontAdapter a6 = this;
        a6.drawString((class_4587)a2, (String)a, (float)a5, (float)a4, (int)a3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void drawString(class_4587 class_45872, String string, double d, double d2, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n2 = n;
        RendererFontAdapter a6 = this;
        a6.drawString((class_4587)a3, (String)a2, (float)a5, (float)a, (int)a4);
    }

    @Override
    public float getMarginHeight() {
        RendererFontAdapter a;
        return a.getFontHeight();
    }
}
