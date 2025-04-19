/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={avfilter.class})
public class AVFilterPad
extends Pointer {
    public AVFilterPad(Pointer pointer) {
        AVFilterPad a = pointer;
        AVFilterPad a2 = this;
        super((Pointer)a);
    }

    public AVFilterPad() {
        super((Pointer)null);
        AVFilterPad a;
    }
}
