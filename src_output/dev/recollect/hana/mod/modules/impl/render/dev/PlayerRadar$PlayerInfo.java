/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.mod.modules.impl.render.dev.PlayerRadar;
import net.minecraft.class_1657;

private static class PlayerRadar.PlayerInfo {
    private final class_1657 player;
    private final double distance;

    /*
     * WARNING - void declaration
     */
    public PlayerRadar.PlayerInfo(class_1657 class_16572, double d) {
        void a;
        PlayerRadar.PlayerInfo a2;
        PlayerRadar.PlayerInfo a3 = class_16572;
        PlayerRadar.PlayerInfo playerInfo = a2 = this;
        playerInfo.player = a3;
        playerInfo.distance = a;
    }

    public double getDistance() {
        PlayerRadar.PlayerInfo a;
        return a.distance;
    }

    public class_1657 getPlayer() {
        PlayerRadar.PlayerInfo a;
        return a.player;
    }
}
