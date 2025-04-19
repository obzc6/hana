/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.mod.commands.Command;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class TeleportCommand
extends Command {
    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void runCommand(String[] arrstring) {
        double d;
        double d2;
        String[] arrstring2;
        double d3;
        String[] arrstring3;
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length != 3) {
            a2.sendUsage();
            return;
        }
        if (a2.isNumeric(a[0])) {
            arrstring2 = a2;
            d2 = Double.parseDouble(a[0]);
        } else {
            if (!a[0].startsWith(FrameFilter.ALLATORIxDEMO("i"))) {
                a2.sendUsage();
                return;
            }
            if (a2.isNumeric(a[0].replace(NCPRaytracer.ALLATORIxDEMO("^"), ""))) {
                d2 = TeleportCommand.mc.field_1724.method_23317() + Double.parseDouble(a[0].replace(FrameFilter.ALLATORIxDEMO("i"), ""));
                arrstring2 = a2;
            } else {
                if (!a[0].replace(NCPRaytracer.ALLATORIxDEMO("^"), "").equals("")) {
                    a2.sendUsage();
                    return;
                }
                d2 = TeleportCommand.mc.field_1724.method_23317();
                arrstring2 = a2;
            }
        }
        String[] arrstring4 = a;
        if (arrstring2.isNumeric(a[1])) {
            d = Double.parseDouble(arrstring4[1]);
            arrstring3 = a2;
        } else {
            if (!arrstring4[1].startsWith(FrameFilter.ALLATORIxDEMO("i"))) {
                a2.sendUsage();
                return;
            }
            if (a2.isNumeric(a[1].replace(NCPRaytracer.ALLATORIxDEMO("^"), ""))) {
                d = TeleportCommand.mc.field_1724.method_23318() + Double.parseDouble(a[1].replace(FrameFilter.ALLATORIxDEMO("i"), ""));
                arrstring3 = a2;
            } else {
                if (!a[1].replace(NCPRaytracer.ALLATORIxDEMO("^"), "").equals("")) {
                    a2.sendUsage();
                    return;
                }
                d = TeleportCommand.mc.field_1724.method_23318();
                arrstring3 = a2;
            }
        }
        String[] arrstring5 = a;
        if (arrstring3.isNumeric(a[2])) {
            d3 = Double.parseDouble(arrstring5[2]);
        } else {
            if (!arrstring5[2].startsWith(FrameFilter.ALLATORIxDEMO("i"))) {
                a2.sendUsage();
                return;
            }
            if (a2.isNumeric(a[2].replace(NCPRaytracer.ALLATORIxDEMO("^"), ""))) {
                d3 = TeleportCommand.mc.field_1724.method_23321() + Double.parseDouble(a[2].replace(FrameFilter.ALLATORIxDEMO("i"), ""));
            } else {
                if (!a[2].replace(NCPRaytracer.ALLATORIxDEMO("^"), "").equals("")) {
                    a2.sendUsage();
                    return;
                }
                d3 = TeleportCommand.mc.field_1724.method_23321();
            }
        }
        TeleportCommand.mc.field_1724.method_5814(d2, d, d3);
        a = new DecimalFormat(FrameFilter.ALLATORIxDEMO("-h'"));
        CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7fTeleported to \u00a7eX:" + ((NumberFormat)a).format(d2) + " Y:" + ((NumberFormat)a).format(d) + " Z:" + ((NumberFormat)a).format(d3));
    }

    public TeleportCommand() {
        super(NCPRaytracer.ALLATORIxDEMO("{P"), FrameFilter.ALLATORIxDEMO("H*r*n,`8nfc9e,-'{6{ #-z~)\u0017N)6,s(u9pm}'`/'If,r&r#c}\"q?>"), NCPRaytracer.ALLATORIxDEMO("p~t&rsx%qu}"));
        TeleportCommand a;
    }

    private /* synthetic */ boolean isNumeric(String string) {
        String a = string;
        TeleportCommand a2 = this;
        return a.matches(NCPRaytracer.ALLATORIxDEMO("*;wb\u0002.u$ya\u0001&\u001f"));
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        TeleportCommand a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = FrameFilter.ALLATORIxDEMO("87");
        return arrstring;
    }
}
