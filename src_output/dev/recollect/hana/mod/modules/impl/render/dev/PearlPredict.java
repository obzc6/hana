/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1684
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.EntitySpawnEvent;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1684;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class PearlPredict
extends Module {
    private final ColorSetting color;
    public Map<class_1684, FakeEntity> map;
    static class_4587 matrixStack;

    /*
     * Exception decompiling
     */
    private /* synthetic */ void calcTrajectory(float var1_3, float var2_5, class_243 var3_7, class_243 var4_8) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 2[WHILELOOP]
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

    public PearlPredict() {
        PearlPredict a;
        PearlPredict pearlPredict = a;
        super(BaseChildSettings.ALLATORIxDEMO("\"cF!L\u0004U6^'\u0013p"), Module.Category.Render);
        PearlPredict pearlPredict2 = a;
        pearlPredict2.map = new ConcurrentHashMap<class_1684, FakeEntity>();
        pearlPredict.color = pearlPredict.add(new ColorSetting(Hole.ALLATORIxDEMO("D\fvF\""), new Color(255, 255, 255, 255)));
        pearlPredict.setChinese(BaseChildSettings.ALLATORIxDEMO("\u73f7\u73ae\u98f4\u5220"));
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        Iterator a;
        float a22 = f;
        PearlPredict a3 = this;
        matrixStack = a;
        if (PearlPredict.nullCheck()) {
            return;
        }
        RenderSystem.disableDepthTest();
        for (class_1297 a22 : PearlPredict.mc.field_1687.method_18112()) {
            if (a22 instanceof class_1684) {
                class_1684 class_16842 = (class_1684)a22;
                FakeEntity fakeEntity = a3.map.get((Object)class_16842);
                if (fakeEntity == null) continue;
                FakeEntity fakeEntity2 = fakeEntity;
                FakeEntity fakeEntity3 = fakeEntity;
                a3.calcTrajectory(fakeEntity2.yaw, fakeEntity2.pitch, fakeEntity3.pos, fakeEntity3.velocity);
                continue;
            }
            if (!(a22 instanceof class_1657) || (a22 = (class_1657)a22) == PearlPredict.mc.field_1724 || a22.method_6047().method_7909() != class_1802.field_8634 && a22.method_6079().method_7909() != class_1802.field_8634) continue;
            class_1297 class_12972 = a22;
            class_1297 class_12973 = a22;
            double d = class_12972.field_6014 + (class_12973.method_23317() - a22.field_6014) * (double)mc.method_1488();
            double d2 = class_12973.field_6036 + (a22.method_23318() - a22.field_6036) * (double)mc.method_1488();
            double d3 = class_12972.field_5969 + (a22.method_23321() - a22.field_5969) * (double)mc.method_1488();
            a3.calcTrajectory(a22.method_5705(mc.method_1488()), a22.method_5695(mc.method_1488()), new class_243(d, d2, d3), a22.method_18798());
        }
        RenderSystem.enableDepthTest();
    }

    private static /* synthetic */ double lambda$onReceivePacket$0(class_1684 class_16842, class_742 class_7422) {
        class_1684 a = class_7422;
        class_1684 a2 = class_16842;
        return a.method_19538().method_1022(new class_243(a2.method_23317(), a2.method_23318(), a2.method_23321()));
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void lambda$onReceivePacket$1(class_1684 class_16842, class_742 class_7422) {
        void a;
        PearlPredict a2 = class_7422;
        PearlPredict a3 = this;
        a3.map.put((class_1684)a, new FakeEntity(a2.method_19538(), a2.method_36454(), a2.method_36455(), a2.method_18798()));
    }

    @EventHandler
    public void onReceivePacket(EntitySpawnEvent entitySpawnEvent) {
        Object a = entitySpawnEvent;
        PearlPredict a2 = this;
        if (PearlPredict.nullCheck()) {
            return;
        }
        class_1297 class_12972 = ((EntitySpawnEvent)a).getEntity();
        if (class_12972 instanceof class_1684) {
            a = (class_1684)class_12972;
            PearlPredict.mc.field_1687.method_18456().stream().min(Comparator.comparingDouble(arg_0 -> PearlPredict.lambda$onReceivePacket$0((class_1684)a, arg_0))).ifPresent(arg_0 -> a2.lambda$onReceivePacket$1((class_1684)a, arg_0));
        }
    }

    private static final class FakeEntity
    extends Record {
        private final float yaw;
        private final class_243 velocity;
        private final float pitch;
        private final class_243 pos;

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ FakeEntity(class_243 class_2432, float f, float f2, class_243 class_2433) {
            void a;
            void a2;
            void a3;
            FakeEntity a4;
            FakeEntity a5;
            FakeEntity fakeEntity = fakeEntity2;
            FakeEntity fakeEntity2 = class_2433;
            FakeEntity fakeEntity3 = a5 = fakeEntity;
            FakeEntity fakeEntity4 = a5;
            fakeEntity4.pos = a3;
            fakeEntity4.yaw = a2;
            fakeEntity3.pitch = a;
            fakeEntity3.velocity = a4;
        }

        public float pitch() {
            FakeEntity a;
            return a.pitch;
        }

        @Override
        public final boolean equals(Object object) {
            Object a = object;
            FakeEntity a2 = this;
            return (boolean)ObjectMethods.bootstrap(new MethodHandle[]{FakeEntity.class, "pos;yaw;pitch;velocity", }