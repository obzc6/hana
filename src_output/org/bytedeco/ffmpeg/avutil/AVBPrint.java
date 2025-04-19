/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVBPrint
extends Pointer {
    @Cast(value={"unsigned"})
    public native int len();

    @Cast(value={"unsigned"})
    public native int size();

    public AVBPrint() {
        super((Pointer)null);
        AVBPrint a;
        a.allocate();
    }

    @Cast(value={"char"})
    public native byte reserved_internal_buffer(int var1);

    @MemberGetter
    @Cast(value={"char*"})
    public native BytePointer reserved_padding();

    private native /* synthetic */ void allocate();

    public AVBPrint(long a) {
        super((Pointer)null);
        AVBPrint a2;
        a2.allocateArray(a);
    }

    public native AVBPrint size_max(int var1);

    @Cast(value={"unsigned"})
    public native int size_max();

    public AVBPrint position(long a) {
        AVBPrint a2;
        return (AVBPrint)super.position(a);
    }

    public AVBPrint getPointer(long a) {
        AVBPrint a2;
        return (AVBPrint)new AVBPrint(a2).offsetAddress(a);
    }

    static {
        Loader.load();
    }

    public native AVBPrint reserved_internal_buffer(int var1, byte var2);

    @MemberGetter
    @Cast(value={"char*"})
    public native BytePointer reserved_internal_buffer();

    public native AVBPrint reserved_padding(int var1, byte var2);

    @Cast(value={"char"})
    public native byte reserved_padding(int var1);

    public native AVBPrint size(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVBPrint str(BytePointer var1);

    @Cast(value={"char*"})
    public native BytePointer str();

    public native AVBPrint len(int var1);

    public AVBPrint(Pointer pointer) {
        AVBPrint a = pointer;
        AVBPrint a2 = this;
        super((Pointer)a);
    }
}
