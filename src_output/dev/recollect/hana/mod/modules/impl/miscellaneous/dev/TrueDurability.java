/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.DurabilityEvent;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.client.SocketClient;

public class TrueDurability
extends Module {
    @EventHandler
    public void onDurability(DurabilityEvent durabilityEvent) {
        DurabilityEvent a = durabilityEvent;
        TrueDurability a2 = this;
        Object object = a;
        int n = ((DurabilityEvent)object).getItemDamage();
        if (((DurabilityEvent)object).getDamage() < 0) {
            n = a.getDamage();
        }
        a.cancel();
        a.setDamage(n);
    }

    public TrueDurability() {
        TrueDurability a;
        TrueDurability trueDurability = a;
        super(FPSManager.ALLATORIxDEMO("T\u00140FT\u0003e\u0010r\u001fa\u00023X"), Module.Category.Misc);
        trueDurability.setChinese(SocketClient.ALLATORIxDEMO("\u802a\u4e5a\u4fd9\u591f"));
    }
}
