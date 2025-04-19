/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2743
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_2596;
import net.minecraft.class_2743;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class DamageFlyTest
extends Module {
    private boolean isVelocity;
    public SliderSetting boostTicks;
    private double motionY;
    public SliderSetting hurtTime;
    private int ticks;
    private double motionX;
    private boolean damage;
    private double motionZ;
    private boolean canBoost;

    @Override
    public void onUpdate() {
        DamageFlyTest a;
        if ((double)DamageFlyTest.mc.field_1724.field_6235 == a.hurtTime.getValue()) {
            a.damage = true;
        }
        if (a.damage && a.isVelocity) {
            if (a.canBoost) {
                DamageFlyTest.mc.field_1724.method_18800(a.motionX, a.motionY, a.motionZ);
                ++a.ticks;
            }
            if ((double)a.ticks >= a.boostTicks.getValue()) {
                DamageFlyTest damageFlyTest = a;
                DamageFlyTest damageFlyTest2 = a;
                damageFlyTest2.isVelocity = false;
                damageFlyTest2.canBoost = false;
                damageFlyTest.damage = false;
                damageFlyTest.ticks = 0;
            }
        }
    }

    public DamageFlyTest() {
        DamageFlyTest a;
        DamageFlyTest damageFlyTest = a;
        DamageFlyTest damageFlyTest2 = a;
        super(BaseChildSettings.ALLATORIxDEMO("\u0017A9F4_\b\u001c}"), Module.Category.Movement);
        DamageFlyTest damageFlyTest3 = a;
        damageFlyTest3.boostTicks = damageFlyTest2.add(new SliderSetting(Animation.ALLATORIxDEMO("IYh\\"), 8, 0, 40));
        damageFlyTest.hurtTime = damageFlyTest.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("h!U'n'\u001da"), 9, 1, 10));
        damageFlyTest.setChinese(Animation.ALLATORIxDEMO("\u4f2f\u5b84\u98d2"));
    }

    @EventHandler(priority=100)
    public void onPacketReceive(PacketEvent.Receive receive) {
        Object a = receive;
        DamageFlyTest a2 = this;
        if ((a = ((PacketEvent)a).getPacket()) instanceof class_2743) {
            if ((a = (class_2743)a).method_11816() > 0) {
                a2.isVelocity = true;
            }
            if ((double)a.method_11816() / 8000.0 > 0.2) {
                DamageFlyTest damageFlyTest = a2;
                Object object = a;
                a2.motionX = (double)a.method_11815() / 8000.0;
                a2.motionY = (double)object.method_11816() / 8000.0;
                damageFlyTest.motionZ = (double)object.method_11819() / 8000.0;
                damageFlyTest.canBoost = true;
            }
        }
    }

    @Override
    public void onEnable() {
        DamageFlyTest a;
        DamageFlyTest damageFlyTest = a;
        a.damage = false;
        damageFlyTest.canBoost = false;
        damageFlyTest.ticks = 0;
    }
}
