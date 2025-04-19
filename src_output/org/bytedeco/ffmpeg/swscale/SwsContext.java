/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.swscale;

import org.bytedeco.ffmpeg.presets.swscale;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={swscale.class})
public class SwsContext
extends Pointer {
    public SwsContext() {
        super((Pointer)null);
        SwsContext a;
    }

    public SwsContext(Pointer pointer) {
        SwsContext a = pointer;
        SwsContext a2 = this;
        super((Pointer)a);
    }
}
