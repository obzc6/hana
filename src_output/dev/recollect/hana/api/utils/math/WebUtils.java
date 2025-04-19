/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Native
 *  com.sun.jna.Pointer
 *  com.sun.jna.win32.StdCallLibrary
 *  com.sun.jna.win32.StdCallLibrary$StdCallCallback
 */
package dev.recollect.hana.api.utils.math;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.Timer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.bytedeco.javacv.BaseChildSettings;

public class WebUtils {
    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 3 ^ 2;
        4 << 4 ^ (3 << 2 ^ 3);
        int n4 = (2 ^ 5) << 4 ^ 3;
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    public static String get(String a) throws IOException {
        String string;
        String string2 = a;
        Object object = a = (HttpURLConnection)new URL(string2).openConnection();
        ((HttpURLConnection)object).setRequestMethod(Animation.ALLATORIxDEMO("Su_"));
        ((URLConnection)object).setRequestProperty(BaseChildSettings.ALLATORIxDEMO("w%X;\u0004\u001cL:T:"), Animation.ALLATORIxDEMO("WyW^`Fp\u0000!\u001e;"));
        a = new BufferedReader(new InputStreamReader(((URLConnection)a).getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = a;
        while ((string = ((BufferedReader)object2).readLine()) != null) {
            object2 = a;
            stringBuilder.append(string);
            stringBuilder.append(BaseChildSettings.ALLATORIxDEMO("D"));
        }
        ((BufferedReader)a).close();
        return stringBuilder.toString();
    }

    public WebUtils() {
        WebUtils a;
    }

    public static String readContent(String a) throws IOException {
        String string;
        Object object = a;
        Object object2 = a = ((String)object).toLowerCase().startsWith(Animation.ALLATORIxDEMO("_x^a\\.\u001f$")) ? (HttpURLConnection)new URL((String)object).openConnection() : (HttpURLConnection)new URL((String)object).openConnection();
        Object object3 = a;
        ((URLConnection)a).setConnectTimeout(10000);
        ((URLConnection)object3).setReadTimeout(10000);
        ((HttpURLConnection)object3).setRequestMethod(BaseChildSettings.ALLATORIxDEMO("\u0013\u001a"));
        ((URLConnection)object2).setRequestProperty(Animation.ALLATORIxDEMO("C^R~\u0007PHq^"), BaseChildSettings.ALLATORIxDEMO("b4\u001a}C7_e\u0012}P4\u0013\u0018S C<U%\u001d\u000744\u0015y\u001e`\u001a\u0019i\u0005V \"MY)\u0016j.A\ng\u0007\u0014G5V&\u0013z\u001bn\u001fk\u001bn<Yg<R1\\!Sp\u0012a\u0014~"));
        HttpURLConnection.setFollowRedirects(true);
        ((URLConnection)object2).setDoOutput(true);
        a = new BufferedReader(new InputStreamReader(((URLConnection)a).getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        Object object4 = a;
        while ((string = ((BufferedReader)object4).readLine()) != null) {
            object4 = a;
            stringBuilder.append(string).append(Animation.ALLATORIxDEMO("\u0001"));
        }
        ((BufferedReader)a).close();
        return stringBuilder.toString();
    }

    public static interface User32
    extends StdCallLibrary {
        public static final User32 INSTANCE = (User32)Native.loadLibrary((String)Timer.ALLATORIxDEMO("LGA[]Q"), User32.class);

        public int GetWindowTextA(Pointer var1, byte[] var2, int var3);

        public boolean EnumWindows(WNDENUMPROC var1, Pointer var2);

        public static interface WNDENUMPROC
        extends StdCallLibrary.StdCallCallback {
            public boolean callback(Pointer var1, Pointer var2);
        }

    }

}
