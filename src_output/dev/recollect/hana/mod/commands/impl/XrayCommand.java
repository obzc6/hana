/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.xibao.SnowAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XrayCommand
extends Command {
    public XrayCommand() {
        super(NCPRaytracer.ALLATORIxDEMO("}XnY"), SnowAnimation.ALLATORIxDEMO("h\u0003Y\u000b\u0017\u0003M\u0004@\bE@]\u0006N\u0017oLDFt\u0010\u0016H\u001a\nU\u000bG\u0017IA\u0000Ii5X\u0015\u0012\u0011@\u0016p7V\u0006T\u0016lOf\rS\u0001];"), NCPRaytracer.ALLATORIxDEMO("_EnM EzBwNr\u0006j@yQX\ns\u0000CV!\u000e-LbMpQ~\u00077\u000f^soS%WwPGqa@cP[\tQKdGj}"));
        XrayCommand a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        void a22322;
        Object a = list;
        XrayCommand a3 = this;
        if (a22322 == true) {
            ArrayList<String> arrayList = a;
            String a22322 = ((String)arrayList.get(arrayList.size() - 1)).toLowerCase();
            a = new ArrayList<String>();
            for (String arrstring2 : List.of(SnowAnimation.ALLATORIxDEMO("\r\\\u0002"), NCPRaytracer.ALLATORIxDEMO("kAaAjY"), SnowAnimation.ALLATORIxDEMO("O\u0006_\u0003N\u0003"), NCPRaytracer.ALLATORIxDEMO("[cDeS`AjY"), SnowAnimation.ALLATORIxDEMO("^\u0005K\u0012"), NCPRaytracer.ALLATORIxDEMO("W`YjT"))) {
                if (!a22322.equalsIgnoreCase(Hana.PREFIX + "xray") && !arrstring2.toLowerCase().startsWith(a22322)) continue;
                a.add(arrstring2);
            }
            int n2 = a.size();
            String[] arrstring = new String[n2];
            int a22322 = 0;
            Object object = a = a.iterator();
            while (object.hasNext()) {
                String string = (String)a.next();
                object = a;
                arrstring[a22322++] = string;
            }
            return arrstring;
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void runCommand(String[] var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [16[DOLOOP]], but top level block is 3[CASE]
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
}
