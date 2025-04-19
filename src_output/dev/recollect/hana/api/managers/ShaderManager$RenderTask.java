/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.ShaderManager;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public static final class ShaderManager.RenderTask
extends Record {
    private final ShaderManager.Shader shader;
    private final Runnable task;

    /*
     * WARNING - void declaration
     */
    public ShaderManager.RenderTask(Runnable runnable, ShaderManager.Shader shader) {
        ShaderManager.RenderTask a;
        void a2;
        Object a3 = shader;
        ShaderManager.RenderTask renderTask = a = this;
        renderTask.task = a2;
        renderTask.shader = a3;
    }

    public ShaderManager.Shader shader() {
        ShaderManager.RenderTask a;
        return a.shader;
    }

    public Runnable task() {
        ShaderManager.RenderTask a;
        return a.task;
    }

    @Override
    public final int hashCode() {
        ShaderManager.RenderTask a;
        return (int)ObjectMethods.bootstrap(new MethodHandle[]{ShaderManager.RenderTask.class, "task;shader", }