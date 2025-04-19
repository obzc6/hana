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
public class pp_context
extends Pointer {
    public pp_context(Pointer pointer) {
        pp_context a = pointer;
        pp_context a2 = this;
        super((Pointer)a);
    }

    public pp_context() {
        super((Pointer)null);
        pp_context a;
    }
}
