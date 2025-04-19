/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.DisplayMode;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import javax.swing.JRootPane;
import org.bytedeco.javacv.CanvasFrame;

class CanvasFrame.1
implements Runnable {
    final /* synthetic */ double val$gamma;
    final /* synthetic */ boolean val$fullScreen;
    final /* synthetic */ CanvasFrame this$0;
    final /* synthetic */ DisplayMode val$displayMode;

    @Override
    public void run() {
        DisplayMode displayMode;
        DisplayMode a;
        CanvasFrame.1 var2_1 = a;
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(var2_1.this$0.keyEventDispatch);
        CanvasFrame.1 v0 = var2_1;
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
            CanvasFrame.1 v1 = var2_1;
            int n7 = v1.val$displayMode.getWidth();
            int n8 = v1.val$displayMode.getHeight();
            int n9 = v1.val$displayMode.getBitDepth();
            int n10 = v1.val$displayMode.getRefreshRate();
            if (n7 > 0) {
                n = n7;
                n2 = n8;
            } else {
                n = a.getWidth();
                n2 = n8;
            }
            if (n2 > 0) {
                n3 = n8;
                n4 = n9;
            } else {
                n3 = a.getHeight();
                n4 = n9;
            }
            if (n4 > 0) {
                n5 = n9;
                n6 = n10;
            } else {
                n5 = a.getBitDepth();
                n6 = n10;
            }
            displayMode2 = new DisplayMode(n, n3, n5, n6 > 0 ? n10 : a.getRefreshRate());
        }
        CanvasFrame.1 v8 = var2_1;
        if (var2_1.val$fullScreen) {
            v8.this$0.setUndecorated(true);
            displayMode = displayMode2;
            CanvasFrame.1 v10 = var2_1;
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
        CanvasFrame.1 v11 = var2_1;
        v11.this$0.setVisible(true);
        CanvasFrame.1 v12 = var2_1;
        v11.this$0.initCanvas(v12.val$fullScreen, v12.val$displayMode, var2_1.val$gamma);
    }

    /*
     * WARNING - void declaration
     */
    CanvasFrame.1() {
        CanvasFrame.1 var3_5;
        void a;
        boolean a2 = bl;
        CanvasFrame.1 v0 = var3_5 = this;
        v0.this$0 = a;
        v0.val$displayMode = displayMode;
        var3_5.val$fullScreen = a2;
        var3_5.val$gamma = d;
    }
}
