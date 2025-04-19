/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import java.nio.ByteBuffer;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Free_Pointer_ByteBuffer
extends FunctionPointer {
    static {
        Loader.load();
    }

    protected Free_Pointer_ByteBuffer() {
        Free_Pointer_ByteBuffer a;
        Free_Pointer_ByteBuffer free_Pointer_ByteBuffer = a;
        free_Pointer_ByteBuffer.allocate();
    }

    public Free_Pointer_ByteBuffer(Pointer pointer) {
        Free_Pointer_ByteBuffer a = pointer;
        Free_Pointer_ByteBuffer a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native void call(Pointer var1, @Cast(value={"uint8_t*"}) ByteBuffer var2);
}
