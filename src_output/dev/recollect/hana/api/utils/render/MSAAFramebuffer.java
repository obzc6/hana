/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL30
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL30;

public class MSAAFramebuffer
extends class_276 {
    private static final List<MSAAFramebuffer> ACTIVE_INSTANCES;
    public static final int MAX_SAMPLES;
    private final int samples;
    private int rboColor;
    private boolean inUse;
    private static final Map<Integer, MSAAFramebuffer> INSTANCES;
    public static final int MIN_SAMPLES = 2;
    private int rboDepth;

    /*
     * WARNING - void declaration
     */
    public void method_1234(int n, int n2, boolean bl) {
        void a;
        int a2 = n2;
        MSAAFramebuffer a3 = this;
        if (a3.field_1482 != a || a3.field_1481 != a2) {
            void a4;
            super.method_1234((int)a, a2, (boolean)a4);
        }
    }

    public static MSAAFramebuffer getInstance(int a) {
        return INSTANCES.computeIfAbsent(a, n2 -> {
            Integer a = n2;
            int a2 = a;
            return new MSAAFramebuffer(a2);
        });
    }

    public static boolean framebufferInUse() {
        return !ACTIVE_INSTANCES.isEmpty();
    }

    public static void use(Runnable a) {
        MSAAFramebuffer.use(Math.min(16, MAX_SAMPLES), class_310.method_1551().method_1522(), a);
    }

    public static void use(int samples, @NotNull class_276 mainBuffer, @NotNull Runnable drawAction) {
        int n = samples;
        RenderSystem.assertOnRenderThreadOrInit();
        MSAAFramebuffer mSAAFramebuffer = samples = MSAAFramebuffer.getInstance(n);
        class_276 class_2762 = mainBuffer;
        samples.method_1234(class_2762.field_1482, class_2762.field_1481, false);
        GlStateManager._glBindFramebuffer((int)36008, (int)mainBuffer.field_1476);
        GlStateManager._glBindFramebuffer((int)36009, (int)samples.field_1476);
        MSAAFramebuffer mSAAFramebuffer2 = samples;
        MSAAFramebuffer mSAAFramebuffer3 = samples;
        GlStateManager._glBlitFrameBuffer((int)0, (int)0, (int)mSAAFramebuffer2.field_1482, (int)mSAAFramebuffer2.field_1481, (int)0, (int)0, (int)mSAAFramebuffer3.field_1482, (int)mSAAFramebuffer3.field_1481, (int)16384, (int)9729);
        mSAAFramebuffer.method_1235(true);
        drawAction.run();
        mSAAFramebuffer.method_1240();
        GlStateManager._glBindFramebuffer((int)36008, (int)samples.field_1476);
        GlStateManager._glBindFramebuffer((int)36009, (int)mainBuffer.field_1476);
        MSAAFramebuffer mSAAFramebuffer4 = samples;
        MSAAFramebuffer mSAAFramebuffer5 = samples;
        GlStateManager._glBlitFrameBuffer((int)0, (int)0, (int)mSAAFramebuffer4.field_1482, (int)samples.field_1481, (int)0, (int)0, (int)mSAAFramebuffer5.field_1482, (int)mSAAFramebuffer5.field_1481, (int)16384, (int)9729);
        mSAAFramebuffer4.method_1230(false);
        mainBuffer.method_1235(false);
    }

    public void method_1238() {
        MSAAFramebuffer a;
        RenderSystem.assertOnRenderThreadOrInit();
        MSAAFramebuffer mSAAFramebuffer = a;
        mSAAFramebuffer.method_1242();
        mSAAFramebuffer.method_1240();
        if (mSAAFramebuffer.field_1476 > -1) {
            GlStateManager._glBindFramebuffer((int)36160, (int)0);
            GlStateManager._glDeleteFramebuffers((int)a.field_1476);
            a.field_1476 = -1;
        }
        if (a.rboColor > -1) {
            GlStateManager._glDeleteRenderbuffers((int)a.rboColor);
            a.rboColor = -1;
        }
        if (a.rboDepth > -1) {
            GlStateManager._glDeleteRenderbuffers((int)a.rboDepth);
            a.rboDepth = -1;
        }
        MSAAFramebuffer mSAAFramebuffer2 = a;
        a.field_1475 = -1;
        mSAAFramebuffer2.field_1474 = -1;
        mSAAFramebuffer2.field_1482 = -1;
        a.field_1481 = -1;
    }

    /*
     * WARNING - void declaration
     */
    public void method_1231(int n, int n2, boolean bl) {
        void a;
        void a2;
        int a3 = n2;
        MSAAFramebuffer a4 = this;
        RenderSystem.assertOnRenderThreadOrInit();
        int n3 = RenderSystem.maxSupportedTextureSize();
        if (a <= 0 || a > n3 || a3 <= 0 || a3 > n3) {
            throw new IllegalArgumentException("Window " + (int)a + "x" + a3 + " size out of bounds (max. size: " + n3 + ")");
        }
        MSAAFramebuffer mSAAFramebuffer = a4;
        MSAAFramebuffer mSAAFramebuffer2 = a4;
        MSAAFramebuffer mSAAFramebuffer3 = a4;
        a4.field_1480 = a;
        mSAAFramebuffer3.field_1477 = a3;
        mSAAFramebuffer3.field_1482 = a;
        mSAAFramebuffer2.field_1481 = a3;
        mSAAFramebuffer2.field_1476 = GlStateManager.glGenFramebuffers();
        GlStateManager._glBindFramebuffer((int)36160, (int)a4.field_1476);
        mSAAFramebuffer2.rboColor = GlStateManager.glGenRenderbuffers();
        GlStateManager._glBindRenderbuffer((int)36161, (int)a4.rboColor);
        GL30.glRenderbufferStorageMultisample((int)36161, (int)a4.samples, (int)32856, (int)a, (int)a3);
        GlStateManager._glBindRenderbuffer((int)36161, (int)0);
        a4.rboDepth = GlStateManager.glGenRenderbuffers();
        GlStateManager._glBindRenderbuffer((int)36161, (int)a4.rboDepth);
        GL30.glRenderbufferStorageMultisample((int)36161, (int)a4.samples, (int)6402, (int)a, (int)a3);
        GlStateManager._glBindRenderbuffer((int)36161, (int)0);
        GL30.glFramebufferRenderbuffer((int)36160, (int)36064, (int)36161, (int)a4.rboColor);
        GL30.glFramebufferRenderbuffer((int)36160, (int)36096, (int)36161, (int)a4.rboDepth);
        a4.field_1475 = class_310.method_1551().method_1522().method_30277();
        mSAAFramebuffer.field_1474 = class_310.method_1551().method_1522().method_30278();
        mSAAFramebuffer.method_1239();
        mSAAFramebuffer.method_1230((boolean)a2);
        a4.method_1242();
    }

    static {
        MAX_SAMPLES = GL30.glGetInteger((int)36183);
        INSTANCES = new HashMap<Integer, MSAAFramebuffer>();
        ACTIVE_INSTANCES = new ArrayList<MSAAFramebuffer>();
    }

    public MSAAFramebuffer(int n) {
        int a = n;
        MSAAFramebuffer a2 = this;
        super(true);
        if (a < 2 || a > MAX_SAMPLES) {
            Object[] arrobject = new Object[3];
            arrobject[0] = 2;
            arrobject[1] = MAX_SAMPLES;
            arrobject[2] = a;
            throw new IllegalArgumentException(String.format(SocketClient.ALLATORIxDEMO("ov_?IwOeXj@*Z9XoMuFjX.Oq\u000f0oB=Zj\n1\u0017(\bO9NdG&\u00173\f,H2\bjGy\u000b+O7"), arrobject));
        }
        int n2 = a;
        if ((n2 & n2 - 1) != 0) {
            throw new IllegalArgumentException(GameInfo.ALLATORIxDEMO("\u001fgr8nff{dj `qs8QE^ZYW\u001cINP{7~a0i8pppmb;l}#lw`9"));
        }
        a2.samples = a;
        a2.method_1236(1.0f, 1.0f, 1.0f, 0.0f);
    }

    public void method_1240() {
        MSAAFramebuffer a;
        MSAAFramebuffer mSAAFramebuffer = a;
        super.method_1240();
        if (mSAAFramebuffer.inUse) {
            a.inUse = false;
            ACTIVE_INSTANCES.remove((Object)a);
        }
    }

    public void method_1235(boolean bl) {
        MSAAFramebuffer a;
        boolean a2 = bl;
        MSAAFramebuffer mSAAFramebuffer = a = this;
        super.method_1235(a2);
        if (!mSAAFramebuffer.inUse) {
            ACTIVE_INSTANCES.add(a);
            a.inUse = true;
        }
    }
}
