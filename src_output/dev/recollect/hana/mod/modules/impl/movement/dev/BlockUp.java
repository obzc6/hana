/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class BlockUp
extends Module {
    private final BooleanSetting onlyMoveInBurrow;
    private final SliderSetting rubberbandOffset;
    private final BooleanSetting vClip;
    private final BooleanSetting pEndChest;
    private final SliderSetting rubberbandPackets;

    public BlockUp() {
        BlockUp a;
        BlockUp blockUp = a;
        BlockUp blockUp2 = a;
        super(User.ALLATORIxDEMO("rHWymjS"), Module.Category.Movement);
        BlockUp blockUp3 = a;
        blockUp3.onlyMoveInBurrow = blockUp2.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("S\u000b:Z\u001dC\u0012X'Bl\u0019"), true));
        blockUp2.rubberbandOffset = blockUp2.add(new SliderSetting(User.ALLATORIxDEMO("k^|uZW"), 9, -10, 10));
        blockUp2.rubberbandPackets = blockUp2.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("}4I#Rv\u000e"), 9, 0, 10));
        blockUp2.pEndChest = blockUp2.add(new BooleanSetting(User.ALLATORIxDEMO("i^@{rcLW"), true));
        blockUp.vClip = blockUp.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\\\u000b[k\r"), true));
        blockUp.setChinese(User.ALLATORIxDEMO("\u81ce\u5290\u5f23\u51fc\u6586\u5774"));
    }

    @Override
    public void onEnable() {
        BlockUp a;
        if (BlockUp.mc.field_1724 != null && (!a.onlyMoveInBurrow.getValue() || BlockUpUtil.isBurrowed(BlockUp.mc.field_1724, !a.pEndChest.getValue()))) {
            int n;
            double d = 0.0;
            double d2 = 0.42;
            double d3 = d;
            while (d3 < 1.1) {
                d2 = (d2 - 0.08) * 0.98;
                BlockUp.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(BlockUp.mc.field_1724.method_23317(), BlockUp.mc.field_1724.method_23318() + (d += d2), BlockUp.mc.field_1724.method_23321(), false));
                d3 = d;
            }
            int n2 = n = 0;
            while (n2 < a.rubberbandPackets.getValueInt()) {
                BlockUp.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(BlockUp.mc.field_1724.method_23317(), BlockUp.mc.field_1724.method_23318() + d + (double)a.rubberbandOffset.getValueInt(), BlockUp.mc.field_1724.method_23321(), false));
                n2 = ++n;
            }
        }
        if (a.vClip.getValue()) {
            BlockUp.mc.field_1724.method_5814(BlockUp.mc.field_1724.method_23317(), BlockUp.mc.field_1724.method_23318() + 3.0, BlockUp.mc.field_1724.method_23321());
            mc.method_1562().method_52787((class_2596)new class_2828.class_2829(BlockUp.mc.field_1724.method_23317(), BlockUp.mc.field_1724.method_23318(), BlockUp.mc.field_1724.method_23321(), false));
        }
        a.toggle();
    }
}
