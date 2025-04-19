/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Pointer
 *  com.sun.jna.win32.StdCallLibrary
 *  com.sun.jna.win32.StdCallLibrary$StdCallCallback
 */
package dev.recollect.hana.api.utils.math;

import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import dev.recollect.hana.api.utils.math.WebUtils;

public static interface WebUtils.User32.WNDENUMPROC
extends StdCallLibrary.StdCallCallback {
    public boolean callback(Pointer var1, Pointer var2);
}
