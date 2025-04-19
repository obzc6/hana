/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1657
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.DeathEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.function.Predicate;
import net.minecraft.class_1041;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_746;

public class Tips
extends Module {
    public static Tips INSTANCE;
    public final BooleanSetting turtle;
    private final Timer lagBackTimer;
    private final Timer lagTimer;
    int turtles;
    DecimalFormat df;
    public final BooleanSetting shulkerViewer;
    public final BooleanSetting deathCoords;
    private final SliderSetting yOffset;
    int color;
    public final BooleanSetting lagBack;
    public final BooleanSetting serverLag;

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender2D(class_332 class_3322, float f) {
        void a;
        float a22 = f;
        Tips a3 = this;
        if (a3.serverLag.getValue() && a3.lagTimer.passedS(1.4)) {
            Tips tips = a3;
            String string = a22 = "Server not responding (" + tips.df.format((double)tips.lagTimer.getPassedTimeMs() / 1000.0) + "s)";
            Objects.requireNonNull(Tips.mc.field_1772);
            a.method_51433(Tips.mc.field_1772, string, mc.method_22683().method_4486() / 2 - Tips.mc.field_1772.method_1727(string) / 2, 10 + 9, a3.color, true);
        }
        if (a3.lagBack.getValue() && !a3.lagBackTimer.passedS(1.5)) {
            String string = a22 = "Lagback (" + a3.df.format((double)(1500L - a3.lagBackTimer.getPassedTimeMs()) / 1000.0) + "s)";
            Objects.requireNonNull(Tips.mc.field_1772);
            a.method_51433(Tips.mc.field_1772, string, mc.method_22683().method_4486() / 2 - Tips.mc.field_1772.method_1727(string) / 2, 10 + 9 * 2, a3.color, true);
        }
        if (a3.turtle.getValue()) {
            String a22 = "\u00a7e" + a3.turtles;
            if (Tips.mc.field_1724.method_6059(class_1294.field_5907) && Tips.mc.field_1724.method_6112(class_1294.field_5907).method_5578() >= 2) {
                a22 = a22 + " \u00a7f" + (Tips.mc.field_1724.method_6112(class_1294.field_5907).method_5584() / 20 + 1);
            }
            String string = a22;
            Objects.requireNonNull(Tips.mc.field_1772);
            a.method_51433(Tips.mc.field_1772, string, mc.method_22683().method_4486() / 2 - Tips.mc.field_1772.method_1727(string) / 2, mc.method_22683().method_4502() / 2 + 9 - a3.yOffset.getValueInt(), -1, true);
        }
    }

    @Override
    public void onUpdate() {
        Tips a;
        if (a.turtle.getValue()) {
            a.turtles = InventoryUtil.getPotionCount(class_1294.field_5907);
        }
    }

    @EventHandler
    public void onPlayerDeath(DeathEvent deathEvent) {
        Object a = deathEvent;
        Tips a2 = this;
        a = ((DeathEvent)a).getPlayer();
        if (a2.deathCoords.getValue() && a == Tips.mc.field_1724) {
            CommandManager.sendChatMessage("\u00a74You died at " + (int)a.method_23317() + ", " + (int)a.method_23318() + ", " + (int)a.method_23321());
        }
    }

    @EventHandler
    public void onPacketEvent(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        Tips a2 = this;
        a2.lagTimer.reset();
        if (a.getPacket() instanceof class_2708) {
            a2.lagBackTimer.reset();
        }
    }

    public Tips() {
        Tips a;
        Tips tips = a;
        super(Setting.ALLATORIxDEMO("R,<|"), Module.Category.Misc);
        Tips tips2 = a;
        tips2.deathCoords = tips.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("\u000b@{VufuWu\u0016>"), true));
        tips.serverLag = tips.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u000by-m=t\t-h"), true));
        tips.lagBack = tips.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("QD}zf\u0011&"), true));
        tips.turtle = tips.add(new BooleanSetting(Setting.ALLATORIxDEMO("O-t1 j"), true).setParent());
        tips.yOffset = tips.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("Dj|^t\u00179"), 0, -200, 200, object -> {
            Object a = object;
            Tips a2 = this;
            return a2.turtle.isOpen();
        }));
        Tips tips3 = a;
        Tips tips4 = a;
        Tips tips5 = a;
        tips5.shulkerViewer = a.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u0011&xw3y-M1c2)}"), true));
        tips4.turtles = 0;
        tips5.lagTimer = new Timer();
        tips4.lagBackTimer = new Timer();
        tips4.df = new DecimalFormat(BlockUpUtil.ALLATORIxDEMO("7\\}"));
        tips3.color = new Color(190, 0, 0).getRGB();
        tips3.setChinese(Setting.ALLATORIxDEMO("\u639c\u7935"));
        INSTANCE = tips3;
    }
}
