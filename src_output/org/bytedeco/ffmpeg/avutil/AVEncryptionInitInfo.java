/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVEncryptionInitInfo
extends Pointer {
    @Cast(value={"uint8_t*"})
    public native BytePointer system_id();

    public AVEncryptionInitInfo getPointer(long a) {
        AVEncryptionInitInfo a2;
        return (AVEncryptionInitInfo)new AVEncryptionInitInfo(a2).offsetAddress(a);
    }

    @Cast(value={"uint32_t"})
    public native int key_id_size();

    public native AVEncryptionInitInfo system_id_size(int var1);

    static {
        Loader.load();
    }

    @Cast(value={"uint32_t"})
    public native int data_size();

    public AVEncryptionInitInfo position(long a) {
        AVEncryptionInitInfo a2;
        return (AVEncryptionInitInfo)super.position(a);
    }

    @Cast(value={"uint8_t*"})
    public native BytePointer data();

    public native AVEncryptionInitInfo system_id(BytePointer var1);

    public native AVEncryptionInitInfo key_ids(PointerPointer var1);

    @Cast(value={"uint32_t"})
    public native int num_key_ids();

    public native AVEncryptionInitInfo data_size(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVEncryptionInitInfo num_key_ids(int var1);

    public native AVEncryptionInitInfo next(AVEncryptionInitInfo var1);

    public native AVEncryptionInitInfo key_id_size(int var1);

    public AVEncryptionInitInfo(long a) {
        super((Pointer)null);
        AVEncryptionInitInfo a2;
        a2.allocateArray(a);
    }

    @Cast(value={"uint8_t**"})
    public native PointerPointer key_ids();

    private native /* synthetic */ void allocate();

    public native AVEncryptionInitInfo data(BytePointer var1);

    @Cast(value={"uint32_t"})
    public native int system_id_size();

    public native AVEncryptionInitInfo next();

    public AVEncryptionInitInfo() {
        super((Pointer)null);
        AVEncryptionInitInfo a;
        a.allocate();
    }

    public native AVEncryptionInitInfo key_ids(int var1, BytePointer var2);

    public AVEncryptionInitInfo(Pointer pointer) {
        AVEncryptionInitInfo a = pointer;
        AVEncryptionInitInfo a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"uint8_t*"})
    public native BytePointer key_ids(int var1);
}
