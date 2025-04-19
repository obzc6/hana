/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avdevice;

import org.bytedeco.ffmpeg.avdevice.AVDeviceInfo;
import org.bytedeco.ffmpeg.presets.avdevice;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avdevice.class})
public class AVDeviceInfoList
extends Pointer {
    public native AVDeviceInfo devices(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"AVDeviceInfo**"})
    public native PointerPointer devices();

    public native AVDeviceInfoList nb_devices(int var1);

    static {
        Loader.load();
    }

    public native AVDeviceInfoList default_device(int var1);

    public AVDeviceInfoList() {
        super((Pointer)null);
        AVDeviceInfoList a;
        a.allocate();
    }

    public native AVDeviceInfoList devices(PointerPointer var1);

    public AVDeviceInfoList position(long a) {
        AVDeviceInfoList a2;
        return (AVDeviceInfoList)super.position(a);
    }

    public AVDeviceInfoList(long a) {
        super((Pointer)null);
        AVDeviceInfoList a2;
        a2.allocateArray(a);
    }

    public AVDeviceInfoList(Pointer pointer) {
        AVDeviceInfoList a = pointer;
        AVDeviceInfoList a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native int nb_devices();

    public native int default_device();

    public native AVDeviceInfoList devices(int var1, AVDeviceInfo var2);

    public AVDeviceInfoList getPointer(long a) {
        AVDeviceInfoList a2;
        return (AVDeviceInfoList)new AVDeviceInfoList(a2).offsetAddress(a);
    }
}
