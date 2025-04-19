/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.DoublePointer
 *  org.bytedeco.javacpp.FloatPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.PointerScope
 *  org.bytedeco.javacpp.ShortPointer
 */
package org.bytedeco.javacv;

import dev.recollect.hana.xibao.SnowAnimation;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Locale;
import org.bytedeco.ffmpeg.avfilter.AVFilter;
import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.ffmpeg.avfilter.AVFilterGraph;
import org.bytedeco.ffmpeg.avfilter.AVFilterInOut;
import org.bytedeco.ffmpeg.avutil.AVFrame;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avfilter;
import org.bytedeco.ffmpeg.global.avformat;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.ffmpeg.global.postproc;
import org.bytedeco.ffmpeg.global.swresample;
import org.bytedeco.ffmpeg.global.swscale;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.PointerScope;
import org.bytedeco.javacpp.ShortPointer;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameFilter;

public class FFmpegFrameFilter
extends FrameFilter {
    AVFrame filt_frame;
    AVFilterGraph filter_graph;
    Buffer[] image_buf2;
    AVFilterContext[] buffersrc_ctx;
    BytePointer[] samples_ptr;
    BytePointer[] image_ptr;
    AVFrame image_frame;
    AVFilterGraph afilter_graph;
    AVFilterContext[] asetpts_ctx;
    AVFilterContext buffersink_ctx;
    AVRational atime_base;
    AVFilterContext[] abuffersrc_ctx;
    Frame frame;
    AVFilterContext abuffersink_ctx;
    Buffer[] image_buf;
    BytePointer[] image_ptr2;
    Buffer[] samples_buf;
    AVFrame samples_frame;
    private volatile boolean started;
    private static Exception loadingException = null;
    AVRational time_base;
    Frame inframe;
    AVFilterContext[] setpts_ctx;

    @Override
    public int getPixelFormat() {
        FFmpegFrameFilter a;
        if (a.buffersink_ctx != null) {
            return avfilter.av_buffersink_get_format(a.buffersink_ctx);
        }
        return super.getPixelFormat();
    }

    @Override
    public int getAudioChannels() {
        FFmpegFrameFilter a;
        if (a.abuffersink_ctx != null) {
            return avfilter.av_buffersink_get_channels(a.abuffersink_ctx);
        }
        return super.getAudioChannels();
    }

    /*
     * WARNING - void declaration
     */
    public void push(int n, Frame frame) throws Exception {
        void a;
        AutoCloseable a2 = frame;
        FFmpegFrameFilter a3 = this;
        AutoCloseable autoCloseable = a2;
        a3.push((int)a, (Frame)autoCloseable, autoCloseable != null && ((Frame)a2).opaque instanceof AVFrame ? ((AVFrame)((Object)((Frame)a2).opaque)).format() : -1);
    }

    public synchronized void startUnsafe() throws Exception {
        FFmpegFrameFilter a2;
        FFmpegFrameFilter fFmpegFrameFilter = a2;
        a2 = new PointerScope();
        try {
            if (fFmpegFrameFilter.frame != null) {
                throw new Exception(SnowAnimation.ALLATORIxDEMO("@\u0019O\u0002OM[\fV\u0001V[I\u001aK\u0002Y\u0002@G]\u0004V\u0003ROW\u0004Q\u0006NN\u001d ^\rFT\u0001Xu42m\u0011\rI\u0014V\u0015^Ey%B\u001cT\rVOJ\u0013{6AC\u0019NI\u0011X\u000e@^"));
            }
            FFmpegFrameFilter fFmpegFrameFilter2 = fFmpegFrameFilter;
            fFmpegFrameFilter2.image_frame = avutil.av_frame_alloc();
            fFmpegFrameFilter2.samples_frame = avutil.av_frame_alloc();
            fFmpegFrameFilter2.filt_frame = avutil.av_frame_alloc();
            BytePointer[] arrbytePointer = new BytePointer[1];
            arrbytePointer[0] = null;
            fFmpegFrameFilter.image_ptr = arrbytePointer;
            BytePointer[] arrbytePointer2 = new BytePointer[1];
            arrbytePointer2[0] = null;
            fFmpegFrameFilter.image_ptr2 = arrbytePointer2;
            Buffer[] arrbuffer = new Buffer[1];
            arrbuffer[0] = null;
            fFmpegFrameFilter.image_buf = arrbuffer;
            Buffer[] arrbuffer2 = new Buffer[1];
            arrbuffer2[0] = null;
            fFmpegFrameFilter.image_buf2 = arrbuffer2;
            BytePointer[] arrbytePointer3 = new BytePointer[1];
            arrbytePointer3[0] = null;
            fFmpegFrameFilter.samples_ptr = arrbytePointer3;
            Buffer[] arrbuffer3 = new Buffer[1];
            arrbuffer3[0] = null;
            fFmpegFrameFilter.samples_buf = arrbuffer3;
            fFmpegFrameFilter.frame = new Frame();
            if (fFmpegFrameFilter.image_frame == null || fFmpegFrameFilter.samples_frame == null || fFmpegFrameFilter.filt_frame == null) {
                throw new Exception(FrameFilter.ALLATORIxDEMO("U*a\bQpo,fo+z\u000bV*n+?0u&{5r"));
            }
            if (fFmpegFrameFilter.filters != null && fFmpegFrameFilter.imageWidth > 0 && fFmpegFrameFilter.imageHeight > 0 && fFmpegFrameFilter.videoInputs > 0) {
                fFmpegFrameFilter.startVideoUnsafe();
            }
            if (fFmpegFrameFilter.afilters != null && fFmpegFrameFilter.audioChannels > 0 && fFmpegFrameFilter.audioInputs > 0) {
                fFmpegFrameFilter.startAudioUnsafe();
            }
            fFmpegFrameFilter.started = true;
        }
        catch (Throwable throwable) {
            Throwable throwable2;
            try {
                a2.close();
                throwable2 = throwable;
            }
            catch (Throwable a2) {
                Throwable throwable3 = throwable;
                throwable2 = throwable3;
                throwable3.addSuppressed(a2);
            }
            throw throwable2;
        }
        a2.close();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public synchronized Frame pullSamples() throws Exception {
        block23 : {
            block22 : {
                var1_3 = a;
                var7_4 = new PointerScope();
                if (!var1_3.started) {
                    throw new Exception(FrameFilter.ALLATORIxDEMO(")\u0005G\u0010\u001df>%b46+{\u0010\u00153`/~*zge\u0011V(=l0r+z) "));
                }
                v0 = var1_3;
                avutil.av_frame_unref(v0.filt_frame);
                var8_5 = avfilter.av_buffersink_get_frame(v0.abuffersink_ctx, var1_3.filt_frame);
                if (var8_5 != avutil.AVERROR_EAGAIN() && var8_5 != avutil.AVERROR_EOF()) break block22;
                var3_7 = null;
                var7_4.close();
                return var3_7;
            }
            if (var8_5 < 0) {
                throw new Exception("av_buffersink_get_frame(): Error occurred: " + avutil.av_make_error_string(new BytePointer(256L), 256L, var8_5).getString());
            }
            var3_8 = var1_3.filt_frame.format();
            if (avutil.av_sample_fmt_is_planar(var3_8) == 0) break block23;
            v1 = var1_3.filt_frame.channels();
            ** GOTO lbl24
        }
        try {
            block25 : {
                block24 : {
                    v1 = 1;
lbl24: // 2 sources:
                    var4_10 = v1;
                    var5_11 = avutil.av_samples_get_buffer_size((IntPointer)null, var1_3.filt_frame.channels(), var1_3.filt_frame.nb_samples(), var1_3.filt_frame.format(), 1) / var4_10;
                    if (var1_3.samples_buf == null) break block24;
                    if (var1_3.samples_buf.length == var4_10) break block25;
                }
                var1_3.samples_ptr = new BytePointer[var4_10];
                var1_3.samples_buf = new Buffer[var4_10];
            }
            v2 = var1_3;
            v2.frame.audioChannels = var1_3.filt_frame.channels();
            v2.frame.sampleRate = var1_3.filt_frame.sample_rate();
            var1_3.frame.samples = var1_3.samples_buf;
            v2.frame.opaque = var1_3.filt_frame;
            var6_12 = var5_11 / avutil.av_get_bytes_per_sample(var3_8);
            v3 = a = 0;
            while (v3 < var4_10) {
                var2_13 = var1_3.filt_frame.data(a);
                if (!var2_13.equals((Object)var1_3.samples_ptr[a]) || var1_3.samples_ptr[a].capacity() < (long)var5_11) {
                    var1_3.samples_ptr[a] = var2_13.capacity((long)var5_11);
                    var2_13 = var2_13.asBuffer();
                    switch (var3_8) {
                        case 0: 
                        case 5: {
                            v4 = var1_3;
                            while (false) {
                            }
                            v5 = v4;
                            v4.samples_buf[a] = var2_13;
                            ** break;
                        }
                        case 1: 
                        case 6: {
                            v6 = var1_3;
                            v5 = v6;
                            v6.samples_buf[a] = var2_13.asShortBuffer();
                            ** break;
                        }
                        case 2: 
                        case 7: {
                            v7 = var1_3;
                            v5 = v7;
                            v7.samples_buf[a] = var2_13.asIntBuffer();
                            ** break;
                        }
                        case 3: 
                        case 8: {
                            v8 = var1_3;
                            v5 = v8;
                            v8.samples_buf[a] = var2_13.asFloatBuffer();
                            ** break;
                        }
                        case 4: 
                        case 9: {
                            v9 = var1_3;
                            v5 = v9;
                            v9.samples_buf[a] = var2_13.asDoubleBuffer();
                            ** break;
                        }
                    }
                    if (!FFmpegFrameFilter.$assertionsDisabled) {
                        throw new AssertionError();
                    }
                }
                v5 = var1_3;
lbl79: // 6 sources:
                v10 = v5.samples_buf[a];
                v10.position(0).limit(var6_12);
                v3 = ++a;
            }
            var1_3.frame.timestamp = 1000000L * var1_3.filt_frame.pts() * (long)var1_3.atime_base.num() / (long)var1_3.atime_base.den();
            a = var1_3.frame;
        }
        catch (Throwable var8_6) {
            try {
                var7_4.close();
                v11 = var8_6;
                throw v11;
            }
            catch (Throwable var3_9) {
                v12 = var8_6;
                v11 = v12;
                v12.addSuppressed(var3_9);
            }
            throw v11;
        }
        var7_4.close();
        return a;
    }

    @Override
    public int getImageHeight() {
        FFmpegFrameFilter a;
        if (a.buffersink_ctx != null) {
            return avfilter.av_buffersink_get_h(a.buffersink_ctx);
        }
        return super.getImageHeight();
    }

    /*
     * WARNING - void declaration
     */
    public void push(Frame frame, int n) throws Exception {
        void a;
        int a2 = n;
        FFmpegFrameFilter a3 = this;
        a3.push(0, (Frame)a, a2);
    }

    static {
        try {
            FFmpegFrameFilter.tryLoad();
        }
        catch (Exception exception) {}
    }

    @Override
    public int getSampleRate() {
        FFmpegFrameFilter a;
        if (a.abuffersink_ctx != null) {
            return avfilter.av_buffersink_get_sample_rate(a.abuffersink_ctx);
        }
        return super.getSampleRate();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public synchronized Frame pullImage() throws Exception {
        block12 : {
            block11 : {
                var3_6 = a;
                var1_7 = new PointerScope();
                try {
                    if (!var3_6.started) {
                        throw new Exception(SnowAnimation.ALLATORIxDEMO("\u0001X{6nl\u0018O[\u0013JGU\nndM\u0011Q\u000fT\u000b\u0019\u0014o'V\u000eC\u001dN\u0003U\u000bWQ"));
                    }
                    v0 = var3_6;
                    avutil.av_frame_unref(v0.filt_frame);
                    var2_8 = avfilter.av_buffersink_get_frame(v0.buffersink_ctx, var3_6.filt_frame);
                    if (var2_8 != avutil.AVERROR_EAGAIN() && var2_8 != avutil.AVERROR_EOF()) break block11;
                    a = null;
                }
                catch (Throwable var2_9) {
                    try {
                        var1_7.close();
                        v1 = var2_9;
                        throw v1;
                    }
                    catch (Throwable a) {
                        v2 = var2_9;
                        v1 = v2;
                        v2.addSuppressed(a);
                    }
                    throw v1;
                }
                var1_7.close();
                return a;
            }
            if (var2_8 < 0) {
                throw new Exception("av_buffersink_get_frame(): Error occurred: " + avutil.av_make_error_string(new BytePointer(256L), 256L, var2_8).getString());
            }
            var3_6.frame.imageWidth = var3_6.filt_frame.width();
            var3_6.frame.imageHeight = var3_6.filt_frame.height();
            var3_6.frame.imageDepth = 8;
            if (var3_6.filt_frame.data(1) != null) break block12;
            v3 = var3_6;
            var3_6.frame.imageStride = v3.filt_frame.linesize(0);
            a = v3.filt_frame.data(0);
            if (a != null && !a.equals((Object)var3_6.image_ptr[0])) {
                v4 = var3_6;
                v4.image_ptr[0] = a.capacity((long)(var3_6.frame.imageHeight * Math.abs(var3_6.frame.imageStride)));
                v4.image_buf[0] = a.asBuffer();
            }
            v5 = var3_6;
            v6 = var3_6;
            var3_6.frame.image = v6.image_buf;
            v6.frame.image[0].position(0).limit(var3_6.frame.imageHeight * Math.abs(var3_6.frame.imageStride));
            var3_6.frame.imageChannels = Math.abs(var3_6.frame.imageStride) / var3_6.frame.imageWidth;
            var3_6.frame.opaque = var3_6.filt_frame;
            ** GOTO lbl70
        }
        v7 = var3_6;
        var3_6.frame.imageStride = v7.frame.imageWidth;
        a = avutil.av_image_get_buffer_size(v7.filt_frame.format(), var3_6.frame.imageWidth, var3_6.frame.imageHeight, 1);
        if (var3_6.image_ptr2[0] == null || var3_6.image_ptr2[0].capacity() < (long)a) {
            v8 = var3_6;
            avutil.av_free((Pointer)v8.image_ptr2[0]);
            v8.image_ptr2[0] = new BytePointer(avutil.av_malloc(a)).capacity((long)a);
            v8.image_buf2[0] = var3_6.image_ptr2[0].asBuffer();
        }
        v9 = var3_6;
        v9.frame.image = v9.image_buf2;
        v9.frame.image[0].position(0).limit(a);
        v10 = var3_6;
        var3_6.frame.imageChannels = (a + v10.frame.imageWidth * var3_6.frame.imageHeight - 1) / (var3_6.frame.imageWidth * var3_6.frame.imageHeight);
        var2_8 = avutil.av_image_copy_to_buffer(v10.image_ptr2[0].position(0L), (int)var3_6.image_ptr2[0].capacity(), new PointerPointer((Pointer)var3_6.filt_frame), var3_6.filt_frame.linesize(), var3_6.filt_frame.format(), var3_6.frame.imageWidth, var3_6.frame.imageHeight, 1);
        if (var2_8 < 0) {
            throw new Exception("av_image_copy_to_buffer() error " + var2_8 + ": Cannot pull image.");
        }
        v11 = var3_6;
        v5 = v11;
        v11.frame.opaque = v11.image_ptr2[0];
lbl70: // 2 sources:
        v5.frame.timestamp = 1000000L * var3_6.filt_frame.pts() * (long)var3_6.time_base.num() / (long)var3_6.time_base.den();
        a = var3_6.frame;
        var1_7.close();
        return a;
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameFilter(String string, String string2, int n, int n2, int n3) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        FFmpegFrameFilter a6;
        int n4 = n3;
        FFmpegFrameFilter fFmpegFrameFilter = a6 = this;
        FFmpegFrameFilter fFmpegFrameFilter2 = a6;
        FFmpegFrameFilter fFmpegFrameFilter3 = a6;
        FFmpegFrameFilter fFmpegFrameFilter4 = a6;
        FFmpegFrameFilter fFmpegFrameFilter5 = a6;
        FFmpegFrameFilter fFmpegFrameFilter6 = a6;
        a6.started = false;
        fFmpegFrameFilter6.filters = a2;
        fFmpegFrameFilter6.imageWidth = a;
        fFmpegFrameFilter5.imageHeight = a5;
        fFmpegFrameFilter5.pixelFormat = 3;
        fFmpegFrameFilter4.frameRate = 30.0;
        fFmpegFrameFilter4.aspectRatio = 0.0;
        fFmpegFrameFilter3.videoInputs = 1;
        fFmpegFrameFilter3.afilters = a4;
        fFmpegFrameFilter2.audioChannels = a3;
        fFmpegFrameFilter2.sampleFormat = 1;
        fFmpegFrameFilter.sampleRate = 44100;
        fFmpegFrameFilter.audioInputs = 1;
    }

    @Override
    public synchronized Frame pull() throws Exception {
        AutoCloseable a;
        FFmpegFrameFilter fFmpegFrameFilter = a;
        if (!fFmpegFrameFilter.started) {
            throw new Exception(FrameFilter.ALLATORIxDEMO(")\u0005G\u0010\u001df>%b46+{\u0010\u00153`/~*zge\u0011V(=l0r+z) "));
        }
        FFmpegFrameFilter fFmpegFrameFilter2 = fFmpegFrameFilter;
        fFmpegFrameFilter2.frame.keyFrame = false;
        fFmpegFrameFilter2.frame.imageWidth = 0;
        fFmpegFrameFilter2.frame.imageHeight = 0;
        fFmpegFrameFilter2.frame.imageDepth = 0;
        fFmpegFrameFilter2.frame.imageChannels = 0;
        fFmpegFrameFilter2.frame.imageStride = 0;
        fFmpegFrameFilter2.frame.image = null;
        fFmpegFrameFilter2.frame.sampleRate = 0;
        fFmpegFrameFilter2.frame.audioChannels = 0;
        fFmpegFrameFilter2.frame.samples = null;
        fFmpegFrameFilter2.frame.opaque = null;
        a = null;
        if (null == null && fFmpegFrameFilter.buffersrc_ctx != null) {
            a = fFmpegFrameFilter.pullImage();
        }
        if (a == null && fFmpegFrameFilter.abuffersrc_ctx != null) {
            a = fFmpegFrameFilter.pullSamples();
        }
        if (a == null && fFmpegFrameFilter.inframe != null && (fFmpegFrameFilter.inframe.image != null && fFmpegFrameFilter.buffersrc_ctx == null || fFmpegFrameFilter.inframe.samples != null && fFmpegFrameFilter.abuffersrc_ctx == null)) {
            a = fFmpegFrameFilter.inframe;
        }
        fFmpegFrameFilter.inframe = null;
        return a;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public synchronized void pushImage(int n, int n2, int n3, int n4, int n5, int n6, int n7, Buffer ... arrbuffer) throws Exception {
        PointerScope pointerScope;
        block19 : {
            int n8 = n4;
            FFmpegFrameFilter a = this;
            pointerScope = new PointerScope();
            try {
                void a2;
                BytePointer bytePointer;
                int n9;
                int a3;
                void a4;
                void a5;
                void a6;
                void a7;
                int a8;
                if (!a.started) {
                    throw new Exception(FrameFilter.ALLATORIxDEMO(")\u0005G\u0010\u001df>%b46+{\u0010\u00153`/~*zge\u0011V(=l0r+z) "));
                }
                a6 = a6 * Math.abs((int)a4) / 8;
                BytePointer bytePointer2 = bytePointer = a5[0] instanceof ByteBuffer ? new BytePointer((ByteBuffer)a5[0]).position(0L) : new BytePointer(new Pointer((Buffer)a5[0]).position(0L));
                if (a8 == -1) {
                    void a9;
                    if ((a4 == 8 || a4 == -8) && a9 == 3) {
                        n9 = a8 = 3;
                    } else if ((a4 == 8 || a4 == -8) && a9 == true) {
                        n9 = a8 = 8;
                    } else if ((a4 == 16 || a4 == -16) && a9 == true) {
                        n9 = a8 = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN) ? 29 : 30;
                    } else if ((a4 == 8 || a4 == -8) && a9 == 4) {
                        n9 = a8 = 26;
                    } else {
                        if (a4 != 8) {
                            if (a4 != -8) throw new Exception("Could not guess pixel format of image: depth=" + (int)a4 + ", channels=" + (int)a9);
                        }
                        if (a9 != 2) throw new Exception("Could not guess pixel format of image: depth=" + (int)a4 + ", channels=" + (int)a9);
                        n9 = a8 = 24;
                    }
                } else {
                    n9 = a8;
                }
                if (n9 == 24) {
                    a6 = a7;
                }
                avutil.av_image_fill_arrays(new PointerPointer((Pointer)a.image_frame), a.image_frame.linesize(), bytePointer, a8, (int)a7, (int)a2, 1);
                a.image_frame.linesize(0, (int)a6);
                a.image_frame.format(a8);
                a.image_frame.width((int)a7);
                a.image_frame.height((int)a2);
                a3 = avfilter.av_buffersrc_add_frame_flags(a.buffersrc_ctx[a3], a.image_frame, 12);
                if (a3 >= 0) break block19;
                throw new Exception("av_buffersrc_add_frame_flags() error " + a3 + ": Error while feeding the filtergraph.");
            }
            catch (Throwable a3) {
                Throwable throwable;
                try {
                    pointerScope.close();
                    throwable = a3;
                    throw throwable;
                }
                catch (Throwable a6) {
                    Throwable throwable2 = a3;
                    throwable = throwable2;
                    throwable2.addSuppressed(a6);
                }
                throw throwable;
            }
        }
        pointerScope.close();
    }

    public static void tryLoad() throws Exception {
        if (loadingException != null) {
            throw loadingException;
        }
        try {
            Loader.load(avutil.class);
            Loader.load(avcodec.class);
            Loader.load(avformat.class);
            Loader.load(postproc.class);
            Loader.load(swresample.class);
            Loader.load(swscale.class);
            Loader.load(avfilter.class);
            return;
        }
        catch (Throwable throwable) {
            if (throwable instanceof Exception) {
                loadingException = (Exception)throwable;
                throw loadingException;
            }
            loadingException = new Exception("Failed to load " + String.valueOf(FFmpegFrameRecorder.class), throwable);
            throw loadingException;
        }
    }

    @Override
    public void push(Frame frame) throws Exception {
        AutoCloseable a = frame;
        FFmpegFrameFilter a2 = this;
        AutoCloseable autoCloseable = a;
        a2.push((Frame)autoCloseable, autoCloseable != null && ((Frame)a).opaque instanceof AVFrame ? ((AVFrame)((Object)((Frame)a).opaque)).format() : -1);
    }

    @Override
    public int getImageWidth() {
        FFmpegFrameFilter a;
        if (a.buffersink_ctx != null) {
            return avfilter.av_buffersink_get_w(a.buffersink_ctx);
        }
        return super.getImageWidth();
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameFilter(String string, int n, int n2) {
        void a;
        void a2;
        int a3 = n2;
        FFmpegFrameFilter a4 = this;
        a4((String)a2, null, (int)a, a3, 0);
    }

    @Override
    public void stop() throws Exception {
        FFmpegFrameFilter a;
        a.release();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public synchronized void pushSamples(int var1_7, int var2_9, int var3_10, int var4_11, Buffer ... var5_12) throws Exception {
        block25 : {
            block24 : {
                block23 : {
                    block22 : {
                        block21 : {
                            block20 : {
                                var9_13 = this;
                                var6_14 = new PointerScope();
                                if (!var9_13.started) {
                                    throw new Exception(SnowAnimation.ALLATORIxDEMO("\u0001X{6nl\u0018O[\u0013JGU\nndM\u0011Q\u000fT\u000b\u0019\u0014o'V\u000eC\u001dN\u0003U\u000bWQ"));
                                }
                                var7_15 = new Pointer[((void)a).length];
                                v0 = a != null ? (a[0].limit() - a[0].position()) / (((void)a).length > 1 ? 1 : a) : (var8_17 = 0);
                                if (a == null || !(a[0] instanceof ByteBuffer)) break block20;
                                a = var7_15.length > 1 ? 5 : 0;
                                v1 = a = 0;
                                while (v1 < var7_15.length) {
                                    v2 = a;
                                    v3 = new BytePointer((ByteBuffer)a[a]);
                                    var7_15[v2] = v3;
                                    v1 = ++a;
                                }
                                ** GOTO lbl78
                            }
                            if (a == null || !(a[0] instanceof ShortBuffer)) break block21;
                            a = var7_15.length > 1 ? 6 : 1;
                            v4 = a = 0;
                            while (v4 < var7_15.length) {
                                v5 = a;
                                v6 = new ShortPointer((ShortBuffer)a[a]);
                                var7_15[v5] = v6;
                                v4 = ++a;
                            }
                            ** GOTO lbl78
                        }
                        if (a == null || !(a[0] instanceof IntBuffer)) break block22;
                        a = var7_15.length > 1 ? 7 : 2;
                        v7 = a = 0;
                        while (v7 < var7_15.length) {
                            v8 = a;
                            v9 = new IntPointer((IntBuffer)a[a]);
                            var7_15[v8] = v9;
                            v7 = ++a;
                        }
                        ** GOTO lbl78
                    }
                    if (a == null || !(a[0] instanceof FloatBuffer)) break block23;
                    a = var7_15.length > 1 ? 8 : 3;
                    v10 = a = 0;
                    while (v10 < var7_15.length) {
                        v11 = a;
                        v12 = new FloatPointer((FloatBuffer)a[a]);
                        var7_15[v11] = v12;
                        v10 = ++a;
                    }
                    ** GOTO lbl78
                }
                if (a == null || !(a[0] instanceof DoubleBuffer)) break block24;
                a = var7_15.length > 1 ? 9 : 4;
                v13 = a = 0;
                while (v13 < var7_15.length) {
                    v14 = a;
                    v15 = new DoublePointer((DoubleBuffer)a[a]);
                    var7_15[v14] = v15;
                    v13 = ++a;
                }
                ** GOTO lbl78
            }
            try {
                if (a != null) {
                    v16 = a = 0;
                    while (v16 < var7_15.length) {
                        v17 = a;
                        v18 = new Pointer((Buffer)a[a]);
                        var7_15[v17] = v18;
                        v16 = ++a;
                    }
                }
lbl78: // 8 sources:
                avutil.av_samples_fill_arrays(new PointerPointer((Pointer)var9_13.samples_frame), var9_13.samples_frame.linesize(), new BytePointer(var7_15[0]), (int)a, var8_17, a, 1);
                a = (reference)false;
                v19 = a;
                while (v19 < ((void)a).length) {
                    var9_13.samples_frame.data((int)a, new BytePointer(var7_15[a++]));
                    v19 = a;
                }
                v20 = var9_13;
                v20.samples_frame.channels((int)a);
                var9_13.samples_frame.channel_layout(avutil.av_get_default_channel_layout((int)a));
                var9_13.samples_frame.nb_samples(var8_17);
                var9_13.samples_frame.format(a);
                var9_13.samples_frame.sample_rate((int)a);
                a = avfilter.av_buffersrc_add_frame_flags(v20.abuffersrc_ctx[a], var9_13.samples_frame, 12);
                if (a >= 0) break block25;
                throw new Exception("av_buffersrc_add_frame_flags() error " + a + ": Error while feeding the filtergraph.");
            }
            catch (Throwable a) {
                try {
                    var6_14.close();
                    v21 = a;
                    throw v21;
                }
                catch (Throwable var7_16) {
                    v22 = a;
                    v21 = v22;
                    v22.addSuppressed(var7_16);
                }
                throw v21;
            }
        }
        var6_14.close();
    }

    /*
     * WARNING - void declaration
     */
    public synchronized void push(int n, Frame frame, int n2) throws Exception {
        void a;
        AutoCloseable a2 = frame;
        FFmpegFrameFilter a3 = this;
        if (!a3.started) {
            throw new Exception(SnowAnimation.ALLATORIxDEMO("\u0001X{6nl\u0018O[\u0013JGU\nndM\u0011Q\u000fT\u000b\u0019\u0014o'V\u000eC\u001dN\u0003U\u000bWQ"));
        }
        a3.inframe = a2;
        if (a2 != null && ((Frame)a2).image != null && a3.buffersrc_ctx != null) {
            void a4;
            a3.image_frame.pts(((Frame)a2).timestamp * (long)a3.time_base.den() / (1000000L * (long)a3.time_base.num()));
            AutoCloseable autoCloseable = a2;
            AutoCloseable autoCloseable2 = a2;
            a3.pushImage((int)a, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable2).imageDepth, ((Frame)autoCloseable2).imageChannels, ((Frame)a2).imageStride, (int)a4, ((Frame)a2).image);
        }
        if (a2 != null && ((Frame)a2).samples != null && a3.abuffersrc_ctx != null) {
            a3.samples_frame.pts(((Frame)a2).timestamp * (long)a3.atime_base.den() / (1000000L * (long)a3.atime_base.num()));
            FFmpegFrameFilter fFmpegFrameFilter = a3;
            fFmpegFrameFilter.pushSamples((int)a, ((Frame)a2).audioChannels, fFmpegFrameFilter.sampleRate, a3.sampleFormat, ((Frame)a2).samples);
        }
        if (a2 == null || ((Frame)a2).image == null && ((Frame)a2).samples == null) {
            if (a3.buffersrc_ctx != null && a < a3.buffersrc_ctx.length) {
                avfilter.av_buffersrc_add_frame_flags(a3.buffersrc_ctx[a], null, 4);
            }
            if (a3.abuffersrc_ctx != null && a < a3.abuffersrc_ctx.length) {
                avfilter.av_buffersrc_add_frame_flags(a3.abuffersrc_ctx[a], null, 4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start() throws Exception {
        Class<avfilter> a;
        FFmpegFrameFilter fFmpegFrameFilter = a;
        a = avfilter.class;
        synchronized (avfilter.class) {
            fFmpegFrameFilter.startUnsafe();
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void release() throws Exception {
        Class<avfilter> a;
        FFmpegFrameFilter fFmpegFrameFilter = a;
        a = avfilter.class;
        synchronized (avfilter.class) {
            fFmpegFrameFilter.releaseUnsafe();
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }

    public synchronized void releaseUnsafe() throws Exception {
        FFmpegFrameFilter a2;
        FFmpegFrameFilter fFmpegFrameFilter = a2;
        fFmpegFrameFilter.started = false;
        if (fFmpegFrameFilter.image_ptr2 != null) {
            int n = a2 = 0;
            while (n < fFmpegFrameFilter.image_ptr2.length) {
                avutil.av_free((Pointer)fFmpegFrameFilter.image_ptr2[a2++]);
                n = a2;
            }
            fFmpegFrameFilter.image_ptr2 = null;
        }
        if (fFmpegFrameFilter.filter_graph != null) {
            FFmpegFrameFilter fFmpegFrameFilter2 = fFmpegFrameFilter;
            avfilter.avfilter_graph_free(fFmpegFrameFilter2.filter_graph);
            fFmpegFrameFilter2.buffersink_ctx.releaseReference();
            int a2 = 0;
            int n = a2;
            while (n < fFmpegFrameFilter.buffersrc_ctx.length) {
                fFmpegFrameFilter.buffersrc_ctx[a2].releaseReference();
                fFmpegFrameFilter.setpts_ctx[a2++].releaseReference();
                n = a2;
            }
            fFmpegFrameFilter.time_base.releaseReference();
            FFmpegFrameFilter fFmpegFrameFilter3 = fFmpegFrameFilter;
            FFmpegFrameFilter fFmpegFrameFilter4 = fFmpegFrameFilter;
            fFmpegFrameFilter.buffersink_ctx = null;
            fFmpegFrameFilter4.buffersrc_ctx = null;
            fFmpegFrameFilter4.setpts_ctx = null;
            fFmpegFrameFilter3.filter_graph = null;
            fFmpegFrameFilter3.time_base = null;
        }
        if (fFmpegFrameFilter.afilter_graph != null) {
            FFmpegFrameFilter fFmpegFrameFilter5 = fFmpegFrameFilter;
            avfilter.avfilter_graph_free(fFmpegFrameFilter5.afilter_graph);
            fFmpegFrameFilter5.abuffersink_ctx.releaseReference();
            int a2 = 0;
            int n = a2;
            while (n < fFmpegFrameFilter.abuffersrc_ctx.length) {
                fFmpegFrameFilter.abuffersrc_ctx[a2].releaseReference();
                fFmpegFrameFilter.asetpts_ctx[a2++].releaseReference();
                n = a2;
            }
            fFmpegFrameFilter.atime_base.releaseReference();
            FFmpegFrameFilter fFmpegFrameFilter6 = fFmpegFrameFilter;
            FFmpegFrameFilter fFmpegFrameFilter7 = fFmpegFrameFilter;
            fFmpegFrameFilter.abuffersink_ctx = null;
            fFmpegFrameFilter7.abuffersrc_ctx = null;
            fFmpegFrameFilter7.asetpts_ctx = null;
            fFmpegFrameFilter6.afilter_graph = null;
            fFmpegFrameFilter6.atime_base = null;
        }
        if (fFmpegFrameFilter.image_frame != null) {
            avutil.av_frame_free(fFmpegFrameFilter.image_frame);
            fFmpegFrameFilter.image_frame = null;
        }
        if (fFmpegFrameFilter.samples_frame != null) {
            avutil.av_frame_free(fFmpegFrameFilter.samples_frame);
            fFmpegFrameFilter.samples_frame = null;
        }
        if (fFmpegFrameFilter.filt_frame != null) {
            avutil.av_frame_free(fFmpegFrameFilter.filt_frame);
            fFmpegFrameFilter.filt_frame = null;
        }
        fFmpegFrameFilter.frame = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void startAudioUnsafe() throws Exception {
        FFmpegFrameFilter a2;
        FFmpegFrameFilter fFmpegFrameFilter = a2;
        AVFilter aVFilter = avfilter.avfilter_get_by_name(SnowAnimation.ALLATORIxDEMO("\u000fJ\u0003_\u0001K\u0002"));
        AVFilter aVFilter2 = avfilter.avfilter_get_by_name(FrameFilter.ALLATORIxDEMO("T)o(y3u4>j"));
        AVFilter aVFilter3 = avfilter.avfilter_get_by_name(SnowAnimation.ALLATORIxDEMO("\u000f[\u0013M\u0017Z\u0003"));
        AVFilterInOut[] arraVFilterInOut = new AVFilterInOut[fFmpegFrameFilter.audioInputs];
        AVFilterInOut aVFilterInOut = avfilter.avfilter_inout_alloc();
        int[] arrn = new int[2];
        arrn[0] = fFmpegFrameFilter.sampleFormat;
        arrn[1] = -1;
        try {
            int n;
            fFmpegFrameFilter.afilter_graph = avfilter.avfilter_graph_alloc();
            if (arraVFilterInOut == null || aVFilterInOut == null || fFmpegFrameFilter.afilter_graph == null) {
                throw new Exception(FrameFilter.ALLATORIxDEMO("S\"i`9hw,ftd/~.s5qi}\u0005@\u0000\\ >4j+b fDR\"`3zu>\bc\u0010\u0015$|nr3j(d)>"));
            }
            fFmpegFrameFilter.abuffersrc_ctx = new AVFilterContext[fFmpegFrameFilter.audioInputs];
            fFmpegFrameFilter.asetpts_ctx = new AVFilterContext[fFmpegFrameFilter.audioInputs];
            int n2 = a2 = 0;
            while (n2 < fFmpegFrameFilter.audioInputs) {
                Object object = fFmpegFrameFilter.audioInputs > 1 ? a2 + ":a" : SnowAnimation.ALLATORIxDEMO("G\u001e");
                arraVFilterInOut[a2] = avfilter.avfilter_inout_alloc();
                Object[] arrobject = new Object[4];
                arrobject[0] = fFmpegFrameFilter.audioChannels;
                arrobject[1] = fFmpegFrameFilter.sampleFormat;
                arrobject[2] = fFmpegFrameFilter.sampleRate;
                arrobject[3] = avutil.av_get_default_channel_layout(fFmpegFrameFilter.audioChannels);
                String string = String.format(Locale.ROOT, FrameFilter.ALLATORIxDEMO("%&x/u!o1x,#0s9u/w\u001ev9q1x\u0000\u000f\u0017T\"n>f\u0018d$`\u0001\bueyq')x\u0001Y\u0014v/f9r3+ue"), arrobject);
                fFmpegFrameFilter.abuffersrc_ctx[a2] = (AVFilterContext)new AVFilterContext().retainReference();
                n = avfilter.avfilter_graph_create_filter(fFmpegFrameFilter.abuffersrc_ctx[a2], aVFilter, (String)object, string, null, fFmpegFrameFilter.afilter_graph);
                if (n < 0) {
                    throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot create audio buffer source.");
                }
                fFmpegFrameFilter.asetpts_ctx[a2] = (AVFilterContext)new AVFilterContext().retainReference();
                n = avfilter.avfilter_graph_create_filter(fFmpegFrameFilter.asetpts_ctx[a2], aVFilter3, (String)(fFmpegFrameFilter.audioInputs > 1 ? "asetpts" + a2 : SnowAnimation.ALLATORIxDEMO("\u000f[\u0013M\u0017Z\u0003")), FrameFilter.ALLATORIxDEMO("O"), null, fFmpegFrameFilter.afilter_graph);
                if (n < 0) {
                    throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot create asetpts filter.");
                }
                n = avfilter.avfilter_link(fFmpegFrameFilter.abuffersrc_ctx[a2], 0, fFmpegFrameFilter.asetpts_ctx[a2], 0);
                if (n < 0) {
                    throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot link asetpts filter.");
                }
                arraVFilterInOut[a2].name(avutil.av_strdup(new BytePointer((String)object)));
                arraVFilterInOut[a2].filter_ctx(fFmpegFrameFilter.asetpts_ctx[a2]);
                arraVFilterInOut[a2].pad_idx(0);
                arraVFilterInOut[a2].next(null);
                if (a2 > 0) {
                    arraVFilterInOut[a2 - 1].next(arraVFilterInOut[a2]);
                }
                n2 = ++a2;
            }
            String a2 = fFmpegFrameFilter.audioInputs > 1 ? SnowAnimation.ALLATORIxDEMO("\u0011") : FrameFilter.ALLATORIxDEMO("y%u");
            fFmpegFrameFilter.abuffersink_ctx = (AVFilterContext)new AVFilterContext().retainReference();
            n = avfilter.avfilter_graph_create_filter(fFmpegFrameFilter.abuffersink_ctx, aVFilter2, a2, null, null, fFmpegFrameFilter.afilter_graph);
            if (n < 0) {
                throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot create audio buffer sink.");
            }
            aVFilterInOut.name(avutil.av_strdup(new BytePointer(a2)));
            aVFilterInOut.filter_ctx(fFmpegFrameFilter.abuffersink_ctx);
            aVFilterInOut.pad_idx(0);
            aVFilterInOut.next(null);
            FFmpegFrameFilter fFmpegFrameFilter2 = fFmpegFrameFilter;
            n = avfilter.avfilter_graph_parse_ptr(fFmpegFrameFilter2.afilter_graph, fFmpegFrameFilter2.afilters, aVFilterInOut, arraVFilterInOut[0], null);
            if (n < 0) {
                throw new Exception("avfilter_graph_parse_ptr() error " + n);
            }
            n = avfilter.avfilter_graph_config(fFmpegFrameFilter.afilter_graph, null);
            if (n < 0) {
                throw new Exception("avfilter_graph_config() error " + n);
            }
            fFmpegFrameFilter.atime_base = (AVRational)avfilter.av_buffersink_get_time_base(fFmpegFrameFilter.abuffersink_ctx).retainReference();
            return;
        }
        finally {
            avfilter.avfilter_inout_free(aVFilterInOut);
            avfilter.avfilter_inout_free(arraVFilterInOut[0]);
        }
    }

    protected void finalize() throws Throwable {
        FFmpegFrameFilter a;
        FFmpegFrameFilter fFmpegFrameFilter = a;
        Object.super.finalize();
        fFmpegFrameFilter.release();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void startVideoUnsafe() throws Exception {
        AVRational a2;
        FFmpegFrameFilter fFmpegFrameFilter = a2;
        AVFilter aVFilter = avfilter.avfilter_get_by_name(SnowAnimation.ALLATORIxDEMO("J\u0003_\u0001K\u0002"));
        AVFilter aVFilter2 = avfilter.avfilter_get_by_name(FrameFilter.ALLATORIxDEMO(")o(y3u4>j"));
        AVFilter aVFilter3 = avfilter.avfilter_get_by_name(SnowAnimation.ALLATORIxDEMO("[\u0013M\u0017Z\u0003"));
        AVFilterInOut[] arraVFilterInOut = new AVFilterInOut[fFmpegFrameFilter.videoInputs];
        AVFilterInOut aVFilterInOut = avfilter.avfilter_inout_alloc();
        Object object = avutil.av_d2q(fFmpegFrameFilter.frameRate, 1001000);
        a2 = avutil.av_inv_q(object);
        int[] arrn = new int[2];
        arrn[0] = fFmpegFrameFilter.pixelFormat;
        arrn[1] = -1;
        try {
            int n;
            fFmpegFrameFilter.filter_graph = avfilter.avfilter_graph_alloc();
            if (arraVFilterInOut == null || aVFilterInOut == null || fFmpegFrameFilter.filter_graph == null) {
                throw new Exception(FrameFilter.ALLATORIxDEMO("S\"i`9hw,ftd/~.s5qi}\u0012\\\u0000P >4j+b fDR\"`3zu>\bc\u0010\u0015$|nr3j(d)>"));
            }
            Object object2 = avutil.av_d2q(fFmpegFrameFilter.aspectRatio > 0.0 ? fFmpegFrameFilter.aspectRatio : 1.0, 255);
            Object[] arrobject = new Object[9];
            arrobject[0] = fFmpegFrameFilter.imageWidth;
            arrobject[1] = fFmpegFrameFilter.imageHeight;
            arrobject[2] = fFmpegFrameFilter.pixelFormat;
            arrobject[3] = a2.num();
            arrobject[4] = a2.den();
            arrobject[5] = object2.num();
            arrobject[6] = object2.den();
            arrobject[7] = object.num();
            arrobject[8] = object.den();
            object = String.format(Locale.ROOT, SnowAnimation.ALLATORIxDEMO("\u0015S\u0000\\\bl\u001eG\n^XWHFEAAX\u001fA8^\u000bMZ\u001a\u0005\t\u0019\u001bAS7_\u0002Y\u0011\u0000F[N\u000f\u0010H\\s<(n\u000e_\u0002\\\u0004OX? \u0001UYYW\u001dX\n\u001bG\nD\u000b\u0015S]H\u000b\u0014"), arrobject);
            fFmpegFrameFilter.buffersrc_ctx = new AVFilterContext[fFmpegFrameFilter.videoInputs];
            fFmpegFrameFilter.setpts_ctx = new AVFilterContext[fFmpegFrameFilter.videoInputs];
            int n2 = a2 = 0;
            while (n2 < fFmpegFrameFilter.videoInputs) {
                object2 = fFmpegFrameFilter.videoInputs > 1 ? a2 + ":v" : FrameFilter.ALLATORIxDEMO("9o");
                arraVFilterInOut[a2] = avfilter.avfilter_inout_alloc();
                fFmpegFrameFilter.buffersrc_ctx[a2] = (AVFilterContext)new AVFilterContext().retainReference();
                n = avfilter.avfilter_graph_create_filter(fFmpegFrameFilter.buffersrc_ctx[a2], aVFilter, (String)object2, (String)object, null, fFmpegFrameFilter.filter_graph);
                if (n < 0) {
                    throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot create video buffer source.");
                }
                fFmpegFrameFilter.setpts_ctx[a2] = (AVFilterContext)new AVFilterContext().retainReference();
                n = avfilter.avfilter_graph_create_filter(fFmpegFrameFilter.setpts_ctx[a2], aVFilter3, (String)(fFmpegFrameFilter.videoInputs > 1 ? "setpts" + a2 : SnowAnimation.ALLATORIxDEMO("[\u0013M\u0017Z\u0003")), FrameFilter.ALLATORIxDEMO("O"), null, fFmpegFrameFilter.filter_graph);
                if (n < 0) {
                    throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot create setpts filter.");
                }
                n = avfilter.avfilter_link(fFmpegFrameFilter.buffersrc_ctx[a2], 0, fFmpegFrameFilter.setpts_ctx[a2], 0);
                if (n < 0) {
                    throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot link setpts filter.");
                }
                arraVFilterInOut[a2].name(avutil.av_strdup(new BytePointer((String)object2)));
                arraVFilterInOut[a2].filter_ctx(fFmpegFrameFilter.setpts_ctx[a2]);
                arraVFilterInOut[a2].pad_idx(0);
                arraVFilterInOut[a2].next(null);
                if (a2 > 0) {
                    arraVFilterInOut[a2 - 1].next(arraVFilterInOut[a2]);
                }
                n2 = ++a2;
            }
            String a2 = fFmpegFrameFilter.videoInputs > 1 ? SnowAnimation.ALLATORIxDEMO("\u0006") : FrameFilter.ALLATORIxDEMO("y%u");
            fFmpegFrameFilter.buffersink_ctx = (AVFilterContext)new AVFilterContext().retainReference();
            n = avfilter.avfilter_graph_create_filter(fFmpegFrameFilter.buffersink_ctx, aVFilter2, a2, null, null, fFmpegFrameFilter.filter_graph);
            if (n < 0) {
                throw new Exception("avfilter_graph_create_filter() error " + n + ": Cannot create video buffer sink.");
            }
            aVFilterInOut.name(avutil.av_strdup(new BytePointer(a2)));
            aVFilterInOut.filter_ctx(fFmpegFrameFilter.buffersink_ctx);
            aVFilterInOut.pad_idx(0);
            aVFilterInOut.next(null);
            FFmpegFrameFilter fFmpegFrameFilter2 = fFmpegFrameFilter;
            n = avfilter.avfilter_graph_parse_ptr(fFmpegFrameFilter2.filter_graph, fFmpegFrameFilter2.filters, aVFilterInOut, arraVFilterInOut[0], null);
            if (n < 0) {
                throw new Exception("avfilter_graph_parse_ptr() error " + n);
            }
            n = avfilter.avfilter_graph_config(fFmpegFrameFilter.filter_graph, null);
            if (n < 0) {
                throw new Exception("avfilter_graph_config() error " + n);
            }
            fFmpegFrameFilter.time_base = (AVRational)avfilter.av_buffersink_get_time_base(fFmpegFrameFilter.buffersink_ctx).retainReference();
            return;
        }
        finally {
            avfilter.avfilter_inout_free(aVFilterInOut);
            avfilter.avfilter_inout_free(arraVFilterInOut[0]);
        }
    }

    @Override
    public double getFrameRate() {
        Object a;
        FFmpegFrameFilter fFmpegFrameFilter = a;
        if (fFmpegFrameFilter.buffersink_ctx != null) {
            a = avfilter.av_buffersink_get_frame_rate(fFmpegFrameFilter.buffersink_ctx);
            if (((AVRational)((Object)a)).num() == 0 && ((AVRational)((Object)a)).den() == 0) {
                a = avfilter.av_buffersink_get_time_base(fFmpegFrameFilter.buffersink_ctx);
                return (double)((AVRational)((Object)a)).den() / (double)((AVRational)((Object)a)).num();
            }
            return (double)((AVRational)((Object)a)).num() / (double)((AVRational)((Object)a)).den();
        }
        return super.getFrameRate();
    }

    @Override
    public int getSampleFormat() {
        FFmpegFrameFilter a;
        if (a.abuffersink_ctx != null) {
            return avfilter.av_buffersink_get_format(a.abuffersink_ctx);
        }
        return super.getSampleFormat();
    }

    @Override
    public double getAspectRatio() {
        Object a;
        FFmpegFrameFilter fFmpegFrameFilter = a;
        if (fFmpegFrameFilter.buffersink_ctx != null) {
            a = avfilter.av_buffersink_get_sample_aspect_ratio(fFmpegFrameFilter.buffersink_ctx);
            double d = (double)((AVRational)((Object)a)).num() / (double)((AVRational)((Object)a)).den();
            if (d == 0.0) {
                return 1.0;
            }
            return d;
        }
        return super.getAspectRatio();
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameFilter(String string, int n) {
        void a;
        int a2 = n;
        FFmpegFrameFilter a3 = this;
        a3(null, (String)a, 0, 0, a2);
    }

    public static class Exception
    extends FrameFilter.Exception {
        /*
         * WARNING - void declaration
         */
        public Exception(String string, Throwable throwable) {
            void a;
            Throwable a2 = throwable;
            Exception a3 = this;
            super((String)a, a2);
        }

        public Exception(String string) {
            String a = string;
            Exception a2 = this;
            super((String)a + " (For more details, make sure FFmpegLogCallback.set() has been called.)");
        }
    }

}
