/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1429
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_310
 *  net.minecraft.class_3966
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.info.ClientInfo;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1429;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class TriggerBot
extends Module {
    public static TriggerBot INSTANCE;
    private final BooleanSetting targetMonsters;
    private final BooleanSetting targetAnimals;
    private final BooleanSetting targetPlayers;

    @Override
    public void onUpdate() {
        TriggerBot a;
        TriggerBot triggerBot = a;
        if (TriggerBot.mc.field_1724.method_7261(0.0f) == 1.0f && (a = TriggerBot.mc.field_1765) != null && a.method_17783() == class_239.class_240.field_1331) {
            class_1297 class_12972 = (a = (class_3966)a).method_17782();
            if (class_12972 instanceof class_1429 && !triggerBot.targetAnimals.getValue()) {
                return;
            }
            if (class_12972 instanceof class_1657 && !triggerBot.targetPlayers.getValue()) {
                return;
            }
            if (class_12972 instanceof class_1569 && !triggerBot.targetMonsters.getValue()) {
                return;
            }
            TriggerBot.mc.field_1761.method_2918((class_1657)TriggerBot.mc.field_1724, a.method_17782());
            TriggerBot.mc.field_1724.method_6104(class_1268.field_5808);
        }
    }

    public TriggerBot() {
        TriggerBot a;
        TriggerBot triggerBot = a;
        TriggerBot triggerBot2 = a;
        super(WebUtils.ALLATORIxDEMO("\u0007h=z4<Ek9"), Module.Category.Combat);
        TriggerBot triggerBot3 = a;
        triggerBot3.targetAnimals = triggerBot2.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("'7id+p\bm's28j"), true));
        triggerBot2.targetPlayers = triggerBot2.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("sg=4 M?{7bv>"), true));
        triggerBot.targetMonsters = triggerBot2.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("j2$|f:I&m=j6&j"), true));
        triggerBot.setChinese(WebUtils.ALLATORIxDEMO("\u81be\u52b5\u6568\u51e1\u674e\u8fd6\u76ea\u684a"));
        INSTANCE = triggerBot;
    }
}
