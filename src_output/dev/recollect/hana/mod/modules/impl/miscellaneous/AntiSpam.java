/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_7439
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_7439;

public class AntiSpam
extends Module {
    private final StringSetting name;

    @EventHandler
    private /* synthetic */ void PacketReceive(PacketEvent.Receive a) {
        AntiSpam a2;
        AntiSpam antiSpam = a2;
        a2 = a.getPacket();
        if (a2 instanceof class_7439 && ((class_7439)a2).comp_763().getString().contains(antiSpam.name.getValue())) {
            a.cancel();
        }
    }

    public AntiSpam() {
        AntiSpam a;
        AntiSpam antiSpam = a;
        super(Snow.ALLATORIxDEMO("qUgqQyoh"), Module.Category.Misc);
        AntiSpam antiSpam2 = a;
        antiSpam.name = antiSpam.add(new StringSetting(MathUtil.ALLATORIxDEMO(".\u001d\u0001\u0015"), Snow.ALLATORIxDEMO("piEZ}Geh`Z")));
        antiSpam.setChinese(MathUtil.ALLATORIxDEMO("\u53b1\u525b\u5c3f"));
    }
}
