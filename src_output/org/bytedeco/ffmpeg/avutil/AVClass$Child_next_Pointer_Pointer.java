/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVClass.Child_next_Pointer_Pointer
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    public AVClass.Child_next_Pointer_Pointer(Pointer pointer) {
        AVClass.Child_next_Pointer_Pointer a = pointer;
        AVClass.Child_next_Pointer_Pointer a2 = this;
        super((Pointer)a);
    }

    public native Pointer call(Pointer var1, Pointer var2);

    protected AVClass.Child_next_Pointer_Pointer() {
        AVClass.Child_next_Pointer_Pointer a;
        AVClass.Child_next_Pointer_Pointer child_next_Pointer_Pointer = a;
        child_next_Pointer_Pointer.allocate();
    }

    static {
        Loader.load();
    }
}
