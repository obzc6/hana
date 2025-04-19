/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1538
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2400
 *  net.minecraft.class_2602
 *  net.minecraft.class_2604
 *  net.minecraft.class_310
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1538;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2400;
import net.minecraft.class_2602;
import net.minecraft.class_2604;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class KillEffects
extends Module {
    private final Map<class_1657, Long> renderEntities;
    public static KillEffects INSTANCE;
    private final BooleanSetting playSound;
    private final Map<class_1657, Long> lightningEntities;
    private final EnumSetting<Mode> mode;
    private final class_310 mc;

    private /* synthetic */ void lambda$onRender3D$0(class_1657 class_16572, Long l) {
        int a;
        KillEffects a2 = class_16572;
        KillEffects a3 = this;
        int n = a = 0;
        while ((float)n < a2.method_17682() * 20.0f) {
            int n2;
            int n3 = n2 = 0;
            while ((float)n3 < a2.method_17681() * 20.0f) {
                int n4;
                int n5 = n4 = 0;
                while ((float)n5 < a2.method_17681() * 20.0f) {
                    double d = a2.method_23321() + (double)n4 * 0.1;
                    a3.mc.field_1687.method_8406((class_2394)class_2398.field_18304, a2.method_23317() + (double)n2 * 0.1, a2.method_23318() + (double)a * 0.1, d, 0.0, 0.0, 0.0);
                    n5 = ++n4;
                }
                n3 = ++n2;
            }
            n = ++a;
        }
        a3.renderEntities.remove(a2);
    }

    private /* synthetic */ void lambda$onRender3D$2(class_1657 class_16572, Long l) {
        int a;
        KillEffects a2 = class_16572;
        KillEffects a3 = this;
        int n = a = 0;
        while ((float)n < a2.method_17682() * 10.0f) {
            int n2;
            int n3 = n2 = 0;
            while ((float)n3 < a2.method_17681() * 10.0f) {
                int n4;
                int n5 = n4 = 0;
                while ((float)n5 < a2.method_17681() * 10.0f) {
                    double d = a2.method_23321() + (double)(n4 * 5);
                    a3.mc.field_1687.method_8406((class_2394)class_2398.field_43379, a2.method_23317() + (double)(n2 * 5), a2.method_23318() + (double)(a * 5), d, 0.0, 0.0, 0.0);
                    n5 = ++n4;
                }
                n3 = ++n2;
            }
            n = ++a;
        }
        a3.renderEntities.remove(a2);
    }

    /*
     * Exception decompiling
     */
    @EventHandler
    public void onRender3D(Render3DEvent var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 1[CASE]
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

    @Override
    public void onUpdate() {
        KillEffects a2;
        a2.mc.field_1687.method_18112().forEach(class_12972 -> {
            KillEffects a = class_12972;
            KillEffects a2 = this;
            if (a instanceof class_1657 && (a = (class_1657)a) != a2.mc.field_1724 && !a2.renderEntities.containsKey(a) && !a2.lightningEntities.containsKey(a) && !a.method_5805() && a.method_6032() == 0.0f) {
                a2.renderEntities.put((class_1657)a, System.currentTimeMillis());
            }
        });
        a2.renderEntities.entrySet().removeIf(a -> System.currentTimeMillis() - (Long)a.getValue() > 5000L);
        a2.lightningEntities.entrySet().removeIf(a -> System.currentTimeMillis() - (Long)a.getValue() > 5000L);
    }

    public KillEffects() {
        KillEffects a;
        KillEffects killEffects = a;
        super(BetterDynamicAnimation.ALLATORIxDEMO("^HyNSBvVd@s"), Module.Category.Render);
        KillEffects killEffects2 = a;
        killEffects2.mode = killEffects.add(new EnumSetting<Mode>(UserInfo.ALLATORIxDEMO(";<\u00151"), Mode.SakuraPetals));
        killEffects.playSound = killEffects.add(new BooleanSetting(BetterDynamicAnimation.ALLATORIxDEMO("eNw]C\\rZd"), true));
        a.mc = class_310.method_1551();
        a.setChinese(UserInfo.ALLATORIxDEMO("\u518d\u6713\u7208\u651c"));
        INSTANCE = a;
        a.renderEntities = new ConcurrentHashMap<class_1657, Long>();
        a.lightningEntities = new ConcurrentHashMap<class_1657, Long>();
    }

    private /* synthetic */ void lambda$onRender3D$1(class_1657 class_16572, Long l) {
        KillEffects a = class_16572;
        KillEffects a2 = this;
        class_1538 a3 = new class_1538(class_1299.field_6112, (class_1937)a2.mc.field_1687);
        a3.method_24203(a.method_23317(), a.method_23318(), a.method_23321());
        KillEffects killEffects = a2;
        new class_2604((class_1297)a3).method_11178((class_2602)killEffects.mc.method_1562());
        if (killEffects.playSound.getValue()) {
            KillEffects killEffects2 = a2;
            a2.mc.field_1687.method_43128((class_1657)killEffects2.mc.field_1724, a.method_23317(), a.method_23318(), a.method_23321(), class_3417.field_14865, class_3419.field_15252, 10000.0f, 0.16000001f);
            killEffects2.mc.field_1687.method_43128((class_1657)a2.mc.field_1724, a.method_23317(), a.method_23318(), a.method_23321(), class_3417.field_14956, class_3419.field_15252, 2.0f, 0.1f);
        }
        a2.renderEntities.remove(a);
        a2.lightningEntities.put((class_1657)a, System.currentTimeMillis());
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode LightningBolt;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode FallingLava;
        public static final /* enum */ Mode SakuraPetals;

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        static {
            FallingLava = new Mode(ColorUtil.ALLATORIxDEMO("X<w6u3|\fg|-"), 0);
            LightningBolt = new Mode(TimerManager.ALLATORIxDEMO("\r\u0015)\u0011?\u0010%\u0017,&9Bh"), 1);
            SakuraPetals = new Mode(ColorUtil.ALLATORIxDEMO("\u000b6n(}\r~4gf?"), 2);
            $VALUES = Mode.$values();
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = FallingLava;
            arrmode[1] = LightningBolt;
            arrmode[2] = SakuraPetals;
            return arrmode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Mode() {
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
    }

}
