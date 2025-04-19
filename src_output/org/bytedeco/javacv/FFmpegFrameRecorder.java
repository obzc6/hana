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

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bytedeco.ffmpeg.avcodec.AVCodec;
import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVCodecParameters;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.ffmpeg.avformat.AVOutputFormat;
import org.bytedeco.ffmpeg.avformat.AVStream;
import org.bytedeco.ffmpeg.avformat.Seek_Pointer_long_int;
import org.bytedeco.ffmpeg.avformat.Write_packet_Pointer_BytePointer_int;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.avutil.AVFrame;
import org.bytedeco.ffmpeg.avutil.AVRational;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avdevice;
import org.bytedeco.ffmpeg.global.avformat;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.ffmpeg.global.swresample;
import org.bytedeco.ffmpeg.global.swscale;
import org.bytedeco.ffmpeg.swresample.SwrContext;
import org.bytedeco.ffmpeg.swscale.SwsContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.PointerScope;
import org.bytedeco.javacpp.ShortPointer;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.Seekable;

public class FFmpegFrameRecorder
extends FrameRecorder {
    private PointerPointer plane_ptr;
    private AVFrame picture;
    private SwsContext img_convert_ctx;
    private String filename;
    private int audio_input_frame_size;
    private BytePointer video_outbuf;
    private volatile boolean started;
    private IntPointer display_matrix;
    static WriteCallback writeCallback;
    private AVStream audio_st;
    private int samples_format;
    private static Exception loadingException;
    private AVCodecContext video_c;
    private AVPacket video_pkt;
    private AVCodec audio_codec;
    private BytePointer[] samples_out;
    private int samples_channels;
    private AVFormatContext oc;
    private Pointer[] samples_in;
    private int samples_rate;
    private AVFrame frame;
    static SeekCallback seekCallback;
    private AVFrame tmp_picture;
    private int video_outbuf_size;
    private OutputStream outputStream;
    private AVOutputFormat oformat;
    private AVStream video_st;
    private SwrContext samples_convert_ctx;
    private AVCodec video_codec;
    static Map<Pointer, OutputStream> outputStreams;
    private int[] got_video_packet;
    private AVCodecContext audio_c;
    private AVPacket audio_pkt;
    private AVIOContext avio;
    private BytePointer audio_outbuf;
    private boolean closeOutputStream;
    private AVFormatContext ifmt_ctx;
    private BytePointer picture_buf;
    private int[] got_audio_packet;
    private int audio_outbuf_size;
    private PointerPointer plane_ptr2;

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(File file, int n, int n2, int n3) {
        void a;
        void a2;
        void a3;
        void a4;
        int n4 = n3;
        FFmpegFrameRecorder a5 = this;
        a5(a3.getAbsolutePath(), (int)a2, (int)a, (int)a4);
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(File file, int n) {
        void a;
        int a2 = n;
        FFmpegFrameRecorder a3 = this;
        a3((File)a, 0, 0, a2);
    }

    public boolean recordSamples(Buffer ... arrbuffer) throws Exception {
        Buffer[] a = arrbuffer;
        Buffer[] a2 = this;
        return a2.recordSamples(0, 0, a);
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(URL uRL, int n) {
        void a;
        int a2 = n;
        FFmpegFrameRecorder a3 = this;
        a3(a.toString(), 0, 0, a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public synchronized boolean recordSamples(int var1_6, int var2_7, Buffer ... var3_8) throws Exception {
        block53 : {
            block52 : {
                block51 : {
                    block50 : {
                        block49 : {
                            block48 : {
                                block47 : {
                                    var13_9 = this /* !! */ ;
                                    var4_10 = new PointerScope();
                                    if (var13_9.audio_st == null) {
                                        throw new Exception(GaussianFilter.ALLATORIxDEMO("\u001eSgJ0M9S(\u000b\u0015x\u0010y?\u0007%N1J @@$\u001dKgJ>C*@7p\"A+L%Vt\u0006b\u001ecN:\\tP\"\\eZ=D&Lj\u0007U{\"N%\u00075[&J&Kj\u0010"));
                                    }
                                    if (!var13_9.started) {
                                        throw new Exception(GaussianKernel.ALLATORIxDEMO("\b\u001d109wqj-)\bI!2(n3#4&\n\u0019x9+/1%<.?>4&6|"));
                                    }
                                    if (a != null || var13_9.samples_out[0].position() <= 0L) break block47;
                                    v0 = var13_9;
                                    v1 = var13_9;
                                    var5_11 = Math.floor((int)Math.min(v0.samples_out[0].limit(), Integer.MAX_VALUE) / v1.audio_input_frame_size);
                                    v1.writeSamples((int)Math.floor((double)((int)v0.samples_out[0].position()) / var5_11));
                                    var7_14 = v0.writeFrame(null);
                                    var4_10.close();
                                    return var7_14;
                                }
                                if (a <= 0) {
                                    a = var13_9.audio_c.sample_rate();
                                }
                                if (a <= 0) {
                                    a = var13_9.audio_c.channels();
                                }
                                if (a == null) break block48;
                                v2 = a[0].limit() - a[0].position();
                                ** GOTO lbl28
                            }
                            v2 = 0;
lbl28: // 2 sources:
                            var6_16 = v2;
                            var7_15 = var13_9.samples_format;
                            var8_18 = a != null && ((void)a).length > 1 ? 1 : a;
                            var9_19 = 0;
                            v3 = var13_9;
                            var10_20 = v3.audio_c.sample_fmt();
                            var11_21 = v3.samples_out.length > 1 ? 1 : var13_9.audio_c.channels();
                            var12_22 = avutil.av_get_bytes_per_sample(var10_20);
                            if (a == null || !(a[0] instanceof ByteBuffer)) break block49;
                            var7_15 = ((void)a).length > 1 ? 5 : 0;
                            var9_19 = 1;
                            v4 = a = 0;
                            while (v4 < ((void)a).length) {
                                var14_23 = (ByteBuffer)a[a];
                                if (var13_9.samples_in[a] instanceof BytePointer && var13_9.samples_in[a].capacity() >= (long)var6_16 && var14_23.hasArray()) {
                                    ((BytePointer)var13_9.samples_in[a]).position(0L).put(var14_23.array(), var14_23.position(), var6_16);
                                } else {
                                    if (var13_9.samples_in[a] != null) {
                                        var13_9.samples_in[a].releaseReference();
                                    }
                                    var13_9.samples_in[a] = new BytePointer((ByteBuffer)var14_23).retainReference();
                                }
                                v4 = ++a;
                            }
                            ** GOTO lbl135
                        }
                        if (a == null || !(a[0] instanceof ShortBuffer)) break block50;
                        var7_15 = ((void)a).length > 1 ? 6 : 1;
                        var9_19 = 2;
                        v5 = a = 0;
                        while (v5 < ((void)a).length) {
                            var14_23 = (ShortBuffer)a[a];
                            if (var13_9.samples_in[a] instanceof ShortPointer && var13_9.samples_in[a].capacity() >= (long)var6_16 && var14_23.hasArray()) {
                                ((ShortPointer)var13_9.samples_in[a]).position(0L).put(var14_23.array(), a[a].position(), var6_16);
                            } else {
                                if (var13_9.samples_in[a] != null) {
                                    var13_9.samples_in[a].releaseReference();
                                }
                                var13_9.samples_in[a] = new ShortPointer((ShortBuffer)var14_23).retainReference();
                            }
                            v5 = ++a;
                        }
                        ** GOTO lbl135
                    }
                    if (a == null || !(a[0] instanceof IntBuffer)) break block51;
                    var7_15 = ((void)a).length > 1 ? 7 : 2;
                    var9_19 = 4;
                    v6 = a = 0;
                    while (v6 < ((void)a).length) {
                        var14_23 = (IntBuffer)a[a];
                        if (var13_9.samples_in[a] instanceof IntPointer && var13_9.samples_in[a].capacity() >= (long)var6_16 && var14_23.hasArray()) {
                            ((IntPointer)var13_9.samples_in[a]).position(0L).put(var14_23.array(), a[a].position(), var6_16);
                        } else {
                            if (var13_9.samples_in[a] != null) {
                                var13_9.samples_in[a].releaseReference();
                            }
                            var13_9.samples_in[a] = new IntPointer((IntBuffer)var14_23).retainReference();
                        }
                        v6 = ++a;
                    }
                    ** GOTO lbl135
                }
                if (a == null || !(a[0] instanceof FloatBuffer)) break block52;
                var7_15 = ((void)a).length > 1 ? 8 : 3;
                var9_19 = 4;
                v7 = a = 0;
                while (v7 < ((void)a).length) {
                    var14_23 = (FloatBuffer)a[a];
                    if (var13_9.samples_in[a] instanceof FloatPointer && var13_9.samples_in[a].capacity() >= (long)var6_16 && var14_23.hasArray()) {
                        ((FloatPointer)var13_9.samples_in[a]).position(0L).put(var14_23.array(), var14_23.position(), var6_16);
                    } else {
                        if (var13_9.samples_in[a] != null) {
                            var13_9.samples_in[a].releaseReference();
                        }
                        var13_9.samples_in[a] = new FloatPointer((FloatBuffer)var14_23).retainReference();
                    }
                    v7 = ++a;
                }
                ** GOTO lbl135
            }
            if (a == null || !(a[0] instanceof DoubleBuffer)) break block53;
            var7_15 = ((void)a).length > 1 ? 9 : 4;
            var9_19 = 8;
            v8 = a = 0;
            while (v8 < ((void)a).length) {
                var14_23 = (DoubleBuffer)a[a];
                if (var13_9.samples_in[a] instanceof DoublePointer && var13_9.samples_in[a].capacity() >= (long)var6_16 && var14_23.hasArray()) {
                    ((DoublePointer)var13_9.samples_in[a]).position(0L).put(var14_23.array(), var14_23.position(), var6_16);
                } else {
                    if (var13_9.samples_in[a] != null) {
                        var13_9.samples_in[a].releaseReference();
                    }
                    var13_9.samples_in[a] = new DoublePointer((DoubleBuffer)var14_23).retainReference();
                }
                v8 = ++a;
            }
            ** GOTO lbl135
        }
        try {
            if (a != null) {
                throw new Exception("Audio samples Buffer has unsupported type: " + String.valueOf(a));
            }
lbl135: // 7 sources:
            if (var13_9.samples_convert_ctx == null || var13_9.samples_channels != a || var13_9.samples_format != var7_15 || var13_9.samples_rate != a) {
                v9 = var13_9;
                var13_9.samples_convert_ctx = swresample.swr_alloc_set_opts(v9.samples_convert_ctx, var13_9.audio_c.channel_layout(), var10_20, var13_9.audio_c.sample_rate(), avutil.av_get_default_channel_layout(a), var7_15, a, 0, null);
                if (v9.samples_convert_ctx == null) {
                    throw new Exception(GaussianFilter.ALLATORIxDEMO("O\u0016?m\f`$D\tI&[\u001eB\u0010x'\u0010n\u000b.U1@\u0006\"cl$G'J \u0018#B/@7Y ]c[-LiF;V4K\u0007j.D%\u00075U$R&W!\u0017"));
                }
                var5_12 = swresample.swr_init(var13_9.samples_convert_ctx);
                if (var5_12 < 0) {
                    throw new Exception("swr_init() error " + var5_12 + ": Cannot initialize the conversion context.");
                }
                v10 = var13_9;
                v10.samples_channels = a;
                v10.samples_format = var7_15;
                var13_9.samples_rate = a;
            }
            v11 = a;
            for (a /* !! */  = (reference)false; v11 != null && a /* !! */  < ((void)a).length; ++a /* !! */ ) {
                v11 = a;
                v12 = var13_9.samples_in[a /* !! */ ].position(var13_9.samples_in[a /* !! */ ].position() * (long)var9_19);
                v13 = var13_9.samples_in[a /* !! */ ].position() + (long)var6_16;
                v12.limit(v13 * (long)var9_19);
            }
            do {
                a /* !! */  = (reference)Math.min(a != null ? (var13_9.samples_in[0].limit() - var13_9.samples_in[0].position()) / (long)(var8_18 * var9_19) : 0L, Integer.MAX_VALUE);
                v14 = a;
                var14_24 = (int)Math.min((var13_9.samples_out[0].limit() - var13_9.samples_out[0].position()) / (long)(var11_21 * var12_22), Integer.MAX_VALUE);
                a /* !! */  = (reference)Math.min((int)a /* !! */ , (var14_24 * a + var13_9.audio_c.sample_rate() - 1) / var13_9.audio_c.sample_rate());
                a = 0;
                while (v14 != null && a < ((void)a).length) {
                    v14 = a;
                    var13_9.plane_ptr.put((long)a, var13_9.samples_in[a++]);
                }
                v15 = a = 0;
                while (v15 < var13_9.samples_out.length) {
                    var13_9.plane_ptr2.put((long)a, (Pointer)var13_9.samples_out[a++]);
                    v15 = a;
                }
                v16 = var13_9;
                var5_12 = swresample.swr_convert(v16.samples_convert_ctx, v16.plane_ptr2, var14_24, var13_9.plane_ptr, (int)a /* !! */ );
                if (var5_12 < 0) {
                    throw new Exception("swr_convert() error " + var5_12 + ": Cannot convert audio samples.");
                }
                if (var5_12 == 0) break;
                v17 = a;
                for (a = 0; v17 != null && a < ((void)a).length; ++a) {
                    v17 = a;
                    v18 = var13_9.samples_in[a];
                    v19 = var13_9.samples_in[a].position();
                    v18.position(v19 + (long)(a /* !! */  * var8_18 * var9_19));
                }
                v20 = a = 0;
                while (v20 < var13_9.samples_out.length) {
                    v21 = var13_9.samples_out[a];
                    v22 = var13_9.samples_out[a].position();
                    v21.position(v22 + (long)(var5_12 * var11_21 * var12_22));
                    v20 = ++a;
                }
                if (a != null && var13_9.samples_out[0].position() < var13_9.samples_out[0].limit()) continue;
                v23 = var13_9;
                v23.writeSamples(v23.audio_input_frame_size);
            } while (true);
            if (a == null) ** break block54
            v24 = var13_9.frame.key_frame() != 0;
            break block55;
        }
        catch (Throwable var5_13) {
            try {
                var4_10.close();
                v25 = var5_13;
                throw v25;
            }
            catch (Throwable var6_17) {
                v26 = var5_13;
                v25 = v26;
                v26.addSuppressed(var6_17);
            }
            throw v25;
        }
        {
            block55 : {
                v24 = var13_9.writeFrame(null);
            }
            a /* !! */  = (reference)v24;
        }
        var4_10.close();
        return (boolean)a /* !! */ ;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void flush() throws Exception {
        Object a;
        FFmpegFrameRecorder fFmpegFrameRecorder = a;
        a = fFmpegFrameRecorder.oc;
        synchronized (a) {
            Object object;
            FFmpegFrameRecorder fFmpegFrameRecorder2 = fFmpegFrameRecorder;
            while (fFmpegFrameRecorder2.video_st != null && fFmpegFrameRecorder.ifmt_ctx == null && fFmpegFrameRecorder.recordImage(0, 0, 0, 0, 0, -1, null)) {
                fFmpegFrameRecorder2 = fFmpegFrameRecorder;
            }
            FFmpegFrameRecorder fFmpegFrameRecorder3 = fFmpegFrameRecorder;
            while (fFmpegFrameRecorder3.audio_st != null && fFmpegFrameRecorder.ifmt_ctx == null && fFmpegFrameRecorder.recordSamples(0, 0, (Buffer[])null)) {
                fFmpegFrameRecorder3 = fFmpegFrameRecorder;
            }
            if (fFmpegFrameRecorder.interleaved && (fFmpegFrameRecorder.video_st != null || fFmpegFrameRecorder.audio_st != null)) {
                avformat.av_interleaved_write_frame(fFmpegFrameRecorder.oc, null);
                object = a;
            } else {
                avformat.av_write_frame(fFmpegFrameRecorder.oc, null);
                object = a;
            }
            // ** MonitorExit[v2 /* !! */ ] (shouldn't be in output)
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(String string, int n) {
        void a;
        int a2 = n;
        FFmpegFrameRecorder a3 = this;
        a3((String)a, 0, 0, a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public synchronized void startUnsafe() throws Exception {
        block112 : {
            block111 : {
                var1_14 = a /* !! */ ;
                var8_15 = new PointerScope();
                if (var1_14.oc != null && !var1_14.oc.isNull()) {
                    throw new Exception(GaussianFilter.ALLATORIxDEMO("?T&Y$\u0014n\u000b-H#\u001ci\b\u0012i\u0001h2\u00074_&AaN\u0001`8]#\u0011kd\"C\u001880[*Ya\ftZ'H,]1\u00186X>R.E3\u0018!J\u0012m<\f|\u0019&L!E-\u0001"));
                }
                v0 = var1_14;
                v1 = var1_14;
                v2 = var1_14;
                v3 = var1_14;
                v4 = var1_14;
                v4.picture = null;
                v4.tmp_picture = null;
                v3.picture_buf = null;
                v3.frame = null;
                v2.video_outbuf = null;
                v2.audio_outbuf = null;
                v5 = var1_14;
                v2.oc = new AVFormatContext(null);
                v1.video_c = null;
                v1.audio_c = null;
                v0.video_st = null;
                v0.audio_st = null;
                var1_14.plane_ptr = (PointerPointer)new PointerPointer(8L).retainReference();
                var1_14.plane_ptr2 = (PointerPointer)new PointerPointer(8L).retainReference();
                var1_14.video_pkt = (AVPacket)new AVPacket().retainReference();
                var1_14.audio_pkt = (AVPacket)new AVPacket().retainReference();
                var1_14.got_video_packet = new int[1];
                var1_14.got_audio_packet = new int[1];
                if (var1_14.format != null && var1_14.format.length() != 0) break block111;
                v6 = null;
                ** GOTO lbl41
            }
            v6 = var1_14.format;
lbl41: // 2 sources:
            var6_16 = v6;
            var1_14.oformat = avformat.av_guess_format(var6_16, var1_14.filename, null);
            if (var1_14.oformat == null) {
                var4_18 = var1_14.filename.indexOf(GaussianKernel.ALLATORIxDEMO("p`r"));
                if (var4_18 > 0) {
                    var6_16 = var1_14.filename.substring(0, var4_18);
                }
                if ((var1_14.oformat = avformat.av_guess_format(var6_16, var1_14.filename, null)) == null) {
                    v7 = var1_14;
                    throw new Exception("av_guess_format() error: Could not guess output format for \"" + v7.filename + "\" and " + v7.format + " format.");
                }
            }
            v8 = var1_14;
            var6_16 = v8.oformat.name().getString();
            if (avformat.avformat_alloc_output_context2(v8.oc, null, var6_16, var1_14.filename) < 0) {
                throw new Exception(GaussianFilter.ALLATORIxDEMO("$_6Sz\t\u0001x?m'K9Y\u001cL.C\u0014i,Lu\u0003b\u0007&]\u0006w1\u0015Lj&P8\\b@,[tY9U=]&_1\u00184Q\u0001r)PuZ(E4I;["));
            }
            if (var1_14.outputStream == null) ** GOTO lbl69
            if (!(var1_14.outputStream instanceof Seekable)) break block112;
            v9 = FFmpegFrameRecorder.seekCallback;
            ** GOTO lbl-1000
        }
        try {
            block114 : {
                block116 : {
                    block117 : {
                        block115 : {
                            v9 = null;
lbl-1000: // 2 sources:
                            {
                                var1_14.avio = avformat.avio_alloc_context(new BytePointer(avutil.av_malloc(4096L)), 4096, 1, (Pointer)var1_14.oc, null, FFmpegFrameRecorder.writeCallback, (Seek_Pointer_long_int)v9);
                            }
                            v10 = var1_14;
                            v10.oc.pb(v10.avio);
                            var1_14.filename = var1_14.outputStream.toString();
                            v11 = var1_14;
                            FFmpegFrameRecorder.outputStreams.put(v11.oc, v11.outputStream);
lbl69: // 2 sources:
                            v12 = var1_14;
                            v12.oc.oformat(v12.oformat);
                            v12.oc.url(new BytePointer(avutil.av_malloc(var1_14.filename.getBytes().length + 1)).putString(var1_14.filename));
                            v13 = var1_14;
                            v13.oc.max_delay(v13.maxDelay);
                            var4_19 = null;
                            var5_20 = null;
                            if (var1_14.ifmt_ctx != null) {
                                v14 = var3_21 = 0;
                                while (v14 < var1_14.ifmt_ctx.nb_streams()) {
                                    var2_27 = var1_14.ifmt_ctx.streams(var3_21);
                                    if (var2_27.codecpar().codec_type() == 0) {
                                        v15 = var4_19 = var2_27;
                                        var1_14.videoCodec = v15.codecpar().codec_id();
                                        if ((long)v15.r_frame_rate().num() != avutil.AV_NOPTS_VALUE && var4_19.r_frame_rate().den() != 0) {
                                            var1_14.frameRate = (double)var4_19.r_frame_rate().num() * 1.0 / (double)var4_19.r_frame_rate().den();
                                        }
                                    } else if (var2_27.codecpar().codec_type() == 1) {
                                        var5_20 = var2_27;
                                        var1_14.audioCodec = var5_20.codecpar().codec_id();
                                    }
                                    v14 = ++var3_21;
                                }
                            }
                            if (var1_14.imageWidth > 0 && var1_14.imageHeight > 0) {
                                if (var1_14.videoCodec == 0) {
                                    var1_14.videoCodec = var1_14.oformat.video_codec();
                                }
                                if ((var1_14.video_codec = avcodec.avcodec_find_encoder_by_name(var1_14.videoCodecName)) == null && (var1_14.video_codec = avcodec.avcodec_find_encoder(var1_14.videoCodec)) == null) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception(GaussianKernel.ALLATORIxDEMO("63?!/<?\u00118%%=Ld\u0015\n\u0014\r50evx/(:\u0014\u001bu}\n'4'7j\f\u0012</=l</;}?$-$+s"));
                                }
                                v16 = var1_14;
                                var3_22 = avutil.av_d2q(v16.frameRate, 1001000);
                                var2_28 = v16.video_codec.supported_framerates();
                                if (var2_28 != null) {
                                    v17 = var2_28;
                                    a = avutil.av_find_nearest_q_idx(var3_22, v17);
                                    var3_22 = v17.position(a);
                                }
                                if ((var1_14.video_st = avformat.avformat_new_stream(var1_14.oc, null)) == null) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception(GaussianFilter.ALLATORIxDEMO("\u0005\u0016j\u000f~&F\"e-J6r\u0013x&]&Fc\u000ecJ\u0006j,]\t\nJ!T&\u000e-@ \u00184U>Q$J ]rH\u001a{-KuJ3Y%M.\u0001"));
                                }
                                var1_14.video_c = avcodec.avcodec_alloc_context3(var1_14.video_codec);
                                if (var1_14.video_c == null) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception(GaussianKernel.ALLATORIxDEMO(";>pn;('\t(74%:\u0014;%0878g2l|+9+3<dl\b6fm\u001fI\u0015\u0006$b,34%9)\u000f\fo+5*5-x/\u0001\u001e7.7\"5`,27?=2;s"));
                                }
                                if (var4_19 != null) {
                                    var7_42 = avcodec.avcodec_parameters_copy(var1_14.video_st.codecpar(), var4_19.codecpar());
                                    if (var7_42 < 0) {
                                        var1_14.releaseUnsafe();
                                        throw new Exception("avcodec_parameters_copy() error " + var7_42 + ": Failed to copy video stream codec parameters from input to output");
                                    }
                                    v18 = var1_14;
                                    v19 = var4_19;
                                    var1_14.videoBitrate = (int)v19.codecpar().bit_rate();
                                    v18.pixelFormat = v19.codecpar().format();
                                    v18.aspectRatio = (double)var4_19.codecpar().sample_aspect_ratio().num() * 1.0 / (double)var4_19.codecpar().sample_aspect_ratio().den();
                                    var1_14.video_c.codec_tag(0);
                                }
                                v20 = var1_14;
                                v20.video_c.codec_id(v20.video_codec.id());
                                var1_14.video_c.codec_type(0);
                                v21 = var1_14;
                                v21.video_c.bit_rate(v21.videoBitrate);
                                if (v20.imageWidth % 2 == 1) {
                                    v22 = var1_14.imageWidth + 1;
                                    a /* !! */  = (FFmpegFrameRecorder)v22;
                                    var1_14.imageHeight = (v22 * var1_14.imageHeight + var1_14.imageWidth / 2) / var1_14.imageWidth;
                                    var1_14.imageWidth = (int)a /* !! */ ;
                                }
                                v23 = var1_14;
                                v23.video_c.width(v23.imageWidth);
                                v24 = var1_14;
                                v24.video_c.height(v24.imageHeight);
                                if (v23.aspectRatio > 0.0) {
                                    v25 = var1_14;
                                    a = avutil.av_d2q(v25.aspectRatio, 255);
                                    v25.video_c.sample_aspect_ratio(a);
                                    var1_14.video_st.sample_aspect_ratio(a);
                                }
                                a = avutil.av_inv_q(var3_22);
                                v26 = var1_14;
                                var1_14.video_st.time_base(a);
                                var1_14.video_c.time_base(a);
                                v26.video_st.avg_frame_rate(var3_22);
                                if (v26.gopSize >= 0) {
                                    v27 = var1_14;
                                    v27.video_c.gop_size(v27.gopSize);
                                }
                                if (var1_14.videoQuality >= 0.0) {
                                    v28 = var1_14;
                                    v28.video_c.flags(v28.video_c.flags() | 2);
                                    var1_14.video_c.global_quality((int)Math.round(118.0 * var1_14.videoQuality));
                                }
                                if (var1_14.pixelFormat != -1) {
                                    v29 = var1_14;
                                    v30 = v29;
                                    var1_14.video_c.pix_fmt(v29.pixelFormat);
                                } else if (var1_14.video_c.codec_id() == 13 || var1_14.video_c.codec_id() == 61 || var1_14.video_c.codec_id() == 25 || var1_14.video_c.codec_id() == 33) {
                                    v31 = var1_14;
                                    v30 = v31;
                                    v31.video_c.pix_fmt(avutil.AV_PIX_FMT_RGB32);
                                } else if (var1_14.video_c.codec_id() == 11) {
                                    v32 = var1_14;
                                    v30 = v32;
                                    v32.video_c.pix_fmt(3);
                                } else if (var1_14.video_c.codec_id() == 7 || var1_14.video_c.codec_id() == 8) {
                                    v33 = var1_14;
                                    v30 = v33;
                                    v33.video_c.pix_fmt(12);
                                } else {
                                    v34 = var1_14;
                                    v30 = v34;
                                    v34.video_c.pix_fmt(0);
                                }
                                if (v30.video_c.codec_id() == 2) {
                                    v35 = var1_14;
                                    v36 = v35;
                                    v35.video_c.max_b_frames(2);
                                } else if (var1_14.video_c.codec_id() == 1) {
                                    v37 = var1_14;
                                    v36 = v37;
                                    v37.video_c.mb_decision(2);
                                } else if (var1_14.video_c.codec_id() == 4) {
                                    if (var1_14.imageWidth <= 128 && var1_14.imageHeight <= 96) {
                                        v38 = var1_14;
                                        v36 = v38;
                                        v38.video_c.width(128).height(96);
                                    } else if (var1_14.imageWidth <= 176 && var1_14.imageHeight <= 144) {
                                        v39 = var1_14;
                                        v36 = v39;
                                        v39.video_c.width(176).height(144);
                                    } else if (var1_14.imageWidth <= 352 && var1_14.imageHeight <= 288) {
                                        v40 = var1_14;
                                        v36 = v40;
                                        v40.video_c.width(352).height(288);
                                    } else if (var1_14.imageWidth <= 704 && var1_14.imageHeight <= 576) {
                                        v41 = var1_14;
                                        v36 = v41;
                                        v41.video_c.width(704).height(576);
                                    } else {
                                        v42 = var1_14;
                                        v36 = v42;
                                        v42.video_c.width(1408).height(1152);
                                    }
                                } else {
                                    if (var1_14.video_c.codec_id() == 27) {
                                        var1_14.video_c.profile(578);
                                    }
                                    v36 = var1_14;
                                }
                                if ((v36.oformat.flags() & 64) != 0) {
                                    v43 = var1_14;
                                    v43.video_c.flags(v43.video_c.flags() | 4194304);
                                }
                                if ((var1_14.video_codec.capabilities() & 512) != 0) {
                                    var1_14.video_c.strict_std_compliance(-2);
                                }
                                if (var1_14.maxBFrames >= 0) {
                                    v44 = var1_14;
                                    var1_14.video_c.max_b_frames(v44.maxBFrames);
                                    v44.video_c.has_b_frames(var1_14.maxBFrames == 0 ? 0 : 1);
                                }
                                if (var1_14.trellis >= 0) {
                                    v45 = var1_14;
                                    v45.video_c.trellis(v45.trellis);
                                }
                            }
                            if (var1_14.audioChannels > 0 && var1_14.audioBitrate > 0 && var1_14.sampleRate > 0) {
                                block113 : {
                                    if (var1_14.audioCodec == 0) {
                                        var1_14.audioCodec = var1_14.oformat.audio_codec();
                                    }
                                    if ((var1_14.audio_codec = avcodec.avcodec_find_encoder_by_name(var1_14.audioCodecName)) == null && (var1_14.audio_codec = avcodec.avcodec_find_encoder(var1_14.audioCodec)) == null) {
                                        var1_14.releaseUnsafe();
                                        throw new Exception(GaussianFilter.ALLATORIxDEMO("\"Y\"B\u0004i7g!B%C\u001cJ\u001a{,K [a\ft]0\\,]n\u0018\u0014L6W(\u000b7W6[\u0010?&K!\u0019!D5B'\u0001"));
                                    }
                                    v46 = var1_14;
                                    var3_23 = avutil.av_d2q(v46.sampleRate, 1001000);
                                    v46.audio_st = avformat.avformat_new_stream(v46.oc, null);
                                    if (v46.audio_st == null) {
                                        var1_14.releaseUnsafe();
                                        throw new Exception(GaussianKernel.ALLATORIxDEMO("*.,1>?!g^9 +\u00118-.+?!cp3d\t\u001b\u0014\u001bjb\u000e0-&>h\u0015\u0006;}=\"<-;+\u001b\u0018x++(;/o.-9=+\"s"));
                                    }
                                    var1_14.audio_c = avcodec.avcodec_alloc_context3(var1_14.audio_codec);
                                    if (var1_14.audio_c == null) {
                                        var1_14.releaseUnsafe();
                                        throw new Exception(GaussianFilter.ALLATORIxDEMO("-V$D4Y$t$E<Sk;\u0003c\u000ex._\"\tk\u0006aH\u0012~;J}\u000b\bH6C\u00108-@1\t(I8W!O7JtY ];QgN:[=Z\u001aq/\u00046V)_%T7\u0001"));
                                    }
                                    if (var5_20 != null && var1_14.audioChannels > 0) {
                                        var7_42 = avcodec.avcodec_parameters_copy(var1_14.audio_st.codecpar(), var5_20.codecpar());
                                        if (var7_42 < 0) {
                                            throw new Exception("avcodec_parameters_copy() error " + var7_42 + ": Failed to copy audio stream codec parameters from input to output");
                                        }
                                        v47 = var1_14;
                                        v48 = var5_20;
                                        var1_14.audioBitrate = (int)var5_20.codecpar().bit_rate();
                                        var1_14.sampleRate = v48.codecpar().sample_rate();
                                        v47.audioChannels = v48.codecpar().channels();
                                        v47.sampleFormat = var5_20.codecpar().format();
                                        var1_14.audio_c.codec_tag(0);
                                        var1_14.audio_st.duration(var5_20.duration());
                                        var1_14.audio_st.time_base().num(var5_20.time_base().num());
                                        var1_14.audio_st.time_base().den(var5_20.time_base().den());
                                    }
                                    v49 = var1_14;
                                    v49.audio_c.codec_id(v49.audio_codec.id());
                                    var1_14.audio_c.codec_type(1);
                                    v50 = var1_14;
                                    v50.audio_c.bit_rate(v50.audioBitrate);
                                    v51 = var1_14;
                                    v51.audio_c.sample_rate(v51.sampleRate);
                                    v52 = var1_14;
                                    v52.audio_c.channels(v52.audioChannels);
                                    v53 = var1_14;
                                    v53.audio_c.channel_layout(avutil.av_get_default_channel_layout(v53.audioChannels));
                                    if (v49.sampleFormat != -1) {
                                        v54 = var3_23;
                                        v55 = var1_14;
                                        v55.audio_c.sample_fmt(v55.sampleFormat);
                                    } else {
                                        var1_14.audio_c.sample_fmt(8);
                                        var2_30 = var1_14.audio_c.codec().sample_fmts();
                                        a = 0;
                                        v56 = var2_30;
                                        while (v56.get((long)a) != -1) {
                                            if (var2_30.get((long)a) == 1) {
                                                v54 = var3_23;
                                                var1_14.audio_c.sample_fmt(1);
                                                break block113;
                                            }
                                            ++a;
                                            v56 = var2_30;
                                        }
                                        v54 = var3_23;
                                    }
                                }
                                var2_32 = avutil.av_inv_q(v54);
                                v57 = var1_14;
                                var1_14.audio_c.time_base(var2_32);
                                v57.audio_st.time_base(var2_32);
                                switch (v57.audio_c.sample_fmt()) {
                                    case 0: 
                                    case 5: {
                                        v58 = var1_14;
                                        while (false) {
                                        }
                                        v59 = v58;
                                        v58.audio_c.bits_per_raw_sample(8);
                                        break;
                                    }
                                    case 1: 
                                    case 6: {
                                        v60 = var1_14;
                                        v59 = v60;
                                        v60.audio_c.bits_per_raw_sample(16);
                                        break;
                                    }
                                    case 2: 
                                    case 7: {
                                        v61 = var1_14;
                                        v59 = v61;
                                        v61.audio_c.bits_per_raw_sample(32);
                                        break;
                                    }
                                    case 3: 
                                    case 8: {
                                        v62 = var1_14;
                                        v59 = v62;
                                        v62.audio_c.bits_per_raw_sample(32);
                                        break;
                                    }
                                    case 4: 
                                    case 9: {
                                        v63 = var1_14;
                                        v59 = v63;
                                        v63.audio_c.bits_per_raw_sample(64);
                                        break;
                                    }
                                    default: {
                                        if (!FFmpegFrameRecorder.$assertionsDisabled) {
                                            throw new AssertionError();
                                        }
                                        v59 = var1_14;
                                    }
                                }
                                if (v59.audioQuality >= 0.0) {
                                    v64 = var1_14;
                                    v64.audio_c.flags(v64.audio_c.flags() | 2);
                                    var1_14.audio_c.global_quality((int)Math.round(118.0 * var1_14.audioQuality));
                                }
                                if ((var1_14.oformat.flags() & 64) != 0) {
                                    v65 = var1_14;
                                    v65.audio_c.flags(v65.audio_c.flags() | 4194304);
                                }
                                if ((var1_14.audio_codec.capabilities() & 512) != 0) {
                                    var1_14.audio_c.strict_std_compliance(-2);
                                }
                            }
                            if (var1_14.video_st != null && var4_19 == null) {
                                var3_24 = new AVDictionary(null);
                                if (var1_14.videoQuality >= 0.0) {
                                    avutil.av_dict_set(var3_24, GaussianKernel.ALLATORIxDEMO(")=;"), "" + var1_14.videoQuality, 0);
                                }
                                v66 = var2_34 = var1_14.videoOptions.entrySet().iterator();
                                while (v66.hasNext()) {
                                    a = var2_34.next();
                                    avutil.av_dict_set(var3_24, (String)a.getKey(), (String)a.getValue(), 0);
                                    v66 = var2_34;
                                }
                                v67 = var1_14;
                                v67.video_c.thread_count(0);
                                var7_42 = avcodec.avcodec_open2(v67.video_c, var1_14.video_codec, var3_24);
                                if (var7_42 < 0) {
                                    var1_14.releaseUnsafe();
                                    avutil.av_dict_free(var3_24);
                                    throw new Exception("avcodec_open2() error " + var7_42 + ": Could not open video codec.");
                                }
                                avutil.av_dict_free(var3_24);
                                var1_14.video_outbuf = null;
                                var1_14.picture = avutil.av_frame_alloc();
                                if (var1_14.picture == null) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception(GaussianFilter.ALLATORIxDEMO("N7r\u0006~5U\"t*K/@\u00170j\u000f [;J&\u0002bm,Z8\\uW=JgJ8T=]\u0012k-\u0004%P$_5^&\u0001"));
                                }
                                var1_14.picture.pts(0L);
                                var2_35 = avutil.av_image_get_buffer_size(var1_14.video_c.pix_fmt(), var1_14.video_c.width(), var1_14.video_c.height(), 1);
                                var1_14.picture_buf = new BytePointer(avutil.av_malloc(var2_35));
                                if (var1_14.picture_buf.isNull()) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception(GaussianKernel.ALLATORIxDEMO("`!\u001a1/'53-vek<as\u0014\u001bAI\u0013-83<j4'\u000fI.10!3#,/O\r1)*9 %o?,->/=s"));
                                }
                                var1_14.tmp_picture = avutil.av_frame_alloc();
                                if (var1_14.tmp_picture == null) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception(GaussianFilter.ALLATORIxDEMO("\u0005\u0016S\u0006~*J3e\"C-B\u0003$}\u0018\"Y9H1\u0015T[,Z)MiK;LbO/C;[4M7\u001e3N9H=L\u0012m1\u0004%P$_5^&\u0001"));
                                }
                                var7_42 = avcodec.avcodec_parameters_from_context(var1_14.video_st.codecpar(), var1_14.video_c);
                                if (var7_42 < 0) {
                                    var1_14.releaseUnsafe();
                                    throw new Exception("avcodec_parameters_from_context() error " + var7_42 + ": Could not copy the video stream parameters.");
                                }
                                a = new AVDictionary(null);
                                v68 = var9_44 = var1_14.videoMetadata.entrySet().iterator();
                                while (v68.hasNext()) {
                                    var10_51 = var9_44.next();
                                    avutil.av_dict_set(a, new BytePointer((String)var10_51.getKey(), var1_14.charset), new BytePointer((String)var10_51.getValue(), var1_14.charset), 0);
                                    v68 = var9_44;
                                }
                                var1_14.video_st.metadata(a);
                                var9_45 = var1_14.videoSideData.entrySet().iterator();
                                while (var9_45.hasNext()) {
                                    var10_51 = var9_45.next();
                                    var11_52 = -1;
                                    v69 = var12_57 = 0;
                                    while (v69 < 32) {
                                        var13_59 = avcodec.av_packet_side_data_name(var12_57);
                                        if (var13_59 != null && !var13_59.isNull() && ((String)var10_51.getKey()).equals(var13_59.getString())) {
                                            var11_52 = var12_57;
                                            break;
                                        }
                                        v69 = ++var12_57;
                                    }
                                    if ((var13_59 = avformat.av_stream_new_side_data(var1_14.video_st, var11_52, (var12_56 = new Pointer((Buffer)var10_51.getValue())).capacity())) == null || var13_59.isNull()) continue;
                                    var13_59.capacity(var12_56.capacity()).put(var12_56);
                                }
                            }
                            if (var1_14.audio_st == null || var5_20 != null) break block114;
                            var3_25 = new AVDictionary(null);
                            if (var1_14.audioQuality >= 0.0) {
                                avutil.av_dict_set(var3_25, GaussianKernel.ALLATORIxDEMO(")=;"), "" + var1_14.audioQuality, 0);
                            }
                            v70 = var2_36 = var1_14.audioOptions.entrySet().iterator();
                            while (v70.hasNext()) {
                                a = var2_36.next();
                                avutil.av_dict_set(var3_25, (String)a.getKey(), (String)a.getValue(), 0);
                                v70 = var2_36;
                            }
                            v71 = var1_14;
                            v71.audio_c.thread_count(0);
                            var7_42 = avcodec.avcodec_open2(v71.audio_c, var1_14.audio_codec, var3_25);
                            if (var7_42 < 0) {
                                var1_14.releaseUnsafe();
                                avutil.av_dict_free(var3_25);
                                throw new Exception("avcodec_open2() error " + var7_42 + ": Could not open audio codec.");
                            }
                            avutil.av_dict_free(var3_25);
                            var1_14.audio_outbuf_size = 262144;
                            var1_14.audio_outbuf = new BytePointer(avutil.av_malloc(var1_14.audio_outbuf_size));
                            if (var1_14.audio_c.frame_size() > 1) break block115;
                            v72 = var1_14;
                            v72.audio_outbuf_size = 16384;
                            var1_14.audio_input_frame_size = v72.audio_outbuf_size / var1_14.audio_c.channels();
                            switch (v72.audio_c.codec_id()) {
                                case 65536: 
                                case 65537: 
                                case 65538: 
                                case 65539: {
                                    v73 = var1_14;
                                    while (false) {
                                    }
                                    v74 = v73;
                                    v73.audio_input_frame_size >>= 1;
                                    break block116;
                                }
                                default: {
                                    break;
                                }
                            }
                            break block117;
                        }
                        var1_14.audio_input_frame_size = var1_14.audio_c.frame_size();
                    }
                    v74 = var1_14;
                }
                var2_37 = avutil.av_sample_fmt_is_planar(v74.audio_c.sample_fmt()) != 0 ? var1_14.audio_c.channels() : 1;
                v75 = var1_14;
                a = avutil.av_samples_get_buffer_size((IntPointer)null, var1_14.audio_c.channels(), v75.audio_input_frame_size, v75.audio_c.sample_fmt(), 1) / var2_37;
                var1_14.samples_out = new BytePointer[var2_37];
                v76 = var9_46 = 0;
                while (v76 < var1_14.samples_out.length) {
                    var1_14.samples_out[var9_46++] = new BytePointer(avutil.av_malloc(a)).capacity((long)a);
                    v76 = var9_46;
                }
                var1_14.samples_in = new Pointer[8];
                var1_14.frame = avutil.av_frame_alloc();
                if (var1_14.frame == null) {
                    var1_14.releaseUnsafe();
                    throw new Exception(GaussianFilter.ALLATORIxDEMO("F e%] @\u0005S5T+D(\u000fj\u000f\u0011j1@7\u0013if;M.JcA;LuX>R(H5L7\u001e\u0012j,M:\u0019!Y!A&\u0001"));
                }
                v77 = var1_14;
                v77.frame.pts(0L);
                var7_42 = avcodec.avcodec_parameters_from_context(v77.audio_st.codecpar(), var1_14.audio_c);
                if (var7_42 < 0) {
                    var1_14.releaseUnsafe();
                    throw new Exception("avcodec_parameters_from_context() error " + var7_42 + ": Could not copy the audio stream parameters.");
                }
                var9_47 = new AVDictionary(null);
                var10_51 = var1_14.audioMetadata.entrySet().iterator();
                v78 = var10_51;
                while (v78.hasNext()) {
                    var11_54 = (Map.Entry)var10_51.next();
                    avutil.av_dict_set(var9_47, new BytePointer((String)var11_54.getKey(), var1_14.charset), new BytePointer((String)var11_54.getValue(), var1_14.charset), 0);
                    v78 = var10_51;
                }
                var1_14.audio_st.metadata(var9_47);
                var10_51 = var1_14.audioSideData.entrySet().iterator();
                while (var10_51.hasNext()) {
                    var11_55 = var10_51.next();
                    var12_58 = -1;
                    v79 = var13_60 = 0;
                    while (v79 < 32) {
                        var4_19 = avcodec.av_packet_side_data_name(var13_60);
                        if (var4_19 != null && !var4_19.isNull() && ((String)var11_55.getKey()).equals(var4_19.getString())) {
                            var12_58 = var13_60;
                            break;
                        }
                        v79 = ++var13_60;
                    }
                    if ((var4_19 = avformat.av_stream_new_side_data(var1_14.audio_st, var12_58, (var13_59 = new Pointer((Buffer)var11_55.getValue())).capacity())) == null || var4_19.isNull()) continue;
                    var4_19.capacity(var13_59.capacity()).put((Pointer)var13_59);
                }
            }
            var3_26 = new AVDictionary(null);
            v80 = var2_38 = var1_14.options.entrySet().iterator();
            while (v80.hasNext()) {
                a = var2_38.next();
                avutil.av_dict_set(var3_26, (String)a.getKey(), (String)a.getValue(), 0);
                v80 = var2_38;
            }
            if (var1_14.outputStream == null && (var1_14.oformat.flags() & 1) == 0) {
                var2_39 = new AVIOContext(null);
                var7_42 = avformat.avio_open2(var2_39, var1_14.filename, 2, null, var3_26);
                if (var7_42 < 0) {
                    a = "avio_open2 error() error " + var7_42 + ": Could not open '" + var1_14.filename + "'";
                    var1_14.releaseUnsafe();
                    avutil.av_dict_free(var3_26);
                    throw new Exception(a);
                }
                var1_14.oc.pb(var2_39);
            }
            var2_41 = new AVDictionary(null);
            v81 = a = var1_14.metadata.entrySet().iterator();
            while (v81.hasNext()) {
                var9_50 = a.next();
                avutil.av_dict_set(var2_41, new BytePointer((String)var9_50.getKey(), var1_14.charset), new BytePointer((String)var9_50.getValue(), var1_14.charset), 0);
                v81 = a;
            }
            var7_42 = avformat.avformat_write_header(var1_14.oc.metadata(var2_41), var3_26);
            if (var7_42 < 0) {
                a = "avformat_write_header error() error " + var7_42 + ": Could not write header to '" + var1_14.filename + "'";
                var1_14.releaseUnsafe();
                avutil.av_dict_free(var3_26);
                throw new Exception(a);
            }
            avutil.av_dict_free(var3_26);
            if (avutil.av_log_get_level() >= 32) {
                avformat.av_dump_format(var1_14.oc, 0, var1_14.filename, 1);
            }
            var1_14.started = true;
        }
        catch (Throwable var7_43) {
            try {
                var8_15.close();
                v82 = var7_43;
            }
            catch (Throwable var6_17) {
                v83 = var7_43;
                v82 = v83;
                v83.addSuppressed(var6_17);
            }
            throw v82;
        }
        var8_15.close();
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(OutputStream outputStream, int n, int n2, int n3) {
        FFmpegFrameRecorder a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n4 = n3;
        FFmpegFrameRecorder fFmpegFrameRecorder = a = this;
        void v1 = a4;
        a(v1.toString(), (int)a3, (int)a2, (int)a5);
        fFmpegFrameRecorder.outputStream = v1;
        fFmpegFrameRecorder.closeOutputStream = true;
    }

    @Override
    public void setFrameNumber(int n) {
        int a = n;
        FFmpegFrameRecorder a2 = this;
        if (a2.picture == null) {
            super.setFrameNumber(a);
            return;
        }
        a2.picture.pts(a);
    }

    public void start(AVFormatContext aVFormatContext) throws Exception {
        Object a = aVFormatContext;
        FFmpegFrameRecorder a2 = this;
        a2.ifmt_ctx = a;
        a2.start();
    }

    /*
     * WARNING - void declaration
     */
    public synchronized void record(Frame frame, int n) throws Exception {
        void a;
        AutoCloseable a2 = frame;
        FFmpegFrameRecorder a3 = this;
        if (a2 == null || ((Frame)a2).image == null && ((Frame)a2).samples == null && ((Frame)a2).data == null) {
            a3.recordImage(0, 0, 0, 0, 0, (int)a, null);
            return;
        }
        if (((Frame)a2).image != null) {
            AutoCloseable autoCloseable = a2;
            ((Frame)a2).keyFrame = a3.recordImage(((Frame)a2).imageWidth, ((Frame)a2).imageHeight, ((Frame)autoCloseable).imageDepth, ((Frame)autoCloseable).imageChannels, ((Frame)a2).imageStride, (int)a, ((Frame)a2).image);
        }
        if (((Frame)a2).samples != null) {
            ((Frame)a2).keyFrame = a3.recordSamples(((Frame)a2).sampleRate, ((Frame)a2).audioChannels, ((Frame)a2).samples);
        }
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(OutputStream outputStream, int n) {
        FFmpegFrameRecorder a;
        void a2;
        int a3 = n;
        FFmpegFrameRecorder fFmpegFrameRecorder = a = this;
        void v1 = a2;
        a(v1.toString(), a3);
        fFmpegFrameRecorder.outputStream = v1;
        fFmpegFrameRecorder.closeOutputStream = true;
    }

    /*
     * WARNING - void declaration
     */
    public static FFmpegFrameRecorder createDefault(String string, int n, int n2) throws Exception {
        void a;
        int a2 = n2;
        String a3 = string;
        return new FFmpegFrameRecorder(a3, (int)a, a2);
    }

    /*
     * WARNING - void declaration
     */
    public static FFmpegFrameRecorder createDefault(File file, int n, int n2) throws Exception {
        void a;
        int a2 = n2;
        File a3 = file;
        return new FFmpegFrameRecorder(a3, (int)a, a2);
    }

    public boolean isCloseOutputStream() {
        FFmpegFrameRecorder a;
        return a.closeOutputStream;
    }

    @Override
    public void setTimestamp(long a) {
        FFmpegFrameRecorder a2;
        FFmpegFrameRecorder fFmpegFrameRecorder = a2;
        fFmpegFrameRecorder.setFrameNumber((int)Math.round((double)a * fFmpegFrameRecorder.getFrameRate() / 1000000.0));
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(URL uRL, int n, int n2, int n3) {
        void a;
        void a2;
        void a3;
        void a4;
        int n4 = n3;
        FFmpegFrameRecorder a5 = this;
        a5(a3.toString(), (int)a2, (int)a, (int)a4);
    }

    static {
        loadingException = null;
        try {
            FFmpegFrameRecorder.tryLoad();
        }
        catch (Exception exception) {
            // empty catch block
        }
        outputStreams = Collections.synchronizedMap(new HashMap());
        writeCallback = (WriteCallback)new WriteCallback().retainReference();
        seekCallback = (SeekCallback)new SeekCallback().retainReference();
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(OutputStream outputStream, int n, int n2) {
        void a;
        void a2;
        FFmpegFrameRecorder a3;
        int a4 = n2;
        FFmpegFrameRecorder fFmpegFrameRecorder = a3 = this;
        void v1 = a2;
        a3(v1.toString(), (int)a, a4);
        fFmpegFrameRecorder.outputStream = v1;
        fFmpegFrameRecorder.closeOutputStream = true;
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(String string, int n, int n2, int n3) {
        FFmpegFrameRecorder a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n4 = n3;
        FFmpegFrameRecorder fFmpegFrameRecorder = a = this;
        FFmpegFrameRecorder fFmpegFrameRecorder2 = a;
        FFmpegFrameRecorder fFmpegFrameRecorder3 = a;
        FFmpegFrameRecorder fFmpegFrameRecorder4 = a;
        FFmpegFrameRecorder fFmpegFrameRecorder5 = a;
        FFmpegFrameRecorder fFmpegFrameRecorder6 = a;
        FFmpegFrameRecorder fFmpegFrameRecorder7 = a;
        fFmpegFrameRecorder7.started = false;
        fFmpegFrameRecorder7.filename = a3;
        fFmpegFrameRecorder6.imageWidth = a4;
        fFmpegFrameRecorder6.imageHeight = a2;
        fFmpegFrameRecorder5.audioChannels = a5;
        fFmpegFrameRecorder5.pixelFormat = -1;
        fFmpegFrameRecorder4.videoCodec = 0;
        fFmpegFrameRecorder4.videoBitrate = 400000;
        fFmpegFrameRecorder3.frameRate = 30.0;
        fFmpegFrameRecorder3.sampleFormat = -1;
        fFmpegFrameRecorder2.audioCodec = 0;
        fFmpegFrameRecorder2.audioBitrate = 64000;
        fFmpegFrameRecorder.sampleRate = 44100;
        fFmpegFrameRecorder.interleaved = true;
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(File file, int n, int n2) {
        void a;
        void a2;
        int a3 = n2;
        FFmpegFrameRecorder a4 = this;
        a4((File)a2, (int)a, a3, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private /* synthetic */ void writePacket(int n, AVPacket aVPacket) throws Exception {
        void a;
        AVStream aVStream;
        int a22 = n;
        FFmpegFrameRecorder a3 = this;
        AVStream aVStream2 = a22 == 0 ? a3.video_st : (aVStream = a22 == 1 ? a3.audio_st : null);
        String string = a22 == 0 ? GaussianKernel.ALLATORIxDEMO("=1.*2") : (a22 == 1 ? GaussianFilter.ALLATORIxDEMO("@6K;Q") : GaussianKernel.ALLATORIxDEMO("?4;\u000e\u0019?2.:5&x'\n\u00191+~?&2*<4k,3?8"));
        AVFormatContext a22 = a3.oc;
        synchronized (a22) {
            if (a3.interleaved && aVStream != null) {
                int n2 = avformat.av_interleaved_write_frame(a3.oc, (AVPacket)a);
                if (n2 < 0) {
                    avcodec.av_packet_unref((AVPacket)a);
                    throw new Exception("av_interleaved_write_frame() error " + n2 + " while writing interleaved " + string + " packet.");
                }
            } else {
                int n3 = avformat.av_write_frame(a3.oc, (AVPacket)a);
                if (n3 < 0) {
                    avcodec.av_packet_unref((AVPacket)a);
                    throw new Exception("av_write_frame() error " + n3 + " while writing " + string + " packet.");
                }
            }
        }
        avcodec.av_packet_unref((AVPacket)a);
    }

    private /* synthetic */ boolean writeFrame(AVFrame a) throws Exception {
        FFmpegFrameRecorder fFmpegFrameRecorder;
        block8 : {
            FFmpegFrameRecorder a22;
            FFmpegFrameRecorder fFmpegFrameRecorder2 = a22;
            int a22 = avcodec.avcodec_send_frame(fFmpegFrameRecorder2.audio_c, a);
            if (a22 < 0 && a != null) {
                throw new Exception("avcodec_send_frame() error " + a22 + ": Error sending an audio frame for encoding.");
            }
            if (a != null) {
                AVFrame aVFrame = a;
                aVFrame.pts(a.pts() + (long)aVFrame.nb_samples());
            }
            fFmpegFrameRecorder2.got_audio_packet[0] = 0;
            while (a22 >= 0) {
                FFmpegFrameRecorder fFmpegFrameRecorder3 = fFmpegFrameRecorder2;
                avcodec.av_new_packet(fFmpegFrameRecorder3.audio_pkt, fFmpegFrameRecorder3.audio_outbuf_size);
                FFmpegFrameRecorder fFmpegFrameRecorder4 = fFmpegFrameRecorder2;
                a22 = avcodec.avcodec_receive_packet(fFmpegFrameRecorder4.audio_c, fFmpegFrameRecorder4.audio_pkt);
                if (a22 == avutil.AVERROR_EAGAIN() || a22 == avutil.AVERROR_EOF()) {
                    FFmpegFrameRecorder fFmpegFrameRecorder5 = fFmpegFrameRecorder2;
                    fFmpegFrameRecorder = fFmpegFrameRecorder5;
                    avcodec.av_packet_unref(fFmpegFrameRecorder5.audio_pkt);
                } else {
                    if (a22 < 0) {
                        avcodec.av_packet_unref(fFmpegFrameRecorder2.audio_pkt);
                        throw new Exception("avcodec_receive_packet() error " + a22 + ": Error during audio encoding.");
                    }
                    FFmpegFrameRecorder fFmpegFrameRecorder6 = fFmpegFrameRecorder2;
                    fFmpegFrameRecorder6.got_audio_packet[0] = 1;
                    if (fFmpegFrameRecorder6.audio_pkt.pts() != avutil.AV_NOPTS_VALUE) {
                        FFmpegFrameRecorder fFmpegFrameRecorder7 = fFmpegFrameRecorder2;
                        fFmpegFrameRecorder7.audio_pkt.pts(avutil.av_rescale_q(fFmpegFrameRecorder7.audio_pkt.pts(), fFmpegFrameRecorder2.audio_c.time_base(), fFmpegFrameRecorder2.audio_st.time_base()));
                    }
                    if (fFmpegFrameRecorder2.audio_pkt.dts() != avutil.AV_NOPTS_VALUE) {
                        FFmpegFrameRecorder fFmpegFrameRecorder8 = fFmpegFrameRecorder2;
                        fFmpegFrameRecorder8.audio_pkt.dts(avutil.av_rescale_q(fFmpegFrameRecorder8.audio_pkt.dts(), fFmpegFrameRecorder2.audio_c.time_base(), fFmpegFrameRecorder2.audio_st.time_base()));
                    }
                    FFmpegFrameRecorder fFmpegFrameRecorder9 = fFmpegFrameRecorder2;
                    fFmpegFrameRecorder9.audio_pkt.flags(fFmpegFrameRecorder9.audio_pkt.flags() | 1);
                    FFmpegFrameRecorder fFmpegFrameRecorder10 = fFmpegFrameRecorder2;
                    fFmpegFrameRecorder10.audio_pkt.stream_index(fFmpegFrameRecorder10.audio_st.index());
                    FFmpegFrameRecorder fFmpegFrameRecorder11 = fFmpegFrameRecorder2;
                    fFmpegFrameRecorder11.writePacket(1, fFmpegFrameRecorder11.audio_pkt);
                    if (a != null) continue;
                    fFmpegFrameRecorder = fFmpegFrameRecorder2;
                }
                break block8;
            }
            fFmpegFrameRecorder = fFmpegFrameRecorder2;
        }
        return fFmpegFrameRecorder.got_audio_packet[0] != 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public synchronized boolean recordImage(int var1_3, int var2_5, int var3_6, int var4_7, int var5_8, int var6_10, Buffer ... var7_11) throws Exception {
        a = var1_3;
        a = this;
        var8_12 = new PointerScope();
        try {
            block31 : {
                if (a.video_st == null) {
                    throw new Exception(GaussianKernel.ALLATORIxDEMO("\u0017$T\u00109&9!z'->\"5;})<ad> d~\u0000(x#4*?/\t%64{!ielnm|'3-,<[d\u0012\u000e\u0013\u001dp|mox+4,[\u0001..|=$#*>GTx(;)<`,<5'=.pt"));
                }
                if (!a.started) {
                    throw new Exception(GaussianFilter.ALLATORIxDEMO("0[$[=\r}\u00185O0\u000f:W \u0018 N)E,AtK7M\ff8T!^-A:\u000e"));
                }
                if (a == null) ** GOTO lbl78
                if (((void)a).length == 0) {
                    v0 = a;
                } else {
                    var9_13 = a * Math.abs((int)a) / 8;
                    v1 = a = a[0] instanceof ByteBuffer != false ? new BytePointer((ByteBuffer)a[0]).position(0L) : new BytePointer(new Pointer((Buffer)a[0]).position(0L));
                    if (a == -1) {
                        if ((a == 8 || a == -8) && a == 3) {
                            v2 = a = 3;
                        } else if ((a == 8 || a == -8) && a == true) {
                            v2 = a = 8;
                        } else if ((a == 16 || a == -16) && a == true) {
                            v2 = a = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN) != false ? 29 : 30;
                        } else if ((a == 8 || a == -8) && a == 4) {
                            v2 = a = 26;
                        } else {
                            if (a != 8) {
                                if (a != -8) throw new Exception("Could not guess pixel format of image: depth=" + (int)a + ", channels=" + (int)a);
                            }
                            if (a != 2) throw new Exception("Could not guess pixel format of image: depth=" + (int)a + ", channels=" + (int)a);
                            v2 = a = 24;
                        }
                    } else {
                        v2 = a;
                    }
                    if (v2 == 24) {
                        var9_13 = a;
                    }
                    if (a.video_c.pix_fmt() != a || a.video_c.width() != a || a.video_c.height() != a) {
                        a.img_convert_ctx = swscale.sws_getCachedContext(a.img_convert_ctx, a, (int)a, a, a.video_c.width(), a.video_c.height(), a.video_c.pix_fmt(), a.imageScalingFlags != 0 ? a.imageScalingFlags : 2, null, null, (DoublePointer)null);
                        if (a.img_convert_ctx == null) {
                            throw new Exception(GaussianKernel.ALLATORIxDEMO("r(>\u001b1,/\u001b+:#=.\u001d#<4vy#mun.+.!,vk\u001aro\u0015\u0006\u000fI9,$+1+6!\u0001\fo)4+p!7$\u0019\u0018*97#<`,27?=2;s"));
                        }
                        avutil.av_image_fill_arrays(new PointerPointer((Pointer)a.tmp_picture), a.tmp_picture.linesize(), a, a, a, (int)a, 1);
                        v3 = a;
                        avutil.av_image_fill_arrays(new PointerPointer((Pointer)a.picture), a.picture.linesize(), v3.picture_buf, v3.video_c.pix_fmt(), a.video_c.width(), a.video_c.height(), 1);
                        a.tmp_picture.linesize(0, var9_13);
                        a.tmp_picture.format(a);
                        a.tmp_picture.width(a);
                        a.tmp_picture.height((int)a);
                        v4 = a;
                        v4.picture.format(v4.video_c.pix_fmt());
                        v5 = a;
                        v5.picture.width(v5.video_c.width());
                        v6 = a;
                        v6.picture.height(v6.video_c.height());
                        swscale.sws_scale(a.img_convert_ctx, new PointerPointer((Pointer)a.tmp_picture), a.tmp_picture.linesize(), 0, (int)a, new PointerPointer((Pointer)a.picture), a.picture.linesize());
                        v0 = a;
                    } else {
                        avutil.av_image_fill_arrays(new PointerPointer((Pointer)a.picture), a.picture.linesize(), a, a, a, (int)a, 1);
                        a.picture.linesize(0, var9_13);
                        a.picture.format(a);
                        a.picture.width(a);
                        a.picture.height((int)a);
lbl78: // 2 sources:
                        v0 = a;
                    }
                }
                v0.picture.quality(a.video_c.global_quality());
                a = avcodec.avcodec_send_frame(a.video_c, a == null || ((void)a).length == 0 ? null : a.picture);
                if (a < 0 && a != null && ((void)a).length != 0) {
                    throw new Exception("avcodec_send_frame() error " + a + ": Error sending a video frame for encoding.");
                }
                v7 = a;
                v7.picture.pts(v7.picture.pts() + 1L);
                a.got_video_packet[0] = 0;
                v8 = a;
                while (v8 >= 0) {
                    v9 = a;
                    avcodec.av_new_packet(v9.video_pkt, v9.video_outbuf_size);
                    v10 = a;
                    a = avcodec.avcodec_receive_packet(v10.video_c, v10.video_pkt);
                    if (a == avutil.AVERROR_EAGAIN() || a == avutil.AVERROR_EOF()) {
                        avcodec.av_packet_unref(a.video_pkt);
                        v11 = a;
                        break block31;
                    }
                    if (a < 0) {
                        avcodec.av_packet_unref(a.video_pkt);
                        throw new Exception("avcodec_receive_packet() error " + a + ": Error during video encoding.");
                    }
                    v12 = a;
                    v12.got_video_packet[0] = 1;
                    if (v12.video_pkt.pts() != avutil.AV_NOPTS_VALUE) {
                        v13 = a;
                        v13.video_pkt.pts(avutil.av_rescale_q(v13.video_pkt.pts(), a.video_c.time_base(), a.video_st.time_base()));
                    }
                    if (a.video_pkt.dts() != avutil.AV_NOPTS_VALUE) {
                        v14 = a;
                        v14.video_pkt.dts(avutil.av_rescale_q(v14.video_pkt.dts(), a.video_c.time_base(), a.video_st.time_base()));
                    }
                    v15 = a;
                    v15.video_pkt.stream_index(v15.video_st.index());
                    v16 = a;
                    v16.writePacket(0, v16.video_pkt);
                    v8 = a;
                }
                v11 = a;
            }
            var9_13 = v11 != null ? ((a.video_pkt.flags() & 1) != 0 ? 1 : 0) : (a.got_video_packet[0] != 0 ? 1 : 0);
        }
        catch (Throwable a) {
            try {
                var8_12.close();
                v17 = a;
                throw v17;
            }
            catch (Throwable var9_14) {
                v18 = a;
                v17 = v18;
                v18.addSuppressed(var9_14);
            }
            throw v17;
        }
        var8_12.close();
        return (boolean)var9_13;
    }

    @Override
    public long getTimestamp() {
        FFmpegFrameRecorder a;
        return Math.round((double)((long)a.getFrameNumber() * 1000000L) / a.getFrameRate());
    }

    public void setDisplayRotation(double a) {
        FFmpegFrameRecorder a2;
        if (a2.display_matrix == null) {
            FFmpegFrameRecorder fFmpegFrameRecorder = a2;
            fFmpegFrameRecorder.display_matrix = (IntPointer)new IntPointer(9L).retainReference();
        }
        avutil.av_display_rotation_set(a2.display_matrix, -a);
        a2.setVideoSideData(GaussianKernel.ALLATORIxDEMO("\u001c#-<>!6}\u0014*,8&%"), a2.display_matrix.asByteBuffer());
    }

    public void setCloseOutputStream(boolean bl) {
        boolean a = bl;
        FFmpegFrameRecorder a2 = this;
        a2.closeOutputStream = a;
    }

    @Override
    public void stop() throws Exception {
        FFmpegFrameRecorder a;
        FFmpegFrameRecorder fFmpegFrameRecorder = a;
        if (fFmpegFrameRecorder.oc != null) {
            try {
                FFmpegFrameRecorder fFmpegFrameRecorder2 = fFmpegFrameRecorder;
                fFmpegFrameRecorder2.flush();
                avformat.av_write_trailer(fFmpegFrameRecorder2.oc);
                return;
            }
            finally {
                fFmpegFrameRecorder.release();
            }
        }
    }

    @Override
    public int getFrameNumber() {
        FFmpegFrameRecorder a;
        if (a.picture == null) {
            return super.getFrameNumber();
        }
        return (int)a.picture.pts();
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(URL uRL, int n, int n2) {
        void a;
        void a2;
        int a3 = n2;
        FFmpegFrameRecorder a4 = this;
        a4(a2.toString(), (int)a, a3, 0);
    }

    protected void finalize() throws Throwable {
        FFmpegFrameRecorder a;
        FFmpegFrameRecorder fFmpegFrameRecorder = a;
        Object.super.finalize();
        fFmpegFrameRecorder.release();
    }

    public synchronized boolean recordPacket(AVPacket aVPacket) throws Exception {
        AVPacket a = aVPacket;
        FFmpegFrameRecorder a2 = this;
        if (a2.ifmt_ctx == null) {
            throw new Exception(GaussianFilter.ALLATORIxDEMO("rgD\tb\u0010y?\u00070U1B Y@o;V3N3Sc\u0007<y0\u000f6](W \u0010\u0003x\u0005@&U5L\u0000@+],] \u0011bL\u0013)\u000b&H!M&Km\u0017"));
        }
        if (!a2.started) {
            throw new Exception(GaussianKernel.ALLATORIxDEMO("\b\u001d109wqj-)\bI!2(n3#4&\n\u0019x9+/1%<.?>4&6|"));
        }
        if (a == null) {
            return false;
        }
        AVStream aVStream = a2.ifmt_ctx.streams(a.stream_index());
        a.pos(-1L);
        if (aVStream.codecpar().codec_type() == 0 && a2.video_st != null) {
            a.stream_index(a2.video_st.index());
            Object object = a;
            ((AVPacket)((Object)object)).duration((int)avutil.av_rescale_q(((AVPacket)((Object)object)).duration(), aVStream.time_base(), a2.video_st.time_base()));
            Object object2 = a;
            ((AVPacket)((Object)object2)).pts(avutil.av_rescale_q_rnd(((AVPacket)((Object)object2)).pts(), aVStream.time_base(), a2.video_st.time_base(), 8197));
            Object object3 = a;
            ((AVPacket)((Object)object3)).dts(avutil.av_rescale_q_rnd(((AVPacket)((Object)object3)).dts(), aVStream.time_base(), a2.video_st.time_base(), 8197));
            a2.writePacket(0, a);
        } else if (aVStream.codecpar().codec_type() == 1 && a2.audio_st != null && a2.audioChannels > 0) {
            a.stream_index(a2.audio_st.index());
            Object object = a;
            ((AVPacket)((Object)object)).duration((int)avutil.av_rescale_q(((AVPacket)((Object)object)).duration(), aVStream.time_base(), a2.audio_st.time_base()));
            Object object4 = a;
            ((AVPacket)((Object)object4)).pts(avutil.av_rescale_q_rnd(((AVPacket)((Object)object4)).pts(), aVStream.time_base(), a2.audio_st.time_base(), 8197));
            Object object5 = a;
            ((AVPacket)((Object)object5)).dts(avutil.av_rescale_q_rnd(((AVPacket)((Object)object5)).dts(), aVStream.time_base(), a2.audio_st.time_base(), 8197));
            a2.writePacket(1, a);
        }
        return true;
    }

    public static void tryLoad() throws Exception {
        if (loadingException != null) {
            throw loadingException;
        }
        try {
            Loader.load(avutil.class);
            Loader.load(swresample.class);
            Loader.load(avcodec.class);
            Loader.load(avformat.class);
            Loader.load(swscale.class);
            avcodec.av_jni_set_java_vm(Loader.getJavaVM(), null);
            avformat.avformat_network_init();
            Loader.load(avdevice.class);
            avdevice.avdevice_register_all();
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
    public void record(Frame frame) throws Exception {
        AutoCloseable a = frame;
        FFmpegFrameRecorder a2 = this;
        AutoCloseable autoCloseable = a;
        a2.record((Frame)autoCloseable, autoCloseable != null && ((Frame)a).opaque instanceof AVFrame ? ((AVFrame)((Object)((Frame)a).opaque)).format() : -1);
    }

    public synchronized void releaseUnsafe() throws Exception {
        Object a;
        FFmpegFrameRecorder fFmpegFrameRecorder = a;
        fFmpegFrameRecorder.started = false;
        if (fFmpegFrameRecorder.display_matrix != null) {
            fFmpegFrameRecorder.display_matrix.releaseReference();
        }
        if (fFmpegFrameRecorder.plane_ptr != null && fFmpegFrameRecorder.plane_ptr2 != null) {
            fFmpegFrameRecorder.plane_ptr.releaseReference();
            fFmpegFrameRecorder.plane_ptr2.releaseReference();
            fFmpegFrameRecorder.plane_ptr2 = null;
            fFmpegFrameRecorder.plane_ptr = null;
        }
        if (fFmpegFrameRecorder.video_pkt != null && fFmpegFrameRecorder.audio_pkt != null) {
            fFmpegFrameRecorder.video_pkt.releaseReference();
            fFmpegFrameRecorder.audio_pkt.releaseReference();
            fFmpegFrameRecorder.audio_pkt = null;
            fFmpegFrameRecorder.video_pkt = null;
        }
        if (fFmpegFrameRecorder.video_c != null) {
            avcodec.avcodec_free_context(fFmpegFrameRecorder.video_c);
            fFmpegFrameRecorder.video_c = null;
        }
        if (fFmpegFrameRecorder.audio_c != null) {
            avcodec.avcodec_free_context(fFmpegFrameRecorder.audio_c);
            fFmpegFrameRecorder.audio_c = null;
        }
        if (fFmpegFrameRecorder.picture_buf != null) {
            avutil.av_free((Pointer)fFmpegFrameRecorder.picture_buf);
            fFmpegFrameRecorder.picture_buf = null;
        }
        if (fFmpegFrameRecorder.picture != null) {
            avutil.av_frame_free(fFmpegFrameRecorder.picture);
            fFmpegFrameRecorder.picture = null;
        }
        if (fFmpegFrameRecorder.tmp_picture != null) {
            avutil.av_frame_free(fFmpegFrameRecorder.tmp_picture);
            fFmpegFrameRecorder.tmp_picture = null;
        }
        if (fFmpegFrameRecorder.video_outbuf != null) {
            avutil.av_free((Pointer)fFmpegFrameRecorder.video_outbuf);
            fFmpegFrameRecorder.video_outbuf = null;
        }
        if (fFmpegFrameRecorder.frame != null) {
            avutil.av_frame_free(fFmpegFrameRecorder.frame);
            fFmpegFrameRecorder.frame = null;
        }
        if (fFmpegFrameRecorder.samples_in != null) {
            int n = a = 0;
            while (n < fFmpegFrameRecorder.samples_in.length) {
                if (fFmpegFrameRecorder.samples_in[a] != null) {
                    fFmpegFrameRecorder.samples_in[a].releaseReference();
                }
                n = ++a;
            }
            fFmpegFrameRecorder.samples_in = null;
        }
        if (fFmpegFrameRecorder.samples_out != null) {
            int n = a = 0;
            while (n < fFmpegFrameRecorder.samples_out.length) {
                BytePointer bytePointer = fFmpegFrameRecorder.samples_out[a];
                avutil.av_free((Pointer)bytePointer.position(0L));
                n = ++a;
            }
            fFmpegFrameRecorder.samples_out = null;
        }
        if (fFmpegFrameRecorder.audio_outbuf != null) {
            avutil.av_free((Pointer)fFmpegFrameRecorder.audio_outbuf);
            fFmpegFrameRecorder.audio_outbuf = null;
        }
        if (fFmpegFrameRecorder.video_st != null && fFmpegFrameRecorder.video_st.metadata() != null) {
            FFmpegFrameRecorder fFmpegFrameRecorder2 = fFmpegFrameRecorder;
            avutil.av_dict_free(fFmpegFrameRecorder2.video_st.metadata());
            fFmpegFrameRecorder2.video_st.metadata(null);
        }
        if (fFmpegFrameRecorder.audio_st != null && fFmpegFrameRecorder.audio_st.metadata() != null) {
            FFmpegFrameRecorder fFmpegFrameRecorder3 = fFmpegFrameRecorder;
            avutil.av_dict_free(fFmpegFrameRecorder3.audio_st.metadata());
            fFmpegFrameRecorder3.audio_st.metadata(null);
        }
        fFmpegFrameRecorder.video_st = null;
        fFmpegFrameRecorder.audio_st = null;
        fFmpegFrameRecorder.filename = null;
        a = fFmpegFrameRecorder.oc;
        if (fFmpegFrameRecorder.oc != null && !fFmpegFrameRecorder.oc.isNull()) {
            if (fFmpegFrameRecorder.outputStream == null && (fFmpegFrameRecorder.oformat.flags() & 1) == 0) {
                avformat.avio_close(fFmpegFrameRecorder.oc.pb());
            }
            avformat.avformat_free_context(fFmpegFrameRecorder.oc);
            fFmpegFrameRecorder.oc = null;
        }
        if (fFmpegFrameRecorder.img_convert_ctx != null) {
            swscale.sws_freeContext(fFmpegFrameRecorder.img_convert_ctx);
            fFmpegFrameRecorder.img_convert_ctx = null;
        }
        if (fFmpegFrameRecorder.samples_convert_ctx != null) {
            swresample.swr_free(fFmpegFrameRecorder.samples_convert_ctx);
            fFmpegFrameRecorder.samples_convert_ctx = null;
        }
        if (fFmpegFrameRecorder.outputStream != null) {
            try {
                if (fFmpegFrameRecorder.closeOutputStream) {
                    fFmpegFrameRecorder.outputStream.close();
                }
                fFmpegFrameRecorder.outputStream = null;
                outputStreams.remove(a);
            }
            catch (IOException iOException) {
                try {
                    throw new Exception(GaussianFilter.ALLATORIxDEMO("k1];JtW-\u000f\u0005S7_2_\u0006M1J\u0012rfG9V4Nh\u0005y\u000f"), iOException);
                }
                catch (Throwable throwable) {
                    fFmpegFrameRecorder.outputStream = null;
                    outputStreams.remove(a);
                    if (fFmpegFrameRecorder.avio != null) {
                        if (fFmpegFrameRecorder.avio.buffer() != null) {
                            FFmpegFrameRecorder fFmpegFrameRecorder4 = fFmpegFrameRecorder;
                            avutil.av_free((Pointer)fFmpegFrameRecorder4.avio.buffer());
                            fFmpegFrameRecorder4.avio.buffer(null);
                        }
                        avutil.av_free(fFmpegFrameRecorder.avio);
                        fFmpegFrameRecorder.avio = null;
                    }
                    throw throwable;
                }
            }
            if (fFmpegFrameRecorder.avio != null) {
                if (fFmpegFrameRecorder.avio.buffer() != null) {
                    FFmpegFrameRecorder fFmpegFrameRecorder5 = fFmpegFrameRecorder;
                    avutil.av_free((Pointer)fFmpegFrameRecorder5.avio.buffer());
                    fFmpegFrameRecorder5.avio.buffer(null);
                }
                avutil.av_free(fFmpegFrameRecorder.avio);
                fFmpegFrameRecorder.avio = null;
                return;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void release() throws Exception {
        Class<avcodec> a;
        FFmpegFrameRecorder fFmpegFrameRecorder = a;
        a = avcodec.class;
        synchronized (avcodec.class) {
            fFmpegFrameRecorder.releaseUnsafe();
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }

    private /* synthetic */ void writeSamples(int n) throws Exception {
        int a = n;
        FFmpegFrameRecorder a2 = this;
        if (a2.samples_out == null || a2.samples_out.length == 0) {
            return;
        }
        a2.frame.nb_samples(a);
        FFmpegFrameRecorder fFmpegFrameRecorder = a2;
        avcodec.avcodec_fill_audio_frame(fFmpegFrameRecorder.frame, fFmpegFrameRecorder.audio_c.channels(), a2.audio_c.sample_fmt(), a2.samples_out[0], (int)a2.samples_out[0].position(), 0);
        a = 0;
        int n2 = a;
        while (n2 < a2.samples_out.length) {
            FFmpegFrameRecorder fFmpegFrameRecorder2;
            int n3 = 0;
            if (a2.samples_out[0].position() > 0L && a2.samples_out[0].position() < a2.samples_out[0].limit()) {
                FFmpegFrameRecorder fFmpegFrameRecorder3 = a2;
                fFmpegFrameRecorder2 = fFmpegFrameRecorder3;
                n3 = (int)fFmpegFrameRecorder3.samples_out[a].position() + 31 & -32;
            } else {
                FFmpegFrameRecorder fFmpegFrameRecorder4 = a2;
                fFmpegFrameRecorder2 = fFmpegFrameRecorder4;
                n3 = (int)Math.min(fFmpegFrameRecorder4.samples_out[a].limit(), Integer.MAX_VALUE);
            }
            int n4 = a;
            fFmpegFrameRecorder2.frame.data(n4, a2.samples_out[n4].position(0L));
            a2.frame.linesize(a++, n3);
            n2 = a;
        }
        FFmpegFrameRecorder fFmpegFrameRecorder5 = a2;
        fFmpegFrameRecorder5.frame.channels(fFmpegFrameRecorder5.audio_c.channels());
        FFmpegFrameRecorder fFmpegFrameRecorder6 = a2;
        fFmpegFrameRecorder6.frame.format(fFmpegFrameRecorder6.audio_c.sample_fmt());
        FFmpegFrameRecorder fFmpegFrameRecorder7 = a2;
        fFmpegFrameRecorder7.frame.quality(fFmpegFrameRecorder7.audio_c.global_quality());
        FFmpegFrameRecorder fFmpegFrameRecorder8 = a2;
        fFmpegFrameRecorder8.writeFrame(fFmpegFrameRecorder8.frame);
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder(String string, int n, int n2) {
        void a;
        void a2;
        int a3 = n2;
        FFmpegFrameRecorder a4 = this;
        a4((String)a2, (int)a, a3, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start() throws Exception {
        Class<avcodec> a;
        FFmpegFrameRecorder fFmpegFrameRecorder = a;
        a = avcodec.class;
        synchronized (avcodec.class) {
            fFmpegFrameRecorder.startUnsafe();
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }

    public static class Exception
    extends FrameRecorder.Exception {
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

    static class WriteCallback
    extends Write_packet_Pointer_BytePointer_int {
        /*
         * WARNING - void declaration
         */
        @Override
        public int call(Pointer pointer, BytePointer bytePointer, int n) {
            byte[] arrby = this;
            try {
                OutputStream a;
                void a2;
                void a3;
                byte[] a4 = new byte[a3];
                a = outputStreams.get(a);
                a2.get(a4, 0, (int)a3);
                a.write(a4, 0, (int)a3);
                return (int)a3;
            }
            catch (Throwable a4) {
                System.err.println("Error on OutputStream.write(): " + String.valueOf(a4));
                return -1;
            }
        }

        WriteCallback() {
            WriteCallback a;
        }
    }

    static class SeekCallback
    extends Seek_Pointer_long_int {
        /*
         * WARNING - void declaration
         */
        @Override
        public long call(Pointer pointer, long l, int n) {
            Object a22 = pointer;
            SeekCallback a = this;
            try {
                void a3;
                void a4;
                a22 = outputStreams.get(a22);
                ((Seekable)a22).seek((long)a3, (int)a4);
                return 0L;
            }
            catch (Throwable a22) {
                System.err.println("Error on OutputStream.seek(): " + String.valueOf(a22));
                return -1L;
            }
        }

        SeekCallback() {
            SeekCallback a;
        }
    }

}
