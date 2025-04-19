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
package dev.recollect.hana.mod.modules.impl.combat.dev;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.combat.dev.PushCleaner;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import java.util.UUID;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class PushCleaner.PlayerAndPredict {
    final class_1657 predict;
    final /* synthetic */ PushCleaner this$0;

    /*
     * WARNING - void declaration
     */
    public PushCleaner.PlayerAndPredict(PushCleaner pushCleaner, class_2338 class_23382) {
        void a;
        PushCleaner.PlayerAndPredict a2;
        PushCleaner.PlayerAndPredict a3 = class_23382;
        PushCleaner.PlayerAndPredict playerAndPredict = a2 = this;
        playerAndPredict.this$0 = a;
        PushCleaner.PlayerAndPredict playerAndPredict2 = a2;
        a2.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a3.method_10074(), 0.0f, new GameProfile(UUID.fromString(PacketBuffer.ALLATORIxDEMO("_8\u000ejx\u001aA&W,P6J4\\:i\u000fX$I.}\u0001_8I,I+J#N)_8")), Tab.ALLATORIxDEMO("U\u0014w\u00153Z{)f\u001ff\u0018kBk\u0002")), (PushCleaner)a){
            final /* synthetic */ PushCleaner val$this$0;
            final /* synthetic */ PushCleaner.PlayerAndPredict this$1;

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
                super((class_1937)a3, (class_2338)a2, (float)a4, (GameProfile)a6);
            }
        };
        playerAndPredict.predict.method_33574(a3.method_46558().method_1031(0.0, -1.0, 0.0));
        playerAndPredict.predict.method_6033(20.0f);
        playerAndPredict.predict.method_24830(true);
    }

}
