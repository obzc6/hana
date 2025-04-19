/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4050
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4050;
import net.minecraft.class_638;

public static class AnchorAura.PlayerAndPredict {
    public final class_1657 player;
    public final class_1657 predict;

    public AnchorAura.PlayerAndPredict(class_1657 class_16572) {
        AnchorAura.PlayerAndPredict a = class_16572;
        AnchorAura.PlayerAndPredict a2 = this;
        a2.player = a;
        if (AnchorAura.INSTANCE.predictTicks.getValueFloat() > 0.0f) {
            Iterator iterator;
            AnchorAura.PlayerAndPredict playerAndPredict = a2;
            playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Snow.ALLATORIxDEMO("6bt#\u0002S;o-e*0}&s\u0013F\"m3g\u0007H%q3e3b0j4`%q")), NpSocketClient.ALLATORIxDEMO("\\>]\u001cs9y\bb8h5rx/e"))){
                final /* synthetic */ AnchorAura.PlayerAndPredict this$0;
                {
                    void a;
                    void a2;
                    1 a3;
                    void a4;
                    void a5;
                    1 v0 = this_;
                    1 this_ = gameProfile;
                    1 a6 = v0;
                    a6.this$0 = a2;
                    super((class_1937)a5, (class_2338)a4, (float)a, (GameProfile)a3);
                }

                public boolean method_7337() {
                    return false;
                }

                public boolean method_7325() {
                    return false;
                }
            };
            a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, AnchorAura.INSTANCE.predictTicks.getValueInt(), true)));
            playerAndPredict.predict.method_6033(a.method_6032());
            playerAndPredict.predict.field_6014 = ((class_1657)a).field_6014;
            playerAndPredict.predict.field_5969 = ((class_1657)a).field_5969;
            playerAndPredict.predict.field_6036 = ((class_1657)a).field_6036;
            playerAndPredict.predict.method_24830(a.method_24828());
            AnchorAura.PlayerAndPredict playerAndPredict2 = a;
            playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
            playerAndPredict.predict.method_18380(a.method_18376());
            Iterator iterator2 = iterator = playerAndPredict2.method_6026().iterator();
            while (iterator2.hasNext()) {
                class_1293 class_12932 = (class_1293)iterator.next();
                iterator2 = iterator;
                a2.predict.method_6092(class_12932);
            }
        } else {
            a2.predict = a;
        }
    }

}
