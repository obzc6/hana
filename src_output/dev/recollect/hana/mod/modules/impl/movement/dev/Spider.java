/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class Spider
extends Module {
    public static Spider INSTANCE;

    public Spider() {
        Spider a;
        Spider spider = a;
        super(Setting.ALLATORIxDEMO("H(o!)}"), Module.Category.Movement);
        spider.setChinese(PacketBuffer.ALLATORIxDEMO("\u7245\u5897"));
        INSTANCE = spider;
    }

    @Override
    public void onUpdate() {
        Spider a;
        Spider spider = a;
        a = Spider.mc.field_1724;
        if (a != null && ((class_746)a).field_5976) {
            a.method_18798().method_18806(new class_243(1.0, 0.0, 1.0));
            a.method_18798().method_1019(new class_243(0.0, 0.2, 0.0));
            a.method_24830(true);
        }
    }
}
