/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1702
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1702;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public class SprintPlus
extends Module {
    public static SprintPlus INSTANCE;
    public final EnumSetting<Mode> mode;
    public static boolean shouldSprint;

    public SprintPlus() {
        SprintPlus a;
        SprintPlus sprintPlus = a;
        SprintPlus sprintPlus2 = a;
        super(FadeUtils.ALLATORIxDEMO("i\u001cO\u0018NOA"), Module.Category.Movement);
        SprintPlus sprintPlus3 = a;
        sprintPlus3.mode = sprintPlus2.add(new EnumSetting<Mode>(RenderHelper.ALLATORIxDEMO(":gY'"), Mode.Normal));
        sprintPlus.setDescription(FadeUtils.ALLATORIxDEMO("pN\b\fQ\u000eT\u001dVG\u0003vl\u0010A\u0007ULM\u0007[\bE'$\u0000VPR\u0006UP\u0006\u0018T\u0005]LP\u001eD^D"));
        sprintPlus.setChinese(RenderHelper.ALLATORIxDEMO("\u81ff\u52df\u75b6\u8deci"));
        INSTANCE = sprintPlus;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static float getSprintYaw(float a) {
        float f;
        if (SprintPlus.mc.field_1690.field_1894.method_1434() && !SprintPlus.mc.field_1690.field_1881.method_1434()) {
            if (SprintPlus.mc.field_1690.field_1913.method_1434() && !SprintPlus.mc.field_1690.field_1849.method_1434()) {
                f = a = a - 45.0f;
                return class_3532.method_15393((float)f);
            }
            if (SprintPlus.mc.field_1690.field_1849.method_1434() && !SprintPlus.mc.field_1690.field_1913.method_1434()) {
                f = a = a + 45.0f;
                return class_3532.method_15393((float)f);
            }
        } else if (SprintPlus.mc.field_1690.field_1881.method_1434() && !SprintPlus.mc.field_1690.field_1894.method_1434()) {
            a += 180.0f;
            if (SprintPlus.mc.field_1690.field_1913.method_1434() && !SprintPlus.mc.field_1690.field_1849.method_1434()) {
                f = a = a + 45.0f;
                return class_3532.method_15393((float)f);
            }
            if (SprintPlus.mc.field_1690.field_1849.method_1434() && !SprintPlus.mc.field_1690.field_1913.method_1434()) {
                f = a = a - 45.0f;
                return class_3532.method_15393((float)f);
            }
        } else {
            if (SprintPlus.mc.field_1690.field_1913.method_1434() && !SprintPlus.mc.field_1690.field_1849.method_1434()) {
                f = a = a - 90.0f;
                return class_3532.method_15393((float)f);
            }
            if (SprintPlus.mc.field_1690.field_1849.method_1434() && !SprintPlus.mc.field_1690.field_1913.method_1434()) {
                a += 90.0f;
            }
        }
        f = a;
        return class_3532.method_15393((float)f);
    }

    @Override
    public String getInfo() {
        SprintPlus a;
        return a.mode.getValue().name();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onUpdate() {
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

    @EventHandler(priority=-100)
    public void rotate(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        SprintPlus a2 = this;
        if (!(SprintPlus.mc.field_1724.method_7344().method_7586() <= 6 && !SprintPlus.mc.field_1724.method_7337() || !MovementUtil.isMoving() || SprintPlus.mc.field_1724.method_6128() || SprintPlus.mc.field_1724.method_5715() || SprintPlus.mc.field_1724.method_3144() || SprintPlus.mc.field_1724.method_5799() || SprintPlus.mc.field_1724.method_5771() || SprintPlus.mc.field_1724.method_21754() || SprintPlus.mc.field_1724.method_6059(class_1294.field_5919) || !a2.mode.is(Mode.Rotation) || a.isModified())) {
            a.setYaw(SprintPlus.getSprintYaw(SprintPlus.mc.field_1724.method_36454()));
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Normal;
        public static final /* enum */ Mode Rotation;
        public static final /* enum */ Mode Rage;
        public static final /* enum */ Mode Legit;

        static {
            Legit = new Mode(WebUtils.ALLATORIxDEMO("V+`m9"), 0);
            Normal = new Mode(ColorUtil.ALLATORIxDEMO("\u0013t2kk "), 1);
            Rage = new Mode(WebUtils.ALLATORIxDEMO("\u001cfc("), 2);
            Rotation = new Mode(ColorUtil.ALLATORIxDEMO("\bs)z4oe\""), 3);
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
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

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[4];
            arrmode[0] = Legit;
            arrmode[1] = Normal;
            arrmode[2] = Rage;
            arrmode[3] = Rotation;
            return arrmode;
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }
    }

}
