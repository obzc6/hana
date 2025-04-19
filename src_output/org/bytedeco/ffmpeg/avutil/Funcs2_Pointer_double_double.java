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
public class Funcs2_Pointer_double_double
extends FunctionPointer {
    public Funcs2_Pointer_double_double(Pointer pointer) {
        Funcs2_Pointer_double_double a = pointer;
        Funcs2_Pointer_double_double a2 = this;
        super((Pointer)a);
    }

    protected Funcs2_Pointer_double_double() {
        Funcs2_Pointer_double_double a;
        Funcs2_Pointer_double_double funcs2_Pointer_double_double = a;
        funcs2_Pointer_double_double.allocate();
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public native double call(Pointer var1, double var2, double var4);
}
