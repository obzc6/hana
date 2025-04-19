/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Opaque
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.postproc;

import org.bytedeco.ffmpeg.presets.postproc;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Opaque;
import org.bytedeco.javacpp.annotation.Properties;

@Opaque
@Properties(inherit={postproc.class})
public class pp_mode
extends Pointer {
    public pp_mode() {
        super((Pointer)null);
        pp_mode a;
    }

    public pp_mode(Pointer pointer) {
        pp_mode a = pointer;
        pp_mode a2 = this;
        super((Pointer)a);
    }
}
