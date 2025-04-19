/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class PlayerRadar
extends Module {
    public final SliderSetting lineSpacing;
    public final SliderSetting xPosition;
    public final SliderSetting yPosition;
    private static final int MAX_DISPLAY_DISTANCE = 100;

    private /* synthetic */ Color getColorBasedOnDistance(double a) {
        return Color.getHSBColor((float)(1.0 - a / 100.0), 1.0f, 1.0f);
    }

    private /* synthetic */ List<PlayerInfo> getNearbyPlayers() {
        PlayerRadar a;
        PlayerRadar playerRadar = a;
        a = PlayerRadar.mc.field_1724.method_19538();
        class_238 class_2382 = new class_238(((class_243)a).field_1352 - 100.0, ((class_243)a).field_1351 - 100.0, ((class_243)a).field_1350 - 100.0, ((class_243)a).field_1352 + 100.0, ((class_243)a).field_1351 + 100.0, ((class_243)a).field_1350 + 100.0);
        ArrayList<PlayerInfo> arrayList = new ArrayList<PlayerInfo>();
        for (class_1657 class_16572 : PlayerRadar.mc.field_1687.method_18456()) {
            if (class_16572 == PlayerRadar.mc.field_1724 || !class_2382.method_994(class_16572.method_5829())) continue;
            double d = a.method_1022(class_16572.method_19538());
            arrayList.add(new PlayerInfo(class_16572, d));
        }
        arrayList.sort(Comparator.comparingDouble(PlayerInfo::getDistance));
        return arrayList;
    }

    public PlayerRadar() {
        PlayerRadar a;
        PlayerRadar playerRadar = a;
        PlayerRadar playerRadar2 = a;
        super(CrystalUtil.ALLATORIxDEMO("\u0016z\u0007\\0R\u0002D1W4"), Module.Category.Render);
        PlayerRadar playerRadar3 = a;
        playerRadar3.xPosition = playerRadar2.add(new SliderSetting(Snow.ALLATORIxDEMO("B"), 10.0, 0.0, 500.0, 1.0));
        playerRadar2.yPosition = playerRadar2.add(new SliderSetting(CrystalUtil.ALLATORIxDEMO("\u001f"), 10.0, 0.0, 500.0, 1.0));
        playerRadar.lineSpacing = playerRadar.add(new SliderSetting(Snow.ALLATORIxDEMO("N`"), 10.0, 5.0, 20.0, 1.0));
        playerRadar.setChinese(CrystalUtil.ALLATORIxDEMO("\u9664\u8f81\u738c\u5be3\u6608\u797c"));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender2D(class_332 class_3322, float f) {
        void a;
        float a22 = f;
        PlayerRadar a3 = this;
        if (PlayerRadar.mc.field_1687 == null || PlayerRadar.mc.field_1724 == null) {
            return;
        }
        PlayerRadar playerRadar = a3;
        List<PlayerInfo> a22 = playerRadar.getNearbyPlayers();
        playerRadar.renderPlayerList((class_332)a, a22);
    }

    private /* synthetic */ void renderPlayerList(class_332 a, List<PlayerInfo> a23) {
        Iterator<PlayerInfo> iterator;
        PlayerRadar playerRadar;
        PlayerRadar a222;
        PlayerRadar playerRadar2 = playerRadar = a222;
        int a23 = (int)playerRadar2.xPosition.getValue();
        int a222 = (int)playerRadar2.yPosition.getValue();
        int n = (int)playerRadar2.lineSpacing.getValue();
        Iterator<PlayerInfo> iterator2 = iterator = a23.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator.next();
            Object object2 = ((PlayerInfo)object).getPlayer().method_5477().getString();
            Object[] arrobject = new Object[1];
            arrobject[0] = ((PlayerInfo)object).getDistance();
            String string = String.format(Snow.ALLATORIxDEMO("'' |"), arrobject);
            object2 = (String)object2 + " (" + string + "m)";
            object = playerRadar.getColorBasedOnDistance(((PlayerInfo)object).getDistance());
            iterator2 = iterator;
            TextUtil.drawString(a, (String)object2, (double)a23, (double)a222, (Color)object);
            a222 += n;
        }
    }

    private static class PlayerInfo {
        private final class_1657 player;
        private final double distance;

        /*
         * WARNING - void declaration
         */
        public PlayerInfo(class_1657 class_16572, double d) {
            PlayerInfo a;
            void a2;
            PlayerInfo a3 = class_16572;
            PlayerInfo playerInfo = a = this;
            playerInfo.player = a3;
            playerInfo.distance = a2;
        }

        public double getDistance() {
            PlayerInfo a;
            return a.distance;
        }

        public class_1657 getPlayer() {
            PlayerInfo a;
            return a.player;
        }
    }

}
