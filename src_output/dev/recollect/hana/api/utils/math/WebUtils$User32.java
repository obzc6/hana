/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Native
 *  com.sun.jna.Pointer
 *  com.sun.jna.win32.StdCallLibrary
 *  com.sun.jna.win32.StdCallLibrary$StdCallCallback
 */
package dev.recollect.hana.api.utils.math;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;

public static interface WebUtils.User32
extends StdCallLibrary {
    public static final WebUtils.User32 INSTANCE = (WebUtils.User32)Native.loadLibrary((String)Timer.ALLATORIxDEMO("LGA[]Q"), WebUtils.User32.class);

    public int GetWindowTextA(Pointer var1, byte[] var2, int var3);

    public boolean EnumWindows(WNDENUMPROC var1, Pointer var2);

    public static interface WNDENUMPROC
    extends StdCallLibrary.StdCallCallback {
        public boolean callback(Pointer var1, Pointer var2);
    }

}
