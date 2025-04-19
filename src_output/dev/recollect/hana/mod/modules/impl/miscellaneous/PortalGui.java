/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.mod.modules.Module;

public class PortalGui
extends Module {
    public static PortalGui INSTANCE;

    public PortalGui() {
        PortalGui a;
        PortalGui portalGui = a;
        super(Alt.ALLATORIxDEMO("\u001ct3D\u000bn\u001fk-"), Module.Category.Misc);
        portalGui.setChinese(HoleUtils.ALLATORIxDEMO("\u4f20\u903e\u95da\u5f0d\u7562\u9773"));
        INSTANCE = portalGui;
    }
}
