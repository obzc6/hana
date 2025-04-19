/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3675
 *  net.minecraft.class_4587
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_7204
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.socket.network.packet.Packet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_7204;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseSettings;

public abstract class Module
extends Mod {
    private final List<Setting> settings;
    private final BindSetting bindSetting;
    public final BooleanSetting drawnSetting;
    public boolean state;
    public String chinese;
    private String description;
    private final Category category;

    public static boolean nullCheck() {
        return Module.mc.field_1724 == null || Module.mc.field_1687 == null;
    }

    public BindSetting getBind() {
        Module a;
        return a.bindSetting;
    }

    public void onThread() {
    }

    public void setState(boolean bl) {
        boolean a = bl;
        Module a2 = this;
        if (a2.state == a) {
            return;
        }
        if (a) {
            a2.enable();
            return;
        }
        a2.disable();
    }

    public void onLogin() {
    }

    /*
     * WARNING - void declaration
     */
    public Module(String string, String string2, Category category) {
        Module a;
        void a2;
        void a3;
        String a4 = string;
        Module module = a = this;
        super(a4);
        Module module2 = a;
        module2.settings = new ArrayList<Setting>();
        a.category = a3;
        module.description = a2;
        ModuleManager.lastLoadMod = a;
        module.bindSetting = new BindSetting(WebUtils.ALLATORIxDEMO("La4"), a4.equalsIgnoreCase(Packet.ALLATORIxDEMO("Jq")) ? 89 : -1);
        Module module3 = a;
        module3.drawnSetting = module3.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("^<fs#"), true));
        module3.drawnSetting.hide();
    }

    public void setChinese(String string) {
        String a = string;
        Module a2 = this;
        a2.chinese = a;
    }

    public String getArrayInfo() {
        Module a;
        if (a.getInfo() == null) {
            return "";
        }
        return " \u00a77[" + a.getInfo() + "\u00a77]";
    }

    public String getDescription() {
        Module a;
        return a.description;
    }

    /*
     * WARNING - void declaration
     */
    public Module(String string, Category category) {
        void a;
        Object a2 = category;
        Module a3 = this;
        a3((String)a, "", (Category)((Object)a2));
    }

    /*
     * Exception decompiling
     */
    public void disable() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [14[DOLOOP]], but top level block is 1[CASE]
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

    public boolean isOn() {
        Module a;
        return a.state;
    }

    public SliderSetting add(SliderSetting sliderSetting) {
        SliderSetting a = sliderSetting;
        Module a2 = this;
        Object object = a;
        a2.addSetting((Setting)object);
        return object;
    }

    public boolean setBind(String a) {
        Module a22;
        int a22;
        Module module = a22;
        if (a.equalsIgnoreCase(Packet.ALLATORIxDEMO("x^q]"))) {
            module.bindSetting.setKey(-1);
            return true;
        }
        try {
            a22 = class_3675.method_15981((String)("key.keyboard." + a.toLowerCase())).method_1444();
        }
        catch (NumberFormatException numberFormatException) {
            if (!Module.nullCheck()) {
                CommandManager.sendChatMessage(WebUtils.ALLATORIxDEMO("\u00f8u\u0012!\u00026\u00e9a:P7:?x'6"));
            }
            return false;
        }
        if (a.equalsIgnoreCase(Packet.ALLATORIxDEMO("x^q]"))) {
            a22 = -1;
        }
        if (a22 == 0) {
            return false;
        }
        module.bindSetting.setKey(a22);
        return true;
    }

    /*
     * Exception decompiling
     */
    public void enable() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [16[DOLOOP]], but top level block is 2[CASE]
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

    public String getArrayName() {
        Module a;
        return a.getDisplayName() + a.getArrayInfo();
    }

    public <T extends Enum<T>> EnumSetting<T> add(EnumSetting<T> enumSetting) {
        EnumSetting<T> a = enumSetting;
        Module a2 = this;
        Object object = a;
        a2.addSetting((Setting)object);
        return object;
    }

    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        Module a2 = this;
    }

    public final boolean isCategory(Category category) {
        Object a = category;
        Module a2 = this;
        return a == a2.category;
    }

    public boolean isOff() {
        Module a;
        return !a.isOn();
    }

    public void addSetting(Setting setting) {
        Setting a = setting;
        Module a2 = this;
        a2.settings.add(a);
    }

    public void onDisable() {
    }

    public void onUpdate() {
    }

    public void setDescription(String string) {
        String a = string;
        Module a2 = this;
        a2.description = a;
    }

    public BindSetting add(BindSetting bindSetting) {
        BindSetting a = bindSetting;
        Module a2 = this;
        Object object = a;
        a2.addSetting((Setting)object);
        return object;
    }

    public void onToggle() {
    }

    public String getInfo() {
        return null;
    }

    public void onEnable() throws IOException {
    }

    public List<Setting> getSettings() {
        Module a;
        return a.settings;
    }

    public void onRender2D(class_332 class_3322, float f) {
        float a = f;
        Module a2 = this;
    }

    public boolean hasSettings() {
        Module a;
        return !a.settings.isEmpty();
    }

    public void onLogout() {
    }

    public BooleanSetting add(BooleanSetting booleanSetting) {
        BooleanSetting a = booleanSetting;
        Module a2 = this;
        Object object = a;
        a2.addSetting((Setting)object);
        return object;
    }

    public String getDisplayName() {
        Module a;
        if (UIModule.INSTANCE != null && UIModule.INSTANCE.chinese != null && UIModule.INSTANCE.chinese.getValue() && a.chinese != null && !a.chinese.isEmpty()) {
            return a.chinese;
        }
        return a.getName();
    }

    public Category getCategory() {
        Module a;
        return a.category;
    }

    public void toggle() {
        Module a;
        if (a.isOn()) {
            a.disable();
            return;
        }
        a.enable();
    }

    public ColorSetting add(ColorSetting colorSetting) {
        ColorSetting a = colorSetting;
        Module a2 = this;
        Object object = a;
        a2.addSetting((Setting)object);
        return object;
    }

    public static void sendSequencedPacket(class_7204 a) {
        if (mc.method_1562() == null || Module.mc.field_1687 == null) {
            return;
        }
    }

    public StringSetting add(StringSetting stringSetting) {
        StringSetting a = stringSetting;
        Module a2 = this;
        Object object = a;
        a2.addSetting((Setting)object);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public void sendNotify(String string, Notify.Notifys.icon icon2) {
        void a;
        Object a2 = string;
        Module a3 = this;
        a2 = new Notify.Notifys((String)a2, (Notify.Notifys.icon)a);
        Notify.notifyList.add((Notify.Notifys)a2);
    }

    public static final class Category
    extends Enum<Category> {
        public static final /* enum */ Category Player;
        public static final /* enum */ Category Misc;
        public static final /* enum */ Category Exploit;
        public static final /* enum */ Category Client;
        public static final /* enum */ Category Render;
        private static final /* synthetic */ Category[] $VALUES;
        public static final /* enum */ Category Combat;
        public static final /* enum */ Category Movement;

        static {
            Combat = new Category(BaseSettings.ALLATORIxDEMO("ulF|Aa"), 0);
            Misc = new Category(NCPRaytracer.ALLATORIxDEMO("T_a^"), 1);
            Render = new Category(BaseSettings.ALLATORIxDEMO("dfEzEg"), 2);
            Movement = new Category(NCPRaytracer.ALLATORIxDEMO("ALrNtS|I"), 3);
            Player = new Category(BaseSettings.ALLATORIxDEMO("foJgEg"), 4);
            Exploit = new Category(NCPRaytracer.ALLATORIxDEMO("f|[uY{I"), 5);
            Client = new Category(BaseSettings.ALLATORIxDEMO("uoB{Na"), 6);
            $VALUES = Category.$values();
        }

        public static Category[] values() {
            return (Category[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Category() {
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

        private static /* synthetic */ Category[] $values() {
            Category[] arrcategory = new Category[7];
            arrcategory[0] = Combat;
            arrcategory[1] = Misc;
            arrcategory[2] = Render;
            arrcategory[3] = Movement;
            arrcategory[4] = Player;
            arrcategory[5] = Exploit;
            arrcategory[6] = Client;
            return arrcategory;
        }

        public static Category valueOf(String a) {
            return Enum.valueOf(Category.class, a);
        }
    }

}
