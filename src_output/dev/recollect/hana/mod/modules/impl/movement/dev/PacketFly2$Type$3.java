/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.impl.movement.dev.PacketFly2;
import java.util.Random;
import net.minecraft.class_243;

final class PacketFly2.Type.3
extends PacketFly2.Type {
    private final Random random;

    @Override
    public class_243 createOutOfBounds(class_243 class_2432, int n) {
        PacketFly2.Type.3 a = class_2432;
        PacketFly2.Type.3 a2 = this;
        return a.method_1031((double)a2.randomInt(), 0.0, (double)a2.randomInt());
    }

    private /* synthetic */ int randomInt() {
        PacketFly2.Type.3 a22;
        PacketFly2.Type.3 var1_2;
        PacketFly2.Type.3 v0 = var1_2 = a22;
        int a22 = v0.random.nextInt(29000000);
        if (v0.random.nextBoolean()) {
            return a22;
        }
        return -a22;
    }

    private /* synthetic */ PacketFly2.Type.3(String string, int n) {
        int a = n;
        PacketFly2.Type.3 var2_4 = this;
        PacketFly2.Type.3 v0 = var2_4;
        v0.random = new Random();
    }
}
