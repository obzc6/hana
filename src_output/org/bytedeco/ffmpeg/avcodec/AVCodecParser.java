/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVCodecParserContext;
import org.bytedeco.ffmpeg.presets.avcodec;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avcodec.class})
public class AVCodecParser
extends Pointer {
    public native AVCodecParser split(Split_AVCodecContext_BytePointer_int var1);

    public AVCodecParser() {
        super((Pointer)null);
        AVCodecParser a;
        a.allocate();
    }

    public native AVCodecParser parser_parse(Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int var1);

    public native int codec_ids(int var1);

    static {
        Loader.load();
    }

    public native AVCodecParser codec_ids(int var1, int var2);

    private native /* synthetic */ void allocate();

    public AVCodecParser(long a) {
        super((Pointer)null);
        AVCodecParser a2;
        a2.allocateArray(a);
    }

    public native int priv_data_size();

    public native Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int parser_parse();

    public AVCodecParser getPointer(long a) {
        AVCodecParser a2;
        return (AVCodecParser)new AVCodecParser(a2).offsetAddress(a);
    }

    public native Split_AVCodecContext_BytePointer_int split();

    public native AVCodecParser priv_data_size(int var1);

    private native /* synthetic */ void allocateArray(long var1);

    public native Parser_close_AVCodecParserContext parser_close();

    public native AVCodecParser parser_init(Parser_init_AVCodecParserContext var1);

    public native AVCodecParser parser_close(Parser_close_AVCodecParserContext var1);

    public AVCodecParser position(long a) {
        AVCodecParser a2;
        return (AVCodecParser)super.position(a);
    }

    @MemberGetter
    public native IntPointer codec_ids();

    public native Parser_init_AVCodecParserContext parser_init();

    public AVCodecParser(Pointer pointer) {
        AVCodecParser a = pointer;
        AVCodecParser a2 = this;
        super((Pointer)a);
    }

    public static class Split_AVCodecContext_BytePointer_int
    extends FunctionPointer {
        public Split_AVCodecContext_BytePointer_int(Pointer pointer) {
            Split_AVCodecContext_BytePointer_int a = pointer;
            Split_AVCodecContext_BytePointer_int a2 = this;
            super((Pointer)a);
        }

        protected Split_AVCodecContext_BytePointer_int() {
            Split_AVCodecContext_BytePointer_int a;
            Split_AVCodecContext_BytePointer_int split_AVCodecContext_BytePointer_int = a;
            split_AVCodecContext_BytePointer_int.allocate();
        }

        private native /* synthetic */ void allocate();

        public native int call(AVCodecContext var1, @Cast(value={"const uint8_t*"}) BytePointer var2, int var3);

        static {
            Loader.load();
        }
    }

    public static class Parser_close_AVCodecParserContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        protected Parser_close_AVCodecParserContext() {
            Parser_close_AVCodecParserContext a;
            Parser_close_AVCodecParserContext parser_close_AVCodecParserContext = a;
            parser_close_AVCodecParserContext.allocate();
        }

        public Parser_close_AVCodecParserContext(Pointer pointer) {
            Parser_close_AVCodecParserContext a = pointer;
            Parser_close_AVCodecParserContext a2 = this;
            super((Pointer)a);
        }

        public native void call(AVCodecParserContext var1);
    }

    public static class Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int
    extends FunctionPointer {
        static {
            Loader.load();
        }

        public Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int(Pointer pointer) {
            Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int a = pointer;
            Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int a2 = this;
            super((Pointer)a);
        }

        protected Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int() {
            Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int a;
            Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int = a;
            parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int.allocate();
        }

        public native int call(AVCodecParserContext var1, AVCodecContext var2, @Cast(value={"const uint8_t**"}) PointerPointer var3, IntPointer var4, @Cast(value={"const uint8_t*"}) BytePointer var5, int var6);

        private native /* synthetic */ void allocate();
    }

    public static class Parser_init_AVCodecParserContext
    extends FunctionPointer {
        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        protected Parser_init_AVCodecParserContext() {
            Parser_init_AVCodecParserContext a;
            Parser_init_AVCodecParserContext parser_init_AVCodecParserContext = a;
            parser_init_AVCodecParserContext.allocate();
        }

        public Parser_init_AVCodecParserContext(Pointer pointer) {
            Parser_init_AVCodecParserContext a = pointer;
            Parser_init_AVCodecParserContext a2 = this;
            super((Pointer)a);
        }

        public native int call(AVCodecParserContext var1);
    }

}
