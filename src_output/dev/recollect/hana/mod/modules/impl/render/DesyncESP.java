/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.platform.GlStateManager$class_4534
 *  com.mojang.blaze3d.platform.GlStateManager$class_4535
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_327
 *  net.minecraft.class_3300
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5498
 *  net.minecraft.class_5599
 *  net.minecraft.class_5601
 *  net.minecraft.class_5602
 *  net.minecraft.class_5617
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_591
 *  net.minecraft.class_630
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_759
 *  net.minecraft.class_776
 *  net.minecraft.class_7833
 *  net.minecraft.class_8080
 *  net.minecraft.class_898
 *  net.minecraft.class_918
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.video.FileUtil;
import dev.recollect.hana.video.Renderer;
import java.awt.Color;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_327;
import net.minecraft.class_3300;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5498;
import net.minecraft.class_5599;
import net.minecraft.class_5601;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_759;
import net.minecraft.class_776;
import net.minecraft.class_7833;
import net.minecraft.class_8080;
import net.minecraft.class_898;
import net.minecraft.class_918;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;

public final class DesyncESP
extends Module {
    private final ColorSetting color;
    float lastYaw;
    boolean update;
    public static DesyncESP INSTANCE;
    private final EnumSetting<Type> type;
    float lastPitch;
    Model model;

    @Override
    public void onLogin() {
        a.update = true;
    }

    public DesyncESP() {
        DesyncESP a;
        DesyncESP desyncESP = a;
        DesyncESP desyncESP2 = a;
        super(FileUtil.ALLATORIxDEMO("0s\nI1E\fv\u001a"), Module.Category.Render);
        DesyncESP desyncESP3 = a;
        desyncESP3.color = desyncESP2.add(new ColorSetting(TimerManager.ALLATORIxDEMO("\b\u000b:An"), new Color(255, 255, 255)));
        desyncESP2.type = desyncESP2.add(new EnumSetting<Type>(FileUtil.ALLATORIxDEMO("r0U/"), Type.ServerSide));
        desyncESP.update = true;
        desyncESP.setChinese(TimerManager.ALLATORIxDEMO("\u5bee\u624e\u7aa4\u8f08\u5962\u6610\u7926"));
        INSTANCE = desyncESP;
    }

    private static /* synthetic */ void prepareScale(class_4587 a) {
        class_4587 class_45872 = a;
        a.method_22905(-1.0f, -1.0f, 1.0f);
        class_45872.method_22905(1.6f, 1.8f, 1.6f);
        class_45872.method_46416(0.0f, -1.501f, 0.0f);
    }

    @EventHandler
    public void onUpdateWalkingPost(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        DesyncESP a2 = this;
        if (a.getStage() == Event.Stage.Post) {
            DesyncESP desyncESP = a2;
            desyncESP.lastYaw = DesyncESP.mc.field_1724.method_36454();
            desyncESP.lastPitch = DesyncESP.mc.field_1724.method_36455();
        }
    }

    @Override
    public void onUpdate() {
        DesyncESP a;
        if (DesyncESP.nullCheck()) {
            return;
        }
        if (a.update) {
            DesyncESP desyncESP = a;
            DesyncESP desyncESP2 = a;
            desyncESP.model = new Model();
            desyncESP.update = false;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        void a;
        DesyncESP desyncESP = this;
        if (DesyncESP.nullCheck() || desyncESP.model == null) {
            return;
        }
        if (DesyncESP.mc.field_1690.method_31044() == class_5498.field_26664) {
            return;
        }
        if (Math.abs(desyncESP.lastYaw - Hana.ROTATE.lastYaw) < 1.0f && Math.abs(desyncESP.lastPitch - Hana.ROTATE.lastPitch) < 1.0f) {
            return;
        }
        RenderSystem.depthMask((boolean)false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        double d = DesyncESP.mc.field_1724.field_6014 + (DesyncESP.mc.field_1724.method_23317() - DesyncESP.mc.field_1724.field_6014) * (double)mc.method_1488() - DesyncESP.mc.method_1561().field_4686.method_19326().method_10216();
        double d2 = DesyncESP.mc.field_1724.field_6036 + (DesyncESP.mc.field_1724.method_23318() - DesyncESP.mc.field_1724.field_6036) * (double)mc.method_1488() - DesyncESP.mc.method_1561().field_4686.method_19326().method_10214();
        double d3 = DesyncESP.mc.field_1724.field_5969 + (DesyncESP.mc.field_1724.method_23321() - DesyncESP.mc.field_1724.field_5969) * (double)mc.method_1488() - DesyncESP.mc.method_1561().field_4686.method_19326().method_10215();
        float a22 = desyncESP.type.getValue() == Type.ServerSide ? RotateManager.getPrevRenderYawOffset() + (RotateManager.getRenderYawOffset() - RotateManager.getPrevRenderYawOffset()) * mc.method_1488() : DesyncESP.mc.field_1724.field_6220 + (DesyncESP.mc.field_1724.field_6283 - DesyncESP.mc.field_1724.field_6220) * mc.method_1488();
        float a32 = desyncESP.type.getValue() == Type.ServerSide ? RotateManager.getPrevRotationYawHead() + (RotateManager.getRotationYawHead() - RotateManager.getPrevRotationYawHead()) * mc.method_1488() : DesyncESP.mc.field_1724.field_6259 + (DesyncESP.mc.field_1724.field_6241 - DesyncESP.mc.field_1724.field_6259) * mc.method_1488();
        float f2 = desyncESP.type.getValue() == Type.ServerSide ? RotateManager.getPrevPitch() + (RotateManager.getRenderPitch() - RotateManager.getPrevPitch()) * mc.method_1488() : DesyncESP.mc.field_1724.field_6004 + (DesyncESP.mc.field_1724.method_36455() - DesyncESP.mc.field_1724.field_6004) * mc.method_1488();
        DesyncESP desyncESP2 = desyncESP;
        void v1 = a;
        void v2 = a;
        v2.method_22903();
        v2.method_46416((float)d, (float)d2, (float)d3);
        v1.method_22907(class_7833.field_40716.rotation(MathUtil.rad(180.0f - a22)));
        DesyncESP.prepareScale((class_4587)v1);
        desyncESP2.model.modelPlayer.method_17086((class_1309)DesyncESP.mc.field_1724, DesyncESP.mc.field_1724.field_42108.method_48572(mc.method_1488()), DesyncESP.mc.field_1724.field_42108.method_48570(mc.method_1488()), mc.method_1488());
        desyncESP2.model.modelPlayer.method_17087((class_1309)DesyncESP.mc.field_1724, DesyncESP.mc.field_1724.field_42108.method_48572(mc.method_1488()), DesyncESP.mc.field_1724.field_42108.method_48570(mc.method_1488()), (float)DesyncESP.mc.field_1724.field_6012, a32 - a22, f2);
        RenderSystem.enableBlend();
        GL11.glDisable((int)2929);
        class_289 a22 = class_289.method_1348();
        class_287 a32 = a22.method_1349();
        RenderSystem.blendFuncSeparate((GlStateManager.class_4535)GlStateManager.class_4535.SRC_ALPHA, (GlStateManager.class_4534)GlStateManager.class_4534.ONE_MINUS_SRC_ALPHA, (GlStateManager.class_4535)GlStateManager.class_4535.ONE, (GlStateManager.class_4534)GlStateManager.class_4534.ZERO);
        RenderSystem.setShader(class_757::method_34540);
        a32.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        desyncESP.model.modelPlayer.method_2828((class_4587)a, (class_4588)a32, 10, 0, (float)desyncESP.color.getValue().getRed() / 255.0f, (float)desyncESP.color.getValue().getGreen() / 255.0f, (float)desyncESP.color.getValue().getBlue() / 255.0f, (float)desyncESP.color.getValue().getAlpha() / 255.0f);
        a22.method_1350();
        RenderSystem.disableBlend();
        GL11.glEnable((int)2929);
        a.method_22909();
        RenderSystem.disableBlend();
        RenderSystem.depthMask((boolean)true);
    }

    public static final class Type
    extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES;
        public static final /* enum */ Type ServerSide;
        public static final /* enum */ Type ClientSide;

        /*
         * Exception decompiling
         */
        private /* synthetic */ Type() {
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
            ClientSide = new Type(GaussianFilter.ALLATORIxDEMO("\fO!A!W\u0001W|\u0011"), 0);
            ServerSide = new Type(Renderer.ALLATORIxDEMO("N\u0005h\u0011x\u0012S\u0014.R"), 1);
            $VALUES = Type.$values();
        }

        public static Type valueOf(String a) {
            return Enum.valueOf(Type.class, a);
        }

        private static /* synthetic */ Type[] $values() {
            Type[] arrtype = new Type[2];
            arrtype[0] = ClientSide;
            arrtype[1] = ServerSide;
            return arrtype;
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }
    }

    private static class Model {
        private final class_591<class_1657> modelPlayer;

        public Model() {
            Model a;
            a.modelPlayer = new class_591(new class_5617.class_5618(Wrapper.mc.method_1561(), Wrapper.mc.method_1480(), Wrapper.mc.method_1541(), Wrapper.mc.method_1561().method_43336(), Wrapper.mc.method_1478(), Wrapper.mc.method_31974(), Wrapper.mc.field_1772).method_32167(class_5602.field_27577), false);
            a.modelPlayer.method_2838().method_41924(new Vector3f(-0.3f, -0.3f, -0.3f));
        }
    }

}
