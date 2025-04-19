/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.video.FileUtil;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class AimCommand
extends Command {
    private /* synthetic */ boolean isNumeric(String string) {
        String a = string;
        AimCommand a2 = this;
        return a.matches(Timer.ALLATORIxDEMO(">\u001atY\u001b\u001dd\fs]\u001f\u001a\u0001"));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void runCommand(String[] arrstring) {
        String[] arrstring2;
        double d;
        double d2;
        String[] arrstring3;
        double d3;
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length != 3) {
            a2.sendUsage();
            return;
        }
        if (a2.isNumeric(a[0])) {
            arrstring2 = a2;
            d3 = Double.parseDouble(a[0]);
        } else {
            if (!a[0].startsWith(FileUtil.ALLATORIxDEMO("\u0000"))) {
                a2.sendUsage();
                return;
            }
            if (a2.isNumeric(a[0].replace(Timer.ALLATORIxDEMO("G"), ""))) {
                d3 = AimCommand.mc.field_1724.method_23317() + Double.parseDouble(a[0].replace(FileUtil.ALLATORIxDEMO("\u0000"), ""));
                arrstring2 = a2;
            } else {
                if (!a[0].replace(Timer.ALLATORIxDEMO("G"), "").equals("")) {
                    a2.sendUsage();
                    return;
                }
                d3 = AimCommand.mc.field_1724.method_23317();
                arrstring2 = a2;
            }
        }
        String[] arrstring4 = a;
        if (arrstring2.isNumeric(a[1])) {
            d = Double.parseDouble(arrstring4[1]);
            arrstring3 = a2;
        } else {
            if (!arrstring4[1].startsWith(FileUtil.ALLATORIxDEMO("\u0000"))) {
                a2.sendUsage();
                return;
            }
            if (a2.isNumeric(a[1].replace(Timer.ALLATORIxDEMO("G"), ""))) {
                d = AimCommand.mc.field_1724.method_23318() + Double.parseDouble(a[1].replace(FileUtil.ALLATORIxDEMO("\u0000"), ""));
                arrstring3 = a2;
            } else {
                if (!a[1].replace(Timer.ALLATORIxDEMO("G"), "").equals("")) {
                    a2.sendUsage();
                    return;
                }
                d = AimCommand.mc.field_1724.method_23318();
                arrstring3 = a2;
            }
        }
        String[] arrstring5 = a;
        if (arrstring3.isNumeric(a[2])) {
            d2 = Double.parseDouble(arrstring5[2]);
        } else {
            if (!arrstring5[2].startsWith(FileUtil.ALLATORIxDEMO("\u0000"))) {
                a2.sendUsage();
                return;
            }
            if (a2.isNumeric(a[2].replace(Timer.ALLATORIxDEMO("G"), ""))) {
                d2 = AimCommand.mc.field_1724.method_23321() + Double.parseDouble(a[2].replace(FileUtil.ALLATORIxDEMO("\u0000"), ""));
            } else {
                if (!a[2].replace(Timer.ALLATORIxDEMO("G"), "").equals("")) {
                    a2.sendUsage();
                    return;
                }
                d2 = AimCommand.mc.field_1724.method_23321();
            }
        }
        a = EntityUtil.getLegitRotations(new class_243(d3, d, d2));
        AimCommand.mc.field_1724.method_36456((float)a[0]);
        AimCommand.mc.field_1724.method_36457((float)a[1]);
        a = new DecimalFormat(FileUtil.ALLATORIxDEMO("D?N"));
        CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7fAim to \u00a7eX:" + ((NumberFormat)a).format(d3) + " Y:" + ((NumberFormat)a).format(d) + " Z:" + ((NumberFormat)a).format(d2));
    }

    public AimCommand() {
        super(Timer.ALLATORIxDEMO("H\u0007\u000e"), FileUtil.ALLATORIxDEMO("Y\u001euW`\u0014;\u0004~\r"), Timer.ALLATORIxDEMO(":Ai\u001eh@i\u0004r\u0014>"));
        AimCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        AimCommand a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = FileUtil.ALLATORIxDEMO("o^");
        return arrstring;
    }
}
