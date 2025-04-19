/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.platform.GlStateManager$class_4534
 *  com.mojang.blaze3d.platform.GlStateManager$class_4535
 *  com.mojang.blaze3d.systems.RenderSystem
 *  ladysnake.satin.api.managed.ManagedShaderEffect
 *  ladysnake.satin.api.managed.ShaderEffectManager
 *  net.minecraft.class_1041
 *  net.minecraft.class_276
 *  net.minecraft.class_279
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_761
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.api.managers;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.interfaces.IShaderEffect;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.SnowAnimation;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.minecraft.class_1041;
import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_761;
import org.bytedeco.javacv.FrameFilter;
import org.jetbrains.annotations.NotNull;

public class ShaderManager
implements Wrapper {
    public static ManagedShaderEffect DEFAULT;
    public static ManagedShaderEffect SNOW_OUTLINE;
    public static ManagedShaderEffect DEFAULT_OUTLINE;
    private static final List<RenderTask> tasks;
    public static ManagedShaderEffect SMOKE;
    public static ManagedShaderEffect RAINBOW_OUTLINE;
    public static ManagedShaderEffect FLOW_OUTLINE;
    private MyFramebuffer shaderBuffer;
    public float time = 0.0f;
    public static ManagedShaderEffect GRADIENT_OUTLINE;
    public static ManagedShaderEffect SMOKE_OUTLINE;
    public static ManagedShaderEffect FLOW;
    public static ManagedShaderEffect RAINBOW;
    public static ManagedShaderEffect GRADIENT;
    public static ManagedShaderEffect SNOW;

    public ShaderManager() {
        ShaderManager a;
    }

    public void reloadShaders() {
        DEFAULT = ShaderEffectManager.getInstance().manage(new class_2960(SnowAnimation.ALLATORIxDEMO("\"\\\u000bY\u0006J\u0015\u0016\u0017A\u0003e`R\u0016F\u0000T\r^KS\u0014A\u001e")));
        SMOKE = ShaderEffectManager.getInstance().manage(new class_2960(CameraState.ALLATORIxDEMO("K5P<Q+FaR\u001en)\u001e!S2Z>\u00193F!L")));
        GRADIENT = ShaderEffectManager.getInstance().manage(new class_2960(SnowAnimation.ALLATORIxDEMO("|9U\u000eX\u0011KII\b]\u0004>(O\u0002V\u0005X\rOKS\u0014A\u001e")));
        SNOW = ShaderEffectManager.getInstance().manage(new class_2960(CameraState.ALLATORIxDEMO(".Y9P<G=\r\u0001r.E}M3^,\u00193F!L")));
        FLOW = ShaderEffectManager.getInstance().manage(new class_2960(SnowAnimation.ALLATORIxDEMO("N\u000bY\u0002\\\u0015]_a N\u0017\u001d\nQ\fLKS\u0014A\u001e")));
        RAINBOW = ShaderEffectManager.getInstance().manage(new class_2960(CameraState.ALLATORIxDEMO("p<Y9T*GvE!Q\u00052/P;P?^,\u00193F!L")));
        DEFAULT_OUTLINE = ShaderEffectManager.getInstance().manage(new class_2960(SnowAnimation.ALLATORIxDEMO("\"\\\u000bY\u0006J\u0015\u0016\u0017A\u0003e`R\u0016F\u0000T\r^KS\u0014A\u001e")), a -> {
            ManagedShaderEffect managedShaderEffect = a;
            a = managedShaderEffect.getShaderEffect();
            if (a == null) {
                return;
            }
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), ShaderManager.mc.field_1769.method_22990());
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(CameraState.ALLATORIxDEMO("9B?z;V"), ShaderManager.mc.field_1769.method_22990());
        });
        SMOKE_OUTLINE = ShaderEffectManager.getInstance().manage(new class_2960(CameraState.ALLATORIxDEMO("K5P<Q+FaR\u001en)\u001e!S2Z>\u00193F!L")), a -> {
            ManagedShaderEffect managedShaderEffect = a;
            a = managedShaderEffect.getShaderEffect();
            if (a == null) {
                return;
            }
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), ShaderManager.mc.field_1769.method_22990());
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(CameraState.ALLATORIxDEMO("9B?z;V"), ShaderManager.mc.field_1769.method_22990());
        });
        GRADIENT_OUTLINE = ShaderEffectManager.getInstance().manage(new class_2960(SnowAnimation.ALLATORIxDEMO("|9U\u000eX\u0011KII\b]\u0004>(O\u0002V\u0005X\rOKS\u0014A\u001e")), a -> {
            ManagedShaderEffect managedShaderEffect = a;
            a = managedShaderEffect.getShaderEffect();
            if (a == null) {
                return;
            }
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), ShaderManager.mc.field_1769.method_22990());
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(CameraState.ALLATORIxDEMO("9B?z;V"), ShaderManager.mc.field_1769.method_22990());
        });
        SNOW_OUTLINE = ShaderEffectManager.getInstance().manage(new class_2960(CameraState.ALLATORIxDEMO(".Y9P<G=\r\u0001r.E}M3^,\u00193F!L")), a -> {
            ManagedShaderEffect managedShaderEffect = a;
            a = managedShaderEffect.getShaderEffect();
            if (a == null) {
                return;
            }
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), ShaderManager.mc.field_1769.method_22990());
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(CameraState.ALLATORIxDEMO("9B?z;V"), ShaderManager.mc.field_1769.method_22990());
        });
        FLOW_OUTLINE = ShaderEffectManager.getInstance().manage(new class_2960(SnowAnimation.ALLATORIxDEMO("N\u000bY\u0002\\\u0015]_a N\u0017\u001d\nQ\fLKS\u0014A\u001e")), a -> {
            ManagedShaderEffect managedShaderEffect = a;
            a = managedShaderEffect.getShaderEffect();
            if (a == null) {
                return;
            }
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), ShaderManager.mc.field_1769.method_22990());
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(CameraState.ALLATORIxDEMO("9B?z;V"), ShaderManager.mc.field_1769.method_22990());
        });
        RAINBOW_OUTLINE = ShaderEffectManager.getInstance().manage(new class_2960(CameraState.ALLATORIxDEMO("p<Y9T*GvE!Q\u00052/P;P?^,\u00193F!L")), a -> {
            ManagedShaderEffect managedShaderEffect = a;
            a = managedShaderEffect.getShaderEffect();
            if (a == null) {
                return;
            }
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), ShaderManager.mc.field_1769.method_22990());
            ((IShaderEffect)a).nullpoint_nextgen_master$addFakeTargetHook(CameraState.ALLATORIxDEMO("9B?z;V"), ShaderManager.mc.field_1769.method_22990());
        });
    }

    /*
     * Exception decompiling
     */
    public ManagedShaderEffect getShader(@NotNull Shader var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[DOLOOP]], but top level block is 2[CASE]
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

    public void renderShaders() {
        ShaderManager a;
        tasks.forEach(renderTask -> {
            RenderTask a = renderTask;
            ShaderManager a2 = this;
            a2.applyShader(a.task(), a.shader());
        });
        tasks.clear();
    }

    /*
     * WARNING - void declaration
     */
    public void renderShader(Runnable runnable, Shader shader) {
        void a;
        Object a2 = shader;
        ShaderManager a3 = this;
        tasks.add(new RenderTask((Runnable)a, (Shader)((Object)a2)));
    }

    public void applyFlow(Runnable a) {
        ShaderManager a2;
        ShaderManager shaderManager = a2;
        if (shaderManager.fullNullCheck()) {
            return;
        }
        a2 = class_310.method_1551().method_1522();
        RenderSystem.assertOnRenderThreadOrInit();
        if (shaderManager.shaderBuffer.field_1482 != ((class_276)a2).field_1482 || shaderManager.shaderBuffer.field_1481 != ((class_276)a2).field_1481) {
            ShaderManager shaderManager2 = a2;
            shaderManager.shaderBuffer.method_1234(((class_276)shaderManager2).field_1482, ((class_276)shaderManager2).field_1481, false);
        }
        GlStateManager._glBindFramebuffer((int)36009, (int)shaderManager.shaderBuffer.field_1476);
        ShaderManager shaderManager3 = shaderManager;
        shaderManager3.shaderBuffer.method_1235(true);
        a.run();
        shaderManager3.shaderBuffer.method_1240();
        ShaderManager shaderManager4 = a2;
        GlStateManager._glBindFramebuffer((int)36009, (int)((class_276)shaderManager4).field_1476);
        shaderManager4.method_1235(false);
        a = class_310.method_1551().method_1522();
        a2 = FLOW.getShaderEffect();
        if (a2 != null) {
            ((IShaderEffect)((Object)a2)).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), shaderManager.shaderBuffer);
        }
        a2 = FLOW.getShaderEffect().method_1264(CameraState.ALLATORIxDEMO("9B?z;V"));
        FLOW.setUniformValue(SnowAnimation.ALLATORIxDEMO("@\tN\fW\u0010M\u000eA\u001e"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
        FLOW.setUniformValue(CameraState.ALLATORIxDEMO("-\\#G"), shaderManager.time);
        FLOW.render(mc.method_1488());
        ShaderManager shaderManager5 = shaderManager;
        shaderManager5.time += 0.01f;
        shaderManager5.shaderBuffer.method_1230(false);
        a.method_1235(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((GlStateManager.class_4535)GlStateManager.class_4535.SRC_ALPHA, (GlStateManager.class_4534)GlStateManager.class_4534.ONE_MINUS_SRC_ALPHA, (GlStateManager.class_4535)GlStateManager.class_4535.ZERO, (GlStateManager.class_4534)GlStateManager.class_4534.ONE);
        RenderSystem.backupProjectionMatrix();
        ShaderManager shaderManager6 = a2;
        shaderManager6.method_22594(((class_276)a2).field_1482, ((class_276)shaderManager6).field_1481, false);
        RenderSystem.restoreProjectionMatrix();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }

    static {
        tasks = new ArrayList<RenderTask>();
    }

    public void applyShader(Runnable a, Shader a2) {
        ShaderManager a3;
        ShaderManager shaderManager = a3;
        if (shaderManager.fullNullCheck()) {
            return;
        }
        a3 = class_310.method_1551().method_1522();
        RenderSystem.assertOnRenderThreadOrInit();
        if (shaderManager.shaderBuffer.field_1482 != ((class_276)a3).field_1482 || shaderManager.shaderBuffer.field_1481 != ((class_276)a3).field_1481) {
            ShaderManager shaderManager2 = a3;
            shaderManager.shaderBuffer.method_1234(((class_276)shaderManager2).field_1482, ((class_276)shaderManager2).field_1481, false);
        }
        GlStateManager._glBindFramebuffer((int)36009, (int)shaderManager.shaderBuffer.field_1476);
        ShaderManager shaderManager3 = shaderManager;
        shaderManager3.shaderBuffer.method_1235(true);
        a.run();
        shaderManager3.shaderBuffer.method_1240();
        ShaderManager shaderManager4 = a3;
        GlStateManager._glBindFramebuffer((int)36009, (int)((class_276)shaderManager4).field_1476);
        shaderManager4.method_1235(false);
        a = shaderManager.getShader(a2);
        a3 = class_310.method_1551().method_1522();
        class_279 class_2792 = a.getShaderEffect();
        if (class_2792 != null) {
            ((IShaderEffect)class_2792).nullpoint_nextgen_master$addFakeTargetHook(SnowAnimation.ALLATORIxDEMO("\u0007L\u0001g\u001e"), shaderManager.shaderBuffer);
        }
        class_2792 = a.getShaderEffect().method_1264(CameraState.ALLATORIxDEMO("9B?z;V"));
        ShaderManager shaderManager5 = shaderManager;
        shaderManager5.setupShader(a2, (ManagedShaderEffect)a);
        shaderManager5.shaderBuffer.method_1230(false);
        a3.method_1235(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((GlStateManager.class_4535)GlStateManager.class_4535.SRC_ALPHA, (GlStateManager.class_4534)GlStateManager.class_4534.ONE_MINUS_SRC_ALPHA, (GlStateManager.class_4535)GlStateManager.class_4535.ZERO, (GlStateManager.class_4534)GlStateManager.class_4534.ONE);
        RenderSystem.backupProjectionMatrix();
        class_279 class_2793 = class_2792;
        class_2793.method_22594(class_2792.field_1482, class_2793.field_1481, false);
        RenderSystem.restoreProjectionMatrix();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }

    /*
     * Exception decompiling
     */
    public ManagedShaderEffect getShaderOutline(@NotNull Shader var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[DOLOOP]], but top level block is 2[CASE]
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

    public boolean fullNullCheck() {
        ShaderManager a;
        if (GRADIENT == null || SMOKE == null || DEFAULT == null || FLOW == null || RAINBOW == null || GRADIENT_OUTLINE == null || SMOKE_OUTLINE == null || DEFAULT_OUTLINE == null || FLOW_OUTLINE == null || RAINBOW_OUTLINE == null || a.shaderBuffer == null) {
            if (mc.method_1522() == null) {
                return true;
            }
            a.shaderBuffer = new MyFramebuffer(ShaderManager.mc.method_1522().field_1482, ShaderManager.mc.method_1522().field_1481);
            a.reloadShaders();
            return true;
        }
        return false;
    }

    public void setupShader(Shader a, ManagedShaderEffect a2) {
        Wrapper a3;
        ShaderManager shaderManager = a3;
        a3 = dev.recollect.hana.mod.modules.impl.render.Shader.INSTANCE;
        if (a == Shader.Rainbow) {
            ManagedShaderEffect managedShaderEffect = a2;
            ManagedShaderEffect managedShaderEffect2 = a2;
            ManagedShaderEffect managedShaderEffect3 = a2;
            a2.setUniformValue(SnowAnimation.ALLATORIxDEMO("Z\tI\u000fOB"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getAlpha() / 255.0f);
            managedShaderEffect3.setUniformValue(CameraState.ALLATORIxDEMO(")V=\\;Q"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).radius.getValueFloat());
            managedShaderEffect3.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0012N\u0004U\u000eZ\t"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoothness.getValueFloat());
            managedShaderEffect2.setUniformValue(CameraState.ALLATORIxDEMO("U2A0Q+P"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).divider.getValueFloat());
            managedShaderEffect2.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0001\\\u001bh\u0004T\u0017B\u0015"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).maxSample.getValueFloat());
            managedShaderEffect.setUniformValue(CameraState.ALLATORIxDEMO(" [.^7B-\\!L"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
            managedShaderEffect.setUniformValue(SnowAnimation.ALLATORIxDEMO("M\u000eC\u0015"), shaderManager.time);
            managedShaderEffect.render(mc.method_1488());
            shaderManager.time += (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).speed.getValue() * 0.002f;
            return;
        }
        if (a == Shader.Gradient) {
            ManagedShaderEffect managedShaderEffect = a2;
            ManagedShaderEffect managedShaderEffect4 = a2;
            ManagedShaderEffect managedShaderEffect5 = a2;
            ManagedShaderEffect managedShaderEffect6 = a2;
            ManagedShaderEffect managedShaderEffect7 = a2;
            managedShaderEffect7.setUniformValue(CameraState.ALLATORIxDEMO(":[)]/\u0010"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getAlpha() / 255.0f);
            managedShaderEffect7.setUniformValue(SnowAnimation.ALLATORIxDEMO("\bM\u0004"), (int)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).octaves.getValue());
            managedShaderEffect6.setUniformValue(CameraState.ALLATORIxDEMO(")V=\\;Q"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).radius.getValueFloat());
            managedShaderEffect6.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0012N\u0004U\u000eZ\t"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoothness.getValueFloat());
            managedShaderEffect5.setUniformValue(CameraState.ALLATORIxDEMO("U2A0Q+P"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).divider.getValueFloat());
            managedShaderEffect5.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0001\\\u001bh\u0004T\u0017B\u0015"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).maxSample.getValueFloat());
            managedShaderEffect4.setUniformValue(CameraState.ALLATORIxDEMO("=V:A!P"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).factor.getValue());
            managedShaderEffect4.setUniformValue(SnowAnimation.ALLATORIxDEMO("P\f@\tz\u0011Z\u0001P\u0002@\u0004"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).gradient.getValue());
            managedShaderEffect.setUniformValue(CameraState.ALLATORIxDEMO(" [.^7B-\\!L"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
            managedShaderEffect.setUniformValue(SnowAnimation.ALLATORIxDEMO("M\u000eC\u0015"), shaderManager.time);
            managedShaderEffect.render(mc.method_1488());
            shaderManager.time += (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).speed.getValue() * 0.002f;
            return;
        }
        if (a == Shader.Smoke) {
            ManagedShaderEffect managedShaderEffect = a2;
            ManagedShaderEffect managedShaderEffect8 = a2;
            ManagedShaderEffect managedShaderEffect9 = a2;
            ManagedShaderEffect managedShaderEffect10 = a2;
            ManagedShaderEffect managedShaderEffect11 = a2;
            a2.setUniformValue(CameraState.ALLATORIxDEMO(":[)]/\u0013"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getAlpha() / 255.0f);
            managedShaderEffect11.setUniformValue(SnowAnimation.ALLATORIxDEMO("I\u0004]\u000e[\u0003"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).radius.getValueFloat());
            managedShaderEffect11.setUniformValue(CameraState.ALLATORIxDEMO("@.V5\\:["), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoothness.getValueFloat());
            managedShaderEffect10.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0007R\u0013P\u0003K\u0002"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).divider.getValueFloat());
            managedShaderEffect10.setUniformValue(CameraState.ALLATORIxDEMO("S<I\bV4E\"G"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).maxSample.getValueFloat());
            managedShaderEffect9.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0003P\u0015]\u0004"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke1.getValue().getRed() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke1.getValue().getGreen() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke1.getValue().getBlue() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke1.getValue().getAlpha() / 255.0f);
            managedShaderEffect9.setUniformValue(CameraState.ALLATORIxDEMO("(R:Z F"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke2.getValue().getRed() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke2.getValue().getGreen() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke2.getValue().getBlue() / 255.0f);
            managedShaderEffect8.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0011Q\u000e\\\u0014"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke3.getValue().getRed() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke3.getValue().getGreen() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoke3.getValue().getBlue() / 255.0f);
            managedShaderEffect8.setUniformValue(CameraState.ALLATORIxDEMO("Z-V"), (int)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).octaves.getValue());
            managedShaderEffect.setUniformValue(SnowAnimation.ALLATORIxDEMO("@\tN\fW\u0010M\u000eA\u001e"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
            managedShaderEffect.setUniformValue(CameraState.ALLATORIxDEMO("-\\#G"), shaderManager.time);
            managedShaderEffect.render(mc.method_1488());
            shaderManager.time += (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).speed.getValue() * 0.002f;
            return;
        }
        if (a == Shader.Solid) {
            ManagedShaderEffect managedShaderEffect = a2;
            ManagedShaderEffect managedShaderEffect12 = a2;
            ManagedShaderEffect managedShaderEffect13 = a2;
            ManagedShaderEffect managedShaderEffect14 = a2;
            managedShaderEffect14.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0001T\u001b}\u0004Z\u0013A\u0002"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getAlpha() / 255.0f);
            managedShaderEffect14.setUniformValue(CameraState.ALLATORIxDEMO("0X5v5E&C"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).alpha.getValueFloat() / 255.0f);
            managedShaderEffect13.setUniformValue(SnowAnimation.ALLATORIxDEMO("I\u0004]\u000e[\u0003"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).radius.getValueFloat());
            managedShaderEffect13.setUniformValue(CameraState.ALLATORIxDEMO("@.V5\\:["), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoothness.getValueFloat());
            managedShaderEffect12.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0007R\u0013P\u0003K\u0002"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).divider.getValueFloat());
            managedShaderEffect12.setUniformValue(CameraState.ALLATORIxDEMO("S<I\bV4E\"G"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).maxSample.getValueFloat());
            managedShaderEffect.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0006V\u000bA\u0002"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getRed() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getGreen() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getBlue() / 255.0f);
            managedShaderEffect.setUniformValue(CameraState.ALLATORIxDEMO(" [.^7B-\\!L"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
            managedShaderEffect.render(mc.method_1488());
            return;
        }
        if (a == Shader.Snow) {
            ManagedShaderEffect managedShaderEffect = a2;
            ManagedShaderEffect managedShaderEffect15 = a2;
            ManagedShaderEffect managedShaderEffect16 = a2;
            a2.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0006V\u000bA\u0002"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getRed() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getGreen() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getBlue() / 255.0f, (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getAlpha() / 255.0f);
            managedShaderEffect16.setUniformValue(CameraState.ALLATORIxDEMO(")V=\\;Q"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).radius.getValueFloat());
            managedShaderEffect16.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0012N\u0004U\u000eZ\t"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoothness.getValueFloat());
            managedShaderEffect15.setUniformValue(CameraState.ALLATORIxDEMO("U2A0Q+P"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).divider.getValueFloat());
            managedShaderEffect15.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0001\\\u001bh\u0004T\u0017B\u0015"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).maxSample.getValueFloat());
            managedShaderEffect.setUniformValue(CameraState.ALLATORIxDEMO(" [.^7B-\\!L"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
            managedShaderEffect.setUniformValue(SnowAnimation.ALLATORIxDEMO("M\u000eC\u0015"), shaderManager.time);
            managedShaderEffect.render(mc.method_1488());
            shaderManager.time += (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).speed.getValue() * 0.002f;
            return;
        }
        if (a == Shader.Flow) {
            ManagedShaderEffect managedShaderEffect = a2;
            ManagedShaderEffect managedShaderEffect17 = a2;
            ManagedShaderEffect managedShaderEffect18 = a2;
            a2.setUniformValue(CameraState.ALLATORIxDEMO("S4I\u001dV:A!P"), (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).fill.getValue().getAlpha() / 255.0f);
            managedShaderEffect18.setUniformValue(SnowAnimation.ALLATORIxDEMO("I\u0004]\u000e[\u0003"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).radius.getValueFloat());
            managedShaderEffect18.setUniformValue(CameraState.ALLATORIxDEMO("@.V5\\:["), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).smoothness.getValueFloat());
            managedShaderEffect17.setUniformValue(SnowAnimation.ALLATORIxDEMO("\u0007R\u0013P\u0003K\u0002"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).divider.getValueFloat());
            managedShaderEffect17.setUniformValue(CameraState.ALLATORIxDEMO("S<I\bV4E\"G"), ((dev.recollect.hana.mod.modules.impl.render.Shader)a3).maxSample.getValueFloat());
            managedShaderEffect.setUniformValue(SnowAnimation.ALLATORIxDEMO("@\tN\fW\u0010M\u000eA\u001e"), (float)mc.method_22683().method_4486(), (float)mc.method_22683().method_4502());
            managedShaderEffect.setUniformValue(CameraState.ALLATORIxDEMO("-\\#G"), shaderManager.time);
            managedShaderEffect.render(mc.method_1488());
            shaderManager.time += (float)((dev.recollect.hana.mod.modules.impl.render.Shader)a3).speed.getValue() * 0.002f;
        }
    }

    public static final class RenderTask
    extends Record {
        private final Shader shader;
        private final Runnable task;

        /*
         * WARNING - void declaration
         */
        public RenderTask(Runnable runnable, Shader shader) {
            RenderTask a;
            void a2;
            Object a3 = shader;
            RenderTask renderTask = a = this;
            renderTask.task = a2;
            renderTask.shader = a3;
        }

        public Shader shader() {
            RenderTask a;
            return a.shader;
        }

        public Runnable task() {
            RenderTask a;
            return a.task;
        }

        @Override
        public final int hashCode() {
            RenderTask a;
            return (int)ObjectMethods.bootstrap(new MethodHandle[]{RenderTask.class, "task;shader", }