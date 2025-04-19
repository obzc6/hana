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
public class AVMD5
extends Pointer {
    public AVMD5() {
        super((Pointer)null);
        AVMD5 a;
    }

    public AVMD5(Pointer pointer) {
        AVMD5 a = pointer;
        AVMD5 a2 = this;
        super((Pointer)a);
    }
}
