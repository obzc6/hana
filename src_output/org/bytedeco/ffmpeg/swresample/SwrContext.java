/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.swresample;

import org.bytedeco.ffmpeg.presets.swresample;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={swresample.class})
public class SwrContext
extends Pointer {
    public SwrContext() {
        super((Pointer)null);
        SwrContext a;
    }

    public SwrContext(Pointer pointer) {
        SwrContext a = pointer;
        SwrContext a2 = this;
        super((Pointer)a);
    }
}
