/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

public class CanvasFrame
extends JFrame {
    protected double initialScale;
    public static CanvasFrame global = null;
    private Java2DFrameConverter converter;
    private BufferedImage buffer;
    public static final long DEFAULT_LATENCY = 200L;
    protected Canvas canvas;
    private KeyEvent keyEvent;
    private KeyEventDispatcher keyEventDispatch;
    private Color color;
    private long latency;
    protected double inverseGamma;
    private Image image;
    protected boolean needInitialResize;

    public static double getGamma(int a2) {
        int n = a2;
        GraphicsDevice[] a2 = CanvasFrame.getScreenDevices();
        if (n >= 0 && n < a2.length) {
            return CanvasFrame.getGamma(a2[n]);
        }
        return 0.0;
    }

    public static double getDefaultGamma() {
        return CanvasFrame.getGamma(CanvasFrame.getDefaultScreenDevice());
    }

    protected void initCanvas(boolean bl, DisplayMode displayMode, double d) {
        CanvasFrame a;
        CanvasFrame canvasFrame;
        boolean a2 = bl;
        CanvasFrame canvasFrame2 = a = this;
        a.canvas = new Canvas(a){
            final /* synthetic */ CanvasFrame this$0;
            {
                Component a = canvasFrame;
                2 a2 = this;
                a2.this$0 = a;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void paint(Graphics a) {
                var2_4 = a;
                try {
                    if (var2_4.this$0.canvas.getWidth() <= 0) return;
                    if (var2_4.this$0.canvas.getHeight() <= 0) {
                        return;
                    }
                    a = var2_4.this$0.canvas.getBufferStrategy();
                    do lbl-1000: // 3 sources:
                    {
                        a = a.getDrawGraphics();
                        if (var2_4.this$0.color != null) {
                            v0 = a;
                            v0.setColor(var2_4.this$0.color);
                            v0.fillRect(0, 0, var2_4.getWidth(), var2_4.getHeight());
                        }
                        if (var2_4.this$0.image != null) {
                            a.drawImage(var2_4.this$0.image, 0, 0, var2_4.getWidth(), var2_4.getHeight(), null);
                        }
                        if (var2_4.this$0.buffer != null) {
                            a.drawImage(var2_4.this$0.buffer, 0, 0, var2_4.getWidth(), var2_4.getHeight(), null);
                        }
                        a.dispose();
                        if (a.contentsRestored()) ** GOTO lbl-1000
                        v1 = a;
                        v1.show();
                    } while (v1.contentsLost());
                    return;
                }
                catch (NullPointerException a) {
                    return;
                }
                catch (IllegalStateException a) {
                    return;
                }
            }

            @Override
            public void update(Graphics graphics) {
                Graphics a = graphics;
                2 a2 = this;
                a2.paint(a);
            }
        };
        if (a2) {
            CanvasFrame canvasFrame3 = a;
            canvasFrame = canvasFrame3;
            canvasFrame3.canvas.setSize(a.getSize());
            canvasFrame3.needInitialResize = false;
        } else {
            canvasFrame = a;
            a.canvas.setSize(10, 10);
            a.needInitialResize = true;
        }
        canvasFrame.getContentPane().add(a.canvas);
        CanvasFrame canvasFrame4 = a;
        canvasFrame4.canvas.setVisible(true);
        canvasFrame4.canvas.createBufferStrategy(2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void tile(CanvasFrame[] a) {
        CanvasFrame[] arrcanvasFrame = a;
        class MovedListener
        extends ComponentAdapter {
            boolean moved = false;

            MovedListener() {
                MovedListener a;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void componentMoved(ComponentEvent a) {
                Serializable a2;
                MovedListener movedListener = a2;
                movedListener.moved = true;
                a = ((ComponentEvent)a).getComponent();
                a2 = a;
                synchronized (a) {
                    a.notify();
                    // ** MonitorExit[a] (shouldn't be in output)
                    return;
                }
            }
        }
        MovedListener movedListener = new MovedListener();
        int n = (int)Math.round(Math.sqrt(arrcanvasFrame.length));
        if (n * n < arrcanvasFrame.length) {
            ++n;
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = a = 0;
        while (n5 < arrcanvasFrame.length) {
            CanvasFrame[] arrcanvasFrame2;
            int n6 = a;
            int n7 = n2;
            Object object = n3;
            try {
                MovedListener movedListener2 = movedListener;
                movedListener.moved = false;
                EventQueue.invokeLater(new Runnable(){
                    final /* synthetic */ int val$y;
                    final /* synthetic */ CanvasFrame[] val$frames;
                    final /* synthetic */ int val$n;
                    final /* synthetic */ MovedListener val$movedListener;
                    final /* synthetic */ int val$x;

                    @Override
                    public void run() {
                        5 a;
                        5 v0 = a;
                        5 v1 = a;
                        v0.val$frames[v0.val$n].addComponentListener(v1.val$movedListener);
                        5 v2 = a;
                        v1.val$frames[a.val$n].setLocation(v2.val$x, v2.val$y);
                    }
                    {
                        void a;
                        5 var5_7;
                        int n4 = n3;
                        5 v0 = var5_7 = this;
                        var5_7.val$frames = arrcanvasFrame;
                        v0.val$n = n;
                        v0.val$movedListener = movedListener;
                        var5_7.val$x = n2;
                        var5_7.val$y = a;
                    }
                });
                for (n7 = (int)(false ? 1 : 0); !movedListener2.moved && n7 < 5; ++n7) {
                    CanvasFrame canvasFrame = arrcanvasFrame[n6];
                    object = canvasFrame;
                    // MONITORENTER : canvasFrame
                    arrcanvasFrame[n6].wait(100L);
                    // MONITOREXIT : object
                    {
                        movedListener2 = movedListener;
                        continue;
                    }
                }
                EventQueue.invokeLater(new Runnable(){
                    final /* synthetic */ MovedListener val$movedListener;
                    final /* synthetic */ int val$n;
                    final /* synthetic */ CanvasFrame[] val$frames;

                    @Override
                    public void run() {
                        6 a;
                        6 v0 = a;
                        v0.val$frames[v0.val$n].removeComponentListener(a.val$movedListener);
                    }
                    {
                        Object a = object;
                        object = this;
                        object.val$frames = arrcanvasFrame;
                        object.val$n = n;
                        object.val$movedListener = a;
                        object();
                    }
                });
                arrcanvasFrame2 = arrcanvasFrame;
            }
            catch (java.lang.Exception exception) {
                arrcanvasFrame2 = arrcanvasFrame;
            }
            n2 = arrcanvasFrame2[a].getX() + arrcanvasFrame[a].getWidth();
            n4 = Math.max(n4, arrcanvasFrame[a].getY() + arrcanvasFrame[a].getHeight());
            if ((a + 1) % n == 0) {
                n2 = 0;
                n3 = n4;
            }
            n5 = ++a;
        }
    }

    public void releaseGraphics(Graphics2D graphics2D) {
        Graphics2D a = graphics2D;
        CanvasFrame a2 = this;
        a.dispose();
        a2.canvas.paint(null);
    }

    /*
     * WARNING - void declaration
     */
    public CanvasFrame(String string, int n, DisplayMode displayMode, double d) throws Exception {
        CanvasFrame a;
        void a2;
        void a3;
        void a4;
        DisplayMode a5 = displayMode;
        CanvasFrame canvasFrame = a = this;
        CanvasFrame canvasFrame2 = a;
        CanvasFrame canvasFrame3 = a;
        CanvasFrame canvasFrame4 = a;
        super((String)a4, CanvasFrame.getScreenDevice((int)a3).getDefaultConfiguration());
        canvasFrame4.latency = 200L;
        canvasFrame4.keyEvent = null;
        CanvasFrame canvasFrame5 = a;
        canvasFrame4.keyEventDispatch = new KeyEventDispatcher(a){
            final /* synthetic */ CanvasFrame this$0;

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean dispatchKeyEvent(KeyEvent a) {
                CanvasFrame a2;
                3 var2_2 = a2;
                if (a.getID() == 401) {
                    a2 = var2_2.this$0;
                    synchronized (a2) {
                        var2_2.this$0.keyEvent = a;
                        var2_2.this$0.notify();
                    }
                }
                return false;
            }
            {
                CanvasFrame a = canvasFrame;
                3 a2 = this;
                a2.this$0 = a;
            }
        };
        canvasFrame3.canvas = null;
        canvasFrame3.needInitialResize = false;
        canvasFrame2.initialScale = 1.0;
        canvasFrame2.inverseGamma = 1.0;
        canvasFrame.color = null;
        canvasFrame.image = null;
        a.buffer = null;
        a.converter = new Java2DFrameConverter();
        a.init(true, a5, (double)a2);
    }

    /*
     * WARNING - void declaration
     */
    public CanvasFrame(String string, GraphicsConfiguration graphicsConfiguration) {
        void a;
        GraphicsConfiguration a2 = graphicsConfiguration;
        CanvasFrame a3 = this;
        a3((String)a, a2, 0.0);
    }

    /*
     * WARNING - void declaration
     */
    public CanvasFrame(String string, GraphicsConfiguration graphicsConfiguration, double d) {
        CanvasFrame a;
        void a2;
        void a3;
        GraphicsConfiguration a4 = graphicsConfiguration;
        CanvasFrame canvasFrame = a = this;
        CanvasFrame canvasFrame2 = a;
        CanvasFrame canvasFrame3 = a;
        CanvasFrame canvasFrame4 = a;
        super((String)a3, a4);
        canvasFrame4.latency = 200L;
        canvasFrame4.keyEvent = null;
        CanvasFrame canvasFrame5 = a;
        canvasFrame4.keyEventDispatch = new /* invalid duplicate definition of identical inner class */;
        canvasFrame3.canvas = null;
        canvasFrame3.needInitialResize = false;
        canvasFrame2.initialScale = 1.0;
        canvasFrame2.inverseGamma = 1.0;
        canvasFrame.color = null;
        canvasFrame.image = null;
        a.buffer = null;
        a.converter = new Java2DFrameConverter();
        a.init(false, null, (double)a2);
    }

    public long getLatency() {
        CanvasFrame a;
        return a.latency;
    }

    public CanvasFrame(String string) {
        String a = string;
        CanvasFrame a2 = this;
        a2(a, 0.0);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void init(boolean bl, DisplayMode displayMode, double d) {
        void a;
        void a2;
        boolean a222 = bl;
        CanvasFrame a3 = this;
        Runnable a222 = new Runnable(){
            final /* synthetic */ double val$gamma;
            final /* synthetic */ boolean val$fullScreen;
            final /* synthetic */ CanvasFrame this$0;
            final /* synthetic */ DisplayMode val$displayMode;

            @Override
            public void run() {
                DisplayMode displayMode;
                DisplayMode a;
                1 var2_1 = a;
                KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(var2_1.this$0.keyEventDispatch);
                1 v0 = var2_1;
                GraphicsDevice graphicsDevice = v0.this$0.getGraphicsConfiguration().getDevice();
                a = graphicsDevice.getDisplayMode();
                DisplayMode displayMode2 = null;
                if (v0.val$displayMode != null && a != null) {
                    int n;
                    int n2;
                    int n3;
                    int n4;
                    int n5;
                    int n6;
                    1 v1 = var2_1;
                    int n7 = v1.val$displayMode.getWidth();
                    int n8 = v1.val$displayMode.getHeight();
                    int n9 = v1.val$displayMode.getBitDepth();
                    int n10 = v1.val$displayMode.getRefreshRate();
                    if (n7 > 0) {
                        n3 = n7;
                        n = n8;
                    } else {
                        n3 = a.getWidth();
                        n = n8;
                    }
                    if (n > 0) {
                        n2 = n8;
                        n5 = n9;
                    } else {
                        n2 = a.getHeight();
                        n5 = n9;
                    }
                    if (n5 > 0) {
                        n6 = n9;
                        n4 = n10;
                    } else {
                        n6 = a.getBitDepth();
                        n4 = n10;
                    }
                    displayMode2 = new DisplayMode(n3, n2, n6, n4 > 0 ? n10 : a.getRefreshRate());
                }
                1 v8 = var2_1;
                if (var2_1.val$fullScreen) {
                    v8.this$0.setUndecorated(true);
                    displayMode = displayMode2;
                    1 v10 = var2_1;
                    v10.this$0.getRootPane().setWindowDecorationStyle(0);
                    v10.this$0.setResizable(false);
                    graphicsDevice.setFullScreenWindow(v10.this$0);
                } else {
                    v8.this$0.setLocationByPlatform(true);
                    displayMode = displayMode2;
                }
                if (displayMode != null && !displayMode2.equals(a)) {
                    graphicsDevice.setDisplayMode(displayMode2);
                }
                double d = var2_1.val$gamma == 0.0 ? CanvasFrame.getGamma(graphicsDevice) : var2_1.val$gamma;
                var2_1.this$0.inverseGamma = d == 0.0 ? 1.0 : 1.0 / d;
                1 v11 = var2_1;
                v11.this$0.setVisible(true);
                1 v12 = var2_1;
                v11.this$0.initCanvas(v12.val$fullScreen, v12.val$displayMode, var2_1.val$gamma);
            }
            {
                1 var3_5;
                void a;
                boolean a2 = bl;
                1 v0 = var3_5 = this;
                v0.this$0 = a;
                v0.val$displayMode = displayMode;
                var3_5.val$fullScreen = a2;
                var3_5.val$gamma = d;
            }
        };
        if (EventQueue.isDispatchThread()) {
            a222.run();
            return;
        }
        try {
            EventQueue.invokeAndWait(a222);
            return;
        }
        catch (java.lang.Exception exception) {
            return;
        }
    }

    public void showImage(Image image) {
        Image a = image;
        CanvasFrame a2 = this;
        if (a == null) {
            return;
        }
        if (a2.isResizable() && a2.needInitialResize) {
            Object object = a;
            int n = (int)Math.round((double)((Image)object).getWidth(null) * a2.initialScale);
            CanvasFrame canvasFrame = a2;
            int n2 = (int)Math.round((double)((Image)object).getHeight(null) * canvasFrame.initialScale);
            canvasFrame.setCanvasSize(n, n2);
        }
        CanvasFrame canvasFrame = a2;
        canvasFrame.color = null;
        canvasFrame.image = a;
        a2.canvas.paint(null);
    }

    public void setCanvasScale(double a) {
        CanvasFrame a2;
        CanvasFrame canvasFrame = a2;
        canvasFrame.initialScale = a;
        canvasFrame.needInitialResize = true;
    }

    public static GraphicsDevice getScreenDevice(int a2) throws Exception {
        int n = a2;
        GraphicsDevice[] a2 = CanvasFrame.getScreenDevices();
        if (n >= a2.length) {
            throw new Exception("CanvasFrame Error: Screen number " + n + " not found. There are only " + a2.length + " screens.");
        }
        return a2[n];
    }

    public KeyEvent waitKey() throws InterruptedException {
        CanvasFrame a;
        return a.waitKey(0);
    }

    public static GraphicsDevice[] getScreenDevices() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
    }

    /*
     * WARNING - void declaration
     */
    public CanvasFrame(String string, int n, DisplayMode displayMode) throws Exception {
        void a;
        void a2;
        DisplayMode a3 = displayMode;
        CanvasFrame a4 = this;
        a4((String)a2, (int)a, a3, 0.0);
    }

    public void waitLatency() throws InterruptedException {
        CanvasFrame a;
        Thread.sleep(a.getLatency());
    }

    public void setLatency(long a) {
        a.latency = a;
    }

    public static DisplayMode getDisplayMode(int a2) {
        int n = a2;
        GraphicsDevice[] a2 = CanvasFrame.getScreenDevices();
        if (n >= 0 && n < a2.length) {
            return a2[n].getDisplayMode();
        }
        return null;
    }

    public static GraphicsDevice getDefaultScreenDevice() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    }

    public static double getGamma(GraphicsDevice a) {
        GraphicsDevice graphicsDevice = a;
        a = graphicsDevice.getDefaultConfiguration().getColorModel().getColorSpace();
        if (((ColorSpace)a).isCS_sRGB()) {
            return 2.2;
        }
        try {
            return ((ICC_ProfileRGB)((ICC_ColorSpace)a).getProfile()).getGamma(0);
        }
        catch (RuntimeException runtimeException) {
            return 0.0;
        }
    }

    public Graphics2D createGraphics() {
        BufferedImage a;
        CanvasFrame canvasFrame = a;
        if (canvasFrame.buffer == null || canvasFrame.buffer.getWidth() != canvasFrame.canvas.getWidth() || canvasFrame.buffer.getHeight() != canvasFrame.canvas.getHeight()) {
            CanvasFrame canvasFrame2 = canvasFrame;
            a = canvasFrame2.canvas.getGraphicsConfiguration().createCompatibleImage(canvasFrame.canvas.getWidth(), canvasFrame.canvas.getHeight(), 3);
            if (canvasFrame2.buffer != null) {
                Graphics graphics = a.getGraphics();
                graphics.drawImage(canvasFrame.buffer, 0, 0, null);
                graphics.dispose();
            }
            canvasFrame.buffer = a;
        }
        return canvasFrame.buffer.createGraphics();
    }

    public void showImage(Frame frame) {
        Frame a = frame;
        CanvasFrame a2 = this;
        a2.showImage(a, false);
    }

    /*
     * WARNING - void declaration
     */
    public CanvasFrame(String string, double d) {
        CanvasFrame a;
        void a2;
        String a3 = string;
        CanvasFrame canvasFrame = a = this;
        CanvasFrame canvasFrame2 = a;
        CanvasFrame canvasFrame3 = a;
        CanvasFrame canvasFrame4 = a;
        super(a3);
        canvasFrame4.latency = 200L;
        canvasFrame4.keyEvent = null;
        CanvasFrame canvasFrame5 = a;
        canvasFrame4.keyEventDispatch = new /* invalid duplicate definition of identical inner class */;
        canvasFrame3.canvas = null;
        canvasFrame3.needInitialResize = false;
        canvasFrame2.initialScale = 1.0;
        canvasFrame2.inverseGamma = 1.0;
        canvasFrame.color = null;
        canvasFrame.image = null;
        a.buffer = null;
        a.converter = new Java2DFrameConverter();
        a.init(false, null, (double)a2);
    }

    public Dimension getCanvasSize() {
        CanvasFrame a;
        return a.canvas.getSize();
    }

    public double getCanvasScale() {
        CanvasFrame a;
        return a.initialScale;
    }

    public Canvas getCanvas() {
        CanvasFrame a;
        return a.canvas;
    }

    public static String[] getScreenDescriptions() {
        int n;
        GraphicsDevice[] arrgraphicsDevice = CanvasFrame.getScreenDevices();
        String[] arrstring = new String[arrgraphicsDevice.length];
        int n2 = n = 0;
        while (n2 < arrgraphicsDevice.length) {
            int n3 = n++;
            arrstring[n3] = arrgraphicsDevice[n3].getIDstring();
            n2 = n;
        }
        return arrstring;
    }

    public void showColor(Color color) {
        Serializable a = color;
        CanvasFrame a2 = this;
        a2.color = a;
        a2.image = null;
        a2.canvas.paint(null);
    }

    public synchronized KeyEvent waitKey(int n) throws InterruptedException {
        int a22 = n;
        CanvasFrame a = this;
        if (a22 >= 0) {
            a.keyEvent = null;
            a.wait(a22);
        }
        KeyEvent a22 = a.keyEvent;
        a.keyEvent = null;
        return a22;
    }

    /*
     * WARNING - void declaration
     */
    public void setCanvasSize(int n, int n2) {
        void a;
        int a22 = n;
        CanvasFrame a3 = this;
        Dimension dimension = a3.getCanvasSize();
        if (dimension.width == a22 && dimension.height == a) {
            return;
        }
        Runnable a22 = new Runnable(){
            final /* synthetic */ int val$width;
            final /* synthetic */ CanvasFrame this$0;
            final /* synthetic */ int val$height;

            @Override
            public void run() {
                4 a;
                4 v0 = a;
                v0.this$0.setExtendedState(0);
                4 v1 = a;
                v0.this$0.canvas.setSize(a.val$width, v1.val$height);
                v1.this$0.pack();
                v0.this$0.canvas.setSize(a.val$width + 1, a.val$height + 1);
                4 v2 = a;
                v0.this$0.canvas.setSize(v2.val$width, v2.val$height);
                v0.this$0.needInitialResize = false;
            }
            {
                void a;
                int a2 = n2;
                4 var3_5 = this;
                var3_5.this$0 = a;
                var3_5.val$width = n;
                var3_5.val$height = a2;
            }
        };
        if (EventQueue.isDispatchThread()) {
            a22.run();
            return;
        }
        try {
            EventQueue.invokeAndWait(a22);
            return;
        }
        catch (java.lang.Exception exception) {
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void showImage(Frame frame, boolean bl) {
        boolean bl2;
        double d;
        CanvasFrame a;
        void a2;
        boolean a3 = bl;
        CanvasFrame canvasFrame = a = this;
        void v1 = a2;
        if (Java2DFrameConverter.getBufferedImageType((Frame)v1) == 0) {
            d = 1.0;
            bl2 = a3;
        } else {
            d = a.inverseGamma;
            bl2 = a3;
        }
        canvasFrame.showImage(canvasFrame.converter.getBufferedImage((Frame)v1, d, bl2, null));
    }

    public static class Exception
    extends java.lang.Exception {
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

}
