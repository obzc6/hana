/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import net.minecraft.class_4587;

public interface FontAdapter {
    public void drawString(class_4587 var1, String var2, double var3, double var5, int var7);

    public float getMarginHeight();

    public void drawCenteredString(class_4587 var1, String var2, double var3, double var5, float var7, float var8, float var9, float var10);

    public void drawGradientString(class_4587 var1, String var2, float var3, float var4, int var5, boolean var6);

    public String trimStringToWidth(String var1, double var2, boolean var4);

    public void drawString(class_4587 var1, String var2, float var3, float var4, float var5, float var6, float var7, float var8);

    public float getWidth(String var1);

    public float getFontHeight();

    public void drawCenteredString(class_4587 var1, String var2, double var3, double var5, int var7);

    public float getFontHeight(String var1);

    public String trimStringToWidth(String var1, double var2);

    public void drawString(class_4587 var1, String var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9);

    public void drawString(class_4587 var1, String var2, float var3, float var4, int var5);

    public void drawString(class_4587 var1, String var2, float var3, float var4, int var5, boolean var6);
}
