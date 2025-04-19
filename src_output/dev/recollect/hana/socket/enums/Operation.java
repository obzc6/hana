/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 */
package dev.recollect.hana.socket.enums;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.video.FileUtil;
import org.apache.logging.log4j.LogManager;

public final class Operation
extends Enum<Operation> {
    public static final /* enum */ Operation KICK;
    public static final /* enum */ Operation IRC_CHAT;
    private static final /* synthetic */ Operation[] $VALUES;
    public static final /* enum */ Operation CHAT;
    public static final /* enum */ Operation TITLE;
    private final String name;
    public static final /* enum */ Operation CRASH;

    static {
        CRASH = new Operation(Snow.ALLATORIxDEMO("\u001f\\\u001b\\\u0013"), 0, FileUtil.ALLATORIxDEMO("0h\u0014h\u001c"));
        IRC_CHAT = new Operation(Snow.ALLATORIxDEMO("\\\u0013K\u0003M\u0012N\u000f"), 1, FileUtil.ALLATORIxDEMO("'n\u0010Y\u001dz\u0000"));
        CHAT = new Operation(Snow.ALLATORIxDEMO("M\u0012N\u000f"), 2, FileUtil.ALLATORIxDEMO("Y\u001dz\u0000"));
        TITLE = new Operation(Snow.ALLATORIxDEMO("\bG\u000eC\u001e"), 3, FileUtil.ALLATORIxDEMO("'s\u0001w\u0011"));
        KICK = new Operation(Snow.ALLATORIxDEMO("E\u0013L\u0010"), 4, FileUtil.ALLATORIxDEMO("Q\u001cx\u001f"));
        $VALUES = Operation.$values();
    }

    public String getName() {
        Operation a;
        return a.name;
    }

    public static Operation fromString(String a) {
        String string = a;
        Operation[] arroperation = Operation.values();
        int n = arroperation.length;
        int n2 = a = 0;
        while (n2 < n) {
            Operation operation = arroperation[a];
            if (operation.getName().equalsIgnoreCase(string)) {
                return operation;
            }
            n2 = ++a;
        }
        LogManager.getLogger().info("No enum constant for name: " + string);
        return null;
    }

    public static Operation valueOf(String a) {
        return Enum.valueOf(Operation.class, a);
    }

    private static /* synthetic */ Operation[] $values() {
        Operation[] arroperation = new Operation[5];
        arroperation[0] = CRASH;
        arroperation[1] = IRC_CHAT;
        arroperation[2] = CHAT;
        arroperation[3] = TITLE;
        arroperation[4] = KICK;
        return arroperation;
    }

    /*
     * Exception decompiling
     */
    public void handler(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:478)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:376)
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

    public static Operation[] values() {
        return (Operation[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Operation(String varnull) {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }
}
