/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2404
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2404;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Glide
extends Module {
    public static Glide INSTANCE = new Glide();
    public final SliderSetting moveSpeed;
    public final SliderSetting minHeight;
    public final SliderSetting fallSpeed;

    public Glide() {
        Glide a;
        Glide glide = a;
        Glide glide2 = a;
        super(OnlineUserInfo.ALLATORIxDEMO("\u0019H:A7"), GaussianFilter.ALLATORIxDEMO("d>W|\u0011"), Module.Category.Movement);
        glide2.setChinese(OnlineUserInfo.ALLATORIxDEMO("\u6ef4\u7f86"));
        Glide glide3 = a;
        glide3.fallSpeed = glide.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("e)H#p\"[}\u0010"), 0.125, 0.005, 0.25, 0.005));
        glide.moveSpeed = glide.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("=C-L\rT6@6"), 1.2, 1.0, 5.0, 0.05));
        glide.minHeight = glide.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("n!J\u0007F;Yp\u0000"), 0.0, 0.0, 2.0, 0.01));
        INSTANCE = glide;
    }

    @Override
    public void onUpdate() {
        Glide a;
        Glide glide = a;
        class_746 class_7462 = Glide.mc.field_1724;
        class_243 class_2432 = null;
        if (class_7462 != null) {
            class_2432 = class_7462.method_18798();
        }
        if (!(class_7462 != null && (class_7462.method_24828() || class_7462.method_5799() || class_7462.method_5771() || class_7462.method_6101() || class_2432.field_1351 >= 0.0))) {
            if (glide.minHeight.getValue() > 0.0) {
                a = null;
                if (class_7462 != null) {
                    a = class_7462.method_5829();
                }
                Glide glide2 = a;
                a = glide2.method_991(glide2.method_989(0.0, -glide.minHeight.getValue(), 0.0));
                if (Glide.mc.field_1687 != null && !Glide.mc.field_1687.method_18026((class_238)a)) {
                    return;
                }
                Glide glide3 = a;
                class_2338 class_23382 = class_2338.method_49637((double)((class_238)glide3).field_1323, (double)((class_238)a).field_1322, (double)((class_238)a).field_1321);
                a = class_2338.method_49637((double)((class_238)glide3).field_1320, (double)((class_238)a).field_1325, (double)((class_238)a).field_1324);
                StreamSupport.stream(BlockUtil.getAllInBox(class_23382, (class_2338)a).spliterator(), true).map(BlockUtil::getBlock);
                Objects.requireNonNull(class_2404.class);
                return;
            }
            if (class_7462 != null) {
                class_7462.method_18800(class_2432.field_1352, Math.max(class_2432.field_1351, -glide.fallSpeed.getValue()), class_2432.field_1350);
            }
        }
    }

    public void onGetAirStrafingSpeed() {
        Glide a;
        a.moveSpeed.getValue();
    }
}
