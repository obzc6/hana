/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avcodec;

import org.bytedeco.ffmpeg.avcodec.AVCodecParser;
import org.bytedeco.ffmpeg.avcodec.AVCodecParserContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVCodecParser.Parser_close_AVCodecParserContext
extends FunctionPointer {
    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    protected AVCodecParser.Parser_close_AVCodecParserContext() {
        AVCodecParser.Parser_close_AVCodecParserContext a;
        AVCodecParser.Parser_close_AVCodecParserContext parser_close_AVCodecParserContext = a;
        parser_close_AVCodecParserContext.allocate();
    }

    public AVCodecParser.Parser_close_AVCodecParserContext(Pointer pointer) {
        AVCodecParser.Parser_close_AVCodecParserContext a = pointer;
        AVCodecParser.Parser_close_AVCodecParserContext a2 = this;
        super((Pointer)a);
    }

    public native void call(AVCodecParserContext var1);
}
