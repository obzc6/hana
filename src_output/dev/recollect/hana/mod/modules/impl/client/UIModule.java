/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.BooleanComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.ColorComponents;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.ModuleComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.SliderComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.Renderer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.bytedeco.javacv.BaseSettings;

public class UIModule
extends Module {
    public final BooleanSetting showBYD;
    public final ColorSetting color;
    public final ColorSetting mhColor;
    public static final FadeUtils fade = new FadeUtils(300L);
    int lastHeight;
    public final EnumSetting<Mode> mode;
    public final BooleanSetting customFont;
    public final ColorSetting sbgColor;
    public final ColorSetting mbgColor;
    public final SliderSetting booleanSpeed;
    public final ColorSetting gearColor;
    public final ColorSetting mainHover;
    private final EnumSetting<Pages> page;
    public final BooleanSetting chinese;
    public final SliderSetting sliderSpeed;
    public final BooleanSetting snow;
    public final BooleanSetting newsnow;
    public final SliderSetting animationSpeed;
    public final ColorSetting moduleEnable;
    public final ColorSetting categoryEnd;
    public final ColorSetting bgColor;
    public final BooleanSetting scissor;
    public final ColorSetting moduleEnd;
    public static UIModule INSTANCE;
    public final ColorSetting bindC;
    public final EnumSetting<AnimateUtil.AnimMode> animMode;
    public final ColorSetting shColor;
    public final SliderSetting height;
    public final EnumSetting<BYDMode> bydMode;
    public final ColorSetting disableText;
    public final ColorSetting enableText;

    @Override
    public void onDisable() {
        if (UIModule.mc.field_1755 instanceof ClickGuiScreen) {
            mc.method_1507(null);
        }
    }

    public UIModule() {
        UIModule a;
        UIModule uIModule = a;
        super(Renderer.ALLATORIxDEMO("Y\u000bt\u0003k:?^"), Module.Category.Client);
        UIModule uIModule2 = a;
        uIModule2.page = uIModule.add(new EnumSetting<Pages>(Hole.ALLATORIxDEMO("3{N5"), Pages.General));
        uIModule.animMode = uIModule.add(new EnumSetting<AnimateUtil.AnimMode>(Renderer.ALLATORIxDEMO("[\tt\rM\u0012.R"), AnimateUtil.AnimMode.None, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.height = a.add(new SliderSetting(Hole.ALLATORIxDEMO("6b\n}A$"), 16.0, 10.0, 20.0, 1.0, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.bindC = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("X\u000es\u0004T\u00182C"), new Color(255, 255, 255), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }).injectBoolean(true));
        a.gearColor = a.add(new ColorSetting(Hole.ALLATORIxDEMO("$H\""), new Color(150, 150, 150), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }).injectBoolean(true));
        a.mode = a.add(new EnumSetting<Mode>(Renderer.ALLATORIxDEMO("X\u000e{\u0005q\u0005A\u0013#Z"), Mode.Reset, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.scissor = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("S\u001dn\u0010iF\""), true, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.snow = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("S\u0013%@"), false, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.newsnow = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("N\u001bp0tF'"), false, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.showBYD = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("V\u0001w\u001c#^"), false, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }).setParent());
        a.bydMode = a.add(new EnumSetting<BYDMode>(Hole.ALLATORIxDEMO(".uM5"), BYDMode.gun, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General && a2.showBYD.isOpen();
        }));
        a.animationSpeed = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("P\u0002!X|\u0014s\bs3p\u0018/S"), 0.2, 0.01, 2.0, 0.01, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.sliderSpeed = a.add(new SliderSetting(Hole.ALLATORIxDEMO("\u0001\u0012n\u001de\fT\u0013L4"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.booleanSpeed = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("\nZr\f\u0006s3p\u0018/S"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.customFont = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("=r\nt\u0011j%uG$"), false, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        a.color = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("M\u001c#Y"), new Color(255, 255, 255), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.mainHover = a.add(new ColorSetting(Hole.ALLATORIxDEMO("J\u0018i\u0010O\flL\""), new Color(255, 255, 255), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.categoryEnd = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("v|\u0014\u0000r\u0012y8$S"), -2113929216, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }).injectBoolean(true));
        a.disableText = a.add(new ColorSetting(Hole.ALLATORIxDEMO("\u0016\u0017t\u0018b\u0012b7Q$"), new Color(255, 255, 255), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.enableText = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("X\u000e{\u0005q\u0005T\u00182C"), new Color(255, 255, 255), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.mbgColor = a.add(new ColorSetting(Hole.ALLATORIxDEMO("3h\u0007oE5"), new Color(63, 63, 63, 42), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.moduleEnd = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("-u\u0003h\fe8$S"), -2113929216, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }).injectBoolean(true));
        a.moduleEnable = a.add(new ColorSetting(Hole.ALLATORIxDEMO("f=\u001ar\u0015e;i\u0002xE5"), new Color(254, 254, 255), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.mhColor = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("xr\u0004o\u000bx(o\u000b/E"), new Color(152, 152, 152, 123), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.sbgColor = a.add(new ColorSetting(Hole.ALLATORIxDEMO("S\u001bs\u0017sG7"), new Color(24, 24, 24, 0), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.shColor = a.add(new ColorSetting(Renderer.ALLATORIxDEMO("\u001bPi\u0014s\tz(o\u000b/E"), new Color(152, 152, 152, 123), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.bgColor = a.add(new ColorSetting(Hole.ALLATORIxDEMO("<f\u001ak\u0019u\foG4"), new Color(24, 24, 24, 42), object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.Color;
        }));
        a.chinese = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("$u\tn\u00189R"), false, object -> {
            Object a = object;
            UIModule a2 = this;
            return a2.page.getValue() == Pages.General;
        }));
        UIModule uIModule3 = a;
        uIModule3.setChinese(Hole.ALLATORIxDEMO("\u83f5\u5305"));
        INSTANCE = uIModule3;
    }

    @Override
    public void onEnable() {
        UIModule uIModule;
        UIModule uIModule2 = uIModule = this;
        if (uIModule2.lastHeight != uIModule2.height.getValueInt()) {
            for (ClickGuiTab clickGuiTab : Hana.GUI.tabs) {
                Iterator<Component> iterator = clickGuiTab.getChildren().iterator();
                while (iterator.hasNext()) {
                    Iterator<Component> iterator2;
                    Component component = iterator2.next();
                    if (component instanceof ModuleComponent) {
                        Object object = ((ModuleComponent)component).getSettingsList().iterator();
                        while (object.hasNext()) {
                            Iterator<Component> a;
                            Component component2 = (Component)a.next();
                            object = a;
                            component2.setHeight(uIModule.height.getValueInt());
                            component2.defaultHeight = uIModule.height.getValueInt();
                        }
                    }
                    UIModule uIModule3 = uIModule;
                    component.setHeight(uIModule3.height.getValueInt());
                    component.defaultHeight = uIModule3.height.getValueInt();
                    iterator = iterator2;
                }
            }
            uIModule.lastHeight = uIModule.height.getValueInt();
        }
        if (uIModule.mode.getValue() == Mode.Reset) {
            Iterator<ClickGuiTab> iterator = Hana.GUI.tabs.iterator();
            Iterator<ClickGuiTab> iterator3 = iterator;
            while (iterator3.hasNext()) {
                ClickGuiTab clickGuiTab;
                clickGuiTab = iterator.next();
                for (Component component : clickGuiTab.getChildren()) {
                    component.currentOffset = 0.0;
                    if (!(component instanceof ModuleComponent)) continue;
                    ((ModuleComponent)component).isPopped = false;
                    for (Component component2 : ((ModuleComponent)component).getSettingsList()) {
                        component2.currentOffset = 0.0;
                        if (component2 instanceof SliderComponent) {
                            ((SliderComponent)component2).renderSliderPosition = 0.0;
                            continue;
                        }
                        if (component2 instanceof BooleanComponent) {
                            ((BooleanComponent)component2).currentWidth = 0.0;
                            continue;
                        }
                        if (!(component2 instanceof ColorComponents)) continue;
                        ((ColorComponents)component2).currentWidth = 0.0;
                    }
                }
                clickGuiTab.currentHeight = 0.0;
                iterator3 = iterator;
            }
        }
        Notify.notifyList.clear();
        fade.reset();
        if (UIModule.nullCheck()) {
            uIModule.disable();
            return;
        }
        mc.method_1507((class_437)GuiManager.clickGui);
    }

    @Override
    public void onUpdate() {
        UIModule a;
        if (a.chinese.getValue()) {
            a.customFont.setValue(false);
        }
        if (!(UIModule.mc.field_1755 instanceof ClickGuiScreen)) {
            a.disable();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static UIModule getInstance() {
        if (INSTANCE != null) return INSTANCE;
        Class<UIModule> class_ = UIModule.class;
        synchronized (UIModule.class) {
            if (INSTANCE != null) return INSTANCE;
            {
                INSTANCE = new UIModule();
            }
            // ** MonitorExit[var0] (shouldn't be in output)
            return INSTANCE;
        }
    }

    private static final class Pages
    extends Enum<Pages> {
        private static final /* synthetic */ Pages[] $VALUES;
        public static final /* enum */ Pages General = new Pages(BaseSettings.ALLATORIxDEMO("J[eY{Ks"), 0);
        public static final /* enum */ Pages Color = new Pages(GaussianFilter.ALLATORIxDEMO("`=Rw\u0006"), 1);

        public static Pages valueOf(String a) {
            return Enum.valueOf(Pages.class, a);
        }

        static {
            $VALUES = Pages.$values();
        }

        public static Pages[] values() {
            return (Pages[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Pages() {
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

        private static /* synthetic */ Pages[] $values() {
            Pages[] arrpages = new Pages[2];
            arrpages[0] = General;
            arrpages[1] = Color;
            return arrpages;
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Reset;
        public static final /* enum */ Mode Scissor;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Pull;
        public static final /* enum */ Mode Scale;
        public static final /* enum */ Mode None;

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

        static {
            Scale = new Mode(ColorUtil.ALLATORIxDEMO("H#gf)"), 0);
            Pull = new Mode(Renderer.ALLATORIxDEMO("P\b&["), 1);
            Scissor = new Mode(ColorUtil.ALLATORIxDEMO("O>r3ue>"), 2);
            Reset = new Mode(Renderer.ALLATORIxDEMO("2e\u000e/C"), 3);
            None = new Mode(ColorUtil.ALLATORIxDEMO("\u000eid)"), 4);
            $VALUES = Mode.$values();
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[5];
            arrmode[0] = Scale;
            arrmode[1] = Pull;
            arrmode[2] = Scissor;
            arrmode[3] = Reset;
            arrmode[4] = None;
            return arrmode;
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }
    }

    public static final class BYDMode
    extends Enum<BYDMode> {
        public static final /* enum */ BYDMode madcat = new BYDMode(ObsidianHelper.ALLATORIxDEMO("N)L H6"), 0);
        public static final /* enum */ BYDMode gun = new BYDMode(TimeHelper.ALLATORIxDEMO("\u0018\u0002["), 1);
        public static final /* enum */ BYDMode little = new BYDMode(ObsidianHelper.ALLATORIxDEMO("O!\\7E'"), 2);
        private static final /* synthetic */ BYDMode[] $VALUES;

        static {
            $VALUES = BYDMode.$values();
        }

        private static /* synthetic */ BYDMode[] $values() {
            BYDMode[] arrbYDMode = new BYDMode[3];
            arrbYDMode[0] = madcat;
            arrbYDMode[1] = gun;
            arrbYDMode[2] = little;
            return arrbYDMode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ BYDMode() {
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

        public static BYDMode[] values() {
            return (BYDMode[])$VALUES.clone();
        }

        public static BYDMode valueOf(String a) {
            return Enum.valueOf(BYDMode.class, a);
        }
    }

}
