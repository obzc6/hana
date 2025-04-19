/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2761
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_640
 *  net.minecraft.class_7438
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.JelloUtil;
import dev.recollect.hana.mod.modules.impl.client.HUD;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.class_2596;
import net.minecraft.class_2761;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_640;
import net.minecraft.class_7438;
import net.minecraft.class_746;

public class ServerManager
implements Wrapper {
    boolean worldNull;
    private final Timer timeDelay;
    private final ArrayDeque<Float> tpsResult;
    private long time;
    private long tickTime;
    private float tps;

    public long serverRespondingTime() {
        ServerManager a;
        return a.timeDelay.getPassedTimeMs();
    }

    public int getPing() {
        ServerManager a;
        ServerManager serverManager = a;
        a = mc.method_1562().method_2871(ServerManager.mc.field_1724.method_5667());
        if (a == null) {
            return 0;
        }
        return a.method_2959();
    }

    public static float round2(double a) {
        return new BigDecimal(a).setScale(2, RoundingMode.HALF_UP).floatValue();
    }

    public ServerManager() {
        ServerManager a;
        ServerManager serverManager = a;
        ServerManager serverManager2 = a;
        serverManager.timeDelay = new Timer();
        serverManager.tpsResult = new ArrayDeque(20);
        serverManager.worldNull = true;
        Hana.EVENT_BUS.subscribe(a);
    }

    public float getTPS() {
        ServerManager a;
        return ServerManager.round2(a.tps);
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive receive) {
        PacketEvent.Receive a3 = receive;
        ServerManager a2 = this;
        if (!(a3.getPacket() instanceof class_7438)) {
            a2.timeDelay.reset();
        }
        if (a3.getPacket() instanceof class_2761) {
            if (a2.time != 0L) {
                ServerManager serverManager = a2;
                serverManager.tickTime = System.currentTimeMillis() - serverManager.time;
                if (serverManager.tpsResult.size() > 20) {
                    a2.tpsResult.poll();
                }
                a2.tpsResult.add(Float.valueOf(20.0f * (1000.0f / (float)a2.tickTime)));
                float a3 = 0.0f;
                Iterator<Float> iterator = a2.tpsResult.iterator();
                Iterator<Float> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    Float f = iterator.next();
                    a3 += MathUtil.clamp(f.floatValue(), 0.0f, 20.0f);
                    iterator2 = iterator;
                }
                a2.tps = a3 / (float)a2.tpsResult.size();
            }
            a2.time = System.currentTimeMillis();
        }
    }

    public float getTPSFactor() {
        ServerManager a;
        return (float)a.tickTime / 1000.0f;
    }

    public void run() {
        ServerManager a;
        JelloUtil.updateJello();
        if (a.worldNull && ServerManager.mc.field_1687 != null) {
            Hana.MODULE.onLogin();
            a.worldNull = false;
            return;
        }
        if (!a.worldNull && ServerManager.mc.field_1687 == null) {
            Hana.MODULE.onLogout();
            a.worldNull = true;
        }
    }

    public float getCurrentTPS() {
        ServerManager a;
        return ServerManager.round2(20.0f * ((float)a.tickTime / 1000.0f));
    }

    public boolean isServerNotResponding() {
        ServerManager a;
        return a.timeDelay.passedMs(HUD.INSTANCE.lagTime.getValue());
    }
}
