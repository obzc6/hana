/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.video.FileUtil;
import org.bytedeco.javacv.FrameConverter;
import org.bytedeco.javacv.FrameFilter;

public static class Notify.Notifys {
    public final FadeUtils firstFade;
    public int delayed;
    public static icon icon;
    public final FadeUtils accentFade;
    public final String first;
    public final FadeUtils yFade;
    public final FadeUtils endFade;
    public boolean end;

    /*
     * WARNING - void declaration
     */
    public Notify.Notifys(String string, icon icon2) {
        Notify.Notifys a;
        void a2;
        Object a3 = icon2;
        Notify.Notifys notifys = a = this;
        Notify.Notifys notifys2 = a;
        notifys2.firstFade = new FadeUtils(500L);
        notifys.yFade = new FadeUtils(500L);
        notifys.accentFade = new FadeUtils(500L);
        notifys.delayed = 55;
        a.endFade = new FadeUtils(350L);
        a.first = a2;
        a.firstFade.reset();
        a.yFade.reset();
        a.endFade.reset();
        a.accentFade.reset();
        a.end = false;
        icon = a3;
    }

    public static final class icon
    extends Enum<icon> {
        public static final /* enum */ icon Success = new icon(FrameFilter.ALLATORIxDEMO("I4s.y?n"), 0);
        public static final /* enum */ icon Error = new icon(FileUtil.ALLATORIxDEMO("<h\u0007t\u0006"), 1);
        private static final /* synthetic */ icon[] $VALUES;

        public static icon valueOf(String a) {
            return Enum.valueOf(icon.class, a);
        }

        public static icon[] values() {
            return (icon[])$VALUES.clone();
        }

        static {
            $VALUES = icon.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ icon() {
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

        private static /* synthetic */ icon[] $values() {
            icon[] arricon = new icon[2];
            arricon[0] = Success;
            arricon[1] = Error;
            return arricon;
        }
    }

    public static final class mode
    extends Enum<mode> {
        public static final /* enum */ mode Fill;
        private static final /* synthetic */ mode[] $VALUES;
        public static final /* enum */ mode Line;

        static {
            Line = new mode(Hole.ALLATORIxDEMO("/sG5"), 0);
            Fill = new mode(Animation.ALLATORIxDEMO("auJq"), 1);
            $VALUES = mode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ mode() {
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

        private static /* synthetic */ mode[] $values() {
            mode[] arrmode = new mode[2];
            arrmode[0] = Line;
            arrmode[1] = Fill;
            return arrmode;
        }

        public static mode valueOf(String a) {
            return Enum.valueOf(mode.class, a);
        }

        public static mode[] values() {
            return (mode[])$VALUES.clone();
        }
    }

    public static final class type
    extends Enum<type> {
        public static final /* enum */ type Chat;
        private static final /* synthetic */ type[] $VALUES;
        public static final /* enum */ type Both;
        public static final /* enum */ type Notify;

        /*
         * Exception decompiling
         */
        private /* synthetic */ type() {
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

        public static type[] values() {
            return (type[])$VALUES.clone();
        }

        private static /* synthetic */ type[] $values() {
            type[] arrtype = new type[3];
            arrtype[0] = Notify;
            arrtype[1] = Chat;
            arrtype[2] = Both;
            return arrtype;
        }

        static {
            Notify = new type(FrameConverter.ALLATORIxDEMO("<~\u001beC?"), 0);
            Chat = new type(GameInfo.ALLATORIxDEMO("N}yt"), 1);
            Both = new type(FrameConverter.ALLATORIxDEMO("-cQ."), 2);
            $VALUES = type.$values();
        }

        public static type valueOf(String a) {
            return Enum.valueOf(type.class, a);
        }
    }

}
