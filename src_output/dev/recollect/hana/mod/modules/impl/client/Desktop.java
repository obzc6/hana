/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 *  net.minecraft.class_7439
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TotemEvent;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_7439;
import net.minecraft.class_746;

public class Desktop
extends Module {
    private final BooleanSetting onlyTabbed;
    private final BooleanSetting mention;
    private List<class_1297> players;
    private final List<class_1297> knownPlayers;
    private static final Image image;
    private final BooleanSetting visualRange;
    final TrayIcon icon;
    private final BooleanSetting dm;
    private static InputStream inputStream;
    private final BooleanSetting selfPop;

    @EventHandler
    public void onClientChatReceived(PacketEvent.Receive receive) {
        Object a = receive;
        Desktop a2 = this;
        if (Desktop.nullCheck()) {
            return;
        }
        if ((a = ((PacketEvent)a).getPacket()) instanceof class_7439) {
            if (((String)(a = String.valueOf((Object)((class_7439)a).comp_763()))).contains(Desktop.mc.field_1724.method_5477().getString()) && a2.mention.getValue()) {
                a2.icon.displayMessage(Alt.ALLATORIxDEMO("\u0010i*o\tw+i)"), TipUtils.ALLATORIxDEMO("=\u001f\"m\u0001#\u00059B,\u000b0\u0005$\r\"B"), TrayIcon.MessageType.INFO);
            }
            if (((String)a).contains(Alt.ALLATORIxDEMO(")t/p)}0tg")) && a2.dm.getValue()) {
                a2.icon.displayMessage(TipUtils.ALLATORIxDEMO(",4\u00022!\"\u000b\"\u0017"), Alt.ALLATORIxDEMO("\rf.ygZ\u001bw+p~q#p*y%b|"), TrayIcon.MessageType.INFO);
            }
        }
    }

    private /* synthetic */ void addIcon() {
        SystemTray a22;
        Desktop desktop = a22;
        a22 = SystemTray.getSystemTray();
        Desktop desktop2 = desktop;
        desktop2.icon.setImageAutoSize(true);
        desktop2.icon.setToolTip(TipUtils.ALLATORIxDEMO("\u0015\u0001/\u0000\f\u001c.\u0006,Z\u001b\u0003/\f \u000f\u0004-?3.\u0006-D"));
        try {
            a22.add(desktop.icon);
            return;
        }
        catch (AWTException a22) {
            a22.printStackTrace();
            return;
        }
    }

    @EventHandler
    public void onTotemPop(TotemEvent totemEvent) {
        TotemEvent a = totemEvent;
        Desktop a2 = this;
        if (Desktop.nullCheck() || a.getPlayer() != Desktop.mc.field_1724 || !a2.selfPop.getValue()) {
            return;
        }
        a2.icon.displayMessage(Alt.ALLATORIxDEMO("\u0010i*o\tw+i)"), TipUtils.ALLATORIxDEMO("%<2H=\u0001(B5\u0005\b'.\u0006?V"), TrayIcon.MessageType.WARNING);
    }

    public Desktop() {
        Desktop a;
        Desktop desktop = a;
        super(Alt.ALLATORIxDEMO("\u0002f*s6h-"), TipUtils.ALLATORIxDEMO(",=\u0004O.\u001ef'.\u001a5\u0015oJ"), Module.Category.Client);
        desktop.icon = new TrayIcon(image, Alt.ALLATORIxDEMO("\u0010i*o\tw+i)"));
        desktop.onlyTabbed = a.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("\u000e\u0000*\u0010\u0015\u000f>\u0011s]"), false));
        desktop.visualRange = desktop.add(new BooleanSetting(Alt.ALLATORIxDEMO("\u001em-i'o\u000by,`8"), true));
        desktop.selfPop = desktop.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("\u0012\u00065\u000b1#yI"), true));
        desktop.mention = desktop.add(new BooleanSetting(Alt.ALLATORIxDEMO("\u000bf7l+h3"), true));
        a.dm = desktop.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("Rt"), true));
        a.knownPlayers = new ArrayList<class_1297>();
        a.setChinese(Alt.ALLATORIxDEMO("\u684b\u973f"));
    }

    @Override
    public void onEnable() {
        Desktop a;
        a.addIcon();
    }

    private /* synthetic */ void removeIcon() {
        Desktop a;
        SystemTray.getSystemTray().remove(a.icon);
    }

    @Override
    public void onDisable() {
        Desktop a;
        Desktop desktop = a;
        desktop.knownPlayers.clear();
        desktop.removeIcon();
    }

    @Override
    public void onUpdate() {
        Desktop a22;
        Desktop desktop = a22;
        if (Desktop.nullCheck() || !desktop.visualRange.getValue()) {
            return;
        }
        try {
            if (desktop.onlyTabbed.getValue()) {
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        desktop.players = Desktop.mc.field_1687.method_18456().stream().filter(Objects::nonNull).collect(Collectors.toList());
        try {
            for (class_1297 a22 : desktop.players) {
                if (!(a22 instanceof class_1657) || a22.method_5477().equals((Object)Desktop.mc.field_1724.method_5477()) || desktop.knownPlayers.contains((Object)a22)) continue;
                if (FriendManager.isFriend(a22.method_5477().getString())) continue;
                Desktop desktop2 = desktop;
                desktop2.knownPlayers.add(a22);
                desktop2.icon.displayMessage(TipUtils.ALLATORIxDEMO("99\u000f%63\u001a#\u0016"), String.valueOf((Object)a22.method_5477()) + " has entered your visual range!", TrayIcon.MessageType.INFO);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            desktop.knownPlayers.removeIf(class_12972 -> {
                Desktop a = class_12972;
                Desktop a2 = this;
                return a instanceof class_1657 && !a.method_5477().equals((Object)Desktop.mc.field_1724.method_5477()) && !a2.players.contains(a);
            });
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    static {
        inputStream = Hana.class.getClassLoader().getResourceAsStream(Alt.ALLATORIxDEMO(" m7w<jln07fP\u001bs.pqu%l762i:"));
        try {
            image = ImageIO.read(inputStream);
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }
}
