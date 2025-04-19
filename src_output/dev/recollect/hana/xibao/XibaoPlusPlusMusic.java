/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_5195
 *  net.minecraft.class_6880
 *  net.minecraft.class_6880$class_6883
 *  net.minecraft.class_7923
 */
package dev.recollect.hana.xibao;

import dev.recollect.hana.api.utils.math.Animation;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_5195;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import org.bytedeco.javacv.FrameConverter;

public class XibaoPlusPlusMusic {
    public static class_6880.class_6883<class_3414> BEIBAO_SOUND_EVENT;
    public static class_5195 XIBAO_MUSIC;
    public static class_5195 BEIBAO_MUSIC;
    public static class_6880.class_6883<class_3414> XIBAO_SOUND_EVENT;

    private static /* synthetic */ class_6880.class_6883<class_3414> registerReference(class_2960 a) {
        class_2960 class_29602 = a;
        return XibaoPlusPlusMusic.registerReference(class_29602, class_29602);
    }

    public XibaoPlusPlusMusic() {
        XibaoPlusPlusMusic a;
    }

    private static /* synthetic */ class_6880.class_6883<class_3414> registerReference(class_2960 class_29602, class_2960 class_29603) {
        class_2960 a = class_29603;
        class_2960 a2 = class_29602;
        return class_2378.method_47985((class_2378)class_7923.field_41172, (class_2960)a2, (Object)class_3414.method_47908((class_2960)a));
    }

    static {
        XIBAO_SOUND_EVENT = XibaoPlusPlusMusic.registerReference(new class_2960(Animation.ALLATORIxDEMO("uYiK~Pk"), FrameConverter.ALLATORIxDEMO("i\u0006nD)")));
        XIBAO_MUSIC = new class_5195(XIBAO_SOUND_EVENT, 0, 0, true);
        BEIBAO_SOUND_EVENT = XibaoPlusPlusMusic.registerReference(new class_2960(Animation.ALLATORIxDEMO("uYiK~Pk"), FrameConverter.ALLATORIxDEMO("\u0010t\u0006nD)")));
        BEIBAO_MUSIC = new class_5195(BEIBAO_SOUND_EVENT, 0, 0, true);
    }
}
