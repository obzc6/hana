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
public class ff_pad_helper_AVBPrint
extends Pointer {
    public native ff_pad_helper_AVBPrint size_max(int var1);

    @MemberGetter
    @Cast(value={"char*"})
    public native BytePointer reserved_internal_buffer();

    public native ff_pad_helper_AVBPrint len(int var1);

    public ff_pad_helper_AVBPrint getPointer(long a) {
        ff_pad_helper_AVBPrint a2;
        return (ff_pad_helper_AVBPrint)new ff_pad_helper_AVBPrint(a2).offsetAddress(a);
    }

    @Cast(value={"char*"})
    public native BytePointer str();

    private native /* synthetic */ void allocate();

    public native ff_pad_helper_AVBPrint reserved_internal_buffer(int var1, byte var2);

    @Cast(value={"char"})
    public native byte reserved_internal_buffer(int var1);

    public ff_pad_helper_AVBPrint() {
        super((Pointer)null);
        ff_pad_helper_AVBPrint a;
        a.allocate();
    }

    static {
        Loader.load();
    }

    public native ff_pad_helper_AVBPrint size(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"unsigned"})
    public native int size_max();

    public ff_pad_helper_AVBPrint(long a) {
        super((Pointer)null);
        ff_pad_helper_AVBPrint a2;
        a2.allocateArray(a);
    }

    @Cast(value={"unsigned"})
    public native int len();

    @Cast(value={"unsigned"})
    public native int size();

    public native ff_pad_helper_AVBPrint str(BytePointer var1);

    public ff_pad_helper_AVBPrint(Pointer pointer) {
        ff_pad_helper_AVBPrint a = pointer;
        ff_pad_helper_AVBPrint a2 = this;
        super((Pointer)a);
    }

    public ff_pad_helper_AVBPrint position(long a) {
        ff_pad_helper_AVBPrint a2;
        return (ff_pad_helper_AVBPrint)super.position(a);
    }
}
