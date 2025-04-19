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
 *  net.minecraft.class_2596
 *  net.minecraft.class_2703
 *  net.minecraft.class_2703$class_2705
 *  net.minecraft.class_2703$class_5893
 *  net.minecraft.class_310
 *  net.minecraft.class_4048
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_7828
 */
package dev.recollect.hana.mod.modules.impl.render;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.asm.accessors.IEntity;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import java.awt.Color;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2703;
import net.minecraft.class_310;
import net.minecraft.class_4048;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_7828;

public class LogoutSpots
extends Module {
    private final ColorSetting color;
    private final BooleanSetting message;
    private final Map<UUID, class_1657> logoutCache;
    private final BooleanSetting text;
    private final BooleanSetting notify;
    private final BooleanSetting box;
    private final Map<UUID, class_1657> playerCache;
    private final BooleanSetting outline;

    @Override
    public void onUpdate() {
        Iterator a;
        LogoutSpots logoutSpots = a;
        a = LogoutSpots.mc.field_1687.method_18456().iterator();
        block0 : do {
            Iterator iterator = a;
            while (iterator.hasNext()) {
                class_1657 class_16572 = (class_1657)a.next();
                if (class_16572 == null) continue block0;
                if (class_16572.equals((Object)LogoutSpots.mc.field_1724)) {
                    iterator = a;
                    continue;
                }
                logoutSpots.playerCache.put(class_16572.method_7334().getId(), class_16572);
                iterator = a;
            }
            break;
        } while (true);
    }

    public LogoutSpots() {
        LogoutSpots a;
        LogoutSpots logoutSpots = a;
        super(Alt.ALLATORIxDEMO("\u0015K\u0019h(l\u0011s6p-"), Module.Category.Render);
        LogoutSpots logoutSpots2 = a;
        logoutSpots2.color = logoutSpots.add(new ColorSetting(CrystalUtil.ALLATORIxDEMO("\u0018_,X5"), new Color(255, 255, 255, 100)));
        logoutSpots.box = logoutSpots.add(new BooleanSetting(Alt.ALLATORIxDEMO("\u001bk&"), true));
        logoutSpots.outline = logoutSpots.add(new BooleanSetting(CrystalUtil.ALLATORIxDEMO("\u000b^/\\)Y\""), true));
        logoutSpots.text = logoutSpots.add(new BooleanSetting(Alt.ALLATORIxDEMO("W<|*"), true));
        logoutSpots.message = logoutSpots.add(new BooleanSetting(CrystalUtil.ALLATORIxDEMO("\tN(C!P\""), true));
        logoutSpots.notify = logoutSpots.add(new BooleanSetting(Alt.ALLATORIxDEMO("V-w0b'"), true));
        a.playerCache = Maps.newConcurrentMap();
        a.logoutCache = Maps.newConcurrentMap();
        a.setChinese(CrystalUtil.ALLATORIxDEMO("\u9030\u51ba\u6609\u797d"));
    }

    @Override
    public void onEnable() {
        LogoutSpots a;
        LogoutSpots logoutSpots = a;
        logoutSpots.playerCache.clear();
        logoutSpots.logoutCache.clear();
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive a) {
        block14 : {
            Object object;
            LogoutSpots logoutSpots;
            LogoutSpots a2;
            block9 : {
                block10 : {
                    logoutSpots = a2;
                    object = a.getPacket();
                    if (!(object instanceof class_2703)) break block9;
                    class_2703 class_27032 = (class_2703)object;
                    if (!class_27032.method_46327().contains((Object)class_2703.class_5893.field_29136)) break block10;
                    for (class_2703.class_2705 class_27052 : class_27032.method_46330()) {
                        Iterator<UUID> iterator = logoutSpots.logoutCache.keySet().iterator();
                        while (iterator.hasNext()) {
                            LogoutSpots logoutSpots2;
                            UUID uUID;
                            Iterator<UUID> iterator2;
                            block13 : {
                                block12 : {
                                    block11 : {
                                        uUID = iterator2.next();
                                        if (!uUID.equals(class_27052.comp_1107().getId())) {
                                            iterator = iterator2;
                                            continue;
                                        }
                                        a2 = logoutSpots.logoutCache.get(uUID);
                                        if (!Notify.INSTANCE.isOn() || Notify.INSTANCE.type.getValue() != Notify.Notifys.type.Both) break block11;
                                        if (!logoutSpots.message.getValue()) break block12;
                                        CommandManager.sendChatMessage("\u00a7e[!] \u00a7b" + a2.method_5477().getString() + " \u00a7alogged back at X: " + (int)a2.method_23317() + " Y: " + (int)a2.method_23318() + " Z: " + (int)a2.method_23321());
                                        logoutSpots2 = logoutSpots;
                                        break block13;
                                    }
                                    if (Notify.INSTANCE.isOn() && Notify.INSTANCE.type.getValue() == Notify.Notifys.type.Chat && logoutSpots.message.getValue()) {
                                        CommandManager.sendChatMessage("\u00a7e[!] \u00a7b" + a2.method_5477().getString() + " \u00a7alogged back at X: " + (int)a2.method_23317() + " Y: " + (int)a2.method_23318() + " Z: " + (int)a2.method_23321());
                                    }
                                }
                                logoutSpots2 = logoutSpots;
                            }
                            logoutSpots2.logoutCache.remove(uUID);
                            iterator = iterator2;
                        }
                    }
                }
                logoutSpots.playerCache.clear();
                return;
            }
            object = a.getPacket();
            if (!(object instanceof class_7828)) break block14;
            block2 : for (UUID uUID : ((class_7828)object).comp_1105()) {
                Iterator<UUID> iterator = logoutSpots.playerCache.keySet().iterator();
                block3 : do {
                    Iterator<UUID> iterator3 = iterator;
                    while (iterator3.hasNext()) {
                        UUID uUID2;
                        LogoutSpots logoutSpots3;
                        block17 : {
                            block16 : {
                                block15 : {
                                    uUID2 = iterator.next();
                                    if (!uUID2.equals(uUID)) {
                                        iterator3 = iterator;
                                        continue;
                                    }
                                    a2 = logoutSpots.playerCache.get(uUID2);
                                    if (logoutSpots.logoutCache.containsKey(uUID2)) continue block3;
                                    if (!Notify.INSTANCE.isOn() || Notify.INSTANCE.type.getValue() != Notify.Notifys.type.Both) break block15;
                                    if (!logoutSpots.message.getValue()) break block16;
                                    CommandManager.sendChatMessage("\u00a7e[!] \u00a7b" + a2.method_5477().getString() + " \u00a7clogged out at X: " + (int)a2.method_23317() + " Y: " + (int)a2.method_23318() + " Z: " + (int)a2.method_23321());
                                    logoutSpots3 = logoutSpots;
                                    break block17;
                                }
                                if (Notify.INSTANCE.isOn() && Notify.INSTANCE.type.getValue() == Notify.Notifys.type.Chat && logoutSpots.message.getValue()) {
                                    CommandManager.sendChatMessage("\u00a7e[!] \u00a7b" + a2.method_5477().getString() + " \u00a7clogged out at X: " + (int)a2.method_23317() + " Y: " + (int)a2.method_23318() + " Z: " + (int)a2.method_23321());
                                }
                            }
                            logoutSpots3 = logoutSpots;
                        }
                        logoutSpots3.logoutCache.put(uUID2, (class_1657)a2);
                        continue block3;
                    }
                    continue block2;
                    break;
                } while (true);
            }
            logoutSpots.playerCache.clear();
        }
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        Object a3;
        LogoutSpots logoutSpots = a3;
        Iterator<UUID> a22 = logoutSpots.logoutCache.keySet().iterator();
        block0 : do {
            Iterator<UUID> iterator = a22;
            while (iterator.hasNext()) {
                a3 = a22.next();
                if ((a3 = logoutSpots.logoutCache.get(a3)) == null) {
                    iterator = a22;
                    continue;
                }
                Render3DUtil.draw3DBox(a, ((IEntity)a3).getDimensions().method_30757(a3.method_19538()), logoutSpots.color.getValue(), logoutSpots.outline.getValue(), logoutSpots.box.getValue());
                if (!logoutSpots.text.getValue()) continue block0;
                Render3DUtil.drawText3D(a3.method_5477().getString(), new class_243(a3.method_23317(), ((IEntity)a3).getDimensions().method_30757((class_243)a3.method_19538()).field_1325 + 0.5, a3.method_23321()), ColorUtil.injectAlpha(logoutSpots.color.getValue(), 255));
                continue block0;
            }
            break;
        } while (true);
    }
}
