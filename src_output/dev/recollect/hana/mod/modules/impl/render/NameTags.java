/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_1657
 *  net.minecraft.class_1934
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_634
 *  net.minecraft.class_640
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.video.Renderer;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import net.minecraft.class_124;
import net.minecraft.class_1657;
import net.minecraft.class_1934;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_634;
import net.minecraft.class_640;
import org.jetbrains.annotations.NotNull;

public class NameTags
extends Module {
    private final SliderSetting offset;
    private final BooleanSetting health;
    private final BooleanSetting enchants;
    private final SliderSetting minScale;
    private final BooleanSetting distance;
    private final ColorSetting outline;
    public static NameTags INSTANCE;
    private final SliderSetting scaled;
    private final ColorSetting friendColor;
    private final ColorSetting rect;
    private final BooleanSetting pops;
    private final BooleanSetting gamemode;
    private final BooleanSetting ping;
    public final EnumSetting<Font> font;
    private final ColorSetting color;
    private final SliderSetting height;
    private final EnumSetting<Armor> armorMode;
    private final SliderSetting armorScale;
    private final SliderSetting scale;
    private final SliderSetting armorHeight;

    public static float round2(double a) {
        return new BigDecimal(a).setScale(1, RoundingMode.HALF_UP).floatValue();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onRender2D(class_332 var1_1, float var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [29[DOLOOP]], but top level block is 11[CASE]
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

    public static class_1934 getEntityGamemode(class_1657 a) {
        class_1657 class_16572 = a;
        if (class_16572 == null) {
            return null;
        }
        a = mc.method_1562().method_2871(class_16572.method_5667());
        if (a == null) {
            return null;
        }
        return a.method_2958();
    }

    private /* synthetic */ class_124 getHealthColor(@NotNull class_1657 class_16572) {
        NameTags nameTags = nameTags2;
        NameTags nameTags2 = class_16572;
        NameTags a = nameTags;
        int this2 = (int)((float)((int)nameTags2.method_6032()) + nameTags2.method_6067());
        if (this2 >= 30) {
            return class_124.field_1077;
        }
        if (this2 >= 24) {
            return class_124.field_1060;
        }
        if (this2 >= 18) {
            return class_124.field_1054;
        }
        if (this2 >= 12) {
            return class_124.field_1065;
        }
        if (this2 >= 6) {
            return class_124.field_1061;
        }
        return class_124.field_1079;
    }

    public NameTags() {
        NameTags a;
        NameTags nameTags = a;
        NameTags nameTags2 = a;
        super(FadeUtils.ALLATORIxDEMO("%[\u0001X%A\\\u0019"), Module.Category.Render);
        NameTags nameTags3 = a;
        nameTags3.scale = nameTags2.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\u001al.w>"), 0.6800000071525574, 0.10000000149011612, 2.0, 0.01));
        nameTags2.minScale = nameTags2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("&S\u0002n\u0012AW\u000f"), 0.20000000298023224, 0.10000000149011612, 1.0, 0.01));
        nameTags2.scaled = nameTags2.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("Z*n#~?"), 1.0, 0.0, 2.0, 0.01));
        nameTags2.offset = nameTags2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("#[\u0017S^\u001e"), 0.3149999976158142, 0.0010000000474974513, 1.0, 0.001));
        nameTags2.height = nameTags2.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("A,f(s/"), 0.0, -3.0, 3.0, 0.01));
        nameTags2.gamemode = nameTags2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO(",[\u0001X\u001cO_\u000f"), false));
        nameTags2.ping = nameTags2.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("_&u<"), false));
        nameTags2.health = nameTags2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("$X\u0010LO\u0002"), true));
        nameTags2.distance = nameTags2.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("x\u0015z=n!x>"), true));
        nameTags2.pops = nameTags2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("i\u0004N\tP!OK\u0019"), true));
        nameTags2.enchants = nameTags2.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("y\u0012j!n!o("), true));
        nameTags2.outline = nameTags2.add(new ColorSetting(FadeUtils.ALLATORIxDEMO("u\u0019I\u001dIU\u000f"), new Color(-1711276033, true)).injectBoolean(true));
        nameTags2.rect = nameTags2.add(new ColorSetting(NpSocketClient.ALLATORIxDEMO("]*x/"), new Color(-1728053247, true)).injectBoolean(true));
        nameTags2.friendColor = nameTags2.add(new ColorSetting(FadeUtils.ALLATORIxDEMO(".\u001eT\u000eT\b~\u001eLT\u0018"), new Color(-14811363, true)));
        nameTags2.color = nameTags2.add(new ColorSetting(NpSocketClient.ALLATORIxDEMO("\n`#t)"), new Color(-1, true)));
        nameTags2.font = nameTags2.add(new EnumSetting<Font>(FadeUtils.ALLATORIxDEMO("-U\u0002I<O_\u000f"), Font.Fast));
        nameTags2.armorHeight = nameTags2.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\u0004 S\u000eA,f(s/"), 0.30000001192092896, -10.0, 10.0));
        nameTags2.armorScale = nameTags2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("-O\u0006U\u001en\u0012AW\u000f"), 0.8999999761581421, 0.10000000149011612, 2.0, 0.009999999776482582));
        nameTags.armorMode = nameTags2.add(new EnumSetting<Armor>(NpSocketClient.ALLATORIxDEMO("\fN\u0011f;B >"), Armor.Full));
        nameTags.setChinese(FadeUtils.ALLATORIxDEMO("\u547c\u5b77\u683c\u7b14"));
        INSTANCE = nameTags;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ String translateGamemode(class_1934 var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:478)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:376)
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

    public static String getEntityPing(class_1657 a2) {
        class_1657 class_16572 = a2;
        if (mc.method_1562() == null) {
            return NpSocketClient.ALLATORIxDEMO("6j");
        }
        a2 = mc.method_1562().method_2871(class_16572.method_5667());
        if (a2 == null) {
            return FadeUtils.ALLATORIxDEMO("O\u0002");
        }
        int a2 = a2.method_2959();
        class_124 class_1242 = class_124.field_1060;
        if (a2 >= 100) {
            class_1242 = class_124.field_1054;
        }
        if (a2 >= 250) {
            class_1242 = class_124.field_1061;
        }
        return class_1242.toString() + a2;
    }

    public static final class Font
    extends Enum<Font> {
        public static final /* enum */ Font Fancy = new Font(TimerManager.ALLATORIxDEMO("\r\u00058Me"), 0);
        public static final /* enum */ Font Fast = new Font(Vec3.ALLATORIxDEMO("U\u0018z\u0017"), 1);
        private static final /* synthetic */ Font[] $VALUES;

        private static /* synthetic */ Font[] $values() {
            Font[] arrfont = new Font[2];
            arrfont[0] = Fancy;
            arrfont[1] = Fast;
            return arrfont;
        }

        static {
            $VALUES = Font.$values();
        }

        public static Font[] values() {
            return (Font[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Font() {
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

        public static Font valueOf(String a) {
            return Enum.valueOf(Font.class, a);
        }
    }

    public static final class Armor
    extends Enum<Armor> {
        public static final /* enum */ Armor None = new Armor(Start.ALLATORIxDEMO("p\u00150"), 0);
        public static final /* enum */ Armor OnlyArmor;
        public static final /* enum */ Armor Full;
        public static final /* enum */ Armor Durability;
        public static final /* enum */ Armor Item;
        private static final /* synthetic */ Armor[] $VALUES;

        public static Armor valueOf(String a) {
            return Enum.valueOf(Armor.class, a);
        }

        public static Armor[] values() {
            return (Armor[])$VALUES.clone();
        }

        private static /* synthetic */ Armor[] $values() {
            Armor[] arrarmor = new Armor[5];
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
        private /* synthetic */ Armor() {
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
            Full = new Armor(Renderer.ALLATORIxDEMO("F\b&["), 1);
            Durability = new Armor(Start.ALLATORIxDEMO("hwYdNk]v\u000f,"), 2);
            Item = new Armor(Renderer.ALLATORIxDEMO("I\t/Z"), 3);
            OnlyArmor = new Armor(Start.ALLATORIxDEMO("MEiUCCr\u0014'"), 4);
            $VALUES = Armor.$values();
        }
    }

}
