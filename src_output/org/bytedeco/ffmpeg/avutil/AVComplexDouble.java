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
public class AVComplexDouble
extends Pointer {
    public native AVComplexDouble re(double var1);

    public AVComplexDouble(long a) {
        super((Pointer)null);
        AVComplexDouble a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocate();

    public native double re();

    public AVComplexDouble getPointer(long a) {
        AVComplexDouble a2;
        return (AVComplexDouble)new AVComplexDouble(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native AVComplexDouble im(double var1);

    public native double im();

    public AVComplexDouble(Pointer pointer) {
        AVComplexDouble a = pointer;
        AVComplexDouble a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    public AVComplexDouble position(long a) {
        AVComplexDouble a2;
        return (AVComplexDouble)super.position(a);
    }

    public AVComplexDouble() {
        super((Pointer)null);
        AVComplexDouble a;
        a.allocate();
    }
}
