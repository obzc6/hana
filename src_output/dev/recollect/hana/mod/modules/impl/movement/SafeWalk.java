/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class SafeWalk
extends Module {
    public SafeWalk() {
        SafeWalk a;
        SafeWalk safeWalk = a;
        super(MathUtil.ALLATORIxDEMO("\u0005+\u0006\u0019:\u0010\u0006\u001d"), Alt.ALLATORIxDEMO("W\ny<1*fhT\u0012sl~%{#"), Module.Category.Movement);
        safeWalk.setChinese(MathUtil.ALLATORIxDEMO("\u5be4\u5119\u8826\u8d06"));
    }

    @EventHandler(priority=-100)
    public void onMove(MoveEvent moveEvent) {
        MoveEvent a = moveEvent;
        SafeWalk a2 = this;
        Object object = a;
        double d = ((MoveEvent)object).getX();
        double d2 = ((MoveEvent)object).getY();
        double d3 = ((MoveEvent)object).getZ();
        if (SafeWalk.mc.field_1724.method_24828()) {
            double d4 = 0.05;
            double d5 = d;
            while (d5 != 0.0 && a2.isOffsetBBEmpty(d, -1.0, 0.0)) {
                if (d < d4 && d >= -d4) {
                    d5 = d = 0.0;
                    continue;
                }
                if (d > 0.0) {
                    d5 = d - d4;
                    continue;
                }
                d5 = d + d4;
            }
            double d6 = d3;
            while (d6 != 0.0 && a2.isOffsetBBEmpty(0.0, -1.0, d3)) {
                if (d3 < d4 && d3 >= -d4) {
                    d6 = d3 = 0.0;
                    continue;
                }
                if (d3 > 0.0) {
                    d6 = d3 - d4;
                    continue;
                }
                d6 = d3 + d4;
            }
            double d7 = d;
            while (d7 != 0.0 && d3 != 0.0 && a2.isOffsetBBEmpty(d, -1.0, d3)) {
                double d8 = d < d4 && d >= -d4 ? 0.0 : (d = d > 0.0 ? d - d4 : d + d4);
                if (d3 < d4 && d3 >= -d4) {
                    d3 = 0.0;
                    d7 = d;
                    continue;
                }
                if (d3 > 0.0) {
                    d3 -= d4;
                    d7 = d;
                    continue;
                }
                d3 += d4;
                d7 = d;
            }
        }
        Object object2 = a;
        ((MoveEvent)object2).setX(d);
        ((MoveEvent)object2).setY(d2);
        a.setZ(d3);
    }

    public boolean isOffsetBBEmpty(double a, double a2, double a3) {
        return !SafeWalk.mc.field_1687.method_39454((class_1297)SafeWalk.mc.field_1724, SafeWalk.mc.field_1724.method_5829().method_989(a, a2, a3));
    }
}
