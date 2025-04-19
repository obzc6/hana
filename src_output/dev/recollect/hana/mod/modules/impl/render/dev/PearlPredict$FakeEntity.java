/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.mod.modules.impl.render.dev.PearlPredict;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.class_243;

private static final class PearlPredict.FakeEntity
extends Record {
    private final float yaw;
    private final class_243 velocity;
    private final float pitch;
    private final class_243 pos;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ PearlPredict.FakeEntity(class_243 class_2432, float f, float f2, class_243 class_2433) {
        void a;
        void a2;
        void a3;
        PearlPredict.FakeEntity a4;
        PearlPredict.FakeEntity a5;
        PearlPredict.FakeEntity fakeEntity = fakeEntity2;
        PearlPredict.FakeEntity fakeEntity2 = class_2433;
        PearlPredict.FakeEntity fakeEntity3 = a5 = fakeEntity;
        PearlPredict.FakeEntity fakeEntity4 = a5;
        fakeEntity4.pos = a2;
        fakeEntity4.yaw = a3;
        fakeEntity3.pitch = a;
        fakeEntity3.velocity = a4;
    }

    public float pitch() {
        PearlPredict.FakeEntity a;
        return a.pitch;
    }

    @Override
    public final boolean equals(Object object) {
        Object a = object;
        PearlPredict.FakeEntity a2 = this;
        return (boolean)ObjectMethods.bootstrap(new MethodHandle[]{PearlPredict.FakeEntity.class, "pos;yaw;pitch;velocity", }