/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import java.io.File;
import java.util.List;
import net.minecraft.class_310;

public class SaveCommand
extends Command {
    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        CommandManager.sendChatMessage(TipUtils.ALLATORIxDEMO("\u00e1\f0e\u001aH\u00e2\f\u0016\u000b?\u000f(\u000ebM"));
        if (a.length == 1) {
            ConfigManager.options = new File(SaveCommand.mc.field_1697, a[0] + ".cfg");
            Hana.save();
            ConfigManager.options = new File(SaveCommand.mc.field_1697, BackgroundInfo.ALLATORIxDEMO("3-\u0018\u0000\u0005\"(;1 :0u8)2"));
        }
        Hana.save();
    }

    public SaveCommand() {
        super(TipUtils.ALLATORIxDEMO("/\u0012`\\"), BackgroundInfo.ALLATORIxDEMO("27}y"), "");
        SaveCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        SaveCommand a2 = this;
        return null;
    }
}
