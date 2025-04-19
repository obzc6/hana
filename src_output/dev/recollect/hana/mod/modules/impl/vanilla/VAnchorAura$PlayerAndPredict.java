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
package dev.recollect.hana.mod.modules.impl.vanilla;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.vanilla.VAnchorAura;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
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
import org.bytedeco.javacv.BaseChildSettings;

public static class VAnchorAura.PlayerAndPredict {
    public final class_1657 player;
    public final class_1657 predict;

    public VAnchorAura.PlayerAndPredict(class_1657 class_16572) {
        VAnchorAura.PlayerAndPredict a = class_16572;
        VAnchorAura.PlayerAndPredict a2 = this;
        a2.player = a;
        if (VAnchorAura.INSTANCE.predictTicks.getValueFloat() > 0.0f) {
            Iterator iterator;
            VAnchorAura.PlayerAndPredict playerAndPredict = a2;
            playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(BaseChildSettings.ALLATORIxDEMO("\u001di\rz<M\u0016b\u0007o,Y\be\u001ek\u0019l\ne\u001bo\fcD0\u0010f\u0016g\u001fe\fx@4")), ObsidianHelper.ALLATORIxDEMO("x1y\u0013W6]\u0007F7L:Vw\u000bj"))){
                final /* synthetic */ VAnchorAura.PlayerAndPredict this$0;

                public boolean method_7337() {
                    return false;
                }
                {
                    1 a;
                    void a2;
                    void a3;
                    void a4;
                    void a5;
                    1 v0 = this_;
                    1 this_ = gameProfile;
                    1 a6 = v0;
                    a6.this$0 = a2;
                    super((class_1937)a4, (class_2338)a5, (float)a3, (GameProfile)a);
                }

                public boolean method_7325() {
                    return false;
                }
            };
            a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, VAnchorAura.INSTANCE.predictTicks.getValueInt(), true)));
            playerAndPredict.predict.method_6033(a.method_6032());
            playerAndPredict.predict.field_6014 = ((class_1657)a).field_6014;
            playerAndPredict.predict.field_5969 = ((class_1657)a).field_5969;
            playerAndPredict.predict.field_6036 = ((class_1657)a).field_6036;
            playerAndPredict.predict.method_24830(a.method_24828());
            VAnchorAura.PlayerAndPredict playerAndPredict2 = a;
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
