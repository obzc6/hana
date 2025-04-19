/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1934
 *  net.minecraft.class_310
 *  net.minecraft.class_636
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.commands.Command;
import java.util.List;
import net.minecraft.class_1934;
import net.minecraft.class_310;
import net.minecraft.class_636;

public class GamemodeCommand
extends Command {
    public GamemodeCommand() {
        super(Animation.ALLATORIxDEMO("ItO|@yCy"), TipUtils.ALLATORIxDEMO(".\n\n* \re\r$\u0007,\u000b)\r)KwW(\u000b(\u001da\u001d5\u0017s\u0010"), Animation.ALLATORIxDEMO("urOxGtBrBA"));
        GamemodeCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        int a = n;
        GamemodeCommand a2 = this;
        if (a == 1) {
            String[] arrstring = new String[4];
            arrstring[0] = TipUtils.ALLATORIxDEMO(")\u0000?\u0014\"\u0012=\u001f");
            arrstring[1] = Animation.ALLATORIxDEMO("MgGxYQy");
            arrstring[2] = TipUtils.ALLATORIxDEMO("\u0014>\u0003(\f?\u0011.\u0016");
            arrstring[3] = Animation.ALLATORIxDEMO("f^pAmLbHn");
            return arrstring;
        }
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
        if (((String)(a = a[0])).equalsIgnoreCase(TipUtils.ALLATORIxDEMO("6\u001f;\u0010/\u001f-\u000f"))) {
            GamemodeCommand.mc.field_1761.method_2907(class_1934.field_9215);
            return;
        }
        if (((String)a).equalsIgnoreCase(Animation.ALLATORIxDEMO("MgGxYQy"))) {
            GamemodeCommand.mc.field_1761.method_2907(class_1934.field_9220);
            return;
        }
        if (((String)a).equalsIgnoreCase(TipUtils.ALLATORIxDEMO("\u000b!\u001c,\b2\u001c>\u0006"))) {
            GamemodeCommand.mc.field_1761.method_2907(class_1934.field_9216);
            return;
        }
        if (((String)a).equalsIgnoreCase(Animation.ALLATORIxDEMO("f^pAmLbHn"))) {
            GamemodeCommand.mc.field_1761.method_2907(class_1934.field_9219);
        }
    }
}
