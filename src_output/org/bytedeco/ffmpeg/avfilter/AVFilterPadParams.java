/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avfilter.class})
public class AVFilterPadParams
extends Pointer {
    public AVFilterPadParams(long a) {
        super((Pointer)null);
        AVFilterPadParams a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    public AVFilterPadParams position(long a) {
        AVFilterPadParams a2;
        return (AVFilterPadParams)super.position(a);
    }

    public AVFilterPadParams getPointer(long a) {
        AVFilterPadParams a2;
        return (AVFilterPadParams)new AVFilterPadParams(a2).offsetAddress(a);
    }

    public AVFilterPadParams(Pointer pointer) {
        AVFilterPadParams a = pointer;
        AVFilterPadParams a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVFilterPadParams() {
        super((Pointer)null);
        AVFilterPadParams a;
        a.allocate();
    }

    @Cast(value={"char*"})
    public native BytePointer label();

    private native /* synthetic */ void allocate();

    public native AVFilterPadParams label(BytePointer var1);
}
