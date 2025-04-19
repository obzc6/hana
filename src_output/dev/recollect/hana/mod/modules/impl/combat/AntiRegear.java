/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2480
 *  net.minecraft.class_2586
 *  net.minecraft.class_2627
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2480;
import net.minecraft.class_2586;
import net.minecraft.class_2627;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AntiRegear
extends Module {
    private final SliderSetting safeRange;
    private final SliderSetting range;

    public AntiRegear() {
        AntiRegear a;
        AntiRegear antiRegear = a;
        AntiRegear antiRegear2 = a;
        super(ProjectionUtils.ALLATORIxDEMO("`\tW\fs\u0002B\u0006W\u0002"), MathUtil.ALLATORIxDEMO("';:\b\u0013\u0003\bD\u0016\u0015\u0017\u0016\u001d"), Module.Category.Combat);
        AntiRegear antiRegear3 = a;
        antiRegear3.safeRange = antiRegear2.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("4B\u0003D5D\rQ\u0015"), 2, 0, 8));
        antiRegear.range = antiRegear.add(new SliderSetting(MathUtil.ALLATORIxDEMO("*\u0001\u0012\u0014\n"), 5, 0, 8));
        antiRegear.setChinese(ProjectionUtils.ALLATORIxDEMO("\u53aa\u724c\u8d27\u8853\u7ea9"));
    }

    @Override
    public void onUpdate() {
        AntiRegear a;
        if (SpeedMine.breakPos != null && AntiRegear.mc.field_1687.method_8320(SpeedMine.breakPos).method_26204() instanceof class_2480) {
            return;
        }
        if (a.getBlock() != null) {
            SpeedMine.INSTANCE.mine(a.getBlock().method_11016());
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ class_2627 getBlock() {
        var2_1 = a;
        var1_2 = BlockUtil.getTileEntities().iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = var1_2;
            while (v0.hasNext() != false) {
                a = var1_2.next();
                if (!(a instanceof class_2627)) ** GOTO lbl-1000
                if (!((double)class_3532.method_15355((float)((float)AntiRegear.mc.field_1724.method_5707((a = (class_2627)a).method_11016().method_46558()))) <= var2_1.safeRange.getValue())) continue block0;
                v0 = var1_2;
            }
            return null;
        } while (!((double)class_3532.method_15355((float)((float)AntiRegear.mc.field_1724.method_5707(a.method_11016().method_46558()))) <= var2_1.range.getValue()));
        return a;
    }
}
