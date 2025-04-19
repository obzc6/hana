/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.SocketManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IRCCommand
extends Command {
    public IRCCommand() {
        super(Start.ALLATORIxDEMO("v\t6"), OLEPOSSUtils.ALLATORIxDEMO("g3V7_6Bt_\u0007O>L,\n\u000b_c\t"), Start.ALLATORIxDEMO("wvTg\u000f\b"));
        IRCCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length == 0) {
            a2.sendUsage();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        a = Arrays.stream(a).toList().iterator();
        Iterator<String> iterator = a;
        while (iterator.hasNext()) {
            String string = (String)a.next();
            iterator = a;
            stringBuilder.append(OLEPOSSUtils.ALLATORIxDEMO("\u0007")).append(string);
        }
        Hana.IRC.chat(stringBuilder.toString());
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        IRCCommand a2 = this;
        return null;
    }
}
