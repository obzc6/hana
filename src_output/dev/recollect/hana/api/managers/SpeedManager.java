/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.Wrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class SpeedManager
implements Wrapper {
    public final HashMap<class_1657, Double> playerSpeeds;
    public double speedometerCurrentSpeed;

    public void updatePlayers() {
        SpeedManager a;
        Iterator iterator;
        SpeedManager speedManager = a;
        Iterator iterator2 = iterator = SpeedManager.mc.field_1687.method_18456().iterator();
        while (iterator2.hasNext()) {
            a = (class_1657)iterator.next();
            if (!((double)SpeedManager.mc.field_1724.method_5739((class_1297)a) < 400.0)) {
                iterator2 = iterator;
                continue;
            }
            SpeedManager speedManager2 = a;
            double d = speedManager2.method_23317() - ((class_1657)a).field_6014;
            double d2 = speedManager2.method_23321() - ((class_1657)a).field_5969;
            double d3 = d;
            double d4 = d2;
            d = d3 * d3 + d4 * d4;
            iterator2 = iterator;
            speedManager.playerSpeeds.put((class_1657)a, d);
        }
    }

    @EventHandler
    public void updateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        SpeedManager a2 = this;
        a2.updateValues();
    }

    public double turnIntoKpH(double a) {
        return (double)class_3532.method_15355((float)((float)a)) * 71.2729367892;
    }

    public void updateValues() {
        SpeedManager a;
        double d = SpeedManager.mc.field_1724.method_23317() - SpeedManager.mc.field_1724.field_6014;
        double d2 = SpeedManager.mc.field_1724.method_23321() - SpeedManager.mc.field_1724.field_5969;
        double d3 = d;
        double d4 = d2;
        a.speedometerCurrentSpeed = d3 * d3 + d4 * d4;
        a.updatePlayers();
    }

    public SpeedManager() {
        SpeedManager a;
        SpeedManager speedManager = a;
        speedManager.playerSpeeds = new HashMap();
        Hana.EVENT_BUS.subscribe(a);
    }

    public double getSpeedKpH() {
        SpeedManager a;
        SpeedManager speedManager = a;
        double d = speedManager.turnIntoKpH(speedManager.speedometerCurrentSpeed);
        d = (double)Math.round(10.0 * d) / 10.0;
        return d;
    }

    public double getPlayerSpeed(class_1657 class_16572) {
        SpeedManager a = class_16572;
        SpeedManager a2 = this;
        if (a2.playerSpeeds.get(a) == null) {
            return 0.0;
        }
        SpeedManager speedManager = a2;
        return speedManager.turnIntoKpH(speedManager.playerSpeeds.get(a));
    }
}
