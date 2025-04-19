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
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.video.FileUtil;
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

public class ModuleList
extends Module {
    private final BooleanSetting scissor;
    private final EnumSetting<ColorMode> colorMode;
    public final EnumSetting<AnimateUtil.AnimMode> animMode;
    private List<Modules> modulesList;
    private final EnumSetting<Theme> theme;
    private final ColorSetting endColor;
    private final SliderSetting xOffset;
    private final ColorSetting bgColor;
    private final SliderSetting textOffset;
    public final SliderSetting ySpeed;
    private final BooleanSetting rect;
    public final SliderSetting enableSpeed;
    private final SliderSetting rainbowDelay;
    private final BooleanSetting font;
    private final SliderSetting pulseSpeed;
    boolean update;
    private final BooleanSetting bgSync;
    private final BooleanSetting forgeHax;
    private final BooleanSetting space;
    private final ColorSetting color;
    private final SliderSetting height;
    private final BooleanSetting fold;
    private final SliderSetting saturation;
    private final SliderSetting rainbowSpeed;
    public final SliderSetting disableSpeed;
    private final SliderSetting pulseCounter;
    private final BooleanSetting animY;
    int progress;
    private final BooleanSetting preY;
    private final BooleanSetting down;
    private final BooleanSetting backGround;
    private float counter;
    private final SliderSetting foldSpeed;
    private final BooleanSetting onlyBind;
    private final SliderSetting yOffset;
    public static ModuleList INSTANCE;
    private boolean aBoolean;
    private final BooleanSetting fade;
    private final Timer timer;
    private final SliderSetting fadeSpeed;

    private /* synthetic */ int getColor(int n) {
        int a = n;
        ModuleList a2 = this;
        if (a2.colorMode.getValue() != ColorMode.Custom) {
            return a2.rainbow(a).getRGB();
        }
        return a2.color.getValue().getRGB();
    }

    public double animate(double a, double a2, double a3) {
        ModuleList a4;
        if (a3 >= 1.0) {
            return a2;
        }
        if (a3 == 0.0) {
            return a;
        }
        return AnimateUtil.animate(a, a2, a3, a4.animMode.getValue());
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ int getTextColor() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 1[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
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

    @Override
    public void onRender2D(class_332 a, float a2) {
        Modules modules2;
        Modules a3;
        ModuleList moduleList = a3;
        if (moduleList.space.getValue() != moduleList.aBoolean) {
            Iterator<Modules> iterator = a2 = moduleList.modulesList.iterator();
            while (iterator.hasNext()) {
                modules2 = a2.next();
                iterator = a2;
                modules2.updateName();
            }
            moduleList.aBoolean = moduleList.space.getValue();
        }
        Iterator<Modules> iterator = a2 = moduleList.modulesList.iterator();
        while (iterator.hasNext()) {
            modules2 = a2.next();
            iterator = a2;
            modules2.update();
        }
        if (moduleList.update) {
            moduleList.modulesList = moduleList.modulesList.stream().sorted(Comparator.comparing(modules -> {
                Modules a = modules;
                ModuleList a2 = this;
                return a2.getStringWidth(a.name) * -1;
            })).collect(Collectors.toList());
            moduleList.update = false;
        }
        if (moduleList.timer.passed(25L)) {
            ModuleList moduleList2 = moduleList;
            moduleList.progress -= moduleList2.rainbowSpeed.getValueInt();
            moduleList2.timer.reset();
        }
        int n = a2 = moduleList.down.getValue() ? mc.method_22683().method_4502() - moduleList.yOffset.getValueInt() - moduleList.getFontHeight() : moduleList.yOffset.getValueInt();
        int n2 = 20;
        Iterator<Modules> iterator2 = moduleList.modulesList.iterator();
        block2 : do {
            Iterator<Modules> iterator3 = iterator2;
            while (iterator3.hasNext()) {
                Modules modules3;
                ModuleList moduleList3;
                Modules modules4;
                a3 = iterator2.next();
                if (a3.module.isOn() && a3.module.drawnSetting.getValue() && (!moduleList.onlyBind.getValue() || a3.module.getBind().getKey() != -1)) {
                    Object object = a3;
                    modules4 = object;
                    ((Modules)object).enable();
                } else {
                    Modules modules5 = a3;
                    modules4 = modules5;
                    modules5.disable();
                }
                if (modules4.isEnabled) {
                    Modules modules6;
                    Modules modules7 = a3;
                    if (moduleList.fade.getValue()) {
                        modules7.fade = moduleList.animate(a3.fade, 1.0, moduleList.fadeSpeed.getValue());
                        modules6 = a3;
                    } else {
                        modules7.fade = 1.0;
                        modules6 = a3;
                    }
                    modules6.fold = 1.0;
                    Modules modules8 = a3;
                    modules3 = modules8;
                    ModuleList moduleList4 = moduleList;
                    modules8.x = moduleList.animate(modules8.x, moduleList4.getStringWidth(moduleList4.getSuffix(a3.name)), moduleList.enableSpeed.getValue());
                } else {
                    Modules modules9;
                    Modules modules10 = a3;
                    if (moduleList.fade.getValue()) {
                        modules10.fade = moduleList.animate(a3.fade, 0.08, moduleList.fadeSpeed.getValue());
                        modules9 = a3;
                    } else {
                        modules10.fade = 1.0;
                        modules9 = a3;
                    }
                    modules9.fold = moduleList.animate(a3.fold, -0.1, moduleList.foldSpeed.getValue());
                    Object object = a3;
                    ((Modules)object).x = moduleList.animate(((Modules)object).x, -1.0, moduleList.disableSpeed.getValue());
                    if (((Modules)object).x <= 0.0 || a3.fade <= 0.084 || moduleList.fold.getValue() && a3.fold <= 0.0) {
                        a3.hide = true;
                        iterator3 = iterator2;
                        continue;
                    }
                    modules3 = a3;
                }
                if (modules3.hide) {
                    Object object = a3;
                    a3.updateName();
                    ((Modules)object).x = 0.0;
                    ((Modules)object).y = moduleList.animY.getValue() ? (double)a2 : (double)n;
                    Object object2 = a3;
                    ((Modules)object2).nameUpdated = false;
                    ((Modules)object2).hide = false;
                }
                if (a3.nameUpdated) {
                    Object object = a3;
                    ((Modules)object).nameUpdated = false;
                    ((Modules)object).y = moduleList.animY.getValue() && !a3.isEnabled ? (double)a2 : (double)n;
                } else {
                    double d;
                    ModuleList moduleList5;
                    ModuleList moduleList6 = moduleList;
                    if (moduleList6.animY.getValue() && !a3.isEnabled) {
                        d = a2;
                        moduleList5 = moduleList;
                    } else {
                        d = n;
                        moduleList5 = moduleList;
                    }
                    a3.y = moduleList6.animate(a3.y, d, moduleList5.ySpeed.getValue());
                }
                ++n2;
                int n3 = (int)((double)mc.method_22683().method_4486() - a3.x - moduleList.xOffset.getValue() - (double)(moduleList.rect.getValue() ? 2 : 0));
                if (moduleList.fold.getValue()) {
                    class_332 class_3322 = a;
                    class_3322.method_51448().method_22903();
                    class_3322.method_51448().method_22904(0.0, a3.y * (1.0 - a3.fold), 0.0);
                    class_3322.method_51448().method_22905(1.0f, (float)a3.fold, 1.0f);
                }
                if (moduleList.scissor.getValue()) {
                    GL11.glEnable((int)3089);
                    GL11.glScissor((int)0, (int)0, (int)((mc.method_22683().method_4480() / 2 - moduleList.xOffset.getValueInt() - (moduleList.rect.getValue() ? 2 : 0)) * 2), (int)mc.method_22683().method_4507());
                }
                if (moduleList.backGround.getValue()) {
                    ModuleList moduleList7 = moduleList;
                    Render2DUtil.drawRect(a.method_51448(), (float)(n3 - 1), (float)((int)a3.y), (float)mc.method_22683().method_4486() - (float)moduleList.xOffset.getValueInt() + 1.0f - (float)n3 + 1.0f, (float)(moduleList.getFontHeight() + moduleList.height.getValueInt()), moduleList.bgSync.getValue() ? ColorUtil.injectAlpha(moduleList7.getColor(n2), (int)((double)moduleList.bgColor.getValue().getAlpha() * a3.fade)) : ColorUtil.injectAlpha(moduleList7.bgColor.getValue().getRGB(), (int)((double)moduleList.bgColor.getValue().getAlpha() * a3.fade)));
                }
                if (moduleList.font.getValue()) {
                    FontRenderers.sigma.drawString(a.method_51448(), moduleList.getSuffix(a3.name), n3, (int)(a3.y + 1.0 + (double)moduleList.textOffset.getValueInt()), ColorUtil.injectAlpha(moduleList.getColor(n2), (int)(255.0 * a3.fade)));
                    moduleList3 = moduleList;
                } else {
                    a.method_25303(ModuleList.mc.field_1772, moduleList.getSuffix(a3.name), n3, (int)(a3.y + 1.0 + (double)moduleList.textOffset.getValueInt()), ColorUtil.injectAlpha(moduleList.getColor(n2), (int)(255.0 * a3.fade)));
                    moduleList3 = moduleList;
                }
                if (moduleList3.scissor.getValue()) {
                    GL11.glDisable((int)3089);
                }
                if (moduleList.fold.getValue()) {
                    a.method_51448().method_22909();
                }
                if (moduleList.rect.getValue()) {
                    ModuleList moduleList8 = moduleList;
                    int n4 = (int)a3.y + 1 + moduleList8.textOffset.getValueInt();
                    int n5 = 2;
                    int n6 = moduleList.getFontHeight();
                    int n7 = ColorUtil.injectAlpha(moduleList8.getColor(n2), (int)(255.0 * a3.fade));
                    Render2DUtil.drawRect(a.method_51448(), (float)(n3 -= 3), (float)n4, (float)(n3 + n5), (float)(n4 + n6), n7);
                }
                if (!a3.isEnabled && moduleList.preY.getValue()) continue block2;
                int n8 = n;
                if (moduleList.down.getValue()) {
                    n = n8 - (moduleList.getFontHeight() + moduleList.height.getValueInt());
                    continue block2;
                }
                n = n8 + (moduleList.getFontHeight() + moduleList.height.getValueInt());
                continue block2;
            }
            break;
        } while (true);
    }

    private /* synthetic */ int getStringWidth(String string) {
        String a = string;
        ModuleList a2 = this;
        if (a2.font.getValue()) {
            return (int)FontRenderers.sigma.getWidth(a);
        }
        return ModuleList.mc.field_1772.method_1727(a);
    }

    @Override
    public void onEnable() {
        Object a;
        ModuleList moduleList = a;
        moduleList.modulesList.clear();
        Object object = a = Hana.MODULE.modules.iterator();
        while (object.hasNext()) {
            Module module = (Module)a.next();
            object = a;
            moduleList.modulesList.add(new Modules(moduleList, module));
        }
    }

    private /* synthetic */ String getSuffix(String string) {
        String a = string;
        ModuleList a2 = this;
        if (a2.forgeHax.getValue()) {
            return (String)a + "\u00a7r<";
        }
        return a;
    }

    private /* synthetic */ int getFontHeight() {
        ModuleList a;
        if (a.font.getValue()) {
            return (int)FontRenderers.sigma.getFontHeight();
        }
        Objects.requireNonNull(ModuleList.mc.field_1772);
        return 9;
    }

    private /* synthetic */ Color rainbow(int n) {
        int a = n;
        ModuleList a2 = this;
        if (a2.colorMode.getValue() == ColorMode.Pulse) {
            return ColorUtil.pulseColor(a2.color.getValue(), a2.endColor.getValue(), a, a2.pulseCounter.getValueInt(), a2.pulseSpeed.getValue());
        }
        if (a2.colorMode.getValue() == ColorMode.Rainbow) {
            return Color.getHSBColor((float)(Math.ceil(((double)a2.progress + (double)a * a2.rainbowDelay.getValue()) / 20.0) % 360.0 / 360.0), a2.saturation.getValueFloat() / 255.0f, 1.0f);
        }
        return a2.color.getValue();
    }

    public ModuleList() {
        ModuleList a;
        ModuleList moduleList = a;
        super(FileUtil.ALLATORIxDEMO("]\u0010]#p\u0016J\u0000r\u001a"), Module.Category.Client);
        ModuleList moduleList2 = a;
        moduleList2.font = moduleList.add(new BooleanSetting(Snow.ALLATORIxDEMO("T){5"), false));
        moduleList.height = moduleList.add(new SliderSetting(FileUtil.ALLATORIxDEMO("T\u0016o\u000ei\u001a"), 0, -2, 10));
        moduleList.textOffset = moduleList.add(new SliderSetting(Snow.ALLATORIxDEMO("P5U\rG:t5p5"), 0, 0, 10));
        moduleList.xOffset = moduleList.add(new SliderSetting(FileUtil.ALLATORIxDEMO("\u000eS\u0015`\u001ad\u001a"), 0, 0, 500));
        moduleList.yOffset = moduleList.add(new SliderSetting(Snow.ALLATORIxDEMO(" G:t5p5"), 10, 0, 300));
        moduleList.animMode = moduleList.add(new EnumSetting<AnimateUtil.AnimMode>(FileUtil.ALLATORIxDEMO("x8u\u001eK\u0006e\u000b"), AnimateUtil.AnimMode.Mio));
        moduleList.disableSpeed = moduleList.add(new SliderSetting(Snow.ALLATORIxDEMO("I0w1O\u0015m\u000fb#p%"), 0.2, -0.2, 1.0, 0.01));
        moduleList.enableSpeed = moduleList.add(new SliderSetting(FileUtil.ALLATORIxDEMO("3~\u001e[:y v\fd\n"), 0.2, 0.0, 1.0, 0.01));
        moduleList.ySpeed = moduleList.add(new SliderSetting(Snow.ALLATORIxDEMO("Q\u000fb#p%"), 0.2, 0.01, 1.0, 0.01));
        moduleList.forgeHax = moduleList.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("9n\u0014c!`\u0016"), true));
        moduleList.space = moduleList.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u000fb'v$"), true));
        moduleList.down = moduleList.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("B\u0006v\u0000"), false));
        moduleList.animY = moduleList.add(new BooleanSetting(Snow.ALLATORIxDEMO("\u001d|/x\u0018"), true));
        moduleList.scissor = moduleList.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("\u0005\u001au\u001an\u001c"), false));
        moduleList.onlyBind = moduleList.add(new BooleanSetting(Snow.ALLATORIxDEMO("b\u0017d%P/{%"), true));
        moduleList.colorMode = moduleList.add(new EnumSetting<ColorMode>(FileUtil.ALLATORIxDEMO("<V:s\u0001K\u0006e\u000b"), ColorMode.Pulse));
        moduleList.rainbowSpeed = moduleList.add(new SliderSetting(Snow.ALLATORIxDEMO("_8m>O\u0016\u000fb#p%"), 200, 1, 1000, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow;
        }));
        a.saturation = a.add(new SliderSetting(FileUtil.ALLATORIxDEMO("C\u001eM#n\u0012r\u0000n\u0000"), 130.0, 1.0, 355.0, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow;
        }));
        a.pulseSpeed = a.add(new SliderSetting(Snow.ALLATORIxDEMO("T%A\nm\u000fb#p%"), 1.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() == ColorMode.Pulse;
        }));
        a.pulseCounter = a.add(new SliderSetting(FileUtil.ALLATORIxDEMO("\u0015s\u0006h\u001dd\u001c"), 10, 1, 100, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() == ColorMode.Pulse;
        }));
        a.rainbowDelay = a.add(new SliderSetting(Snow.ALLATORIxDEMO("\u0018w*t8"), 350, 0, 1000, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow;
        }));
        a.color = a.add(new ColorSetting(FileUtil.ALLATORIxDEMO("0i\u0005n\u001c"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() != ColorMode.Rainbow;
        }));
        a.endColor = a.add(new ColorSetting(Snow.ALLATORIxDEMO("h\u0017l\u001f}*z3"), new Color(255, 0, 0, 255), object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.colorMode.getValue() == ColorMode.Pulse;
        }));
        ModuleList moduleList3 = a;
        moduleList3.rect = moduleList3.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("T\fb\u001a"), true));
        moduleList3.backGround = moduleList3.add(new BooleanSetting(Snow.ALLATORIxDEMO("F1N\u0012O.}3{%"), true).setParent());
        moduleList3.bgSync = moduleList3.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("U\u0010o\r"), false, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.backGround.isOpen();
        }));
        a.bgColor = a.add(new ColorSetting(Snow.ALLATORIxDEMO(";O\u001f}*z3"), new Color(0, 0, 0, 100), object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.backGround.isOpen();
        }));
        ModuleList moduleList4 = a;
        moduleList4.preY = moduleList4.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("V\u001bd7"), true));
        moduleList4.fold = moduleList4.add(new BooleanSetting(Snow.ALLATORIxDEMO("T)y%"), true).setParent());
        moduleList4.foldSpeed = moduleList4.add(new SliderSetting(FileUtil.ALLATORIxDEMO("9V:x v\fd\n"), 0.1, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.fold.isOpen();
        }));
        ModuleList moduleList5 = a;
        moduleList5.fade = moduleList5.add(new BooleanSetting(Snow.ALLATORIxDEMO("T'q$"), true).setParent());
        moduleList5.fadeSpeed = moduleList5.add(new SliderSetting(FileUtil.ALLATORIxDEMO("9X2y v\fd\n"), 0.1, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            ModuleList a2 = this;
            return a2.fade.isOpen();
        }));
        ModuleList moduleList6 = a;
        ModuleList moduleList7 = a;
        a.theme = a.add(new EnumSetting<Theme>(Snow.ALLATORIxDEMO("\bz#x$"), Theme.Dark));
        moduleList7.modulesList = new ArrayList<Modules>();
        moduleList7.counter = 0.0f;
        moduleList7.timer = new Timer();
        moduleList6.progress = 0;
        moduleList6.setChinese(FileUtil.ALLATORIxDEMO("\u5299\u8094\u5216\u8806"));
        INSTANCE = moduleList6;
    }

    private static final class ColorMode
    extends Enum<ColorMode> {
        public static final /* enum */ ColorMode Custom = new ColorMode(Setting.ALLATORIxDEMO("X-u1#b"), 0);
        private static final /* synthetic */ ColorMode[] $VALUES;
        public static final /* enum */ ColorMode Pulse = new ColorMode(Packet.ALLATORIxDEMO("bkUl]"), 1);
        public static final /* enum */ ColorMode Rainbow = new ColorMode(Setting.ALLATORIxDEMO("\rz1h'#x"), 2);

        private static /* synthetic */ ColorMode[] $values() {
            ColorMode[] arrcolorMode = new ColorMode[3];
            arrcolorMode[0] = Custom;
            arrcolorMode[1] = Pulse;
            arrcolorMode[2] = Rainbow;
            return arrcolorMode;
        }

        public static ColorMode valueOf(String a) {
            return Enum.valueOf(ColorMode.class, a);
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

        static {
            $VALUES = ColorMode.$values();
        }

        public static ColorMode[] values() {
            return (ColorMode[])$VALUES.clone();
        }
    }

    private static final class Theme
    extends Enum<Theme> {
        public static final /* enum */ Theme Light;
        private static final /* synthetic */ Theme[] $VALUES;
        public static final /* enum */ Theme Colorful;
        public static final /* enum */ Theme Dark;

        private static /* synthetic */ Theme[] $values() {
            Theme[] arrtheme = new Theme[3];
            arrtheme[0] = Dark;
            arrtheme[1] = Light;
            arrtheme[2] = Colorful;
            return arrtheme;
        }

        public static Theme[] values() {
            return (Theme[])$VALUES.clone();
        }

        public static Theme valueOf(String a) {
            return Enum.valueOf(Theme.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Theme() {
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
            Dark = new Theme(TimerManager.ALLATORIxDEMO(" 7\\w"), 0);
            Light = new Theme(Packet.ALLATORIxDEMO("t~WwL"), 1);
            Colorful = new Theme(TimerManager.ALLATORIxDEMO("=#\u0015$\u00160[p"), 2);
            $VALUES = Theme.$values();
        }
    }

    public class Modules {
        final /* synthetic */ ModuleList this$0;
        public boolean isEnabled;
        public double fade;
        public final Module module;
        public String lastName;
        public String name;
        public boolean nameUpdated;
        public double x;
        public boolean hide;
        public double fold;
        public double y;

        /*
         * WARNING - void declaration
         */
        public Modules(ModuleList moduleList, Module module) {
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

        public void update() {
            Object a;
            Modules modules;
            Modules modules2 = modules = a;
            a = modules2.module.getArrayName();
            if (!modules2.lastName.equals(a)) {
                modules.lastName = a;
                if (modules.this$0.space.getValue()) {
                    a = modules.module.getDisplayName().replaceAll(ColorUtil.ALLATORIxDEMO("oZ *>_y>\u000eRm\\\f>"), BetterDynamicAnimation.ALLATORIxDEMO(";\u00136\u00102"));
                    if (((String)a).startsWith(ColorUtil.ALLATORIxDEMO("7"))) {
                        a = ((String)a).replaceFirst(BetterDynamicAnimation.ALLATORIxDEMO(" "), "");
                    }
                    a = (String)a + modules.module.getArrayInfo();
                }
                Modules modules3 = modules;
                modules3.name = a;
                modules3.this$0.update = true;
                modules.nameUpdated = true;
            }
        }

        public void disable() {
            Modules a;
            if (!a.isEnabled) {
                return;
            }
            a.isEnabled = false;
        }

        public void enable() {
            Modules a;
            if (a.isEnabled) {
                return;
            }
            a.isEnabled = true;
        }

        public void updateName() {
            Object a;
            Modules modules;
            Modules modules2 = modules = a;
            a = modules2.module.getArrayName();
            modules2.lastName = a;
            if (modules2.this$0.space.getValue()) {
                a = modules.module.getDisplayName().replaceAll(ColorUtil.ALLATORIxDEMO("}H!++JS\u0014\u000eRtE\f>"), BetterDynamicAnimation.ALLATORIxDEMO(";\u00136\u00102"));
                if (((String)a).startsWith(ColorUtil.ALLATORIxDEMO("7"))) {
                    a = ((String)a).replaceFirst(BetterDynamicAnimation.ALLATORIxDEMO(" "), "");
                }
                a = (String)a + modules.module.getArrayInfo();
            }
            Modules modules3 = modules;
            modules3.name = a;
            modules3.this$0.update = true;
        }
    }

}
