/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1661
 *  net.minecraft.class_1753
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.video.FileUtil;
import dev.recollect.hana.video.Renderer;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1661;
import net.minecraft.class_1753;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class Quiver
extends Module {
    public static Quiver INSTANCE;
    private final BooleanSetting smart;

    public Quiver() {
        Quiver a;
        Quiver quiver = a;
        super(FileUtil.ALLATORIxDEMO("R\u0019y\tb\u001a"), Module.Category.Combat);
        quiver.smart = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("3m\u001c8C"), true));
        quiver.setChinese(FileUtil.ALLATORIxDEMO("\u8186\u52b8\u5c7b\u81ed\u5d99"));
        INSTANCE = quiver;
    }

    @EventHandler(priority=-101)
    public void onRotate(RotateEvent a) {
        class_1799 a2;
        Quiver quiver = a2;
        if (Quiver.mc.field_1724.method_6115() && Quiver.mc.field_1724.method_6030().method_7909() instanceof class_1753) {
            int n;
            if (!quiver.smart.getValue()) {
                a.setPitch(-90.0f);
                return;
            }
            boolean bl = false;
            int n2 = n = 9;
            while (n2 < 45) {
                a2 = Quiver.mc.field_1724.method_31548().method_5438(n);
                if (a2.method_7909() == class_1802.field_8107) {
                    bl = false;
                } else if (a2.method_7909() == class_1802.field_8236) {
                    bl = false;
                } else if (a2.method_7909() == class_1802.field_8087) {
                    boolean bl2 = false;
                    for (class_1293 class_12932 : class_1844.method_8067((class_1799)a2)) {
                        if (class_12932.method_5579() != class_1294.field_5904 && class_12932.method_5579() != class_1294.field_5910) continue;
                        bl2 = true;
                    }
                    bl = bl2;
                }
                n2 = ++n;
            }
            if (bl) {
                a.setPitch(-90.0f);
            }
        }
    }
}
