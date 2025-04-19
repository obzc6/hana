/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2620
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.render.BreakESP;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2620;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;

public class BreakManager
implements Wrapper {
    public final HashMap<Integer, BreakData> breakMap;

    @EventHandler
    public void onPacket(PacketEvent.Receive receive) {
        Object a = receive;
        BreakManager a2 = this;
        Object object = ((PacketEvent)a).getPacket();
        if (object instanceof class_2620) {
            a = (class_2620)object;
            if (a.method_11277() == null) {
                return;
            }
            object = new BreakData(a.method_11277(), a.method_11280());
            if (a2.breakMap.containsKey(a.method_11280()) && a2.breakMap.get((Object)Integer.valueOf((int)a.method_11280())).pos.equals((Object)a.method_11277())) {
                return;
            }
            if (((BreakData)object).getEntity() == null) {
                return;
            }
            if (class_3532.method_15355((float)((float)((BreakData)object).getEntity().method_33571().method_1025(a.method_11277().method_46558()))) > 8.0f) {
                return;
            }
            a2.breakMap.put(a.method_11280(), (BreakData)object);
        }
    }

    public BreakManager() {
        BreakManager a;
        BreakManager breakManager = a;
        breakManager.breakMap = new HashMap();
        Hana.EVENT_BUS.subscribe(a);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean isMining(class_2338 a) {
        Iterator<BreakData> a2;
        BreakData breakData;
        BreakManager breakManager = a2;
        boolean bl = false;
        a2 = new HashMap<Integer, BreakData>(breakManager.breakMap).values().iterator();
        block0 : do {
            Iterator<BreakData> iterator = a2;
            do {
                if (!iterator.hasNext()) {
                    return bl;
                }
                breakData = (BreakData)a2.next();
                if (breakData.getEntity() == null) {
                    iterator = a2;
                    continue;
                }
                if (!(breakData.getEntity().method_33571().method_1022(a.method_46558()) > 8.0)) continue block0;
                iterator = a2;
            } while (true);
        } while (!breakData.pos.equals((Object)a));
        return true;
    }

    public static class BreakData {
        public final int entityId;
        public final class_2338 pos;
        public final FadeUtils fade;

        /*
         * WARNING - void declaration
         */
        public BreakData(class_2338 class_23382, int n) {
            BreakData a;
            void a2;
            int a3 = n;
            BreakData breakData = a = this;
            breakData.pos = a2;
            breakData.entityId = a3;
            BreakData breakData2 = a;
            breakData.fade = new FadeUtils((long)BreakESP.INSTANCE.animationTime.getValue());
        }

        public class_1297 getEntity() {
            BreakData a;
            BreakData breakData = a;
            a = Wrapper.mc.field_1687.method_8469(breakData.entityId);
            if (a instanceof class_1657) {
                return a;
            }
            return null;
        }
    }

}
