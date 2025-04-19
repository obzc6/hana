/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.eventbus;

import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.eventbus.IListener;
import dev.recollect.hana.api.events.eventbus.LambdaListener;

public interface IEventBus {
    public void registerLambdaFactory(String var1, LambdaListener.Factory var2);

    public <T> T post(T var1);

    public <T extends ICancellable> T post(T var1);

    public void subscribe(Object var1);

    public void subscribe(Class<?> var1);

    public void subscribe(IListener var1);

    public void unsubscribe(Object var1);

    public void unsubscribe(Class<?> var1);

    public void unsubscribe(IListener var1);
}
