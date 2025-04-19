/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.impl.combat.AutoTrap;
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

public class AutoTrap.AutoTrapRender {
    public static final HashMap<class_2338, placePosition> PlaceMap = new HashMap();
    final /* synthetic */ AutoTrap this$0;

    @EventHandler
    public void onRender3D(Render3DEvent a) {
        placePosition a2;
        Iterator<placePosition> iterator;
        AutoTrap.AutoTrapRender autoTrapRender = a2;
        if (!autoTrapRender.this$0.render.getValue()) {
            return;
        }
        if (PlaceMap.isEmpty()) {
            return;
        }
        boolean bl = true;
        Iterator<placePosition> iterator2 = iterator = PlaceMap.values().iterator();
        while (iterator2.hasNext()) {
            a2 = iterator.next();
            if (!BlockUtil.clientCanPlace(a2.pos, true)) {
                a2.isAir = false;
            }
            if (!a2.timer.passedMs((long)(autoTrapRender.this$0.delay.getValue() + 100.0)) && a2.isAir) {
                a2.firstFade.reset();
            }
            if (a2.firstFade.getQuad(FadeUtils.Quad.In2) == 1.0) {
                iterator2 = iterator;
                continue;
            }
            bl = false;
            iterator2 = iterator;
            AutoTrap.AutoTrapRender autoTrapRender2 = autoTrapRender;
            autoTrapRender2.drawBlock(a2.pos, (double)autoTrapRender2.this$0.color.getValue().getAlpha() * (1.0 - a2.firstFade.getQuad(FadeUtils.Quad.In2)), a2.posColor, a.getMatrixStack());
        }
        if (bl) {
            PlaceMap.clear();
        }
    }

    public AutoTrap.AutoTrapRender(AutoTrap autoTrap) {
        AutoTrap a = autoTrap;
        AutoTrap.AutoTrapRender a2 = this;
        a2.this$0 = a;
    }

    public static void addBlock(class_2338 a) {
        if (BlockUtil.clientCanPlace(a, true) && !PlaceMap.containsKey((Object)a)) {
            class_2338 class_23382 = a;
            class_2338 class_23383 = a;
            PlaceMap.put(class_23383, new placePosition(class_23383));
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawBlock(class_2338 class_23382, double d, Color color, class_4587 class_45872) {
        void a;
        void a2;
        void a3;
        Color a4;
        AutoTrap.AutoTrapRender autoTrapRender = color2;
        Color color2 = color;
        AutoTrap.AutoTrapRender a5 = autoTrapRender;
        if (a5.this$0.sync.getValue()) {
            a4 = AutoTrap.INSTANCE.color.getValue();
        }
        Render3DUtil.draw3DBox((class_4587)a, new class_238((class_2338)a3), ColorUtil.injectAlpha(a4, (int)a2), a5.this$0.outline.getValue(), a5.this$0.box.getValue());
    }

    public static class placePosition {
        public boolean isAir;
        public final Timer timer;
        public final class_2338 pos;
        public final Color posColor;
        public final FadeUtils firstFade;

        public placePosition(class_2338 class_23382) {
            placePosition a;
            placePosition a2 = class_23382;
            placePosition placePosition2 = a = this;
            placePosition placePosition3 = a;
            placePosition2.firstFade = new FadeUtils((long)AutoTrap.INSTANCE.fadeTime.getValue());
            placePosition2.pos = a2;
            placePosition2.posColor = AutoTrap.INSTANCE.color.getValue();
            a.timer = new Timer();
            a.isAir = true;
            a.timer.reset();
        }
    }

}
