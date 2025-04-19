/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.modules.settings.Setting;
import java.util.function.Predicate;

public class StringSetting
extends Setting {
    private String text;
    private boolean isListening;
    public static StringSetting current;

    public static String removeLastChar(String a) {
        String string = a;
        a = "";
        if (string != null && !string.isEmpty()) {
            String string2 = string;
            a = string2.substring(0, string2.length() - 1);
        }
        return a;
    }

    public void setListening(boolean bl) {
        boolean a = bl;
        StringSetting a2 = this;
        a2.isListening = a;
        if (a2.isListening) {
            current = a2;
        }
    }

    /*
     * WARNING - void declaration
     */
    public StringSetting(String string, String string2, Predicate predicate) {
        void a;
        void a2;
        Predicate a3 = predicate;
        StringSetting a4 = this;
        void v0 = a;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0, a3);
        StringSetting stringSetting = a4;
        stringSetting.isListening = false;
        stringSetting.text = a2;
    }

    public void charType(char c) {
        StringSetting a;
        char a2 = c;
        StringSetting stringSetting = a = this;
        stringSetting.setValue(stringSetting.getValue() + a2);
    }

    public void setValue(String string) {
        String a = string;
        StringSetting a2 = this;
        a2.text = a;
    }

    /*
     * Exception decompiling
     */
    public void keyType(int var1_2) {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void loadSetting() {
        StringSetting a;
        StringSetting stringSetting = a;
        stringSetting.setValue(Hana.CONFIG.getString(a.getLine(), stringSetting.text));
    }

    public boolean isListening() {
        StringSetting a;
        return a.isListening && current == a;
    }

    public String getValue() {
        StringSetting a;
        return a.text;
    }

    /*
     * WARNING - void declaration
     */
    public StringSetting(String string, String string2) {
        void a;
        String a2 = string2;
        StringSetting a3 = this;
        void v0 = a;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0);
        StringSetting stringSetting = a3;
        stringSetting.isListening = false;
        stringSetting.text = a2;
    }
}
