/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class avfilter_action_func
extends FunctionPointer {
    public avfilter_action_func(Pointer pointer) {
        avfilter_action_func a = pointer;
        avfilter_action_func a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native int call(AVFilterContext var1, Pointer var2, int var3, int var4);

    protected avfilter_action_func() {
        avfilter_action_func a;
        avfilter_action_func avfilter_action_func2 = a;
        avfilter_action_func2.allocate();
    }

    static {
        Loader.load();
    }
}
