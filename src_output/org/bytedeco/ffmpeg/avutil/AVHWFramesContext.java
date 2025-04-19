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

import org.bytedeco.ffmpeg.avutil.AVBufferPool;
import org.bytedeco.ffmpeg.avutil.AVBufferRef;
import org.bytedeco.ffmpeg.avutil.AVClass;
import org.bytedeco.ffmpeg.avutil.AVHWDeviceContext;
import org.bytedeco.ffmpeg.avutil.AVHWFramesInternal;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVHWFramesContext
extends Pointer {
    public native AVHWFramesContext format(int var1);

    @Const
    public native AVClass av_class();

    public native Pointer hwctx();

    public native AVHWFramesContext initial_pool_size(int var1);

    public native AVBufferPool pool();

    static {
        Loader.load();
    }

    public native int width();

    public native AVHWFramesInternal internal();

    public native int height();

    @Cast(value={"AVPixelFormat"})
    public native int format();

    public AVHWFramesContext getPointer(long a) {
        AVHWFramesContext a2;
        return (AVHWFramesContext)new AVHWFramesContext(a2).offsetAddress(a);
    }

    @Cast(value={"AVPixelFormat"})
    public native int sw_format();

    public native AVHWFramesContext av_class(AVClass var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native AVHWDeviceContext device_ctx();

    public native AVHWFramesContext device_ctx(AVHWDeviceContext var1);

    public native Pointer user_opaque();

    public native AVHWFramesContext internal(AVHWFramesInternal var1);

    public native AVBufferRef device_ref();

    public native AVHWFramesContext sw_format(int var1);

    public AVHWFramesContext position(long a) {
        AVHWFramesContext a2;
        return (AVHWFramesContext)super.position(a);
    }

    public native AVHWFramesContext _free(Free_AVHWFramesContext var1);

    public native AVHWFramesContext pool(AVBufferPool var1);

    public AVHWFramesContext(Pointer pointer) {
        AVHWFramesContext a = pointer;
        AVHWFramesContext a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native int initial_pool_size();

    public native AVHWFramesContext width(int var1);

    public AVHWFramesContext(long a) {
        super((Pointer)null);
        AVHWFramesContext a2;
        a2.allocateArray(a);
    }

    public native AVHWFramesContext height(int var1);

    public native AVHWFramesContext device_ref(AVBufferRef var1);

    public native AVHWFramesContext hwctx(Pointer var1);

    @Name(value={"free"})
    public native Free_AVHWFramesContext _free();

    public AVHWFramesContext() {
        super((Pointer)null);
        AVHWFramesContext a;
        a.allocate();
    }

    public native AVHWFramesContext user_opaque(Pointer var1);

    public static class Free_AVHWFramesContext
    extends FunctionPointer {
        protected Free_AVHWFramesContext() {
            Free_AVHWFramesContext a;
            Free_AVHWFramesContext free_AVHWFramesContext = a;
            free_AVHWFramesContext.allocate();
        }

        static {
            Loader.load();
        }

        public Free_AVHWFramesContext(Pointer pointer) {
            Free_AVHWFramesContext a = pointer;
            Free_AVHWFramesContext a2 = this;
            super((Pointer)a);
        }

        public native void call(AVHWFramesContext var1);

        private native /* synthetic */ void allocate();
    }

}
