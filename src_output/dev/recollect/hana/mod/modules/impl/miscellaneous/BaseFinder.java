/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2646
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.video.FileUtil;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2646;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class BaseFinder
extends Module {
    private final SliderSetting count;
    private static File chestdata;
    private final SliderSetting delay;
    private final Timer timer;
    public final ColorSetting color;
    private final BooleanSetting log;
    private static File basedata;

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        Object object2;
        float a22 = f;
        BaseFinder a = this;
        for (Object object2 : BlockUtil.getTileEntities()) {
            class_2586 a3;
            if (!(object2 instanceof class_2595) && !(object2 instanceof class_2646)) continue;
            class_238 class_2382 = new class_238(object2.method_11016());
            Render3DUtil.draw3DBox((class_4587)a3, class_2382, a.color.getValue());
        }
        BaseFinder baseFinder = a;
        if (!baseFinder.timer.passed((long)baseFinder.delay.getValueInt() * 20L)) {
            return;
        }
        int a22 = 0;
        object2 = BlockUtil.getTileEntities();
        for (class_2586 a3 : object2) {
            if (!(a3 instanceof class_2595) && !(a3 instanceof class_2646)) continue;
            ++a22;
            if (!a.log.getValue()) continue;
            BaseFinder.writePacketData(chestdata, "FindChest:" + String.valueOf((Object)a3.method_11016()));
        }
        if ((double)a22 >= a.count.getValue()) {
            a.timer.reset();
            BaseFinder.writePacketData(basedata, "Find:" + String.valueOf((Object)BaseFinder.mc.field_1724.method_19538()) + " Count:" + a22);
            CommandManager.sendChatMessage("Find:" + String.valueOf((Object)BaseFinder.mc.field_1724.method_19538()) + " Count:" + a22);
            a22 = 0;
        }
    }

    static {
        basedata = new File(PacketBuffer.ALLATORIxDEMO("P6\u001f[\u0001p1s\u000byPm\u0011z"));
        chestdata = new File(FileUtil.ALLATORIxDEMO("G?<[9o\u0007_\u0015e\u001f>\u000b\u001c"));
    }

    private static /* synthetic */ void writePacketData(File file, String string) {
        String a = string;
        File a2 = file;
        new Thread(() -> {
            String a = a;
            File a2 = a2;
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(a2, true));
                bufferedWriter.write(a);
                bufferedWriter.newLine();
                bufferedWriter.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }).start();
    }

    public BaseFinder() {
        BaseFinder a;
        BaseFinder baseFinder = a;
        super(PacketBuffer.ALLATORIxDEMO("0t\u0006w9q\u0010}\f|"), Module.Category.Misc);
        BaseFinder baseFinder2 = a;
        baseFinder2.color = baseFinder.add(new ColorSetting(FileUtil.ALLATORIxDEMO("=\u0013h\u001a"), new Color(255, 255, 255, 100)));
        baseFinder.delay = baseFinder.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("\\\u001bu\bw"), 15, 0, 30));
        baseFinder.count = baseFinder.add(new SliderSetting(FileUtil.ALLATORIxDEMO("=\ni\u001c"), 50, 1, 2000));
        a.log = baseFinder.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\u000e[\u0004p6z\u001ak\nU\u0006i"), true));
        a.timer = new Timer();
        a.setChinese(FileUtil.ALLATORIxDEMO("\u57ea\u574f\u8bb7\u5f3d"));
    }
}
