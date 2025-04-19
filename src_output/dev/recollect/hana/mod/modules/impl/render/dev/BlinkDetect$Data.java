/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.mod.modules.impl.render.dev.BlinkDetect;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.class_1657;
import net.minecraft.class_243;

private static final class BlinkDetect.Data
extends Record {
    private final class_243 pos;
    private final class_1657 player;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ BlinkDetect.Data(class_1657 class_16572, class_243 class_2432) {
        BlinkDetect.Data a;
        void a2;
        BlinkDetect.Data a3 = class_2432;
        BlinkDetect.Data data = a = this;
        data.player = a2;
        data.pos = a3;
    }

    public class_1657 player() {
        BlinkDetect.Data a;
        return a.player;
    }

    @Override
    public final int hashCode() {
        BlinkDetect.Data a;
        return (int)ObjectMethods.bootstrap(new MethodHandle[]{BlinkDetect.Data.class, "player;pos", }