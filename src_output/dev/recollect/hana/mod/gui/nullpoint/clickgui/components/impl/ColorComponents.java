/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class ColorComponents
extends Component {
    private float spos;
    private float bpos;
    private boolean sbfocused;
    private Color prevColor;
    private float hue;
    public double currentWidth;
    private float hpos;
    private double lastMouseY;
    private float brightness;
    private final ColorSetting colorSetting;
    boolean popped;
    boolean clicked;
    private double lastMouseX;
    private boolean hfocused;
    boolean hover;
    private boolean afocused;
    private int alpha;
    private float saturation;
    private float apos;
    private final Timer clickTimer;
    private boolean firstInit;
    boolean rainbowHovered;

    public ColorSetting getColorSetting() {
        ColorComponents a;
        return a.colorSetting;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        Color a5;
        Color a2;
        void a3;
        int a222 = n;
        ColorComponents a4 = this;
        a4.currentOffset = ColorComponents.animate(a4.currentOffset, a222);
        if (a3 != false && Math.abs(a4.currentOffset - (double)a222) <= 0.5) {
            a4.currentWidth = 0.0;
            return false;
        }
        ColorComponents colorComponents = a4;
        a222 = colorComponents.parent.getX();
        int a322 = (int)((double)colorComponents.parent.getY() + a4.currentOffset - 2.0);
        int n2 = colorComponents.parent.getWidth();
        class_4587 class_45872 = a5.method_51448();
        Render2DUtil.drawRect(class_45872, (float)a222 + 1.0f, (float)a322 + 1.0f, (float)n2 - 2.0f, (float)a4.defaultHeight - 1.0f, a4.hover ? UIModule.INSTANCE.shColor.getValue() : UIModule.INSTANCE.sbgColor.getValue());
        if (a4.colorSetting.injectBoolean) {
            a4.currentWidth = ColorComponents.animate(a4.currentWidth, a4.colorSetting.booleanValue ? (double)n2 - 2.0 : 0.0, UIModule.INSTANCE.booleanSpeed.getValue());
            Render2DUtil.drawRect(class_45872, (float)a222 + 1.0f, (float)a322 + 1.0f, (float)a4.currentWidth, (float)a4.defaultHeight - 1.0f, a4.hover ? UIModule.INSTANCE.mainHover.getValue() : a2);
        }
        int n3 = a222;
        TextUtil.drawString((class_332)a5, a4.colorSetting.getName(), (double)(n3 + 4), (double)a322 + a4.getTextOffsetY(), new Color(-1).getRGB());
        Render2DUtil.drawRound(class_45872, n3 + n2 - 16, (float)((double)a322 + a4.getTextOffsetY()), 12.0f, 8.0f, 1.0f, ColorUtil.injectAlpha(a4.getColorSetting().getValue(), 255));
        TextUtil.drawCustomSmallText((class_332)a5, ColorUtil.ALLATORIxDEMO("D'i;q,r"), a222 + n2 - 79, a322 + 6, a4.getColorSetting().isRainbow ? a2.getRGB() : (a4.rainbowHovered ? new Color(-1543503873, true).getRGB() : Color.WHITE.getRGB()));
        if (a3 != false) {
            return true;
        }
        if (!a4.popped) {
            return true;
        }
        double d = a222;
        double d2 = a322 + a4.defaultHeight + 1;
        double d3 = n2 - 15;
        ColorComponents colorComponents2 = a4;
        double d4 = colorComponents2.defaultHeight - 32 + 60;
        if (colorComponents2.prevColor != a4.getColorSetting().getValue()) {
            ColorComponents colorComponents3 = a4;
            colorComponents3.updatePos();
            colorComponents3.prevColor = colorComponents3.getColorSetting().getValue();
        }
        if (a4.firstInit) {
            ColorComponents colorComponents4 = a4;
            double d5 = d2;
            ColorComponents colorComponents5 = a4;
            double d6 = d3;
            colorComponents5.spos = (float)(d + d3 - (d6 - d6 * (double)a4.saturation));
            double d7 = d4;
            colorComponents5.bpos = (float)(d2 + (d7 - d7 * (double)a4.brightness));
            a4.hpos = (float)(d5 + (d4 - 3.0 + (d4 - 3.0) * (double)a4.hue));
            colorComponents4.apos = (float)(d5 + (d4 - 3.0 - (d4 - 3.0) * (double)((float)a4.alpha / 255.0f)));
            colorComponents4.firstInit = false;
        }
        ColorComponents colorComponents6 = a4;
        double d8 = d3;
        colorComponents6.spos = (float)ColorComponents.animate(colorComponents6.spos, (float)(d + d3 - (d8 - d8 * (double)a4.saturation)), 0.6000000238418579);
        double d9 = d4;
        colorComponents6.bpos = (float)ColorComponents.animate(colorComponents6.bpos, (float)(d2 + (d9 - d9 * (double)a4.brightness)), 0.6000000238418579);
        colorComponents6.hpos = (float)ColorComponents.animate(colorComponents6.hpos, (float)(d2 + (d4 - 3.0 + (d4 - 3.0) * (double)a4.hue)), 0.6000000238418579);
        colorComponents6.apos = (float)ColorComponents.animate(colorComponents6.apos, (float)(d2 + (d4 - 3.0 - (d4 - 3.0) * (double)((float)a4.alpha / 255.0f))), 0.6000000238418579);
        Color a222 = Color.getHSBColor(colorComponents6.hue, 0.0f, 1.0f);
        a5 = Color.getHSBColor(colorComponents6.hue, 1.0f, 1.0f);
        Color a322 = new Color(0, 0, 0, 0);
        a2 = new Color(0, 0, 0);
        class_4587 class_45873 = class_45872;
        Render2DUtil.horizontalGradient(class_45873, (float)d + 2.0f, (float)d2, (float)(d + d3), (float)(d2 + d4), a222, a5);
        Render2DUtil.verticalGradient(class_45873, (float)(d + 2.0), (float)d2, (float)(d + d3), (float)(d2 + d4), a322, a2);
        float f2 = a222 = 1.0f;
        while ((double)f2 < d4 - 2.0) {
            float a5 = (float)(1.0 / (d4 / (double)a222));
            Render2DUtil.drawRect(class_45872, (float)(d + d3 + 4.0), (float)(d2 + (double)a222), 4.0f, 1.0f, Color.getHSBColor(a5, 1.0f, 1.0f));
            f2 = a222 + 1.0f;
        }
        class_4587 class_45874 = class_45872;
        double d10 = d;
        Render2DUtil.verticalGradient(class_45872, (float)(d + d3 + 9.0), (float)(d2 + 0.800000011920929), (float)(d + d3 + 12.5), (float)(d2 + d4 - 2.0), new Color(a4.getColorSetting().getValue().getRed(), a4.getColorSetting().getValue().getGreen(), a4.getColorSetting().getValue().getBlue(), 255), new Color(0, 0, 0, 0));
        Render2DUtil.drawRect(class_45874, (float)(d10 + d3 + 3.0), a4.hpos + 0.5f, 5.0f, 1.0f, Color.WHITE);
        ColorComponents colorComponents7 = a4;
        Render2DUtil.drawRect(class_45874, (float)(d10 + d3 + 8.0), colorComponents7.apos + 0.5f, 5.0f, 1.0f, Color.WHITE);
        Render2DUtil.drawRound(class_45874, colorComponents7.spos - 1.5f, a4.bpos - 1.5f, 3.0f, 3.0f, 1.5f, new Color(-1));
        return true;
    }

    private /* synthetic */ void updatePos() {
        float[] arrf;
        float[] a;
        float[] arrf2 = arrf = a;
        a = Color.RGBtoHSB(arrf2.getColorSetting().getValue().getRed(), arrf.getColorSetting().getValue().getGreen(), arrf.getColorSetting().getValue().getBlue(), null);
        arrf2.hue = -1.0f + a[0];
        arrf.saturation = a[1];
        arrf2.brightness = a[2];
        arrf2.alpha = arrf2.getColorSetting().getValue().getAlpha();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void update(int var1_3, double var2_5, double var4_6, boolean var6_7) {
        block15 : {
            block14 : {
                a = var1_3;
                v0 = a = this;
                a = v0.parent.getX();
                v1 = a;
                a = (int)((double)v0.parent.getY() + v1.currentOffset) - 2;
                var7_8 = v1.parent.getWidth();
                var8_9 = a + 3;
                var10_10 = a + a.defaultHeight;
                var12_11 = var7_8 - 19;
                var14_12 = v0.getHeight() - 17;
                v0.rainbowHovered = Render2DUtil.isHovered((double)a, (double)a, a + var7_8 - 81, a + 4, 40.0, 10.0);
                v0.hover = Render2DUtil.isHovered((double)a, (double)a, (float)a + 1.0f, (float)a + 1.0f, (float)var7_8 - 2.0f, a.defaultHeight);
                if (v0.hover && GuiManager.currentGrabbed == null && a.isVisible() && ClickGuiScreen.rightClicked) {
                    ClickGuiScreen.rightClicked = false;
                    a.popped = a.popped == false;
                    a = a.popped ? 1 : 0;
                }
                if (a.popped) {
                    v2 = a;
                    v2.setHeight(45 + v2.defaultHeight);
                } else {
                    v3 = a;
                    v3.setHeight(v3.defaultHeight);
                }
                if (!ClickGuiScreen.clicked && !ClickGuiScreen.hoverClicked || !a.isVisible()) break block14;
                if (a.clicked) ** GOTO lbl62
                if (Render2DUtil.isHovered((double)a, (double)a, var8_9 + var12_11 + 9.0, var10_10, 4.0, var14_12)) {
                    a.afocused = true;
                    ClickGuiScreen.hoverClicked = true;
                    ClickGuiScreen.clicked = false;
                }
                if (!Render2DUtil.isHovered((double)a, (double)a, var8_9 + var12_11 + 4.0, var10_10, 4.0, var14_12)) ** GOTO lbl49
                a.hfocused = true;
                ClickGuiScreen.hoverClicked = true;
                ClickGuiScreen.clicked = false;
                v4 = a;
                if (a.colorSetting.isRainbow) {
                    v4.colorSetting.setRainbow(false);
                    v5 = a;
                    v6 = a;
                    v6.lastMouseX = 0.0;
                    v6.lastMouseY = 0.0;
                } else {
                    if (!v4.clickTimer.passedMs(400L) && a == a.lastMouseX && a == a.lastMouseY) {
                        v7 = a;
                        v7.colorSetting.setRainbow(v7.colorSetting.isRainbow == false);
                    }
                    a.clickTimer.reset();
                    v8 = a;
                    v8.lastMouseX = a;
                    v8.lastMouseY = a;
lbl49: // 2 sources:
                    v5 = a;
                }
                if (Render2DUtil.isHovered((double)v5, (double)a, var8_9, var10_10, var12_11, var14_12)) {
                    a.sbfocused = true;
                    ClickGuiScreen.hoverClicked = true;
                    ClickGuiScreen.clicked = false;
                }
                if (GuiManager.currentGrabbed != null || !a.isVisible()) ** GOTO lbl62
                if (a.rainbowHovered) {
                    a.getColorSetting().setRainbow(a.getColorSetting().isRainbow == false);
                    v9 = a;
                } else {
                    if (a.hover && a.getColorSetting().injectBoolean) {
                        a.getColorSetting().booleanValue = a.getColorSetting().booleanValue == false;
                        ClickGuiScreen.clicked = false;
                    }
lbl62: // 5 sources:
                    v9 = a;
                }
                v9.clicked = true;
                v10 = a;
                break block15;
            }
            v10 = a;
            v11 = a;
            v12 = a;
            v12.clicked = false;
            v12.sbfocused = false;
            v11.afocused = false;
            v11.hfocused = false;
        }
        if (!v10.popped) {
            return;
        }
        if (GuiManager.currentGrabbed != null) return;
        if (a.isVisible() == false) return;
        v13 = a;
        v14 = a;
        a = Color.getHSBColor(v13.hue, v13.saturation, v14.brightness);
        if (v14.sbfocused) {
            a.saturation = (float)((double)MathUtil.clamp((float)(a - var8_9), 0.0f, (float)var12_11) / var12_11);
            a.brightness = (float)((var14_12 - (double)MathUtil.clamp((float)(a - var10_10), 0.0f, (float)var14_12)) / var14_12);
            v15 = a;
            a = Color.getHSBColor(a.hue, a.saturation, v15.brightness);
            v16 = a;
            v15.setColor(new Color(a.getRed(), a.getGreen(), a.getBlue(), a.alpha));
        }
        if (a.hfocused) {
            v17 = var14_12;
            a.hue = (float)(-((v17 - (double)MathUtil.clamp((float)(a - var10_10), 0.0f, (float)v17)) / var14_12));
            v18 = a;
            a = Color.getHSBColor(a.hue, a.saturation, v18.brightness);
            v18.setColor(new Color(a.getRed(), a.getGreen(), a.getBlue(), a.alpha));
        }
        if (a.afocused == false) return;
        v19 = var14_12;
        a.alpha = (int)((v19 - (double)MathUtil.clamp((float)(a - var10_10), 0.0f, (float)v19)) / var14_12 * 255.0);
        a.setColor(new Color(a.getRed(), a.getGreen(), a.getBlue(), a.alpha));
    }

    @Override
    public boolean isVisible() {
        ColorComponents a;
        if (a.colorSetting.visibility != null) {
            return a.colorSetting.visibility.test(null);
        }
        return true;
    }

    private /* synthetic */ void setColor(Color color) {
        Color a = color;
        ColorComponents a2 = this;
        a2.getColorSetting().setValue(a.getRGB());
        a2.prevColor = a;
    }

    /*
     * WARNING - void declaration
     */
    public ColorComponents(ClickGuiTab clickGuiTab, ColorSetting colorSetting) {
        ColorComponents a;
        void a2;
        ColorSetting a3 = colorSetting;
        ColorComponents colorComponents = a = this;
        ColorComponents colorComponents2 = a;
        a.rainbowHovered = false;
        ColorComponents colorComponents3 = a;
        a.clickTimer = new Timer();
        colorComponents2.clicked = false;
        colorComponents2.popped = false;
        colorComponents.hover = false;
        colorComponents.currentWidth = 0.0;
        a.parent = a2;
        a.colorSetting = a3;
        a.prevColor = a.getColorSetting().getValue();
        a.updatePos();
        a.firstInit = true;
    }
}
