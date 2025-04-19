/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4587;

public class BlockerESP
extends Module {
    private final BooleanSetting outline;
    private final BooleanSetting burrow;
    private final BooleanSetting surround;
    final List<class_2338> renderList;
    private final BooleanSetting box;
    private final ColorSetting color;

    private /* synthetic */ boolean isObsidian(class_2338 class_23382) {
        BlockerESP a = class_23382;
        BlockerESP a2 = this;
        return (BlockUtil.getBlock((class_2338)a) == class_2246.field_10540 || BlockUtil.getBlock((class_2338)a) == class_2246.field_10443) && !a2.renderList.contains(a);
    }

    public BlockerESP() {
        BlockerESP a;
        BlockerESP blockerESP = a;
        super(BackgroundInfo.ALLATORIxDEMO("\u001e'4/7.3\u0013XL"), Module.Category.Render);
        BlockerESP blockerESP2 = a;
        blockerESP2.color = blockerESP.add(new ColorSetting(BlockUpUtil.ALLATORIxDEMO("YWk\u001d?"), new Color(255, 255, 255, 100)));
        blockerESP.box = blockerESP.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u0014dd"), true));
        blockerESP.outline = blockerESP.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("RPnTn\u001c("), true));
        blockerESP.burrow = blockerESP.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u001e>3$dk"), true));
        a.surround = blockerESP.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("qhWhWr\u001c)"), true));
        a.renderList = new ArrayList<class_2338>();
        a.setChinese(BackgroundInfo.ALLATORIxDEMO("\u65f8\u5701\u6635\u7926"));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onRender3D(class_4587 var1_2, float var2_3) {
        var9_4 = this;
        var9_4.renderList.clear();
        a = (float)CombatSetting.getOffset();
        var3_5 = CombatUtil.getEnemies(10.0).iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = var3_5;
            do {
                block10 : {
                    block11 : {
                        block9 : {
                            if (!v0.hasNext()) break block9;
                            var4_6 = (class_1297)var3_5.next();
                            if (!var9_4.burrow.getValue()) break block10;
                            v1 = new float[3];
                            v1[0] = -a;
                            v1[1] = 0.0f;
                            v1[2] = a;
                            var5_7 = v1;
                            var6_9 = v1;
                            var7_11 = var6_9.length;
                            v2 = var8_12 = 0;
                            break block11;
                        }
                        var3_5 = var9_4.renderList.iterator();
                        v3 = var3_5;
                        while (v3.hasNext() != false) {
                            var4_6 = (class_2338)var3_5.next();
                            v3 = var3_5;
                            Render3DUtil.draw3DBox((class_4587)a, new class_238((class_2338)var4_6), var9_4.color.getValue(), var9_4.outline.getValue(), var9_4.box.getValue());
                        }
                        return;
                    }
                    while (v2 < var7_11) {
                        a = var6_9[var8_12];
                        var10_13 = var5_7;
                        var11_14 = var10_13.length;
                        v4 = var12_15 = 0;
                        while (v4 < var11_14) {
                            var13_16 = var10_13[var12_15];
                            var14_17 = new BlockPosX(var4_6.method_19538().method_1031((double)a, 0.0, (double)var13_16));
                            if (var9_4.isObsidian(var14_17)) {
                                var9_4.renderList.add(var14_17);
                            }
                            if (var9_4.isObsidian(var14_17 = new BlockPosX(var4_6.method_19538().method_1031((double)a, 0.5, (double)var13_16)))) {
                                var9_4.renderList.add(var14_17);
                            }
                            v4 = ++var12_15;
                        }
                        v2 = ++var8_12;
                    }
                }
                if (!var9_4.surround.getValue()) ** GOTO lbl-1000
                var5_7 = EntityUtil.getEntityPos(var4_6, true);
                if (BlockUtil.isHole((class_2338)var5_7)) break;
                v0 = var3_5;
            } while (true);
            var6_10 = class_2350.values();
            var7_11 = var6_10.length;
            v5 = var8_12 = 0;
            do {
                if (v5 >= var7_11) continue block0;
                a = var6_10[var8_12];
                if (a != class_2350.field_11036 && a != class_2350.field_11033 && var9_4.isObsidian(var5_7.method_10093((class_2350)a))) {
                    var9_4.renderList.add(var5_7.method_10093((class_2350)a));
                }
                v5 = ++var8_12;
            } while (true);
            break;
        } while (true);
    }
}
