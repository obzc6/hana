/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVProducerReferenceTime
extends Pointer {
    private native /* synthetic */ void allocate();

    public AVProducerReferenceTime position(long a) {
        AVProducerReferenceTime a2;
        return (AVProducerReferenceTime)super.position(a);
    }

    public AVProducerReferenceTime() {
        super((Pointer)null);
        AVProducerReferenceTime a;
        a.allocate();
    }

    public native AVProducerReferenceTime wallclock(long var1);

    public native int flags();

    public AVProducerReferenceTime getPointer(long a) {
        AVProducerReferenceTime a2;
        return (AVProducerReferenceTime)new AVProducerReferenceTime(a2).offsetAddress(a);
    }

    public native AVProducerReferenceTime flags(int var1);

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVProducerReferenceTime(Pointer pointer) {
        AVProducerReferenceTime a = pointer;
        AVProducerReferenceTime a2 = this;
        super((Pointer)a);
    }

    public AVProducerReferenceTime(long a) {
        super((Pointer)null);
        AVProducerReferenceTime a2;
        a2.allocateArray(a);
    }

    @Cast(value={"int64_t"})
    public native long wallclock();
}
