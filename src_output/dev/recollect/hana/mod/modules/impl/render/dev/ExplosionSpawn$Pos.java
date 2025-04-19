/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.render.dev.ExplosionSpawn;
import net.minecraft.class_243;

public static class ExplosionSpawn.Pos {
    public final FadeUtils fadeTime;
    public final FadeUtils time;
    public final FadeUtils firstFade;
    public final class_243 pos;

    /*
     * WARNING - void declaration
     */
    public ExplosionSpawn.Pos(class_243 class_2432, int n, int n2, int n3) {
        ExplosionSpawn.Pos a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n4 = n3;
        ExplosionSpawn.Pos pos = a = this;
        ExplosionSpawn.Pos pos2 = a;
        pos2.firstFade = new FadeUtils((long)a5);
        pos.time = new FadeUtils((long)a4);
        pos.fadeTime = new FadeUtils((long)a3);
        pos.pos = a2;
    }
}
