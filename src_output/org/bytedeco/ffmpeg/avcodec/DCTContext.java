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
public class DCTContext
extends Pointer {
    public DCTContext(Pointer pointer) {
        DCTContext a = pointer;
        DCTContext a2 = this;
        super((Pointer)a);
    }

    public DCTContext() {
        super((Pointer)null);
        DCTContext a;
    }
}
