/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.io.IOException;
import org.bytedeco.javacv.FrameRecorder;

public static class FrameRecorder.Exception
extends IOException {
    public FrameRecorder.Exception(String string) {
        String a = string;
        FrameRecorder.Exception a2 = this;
        super(a);
    }

    /*
     * WARNING - void declaration
     */
    public FrameRecorder.Exception(String string, Throwable throwable) {
        void a;
        Throwable a2 = throwable;
        FrameRecorder.Exception a3 = this;
        super((String)a, a2);
    }
}
