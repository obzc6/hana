/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avdevice;

import org.bytedeco.ffmpeg.presets.avdevice;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avdevice.class})
public class AVDeviceRect
extends Pointer {
    public AVDeviceRect(Pointer pointer) {
        AVDeviceRect a = pointer;
        AVDeviceRect a2 = this;
        super((Pointer)a);
    }

    public native int x();

    public native AVDeviceRect y(int var1);

    static {
        Loader.load();
    }

    public native int width();

    public AVDeviceRect position(long a) {
        AVDeviceRect a2;
        return (AVDeviceRect)super.position(a);
    }

    public AVDeviceRect getPointer(long a) {
        AVDeviceRect a2;
        return (AVDeviceRect)new AVDeviceRect(a2).offsetAddress(a);
    }

    public native AVDeviceRect x(int var1);

    public native AVDeviceRect height(int var1);

    public AVDeviceRect(long a) {
        super((Pointer)null);
        AVDeviceRect a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    private native /* synthetic */ void allocate();

    public native int y();

    public native int height();

    public AVDeviceRect() {
        super((Pointer)null);
        AVDeviceRect a;
        a.allocate();
    }

    public native AVDeviceRect width(int var1);
}
