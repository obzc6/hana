/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

public class BufferRing<B extends ReleasableBuffer> {
    private Object[] buffers;
    private int position;

    public B get() {
        BufferRing a;
        BufferRing bufferRing = a;
        return (B)((ReleasableBuffer)bufferRing.buffers[bufferRing.position]);
    }

    public B get(int n) {
        BufferRing a;
        int a2 = n;
        BufferRing bufferRing = a = this;
        return (B)((ReleasableBuffer)bufferRing.buffers[((bufferRing.position + a2) % a.buffers.length + a.buffers.length) % a.buffers.length]);
    }

    public int capacity() {
        BufferRing a;
        return a.buffers.length;
    }

    public void release() {
        BufferRing a;
        BufferRing bufferRing = a;
        int n = a = 0;
        while (n < bufferRing.buffers.length) {
            ((ReleasableBuffer)bufferRing.buffers[a++]).release();
            n = a;
        }
        bufferRing.buffers = null;
    }

    public int position() {
        BufferRing a;
        return a.position;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 3;
        5 << 4 ^ (3 ^ 5) << 1;
        int n4 = 2 << 3 ^ 4;
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

    public BufferRing(BufferFactory<B> a, int a2) {
        BufferRing a3;
        BufferRing bufferRing = a3;
        bufferRing.buffers = new Object[a2];
        int n = a3 = 0;
        while (n < a2) {
            bufferRing.buffers[a3++] = a.create();
            n = a3;
        }
        bufferRing.position = 0;
    }

    public BufferRing position(int n) {
        int a = n;
        BufferRing a2 = this;
        a2.position = (a % a2.buffers.length + a2.buffers.length) % a2.buffers.length;
        return a2;
    }

    public static interface BufferFactory<B extends ReleasableBuffer> {
        public B create();
    }

    public static interface ReleasableBuffer {
        public void release();
    }

}
