/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.ModuleComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.gui.nullpoint.elements.ArmorHUD;
import dev.recollect.hana.mod.gui.nullpoint.elements.IngameGUI;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.lwjgl.opengl.GL11;

public class GuiManager
implements Wrapper {
    public static Tab currentGrabbed;
    public final IngameGUI ingameGUI;
    private int mouseY;
    public final ArmorHUD armorHud;
    private int lastMouseX;
    private int mouseX;
    private int lastMouseY;
    public static final ClickGuiScreen clickGui;
    public final ArrayList<ClickGuiTab> tabs;

    static {
        clickGui = new ClickGuiScreen();
        currentGrabbed = null;
    }

    /*
     * Exception decompiling
     */
    public void draw(int var1_1, int var2_2, class_332 var3_4, float var4_5) {
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

    /*
     * WARNING - void declaration
     */
    public void setScissorRegion(int n, int n2, int n3, int n4) {
        void a;
        void a2;
        void a3;
        void a4;
        int n5 = n4;
        GuiManager a5 = this;
        double d = mc.method_22683().method_4507() - (a2 + a4);
        GL11.glEnable((int)3089);
        GL11.glScissor((int)a3, (int)((int)d), (int)a, (int)a4);
    }

    public GuiManager() {
        int n;
        GuiManager guiManager;
        ClickGuiTab a;
        GuiManager guiManager2 = guiManager = a;
        GuiManager guiManager3 = guiManager;
        GuiManager guiManager4 = guiManager;
        guiManager4.tabs = new ArrayList();
        guiManager3.lastMouseX = 0;
        guiManager2.lastMouseY = 0;
        guiManager3.armorHud = new ArmorHUD();
        guiManager2.ingameGUI = new IngameGUI();
        int n2 = 30;
        Module.Category[] arrcategory = Module.Category.values();
        int n3 = arrcategory.length;
        int n4 = n = 0;
        while (n4 < n3) {
            Module.Category category = arrcategory[n];
            a = new ClickGuiTab(category, n2, 50);
            for (Wrapper wrapper : Hana.MODULE.modules) {
                if (wrapper.getCategory() != category) continue;
                wrapper = new ModuleComponent(wrapper.getName(), a, (Module)wrapper);
                a.addChild((Component)wrapper);
            }
            guiManager.tabs.add(a);
            n2 += a.getWidth() + 2;
            n4 = ++n;
        }
    }

    public boolean isClickGuiOpen() {
        return GuiManager.mc.field_1755 instanceof ClickGuiScreen;
    }

    public void update() {
        Object a;
        Object object = a;
        if (((GuiManager)object).isClickGuiOpen()) {
            Object object2 = a = ((GuiManager)object).tabs.iterator();
            while (object2.hasNext()) {
                ((ClickGuiTab)a.next()).update(((GuiManager)object).mouseX, ((GuiManager)object).mouseY, ClickGuiScreen.clicked);
                object2 = a;
            }
            GuiManager guiManager = object;
            guiManager.armorHud.update(guiManager.mouseX, ((GuiManager)object).mouseY, ClickGuiScreen.clicked);
        }
    }

    public Color getColor() {
        return UIModule.INSTANCE.color.getValue();
    }

    public static final class HackName
    extends Enum<HackName> {
        public static final /* enum */ HackName MadCat;
        public static final /* enum */ HackName MoonGod;
        private static final /* synthetic */ HackName[] $VALUES;
        public static final /* enum */ HackName Mio;
        public static final /* enum */ HackName nullpoint;
        public static final /* enum */ HackName MoonEmoji;
        public static final /* enum */ HackName Moon;

        public static HackName[] values() {
            return (HackName[])$VALUES.clone();
        }

        public static HackName valueOf(String a) {
            return Enum.valueOf(HackName.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ HackName() {
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

        private static /* synthetic */ HackName[] $values() {
            HackName[] arrhackName = new HackName[6];
            arrhackName[0] = MoonEmoji;
            arrhackName[1] = nullpoint;
            arrhackName[2] = MadCat;
            arrhackName[3] = Moon;
            arrhackName[4] = MoonGod;
            arrhackName[5] = Mio;
            return arrhackName;
        }

        static {
            MoonEmoji = new HackName(Vec3.ALLATORIxDEMO("1\\6r3}\u0015r\u001b"), 0);
            nullpoint = new HackName(RenderHelper.ALLATORIxDEMO("{\u0018~\u0006e\u0018aS6"), 1);
            MadCat = new HackName(Vec3.ALLATORIxDEMO("Q\u0017t9y\u0006"), 2);
            Moon = new HackName(RenderHelper.ALLATORIxDEMO(":gR,"), 3);
            MoonGod = new HackName(Vec3.ALLATORIxDEMO("\u0014s\u0019~=w\u0016"), 4);
            Mio = new HackName(RenderHelper.ALLATORIxDEMO("ET-"), 5);
            $VALUES = HackName.$values();
        }
    }

}
