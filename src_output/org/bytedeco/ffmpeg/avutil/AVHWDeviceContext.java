/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Name
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.avutil.AVHWDeviceInternal;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVHWDeviceContext
extends Pointer {
    public native AVHWDeviceContext av_class(AVClass var1);

    public native AVHWDeviceContext internal(AVHWDeviceInternal var1);

    @Const
    public native AVClass av_class();

    public AVHWDeviceContext getPointer(long a) {
        AVHWDeviceContext a2;
        return (AVHWDeviceContext)new AVHWDeviceContext(a2).offsetAddress(a);
    }

    public native AVHWDeviceContext type(int var1);

    private native /* synthetic */ void allocate();

    @Name(value={"free"})
    public native Free_AVHWDeviceContext _free();

    static {
        Loader.load();
    }

    public AVHWDeviceContext(long a) {
        super((Pointer)null);
        AVHWDeviceContext a2;
        a2.allocateArray(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    @Cast(value={"AVHWDeviceType"})
    public native int type();

    public native AVHWDeviceInternal internal();

    public native AVHWDeviceContext user_opaque(Pointer var1);

    public AVHWDeviceContext(Pointer pointer) {
        AVHWDeviceContext a = pointer;
        AVHWDeviceContext a2 = this;
        super((Pointer)a);
    }

    public native AVHWDeviceContext hwctx(Pointer var1);

    public native Pointer user_opaque();

    public native Pointer hwctx();

    public AVHWDeviceContext() {
        super((Pointer)null);
        AVHWDeviceContext a;
        a.allocate();
    }

    public AVHWDeviceContext position(long a) {
        AVHWDeviceContext a2;
        return (AVHWDeviceContext)super.position(a);
    }

    public native AVHWDeviceContext _free(Free_AVHWDeviceContext var1);

    public static class Free_AVHWDeviceContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        public Free_AVHWDeviceContext(Pointer pointer) {
            Free_AVHWDeviceContext a = pointer;
            Free_AVHWDeviceContext a2 = this;
            super((Pointer)a);
        }

        public native void call(AVHWDeviceContext var1);

        protected Free_AVHWDeviceContext() {
            Free_AVHWDeviceContext a;
            Free_AVHWDeviceContext free_AVHWDeviceContext = a;
            free_AVHWDeviceContext.allocate();
        }

        private native /* synthetic */ void allocate();
    }

}
