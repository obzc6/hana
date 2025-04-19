/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.DoublePointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.PointerScope
 */
package org.bytedeco.javacv;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bytedeco.ffmpeg.avcodec.AVCodec;
import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVCodecParameters;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avcodec.AVPacketSideData;
import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.ffmpeg.avformat.AVStream;
import org.bytedeco.ffmpeg.avformat.Read_packet_Pointer_BytePointer_int;
import org.bytedeco.ffmpeg.avformat.Seek_Pointer_long_int;
import org.bytedeco.ffmpeg.avutil.AVDictionary;
import org.bytedeco.ffmpeg.avutil.AVDictionaryEntry;
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
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.PointerScope;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;

public class FFmpegFrameGrabber
extends FrameGrabber {
    private Buffer[] samples_buf;
    private volatile boolean started;
    private static Exception loadingException = null;
    private BytePointer[] samples_ptr;
    private SwrContext samples_convert_ctx;
    private PointerPointer plane_ptr2;
    private InputStream inputStream;
    private AVStream audio_st;
    private boolean closeInputStream;
    private int samples_rate;
    private Buffer[] image_buf;
    private BytePointer[] samples_ptr_out;
    private Frame frame;
    private Buffer[] samples_buf_out;
    static Map<Pointer, InputStream> inputStreams;
    private BytePointer[] image_ptr;
    private AVIOContext avio;
    private AVFrame picture_rgb;
    private SwsContext img_convert_ctx;
    private boolean frameGrabbed;
    private String filename;
    private AVPacket pkt;
    private AVFrame samples_frame;
    private AVStream video_st;
    private int maximumSize;
    static ReadCallback readCallback;
    private int samples_channels;
    private int[] streams;
    static SeekCallback seekCallback;
    private PointerPointer plane_ptr;
    private AVCodecContext video_c;
    private int samples_format;
    private AVFormatContext oc;
    private AVFrame picture;
    private AVCodecContext audio_c;

    public void setVideoFrameNumber(int n) throws Exception {
        int a = n;
        FFmpegFrameGrabber a2 = this;
        if (a2.hasVideo()) {
            FFmpegFrameGrabber fFmpegFrameGrabber = a2;
            fFmpegFrameGrabber.setVideoTimestamp(Math.round((double)(1000000L * (long)a + 500000L) / fFmpegFrameGrabber.getFrameRate()));
            return;
        }
        a2.frameNumber = a;
    }

    public synchronized AVPacket grabPacket() throws Exception {
        FFmpegFrameGrabber a;
        if (a.oc == null || a.oc.isNull()) {
            throw new Exception(FadeUtils.ALLATORIxDEMO("%X\u0006NOZ-}72\u000fK\u0014FZ\u0011,\\cS!`\u000bG\u0005X\u0014r-}\u0003C\u001cAI\u0016O~\u0001BWU\u0016R\u0005RL\u001cGT0a\n\u0015\u0005V\u0002S\u0005UN\t"));
        }
        if (!a.started) {
            throw new Exception(BlockUpUtil.ALLATORIxDEMO("ZbjFJ)\u00042Yp]1GyJ!HuRmHv\u000ebi@Nw\\cAmEzA&"));
        }
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (avformat.av_read_frame(fFmpegFrameGrabber.oc, fFmpegFrameGrabber.pkt) < 0) {
            return null;
        }
        return a.pkt;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void processSamples() throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [18[DOLOOP]], but top level block is 8[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public void setAudioFrameNumber(int n) throws Exception {
        int a = n;
        FFmpegFrameGrabber a2 = this;
        if (a2.hasAudio()) {
            FFmpegFrameGrabber fFmpegFrameGrabber = a2;
            fFmpegFrameGrabber.setAudioTimestamp(Math.round((double)(1000000L * (long)a + 500000L) / fFmpegFrameGrabber.getAudioFrameRate()));
        }
    }

    @Override
    public Buffer getVideoSideData(String string) {
        String a = string;
        FFmpegFrameGrabber a2 = this;
        return a2.getVideoSideData().get(a);
    }

    public double getDisplayRotation() {
        ByteBuffer a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        a = (ByteBuffer)fFmpegFrameGrabber.getVideoSideData(FadeUtils.ALLATORIxDEMO(".R\u0002P\bT\b\u0000!\\\u001eI\u0002B"));
        if (a != null) {
            return avutil.av_display_rotation_get(new IntPointer((Pointer)new BytePointer(a)));
        }
        return 0.0;
    }

    public FFmpegFrameGrabber(String string) {
        FFmpegFrameGrabber a;
        String a2 = string;
        FFmpegFrameGrabber fFmpegFrameGrabber = a = this;
        FFmpegFrameGrabber fFmpegFrameGrabber2 = a;
        fFmpegFrameGrabber2.started = false;
        fFmpegFrameGrabber2.filename = a2;
        fFmpegFrameGrabber.pixelFormat = -1;
        fFmpegFrameGrabber.sampleFormat = -1;
    }

    @Override
    public int getPixelFormat() {
        FFmpegFrameGrabber a;
        if (a.imageMode == FrameGrabber.ImageMode.COLOR || a.imageMode == FrameGrabber.ImageMode.GRAY) {
            if (a.pixelFormat == -1) {
                if (a.imageMode == FrameGrabber.ImageMode.COLOR) {
                    return 3;
                }
                return 8;
            }
            return a.pixelFormat;
        }
        if (a.video_c != null) {
            return a.video_c.pix_fmt();
        }
        return super.getPixelFormat();
    }

    public FFmpegFrameGrabber(File file) {
        File a = file;
        FFmpegFrameGrabber a2 = this;
        a2(a.getAbsolutePath());
    }

    @Override
    public String getAudioCodecName() {
        FFmpegFrameGrabber a;
        if (a.audio_c == null) {
            return super.getAudioCodecName();
        }
        return a.audio_c.codec().name().getString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public synchronized void startUnsafe(boolean a) throws Exception {
        block47 : {
            block46 : {
                var2_9 = a;
                var8_10 = new PointerScope();
                if (var2_9.oc != null && !var2_9.oc.isNull()) {
                    throw new Exception(BlockUpUtil.ALLATORIxDEMO("\u0011)GkY:\u0013%Es\\0[i\u00108kQs\u0015C{Ym\tuJxfPZ;\rQ@rE6x@Qq\u0005;\u000esKwFd[!\\aTkD|Y!KsxTV5\u0016 LuK|G8"));
                }
                v0 = var2_9;
                var2_9.img_convert_ctx = null;
                v1 = var2_9;
                v1.oc = new AVFormatContext(null);
                v0.video_c = null;
                v0.audio_c = null;
                var2_9.plane_ptr = (PointerPointer)new PointerPointer(8L).retainReference();
                var2_9.plane_ptr2 = (PointerPointer)new PointerPointer(8L).retainReference();
                var2_9.pkt = (AVPacket)new AVPacket().retainReference();
                v2 = var2_9;
                v2.frameGrabbed = false;
                v2.frame = new Frame();
                var2_9.timestamp = 0L;
                var2_9.frameNumber = 0;
                var2_9.pkt.stream_index(-1);
                var4_11 = null;
                if (var2_9.format != null && var2_9.format.length() > 0 && (var4_11 = avformat.av_find_input_format(var2_9.format)) == null) {
                    throw new Exception("av_find_input_format() error: Could not find input format \"" + var2_9.format + "\".");
                }
                var3_13 = new AVDictionary(null);
                if (var2_9.frameRate > 0.0) {
                    var6_14 = avutil.av_d2q(var2_9.frameRate, 1001000);
                    avutil.av_dict_set(var3_13, FadeUtils.ALLATORIxDEMO("\\\u0004F\tP\u0011S\u0014T"), var6_14.num() + "/" + var6_14.den(), 0);
                }
                if (var2_9.pixelFormat < 0) break block46;
                v3 = var2_9;
                v4 = v3;
                avutil.av_dict_set(var3_13, BlockUpUtil.ALLATORIxDEMO("iOZxS_K}XxHb"), avutil.av_get_pix_fmt_name(v3.pixelFormat).getString(), 0);
                ** GOTO lbl50
            }
            if (var2_9.imageMode == FrameGrabber.ImageMode.RAW) ** GOTO lbl49
            if (var2_9.imageMode != FrameGrabber.ImageMode.COLOR) break block47;
            v5 = BlockUpUtil.ALLATORIxDEMO("pMg\u001b\"");
            ** GOTO lbl-1000
        }
        try {
            v5 = FadeUtils.ALLATORIxDEMO("R\u0011S\u0019\t");
lbl-1000: // 2 sources:
            {
                avutil.av_dict_set(var3_13, FadeUtils.ALLATORIxDEMO(" h\u0013_\u001ax\u0002Z\u0011_\u0001E"), v5, 0);
            }
lbl49: // 2 sources:
            v4 = var2_9;
lbl50: // 2 sources:
            if (v4.imageWidth > 0 && var2_9.imageHeight > 0) {
                v6 = var2_9;
                avutil.av_dict_set(var3_13, BlockUpUtil.ALLATORIxDEMO("Tt[eBMY|Ss"), v6.imageWidth + "x" + v6.imageHeight, 0);
            }
            if (var2_9.sampleRate > 0) {
                avutil.av_dict_set(var3_13, FadeUtils.ALLATORIxDEMO("r\nW\u0006K\u0001j\u0011S\u0014T"), "" + var2_9.sampleRate, 0);
            }
            if (var2_9.audioChannels > 0) {
                avutil.av_dict_set(var3_13, BlockUpUtil.ALLATORIxDEMO("\\hL|DpEe"), "" + var2_9.audioChannels, 0);
            }
            var6_14 = var2_9.options.entrySet().iterator();
            v7 /* !! */  = var6_14;
            while (v7 /* !! */ .hasNext()) {
                var7_16 = (Map.Entry)var6_14.next();
                avutil.av_dict_set(var3_13, (String)var7_16.getKey(), (String)var7_16.getValue(), 0);
                v7 /* !! */  = var6_14;
            }
            if (var2_9.inputStream != null) {
                if (!var2_9.inputStream.markSupported()) {
                    var2_9.inputStream = new BufferedInputStream(var2_9.inputStream);
                }
                var2_9.inputStream.mark(var2_9.maximumSize);
                var2_9.oc = avformat.avformat_alloc_context();
                var2_9.avio = avformat.avio_alloc_context(new BytePointer(avutil.av_malloc(4096L)), 4096, 0, (Pointer)var2_9.oc, FFmpegFrameGrabber.readCallback, null, (Seek_Pointer_long_int)(var2_9.maximumSize > 0 ? FFmpegFrameGrabber.seekCallback : null));
                v8 = var2_9;
                v8.oc.pb(v8.avio);
                var2_9.filename = var2_9.inputStream.toString();
                v9 = var2_9;
                FFmpegFrameGrabber.inputStreams.put(v9.oc, v9.inputStream);
            }
            v10 = var2_9;
            var5_19 = avformat.avformat_open_input(v10.oc, v10.filename, var4_11, var3_13);
            if (var5_19 < 0) {
                avutil.av_dict_set(var3_13, FadeUtils.ALLATORIxDEMO(" h\u0013_\u001ax\u0002Z\u0011_\u0001E"), null, 0);
                var5_19 = avformat.avformat_open_input(var2_9.oc, var2_9.filename, var4_11, var3_13);
                if (var5_19 < 0) {
                    throw new Exception("avformat_open_input() error " + var5_19 + ": Could not open input \"" + var2_9.filename + "\". (Has setFormat() been called?)");
                }
            }
            avutil.av_dict_free(var3_13);
            v11 = var2_9;
            v11.oc.max_delay(v11.maxDelay);
            if (a /* !! */  && (var5_19 = avformat.avformat_find_stream_info(var2_9.oc, (PointerPointer)null)) < 0) {
                throw new Exception("avformat_find_stream_info() error " + var5_19 + ": Could not find stream information.");
            }
            if (avutil.av_log_get_level() >= 32) {
                avformat.av_dump_format(var2_9.oc, 0, var2_9.filename, 0);
            }
            var6_15 = var2_9.oc.nb_streams();
            v12 = var7_17 = 0;
            while (v12 < var6_15) {
                v13 = var2_9;
                a = v13.oc.streams(var7_17);
                a = a.codecpar();
                if (v13.videoStream < 0 && a.codec_type() == 0 && a.disposition() == var2_9.videoDisposition) {
                    var2_9.videoStream = var7_17;
                } else if (var2_9.audioStream < 0 && a.codec_type() == 1 && a.disposition() == var2_9.audioDisposition) {
                    var2_9.audioStream = var7_17;
                }
                v12 = ++var7_17;
            }
            v14 = var2_9;
            v14.audio_st = null;
            v14.video_st = null;
            var7_18 = null;
            a = null;
            var2_9.streams = new int[var6_15];
            v15 = a = 0;
            while (v15 < var6_15) {
                v16 = var2_9;
                var9_21 = v16.oc.streams(a);
                var10_22 = var9_21.codecpar();
                v16.streams[a] = var10_22.codec_type();
                if (v16.video_st == null && var10_22.codec_type() == 0 && (var2_9.videoStream < 0 || var2_9.videoStream == a)) {
                    var2_9.video_st = var9_21;
                    var7_18 = var10_22;
                    var2_9.videoStream = a;
                } else if (var2_9.audio_st == null && var10_22.codec_type() == 1 && (var2_9.audioStream < 0 || var2_9.audioStream == a)) {
                    var2_9.audio_st = var9_21;
                    a = var10_22;
                    var2_9.audioStream = a;
                }
                v15 = ++a;
            }
            if (var2_9.video_st == null && var2_9.audio_st == null) {
                v17 = var2_9;
                throw new Exception("Did not find a video or audio stream inside \"" + v17.filename + "\" for videoStream == " + v17.videoStream + " and audioStream == " + var2_9.audioStream + ".");
            }
            if (var2_9.video_st != null) {
                a = avcodec.avcodec_find_decoder_by_name(var2_9.videoCodecName);
                if (a == null) {
                    a = avcodec.avcodec_find_decoder(var7_18.codec_id());
                }
                if (a == null) {
                    throw new Exception("avcodec_find_decoder() error: Unsupported video format or codec not found: " + var7_18.codec_id() + ".");
                }
                var2_9.video_c = avcodec.avcodec_alloc_context3(a);
                if (var2_9.video_c == null) {
                    throw new Exception(BlockUpUtil.ALLATORIxDEMO("\u0003+EvIwYZL~CYZ\u00012dAoMU-\u0014*\tsYfeG\u0004!n}TrM6e[J!L~B~Mp]s\u001ewVd]h\rv[bWcpHE=\\oCfOm]8"));
                }
                v18 = var2_9;
                var5_19 = avcodec.avcodec_parameters_to_context(v18.video_c, v18.video_st.codecpar());
                if (var5_19 < 0) {
                    var2_9.releaseUnsafe();
                    throw new Exception("avcodec_parameters_to_context() error " + var5_19 + ": Could not copy the video stream parameters.");
                }
                var3_13 = new AVDictionary(null);
                var9_21 = var2_9.videoOptions.entrySet().iterator();
                v19 /* !! */  = var9_21;
                while (v19 /* !! */ .hasNext()) {
                    var10_22 = (Map.Entry)var9_21.next();
                    avutil.av_dict_set(var3_13, (String)var10_22.getKey(), (String)var10_22.getValue(), 0);
                    v19 /* !! */  = var9_21;
                }
                v20 = var2_9;
                v20.video_c.thread_count(0);
                var5_19 = avcodec.avcodec_open2(v20.video_c, a, var3_13);
                if (var5_19 < 0) {
                    throw new Exception("avcodec_open2() error " + var5_19 + ": Could not open video codec.");
                }
                avutil.av_dict_free(var3_13);
                if (var2_9.video_c.time_base().num() > 1000 && var2_9.video_c.time_base().den() == 1) {
                    var2_9.video_c.time_base().den(1000);
                }
                if ((var2_9.picture = avutil.av_frame_alloc()) == null) {
                    throw new Exception(FadeUtils.ALLATORIxDEMO("C]%%`\"\rf\u0014H\f^\u0001\u001bj2\u0012T\u0016Z\u001a\u0003@r-f\u001bBD[\bBGW\f]\u0018E\u0017S\u0014\u0000\u0016T\u0000\u0006\u0001I3u\u001eH\u0013\u0007\u0002G\u0002_\u0005\u001f"));
                }
                var2_9.picture_rgb = avutil.av_frame_alloc();
                if (var2_9.picture_rgb == null) {
                    throw new Exception(BlockUpUtil.ALLATORIxDEMO("d\u0014\u0002lGkXDA]oEyH<#\u0015[s_}S$\tUdARe\r|Ae\u000epEzQb^t]'U|!HnzRWoZ K`KxL8"));
                }
                var2_9.initPictureRGB();
            }
            if (var2_9.audio_st != null) {
                a = avcodec.avcodec_find_decoder_by_name(var2_9.audioCodecName);
                if (a == null) {
                    a = avcodec.avcodec_find_decoder(a.codec_id());
                }
                if (a == null) {
                    throw new Exception("avcodec_find_decoder() error: Unsupported audio format or codec not found: " + a.codec_id() + ".");
                }
                var2_9.audio_c = avcodec.avcodec_alloc_context3(a);
                if (var2_9.audio_c == null) {
                    throw new Exception(FadeUtils.ALLATORIxDEMO("J\f\fQ\u0000P\u0010}\u0005Y\nX\u0010}H\u0015-f&j\u001c\n]\r@T\u0010A,`M\u0006'Z\u001dU\u0004\u0011,|\u0003\u0006\u0005Y\u000bY\u0004W\u0014TWG\u0003C\u0018ODQ\u0012E\u001eD9o\f\u001a\u0015H\nA\u0006J\u0014\u001f"));
                }
                v21 = var2_9;
                var5_19 = avcodec.avcodec_parameters_to_context(v21.audio_c, v21.audio_st.codecpar());
                if (var5_19 < 0) {
                    var2_9.releaseUnsafe();
                    throw new Exception("avcodec_parameters_to_context() error " + var5_19 + ": Could not copy the audio stream parameters.");
                }
                var3_13 = new AVDictionary(null);
                var9_21 = var2_9.audioOptions.entrySet().iterator();
                v22 /* !! */  = var9_21;
                while (v22 /* !! */ .hasNext()) {
                    var10_22 = (Map.Entry)var9_21.next();
                    avutil.av_dict_set(var3_13, (String)var10_22.getKey(), (String)var10_22.getValue(), 0);
                    v22 /* !! */  = var9_21;
                }
                v23 = var2_9;
                v23.audio_c.thread_count(0);
                var5_19 = avcodec.avcodec_open2(v23.audio_c, a, var3_13);
                if (var5_19 < 0) {
                    throw new Exception("avcodec_open2() error " + var5_19 + ": Could not open audio codec.");
                }
                avutil.av_dict_free(var3_13);
                var2_9.samples_frame = avutil.av_frame_alloc();
                if (var2_9.samples_frame == null) {
                    throw new Exception(BlockUpUtil.ALLATORIxDEMO("TWAZqH{NKkYRnN:\b>Ldy[L;\rQAdBu\txQu\u001faTkBq_u]'xSFtP K`KxL8"));
                }
                v24 = new BytePointer[1];
                v24[0] = null;
                var2_9.samples_ptr = v24;
                v25 = new Buffer[1];
                v25[0] = null;
                var2_9.samples_buf = v25;
            }
            var2_9.started = true;
        }
        catch (Throwable var5_20) {
            try {
                var8_10.close();
                v26 = var5_20;
            }
            catch (Throwable var4_12) {
                v27 = var5_20;
                v26 = v27;
                v27.addSuppressed(var4_12);
            }
            throw v26;
        }
        var8_10.close();
    }

    @Override
    public Buffer getAudioSideData(String string) {
        String a = string;
        FFmpegFrameGrabber a2 = this;
        return a2.getAudioSideData().get(a);
    }

    @Override
    public int getImageHeight() {
        FFmpegFrameGrabber a;
        if (a.imageHeight > 0 || a.video_c == null) {
            return super.getImageHeight();
        }
        return a.video_c.height();
    }

    @Override
    public String getVideoMetadata(String string) {
        Object a = string;
        FFmpegFrameGrabber a2 = this;
        if (a2.video_st == null) {
            return super.getVideoMetadata((String)a);
        }
        a = avutil.av_dict_get(a2.video_st.metadata(), (String)a, null, 0);
        if (a == null || ((AVDictionaryEntry)((Object)a)).value() == null) {
            return null;
        }
        return ((AVDictionaryEntry)((Object)a)).value().getString(a2.charset);
    }

    @Override
    public double getAspectRatio() {
        Object a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.video_st == null) {
            return super.getAspectRatio();
        }
        FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
        a = avformat.av_guess_sample_aspect_ratio(fFmpegFrameGrabber2.oc, fFmpegFrameGrabber2.video_st, fFmpegFrameGrabber.picture);
        double d = (double)((AVRational)((Object)a)).num() / (double)((AVRational)((Object)a)).den();
        if (d == 0.0) {
            return 1.0;
        }
        return d;
    }

    public double getVideoFrameRate() {
        Object a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.video_st == null) {
            return super.getFrameRate();
        }
        a = fFmpegFrameGrabber.video_st.avg_frame_rate();
        if (((AVRational)((Object)a)).num() == 0 && ((AVRational)((Object)a)).den() == 0) {
            a = fFmpegFrameGrabber.video_st.r_frame_rate();
        }
        return (double)((AVRational)((Object)a)).num() / (double)((AVRational)((Object)a)).den();
    }

    @Override
    public double getGamma() {
        FFmpegFrameGrabber a;
        if (a.gamma == 0.0) {
            return 2.2;
        }
        return a.gamma;
    }

    public static FFmpegFrameGrabber createDefault(File a) throws Exception {
        return new FFmpegFrameGrabber(a);
    }

    @Override
    public void stop() throws Exception {
        FFmpegFrameGrabber a;
        a.release();
    }

    public static FFmpegFrameGrabber createDefault(String a) throws Exception {
        return new FFmpegFrameGrabber(a);
    }

    @Override
    public int getImageWidth() {
        FFmpegFrameGrabber a;
        if (a.imageWidth > 0 || a.video_c == null) {
            return super.getImageWidth();
        }
        return a.video_c.width();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void release() throws Exception {
        Class<avcodec> a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        a = avcodec.class;
        synchronized (avcodec.class) {
            fFmpegFrameGrabber.releaseUnsafe();
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }

    public FFmpegFrameGrabber(URL uRL) {
        URL a = uRL;
        FFmpegFrameGrabber a2 = this;
        a2(a.toString());
    }

    @Override
    public String getMetadata(String string) {
        Object a = string;
        FFmpegFrameGrabber a2 = this;
        if (a2.oc == null) {
            return super.getMetadata((String)a);
        }
        a = avutil.av_dict_get(a2.oc.metadata(), (String)a, null, 0);
        if (a == null || ((AVDictionaryEntry)((Object)a)).value() == null) {
            return null;
        }
        return ((AVDictionaryEntry)((Object)a)).value().getString(a2.charset);
    }

    public int getLengthInAudioFrames() {
        double d;
        FFmpegFrameGrabber a;
        double d2 = a.getAudioFrameRate();
        if (d > 0.0) {
            return (int)((double)a.getLengthInTime() * d2 / 1000000.0);
        }
        return 0;
    }

    @Override
    public Map<String, String> getAudioMetadata() {
        Object a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.audio_st == null) {
            return super.getAudioMetadata();
        }
        a = null;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
        while ((a = avutil.av_dict_get(fFmpegFrameGrabber2.audio_st.metadata(), "", (AVDictionaryEntry)((Object)a), 2)) != null) {
            FFmpegFrameGrabber fFmpegFrameGrabber3 = fFmpegFrameGrabber;
            fFmpegFrameGrabber2 = fFmpegFrameGrabber3;
            hashMap.put(((AVDictionaryEntry)((Object)a)).key().getString(fFmpegFrameGrabber3.charset), ((AVDictionaryEntry)((Object)a)).value().getString(fFmpegFrameGrabber.charset));
        }
        return hashMap;
    }

    private /* synthetic */ void processImage() throws Exception {
        FFmpegFrameGrabber fFmpegFrameGrabber;
        FFmpegFrameGrabber a;
        FFmpegFrameGrabber fFmpegFrameGrabber2 = a;
        fFmpegFrameGrabber2.frame.imageWidth = fFmpegFrameGrabber2.imageWidth > 0 ? fFmpegFrameGrabber2.imageWidth : fFmpegFrameGrabber2.video_c.width();
        fFmpegFrameGrabber2.frame.imageHeight = fFmpegFrameGrabber2.imageHeight > 0 ? fFmpegFrameGrabber2.imageHeight : fFmpegFrameGrabber2.video_c.height();
        fFmpegFrameGrabber2.frame.imageDepth = 8;
        switch (1.$SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode[fFmpegFrameGrabber2.imageMode.ordinal()]) {
            case 1: 
            case 2: {
                while (false) {
                }
                if (fFmpegFrameGrabber2.deinterlace) {
                    throw new Exception(BlockUpUtil.ALLATORIxDEMO("\u001ek[dZU>Xf@x_qxY_bH(\u0001X\\xh@WnCsBxZh\t{QwYg\u001euL<iVDfZgyrdWDXD~_q[8"));
                }
                if (fFmpegFrameGrabber2.frame.imageWidth != fFmpegFrameGrabber2.picture_rgb.width() || fFmpegFrameGrabber2.frame.imageHeight != fFmpegFrameGrabber2.picture_rgb.height()) {
                    fFmpegFrameGrabber2.initPictureRGB();
                }
                FFmpegFrameGrabber fFmpegFrameGrabber3 = fFmpegFrameGrabber2;
                avutil.av_frame_copy_props(fFmpegFrameGrabber2.picture_rgb, fFmpegFrameGrabber3.picture);
                fFmpegFrameGrabber2.img_convert_ctx = swscale.sws_getCachedContext(fFmpegFrameGrabber3.img_convert_ctx, fFmpegFrameGrabber2.video_c.width(), fFmpegFrameGrabber2.video_c.height(), fFmpegFrameGrabber2.video_c.pix_fmt(), fFmpegFrameGrabber2.frame.imageWidth, fFmpegFrameGrabber2.frame.imageHeight, fFmpegFrameGrabber2.getPixelFormat(), fFmpegFrameGrabber2.imageScalingFlags != 0 ? fFmpegFrameGrabber2.imageScalingFlags : 2, null, null, (DoublePointer)null);
                if (fFmpegFrameGrabber2.img_convert_ctx == null) {
                    throw new Exception(FadeUtils.ALLATORIxDEMO("F\u0004Q;R\u0003C0CH\u0012&v\u0000}\u0006M\u0010\\\u0014\u0019K\u0013&`\u0005I\u0016\u000fHz\u0001_,|\u0003\u0006\r[\u000eB\u000eW\fX\rCUP\u001fCJX\tY\u0016T\u0004T\u001fH\"=\u000bV\nA\u0007K\u0014\u001f"));
                }
                FFmpegFrameGrabber fFmpegFrameGrabber4 = fFmpegFrameGrabber2;
                fFmpegFrameGrabber = fFmpegFrameGrabber4;
                swscale.sws_scale(fFmpegFrameGrabber4.img_convert_ctx, new PointerPointer((Pointer)fFmpegFrameGrabber2.picture), fFmpegFrameGrabber2.picture.linesize(), 0, fFmpegFrameGrabber2.video_c.height(), new PointerPointer((Pointer)fFmpegFrameGrabber2.picture_rgb), fFmpegFrameGrabber2.picture_rgb.linesize());
                FFmpegFrameGrabber fFmpegFrameGrabber5 = fFmpegFrameGrabber2;
                fFmpegFrameGrabber5.frame.imageStride = fFmpegFrameGrabber2.picture_rgb.linesize(0);
                fFmpegFrameGrabber5.frame.image = fFmpegFrameGrabber2.image_buf;
                fFmpegFrameGrabber2.frame.opaque = fFmpegFrameGrabber2.picture_rgb;
                break;
            }
            case 3: {
                FFmpegFrameGrabber fFmpegFrameGrabber6 = fFmpegFrameGrabber2;
                fFmpegFrameGrabber6.frame.imageStride = fFmpegFrameGrabber6.picture.linesize(0);
                a = fFmpegFrameGrabber6.picture.data(0);
                if (a != null && !a.equals((Object)fFmpegFrameGrabber2.image_ptr[0])) {
                    FFmpegFrameGrabber fFmpegFrameGrabber7 = fFmpegFrameGrabber2;
                    fFmpegFrameGrabber7.image_ptr[0] = a.capacity((long)(fFmpegFrameGrabber2.frame.imageHeight * fFmpegFrameGrabber2.frame.imageStride));
                    fFmpegFrameGrabber7.image_buf[0] = a.asBuffer();
                }
                fFmpegFrameGrabber = fFmpegFrameGrabber2;
                fFmpegFrameGrabber2.frame.image = fFmpegFrameGrabber2.image_buf;
                fFmpegFrameGrabber2.frame.opaque = fFmpegFrameGrabber2.picture;
                break;
            }
            default: {
                assert (false);
                fFmpegFrameGrabber = fFmpegFrameGrabber2;
            }
        }
        fFmpegFrameGrabber.frame.image[0].limit(fFmpegFrameGrabber2.frame.imageHeight * fFmpegFrameGrabber2.frame.imageStride);
        fFmpegFrameGrabber2.frame.imageChannels = fFmpegFrameGrabber2.frame.imageStride / fFmpegFrameGrabber2.frame.imageWidth;
    }

    @Override
    public long getLengthInTime() {
        FFmpegFrameGrabber a;
        return a.oc.duration() * 1000000L / 1000000L;
    }

    /*
     * WARNING - void declaration
     */
    public Frame grabFrame(boolean bl, boolean bl2, boolean bl3, boolean bl4) throws Exception {
        void a;
        void a2;
        void a3;
        void a4;
        boolean bl5 = bl4;
        FFmpegFrameGrabber a5 = this;
        return a5.grabFrame((boolean)a4, (boolean)a3, (boolean)a2, (boolean)a, true);
    }

    protected void finalize() throws Throwable {
        FFmpegFrameGrabber a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        Object.super.finalize();
        fFmpegFrameGrabber.release();
    }

    public Frame grabSamples() throws Exception {
        FFmpegFrameGrabber a;
        return a.grabFrame(true, false, true, false, false);
    }

    public static String[] getDeviceDescriptions() throws Exception {
        FFmpegFrameGrabber.tryLoad();
        throw new UnsupportedOperationException(FadeUtils.ALLATORIxDEMO("w\u0005G\u0018C$0\u0005_\u0006O\tO\u0007C\t^/0\u000e^\u0002\u0007\u0015B\u0007V\u0003O\u0001\u0004\u0013YL{,V\u001b_\u0011\t"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start(boolean a) throws Exception {
        Class<avcodec> a2;
        FFmpegFrameGrabber fFmpegFrameGrabber = a2;
        a2 = avcodec.class;
        synchronized (avcodec.class) {
            fFmpegFrameGrabber.startUnsafe(a);
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }

    @Override
    public int getVideoCodec() {
        FFmpegFrameGrabber a;
        if (a.video_c == null) {
            return super.getVideoCodec();
        }
        return a.video_c.codec_id();
    }

    @Override
    public Map<String, String> getVideoMetadata() {
        Object a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.video_st == null) {
            return super.getVideoMetadata();
        }
        a = null;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
        while ((a = avutil.av_dict_get(fFmpegFrameGrabber2.video_st.metadata(), "", (AVDictionaryEntry)((Object)a), 2)) != null) {
            FFmpegFrameGrabber fFmpegFrameGrabber3 = fFmpegFrameGrabber;
            fFmpegFrameGrabber2 = fFmpegFrameGrabber3;
            hashMap.put(((AVDictionaryEntry)((Object)a)).key().getString(fFmpegFrameGrabber3.charset), ((AVDictionaryEntry)((Object)a)).value().getString(fFmpegFrameGrabber.charset));
        }
        return hashMap;
    }

    @Override
    public int getAudioBitrate() {
        FFmpegFrameGrabber a;
        if (a.audio_c == null) {
            return super.getAudioBitrate();
        }
        return (int)a.audio_c.bit_rate();
    }

    public FFmpegFrameGrabber(InputStream inputStream) {
        Closeable a = inputStream;
        FFmpegFrameGrabber a2 = this;
        a2((InputStream)a, 2147483639);
    }

    /*
     * WARNING - void declaration
     */
    public void setTimestamp(long l, boolean bl) throws Exception {
        void a;
        boolean a2 = bl;
        FFmpegFrameGrabber a3 = this;
        a3.setTimestamp((long)a, a2 ? EnumSet.of(Frame.Type.VIDEO, Frame.Type.AUDIO) : null);
    }

    /*
     * Exception decompiling
     */
    public synchronized Frame grabFrame(boolean var1_2, boolean var2_3, boolean var3_4, boolean var4_5, boolean var5_6) throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[TRYBLOCK]], but top level block is 21[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public int getLengthInVideoFrames() {
        FFmpegFrameGrabber a;
        return (int)Math.round((double)a.getLengthInTime() * a.getFrameRate() / 1000000.0);
    }

    @Override
    public int getVideoBitrate() {
        FFmpegFrameGrabber a;
        if (a.video_c == null) {
            return super.getVideoBitrate();
        }
        return (int)a.video_c.bit_rate();
    }

    @Override
    public int getAudioCodec() {
        FFmpegFrameGrabber a;
        if (a.audio_c == null) {
            return super.getAudioCodec();
        }
        return a.audio_c.codec_id();
    }

    @Override
    public int getSampleRate() {
        FFmpegFrameGrabber a;
        if (a.sampleRate > 0 || a.audio_c == null) {
            return super.getSampleRate();
        }
        return a.audio_c.sample_rate();
    }

    public void setCloseInputStream(boolean bl) {
        boolean a = bl;
        FFmpegFrameGrabber a2 = this;
        a2.closeInputStream = a;
    }

    @Override
    public String getAudioMetadata(String string) {
        Object a = string;
        FFmpegFrameGrabber a2 = this;
        if (a2.audio_st == null) {
            return super.getAudioMetadata((String)a);
        }
        a = avutil.av_dict_get(a2.audio_st.metadata(), (String)a, null, 0);
        if (a == null || ((AVDictionaryEntry)((Object)a)).value() == null) {
            return null;
        }
        return ((AVDictionaryEntry)((Object)a)).value().getString(a2.charset);
    }

    public double getAudioFrameRate() {
        FFmpegFrameGrabber fFmpegFrameGrabber;
        FFmpegFrameGrabber a;
        if (a.audio_st == null) {
            return 0.0;
        }
        if (a.samples_frame == null || a.samples_frame.nb_samples() == 0) {
            try {
                a.grabFrame(true, false, false, false, false);
                a.frameGrabbed = true;
                fFmpegFrameGrabber = a;
            }
            catch (Exception exception) {
                return 0.0;
            }
        } else {
            fFmpegFrameGrabber = a;
        }
        if (fFmpegFrameGrabber.samples_frame != null && a.samples_frame.nb_samples() != 0) {
            return (double)a.getSampleRate() / (double)a.samples_frame.nb_samples();
        }
        return 0.0;
    }

    public boolean hasVideo() {
        FFmpegFrameGrabber a;
        return a.video_st != null;
    }

    @Override
    public Frame grab() throws Exception {
        FFmpegFrameGrabber a;
        return a.grabFrame(true, true, true, false, true);
    }

    public Frame grabImage() throws Exception {
        FFmpegFrameGrabber a;
        return a.grabFrame(false, true, true, false, true);
    }

    public boolean hasAudio() {
        FFmpegFrameGrabber a;
        return a.audio_st != null;
    }

    public AVFormatContext getFormatContext() {
        FFmpegFrameGrabber a;
        return a.oc;
    }

    @Override
    public String getVideoCodecName() {
        FFmpegFrameGrabber a;
        if (a.video_c == null) {
            return super.getVideoCodecName();
        }
        return a.video_c.codec().name().getString();
    }

    public void setVideoTimestamp(long a) throws Exception {
        FFmpegFrameGrabber a2;
        a2.setTimestamp(a, EnumSet.of(Frame.Type.VIDEO));
    }

    @Override
    public Map<String, Buffer> getAudioSideData() {
        Object a;
        int n;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.audio_st == null) {
            return super.getAudioSideData();
        }
        fFmpegFrameGrabber.audioSideData = new HashMap();
        int n2 = n = 0;
        while (n2 < fFmpegFrameGrabber.audio_st.nb_side_data()) {
            FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
            a = fFmpegFrameGrabber2.audio_st.side_data().position(n);
            String string = avcodec.av_packet_side_data_name(((AVPacketSideData)((Object)a)).type()).getString();
            a = ((AVPacketSideData)((Object)a)).data().capacity(((AVPacketSideData)((Object)a)).size()).asBuffer();
            fFmpegFrameGrabber2.audioSideData.put(string, a);
            n2 = ++n;
        }
        return fFmpegFrameGrabber.audioSideData;
    }

    static {
        try {
            FFmpegFrameGrabber.tryLoad();
        }
        catch (Exception exception) {
            // empty catch block
        }
        inputStreams = Collections.synchronizedMap(new HashMap());
        readCallback = (ReadCallback)new ReadCallback().retainReference();
        seekCallback = (SeekCallback)new SeekCallback().retainReference();
    }

    public Frame grabKeyFrame() throws Exception {
        FFmpegFrameGrabber a;
        return a.grabFrame(false, true, true, true, false);
    }

    @Override
    public String getFormat() {
        FFmpegFrameGrabber a;
        if (a.oc == null) {
            return super.getFormat();
        }
        return a.oc.iformat().name().getString();
    }

    public void setAudioTimestamp(long a) throws Exception {
        FFmpegFrameGrabber a2;
        a2.setTimestamp(a, EnumSet.of(Frame.Type.AUDIO));
    }

    public static FFmpegFrameGrabber createDefault(int a) throws Exception {
        throw new Exception(String.valueOf(FFmpegFrameGrabber.class) + " does not support device numbers.");
    }

    @Override
    public void setTimestamp(long a) throws Exception {
        FFmpegFrameGrabber a2;
        a2.setTimestamp(a, false);
    }

    public void startUnsafe() throws Exception {
        FFmpegFrameGrabber a;
        a.startUnsafe(true);
    }

    public boolean isCloseInputStream() {
        FFmpegFrameGrabber a;
        return a.closeInputStream;
    }

    @Override
    public synchronized void trigger() throws Exception {
        FFmpegFrameGrabber a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.oc == null || fFmpegFrameGrabber.oc.isNull()) {
            throw new Exception(FadeUtils.ALLATORIxDEMO("9\u0000K\bQSL\u000bAFC\u0001KL\u001d&`y2&VUe6w\rA.s\u0003e\u000b[\u001c\\\u0018El3_n\u0005FGE\u0013W\u0012E_\u000fQB\u0012C\u0002\u001d\u0001R\u000e_\u0005UH\u000f"));
        }
        if (fFmpegFrameGrabber.pkt.stream_index() != -1) {
            FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
            avcodec.av_packet_unref(fFmpegFrameGrabber2.pkt);
            fFmpegFrameGrabber2.pkt.stream_index(-1);
        }
        int n = a = 0;
        while (n < fFmpegFrameGrabber.numBuffers + 1) {
            FFmpegFrameGrabber fFmpegFrameGrabber3 = fFmpegFrameGrabber;
            if (avformat.av_read_frame(fFmpegFrameGrabber3.oc, fFmpegFrameGrabber3.pkt) < 0) {
                return;
            }
            avcodec.av_packet_unref(fFmpegFrameGrabber.pkt);
            n = ++a;
        }
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameGrabber(InputStream inputStream, int n) {
        FFmpegFrameGrabber a;
        void a2;
        int a3 = n;
        FFmpegFrameGrabber fFmpegFrameGrabber = a = this;
        FFmpegFrameGrabber fFmpegFrameGrabber2 = a;
        FFmpegFrameGrabber fFmpegFrameGrabber3 = a;
        fFmpegFrameGrabber3.started = false;
        fFmpegFrameGrabber3.inputStream = a2;
        fFmpegFrameGrabber2.closeInputStream = true;
        fFmpegFrameGrabber2.pixelFormat = -1;
        fFmpegFrameGrabber.sampleFormat = -1;
        fFmpegFrameGrabber.maximumSize = a3;
    }

    @Override
    public Map<String, Buffer> getVideoSideData() {
        Object a;
        int n;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.video_st == null) {
            return super.getVideoSideData();
        }
        fFmpegFrameGrabber.videoSideData = new HashMap();
        int n2 = n = 0;
        while (n2 < fFmpegFrameGrabber.video_st.nb_side_data()) {
            FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
            a = fFmpegFrameGrabber2.video_st.side_data().position(n);
            String string = avcodec.av_packet_side_data_name(((AVPacketSideData)((Object)a)).type()).getString();
            a = ((AVPacketSideData)((Object)a)).data().capacity(((AVPacketSideData)((Object)a)).size()).asBuffer();
            fFmpegFrameGrabber2.videoSideData.put(string, a);
            n2 = ++n;
        }
        return fFmpegFrameGrabber.videoSideData;
    }

    @Override
    public int getAudioChannels() {
        FFmpegFrameGrabber a;
        if (a.audioChannels > 0 || a.audio_c == null) {
            return super.getAudioChannels();
        }
        return a.audio_c.channels();
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
            loadingException = new Exception("Failed to load " + String.valueOf(FFmpegFrameGrabber.class), throwable);
            throw loadingException;
        }
    }

    @Override
    public void setFrameNumber(int n) throws Exception {
        int a = n;
        FFmpegFrameGrabber a2 = this;
        if (a2.hasVideo()) {
            FFmpegFrameGrabber fFmpegFrameGrabber = a2;
            fFmpegFrameGrabber.setTimestamp(Math.round((double)(1000000L * (long)a + 500000L) / fFmpegFrameGrabber.getFrameRate()));
            return;
        }
        a2.frameNumber = a;
    }

    @Override
    public void start() throws Exception {
        FFmpegFrameGrabber a;
        a.start(true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ void initPictureRGB() {
        var3_2 = a;
        var6_3 = var3_2.imageWidth > 0 ? var3_2.imageWidth : var3_2.video_c.width();
        var5_4 = var3_2.imageHeight > 0 ? var3_2.imageHeight : var3_2.video_c.height();
        switch (1.$SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode[var3_2.imageMode.ordinal()]) {
            case 1: 
            case 2: {
                while (false) {
                }
                if (var3_2.image_ptr != null) {
                    var3_2.image_buf = null;
                    a = var3_2.image_ptr;
                    var3_2.image_ptr = null;
                    avutil.av_free((Pointer)a[0]);
                }
                a = var3_2.getPixelFormat();
                var4_5 = 64;
                var2_6 = var6_3;
                v0 = var1_7 = 1;
                while (v0 <= var4_5) {
                    var2_6 = var6_3 + (var1_7 - 1) & ~(var1_7 - 1);
                    v1 = var3_2;
                    avutil.av_image_fill_linesizes(v1.picture_rgb.linesize(), a, var2_6);
                    if ((v1.picture_rgb.linesize(0) & var4_5 - 1) != 0) ** GOTO lbl25
                    v2 = a;
                    ** GOTO lbl29
lbl25: // 1 sources:
                    v3 = var1_7;
                    v0 = v3 + v3;
                }
                v2 = a;
lbl29: // 2 sources:
                var1_7 = avutil.av_image_get_buffer_size(v2, var2_6, var5_4, 1);
                v4 = new BytePointer[1];
                v4[0] = new BytePointer(avutil.av_malloc(var1_7)).capacity((long)var1_7);
                var3_2.image_ptr = v4;
                v5 = new Buffer[1];
                v5[0] = var3_2.image_ptr[0].asBuffer();
                var3_2.image_buf = v5;
                avutil.av_image_fill_arrays(new PointerPointer((Pointer)var3_2.picture_rgb), var3_2.picture_rgb.linesize(), var3_2.image_ptr[0], a, var2_6, var5_4, 1);
                var3_2.picture_rgb.format(a);
                var3_2.picture_rgb.width(var6_3);
                var3_2.picture_rgb.height(var5_4);
                return;
            }
            case 3: {
                v6 = new BytePointer[1];
                v6[0] = null;
                var3_2.image_ptr = v6;
                v7 = new Buffer[1];
                v7[0] = null;
                var3_2.image_buf = v7;
                return;
            }
        }
        if (FFmpegFrameGrabber.$assertionsDisabled != false) return;
        throw new AssertionError();
    }

    @Override
    public Map<String, String> getMetadata() {
        Object a;
        FFmpegFrameGrabber fFmpegFrameGrabber = a;
        if (fFmpegFrameGrabber.oc == null) {
            return super.getMetadata();
        }
        a = null;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
        while ((a = avutil.av_dict_get(fFmpegFrameGrabber2.oc.metadata(), "", (AVDictionaryEntry)((Object)a), 2)) != null) {
            FFmpegFrameGrabber fFmpegFrameGrabber3 = fFmpegFrameGrabber;
            fFmpegFrameGrabber2 = fFmpegFrameGrabber3;
            hashMap.put(((AVDictionaryEntry)((Object)a)).key().getString(fFmpegFrameGrabber3.charset), ((AVDictionaryEntry)((Object)a)).value().getString(fFmpegFrameGrabber.charset));
        }
        return hashMap;
    }

    @Override
    public int getSampleFormat() {
        FFmpegFrameGrabber a;
        if (a.sampleMode == FrameGrabber.SampleMode.SHORT || a.sampleMode == FrameGrabber.SampleMode.FLOAT) {
            if (a.sampleFormat == -1) {
                if (a.sampleMode == FrameGrabber.SampleMode.SHORT) {
                    return 1;
                }
                return 3;
            }
            return a.sampleFormat;
        }
        if (a.audio_c != null) {
            return a.audio_c.sample_fmt();
        }
        return super.getSampleFormat();
    }

    /*
     * WARNING - void declaration
     */
    private synchronized /* synthetic */ void setTimestamp(long l, EnumSet<Frame.Type> enumSet) throws Exception {
        block29 : {
            void a;
            long l2;
            FFmpegFrameGrabber a2;
            block30 : {
                double d;
                void v1;
                EnumSet<Frame.Type> a3;
                block33 : {
                    block31 : {
                        block32 : {
                            a3 = enumSet;
                            a2 = this;
                            if (a2.oc == null) {
                                a2.timestamp = a;
                                return;
                            }
                            a = a * 1000000L / 1000000L;
                            long l3 = l2 = a2.oc.start_time() != avutil.AV_NOPTS_VALUE ? a2.oc.start_time() : 0L;
                            if (a3 == null || !a3.contains((Object)Frame.Type.VIDEO) && !a3.contains((Object)Frame.Type.AUDIO) || !a2.hasVideo() && !a2.hasAudio()) break block30;
                            if (a3.contains((Object)Frame.Type.VIDEO) && !a2.hasVideo() || a3.contains((Object)Frame.Type.AUDIO) && !a2.hasAudio()) {
                                a3 = EnumSet.of(Frame.Type.VIDEO, Frame.Type.AUDIO);
                            }
                            if (a3.size() != 1) break block31;
                            if (!a3.contains((Object)Frame.Type.VIDEO)) break block32;
                            if (a2.video_st == null || a2.video_st.start_time() == avutil.AV_NOPTS_VALUE) break block31;
                            AVRational aVRational = a2.video_st.time_base();
                            l2 = 1000000L * a2.video_st.start_time() * (long)aVRational.num() / (long)aVRational.den();
                            v1 = a;
                            break block33;
                        }
                        if (a3.contains((Object)Frame.Type.AUDIO) && a2.audio_st != null && a2.audio_st.start_time() != avutil.AV_NOPTS_VALUE) {
                            AVRational aVRational = a2.audio_st.time_base();
                            l2 = 1000000L * a2.audio_st.start_time() * (long)aVRational.num() / (long)aVRational.den();
                        }
                    }
                    v1 = a;
                }
                long l4 = v1;
                a += l2;
                l4 += l2;
                long l5 = Long.MIN_VALUE;
                long l6 = 0L;
                long l7 = 0L;
                Frame frame = null;
                do {
                    void v2 = l4;
                    int n = avformat.avformat_seek_file(a2.oc, -1, 0L, (long)v2, (long)v2, 1);
                    if (n < 0) {
                        throw new Exception("avformat_seek_file() error " + n + ": Could not seek file to timestamp " + (long)a + ".");
                    }
                    if (a2.video_c != null) {
                        avcodec.avcodec_flush_buffers(a2.video_c);
                    }
                    if (a2.audio_c != null) {
                        avcodec.avcodec_flush_buffers(a2.audio_c);
                    }
                    if (a2.pkt.stream_index() != -1) {
                        FFmpegFrameGrabber fFmpegFrameGrabber = a2;
                        avcodec.av_packet_unref(fFmpegFrameGrabber.pkt);
                        fFmpegFrameGrabber.pkt.stream_index(-1);
                    }
                    if ((frame = a2.grabFrame(a3.contains((Object)Frame.Type.AUDIO), a3.contains((Object)Frame.Type.VIDEO), false, false, false)) == null) {
                        return;
                    }
                    l5 = frame.timestamp;
                    if (l4 == 0L) break;
                    if ((l4 -= 500000L) >= 0L) continue;
                    l4 = 0L;
                } while (l5 > a);
                double d2 = 0.0;
                if (frame.image != null && a2.getFrameRate() > 0.0) {
                    d = d2 = 1000000.0 / a2.getFrameRate();
                } else {
                    if (frame.samples != null && a2.samples_frame != null && a2.getSampleRate() > 0) {
                        d2 = (double)(1000000 * a2.samples_frame.nb_samples()) / (double)a2.getSampleRate();
                    }
                    d = d2;
                }
                if (d > 0.0) {
                    l6 = 0L;
                    if ((double)(a - l5 + 1L) > d2) {
                        l6 = (long)((double)(10L * (a - l5)) / d2);
                    }
                } else if (l5 < a) {
                    l6 = 1000L;
                }
                double d3 = 0.0;
                l7 = 0L;
                while (l7 < l6) {
                    double d4;
                    frame = a2.grabFrame(a3.contains((Object)Frame.Type.AUDIO), a3.contains((Object)Frame.Type.VIDEO), false, false, false);
                    if (frame == null) {
                        return;
                    }
                    ++l7;
                    Frame frame2 = frame;
                    double d5 = frame2.timestamp;
                    d2 = 0.0;
                    if (frame2.image != null && a2.getFrameRate() > 0.0) {
                        d2 = 1000000.0 / a2.getFrameRate();
                    } else if (frame.samples != null && a2.samples_frame != null && a2.getSampleRate() > 0) {
                        d2 = (double)(1000000 * a2.samples_frame.nb_samples()) / (double)a2.getSampleRate();
                    }
                    d3 = 0.0;
                    if (d2 > 0.0) {
                        double d6;
                        d3 = (d5 - (double)l2) / d2 - (double)Math.round((d5 - (double)l2) / d2);
                        if (Math.abs(d6) > 0.2) {
                            d3 = 0.0;
                        }
                    }
                    d5 -= d3 * d2;
                    if (!(d4 + d2 > (double)a)) continue;
                    break block29;
                }
                break block29;
            }
            int n = avformat.avformat_seek_file(a2.oc, -1, Long.MIN_VALUE, (long)(a += l2), Long.MAX_VALUE, 1);
            if (n < 0) {
                throw new Exception("avformat_seek_file() error " + n + ": Could not seek file to timestamp " + (long)a + ".");
            }
            if (a2.video_c != null) {
                avcodec.avcodec_flush_buffers(a2.video_c);
            }
            if (a2.audio_c != null) {
                avcodec.avcodec_flush_buffers(a2.audio_c);
            }
            if (a2.pkt.stream_index() != -1) {
                FFmpegFrameGrabber fFmpegFrameGrabber = a2;
                avcodec.av_packet_unref(fFmpegFrameGrabber.pkt);
                fFmpegFrameGrabber.pkt.stream_index(-1);
            }
            int n2 = 0;
            FFmpegFrameGrabber fFmpegFrameGrabber = a2;
            while (fFmpegFrameGrabber.timestamp > a + 1L && a2.grabFrame(true, true, false, false) != null && n2++ < 1000) {
                fFmpegFrameGrabber = a2;
            }
            n2 = 0;
            FFmpegFrameGrabber fFmpegFrameGrabber2 = a2;
            while (fFmpegFrameGrabber2.timestamp < a - 1L && a2.grabFrame(true, true, false, false) != null && n2++ < 1000) {
                fFmpegFrameGrabber2 = a2;
            }
        }
        a2.frameGrabbed = true;
    }

    @Override
    public double getFrameRate() {
        FFmpegFrameGrabber a;
        return a.getVideoFrameRate();
    }

    public synchronized void releaseUnsafe() throws Exception {
        FFmpegFrameGrabber a2;
        FFmpegFrameGrabber fFmpegFrameGrabber = a2;
        fFmpegFrameGrabber.started = false;
        if (fFmpegFrameGrabber.plane_ptr != null && fFmpegFrameGrabber.plane_ptr2 != null) {
            fFmpegFrameGrabber.plane_ptr.releaseReference();
            fFmpegFrameGrabber.plane_ptr2.releaseReference();
            fFmpegFrameGrabber.plane_ptr2 = null;
            fFmpegFrameGrabber.plane_ptr = null;
        }
        if (fFmpegFrameGrabber.pkt != null) {
            if (fFmpegFrameGrabber.pkt.stream_index() != -1) {
                avcodec.av_packet_unref(fFmpegFrameGrabber.pkt);
            }
            fFmpegFrameGrabber.pkt.releaseReference();
            fFmpegFrameGrabber.pkt = null;
        }
        if (fFmpegFrameGrabber.image_ptr != null) {
            int n = a2 = 0;
            while (n < fFmpegFrameGrabber.image_ptr.length) {
                if (fFmpegFrameGrabber.imageMode != FrameGrabber.ImageMode.RAW) {
                    avutil.av_free((Pointer)fFmpegFrameGrabber.image_ptr[a2]);
                }
                n = ++a2;
            }
            fFmpegFrameGrabber.image_ptr = null;
        }
        if (fFmpegFrameGrabber.picture_rgb != null) {
            avutil.av_frame_free(fFmpegFrameGrabber.picture_rgb);
            fFmpegFrameGrabber.picture_rgb = null;
        }
        if (fFmpegFrameGrabber.picture != null) {
            avutil.av_frame_free(fFmpegFrameGrabber.picture);
            fFmpegFrameGrabber.picture = null;
        }
        if (fFmpegFrameGrabber.video_c != null) {
            avcodec.avcodec_free_context(fFmpegFrameGrabber.video_c);
            fFmpegFrameGrabber.video_c = null;
        }
        if (fFmpegFrameGrabber.samples_frame != null) {
            avutil.av_frame_free(fFmpegFrameGrabber.samples_frame);
            fFmpegFrameGrabber.samples_frame = null;
        }
        if (fFmpegFrameGrabber.audio_c != null) {
            avcodec.avcodec_free_context(fFmpegFrameGrabber.audio_c);
            fFmpegFrameGrabber.audio_c = null;
        }
        if (fFmpegFrameGrabber.inputStream == null && fFmpegFrameGrabber.oc != null && !fFmpegFrameGrabber.oc.isNull()) {
            avformat.avformat_close_input(fFmpegFrameGrabber.oc);
            fFmpegFrameGrabber.oc = null;
        }
        if (fFmpegFrameGrabber.img_convert_ctx != null) {
            swscale.sws_freeContext(fFmpegFrameGrabber.img_convert_ctx);
            fFmpegFrameGrabber.img_convert_ctx = null;
        }
        if (fFmpegFrameGrabber.samples_ptr_out != null) {
            int n = a2 = 0;
            while (n < fFmpegFrameGrabber.samples_ptr_out.length) {
                BytePointer bytePointer = fFmpegFrameGrabber.samples_ptr_out[a2];
                avutil.av_free((Pointer)bytePointer.position(0L));
                n = ++a2;
            }
            fFmpegFrameGrabber.samples_ptr_out = null;
            fFmpegFrameGrabber.samples_buf_out = null;
        }
        if (fFmpegFrameGrabber.samples_convert_ctx != null) {
            swresample.swr_free(fFmpegFrameGrabber.samples_convert_ctx);
            fFmpegFrameGrabber.samples_convert_ctx = null;
        }
        FFmpegFrameGrabber fFmpegFrameGrabber2 = fFmpegFrameGrabber;
        FFmpegFrameGrabber fFmpegFrameGrabber3 = fFmpegFrameGrabber;
        fFmpegFrameGrabber3.frameGrabbed = false;
        fFmpegFrameGrabber3.frame = null;
        fFmpegFrameGrabber2.timestamp = 0L;
        fFmpegFrameGrabber2.frameNumber = 0;
        if (fFmpegFrameGrabber.inputStream != null) {
            try {
                if (fFmpegFrameGrabber.oc == null) {
                    if (fFmpegFrameGrabber.closeInputStream) {
                        fFmpegFrameGrabber.inputStream.close();
                    }
                } else if (fFmpegFrameGrabber.maximumSize > 0) {
                    try {
                        fFmpegFrameGrabber.inputStream.reset();
                    }
                    catch (IOException a2) {
                        System.err.println("Error on InputStream.reset(): " + String.valueOf(a2));
                    }
                }
                inputStreams.remove((Object)fFmpegFrameGrabber.oc);
            }
            catch (IOException a2) {
                try {
                    throw new Exception(BlockUpUtil.ALLATORIxDEMO("ldLnL!Fx\u0000VGfXflt[sxK\f~So^w\u0002<\u00136"), a2);
                }
                catch (Throwable throwable) {
                    inputStreams.remove((Object)fFmpegFrameGrabber.oc);
                    if (fFmpegFrameGrabber.avio != null) {
                        if (fFmpegFrameGrabber.avio.buffer() != null) {
                            FFmpegFrameGrabber fFmpegFrameGrabber4 = fFmpegFrameGrabber;
                            avutil.av_free((Pointer)fFmpegFrameGrabber4.avio.buffer());
                            fFmpegFrameGrabber4.avio.buffer(null);
                        }
                        avutil.av_free(fFmpegFrameGrabber.avio);
                        fFmpegFrameGrabber.avio = null;
                    }
                    if (fFmpegFrameGrabber.oc != null) {
                        avformat.avformat_free_context(fFmpegFrameGrabber.oc);
                        fFmpegFrameGrabber.oc = null;
                    }
                    throw throwable;
                }
            }
            if (fFmpegFrameGrabber.avio != null) {
                if (fFmpegFrameGrabber.avio.buffer() != null) {
                    FFmpegFrameGrabber fFmpegFrameGrabber5 = fFmpegFrameGrabber;
                    avutil.av_free((Pointer)fFmpegFrameGrabber5.avio.buffer());
                    fFmpegFrameGrabber5.avio.buffer(null);
                }
                avutil.av_free(fFmpegFrameGrabber.avio);
                fFmpegFrameGrabber.avio = null;
            }
            if (fFmpegFrameGrabber.oc != null) {
                avformat.avformat_free_context(fFmpegFrameGrabber.oc);
                fFmpegFrameGrabber.oc = null;
                return;
            }
        }
    }

    @Override
    public int getLengthInFrames() {
        FFmpegFrameGrabber a;
        return a.getLengthInVideoFrames();
    }

    public static class Exception
    extends FrameGrabber.Exception {
        public Exception(String string) {
            String a = string;
            Exception a2 = this;
            super((String)a + " (For more details, make sure FFmpegLogCallback.set() has been called.)");
        }

        /*
         * WARNING - void declaration
         */
        public Exception(String string, Throwable throwable) {
            void a;
            Throwable a2 = throwable;
            Exception a3 = this;
            super((String)a, a2);
        }
    }

    static class ReadCallback
    extends Read_packet_Pointer_BytePointer_int {
        /*
         * WARNING - void declaration
         */
        @Override
        public int call(Pointer pointer, BytePointer bytePointer, int n) {
            byte[] a5;
            int a22;
            void a3;
            block3 : {
                byte[] arrby = this;
                try {
                    void a22;
                    void a4;
                    a5 = new byte[a4];
                    a22 = inputStreams.get(a22).read(a5, 0, (int)a4);
                    if (a22 >= 0) break block3;
                    return avutil.AVERROR_EOF();
                }
                catch (Throwable a5) {
                    System.err.println("Error on InputStream.read(): " + String.valueOf(a5));
                    return -1;
                }
            }
            a3.put(a5, 0, a22);
            return a22;
        }

        ReadCallback() {
            ReadCallback a;
        }
    }

    static class SeekCallback
    extends Seek_Pointer_long_int {
        /*
         * Exception decompiling
         */
        @Override
        public long call(Pointer var1_2, long var2_3, int var4_4) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [13[DOLOOP]], but top level block is 7[CASE]
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        SeekCallback() {
            SeekCallback a;
        }
    }

}
