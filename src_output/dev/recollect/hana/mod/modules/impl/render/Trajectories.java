/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1753
 *  net.minecraft.class_1764
 *  net.minecraft.class_1771
 *  net.minecraft.class_1776
 *  net.minecraft.class_1779
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1803
 *  net.minecraft.class_1823
 *  net.minecraft.class_1828
 *  net.minecraft.class_1835
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_4587
 *  net.minecraft.class_7172
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import net.minecraft.class_1268;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1771;
import net.minecraft.class_1776;
import net.minecraft.class_1779;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1803;
import net.minecraft.class_1823;
import net.minecraft.class_1828;
import net.minecraft.class_1835;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_4587;
import net.minecraft.class_7172;
import net.minecraft.class_746;

public class Trajectories
extends Module {
    private final ColorSetting color;
    private final ColorSetting lcolor;

    private /* synthetic */ float getThrowVelocity(class_1792 class_17922) {
        Trajectories a = class_17922;
        Trajectories a2 = this;
        if (a instanceof class_1828 || a instanceof class_1803) {
            return 0.5f;
        }
        if (a instanceof class_1779) {
            return 0.59f;
        }
        if (a instanceof class_1835) {
            return 2.0f;
        }
        return 1.5f;
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        Trajectories a3;
        class_1268 a22;
        Trajectories trajectories = a3;
        if (Trajectories.nullCheck()) {
            return;
        }
        a3 = Trajectories.mc.field_1724.method_6047();
        class_1799 class_17992 = Trajectories.mc.field_1724.method_6079();
        if (a3.method_7909() instanceof class_1753 || a3.method_7909() instanceof class_1764 || trajectories.isThrowable(a3.method_7909())) {
            a22 = class_1268.field_5808;
        } else if (class_17992.method_7909() instanceof class_1753 || class_17992.method_7909() instanceof class_1764 || trajectories.isThrowable(class_17992.method_7909())) {
            a22 = class_1268.field_5810;
        } else {
            return;
        }
        boolean bl = (Boolean)Trajectories.mc.field_1690.method_42448().method_41753();
        Trajectories.mc.field_1690.method_42448().method_41748((Object)false);
        if (a3.method_7909() instanceof class_1764 && class_1890.method_8225((class_1887)class_1893.field_9108, (class_1799)a3) != 0) {
            trajectories.calcTrajectory(a, a22 == class_1268.field_5810 ? class_17992.method_7909() : a3.method_7909(), Trajectories.mc.field_1724.method_36454() - 10.0f);
            trajectories.calcTrajectory(a, a22 == class_1268.field_5810 ? class_17992.method_7909() : a3.method_7909(), Trajectories.mc.field_1724.method_36454());
            trajectories.calcTrajectory(a, a22 == class_1268.field_5810 ? class_17992.method_7909() : a3.method_7909(), Trajectories.mc.field_1724.method_36454() + 10.0f);
        } else {
            trajectories.calcTrajectory(a, a22 == class_1268.field_5810 ? class_17992.method_7909() : a3.method_7909(), Trajectories.mc.field_1724.method_36454());
        }
        Trajectories.mc.field_1690.method_42448().method_41748((Object)bl);
    }

    private /* synthetic */ boolean isThrowable(class_1792 class_17922) {
        Trajectories a = class_17922;
        Trajectories a2 = this;
        return a instanceof class_1776 || a instanceof class_1835 || a instanceof class_1779 || a instanceof class_1823 || a instanceof class_1771 || a instanceof class_1828 || a instanceof class_1803;
    }

    public Trajectories() {
        Trajectories a;
        Trajectories trajectories = a;
        Trajectories trajectories2 = a;
        super(Animation.ALLATORIxDEMO("c~M}Ti^~TtUx"), Module.Category.Render);
        Trajectories trajectories3 = a;
        trajectories3.color = trajectories2.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("\u00057&!."), new Color(575714484)));
        trajectories.lcolor = trajectories.add(new ColorSetting(Animation.ALLATORIxDEMO("@MyUoNRIq_y"), new Color(575714484)));
        trajectories.setChinese(GaussianKernel.ALLATORIxDEMO("\u62d1\u7227\u7ee3"));
    }

    private /* synthetic */ float getDistance(class_1792 class_17922) {
        Trajectories a = class_17922;
        Trajectories a2 = this;
        if (a instanceof class_1753) {
            return 1.0f;
        }
        return 0.4f;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void calcTrajectory(class_4587 var1_3, class_1792 var2_4, float var3_5) {
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

    private /* synthetic */ int getThrowPitch(class_1792 class_17922) {
        Trajectories a = class_17922;
        Trajectories a2 = this;
        if (a instanceof class_1828 || a instanceof class_1803 || a instanceof class_1779) {
            return 20;
        }
        return 0;
    }
}
