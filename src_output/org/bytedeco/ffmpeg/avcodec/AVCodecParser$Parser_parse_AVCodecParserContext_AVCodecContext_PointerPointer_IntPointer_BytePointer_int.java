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
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVCodecParser;
import org.bytedeco.ffmpeg.avcodec.AVCodecParserContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;

public static class AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int
extends FunctionPointer {
    static {
        Loader.load();
    }

    public AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int(Pointer pointer) {
        AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int a = pointer;
        AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int a2 = this;
        super((Pointer)a);
    }

    protected AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int() {
        AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int a;
        AVCodecParser.Parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int = a;
        parser_parse_AVCodecParserContext_AVCodecContext_PointerPointer_IntPointer_BytePointer_int.allocate();
    }

    public native int call(AVCodecParserContext var1, AVCodecContext var2, @Cast(value={"const uint8_t**"}) PointerPointer var3, IntPointer var4, @Cast(value={"const uint8_t*"}) BytePointer var5, int var6);

    private native /* synthetic */ void allocate();
}
