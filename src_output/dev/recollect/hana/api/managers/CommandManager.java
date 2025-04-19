/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_329
 *  net.minecraft.class_338
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.interfaces.IChatHud;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.commands.impl.AimCommand;
import dev.recollect.hana.mod.commands.impl.BindCommand;
import dev.recollect.hana.mod.commands.impl.ClipCommand;
import dev.recollect.hana.mod.commands.impl.FriendCommand;
import dev.recollect.hana.mod.commands.impl.GamemodeCommand;
import dev.recollect.hana.mod.commands.impl.HelpCommand;
import dev.recollect.hana.mod.commands.impl.IRCCommand;
import dev.recollect.hana.mod.commands.impl.LoadCommand;
import dev.recollect.hana.mod.commands.impl.PrefixCommand;
import dev.recollect.hana.mod.commands.impl.RejoinCommand;
import dev.recollect.hana.mod.commands.impl.ReloadAllCommand;
import dev.recollect.hana.mod.commands.impl.ReloadCommand;
import dev.recollect.hana.mod.commands.impl.SaveCommand;
import dev.recollect.hana.mod.commands.impl.TeleportCommand;
import dev.recollect.hana.mod.commands.impl.Toggle2Command;
import dev.recollect.hana.mod.commands.impl.ToggleCommand;
import dev.recollect.hana.mod.commands.impl.WatermarkCommand;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_338;

