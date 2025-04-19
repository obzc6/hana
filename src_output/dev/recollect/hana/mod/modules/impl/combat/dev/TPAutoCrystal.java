/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_5321
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.entity.TPUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_5321;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class TPAutoCrystal
extends Module {
    private final SliderSetting placeDelay;
    private final SliderSetting range;
    private final SliderSetting wallRange;
    private long lastPlaceTime;
    private final BooleanSetting enabled;

    private /* synthetic */ class_2338 findBestPlacePosition(class_1657 class_16572) {
        int n;
        TPAutoCrystal a = class_16572;
        TPAutoCrystal a2 = this;
        a = a.method_5829();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        int n2 = n = (int)Math.floor(((class_238)a).field_1323);
        while (n2 <= (int)Math.ceil(((class_238)a).field_1320)) {
            int n3 = (int)Math.floor(((class_238)a).field_1322);
            while (n3 <= (int)Math.ceil(((class_238)a).field_1325)) {
                int n4;
                int n5 = (int)Math.floor(((class_238)a).field_1321);
                while (n5 <= (int)Math.ceil(((class_238)a).field_1324)) {
                    int n6;
                    arrayList.add(new class_2338(n, n4, n6++));
                    n5 = n6;
                }
                n3 = ++n4;
            }
            n2 = ++n;
        }
        for (class_2338 class_23382 : arrayList) {
            if (!a2.canPlaceCrystal(class_23382, false, false)) continue;
            return class_23382;
        }
        return null;
    }

    private /* synthetic */ int getDimensionId() {
        TPAutoCrystal a;
        TPAutoCrystal tPAutoCrystal = a;
        a = TPAutoCrystal.mc.field_1687.method_27983();
        if (a == class_1937.field_25179) {
            return 0;
        }
        if (a == class_1937.field_25180) {
            return -1;
        }
        if (a == class_1937.field_25181) {
            return 1;
        }
        throw new IllegalArgumentException("Unknown dimension: " + String.valueOf(a));
    }

    private /* synthetic */ class_1657 findClosestPlayer() {
        Iterator a2;
        TPAutoCrystal tPAutoCrystal = a2;
        a2 = (List)TPAutoCrystal.mc.field_1687.method_18112();
        ArrayList<class_1657> arrayList = new ArrayList<class_1657>();
        a2 = a2.iterator();
        while (a2.hasNext()) {
            class_1297 class_12972 = (class_1297)a2.next();
            if (!(class_12972 instanceof class_1657) || class_12972 == TPAutoCrystal.mc.field_1724 || !(class_12972.method_5858((class_1297)TPAutoCrystal.mc.field_1724) <= tPAutoCrystal.range.getValue() * tPAutoCrystal.range.getValue())) continue;
            arrayList.add((class_1657)class_12972);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.stream().min(Comparator.comparingDouble(a -> a.method_5858((class_1297)TPAutoCrystal.mc.field_1724))).orElse(null);
    }

    private /* synthetic */ void placeCrystal(class_2338 class_23382, class_1657 class_16572) {
        TPAutoCrystal a = class_23382;
        TPAutoCrystal a2 = this;
        if ((double)(System.currentTimeMillis() - a2.lastPlaceTime) < a2.placeDelay.getValue()) {
            return;
        }
        class_243 a3 = new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.0, (double)a.method_10260() + 0.5);
        TPUtil.tp(() -> a2.lambda$placeCrystal$1(a3, (class_2338)a), a3);
        a2.lastPlaceTime = System.currentTimeMillis();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean hasEntityBlockCrystal(class_2338 var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        a = TPAutoCrystal.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = a;
            while (v0.hasNext() != false) {
                a = (class_1297)a.next();
                if (!a.method_5805() || a != false && a instanceof class_1542) ** GOTO lbl-1000
                if (a instanceof class_1531 && CombatSetting.INSTANCE.obsMode.getValue()) {
                    v0 = a;
                    continue;
                }
                if (a instanceof class_1511 == false) return true;
                if (a == false) {
                    return true;
                }
                if (TPAutoCrystal.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(TPAutoCrystal.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return true;
                v0 = a;
            }
            return false;
            break;
        } while (true);
    }

    @Override
    public void onUpdate() {
        class_2338 class_23382;
        TPAutoCrystal tPAutoCrystal;
        TPAutoCrystal a;
        TPAutoCrystal tPAutoCrystal2 = tPAutoCrystal = a;
        super.onUpdate();
        if (!tPAutoCrystal2.enabled.getValue()) {
            return;
        }
        a = tPAutoCrystal.findClosestPlayer();
        if (a != null && (class_23382 = tPAutoCrystal.findBestPlacePosition((class_1657)a)) != null) {
            tPAutoCrystal.placeCrystal(class_23382, (class_1657)a);
        }
    }

    private /* synthetic */ void lambda$placeCrystal$1(class_243 a, class_2338 a2) {
        TPAutoCrystal a3;
        TPAutoCrystal tPAutoCrystal = a3;
        if (TPAutoCrystal.mc.field_1724.method_6047().method_7909() == class_1802.field_8301 && (a3 = TPAutoCrystal.mc.field_1687.method_17742(new class_3959(TPAutoCrystal.mc.field_1724.method_5836(1.0f), a, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)TPAutoCrystal.mc.field_1724))).method_17783() == class_239.class_240.field_1332) {
            a3.method_17777();
            TPAutoCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a3, tPAutoCrystal.getDimensionId()));
        }
        TPAutoCrystal.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, new class_3965(a, class_2350.field_11036, a2, false), tPAutoCrystal.getDimensionId()));
    }

    private /* synthetic */ class_2248 getBlock(class_2338 class_23382) {
        TPAutoCrystal a = class_23382;
        TPAutoCrystal a2 = this;
        return TPAutoCrystal.mc.field_1687.method_8320((class_2338)a).method_26204();
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        void a2;
        class_2338 a3;
        TPAutoCrystal tPAutoCrystal = this;
        a3 = a3.method_10074();
        TPAutoCrystal a4 = a3.method_10084();
        return !(tPAutoCrystal.getBlock(a3) != class_2246.field_9987 && tPAutoCrystal.getBlock(a3) != class_2246.field_10540 || BlockUtil.getClickSideStrict(a3) == null || tPAutoCrystal.hasEntityBlockCrystal((class_2338)a4, (boolean)a2, (boolean)a) || tPAutoCrystal.hasEntityBlockCrystal(a4.method_10084(), (boolean)a2, (boolean)a) || tPAutoCrystal.getBlock((class_2338)a4) != class_2246.field_10124 && (!tPAutoCrystal.hasEntityBlockCrystal((class_2338)a4, false, (boolean)a) || tPAutoCrystal.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && tPAutoCrystal.getBlock(a4.method_10084()) != class_2246.field_10124);
    }

    public TPAutoCrystal() {
        TPAutoCrystal a;
        TPAutoCrystal tPAutoCrystal = a;
        super(BOEntityUtils.ALLATORIxDEMO("HQlRoouRaJ~_"), Module.Category.Combat);
        TPAutoCrystal tPAutoCrystal2 = a;
        tPAutoCrystal2.enabled = tPAutoCrystal.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("]T~MfGc"), true));
        tPAutoCrystal.range = tPAutoCrystal.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("ysPxV"), 6, 1, 200));
        tPAutoCrystal.placeDelay = tPAutoCrystal.add(new SliderSetting(SocketClient.ALLATORIxDEMO("I[s^}\u001a[JfC~"), 10, 1, 200));
        tPAutoCrystal.wallRange = tPAutoCrystal.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("]Gl@'ysPxV"), 6, 1, 200));
        a.lastPlaceTime = 0L;
        a.setChinese(SocketClient.ALLATORIxDEMO("{Z\u6c16\u6671"));
    }
}
