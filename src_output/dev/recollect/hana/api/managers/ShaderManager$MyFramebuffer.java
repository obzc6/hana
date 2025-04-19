/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_276
 */
package dev.recollect.hana.api.managers;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.managers.ShaderManager;
import net.minecraft.class_276;

public static class ShaderManager.MyFramebuffer
extends class_276 {
    /*
     * WARNING - void declaration
     */
    public ShaderManager.MyFramebuffer(int n, int n2) {
        void a;
        ShaderManager.MyFramebuffer a2;
        int a3 = n2;
        ShaderManager.MyFramebuffer myFramebuffer = a2 = this;
        super(false);
        RenderSystem.assertOnRenderThreadOrInit();
        myFramebuffer.method_1234((int)a, a3, true);
        myFramebuffer.method_1236(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
