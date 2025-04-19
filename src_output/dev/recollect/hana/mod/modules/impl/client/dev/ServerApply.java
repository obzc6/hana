/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2709
 *  net.minecraft.class_2720
 *  net.minecraft.class_2735
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.asm.accessors.IPlayerPositionLookS2CPacket;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2709;
import net.minecraft.class_2720;
import net.minecraft.class_2735;
import net.minecraft.class_2856;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class ServerApply
extends Module {
    public final BooleanSetting pack;
    public final BooleanSetting slot;
    private final Timer applyTimer;
    public static ServerApply INSTANCE;
    public final BooleanSetting rotate;
    public final BooleanSetting applyYaw;
    boolean send;

    @Override
    public void onUpdate() {
        ServerApply a;
        if (a.send && ServerApply.mc.field_1724 != null) {
            mc.method_1562().method_52787((class_2596)new class_2856(ServerApply.mc.field_1724.method_5667(), class_2856.class_2857.field_13016));
            mc.method_1562().method_52787((class_2596)new class_2856(ServerApply.mc.field_1724.method_5667(), class_2856.class_2857.field_47704));
            mc.method_1562().method_52787((class_2596)new class_2856(ServerApply.mc.field_1724.method_5667(), class_2856.class_2857.field_13017));
            a.send = false;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onPacketReceive(PacketEvent.Receive a) {
        var2_2 = a;
        if (!var2_2.pack.getValue() && a.getPacket() instanceof class_2720) {
            var2_2.send = true;
            a.cancel();
        }
        if (!var2_2.applyTimer.passed(1000L)) {
            return;
        }
        if (ServerApply.nullCheck()) {
            return;
        }
        if (var2_2.rotate.getValue() || !((var3_3 = a.getPacket()) instanceof class_2708)) ** GOTO lbl23
        v0 = a = (class_2708)var3_3;
        if (a.method_11733().contains((Object)class_2709.field_12401)) {
            ((IPlayerPositionLookS2CPacket)v0).setYaw(0.0f);
            v1 = a;
        } else {
            ((IPlayerPositionLookS2CPacket)v0).setYaw(ServerApply.mc.field_1724.method_36454());
            v1 = a;
        }
        v2 = a;
        if (v1.method_11733().contains((Object)class_2709.field_12397)) {
            ((IPlayerPositionLookS2CPacket)v2).setPitch(0.0f);
            v3 = var2_2;
        } else {
            ((IPlayerPositionLookS2CPacket)v2).setPitch(ServerApply.mc.field_1724.method_36455());
lbl23: // 2 sources:
            v3 = var2_2;
        }
        if (v3.slot.getValue() != false) return;
        var3_3 = a.getPacket();
        if (var3_3 instanceof class_2735 == false) return;
        a = (class_2735)var3_3;
        a.setCancelled(true);
        if (a.method_11803() == ServerApply.mc.field_1724.method_31548().field_7545) return;
        ServerApply.mc.method_1562().method_52787((class_2596)new class_2868(ServerApply.mc.field_1724.method_31548().field_7545));
    }

    public ServerApply() {
        ServerApply a;
        ServerApply serverApply = a;
        super(ObsidianHelper.ALLATORIxDEMO("\u0006h\u0014J2N\u0016P;Y'"), Module.Category.Client);
        ServerApply serverApply2 = a;
        serverApply2.rotate = serverApply.add(new BooleanSetting(Setting.ALLATORIxDEMO("I7r$8j"), true));
        serverApply.applyYaw = serverApply.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("}'L;Y\u0012T)"), true, object -> {
            Object a = object;
            ServerApply a2 = this;
            return !a2.rotate.getValue();
        }));
        ServerApply serverApply3 = a;
        a.slot = a.add(new BooleanSetting(Setting.ALLATORIxDEMO("U)#{"), true));
        a.pack = a.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("l0~\tI%_2p*V5"), true));
        a.send = false;
        serverApply3.applyTimer = new Timer();
        serverApply3.setChinese(Setting.ALLATORIxDEMO("\u6755\u52a7\u562d\u5ed8\u7527"));
        Hana.EVENT_BUS.subscribe(a);
        INSTANCE = serverApply3;
    }

    @Override
    public void disable() {
        a.state = true;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void enable() {
        a.state = true;
    }

    @Override
    public void onLogin() {
        ServerApply a;
        a.applyTimer.reset();
    }
}
