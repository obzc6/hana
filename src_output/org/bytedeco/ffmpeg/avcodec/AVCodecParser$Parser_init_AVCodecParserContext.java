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

public static class AVCodecParser.Parser_init_AVCodecParserContext
extends FunctionPointer {
    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    protected AVCodecParser.Parser_init_AVCodecParserContext() {
        AVCodecParser.Parser_init_AVCodecParserContext a;
        AVCodecParser.Parser_init_AVCodecParserContext parser_init_AVCodecParserContext = a;
        parser_init_AVCodecParserContext.allocate();
    }

    public AVCodecParser.Parser_init_AVCodecParserContext(Pointer pointer) {
        AVCodecParser.Parser_init_AVCodecParserContext a = pointer;
        AVCodecParser.Parser_init_AVCodecParserContext a2 = this;
        super((Pointer)a);
    }

    public native int call(AVCodecParserContext var1);
}
