/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.skid;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.PrintStream;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import org.bytedeco.javacv.BaseSettings;

public class LaunchWrapper {
    static double speed;
    static int dotCount;
    static int launch;
    static final float ANIMATION_SPEED = 0.02f;

    public static void main(String[] a) {
        String[] arrstring = a;
        System.out.println(BaseSettings.ALLATORIxDEMO("\u000e-\u0018\b=\u001b.\n?\n?\u001f*\b=\u0017\"\u001b.\u0013&\u0014!\u001e+\u001f*\f9Ta\b=\u001f*\u0019,\u0015 \u0016#\u0016#\u001f*\u0019,\u000e;}a\u0011$\u0018-\u0017\"\u0018-Wb\n?\u0012'\u0010%\u001d(Wb5\u0000\u0018-\f9\u0017\"\u001a/\u0011$.\u001b\u000b>\u0018-\t<\t<\u001c)\u000b>\u0017\u000b\u001b-\u0010%\u0017\"\u001d(\u001c*\f:Tb\u000b>\u001f)\u001a/\u0016 \u0016 \u0016#\u001f)\u0019,\u000e8Ta\u0011$\u001b.\u0014\"\u0018-Wb\n?\u0012$:&\u001d(Wb5\u0000\u0018.\f:\u0017!\u001a/\u0011'.\u001b\u000b=\u0018.\t<\n<\u001c*\u000b=\u0014\"\u0018.\u0010%\u0014\"\u001d(\u001c)\u000f:Wb\b\u0014\u001f)\u001a/\u0016#\u0015 \u0016#\u001f)\u0019/\r8Tb\u0011$\u001b.\u0014\"\u0018.Wb\t?\u0011'\u0013&\u001d(Wa5\u0000\u0018-\f9\u0017\"\u001a,;'.\u001b\u000b>\u0018-\t?\t?\u001c*\b=\u0014\"\u001b.\u0010&\u0017!\u001d(\u001f)\u000f9Ta\u000b=\u001c*\u001a,\u0015 \u0015 \u0015 \u001c)\u001a/\u000e\u0012Tb\u0011$\u0018-\u0017\"\u0018-Wb\n?\u0012'\u0010%\u001d(Wb5\u0000\u0018-\f9\u0017\"\u001a/\u0011$.\u001b\u000b>\u0018-\t<\t<\u001c)\u000b=>\"\u0018BRcBq^iH`@tW R>}eVnBlGi\u0015O^oO|Ny\u0003-C$N4\u00193\u0018I2\u000fe?\u0011\r\u0013%\u001d(Wb5\u0000\u0018-\f9\u0017\"\u001a/\u0011$.\u001b\u000b>\u0018-\t<\t<\u001c)\u000b>\u0014!\u0018-\u0010%\u0017\"\u001d(\u001c)\u000f:Wa!=\u001c)\u001a/\u0016#\u0015 \u0015 \u001caN{]\"XmFsO#VnTl\u0003-Xv\u001cd_h\u001d(Wb5\u0000\u0018-\f9\u0017\"\u0019\u0005\u0012$.\u001b\u000b>\u0018-\t<\t<\u001c)\u000b>\u0014!\u0018-\u0010%\u0017\"\u001d(\u001c)\u000f:Wb\u000b>\u001c)\u001a/\u0016#\u0015 \u0015 \u001c)\u001a,';Ta\u0012'\u001b.\u0014!\u001b.Ta\t<\u0011$\u0013&\u001e+Ta6\u0003\u001b.\u000f:\u0014!\u0019,\u0012'-\u0018\b=\u001b.\n?\n?\u001f*\b\u0014"));
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println(BlockUpUtil.ALLATORIxDEMO("OX|\f4Qg\u0007qK:@r\u00039lZ^a\u0019kMyJ>\u0004HpMNqD|[#OsEwMi\u0001mN`@L3"));
            return;
        }
        a = new JWindow();
        JPanel jPanel = LaunchWrapper.createContentPanel();
        Object object = a;
        Object object2 = a;
        ((JWindow)object2).setContentPane(jPanel);
        ((Window)object).setSize(265, 300);
        LaunchWrapper.centerWindow((JWindow)object2);
        LaunchWrapper.configureSplashScreen((JWindow)object);
        LaunchWrapper.createCloseTimer(arrstring, (JWindow)object).start();
        LaunchWrapper.startDotTimer(jPanel);
        LaunchWrapper.startRotationTimer(jPanel);
    }

    static {
        dotCount = 0;
        speed = 0.0;
        launch = 10000;
    }

    private static /* synthetic */ void startRotationTimer(JPanel a) {
        new Timer(25, actionEvent -> {
            Serializable a = actionEvent;
            JPanel a2 = a;
            speed += 0.08975979010256552;
            a2.repaint();
        }).start();
    }

    private static /* synthetic */ void lambda$createCloseTimer$4(JWindow jWindow, ActionEvent actionEvent) {
        Serializable a = actionEvent;
        JWindow a3 = jWindow;
        new Timer(10, a2 -> {
            JWindow jWindow;
            JWindow jWindow2 = jWindow = a3;
            float a3 = Math.max(jWindow2.getOpacity() - 0.02f, 0.0f);
            jWindow2.setOpacity(a3);
            if (a3 <= 0.0f) {
                JWindow jWindow3 = jWindow;
                jWindow3.setVisible(false);
                jWindow3.dispose();
                ((Timer)a2.getSource()).stop();
            }
        }).start();
    }

    private static /* synthetic */ void configureSplashScreen(JWindow a) {
        JWindow jWindow = a;
        JWindow jWindow2 = a;
        JWindow jWindow3 = a;
        jWindow2.setBackground(new Color(0, 0, 0, 0));
        jWindow2.setAlwaysOnTop(true);
        jWindow.setOpacity(0.0f);
        jWindow.setVisible(true);
        LaunchWrapper.fadeIn(jWindow);
    }

    private static /* synthetic */ Timer createCloseTimer(String[] arrstring, JWindow jWindow) {
        Object a = jWindow;
        String[] a2 = arrstring;
        return new Timer(launch, arg_0 -> LaunchWrapper.lambda$createCloseTimer$4((JWindow)a, arg_0));
    }

    private static /* synthetic */ void fadeIn(JWindow a) {
        new Timer(10, a2 -> {
            JWindow jWindow;
            JWindow jWindow2 = jWindow = a;
            float a3 = Math.min(jWindow2.getOpacity() + 0.02f, 1.0f);
            jWindow2.setOpacity(a3);
            if (a3 >= 1.0f) {
                ((Timer)a2.getSource()).stop();
            }
        }).start();
    }

    public LaunchWrapper() {
        LaunchWrapper a;
    }

    private static /* synthetic */ JPanel createContentPanel() {
        return new JPanel(){

            private /* synthetic */ void drawAuthenticationText(Graphics2D graphics2D) {
                Object a22 = graphics2D;
                1 a = this;
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
                1 a2 = this;
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
            {
                1 a;
            }

            /*
             * WARNING - void declaration
             */
            private /* synthetic */ void drawRotatingLoader(Graphics2D graphics2D) {
                1 var4_3;
                int n;
                1 v0 = var4_3 = this;
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
        };
    }

    private static /* synthetic */ void centerWindow(JWindow a2) {
        JWindow jWindow = a2;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JWindow jWindow2 = jWindow;
        int n = (dimension.width - jWindow2.getWidth()) / 2;
        int a2 = (dimension.height - jWindow.getHeight()) / 2;
        jWindow2.setLocation(n, a2);
    }

    private static /* synthetic */ void startDotTimer(JPanel a) {
        new Timer(255, actionEvent -> {
            Serializable a = actionEvent;
            JPanel a2 = a;
            dotCount = (dotCount + 1) % 4;
            a2.repaint();
        }).start();
    }

}
