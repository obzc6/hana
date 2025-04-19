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
public class LogCallback
extends FunctionPointer {
    public native void call(int var1, @Cast(value={"const char*"}) BytePointer var2);

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    protected LogCallback() {
        LogCallback a;
        LogCallback logCallback = a;
        logCallback.allocate();
    }

    public LogCallback(Pointer pointer) {
        LogCallback a = pointer;
        LogCallback a2 = this;
        super((Pointer)a);
    }
}
