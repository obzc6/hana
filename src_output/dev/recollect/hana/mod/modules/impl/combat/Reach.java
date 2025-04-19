/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;

public class Reach
extends Module {
    public static Reach INSTANCE;
    public final SliderSetting distance;

    public Reach() {
        Reach a;
        Reach reach = a;
        super(OnlineUserInfo.ALLATORIxDEMO("\u0004F5K7"), Module.Category.Combat);
        reach.distance = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("w\u000eG\u0014H\u0013\u0000R"), 5.0, 1.0, 15.0, 0.1));
        reach.setChinese(OnlineUserInfo.ALLATORIxDEMO("\u952b\u81ea\u7360"));
        INSTANCE = reach;
    }
}
