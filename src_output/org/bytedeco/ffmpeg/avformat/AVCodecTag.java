/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={avformat.class})
public class AVCodecTag
extends Pointer {
    public AVCodecTag() {
        super((Pointer)null);
        AVCodecTag a;
    }

    public AVCodecTag(Pointer pointer) {
        AVCodecTag a = pointer;
        AVCodecTag a2 = this;
        super((Pointer)a);
    }
}
