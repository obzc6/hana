/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.BedAura;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class BlockStrafe
extends Module {
    private final SliderSetting speed;
    private final SliderSetting aForward;
    public static BlockStrafe INSTANCE;
    private final SliderSetting bSpeed;
    private final SliderSetting aSpeed;

    public BlockStrafe() {
        BlockStrafe a;
        BlockStrafe blockStrafe = a;
        BlockStrafe blockStrafe2 = a;
        super(ProjectionUtils.ALLATORIxDEMO("\u0013\\\u0019U\u001bv\u0017P\u0005G\u0002"), Module.Category.Movement);
        BlockStrafe blockStrafe3 = a;
        blockStrafe3.speed = blockStrafe2.add(new SliderSetting(WebUtils.ALLATORIxDEMO("]&t>I>ba)"), 10.0, 0.0, 20.0, 1.0));
        blockStrafe2.aSpeed = blockStrafe2.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("\u0010^\u0015^\u001fW0R\u0001D\u0003"), 3.0, 0.0, 20.0, 1.0));
        blockStrafe2.aForward = blockStrafe2.add(new SliderSetting(WebUtils.ALLATORIxDEMO("Wh,;u&[<h9fv)"), 1.0, 0.0, 20.0, 0.25));
        blockStrafe.bSpeed = blockStrafe2.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("t\u0015A0R\u0001D\u0003"), 3.0, 0.0, 20.0, 1.0));
        blockStrafe.setChinese(WebUtils.ALLATORIxDEMO("\u65ea\u574d\u703b\u6d3c\u79ff\u52e5"));
        INSTANCE = blockStrafe;
    }

    @EventHandler
    public void onMove(MoveEvent moveEvent) {
        double d;
        MoveEvent a = moveEvent;
        BlockStrafe a2 = this;
        if (!EntityUtil.isInsideBlock()) {
            return;
        }
        if (HoleKick.isInWeb((class_1657)BlockStrafe.mc.field_1724)) {
            return;
        }
        if (AnchorAura.INSTANCE.currentPos == null) {
            BlockStrafe blockStrafe = a2;
            d = BedAura.placePos == null ? blockStrafe.speed.getValue() : blockStrafe.bSpeed.getValue();
        } else {
            d = a2.aSpeed.getValue();
        }
        double d2 = d;
        d2 = 0.002873 * d2;
        double d3 = BlockStrafe.mc.field_1724.field_3913.field_3905;
        double d4 = BlockStrafe.mc.field_1724.field_3913.field_3907;
        double d5 = BlockStrafe.mc.field_1724.method_36454();
        if (d3 == 0.0 && d4 == 0.0) {
            if (AnchorAura.INSTANCE.currentPos == null) {
                Object object = a;
                ((MoveEvent)object).setX(0.0);
                ((MoveEvent)object).setZ(0.0);
                return;
            }
            d2 = 0.002873 * a2.aForward.getValue();
            Object object = a;
            ((MoveEvent)object).setX(1.0 * d2 * -Math.sin(Math.toRadians(d5)));
            ((MoveEvent)object).setZ(1.0 * d2 * Math.cos(Math.toRadians(d5)));
            return;
        }
        if (d3 != 0.0 && d4 != 0.0) {
            d3 *= Math.sin(0.7853981633974483);
            d4 *= Math.cos(0.7853981633974483);
        }
        Object object = a;
        double d6 = d3;
        ((MoveEvent)object).setX(d6 * d2 * -Math.sin(Math.toRadians(d5)) + d4 * d2 * Math.cos(Math.toRadians(d5)));
        ((MoveEvent)object).setZ(d6 * d2 * Math.cos(Math.toRadians(d5)) - d4 * d2 * -Math.sin(Math.toRadians(d5)));
    }
}
