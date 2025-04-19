/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.video;

import dev.recollect.hana.video.VideoPlayer;

static class VideoPlayer.1
extends Thread {
    VideoPlayer.1(String string) {
        String a = string;
        VideoPlayer.1 a2 = this;
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
        VideoPlayer.1 a22;
        VideoPlayer.1 var1_2 = a22;
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
}
