/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.impl.client.HUD;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WatermarkCommand
extends Command {
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        WatermarkCommand a2 = this;
        return null;
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
            stringBuilder.append(GaussianKernel.ALLATORIxDEMO("k")).append(string);
        }
        HUD.INSTANCE.watermarkString.setValue(stringBuilder.toString());
    }

    public WatermarkCommand() {
        super(GameInfo.ALLATORIxDEMO("q|yv~jkj"), GaussianKernel.ALLATORIxDEMO("5,\u001f\u00025%p5169<> + "), GameInfo.ALLATORIxDEMO("Gpvsm\\"));
        WatermarkCommand a;
    }
}
