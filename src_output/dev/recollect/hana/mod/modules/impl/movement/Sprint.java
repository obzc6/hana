/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1702
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.video.FileUtil;
import net.minecraft.class_1702;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public class Sprint
extends Module {
    public static Sprint INSTANCE;
    private final BooleanSetting legit;

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        Sprint a2 = this;
        if (!a2.legit.getValue()) {
            if (Sprint.mc.field_1724.method_7344().method_7586() <= 6) {
                return;
            }
            Sprint.mc.field_1724.method_5728(MovementUtil.isMoving() && !Sprint.mc.field_1724.method_5715());
        }
    }

    public Sprint() {
        Sprint a;
        Sprint sprint = a;
        Sprint sprint2 = a;
        super(FileUtil.ALLATORIxDEMO("O\u0003i\u001do\u001a"), Module.Category.Movement);
        Sprint sprint3 = a;
        sprint3.legit = sprint2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("\u0002G.Q'"), false));
        sprint.setDescription(FileUtil.ALLATORIxDEMO("9>Fq\u0012v\u0012k\u001eu\u000f{_}\u0012j\u0006#\u001c|\u001ea\u0012b_r\u001a!\u001d+FO'q\u0003i\u000f<\u001et\u0010d@"));
        sprint.setChinese(ObsidianHelper.ALLATORIxDEMO("\u81c8\u52e1\u7586\u8d82"));
        INSTANCE = sprint;
    }

    @Override
    public void onUpdate() {
        Sprint a;
        if (Sprint.nullCheck()) {
            return;
        }
        if (a.legit.getValue()) {
            Sprint.mc.field_1690.field_1867.method_23481(true);
        }
    }
}
