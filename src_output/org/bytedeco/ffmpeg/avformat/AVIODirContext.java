/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVIODirContext
extends Pointer {
    static {
        Loader.load();
    }

    public AVIODirContext() {
        super((Pointer)null);
        AVIODirContext a;
        a.allocate();
    }

    public native AVIODirContext url_context(Pointer var1);

    private native /* synthetic */ void allocateArray(long var1);

    public AVIODirContext(Pointer pointer) {
        AVIODirContext a = pointer;
        AVIODirContext a2 = this;
        super((Pointer)a);
    }

    @Cast(value={"URLContext*"})
    public native Pointer url_context();

    public AVIODirContext getPointer(long a) {
        AVIODirContext a2;
        return (AVIODirContext)new AVIODirContext(a2).offsetAddress(a);
    }

    public AVIODirContext(long a) {
        super((Pointer)null);
        AVIODirContext a2;
        a2.allocateArray(a);
    }

    public AVIODirContext position(long a) {
        AVIODirContext a2;
        return (AVIODirContext)super.position(a);
    }

    private native /* synthetic */ void allocate();
}
