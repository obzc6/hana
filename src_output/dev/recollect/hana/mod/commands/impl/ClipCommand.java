/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.commands.Command;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class ClipCommand
extends Command {
    private /* synthetic */ boolean isNumeric(String string) {
        String a = string;
        ClipCommand a2 = this;
        return a.matches(WebUtils.ALLATORIxDEMO("\u0010pZ35wJf]71p/"));
    }

    @Override
    public void runCommand(String[] arrstring) {
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length != 3) {
            a2.sendUsage();
            return;
        }
        if (!a2.isNumeric(a[0])) {
            a2.sendUsage();
            return;
        }
        double d = ClipCommand.mc.field_1724.method_23317() + Double.parseDouble(a[0]);
        if (!a2.isNumeric(a[1])) {
            a2.sendUsage();
            return;
        }
        double d2 = ClipCommand.mc.field_1724.method_23318() + Double.parseDouble(a[1]);
        if (!a2.isNumeric(a[2])) {
            a2.sendUsage();
            return;
        }
        double d3 = ClipCommand.mc.field_1724.method_23321() + Double.parseDouble(a[2]);
        ClipCommand.mc.field_1724.method_5814(d, d2, d3);
        a = new DecimalFormat(FrameFilter.ALLATORIxDEMO("-h'"));
        CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7fTeleported to \u00a7eX:" + ((NumberFormat)a).format(d) + " Y:" + ((NumberFormat)a).format(d2) + " Z:" + ((NumberFormat)a).format(d3));
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        ClipCommand a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = FrameFilter.ALLATORIxDEMO("v7");
        return arrstring;
    }

    public ClipCommand() {
        super(WebUtils.ALLATORIxDEMO("-km="), FrameFilter.ALLATORIxDEMO("H#{i-.b9ooj'{cb |?r# o89n.w<#,sc>\nCn~<{+#If,r&r#c}\"q?>"), WebUtils.ALLATORIxDEMO("\u0014+GtF*Gn\\~\u0010"));
        ClipCommand a;
    }
}
