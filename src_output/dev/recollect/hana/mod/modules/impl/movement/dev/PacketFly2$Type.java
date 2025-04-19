/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.impl.movement.dev.PacketFly2;
import dev.recollect.hana.mod.modules.settings.Setting;
import java.util.Random;
import net.minecraft.class_243;
import org.bytedeco.javacv.BaseChildSettings;

public static abstract class PacketFly2.Type
extends Enum<PacketFly2.Type> {
    public static final /* enum */ PacketFly2.Type Switch;
    public static final /* enum */ PacketFly2.Type Down;
    public static final /* enum */ PacketFly2.Type X;
    private static final /* synthetic */ PacketFly2.Type[] $VALUES;
    public static final /* enum */ PacketFly2.Type Z;
    public static final /* enum */ PacketFly2.Type XZ;
    public static final /* enum */ PacketFly2.Type Up;
    public static final /* enum */ PacketFly2.Type Preserve;

    public static PacketFly2.Type[] values() {
        return (PacketFly2.Type[])$VALUES.clone();
    }

    private static /* synthetic */ PacketFly2.Type[] $values() {
        PacketFly2.Type[] arrtype = new PacketFly2.Type[7];
        arrtype[0] = Down;
        arrtype[1] = Up;
        arrtype[2] = Preserve;
        arrtype[3] = Switch;
        arrtype[4] = X;
        arrtype[5] = Z;
        arrtype[6] = XZ;
        return arrtype;
    }

    public static PacketFly2.Type valueOf(String a) {
        return Enum.valueOf(PacketFly2.Type.class, a);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ PacketFly2.Type() {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public abstract class_243 createOutOfBounds(class_243 var1, int var2);

    static {
        Down = new PacketFly2.Type(Setting.ALLATORIxDEMO("B*;a"), 0){
            {
                int a = n;
                1 var2_4 = this;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                void a;
                int a2 = n;
                1 a3 = this;
                return a.method_1031(0.0, (double)(-a2), 0.0);
            }
        };
        Up = new PacketFly2.Type(BaseChildSettings.ALLATORIxDEMO("%t"), 1){

            /*
             * WARNING - void declaration
             */
            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                void a;
                int a2 = n;
                2 a3 = this;
                return a.method_1031(0.0, (double)a2, 0.0);
            }
            {
                int a = n;
                2 var2_4 = this;
            }
        };
        Preserve = new PacketFly2.Type(Setting.ALLATORIxDEMO("L-~+c7:j"), 2){
            private final Random random;

            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                3 a = class_2432;
                3 a2 = this;
                return a.method_1031((double)a2.randomInt(), 0.0, (double)a2.randomInt());
            }

            private /* synthetic */ int randomInt() {
                3 a22;
                3 var1_2;
                3 v0 = var1_2 = a22;
                int a22 = v0.random.nextInt(29000000);
                if (v0.random.nextBoolean()) {
                    return a22;
                }
                return -a22;
            }
            {
                int a = n;
                3 var2_4 = this;
                3 v0 = var2_4;
                v0.random = new Random();
            }
        };
        Switch = new PacketFly2.Type(BaseChildSettings.ALLATORIxDEMO("t$S:\u0013l"), 3){
            private final Random random;

            /*
             * WARNING - void declaration
             */
            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                void a;
                int a2 = n;
                4 a3 = this;
                if (a3.random.nextBoolean()) {
                    return a.method_1031(0.0, (double)(-a2), 0.0);
                }
                return a.method_1031(0.0, (double)a2, 0.0);
            }
            {
                int a = n;
                4 var2_4 = this;
                4 v0 = var2_4;
                v0.random = new Random();
            }
        };
        X = new PacketFly2.Type(Setting.ALLATORIxDEMO("W"), 4){
            {
                int a = n;
                5 var2_4 = this;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                void a;
                int a2 = n;
                5 a3 = this;
                return a.method_1031((double)a2, 0.0, 0.0);
            }
        };
        Z = new PacketFly2.Type(BaseChildSettings.ALLATORIxDEMO("^"), 5){
            {
                int a = n;
                6 var2_4 = this;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                void a;
                int a2 = n;
                6 a3 = this;
                return a.method_1031(0.0, 0.0, (double)a2);
            }
        };
        XZ = new PacketFly2.Type(Setting.ALLATORIxDEMO("\u0014U"), 6){

            /*
             * WARNING - void declaration
             */
            @Override
            public class_243 createOutOfBounds(class_243 class_2432, int n) {
                void a;
                int a2 = n;
                7 a3 = this;
                return a.method_1031((double)a2, 0.0, (double)a2);
            }
            {
                int a = n;
                7 var2_4 = this;
            }
        };
        $VALUES = PacketFly2.Type.$values();
    }

}
