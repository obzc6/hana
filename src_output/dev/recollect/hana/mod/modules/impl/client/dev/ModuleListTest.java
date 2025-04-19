/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;

public class ModuleListTest
extends Module {
    private final ColorSetting endColor;
    private final SliderSetting pulseCounter;
    private final Timer timer;
    private final SliderSetting foldSpeed;
    private final BooleanSetting font;
    public final SliderSetting disableSpeed;
    private final BooleanSetting bgSync;
    private final SliderSetting height;
    private final BooleanSetting rect;
    private final SliderSetting pulseSpeed;
    private final ColorSetting bgColor;
    int progress;
    private final SliderSetting yOffset;
    private final BooleanSetting down;
    private final SliderSetting fadeSpeed;
    public final EnumSetting<AnimateUtil.AnimMode> animMode;
    private final BooleanSetting space;
    private final SliderSetting saturation;
    public final SliderSetting ySpeed;
    private final BooleanSetting onlyBind;
    private final SliderSetting rainbowDelay;
    private final BooleanSetting forgeHax;
    private final BooleanSetting animY;
    private final BooleanSetting scissor;
    public final SliderSetting enableSpeed;
    private List<Modules> modulesList;
    boolean update;
    private boolean aBoolean;
    private final SliderSetting xOffset;
    private final ColorSetting color;
    public static ModuleListTest INSTANCE;
    private final EnumSetting<ColorMode> colorMode;
    private final BooleanSetting fold;
    private final BooleanSetting fade;
    private final BooleanSetting preY;
    private final BooleanSetting backGround;
    private final SliderSetting textOffset;
    private final SliderSetting rainbowSpeed;

    private /* synthetic */ Color rainbow(int n) {
        int a = n;
        ModuleListTest a2 = this;
        if (a2.colorMode.getValue() == ColorMode.Pulse) {
            return ColorUtil.pulseColor(a2.color.getValue(), a2.endColor.getValue(), a, a2.pulseCounter.getValueInt(), a2.pulseSpeed.getValue());
        }
        if (a2.colorMode.getValue() == ColorMode.Rainbow) {
            return Color.getHSBColor((float)(Math.ceil(((double)a2.progress + (double)a * a2.rainbowDelay.getValue()) / 20.0) % 360.0 / 360.0), a2.saturation.getValueFloat() / 255.0f, 1.0f);
        }
        return a2.color.getValue();
    }

    private /* synthetic */ int getColor(int n) {
        int a = n;
        ModuleListTest a2 = this;
        if (a2.colorMode.getValue() != ColorMode.Custom) {
            return a2.rainbow(a).getRGB();
        }
        return a2.color.getValue().getRGB();
    }

    @Override
    public void onRender2D(class_332 a, float a2) {
        Modules a3;
        Modules modules2;
        ModuleListTest moduleListTest = a3;
        if (moduleListTest.space.getValue() != moduleListTest.aBoolean) {
            Iterator<Modules> iterator = a2 = moduleListTest.modulesList.iterator();
            while (iterator.hasNext()) {
                modules2 = a2.next();
                iterator = a2;
                modules2.updateName();
            }
            moduleListTest.aBoolean = moduleListTest.space.getValue();
        }
        Iterator<Modules> iterator = a2 = moduleListTest.modulesList.iterator();
        while (iterator.hasNext()) {
            modules2 = a2.next();
            iterator = a2;
            modules2.update();
        }
        if (moduleListTest.update) {
            moduleListTest.modulesList = moduleListTest.modulesList.stream().sorted(Comparator.comparing(modules -> {
                Modules a = modules;
                ModuleListTest a2 = this;
                return a2.getStringWidth(a.name) * -1;
            })).collect(Collectors.toList());
            moduleListTest.update = false;
        }
        if (moduleListTest.timer.passed(25L)) {
            ModuleListTest moduleListTest2 = moduleListTest;
            moduleListTest.progress -= moduleListTest2.rainbowSpeed.getValueInt();
            moduleListTest2.timer.reset();
        }
        int n = a2 = moduleListTest.down.getValue() ? mc.method_22683().method_4502() - moduleListTest.yOffset.getValueInt() - moduleListTest.getFontHeight() : moduleListTest.yOffset.getValueInt();
        int n2 = 20;
        Iterator<Modules> iterator2 = moduleListTest.modulesList.iterator();
        block2 : do {
            Iterator<Modules> iterator3 = iterator2;
            while (iterator3.hasNext()) {
                ModuleListTest moduleListTest3;
                Modules modules3;
                Modules modules4;
                a3 = iterator2.next();
                if (a3.module.isOn() && a3.module.drawnSetting.getValue() && (!moduleListTest.onlyBind.getValue() || a3.module.getBind().getKey() != -1)) {
                    Object object = a3;
                    modules3 = object;
                    ((Modules)object).enable();
                } else {
                    Modules modules5 = a3;
                    modules3 = modules5;
                    modules5.disable();
                }
                if (modules3.isEnabled) {
                    Modules modules6;
                    Modules modules7 = a3;
                    if (moduleListTest.fade.getValue()) {
                        modules7.fade = moduleListTest.animate(a3.fade, 1.0, moduleListTest.fadeSpeed.getValue());
                        modules6 = a3;
                    } else {
                        modules7.fade = 1.0;
                        modules6 = a3;
                    }
                    modules6.fold = 1.0;
                    Modules modules8 = a3;
                    modules4 = modules8;
                    ModuleListTest moduleListTest4 = moduleListTest;
                    modules8.x = moduleListTest.animate(modules8.x, moduleListTest4.getStringWidth(moduleListTest4.getSuffix(a3.name)), moduleListTest.enableSpeed.getValue());
                } else {
                    Modules modules9;
                    Modules modules10 = a3;
                    if (moduleListTest.fade.getValue()) {
                        modules10.fade = moduleListTest.animate(a3.fade, 0.08, moduleListTest.fadeSpeed.getValue());
                        modules9 = a3;
                    } else {
                        modules10.fade = 1.0;
                        modules9 = a3;
                    }
                    modules9.fold = moduleListTest.animate(a3.fold, -0.1, moduleListTest.foldSpeed.getValue());
                    Object object = a3;
                    ((Modules)object).x = moduleListTest.animate(((Modules)object).x, -1.0, moduleListTest.disableSpeed.getValue());
                    if (((Modules)object).x <= 0.0 || a3.fade <= 0.084 || moduleListTest.fold.getValue() && a3.fold <= 0.0) {
                        a3.hide = true;
                        iterator3 = iterator2;
                        continue;
                    }
                    modules4 = a3;
                }
                if (modules4.hide) {
                    Object object = a3;
                    a3.updateName();
                    ((Modules)object).x = 0.0;
                    ((Modules)object).y = moduleListTest.animY.getValue() ? (double)a2 : (double)n;
                    Object object2 = a3;
                    ((Modules)object2).nameUpdated = false;
                    ((Modules)object2).hide = false;
                }
                if (a3.nameUpdated) {
                    Object object = a3;
                    ((Modules)object).nameUpdated = false;
                    ((Modules)object).y = moduleListTest.animY.getValue() && !a3.isEnabled ? (double)a2 : (double)n;
                } else {
                    double d;
                    ModuleListTest moduleListTest5;
                    ModuleListTest moduleListTest6 = moduleListTest;
                    if (moduleListTest6.animY.getValue() && !a3.isEnabled) {
                        d = a2;
                        moduleListTest5 = moduleListTest;
                    } else {
                        d = n;
                        moduleListTest5 = moduleListTest;
                    }
                    a3.y = moduleListTest6.animate(a3.y, d, moduleListTest5.ySpeed.getValue());
                }
                ++n2;
                int n3 = (int)((double)mc.method_22683().method_4486() - a3.x - moduleListTest.xOffset.getValue() - (double)(moduleListTest.rect.getValue() ? 2 : 0));
                if (moduleListTest.fold.getValue()) {
                    class_332 class_3322 = a;
                    class_3322.method_51448().method_22903();
                    class_3322.method_51448().method_22904(0.0, a3.y * (1.0 - a3.fold), 0.0);
                    class_3322.method_51448().method_22905(1.0f, (float)a3.fold, 1.0f);
                }
                if (moduleListTest.scissor.getValue()) {
                    GL11.glEnable((int)3089);
                    GL11.glScissor((int)0, (int)0, (int)((mc.method_22683().method_4480() / 2 - moduleListTest.xOffset.getValueInt() - (moduleListTest.rect.getValue() ? 2 : 0)) * 2), (int)mc.method_22683().method_4507());
                }
                if (moduleListTest.backGround.getValue()) {
                    ModuleListTest moduleListTest7 = moduleListTest;
                    Render2DUtil.drawRect(a.method_51448(), (float)(n3 - 1), (float)((int)a3.y), (float)mc.method_22683().method_4486() - (float)moduleListTest.xOffset.getValueInt() + 1.0f - (float)n3 + 1.0f, (float)(moduleListTest.getFontHeight() + moduleListTest.height.getValueInt()), moduleListTest.bgSync.getValue() ? ColorUtil.injectAlpha(moduleListTest7.getColor(n2), (int)((double)moduleListTest.bgColor.getValue().getAlpha() * a3.fade)) : ColorUtil.injectAlpha(moduleListTest7.bgColor.getValue().getRGB(), (int)((double)moduleListTest.bgColor.getValue().getAlpha() * a3.fade)));
                }
                if (moduleListTest.font.getValue()) {
                    FontRenderers.Arial.drawString(a.method_51448(), moduleListTest.getSuffix(a3.name), n3, (int)(a3.y + 1.0 + (double)moduleListTest.textOffset.getValueInt()), ColorUtil.injectAlpha(moduleListTest.getColor(n2), (int)(255.0 * a3.fade)));
                    moduleListTest3 = moduleListTest;
                } else {
                    a.method_25303(ModuleListTest.mc.field_1772, moduleListTest.getSuffix(a3.name), n3, (int)(a3.y + 1.0 + (double)moduleListTest.textOffset.getValueInt()), ColorUtil.injectAlpha(moduleListTest.getColor(n2), (int)(255.0 * a3.fade)));
                    moduleListTest3 = moduleListTest;
                }
                if (moduleListTest3.scissor.getValue()) {
                    GL11.glDisable((int)3089);
                }
                if (moduleListTest.fold.getValue()) {
                    a.method_51448().method_22909();
                }
                if (moduleListTest.rect.getValue()) {
                    Render2DUtil.drawRect(a.method_51448(), (float)mc.method_22683().method_4486() - (float)moduleListTest.xOffset.getValueInt() - 1.0f, (float)((int)a3.y), 1.0f, (float)(moduleListTest.getFontHeight() + moduleListTest.height.getValueInt()), ColorUtil.injectAlpha(moduleListTest.getColor(n2), (int)(255.0 * a3.fade)));
                }
                if (!a3.isEnabled && moduleListTest.preY.getValue()) continue block2;
                int n4 = n;
                if (moduleListTest.down.getValue()) {
                    n = n4 - (moduleListTest.getFontHeight() + moduleListTest.height.getValueInt());
                    continue block2;
                }
                n = n4 + (moduleListTest.getFontHeight() + moduleListTest.height.getValueInt());
                continue block2;
            }
            break;
        } while (true);
    }

    @Override
    public void onEnable() {
        Object a;
        ModuleListTest moduleListTest = a;
        moduleListTest.modulesList.clear();
        Object object = a = Hana.MODULE.modules.iterator();
        while (object.hasNext()) {
            Module module = (Module)a.next();
            object = a;
            moduleListTest.modulesList.add(new Modules(moduleListTest, module));
        }
    }

    private /* synthetic */ int getStringWidth(String string) {
        String a = string;
        ModuleListTest a2 = this;
        if (a2.font.getValue()) {
            return (int)FontRenderers.Arial.getWidth(a);
        }
        return ModuleListTest.mc.field_1772.method_1727(a);
    }

    private /* synthetic */ int getFontHeight() {
        ModuleListTest a;
        if (a.font.getValue()) {
            return (int)FontRenderers.Arial.getFontHeight();
        }
        Objects.requireNonNull(ModuleListTest.mc.field_1772);
        return 9;
    }

    private /* synthetic */ String getSuffix(String string) {
        String a = string;
        ModuleListTest a2 = this;
        if (a2.forgeHax.getValue()) {
            return (String)a + "\u00a7r<";
        }
        return a;
    }

    public double animate(double a, double a2, double a3) {
        ModuleListTest a4;
        if (a3 >= 1.0) {
            return a2;
        }
        if (a3 == 0.0) {
            return a;
        }
        return AnimateUtil.animate(a, a2, a3, a4.animMode.getValue());
    }

    public ModuleListTest() {
        ModuleListTest a;
        ModuleListTest moduleListTest = a;
        super(OnlineUserInfo.ALLATORIxDEMO("d1W1X&X\nV&g!G7"), Module.Category.Client);
        ModuleListTest moduleListTest2 = a;
        moduleListTest2.font = moduleListTest.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("FCi_"), false));
        moduleListTest.height = moduleListTest.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("m7Z#\\7"), 0, -2, 10));
        moduleListTest.textOffset = moduleListTest.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("SN_Y\\f_b_"), 0, 0, 10));
        moduleListTest.xOffset = moduleListTest.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO(";j4U7Q7"), 0, 0, 500));
        moduleListTest.yOffset = moduleListTest.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("RY\\f_b_"), 10, 0, 300));
        moduleListTest.animMode = moduleListTest.add(new EnumSetting<AnimateUtil.AnimMode>(OnlineUserInfo.ALLATORIxDEMO("U\rL?~+P&"), AnimateUtil.AnimMode.Mio));
        moduleListTest.disableSpeed = moduleListTest.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("DEtJEgsipIbO"), 0.2, -0.2, 1.0, 0.01));
        moduleListTest.enableSpeed = moduleListTest.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0001Z\"v\u000f@\u0001C!Q'"), 0.2, 0.0, 1.0, 0.01));
        moduleListTest.ySpeed = moduleListTest.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("OipIbO"), 0.2, 0.01, 1.0, 0.01));
        moduleListTest.forgeHax = moduleListTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("R\fW5V\fU;"), true));
        moduleListTest.space = moduleListTest.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("ipMdN"), true));
        moduleListTest.down = moduleListTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("w+C-"), false));
        moduleListTest.animY = moduleListTest.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("{nEjr"), true));
        moduleListTest.scissor = moduleListTest.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("0F;@7[1"), false));
        moduleListTest.onlyBind = moduleListTest.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("hezCBEiO"), true));
        moduleListTest.colorMode = moduleListTest.add(new EnumSetting<ColorMode>(OnlineUserInfo.ALLATORIxDEMO("\u0000{\u000fJ ~+P&"), ColorMode.Pulse));
        moduleListTest.rainbowSpeed = moduleListTest.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("RMnEEdaipIbO"), 200, 1, 500, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow;
        }));
        a.saturation = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("g\"`\u0016W3G-[-"), 130.0, 1.0, 255.0, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow;
        }));
        a.pulseSpeed = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("W^KxsipIbO"), 1.0, 0.0, 5.0, 0.1, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() == ColorMode.Pulse;
        }));
        a.pulseCounter = a.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO(" J']0Q1"), 10, 1, 50, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() == ColorMode.Pulse;
        }));
        a.rainbowDelay = a.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("~e@fR"), 350, 0, 600, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow;
        }));
        a.color = a.add(new ColorSetting(OnlineUserInfo.ALLATORIxDEMO("\u0011\\([1"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() != ColorMode.Rainbow;
        }));
        a.endColor = a.add(new ColorSetting(BOEntityUtils.ALLATORIxDEMO("beryo@hY"), new Color(255, 0, 0, 255), object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.colorMode.getValue() == ColorMode.Pulse;
        }));
        ModuleListTest moduleListTest3 = a;
        moduleListTest3.rect = moduleListTest3.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("a!W7"), true));
        moduleListTest3.backGround = moduleListTest3.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("EJD`QHoYiO"), true).setParent());
        moduleListTest3.bgSync = moduleListTest3.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("`=Z "), false, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.backGround.isOpen();
        }));
        a.bgColor = a.add(new ColorSetting(BOEntityUtils.ALLATORIxDEMO("IQyo@hY"), new Color(0, 0, 0, 100), object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.backGround.isOpen();
        }));
        ModuleListTest moduleListTest4 = a;
        moduleListTest4.preY = moduleListTest4.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("c6Q\u001a"), true));
        moduleListTest4.fold = moduleListTest4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("FCkO"), true).setParent());
        moduleListTest4.foldSpeed = moduleListTest4.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0005{\u000fA\u0001C!Q'"), 0.1, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.fold.isOpen();
        }));
        ModuleListTest moduleListTest5 = a;
        moduleListTest5.fade = moduleListTest5.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("FMcN"), true).setParent());
        moduleListTest5.fadeSpeed = moduleListTest5.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u0005u\u0007@\u0001C!Q'"), 0.1, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            ModuleListTest a2 = this;
            return a2.fade.isOpen();
        }));
        ModuleListTest moduleListTest6 = a;
        ModuleListTest moduleListTest7 = a;
        moduleListTest7.modulesList = new ArrayList<Modules>();
        moduleListTest7.timer = new Timer();
        moduleListTest6.progress = 0;
        moduleListTest6.setChinese(BOEntityUtils.ALLATORIxDEMO("\u6d5d\u8bef\u529f\u80d1\u5210\u8843"));
        INSTANCE = moduleListTest6;
    }

    private static final class ColorMode
    extends Enum<ColorMode> {
        private static final /* synthetic */ ColorMode[] $VALUES;
        public static final /* enum */ ColorMode Rainbow;
        public static final /* enum */ ColorMode Pulse;
        public static final /* enum */ ColorMode Custom;

        static {
            Custom = new ColorMode(Vec3.ALLATORIxDEMO("Q\rj\u0007w\u001f"), 0);
            Pulse = new ColorMode(Animation.ALLATORIxDEMO("GRpUx"), 1);
            Rainbow = new ColorMode(Vec3.ALLATORIxDEMO("\bs\u0011w\u0011w\u0005"), 2);
            $VALUES = ColorMode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ ColorMode() {
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

        public static ColorMode valueOf(String a) {
            return Enum.valueOf(ColorMode.class, a);
        }

        public static ColorMode[] values() {
            return (ColorMode[])$VALUES.clone();
        }

        private static /* synthetic */ ColorMode[] $values() {
            ColorMode[] arrcolorMode = new ColorMode[3];
            arrcolorMode[0] = Custom;
            arrcolorMode[1] = Pulse;
            arrcolorMode[2] = Rainbow;
            return arrcolorMode;
        }
    }

    public class Modules {
        public double fold;
        public boolean nameUpdated;
        public boolean isEnabled;
        final /* synthetic */ ModuleListTest this$0;
        public String name;
        public String lastName;
        public double x;
        public double fade;
        public boolean hide;
        public double y;
        public final Module module;

        public void update() {
            String a;
            Modules modules;
            Modules modules2 = modules = a;
            a = modules2.module.getArrayName();
            if (!modules2.lastName.equals(a)) {
                modules.lastName = a;
                modules.name = (String)a + modules.module.getArrayInfo();
                Modules modules3 = modules;
                modules3.this$0.update = true;
                modules3.nameUpdated = true;
            }
        }

        public void enable() {
            Modules a;
            if (a.isEnabled) {
                return;
            }
            a.isEnabled = true;
        }

        public void updateName() {
            String a;
            Modules modules = a;
            a = modules.module.getArrayName();
            modules.lastName = a;
            modules.name = (String)a + modules.module.getArrayInfo();
            modules.this$0.update = true;
        }

        /*
         * WARNING - void declaration
         */
        public Modules(ModuleListTest moduleListTest, Module module) {
            Modules a;
            void a2;
            Module a3 = module;
            Modules modules = a = this;
            Modules modules2 = a;
            Modules modules3 = a;
            Modules modules4 = a;
            Modules modules5 = a;
            a.this$0 = a2;
            modules5.isEnabled = false;
            modules5.x = 0.0;
            modules4.y = 0.0;
            modules4.fade = 0.0;
            modules3.hide = true;
            modules3.fold = 0.0;
            modules2.lastName = "";
            modules2.name = "";
            modules.nameUpdated = false;
            modules.module = a3;
        }

        public void disable() {
            Modules a;
            if (!a.isEnabled) {
                return;
            }
            a.isEnabled = false;
        }
    }

}
