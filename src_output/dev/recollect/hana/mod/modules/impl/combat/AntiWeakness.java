/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1829
 *  net.minecraft.class_2596
 *  net.minecraft.class_2824
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Criticals;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_2596;
import net.minecraft.class_2824;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameConverter;
import org.bytedeco.javacv.FrameFilter;

public class AntiWeakness
extends Module {
    boolean ignore;
    private final Timer delayTimer;
    private final BooleanSetting onlyCrystal;
    private class_2824 lastPacket;
    private final SliderSetting delay;
    private final EnumSetting<SwapMode> swapMode;

    @Override
    public String getInfo() {
        AntiWeakness a;
        return a.swapMode.getValue().name();
    }

    public AntiWeakness() {
        AntiWeakness a;
        AntiWeakness antiWeakness = a;
        AntiWeakness antiWeakness2 = a;
        super(FrameConverter.ALLATORIxDEMO("f*\u0006x\"s\u0013z\u0001iV5"), FrameFilter.ALLATORIxDEMO("y\"i.6&e0k"), Module.Category.Combat);
        AntiWeakness antiWeakness3 = a;
        antiWeakness3.delay = antiWeakness2.add(new SliderSetting(FrameConverter.ALLATORIxDEMO("U\n`D?"), 100, 0, 500).setSuffix(FrameFilter.ALLATORIxDEMO("<s")));
        antiWeakness2.swapMode = antiWeakness2.add(new EnumSetting<SwapMode>(FrameConverter.ALLATORIxDEMO("&a\u0013a\"cA#"), SwapMode.Inventory));
        antiWeakness.onlyCrystal = antiWeakness2.add(new BooleanSetting(FrameFilter.ALLATORIxDEMO("]'t5^5o\"t0l"), true));
        antiWeakness.delayTimer = new Timer();
        antiWeakness.lastPacket = null;
        a.ignore = false;
        a.setChinese(FrameConverter.ALLATORIxDEMO("\u53c1\u867f\u5f77"));
    }

    private /* synthetic */ void doAnti() {
        AntiWeakness a;
        AntiWeakness antiWeakness = a;
        if (antiWeakness.lastPacket == null) {
            return;
        }
        if ((antiWeakness.swapMode.getValue() != SwapMode.Inventory ? (a = InventoryUtil.findClass(class_1829.class)) : (a = InventoryUtil.findClassInventorySlot(class_1829.class))) == -1) {
            return;
        }
        int n = AntiWeakness.mc.field_1724.method_31548().field_7545;
        if (antiWeakness.swapMode.getValue() != SwapMode.Inventory) {
            InventoryUtil.switchToSlot(a);
        } else {
            AntiWeakness.mc.field_1761.method_2906(AntiWeakness.mc.field_1724.field_7512.field_7763, a, AntiWeakness.mc.field_1724.method_31548().field_7545, class_1713.field_7791, (class_1657)AntiWeakness.mc.field_1724);
        }
        AntiWeakness.mc.field_1724.field_3944.method_52787((class_2596)antiWeakness.lastPacket);
        if (antiWeakness.swapMode.getValue() != SwapMode.Inventory) {
            if (antiWeakness.swapMode.getValue() != SwapMode.Normal) {
                InventoryUtil.switchToSlot(n);
                return;
            }
        } else {
            AntiWeakness.mc.field_1761.method_2906(AntiWeakness.mc.field_1724.field_7512.field_7763, a, AntiWeakness.mc.field_1724.method_31548().field_7545, class_1713.field_7791, (class_1657)AntiWeakness.mc.field_1724);
            EntityUtil.syncInventory();
        }
    }

    @EventHandler(priority=-200)
    public void onPacketSend(PacketEvent.Send send) {
        class_2824 class_28242;
        PacketEvent.Send a = send;
        AntiWeakness a2 = this;
        if (AntiWeakness.nullCheck()) {
            return;
        }
        if (a.isCancelled()) {
            return;
        }
        if (a2.ignore) {
            return;
        }
        if (AntiWeakness.mc.field_1724.method_6112(class_1294.field_5911) == null) {
            return;
        }
        if (AntiWeakness.mc.field_1724.method_6047().method_7909() instanceof class_1829) {
            return;
        }
        AntiWeakness antiWeakness = a2;
        if (!antiWeakness.delayTimer.passedMs(antiWeakness.delay.getValue())) {
            return;
        }
        Object t = a.getPacket();
        if (t instanceof class_2824 && Criticals.getInteractType(class_28242 = (class_2824)t) == Criticals.InteractType.ATTACK) {
            if (a2.onlyCrystal.getValue() && !(Criticals.getEntity(class_28242) instanceof class_1511)) {
                return;
            }
            a2.lastPacket = (class_2824)a.getPacket();
            a2.delayTimer.reset();
            a2.ignore = true;
            a2.doAnti();
            a2.ignore = false;
            a.cancel();
        }
    }

    public static final class SwapMode
    extends Enum<SwapMode> {
        private static final /* synthetic */ SwapMode[] $VALUES;
        public static final /* enum */ SwapMode Silent;
        public static final /* enum */ SwapMode Inventory;
        public static final /* enum */ SwapMode Normal;

        /*
         * Exception decompiling
         */
        private /* synthetic */ SwapMode() {
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

        public static SwapMode[] values() {
            return (SwapMode[])$VALUES.clone();
        }

        private static /* synthetic */ SwapMode[] $values() {
            SwapMode[] arrswapMode = new SwapMode[3];
            arrswapMode[0] = Normal;
            arrswapMode[1] = Silent;
            arrswapMode[2] = Inventory;
            return arrswapMode;
        }

        public static SwapMode valueOf(String a) {
            return Enum.valueOf(SwapMode.class, a);
        }

        static {
            Normal = new SwapMode(Vec3.ALLATORIxDEMO("\\\u0017k\u001ey\u001e"), 0);
            Silent = new SwapMode(Vec3.ALLATORIxDEMO("A\u0011u\u0016v\u0006"), 1);
            Inventory = new SwapMode(Vec3.ALLATORIxDEMO(".^,w\u0016m\u001cj\u000b"), 2);
            $VALUES = SwapMode.$values();
        }
    }

}
