/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.util.Arrays;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;

public static class FrameGrabber.Array {
    private Frame[] grabbedFrames;
    protected FrameGrabber[] frameGrabbers;
    private long[] bestLatencies;
    private long lastNewestTimestamp;
    private long[] latencies;
    private long bestInterval;

    public void release() throws FrameGrabber.Exception {
        FrameGrabber.Array a;
        FrameGrabber.Array array = a;
        FrameGrabber[] arrframeGrabber = array.frameGrabbers;
        int n = arrframeGrabber.length;
        int n2 = a = 0;
        while (n2 < n) {
            arrframeGrabber[a++].release();
            n2 = a;
        }
    }

    public void stop() throws FrameGrabber.Exception {
        FrameGrabber.Array a;
        FrameGrabber.Array array = a;
        FrameGrabber[] arrframeGrabber = array.frameGrabbers;
        int n = arrframeGrabber.length;
        int n2 = a = 0;
        while (n2 < n) {
            arrframeGrabber[a++].stop();
            n2 = a;
        }
    }

    public FrameGrabber[] getFrameGrabbers() {
        FrameGrabber.Array a;
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

    protected FrameGrabber.Array(FrameGrabber[] arrframeGrabber) {
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

    public Frame[] grab() throws FrameGrabber.Exception {
        int n;
        int a2;
        FrameGrabber.Array a2;
        FrameGrabber.Array array;
        FrameGrabber.Array array2 = a2;
        if (array2.frameGrabbers.length == 1) {
            FrameGrabber.Array array3 = array2;
            array2.grabbedFrames[0] = array3.frameGrabbers[0].grab();
            return array3.grabbedFrames;
        }
        long l = 0L;
        int n2 = 0;
        int n3 = a2 = 0;
        while (n3 < array2.frameGrabbers.length) {
            FrameGrabber.Array array4 = array2;
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
            FrameGrabber.Array array5 = array2;
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
                        FrameGrabber.Array array6 = array2;
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
        FrameGrabber.Array a;
        return a.frameGrabbers.length;
    }

    public void start() throws FrameGrabber.Exception {
        FrameGrabber.Array a;
        FrameGrabber.Array array = a;
        FrameGrabber[] arrframeGrabber = array.frameGrabbers;
        int n = arrframeGrabber.length;
        int n2 = a = 0;
        while (n2 < n) {
            arrframeGrabber[a++].start();
            n2 = a;
        }
    }

    public void trigger() throws FrameGrabber.Exception {
        FrameGrabber.Array a;
        FrameGrabber.Array array = a;
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
