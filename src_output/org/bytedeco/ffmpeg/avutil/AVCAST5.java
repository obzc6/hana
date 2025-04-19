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
public class AVCAST5
extends Pointer {
    public AVCAST5() {
        super((Pointer)null);
        AVCAST5 a;
    }

    public AVCAST5(Pointer pointer) {
        AVCAST5 a = pointer;
        AVCAST5 a2 = this;
        super((Pointer)a);
    }
}
