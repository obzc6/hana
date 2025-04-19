/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.mod.modules.Module;
import org.bytedeco.javacv.BaseSettings;

public static final class Module.Category
extends Enum<Module.Category> {
    public static final /* enum */ Module.Category Player;
    public static final /* enum */ Module.Category Misc;
    public static final /* enum */ Module.Category Exploit;
    public static final /* enum */ Module.Category Client;
    public static final /* enum */ Module.Category Render;
    private static final /* synthetic */ Module.Category[] $VALUES;
    public static final /* enum */ Module.Category Combat;
    public static final /* enum */ Module.Category Movement;

    static {
        Combat = new Module.Category(BaseSettings.ALLATORIxDEMO("ulF|Aa"), 0);
        Misc = new Module.Category(NCPRaytracer.ALLATORIxDEMO("T_a^"), 1);
        Render = new Module.Category(BaseSettings.ALLATORIxDEMO("dfEzEg"), 2);
        Movement = new Module.Category(NCPRaytracer.ALLATORIxDEMO("ALrNtS|I"), 3);
        Player = new Module.Category(BaseSettings.ALLATORIxDEMO("foJgEg"), 4);
        Exploit = new Module.Category(NCPRaytracer.ALLATORIxDEMO("f|[uY{I"), 5);
        Client = new Module.Category(BaseSettings.ALLATORIxDEMO("uoB{Na"), 6);
        $VALUES = Module.Category.$values();
    }

    public static Module.Category[] values() {
        return (Module.Category[])$VALUES.clone();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ Module.Category() {
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

    private static /* synthetic */ Module.Category[] $values() {
        Module.Category[] arrcategory = new Module.Category[7];
        arrcategory[0] = Combat;
        arrcategory[1] = Misc;
        arrcategory[2] = Render;
        arrcategory[3] = Movement;
        arrcategory[4] = Player;
        arrcategory[5] = Exploit;
        arrcategory[6] = Client;
        return arrcategory;
    }

    public static Module.Category valueOf(String a) {
        return Enum.valueOf(Module.Category.class, a);
    }
}
