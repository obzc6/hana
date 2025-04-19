/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1702
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1702;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public class AutoEat
extends Module {
    private final SliderSetting health;
    public static AutoEat INSTANCE;
    boolean eat;
    private final SliderSetting hunger;

    @Override
    public void onUpdate() {
        AutoEat a;
        if (EntityUtil.getHealth((class_1297)AutoEat.mc.field_1724) <= a.health.getValueFloat() || (float)AutoEat.mc.field_1724.method_7344().method_7586() <= a.hunger.getValueFloat()) {
            if (InventoryUtil.findItem(class_1802.field_8367) != -1) {
                InventoryUtil.switchToSlot(InventoryUtil.findItem(class_1802.field_8367));
                AutoEat.mc.field_1690.field_1904.method_23481(true);
                a.eat = true;
                return;
            }
            if (InventoryUtil.findItem(class_1802.field_8463) != -1) {
                InventoryUtil.switchToSlot(InventoryUtil.findItem(class_1802.field_8463));
                AutoEat.mc.field_1690.field_1904.method_23481(true);
                a.eat = true;
                return;
            }
        } else if (a.eat) {
            AutoEat.mc.field_1690.field_1904.method_23481(false);
            a.eat = false;
        }
    }

    public AutoEat() {
        AutoEat a;
        AutoEat autoEat = a;
        AutoEat autoEat2 = a;
        super(RadiusUtils.ALLATORIxDEMO("&A\u0014F8\u0002C"), Module.Category.Misc);
        AutoEat autoEat3 = a;
        autoEat3.hunger = autoEat2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("$H\u001fG^\u0018"), 10.0, 0.0, 19.0, 1.0));
        autoEat2.health = autoEat2.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("|\u0005H\u0011\u0017_"), 20.0, 0.0, 35.9, 0.1));
        autoEat.eat = false;
        autoEat.setChinese(FadeUtils.ALLATORIxDEMO("\u81ca\u5293\u5469"));
        INSTANCE = autoEat;
    }
}
