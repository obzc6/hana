/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2663
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.DeathEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TotemEvent;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.Module;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2663;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class PopManager
implements Wrapper {
    public final ArrayList<class_1657> deadPlayer;
    public final HashMap<String, Integer> popContainer;

    public void onDeath(class_1657 class_16572) {
        PopManager a = class_16572;
        PopManager a2 = this;
        a2.popContainer.remove(a.method_5477().getString());
    }

    public Integer getPop(String string) {
        String a = string;
        PopManager a2 = this;
        return a2.popContainer.getOrDefault(a, 0);
    }

    public void onTotemPop(class_1657 class_16572) {
        PopManager a = class_16572;
        PopManager a2 = this;
        int n = 1;
        if (a2.popContainer.containsKey(a.method_5477().getString())) {
            n = a2.popContainer.get(a.method_5477().getString());
            a2.popContainer.put(a.method_5477().getString(), ++n);
        } else {
            a2.popContainer.put(a.method_5477().getString(), n);
        }
        Hana.EVENT_BUS.post(new TotemEvent((class_1657)a));
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive receive) {
        Object a = receive;
        PopManager a2 = this;
        if (Module.nullCheck()) {
            return;
        }
        Object object = ((PacketEvent)a).getPacket();
        if (object instanceof class_2663 && (a = (class_2663)object).method_11470() == 35 && (object = a.method_11469((class_1937)PopManager.mc.field_1687)) instanceof class_1657) {
            a = (class_1657)object;
            a2.onTotemPop((class_1657)a);
        }
    }

    public PopManager() {
        PopManager a;
        PopManager popManager = a;
        a.popContainer = new HashMap();
        popManager.deadPlayer = new ArrayList();
        Hana.EVENT_BUS.subscribe(a);
    }

    public void update() {
        PopManager a;
        Iterator iterator;
        PopManager popManager = a;
        if (Module.nullCheck()) {
            return;
        }
        Iterator iterator2 = iterator = PopManager.mc.field_1687.method_18456().iterator();
        while (iterator2.hasNext()) {
            a = (class_1657)iterator.next();
            if (a == null || a.method_5805()) {
                popManager.deadPlayer.remove(a);
                iterator2 = iterator;
                continue;
            }
            if (popManager.deadPlayer.contains(a)) {
                iterator2 = iterator;
                continue;
            }
            Hana.EVENT_BUS.post(new DeathEvent((class_1657)a));
            PopManager popManager2 = popManager;
            popManager2.onDeath((class_1657)a);
            popManager2.deadPlayer.add((class_1657)a);
            iterator2 = iterator;
        }
    }
}
