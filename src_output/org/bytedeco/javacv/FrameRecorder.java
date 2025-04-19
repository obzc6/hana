/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import dev.recollect.hana.xibao.SnowAnimation;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.bytedeco.javacv.BufferRing;
import org.bytedeco.javacv.Frame;

public abstract class FrameRecorder
implements Closeable {
    protected Map<String, String> options;
    protected double audioQuality;
    protected Map<String, String> videoMetadata;
    protected Map<String, Buffer> audioSideData;
    protected double aspectRatio;
    protected double videoQuality;
    protected int audioBitrate;
    protected long timestamp;
    protected Map<String, String> audioOptions;
    protected String audioCodecName;
    protected int audioCodec;
    protected int pixelFormat;
    protected int imageWidth;
    protected Charset charset;
    protected int sampleFormat;
    protected String format;
    protected int maxBFrames;
    protected int frameNumber;
    protected Map<String, Buffer> videoSideData;
    public static final List<String> list;
    protected double frameRate;
    protected int videoBitrate;
    protected int gopSize;
    protected int trellis;
    protected Map<String, String> videoOptions;
    protected Map<String, String> metadata;
    protected boolean interleaved;
    protected int imageHeight;
    protected int videoCodec;
    protected Map<String, String> audioMetadata;
    protected int maxDelay;
    protected int audioChannels;
    protected String videoCodecName;
    protected int sampleRate;
    protected int imageScalingFlags;

    public boolean isInterleaved() {
        FrameRecorder a;
        return a.interleaved;
    }

    public void setPixelFormat(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.pixelFormat = a;
    }

    public Map<String, Buffer> getAudioSideData() {
        FrameRecorder a;
        return a.audioSideData;
    }

    public void setAudioMetadata(Map<String, String> map) {
        Map<String, String> a = map;
        FrameRecorder a2 = this;
        a2.audioMetadata = a;
    }

    public void setImageWidth(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.imageWidth = a;
    }

    public String getOption(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.options.get(a);
    }

    public int getTrellis() {
        FrameRecorder a;
        return a.trellis;
    }

    public static void init() {
        for (String string : list) {
            try {
                FrameRecorder.get(string).getMethod(BufferRing.ALLATORIxDEMO("\t<\u0003\u0005\u00125\u0004"), new Class[0]).invoke(null, new Object[0]);
            }
            catch (Throwable throwable) {}
        }
    }

    public Map<String, Buffer> getVideoSideData() {
        FrameRecorder a;
        return a.videoSideData;
    }

    public void setFrameRate(double a) {
        a.frameRate = a;
    }

    public void setImageHeight(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.imageHeight = a;
    }

    public void setAudioCodecName(String string) {
        String a = string;
        FrameRecorder a2 = this;
        a2.audioCodecName = a;
    }

    public int getAudioBitrate() {
        FrameRecorder a;
        return a.audioBitrate;
    }

    public double getFrameRate() {
        FrameRecorder a;
        return a.frameRate;
    }

    /*
     * WARNING - void declaration
     */
    public void setMetadata(String string, String string2) {
        void a;
        String a2 = string2;
        FrameRecorder a3 = this;
        a3.metadata.put((String)a, a2);
    }

    public void setVideoMetadata(Map<String, String> map) {
        Map<String, String> a = map;
        FrameRecorder a2 = this;
        a2.videoMetadata = a;
    }

    public String getFormat() {
        FrameRecorder a;
        return a.format;
    }

    public long getTimestamp() {
        FrameRecorder a;
        return a.timestamp;
    }

    public void setVideoQuality(double a) {
        a.videoQuality = a;
    }

    public void setVideoCodecName(String string) {
        String a = string;
        FrameRecorder a2 = this;
        a2.videoCodecName = a;
    }

    public void setInterleaved(boolean bl) {
        boolean a = bl;
        FrameRecorder a2 = this;
        a2.interleaved = a;
    }

    public FrameRecorder() {
        FrameRecorder a;
        FrameRecorder frameRecorder = a;
        FrameRecorder frameRecorder2 = a;
        FrameRecorder frameRecorder3 = a;
        FrameRecorder frameRecorder4 = a;
        FrameRecorder frameRecorder5 = a;
        a.gopSize = -1;
        frameRecorder5.videoQuality = -1.0;
        frameRecorder5.audioQuality = -1.0;
        frameRecorder4.charset = Charset.defaultCharset();
        FrameRecorder frameRecorder6 = a;
        frameRecorder6.options = new HashMap<String, String>();
        frameRecorder4.videoOptions = new HashMap<String, String>();
        frameRecorder4.audioOptions = new HashMap<String, String>();
        frameRecorder4.metadata = new HashMap<String, String>();
        frameRecorder4.videoMetadata = new HashMap<String, String>();
        frameRecorder4.audioMetadata = new HashMap<String, String>();
        frameRecorder3.videoSideData = new HashMap<String, Buffer>();
        frameRecorder3.audioSideData = new HashMap<String, Buffer>();
        frameRecorder3.frameNumber = 0;
        frameRecorder2.timestamp = 0L;
        frameRecorder2.maxBFrames = -1;
        frameRecorder.trellis = -1;
        frameRecorder.maxDelay = -1;
    }

    public void setTrellis(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.trellis = a;
    }

    public double getAspectRatio() {
        FrameRecorder a;
        return a.aspectRatio;
    }

    public int getSampleFormat() {
        FrameRecorder a;
        return a.sampleFormat;
    }

    public String getVideoCodecName() {
        FrameRecorder a;
        return a.videoCodecName;
    }

    public abstract void record(Frame var1) throws Exception;

    public int getFrameNumber() {
        FrameRecorder a;
        return a.frameNumber;
    }

    public void setFormat(String string) {
        String a = string;
        FrameRecorder a2 = this;
        a2.format = a;
    }

    public void setAudioCodec(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.audioCodec = a;
    }

    public int getAudioChannels() {
        FrameRecorder a;
        return a.audioChannels;
    }

    public void setVideoOptions(Map<String, String> map) {
        Map<String, String> a = map;
        FrameRecorder a2 = this;
        a2.videoOptions = a;
    }

    public void setAudioChannels(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.audioChannels = a;
    }

    /*
     * WARNING - void declaration
     */
    public static FrameRecorder createDefault(File file, int n, int n2) throws Exception {
        void a;
        int a2 = n2;
        File a3 = file;
        return FrameRecorder.create(FrameRecorder.getDefault(), File.class, a3, (int)a, a2);
    }

    /*
     * WARNING - void declaration
     */
    public void setVideoSideData(String string, Buffer buffer) {
        void a;
        Buffer a2 = buffer;
        FrameRecorder a3 = this;
        a3.videoSideData.put((String)a, a2);
    }

    public Map<String, String> getVideoMetadata() {
        FrameRecorder a;
        return a.videoMetadata;
    }

    public int getGopSize() {
        FrameRecorder a;
        return a.gopSize;
    }

    public String getAudioOption(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.audioOptions.get(a);
    }

    public void setVideoCodec(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.videoCodec = a;
    }

    public void setImageScalingFlags(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.imageScalingFlags = a;
    }

    public void setFrameNumber(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.frameNumber = a;
    }

    public void setAspectRatio(double a) {
        a.aspectRatio = a;
    }

    public int getPixelFormat() {
        FrameRecorder a;
        return a.pixelFormat;
    }

    public Map<String, String> getOptions() {
        FrameRecorder a;
        return a.options;
    }

    public String getMetadata(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.metadata.get(a);
    }

    /*
     * WARNING - void declaration
     */
    public void setOption(String string, String string2) {
        void a;
        String a2 = string2;
        FrameRecorder a3 = this;
        a3.options.put((String)a, a2);
    }

    public String getVideoMetadata(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.videoMetadata.get(a);
    }

    public int getSampleRate() {
        FrameRecorder a;
        return a.sampleRate;
    }

    public void setMaxDelay(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.maxDelay = a;
    }

    public void setGopSize(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.gopSize = a;
    }

    public Charset getCharset() {
        FrameRecorder a;
        return a.charset;
    }

    public void setCharset(Charset charset) {
        Charset a = charset;
        FrameRecorder a2 = this;
        a2.charset = a;
    }

    public abstract void stop() throws Exception;

    public double getAudioQuality() {
        FrameRecorder a;
        return a.audioQuality;
    }

    /*
     * WARNING - void declaration
     */
    public void setVideoOption(String string, String string2) {
        void a;
        String a2 = string2;
        FrameRecorder a3 = this;
        a3.videoOptions.put((String)a, a2);
    }

    public void setAudioOptions(Map<String, String> map) {
        Map<String, String> a = map;
        FrameRecorder a2 = this;
        a2.audioOptions = a;
    }

    public void setAudioQuality(double a) {
        a.audioQuality = a;
    }

    /*
     * WARNING - void declaration
     */
    public static FrameRecorder createDefault(String string, int n, int n2) throws Exception {
        void a;
        int a2 = n2;
        String a3 = string;
        return FrameRecorder.create(FrameRecorder.getDefault(), String.class, a3, (int)a, a2);
    }

    /*
     * WARNING - void declaration
     */
    public void setAudioMetadata(String string, String string2) {
        void a;
        String a2 = string2;
        FrameRecorder a3 = this;
        a3.audioMetadata.put((String)a, a2);
    }

    public int getImageScalingFlags() {
        FrameRecorder a;
        return a.imageScalingFlags;
    }

    static {
        String[] arrstring = new String[2];
        arrstring[0] = BufferRing.ALLATORIxDEMO("\u000f;9\u0010{M");
        arrstring[1] = SnowAnimation.ALLATORIxDEMO("w\u0016\\\tm&");
        list = new LinkedList<String>(Arrays.asList(arrstring));
    }

    public int getAudioCodec() {
        FrameRecorder a;
        return a.audioCodec;
    }

    public abstract void start() throws Exception;

    public int getVideoBitrate() {
        FrameRecorder a;
        return a.videoBitrate;
    }

    public String getAudioMetadata(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.audioMetadata.get(a);
    }

    public void setVideoBitrate(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.videoBitrate = a;
    }

    public int getMaxDelay() {
        FrameRecorder a;
        return a.maxDelay;
    }

    public void setTimestamp(long a) {
        a.timestamp = a;
    }

    public void setAudioBitrate(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.audioBitrate = a;
    }

    public void setVideoSideData(Map<String, Buffer> map) {
        Map<String, Buffer> a = map;
        FrameRecorder a2 = this;
        a2.videoSideData = a;
    }

    @Override
    public void close() throws Exception {
        FrameRecorder a;
        FrameRecorder frameRecorder = a;
        frameRecorder.stop();
        frameRecorder.release();
    }

    public void setMaxBFrames(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.maxBFrames = a;
    }

    public static Class<? extends FrameRecorder> getDefault() {
        Iterator<String> iterator;
        Iterator<String> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator.next();
            try {
                object = FrameRecorder.get((String)object);
                ((Class)object).getMethod(SnowAnimation.ALLATORIxDEMO("\u0004J\u001fu\bO\u0014"), new Class[0]).invoke(null, new Object[0]);
                return object;
            }
            catch (Throwable throwable) {
                iterator2 = iterator;
            }
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public void setAudioSideData(String string, Buffer buffer) {
        void a;
        Buffer a2 = buffer;
        FrameRecorder a3 = this;
        a3.audioSideData.put((String)a, a2);
    }

    public static Class<? extends FrameRecorder> get(String a) throws Exception {
        Object object = a;
        object = FrameRecorder.class.getPackage().getName() + "." + (String)object;
        try {
            return Class.forName((String)object).asSubclass(FrameRecorder.class);
        }
        catch (ClassNotFoundException classNotFoundException) {
            a = (String)object + "FrameRecorder";
            try {
                return Class.forName((String)a).asSubclass(FrameRecorder.class);
            }
            catch (ClassNotFoundException classNotFoundException2) {
                throw new Exception("Could not get FrameRecorder class for " + (String)object + " or " + (String)a, classNotFoundException);
            }
        }
    }

    public int getImageWidth() {
        FrameRecorder a;
        return a.imageWidth;
    }

    /*
     * WARNING - void declaration
     */
    public static FrameRecorder create(String string, String string2, int n, int n2) throws Exception {
        void a;
        void a2;
        int a3 = n2;
        String a4 = string;
        return FrameRecorder.create(FrameRecorder.get(a4), String.class, a2, (int)a, a3);
    }

    public Buffer getVideoSideData(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.videoSideData.get(a);
    }

    public void setSampleFormat(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.sampleFormat = a;
    }

    public abstract void release() throws Exception;

    public Map<String, String> getAudioOptions() {
        FrameRecorder a;
        return a.audioOptions;
    }

    /*
     * WARNING - void declaration
     */
    public static FrameRecorder create(Class<? extends FrameRecorder> class_, Class class_2, Object object, int n, int n2) throws Exception {
        void a;
        void a2;
        void a3;
        Class a222 = class_2;
        Class<? extends FrameRecorder> a4 = class_;
        Throwable throwable = null;
        try {
            Class[] arrclass = new Class[3];
            arrclass[0] = a222;
            arrclass[1] = Integer.TYPE;
            arrclass[2] = Integer.TYPE;
            Object[] arrobject = new Object[3];
            arrobject[0] = a3;
            arrobject[1] = (int)a;
            arrobject[2] = (int)a2;
            return a4.getConstructor(arrclass).newInstance(arrobject);
        }
        catch (InstantiationException a222) {
            throwable = a222;
        }
        catch (IllegalAccessException a222) {
            throwable = a222;
        }
        catch (IllegalArgumentException a222) {
            throwable = a222;
        }
        catch (NoSuchMethodException a222) {
            throwable = a222;
        }
        catch (InvocationTargetException a222) {
            throwable = a222.getCause();
        }
        throw new Exception("Could not create new " + a4.getSimpleName() + "(" + String.valueOf(a3) + ", " + (int)a + ", " + (int)a2 + ")", throwable);
    }

    /*
     * WARNING - void declaration
     */
    public static FrameRecorder create(String string, File file, int n, int n2) throws Exception {
        void a;
        void a2;
        int a3 = n2;
        String a4 = string;
        return FrameRecorder.create(FrameRecorder.get(a4), File.class, a2, (int)a, a3);
    }

    public double getVideoQuality() {
        FrameRecorder a;
        return a.videoQuality;
    }

    public Map<String, String> getAudioMetadata() {
        FrameRecorder a;
        return a.audioMetadata;
    }

    public String getAudioCodecName() {
        FrameRecorder a;
        return a.audioCodecName;
    }

    public String getVideoOption(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.videoOptions.get(a);
    }

    public int getMaxBFrames() {
        FrameRecorder a;
        return a.maxBFrames;
    }

    public void setSampleRate(int n) {
        int a = n;
        FrameRecorder a2 = this;
        a2.sampleRate = a;
    }

    public void setAudioSideData(Map<String, Buffer> map) {
        Map<String, Buffer> a = map;
        FrameRecorder a2 = this;
        a2.audioSideData = a;
    }

    public abstract void flush() throws Exception;

    public int getVideoCodec() {
        FrameRecorder a;
        return a.videoCodec;
    }

    public Buffer getAudioSideData(String string) {
        String a = string;
        FrameRecorder a2 = this;
        return a2.audioSideData.get(a);
    }

    public void setMetadata(Map<String, String> map) {
        Map<String, String> a = map;
        FrameRecorder a2 = this;
        a2.metadata = a;
    }

    /*
     * WARNING - void declaration
     */
    public void setAudioOption(String string, String string2) {
        void a;
        String a2 = string2;
        FrameRecorder a3 = this;
        a3.audioOptions.put((String)a, a2);
    }

    public Map<String, String> getVideoOptions() {
        FrameRecorder a;
        return a.videoOptions;
    }

    public Map<String, String> getMetadata() {
        FrameRecorder a;
        return a.metadata;
    }

    /*
     * WARNING - void declaration
     */
    public void setVideoMetadata(String string, String string2) {
        void a;
        String a2 = string2;
        FrameRecorder a3 = this;
        a3.videoMetadata.put((String)a, a2);
    }

    public int getImageHeight() {
        FrameRecorder a;
        return a.imageHeight;
    }

    public void setOptions(Map<String, String> map) {
        Map<String, String> a = map;
        FrameRecorder a2 = this;
        a2.options = a;
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
