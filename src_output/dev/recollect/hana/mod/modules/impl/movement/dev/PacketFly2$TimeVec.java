/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.impl.movement.dev.PacketFly2;
import net.minecraft.class_243;

public static class PacketFly2.TimeVec
extends class_243 {
    private final long time;

    public PacketFly2.TimeVec(double a, double a2, double a3, long a4) {
        super(a, a2, a3);
        PacketFly2.TimeVec a5;
        a5.time = a4;
    }

    public long getTime() {
        PacketFly2.TimeVec a;
        return a.time;
    }

    public PacketFly2.TimeVec(class_243 class_2432) {
        PacketFly2.TimeVec a = class_2432;
        PacketFly2.TimeVec a2 = this;
        a2(a.field_1352, a.field_1351, a.field_1350, System.currentTimeMillis());
    }
}
