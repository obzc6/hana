/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.swscale;

import org.bytedeco.ffmpeg.presets.swscale;
import org.bytedeco.ffmpeg.swscale.SwsVector;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={swscale.class})
public class SwsFilter
extends Pointer {
    public native SwsVector lumV();

    public native SwsFilter lumH(SwsVector var1);

    public SwsFilter() {
        super((Pointer)null);
        SwsFilter a;
        a.allocate();
    }

    public native SwsFilter chrH(SwsVector var1);

    public SwsFilter getPointer(long a) {
        SwsFilter a2;
        return (SwsFilter)new SwsFilter(a2).offsetAddress(a);
    }

    public native SwsVector chrV();

    public native SwsVector lumH();

    private native /* synthetic */ void allocateArray(long var1);

    public SwsFilter(long a) {
        super((Pointer)null);
        SwsFilter a2;
        a2.allocateArray(a);
    }

    public SwsFilter position(long a) {
        SwsFilter a2;
        return (SwsFilter)super.position(a);
    }

    public native SwsFilter chrV(SwsVector var1);

    public SwsFilter(Pointer pointer) {
        SwsFilter a = pointer;
        SwsFilter a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native SwsFilter lumV(SwsVector var1);

    static {
        Loader.load();
    }

    public native SwsVector chrH();
}
