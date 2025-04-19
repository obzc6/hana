/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.NpSocketManager;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NPIRCCommand
extends Command {
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
            stringBuilder.append(TimeHelper.ALLATORIxDEMO("O")).append(string);
        }
        if (Hana.isdev) {
            Hana.NPIRC.chat(stringBuilder.toString());
            return;
        }
        if (Notify.INSTANCE.isOn() && Notify.INSTANCE.type.getValue() == Notify.Notifys.type.Chat) {
            CommandManager.sendChatMessageWidthId(GameInfo.ALLATORIxDEMO("\u4e3a\u6611\u5f26\u53ef\u8023\uff1e\u65ea\u6cc5\u4f77\u7538\u79c9\u6715MAH\u5286\u80fc"), -1);
        }
    }

    public NPIRCCommand() {
        super(GameInfo.ALLATORIxDEMO("wq"), TimeHelper.ALLATORIxDEMO("/F\u001eB\u0017C\n\u0001\u0017r\u0007K\u0004YB~\u0017\u0016A"), GameInfo.ALLATORIxDEMO("Gpvsm\\"));
        NPIRCCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        NPIRCCommand a2 = this;
        return null;
    }
}
