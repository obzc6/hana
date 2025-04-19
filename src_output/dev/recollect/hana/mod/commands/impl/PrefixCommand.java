/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.socket.network.client.SocketClient;
import java.util.List;

public class PrefixCommand
extends Command {
    public PrefixCommand() {
        super(TimerManager.ALLATORIxDEMO("\t9\u00010Gd"), SocketClient.ALLATORIxDEMO("pcW&_xEcCw"), TimerManager.ALLATORIxDEMO("%<\u000b.\u0002?VA"));
        PrefixCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        if (a.length == 0) {
            a2.sendUsage();
            return;
        }
        if (a[0].startsWith(SocketClient.ALLATORIxDEMO(" "))) {
            CommandManager.sendChatMessage(TimerManager.ALLATORIxDEMO("\u00d1r\"j5z\u00f4\u0007/!\u0018.\u000e*Q0\u000e)\u0017/\u0004)E6^:2\r\u0016)]\u00e8\u001f?\u0003&\u0018%\fh"));
            return;
        }
        Hana.PREFIX = a[0];
        CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7bPrefix \u00a7fset to \u00a7e" + a[0]);
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        PrefixCommand a2 = this;
        return null;
    }
}
