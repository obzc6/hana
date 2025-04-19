/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.util.List;

public class ReloadAllCommand
extends Command {
    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        CommandManager.sendChatMessage(NpSocketClient.ALLATORIxDEMO("\u00cea\u001f%\u0019\u000b\u00cca\u0015`)j$m h!\"b"));
        Hana.unload();
        Hana.load();
    }

    public ReloadAllCommand() {
        super(NpSocketClient.ALLATORIxDEMO("7`)f(b'` "), MathUtil.ALLATORIxDEMO("\u0018\n\u0011\u0010\u001e"), "");
        ReloadAllCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        ReloadAllCommand a2 = this;
        return null;
    }
}
