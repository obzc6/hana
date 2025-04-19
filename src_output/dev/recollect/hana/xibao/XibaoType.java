/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5195
 */
package dev.recollect.hana.xibao;

import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.xibao.XibaoPlusPlusMusic;
import net.minecraft.class_2960;
import net.minecraft.class_5195;
import org.bytedeco.javacv.BaseSettings;

public final class XibaoType
extends Enum<XibaoType> {
    private static final /* synthetic */ XibaoType[] $VALUES;
    public final class_2960 background;
    public final class_5195 music;
    public static final /* enum */ XibaoType XIBAO;
    public final class_2960[] snows;
    public final String type;
    public static final /* enum */ XibaoType BEIBAO;

    static {
        class_2960[] arrclass_2960 = new class_2960[2];
        arrclass_2960[0] = new class_2960(RadiusUtils.ALLATORIxDEMO("\u001f]\u0002H\u0012\u0013G"), BaseSettings.ALLATORIxDEMO("LhNw\u00020dG\u001f|^bTbA\\~VOb\u0007lRn"));
        arrclass_2960[1] = new class_2960(RadiusUtils.ALLATORIxDEMO("\u001f]\u0002H\u0012\u0013G"), BaseSettings.ALLATORIxDEMO("w\u0012:uAB`H!JhR\\~VOb\u0007lRn"));
        XIBAO = new XibaoType(BaseSettings.ALLATORIxDEMO("M`^}F"), 0, XibaoPlusPlusMusic.XIBAO_MUSIC, new class_2960(RadiusUtils.ALLATORIxDEMO("\u001f]\u0002H\u0012\u0013G"), BaseSettings.ALLATORIxDEMO("uQHqN|]~\u0019{dZAz\u0007lRn")), arrclass_2960, RadiusUtils.ALLATORIxDEMO("\u0018@\u001f\u0002X"));
        class_2960[] arrclass_29602 = new class_2960[1];
        arrclass_29602[0] = new class_2960(RadiusUtils.ALLATORIxDEMO("\u001f]\u0002H\u0012\u0013G"), BaseSettings.ALLATORIxDEMO("yS{\u00037sQC*LfQyS\\~VOb\u0007lRn"));
        BEIBAO = new XibaoType(BaseSettings.ALLATORIxDEMO("bP`^}F"), 1, XibaoPlusPlusMusic.BEIBAO_MUSIC, new class_2960(RadiusUtils.ALLATORIxDEMO("\u001f]\u0002H\u0012\u0013G"), BaseSettings.ALLATORIxDEMO("6dLDpIkK\"TfdZAz\u0007lRn")), arrclass_29602, RadiusUtils.ALLATORIxDEMO("V\u0005@\u001f\u0002X"));
        $VALUES = XibaoType.$values();
    }

    public static XibaoType getByString(String a) {
        String string = a;
        XibaoType[] arrxibaoType = XibaoType.values();
        int n = arrxibaoType.length;
        int n2 = a = 0;
        while (n2 < n) {
            XibaoType xibaoType = arrxibaoType[a];
            if (string.equals(xibaoType.type)) {
                return xibaoType;
            }
            n2 = ++a;
        }
        return XIBAO;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ XibaoType(class_5195 varnull, class_2960 varnull, class_2960[] var3_1, String var4_2) {
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

    private static /* synthetic */ XibaoType[] $values() {
        XibaoType[] arrxibaoType = new XibaoType[2];
        arrxibaoType[0] = XIBAO;
        arrxibaoType[1] = BEIBAO;
        return arrxibaoType;
    }

    public static XibaoType[] values() {
        return (XibaoType[])$VALUES.clone();
    }

    public static XibaoType valueOf(String a) {
        return Enum.valueOf(XibaoType.class, a);
    }
}
