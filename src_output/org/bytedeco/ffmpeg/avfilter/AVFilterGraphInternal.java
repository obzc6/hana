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
public class AVFilterGraphInternal
extends Pointer {
    public AVFilterGraphInternal() {
        super((Pointer)null);
        AVFilterGraphInternal a;
    }

    public AVFilterGraphInternal(Pointer pointer) {
        AVFilterGraphInternal a = pointer;
        AVFilterGraphInternal a2 = this;
        super((Pointer)a);
    }
}
