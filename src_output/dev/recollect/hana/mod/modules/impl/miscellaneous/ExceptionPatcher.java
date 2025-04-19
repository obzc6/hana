/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;

@Beta
public class ExceptionPatcher
extends Module {
    public static ExceptionPatcher INSTANCE;
    public final BooleanSetting log;

    public ExceptionPatcher() {
        ExceptionPatcher a;
        ExceptionPatcher exceptionPatcher = a;
        super(GaussianFilter.ALLATORIxDEMO("\u0006W7]j\u0002&L&t.W1V}\u0006"), Module.Category.Misc);
        exceptionPatcher.log = a.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("rw\u0013"), true));
        exceptionPatcher.setChinese(GaussianFilter.ALLATORIxDEMO("\u81b8\u5296\u9018\u518e"));
        INSTANCE = exceptionPatcher;
    }
}
