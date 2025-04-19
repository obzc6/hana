/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.util.HashMap;
import java.util.function.Predicate;
import net.minecraft.class_5348;
import net.minecraft.class_5481;

public class ChatSetting
extends Module {
    public final StringSetting end;
    public static ChatSetting INSTANCE;
    public final SliderSetting animateTime;
    public final StringSetting hackName;
    public final ColorSetting pulse;
    public final SliderSetting pulseCounter;
    public final StringSetting start;
    public final ColorSetting color;
    public final BooleanSetting keepHistory;
    public final SliderSetting pulseSpeed;
    public final EnumSetting<FadeUtils.Quad> animQuad;
    public final EnumSetting<Style> messageStyle;
    public final EnumSetting<code> messageCode;
    public final SliderSetting animateOffset;
    public final BooleanSetting infiniteChat;
    public static final HashMap<class_5481, class_5348> chatMessage;

    public ChatSetting() {
        ChatSetting a;
        ChatSetting chatSetting = a;
        super(Snow.ALLATORIxDEMO("N}cOouyojh"), Module.Category.Client);
        ChatSetting chatSetting2 = a;
        chatSetting2.hackName = chatSetting.add(new StringSetting(TipUtils.ALLATORIxDEMO("\u0012\u0012{\\"), Snow.ALLATORIxDEMO("_}y}Imdcj{")));
        chatSetting.color = chatSetting.add(new ColorSetting(TipUtils.ALLATORIxDEMO("-3\u001fyK"), new Color(227, 154, 154)));
        chatSetting.pulse = chatSetting.add(new ColorSetting(Snow.ALLATORIxDEMO("Qxjwj"), new Color(0, 0, 0)).injectBoolean(true));
        chatSetting.pulseSpeed = chatSetting.add(new SliderSetting(TipUtils.ALLATORIxDEMO(")4\u0000,=,\u0016s]"), 1.0, 0.0, 5.0, 0.1, object -> {
            Object a = object;
            ChatSetting a2 = this;
            return a2.pulse.booleanValue;
        }));
        a.pulseCounter = a.add(new SliderSetting(Snow.ALLATORIxDEMO("_etcra}"), 10, 1, 50, object -> {
            Object a = object;
            ChatSetting a2 = this;
            return a2.pulse.booleanValue;
        }));
        ChatSetting chatSetting3 = a;
        chatSetting3.animateTime = chatSetting3.add(new SliderSetting(TipUtils.ALLATORIxDEMO("\u0007\u0007(\u0003\b\u001a{\\"), 300, 0, 1000));
        chatSetting3.animateOffset = chatSetting3.add(new SliderSetting(Snow.ALLATORIxDEMO("Vr~qEgkua{"), -40, -200, 100));
        chatSetting3.animQuad = chatSetting3.add(new EnumSetting<FadeUtils.Quad>(TipUtils.ALLATORIxDEMO("\r\u0006w]"), FadeUtils.Quad.In));
        chatSetting3.keepHistory = chatSetting3.add(new BooleanSetting(Snow.ALLATORIxDEMO("FrygTcryivv"), true));
        chatSetting3.infiniteChat = chatSetting3.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("]U'\u0007(\u00005\u000b\u001f\u001bwM"), true));
        chatSetting3.messageStyle = chatSetting3.add(new EnumSetting<Style>(Snow.ALLATORIxDEMO("Khdov{oRyhj"), Style.Mio));
        chatSetting3.messageCode = chatSetting3.add(new EnumSetting<code>(TipUtils.ALLATORIxDEMO("v$\u001d5\b&\u000b\u001f\u001cr\\"), code.Mio));
        chatSetting3.start = chatSetting3.add(new StringSetting(Snow.ALLATORIxDEMO("Oc}xuNi`j"), TipUtils.ALLATORIxDEMO("b"), object -> {
            Object a = object;
            ChatSetting a2 = this;
            return a2.messageCode.getValue() == code.Custom;
        }));
        a.end = a.add(new StringSetting(Snow.ALLATORIxDEMO("YdeNi`j"), TipUtils.ALLATORIxDEMO("d"), object -> {
            Object a = object;
            ChatSetting a2 = this;
            return a2.messageCode.getValue() == code.Custom;
        }));
        ChatSetting chatSetting4 = a;
        chatSetting4.setChinese(Snow.ALLATORIxDEMO("\u8047\u592f\u8bba\u7f61"));
        INSTANCE = chatSetting4;
    }

    static {
        chatMessage = new HashMap();
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void disable() {
        a.state = true;
    }

    @Override
    public void enable() {
        a.state = true;
    }

    public static final class Style
    extends Enum<Style> {
        public static final /* enum */ Style None;
        public static final /* enum */ Style Mio;
        private static final /* synthetic */ Style[] $VALUES;
        public static final /* enum */ Style Future;
        public static final /* enum */ Style Basic;
        public static final /* enum */ Style Moon;
        public static final /* enum */ Style Earth;

        /*
         * Exception decompiling
         */
        private /* synthetic */ Style() {
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

        public static Style valueOf(String a) {
            return Enum.valueOf(Style.class, a);
        }

        private static /* synthetic */ Style[] $values() {
            Style[] arrstyle = new Style[6];
            arrstyle[0] = Mio;
            arrstyle[1] = Basic;
            arrstyle[2] = Future;
            arrstyle[3] = Earth;
            arrstyle[4] = Moon;
            arrstyle[5] = None;
            return arrstyle;
        }

        static {
            Mio = new Style(CameraState.ALLATORIxDEMO("q0Z"), 0);
            Basic = new Style(TimerManager.ALLATORIxDEMO("\t\u0005%G"), 1);
            Future = new Style(CameraState.ALLATORIxDEMO("\u0003\\$I+P"), 2);
            Earth = new Style(TimerManager.ALLATORIxDEMO("\u000e\u0005$Zt"), 3);
            Moon = new Style(CameraState.ALLATORIxDEMO("\u001dS6["), 4);
            None = new Style(TimerManager.ALLATORIxDEMO("*9@y"), 5);
            $VALUES = Style.$values();
        }

        public static Style[] values() {
            return (Style[])$VALUES.clone();
        }
    }

    public static final class code
    extends Enum<code> {
        public static final /* enum */ code Earth;
        public static final /* enum */ code None;
        private static final /* synthetic */ code[] $VALUES;
        public static final /* enum */ code Mio;
        public static final /* enum */ code Custom;

        private static /* synthetic */ code[] $values() {
            code[] arrcode = new code[4];
            arrcode[0] = Mio;
            arrcode[1] = Earth;
            arrcode[2] = Custom;
            arrcode[3] = None;
            return arrcode;
        }

        public static code[] values() {
            return (code[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ code() {
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
            Mio = new code(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u001cm?"), 0);
            Earth = new code(GaussianFilter.ALLATORIxDEMO("f3Ll\u001c"), 1);
            Custom = new code(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("M/v%k="), 2);
            None = new code(GaussianFilter.ALLATORIxDEMO("\u001cQv\u0011"), 3);
            $VALUES = code.$values();
        }

        public static code valueOf(String a) {
            return Enum.valueOf(code.class, a);
        }
    }

}
