/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.video.FileUtil;
import java.beans.PropertyEditorSupport;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.bytedeco.javacv.Frame;

public abstract class FrameGrabber
implements Closeable {
    public static final long SENSOR_PATTERN_RGGB = 0L;
    protected Map<String, String> videoMetadata;
    protected int audioChannels;
    protected SampleMode sampleMode;
    protected long timestamp;
    protected int audioCodec;
    protected long startTime;
    protected int sampleRate;
    protected String audioCodecName;
    protected double aspectRatio;
    protected int audioDisposition;
    protected int imageHeight;
    protected int videoStream;
    protected int videoCodec;
    protected int pixelFormat;
    protected Map<String, Buffer> audioSideData;
    private Frame delayedFrame;
    private ExecutorService executor;
    protected int audioStream;
    protected Charset charset;
    protected boolean triggerMode;
    protected int imageScalingFlags;
    protected int maxDelay;
    public static final long SENSOR_PATTERN_GBRG = 0x100000000L;
    protected Map<String, Buffer> videoSideData;
    protected double frameRate;
    protected boolean deinterlace;
    private long delayedTime;
    protected long sensorPattern;
    private Future<Void> future;
    protected Map<String, String> videoOptions;
    public static final List<String> list;
    public static final long SENSOR_PATTERN_BGGR = 0x100000001L;
    protected int imageWidth;
    protected int frameNumber;
    protected double gamma;
    protected Map<String, String> metadata;
    protected ImageMode imageMode;
    protected int sampleFormat;
    protected String format;
    protected String videoCodecName;
    protected Map<String, String> audioMetadata;
    protected Map<String, String> options;
    protected Map<String, String> audioOptions;
    protected int timeout;
    protected int audioBitrate;
    protected int videoDisposition;
    protected int bpp;
    protected int videoBitrate;
    public static final long SENSOR_PATTERN_GRBG = 1L;
    protected int numBuffers;

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static Class<? extends FrameGrabber> getDefault() {
        var0 = FrameGrabber.list.iterator();
        block5 : do {
            v0 = var0;
            while (v0.hasNext()) {
                var1_1 = var0.next();
                var1_1 = FrameGrabber.get((String)var1_1);
                var1_1.getMethod(NpSocketClient.ALLATORIxDEMO(">x3A\"{>"), new Class[0]).invoke(null, new Object[0]);
                var2_3 = false;
                try {
                    var3_4 = (String[])var1_1.getMethod(Setting.ALLATORIxDEMO("$p\"S1p,U\u0010S1g4a9w0w2h6"), new Class[0]).invoke(null, new Object[0]);
                    if (var3_4.length > 0) {
                        var2_3 = true;
                    }
                    ** GOTO lbl28
                }
                catch (Throwable var3_5) {
                    try {
                        if (var3_5.getCause() instanceof UnsupportedOperationException) {
                            var2_3 = true;
                        }
lbl28: // 4 sources:
                        if (!var2_3) continue block5;
                        return var1_1;
                    }
                    catch (Throwable var1_2) {
                        v0 = var0;
                    }
                }
            }
            break;
        } while (true);
        return null;
    }

    public long getLengthInTime() {
        return 0L;
    }

    public int getTimeout() {
        FrameGrabber a;
        return a.timeout;
    }

    public void setTimestamp(long a) throws Exception {
        a.timestamp = a;
    }

    public static FrameGrabber createDefault(File a) throws Exception {
        return FrameGrabber.create(FrameGrabber.getDefault(), File.class, a);
    }

    public abstract void release() throws Exception;

    /*
     * WARNING - void declaration
     */
    public void setVideoMetadata(String string, String string2) {
        void a;
        String a2 = string2;
        FrameGrabber a3 = this;
        a3.videoMetadata.put((String)a, a2);
    }

    /*
     * WARNING - void declaration
     */
    public void setAudioMetadata(String string, String string2) {
        void a;
        String a2 = string2;
        FrameGrabber a3 = this;
        a3.audioMetadata.put((String)a, a2);
    }

    public int getBitsPerPixel() {
        FrameGrabber a;
        return a.bpp;
    }

    public int getAudioCodec() {
        FrameGrabber a;
        return a.audioCodec;
    }

    public void setAudioStream(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.audioStream = a;
    }

    public void setAudioDisposition(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.audioDisposition = a;
    }

    public int getSampleFormat() {
        FrameGrabber a;
        return a.sampleFormat;
    }

    public double getGamma() {
        FrameGrabber a;
        return a.gamma;
    }

    public int getImageScalingFlags() {
        FrameGrabber a;
        return a.imageScalingFlags;
    }

    public Map<String, String> getVideoOptions() {
        FrameGrabber a;
        return a.videoOptions;
    }

    public void setSampleFormat(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.sampleFormat = a;
    }

    public void setMetadata(Map<String, String> map) {
        Map<String, String> a = map;
        FrameGrabber a2 = this;
        a2.metadata = a;
    }

    /*
     * WARNING - void declaration
     */
    public void setOption(String string, String string2) {
        void a;
        String a2 = string2;
        FrameGrabber a3 = this;
        a3.options.put((String)a, a2);
    }

    public int getPixelFormat() {
        FrameGrabber a;
        return a.pixelFormat;
    }

    public Frame grabAtFrameRate() throws Exception, InterruptedException {
        AutoCloseable a;
        FrameGrabber frameGrabber = a;
        a = frameGrabber.grab();
        if (a != null) {
            frameGrabber.waitForTimestamp((Frame)a);
        }
        return a;
    }

    public void setMaxDelay(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.maxDelay = a;
    }

    public String getAudioOption(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.audioOptions.get(a);
    }

    public int getNumBuffers() {
        FrameGrabber a;
        return a.numBuffers;
    }

    public void setDeinterlace(boolean bl) {
        boolean a = bl;
        FrameGrabber a2 = this;
        a2.deinterlace = a;
    }

    public static FrameGrabber createDefault(String a) throws Exception {
        return FrameGrabber.create(FrameGrabber.getDefault(), String.class, a);
    }

    public boolean waitForTimestamp(Frame frame) throws InterruptedException {
        AutoCloseable a = frame;
        FrameGrabber a2 = this;
        if (a2.startTime == 0L) {
            a2.startTime = System.nanoTime() / 1000L - ((Frame)a).timestamp;
        } else {
            long l = ((Frame)a).timestamp - (System.nanoTime() / 1000L - a2.startTime);
            if (l > 0L) {
                Thread.sleep(l / 1000L, (int)(l % 1000L) * 1000);
                return true;
            }
        }
        return false;
    }

    public Charset getCharset() {
        FrameGrabber a;
        return a.charset;
    }

    public int getVideoStream() {
        FrameGrabber a;
        return a.videoStream;
    }

    public void setGamma(double a) {
        a.gamma = a;
    }

    public Map<String, String> getOptions() {
        FrameGrabber a;
        return a.options;
    }

    public int getVideoDisposition() {
        FrameGrabber a;
        return a.videoDisposition;
    }

    public void setTimeout(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.timeout = a;
    }

    public void setAudioChannels(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.audioChannels = a;
    }

    public String getAudioCodecName() {
        FrameGrabber a;
        return a.audioCodecName;
    }

    /*
     * WARNING - void declaration
     */
    public void setMetadata(String string, String string2) {
        void a;
        String a2 = string2;
        FrameGrabber a3 = this;
        a3.metadata.put((String)a, a2);
    }

    @Override
    public void close() throws Exception {
        FrameGrabber a;
        FrameGrabber frameGrabber = a;
        frameGrabber.stop();
        frameGrabber.release();
    }

    public void restart() throws Exception {
        FrameGrabber a;
        FrameGrabber frameGrabber = a;
        frameGrabber.stop();
        frameGrabber.start();
    }

    public void setAudioOptions(Map<String, String> map) {
        Map<String, String> a = map;
        FrameGrabber a2 = this;
        a2.audioOptions = a;
    }

    public int getVideoCodec() {
        FrameGrabber a;
        return a.videoCodec;
    }

    public String getFormat() {
        FrameGrabber a;
        return a.format;
    }

    public static FrameGrabber create(String string, int n) throws Exception {
        int a = n;
        String a2 = string;
        try {
            return FrameGrabber.create(FrameGrabber.get(a2), Integer.TYPE, a);
        }
        catch (Exception exception) {
            return FrameGrabber.create(FrameGrabber.get(a2), Integer.class, a);
        }
    }

    public void setNumBuffers(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.numBuffers = a;
    }

    public Map<String, String> getAudioOptions() {
        FrameGrabber a;
        return a.audioOptions;
    }

    public void setAudioBitrate(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.audioBitrate = a;
    }

    public Map<String, Buffer> getVideoSideData() {
        FrameGrabber a;
        return a.videoSideData;
    }

    public void setVideoCodecName(String string) {
        String a = string;
        FrameGrabber a2 = this;
        a2.videoCodecName = a;
    }

    public Buffer getVideoSideData(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.videoSideData.get(a);
    }

    public String getVideoOption(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.videoOptions.get(a);
    }

    public void setVideoOptions(Map<String, String> map) {
        Map<String, String> a = map;
        FrameGrabber a2 = this;
        a2.videoOptions = a;
    }

    public int getAudioChannels() {
        FrameGrabber a;
        return a.audioChannels;
    }

    public void setVideoSideData(Map<String, Buffer> map) {
        Map<String, Buffer> a = map;
        FrameGrabber a2 = this;
        a2.videoSideData = a;
    }

    public abstract void start() throws Exception;

    public void setCharset(Charset charset) {
        Charset a = charset;
        FrameGrabber a2 = this;
        a2.charset = a;
    }

    public void setSampleMode(SampleMode sampleMode) {
        Object a = sampleMode;
        FrameGrabber a2 = this;
        a2.sampleMode = a;
    }

    public String getVideoCodecName() {
        FrameGrabber a;
        return a.videoCodecName;
    }

    public String getMetadata(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.metadata.get(a);
    }

    public Map<String, String> getAudioMetadata() {
        FrameGrabber a;
        return a.audioMetadata;
    }

    public int getMaxDelay() {
        FrameGrabber a;
        return a.maxDelay;
    }

    public Frame getDelayedFrame() throws InterruptedException, ExecutionException {
        FrameGrabber a;
        if (a.future == null) {
            return null;
        }
        FrameGrabber frameGrabber = a;
        frameGrabber.future.get();
        return frameGrabber.delayedFrame;
    }

    public void setFrameNumber(int n) throws Exception {
        int a = n;
        FrameGrabber a2 = this;
        a2.frameNumber = a;
    }

    public Map<String, String> getVideoMetadata() {
        FrameGrabber a;
        return a.videoMetadata;
    }

    public void setFrameRate(double a) {
        a.frameRate = a;
    }

    public void setVideoStream(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.videoStream = a;
    }

    public ImageMode getImageMode() {
        FrameGrabber a;
        return a.imageMode;
    }

    public void setAudioMetadata(Map<String, String> map) {
        Map<String, String> a = map;
        FrameGrabber a2 = this;
        a2.audioMetadata = a;
    }

    public void setBitsPerPixel(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.bpp = a;
    }

    public Buffer getAudioSideData(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.audioSideData.get(a);
    }

    public Map<String, String> getMetadata() {
        FrameGrabber a;
        return a.metadata;
    }

    public int getImageWidth() {
        FrameGrabber a;
        return a.imageWidth;
    }

    public void setVideoDisposition(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.videoDisposition = a;
    }

    /*
     * WARNING - void declaration
     */
    public void setAudioSideData(String string, Buffer buffer) {
        void a;
        Buffer a2 = buffer;
        FrameGrabber a3 = this;
        a3.audioSideData.put((String)a, a2);
    }

    /*
     * WARNING - void declaration
     */
    public static FrameGrabber create(Class<? extends FrameGrabber> class_, Class class_2, Object object) throws Exception {
        void a;
        Class a22 = class_2;
        Class<? extends FrameGrabber> a3 = class_;
        Throwable throwable = null;
        try {
            Class[] arrclass = new Class[1];
            arrclass[0] = a22;
            Object[] arrobject = new Object[1];
            arrobject[0] = a;
            return a3.getConstructor(arrclass).newInstance(arrobject);
        }
        catch (InstantiationException a22) {
            throwable = a22;
        }
        catch (IllegalAccessException a22) {
            throwable = a22;
        }
        catch (IllegalArgumentException a22) {
            throwable = a22;
        }
        catch (NoSuchMethodException a22) {
            throwable = a22;
        }
        catch (InvocationTargetException a22) {
            throwable = a22.getCause();
        }
        throw new Exception("Could not create new " + a3.getSimpleName() + "(" + String.valueOf(a) + ")", throwable);
    }

    public double getAspectRatio() {
        FrameGrabber a;
        return a.aspectRatio;
    }

    public void setAudioCodecName(String string) {
        String a = string;
        FrameGrabber a2 = this;
        a2.audioCodecName = a;
    }

    public String getOption(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.options.get(a);
    }

    public Map<String, Buffer> getAudioSideData() {
        FrameGrabber a;
        return a.audioSideData;
    }

    public void setSampleRate(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.sampleRate = a;
    }

    public void delayedGrab(long a) {
        FrameGrabber a2;
        a2.delayedFrame = null;
        a2.delayedTime = 0L;
        long l = System.nanoTime() / 1000L;
        if (a2.future != null && !a2.future.isDone()) {
            return;
        }
        a2.future = a2.executor.submit(new Callable<Void>(){
            final /* synthetic */ long val$delayTime;
            final /* synthetic */ long val$start;
            final /* synthetic */ FrameGrabber this$0;
            {
                FrameGrabber a = frameGrabber;
                1 a2 = this;
                a2.this$0 = a;
                a2.val$start = l;
                a2.val$delayTime = l2;
            }

            @Override
            public Void call() throws Exception {
                1 a;
                do {
                    a.this$0.delayedFrame = a.this$0.grab();
                    a.this$0.delayedTime = System.nanoTime() / 1000L - a.val$start;
                } while (a.this$0.delayedTime < a.val$delayTime);
                return null;
            }
        });
    }

    public void setVideoCodec(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.videoCodec = a;
    }

    public static Class<? extends FrameGrabber> get(String a) throws Exception {
        Object object = a;
        object = FrameGrabber.class.getPackage().getName() + "." + (String)object;
        try {
            return Class.forName((String)object).asSubclass(FrameGrabber.class);
        }
        catch (ClassNotFoundException classNotFoundException) {
            a = (String)object + "FrameGrabber";
            try {
                return Class.forName((String)a).asSubclass(FrameGrabber.class);
            }
            catch (ClassNotFoundException classNotFoundException2) {
                throw new Exception("Could not get FrameGrabber class for " + (String)object + " or " + (String)a, classNotFoundException);
            }
        }
    }

    static {
        String[] arrstring = new String[12];
        arrstring[0] = NpSocketClient.ALLATORIxDEMO("N\t<~#n");
        arrstring[1] = Setting.ALLATORIxDEMO("]4e\u001cz(r0>j");
        arrstring[2] = NpSocketClient.ALLATORIxDEMO("\u001ce0I+z>x?h");
        arrstring[3] = Setting.ALLATORIxDEMO("T(y1P1h /{");
        arrstring[4] = NpSocketClient.ALLATORIxDEMO("\u0015y,d\u0001c$h.nh");
        arrstring[5] = Setting.ALLATORIxDEMO("\ny>w\u000bc+?j");
        arrstring[6] = NpSocketClient.ALLATORIxDEMO("[,k&Y/c>h");
        arrstring[7] = Setting.ALLATORIxDEMO("K\u000b5\u00005j");
        arrstring[8] = NpSocketClient.ALLATORIxDEMO("_ n/e\u0003c=o.");
        arrstring[9] = Setting.ALLATORIxDEMO("T(c+\u000fY");
        arrstring[10] = NpSocketClient.ALLATORIxDEMO("L\f`==");
        arrstring[11] = Setting.ALLATORIxDEMO("U\u000fX9k >n");
        list = new LinkedList<String>(Arrays.asList(arrstring));
    }

    public void flush() throws Exception {
        FrameGrabber a;
        FrameGrabber frameGrabber = a;
        int n = a = 0;
        while (n < frameGrabber.numBuffers + 1) {
            frameGrabber.grab();
            n = ++a;
        }
    }

    public void setImageHeight(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.imageHeight = a;
    }

    public int getFrameNumber() {
        FrameGrabber a;
        return a.frameNumber;
    }

    public void setVideoBitrate(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.videoBitrate = a;
    }

    /*
     * WARNING - void declaration
     */
    public void setAudioOption(String string, String string2) {
        void a;
        String a2 = string2;
        FrameGrabber a3 = this;
        a3.audioOptions.put((String)a, a2);
    }

    public void setAspectRatio(double a) {
        a.aspectRatio = a;
    }

    public int getAudioDisposition() {
        FrameGrabber a;
        return a.audioDisposition;
    }

    public static void init() {
        Iterator<String> iterator = list.iterator();
        block2 : do {
            Iterator<String> iterator2 = iterator;
            while (iterator2.hasNext()) {
                String string = iterator.next();
                try {
                    FrameGrabber.get(string).getMethod(Setting.ALLATORIxDEMO(",n&W7g!"), new Class[0]).invoke(null, new Object[0]);
                }
                catch (Throwable throwable) {
                    iterator2 = iterator;
                    continue;
                }
                continue block2;
            }
            break;
        } while (true);
    }

    public int getSampleRate() {
        FrameGrabber a;
        return a.sampleRate;
    }

    public Array createArray(FrameGrabber[] arrframeGrabber) {
        FrameGrabber[] a = arrframeGrabber;
        FrameGrabber[] a2 = this;
        return new Array(a);
    }

    public void setVideoMetadata(Map<String, String> map) {
        Map<String, String> a = map;
        FrameGrabber a2 = this;
        a2.videoMetadata = a;
    }

    public abstract void trigger() throws Exception;

    public long getDelayedTime() throws InterruptedException, ExecutionException {
        FrameGrabber a;
        if (a.future == null) {
            return 0L;
        }
        FrameGrabber frameGrabber = a;
        frameGrabber.future.get();
        return frameGrabber.delayedTime;
    }

    public int getVideoBitrate() {
        FrameGrabber a;
        return a.videoBitrate;
    }

    public void setPixelFormat(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.pixelFormat = a;
    }

    public Frame grabFrame() throws Exception {
        FrameGrabber a;
        return a.grab();
    }

    public SampleMode getSampleMode() {
        FrameGrabber a;
        return a.sampleMode;
    }

    /*
     * WARNING - void declaration
     */
    public void setVideoSideData(String string, Buffer buffer) {
        void a;
        Buffer a2 = buffer;
        FrameGrabber a3 = this;
        a3.videoSideData.put((String)a, a2);
    }

    public static FrameGrabber createDefault(int a) throws Exception {
        try {
            return FrameGrabber.create(FrameGrabber.getDefault(), Integer.TYPE, a);
        }
        catch (Exception exception) {
            return FrameGrabber.create(FrameGrabber.getDefault(), Integer.class, a);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setVideoOption(String string, String string2) {
        void a;
        String a2 = string2;
        FrameGrabber a3 = this;
        a3.videoOptions.put((String)a, a2);
    }

    public void setOptions(Map<String, String> map) {
        Map<String, String> a = map;
        FrameGrabber a2 = this;
        a2.options = a;
    }

    public abstract void stop() throws Exception;

    public void setTriggerMode(boolean bl) {
        boolean a = bl;
        FrameGrabber a2 = this;
        a2.triggerMode = a;
    }

    public void setAudioCodec(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.audioCodec = a;
    }

    public void setAudioSideData(Map<String, Buffer> map) {
        Map<String, Buffer> a = map;
        FrameGrabber a2 = this;
        a2.audioSideData = a;
    }

    public boolean isDeinterlace() {
        FrameGrabber a;
        return a.deinterlace;
    }

    public void setSensorPattern(long a) {
        a.sensorPattern = a;
    }

    public int getLengthInFrames() {
        return 0;
    }

    public int getImageHeight() {
        FrameGrabber a;
        return a.imageHeight;
    }

    public String getVideoMetadata(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.videoMetadata.get(a);
    }

    public double getFrameRate() {
        FrameGrabber a;
        return a.frameRate;
    }

    public void setImageWidth(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.imageWidth = a;
    }

    public abstract Frame grab() throws Exception;

    public long getTimestamp() {
        FrameGrabber a;
        return a.timestamp;
    }

    public void setImageScalingFlags(int n) {
        int a = n;
        FrameGrabber a2 = this;
        a2.imageScalingFlags = a;
    }

    public static FrameGrabber create(String string, File file) throws Exception {
        File a = file;
        String a2 = string;
        return FrameGrabber.create(FrameGrabber.get(a2), File.class, a);
    }

    public static FrameGrabber create(String string, String string2) throws Exception {
        String a = string2;
        String a2 = string;
        return FrameGrabber.create(FrameGrabber.get(a2), String.class, a);
    }

    public void setImageMode(ImageMode imageMode) {
        Object a = imageMode;
        FrameGrabber a2 = this;
        a2.imageMode = a;
    }

    public long getSensorPattern() {
        FrameGrabber a;
        return a.sensorPattern;
    }

    public void resetStartTime() {
        a.startTime = 0L;
    }

    public String getAudioMetadata(String string) {
        String a = string;
        FrameGrabber a2 = this;
        return a2.audioMetadata.get(a);
    }

    public int getAudioStream() {
        FrameGrabber a;
        return a.audioStream;
    }

    public int getAudioBitrate() {
        FrameGrabber a;
        return a.audioBitrate;
    }

    public boolean isTriggerMode() {
        FrameGrabber a;
        return a.triggerMode;
    }

    public void setFormat(String string) {
        String a = string;
        FrameGrabber a2 = this;
        a2.format = a;
    }

    public FrameGrabber() {
        FrameGrabber a;
        FrameGrabber frameGrabber = a;
        FrameGrabber frameGrabber2 = a;
        FrameGrabber frameGrabber3 = a;
        FrameGrabber frameGrabber4 = a;
        FrameGrabber frameGrabber5 = a;
        FrameGrabber frameGrabber6 = a;
        FrameGrabber frameGrabber7 = a;
        FrameGrabber frameGrabber8 = a;
        FrameGrabber frameGrabber9 = a;
        FrameGrabber frameGrabber10 = a;
        FrameGrabber frameGrabber11 = a;
        FrameGrabber frameGrabber12 = a;
        FrameGrabber frameGrabber13 = a;
        FrameGrabber frameGrabber14 = a;
        FrameGrabber frameGrabber15 = a;
        FrameGrabber frameGrabber16 = a;
        FrameGrabber frameGrabber17 = a;
        FrameGrabber frameGrabber18 = a;
        frameGrabber18.videoStream = -1;
        frameGrabber18.audioStream = -1;
        frameGrabber17.videoDisposition = 0;
        frameGrabber17.audioDisposition = 0;
        frameGrabber16.format = null;
        frameGrabber16.videoCodecName = null;
        frameGrabber15.audioCodecName = null;
        frameGrabber15.imageWidth = 0;
        frameGrabber14.imageHeight = 0;
        frameGrabber14.audioChannels = 0;
        frameGrabber13.imageMode = ImageMode.COLOR;
        frameGrabber13.sensorPattern = -1L;
        frameGrabber12.pixelFormat = -1;
        frameGrabber12.videoBitrate = 0;
        frameGrabber11.imageScalingFlags = 0;
        frameGrabber11.aspectRatio = 0.0;
        frameGrabber10.frameRate = 0.0;
        frameGrabber10.sampleMode = SampleMode.SHORT;
        frameGrabber10.sampleFormat = -1;
        frameGrabber9.audioBitrate = 0;
        frameGrabber9.sampleRate = 0;
        frameGrabber8.triggerMode = 0;
        frameGrabber8.bpp = 0;
        frameGrabber7.timeout = 10000;
        frameGrabber7.numBuffers = 4;
        frameGrabber6.gamma = 0.0;
        frameGrabber6.deinterlace = false;
        frameGrabber5.charset = Charset.defaultCharset();
        FrameGrabber frameGrabber19 = a;
        frameGrabber19.options = new HashMap<String, String>();
        frameGrabber5.videoOptions = new HashMap<String, String>();
        frameGrabber5.audioOptions = new HashMap<String, String>();
        frameGrabber5.metadata = new HashMap<String, String>();
        frameGrabber5.videoMetadata = new HashMap<String, String>();
        frameGrabber5.audioMetadata = new HashMap<String, String>();
        frameGrabber4.videoSideData = new HashMap<String, Buffer>();
        frameGrabber4.audioSideData = new HashMap<String, Buffer>();
        frameGrabber4.frameNumber = 0;
        frameGrabber3.timestamp = 0L;
        frameGrabber3.maxDelay = -1;
        frameGrabber2.startTime = 0L;
        frameGrabber2.executor = Executors.newSingleThreadExecutor();
        frameGrabber2.future = null;
        frameGrabber.delayedFrame = null;
        frameGrabber.delayedTime = 0L;
    }

    public static final class ImageMode
    extends Enum<ImageMode> {
        public static final /* enum */ ImageMode GRAY;
        private static final /* synthetic */ ImageMode[] $VALUES;
        public static final /* enum */ ImageMode RAW;
        public static final /* enum */ ImageMode COLOR;

        static {
            COLOR = new ImageMode(NpSocketClient.ALLATORIxDEMO("\u0004C\u0000B\u001f"), 0);
            GRAY = new ImageMode(FileUtil.ALLATORIxDEMO("V,Q&"), 1);
            RAW = new ImageMode(NpSocketClient.ALLATORIxDEMO("\u001eL\u001a"), 2);
            $VALUES = ImageMode.$values();
        }

        public static ImageMode[] values() {
            return (ImageMode[])$VALUES.clone();
        }

        private static /* synthetic */ ImageMode[] $values() {
            ImageMode[] arrimageMode = new ImageMode[3];
            arrimageMode[0] = COLOR;
            arrimageMode[1] = GRAY;
            arrimageMode[2] = RAW;
            return arrimageMode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ ImageMode() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
            // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        public static ImageMode valueOf(String a) {
            return Enum.valueOf(ImageMode.class, a);
        }
    }

    public static final class SampleMode
    extends Enum<SampleMode> {
        public static final /* enum */ SampleMode RAW;
        public static final /* enum */ SampleMode FLOAT;
        private static final /* synthetic */ SampleMode[] $VALUES;
        public static final /* enum */ SampleMode SHORT;

        /*
         * Exception decompiling
         */
        private /* synthetic */ SampleMode() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
            // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        static {
            SHORT = new SampleMode(CrystalUtil.ALLATORIxDEMO("\bh\u001fs\u0005"), 0);
            FLOAT = new SampleMode(SocketClient.ALLATORIxDEMO("Bf@jZ"), 1);
            RAW = new SampleMode(CrystalUtil.ALLATORIxDEMO("\u0002`\u0006"), 2);
            $VALUES = SampleMode.$values();
        }

        public static SampleMode[] values() {
            return (SampleMode[])$VALUES.clone();
        }

        private static /* synthetic */ SampleMode[] $values() {
            SampleMode[] arrsampleMode = new SampleMode[3];
            arrsampleMode[0] = SHORT;
            arrsampleMode[1] = FLOAT;
            arrsampleMode[2] = RAW;
            return arrsampleMode;
        }

        public static SampleMode valueOf(String a) {
            return Enum.valueOf(SampleMode.class, a);
        }
    }

    public static class Exception
    extends IOException {
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
            super(a);
        }
    }

    public static class Array {
        private Frame[] grabbedFrames;
        protected FrameGrabber[] frameGrabbers;
        private long[] bestLatencies;
        private long lastNewestTimestamp;
        private long[] latencies;
        private long bestInterval;

        public void release() throws Exception {
            Array a;
            Array array = a;
            FrameGrabber[] arrframeGrabber = array.frameGrabbers;
            int n = arrframeGrabber.length;
            int n2 = a = 0;
            while (n2 < n) {
                arrframeGrabber[a++].release();
                n2 = a;
            }
        }

        public void stop() throws Exception {
            Array a;
            Array array = a;
            FrameGrabber[] arrframeGrabber = array.frameGrabbers;
            int n = arrframeGrabber.length;
            int n2 = a = 0;
            while (n2 < n) {
                arrframeGrabber[a++].stop();
                n2 = a;
            }
        }

        public FrameGrabber[] getFrameGrabbers() {
            Array a;
            return a.frameGrabbers;
        }

        public void setFrameGrabbers(FrameGrabber[] arrframeGrabber) {
            FrameGrabber[] a;
            FrameGrabber[] a2 = arrframeGrabber;
            FrameGrabber[] arrframeGrabber2 = a = this;
            arrframeGrabber2.frameGrabbers = a2;
            arrframeGrabber2.grabbedFrames = new Frame[a2.length];
            a.latencies = new long[a2.length];
            FrameGrabber[] arrframeGrabber3 = a;
            arrframeGrabber3.bestLatencies = null;
            arrframeGrabber3.lastNewestTimestamp = 0L;
        }

        protected Array(FrameGrabber[] arrframeGrabber) {
            FrameGrabber[] a;
            FrameGrabber[] a2 = arrframeGrabber;
            FrameGrabber[] arrframeGrabber2 = a = this;
            FrameGrabber[] arrframeGrabber3 = a;
            a.grabbedFrames = null;
            arrframeGrabber3.latencies = null;
            arrframeGrabber3.bestLatencies = null;
            arrframeGrabber2.lastNewestTimestamp = 0L;
            arrframeGrabber2.bestInterval = Long.MAX_VALUE;
            a.frameGrabbers = null;
            a.setFrameGrabbers(a2);
        }

        public Frame[] grab() throws Exception {
            int n;
            Array a2;
            int a2;
            Array array;
            Array array2 = a2;
            if (array2.frameGrabbers.length == 1) {
                Array array3 = array2;
                array2.grabbedFrames[0] = array3.frameGrabbers[0].grab();
                return array3.grabbedFrames;
            }
            long l = 0L;
            int n2 = 0;
            int n3 = a2 = 0;
            while (n3 < array2.frameGrabbers.length) {
                Array array4 = array2;
                array2.grabbedFrames[a2] = array4.frameGrabbers[a2].grab();
                if (array4.grabbedFrames[a2] != null) {
                    l = Math.max(l, array2.frameGrabbers[a2].getTimestamp());
                }
                if (array2.frameGrabbers[a2].getClass() != array2.frameGrabbers[(a2 + 1) % array2.frameGrabbers.length].getClass()) {
                    n2 = 1;
                }
                n3 = ++a2;
            }
            if (n2 != 0) {
                return array2.grabbedFrames;
            }
            int n4 = a2 = 0;
            while (n4 < array2.frameGrabbers.length) {
                if (array2.grabbedFrames[a2] != null) {
                    array2.latencies[a2] = l - Math.max(0L, array2.frameGrabbers[a2].getTimestamp());
                }
                n4 = ++a2;
            }
            if (array2.bestLatencies == null) {
                array2.bestLatencies = Arrays.copyOf(array2.latencies, array2.latencies.length);
                array = array2;
            } else {
                a2 = 0;
                n2 = 0;
                int n5 = n = 0;
                while (n5 < array2.frameGrabbers.length) {
                    a2 = (int)((long)a2 + array2.latencies[n]);
                    long l2 = array2.bestLatencies[n];
                    n2 = (int)((long)n2 + l2);
                    n5 = ++n;
                }
                if (a2 < n2) {
                    array2.bestLatencies = Arrays.copyOf(array2.latencies, array2.latencies.length);
                }
                array = array2;
            }
            array.bestInterval = Math.min(array2.bestInterval, l - array2.lastNewestTimestamp);
            int n6 = a2 = 0;
            while (n6 < array2.bestLatencies.length) {
                Array array5 = array2;
                int n7 = a2++;
                array5.bestLatencies[n7] = Math.min(array5.bestLatencies[n7], array2.bestInterval * 9L / 10L);
                n6 = a2;
            }
            int n8 = a2 = 0;
            while (n8 < 2) {
                int n9 = n2 = 0;
                while (n9 < array2.frameGrabbers.length) {
                    if (!array2.frameGrabbers[n2].isTriggerMode() && array2.grabbedFrames[n2] != null) {
                        n = (int)(l - Math.max(0L, array2.frameGrabbers[n2].getTimestamp()));
                        while ((double)((long)n - array2.bestLatencies[n2]) > 0.1 * (double)array2.bestLatencies[n2]) {
                            Array array6 = array2;
                            array2.grabbedFrames[n2] = array6.frameGrabbers[n2].grab();
                            if (array6.grabbedFrames[n2] == null) break;
                            n = (int)(l - Math.max(0L, array2.frameGrabbers[n2].getTimestamp()));
                            if (n >= 0) continue;
                            l = Math.max(0L, array2.frameGrabbers[n2].getTimestamp());
                            break;
                        }
                    }
                    n9 = ++n2;
                }
                n8 = ++a2;
            }
            array2.lastNewestTimestamp = l;
            return array2.grabbedFrames;
        }

        public int size() {
            Array a;
            return a.frameGrabbers.length;
        }

        public void start() throws Exception {
            Array a;
            Array array = a;
            FrameGrabber[] arrframeGrabber = array.frameGrabbers;
            int n = arrframeGrabber.length;
            int n2 = a = 0;
            while (n2 < n) {
                arrframeGrabber[a++].start();
                n2 = a;
            }
        }

        public void trigger() throws Exception {
            Array a;
            Array array = a;
            FrameGrabber[] arrframeGrabber = array.frameGrabbers;
            int n = arrframeGrabber.length;
            int n2 = a = 0;
            while (n2 < n) {
                FrameGrabber frameGrabber = arrframeGrabber[a];
                if (frameGrabber.isTriggerMode()) {
                    frameGrabber.trigger();
                }
                n2 = ++a;
            }
        }
    }

    public static class PropertyEditor
    extends PropertyEditorSupport {
        @Override
        public String getAsText() {
            Class a;
            PropertyEditor propertyEditor = a;
            a = (Class)propertyEditor.getValue();
            if (a == null) {
                return BOEntityUtils.ALLATORIxDEMO("rEmA");
            }
            return a.getSimpleName().split(FPSManager.ALLATORIxDEMO("~,k\u0001H\fn\u001bc\u0005h\u0019"))[0];
        }

        @Override
        public String[] getTags() {
            return list.toArray(new String[list.size()]);
        }

        public PropertyEditor() {
            PropertyEditor a;
        }

        @Override
        public void setAsText(String string) {
            String a22 = string;
            PropertyEditor a = this;
            if (a22 == null) {
                a.setValue(null);
            }
            try {
                a.setValue(FrameGrabber.get(a22));
                return;
            }
            catch (Exception a22) {
                throw new IllegalArgumentException(a22);
            }
        }
    }

}
