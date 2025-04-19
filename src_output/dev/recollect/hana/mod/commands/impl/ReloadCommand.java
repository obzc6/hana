/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.socket.network.user.User;
import dev.recollect.hana.video.FileUtil;
import java.util.List;

public class ReloadCommand
extends Command {
    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        CommandManager.sendChatMessage(FileUtil.ALLATORIxDEMO("\u00d2q 0#\u0016\u00fe|'}\u001bw\u0016p\u0012u\u0013?P"));
        Hana.CONFIG = new ConfigManager();
        Hana.PREFIX = Hana.CONFIG.getString(User.ALLATORIxDEMO("^@D[BO"), Hana.PREFIX);
        Hana.CONFIG.loadSettings();
    }

    public ReloadCommand() {
        super(FileUtil.ALLATORIxDEMO("f\u001ew\u001bp\u001a"), User.ALLATORIxDEMO("VD_^P"), "");
        ReloadCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        ReloadCommand a2 = this;
        return null;
    }
}
