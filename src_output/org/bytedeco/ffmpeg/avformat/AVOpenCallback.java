/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVIOInterruptCB;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVOpenCallback
extends FunctionPointer {
    public native int call(AVFormatContext var1, @Cast(value={"AVIOContext**"}) PointerPointer var2, @Cast(value={"const char*"}) BytePointer var3, int var4, @Const AVIOInterruptCB var5, @Cast(value={"AVDictionary**"}) PointerPointer var6);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public AVOpenCallback(Pointer pointer) {
        AVOpenCallback a = pointer;
        AVOpenCallback a2 = this;
        super((Pointer)a);
    }

    protected AVOpenCallback() {
        AVOpenCallback a;
        AVOpenCallback aVOpenCallback = a;
        aVOpenCallback.allocate();
    }
}
