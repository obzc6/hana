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
public class AVComponentDescriptor
extends Pointer {
    public native int depth();

    public native AVComponentDescriptor shift(int var1);

    private native /* synthetic */ void allocate();

    public native AVComponentDescriptor plane(int var1);

    public native AVComponentDescriptor offset(int var1);

    public AVComponentDescriptor(Pointer pointer) {
        AVComponentDescriptor a = pointer;
        AVComponentDescriptor a2 = this;
        super((Pointer)a);
    }

    public native AVComponentDescriptor step(int var1);

    public native AVComponentDescriptor depth(int var1);

    public AVComponentDescriptor(long a) {
        super((Pointer)null);
        AVComponentDescriptor a2;
        a2.allocateArray(a);
    }

    public native int shift();

    public native int step();

    public native int plane();

    private native /* synthetic */ void allocateArray(long var1);

    public native int offset();

    public AVComponentDescriptor position(long a) {
        AVComponentDescriptor a2;
        return (AVComponentDescriptor)super.position(a);
    }

    public AVComponentDescriptor() {
        super((Pointer)null);
        AVComponentDescriptor a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    public AVComponentDescriptor getPointer(long a) {
        AVComponentDescriptor a2;
        return (AVComponentDescriptor)new AVComponentDescriptor(a2).offsetAddress(a);
    }
}
