/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1267
 *  net.minecraft.class_1280
 *  net.minecraft.class_1282
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1320
 *  net.minecraft.class_1324
 *  net.minecraft.class_1656
 *  net.minecraft.class_1657
 *  net.minecraft.class_1890
 *  net.minecraft.class_1927
 *  net.minecraft.class_1927$class_4179
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_5134
 *  net.minecraft.class_638
 *  net.minecraft.class_8109
 */
package dev.recollect.hana.api.utils.combat;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IExplosion;
import net.minecraft.class_1267;
import net.minecraft.class_1280;
import net.minecraft.class_1282;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1320;
import net.minecraft.class_1324;
import net.minecraft.class_1656;
import net.minecraft.class_1657;
import net.minecraft.class_1890;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_5134;
import net.minecraft.class_638;
import net.minecraft.class_8109;

/*
 * Exception performing whole class analysis ignored.
 */
public class MeteorExplosionUtil
implements Wrapper {
    public static final class_1927 explosion = new class_1927((class_1937)MeteorExplosionUtil.mc.field_1687, null, 0.0, 0.0, 0.0, 6.0f, false, class_1927.class_4179.field_18687);

    /*
     * WARNING - void declaration
     */
    public static double explosionDamage(class_1657 class_16572, class_243 class_2432, class_1657 class_16573, float f) {
        void a;
        class_1657 a2;
        double d;
        double d2;
        class_1657 a3 = class_2432;
        class_1657 a4 = class_16572;
        if (a4 != null && a4.method_31549().field_7477) {
            return 0.0;
        }
        if (a2 == null) {
            a2 = a4;
        }
        double d3 = Math.sqrt(a2.method_5707((class_243)a3));
        if (d > 10.0) {
            return 0.0;
        }
        double d4 = class_1927.method_17752((class_243)a3, (class_1297)a2);
        d3 = (1.0 - d3 / 10.0) * d4;
        d3 = (d3 * d3 + d3) / 2.0 * 7.0 * 10.0 + 1.0;
        d3 = MeteorExplosionUtil.getDamageForDifficulty(d3);
        d3 = MeteorExplosionUtil.resistanceReduction((class_1309)a4, d3);
        d3 = class_1280.method_5496((float)((float)d3), (float)a4.method_6096(), (float)((float)a4.method_5996(class_5134.field_23725).method_6194()));
        ((IExplosion)explosion).setWorld((class_1937)MeteorExplosionUtil.mc.field_1687);
        ((IExplosion)explosion).setX(a3.field_1352);
        ((IExplosion)explosion).setY(a3.field_1351);
        ((IExplosion)explosion).setZ(a3.field_1350);
        ((IExplosion)explosion).setPower((float)a);
        d3 = MeteorExplosionUtil.blastProtReduction((class_1297)a4, d3, explosion);
        if (d2 < 0.0) {
            d3 = 0.0;
        }
        return d3;
    }

    /*
     * WARNING - void declaration
     */
    public static double anchorDamage(class_1657 class_16572, class_2338 class_23382, class_1657 class_16573) {
        void a;
        class_1657 a2 = class_23382;
        class_1657 a3 = class_16572;
        if (BlockUtil.getBlock((class_2338)a2) == class_2246.field_23152) {
            CombatUtil.modifyPos = a2;
            CombatUtil.modifyBlockState = class_2246.field_10124.method_9564();
            double d = MeteorExplosionUtil.explosionDamage(a3, CombatUtil.modifyPos.method_46558(), (class_1657)a, 5.0f);
            CombatUtil.modifyPos = null;
            return d;
        }
        return MeteorExplosionUtil.explosionDamage(a3, a2.method_46558(), (class_1657)a, 5.0f);
    }

    /*
     * Exception decompiling
     */
    private static /* synthetic */ double getDamageForDifficulty(double a) {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    private static /* synthetic */ double resistanceReduction(class_1309 a3, double a2) {
        class_1309 class_13092 = a3;
        if (class_13092.method_6059(class_1294.field_5907)) {
            int a3 = class_13092.method_6112(class_1294.field_5907).method_5578() + 1;
            a2 *= 1.0 - (double)a3 * 0.2;
        }
        if (a2 < 0.0) {
            return 0.0;
        }
        return a2;
    }

    /*
     * WARNING - void declaration
     */
    public static double crystalDamage(class_1657 class_16572, class_243 class_2432, class_1657 class_16573) {
        void a;
        class_1657 a2 = class_16573;
        class_1657 a3 = class_16572;
        return MeteorExplosionUtil.explosionDamage(a3, (class_243)a, a2, 6.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static double crystalDamage(class_1657 class_16572, class_2338 class_23382, class_1657 class_16573) {
        void a;
        class_1657 a2 = class_16573;
        class_1657 a3 = class_16572;
        return MeteorExplosionUtil.explosionDamage(a3, a.method_46558().method_1031(0.0, -0.5, 0.0), a2, 6.0f);
    }

    public MeteorExplosionUtil() {
        MeteorExplosionUtil a;
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ double blastProtReduction(class_1297 class_12972, double d, class_1927 class_19272) {
        void a;
        void v0;
        class_1297 a22 = class_19272;
        class_1297 a3 = class_12972;
        int a22 = class_1890.method_8219((Iterable)a3.method_5661(), (class_1282)MeteorExplosionUtil.mc.field_1687.method_48963().method_48807((class_1927)a22));
        if (a22 > 20) {
            a22 = 20;
        }
        a *= 1.0 - (double)a22 / 25.0;
        if (v0 < 0.0) {
            return 0.0;
        }
        return (double)a;
    }

}
