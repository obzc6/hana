/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVRational
extends Pointer {
    static {
        Loader.load();
    }

    public AVRational(long a) {
        super((Pointer)null);
        AVRational a2;
        a2.allocateArray(a);
    }

    public AVRational getPointer(long a) {
        AVRational a2;
        return (AVRational)new AVRational(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocate();

    public AVRational() {
        super((Pointer)null);
        AVRational a;
        a.allocate();
    }

    public AVRational position(long a) {
        AVRational a2;
        return (AVRational)super.position(a);
    }

    public native int num();

    public native int den();

    public native AVRational num(int var1);

    public native AVRational den(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    public AVRational(Pointer pointer) {
        AVRational a = pointer;
        AVRational a2 = this;
        super((Pointer)a);
    }
}
