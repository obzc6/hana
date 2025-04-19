/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.TotemParticleEvent;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.Random;
import org.bytedeco.javacv.FrameConverter;

public class TotemParticle
extends Module {
    public static TotemParticle INSTANCE;
    private final ColorSetting color;
    public final SliderSetting velocityY;
    private final ColorSetting color2;
    Random random;
    public final SliderSetting velocityXZ;

    @EventHandler
    public void idk(TotemParticleEvent totemParticleEvent) {
        TotemParticleEvent a = totemParticleEvent;
        TotemParticle a2 = this;
        Object object = a;
        Object object2 = a;
        ((Event)object2).cancel();
        ((TotemParticleEvent)object2).velocityZ *= a2.velocityXZ.getValue() / 100.0;
        ((TotemParticleEvent)object).velocityX *= a2.velocityXZ.getValue() / 100.0;
        ((TotemParticleEvent)object).velocityY *= a2.velocityY.getValue() / 100.0;
        ((TotemParticleEvent)object).color = ColorUtil.fadeColor(a2.color.getValue(), a2.color2.getValue(), a2.random.nextDouble());
    }

    public TotemParticle() {
        TotemParticle a;
        TotemParticle totemParticle = a;
        TotemParticle totemParticle2 = a;
        super(FrameConverter.ALLATORIxDEMO("IH0\u0017|%w\u0000e\u0006oI#"), Module.Category.Render);
        TotemParticle totemParticle3 = a;
        totemParticle3.color = totemParticle2.add(new ColorSetting(FadeUtils.ALLATORIxDEMO("~\u001eLT\u0018"), new Color(255, 255, 255, 255)));
        totemParticle2.color2 = totemParticle2.add(new ColorSetting(FrameConverter.ALLATORIxDEMO("1~\u0003cWt"), new Color(0, 0, 0, 255)));
        totemParticle2.velocityXZ = totemParticle2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO(":X\u0007U\u000fT\u0005Yc0"), 100.0, 0.0, 500.0, 1.0).setSuffix(FrameConverter.ALLATORIxDEMO("c")));
        totemParticle2.velocityY = totemParticle2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("k\u000eV\u0003^\u0018TB3"), 100.0, 0.0, 500.0, 1.0).setSuffix(FrameConverter.ALLATORIxDEMO("c")));
        totemParticle.random = new Random();
        totemParticle.setChinese(FadeUtils.ALLATORIxDEMO("\u568f\u815e\u7ca9\u5b3a"));
        INSTANCE = totemParticle;
    }
}
