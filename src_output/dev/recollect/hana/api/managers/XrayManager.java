/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_310
 *  net.minecraft.class_761
 *  org.apache.commons.io.FileUtils
 *  org.apache.commons.io.IOUtils
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.dev.XRay;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_310;
import net.minecraft.class_761;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class XrayManager
implements Wrapper {
    public final ArrayList<String> list = new ArrayList();

    public void save() {
        PrintWriter printWriter;
        Object a;
        XrayManager xrayManager = a;
        try {
            String[] arrstring = new String[1];
            arrstring[0] = BetterDynamicAnimation.ALLATORIxDEMO("b_HsveTsYg\fbMu");
            File file = FileUtils.getFile((String[])arrstring);
            printWriter = new PrintWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(file), StandardCharsets.UTF_8));
            Object object = a = xrayManager.list.iterator();
            while (object.hasNext()) {
                String string = (String)a.next();
                object = a;
                printWriter.println(string);
            }
        }
        catch (Exception exception) {
            System.out.println(RadiusUtils.ALLATORIxDEMO("!;Fk0l\u0017U\rJ\u0004Mdz\tZ\u000bY\f\u001a\u001aWL\\\u001aX\u001f\u001c\u0010Y\u001eA\u001f"));
            return;
        }
        printWriter.close();
    }

    public void add(String string) {
        String a = string;
        XrayManager a2 = this;
        if (!a2.list.contains(a)) {
            a2.list.add(a);
            if (!Module.nullCheck() && XRay.INSTANCE.isOn()) {
                XrayManager.mc.field_1769.method_3279();
            }
        }
    }

    public boolean inWhitelist(String string) {
        String a = string;
        XrayManager a2 = this;
        return a2.list.contains(a);
    }

    public void read() {
        File a2;
        XrayManager xrayManager;
        block4 : {
            xrayManager = a2;
            String[] arrstring = new String[1];
            arrstring[0] = RadiusUtils.ALLATORIxDEMO("\u0003]\u001aA\u001f\u0012\u001cA\u0019");
            a2 = FileUtils.getFile((String[])arrstring);
            if (a2.exists()) break block4;
            XrayManager xrayManager2 = xrayManager;
            xrayManager2.add(class_2246.field_10442.method_9539());
            xrayManager2.add(class_2246.field_29029.method_9539());
            xrayManager2.add(class_2246.field_10571.method_9539());
            xrayManager2.add(class_2246.field_23077.method_9539());
            xrayManager2.add(class_2246.field_10212.method_9539());
            xrayManager2.add(class_2246.field_29027.method_9539());
            xrayManager2.add(class_2246.field_10080.method_9539());
            xrayManager2.add(class_2246.field_10013.method_9539());
            xrayManager2.add(class_2246.field_29220.method_9539());
            xrayManager2.add(class_2246.field_29030.method_9539());
            xrayManager2.add(class_2246.field_10418.method_9539());
            xrayManager2.add(class_2246.field_29219.method_9539());
            xrayManager2.add(class_2246.field_22109.method_9539());
            xrayManager2.add(class_2246.field_10213.method_9539());
            xrayManager2.add(class_2246.field_10090.method_9539());
            xrayManager2.add(class_2246.field_29028.method_9539());
            return;
        }
        try {
            for (String string : IOUtils.readLines((InputStream)new FileInputStream(a2), (Charset)StandardCharsets.UTF_8)) {
                xrayManager.add(string);
            }
        }
        catch (IOException a2) {
            a2.printStackTrace();
        }
    }

    public XrayManager() {
        XrayManager a;
        a.read();
    }

    public void remove(String string) {
        String a = string;
        XrayManager a2 = this;
        if (a2.list.remove(a) && !Module.nullCheck() && XRay.INSTANCE.isOn()) {
            XrayManager.mc.field_1769.method_3279();
        }
    }
}
