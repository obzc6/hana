/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avformat.class})
public class AVIOInterruptCB
extends Pointer {
    public native Callback_Pointer callback();

    private native /* synthetic */ void allocate();

    public AVIOInterruptCB(Pointer pointer) {
        AVIOInterruptCB a = pointer;
        AVIOInterruptCB a2 = this;
        super((Pointer)a);
    }

    public AVIOInterruptCB getPointer(long a) {
        AVIOInterruptCB a2;
        return (AVIOInterruptCB)new AVIOInterruptCB(a2).offsetAddress(a);
    }

    public native AVIOInterruptCB callback(Callback_Pointer var1);

    public native AVIOInterruptCB opaque(Pointer var1);

    public native Pointer opaque();

    public AVIOInterruptCB() {
        super((Pointer)null);
        AVIOInterruptCB a;
        a.allocate();
    }

    private native /* synthetic */ void allocateArray(long var1);

    static {
        Loader.load();
    }

    public AVIOInterruptCB(long a) {
        super((Pointer)null);
        AVIOInterruptCB a2;
        a2.allocateArray(a);
    }

    public AVIOInterruptCB position(long a) {
        AVIOInterruptCB a2;
        return (AVIOInterruptCB)super.position(a);
    }

    public static class Callback_Pointer
    extends FunctionPointer {
        private native /* synthetic */ void allocate();

        public native int call(Pointer var1);

        static {
            Loader.load();
        }

        public Callback_Pointer(Pointer pointer) {
            Callback_Pointer a = pointer;
            Callback_Pointer a2 = this;
            super((Pointer)a);
        }

        protected Callback_Pointer() {
            Callback_Pointer a;
            Callback_Pointer callback_Pointer = a;
            callback_Pointer.allocate();
        }
    }

}
