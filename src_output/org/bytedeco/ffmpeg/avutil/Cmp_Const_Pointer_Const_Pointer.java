/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Cmp_Const_Pointer_Const_Pointer
extends FunctionPointer {
    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    protected Cmp_Const_Pointer_Const_Pointer() {
        Cmp_Const_Pointer_Const_Pointer a;
        Cmp_Const_Pointer_Const_Pointer cmp_Const_Pointer_Const_Pointer = a;
        cmp_Const_Pointer_Const_Pointer.allocate();
    }

    public Cmp_Const_Pointer_Const_Pointer(Pointer pointer) {
        Cmp_Const_Pointer_Const_Pointer a = pointer;
        Cmp_Const_Pointer_Const_Pointer a2 = this;
        super((Pointer)a);
    }

    public native int call(@Const Pointer var1, @Const Pointer var2);
}
