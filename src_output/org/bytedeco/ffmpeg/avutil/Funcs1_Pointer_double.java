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
public class Funcs1_Pointer_double
extends FunctionPointer {
    public native double call(Pointer var1, double var2);

    protected Funcs1_Pointer_double() {
        Funcs1_Pointer_double a;
        Funcs1_Pointer_double funcs1_Pointer_double = a;
        funcs1_Pointer_double.allocate();
    }

    public Funcs1_Pointer_double(Pointer pointer) {
        Funcs1_Pointer_double a = pointer;
        Funcs1_Pointer_double a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }
}
