/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.eventbus;

import dev.recollect.hana.api.events.eventbus.LambdaListener;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public static interface LambdaListener.Factory {
    public MethodHandles.Lookup create(Method var1, Class<?> var2) throws InvocationTargetException, IllegalAccessException;
}
