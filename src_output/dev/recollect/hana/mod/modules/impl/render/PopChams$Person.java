/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
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
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.modules.impl.render.PopChams;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.class_1297;
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

private class PopChams.Person {
    private int alpha;
    private float yOffset;
    final /* synthetic */ PopChams this$0;
    private final class_1657 player;
    private final float moveSpeed;
    private final class_591<class_1657> modelPlayer;

    public void update(CopyOnWriteArrayList<PopChams.Person> copyOnWriteArrayList) {
        CopyOnWriteArrayList<PopChams.Person> a = copyOnWriteArrayList;
        PopChams.Person a2 = this;
        if (a2.alpha <= 0) {
            a.remove(a2);
            PopChams.Person person = a2;
            person.player.method_5768();
            person.player.method_5650(class_1297.class_5529.field_26998);
            person.player.method_36209();
            return;
        }
        if (a2.yOffset < 2.0f) {
            a2.yOffset += a2.moveSpeed;
        }
        a2.alpha = (int)(AnimateUtil.animate(a2.alpha, 0.0, a2.this$0.alphaSpeed.getValue()) - 0.2);
    }

    public int getAlpha() {
        PopChams.Person a;
        return (int)MathUtil.clamp(a.alpha, 0.0f, 255.0f);
    }

    /*
     * WARNING - void declaration
     */
    public PopChams.Person(PopChams object, class_1657 class_16572) {
        void a;
        Object a2 = object;
        object = this;
        ((PopChams.Person)object).this$0 = a2;
        object();
        ((PopChams.Person)object).player = a;
        Object object2 = object;
        ((PopChams.Person)object).modelPlayer = new class_591(new class_5617.class_5618(Wrapper.mc.method_1561(), Wrapper.mc.method_1480(), Wrapper.mc.method_1541(), Wrapper.mc.method_1561().method_43336(), Wrapper.mc.method_1478(), Wrapper.mc.method_31974(), Wrapper.mc.field_1772).method_32167(class_5602.field_27577), false);
        ((PopChams.Person)object).modelPlayer.method_2838().method_41924(new Vector3f(-0.3f, -0.3f, -0.3f));
        ((PopChams.Person)object).alpha = ((PopChams)a2).color.getValue().getAlpha();
        ((PopChams.Person)object).moveSpeed = (float)PopChams.INSTANCE.riseSpeed.getValue();
    }
}
