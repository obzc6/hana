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
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVProfile
extends Pointer {
    private native /* synthetic */ void allocateArray(long var1);

    public AVProfile getPointer(long a) {
        AVProfile a2;
        return (AVProfile)new AVProfile(a2).offsetAddress(a);
    }

    static {
        Loader.load();
    }

    public AVProfile() {
        super((Pointer)null);
        AVProfile a;
        a.allocate();
    }

    public AVProfile(Pointer pointer) {
        AVProfile a = pointer;
        AVProfile a2 = this;
        super((Pointer)a);
    }

    public AVProfile(long a) {
        super((Pointer)null);
        AVProfile a2;
        a2.allocateArray(a);
    }

    public native AVProfile profile(int var1);

    private native /* synthetic */ void allocate();

    @Cast(value={"const char*"})
    public native BytePointer name();

    public native AVProfile name(BytePointer var1);

    public native int profile();

    public AVProfile position(long a) {
        AVProfile a2;
        return (AVProfile)super.position(a);
    }
}
