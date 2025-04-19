/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AntiVoid
extends Module {
    private final SliderSetting height;
    private final SliderSetting voidHeight;

    @Override
    public void onUpdate() {
        AntiVoid a;
        AntiVoid antiVoid = a;
        boolean bl = true;
        int n = a = (int)AntiVoid.mc.field_1724.method_23318();
        while (n > antiVoid.voidHeight.getValueInt() - 1) {
            if (AntiVoid.mc.field_1687.method_8320((class_2338)new BlockPosX(AntiVoid.mc.field_1724.method_23317(), a, AntiVoid.mc.field_1724.method_23321())).method_26204() != class_2246.field_10124) {
                bl = false;
                break;
            }
            n = --a;
        }
        if (AntiVoid.mc.field_1724.method_23318() < antiVoid.height.getValue() + antiVoid.voidHeight.getValue() && bl) {
            MovementUtil.setMotionY(0.0);
        }
    }

    public AntiVoid() {
        AntiVoid a;
        AntiVoid antiVoid = a;
        AntiVoid antiVoid2 = a;
        super(GameInfo.ALLATORIxDEMO("j]fcBcpe"), Animation.ALLATORIxDEMO("oy@xB}\u0006dA`\u0006iB6Q`\u0014vmOHd\u0017zExq\u000eN{ErLo"), Module.Category.Movement);
        AntiVoid antiVoid3 = a;
        antiVoid3.voidHeight = antiVoid2.add(new SliderSetting(GameInfo.ALLATORIxDEMO("BcBWZo}kqu"), -64.0, -64.0, 319.0, 1.0));
        antiVoid.height = antiVoid.add(new SliderSetting(Animation.ALLATORIxDEMO("drCvOh"), 100.0, -40.0, 256.0, 1.0));
        antiVoid.setChinese(GameInfo.ALLATORIxDEMO("\u53c1\u8643\u7a7b"));
    }
}
