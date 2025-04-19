/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.info.ClientInfo;

public class ShulkerViewer
extends Module {
    public static ShulkerViewer INSTANCE;

    public ShulkerViewer() {
        ShulkerViewer a;
        ShulkerViewer shulkerViewer = a;
        super(CrystalUtil.ALLATORIxDEMO("\u0015z\u0017A6D#e*D&S4"), Module.Category.Misc);
        shulkerViewer.setChinese(ClientInfo.ALLATORIxDEMO("\u6f12\u5f6f\u7681\u905b\u89df"));
        INSTANCE = shulkerViewer;
    }
}
