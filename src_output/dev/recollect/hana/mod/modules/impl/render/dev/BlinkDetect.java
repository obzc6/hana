/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.DeathEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class BlinkDetect
extends Module {
    private final BooleanSetting text;
    private final Map<UUID, Data> playerCaches;
    private final BooleanSetting outline;
    private final BooleanSetting message;
    private final Map<UUID, Data> blinkCaches;
    private final Timer timer;
    private final BooleanSetting box;
    private final ColorSetting color;

    @Override
    public void onUpdate() {
        BlinkDetect a;
        BlinkDetect blinkDetect = a;
        if (!blinkDetect.timer.passedS(1.0)) {
            return;
        }
        blinkDetect.timer.reset();
        Iterator iterator = BlinkDetect.mc.field_1687.method_18456().iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = (class_1657)iterator.next();
                if (a == null) continue block0;
                if (a.equals((Object)BlinkDetect.mc.field_1724)) {
                    iterator2 = iterator;
                    continue;
                }
                Data data = blinkDetect.playerCaches.get(a.method_7334().getId());
                if (data != null && BlockUtil.distanceToXZ(data.pos.field_1352, data.pos.field_1350, a.method_23317(), a.method_23321()) > 20.0) {
                    if (blinkDetect.message.getValue()) {
                        CommandManager.sendChatMessage("\u00a7f" + a.method_5477().getString() + " \u00a7rTeleported to \u00a7f" + a.method_31477() + ", " + a.method_31478() + ", " + a.method_31479());
                    }
                    blinkDetect.blinkCaches.put(a.method_7334().getId(), data);
                }
                BlinkDetect blinkDetect2 = a;
                blinkDetect.playerCaches.put(a.method_7334().getId(), new Data((class_1657)blinkDetect2, blinkDetect2.method_19538()));
                iterator2 = iterator;
            }
            break;
        } while (true);
    }

    public BlinkDetect() {
        BlinkDetect a;
        BlinkDetect blinkDetect = a;
        super(TimerManager.ALLATORIxDEMO("\\\u0015\"\u0010'=.\u00103Mh"), Module.Category.Render);
        BlinkDetect blinkDetect2 = a;
        blinkDetect2.color = blinkDetect.add(new ColorSetting(TimeHelper.ALLATORIxDEMO("!R\u0013\u0018G"), new Color(255, 255, 255, 100)));
        blinkDetect.box = blinkDetect.add(new BooleanSetting(TimerManager.ALLATORIxDEMO("\u0014Ad"), true));
        blinkDetect.outline = blinkDetect.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("*U\u0016Q\u0016\u0019P"), true));
        blinkDetect.text = blinkDetect.add(new BooleanSetting(TimerManager.ALLATORIxDEMO("03Vh"), true));
        blinkDetect.message = blinkDetect.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("(E\u0011N\u001e\u0010P"), true));
        blinkDetect.playerCaches = Maps.newConcurrentMap();
        a.blinkCaches = Maps.newConcurrentMap();
        a.timer = new Timer();
        a.setChinese(TimerManager.ALLATORIxDEMO("\u77c8\u79ad\u68ee\u67f9"));
    }

    public class_238 getBoxAt(class_243 class_2432) {
        BlinkDetect a22 = class_2432;
        BlinkDetect a = this;
        BlinkDetect blinkDetect = a22;
        double d = blinkDetect.method_10216();
        double d2 = blinkDetect.method_10214();
        double d3 = blinkDetect.method_10215();
        float a22 = 0.3f;
        float f = 1.8f;
        return new class_238(d - (double)a22, d2, d3 - (double)a22, d + (double)a22, d2 + (double)f, d3 + (double)a22);
    }

    @Override
    public void onRender3D(class_4587 a, float a2) {
        BlinkDetect a322;
        BlinkDetect blinkDetect = a322;
        for (Data a322 : blinkDetect.blinkCaches.values()) {
            BlinkDetect blinkDetect2 = blinkDetect;
            Render3DUtil.draw3DBox((class_4587)a, blinkDetect.getBoxAt(a322.pos()), blinkDetect2.color.getValue(), blinkDetect.outline.getValue(), blinkDetect.box.getValue());
            if (!blinkDetect2.text.getValue()) continue;
            Render3DUtil.drawText3D(a322.player().method_5477().getString() + " Teleported", new class_243(a322.pos.method_10216(), blinkDetect.getBoxAt((class_243)a322.pos).field_1325 + 0.5, a322.pos.method_10215()), ColorUtil.injectAlpha(blinkDetect.color.getValue(), 255));
        }
    }

    @Override
    public void onEnable() {
        BlinkDetect a;
        BlinkDetect blinkDetect = a;
        blinkDetect.playerCaches.clear();
        blinkDetect.blinkCaches.clear();
    }

    @EventHandler
    public void onDeath(DeathEvent deathEvent) {
        DeathEvent a = deathEvent;
        BlinkDetect a2 = this;
        a2.playerCaches.remove(a.getPlayer().method_7334().getId());
        a2.blinkCaches.remove(a.getPlayer().method_7334().getId());
    }

    @Override
    public void onLogin() {
        BlinkDetect a;
        BlinkDetect blinkDetect = a;
        blinkDetect.playerCaches.clear();
        blinkDetect.blinkCaches.clear();
    }

    private static final class Data
    extends Record {
        private final class_243 pos;
        private final class_1657 player;

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ Data(class_1657 class_16572, class_243 class_2432) {
            Data a;
            void a2;
            Data a3 = class_2432;
            Data data = a = this;
            data.player = a2;
            data.pos = a3;
        }

        public class_1657 player() {
            Data a;
            return a.player;
        }

        @Override
        public final int hashCode() {
            Data a;
            return (int)ObjectMethods.bootstrap(new MethodHandle[]{Data.class, "player;pos", }