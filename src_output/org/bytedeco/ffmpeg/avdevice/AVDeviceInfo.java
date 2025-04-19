/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avdevice;

import org.bytedeco.ffmpeg.presets.avdevice;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avdevice.class})
public class AVDeviceInfo
extends Pointer {
    private native /* synthetic */ void allocateArray(long var1);

    public native AVDeviceInfo device_description(BytePointer var1);

    public native int nb_media_types();

    public AVDeviceInfo position(long a) {
        AVDeviceInfo a2;
        return (AVDeviceInfo)super.position(a);
    }

    public native AVDeviceInfo nb_media_types(int var1);

    @Cast(value={"char*"})
    public native BytePointer device_name();

    @Cast(value={"AVMediaType*"})
    public native IntPointer media_types();

    public native AVDeviceInfo media_types(IntPointer var1);

    public AVDeviceInfo(Pointer pointer) {
        AVDeviceInfo a = pointer;
        AVDeviceInfo a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public AVDeviceInfo(long a) {
        super((Pointer)null);
        AVDeviceInfo a2;
        a2.allocateArray(a);
    }

    static {
        Loader.load();
    }

    @Cast(value={"char*"})
    public native BytePointer device_description();

    public AVDeviceInfo getPointer(long a) {
        AVDeviceInfo a2;
        return (AVDeviceInfo)new AVDeviceInfo(a2).offsetAddress(a);
    }

    public AVDeviceInfo() {
        super((Pointer)null);
        AVDeviceInfo a;
        a.allocate();
    }

    public native AVDeviceInfo device_name(BytePointer var1);
}
