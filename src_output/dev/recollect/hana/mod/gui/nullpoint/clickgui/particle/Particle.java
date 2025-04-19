/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.particle;

import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.util.Random;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_4587;

public class Particle {
    private double maxRadius;
    public float radius;
    private static final Random random = new Random();
    private double minRadius;
    public int[] pos;
    private boolean grow;
    public float x;
    public State state;
    public float y;

    /*
     * WARNING - void declaration
     */
    public Particle(int n, int n2) {
        Particle particle;
        void a;
        Particle a2;
        int a3 = n2;
        Particle particle2 = a2 = this;
        Particle particle3 = a2;
        Particle particle4 = a2;
        particle4.radius = random.nextInt(2) + 1;
        particle4.maxRadius = 0.5;
        particle3.minRadius = 1.0;
        particle3.state = State.ONE;
        particle3.pos = new int[2];
        a2.x = (float)a;
        particle2.y = a3;
        particle2.grow = particle.radius < 2.0f;
        Particle particle5 = a2;
        particle5.pos[0] = a;
        particle5.pos[1] = a3;
    }

    private /* synthetic */ void changeRadius() {
        Particle a;
        if (a.grow) {
            Particle particle = a;
            particle.radius = (float)((double)particle.radius + 0.1);
            if ((double)particle.radius > a.maxRadius) {
                a.grow = false;
                return;
            }
        } else {
            Particle particle = a;
            particle.radius = (float)((double)particle.radius - 0.1);
            if ((double)particle.radius < a.minRadius) {
                a.grow = true;
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void drawScreen(class_4587 class_45872, int n, int n2, float f) {
        void a;
        int a22 = n;
        Particle a3 = this;
        Color a22 = new Color(255, 255, 255, 255);
        Particle particle = a3;
        particle.changeRadius();
        particle.changePos(class_310.method_1551().method_22683().method_4502());
        void v1 = a;
        void v2 = a;
        Particle particle2 = a3;
        Particle particle3 = a3;
        Render2DUtil.drawRound((class_4587)v2, a3.x - particle2.radius, particle3.y - particle3.radius, a3.radius * 2.0f, a3.radius * 2.0f, a3.radius, a22);
        Particle particle4 = a3;
        Color color = a22;
        Render2DUtil.drawRectHorizontal((class_4587)v2, particle2.x, particle4.y - 1.8f, 0.2f, 3.6f, color, color);
        Particle particle5 = a3;
        Color color2 = a22;
        Render2DUtil.drawRectHorizontal((class_4587)v2, particle4.x - 0.2f, particle5.y - 1.8f, 0.2f, 3.6f, color2, color2);
        Color color3 = a22;
        Render2DUtil.drawRectHorizontal((class_4587)v1, particle5.x - 1.8f, a3.y - 0.8f, 3.6f, 1.6f, color3, color3);
        Color color4 = a22;
        Render2DUtil.drawRectHorizontal((class_4587)v1, particle.x - 1.8f, a3.y + 0.8f, 3.6f, 1.6f, color4, color4);
    }

    private /* synthetic */ void changePos(int n) {
        Particle a;
        int a2 = n;
        Particle particle = a = this;
        particle.x += random.nextFloat() - 0.5f;
        particle.y += 1.2f;
        if (particle.y > (float)a2) {
            a.y = 0.0f;
        }
    }

    private static final class State
    extends Enum<State> {
        public static final /* enum */ State TWO;
        public static final /* enum */ State ONE;
        public static final /* enum */ State THREE;
        private static final /* synthetic */ State[] $VALUES;

        public static State valueOf(String a) {
            return Enum.valueOf(State.class, a);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static /* synthetic */ State[] $values() {
            State[] arrstate = new State[3];
            arrstate[0] = ONE;
            arrstate[1] = TWO;
            arrstate[2] = THREE;
            return arrstate;
        }

        static {
            ONE = new State(RenderHelper.ALLATORIxDEMO("Gs\u0007"), 0);
            TWO = new State(Packet.ALLATORIxDEMO("}Hw"), 1);
            THREE = new State(RenderHelper.ALLATORIxDEMO("A?Zx\u0007"), 2);
            $VALUES = State.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ State() {
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
    }

}
