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
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.impl.combat.HoleFiller;
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

public class HoleFiller.PlayerAndPredict {
    final /* synthetic */ HoleFiller this$0;
    class_1657 player;
    class_1657 predict;

    public HoleFiller.PlayerAndPredict(HoleFiller holeFiller, class_1657 class_16572) {
        Iterator a;
        HoleFiller.PlayerAndPredict a2 = class_16572;
        HoleFiller.PlayerAndPredict a3 = this;
        a3.this$0 = a;
        a3.player = a2;
        if (((HoleFiller)a).predictTicks.getValueFloat() > 0.0f) {
            HoleFiller.PlayerAndPredict playerAndPredict = a3;
            playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(BOEntityUtils.ALLATORIxDEMO("7\u001bfI\u00109)\u0005?\u000f8\u0015\"\u00174\u0019\u0001,0\u0007!\r\u0015\"7\u001b!\u000f!\b\"\u0000&\n7\u001b")), TipUtils.ALLATORIxDEMO("\u001b\u00169\u0017}X5+(\u001d(\u001a%@%\u0000")), (HoleFiller)((Object)a)){
                final /* synthetic */ HoleFiller.PlayerAndPredict this$1;
                final /* synthetic */ HoleFiller val$this$0;

                public boolean method_7325() {
                    return false;
                }
                {
                    void a;
                    void a2;
                    void a3;
                    void a4;
                    void a5;
                    Object a6;
                    1 v0 = object2;
                    Object object2 = object;
                    object = v0;
                    object.this$1 = a5;
                    object.val$this$0 = a6;
                    super((class_1937)a4, (class_2338)a3, (float)a2, (GameProfile)a);
                }

                public boolean method_7337() {
                    return false;
                }
            };
            a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, HoleFiller.INSTANCE.predictTicks.getValueInt(), true)));
            playerAndPredict.predict.method_6033(a2.method_6032());
            playerAndPredict.predict.field_6014 = ((class_1657)a2).field_6014;
            playerAndPredict.predict.field_5969 = ((class_1657)a2).field_5969;
            playerAndPredict.predict.field_6036 = ((class_1657)a2).field_6036;
            playerAndPredict.predict.method_24830(a2.method_24828());
            HoleFiller.PlayerAndPredict playerAndPredict2 = a2;
            playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
            playerAndPredict.predict.method_18380(a2.method_18376());
            Iterator iterator = a = playerAndPredict2.method_6026().iterator();
            while (iterator.hasNext()) {
                class_1293 class_12932 = (class_1293)a.next();
                iterator = a;
                a3.predict.method_6092(class_12932);
            }
        } else {
            a3.predict = a2;
        }
    }

}
