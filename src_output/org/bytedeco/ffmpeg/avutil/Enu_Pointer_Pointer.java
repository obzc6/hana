/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class Enu_Pointer_Pointer
extends FunctionPointer {
    public native int call(Pointer var1, Pointer var2);

    protected Enu_Pointer_Pointer() {
        Enu_Pointer_Pointer a;
        Enu_Pointer_Pointer enu_Pointer_Pointer = a;
        enu_Pointer_Pointer.allocate();
    }

    public Enu_Pointer_Pointer(Pointer pointer) {
        Enu_Pointer_Pointer a = pointer;
        Enu_Pointer_Pointer a2 = this;
        super((Pointer)a);
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();
}
