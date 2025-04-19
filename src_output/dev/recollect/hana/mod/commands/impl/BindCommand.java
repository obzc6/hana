/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.info.ClientInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BindCommand
extends Command {
    /*
     * WARNING - void declaration
     */
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        void a22322;
        Iterator<Module> a42 = list;
        BindCommand a3 = this;
        if (a22322 == true) {
            Iterator<Module> iterator = a42;
            String a22322 = ((String)iterator.get(iterator.size() - 1)).toLowerCase();
            a42 = Hana.MODULE;
            Object object = new ArrayList<String>();
            for (Module arrstring2 : ((ModuleManager)a42).modules) {
                if (!a22322.equalsIgnoreCase(Hana.PREFIX + "bind") && !arrstring2.getName().toLowerCase().startsWith(a22322)) continue;
                object.add(arrstring2.getName());
            }
            int a42 = object.size();
            String[] arrstring = new String[a42];
            int a22322 = 0;
            Iterator iterator2 = a42 = object.iterator();
            while (iterator2.hasNext()) {
                object = (String)a42.next();
                iterator2 = a42;
                arrstring[a22322++] = object;
            }
            return arrstring;
        }
        return null;
    }

    public BindCommand() {
        super(MathUtil.ALLATORIxDEMO("\r\u001a\u000b\u001d"), ClientInfo.ALLATORIxDEMO("F m*>81`"), MathUtil.ALLATORIxDEMO("\u00193\u0001\u0016\u0019\u001c\t-@'\u0004\u0016\u001c$"));
        BindCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length == 0) {
            a2.sendUsage();
            return;
        }
        Object object = a[0];
        if ((object = Hana.MODULE.getModuleByName((String)object)) == null) {
            CommandManager.sendChatMessage(ClientInfo.ALLATORIxDEMO("\u00e10\u0012/\u001e8\u00f2y\u0007j\"G\u000br&'\u00ede'd\"q%kb"));
            return;
        }
        if (((String[])a).length == 1) {
            CommandManager.sendChatMessage(MathUtil.ALLATORIxDEMO("\u00d3Z+P0M\u00d6Ic/:\t\u0007\nS\u0016\t'=\u0007\u0014\u0015P\rP\u00c7\u001e\u0004\u0016\u001cW"));
            return;
        }
        if ((a = a[1]) == null) {
            CommandManager.sendChatMessage(ClientInfo.ALLATORIxDEMO("\u00ee\u001d1k#i%p$+\u0003v;a1"));
            return;
        }
        if (((Module)object).setBind(((String)a).toUpperCase())) {
            CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7fBind for \u00a7a" + ((Mod)object).getName() + "\u00a7f set to \u00a77" + ((String)a).toUpperCase());
        }
    }
}
