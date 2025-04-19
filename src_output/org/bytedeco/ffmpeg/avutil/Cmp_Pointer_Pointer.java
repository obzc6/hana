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
public class Cmp_Pointer_Pointer
extends FunctionPointer {
    protected Cmp_Pointer_Pointer() {
        Cmp_Pointer_Pointer a;
        Cmp_Pointer_Pointer cmp_Pointer_Pointer = a;
        cmp_Pointer_Pointer.allocate();
    }

    private native /* synthetic */ void allocate();

    public Cmp_Pointer_Pointer(Pointer pointer) {
        Cmp_Pointer_Pointer a = pointer;
        Cmp_Pointer_Pointer a2 = this;
        super((Pointer)a);
    }

    public native int call(Pointer var1, Pointer var2);

    static {
        Loader.load();
    }
}
