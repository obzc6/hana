/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.render.PlaceRender;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_2338;

public class PlaceRender.PlacePos {
    final /* synthetic */ PlaceRender this$0;
    public final Timer timer;
    public final FadeUtils fade;
    public boolean isAir;
    public final class_2338 pos;

    /*
     * WARNING - void declaration
     */
    public PlaceRender.PlacePos(PlaceRender placeRender, class_2338 class_23382) {
        void a;
        PlaceRender.PlacePos a2;
        PlaceRender a3 = placeRender;
        PlaceRender.PlacePos placePos = a2 = this;
        a2.this$0 = a3;
        PlaceRender.PlacePos placePos2 = a2;
        placePos2.fade = new FadeUtils((long)a3.fadeTime.getValue());
        placePos.pos = a;
        placePos.timer = new Timer();
        placePos.isAir = true;
    }
}
