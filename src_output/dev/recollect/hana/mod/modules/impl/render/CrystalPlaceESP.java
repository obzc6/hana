/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_898;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class CrystalPlaceESP
extends Module {
    SliderSetting rangeValue;
    SliderSetting pointsNew;
    EnumSetting mode;
    BooleanSetting range;
    private final Timer timer;
    ColorSetting color;
    private final ConcurrentHashMap<class_1511, RenderInfo> cryList;
    SliderSetting fadeSpeed;
    SliderSetting interval;
    SliderSetting animationTime;

    public CrystalPlaceESP() {
        CrystalPlaceESP a;
        CrystalPlaceESP crystalPlaceESP = a;
        super(Packet.ALLATORIxDEMO("NdHhHxROT^{LKy]"), Module.Category.Render);
        CrystalPlaceESP crystalPlaceESP2 = a;
        crystalPlaceESP2.range = crystalPlaceESP.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO(" O\u0004B\f!\u0015v?s7"), true)).setParent();
        crystalPlaceESP.rangeValue = crystalPlaceESP.add(new SliderSetting(Packet.ALLATORIxDEMO("JH`Mh"), 12, 0, 256, object -> {
            Object a = object;
            CrystalPlaceESP a2 = this;
            return a2.range.getValue();
        }));
        CrystalPlaceESP crystalPlaceESP3 = a;
        crystalPlaceESP3.color = crystalPlaceESP3.add(new ColorSetting(ProjectionUtils.ALLATORIxDEMO("B({>fr"), new Color(255, 255, 255, 150)));
        crystalPlaceESP3.animationTime = crystalPlaceESP3.add(new SliderSetting(Packet.ALLATORIxDEMO("W_rQxJvWQL@cO-"), 500, 0, 1500));
        crystalPlaceESP3.fadeSpeed = crystalPlaceESP3.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("'@\u0003d\u0014g4q6"), 500.0, 0.0, 1500.0, 0.1));
        crystalPlaceESP3.mode = crystalPlaceESP3.add(new EnumSetting<Mode>(Packet.ALLATORIxDEMO("daNh"), Mode.Normal));
        crystalPlaceESP3.pointsNew = crystalPlaceESP3.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("Q(~?`!"), 3, 1, 10, object -> {
            Object a = object;
            CrystalPlaceESP a2 = this;
            return a2.mode.getValue() == Mode.Normal;
        }));
        a.interval = a.add(new SliderSetting(Packet.ALLATORIxDEMO("wqLZj_oF-"), 2, 1, 100, object -> {
            Object a = object;
            CrystalPlaceESP a2 = this;
            return a2.mode.getValue() == Mode.New;
        }));
        a.cryList = new ConcurrentHashMap();
        a.timer = new Timer();
        a.setChinese(ProjectionUtils.ALLATORIxDEMO("\u6c35\u6631\u6529\u7f3f\u662a\u7968"));
    }

    @Override
    public void onDisable() {
        CrystalPlaceESP a;
        a.cryList.clear();
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void draw(class_4587 class_45872, class_1511 class_15112, long l, long l2) {
        long a;
        long a2;
        CrystalPlaceESP a3 = class_15112;
        CrystalPlaceESP a4 = this;
        a2 = System.currentTimeMillis() - a2;
        a = System.currentTimeMillis() - a;
        if ((double)a2 <= a4.animationTime.getValue()) {
            void a5;
            CrystalPlaceESP.drawCircle3D((class_4587)a5, (class_1297)a3, (float)a2 / a4.fadeSpeed.getValueFloat(), (float)a / 1000.0f, a4.color.getValue());
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void lambda$onRender3D$3(class_4587 class_45872, class_1511 class_15112, RenderInfo renderInfo) {
        void a;
        RenderInfo a2 = renderInfo;
        CrystalPlaceESP a3 = this;
        Object object = a2;
        a3.draw((class_4587)a, ((RenderInfo)object).entity, ((RenderInfo)object).time, a2.time);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCircle3D(class_4587 class_45872, class_1297 class_12972, float f, float f2, Color color) {
        void a;
        int n;
        class_4587 a2 = class_12972;
        class_4587 a3 = class_45872;
        Render3DUtil.setupRender();
        GL11.glDisable((int)2929);
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        class_2872.method_1328(class_293.class_5596.field_29345, class_290.field_1576);
        GL11.glLineWidth((float)2.0f);
        class_4587 class_45873 = a2;
        double d = a2.field_6014 + (class_45873.method_23317() - a2.field_6014) * (double)mc.method_1488() - CrystalPlaceESP.mc.method_1561().field_4686.method_19326().method_10216();
        class_4587 class_45874 = a2;
        double d2 = class_45873.field_6036 + (class_45874.method_23318() - a2.field_6036) * (double)mc.method_1488() - CrystalPlaceESP.mc.method_1561().field_4686.method_19326().method_10214();
        double d3 = class_45874.field_5969 + (a2.method_23321() - a2.field_5969) * (double)mc.method_1488() - CrystalPlaceESP.mc.method_1561().field_4686.method_19326().method_10215();
        class_4587 class_45875 = a3;
        class_45875.method_22903();
        class_45875.method_22904(d, d2, d3);
        a2 = a3.method_23760().method_23761();
        int n2 = n = 0;
        while (n2 <= 180) {
            void a4;
            void a5;
            class_4588 class_45882 = class_2872.method_22918((Matrix4f)a2, (float)((double)a5 * Math.cos((double)n * 6.28 / 45.0)), 0.0f, (float)((double)a5 * Math.sin((double)n * 6.28 / 45.0)));
            class_45882.method_39415(a4.getRGB()).method_1344();
            n2 = ++n;
        }
        class_2892.method_1350();
        Render3DUtil.endRender();
        class_4587 class_45876 = a3;
        class_45876.method_22904(-d, -d2 + (double)a, -d3);
        GL11.glEnable((int)2929);
        class_45876.method_22909();
    }

    /*
     * WARNING - void declaration
     */
    @EventHandler
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        CrystalPlaceESP crystalPlaceESP;
        void a;
        float a222 = f;
        CrystalPlaceESP a3 = this;
        Iterator<class_1297> a222 = new Iterable<class_1297>(a3){
            final /* synthetic */ CrystalPlaceESP this$0;
            {
                CrystalPlaceESP a = crystalPlaceESP;
                1 a2 = this;
                a2.this$0 = a;
            }

            @Override
            public Iterator<class_1297> iterator() {
                return Wrapper.mc.field_1687.method_18112().iterator();
            }
        }.iterator();
        block0 : do {
            Iterator<class_1297> iterator = a222;
            while (iterator.hasNext()) {
                class_1297 class_12972 = a222.next();
                if (!(class_12972 instanceof class_1511)) {
                    iterator = a222;
                    continue;
                }
                if (a3.range.getValue() && (double)CrystalPlaceESP.mc.field_1724.method_5739(class_12972) > a3.rangeValue.getValue()) {
                    iterator = a222;
                    continue;
                }
                if (a3.cryList.containsKey((Object)class_12972)) continue block0;
                a3.cryList.put((class_1511)class_12972, new RenderInfo((class_1511)class_12972, System.currentTimeMillis()));
                continue block0;
            }
            break;
        } while (true);
        CrystalPlaceESP crystalPlaceESP2 = a3;
        if (((Enum)a3.mode.getValue()).equals((Object)Mode.Normal)) {
            crystalPlaceESP2.cryList.forEach((arg_0, arg_1) -> a3.lambda$onRender3D$3((class_4587)a, arg_0, arg_1));
            crystalPlaceESP = a3;
        } else {
            if (((Enum)crystalPlaceESP2.mode.getValue()).equals((Object)Mode.New)) {
                int n;
                int a222 = 0;
                int n2 = n = 0;
                while ((double)n2 < a3.pointsNew.getValue()) {
                    if (a3.timer.passedMs(500L)) {
                        int n3 = a222;
                        a3.cryList.forEach((arg_0, arg_1) -> a3.lambda$onRender3D$4((class_4587)a, n3, arg_0, arg_1));
                    }
                    a222 = (int)((double)a222 + a3.interval.getValue());
                    n2 = ++n;
                }
            }
            crystalPlaceESP = a3;
        }
        crystalPlaceESP.cryList.forEach((class_15112, renderInfo) -> {
            void a;
            CrystalPlaceESP a2 = class_15112;
            CrystalPlaceESP a3 = this;
            if ((double)(System.currentTimeMillis() - a.time) > a3.animationTime.getValue() && !a2.method_5805()) {
                a3.cryList.remove(a2);
            }
            if ((double)(System.currentTimeMillis() - a.time) > a3.animationTime.getValue() && (double)CrystalPlaceESP.mc.field_1724.method_5739((class_1297)a2) > a3.rangeValue.getValue()) {
                a3.cryList.remove(a2);
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void lambda$onRender3D$4(class_4587 class_45872, int n, class_1511 class_15112, RenderInfo renderInfo) {
        void a;
        void a2;
        RenderInfo a3;
        CrystalPlaceESP crystalPlaceESP = renderInfo2;
        RenderInfo renderInfo2 = renderInfo;
        CrystalPlaceESP a4 = crystalPlaceESP;
        RenderInfo renderInfo3 = a3;
        a4.draw((class_4587)a, renderInfo3.entity, renderInfo3.time - (long)a2, a3.time - (long)a2);
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode New;
        public static final /* enum */ Mode Normal;

        static {
            Normal = new Mode(Start.ALLATORIxDEMO("bmCr\u001a9"), 0);
            New = new Mode(RenderHelper.ALLATORIxDEMO("FX5"), 1);
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
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

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[2];
            arrmode[0] = Normal;
            arrmode[1] = New;
            return arrmode;
        }
    }

    static final class RenderInfo
    extends Record {
        private final class_1511 entity;
        private final long time;

        @Override
        public final String toString() {
            RenderInfo a;
            return ObjectMethods.bootstrap(new MethodHandle[]{RenderInfo.class, "entity;time", }