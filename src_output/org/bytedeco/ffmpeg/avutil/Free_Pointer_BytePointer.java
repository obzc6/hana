/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Free_Pointer_BytePointer
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    public native void call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2);

    public Free_Pointer_BytePointer(Pointer pointer) {
        Free_Pointer_BytePointer a = pointer;
        Free_Pointer_BytePointer a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    protected Free_Pointer_BytePointer() {
        Free_Pointer_BytePointer a;
        Free_Pointer_BytePointer free_Pointer_BytePointer = a;
        free_Pointer_BytePointer.allocate();
    }
}
