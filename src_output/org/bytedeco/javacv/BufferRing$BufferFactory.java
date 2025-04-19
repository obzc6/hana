/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import org.bytedeco.javacv.BufferRing;

public static interface BufferRing.BufferFactory<B extends BufferRing.ReleasableBuffer> {
    public B create();
}
