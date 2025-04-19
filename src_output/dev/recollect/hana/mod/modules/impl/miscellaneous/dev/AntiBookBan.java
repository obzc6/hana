/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.Module;
import org.bytedeco.javacv.BaseSettings;

public class AntiBookBan
extends Module {
    public static AntiBookBan INSTANCE;

    public AntiBookBan() {
        AntiBookBan a;
        AntiBookBan antiBookBan = a;
        super(BaseSettings.ALLATORIxDEMO("BXw[EtASOVl"), Module.Category.Misc);
        antiBookBan.setChinese(Animation.ALLATORIxDEMO("\u53d4\u4e4b\u5d3f"));
        INSTANCE = antiBookBan;
    }
}
