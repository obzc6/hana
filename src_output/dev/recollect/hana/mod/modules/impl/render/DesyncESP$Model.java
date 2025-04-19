/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_3300
 *  net.minecraft.class_5599
 *  net.minecraft.class_5601
 *  net.minecraft.class_5602
 *  net.minecraft.class_5617
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_591
 *  net.minecraft.class_630
 *  net.minecraft.class_759
 *  net.minecraft.class_776
 *  net.minecraft.class_898
 *  net.minecraft.class_918
 *  org.joml.Vector3f
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.impl.render.DesyncESP;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_3300;
import net.minecraft.class_5599;
import net.minecraft.class_5601;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_759;
import net.minecraft.class_776;
import net.minecraft.class_898;
import net.minecraft.class_918;
import org.joml.Vector3f;

private static class DesyncESP.Model {
    private final class_591<class_1657> modelPlayer;

    public DesyncESP.Model() {
        DesyncESP.Model a;
        a.modelPlayer = new class_591(new class_5617.class_5618(Wrapper.mc.method_1561(), Wrapper.mc.method_1480(), Wrapper.mc.method_1541(), Wrapper.mc.method_1561().method_43336(), Wrapper.mc.method_1478(), Wrapper.mc.method_31974(), Wrapper.mc.field_1772).method_32167(class_5602.field_27577), false);
        a.modelPlayer.method_2838().method_41924(new Vector3f(-0.3f, -0.3f, -0.3f));
    }
}
