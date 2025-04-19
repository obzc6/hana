/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.AutoCity;
import dev.recollect.hana.mod.modules.impl.combat.AutoTrap;
import dev.recollect.hana.mod.modules.impl.combat.Burrow;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.combat.Surround;
import dev.recollect.hana.mod.modules.impl.combat.WebAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.movement.Step;
import dev.recollect.hana.mod.modules.impl.movement.dev.GrimSpeed;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import java.awt.Color;
import net.minecraft.class_1041;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class Indicator
extends Module {
    float offset;
    class_4587 matrixStack;
    public static Indicator INSTANCE;
    float height;

    @Override
    public void onRender2D(class_332 class_3322, float f) {
        Indicator a = class_3322;
        Indicator a2 = this;
        if (Indicator.nullCheck()) {
            return;
        }
        Indicator indicator = a2;
        indicator.matrixStack = a.method_51448();
        indicator.height = FontRenderers.Arial.getFontHeight();
        a2.offset = 0.0f;
        if (Burrow.INSTANCE.isOn()) {
            a2.draw(PacketBuffer.ALLATORIxDEMO("-]&A&Y"), HoleKick.isInWeb((class_1657)Indicator.mc.field_1724) ? ColorType.Red : ColorType.Green);
        }
        Indicator indicator2 = a2;
        if (BlockUtil.isHole(EntityUtil.getPlayerPos(true))) {
            indicator2.draw(TimeHelper.ALLATORIxDEMO("(xK\n"), ColorType.Green);
        } else {
            indicator2.draw(PacketBuffer.ALLATORIxDEMO(":F'R/K"), ColorType.Red);
        }
        if (GrimSpeed.INSTANCE.isOn()) {
            a2.draw(TimeHelper.ALLATORIxDEMO("9qB\u001f"), ColorType.White);
        }
        if (HoleKick.INSTANCE.isOn()) {
            a2.draw(PacketBuffer.ALLATORIxDEMO("$F:F"), ColorType.White);
        }
        if (AutoTrap.INSTANCE.isOn()) {
            a2.draw(TimeHelper.ALLATORIxDEMO("/kL\u001f"), ColorType.White);
        }
        if (AutoCity.INSTANCE.isOn()) {
            a2.draw(PacketBuffer.ALLATORIxDEMO("7Z=W"), ColorType.White);
        }
        if (Surround.INSTANCE.isOn()) {
            a2.draw(TimeHelper.ALLATORIxDEMO("}H\t"), ColorType.White);
        }
        if (Step.INSTANCE.isOn()) {
            a2.draw(PacketBuffer.ALLATORIxDEMO(":Z"), ColorType.White);
        }
        if (WebAura.INSTANCE.isOn()) {
            a2.draw(TimeHelper.ALLATORIxDEMO("L\u0018"), ColorType.White);
        }
        if (HanaAura.INSTANCE.isOn()) {
            a2.draw(PacketBuffer.ALLATORIxDEMO("(M"), HanaAura.INSTANCE.displayTarget != null && HanaAura.INSTANCE.lastDamage > 0.0f ? ColorType.Green : ColorType.Red);
        }
        if (AnchorAura.INSTANCE.isOn()) {
            a2.draw(TimeHelper.ALLATORIxDEMO("L\u0001"), AnchorAura.INSTANCE.displayTarget != null && AnchorAura.INSTANCE.currentPos != null ? ColorType.Green : ColorType.Red);
        }
    }

    public Indicator() {
        Indicator a;
        Indicator indicator = a;
        super(PacketBuffer.ALLATORIxDEMO("V\u0014y\u0006k\u0015g\u0006|"), Module.Category.Client);
        indicator.setChinese(TimeHelper.ALLATORIxDEMO("\u52bf\u809f\u5f3d\u510c\u6649\u790f"));
        INSTANCE = indicator;
    }

    private /* synthetic */ void draw(String a, ColorType a2) {
        Indicator a222;
        Indicator indicator = a222;
        int a222 = -1;
        if (a2 == ColorType.Red) {
            a222 = new Color(255, 0, 0).getRGB();
        }
        if (a2 == ColorType.Green) {
            a222 = new Color(47, 173, 26).getRGB();
        }
        double d = FontRenderers.Arial.getWidth(a) + 8.0f;
        Indicator indicator2 = indicator;
        Render2DUtil.horizontalGradient(indicator2.matrixStack, 10.0f, (float)(mc.method_22683().method_4502() - 200) + indicator.offset, (float)(10.0 + d / 2.0), (float)(mc.method_22683().method_4502() - 200) + indicator.offset + indicator.height, new Color(0, 0, 0, 0), new Color(0, 0, 0, 100));
        Render2DUtil.horizontalGradient(indicator2.matrixStack, (float)(10.0 + d / 2.0), (float)(mc.method_22683().method_4502() - 200) + indicator.offset, (float)(10.0 + d), (float)(mc.method_22683().method_4502() - 200) + indicator.offset + indicator.height, new Color(0, 0, 0, 100), new Color(0, 0, 0, 0));
        Indicator indicator3 = indicator;
        FontRenderers.Arial.drawString(indicator3.matrixStack, a, 14.0f, (float)(mc.method_22683().method_4502() - 195) + indicator.offset, a222);
        indicator3.offset -= indicator.height + 3.0f;
    }

    private static final class ColorType
    extends Enum<ColorType> {
        private static final /* synthetic */ ColorType[] $VALUES;
        public static final /* enum */ ColorType White;
        public static final /* enum */ ColorType Red;
        public static final /* enum */ ColorType Green;

        public static ColorType valueOf(String a) {
            return Enum.valueOf(ColorType.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ ColorType() {
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
            Red = new ColorType(TimerManager.ALLATORIxDEMO("\u0004Kx"), 0);
            Green = new ColorType(BackgroundInfo.ALLATORIxDEMO("\f33nr"), 1);
            White = new ColorType(TimerManager.ALLATORIxDEMO("\u001c\f?Zy"), 2);
            $VALUES = ColorType.$values();
        }

        public static ColorType[] values() {
            return (ColorType[])$VALUES.clone();
        }

        private static /* synthetic */ ColorType[] $values() {
            ColorType[] arrcolorType = new ColorType[3];
            arrcolorType[0] = Red;
            arrcolorType[1] = Green;
            arrcolorType[2] = White;
            return arrcolorType;
        }
    }

}
