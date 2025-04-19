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

final class PacketFly2.Type.4
extends PacketFly2.Type {
    private final Random random;

    /*
     * WARNING - void declaration
     */
    @Override
    public class_243 createOutOfBounds(class_243 class_2432, int n) {
        void a;
        int a2 = n;
        PacketFly2.Type.4 a3 = this;
        if (a3.random.nextBoolean()) {
            return a.method_1031(0.0, (double)(-a2), 0.0);
        }
        return a.method_1031(0.0, (double)a2, 0.0);
    }

    private /* synthetic */ PacketFly2.Type.4(String string, int n) {
        int a = n;
        PacketFly2.Type.4 var2_4 = this;
        PacketFly2.Type.4 v0 = var2_4;
        v0.random = new Random();
    }
}
