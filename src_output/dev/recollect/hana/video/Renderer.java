/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 */
package dev.recollect.hana.video;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class Renderer {
    private int imageHeight;
    private ByteBuffer imageBuffer;
    private int internalformat;
    private int imageWidth;

    public Renderer() {
        Renderer a;
    }

    public void onDrawFrame() {
        Renderer a;
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)-1);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
        Renderer renderer = a;
        GL11.glTexImage2D((int)3553, (int)0, (int)renderer.internalformat, (int)renderer.imageWidth, (int)a.imageHeight, (int)0, (int)a.internalformat, (int)5121, (ByteBuffer)a.imageBuffer);
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ 2 << 1;
        (3 ^ 5) << 4 ^ (3 << 2 ^ 1);
        int n4 = 1 << 3 ^ 1;
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

    /*
     * WARNING - void declaration
     */
    public void setBuffer(ByteBuffer byteBuffer, int n, int n2) {
        void a;
        void a2;
        Renderer a3;
        int a4 = n2;
        Renderer renderer = a3 = this;
        Renderer renderer2 = a3;
        renderer2.internalformat = 6407;
        renderer2.imageWidth = a2;
        renderer.imageHeight = a4;
        renderer.imageBuffer = a;
    }
}
