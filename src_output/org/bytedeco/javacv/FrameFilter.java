/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.io.Closeable;
import java.io.IOException;
import org.bytedeco.javacv.FFmpegFrameFilter;
import org.bytedeco.javacv.Frame;

public abstract class FrameFilter
implements Closeable {
    protected int imageWidth;
    protected double frameRate;
    protected int audioInputs;
    protected String afilters;
    protected int audioChannels;
    protected int sampleRate;
    protected int imageHeight;
    protected double aspectRatio;
    protected int videoInputs;
    protected String filters;
    protected int pixelFormat;
    protected int sampleFormat;

    public void setAspectRatio(double a) {
        a.aspectRatio = a;
    }

    public void restart() throws Exception {
        FrameFilter a;
        FrameFilter frameFilter = a;
        frameFilter.stop();
        frameFilter.start();
    }

    public int getAudioInputs() {
        FrameFilter a;
        return a.audioInputs;
    }

    public FrameFilter() {
        FrameFilter a;
    }

    public abstract void release() throws Exception;

    public int getVideoInputs() {
        FrameFilter a;
        return a.videoInputs;
    }

    public String getFilters() {
        FrameFilter a;
        return a.filters;
    }

    public int getImageHeight() {
        FrameFilter a;
        return a.imageHeight;
    }

    public void setSampleRate(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.sampleRate = a;
    }

    public void setFrameRate(double a) {
        a.frameRate = a;
    }

    public void setAudioChannels(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.audioChannels = a;
    }

    public abstract Frame pull() throws Exception;

    /*
     * WARNING - void declaration
     */
    public static FrameFilter createDefault(String string, int n, int n2) throws Exception {
        void a;
        int a2 = n2;
        String a3 = string;
        return new FFmpegFrameFilter(a3, (int)a, a2);
    }

    public void setImageHeight(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.imageHeight = a;
    }

    public void setVideoInputs(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.videoInputs = a;
    }

    public void setAudioInputs(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.audioInputs = a;
    }

    public int getAudioChannels() {
        FrameFilter a;
        return a.audioChannels;
    }

    public int getPixelFormat() {
        FrameFilter a;
        return a.pixelFormat;
    }

    public void flush() throws Exception {
        FrameFilter a;
        FrameFilter frameFilter = a;
        while (frameFilter.pull() != null) {
            frameFilter = a;
        }
    }

    public int getImageWidth() {
        FrameFilter a;
        return a.imageWidth;
    }

    public double getFrameRate() {
        FrameFilter a;
        return a.frameRate;
    }

    public void setImageWidth(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.imageWidth = a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 3 ^ 2;
        4 << 4 ^ 3;
        int n4 = (2 ^ 5) << 4 ^ 3;
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    public int getSampleRate() {
        FrameFilter a;
        return a.sampleRate;
    }

    public void setFilters(String string) {
        String a = string;
        FrameFilter a2 = this;
        a2.filters = a;
    }

    public void setPixelFormat(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.pixelFormat = a;
    }

    public double getAspectRatio() {
        FrameFilter a;
        return a.aspectRatio;
    }

    public abstract void stop() throws Exception;

    public abstract void start() throws Exception;

    public int getSampleFormat() {
        FrameFilter a;
        return a.sampleFormat;
    }

    public abstract void push(Frame var1) throws Exception;

    public void setSampleFormat(int n) {
        int a = n;
        FrameFilter a2 = this;
        a2.sampleFormat = a;
    }

    @Override
    public void close() throws Exception {
        FrameFilter a;
        FrameFilter frameFilter = a;
        frameFilter.stop();
        frameFilter.release();
    }

    public static class Exception
    extends IOException {
        public Exception(String string) {
            String a = string;
            Exception a2 = this;
            super(a);
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

}
