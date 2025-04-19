/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.StringUtils
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class HelpCommand
extends Command {
    final int indexesPerPage = 5;

    private /* synthetic */ void ShowCommands(int a) {
        HelpCommand a2;
        HelpCommand helpCommand = a2;
        CommandManager.sendChatMessage("------------ Help [Page " + a + " of 5] ------------");
        CommandManager.sendChatMessage("Use " + Hana.PREFIX + "help [n] to get page n of help.");
        Collection<String> collection = Hana.COMMAND.getCommands().keySet();
        collection = new ArrayList<String>(collection);
        int n = a2 = (a - 1) * 5;
        while (n < a * 5) {
            if (a2 >= 0 && a2 < Hana.COMMAND.getNumOfCommands()) {
                CommandManager.sendChatMessage(" " + Hana.PREFIX + (String)((ArrayList)collection).get(a2));
            }
            n = ++a2;
        }
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        HelpCommand a2 = this;
        return null;
    }

    public HelpCommand() {
        super(Alt.ALLATORIxDEMO("q&9"), Hole.ALLATORIxDEMO("4v;Z\u000b!\u000ek\u001f#\u0017y\u0018i\u0012hG7^d\u0016m\u0013f\r~Z~"), Alt.ALLATORIxDEMO("o\u001ey%l:-y(l/v\u0014"));
        HelpCommand a;
    }

    @Override
    public void runCommand(String[] a) {
        Wrapper a22;
        HelpCommand helpCommand = a22;
        if (a.length == 0) {
            helpCommand.ShowCommands(1);
            return;
        }
        if (StringUtils.isNumeric((CharSequence)a[0])) {
            int a22 = Integer.parseInt(a[0]);
            helpCommand.ShowCommands(a22);
            return;
        }
        a22 = Hana.MODULE.getModuleByName(a[0]);
        if (a22 == null) {
            CommandManager.sendChatMessage("Could not find Module '" + a[0] + "'.");
            return;
        }
        CommandManager.sendChatMessage("------------ " + ((Mod)a22).getName() + "Help ------------");
        CommandManager.sendChatMessage("Name: " + ((Mod)a22).getName());
        CommandManager.sendChatMessage("Description: " + ((Module)a22).getDescription());
        CommandManager.sendChatMessage("Keybind: " + ((Module)a22).getBind().getBind() + " " + ((Module)a22).getBind().getKey());
    }
}
