/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.impl.combat.WebCleaner;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import java.util.UUID;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class WebCleaner.PlayerAndPredict {
    final /* synthetic */ WebCleaner this$0;
    final class_1657 predict;

    /*
     * WARNING - void declaration
     */
    public WebCleaner.PlayerAndPredict(WebCleaner webCleaner, class_2338 class_23382) {
        WebCleaner.PlayerAndPredict a;
        void a2;
        WebCleaner.PlayerAndPredict a3 = class_23382;
        WebCleaner.PlayerAndPredict playerAndPredict = a = this;
        playerAndPredict.this$0 = a2;
        WebCleaner.PlayerAndPredict playerAndPredict2 = a;
        a.predict = new class_1657(a, (class_1937)Wrapper.mc.field_1687, a3.method_10074(), 0.0f, new GameProfile(UUID.fromString(Animation.ALLATORIxDEMO("\u0007<Vn \u001e\u0019\"\u000f(\b2\u00120\u0004>1\u000b\u0000 \u0011*%\u0005\u0007<\u0011(\u0011/\u0012'\u0016-\u0007<")), ProjectionUtils.ALLATORIxDEMO("p\u0014q6_\u0013U\"N\u0012D\u001f^R\u0003O")), (WebCleaner)a2){
            final /* synthetic */ WebCleaner val$this$0;
            final /* synthetic */ WebCleaner.PlayerAndPredict this$1;

            public boolean method_7337() {
                return false;
            }

            public boolean method_7325() {
                return false;
            }
            {
                Object a;
                void a2;
                void a3;
                void a4;
                void a5;
                void a6;
                1 v0 = object2;
                Object object2 = object;
                object = v0;
                object.this$1 = a5;
                object.val$this$0 = a;
                super((class_1937)a2, (class_2338)a4, (float)a6, (GameProfile)a3);
            }
        };
        playerAndPredict.predict.method_33574(a3.method_46558().method_1031(0.0, -1.0, 0.0));
        playerAndPredict.predict.method_6033(20.0f);
        playerAndPredict.predict.method_24830(true);
    }

}
