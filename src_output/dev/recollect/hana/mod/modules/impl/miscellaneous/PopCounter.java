/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2561
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.DeathEvent;
import dev.recollect.hana.api.events.impl.TotemEvent;
import dev.recollect.hana.api.managers.PopManager;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.video.FileUtil;
import java.util.HashMap;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import org.bytedeco.javacv.FrameFilter;

public class PopCounter
extends Module {
    public final BooleanSetting unPop;
    public static PopCounter INSTANCE;
    private final EnumSetting<type> notitype;

    @EventHandler
    public void onPlayerDeath(DeathEvent deathEvent) {
        Object a = deathEvent;
        PopCounter a2 = this;
        if (Hana.POP.popContainer.containsKey((a = ((DeathEvent)a).getPlayer()).method_5477().getString())) {
            Hana.POP.popContainer.get(a.method_5477().getString()).intValue();
        }
    }

    public PopCounter() {
        PopCounter a;
        PopCounter popCounter = a;
        PopCounter popCounter2 = a;
        super(ProjectionUtils.ALLATORIxDEMO("a\u0018Z/_\u0003O\u0013S\u0002"), FileUtil.ALLATORIxDEMO(",i\u001c5@Vjj\u0019d\u0013S+iUt\u0000o\u0011lN`\u0010w\u001b"), Module.Category.Misc);
        PopCounter popCounter3 = a;
        popCounter3.notitype = popCounter2.add(new EnumSetting<type>(ProjectionUtils.ALLATORIxDEMO("u\u001eF\u0015"), type.Notify));
        popCounter.unPop = popCounter2.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("T\u001af\f"), true));
        popCounter.setChinese(ProjectionUtils.ALLATORIxDEMO("\u56df\u8119\u8b97\u6500"));
        INSTANCE = popCounter;
    }

    @EventHandler
    public void onTotem(TotemEvent totemEvent) {
        Object a = totemEvent;
        PopCounter a2 = this;
        a = ((TotemEvent)a).getPlayer();
        if (Hana.POP.popContainer.containsKey(a.method_5477().getString())) {
            Hana.POP.popContainer.get(a.method_5477().getString()).intValue();
        }
    }

    public static final class type
    extends Enum<type> {
        public static final /* enum */ type Chat;
        private static final /* synthetic */ type[] $VALUES;
        public static final /* enum */ type Notify;
        public static final /* enum */ type Both;

        private static /* synthetic */ type[] $values() {
            type[] arrtype = new type[3];
            arrtype[0] = Notify;
            arrtype[1] = Chat;
            arrtype[2] = Both;
            return arrtype;
        }

        static {
            Notify = new type(ObsidianHelper.ALLATORIxDEMO("{1H>O;"), 0);
            Chat = new type(FrameFilter.ALLATORIxDEMO("\u0011k&b"), 1);
            Both = new type(ObsidianHelper.ALLATORIxDEMO("~8]*"), 2);
            $VALUES = type.$values();
        }

        public static type[] values() {
            return (type[])$VALUES.clone();
        }

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

        public static type valueOf(String a) {
            return Enum.valueOf(type.class, a);
        }
    }

}
