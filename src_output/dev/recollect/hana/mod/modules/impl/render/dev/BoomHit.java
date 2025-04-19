/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents$EndTick
 *  net.fabricmc.fabric.api.event.Event
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2400
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3966
 *  net.minecraft.class_5819
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.mod.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2400;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_5819;
import net.minecraft.class_638;

public class BoomHit
extends Module {
    private boolean hasPlayedParticles;
    private final AttackEntityCallback registeredCallback;
    private static final long PARTICLE_DURATION = 100L;
    private long lastParticleTime;

    @Override
    public void onDisable() {
        BoomHit a;
        BoomHit boomHit = a;
        boomHit.hasPlayedParticles = false;
        boomHit.lastParticleTime = 0L;
    }

    @Override
    public void onEnable() {
        BoomHit a;
        AttackEntityCallback.EVENT.register((Object)a.registeredCallback);
        ClientTickEvents.END_CLIENT_TICK.register((Object)((ClientTickEvents.EndTick)class_3102 -> {
            BoomHit a = class_3102;
            BoomHit a2 = this;
            a2.onUpdate();
        }));
    }

    public BoomHit() {
        BoomHit a;
        BoomHit boomHit = a;
        super(Alt.ALLATORIxDEMO("\u0002P\ns\fj-"), BlockUpUtil.ALLATORIxDEMO("nmHoQ=MoYzQr\u000b2F7YwHq\u000b>bTP<TtDp$SLnLn\u001e(\u0005LiLnQb\u0001c"), Module.Category.Render);
        boomHit.hasPlayedParticles = false;
        boomHit.lastParticleTime = 0L;
        a.registeredCallback = (class_16572, class_19372, class_12682, class_12972, class_39662) -> {
            void a;
            BoomHit a2 = class_16572;
            BoomHit a3 = this;
            if (a instanceof class_638 && a3.isOn()) {
                long l = System.currentTimeMillis();
                if (!a3.hasPlayedParticles || l - a3.lastParticleTime >= 100L) {
                    int a4;
                    void a5;
                    a2 = a5.method_19538();
                    int n = a4 = 0;
                    while (n < 50) {
                        void v1 = a;
                        double d = v1.field_9229.method_43058() * 1.0 - 1.0;
                        double d2 = v1.field_9229.method_43058() * 1.0 - 1.0;
                        double d3 = v1.field_9229.method_43058() * 1.0 - 1.0;
                        ((class_638)v1).method_8406((class_2394)class_2398.field_11236, ((class_243)a2).field_1352 + d, ((class_243)a2).field_1351 + d2, ((class_243)a2).field_1350 + d3, 0.0, 0.0, 0.0);
                        n = ++a4;
                    }
                    a3.hasPlayedParticles = true;
                    a3.lastParticleTime = l;
                }
            }
            return class_1269.field_5811;
        };
        a.setChinese(Alt.ALLATORIxDEMO("\u6504\u519e\u7218\u70fc\u727a\u6511"));
    }

    @Override
    public void onUpdate() {
        BoomHit a;
        long l = System.currentTimeMillis();
        if (a.hasPlayedParticles && l - a.lastParticleTime >= 100L) {
            a.hasPlayedParticles = false;
        }
    }
}
