/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.modules.settings.Setting;

public class BindSetting
extends Setting {
    public boolean hold;
    private boolean isListening;
    private boolean holdEnable;
    private boolean pressed;
    private int key;

    public int getKey() {
        BindSetting a;
        return a.key;
    }

    public void setKey(int n) {
        int a = n;
        BindSetting a2 = this;
        a2.key = a;
    }

    /*
     * WARNING - void declaration
     */
    public BindSetting(String string, int n) {
        void a;
        int a2 = n;
        BindSetting a3 = this;
        void v0 = a;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0);
        BindSetting bindSetting = a3;
        BindSetting bindSetting2 = a3;
        a3.isListening = false;
        bindSetting2.pressed = false;
        bindSetting2.holdEnable = false;
        bindSetting.hold = false;
        bindSetting.key = a2;
    }

    public void setHoldEnable(boolean bl) {
        boolean a = bl;
        BindSetting a2 = this;
        a2.holdEnable = a;
    }

    public void setPressed(boolean bl) {
        boolean a = bl;
        BindSetting a2 = this;
        a2.pressed = a;
    }

    public void setListening(boolean bl) {
        boolean a = bl;
        BindSetting a2 = this;
        a2.isListening = a;
    }

    @Override
    public void loadSetting() {
        BindSetting a;
        BindSetting bindSetting = a;
        bindSetting.setKey(Hana.CONFIG.getInt(bindSetting.getLine(), a.key));
        bindSetting.setHoldEnable(Hana.CONFIG.getBoolean(a.getLine() + "_hold"));
    }

    public boolean isListening() {
        BindSetting a;
        return a.isListening;
    }

    /*
     * Exception decompiling
     */
    public String getBind() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[DOLOOP]], but top level block is 2[CASE]
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

    public boolean isHoldEnable() {
        BindSetting a;
        return a.holdEnable;
    }

    public boolean isPressed() {
        BindSetting a;
        return a.pressed;
    }
}
