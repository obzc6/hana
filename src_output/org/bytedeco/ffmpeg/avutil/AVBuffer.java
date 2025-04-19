/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={avutil.class})
public class AVBuffer
extends Pointer {
    public AVBuffer(Pointer pointer) {
        AVBuffer a = pointer;
        AVBuffer a2 = this;
        super((Pointer)a);
    }

    public AVBuffer() {
        super((Pointer)null);
        AVBuffer a;
    }
}
