/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class WebClimb
extends Module {
    public static WebClimb INSTANCE;

    @Override
    public void onUpdate() {
        WebClimb a;
        WebClimb webClimb = a;
        super.onUpdate();
        if (!WebClimb.mc.field_1724.method_24828()) {
            class_2338 class_23382 = new class_2338((int)WebClimb.mc.field_1724.method_23317(), (int)WebClimb.mc.field_1724.method_23318(), (int)WebClimb.mc.field_1724.method_23321());
            class_2350[] arrclass_2350 = class_2350.values();
            int n = arrclass_2350.length;
            int n2 = a = 0;
            while (n2 < n) {
                class_2338 class_23383;
                class_2350 class_23502 = arrclass_2350[a];
                if (class_23502 != class_2350.field_11033 && WebClimb.mc.field_1687.method_8320(class_23383 = class_23382.method_10093(class_23502)).method_26204() == class_2246.field_10343) {
                    webClimb.handleWebClimb(class_23502);
                    return;
                }
                n2 = ++a;
            }
        }
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void handleWebClimb(class_2350 var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[DOLOOP]], but top level block is 1[CASE]
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

    public WebClimb() {
        WebClimb a;
        WebClimb webClimb = a;
        super(Animation.ALLATORIxDEMO("xqHRB|Lx"), Module.Category.Movement);
        webClimb.setChinese(NCPRaytracer.ALLATORIxDEMO("\u722a\u8731\u86d2\u7f77"));
        INSTANCE = webClimb;
    }

}
