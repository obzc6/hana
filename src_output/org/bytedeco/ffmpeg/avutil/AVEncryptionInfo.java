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
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVSubsampleEncryptionInfo;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVEncryptionInfo
extends Pointer {
    public AVEncryptionInfo getPointer(long a) {
        AVEncryptionInfo a2;
        return (AVEncryptionInfo)new AVEncryptionInfo(a2).offsetAddress(a);
    }

    public native AVEncryptionInfo subsamples(AVSubsampleEncryptionInfo var1);

    public native AVEncryptionInfo scheme(int var1);

    public native AVSubsampleEncryptionInfo subsamples();

    public native AVEncryptionInfo iv_size(int var1);

    @Cast(value={"uint8_t*"})
    public native BytePointer iv();

    public native AVEncryptionInfo key_id_size(int var1);

    @Cast(value={"uint32_t"})
    public native int skip_byte_block();

    public native AVEncryptionInfo crypt_byte_block(int var1);

    static {
        Loader.load();
    }

    @Cast(value={"uint32_t"})
    public native int subsample_count();

    private native /* synthetic */ void allocateArray(long var1);

    public AVEncryptionInfo(Pointer pointer) {
        AVEncryptionInfo a = pointer;
        AVEncryptionInfo a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    @Cast(value={"uint32_t"})
    public native int crypt_byte_block();

    public native AVEncryptionInfo skip_byte_block(int var1);

    public AVEncryptionInfo() {
        super((Pointer)null);
        AVEncryptionInfo a;
        a.allocate();
    }

    public AVEncryptionInfo(long a) {
        super((Pointer)null);
        AVEncryptionInfo a2;
        a2.allocateArray(a);
    }

    @Cast(value={"uint32_t"})
    public native int iv_size();

    public native AVEncryptionInfo key_id(BytePointer var1);

    public native AVEncryptionInfo iv(BytePointer var1);

    @Cast(value={"uint32_t"})
    public native int key_id_size();

    public native AVEncryptionInfo subsample_count(int var1);

    @Cast(value={"uint8_t*"})
    public native BytePointer key_id();

    public AVEncryptionInfo position(long a) {
        AVEncryptionInfo a2;
        return (AVEncryptionInfo)super.position(a);
    }

    @Cast(value={"uint32_t"})
    public native int scheme();
}
