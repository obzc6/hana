/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.annotation.Platform
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg;

import org.bytedeco.ffmpeg.presets.avdevice;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avdevice.class, avfilter.class}, value={@Platform(executable={"ffmpeg"})})
public class ffmpeg {
    public ffmpeg() {
        ffmpeg a;
    }

    static {
        Loader.load();
    }
}
