/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2848;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class HoleFiller
extends Module {
    private final BooleanSetting webs;
    int progress;
    private float lastPitch;
    private final BooleanSetting rotate;
    public final SliderSetting delay;
    public final SliderSetting placeRange;
    private final SliderSetting targetRange;
    public static HoleFiller INSTANCE;
    private final BooleanSetting checkLook;
    private final SliderSetting predictTicks;
    public final BooleanSetting any;
    private final BooleanSetting usingPause;
    private final SliderSetting range;
    private final SliderSetting yawStep;
    private float lastYaw;
    private final SliderSetting fov;
    private class_1657 closestTarget;
    public class_243 directionVec;
    private final BooleanSetting newRotate;
    public final EnumSetting<Page> page;
    private final SliderSetting saferange;
    private final BooleanSetting inventory;
    public final SliderSetting blocksPer;
    public final BooleanSetting doubleHole;
    private final Timer timer;
    private final BooleanSetting detectMining;

    public HoleFiller() {
        HoleFiller a;
        HoleFiller holeFiller = a;
        super(OnlineUserInfo.ALLATORIxDEMO("a1@>j2I>W7"), OnlineUserInfo.ALLATORIxDEMO("k3N9RvU/\u00029{\u001eI=\f(U=r\u0002\t7B{^:A;G6"), Module.Category.Combat);
        HoleFiller holeFiller2 = a;
        holeFiller2.page = holeFiller.add(new EnumSetting<Page>(OnlineUserInfo.ALLATORIxDEMO("u3U "), Page.General));
        holeFiller.delay = holeFiller.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u001f@>S<"), 50, 0, 500, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.blocksPer = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u001c@4O0V\u0002W7"), 2, 1, 10, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("B\u0014];O/a2K;\\\""), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.usingPause = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("|-E5K\u000bD'A "), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventory = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u001bh\u0007L0X4^\"v%S5"), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.webs = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("r7P6"), false, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.range = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("~:A;G6"), 1.9, 0.0, 6.0, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.saferange = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\rM=I\tD<U "), 1.4, 0.0, 6.0, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("y2M8I\tD<U "), 5.0, 0.0, 6.0, 0.1, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("%H,K>X\tD<U "), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.any = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u001aB\"m=^ "), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.doubleHole = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("m1Y9@>m=^ "), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.predictTicks = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("V\u0003L:E8X\u000fL1Y6"), 4, 0, 10, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("~4Q3F "), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u0010I,~4Q3F "), false, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0002M,v&W5"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u001dD>O0i=]."), true, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0014]3"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            HoleFiller a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        HoleFiller holeFiller3 = a;
        HoleFiller holeFiller4 = a;
        HoleFiller holeFiller5 = a;
        holeFiller5.timer = new Timer();
        holeFiller5.directionVec = null;
        holeFiller4.lastYaw = 0.0f;
        holeFiller4.lastPitch = 0.0f;
        holeFiller3.progress = 0;
        holeFiller3.setChinese(OnlineUserInfo.ALLATORIxDEMO("\u81cf\u52fa\u5859\u5714"));
        INSTANCE = holeFiller3;
    }

    @Override
    public void onUpdate() {
        HoleFiller a322;
        Object object;
        int n;
        HoleFiller holeFiller = a322;
        if (HoleFiller.nullCheck()) {
            return;
        }
        HoleFiller holeFiller2 = holeFiller;
        if (!holeFiller2.timer.passedMs(holeFiller2.delay.getValueInt())) {
            return;
        }
        if (holeFiller.usingPause.getValue() && HoleFiller.mc.field_1724.method_6115()) {
            return;
        }
        holeFiller.progress = 0;
        holeFiller.directionVec = null;
        holeFiller.timer.reset();
        HoleFiller holeFiller3 = holeFiller;
        int a322 = holeFiller3.findBlock(class_2246.field_10540);
        int n2 = holeFiller3.findBlock(class_2246.field_10443);
        int n3 = holeFiller3.findBlock(class_2246.field_10343);
        int n4 = holeFiller.webs.getValue() ? (n3 == -1 ? (a322 == -1 ? n2 : a322) : n3) : (n = a322 == -1 ? n2 : a322);
        if (!holeFiller.webs.getValue() && a322 == -1 && n2 == -1) {
            return;
        }
        if (holeFiller.webs.getValue() && n3 == -1 && a322 == -1 && n2 == -1) {
            return;
        }
        Iterator<class_2338> a322 = new ArrayList<PlayerAndPredict>();
        Object object2 = object = CombatUtil.getEnemies(holeFiller.targetRange.getRange()).iterator();
        while (object2.hasNext()) {
            class_1657 class_16572 = object.next();
            object2 = object;
            ((ArrayList)((Object)a322)).add((class_2338)new PlayerAndPredict(holeFiller, class_16572));
        }
        object = new PlayerAndPredict(holeFiller, (class_1657)HoleFiller.mc.field_1724);
        if (!((ArrayList)((Object)a322)).isEmpty()) {
            Iterator iterator = ((ArrayList)((Object)a322)).iterator();
            block1 : while (iterator.hasNext()) {
                a322 = (PlayerAndPredict)iterator.next();
                a322 = BlockUtil.getSphere(holeFiller.range.getValueFloat(), ((PlayerAndPredict)a322).player.method_19538()).iterator();
                block2 : do {
                    Iterator<class_2338> iterator2 = a322;
                    while (iterator2.hasNext()) {
                        HoleFiller holeFiller4;
                        object = a322.next();
                        if (!BlockUtil.isHole((class_2338)object, true, true, holeFiller.any.getValue()) && (!holeFiller.doubleHole.getValue() || !CombatUtil.isDoubleHole((class_2338)object))) continue block2;
                        if (HoleFiller.mc.field_1724.method_5707(object.method_46558()) < holeFiller.saferange.getValue()) {
                            iterator2 = a322;
                            continue;
                        }
                        if (holeFiller.detectMining.getValue()) {
                            if (Hana.BREAK.isMining((class_2338)object)) continue block2;
                            if (object.equals((Object)SpeedMine.breakPos)) {
                                iterator2 = a322;
                                continue;
                            }
                        }
                        HoleFiller holeFiller5 = holeFiller;
                        if (holeFiller5.progress >= holeFiller5.blocksPer.getValueInt()) {
                            iterator2 = a322;
                            continue;
                        }
                        if (!BlockUtil.canPlace((class_2338)object, holeFiller.placeRange.getValue())) {
                            iterator2 = a322;
                            continue;
                        }
                        if (BlockUtil.getPlaceSide((class_2338)object, holeFiller.placeRange.getValue()) == null || !HoleFiller.mc.field_1687.method_22347((class_2338)object)) continue block2;
                        int n5 = HoleFiller.mc.field_1724.method_31548().field_7545;
                        HoleFiller holeFiller6 = holeFiller;
                        holeFiller.doSwap(n);
                        holeFiller6.placeBlock((class_2338)object, holeFiller6.rotate.getValue());
                        ++holeFiller.progress;
                        HoleFiller holeFiller7 = holeFiller;
                        if (holeFiller6.inventory.getValue()) {
                            holeFiller7.doSwap(n);
                            EntityUtil.syncInventory();
                            holeFiller4 = holeFiller;
                        } else {
                            holeFiller7.doSwap(n5);
                            holeFiller4 = holeFiller;
                        }
                        holeFiller4.timer.reset();
                        continue block2;
                    }
                    continue block1;
                    break;
                } while (true);
            }
        }
    }

    public int findBlock(class_2248 class_22482) {
        HoleFiller a = class_22482;
        HoleFiller a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    @Override
    public void onDisable() {
        a.closestTarget = null;
    }

    private /* synthetic */ boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.newRotate.getValue()) {
            RotateManager.lastEvent.cancelRotate();
            EntityUtil.faceVector((class_243)a);
            return true;
        }
        a2.directionVec = a;
        a = EntityUtil.getLegitRotations((class_243)a);
        if (Math.abs(class_3532.method_15393((float)(arrf[0] - a2.lastYaw))) < a2.fov.getValueFloat() && Math.abs(class_3532.method_15393((float)(a[1] - a2.lastPitch))) < a2.fov.getValueFloat()) {
            EntityUtil.sendYawAndPitch(a[0], a[true]);
            return true;
        }
        return !a2.checkLook.getValue();
    }

    @EventHandler(priority=98)
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.newRotate.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.yawStep.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            RotateEvent rotateEvent = a;
            rotateEvent.setYaw(arrf.lastYaw);
            rotateEvent.setPitch(arrf.lastPitch);
            return;
        }
        float[] arrf3 = arrf;
        arrf3.lastYaw = Hana.ROTATE.lastYaw;
        arrf3.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        HoleFiller a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, HoleFiller.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public static boolean needSneak(class_2248 a) {
        return BlockUtil.shiftBlocks.contains((Object)a);
    }

    @Override
    public String getInfo() {
        return "";
    }

    public boolean placeBlock(class_2338 a, boolean a2) {
        class_2350 a3;
        class_2350 class_23502 = a3;
        if (BlockUtil.airPlace()) {
            int n;
            a3 = class_2350.values();
            int n2 = ((class_2350[])a3).length;
            int n3 = n = 0;
            while (n3 < n2) {
                class_2350 class_23503 = a3[n];
                if (HoleFiller.mc.field_1687.method_22347(a.method_10093(class_23503))) {
                    return class_23502.clickBlock(a, class_23503, a2);
                }
                n3 = ++n;
            }
        }
        if ((a3 = BlockUtil.getPlaceSide(a)) == null) {
            return false;
        }
        class_243 class_2432 = new class_243((double)a.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, a3, a, false);
        BlockUtil.placedPos.add(a);
        boolean bl = false;
        if (HoleFiller.mc.field_1724 != null) {
            bl = HoleFiller.mc.field_1724.method_5624();
        }
        boolean bl2 = false;
        if (HoleFiller.mc.field_1687 != null) {
            boolean bl3 = bl2 = HoleFiller.needSneak(HoleFiller.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !HoleFiller.mc.field_1724.method_5715();
        }
        if (bl) {
            HoleFiller.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)HoleFiller.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl2) {
            HoleFiller.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)HoleFiller.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a.method_10093(a3), a3.method_10153(), a2);
        if (bl2) {
            HoleFiller.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)HoleFiller.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl) {
            HoleFiller.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)HoleFiller.mc.field_1724, class_2848.class_2849.field_12981));
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        HoleFiller a3 = this;
        if (a2 < 0.01f) {
            a2 = 0.01f;
        }
        if (a2 > 1.0f) {
            a2 = 1.0f;
        }
        if (a2 < 1.0f && a != null) {
            void v2;
            float f2;
            float f3 = a3.lastYaw;
            float f4 = class_3532.method_15393((float)(a[0] - f3));
            if (Math.abs(f2) > 90.0f * a2) {
                float f5 = f4;
                a[0] = f3 + f5 * (90.0f * a2 / Math.abs(f5));
            }
            f3 = a3.lastPitch;
            f4 = a[1] - f3;
            if (Math.abs((float)v2) > 90.0f * a2) {
                float f6 = f4;
                a[1] = f3 + f6 * (90.0f * a2 / Math.abs(f6));
            }
        }
        float[] arrf2 = new float[2];
        arrf2[0] = a[0];
        arrf2[1] = a[1];
        return arrf2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl) {
        void a;
        void a2;
        HoleFiller a3 = class_23382;
        HoleFiller a4 = this;
        class_243 class_2432 = new class_243((double)a3.method_10263() + 0.5 + (double)a.method_10163().method_10263() * 0.5, (double)a3.method_10264() + 0.5 + (double)a.method_10163().method_10264() * 0.5, (double)a3.method_10260() + 0.5 + (double)a.method_10163().method_10260() * 0.5);
        if (a2 != false && !a4.faceVector(class_2432)) {
            return false;
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        a3 = new class_3965(class_2432, (class_2350)a, (class_2338)a3, false);
        HoleFiller.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a3, BlockUtil.getWorldActionId(HoleFiller.mc.field_1687)));
        return true;
    }

    public static final class Page
    extends Enum<Page> {
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General = new Page(RadiusUtils.ALLATORIxDEMO(" Q\u000eL\u000f\u0002["), 0);
        public static final /* enum */ Page Rotate = new Page(SocketClient.ALLATORIxDEMO("}e]m_k"), 1);

        /*
         * Exception decompiling
         */
        private /* synthetic */ Page() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
            // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        static {
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            return arrpage;
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

    public class PlayerAndPredict {
        final /* synthetic */ HoleFiller this$0;
        class_1657 player;
        class_1657 predict;

        public PlayerAndPredict(HoleFiller holeFiller, class_1657 class_16572) {
            Iterator a;
            PlayerAndPredict a2 = class_16572;
            PlayerAndPredict a3 = this;
            a3.this$0 = a;
            a3.player = a2;
            if (((HoleFiller)a).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a3;
                playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(BOEntityUtils.ALLATORIxDEMO("7\u001bfI\u00109)\u0005?\u000f8\u0015\"\u00174\u0019\u0001,0\u0007!\r\u0015\"7\u001b!\u000f!\b\"\u0000&\n7\u001b")), TipUtils.ALLATORIxDEMO("\u001b\u00169\u0017}X5+(\u001d(\u001a%@%\u0000")), (HoleFiller)((Object)a)){
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ HoleFiller val$this$0;

                    public boolean method_7325() {
                        return false;
                    }
                    {
                        Object a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        void a6;
                        1 v0 = object2;
                        Object object2 = object;
                        object = v0;
                        object.this$1 = a3;
                        object.val$this$0 = a;
                        super((class_1937)a2, (class_2338)a5, (float)a6, (GameProfile)a4);
                    }

                    public boolean method_7337() {
                        return false;
                    }
                };
                a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, HoleFiller.INSTANCE.predictTicks.getValueInt(), true)));
                playerAndPredict.predict.method_6033(a2.method_6032());
                playerAndPredict.predict.field_6014 = ((class_1657)a2).field_6014;
                playerAndPredict.predict.field_5969 = ((class_1657)a2).field_5969;
                playerAndPredict.predict.field_6036 = ((class_1657)a2).field_6036;
                playerAndPredict.predict.method_24830(a2.method_24828());
                PlayerAndPredict playerAndPredict2 = a2;
                playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
                playerAndPredict.predict.method_18380(a2.method_18376());
                Iterator iterator = a = playerAndPredict2.method_6026().iterator();
                while (iterator.hasNext()) {
                    class_1293 class_12932 = (class_1293)a.next();
                    iterator = a;
                    a3.predict.method_6092(class_12932);
                }
            } else {
                a3.predict = a2;
            }
        }

    }

}
