/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1541
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.ClientInfo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1541;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class TNTExplosionTimer
extends Module {
    private final Map<class_1541, Long> tntTimers;
    public static TNTExplosionTimer INSTANCE;

    private /* synthetic */ boolean isEntityInWorld(class_1541 a) {
        Iterator a2;
        TNTExplosionTimer tNTExplosionTimer = a2;
        if (TNTExplosionTimer.mc.field_1687 != null) {
            a2 = TNTExplosionTimer.mc.field_1687.method_18112().iterator();
            while (a2.hasNext()) {
                if ((class_1297)a2.next() != a) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDisable() {
        TNTExplosionTimer a;
        a.tntTimers.clear();
    }

    @Override
    public void onUpdate() {
        Iterator<Object> a;
        TNTExplosionTimer tNTExplosionTimer = a;
        if (TNTExplosionTimer.mc.field_1687 == null || TNTExplosionTimer.mc.field_1724 == null) {
            return;
        }
        ArrayList<class_1541> arrayList = new ArrayList<class_1541>();
        for (Map.Entry entry : tNTExplosionTimer.tntTimers.entrySet()) {
            class_1541 class_15412 = (class_1541)entry.getKey();
            long l = System.currentTimeMillis();
            if (4000L - (l - (Long)entry.getValue()) > 0L && tNTExplosionTimer.isEntityInWorld(class_15412)) continue;
            arrayList.add(class_15412);
        }
        a = arrayList.iterator();
        Iterator<Object> iterator = a;
        while (iterator.hasNext()) {
            class_1541 class_15413 = (class_1541)a.next();
            iterator = a;
            tNTExplosionTimer.tntTimers.remove((Object)class_15413);
        }
        for (class_1297 class_12972 : TNTExplosionTimer.mc.field_1687.method_18112()) {
            if (class_12972.method_5864() != class_1299.field_6063 || tNTExplosionTimer.tntTimers.containsKey((Object)class_12972)) continue;
            tNTExplosionTimer.tntTimers.put((class_1541)class_12972, System.currentTimeMillis());
        }
    }

    @Override
    public void onRender3D(class_4587 a, float a3222) {
        Color a422;
        TNTExplosionTimer tNTExplosionTimer = a422;
        if (TNTExplosionTimer.mc.field_1687 == null || TNTExplosionTimer.mc.field_1724 == null) {
            return;
        }
        a = tNTExplosionTimer.tntTimers.entrySet().iterator();
        Iterator<Map.Entry<Object, Long>> iterator = a;
        while (iterator.hasNext()) {
            Map.Entry a3222 = (Map.Entry)a.next();
            class_1541 class_15412 = (class_1541)a3222.getKey();
            long l = System.currentTimeMillis();
            if ((l = 4000L - (l - (Long)a3222.getValue())) <= 0L) {
                iterator = a;
                continue;
            }
            int a3222 = (int)(l / 1000L);
            int a422 = (int)(l % 1000L / 100L);
            Object[] arrobject = new Object[2];
            arrobject[0] = a3222;
            arrobject[1] = a422;
            String a3222 = String.format(ClientInfo.ALLATORIxDEMO("g|{|$\u001f\u0007"), arrobject);
            float a422 = 1.0f;
            float f = Math.min(1.0f, (float)(4000L - l) / 2000.0f);
            float f2 = 1.0f - f;
            a422 = new Color(f, f2, 0.0f, a422);
            class_15412 = class_15412.method_19538().method_1031(0.0, 1.5, 0.0);
            iterator = a;
            Render3DUtil.drawText3D(class_2561.method_30163((String)a3222), (class_243)class_15412, 0.0, 0.0, 1.0, a422);
        }
    }

    public TNTExplosionTimer() {
        TNTExplosionTimer a;
        TNTExplosionTimer tNTExplosionTimer = a;
        super(SocketClient.ALLATORIxDEMO("LiVd|PiuLNmMRBcYk"), Module.Category.Render);
        TNTExplosionTimer tNTExplosionTimer2 = a;
        tNTExplosionTimer2.tntTimers = new HashMap<class_1541, Long>();
        tNTExplosionTimer.setDescription(ClientInfo.ALLATORIxDEMO("7M\u001aN\u001fN\u001b2>:4i>k<};t %<m$[\u0001#/e%y'8\u0001\u0018O#+j=j:w6'7"));
        tNTExplosionTimer.setChinese(SocketClient.ALLATORIxDEMO("VmR\u722d\u70b6\u65ca\u95ed"));
        INSTANCE = tNTExplosionTimer;
    }

    @Override
    public void onEnable() {
        TNTExplosionTimer a;
        a.tntTimers.clear();
    }
}
