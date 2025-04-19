/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1303
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1661
 *  net.minecraft.class_1667
 *  net.minecraft.class_1683
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1667;
import net.minecraft.class_1683;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class SelfTrap
extends Module {
    private final BooleanSetting checkMine;
    private final SliderSetting yawStep;
    private final BooleanSetting checkLook;
    private final Timer timer;
    private final BooleanSetting inventory;
    private final BooleanSetting newRotate;
    private final SliderSetting delay;
    public static SelfTrap INSTANCE;
    private final BooleanSetting packet;
    private float lastPitch;
    private final BooleanSetting rotate;
    private final SliderSetting fov;
    private final BooleanSetting eatingPause;
    public final EnumSetting<Page> page;
    private float lastYaw;
    public class_243 directionVec;

    private /* synthetic */ int getBlock() {
        SelfTrap a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    public SelfTrap() {
        SelfTrap a;
        SelfTrap selfTrap = a;
        super(User.ALLATORIxDEMO("HbQGz@^S"), Module.Category.Combat);
        SelfTrap selfTrap2 = a;
        selfTrap2.page = selfTrap.add(new EnumSetting<Page>(TipUtils.ALLATORIxDEMO("\f\u0012q\\"), Page.General));
        selfTrap.checkMine = selfTrap.add(new BooleanSetting(User.ALLATORIxDEMO("gZ]PxspH@[QD"), true, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("~ \u001a/\u0007&>=\u0006e\\"), true, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventory = a.add(new BooleanSetting(User.ALLATORIxDEMO("MIL[ohOX}E^S"), true, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.delay = a.add(new SliderSetting(TipUtils.ALLATORIxDEMO("*9\u001fw@"), 100, 0, 1000, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(User.ALLATORIxDEMO("oNZSKF"), true, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(TipUtils.ALLATORIxDEMO(" #\u001e\u0013\u0001(\u0012b\\"), false, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(User.ALLATORIxDEMO("^\\V}FZS"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("\u0011\u000f?\u0018sM"), false, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(User.ALLATORIxDEMO("vsb^Jb]PH"), true, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(TipUtils.ALLATORIxDEMO("5yO"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            SelfTrap a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        SelfTrap selfTrap3 = a;
        SelfTrap selfTrap4 = a;
        a.timer = new Timer();
        selfTrap4.directionVec = null;
        selfTrap4.lastYaw = 0.0f;
        selfTrap3.lastPitch = 0.0f;
        selfTrap3.setChinese(User.ALLATORIxDEMO("\u5bb4\u5149\u56da\u4f7d\u81d5\u5dd2"));
        INSTANCE = selfTrap3;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        SelfTrap a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, SelfTrap.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    @Override
    public void onUpdate() {
        SelfTrap selfTrap;
        SelfTrap selfTrap2 = this;
        if (!SelfTrap.mc.field_1724.method_24828()) {
            return;
        }
        if (selfTrap2.eatingPause.getValue() && EntityUtil.isUsing()) {
            return;
        }
        SelfTrap selfTrap3 = selfTrap2;
        if (!selfTrap3.timer.passedMs(selfTrap3.delay.getValueInt())) {
            return;
        }
        selfTrap2.directionVec = null;
        int n = SelfTrap.mc.field_1724.method_31548().field_7545;
        int n2 = selfTrap2.getBlock();
        if (n2 == -1) {
            return;
        }
        if (!EntityUtil.isInsideBlock()) {
            return;
        }
        class_2338 class_23382 = new BlockPosX(SelfTrap.mc.field_1724.method_23317() + 0.6, SelfTrap.mc.field_1724.method_23318() + 0.5, SelfTrap.mc.field_1724.method_23321() + 0.6).method_10074();
        class_2338 class_23383 = new BlockPosX(SelfTrap.mc.field_1724.method_23317() - 0.6, SelfTrap.mc.field_1724.method_23318() + 0.5, SelfTrap.mc.field_1724.method_23321() + 0.6).method_10074();
        SelfTrap a = new BlockPosX(SelfTrap.mc.field_1724.method_23317() + 0.6, SelfTrap.mc.field_1724.method_23318() + 0.5, SelfTrap.mc.field_1724.method_23321() - 0.6).method_10074();
        class_2338 class_23384 = new BlockPosX(SelfTrap.mc.field_1724.method_23317() - 0.6, SelfTrap.mc.field_1724.method_23318() + 0.5, SelfTrap.mc.field_1724.method_23321() - 0.6).method_10074();
        if (!(selfTrap2.canPlace(class_23382) || selfTrap2.canPlace(class_23383) || selfTrap2.canPlace((class_2338)a) || selfTrap2.canPlace(class_23384))) {
            return;
        }
        SelfTrap selfTrap4 = selfTrap2;
        selfTrap4.doSwap(n2);
        if (selfTrap2.tryPlaceObsidian(class_23382, selfTrap4.rotate.getValue())) {
            selfTrap = selfTrap2;
        } else if (selfTrap2.tryPlaceObsidian(class_23383, selfTrap2.rotate.getValue())) {
            selfTrap = selfTrap2;
        } else if (selfTrap2.tryPlaceObsidian((class_2338)a, selfTrap2.rotate.getValue())) {
            selfTrap = selfTrap2;
        } else {
            selfTrap = selfTrap2;
            SelfTrap selfTrap5 = selfTrap2;
            selfTrap5.tryPlaceObsidian(class_23384, selfTrap5.rotate.getValue());
        }
        SelfTrap selfTrap6 = selfTrap2;
        if (selfTrap.inventory.getValue()) {
            selfTrap6.doSwap(n2);
            EntityUtil.syncInventory();
            return;
        }
        selfTrap6.doSwap(n);
    }

    /*
     * WARNING - void declaration
     */
    public static void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, class_1268 class_12682, boolean bl2) {
        void a;
        void a2;
        void a3;
        class_2338 a4 = class_23502;
        class_2338 a5 = class_23382;
        class_243 class_2432 = new class_243((double)a5.method_10263() + 0.5 + (double)a4.method_10163().method_10263() * 0.5, (double)a5.method_10264() + 0.5 + (double)a4.method_10163().method_10264() * 0.5, (double)a5.method_10260() + 0.5 + (double)a4.method_10163().method_10260() * 0.5);
        if (a2 != false) {
            EntityUtil.faceVector(class_2432);
        }
        EntityUtil.swingHand((class_1268)a3, CombatSetting.INSTANCE.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a4, a5, false);
        if (a != false) {
            SelfTrap.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(SelfTrap.mc.field_1687)));
            return;
        }
        SelfTrap.mc.field_1761.method_2896(SelfTrap.mc.field_1724, (class_1268)a3, (class_3965)a4);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        SelfTrap a3 = this;
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
    private /* synthetic */ boolean tryPlaceObsidian(class_2338 class_23382, boolean bl) {
        SelfTrap a = this;
        SelfTrap a2 = class_23382;
        if (a.canPlace((class_2338)a2)) {
            void a3;
            if (a.checkMine.getValue() && BlockUtil.isMining((class_2338)a2)) {
                return false;
            }
            class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)a2);
            if (class_23502 == null) {
                return false;
            }
            BlockUtil.placedPos.add((class_2338)a2);
            SelfTrap.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), (boolean)a3, class_1268.field_5808, true);
            a.timer.reset();
            return true;
        }
        return false;
    }

    private /* synthetic */ boolean canPlace(class_2338 class_23382) {
        SelfTrap a = class_23382;
        SelfTrap a2 = this;
        if (BlockUtil.getPlaceSide((class_2338)a) == null) {
            return false;
        }
        if (!BlockUtil.canReplace((class_2338)a)) {
            return false;
        }
        return !a2.hasEntity((class_2338)a);
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
            if (a2.packet.getValue()) {
                EntityUtil.sendYawAndPitch(a[0], a[1]);
            }
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean hasEntity(class_2338 a) {
        SelfTrap a2;
        SelfTrap selfTrap = a2;
        a = SelfTrap.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                a2 = (class_1297)a.next();
                if (a2 == SelfTrap.mc.field_1724) {
                    object = a;
                    continue;
                }
                if (!a2.method_5805() || a2 instanceof class_1542 || a2 instanceof class_1303 || a2 instanceof class_1683 || a2 instanceof class_1667 || a2 instanceof class_1511) continue block0;
                if (!(a2 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                object = a;
            }
            break;
        } while (true);
        return false;
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page General = new Page(Vec3.ALLATORIxDEMO("\u0000y\u0018\u0002y\u001e"), 0);
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Rotate = new Page(Timer.ALLATORIxDEMO("k[PH\u001a\u0006"), 1);

        static {
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            return arrpage;
        }

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

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }
    }

}
