/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2244
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2587
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.xibao.SnowAnimation;
import net.minecraft.class_2244;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2587;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Fucker
extends Module {
    private final SliderSetting range;
    private final BooleanSetting rotate;

    public Fucker() {
        Fucker a;
        Fucker fucker = a;
        super(SnowAnimation.ALLATORIxDEMO("q\u001cZ\fK\u0002"), NpSocketClient.ALLATORIxDEMO("\u001fn/#-x&("), Module.Category.Player);
        Fucker fucker2 = a;
        fucker2.rotate = fucker.add(new BooleanSetting(SnowAnimation.ALLATORIxDEMO("e\u0006M\u0006Z\u0015"), true));
        fucker.range = fucker.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\u0011l#}?"), 5, 0, 8));
    }

    private /* synthetic */ class_2587 getBlock() {
        Fucker a22;
        Fucker fucker = a22;
        for (class_2586 a22 : BlockUtil.getTileEntities()) {
            if (!(a22 instanceof class_2587) || !((double)class_3532.method_15355((float)((float)Fucker.mc.field_1724.method_5707((a22 = (class_2587)a22).method_11016().method_46558()))) <= fucker.range.getValue())) continue;
            return a22;
        }
        return null;
    }

    @Override
    public void onUpdate() {
        Fucker a;
        if (SpeedMine.breakPos != null && Fucker.mc.field_1687.method_8320(SpeedMine.breakPos).method_26204() instanceof class_2244) {
            return;
        }
        if (a.getBlock() != null) {
            SpeedMine.INSTANCE.mine(a.getBlock().method_11016());
        }
    }
}
