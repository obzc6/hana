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
public class Pool_free_Pointer
extends FunctionPointer {
    public native void call(Pointer var1);

    protected Pool_free_Pointer() {
        Pool_free_Pointer a;
        Pool_free_Pointer pool_free_Pointer = a;
        pool_free_Pointer.allocate();
    }

    public Pool_free_Pointer(Pointer pointer) {
        Pool_free_Pointer a = pointer;
        Pool_free_Pointer a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }
}
