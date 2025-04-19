/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilter;
import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVFilter.Query_func_AVFilterContext
extends FunctionPointer {
    public AVFilter.Query_func_AVFilterContext(Pointer pointer) {
        AVFilter.Query_func_AVFilterContext a = pointer;
        AVFilter.Query_func_AVFilterContext a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    protected AVFilter.Query_func_AVFilterContext() {
        AVFilter.Query_func_AVFilterContext a;
        AVFilter.Query_func_AVFilterContext query_func_AVFilterContext = a;
        query_func_AVFilterContext.allocate();
    }

    public native int call(AVFilterContext var1);
}
