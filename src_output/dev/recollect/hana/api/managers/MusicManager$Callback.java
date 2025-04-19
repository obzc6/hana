/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.MusicManager;

public static interface MusicManager.Callback<T> {
    public void onSuccess(T var1);

    public void onError(String var1);
}