public class CommandManager
implements Wrapper {
    public final TeleportCommand tp;
    public final ReloadCommand reload;
    public final IRCCommand irc;
    public final BindCommand bind;
    public final Toggle2Command t;
    public final HelpCommand help;
    public final GamemodeCommand gamemode;
    public final PrefixCommand prefix;
    public final ToggleCommand toggle;
    public final ReloadAllCommand reloadHack;
    public final SaveCommand save;
    public static final String syncCode = "\u00a7(";
    public final WatermarkCommand watermark;
    public final FriendCommand friend;
    public final ClipCommand clip;
    private final HashMap<String, Command> commands;
    public final AimCommand aim;
    public final LoadCommand load;
    public final RejoinCommand rejoin;

    public static void sendChatMessageWidthIdNoSync(String string, int n) {
        int a = n;
        String a2 = string;
        if (Module.nullCheck()) {
            return;
        }
        ((IChatHud)CommandManager.mc.field_1705.method_1743()).nullpoint_nextgen_master$add(class_2561.method_30163((String)("\u00a7f" + a2)), a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CommandManager() {
        CommandManager a22;
        CommandManager commandManager = a22;
        CommandManager commandManager2 = commandManager;
        commandManager.commands = new HashMap();
        commandManager2.aim = new AimCommand();
        commandManager.bind = new BindCommand();
        commandManager.clip = new ClipCommand();
        commandManager.friend = new FriendCommand();
        commandManager.gamemode = new GamemodeCommand();
        commandManager.help = new HelpCommand();
        commandManager.prefix = new PrefixCommand();
        commandManager.load = new LoadCommand();
        commandManager.rejoin = new RejoinCommand();
        commandManager.reload = new ReloadCommand();
        commandManager.reloadHack = new ReloadAllCommand();
        commandManager.save = new SaveCommand();
        commandManager.tp = new TeleportCommand();
        commandManager.t = new Toggle2Command();
        commandManager.toggle = new ToggleCommand();
        commandManager.watermark = new WatermarkCommand();
        commandManager.irc = new IRCCommand();
        try {
            for (Field a22 : CommandManager.class.getDeclaredFields()) {
                if (!Command.class.isAssignableFrom(a22.getType())) continue;
                Command a22 = (Command)a22.get(commandManager);
                commandManager.commands.put(a22.getName(), a22);
            }
            return;
        }
        catch (Exception exception) {
            System.out.println(TimeHelper.ALLATORIxDEMO("\rT\u0016K\u0014\u0004\u000fF\u0003S\fL\u0003m<A\u0004@E`\u000b@\ro\u0002R\u001c\u001bC\u0000\u0001H\bM\u0003S\u001b\u0004\u001b"));
            System.out.println(exception.getStackTrace().toString());
        }
    }

    public HashMap<String, Command> getCommands() {
        CommandManager a;
        return a.commands;
    }

    public void command(String[] a) {
        String[] a2;
        int n;
        String[] arrstring = a2;
        Command command = arrstring.commands.get(a[0].substring(Hana.PREFIX.length()).toLowerCase());
        if (command == null) {
            CommandManager.sendChatMessage(WebUtils.ALLATORIxDEMO("\u00b3>\f?\u00062\u00f3{\u0012|+u3,!\noy0\u0018^1=wJ.n>2\u00f3x6r\u001bN{\u00b52{4`}uz!r-0:zw}8s6s:y-9"));
            return;
        }
        a2 = new String[a.length - 1];
        int n2 = n = 1;
        while (n2 < a.length) {
            int n3 = n - 1;
            String string = a[n];
            a2[n3] = string;
            n2 = ++n;
        }
        if (a2.length == 1 && a2[0].equals(TimeHelper.ALLATORIxDEMO("O\u0000A\u001f"))) {
            command.sendUsage();
            return;
        }
        command.runCommand(a2);
    }

    public int getNumOfCommands() {
        CommandManager a;
        return a.commands.size();
    }

    public Command getCommandBySyntax(String string) {
        String a = string;
        CommandManager a2 = this;
        return a2.commands.get(a);
    }

    public static void sendChatMessage(String a) {
        String string = a;
        if (Module.nullCheck()) {
            return;
        }
        String string2 = "";
        a = "";
        if (ChatSetting.INSTANCE.messageCode.getValue() == ChatSetting.code.Mio) {
            string2 = WebUtils.ALLATORIxDEMO("M");
            a = TimeHelper.ALLATORIxDEMO("3");
        }
        if (ChatSetting.INSTANCE.messageCode.getValue() == ChatSetting.code.Earth) {
            string2 = WebUtils.ALLATORIxDEMO("*");
            a = TimeHelper.ALLATORIxDEMO("P");
        }
        if (ChatSetting.INSTANCE.messageCode.getValue() == ChatSetting.code.Custom) {
            string2 = ChatSetting.INSTANCE.start.getValue();
            a = ChatSetting.INSTANCE.end.getValue();
        }
        CommandManager.mc.field_1705.method_1743().method_1812(class_2561.method_30163((String)("\u00a7(\u00a7r" + string2 + ChatSetting.INSTANCE.hackName.getValue() + "\u00a7r" + a + "\u00a7f " + string)));
    }

    public static void sendChatMessageWidthId(String a, int a2) {
        String string = a;
        if (Module.nullCheck()) {
            return;
        }
        String string2 = "";
        a = "";
        if (ChatSetting.INSTANCE.messageCode.getValue() == ChatSetting.code.Mio) {
            string2 = WebUtils.ALLATORIxDEMO("L");
            a = TimeHelper.ALLATORIxDEMO("2");
        }
        if (ChatSetting.INSTANCE.messageCode.getValue() == ChatSetting.code.Earth) {
            string2 = WebUtils.ALLATORIxDEMO("+");
            a = TimeHelper.ALLATORIxDEMO("Q");
        }
        if (ChatSetting.INSTANCE.messageCode.getValue() == ChatSetting.code.Custom) {
            string2 = ChatSetting.INSTANCE.start.getValue();
            a = ChatSetting.INSTANCE.end.getValue();
        }
        ((IChatHud)CommandManager.mc.field_1705.method_1743()).nullpoint_nextgen_master$add(class_2561.method_30163((String)("\u00a7(\u00a7r" + string2 + ChatSetting.INSTANCE.hackName.getValue() + "\u00a7r" + a + "\u00a7f " + string)), a2);
    }
}
