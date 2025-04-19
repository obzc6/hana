/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 */
package dev.recollect.hana.xibao;

import dev.recollect.hana.xibao.Snow;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.class_2960;

public class SnowAnimation {
    private int lastHeight;
    public static SnowAnimation INSTANCE;
    private class_2960[] source;
    private int lastWidth;
    private float amount;
    public final List<Snow> snows;
    private final Random random;

    public void spawnGroup() {
        SnowAnimation snowAnimation;
        block4 : {
            SnowAnimation snowAnimation2;
            block3 : {
                float a22;
                int n;
                block2 : {
                    SnowAnimation a22;
                    float f;
                    snowAnimation2 = a22;
                    snowAnimation2.amount += 0.001f;
                    a22 = Math.min(0.4f, snowAnimation2.amount);
                    if (!(f < 1.0f)) break block2;
                    if (snowAnimation2.random.nextInt((int)(1.0f / a22)) != 0) break block3;
                    SnowAnimation snowAnimation3 = snowAnimation2;
                    snowAnimation = snowAnimation3;
                    snowAnimation3.spawn();
                    break block4;
                }
                int n2 = n = 1;
                while ((float)n2 <= a22) {
                    snowAnimation2.spawn();
                    n2 = ++n;
                }
            }
            snowAnimation = snowAnimation2;
        }
        if (snowAnimation.amount >= 0.6f) {
            snowAnimation2.amount = 0.1f;
        }
    }

    public int getSourceIndex() {
        SnowAnimation a;
        SnowAnimation snowAnimation = a;
        return snowAnimation.random.nextInt(snowAnimation.source.length);
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 5 << 4 ^ (3 ^ 5) << 1;
        int n4 = 2;
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

    public SnowAnimation(Random random) {
        SnowAnimation a;
        Random a2 = random;
        SnowAnimation snowAnimation = a = this;
        snowAnimation.amount = 0.1f;
        SnowAnimation snowAnimation2 = a;
        snowAnimation.snows = new ArrayList<Snow>();
        snowAnimation.random = a2;
    }

    public void spawn() {
        SnowAnimation snowAnimation;
        SnowAnimation a22;
        int n;
        SnowAnimation snowAnimation2;
        SnowAnimation snowAnimation3 = snowAnimation = a22;
        SnowAnimation snowAnimation4 = snowAnimation;
        int n2 = snowAnimation3.random.nextInt(snowAnimation4.lastWidth);
        int a22 = snowAnimation3.random.nextInt(4) * 2 + 1;
        if (snowAnimation.random.nextInt(2) == 0) {
            n = -a22;
            snowAnimation2 = snowAnimation;
        } else {
            n = a22;
            snowAnimation2 = snowAnimation;
        }
        snowAnimation4.snows.add(new Snow(n2, n, snowAnimation2.getSourceIndex()));
    }

    /*
     * WARNING - void declaration
     */
    public void tick(int n, int n2, class_2960[] arrclass_2960) {
        void a;
        void var3_7;
        void a2;
        void a322 = var3_7;
        SnowAnimation a4 = this;
        a4.source = a322;
        if (a2 != a4.lastWidth || a != a4.lastHeight) {
            a4.snows.clear();
            a4.lastWidth = a2;
            a4.lastHeight = a;
        }
        SnowAnimation snowAnimation = a4;
        snowAnimation.spawnGroup();
        for (Snow a322 : snowAnimation.snows) {
            RenderHelper.renderParticle(a322.x, (int)(a - a322.y), 4, 4, a4.source[a322.source % a4.source.length]);
            Snow snow = a322;
            snow.move();
            if (snow.y <= a) continue;
            a322.removed = true;
        }
        if (a4.snows.size() > 500) {
            while (0 < a4.snows.size() && a4.snows.get((int)0).removed) {
                a4.snows.remove(0);
            }
        }
    }
}
