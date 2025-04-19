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
public class AVSubsampleEncryptionInfo
extends Pointer {
    public AVSubsampleEncryptionInfo position(long a) {
        AVSubsampleEncryptionInfo a2;
        return (AVSubsampleEncryptionInfo)super.position(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"unsigned int"})
    public native int bytes_of_protected_data();

    @Cast(value={"unsigned int"})
    public native int bytes_of_clear_data();

    public AVSubsampleEncryptionInfo getPointer(long a) {
        AVSubsampleEncryptionInfo a2;
        return (AVSubsampleEncryptionInfo)new AVSubsampleEncryptionInfo(a2).offsetAddress(a);
    }

    private native /* synthetic */ void allocate();

    public native AVSubsampleEncryptionInfo bytes_of_protected_data(int var1);

    public AVSubsampleEncryptionInfo(long a) {
        super((Pointer)null);
        AVSubsampleEncryptionInfo a2;
        a2.allocateArray(a);
    }

    public AVSubsampleEncryptionInfo() {
        super((Pointer)null);
        AVSubsampleEncryptionInfo a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    public native AVSubsampleEncryptionInfo bytes_of_clear_data(int var1);

    public AVSubsampleEncryptionInfo(Pointer pointer) {
        AVSubsampleEncryptionInfo a = pointer;
        AVSubsampleEncryptionInfo a2 = this;
        super((Pointer)a);
    }
}
