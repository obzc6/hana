/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
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
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class OldBurrow
extends Module {
    public final BooleanSetting antiLag;
    private final BooleanSetting center;
    class_2338 movedPos;
    private final BooleanSetting inventory;
    private boolean ignore;
    public static OldBurrow INSTANCE;
    private final BooleanSetting breakCrystal;
    private final BooleanSetting wait;
    int progress;
    List<class_2338> placePos;
    private final EnumSetting rotate;
    public final SliderSetting multiPlace;
    public final BooleanSetting enderChest;
    private final BooleanSetting aboveHead;
    public final BooleanSetting headFill;
    public final BooleanSetting bypass;
    private final EnumSetting lagMode;
    private final BooleanSetting noSelfPos;
    public final BooleanSetting helper;

    private /* synthetic */ int getBlock() {
        OldBurrow a;
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

    @EventHandler
    public void OnPacket(PacketEvent.Receive receive) {
        Object a = receive;
        OldBurrow a2 = this;
        if (OldBurrow.nullCheck()) {
            return;
        }
        if ((a = ((PacketEvent)a).getPacket()) instanceof class_2828.class_2829) {
            (class_2828.class_2829)a;
            if (a2.bypass.getValue() && !a2.ignore) {
                OldBurrow.mc.field_1724.field_6036 = 0.0;
                OldBurrow.mc.field_1724.method_5814(OldBurrow.mc.field_1724.method_23317(), OldBurrow.mc.field_1724.method_23318() - 1.0E-10, OldBurrow.mc.field_1724.method_23321());
                OldBurrow oldBurrow = a2;
                oldBurrow.ignore = true;
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(OldBurrow.mc.field_1724.method_23317(), OldBurrow.mc.field_1724.method_23318(), OldBurrow.mc.field_1724.method_23321(), false));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(OldBurrow.mc.field_1724.method_23317(), OldBurrow.mc.field_1724.method_23318() + 1000.0, OldBurrow.mc.field_1724.method_23321(), false));
                oldBurrow.ignore = false;
            }
        }
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        OldBurrow a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, OldBurrow.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ boolean checkSelf(class_2338 class_23382) {
        OldBurrow a = class_23382;
        OldBurrow a2 = this;
        return OldBurrow.mc.field_1724.method_5829().method_994(new class_238((class_2338)a));
    }

    private /* synthetic */ class_2338 getFlooredPosition(class_1297 class_12972) {
        OldBurrow a = class_12972;
        OldBurrow a2 = this;
        return new class_2338((int)Math.floor(a.method_23317()), (int)Math.round(a.method_23318()), (int)Math.floor(a.method_23321()));
    }

    private /* synthetic */ double qaq() {
        OldBurrow a;
        OldBurrow oldBurrow = a;
        if (!BlockUtil.isAir(new class_2338((int)OldBurrow.mc.field_1724.method_23317(), (int)OldBurrow.mc.field_1724.method_23318(), (int)OldBurrow.mc.field_1724.method_23321()).method_35830(3))) {
            return 1.2;
        }
        int n = a = 4;
        while (n <= 5) {
            if (!BlockUtil.isAir(new class_2338((int)OldBurrow.mc.field_1724.method_23317(), (int)OldBurrow.mc.field_1724.method_23318(), (int)OldBurrow.mc.field_1724.method_23321()).method_35830(a))) {
                return 2.2 + (double)a - 4.0;
            }
            n = ++a;
        }
        return 10.0;
    }

    private /* synthetic */ boolean Trapped(class_2338 class_23382) {
        OldBurrow a = class_23382;
        OldBurrow a2 = this;
        return OldBurrow.mc.field_1687.method_39454((class_1297)OldBurrow.mc.field_1724, new class_238((class_2338)a)) && a2.checkSelf(a.method_10087(2));
    }

    private /* synthetic */ boolean hasEntity(class_2338 a) {
        OldBurrow a22;
        OldBurrow oldBurrow = a22;
        for (OldBurrow a22 : OldBurrow.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a))) {
            if (a22 == OldBurrow.mc.field_1724 || !a22.method_5805() || a22 instanceof class_1542 || a22 instanceof class_1303 || a22 instanceof class_1683 || a22 instanceof class_1667 || a22 instanceof class_1511 && oldBurrow.breakCrystal.getValue() || a22 instanceof class_1531 && CombatSetting.INSTANCE.obsMode.getValue()) continue;
            return true;
        }
        return false;
    }

    private /* synthetic */ boolean canGoto(class_2338 class_23382) {
        OldBurrow a = class_23382;
        OldBurrow a2 = this;
        return !BlockUtil.getState((class_2338)a).method_51366() && !BlockUtil.getState(a.method_10084()).method_51366();
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void placeBlock(class_2338 class_23382, boolean bl) {
        OldBurrow a = this;
        OldBurrow a2 = class_23382;
        if (a.canPlace((class_2338)a2) && !a.placePos.contains(a2)) {
            OldBurrow oldBurrow = a;
            if (oldBurrow.progress < oldBurrow.multiPlace.getValueInt()) {
                void a3;
                a.placePos.add((class_2338)a2);
                ++a.progress;
                class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)a2);
                if (class_23502 == null) {
                    return;
                }
                BlockUtil.placedPos.add((class_2338)a2);
                BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), (boolean)a3);
            }
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onUpdate() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[DOLOOP]], but top level block is 2[CASE]
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

    public OldBurrow() {
        OldBurrow a;
        OldBurrow oldBurrow = a;
        super(PacketBuffer.ALLATORIxDEMO("F\u0005j+{\u0006a\u0003|"), Module.Category.Combat);
        OldBurrow oldBurrow2 = a;
        oldBurrow2.enderChest = oldBurrow.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\nM,A=`:[k\u0000"), true));
        oldBurrow.antiLag = oldBurrow.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("O\u0007z\u001d_\rl"), true));
        oldBurrow.helper = oldBurrow.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u0007F>N}\u0006"), true));
        oldBurrow.headFill = oldBurrow.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("!k\bj2z\u0000g"), true));
        oldBurrow.multiPlace = oldBurrow.add(new SliderSetting(GaussianFilter.ALLATORIxDEMO("\u0002V$P&s>_{\u0011"), 3.0, 1.0, 16.0, 1.0));
        oldBurrow.rotate = oldBurrow.add(new EnumSetting<RotateMode>(PacketBuffer.ALLATORIxDEMO("<f\u001do\u001dk9|\bn"), RotateMode.Bypass));
        oldBurrow.breakCrystal = oldBurrow.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("a [y\u001f"), true));
        oldBurrow.noSelfPos = oldBurrow.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("G\u0006]\fb\u0012C\u0003x"), false));
        oldBurrow.wait = oldBurrow.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("\u0005_q\u0000"), false));
        oldBurrow.bypass = oldBurrow.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("+w\u0004r\u001fx"), true));
        oldBurrow.aboveHead = oldBurrow.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("b*K9F\u001a[y\u0010"), true).setParent());
        oldBurrow.center = oldBurrow.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("*k\u001ag\ty"), true, object -> {
            Object a = object;
            OldBurrow a2 = this;
            return a2.aboveHead.isOpen();
        }));
        OldBurrow oldBurrow3 = a;
        OldBurrow oldBurrow4 = a;
        OldBurrow oldBurrow5 = a;
        oldBurrow5.inventory = oldBurrow5.add(new BooleanSetting(GaussianFilter.ALLATORIxDEMO("tt\u0000*M<K=Z\u0001Iy\u0004"), true));
        oldBurrow5.lagMode = oldBurrow5.add(new EnumSetting<LagBackMode>(PacketBuffer.ALLATORIxDEMO("B\bi9|\bn"), LagBackMode.Normal));
        oldBurrow4.ignore = false;
        oldBurrow4.progress = 0;
        oldBurrow4.placePos = new ArrayList<class_2338>();
        oldBurrow3.movedPos = null;
        oldBurrow3.setChinese(GaussianFilter.ALLATORIxDEMO("\u001dF0\u76ba\u57d3\u816e"));
        INSTANCE = oldBurrow3;
    }

    private /* synthetic */ void gotoPos(class_2338 class_23382) {
        OldBurrow oldBurrow;
        OldBurrow a = class_23382;
        OldBurrow a2 = this;
        a2.movedPos = a;
        if (Math.abs((double)oldBurrow.method_10263() + 0.5 - OldBurrow.mc.field_1724.method_23317()) < Math.abs((double)a.method_10260() + 0.5 - OldBurrow.mc.field_1724.method_23321())) {
            OldBurrow.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(OldBurrow.mc.field_1724.method_23317(), OldBurrow.mc.field_1724.method_23318() + 0.2, OldBurrow.mc.field_1724.method_23321() + ((double)a.method_10260() + 0.5 - OldBurrow.mc.field_1724.method_23321()), true));
            return;
        }
        OldBurrow.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(OldBurrow.mc.field_1724.method_23317() + ((double)a.method_10263() + 0.2 - OldBurrow.mc.field_1724.method_23317()), OldBurrow.mc.field_1724.method_23318() + 0.2, OldBurrow.mc.field_1724.method_23321(), true));
    }

    boolean canPlace(class_2338 class_23382) {
        OldBurrow a = class_23382;
        OldBurrow a2 = this;
        return (!a2.noSelfPos.getValue() || !EntityUtil.getPlayerPos().equals((Object)a)) && BlockUtil.getPlaceSide((class_2338)a) != null && BlockUtil.canReplace((class_2338)a) && !a2.hasEntity((class_2338)a);
    }

    private static final class RotateMode
    extends Enum<RotateMode> {
        private static final /* synthetic */ RotateMode[] $VALUES;
        public static final /* enum */ RotateMode Normal;
        public static final /* enum */ RotateMode Bypass;
        public static final /* enum */ RotateMode None;

        public static RotateMode valueOf(String a) {
            return Enum.valueOf(RotateMode.class, a);
        }

        static {
            Bypass = new RotateMode(FadeUtils.ALLATORIxDEMO(".D\u0001AH\u0019"), 0);
            Normal = new RotateMode(GaussianKernel.ALLATORIxDEMO("\u001c/+&9&"), 1);
            None = new RotateMode(FadeUtils.ALLATORIxDEMO("?OU\u000f"), 2);
            $VALUES = RotateMode.$values();
        }

        private static /* synthetic */ RotateMode[] $values() {
            RotateMode[] arrrotateMode = new RotateMode[3];
            arrrotateMode[0] = Bypass;
            arrrotateMode[1] = Normal;
            arrrotateMode[2] = None;
            return arrrotateMode;
        }

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

        public static RotateMode[] values() {
            return (RotateMode[])$VALUES.clone();
        }
    }

    private static final class LagBackMode
    extends Enum<LagBackMode> {
        public static final /* enum */ LagBackMode OBSTest;
        public static final /* enum */ LagBackMode TrollHack;
        public static final /* enum */ LagBackMode Normal;
        private static final /* synthetic */ LagBackMode[] $VALUES;
        public static final /* enum */ LagBackMode Rotation;
        public static final /* enum */ LagBackMode Test;
        public static final /* enum */ LagBackMode Old;
        public static final /* enum */ LagBackMode Glide;
        public static final /* enum */ LagBackMode Void;
        public static final /* enum */ LagBackMode Strict;

        public static LagBackMode valueOf(String a) {
            return Enum.valueOf(LagBackMode.class, a);
        }

        private static /* synthetic */ LagBackMode[] $values() {
            LagBackMode[] arrlagBackMode = new LagBackMode[9];
            arrlagBackMode[0] = Normal;
            arrlagBackMode[1] = Strict;
            arrlagBackMode[2] = Void;
            arrlagBackMode[3] = OBSTest;
            arrlagBackMode[4] = Old;
            arrlagBackMode[5] = Glide;
            arrlagBackMode[6] = Test;
            arrlagBackMode[7] = TrollHack;
            arrlagBackMode[8] = Rotation;
            return arrlagBackMode;
        }

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

        static {
            Normal = new LagBackMode(BaseChildSettings.ALLATORIxDEMO("i<H#\u0011h"), 0);
            Strict = new LagBackMode(GameInfo.ALLATORIxDEMO("A~kh{t"), 1);
            Void = new LagBackMode(BaseChildSettings.ALLATORIxDEMO("l!\u0019`"), 2);
            OBSTest = new LagBackMode(GameInfo.ALLATORIxDEMO("gPYMdkt"), 3);
            Old = new LagBackMode(BaseChildSettings.ALLATORIxDEMO("\u0001\u001c`"), 4);
            Glide = new LagBackMode(GameInfo.ALLATORIxDEMO("Muh|e"), 5);
            Test = new LagBackMode(BaseChildSettings.ALLATORIxDEMO("n+\u0003p"), 6);
            TrollHack = new LagBackMode(GameInfo.ALLATORIxDEMO("ZBG~fQ`{k"), 7);
            Rotation = new LagBackMode(BaseChildSettings.ALLATORIxDEMO("r;S2N'\u001fj"), 8);
            $VALUES = LagBackMode.$values();
        }

        public static LagBackMode[] values() {
            return (LagBackMode[])$VALUES.clone();
        }
    }

}
