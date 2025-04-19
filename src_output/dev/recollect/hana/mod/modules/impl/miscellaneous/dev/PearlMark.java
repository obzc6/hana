/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1684
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.EntitySpawnEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.class_1297;
import net.minecraft.class_1684;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_742;

public class PearlMark
extends Module {
    @EventHandler
    public void onReceivePacket(EntitySpawnEvent entitySpawnEvent) {
        Object a = entitySpawnEvent;
        PearlMark a2 = this;
        if (PearlMark.nullCheck()) {
            return;
        }
        class_1297 class_12972 = ((EntitySpawnEvent)a).getEntity();
        if (class_12972 instanceof class_1684) {
            a = (class_1684)class_12972;
            PearlMark.mc.field_1687.method_18456().stream().min(Comparator.comparingDouble(arg_0 -> PearlMark.lambda$onReceivePacket$0((class_1684)a, arg_0))).ifPresent(arg_0 -> PearlMark.lambda$onReceivePacket$1((class_1684)a, arg_0));
        }
    }

    public PearlMark() {
        PearlMark a;
        PearlMark pearlMark = a;
        super(TimerManager.ALLATORIxDEMO("\u001b\u001b-\u000b')7\\w"), Module.Category.Misc);
        pearlMark.setChinese(OnlineUserInfo.ALLATORIxDEMO("\u73ff\u73a5\u5426\u5b0b"));
    }

    private static /* synthetic */ void lambda$onReceivePacket$1(class_1684 class_16842, class_742 class_7422) {
        class_1684 a;
        class_1684 a2 = class_7422;
        class_1684 class_16843 = a = class_16842;
        class_16843.method_5665(a2.method_5477());
        class_16843.method_5880(true);
    }

    private static /* synthetic */ double lambda$onReceivePacket$0(class_1684 class_16842, class_742 class_7422) {
        class_1684 a = class_7422;
        class_1684 a2 = class_16842;
        return a.method_19538().method_1022(new class_243(a2.method_23317(), a2.method_23318(), a2.method_23321()));
    }
}
