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
package dev.recollect.hana.mod.modules.impl.combat.dev;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoCrystalBase;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
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
import org.bytedeco.javacv.FrameConverter;

private class AutoCrystalBase.PlayerAndPredict {
    final /* synthetic */ AutoCrystalBase this$0;
    final class_1657 player;
    final class_1657 predict;

    private /* synthetic */ AutoCrystalBase.PlayerAndPredict(AutoCrystalBase object, class_1657 class_16572) {
        AutoCrystalBase.PlayerAndPredict a = class_16572;
        AutoCrystalBase.PlayerAndPredict a2 = this;
        a2.this$0 = object;
        a2.player = a;
        if (((AutoCrystalBase)object).predictTicks.getValueFloat() > 0.0f) {
            AutoCrystalBase.PlayerAndPredict playerAndPredict = a2;
            playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(Animation.ALLATORIxDEMO("\u0010+Vn \u001e\u0019\"\u000f(\b2\u00120\u0004>1\u000b\u0000 \u0011*%\u0005\u0007<\u0011(\u0011/\u0012'\u0016-\u0007<")), FrameConverter.ALLATORIxDEMO("(i\nhN'\u0006T\u001bb\u001be\u0016?\u0016")), (AutoCrystalBase)object, (class_1657)a){
                final /* synthetic */ AutoCrystalBase.PlayerAndPredict this$1;
                final /* synthetic */ AutoCrystalBase val$this$0;
                final /* synthetic */ class_1657 val$player;

                public boolean method_24828() {
                    1 a;
                    return a.val$player.method_24828();
                }

                public boolean method_7325() {
                    return false;
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
                    class_16573.this$1 = a4;
                    class_16573.val$this$0 = autoCrystalBase;
                    class_16572.val$player = a5;
                    class_16572((class_1937)a2, (class_2338)a6, (float)a, (GameProfile)a3);
                }

                public boolean method_7337() {
                    return false;
                }
            };
            a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, ((AutoCrystalBase)object).predictTicks.getValueInt(), true)));
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
