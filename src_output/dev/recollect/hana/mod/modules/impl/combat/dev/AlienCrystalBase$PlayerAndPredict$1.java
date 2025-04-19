/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystalBase;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;

class AlienCrystalBase.PlayerAndPredict.1
extends class_1657 {
    final /* synthetic */ AlienCrystalBase val$this$0;
    final /* synthetic */ AlienCrystalBase.PlayerAndPredict this$1;
    final /* synthetic */ class_1657 val$player;

    /*
     * WARNING - void declaration
     */
    AlienCrystalBase.PlayerAndPredict.1(AlienCrystalBase.PlayerAndPredict playerAndPredict, class_1937 class_19372, class_2338 class_23382, float f, GameProfile gameProfile, AlienCrystalBase alienCrystalBase, class_1657 class_16572) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        AlienCrystalBase.PlayerAndPredict.1 a6;
        AlienCrystalBase.PlayerAndPredict.1 v0 = this_;
        AlienCrystalBase.PlayerAndPredict.1 this_ = class_16572;
        class_1657 class_16573 = class_16572 = v0;
        class_16573.this$1 = a5;
        class_16573.val$this$0 = alienCrystalBase;
        class_16572.val$player = a6;
        class_16572((class_1937)a4, (class_2338)a3, (float)a2, (GameProfile)a);
    }

    public boolean method_24828() {
        AlienCrystalBase.PlayerAndPredict.1 a;
        return a.val$player.method_24828();
    }

    public boolean method_7337() {
        return false;
    }

    public boolean method_7325() {
        return false;
    }
}
