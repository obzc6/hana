/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_437
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IMinecraftClient;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1268;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_437;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class SmartEat
extends Module {
    private final BooleanSetting rottenFlesh;
    private final SliderSetting health;
    private final BooleanSetting chorus;
    private final BooleanSetting gapple;
    private boolean eating;
    private final BooleanSetting spiderEye;
    private final SliderSetting burhealth;
    private final BooleanSetting pufferfish;
    private final SliderSetting targetdmg;

    public SmartEat() {
        SmartEat a;
        SmartEat smartEat = a;
        super(Animation.ALLATORIxDEMO("dagOV\\Vx"), Module.Category.Player);
        SmartEat smartEat2 = a;
        smartEat2.health = smartEat.add(new SliderSetting(Snow.ALLATORIxDEMO("l\u0015a8a)"), 10.0, 0.0, 36.0));
        smartEat.burhealth = smartEat.add(new SliderSetting(Animation.ALLATORIxDEMO("p_HB~NXCuCd"), 7.0, 0.0, 36.0));
        smartEat.targetdmg = smartEat.add(new SliderSetting(Snow.ALLATORIxDEMO("\u0013t3C\u0015t\u0010X\u0006"), 10.0, 0.0, 36.0));
        smartEat.gapple = smartEat.add(new BooleanSetting(Animation.ALLATORIxDEMO("A\\Ri[i"), false));
        smartEat.chorus = smartEat.add(new BooleanSetting(Snow.ALLATORIxDEMO("g\u0018o&`2"), false));
        smartEat.rottenFlesh = smartEat.add(new BooleanSetting(Animation.ALLATORIxDEMO("K^~Cih{N|Dd"), false));
        smartEat.spiderEye = smartEat.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u0014e(@\u0015r\u0011l$"), false));
        smartEat.pufferfish = smartEat.add(new BooleanSetting(Animation.ALLATORIxDEMO("aQjcODpDd"), false));
    }

    @Override
    public void onUpdate() {
        SmartEat a;
        SmartEat smartEat = a;
        if ((double)SmartEat.mc.field_1724.method_6032() <= smartEat.health.getValue()) {
            SmartEat smartEat2;
            block10 : {
                SmartEat smartEat3;
                if (!smartEat.isHandGood(class_1268.field_5808) && !smartEat.isHandGood(class_1268.field_5810)) {
                    int n;
                    int n2 = n = 0;
                    while (n2 < 9) {
                        a = SmartEat.mc.field_1724.method_31548().method_5438(n);
                        if (a.method_19267() && (smartEat.gapple.getValue() || a.method_7909() != class_1802.field_8463 && a.method_7909() != class_1802.field_8367) && (smartEat.chorus.getValue() || a.method_7909() != class_1802.field_8233) && (smartEat.rottenFlesh.getValue() || a.method_7909() != class_1802.field_8511) && (smartEat.spiderEye.getValue() || a.method_7909() != class_1802.field_8680) && (smartEat.pufferfish.getValue() || a.method_7909() != class_1802.field_8323)) {
                            SmartEat.mc.field_1724.method_31548().field_7545 = n;
                            SmartEat.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(n));
                            smartEat3 = smartEat;
                            break block10;
                        }
                        n2 = ++n;
                    }
                }
                smartEat3 = smartEat;
            }
            smartEat3.eating = true;
            if ((double)SmartEat.mc.field_1724.method_6032() <= smartEat.health.getValue() || BlockUtil.isHole(EntityUtil.getPlayerPos(true)) || smartEat.isObsidian(EntityUtil.getPlayerPos(true))) {
                smartEat.eating = false;
                if (SmartEat.mc.field_1724.method_6030().method_7909().method_19263() && SmartEat.mc.field_1724.method_6115()) {
                    SmartEat.mc.field_1724.method_6075();
                }
            }
            if (smartEat.isObsidian(EntityUtil.getPlayerPos(true)) && (double)SmartEat.mc.field_1724.method_6032() <= smartEat.burhealth.getValue() || (double)HanaAura.INSTANCE.lastDamage >= smartEat.targetdmg.getValue()) {
                smartEat.eating = true;
            }
            if (SmartEat.mc.field_1755 != null && !SmartEat.mc.field_1724.method_6115() && SmartEat.mc.field_1724.method_6030().method_7909().method_19263()) {
                ((IMinecraftClient)mc).idoItemUse();
                smartEat2 = smartEat;
            } else {
                SmartEat.mc.field_1690.field_1904.method_23481(true);
                smartEat2 = smartEat;
            }
            smartEat2.eating = false;
            SmartEat.mc.field_1724.method_6075();
            return;
        }
        if (smartEat.eating) {
            smartEat.eating = false;
            SmartEat.mc.field_1690.field_1904.method_23481(false);
            SmartEat.mc.field_1724.method_6075();
        }
    }

    private /* synthetic */ boolean isObsidian(class_2338 class_23382) {
        SmartEat a = class_23382;
        SmartEat a2 = this;
        return BlockUtil.getBlock((class_2338)a) == class_2246.field_10540 || BlockUtil.getBlock((class_2338)a) == class_2246.field_10443;
    }

    private /* synthetic */ boolean isHandGood(class_1268 class_12682) {
        SmartEat a = class_12682;
        SmartEat a2 = this;
        SmartEat smartEat = a = a == class_1268.field_5808 ? SmartEat.mc.field_1724.method_6047() : SmartEat.mc.field_1724.method_6079();
        a = smartEat.method_7909();
        return !(!smartEat.method_19267() || !a2.gapple.getValue() && (a == class_1802.field_8463 || a == class_1802.field_8367) || !a2.chorus.getValue() && a == class_1802.field_8233 || !a2.rottenFlesh.getValue() && a == class_1802.field_8511 || !a2.spiderEye.getValue() && a == class_1802.field_8680 || !a2.pufferfish.getValue() && a == class_1802.field_8323);
    }
}
