/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import org.bytedeco.javacv.Frame;

public abstract class FrameConverter<F>
implements AutoCloseable {
    protected Frame frame;

    public abstract Frame convert(F var1);

    public abstract F convert(Frame var1);

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 3 << 3 ^ 3;
        4 << 4 ^ 1 << 1;
        int n4 = (2 ^ 5) << 4 ^ 4 << 1;
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

    public FrameConverter() {
        FrameConverter a;
    }

    @Override
    public void close() {
        FrameConverter a;
        if (a.frame != null) {
            a.frame.close();
            a.frame = null;
        }
    }
}
