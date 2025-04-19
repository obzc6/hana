/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.DoublePointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.swscale;

import org.bytedeco.ffmpeg.presets.swscale;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={swscale.class})
public class SwsVector
extends Pointer {
    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native SwsVector length(int var1);

    public SwsVector position(long a) {
        SwsVector a2;
        return (SwsVector)super.position(a);
    }

    public native DoublePointer coeff();

    public native int length();

    public SwsVector getPointer(long a) {
        SwsVector a2;
        return (SwsVector)new SwsVector(a2).offsetAddress(a);
    }

    public SwsVector(Pointer pointer) {
        SwsVector a = pointer;
        SwsVector a2 = this;
        super((Pointer)a);
    }

    public SwsVector() {
        super((Pointer)null);
        SwsVector a;
        a.allocate();
    }

    public native SwsVector coeff(DoublePointer var1);

    public SwsVector(long a) {
        super((Pointer)null);
        SwsVector a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocateArray(long var1);
}
