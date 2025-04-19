/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByVal
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByVal;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Callback_Pointer_int_String_Pointer
extends FunctionPointer {
    public Callback_Pointer_int_String_Pointer(Pointer pointer) {
        Callback_Pointer_int_String_Pointer a = pointer;
        Callback_Pointer_int_String_Pointer a2 = this;
        super((Pointer)a);
    }

    protected Callback_Pointer_int_String_Pointer() {
        Callback_Pointer_int_String_Pointer a;
        Callback_Pointer_int_String_Pointer callback_Pointer_int_String_Pointer = a;
        callback_Pointer_int_String_Pointer.allocate();
    }

    public native void call(Pointer var1, int var2, String var3, @ByVal @Cast(value={"va_list*"}) Pointer var4);

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();
}
