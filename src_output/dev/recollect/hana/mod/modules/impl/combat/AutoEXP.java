/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2371
 *  net.minecraft.class_2596
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_1268;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2371;
import net.minecraft.class_2596;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoEXP
extends Module {
    private final Timer delayTimer;
    public static AutoEXP INSTANCE;
    private final BooleanSetting onlyGround;
    private final BooleanSetting usingPause;
    int exp;
    private final SliderSetting delay;
    public final BooleanSetting down;
    public final BooleanSetting onlyBroken;
    private final BooleanSetting inventory;
    private boolean throwing;

    public void throwExp() {
        AutoEXP a22;
        AutoEXP autoEXP = a22;
        int n = AutoEXP.mc.field_1724.method_31548().field_7545;
        if (autoEXP.inventory.getValue() && (a22 = InventoryUtil.findItemInventorySlot(class_1802.field_8287)) != -1) {
            InventoryUtil.inventorySwap(a22, AutoEXP.mc.field_1724.method_31548().field_7545);
            AutoEXP.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, EntityUtil.getWorldActionId(AutoEXP.mc.field_1687)));
            InventoryUtil.inventorySwap(a22, AutoEXP.mc.field_1724.method_31548().field_7545);
            EntityUtil.syncInventory();
            autoEXP.delayTimer.reset();
            return;
        }
        int a22 = InventoryUtil.findItem(class_1802.field_8287);
        if (a22 != -1) {
            InventoryUtil.switchToSlot(a22);
            AutoEXP.mc.field_1724.field_3944.method_52787((class_2596)new class_2886(class_1268.field_5808, EntityUtil.getWorldActionId(AutoEXP.mc.field_1687)));
            InventoryUtil.switchToSlot(n);
            autoEXP.delayTimer.reset();
        }
    }

    public boolean isThrow() {
        AutoEXP a;
        return a.throwing;
    }

    public boolean checkThrow() {
        Object a;
        Object object = a;
        if (((Module)object).isOff()) {
            return false;
        }
        if (AutoEXP.mc.field_1755 instanceof class_408) {
            return false;
        }
        if (AutoEXP.mc.field_1755 != null) {
            return false;
        }
        if (((AutoEXP)object).usingPause.getValue() && AutoEXP.mc.field_1724.method_6115()) {
            return false;
        }
        if (!(InventoryUtil.findItem(class_1802.field_8287) != -1 || ((AutoEXP)object).inventory.getValue() && InventoryUtil.findItemInventorySlot(class_1802.field_8287) != -1)) {
            return false;
        }
        if (((AutoEXP)object).onlyBroken.getValue()) {
            Object object2 = a = AutoEXP.mc.field_1724.method_31548().field_7548.iterator();
            while (object2.hasNext()) {
                class_1799 class_17992 = (class_1799)a.next();
                if (class_17992.method_7960()) {
                    object2 = a;
                    continue;
                }
                if (EntityUtil.getDamagePercent(class_17992) >= 100) {
                    object2 = a;
                    continue;
                }
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void onDisable() {
        a.throwing = false;
    }

    @EventHandler(priority=-200)
    public void RotateEvent(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        AutoEXP a2 = this;
        if (!a2.down.getValue()) {
            return;
        }
        if (a2.isThrow()) {
            a.setPitch(88.0f);
        }
    }

    @Override
    public String getInfo() {
        AutoEXP a;
        return String.valueOf(a.exp);
    }

    public AutoEXP() {
        AutoEXP a;
        AutoEXP autoEXP = a;
        AutoEXP autoEXP2 = a;
        AutoEXP autoEXP3 = a;
        super(RadiusUtils.ALLATORIxDEMO("&A\u0014F8;g"), Module.Category.Combat);
        AutoEXP autoEXP4 = a;
        autoEXP4.delay = autoEXP3.add(new SliderSetting(BackgroundInfo.ALLATORIxDEMO("\u000f$:je"), 3, 0, 5));
        autoEXP3.down = autoEXP3.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("m\u0012\u0014Y"), true));
        autoEXP3.onlyBroken = autoEXP3.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u0013%75\u001e9.=nr"), true));
        autoEXP3.usingPause = autoEXP3.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("a\u0013Z\tS0H\b\u0010R"), true));
        autoEXP3.onlyGround = autoEXP3.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u0013%75\u001b9.#ex"), true));
        autoEXP2.inventory = autoEXP3.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("\u0010\u000fCQ\u000eG\bF\u0019z\n\u0002G"), true));
        autoEXP2.delayTimer = new Timer();
        autoEXP2.throwing = false;
        autoEXP.exp = false ? 1 : 0;
        autoEXP.setChinese(BackgroundInfo.ALLATORIxDEMO("\u81a1\u52e9\u7e99\u9a87\u74ea"));
        INSTANCE = autoEXP;
    }

    @Override
    public void onUpdate() {
        AutoEXP a;
        if (!a.getBind().isPressed()) {
            a.disable();
            return;
        }
        AutoEXP autoEXP = a;
        autoEXP.throwing = autoEXP.checkThrow();
        if (autoEXP.isThrow()) {
            AutoEXP autoEXP2 = a;
            if (autoEXP2.delayTimer.passedMs((long)autoEXP2.delay.getValueInt() * 20L) && (!a.onlyGround.getValue() || AutoEXP.mc.field_1724.method_24828())) {
                a.exp = InventoryUtil.getItemCount(class_1802.field_8287) - 1;
                a.throwExp();
            }
        }
    }

    @Override
    public void onEnable() {
        if (AutoEXP.nullCheck()) {
            AutoEXP a;
            a.disable();
            return;
        }
        a.exp = InventoryUtil.getItemCount(class_1802.field_8287);
    }
}
