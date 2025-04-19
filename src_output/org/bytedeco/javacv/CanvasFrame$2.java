/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import org.bytedeco.javacv.CanvasFrame;

class CanvasFrame.2
extends Canvas {
    final /* synthetic */ CanvasFrame this$0;

    CanvasFrame.2(CanvasFrame canvasFrame) {
        Component a = canvasFrame;
        CanvasFrame.2 a2 = this;
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
        CanvasFrame.2 a2 = this;
        a2.paint(a);
    }
}
