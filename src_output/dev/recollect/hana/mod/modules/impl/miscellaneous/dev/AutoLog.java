/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2661
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_2561;
import net.minecraft.class_2661;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoLog
extends Module {
    private final SliderSetting health;

    @Override
    public void onUpdate() {
        AutoLog a;
        if (AutoLog.mc.field_1724.method_6032() < a.health.getValueFloat()) {
            AutoLog autoLog = a;
            autoLog.onDisconnect();
            autoLog.disable();
        }
    }

    private /* synthetic */ void onDisconnect() {
        if (AutoLog.mc.field_1724 == null || AutoLog.mc.field_1687 == null) {
            return;
        }
        AutoLog.mc.field_1724.field_3944.method_52781(new class_2661(class_2561.method_30163((String)Tab.ALLATORIxDEMO("\u0013jR0|<}\u0016TJI<{\u0018d\f}J`\u000eC-{\u00045\u0017w\u0003)\u0004g\u001f(\u0018v\u0010u\t`\u0005"))));
    }

    public AutoLog() {
        AutoLog a;
        AutoLog autoLog = a;
        super(CrystalUtil.ALLATORIxDEMO("\u001a}\fD\u0017L4"), Module.Category.Misc);
        AutoLog autoLog2 = a;
        a.health = new SliderSetting(Tab.ALLATORIxDEMO("G\ts\u001d,S"), 10.0, 1.0, 36.0, 1.0);
        autoLog.setChinese(CrystalUtil.ALLATORIxDEMO("\u81c1\u52f3\u9023\u51a9"));
        autoLog.addSetting(a.health);
    }
}
