/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameConverter;

public class testNCPRay
extends Module {
    public testNCPRay() {
        testNCPRay a;
        testNCPRay testNCPRay2 = a;
        super(Snow.ALLATORIxDEMO("tN@LyR[{h"), Module.Category.Misc);
        testNCPRay2.setChinese(FrameConverter.ALLATORIxDEMO("\u6d5d\u8ba7_,\\\u8fd8\u8e6c"));
    }

    @Override
    public void onEnable() {
        testNCPRay a;
        testNCPRay testNCPRay2 = a;
        if (testNCPRay.mc.field_1687 == null || testNCPRay.mc.field_1724 == null) {
            return;
        }
        a = testNCPRay.mc.field_1724.method_33571();
        class_243 class_2432 = a.method_1019(testNCPRay.mc.field_1724.method_5720().method_1021(5.0));
        testNCPRay testNCPRay3 = a;
        a = new class_238((class_243)testNCPRay3, class_2432);
        CommandManager.sendChatMessage("Raytrace" + (NCPRaytracer.raytrace((class_243)testNCPRay3, class_2432, (class_238)a) ? Snow.ALLATORIxDEMO("ase") : FrameConverter.ALLATORIxDEMO("\u0014s\u0004g\u001by")));
    }
}
