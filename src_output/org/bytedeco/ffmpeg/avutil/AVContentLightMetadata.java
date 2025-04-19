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
public class AVContentLightMetadata
extends Pointer {
    @Cast(value={"unsigned"})
    public native int MaxCLL();

    public native AVContentLightMetadata MaxFALL(int var1);

    private native /* synthetic */ void allocate();

    public AVContentLightMetadata(long a) {
        super((Pointer)null);
        AVContentLightMetadata a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native AVContentLightMetadata MaxCLL(int var1);

    public AVContentLightMetadata(Pointer pointer) {
        AVContentLightMetadata a = pointer;
        AVContentLightMetadata a2 = this;
        super((Pointer)a);
    }

    public AVContentLightMetadata getPointer(long a) {
        AVContentLightMetadata a2;
        return (AVContentLightMetadata)new AVContentLightMetadata(a2).offsetAddress(a);
    }

    public AVContentLightMetadata() {
        super((Pointer)null);
        AVContentLightMetadata a;
        a.allocate();
    }

    public AVContentLightMetadata position(long a) {
        AVContentLightMetadata a2;
        return (AVContentLightMetadata)super.position(a);
    }

    @Cast(value={"unsigned"})
    public native int MaxFALL();
}
