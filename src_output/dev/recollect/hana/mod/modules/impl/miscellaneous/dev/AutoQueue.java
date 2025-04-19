/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_7439
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.HashMap;
import java.util.Set;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_7439;
import org.bytedeco.javacv.BaseChildSettings;

public class AutoQueue
extends Module {
    public static boolean inQueue;
    private final BooleanSetting queueCheck;
    public static HashMap<String, String> asks;

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive a) {
        Object a2;
        AutoQueue autoQueue = a2;
        if (!inQueue && autoQueue.queueCheck.getValue()) {
            return;
        }
        a2 = a.getPacket();
        if (a2 instanceof class_7439) {
            a = (class_7439)a2;
            for (String string : asks.keySet()) {
                int n;
                if (!a.comp_763().getString().contains(string)) continue;
                String[] arrstring = new String[3];
                arrstring[0] = BaseChildSettings.ALLATORIxDEMO("\u001e");
                arrstring[1] = Hole.ALLATORIxDEMO("I");
                arrstring[2] = BaseChildSettings.ALLATORIxDEMO("\u001c");
                String[] arrstring2 = arrstring;
                int n2 = arrstring.length;
                int n3 = n = 0;
                while (n3 < n2) {
                    String string2 = arrstring2[n];
                    if (a.comp_763().getString().contains(string2 + "." + asks.get(string))) {
                        mc.method_1562().method_45729(string2.toLowerCase());
                        return;
                    }
                    n3 = ++n;
                }
            }
        }
    }

    public AutoQueue() {
        AutoQueue a;
        AutoQueue autoQueue = a;
        super(Hole.ALLATORIxDEMO("F\ft\u0011V\u0016\\5"), Module.Category.Misc);
        AutoQueue autoQueue2 = a;
        autoQueue.queueCheck = autoQueue.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("v&E!B\u0010R+\u0013o"), true));
        autoQueue.setChinese(Hole.ALLATORIxDEMO("\u8189\u52b2\u7b7d\u98c8"));
    }

    @Override
    public void onUpdate() {
        if (AutoQueue.nullCheck()) {
            inQueue = false;
            return;
        }
        inQueue = InventoryUtil.findItem(class_1802.field_8251) != -1;
    }

    @Override
    public void onDisable() {
        inQueue = false;
    }

    static {
        asks = new HashMap<String, String>(){
            {
                1 a;
                1 v0 = a;
                v0.put(ColorUtil.ALLATORIxDEMO("\u7ee2\u77f5\u7061\u62c6"), ProjectionUtils.ALLATORIxDEMO("D\u0006"));
                a.put(ColorUtil.ALLATORIxDEMO("\u736a\u88ad\u95e0\u7579"), ProjectionUtils.ALLATORIxDEMO("\u5095\u5c1e\u735f\u4e89"));
                a.put(ColorUtil.ALLATORIxDEMO("\u5c4f\u7bb7\u5b5a\u80b1"), ProjectionUtils.ALLATORIxDEMO("G\u0004"));
                a.put(ColorUtil.ALLATORIxDEMO("\u5f40\u670b\u5e7e\u4eb1"), ProjectionUtils.ALLATORIxDEMO("R\u0016G\u0003"));
                a.put(ColorUtil.ALLATORIxDEMO("\u5bc7\u4f56\u676b\u5736\u905d\u8fb5"), ProjectionUtils.ALLATORIxDEMO("\u0003"));
                a.put(ColorUtil.ALLATORIxDEMO("\u7271\u8857\u8045\u88ad\u95e0\u7579"), ProjectionUtils.ALLATORIxDEMO("\u9abf\u53eb\u720a\u8839\u8036"));
                a.put(ColorUtil.ALLATORIxDEMO("\u5967\u7bb7\u5b5a\u80b1"), ProjectionUtils.ALLATORIxDEMO("@\u0007"));
                a.put(ColorUtil.ALLATORIxDEMO("\u7f91\u9a3c\u4f1c\u4e31\u52e4"), ProjectionUtils.ALLATORIxDEMO("\u4e78\u4f29"));
                a.put(ColorUtil.ALLATORIxDEMO("\u65e6\u965a\u6c78"), ProjectionUtils.ALLATORIxDEMO("\u0000"));
                a.put(ColorUtil.ALLATORIxDEMO("\u634b\u6383\u905f\u5ea0\u670a\u5fa7"), ProjectionUtils.ALLATORIxDEMO("\u91a4\u9563"));
                a.put(ColorUtil.ALLATORIxDEMO("\u518b\u7073\u6b71\u5442"), ProjectionUtils.ALLATORIxDEMO("\u4e6b\u756a\u4e3e\u662c"));
                a.put(ColorUtil.ALLATORIxDEMO("\u82bb\u5280\u6055\u7682\u5b92\u65f5"), ProjectionUtils.ALLATORIxDEMO("\u720a\u8839\u8036"));
                a.put(ColorUtil.ALLATORIxDEMO("\u534c\u749c\u7682\u7515\u9533"), ProjectionUtils.ALLATORIxDEMO("\u4e2b\u9775\u89b2"));
                a.put(ColorUtil.ALLATORIxDEMO("\u5bda\u4f4b\u6721\u577c"), ProjectionUtils.ALLATORIxDEMO("\u0003"));
            }
        };
        inQueue = false;
    }

}
