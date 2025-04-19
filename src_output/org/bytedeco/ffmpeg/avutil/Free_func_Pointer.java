/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Free_func_Pointer
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    protected Free_func_Pointer() {
        Free_func_Pointer a;
        Free_func_Pointer free_func_Pointer = a;
        free_func_Pointer.allocate();
    }

    static {
        Loader.load();
    }

    public Free_func_Pointer(Pointer pointer) {
        Free_func_Pointer a = pointer;
        Free_func_Pointer a2 = this;
        super((Pointer)a);
    }

    public native void call(Pointer var1);
}
