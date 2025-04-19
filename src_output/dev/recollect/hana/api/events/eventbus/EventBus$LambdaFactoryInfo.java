/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.eventbus;

import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.LambdaListener;

private static class EventBus.LambdaFactoryInfo {
    public final String packagePrefix;
    public final LambdaListener.Factory factory;

    public EventBus.LambdaFactoryInfo(String packagePrefix, LambdaListener.Factory factory) {
        this.packagePrefix = packagePrefix;
        this.factory = factory;
    }
}
