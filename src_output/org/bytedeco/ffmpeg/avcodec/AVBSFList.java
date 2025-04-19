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
public class AVBSFList
extends Pointer {
    public AVBSFList() {
        super((Pointer)null);
        AVBSFList a;
    }

    public AVBSFList(Pointer pointer) {
        AVBSFList a = pointer;
        AVBSFList a2 = this;
        super((Pointer)a);
    }
}
