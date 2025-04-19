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
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVIODirEntry
extends Pointer {
    @Cast(value={"int64_t"})
    public native long user_id();

    @Cast(value={"int64_t"})
    public native long status_change_timestamp();

    public AVIODirEntry() {
        super((Pointer)null);
        AVIODirEntry a;
        a.allocate();
    }

    private native /* synthetic */ void allocate();

    public native AVIODirEntry type(int var1);

    public native int utf8();

    public native AVIODirEntry modification_timestamp(long var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"char*"})
    public native BytePointer name();

    public native AVIODirEntry access_timestamp(long var1);

    public native AVIODirEntry utf8(int var1);

    public AVIODirEntry(Pointer pointer) {
        AVIODirEntry a = pointer;
        AVIODirEntry a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"int64_t"})
    public native long modification_timestamp();

    static {
        Loader.load();
    }

    public AVIODirEntry position(long a) {
        AVIODirEntry a2;
        return (AVIODirEntry)super.position(a);
    }

    @Cast(value={"int64_t"})
    public native long group_id();

    public AVIODirEntry(long a) {
        super((Pointer)null);
        AVIODirEntry a2;
        a2.allocateArray(a);
    }

    @Cast(value={"int64_t"})
    public native long size();

    public native AVIODirEntry size(long var1);

    public native AVIODirEntry filemode(long var1);

    public native AVIODirEntry user_id(long var1);

    public native int type();

    public native AVIODirEntry name(BytePointer var1);

    public native AVIODirEntry status_change_timestamp(long var1);

    @Cast(value={"int64_t"})
    public native long filemode();

    @Cast(value={"int64_t"})
    public native long access_timestamp();

    public native AVIODirEntry group_id(long var1);

    public AVIODirEntry getPointer(long a) {
        AVIODirEntry a2;
        return (AVIODirEntry)new AVIODirEntry(a2).offsetAddress(a);
    }
}
