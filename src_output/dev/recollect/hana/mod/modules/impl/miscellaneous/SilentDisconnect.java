/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;

@Beta
public class SilentDisconnect
extends Module {
    public static SilentDisconnect INSTANCE;

    public SilentDisconnect() {
        SilentDisconnect a;
        SilentDisconnect silentDisconnect = a;
        super(FadeUtils.ALLATORIxDEMO("5^\u001dEW\u001c(T\u0018Y\u0003S\u001fEX\u001e"), Module.Category.Misc);
        silentDisconnect.setChinese(MathUtil.ALLATORIxDEMO("\u8e46\u5182\u676f\u4e73\u9075\u5193"));
        INSTANCE = silentDisconnect;
    }
}
