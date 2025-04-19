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
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class Read_packet_Pointer_BytePointer_int
extends FunctionPointer {
    protected Read_packet_Pointer_BytePointer_int() {
        Read_packet_Pointer_BytePointer_int a;
        Read_packet_Pointer_BytePointer_int read_packet_Pointer_BytePointer_int = a;
        read_packet_Pointer_BytePointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native int call(Pointer var1, @Cast(value={"uint8_t*"}) BytePointer var2, int var3);

    public Read_packet_Pointer_BytePointer_int(Pointer pointer) {
        Read_packet_Pointer_BytePointer_int a = pointer;
        Read_packet_Pointer_BytePointer_int a2 = this;
        super((Pointer)a);
    }
}
