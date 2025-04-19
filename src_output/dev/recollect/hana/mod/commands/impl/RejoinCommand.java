/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2661
 *  net.minecraft.class_310
 *  net.minecraft.class_412
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 *  net.minecraft.class_746
 *  net.minecraft.class_8705
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.socket.network.packet.Packet;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_2661;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_746;
import net.minecraft.class_8705;
import org.bytedeco.javacv.FrameConverter;

public class RejoinCommand
extends Command {
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        RejoinCommand a2 = this;
        return null;
    }

    public RejoinCommand() {
        super(Packet.ALLATORIxDEMO("iY~\\wW"), FrameConverter.ALLATORIxDEMO("\u0000t\u0005cL("), "");
        RejoinCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        mc.method_18859(() -> {
            if (RejoinCommand.mc.field_1687 != null && mc.method_1558() != null) {
                class_642 class_6422 = mc.method_1558();
                new class_2661(class_2561.method_30163((String)Packet.ALLATORIxDEMO("cr\\}\u001cZ}R"))).method_11467((class_8705)RejoinCommand.mc.field_1724.field_3944);
                class_412.method_36877((class_437)new class_442(), (class_310)mc, (class_639)class_639.method_2950((String)class_6422.field_3761), (class_642)class_6422, (boolean)false);
            }
        });
    }
}
