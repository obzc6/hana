/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2611
 *  net.minecraft.class_2627
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_7172
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import java.awt.Color;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2611;
import net.minecraft.class_2627;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_7172;
import net.minecraft.class_746;

public class Tracers
extends Module {
    private final ColorSetting enderChest;
    private final ColorSetting player;
    private final ColorSetting chest;
    private final ColorSetting shulkerBox;
    private final ColorSetting item;

    public Tracers() {
        Tracers a;
        Tracers tracers = a;
        Tracers tracers2 = a;
        super(UserInfo.ALLATORIxDEMO("\u0010\u0015#\u00130\u0003'"), Module.Category.Render);
        Tracers tracers3 = a;
        tracers3.item = tracers2.add(new ColorSetting(BetterDynamicAnimation.ALLATORIxDEMO("|uQm"), new Color(255, 255, 255, 100)).injectBoolean(true));
        tracers2.player = tracers2.add(new ColorSetting(UserInfo.ALLATORIxDEMO("7.\u0011,\u0014&"), new Color(255, 255, 255, 100)).injectBoolean(true));
        tracers2.chest = tracers2.add(new ColorSetting(BetterDynamicAnimation.ALLATORIxDEMO("U]dGt"), new Color(255, 255, 255, 100)).injectBoolean(false));
        tracers2.enderChest = tracers2.add(new ColorSetting(UserInfo.ALLATORIxDEMO("&(\u0005!\u0015\u0001\u00180\u0002 "), new Color(255, 100, 255, 100)).injectBoolean(false));
        tracers.shulkerBox = tracers.add(new ColorSetting(BetterDynamicAnimation.ALLATORIxDEMO("uzQ|IsGC[x"), new Color(15, 255, 255, 100)).injectBoolean(false));
        tracers.setChinese(UserInfo.ALLATORIxDEMO("\u73d9\u5be3\u5958\u7eeb"));
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a222 = f;
        Tracers a = this;
        boolean a3 = (Boolean)Tracers.mc.field_1690.method_42448().method_41753();
        Tracers.mc.field_1690.method_42448().method_41748((Object)false);
        if (a.item.booleanValue || a.player.booleanValue) {
            for (class_1297 class_12972 : Tracers.mc.field_1687.method_18112()) {
                if (class_12972 instanceof class_1542 && a.item.booleanValue) {
                    Tracers tracers = a;
                    tracers.drawLine(class_12972.method_19538(), tracers.item.getValue());
                    continue;
                }
                if (!(class_12972 instanceof class_1657) || !a.player.booleanValue || class_12972 == Tracers.mc.field_1724) continue;
                Tracers tracers = a;
                tracers.drawLine(class_12972.method_19538(), tracers.player.getValue());
            }
        }
        class_2586 a222 = BlockUtil.getTileEntities();
        for (class_2586 a222 : a222) {
            if (a222 instanceof class_2595 && a.chest.booleanValue) {
                Tracers tracers = a;
                tracers.drawLine(a222.method_11016().method_46558(), tracers.chest.getValue());
                continue;
            }
            if (a222 instanceof class_2611 && a.enderChest.booleanValue) {
                Tracers tracers = a;
                tracers.drawLine(a222.method_11016().method_46558(), tracers.enderChest.getValue());
                continue;
            }
            if (!(a222 instanceof class_2627) || !a.shulkerBox.booleanValue) continue;
            Tracers tracers = a;
            tracers.drawLine(a222.method_11016().method_46558(), tracers.shulkerBox.getValue());
        }
        Tracers.mc.field_1690.method_42448().method_41748((Object)a3);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawLine(class_243 class_2432, Color color) {
        void a;
        Color a2 = color;
        Tracers a3 = this;
        Render3DUtil.drawLine2((class_243)a, Tracers.mc.field_1724.method_5836(mc.method_1488()).method_1019(class_243.method_1030((float)Tracers.mc.field_1724.method_5695(mc.method_1488()), (float)Tracers.mc.field_1724.method_5705(mc.method_1488())).method_1021(0.2)), a2);
    }
}
