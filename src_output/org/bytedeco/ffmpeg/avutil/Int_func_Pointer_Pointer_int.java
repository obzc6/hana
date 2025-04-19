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
public class Int_func_Pointer_Pointer_int
extends FunctionPointer {
    public Int_func_Pointer_Pointer_int(Pointer pointer) {
        Int_func_Pointer_Pointer_int a = pointer;
        Int_func_Pointer_Pointer_int a2 = this;
        super((Pointer)a);
    }

    protected Int_func_Pointer_Pointer_int() {
        Int_func_Pointer_Pointer_int a;
        Int_func_Pointer_Pointer_int int_func_Pointer_Pointer_int = a;
        int_func_Pointer_Pointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native int call(Pointer var1, Pointer var2, int var3);
}
