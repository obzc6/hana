/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.io.File;
import java.util.List;
import net.minecraft.class_310;
import org.bytedeco.javacv.BufferRing;

public class LoadCommand
extends Command {
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        LoadCommand a2 = this;
        return null;
    }

    public LoadCommand() {
        super(GameInfo.ALLATORIxDEMO("dxe"), BufferRing.ALLATORIxDEMO("\u00191\u0002kM"), GameInfo.ALLATORIxDEMO("Kksjub~\\"));
        LoadCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        if (a.length == 0) {
            a2.sendUsage();
            return;
        }
        CommandManager.sendChatMessage(BufferRing.ALLATORIxDEMO("\u00c6+!B\no\u00dc+5\"\u0018%\u001c \u001dj^"));
        ConfigManager.options = new File(LoadCommand.mc.field_1697, a[0] + ".cfg");
        Hana.unload();
        Hana.load();
        ConfigManager.options = new File(LoadCommand.mc.field_1697, GameInfo.ALLATORIxDEMO("q`PGMe`|ygrw=au"));
        Hana.save();
    }
}
