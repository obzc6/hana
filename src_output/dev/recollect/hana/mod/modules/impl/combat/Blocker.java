/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1511
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Surround;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_1511;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class Blocker
extends Module {
    public static Blocker INSTANCE;
    private final BooleanSetting feet;
    public final BooleanSetting render;
    private final BooleanSetting inventorySwap;
    private int placeProgress;
    private final BooleanSetting bevelCev;
    private class_2338 playerBP;
    private final BooleanSetting detectMining;
    private final EnumSetting<Page> page;
    private final SliderSetting blocksPer;
    private final BooleanSetting rotate;
    final ColorSetting box;
    private final BooleanSetting breakCrystal;
    private final SliderSetting delay;
    private final BooleanSetting onlySurround;
    final ColorSetting fill;
    public final SliderSetting fadeTime;
    private final List<class_2338> placePos;
    private final BooleanSetting eatingPause;
    final Timer timer;
    private final BooleanSetting inAirPause;

    private static /* synthetic */ boolean lambda$crystalHere$16(class_2338 class_23382, class_1511 class_15112) {
        class_2338 a = class_15112;
        class_2338 a2 = class_23382;
        return a.method_24515().equals((Object)a2);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        Blocker a2 = this;
        if (a2.inventorySwap.getValue()) {
            InventoryUtil.inventorySwap(a, Blocker.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ void tryPlaceObsidian(class_2338 a) {
        Blocker a22;
        Blocker blocker;
        Blocker blocker2 = a22;
        if (!((double)blocker2.placeProgress < blocker2.blocksPer.getValue())) {
            return;
        }
        if (blocker2.detectMining.getValue() && BlockUtil.isMining(a)) {
            return;
        }
        int n = Blocker.mc.field_1724.method_31548().field_7545;
        int a22 = blocker2.getObsidian();
        if (a22 == -1) {
            return;
        }
        Blocker blocker3 = blocker2;
        blocker3.doSwap(a22);
        BlockUtil.placeBlock(a, blocker3.rotate.getValue());
        Blocker blocker4 = blocker2;
        if (blocker2.inventorySwap.getValue()) {
            blocker4.doSwap(a22);
            EntityUtil.syncInventory();
            blocker = blocker2;
        } else {
            blocker4.doSwap(n);
            blocker = blocker2;
        }
        ++blocker.placeProgress;
        BlockerRenderer.addBlock(a);
        blocker2.timer.reset();
    }

    private /* synthetic */ boolean isBedrock(class_2338 class_23382) {
        Blocker a = class_23382;
        Blocker a2 = this;
        return Blocker.mc.field_1687.method_8320((class_2338)a).method_26204() == class_2246.field_9987;
    }

    private /* synthetic */ boolean crystalHere(class_2338 class_23382) {
        Blocker a = class_23382;
        Blocker a2 = this;
        return Blocker.mc.field_1687.method_18467(class_1511.class, new class_238((class_2338)a)).stream().anyMatch(arg_0 -> Blocker.lambda$crystalHere$16((class_2338)a, arg_0));
    }

    public Blocker() {
        Blocker a;
        Blocker blocker = a;
        super(NCPRaytracer.ALLATORIxDEMO("el@mJ|D"), Module.Category.Combat);
        blocker.timer = new Timer();
        blocker.page = a.add(new EnumSetting<Page>(SocketClient.ALLATORIxDEMO("{o[|"), Page.General));
        blocker.delay = blocker.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("TGiDekkMxO"), 50, 0, 500, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.blocksPer = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("FAgFkX^Yk"), 1, 1, 8, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("R@z@mS"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.breakCrystal = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("BYk]r"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventorySwap = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("Oi^aE|HrV]VxF"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.bevelCev = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("omSeGMYo"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.feet = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("HD|B"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Target;
        }).setParent());
        a.onlySurround = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("miM}~}WrD{R}"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Target && a2.feet.isOpen();
        }));
        a.inAirPause = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("MEINroTjS"), false, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Check;
        }));
        a.detectMining = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("fbUaN|hiEgR~"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Check;
        }));
        a.eatingPause = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("me_aIgoTjS"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Check;
        }));
        a.render = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("weEjYk"), true, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.box = a.add(new ColorSetting(NCPRaytracer.ALLATORIxDEMO("cvN"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Render;
        }).injectBoolean(true));
        a.fill = a.add(new ColorSetting(SocketClient.ALLATORIxDEMO("mgPu"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.page.getValue() == Page.Render;
        }).injectBoolean(true));
        a.fadeTime = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("NFdJZHtS"), 500, 0, 5000, object -> {
            Object a = object;
            Blocker a2 = this;
            return a2.render.getValue();
        }));
        Blocker blocker2 = a;
        a.placePos = new ArrayList<class_2338>();
        blocker2.placeProgress = 0;
        blocker2.setChinese(SocketClient.ALLATORIxDEMO("\u6651\u80f3\u56c8\u8103"));
        INSTANCE = blocker2;
        Hana.EVENT_BUS.subscribe(new BlockerRenderer(a));
    }

    @Override
    public void onUpdate() {
        Blocker a222;
        Object object;
        Blocker blocker;
        Object object2;
        class_2338 class_23382;
        int n;
        Blocker blocker2 = blocker = a222;
        if (!blocker2.timer.passedMs(blocker2.delay.getValue())) {
            return;
        }
        if (blocker.eatingPause.getValue() && EntityUtil.isUsing()) {
            return;
        }
        blocker.placeProgress = 0;
        if (blocker.playerBP != null && !blocker.playerBP.equals((Object)EntityUtil.getPlayerPos(true))) {
            blocker.placePos.clear();
        }
        blocker.playerBP = EntityUtil.getPlayerPos(true);
        if (blocker.bevelCev.getValue()) {
            object2 = class_2350.values();
            int a222 = ((class_2350[])object2).length;
            int n2 = n = 0;
            while (n2 < a222) {
                object = object2[n];
                if (object != class_2350.field_11033) {
                    Blocker blocker3 = blocker;
                    if (!blocker3.isBedrock(blocker3.playerBP.method_10093(object).method_10084())) {
                        Blocker blocker4 = blocker;
                        class_23382 = blocker4.playerBP.method_10093(object).method_10086(2);
                        if (blocker4.crystalHere(class_23382) && !blocker.placePos.contains((Object)class_23382)) {
                            blocker.placePos.add(class_23382);
                        }
                    }
                }
                n2 = ++n;
            }
        }
        if (blocker.getObsidian() == -1) {
            return;
        }
        if (blocker.inAirPause.getValue() && !Blocker.mc.field_1724.method_24828()) {
            return;
        }
        blocker.placePos.removeIf(a -> !BlockUtil.clientCanPlace(a, true));
        if (blocker.feet.getValue() && (!blocker.onlySurround.getValue() || Surround.INSTANCE.isOn())) {
            object2 = class_2350.values();
            int a222 = ((class_2350[])object2).length;
            int n3 = n = 0;
            while (n3 < a222) {
                object = object2[n];
                if (object != class_2350.field_11033 && object != class_2350.field_11036) {
                    Blocker blocker5 = blocker;
                    class_23382 = blocker5.playerBP.method_10093(object);
                    if (!blocker5.isBedrock(class_23382) && BlockUtil.isMining(class_23382)) {
                        int n4;
                        class_2338 class_23383 = class_2350.values();
                        int n5 = ((class_2350[])class_23383).length;
                        int n6 = n4 = 0;
                        while (n6 < n5) {
                            class_2350 class_23502 = class_23383[n4];
                            if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036) {
                                Blocker blocker6 = blocker;
                                class_23502 = blocker6.playerBP.method_10093(object).method_10093(class_23502);
                                if (blocker6.breakCrystal.getValue()) {
                                    CombatUtil.attackCrystal((class_2338)class_23502, blocker.rotate.getValue(), false);
                                }
                                if (BlockUtil.canPlace((class_2338)class_23502, 6.0, blocker.breakCrystal.getValue())) {
                                    blocker.tryPlaceObsidian((class_2338)class_23502);
                                }
                            }
                            n6 = ++n4;
                        }
                        Blocker blocker7 = blocker;
                        class_23383 = blocker7.playerBP.method_10093(object).method_10084();
                        if (blocker7.breakCrystal.getValue()) {
                            CombatUtil.attackCrystal(class_23383, blocker.rotate.getValue(), false);
                        }
                        if (BlockUtil.canPlace(class_23383, 6.0, blocker.breakCrystal.getValue())) {
                            blocker.tryPlaceObsidian(class_23383);
                        }
                    }
                }
                n3 = ++n;
            }
        }
        for (class_2338 a222 : blocker.placePos) {
            if (blocker.breakCrystal.getValue() && blocker.crystalHere(a222)) {
                CombatUtil.attackCrystal(a222, blocker.rotate.getValue(), false);
            }
            if (!BlockUtil.canPlace(a222, 6.0, blocker.breakCrystal.getValue())) continue;
            blocker.tryPlaceObsidian(a222);
        }
    }

    private /* synthetic */ int getObsidian() {
        Blocker a;
        if (a.inventorySwap.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Target;
        public static final /* enum */ Page Check;
        public static final /* enum */ Page Render;
        public static final /* enum */ Page General;
        private static final /* synthetic */ Page[] $VALUES;

        /*
         * Exception decompiling
         */
        private /* synthetic */ Page() {
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

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        static {
            General = new Page(BufferRing.ALLATORIxDEMO("=,\u00131\u0012F"), 0);
            Target = new Page(RenderHelper.ALLATORIxDEMO(">t\u0005oX6"), 1);
            Check = new Page(BufferRing.ALLATORIxDEMO("><\u0005}A"), 2);
            Render = new Page(RenderHelper.ALLATORIxDEMO("8p\u0019lX0"), 3);
            $VALUES = Page.$values();
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[4];
            arrpage[0] = General;
            arrpage[1] = Target;
            arrpage[2] = Check;
            arrpage[3] = Render;
            return arrpage;
        }
    }

    public class BlockerRenderer {
        public static final HashMap<class_2338, placePosition> renderMap = new HashMap();
        final /* synthetic */ Blocker this$0;

        public BlockerRenderer(Blocker blocker) {
            Blocker a = blocker;
            BlockerRenderer a2 = this;
            a2.this$0 = a;
        }

        @EventHandler
        public void onRender3D(Render3DEvent a) {
            placePosition a2;
            BlockerRenderer blockerRenderer = a2;
            if (!Blocker.INSTANCE.render.getValue()) {
                return;
            }
            if (renderMap.isEmpty()) {
                return;
            }
            boolean bl = true;
            Iterator<placePosition> iterator = renderMap.values().iterator();
            block0 : do {
                Iterator<placePosition> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    a2 = iterator.next();
                    if (!BlockUtil.clientCanPlace(a2.pos, true)) {
                        a2.isAir = false;
                    }
                    if (!a2.timer.passedMs((long)(blockerRenderer.this$0.delay.getValue() + 100.0)) && a2.isAir) {
                        a2.firstFade.reset();
                    }
                    if (a2.firstFade.getQuad(FadeUtils.Quad.In2) == 1.0) {
                        iterator2 = iterator;
                        continue;
                    }
                    bl = false;
                    class_4587 class_45872 = a.getMatrixStack();
                    if (Blocker.INSTANCE.fill.booleanValue) {
                        Render3DUtil.drawFill(class_45872, new class_238(a2.pos), ColorUtil.injectAlpha(Blocker.INSTANCE.fill.getValue(), (int)((double)blockerRenderer.this$0.fill.getValue().getAlpha() * (1.0 - a2.firstFade.getQuad(FadeUtils.Quad.In2)))));
                    }
                    if (!Blocker.INSTANCE.box.booleanValue) continue block0;
                    Render3DUtil.drawBox(class_45872, new class_238(a2.pos), ColorUtil.injectAlpha(Blocker.INSTANCE.box.getValue(), (int)((double)blockerRenderer.this$0.box.getValue().getAlpha() * (1.0 - a2.firstFade.getQuad(FadeUtils.Quad.In2)))));
                    continue block0;
                }
                break;
            } while (true);
            if (bl) {
                renderMap.clear();
            }
        }

        public static void addBlock(class_2338 a) {
            class_2338 class_23382 = a;
            class_2338 class_23383 = a;
            renderMap.put(class_23383, new placePosition(class_23383));
        }

        public static class placePosition {
            public boolean isAir;
            public final class_2338 pos;
            public final Timer timer;
            public final FadeUtils firstFade;

            public placePosition(class_2338 class_23382) {
                placePosition a;
                placePosition a2 = class_23382;
                placePosition placePosition2 = a = this;
                placePosition placePosition3 = a;
                placePosition3.firstFade = new FadeUtils((long)Blocker.INSTANCE.fadeTime.getValue());
                placePosition2.pos = a2;
                placePosition2.timer = new Timer();
                placePosition2.isAir = true;
            }
        }

    }

}
