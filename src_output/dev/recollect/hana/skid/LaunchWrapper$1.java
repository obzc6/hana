/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.skid;

import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.skid.LaunchWrapper;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

static class LaunchWrapper.1
extends JPanel {
    private /* synthetic */ void drawAuthenticationText(Graphics2D graphics2D) {
        Object a22 = graphics2D;
        LaunchWrapper.1 a = this;
        Object object = a22;
        ((Graphics)object).setFont(new Font(GameInfo.ALLATORIxDEMO("Rkyz-Fyn|7\u001b. 0"), 0, 20));
        ((Graphics)object).setColor(Color.WHITE);
        String string = "HanaClient" + WebUtils.ALLATORIxDEMO(")").repeat(dotCount);
        Object object2 = a22;
        a22 = ((Graphics)object2).getFontMetrics();
        String string2 = string;
        int n = ((FontMetrics)a22).stringWidth(string2);
        int a22 = (a.getHeight() + ((FontMetrics)a22).getAscent()) / 2 + 85;
        ((Graphics2D)object2).drawString(string2, (a.getWidth() - n) / 2 + 2, a22);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Object a = graphics;
        LaunchWrapper.1 a2 = this;
        Object object = a;
        super.paintComponent((Graphics)object);
        Object object2 = a = (Graphics2D)((Graphics)object).create();
        ((Graphics2D)a).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics)a).setColor(new Color(35, 35, 35));
        ((Graphics2D)object2).fill(new RoundRectangle2D.Float(0.0f, 0.0f, a2.getWidth(), a2.getHeight(), 30.0f, 30.0f));
        a2.drawRotatingLoader((Graphics2D)a);
        a2.drawAuthenticationText((Graphics2D)object2);
        ((Graphics)object2).dispose();
    }

    LaunchWrapper.1() {
        LaunchWrapper.1 a;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawRotatingLoader(Graphics2D graphics2D) {
        LaunchWrapper.1 var4_3;
        int n;
        LaunchWrapper.1 v0 = var4_3 = this;
        int n2 = v0.getWidth() / 2;
        int n3 = v0.getHeight() / 2 - 20;
        int a = 5;
        int n4 = 32;
        int n5 = 12;
        int n6 = 9;
        speed += 0.01;
        int n7 = n = 0;
        while (n7 < n5) {
            void a2;
            double d = speed + (double)(n * 2) * 3.141592653589793 / (double)n5;
            int n8 = n2 + (int)((double)n4 * Math.cos(d)) - a;
            int n9 = n3 + (int)((double)n4 * Math.sin(d)) - a;
            float f = n < n6 ? Math.max(0.0f, 1.0f - (float)((dotCount + n6 - n) % n6) / (float)n6) : 0.0f;
            void v2 = a2;
            void v3 = a2;
            v2.setColor(new Color(255, 255, 255, (int)(f * 255.0f)));
            v2.fillOval(n8, n9, a * 2, a * 2);
            n7 = ++n;
        }
        speed = (speed + 6.283185307179586) % 6.283185307179586;
    }
}
