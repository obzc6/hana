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
public class Func_Pointer_Pointer_int
extends FunctionPointer {
    public native void call(Pointer var1, Pointer var2, int var3);

    static {
        Loader.load();
    }

    protected Func_Pointer_Pointer_int() {
        Func_Pointer_Pointer_int a;
        Func_Pointer_Pointer_int func_Pointer_Pointer_int = a;
        func_Pointer_Pointer_int.allocate();
    }

    public Func_Pointer_Pointer_int(Pointer pointer) {
        Func_Pointer_Pointer_int a = pointer;
        Func_Pointer_Pointer_int a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();
}
