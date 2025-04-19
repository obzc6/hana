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
package org.bytedeco.ffmpeg.avformat;

import java.nio.ByteBuffer;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class Read_packet_Pointer_ByteBuffer_int
extends FunctionPointer {
    static {
        Loader.load();
    }

    public native int call(Pointer var1, @Cast(value={"uint8_t*"}) ByteBuffer var2, int var3);

    public Read_packet_Pointer_ByteBuffer_int(Pointer pointer) {
        Read_packet_Pointer_ByteBuffer_int a = pointer;
        Read_packet_Pointer_ByteBuffer_int a2 = this;
        super((Pointer)a);
    }

    protected Read_packet_Pointer_ByteBuffer_int() {
        Read_packet_Pointer_ByteBuffer_int a;
        Read_packet_Pointer_ByteBuffer_int read_packet_Pointer_ByteBuffer_int = a;
        read_packet_Pointer_ByteBuffer_int.allocate();
    }

    private native /* synthetic */ void allocate();
}
