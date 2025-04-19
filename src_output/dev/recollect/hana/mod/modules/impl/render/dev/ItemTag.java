/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.bytedeco.javacv.BaseChildSettings;

public class ItemTag
extends Module {
    public final BooleanSetting customName;
    public final BooleanSetting count;

    @Override
    public void onDisable() {
        Object a;
        ItemTag itemTag = a;
        if (ItemTag.mc.field_1687 == null) {
            return;
        }
        for (class_1297 class_12972 : ItemTag.mc.field_1687.method_18112()) {
            if (!(class_12972 instanceof class_1542)) continue;
            ((class_1542)class_12972).method_5880(false);
        }
    }

    @Override
    public void onUpdate() {
        ItemTag a2;
        ItemTag itemTag = a2;
        for (ItemTag a2 : ItemTag.mc.field_1687.method_18112()) {
            if (!(a2 instanceof class_1542)) continue;
            a2 = (class_1542)a2;
            String string = itemTag.count.getValue() ? " x" + a2.method_6983().method_7947() : "";
            a2.method_5665(class_2561.method_30163((String)((itemTag.customName.getValue() ? a2.method_6983().method_7964() : a2.method_6983().method_7909().method_7848()).getString() + string)));
            a2.method_5880(true);
        }
    }

    public ItemTag() {
        ItemTag a;
        ItemTag itemTag = a;
        ItemTag itemTag2 = a;
        super(BaseChildSettings.ALLATORIxDEMO("\u001dS6W\u001a\u0011c"), Module.Category.Render);
        ItemTag itemTag3 = a;
        itemTag3.customName = itemTag2.add(new BooleanSetting(Setting.ALLATORIxDEMO("X-o+t5H$!j"), false));
        itemTag.count = itemTag.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0010U;\u001ep"), true));
        itemTag.setChinese(Setting.ALLATORIxDEMO("\u726f\u5484\u684b\u7b71"));
    }
}
