/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.ExtraModule;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldTrap;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_4587;

public class ExtraOldTrap
extends ExtraModule {
    public static final HashMap<class_2338, placePosition> PlaceMap = new HashMap();

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawBlock(class_2338 class_23382, double d, Color color, class_4587 class_45872) {
        void a;
        void a2;
        void a3;
        Color a4;
        ExtraOldTrap extraOldTrap = color2;
        Color color2 = color;
        ExtraOldTrap a5 = extraOldTrap;
        if (OldTrap.INSTANCE.sync.getValue()) {
            a4 = OldTrap.INSTANCE.color.getValue();
        }
        Render3DUtil.draw3DBox((class_4587)a, new class_238((class_2338)a3), ColorUtil.injectAlpha(a4, (int)a2), OldTrap.INSTANCE.outline.getValue(), OldTrap.INSTANCE.box.getValue());
    }

    public ExtraOldTrap() {
        ExtraOldTrap a;
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        placePosition a3;
        Iterator<placePosition> iterator;
        ExtraOldTrap extraOldTrap = a3;
        if (!OldTrap.INSTANCE.render.getValue()) {
            return;
        }
        if (PlaceMap.isEmpty()) {
            return;
        }
        boolean a22 = true;
        Iterator<placePosition> iterator2 = iterator = PlaceMap.values().iterator();
        while (iterator2.hasNext()) {
            a3 = iterator.next();
            if (!BlockUtil.clientCanPlace(a3.pos, true)) {
                a3.isAir = false;
            }
            if (!a3.timer.passedMs((long)(OldTrap.INSTANCE.delay.getValue() + 100.0)) && a3.isAir) {
                a3.firstFade.reset();
            }
            if (a3.firstFade.easeOutQuad() == 1.0) {
                iterator2 = iterator;
                continue;
            }
            a22 = false;
            iterator2 = iterator;
            extraOldTrap.drawBlock(a3.pos, (double)OldTrap.INSTANCE.color.getValue().getAlpha() * (1.0 - a3.firstFade.easeOutQuad()), a3.posColor, a);
        }
        if (a22) {
            PlaceMap.clear();
        }
    }

    public static void addBlock(class_2338 a) {
        if (BlockUtil.clientCanPlace(a, true) && !PlaceMap.containsKey((Object)a)) {
            class_2338 class_23382 = a;
            class_2338 class_23383 = a;
            PlaceMap.put(class_23383, new placePosition(class_23383));
        }
    }

    public static class placePosition {
        public final Timer timer;
        public final Color posColor;
        public final FadeUtils firstFade;
        public final class_2338 pos;
        public boolean isAir;

        public placePosition(class_2338 class_23382) {
            placePosition a;
            placePosition a2 = class_23382;
            placePosition placePosition2 = a = this;
            placePosition placePosition3 = a;
            placePosition2.firstFade = new FadeUtils((long)OldTrap.INSTANCE.fadeTime.getValue());
            placePosition2.pos = a2;
            placePosition2.posColor = OldTrap.INSTANCE.color.getValue();
            a.timer = new Timer();
            a.isAir = true;
            a.timer.reset();
        }
    }

}
