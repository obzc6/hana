/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.video.FileUtil;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import org.bytedeco.javacv.FrameConverter;
import org.bytedeco.javacv.FrameFilter;

public class Notify
extends Module {
    private final ColorSetting fillcolor;
    public static final ArrayList<Notifys> notifyList = new ArrayList();
    private final SliderSetting notifyY;
    public static Notify INSTANCE;
    private final ColorSetting accentColor;
    public final EnumSetting<Notifys.mode> mode;
    public final EnumSetting<Notifys.type> type;
    private final ColorSetting linecolor;
    public final SliderSetting notifyX;

    @Override
    public void onUpdate() {
        Iterator<Notifys> a;
        Notify notify = a;
        if (UIModule.INSTANCE.state) {
            return;
        }
        a = notifyList.iterator();
        block0 : do {
            Iterator<Notifys> iterator = a;
            while (iterator.hasNext()) {
                Notifys notifys = (Notifys)a.next();
                if (notifys == null || notifys.first == null) continue block0;
                if (notifys.firstFade == null) {
                    iterator = a;
                    continue;
                }
                --notifys.delayed;
                iterator = a;
            }
            break;
        } while (true);
    }

    public Notify() {
        Notify a;
        Notify notify = a;
        Notify notify2 = a;
        super(BetterDynamicAnimation.ALLATORIxDEMO("`uU|Xs"), Snow.ALLATORIxDEMO("hcs~zs!Qkie"), Module.Category.Client);
        Notify notify3 = a;
        notify3.type = notify2.add(new EnumSetting<Notifys.type>(BetterDynamicAnimation.ALLATORIxDEMO("ulNo"), Notifys.type.Notify));
        notify2.mode = notify2.add(new EnumSetting<Notifys.mode>(Snow.ALLATORIxDEMO("Qwjt"), Notifys.mode.Fill));
        notify2.notifyY = notify2.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("S"), 18, -50, 500));
        notify2.fillcolor = notify2.add(new ColorSetting(Snow.ALLATORIxDEMO("A~pfBjbuc"), new Color(20, 20, 20, 100)));
        notify2.linecolor = notify2.add(new ColorSetting(BetterDynamicAnimation.ALLATORIxDEMO("PZiKYNyQx"), new Color(140, 140, 250, 225)));
        notify2.accentColor = notify2.add(new ColorSetting(Snow.ALLATORIxDEMO("godrr~Bjbuc"), new Color(255, 100, 100, 255)));
        notify.notifyX = notify2.add(new SliderSetting(BetterDynamicAnimation.ALLATORIxDEMO("iAnHsGR"), 256, 18, 500));
        notify.setChinese(Snow.ALLATORIxDEMO("\u9000\u77f4"));
        INSTANCE = notify;
    }

    @Override
    public void onRender2D(class_332 a4, float a22) {
        Notifys a3;
        Notify notify = a3;
        boolean a22 = true;
        int n = (int)(379.0 - notify.notifyY.getValue());
        int n2 = notify.notifyX.getValueInt() + 500;
        if (!notifyList.isEmpty()) {
            a3 = notifyList.get(0);
            if (a3 == null || a3.first == null || a3.firstFade == null || a3.delayed < 1) {
                notifyList.remove(0);
                return;
            }
            a22 = false;
            if (a3.delayed < 5 && !a3.end) {
                a3.end = true;
                a3.endFade.reset();
            }
            Object object = a3;
            String string = ((Notifys)object).first;
            double d = ((Notifys)object).delayed < 5 ? (double)n2 - (double)(Notify.mc.field_1772.method_1727(string) + 10) * (1.0 - a3.endFade.easeOutQuad()) : (double)n2 - (double)(Notify.mc.field_1772.method_1727(string) + 10) * a3.firstFade.easeOutQuad();
            class_332 class_3322 = a4;
            Object object2 = a3;
            class_332 class_3323 = a4;
            Render2DUtil.drawRect(class_3323.method_51448(), (float)((int)d + 5), (float)n, (float)(10 + Notify.mc.field_1772.method_1727(string)), 15.0f, notify.fillcolor.getValue());
            Render2DUtil.drawRect(class_3323.method_51448(), (float)((int)d) + 2.0f, (float)(n + 14), (float)((10 + Notify.mc.field_1772.method_1727(string)) * (a3.delayed - 4) - 2) / 62.0f, 1.0f, notify.linecolor.getValue());
            int a4 = (int)class_3532.method_16436((double)((Notifys)object2).accentFade.easeOutQuad(), (double)(10 + Notify.mc.field_1772.method_1727(string)), (double)5.0);
            Render2DUtil.drawRect(class_3322.method_51448(), (float)((int)d), (float)n, (float)a4, 15.0f, notify.accentColor.getValue());
            class_3322.method_51433(Notify.mc.field_1772, string, 5 + (int)d + a4, 4 + n, new Color(255, 255, 255, 255).getRGB(), true);
            if (((Notifys)object2).delayed < 5) {
                n = (int)((double)n + 18.0 * a3.yFade.easeOutQuad() - 18.0 * (1.0 - a3.endFade.easeOutQuad()));
            }
        }
        if (a22) {
            notifyList.clear();
        }
    }

    public static void addNotification(String string, Notifys.icon icon2) {
        Object a = icon2;
        String a2 = string;
        notifyList.add(new Notifys(a2, (Notifys.icon)((Object)a)));
    }

    @Override
    public void onDisable() {
        notifyList.clear();
    }

    public static class Notifys {
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
        public Notifys(String string, icon icon2) {
            void a;
            Notifys a2;
            Object a3 = icon2;
            Notifys notifys = a2 = this;
            Notifys notifys2 = a2;
            notifys2.firstFade = new FadeUtils(500L);
            notifys.yFade = new FadeUtils(500L);
            notifys.accentFade = new FadeUtils(500L);
            notifys.delayed = 55;
            a2.endFade = new FadeUtils(350L);
            a2.first = a;
            a2.firstFade.reset();
            a2.yFade.reset();
            a2.endFade.reset();
            a2.accentFade.reset();
            a2.end = false;
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

}
