/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.Snow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToggleCommand
extends Command {
    public ToggleCommand() {
        super(Alt.ALLATORIxDEMO("b#~$,"), Snow.ALLATORIxDEMO("c`iik%ofiski"), Alt.ALLATORIxDEMO("A-y(l/v\u0014"));
        ToggleCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length == 0) {
            a2.sendUsage();
            return;
        }
        a = a[0];
        if ((a = Hana.MODULE.getModuleByName((String)a)) == null) {
            CommandManager.sendChatMessage(Snow.ALLATORIxDEMO("\u009b8\\%R$\u00a8iQhfND{i.\u00a2lhmmxjb-"));
            return;
        }
        ((Module)a).toggle();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        void a22322;
        Iterator<Module> a42 = list;
        ToggleCommand a3 = this;
        if (a22322 == true) {
            Iterator<Module> iterator = a42;
            String a22322 = ((String)iterator.get(iterator.size() - 1)).toLowerCase();
            a42 = Hana.MODULE;
            Object object = new ArrayList<String>();
            for (Module arrstring2 : ((ModuleManager)a42).modules) {
                if (!a22322.equalsIgnoreCase(Hana.PREFIX + "toggle") && !arrstring2.getName().toLowerCase().startsWith(a22322)) continue;
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
}
