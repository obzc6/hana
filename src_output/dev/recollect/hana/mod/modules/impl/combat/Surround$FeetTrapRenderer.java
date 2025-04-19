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
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.impl.combat.Surround;
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

public class Surround.FeetTrapRenderer {
    final /* synthetic */ Surround this$0;
    public static final HashMap<class_2338, placePosition> renderMap = new HashMap();
    private class_2338 lastPos;

    public static void addBlock(class_2338 a) {
        class_2338 class_23382 = a;
        class_2338 class_23383 = a;
        renderMap.put(class_23383, new placePosition(class_23383));
    }

    @EventHandler
    public void onRender3D(Render3DEvent a) {
        placePosition a2;
        Surround.FeetTrapRenderer feetTrapRenderer = a2;
        if (!Surround.INSTANCE.render.getValue()) {
            return;
        }
        if (Surround.INSTANCE.moveReset.getValue() && !EntityUtil.getPlayerPos(true).equals((Object)feetTrapRenderer.lastPos)) {
            feetTrapRenderer.lastPos = EntityUtil.getPlayerPos(true);
            renderMap.clear();
        }
        if (renderMap.isEmpty()) {
            return;
        }
        boolean bl = true;
        Iterator<placePosition> iterator = renderMap.values().iterator();
        block0 : do {
            Iterator<placePosition> iterator2 = iterator;
            while (iterator2.hasNext()) {
                a2 = iterator.next();
                if (!BlockUtil.clientCanPlace(a2.pos, true)) {
                    a2.isAir = false;
                }
                if (!a2.timer.passedMs((long)(feetTrapRenderer.this$0.placeDelay.getValue() + 100.0)) && a2.isAir) {
                    a2.firstFade.reset();
                }
                if (a2.firstFade.getQuad(FadeUtils.Quad.In2) == 1.0) {
                    iterator2 = iterator;
                    continue;
                }
                bl = false;
                class_4587 class_45872 = a.getMatrixStack();
                if (Surround.INSTANCE.fill.booleanValue) {
                    Render3DUtil.drawFill(class_45872, new class_238(a2.pos), ColorUtil.injectAlpha(Surround.INSTANCE.fill.getValue(), (int)((double)feetTrapRenderer.this$0.fill.getValue().getAlpha() * (1.0 - a2.firstFade.getQuad(FadeUtils.Quad.In2)))));
                }
                if (!Surround.INSTANCE.box.booleanValue) continue block0;
                Render3DUtil.drawBox(class_45872, new class_238(a2.pos), ColorUtil.injectAlpha(Surround.INSTANCE.box.getValue(), (int)((double)feetTrapRenderer.this$0.box.getValue().getAlpha() * (1.0 - a2.firstFade.getQuad(FadeUtils.Quad.In2)))));
                continue block0;
            }
            break;
        } while (true);
        if (bl) {
            renderMap.clear();
        }
    }

    public Surround.FeetTrapRenderer(Surround surround) {
        Surround a = surround;
        Surround.FeetTrapRenderer a2 = this;
        a2.this$0 = a;
        a2.lastPos = null;
    }

    public static class placePosition {
        public boolean isAir;
        public final Timer timer;
        public final FadeUtils firstFade;
        public final class_2338 pos;

        public placePosition(class_2338 class_23382) {
            placePosition a;
            placePosition a2 = class_23382;
            placePosition placePosition2 = a = this;
            placePosition placePosition3 = a;
            placePosition3.firstFade = new FadeUtils((long)Surround.INSTANCE.fadeTime.getValue());
            placePosition2.pos = a2;
            placePosition2.timer = new Timer();
            placePosition2.isAir = true;
        }
    }

}
