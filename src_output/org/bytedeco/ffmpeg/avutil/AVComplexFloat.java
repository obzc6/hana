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
public class AVComplexFloat
extends Pointer {
    public native float re();

    private native /* synthetic */ void allocate();

    public native float im();

    public native AVComplexFloat im(float var1);

    public native AVComplexFloat re(float var1);

    public AVComplexFloat getPointer(long a) {
        AVComplexFloat a2;
        return (AVComplexFloat)new AVComplexFloat(a2).offsetAddress(a);
    }

    public AVComplexFloat(Pointer pointer) {
        AVComplexFloat a = pointer;
        AVComplexFloat a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocateArray(long var1);

    public AVComplexFloat position(long a) {
        AVComplexFloat a2;
        return (AVComplexFloat)super.position(a);
    }

    public AVComplexFloat() {
        super((Pointer)null);
        AVComplexFloat a;
        a.allocate();
    }

    public AVComplexFloat(long a) {
        super((Pointer)null);
        AVComplexFloat a2;
        a2.allocateArray(a);
    }
}
