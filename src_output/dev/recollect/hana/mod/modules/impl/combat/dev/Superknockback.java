/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.Event
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_3966
 *  net.minecraft.class_634
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_634;

public class Superknockback
extends Module {
    private static final class_310 mc = class_310.method_1551();
    private final SliderSetting packets;

    private /* synthetic */ void registerEvents() {
        Superknockback a;
        AttackEntityCallback.EVENT.register((Object)((AttackEntityCallback)(class_16572, class_19372, class_12682, class_12972, class_39662) -> {
            class_1309 a;
            void a2;
            Superknockback a3 = class_16572;
            Superknockback a4 = this;
            if (a2 instanceof class_1309 && (a3.method_5858((class_1297)(a = (class_1309)a2)) <= 1.0 || a3.method_5829().method_994(a.method_5829()))) {
                int n = a = 0;
                while ((double)n < (double)a4.packets.getValueFloat() * 10.0) {
                    if (a3.method_24828()) {
                        class_2828.class_2829 a5 = new class_2828.class_2829(a3.method_23317(), a3.method_23318(), a3.method_23321(), a3.method_24828());
                        mc.method_1562().method_52787((class_2596)a5);
                    }
                    n = ++a;
                }
            }
            return class_1269.field_5811;
        }));
    }

    public Superknockback() {
        Superknockback a;
        Superknockback superknockback = a;
        super(CameraState.ALLATORIxDEMO("\u0000J/V%P0]>Z=R4P"), Module.Category.Combat);
        superknockback.packets = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("L<x+c~?"), 3.0, 0.0, 8.0, 0.10000000149011612));
        superknockback.setChinese(CameraState.ALLATORIxDEMO("\u8dda\u7e94\u51ac\u903b"));
        superknockback.registerEvents();
    }
}
