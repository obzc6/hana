/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.ByRef
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVTimecode
extends Pointer {
    @Cast(value={"unsigned"})
    public native int fps();

    public native AVTimecode rate(AVRational var1);

    public AVTimecode(Pointer pointer) {
        AVTimecode a = pointer;
        AVTimecode a2 = this;
        super((Pointer)a);
    }

    public native int start();

    public AVTimecode getPointer(long a) {
        AVTimecode a2;
        return (AVTimecode)new AVTimecode(a2).offsetAddress(a);
    }

    public AVTimecode() {
        super((Pointer)null);
        AVTimecode a;
        a.allocate();
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVTimecode position(long a) {
        AVTimecode a2;
        return (AVTimecode)super.position(a);
    }

    static {
        Loader.load();
    }

    public native AVTimecode start(int var1);

    @Cast(value={"uint32_t"})
    public native int flags();

    @ByRef
    public native AVRational rate();

    public native AVTimecode flags(int var1);

    public native AVTimecode fps(int var1);

    private native /* synthetic */ void allocate();

    public AVTimecode(long a) {
        super((Pointer)null);
        AVTimecode a2;
        a2.allocateArray(a);
    }
}
