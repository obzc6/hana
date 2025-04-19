/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class UI2 {
    static InputStream inputStream = Hana.class.getClassLoader().getResourceAsStream(RadiusUtils.ALLATORIxDEMO("u3\u001c^\u0015F\u0011\u0002P\u000bUO_\bS\u000f\u0007\r\rP"));

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void Load(String a, TrayIcon.MessageType a2) {
        Object object = a;
        try {
            Object object2;
            block10 : {
                Object object3;
                BufferedImage bufferedImage;
                SystemTray systemTray;
                block9 : {
                    int n;
                    bufferedImage = ImageIO.read(inputStream);
                    systemTray = SystemTray.getSystemTray();
                    a = null;
                    TrayIcon[] arrtrayIcon = systemTray.getTrayIcons();
                    int n2 = arrtrayIcon.length;
                    int n3 = n = 0;
                    while (n3 < n2) {
                        TrayIcon trayIcon = arrtrayIcon[n];
                        if (trayIcon.getToolTip().equals(RadiusUtils.ALLATORIxDEMO("t\tW\f"))) {
                            object3 = a = trayIcon;
                            break block9;
                        }
                        n3 = ++n;
                    }
                    object3 = a;
                }
                if (object3 == null) {
                    Object object4 = a = new TrayIcon(bufferedImage, Snow.ALLATORIxDEMO("`\u001d=f"));
                    ((TrayIcon)object4).setImageAutoSize(true);
                    ((TrayIcon)object4).setToolTip(RadiusUtils.ALLATORIxDEMO("t\tW\f"));
                    try {
                        systemTray.add((TrayIcon)a);
                        object2 = a;
                        break block10;
                    }
                    catch (AWTException aWTException) {
                        aWTException.printStackTrace();
                    }
                }
                object2 = a;
            }
            ((TrayIcon)object2).displayMessage(Snow.ALLATORIxDEMO("`\u001d=f"), (String)object, a2);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public UI2() {
        UI2 a;
    }
}
