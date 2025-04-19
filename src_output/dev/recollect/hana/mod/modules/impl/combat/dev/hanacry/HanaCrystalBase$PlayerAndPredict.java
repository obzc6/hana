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
package dev.recollect.hana.mod.modules.impl.combat.dev.hanacry;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaCrystalBase;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.FileUtil;
import java.util.ArrayList;
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

private class HanaCrystalBase.PlayerAndPredict {
    final /* synthetic */ HanaCrystalBase this$0;
    final class_1657 player;
    final class_1657 predict;

    private /* synthetic */ HanaCrystalBase.PlayerAndPredict(HanaCrystalBase object, class_1657 class_16572) {
        HanaCrystalBase.PlayerAndPredict a = class_16572;
        HanaCrystalBase.PlayerAndPredict a2 = this;
        a2.this$0 = object;
        a2.player = a;
        if (((HanaCrystalBase)object).predictTicks.getValueFloat() > 0.0f) {
            HanaCrystalBase.PlayerAndPredict playerAndPredict = a2;
            playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Timer.ALLATORIxDEMO("\u0003\u000e\u0013\u001d\"*\b\u0005\u0019\b2>\u0016\u0002\u0000\f\u0007\u000b\u0014\u0002\u0005\b\u0012\u0004ZW\u000e\u0001\b\u0000\u0001\u0002\u0012\u001f^S")), FileUtil.ALLATORIxDEMO("A\f@.n\u000bd:\nu\u0007oJ2W")), (HanaCrystalBase)object, (class_1657)a){
                final /* synthetic */ HanaCrystalBase val$this$0;
                final /* synthetic */ HanaCrystalBase.PlayerAndPredict this$1;
                final /* synthetic */ class_1657 val$player;

                public boolean method_24828() {
                    1 a;
                    return a.val$player.method_24828();
                }
                {
                    void a;
                    void a2;
                    void a3;
                    void a4;
                    1 a5;
                    void a6;
                    1 v0 = this_;
                    1 this_ = class_16572;
                    class_1657 class_16573 = class_16572 = v0;
                    class_16573.this$1 = a6;
                    class_16573.val$this$0 = hanaCrystalBase;
                    class_16572.val$player = a5;
                    class_16572((class_1937)a4, (class_2338)a3, (float)a2, (GameProfile)a);
                }

                public boolean method_7325() {
                    return false;
                }

                public boolean method_7337() {
                    return false;
                }
            };
            a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, ((HanaCrystalBase)object).predictTicks.getValueInt(), true)));
            playerAndPredict.predict.method_6033(a.method_6032());
            playerAndPredict.predict.field_6014 = ((class_1657)a).field_6014;
            playerAndPredict.predict.field_5969 = ((class_1657)a).field_5969;
            playerAndPredict.predict.field_6036 = ((class_1657)a).field_6036;
            playerAndPredict.predict.method_24830(a.method_24828());
            playerAndPredict.predict.method_31548().method_7377(a.method_31548());
            playerAndPredict.predict.method_18380(a.method_18376());
            Object object2 = object = new ArrayList(a.method_6026()).iterator();
            while (object2.hasNext()) {
                class_1293 class_12932 = (class_1293)object.next();
                object2 = object;
                a2.predict.method_6092(class_12932);
            }
        } else {
            a2.predict = a;
        }
    }

}
