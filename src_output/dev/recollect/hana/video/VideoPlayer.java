/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  net.minecraft.class_289
 *  net.minecraft.class_761
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.video;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.video.Renderer;
import java.io.File;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import net.minecraft.class_289;
import net.minecraft.class_761;
import org.bytedeco.javacv.BaseChildSettings;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.lwjgl.opengl.GL11;

public class VideoPlayer {
    private static boolean flag;
    private static Renderer renderer;
    private static class_761 worldRenderer;
    private static class_289 tessellator;
    private static FFmpegFrameGrabber frameGrabber;
    private static double frameRate;
    private static int ticks;
    private static boolean stopped;
    private static boolean initialized;
    public static boolean suspended;
    private static long time;

    public VideoPlayer() {
        VideoPlayer a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void stop() {
        if (stopped) {
            return;
        }
        Class<VideoPlayer> class_ = VideoPlayer.class;
        synchronized (VideoPlayer.class) {
            tessellator = null;
            renderer = null;
            time = 0L;
            ticks = 0;
            try {
                frameGrabber.stop();
                frameGrabber.release();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            frameGrabber = null;
            stopped = true;
            initialized = false;
            // ** MonitorExit[var0] (shouldn't be in output)
            return;
        }
    }

    private static /* synthetic */ Thread getThread() {
        Thread thread = new Thread(BaseChildSettings.ALLATORIxDEMO("}6^+uNd3_#L-@.D:")){
            {
                String a = string;
                1 a2 = this;
                super(a);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                1 a22;
                1 var1_2 = a22;
                try {
                    do {
                        a22 = var1_2;
                        synchronized (a22) {
                            if (!flag || (double)(System.currentTimeMillis() - time) > 700.0 / frameRate && !suspended) {
                                VideoPlayer.doGetBuffer();
                            }
                            if (time == 0L) {
                                return;
                            }
                        }
                    } while (true);
                }
                catch (Exception a22) {
                    a22.printStackTrace();
                    var1_2.interrupt();
                    return;
                }
            }
        };
        thread.setDaemon(true);
        return thread;
    }

    static {
        suspended = false;
        stopped = false;
        initialized = false;
    }

    public static void render(int n, int n2) {
        int a = n2;
        int a2 = n;
        if (!stopped) {
            if (renderer != null) {
                suspended = false;
                renderer.onDrawFrame();
                GlStateManager._enableBlend();
                GL11.glDisable((int)2929);
                GL11.glEnable((int)3042);
                GlStateManager._enableBlend();
                GlStateManager._clearColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager._disableBlend();
                GL11.glMatrixMode((int)5889);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glMatrixMode((int)5888);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                tessellator.method_1350();
                GL11.glMatrixMode((int)5889);
                GL11.glPopMatrix();
                GL11.glMatrixMode((int)5888);
                GL11.glPopMatrix();
                GL11.glEnable((int)2929);
                GlStateManager._disableBlend();
                Render2DUtil.resetColor();
                return;
            }
            System.err.println(BaseChildSettings.ALLATORIxDEMO("\u001aO0O:J)\u00124U;\u000b1X5MuF#P?E8\r+_ \u0004qT;A<\u000etf5\t`Q-K:P?_6N;@yy\u0015\u0007;K(NG4w\u0006G2\u000f4EcE0Hh^-N1\u00007K2G:Xf"));
        }
    }

    public static void init(File a) {
        File file = a;
        if (initialized) {
            System.out.println(ProjectionUtils.ALLATORIxDEMO("{\u0002D\u0003N7G\f\u0013I`tL\u0007R\u0003@\u0003RM}<A\u001aL\u0002Q\u0012[\u0002R^"));
            return;
        }
        System.out.println("Initializing VideoPlayer with file: " + file.getAbsolutePath());
        if (!file.exists()) {
            System.err.println("Video file does not exist: " + file.getAbsolutePath());
            return;
        }
        frameGrabber = new FFmpegFrameGrabber(file.getPath());
        frameGrabber.setPixelFormat(2);
        frameGrabber.setOption(BaseChildSettings.ALLATORIxDEMO("K<G8B%_\""), ProjectionUtils.ALLATORIxDEMO("\nT\u000eS\u0004"));
        try {
            frameGrabber.start();
            double d = frameGrabber.getFrameRate();
            System.out.println("Frame rate: " + d);
            while ((a = frameGrabber.grab()) != null && ((Frame)a).image == null) {
            }
            if (a != null) {
                renderer = new Renderer();
                tessellator = class_289.method_1348();
                Object object = a;
                renderer.setBuffer((ByteBuffer)((Frame)a).image[0], ((Frame)object).imageWidth, ((Frame)object).imageHeight);
                time = System.currentTimeMillis();
                ticks = 0;
                flag = false;
                stopped = false;
                VideoPlayer.getThread().start();
                System.out.println(BaseChildSettings.ALLATORIxDEMO("s0\u000ep}\u001eB!\n7E6U<\u0006K,J?\u00170^<_-T F!K?C`"));
                initialized = true;
                return;
            }
            System.err.println(ProjectionUtils.ALLATORIxDEMO("n\u000fH\u000bB\u0005\u0010\u0002\u0005\fE\u0004L\u0017C\rI\n\u0010I\u0012\u0006H\u0005D\u0003S\u0002YWJb}t[\nL\u000fEGM\u001fu?MNB\u0011\\\u0019C\u0002R^"));
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Initialization failed: " + exception.getMessage());
            return;
        }
    }

    private static /* synthetic */ void doGetBuffer() throws Exception {
        int n = frameGrabber.getLengthInFrames() - 5;
        if (ticks < n) {
            Frame frame = frameGrabber.grab();
            if (frame != null && frame.image != null) {
                if (renderer != null) {
                    Frame frame2 = frame;
                    renderer.setBuffer((ByteBuffer)frame.image[0], frame2.imageWidth, frame2.imageHeight);
                    time = System.currentTimeMillis();
                    ++ticks;
                } else {
                    System.err.println(ProjectionUtils.ALLATORIxDEMO("?q<L\u000bW\u0006O[\u670b\u527a\u59fd\u5366"));
                }
            }
        } else {
            ticks = 0;
            frameGrabber.setFrameNumber(0);
        }
        if (!flag) {
            flag = true;
        }
    }

}
