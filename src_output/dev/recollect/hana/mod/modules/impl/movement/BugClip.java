/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class BugClip
extends Module {
    boolean cancelPacket;
    final SliderSetting delay;
    private final BooleanSetting clipIn;
    public static BugClip INSTANCE;
    final Timer timer;

    public boolean insideBurrow() {
        int n;
        BugClip bugClip = this;
        class_2338 class_23382 = EntityUtil.getPlayerPos(true);
        int n2 = n = -1;
        while (n2 <= 1) {
            int n3;
            int n4 = n3 = -1;
            while (n4 <= 1) {
                int a;
                int n5 = a = -1;
                while (n5 <= 1) {
                    class_2338 class_23383 = class_23382.method_10069(n, n3, a);
                    if (BugClip.mc.field_1687.method_8320(class_23383).method_26204() == class_2246.field_9987 && BugClip.mc.field_1724.method_5829().method_994(new class_238(class_23383))) {
                        return true;
                    }
                    n5 = ++a;
                }
                n4 = ++n3;
            }
            n2 = ++n;
        }
        return false;
    }

    public BugClip() {
        BugClip a;
        BugClip bugClip = a;
        BugClip bugClip2 = a;
        super(Alt.ALLATORIxDEMO(",n&](n-"), Module.Category.Movement);
        BugClip bugClip3 = a;
        bugClip3.delay = bugClip2.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("wZbV"), 100, 0, 500));
        bugClip2.clipIn = bugClip2.add(new BooleanSetting(Alt.ALLATORIxDEMO("X-w4N3"), true));
        bugClip2.timer = new Timer();
        bugClip.cancelPacket = true;
        bugClip.setChinese(BOEntityUtils.ALLATORIxDEMO("qOq\u5362\u58b6"));
        INSTANCE = bugClip;
    }

    @Override
    public void onUpdate() {
        BugClip a;
        if (!a.insideBurrow()) {
            a.disable();
        }
    }

    @EventHandler
    public void onPacket(PacketEvent.Send a) {
        Object t;
        BugClip a22;
        BugClip bugClip = a22;
        if (BugClip.nullCheck()) {
            return;
        }
        if (bugClip.cancelPacket && (t = a.getPacket()) instanceof class_2828) {
            a22 = (class_2828)t;
            if (!bugClip.insideBurrow()) {
                bugClip.disable();
                return;
            }
            if (a22.method_36172()) {
                BugClip bugClip2 = a22;
                float f = bugClip2.method_12271(0.0f);
                float a22 = bugClip2.method_12270(0.0f);
                if (bugClip.timer.passedMs(bugClip.delay.getValue())) {
                    bugClip.cancelPacket = false;
                    BugClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2830(BugClip.mc.field_1724.method_23317(), BugClip.mc.field_1724.method_23318() + 1337.0, BugClip.mc.field_1724.method_23321(), f, a22, false));
                    bugClip.cancelPacket = true;
                    bugClip.timer.reset();
                }
            }
            a.cancel();
        }
    }

    @Override
    public void onEnable() {
        BugClip bugClip;
        BugClip a;
        BugClip bugClip2 = a;
        bugClip2.cancelPacket = false;
        if (bugClip2.clipIn.getValue()) {
            a = BugClip.mc.field_1724.method_5735();
            BugClip.mc.field_1724.method_5814(BugClip.mc.field_1724.method_23317() + (double)a.method_10148() * 0.5, BugClip.mc.field_1724.method_23318(), BugClip.mc.field_1724.method_23321() + (double)a.method_10165() * 0.5);
            BugClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(BugClip.mc.field_1724.method_23317(), BugClip.mc.field_1724.method_23318(), BugClip.mc.field_1724.method_23321(), true));
            bugClip = bugClip2;
        } else {
            BugClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(BugClip.mc.field_1724.method_23317(), BugClip.mc.field_1724.method_23318(), BugClip.mc.field_1724.method_23321(), true));
            BugClip.mc.field_1724.method_5814(bugClip2.roundToClosest(BugClip.mc.field_1724.method_23317(), Math.floor(BugClip.mc.field_1724.method_23317()) + 0.23, Math.floor(BugClip.mc.field_1724.method_23317()) + 0.77), BugClip.mc.field_1724.method_23318(), bugClip2.roundToClosest(BugClip.mc.field_1724.method_23321(), Math.floor(BugClip.mc.field_1724.method_23321()) + 0.23, Math.floor(BugClip.mc.field_1724.method_23321()) + 0.77));
            BugClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(bugClip2.roundToClosest(BugClip.mc.field_1724.method_23317(), Math.floor(BugClip.mc.field_1724.method_23317()) + 0.23, Math.floor(BugClip.mc.field_1724.method_23317()) + 0.77), BugClip.mc.field_1724.method_23318(), bugClip2.roundToClosest(BugClip.mc.field_1724.method_23321(), Math.floor(BugClip.mc.field_1724.method_23321()) + 0.23, Math.floor(BugClip.mc.field_1724.method_23321()) + 0.77), true));
            bugClip = bugClip2;
        }
        bugClip.cancelPacket = true;
    }

    private /* synthetic */ double roundToClosest(double a, double a2, double a3) {
        double d = a - a2;
        if (a3 - a > d) {
            return a2;
        }
        return a3;
    }
}
