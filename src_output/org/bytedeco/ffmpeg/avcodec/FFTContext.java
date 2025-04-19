/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={avcodec.class})
public class FFTContext
extends Pointer {
    public FFTContext(Pointer pointer) {
        FFTContext a = pointer;
        FFTContext a2 = this;
        super((Pointer)a);
    }

    public FFTContext() {
        super((Pointer)null);
        FFTContext a;
    }
}
