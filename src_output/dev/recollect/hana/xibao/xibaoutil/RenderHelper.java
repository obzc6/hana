/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_4588
 *  net.minecraft.class_757
 */
package dev.recollect.hana.xibao.xibaoutil;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_4588;
import net.minecraft.class_757;

public class RenderHelper {
    public RenderHelper() {
        RenderHelper a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 3;
        3 << 3 ^ (2 ^ 5);
        int n4 = (2 ^ 5) << 4 ^ (3 ^ 5) << 1;
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
    public static void renderParticle(int n, int n2, int n3, int n4, class_2960 class_29602) {
        void a;
        void a2;
        void a3;
        void a4;
        int n5 = n;
        class_289 class_2892 = class_289.method_1348();
        class_287 a5 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34543);
        RenderSystem.setShaderTexture((int)0, (class_2960)a3);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        class_287 class_2872 = a5;
        void v1 = a2;
        class_287 class_2873 = a5;
        class_2873.method_1328(class_293.class_5596.field_27382, class_290.field_1575);
        class_2873.method_22912(0.0 + (double)n5, (double)(a4 + a), 0.0).method_22913(0.0f, 1.0f).method_1336(255, 255, 255, 255).method_1344();
        a5.method_22912((double)(v1 + n5), (double)(a4 + a), 0.0).method_22913(1.0f, 1.0f).method_1336(255, 255, 255, 255).method_1344();
        class_2872.method_22912((double)(v1 + n5), 0.0 + (double)a, 0.0).method_22913(1.0f, 0.0f).method_1336(255, 255, 255, 255).method_1344();
        class_2872.method_22912(0.0 + (double)n5, 0.0 + (double)a, 0.0).method_22913(0.0f, 0.0f).method_1336(255, 255, 255, 255).method_1344();
        class_2892.method_1350();
    }

    /*
     * WARNING - void declaration
     */
    public static void renderStretchTexture(int n, int n2, int n3, class_2960 class_29602) {
        void a;
        void a2;
        void a3;
        int n4 = n;
        class_289 class_2892 = class_289.method_1348();
        class_287 a4 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34543);
        RenderSystem.setShaderTexture((int)0, (class_2960)a2);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        class_287 class_2872 = a4;
        int n5 = n4;
        class_287 class_2873 = a4;
        class_2873.method_1328(class_293.class_5596.field_27382, class_290.field_1575);
        void v3 = a;
        class_2873.method_22912(0.0, (double)a3, -1.0).method_22913(0.0f, 1.0f).method_1336((int)v3, (int)v3, (int)v3, 255).method_1344();
        void v4 = a;
        a4.method_22912((double)n5, (double)a3, -1.0).method_22913(1.0f, 1.0f).method_1336((int)v4, (int)v4, (int)v4, 255).method_1344();
        void v5 = a;
        class_2872.method_22912((double)n5, 0.0, -1.0).method_22913(1.0f, 0.0f).method_1336((int)v5, (int)v5, (int)v5, 255).method_1344();
        void v6 = a;
        class_2872.method_22912(0.0, 0.0, -1.0).method_22913(0.0f, 0.0f).method_1336((int)v6, (int)v6, (int)v6, 255).method_1344();
        class_2892.method_1350();
    }
}
