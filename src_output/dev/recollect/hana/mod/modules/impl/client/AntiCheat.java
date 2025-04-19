/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_642
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.player.NoSwap;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.packet.Packet;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_642;
import net.minecraft.class_746;

public class AntiCheat
extends Module {
    private boolean needUpdate = true;

    @Override
    public void onUpdate() {
        String a;
        AntiCheat antiCheat;
        AntiCheat antiCheat2 = a;
        if (AntiCheat.nullCheck()) {
            return;
        }
        if (!antiCheat2.needUpdate) {
            return;
        }
        if (mc.method_1542()) {
            return;
        }
        a = AntiCheat.mc.field_1724.field_3944.method_45734().field_3761.toLowerCase();
        if (a.equals(Snow.ALLATORIxDEMO(";?6$.,|/"))) {
            CommandManager.sendChatMessage(Packet.ALLATORIxDEMO("[Y0\u0012Oy4paGu]^> w-l5dGg"));
            HoleKick.INSTANCE.yawDeceive.setValue(false);
            PistonCrystal.INSTANCE.yawDeceive.setValue(false);
            CombatSetting.INSTANCE.invSwapBypass.setValue(false);
            NoSwap.INSTANCE.disable();
            antiCheat = antiCheat2;
        } else {
            if (a.equals(Snow.ALLATORIxDEMO("\"z%Q\u0002h1t&pzv/"))) {
                CommandManager.sendChatMessage(Packet.ALLATORIxDEMO("ao\\uGk\t\u0017\u001cUz}T.jaMJjsYOnK\u0012Mg"));
                HoleKick.INSTANCE.yawDeceive.setValue(true);
                PistonCrystal.INSTANCE.yawDeceive.setValue(true);
                CombatSetting.INSTANCE.invSwapBypass.setValue(true);
                NoSwap.INSTANCE.enable();
            }
            antiCheat = antiCheat2;
        }
        antiCheat.needUpdate = false;
    }

    @Override
    public void onLogin() {
        a.needUpdate = true;
    }

    public AntiCheat() {
        super(Snow.ALLATORIxDEMO("7g)m\u0013h1t5"), Module.Category.Client);
        AntiCheat a;
        a.setChinese(Packet.ALLATORIxDEMO("\u53f5\u4f47\u5f36\u8bb0\u7f47"));
    }
}
