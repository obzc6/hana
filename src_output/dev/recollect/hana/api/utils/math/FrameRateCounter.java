/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FrameRateCounter {
    final List<Long> records;
    public static final FrameRateCounter INSTANCE = new FrameRateCounter();

    public int getFps() {
        FrameRateCounter a2;
        a2.records.removeIf(a -> a + 1000L < System.currentTimeMillis());
        return a2.records.size() / 2;
    }

    public FrameRateCounter() {
        FrameRateCounter a;
        FrameRateCounter frameRateCounter = a;
        frameRateCounter.records = new ArrayList<Long>();
    }

    public void recordFrame() {
        FrameRateCounter a;
        long l = System.currentTimeMillis();
        a.records.add(l);
    }
}
