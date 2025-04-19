/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1770
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.TravelEvent;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_1770;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public class ElytraFlyBypass
extends Module {
    public SliderSetting factor;
    public static ElytraFlyBypass INSTANCE;
    private boolean hasElytra;

    public ElytraFlyBypass() {
        ElytraFlyBypass a;
        ElytraFlyBypass elytraFlyBypass = a;
        ElytraFlyBypass elytraFlyBypass2 = a;
        super(CameraState.ALLATORIxDEMO("y)P\n`$o Y\u001fH?B<P"), Module.Category.Movement);
        elytraFlyBypass2.hasElytra = false;
        ElytraFlyBypass elytraFlyBypass3 = a;
        elytraFlyBypass.factor = elytraFlyBypass2.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("q?s;J{\u001c"), 1.2999999523162842, 0.10000000149011612, 4.0));
        elytraFlyBypass.setChinese(CameraState.ALLATORIxDEMO("\u97c5\u7ff4\u9891\u886f\u7e9a\u8fe4"));
        INSTANCE = elytraFlyBypass;
    }

    @Override
    public void onUpdate() {
        Object a;
        ElytraFlyBypass elytraFlyBypass = a;
        if (ElytraFlyBypass.nullCheck()) {
            return;
        }
        Object object = a = ElytraFlyBypass.mc.field_1724.method_5661().iterator();
        while (object.hasNext()) {
            if (((class_1799)a.next()).method_7909() instanceof class_1770) {
                elytraFlyBypass.hasElytra = true;
                return;
            }
            elytraFlyBypass.hasElytra = false;
            object = a;
        }
    }

    @EventHandler
    public void onMove(TravelEvent travelEvent) {
        TravelEvent a22 = travelEvent;
        ElytraFlyBypass a = this;
        if (ElytraFlyBypass.nullCheck() || !a.hasElytra || !ElytraFlyBypass.mc.field_1724.method_6128()) {
            return;
        }
        float a22 = (float)Math.toRadians(ElytraFlyBypass.mc.field_1724.method_36454());
        ElytraFlyBypass.mc.field_1724.method_5762((double)(-class_3532.method_15374((float)a22)) * a.factor.getValue() / 10.0, 0.0, (double)class_3532.method_15362((float)a22) * a.factor.getValue() / 10.0);
    }
}
