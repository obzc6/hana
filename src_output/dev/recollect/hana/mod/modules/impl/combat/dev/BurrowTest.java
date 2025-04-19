/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1303
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1667
 *  net.minecraft.class_1683
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_310
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.packet.Packet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1667;
import net.minecraft.class_1683;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class BurrowTest
extends Module {
    private final BooleanSetting inventory;
    private final BooleanSetting enderChest;
    private final BooleanSetting sound;
    private final BooleanSetting detectMine;
    private final SliderSetting webTime;
    private final EnumSetting<RotateMode> rotate;
    private final List<class_2338> placePos;
    public static BurrowTest INSTANCE;
    private final BooleanSetting Anchor;
    private final BooleanSetting center;
    private final SliderSetting smartDistance;
    private final BooleanSetting usingPause;
    private final BooleanSetting fakeMove;
    private final BooleanSetting packetPlace;
    private final Timer timer;
    private final SliderSetting blocksPer;
    private final BooleanSetting noSelfPos;
    private final BooleanSetting headFill;
    private final BooleanSetting disable;
    private final BooleanSetting down;
    private final SliderSetting delay;
    private int progress;
    private final BooleanSetting wait;
    private final Timer webTimer;
    private final SliderSetting smartUp;
    private final EnumSetting<LagBackMode> lagMode;
    private final SliderSetting smartDown;
    private final BooleanSetting breakCrystal;
    private final EnumSetting<LagBackMode> aboveLagMode;
    private final BooleanSetting Netherite;
    private final SliderSetting smartX;
    private final BooleanSetting antiLag;

    private /* synthetic */ boolean trapped(class_2338 class_23382) {
        BurrowTest a = class_23382;
        BurrowTest a2 = this;
        return (BurrowTest.mc.field_1687.method_39454((class_1297)BurrowTest.mc.field_1724, new class_238((class_2338)a)) || BlockUtil.getBlock((class_2338)a) == class_2246.field_10343) && a2.checkSelf(a.method_10087(2));
    }

    private /* synthetic */ void gotoPos(class_2338 class_23382) {
        BurrowTest a = class_23382;
        BurrowTest a2 = this;
        if (a2.rotate.getValue() == RotateMode.None) {
            mc.method_1562().method_52787((class_2596)new class_2828.class_2829((double)a.method_10263() + 0.5, BurrowTest.mc.field_1724.method_23318() + 0.1, (double)a.method_10260() + 0.5, false));
            return;
        }
        mc.method_1562().method_52787((class_2596)new class_2828.class_2830((double)a.method_10263() + 0.5, BurrowTest.mc.field_1724.method_23318() + 0.1, (double)a.method_10260() + 0.5, Hana.ROTATE.rotateYaw, 90.0f, false));
    }

    private /* synthetic */ boolean checkSelf(class_2338 class_23382) {
        BurrowTest a = class_23382;
        BurrowTest a2 = this;
        return BurrowTest.mc.field_1724.method_5829().method_994(new class_238((class_2338)a));
    }

    private /* synthetic */ boolean canPlace(class_2338 class_23382) {
        BurrowTest a = class_23382;
        BurrowTest a2 = this;
        if (a2.noSelfPos.getValue() && a.equals((Object)EntityUtil.getPlayerPos(true))) {
            return false;
        }
        if (!BlockUtil.airPlace() && BlockUtil.getPlaceSide((class_2338)a) == null) {
            return false;
        }
        if (!BlockUtil.canReplace((class_2338)a)) {
            return false;
        }
        if (a2.detectMine.getValue() && Hana.BREAK.isMining((class_2338)a)) {
            return false;
        }
        return !a2.hasEntity((class_2338)a);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onUpdate() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [22[DOLOOP]], but top level block is 2[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean hasEntity(class_2338 a) {
        BurrowTest a2;
        BurrowTest burrowTest = a2;
        a = BlockUtil.getEntities(new class_238((class_2338)a)).iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                a2 = (class_1297)a.next();
                if (a2 == BurrowTest.mc.field_1724) {
                    object = a;
                    continue;
                }
                if (!a2.method_5805() || a2 instanceof class_1542 || a2 instanceof class_1303 || a2 instanceof class_1683 || a2 instanceof class_1667 || a2 instanceof class_1511 && burrowTest.breakCrystal.getValue()) continue block0;
                if (!(a2 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                object = a;
            }
            break;
        } while (true);
        return false;
    }

    private /* synthetic */ boolean canMove(class_2338 class_23382) {
        BurrowTest a = class_23382;
        BurrowTest a2 = this;
        return BurrowTest.mc.field_1687.method_22347((class_2338)a) && BurrowTest.mc.field_1687.method_22347(a.method_10084());
    }

    private /* synthetic */ double qaq() {
        BurrowTest a;
        BurrowTest burrowTest = a;
        if (!BlockUtil.isAir(new class_2338((int)BurrowTest.mc.field_1724.method_23317(), (int)BurrowTest.mc.field_1724.method_23318(), (int)BurrowTest.mc.field_1724.method_23321()).method_35830(3))) {
            return 1.2;
        }
        int n = a = 4;
        while (n <= 5) {
            if (!BlockUtil.isAir(new class_2338((int)BurrowTest.mc.field_1724.method_23317(), (int)BurrowTest.mc.field_1724.method_23318(), (int)BurrowTest.mc.field_1724.method_23321()).method_35830(a))) {
                return 2.2 + (double)a - 4.0;
            }
            n = ++a;
        }
        return 10.0;
    }

    public BurrowTest() {
        BurrowTest a;
        BurrowTest burrowTest = a;
        super(Start.ALLATORIxDEMO("nwYwCuez\b!"), Module.Category.Combat);
        BurrowTest burrowTest2 = a;
        burrowTest.timer = new Timer();
        burrowTest2.webTimer = new Timer();
        burrowTest.disable = burrowTest.add(new BooleanSetting(Packet.ALLATORIxDEMO("MvKhLbL"), true));
        burrowTest.Anchor = burrowTest.add(new BooleanSetting(Start.ALLATORIxDEMO("mlRw\u0014'"), false));
        burrowTest.Netherite = burrowTest.add(new BooleanSetting(Packet.ALLATORIxDEMO("dK}w]{GzL"), false));
        burrowTest.delay = burrowTest.add(new SliderSetting(Start.ALLATORIxDEMO("FTs\u001a,"), 500, 0, 1000, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return !a2.disable.getValue();
        }));
        BurrowTest burrowTest3 = a;
        burrowTest3.webTime = burrowTest3.add(new SliderSetting(Packet.ALLATORIxDEMO("^zZ]GcL"), 0, 0, 500));
        burrowTest3.enderChest = burrowTest3.add(new BooleanSetting(Start.ALLATORIxDEMO("ilO`^AYz\b!"), true));
        burrowTest3.antiLag = burrowTest3.add(new BooleanSetting(Packet.ALLATORIxDEMO("HqL`boN"), false));
        burrowTest3.detectMine = burrowTest3.add(new BooleanSetting(Start.ALLATORIxDEMO("=2XgHqak_v\u00152"), false));
        burrowTest3.headFill = burrowTest3.add(new BooleanSetting(Packet.ALLATORIxDEMO("fl~\\OGbE"), false));
        burrowTest3.usingPause = burrowTest3.add(new BooleanSetting(Start.ALLATORIxDEMO("yqBkKRPj\b0"), false));
        burrowTest3.down = burrowTest3.add(new BooleanSetting(Packet.ALLATORIxDEMO("MAyG"), true));
        burrowTest3.noSelfPos = burrowTest3.add(new BooleanSetting(Start.ALLATORIxDEMO("LDVInWO\u0014&"), false));
        burrowTest3.packetPlace = burrowTest3.add(new BooleanSetting(Packet.ALLATORIxDEMO("blIElkheOmL"), true));
        burrowTest3.sound = burrowTest3.add(new BooleanSetting(Start.ALLATORIxDEMO("Q^j\u00151"), true));
        burrowTest3.blocksPer = burrowTest3.add(new SliderSetting(Packet.ALLATORIxDEMO("hBf|Sz~k["), 4.0, 1.0, 4.0, 1.0));
        burrowTest3.rotate = burrowTest3.add(new EnumSetting<RotateMode>(Start.ALLATORIxDEMO("~m_dXg|p\u001f0"), RotateMode.Bypass));
        burrowTest3.breakCrystal = burrowTest3.add(new BooleanSetting(Packet.ALLATORIxDEMO("z{KoB"), true));
        burrowTest3.wait = burrowTest3.add(new BooleanSetting(Start.ALLATORIxDEMO("f~\u0012!"), true, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return !a2.disable.getValue();
        }));
        BurrowTest burrowTest4 = a;
        burrowTest4.fakeMove = burrowTest4.add(new BooleanSetting(Packet.ALLATORIxDEMO("hht]DAxL"), true).setParent());
        burrowTest4.center = burrowTest4.add(new BooleanSetting(Start.ALLATORIxDEMO("\u0016@nDrog_k\u001e'"), false, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return a2.fakeMove.isOpen();
        }));
        BurrowTest burrowTest5 = a;
        burrowTest5.inventory = burrowTest5.add(new BooleanSetting(Packet.ALLATORIxDEMO("f{DhDZfmAZYoY"), true));
        burrowTest5.lagMode = burrowTest5.add(new EnumSetting<LagBackMode>(Start.ALLATORIxDEMO("IMe|p\u001f0"), LagBackMode.TrollHack));
        burrowTest5.aboveLagMode = burrowTest5.add(new EnumSetting<LagBackMode>(Packet.ALLATORIxDEMO("b\\KE~_DAjL"), LagBackMode.Smart));
        burrowTest5.smartX = burrowTest5.add(new SliderSetting(Start.ALLATORIxDEMO("VAcCk#\u000f"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        a.smartUp = a.add(new SliderSetting(Packet.ALLATORIxDEMO("ZrY{Z[Y"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        a.smartDown = a.add(new SliderSetting(Start.ALLATORIxDEMO("QFd^vup\f;"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        a.smartDistance = a.add(new SliderSetting(Packet.ALLATORIxDEMO("|xS^j`lLh@mL"), 2.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            BurrowTest a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        BurrowTest burrowTest6 = a;
        a.progress = 0;
        burrowTest6.placePos = new ArrayList<class_2338>();
        burrowTest6.setChinese(Start.ALLATORIxDEMO("D@kTq\u57b0\u814f"));
        INSTANCE = burrowTest6;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void placeBlock(class_2338 class_23382, boolean bl) {
        BurrowTest a = this;
        BurrowTest a2 = class_23382;
        if (a.canPlace((class_2338)a2) && !a.placePos.contains(a2)) {
            BurrowTest burrowTest = a;
            if (burrowTest.progress < burrowTest.blocksPer.getValueInt()) {
                void a3;
                class_2350 class_23502;
                a.placePos.add((class_2338)a2);
                if (BlockUtil.airPlace()) {
                    BurrowTest burrowTest2 = a;
                    ++burrowTest2.progress;
                    BlockUtil.placedPos.add((class_2338)a2);
                    if (burrowTest2.sound.getValue()) {
                        BurrowTest.mc.field_1687.method_8396((class_1657)BurrowTest.mc.field_1724, (class_2338)a2, class_3417.field_14574, class_3419.field_15245, 1.0f, 0.8f);
                    }
                    BlockUtil.clickBlock((class_2338)a2, class_2350.field_11033, (boolean)a3, a.packetPlace.getValue());
                }
                if ((class_23502 = BlockUtil.getPlaceSide((class_2338)a2)) == null) {
                    return;
                }
                BurrowTest burrowTest3 = a;
                ++burrowTest3.progress;
                BlockUtil.placedPos.add((class_2338)a2);
                if (burrowTest3.sound.getValue()) {
                    BurrowTest.mc.field_1687.method_8396((class_1657)BurrowTest.mc.field_1724, (class_2338)a2, class_3417.field_14574, class_3419.field_15245, 1.0f, 0.8f);
                }
                BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), (boolean)a3, a.packetPlace.getValue());
            }
        }
    }

    private /* synthetic */ int getBlock() {
        BurrowTest a;
        if (a.inventory.getValue()) {
            if (a.Anchor.getValue()) {
                return InventoryUtil.findBlockInventorySlot(class_2246.field_23152);
            }
            if (a.Netherite.getValue()) {
                return InventoryUtil.findBlockInventorySlot(class_2246.field_22108);
            }
            if (InventoryUtil.findBlockInventorySlot(class_2246.field_10540) != -1 || !a.enderChest.getValue()) {
                return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
            }
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10443);
        }
        if (a.Anchor.getValue()) {
            return InventoryUtil.findBlock(class_2246.field_23152);
        }
        if (a.Netherite.getValue()) {
            return InventoryUtil.findBlock(class_2246.field_22108);
        }
        if (InventoryUtil.findBlock(class_2246.field_10540) != -1 || !a.enderChest.getValue()) {
            return InventoryUtil.findBlock(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10443);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        BurrowTest a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, BurrowTest.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private static final class RotateMode
    extends Enum<RotateMode> {
        public static final /* enum */ RotateMode None;
        private static final /* synthetic */ RotateMode[] $VALUES;
        public static final /* enum */ RotateMode Bypass;
        public static final /* enum */ RotateMode Normal;

        /*
         * Exception decompiling
         */
        private /* synthetic */ RotateMode() {
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

        public static RotateMode valueOf(String a) {
            return Enum.valueOf(RotateMode.class, a);
        }

        private static /* synthetic */ RotateMode[] $values() {
            RotateMode[] arrrotateMode = new RotateMode[3];
            arrrotateMode[0] = Bypass;
            arrrotateMode[1] = Normal;
            arrrotateMode[2] = None;
            return arrrotateMode;
        }

        static {
            Bypass = new RotateMode(BlockUpUtil.ALLATORIxDEMO("gcHf\u0001>"), 0);
            Normal = new RotateMode(TimeHelper.ALLATORIxDEMO("n\rO\u0012\u0016Y"), 1);
            None = new RotateMode(BlockUpUtil.ALLATORIxDEMO("vh\u001c("), 2);
            $VALUES = RotateMode.$values();
        }

        public static RotateMode[] values() {
            return (RotateMode[])$VALUES.clone();
        }
    }

    private static final class LagBackMode
    extends Enum<LagBackMode> {
        public static final /* enum */ LagBackMode Normal;
        public static final /* enum */ LagBackMode Invalid;
        public static final /* enum */ LagBackMode Glide2;
        public static final /* enum */ LagBackMode Glide;
        public static final /* enum */ LagBackMode Rotation;
        public static final /* enum */ LagBackMode Tongyiqianweng;
        public static final /* enum */ LagBackMode ToVoid;
        public static final /* enum */ LagBackMode Smart;
        public static final /* enum */ LagBackMode ToVoid2;
        public static final /* enum */ LagBackMode Fly;
        public static final /* enum */ LagBackMode TrollHack;
        public static final /* enum */ LagBackMode Seija;
        private static final /* synthetic */ LagBackMode[] $VALUES;
        public static final /* enum */ LagBackMode XIN;
        public static final /* enum */ LagBackMode OBS;

        /*
         * Exception decompiling
         */
        private /* synthetic */ LagBackMode() {
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

        public static LagBackMode valueOf(String a) {
            return Enum.valueOf(LagBackMode.class, a);
        }

        public static LagBackMode[] values() {
            return (LagBackMode[])$VALUES.clone();
        }

        static {
            Smart = new LagBackMode(CrystalUtil.ALLATORIxDEMO("\bM1S%"), 0);
            Invalid = new LagBackMode(MathUtil.ALLATORIxDEMO("\u0019\u0000\u0004\u0004\u0015\r\u001c"), 1);
            TrollHack = new LagBackMode(CrystalUtil.ALLATORIxDEMO("\u000b{\u0016G7h1B:"), 2);
            ToVoid = new LagBackMode(MathUtil.ALLATORIxDEMO(":\u001d3\u0016\r\u001c"), 3);
            ToVoid2 = new LagBackMode(CrystalUtil.ALLATORIxDEMO("-D\rO9Ec"), 4);
            Normal = new LagBackMode(MathUtil.ALLATORIxDEMO(" \u001d\u0017\u0014\u0005\u0014"), 5);
            Rotation = new LagBackMode(CrystalUtil.ALLATORIxDEMO("[\u0016_:T9N?"), 6);
            Fly = new LagBackMode(MathUtil.ALLATORIxDEMO("?\b\u0001"), 7);
            Glide = new LagBackMode(CrystalUtil.ALLATORIxDEMO("\u001cL9E4"), 8);
            OBS = new LagBackMode(MathUtil.ALLATORIxDEMO("6&+"), 9);
            XIN = new LagBackMode(CrystalUtil.ALLATORIxDEMO("\bh\u001f"), 10);
            Seija = new LagBackMode(MathUtil.ALLATORIxDEMO("!\u0000\u0010\u000e\u0019"), 11);
            Tongyiqianweng = new LagBackMode(CrystalUtil.ALLATORIxDEMO("q:I0V6x\u0010J5W5O6"), 12);
            Glide2 = new LagBackMode(MathUtil.ALLATORIxDEMO(")\u001e\f\u001d\u0001J"), 13);
            $VALUES = LagBackMode.$values();
        }

        private static /* synthetic */ LagBackMode[] $values() {
            LagBackMode[] arrlagBackMode = new LagBackMode[14];
            arrlagBackMode[0] = Smart;
            arrlagBackMode[1] = Invalid;
            arrlagBackMode[2] = TrollHack;
            arrlagBackMode[3] = ToVoid;
            arrlagBackMode[4] = ToVoid2;
            arrlagBackMode[5] = Normal;
            arrlagBackMode[6] = Rotation;
            arrlagBackMode[7] = Fly;
            arrlagBackMode[8] = Glide;
            arrlagBackMode[9] = OBS;
            arrlagBackMode[10] = XIN;
            arrlagBackMode[11] = Seija;
            arrlagBackMode[12] = Tongyiqianweng;
            arrlagBackMode[13] = Glide2;
            return arrlagBackMode;
        }
    }

}
