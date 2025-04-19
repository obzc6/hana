/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3675
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.AutoWalk;
import dev.recollect.hana.mod.modules.impl.movement.dev.SprintPlus;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_1041;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import org.bytedeco.javacv.BaseChildSettings;

public class InventoryMove
extends Module {
    private final BooleanSetting sneak;

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        InventoryMove a2 = this;
        a2.update();
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        InventoryMove a2 = this;
        a2.update();
    }

    @Override
    public void onUpdate() {
        InventoryMove a;
        a.update();
    }

    private /* synthetic */ void update() {
        InventoryMove a;
        InventoryMove inventoryMove = a;
        if (!(InventoryMove.mc.field_1755 instanceof class_408)) {
            class_304[] arrclass_304 = new class_304[4];
            arrclass_304[0] = InventoryMove.mc.field_1690.field_1881;
            arrclass_304[1] = InventoryMove.mc.field_1690.field_1913;
            arrclass_304[2] = InventoryMove.mc.field_1690.field_1849;
            arrclass_304[3] = InventoryMove.mc.field_1690.field_1903;
            class_304[] arrclass_3042 = arrclass_304;
            int n = arrclass_304.length;
            int n2 = a = 0;
            while (n2 < n) {
                class_304 class_3042;
                class_304 class_3043 = class_3042 = arrclass_3042[a];
                class_3043.method_23481(class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)class_3043.method_1428()).method_1444()));
                n2 = ++a;
            }
            InventoryMove.mc.field_1690.field_1894.method_23481(AutoWalk.INSTANCE.isOn() || class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)InventoryMove.mc.field_1690.field_1894.method_1428()).method_1444()));
            InventoryMove.mc.field_1690.field_1867.method_23481(SprintPlus.INSTANCE.isOn() || class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)InventoryMove.mc.field_1690.field_1867.method_1428()).method_1444()));
            if (inventoryMove.sneak.getValue()) {
                InventoryMove.mc.field_1690.field_1832.method_23481(class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)InventoryMove.mc.field_1690.field_1832.method_1428()).method_1444()));
            }
        }
    }

    public InventoryMove() {
        InventoryMove a;
        InventoryMove inventoryMove = a;
        InventoryMove inventoryMove2 = a;
        super(BaseChildSettings.ALLATORIxDEMO("\u0016\u001cpB=T;U*w!\u0006a"), Module.Category.Movement);
        InventoryMove inventoryMove3 = a;
        inventoryMove3.sneak = inventoryMove2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("3G\u0018\u0002\\"), false));
        inventoryMove.setDescription(BaseChildSettings.ALLATORIxDEMO("v4T'\u000b6\u001c&N=V1I'U<\t*"));
        inventoryMove.setChinese(RadiusUtils.ALLATORIxDEMO("\u80e5\u5378\u882f\u8d47"));
    }
}
