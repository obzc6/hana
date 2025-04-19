/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1311
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_757
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ShaderManager;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import dev.recollect.hana.socket.network.user.User;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1311;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_757;

public class Shader
extends Module {
    public final ColorSetting smoke3;
    public final SliderSetting factor;
    public final ColorSetting fill;
    public final SliderSetting speed;
    public final ColorSetting smoke1;
    public final BooleanSetting sky;
    private final BooleanSetting crystals;
    public final SliderSetting smoothness;
    public final SliderSetting octaves;
    private final BooleanSetting self;
    public final ColorSetting smoke2;
    private final BooleanSetting ambients;
    public final SliderSetting radius;
    private final BooleanSetting players;
    public final SliderSetting gradient;
    public final SliderSetting maxRange;
    public final SliderSetting maxSample;
    private final BooleanSetting monsters;
    public final EnumSetting<ShaderManager.Shader> mode;
    private final EnumSetting<Page> page;
    private final BooleanSetting hands;
    public static Shader INSTANCE;
    private final BooleanSetting creatures;
    private final BooleanSetting others;
    public final SliderSetting alpha;
    public final EnumSetting<ShaderManager.Shader> skyMode;
    private final BooleanSetting items;
    public final SliderSetting divider;
    private final BooleanSetting friends;

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        Shader a = class_45872;
        Shader a2 = this;
        if (a2.hands.getValue()) {
            Hana.SHADER.renderShader(() -> Shader.lambda$onRender3D$27((class_4587)a), a2.mode.getValue());
        }
    }

    /*
     * Exception decompiling
     */
    public boolean shouldRender(class_1297 var1_1) {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    private static /* synthetic */ void lambda$onRender3D$27(class_4587 a) {
        Shader.mc.field_1773.method_3172(a, Shader.mc.field_1773.method_19418(), mc.method_1488());
    }

    @Override
    public void onLogin() {
        Hana.SHADER.reloadShaders();
    }

    @Override
    public String getInfo() {
        Shader a;
        return a.mode.getValue().name();
    }

    public Shader() {
        Shader a;
        Shader shader = a;
        super(RenderHelper.ALLATORIxDEMO("9}\u0016lX0"), Module.Category.Render);
        Shader shader2 = a;
        shader2.page = shader.add(new EnumSetting<Page>(User.ALLATORIxDEMO("zWZD"), Page.Shader));
        shader.mode = shader.add(new EnumSetting<ShaderManager.Shader>(RenderHelper.ALLATORIxDEMO(":gY'"), ShaderManager.Shader.Solid, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.skyMode = a.add(new EnumSetting<ShaderManager.Shader>(User.ALLATORIxDEMO("a@NgYYD"), ShaderManager.Shader.Solid, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.speed = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("R\u001f{\u0007F\u0007mX&"), 4.0, 0.0, 20.0, 0.1, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.fill = a.add(new ColorSetting(User.ALLATORIxDEMO("tEZRS"), new Color(255, 255, 255), object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.maxSample = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("X\fj9t\u001axQ'"), 10.0, 0.0, 20.0, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.divider = a.add(new SliderSetting(User.ALLATORIxDEMO("vBACRXS"), 150.0, 0.0, 300.0, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.radius = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("8t\u0013aH1"), 2.0, 0.0, 6.0, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.smoothness = a.add(new SliderSetting(User.ALLATORIxDEMO("tVA]__DSNR"), 1.0, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.alpha = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("R\u0001}\u001dT\u001bxU#"), 255, 0, 255, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Shader;
        }));
        a.sky = a.add(new BooleanSetting(User.ALLATORIxDEMO("eVX"), false, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.hands = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("]\u0016fY1"), true, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.maxRange = a.add(new SliderSetting(User.ALLATORIxDEMO("cSSeKXZD"), 64, 16, 512, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.self = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("$mQ$"), true, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.players = a.add(new BooleanSetting(User.ALLATORIxDEMO("bGVSSOR"), true, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.friends = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("T\u0018|\u0012fY1"), true, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.crystals = a.add(new BooleanSetting(User.ALLATORIxDEMO("m@RD^WQR"), true, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.creatures = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("V\u001fw\u000ba\u0002zX1"), false, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.monsters = a.add(new BooleanSetting(User.ALLATORIxDEMO("c]ED^SOR"), false, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.ambients = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO(",\b|\u0012fI1"), false, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.items = a.add(new BooleanSetting(User.ALLATORIxDEMO("~^SPR"), true, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.others = a.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("%a\u001fmO1"), false, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.factor = a.add(new SliderSetting(User.ALLATORIxDEMO("&\u000f}dN^@FmVIBRS"), 2.0, 0.0, 20.0, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Legacy;
        }));
        a.gradient = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("*`\u000bq\u001emS6"), 2.0, 0.0, 20.0, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Legacy;
        }));
        a.octaves = a.add(new SliderSetting(User.ALLATORIxDEMO("}HCK@XR"), 10, 5, 30, object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Legacy;
        }));
        a.smoke1 = a.add(new ColorSetting(RenderHelper.ALLATORIxDEMO("9x\u0018cXs"), new Color(255, 255, 255), object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Legacy;
        }));
        a.smoke2 = a.add(new ColorSetting(User.ALLATORIxDEMO("xZE]X\u0013"), new Color(255, 255, 255), object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Legacy;
        }));
        a.smoke3 = a.add(new ColorSetting(RenderHelper.ALLATORIxDEMO("9x\u0018cXq"), new Color(255, 255, 255), object -> {
            Object a = object;
            Shader a2 = this;
            return a2.page.getValue() == Page.Legacy;
        }));
        Shader shader3 = a;
        shader3.setChinese(User.ALLATORIxDEMO("\u7776\u824f\u5649"));
        INSTANCE = shader3;
    }

    @Override
    public void onToggle() {
        Hana.SHADER.reloadShaders();
    }

    private static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Shader = new Page(RadiusUtils.ALLATORIxDEMO("g\bH\u0019\u0006E"), 0);
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Target = new Page(OnlineUserInfo.ALLATORIxDEMO("u7U7@&"), 1);
        public static final /* enum */ Page Legacy = new Page(RadiusUtils.ALLATORIxDEMO("x\u0005N\u001c\u0000N"), 2);

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        static {
            $VALUES = Page.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Page() {
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

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[3];
            arrpage[0] = Shader;
            arrpage[1] = Target;
            arrpage[2] = Legacy;
            return arrpage;
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }
    }

}
