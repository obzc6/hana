/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVStereo3D
extends Pointer {
    @Cast(value={"AVStereo3DView"})
    public native int view();

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    public AVStereo3D position(long a) {
        AVStereo3D a2;
        return (AVStereo3D)super.position(a);
    }

    public native AVStereo3D type(int var1);

    public AVStereo3D() {
        super((Pointer)null);
        AVStereo3D a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    @Cast(value={"AVStereo3DType"})
    public native int type();

    public native AVStereo3D flags(int var1);

    public native AVStereo3D view(int var1);

    public native int flags();

    public AVStereo3D getPointer(long a) {
        AVStereo3D a2;
        return (AVStereo3D)new AVStereo3D(a2).offsetAddress(a);
    }

    public AVStereo3D(long a) {
        super((Pointer)null);
        AVStereo3D a2;
        a2.allocateArray(a);
    }

    public AVStereo3D(Pointer pointer) {
        AVStereo3D a = pointer;
        AVStereo3D a2 = this;
        super((Pointer)a);
    }
}
