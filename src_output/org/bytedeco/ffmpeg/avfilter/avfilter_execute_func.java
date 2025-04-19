/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.avfilter.avfilter_action_func;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class avfilter_execute_func
extends FunctionPointer {
    public avfilter_execute_func(Pointer pointer) {
        avfilter_execute_func a = pointer;
        avfilter_execute_func a2 = this;
        super((Pointer)a);
    }

    public native int call(AVFilterContext var1, avfilter_action_func var2, Pointer var3, IntPointer var4, int var5);

    static {
        Loader.load();
    }

    protected avfilter_execute_func() {
        avfilter_execute_func a;
        avfilter_execute_func avfilter_execute_func2 = a;
        avfilter_execute_func2.allocate();
    }

    private native /* synthetic */ void allocate();
}
