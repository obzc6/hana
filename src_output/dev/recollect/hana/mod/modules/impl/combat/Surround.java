/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class Surround
extends Module {
    public static Surround INSTANCE = new Surround();
    private final BooleanSetting breakCrystal;
    private final BooleanSetting enderChest;
    int progress;
    public final BooleanSetting pre;
    public final BooleanSetting extend;
    public final BooleanSetting moveReset;
    private final BooleanSetting center;
    final ColorSetting box;
    public final SliderSetting fadeTime;
    double startX;
    private final Timer timer;
    private final BooleanSetting detectMining;
    private final SliderSetting blocksPer;
    double startZ;
    private final BooleanSetting packetPlace;
    public final BooleanSetting inAir;
    private boolean shouldCenter;
    private final BooleanSetting inventory;
    double startY;
    private final BooleanSetting usingPause;
    private final BooleanSetting moveDisable;
    public final SliderSetting placeDelay;
    private final BooleanSetting jumpDisable;
    final ColorSetting fill;
    public final BooleanSetting render;
    private final BooleanSetting rotate;

    private /* synthetic */ void tryPlaceBlock(class_2338 class_23382) {
        Surround surround;
        Surround surround2;
        Surround a = class_23382;
        Surround a2 = this;
        if (a == null) {
            return;
        }
        if (a2.detectMining.getValue() && BlockUtil.isMining((class_2338)a)) {
            return;
        }
        if (a2.pre.getValue() && BlockUtil.clientCanPlace((class_2338)a, true)) {
            FeetTrapRenderer.addBlock((class_2338)a);
        }
        if (!((double)a2.progress < a2.blocksPer.getValue())) {
            return;
        }
        int n = a2.getBlock();
        if (n == -1) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a, 6.0, true)) {
            return;
        }
        Surround surround3 = a;
        if (a2.breakCrystal.getValue()) {
            CombatUtil.attackCrystal((class_2338)surround3, a2.rotate.getValue(), a2.usingPause.getValue());
            surround2 = a2;
        } else {
            if (BlockUtil.hasEntity((class_2338)surround3, false)) {
                return;
            }
            surround2 = a2;
        }
        if (surround2.rotate.getValue()) {
            RotateManager.lastEvent.cancelRotate();
        }
        int n2 = Surround.mc.field_1724.method_31548().field_7545;
        Surround surround4 = a2;
        surround4.doSwap(n);
        BlockUtil.placeBlock((class_2338)a, surround4.rotate.getValue(), a2.packetPlace.getValue());
        Surround surround5 = a2;
        if (surround4.inventory.getValue()) {
            surround5.doSwap(n);
            EntityUtil.syncInventory();
            surround = a2;
        } else {
            surround5.doSwap(n2);
            surround = a2;
        }
        ++surround.progress;
        a2.timer.reset();
        FeetTrapRenderer.addBlock((class_2338)a);
    }

    @EventHandler(priority=-1)
    public void onMove(MoveEvent a) {
        Surround a2;
        Surround surround = a2;
        if (Surround.nullCheck() || !surround.center.getValue() || EntityUtil.isElytraFlying()) {
            return;
        }
        a2 = EntityUtil.getPlayerPos(true);
        if (Surround.mc.field_1724.method_23317() - (double)a2.method_10263() - 0.5 <= 0.2 && Surround.mc.field_1724.method_23317() - (double)a2.method_10263() - 0.5 >= -0.2 && Surround.mc.field_1724.method_23321() - (double)a2.method_10260() - 0.5 <= 0.2 && Surround.mc.field_1724.method_23321() - 0.5 - (double)a2.method_10260() >= -0.2) {
            if (surround.shouldCenter && (Surround.mc.field_1724.method_24828() || MovementUtil.isMoving())) {
                a.setX(0.0);
                a.setZ(0.0);
                surround.shouldCenter = false;
                return;
            }
        } else if (surround.shouldCenter) {
            a2 = EntityUtil.getPlayerPos(true).method_46558();
            float f = Surround.getRotationTo((class_243)Surround.mc.field_1724.method_19538(), (class_243)a2).field_1343 / 180.0f * 3.1415927f;
            double d = Surround.mc.field_1724.method_19538().method_1022(new class_243(((class_243)a2).field_1352, Surround.mc.field_1724.method_23318(), ((class_243)a2).field_1350));
            d = Math.min(0.2873, d);
            double d2 = (double)(-((float)Math.sin(f))) * d;
            MoveEvent moveEvent = a;
            moveEvent.setX(d2);
            moveEvent.setZ((double)((float)Math.cos(f)) * d);
        }
    }

    public Surround() {
        Surround a;
        Surround surround = a;
        super(Start.ALLATORIxDEMO("xp^p^j\u00151"), TimeHelper.ALLATORIxDEMO("\u000bI\fI\u0016N\u0017B\u0017\u001c\u0007H\u0010\r\u0018\u001cCHBh\u0007S\u000bY\u0016\u0016["), Module.Category.Combat);
        surround.timer = new Timer();
        surround.placeDelay = a.add(new SliderSetting(Start.ALLATORIxDEMO("|nJfIFTs\u001a,"), 50, 0, 500));
        surround.blocksPer = surround.add(new SliderSetting(TimeHelper.ALLATORIxDEMO(" K\nC\tN/\u0012G"), 1, 1, 8));
        surround.detectMining = surround.add(new BooleanSetting(Start.ALLATORIxDEMO("=2XgHqak_v\u00152"), false));
        surround.rotate = surround.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("r\rI\u001e\u0003P"), true));
        surround.packetPlace = surround.add(new BooleanSetting(Start.ALLATORIxDEMO("\u0007Ma@`XR]~\u00180"), true));
        surround.breakCrystal = surround.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO(" O\u001a\u0016^"), true).setParent());
        surround.usingPause = surround.add(new BooleanSetting(Start.ALLATORIxDEMO("\u0012MvBkKRPj\b0"), true, object -> {
            Object a = object;
            Surround a2 = this;
            return a2.breakCrystal.isOpen();
        }));
        Surround surround2 = a;
        surround2.center = surround2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("c\u0007S\u000b\u0012G"), true));
        surround2.extend = surround2.add(new BooleanSetting(Start.ALLATORIxDEMO("izEz\u00151"), true));
        surround2.inventory = surround2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("&\u001bAE\fS\nR\u001bn\b\u0016E"), true));
        surround2.inAir = surround2.add(new BooleanSetting(Start.ALLATORIxDEMO("K_^\u0012'"), true));
        surround2.moveDisable = surround2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("vU\u0016H!I\u0011\\\u001d\u001bP"), true));
        surround2.jumpDisable = surround2.add(new BooleanSetting(Start.ALLATORIxDEMO("\u001dYo[AEqP}\u00170"), true));
        surround2.enderChest = surround2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("e\fC\u0000R!U\u001a\u0004A"), true));
        surround2.render = surround2.add(new BooleanSetting(Start.ALLATORIxDEMO("~g_{\u001e'"), true).setParent());
        surround2.box = surround2.add(new ColorSetting(TimeHelper.ALLATORIxDEMO("=\u0018M"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            Surround a2 = this;
            return a2.render.isOpen();
        }).injectBoolean(true));
        a.fill = a.add(new ColorSetting(Start.ALLATORIxDEMO("wv\u00179"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            Surround a2 = this;
            return a2.render.isOpen();
        }).injectBoolean(true));
        a.fadeTime = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("a\u0004D\u0007i\u0016\u001aP"), 500, 0, 5000, object -> {
            Object a = object;
            Surround a2 = this;
            return a2.render.getValue();
        }));
        a.pre = a.add(new BooleanSetting(Start.ALLATORIxDEMO("O\t0"), false, object -> {
            Object a = object;
            Surround a2 = this;
            return a2.render.getValue();
        }));
        a.moveReset = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("0X\f\u0012A"), true, object -> {
            Object a = object;
            Surround a2 = this;
            return a2.render.getValue();
        }));
        Surround surround3 = a;
        Surround surround4 = a;
        Surround surround5 = a;
        surround5.startX = 0.0;
        surround5.startY = 0.0;
        surround4.startZ = 0.0;
        surround4.progress = 0;
        surround3.shouldCenter = true;
        surround3.setChinese(Start.ALLATORIxDEMO("\u81db\u52b7\u568f\u814f"));
        INSTANCE = surround3;
        Hana.EVENT_BUS.subscribe(new FeetTrapRenderer(a));
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        Surround a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, Surround.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    @Override
    public void onEnable() {
        Surround a;
        if (Surround.nullCheck()) {
            if (a.moveDisable.getValue() || a.jumpDisable.getValue()) {
                a.disable();
            }
            return;
        }
        Surround surround = a;
        surround.startX = Surround.mc.field_1724.method_23317();
        surround.startY = Surround.mc.field_1724.method_23318();
        surround.startZ = Surround.mc.field_1724.method_23321();
        a.shouldCenter = true;
    }

    public static boolean selfIntersectPos(class_2338 a) {
        return Surround.mc.field_1724.method_5829().method_994(new class_238(a));
    }

    public class_2338 getHelperPos(class_2338 a) {
        Surround a2;
        int n;
        Surround surround = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if ((!surround.detectMining.getValue() || !BlockUtil.isMining(a.method_10093((class_2350)a2))) && BlockUtil.isStrictDirection(a.method_10093((class_2350)a2), a2.method_10153(), true) && BlockUtil.canPlace(a.method_10093((class_2350)a2))) {
                return a.method_10093((class_2350)a2);
            }
            n3 = ++n;
        }
        return null;
    }

    private static /* synthetic */ class_241 getRotationFromVec(class_243 a) {
        class_243 class_2432 = a;
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1350;
        d = Math.hypot(d, d2);
        d2 = class_2432.field_1350;
        double d3 = class_2432.field_1352;
        d2 = Surround.normalizeAngle(Math.toDegrees(Math.atan2(d2, d3)) - 90.0);
        d = Surround.normalizeAngle(Math.toDegrees(-Math.atan2(class_2432.field_1351, d)));
        return new class_241((float)d2, (float)d);
    }

    private static /* synthetic */ double normalizeAngle(double a) {
        double d;
        double d2 = a;
        d2 %= 360.0;
        if (d >= 180.0) {
            d2 -= 360.0;
        }
        if (d2 < -180.0) {
            d2 += 360.0;
        }
        return d2;
    }

    private /* synthetic */ int getBlock() {
        Surround a;
        if (a.inventory.getValue()) {
            if (InventoryUtil.findBlockInventorySlot(class_2246.field_10540) != -1 || !a.enderChest.getValue()) {
                return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
            }
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10443);
        }
        if (InventoryUtil.findBlock(class_2246.field_10540) != -1 || !a.enderChest.getValue()) {
            return InventoryUtil.findBlock(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10443);
    }

    public static class_241 getRotationTo(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return Surround.getRotationFromVec(a.method_1020(a2));
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        int n;
        class_2338 a;
        Surround surround;
        block19 : {
            block18 : {
                surround = this;
                if (a.isPost()) break block18;
                Surround surround2 = surround;
                if (surround2.timer.passedMs((long)surround2.placeDelay.getValue())) break block19;
            }
            return;
        }
        surround.progress = 0;
        if (!MovementUtil.isMoving() && !Surround.mc.field_1690.field_1903.method_1434()) {
            Surround surround3 = surround;
            surround3.startX = Surround.mc.field_1724.method_23317();
            surround3.startY = Surround.mc.field_1724.method_23318();
            surround3.startZ = Surround.mc.field_1724.method_23321();
        }
        a = EntityUtil.getPlayerPos(true);
        double d = class_3532.method_15355((float)((float)Surround.mc.field_1724.method_5649(surround.startX, surround.startY, surround.startZ)));
        if (surround.getBlock() == -1) {
            CommandManager.sendChatMessage("\u00a7e[?] \u00a7c\u00a7oObsidian" + (surround.enderChest.getValue() ? TimeHelper.ALLATORIxDEMO("E`\tF\u0005R!O\u0000]\u0018") : "") + "?");
            surround.disable();
            return;
        }
        if (surround.moveDisable.getValue() && d > 1.0 || surround.jumpDisable.getValue() && Math.abs(surround.startY - Surround.mc.field_1724.method_23318()) > 0.5) {
            surround.disable();
            return;
        }
        if (!surround.inAir.getValue() && !Surround.mc.field_1724.method_24828()) {
            return;
        }
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            class_2350 class_23502 = arrclass_2350[n];
            if (class_23502 != class_2350.field_11036) {
                class_2350 class_23503;
                if (BlockUtil.getPlaceSide((class_2338)(class_23502 = a.method_10093(class_23502))) != null) {
                    class_2350 class_23504 = class_23502;
                    class_23503 = class_23504;
                    surround.tryPlaceBlock((class_2338)class_23504);
                } else {
                    if (BlockUtil.canReplace((class_2338)class_23502)) {
                        Surround surround4 = surround;
                        surround4.tryPlaceBlock(surround4.getHelperPos((class_2338)class_23502));
                    }
                    class_23503 = class_23502;
                }
                if (Surround.selfIntersectPos((class_2338)class_23503) && surround.extend.getValue()) {
                    int n4;
                    class_2350[] arrclass_23502 = class_2350.values();
                    int n5 = arrclass_23502.length;
                    int n6 = n4 = 0;
                    while (n6 < n5) {
                        Surround a2 = arrclass_23502[n4];
                        if (a2 != class_2350.field_11036) {
                            if (Surround.selfIntersectPos((class_2338)(a2 = class_23502.method_10093((class_2350)a2)))) {
                                int n7;
                                class_2350[] arrclass_23503 = class_2350.values();
                                int n8 = arrclass_23503.length;
                                int n9 = n7 = 0;
                                while (n9 < n8) {
                                    class_2350 class_23505 = arrclass_23503[n7];
                                    if (class_23505 != class_2350.field_11036) {
                                        Surround surround5 = a2;
                                        surround.tryPlaceBlock((class_2338)surround5);
                                        class_23505 = surround5.method_10093(class_23505);
                                        surround.tryPlaceBlock((class_2338)(BlockUtil.getPlaceSide((class_2338)class_23505) != null || !BlockUtil.canReplace((class_2338)class_23505) ? class_23505 : surround.getHelperPos((class_2338)class_23505)));
                                    }
                                    n9 = ++n7;
                                }
                            }
                            surround.tryPlaceBlock((class_2338)(BlockUtil.getPlaceSide((class_2338)a2) != null || !BlockUtil.canReplace((class_2338)a2) ? a2 : surround.getHelperPos((class_2338)a2)));
                        }
                        n6 = ++n4;
                    }
                }
            }
            n3 = ++n;
        }
    }

    public class FeetTrapRenderer {
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
            FeetTrapRenderer feetTrapRenderer = a2;
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

        public FeetTrapRenderer(Surround surround) {
            Surround a = surround;
            FeetTrapRenderer a2 = this;
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

}
