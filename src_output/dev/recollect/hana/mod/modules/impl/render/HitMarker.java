/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_2596
 *  net.minecraft.class_2824
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.ClientInfo;
import net.minecraft.class_1041;
import net.minecraft.class_2596;
import net.minecraft.class_2824;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class HitMarker
extends Module {
    public SliderSetting time;
    public Timer timer;
    private final class_2960 marker;
    public int ticks;

    public HitMarker() {
        HitMarker a;
        HitMarker hitMarker = a;
        super(ClientInfo.ALLATORIxDEMO("\u0006m=N/l81k"), Module.Category.Render);
        HitMarker hitMarker2 = a;
        hitMarker2.time = hitMarker.add(new SliderSetting(Vec3.ALLATORIxDEMO("%g\na\\L\u001bb\u0000"), 3, 0, 60));
        hitMarker.marker = new class_2960(ClientInfo.ALLATORIxDEMO("v2:x"), Vec3.ALLATORIxDEMO("\u000bY.q\u0017}\u000es\u000e6\u0002a\u0002"));
        hitMarker.timer = new Timer();
        a.ticks = 114514;
        a.setChinese(ClientInfo.ALLATORIxDEMO("\u51c5\u6651\u88db\u9923\u722d\u6551"));
    }

    @Override
    public void onRender2D(class_332 class_3322, float f) {
        HitMarker a = class_3322;
        HitMarker a2 = this;
        if (a2.timer.passedMs(0L)) {
            HitMarker hitMarker = a2;
            hitMarker.timer.reset();
            if ((float)hitMarker.ticks <= a2.time.getValueFloat()) {
                HitMarker hitMarker2 = a2;
                ++hitMarker2.ticks;
                a.method_25291(hitMarker2.marker, mc.method_22683().method_4486() / 2 - 8, mc.method_22683().method_4502() / 2 - 8, 0, 0.0f, 0.0f, 16, 16, 16, 16);
            }
        }
    }

    @Override
    public void onEnable() {
        HitMarker a;
        a.ticks = 114514;
        a.timer.reset();
    }

    @EventHandler
    public void onpacket(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        HitMarker a2 = this;
        if (a.getPacket() instanceof class_2824) {
            a2.ticks = 0;
        }
    }
}
