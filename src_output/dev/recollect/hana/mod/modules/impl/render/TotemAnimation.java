/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4599
 *  net.minecraft.class_4608
 *  net.minecraft.class_638
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  net.minecraft.class_918
 *  org.joml.Quaternionf
 */
package dev.recollect.hana.mod.modules.impl.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.packet.Packet;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4599;
import net.minecraft.class_4608;
import net.minecraft.class_638;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_918;
import org.joml.Quaternionf;

public class TotemAnimation
extends Module {
    public static TotemAnimation instance;
    private final EnumSetting mode;
    private class_1799 floatingItem;
    private int floatingItemTimeLeft;

    public TotemAnimation() {
        TotemAnimation a;
        TotemAnimation totemAnimation = a;
        TotemAnimation totemAnimation2 = a;
        super(Start.ALLATORIxDEMO("j\r2ACElAcEv\u0014;"), Module.Category.Render);
        TotemAnimation totemAnimation3 = a;
        totemAnimation3.mode = totemAnimation2.add(new EnumSetting<Mode>(WebUtils.ALLATORIxDEMO("\u0003h`("), Mode.FadeOut));
        totemAnimation.floatingItem = null;
        totemAnimation.setChinese(Start.ALLATORIxDEMO("\u56cf\u8161\u52d3\u756e"));
        instance = totemAnimation;
    }

    /*
     * WARNING - void declaration
     */
    public void renderFloatingItem(int n, int n2, float f) {
        float a = f;
        TotemAnimation a2 = this;
        if (a2.floatingItem != null && a2.floatingItemTimeLeft > 0 && !((Enum)a2.mode.getValue()).equals((Object)Mode.Off)) {
            void a3;
            void a4;
            int n3 = a2.getTime() - a2.floatingItemTimeLeft;
            TotemAnimation totemAnimation = a2;
            float f2 = ((float)n3 + a) / (float)totemAnimation.getTime();
            float f3 = f2 * f2;
            float f4 = f2 * f3;
            f3 = (10.25f * f4 * f3 - 24.95f * f3 * f3 + 25.5f * f4 - 13.8f * f3 + 4.0f * f2) * 3.1415927f;
            RenderSystem.enableDepthTest();
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            class_4587 class_45872 = new class_4587();
            class_45872.method_22903();
            a = (float)n3 + a;
            float f5 = 50.0f + 175.0f * class_3532.method_15374((float)f3);
            if (((Enum)totemAnimation.mode.getValue()).equals((Object)Mode.FadeOut)) {
                f3 = (float)(Math.sin(a * 112.0f / 180.0f) * 100.0);
                float f6 = (float)(Math.cos(a * 112.0f / 180.0f) * 50.0);
                class_4587 class_45873 = class_45872;
                class_45873.method_46416((float)(a4 / 2) + f3, (float)(a3 / 2) + f6, -50.0f);
                class_45873.method_22905(f5, -f5, f5);
            } else if (((Enum)a2.mode.getValue()).equals((Object)Mode.Size)) {
                class_4587 class_45874 = class_45872;
                class_45874.method_46416((float)(a4 / 2), (float)(a3 / 2), -50.0f);
                class_45874.method_22905(f5, -f5, f5);
            } else if (((Enum)a2.mode.getValue()).equals((Object)Mode.Otkisuli)) {
                class_4587 class_45875 = class_45872;
                class_45872.method_46416((float)(a4 / 2), (float)(a3 / 2), -50.0f);
                class_45875.method_22907(class_7833.field_40714.rotationDegrees(a * 2.0f));
                class_45875.method_22907(class_7833.field_40718.rotationDegrees(a * 2.0f));
                class_45875.method_22905(200.0f - a * 1.5f, -200.0f + a * 1.5f, 200.0f - a * 1.5f);
            } else if (((Enum)a2.mode.getValue()).equals((Object)Mode.Insert)) {
                class_4587 class_45876 = class_45872;
                class_45876.method_46416((float)(a4 / 2), (float)(a3 / 2), -50.0f);
                class_45876.method_22907(class_7833.field_40714.rotationDegrees(a * 3.0f));
                class_45876.method_22905(200.0f - a * 1.5f, -200.0f + a * 1.5f, 200.0f - a * 1.5f);
            } else if (((Enum)a2.mode.getValue()).equals((Object)Mode.Fall)) {
                f3 = (float)(Math.pow(a, 3.0) * 0.20000000298023224);
                class_4587 class_45877 = class_45872;
                class_45877.method_46416((float)(a4 / 2), (float)(a3 / 2) + f3, -50.0f);
                class_45877.method_22907(class_7833.field_40718.rotationDegrees(a * 5.0f));
                class_45877.method_22905(200.0f - a * 1.5f, -200.0f + a * 1.5f, 200.0f - a * 1.5f);
            } else if (((Enum)a2.mode.getValue()).equals((Object)Mode.Rocket)) {
                f3 = (float)(Math.pow(a, 3.0) * 0.20000000298023224) - 20.0f;
                class_4587 class_45878 = class_45872;
                class_45878.method_46416((float)(a4 / 2), (float)(a3 / 2) - f3, -50.0f);
                class_45878.method_22907(class_7833.field_40716.rotationDegrees(a * (float)a2.floatingItemTimeLeft * 2.0f));
                class_45878.method_22905(200.0f - a * 1.5f, -200.0f + a * 1.5f, 200.0f - a * 1.5f);
            } else if (((Enum)a2.mode.getValue()).equals((Object)Mode.Roll)) {
                f3 = (float)(Math.pow(a, 2.0) * 4.5);
                class_4587 class_45879 = class_45872;
                class_45879.method_46416((float)(a4 / 2) + f3, (float)(a3 / 2), -50.0f);
                class_45879.method_22907(class_7833.field_40718.rotationDegrees(a * 40.0f));
                class_45879.method_22905(200.0f - a * 1.5f, -200.0f + a * 1.5f, 200.0f - a * 1.5f);
            }
            class_4597.class_4598 class_45982 = mc.method_22940().method_23000();
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)(1.0f - f2));
            mc.method_1480().method_23178(a2.floatingItem, class_811.field_4319, 15728880, class_4608.field_21444, class_45872, (class_4597)class_45982, (class_1937)TotemAnimation.mc.field_1687, 0);
            class_45872.method_22909();
            class_45982.method_22993();
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
            RenderSystem.disableDepthTest();
        }
    }

    @Override
    public void onUpdate() {
        TotemAnimation a;
        if (a.floatingItemTimeLeft > 0) {
            TotemAnimation totemAnimation = a;
            --totemAnimation.floatingItemTimeLeft;
            if (totemAnimation.floatingItemTimeLeft == 0) {
                a.floatingItem = null;
            }
        }
    }

    public void showFloatingItem(class_1799 class_17992) {
        TotemAnimation a = class_17992;
        TotemAnimation a2 = this;
        a2.floatingItem = a;
        a2.floatingItemTimeLeft = a2.getTime();
    }

    private /* synthetic */ int getTime() {
        TotemAnimation a;
        if (((Enum)a.mode.getValue()).equals((Object)Mode.FadeOut)) {
            return 10;
        }
        if (((Enum)a.mode.getValue()).equals((Object)Mode.Insert)) {
            return 20;
        }
        return 40;
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Off;
        public static final /* enum */ Mode FadeOut;
        public static final /* enum */ Mode Rocket;
        public static final /* enum */ Mode Size;
        public static final /* enum */ Mode Insert;
        public static final /* enum */ Mode Fall;
        public static final /* enum */ Mode Roll;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Otkisuli;

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

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[8];
            arrmode[0] = FadeOut;
            arrmode[1] = Size;
            arrmode[2] = Otkisuli;
            arrmode[3] = Insert;
            arrmode[4] = Fall;
            arrmode[5] = Rocket;
            arrmode[6] = Roll;
            arrmode[7] = Off;
            return arrmode;
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            FadeOut = new Mode(Vec3.ALLATORIxDEMO("\u001cs\u001c|<m\u0006"), 0);
            Size = new Mode(Packet.ALLATORIxDEMO("MPe]"), 1);
            Otkisuli = new Mode(Vec3.ALLATORIxDEMO(".y\u0011j\u0006t\u001b"), 2);
            Insert = new Mode(Packet.ALLATORIxDEMO("\\\\m\\mL"), 3);
            Fall = new Mode(Vec3.ALLATORIxDEMO("_\u0012t\u001e"), 4);
            Rocket = new Mode(Packet.ALLATORIxDEMO("G]}RzL"), 5);
            Roll = new Mode(Vec3.ALLATORIxDEMO("K\u001ct\u001e"), 6);
            Off = new Mode(Packet.ALLATORIxDEMO("vy^"), 7);
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }
    }

}
