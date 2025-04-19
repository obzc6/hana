/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.xibao.Snow;
import java.util.List;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AntiCrawl
extends Module {
    private final BooleanSetting pre;
    public boolean work;
    public static AntiCrawl INSTANCE;
    double[] xzOffset;

    private /* synthetic */ boolean canBreak(class_2338 class_23382) {
        AntiCrawl a = class_23382;
        AntiCrawl a2 = this;
        return (BlockUtil.getClickSideStrict((class_2338)a) != null || SpeedMine.breakPos.equals((Object)a)) && !SpeedMine.godBlocks.contains((Object)AntiCrawl.mc.field_1687.method_8320((class_2338)a).method_26204()) && !AntiCrawl.mc.field_1687.method_22347((class_2338)a);
    }

    @Override
    public void onUpdate() {
        AntiCrawl a;
        AntiCrawl antiCrawl = a;
        antiCrawl.work = false;
        if (AntiCrawl.mc.field_1724.method_20448() || antiCrawl.pre.getValue() && Hana.BREAK.isMining(AntiCrawl.mc.field_1724.method_24515())) {
            double[] arrd = antiCrawl.xzOffset;
            int n = arrd.length;
            int n2 = a = 0;
            while (n2 < n) {
                int n3;
                double d = arrd[a];
                double[] arrd2 = antiCrawl.xzOffset;
                int n4 = arrd2.length;
                int n5 = n3 = 0;
                while (n5 < n4) {
                    double d2 = arrd2[n3];
                    BlockPosX blockPosX = new BlockPosX(AntiCrawl.mc.field_1724.method_23317() + d, AntiCrawl.mc.field_1724.method_23318() + 1.2, AntiCrawl.mc.field_1724.method_23321() + d2);
                    if (antiCrawl.canBreak(blockPosX)) {
                        SpeedMine.INSTANCE.mine(blockPosX);
                        antiCrawl.work = true;
                        return;
                    }
                    n5 = ++n3;
                }
                n2 = ++a;
            }
        }
    }

    public AntiCrawl() {
        AntiCrawl a;
        AntiCrawl antiCrawl = a;
        super(Snow.ALLATORIxDEMO("jnkJf~xh"), Module.Category.Combat);
        AntiCrawl antiCrawl2 = a;
        a.pre = a.add(new BooleanSetting(Tab.ALLATORIxDEMO("!*^"), true));
        a.work = false;
        double[] arrd = new double[3];
        arrd[0] = 0.0;
        arrd[1] = 0.3;
        arrd[2] = -0.3;
        antiCrawl.xzOffset = arrd;
        antiCrawl.setChinese(Snow.ALLATORIxDEMO("\u53d2\u8dbb\u4e0f"));
        INSTANCE = antiCrawl;
    }
}
