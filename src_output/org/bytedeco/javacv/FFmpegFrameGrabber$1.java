/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;

static class FFmpegFrameGrabber.1 {
    static final /* synthetic */ int[] $SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode;

    static {
        $SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode = new int[FrameGrabber.ImageMode.values().length];
        try {
            FFmpegFrameGrabber.1.$SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode[FrameGrabber.ImageMode.COLOR.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            FFmpegFrameGrabber.1.$SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode[FrameGrabber.ImageMode.GRAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            FFmpegFrameGrabber.1.$SwitchMap$org$bytedeco$javacv$FrameGrabber$ImageMode[FrameGrabber.ImageMode.RAW.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
