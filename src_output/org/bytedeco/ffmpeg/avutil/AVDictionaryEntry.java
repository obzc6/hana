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

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVDictionaryEntry
extends Pointer {
    public AVDictionaryEntry(long a) {
        super((Pointer)null);
        AVDictionaryEntry a2;
        a2.allocateArray(a);
    }

    @Cast(value={"char*"})
    public native BytePointer key();

    public native AVDictionaryEntry key(BytePointer var1);

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public AVDictionaryEntry() {
        super((Pointer)null);
        AVDictionaryEntry a;
        a.allocate();
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native AVDictionaryEntry value(BytePointer var1);

    public AVDictionaryEntry(Pointer pointer) {
        AVDictionaryEntry a = pointer;
        AVDictionaryEntry a2 = this;
        super((Pointer)a);
    }

    public AVDictionaryEntry getPointer(long a) {
        AVDictionaryEntry a2;
        return (AVDictionaryEntry)new AVDictionaryEntry(a2).offsetAddress(a);
    }

    @Cast(value={"char*"})
    public native BytePointer value();

    public AVDictionaryEntry position(long a) {
        AVDictionaryEntry a2;
        return (AVDictionaryEntry)super.position(a);
    }
}
