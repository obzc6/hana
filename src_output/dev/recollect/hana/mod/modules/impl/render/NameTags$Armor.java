/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.mod.modules.impl.render.NameTags;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.video.Renderer;

public static final class NameTags.Armor
extends Enum<NameTags.Armor> {
    public static final /* enum */ NameTags.Armor None = new NameTags.Armor(Start.ALLATORIxDEMO("p\u00150"), 0);
    public static final /* enum */ NameTags.Armor OnlyArmor;
    public static final /* enum */ NameTags.Armor Full;
    public static final /* enum */ NameTags.Armor Durability;
    public static final /* enum */ NameTags.Armor Item;
    private static final /* synthetic */ NameTags.Armor[] $VALUES;

    public static NameTags.Armor valueOf(String a) {
        return Enum.valueOf(NameTags.Armor.class, a);
    }

    public static NameTags.Armor[] values() {
        return (NameTags.Armor[])$VALUES.clone();
    }

    private static /* synthetic */ NameTags.Armor[] $values() {
        NameTags.Armor[] arrarmor = new NameTags.Armor[5];
        arrarmor[0] = None;
        arrarmor[1] = Full;
        arrarmor[2] = Durability;
        arrarmor[3] = Item;
        arrarmor[4] = OnlyArmor;
        return arrarmor;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ NameTags.Armor() {
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

    static {
        Full = new NameTags.Armor(Renderer.ALLATORIxDEMO("F\b&["), 1);
        Durability = new NameTags.Armor(Start.ALLATORIxDEMO("hwYdNk]v\u000f,"), 2);
        Item = new NameTags.Armor(Renderer.ALLATORIxDEMO("I\t/Z"), 3);
        OnlyArmor = new NameTags.Armor(Start.ALLATORIxDEMO("MEiUCCr\u0014'"), 4);
        $VALUES = NameTags.Armor.$values();
    }
}
