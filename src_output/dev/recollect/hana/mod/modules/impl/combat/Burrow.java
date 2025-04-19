/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1303
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1667
 *  net.minecraft.class_1683
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_310
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1667;
import net.minecraft.class_1683;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class Burrow
extends Module {
    private final BooleanSetting inventory;
    private final BooleanSetting noSelfPos;
    public final BooleanSetting helper;
    public static Burrow INSTANCE;
    private final BooleanSetting center;
    private final BooleanSetting headFill;
    private final BooleanSetting wait;
    private final List<class_2338> placePos;
    private final BooleanSetting packetPlace;
    private int progress;
    private final SliderSetting smartDown;
    private final SliderSetting smartUp;
    private final EnumSetting<RotateMode> rotate;
    private final SliderSetting blocksPer;
    private final BooleanSetting fakeMove;
    private final EnumSetting<LagBackMode> aboveLagMode;
    private final SliderSetting smartDistance;
    private final BooleanSetting enderChest;
    private final BooleanSetting sound;
    private final SliderSetting smartX;
    private final BooleanSetting antiLag;
    private final EnumSetting<LagBackMode> lagMode;
    private final BooleanSetting breakCrystal;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void placeBlock(class_2338 class_23382, boolean bl) {
        Burrow a = this;
        Burrow a2 = class_23382;
        if (a.canPlace((class_2338)a2) && !a.placePos.contains(a2)) {
            Burrow burrow = a;
            if (burrow.progress < burrow.blocksPer.getValueInt()) {
                void a3;
                Burrow burrow2 = a2;
                a.placePos.add((class_2338)burrow2);
                ++a.progress;
                class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)burrow2);
                if (class_23502 == null) {
                    return;
                }
                BlockUtil.placedPos.add((class_2338)a2);
                if (a.sound.getValue()) {
                    Burrow.mc.field_1687.method_8396((class_1657)Burrow.mc.field_1724, (class_2338)a2, class_3417.field_14574, class_3419.field_15245, 1.0f, 0.8f);
                }
                BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), (boolean)a3, a.packetPlace.getValue());
            }
        }
    }

    public Burrow() {
        Burrow a;
        Burrow burrow = a;
        super(UserInfo.ALLATORIxDEMO("2 \u001f:\u001a'"), Module.Category.Combat);
        Burrow burrow2 = a;
        burrow2.enderChest = burrow.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("q\u000eW\u0002F#A\u0018\u0010C"), true));
        burrow.antiLag = burrow.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("\u0014\u001e!\u0004\u0004\u00147"), true));
        burrow.helper = burrow.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("|\u0005E\r\u0006E"), true));
        burrow.headFill = burrow.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("80\u00111+!\u0019<"), true));
        burrow.noSelfPos = burrow.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO(".\\4Q\fO-\fD"), false));
        burrow.packetPlace = burrow.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("5\u00161\u001b0\u0004\u0005\u0001)\u00165"), true));
        burrow.sound = burrow.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("3F\b\rS"), true));
        burrow.blocksPer = burrow.add(new SliderSetting(UserInfo.ALLATORIxDEMO("\u0010\u001c:\u0013>\u001e\u0018\u0010\""), 4.0, 1.0, 16.0, 1.0));
        burrow.rotate = burrow.add(new EnumSetting<RotateMode>(RadiusUtils.ALLATORIxDEMO("f\u000fG\u0006@\u0005d\u0012\u0007R"), RotateMode.Bypass));
        burrow.breakCrystal = burrow.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("\u0017\u001f-\u0014;"), true));
        burrow.wait = burrow.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("~\u001c\nC"), true));
        burrow.fakeMove = burrow.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("64\u001b0 '\u00035"), true).setParent());
        burrow.center = burrow.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("tX\f\\\u0010w\u0005G\t\u0006E"), false, object -> {
            Object a = object;
            Burrow a2 = this;
            return a2.fakeMove.isOpen();
        }));
        Burrow burrow3 = a;
        burrow3.inventory = burrow3.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("@.\u0013\u0012<\u0004:\u0002,>?\u0014 "), true));
        burrow3.lagMode = burrow3.add(new EnumSetting<LagBackMode>(RadiusUtils.ALLATORIxDEMO("+U\u0007d\u0012\u0007R"), LagBackMode.TrollHack));
        burrow3.aboveLagMode = burrow3.add(new EnumSetting<LagBackMode>(UserInfo.ALLATORIxDEMO("(\u0018$\u0015\u0019\u00112 '\u00115"), LagBackMode.Smart));
        burrow3.smartX = burrow3.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("4Y\u0001[\t;m"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            Burrow a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        a.smartUp = a.add(new SliderSetting(UserInfo.ALLATORIxDEMO("\u0006\u001d4\u001f<  "), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            Burrow a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        a.smartDown = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("3^\u0006F\u0014m\u0012\u0014Y"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            Burrow a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        a.smartDistance = a.add(new SliderSetting(UserInfo.ALLATORIxDEMO("Z-\u0004\u0005&4<\u0003!\f&\u00165"), 2.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            Burrow a2 = this;
            return a2.lagMode.getValue() == LagBackMode.Smart || a2.aboveLagMode.getValue() == LagBackMode.Smart;
        }));
        Burrow burrow4 = a;
        a.progress = 0;
        burrow4.placePos = new ArrayList<class_2338>();
        burrow4.setChinese(RadiusUtils.ALLATORIxDEMO("\u57a8\u812d"));
        INSTANCE = burrow4;
    }

    private /* synthetic */ void gotoPos(class_2338 class_23382) {
        Burrow a = class_23382;
        Burrow a2 = this;
        if (a2.rotate.getValue() == RotateMode.None) {
            Burrow.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829((double)a.method_10263() + 0.5, Burrow.mc.field_1724.method_23318() + 0.2, (double)a.method_10260() + 0.5, false));
            return;
        }
        Burrow.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2830((double)a.method_10263() + 0.5, Burrow.mc.field_1724.method_23318() + 0.2, (double)a.method_10260() + 0.5, Hana.ROTATE.rotateYaw, 90.0f, false));
    }

    /*
     * Exception decompiling
     */
    public boolean canPlace(class_2338 var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 1[WHILELOOP]
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean hasEntity(class_2338 a) {
        Burrow a2;
        Burrow burrow = a2;
        a = Burrow.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                a2 = (class_1297)a.next();
                if (a2 == Burrow.mc.field_1724) {
                    object = a;
                    continue;
                }
                if (!a2.method_5805() || a2 instanceof class_1542 || a2 instanceof class_1303 || a2 instanceof class_1683 || a2 instanceof class_1667 || a2 instanceof class_1511 && burrow.breakCrystal.getValue()) continue block0;
                if (!(a2 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                object = a;
            }
            break;
        } while (true);
        return false;
    }

    private /* synthetic */ int getBlock() {
        Burrow a;
        if (a.inventory.getValue()) {
            if (InventoryUtil.findBlockInventorySlot(class_2246.field_10540) != -1 || !a.enderChest.getValue()) {
                return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
            }
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10443);
        }
        if (InventoryUtil.findBlock(class_2246.field_10540) != -1 || !a.enderChest.getValue()) {
            return InventoryUtil.findBlock(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10443);
    }

    private /* synthetic */ boolean canGoto(class_2338 class_23382) {
        Burrow a = class_23382;
        Burrow a2 = this;
        return Burrow.mc.field_1687.method_22347((class_2338)a) && Burrow.mc.field_1687.method_22347(a.method_10084());
    }

    private /* synthetic */ boolean checkSelf(class_2338 class_23382) {
        Burrow a = class_23382;
        Burrow a2 = this;
        return Burrow.mc.field_1724.method_5829().method_994(new class_238((class_2338)a));
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        Burrow a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, Burrow.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    /*
     * Exception decompiling
     */
    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent a) {
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

    private /* synthetic */ boolean Trapped(class_2338 class_23382) {
        Burrow a = class_23382;
        Burrow a2 = this;
        return Burrow.mc.field_1687.method_39454((class_1297)Burrow.mc.field_1724, new class_238((class_2338)a)) && a2.checkSelf(a.method_10087(2));
    }

    private static final class RotateMode
    extends Enum<RotateMode> {
        private static final /* synthetic */ RotateMode[] $VALUES;
        public static final /* enum */ RotateMode Normal;
        public static final /* enum */ RotateMode Bypass;
        public static final /* enum */ RotateMode None;

        static {
            Bypass = new RotateMode(UserInfo.ALLATORIxDEMO("/1\u0016\"\u00141"), 0);
            Normal = new RotateMode(Snow.ALLATORIxDEMO("@5w<e<"), 1);
            None = new RotateMode(UserInfo.ALLATORIxDEMO("(,\t'"), 2);
            $VALUES = RotateMode.$values();
        }

        public static RotateMode[] values() {
            return (RotateMode[])$VALUES.clone();
        }

        private static /* synthetic */ RotateMode[] $values() {
            RotateMode[] arrrotateMode = new RotateMode[3];
            arrrotateMode[0] = Bypass;
            arrrotateMode[1] = Normal;
            arrrotateMode[2] = None;
            return arrrotateMode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ RotateMode() {
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

        public static RotateMode valueOf(String a) {
            return Enum.valueOf(RotateMode.class, a);
        }
    }

    private static final class LagBackMode
    extends Enum<LagBackMode> {
        public static final /* enum */ LagBackMode Tongyiqianweng;
        private static final /* synthetic */ LagBackMode[] $VALUES;
        public static final /* enum */ LagBackMode Smart;
        public static final /* enum */ LagBackMode Normal;
        public static final /* enum */ LagBackMode ToVoid;
        public static final /* enum */ LagBackMode TrollHack;
        public static final /* enum */ LagBackMode Fly;
        public static final /* enum */ LagBackMode Invalid;
        public static final /* enum */ LagBackMode Rotation;

        static {
            Smart = new LagBackMode(BufferRing.ALLATORIxDEMO(".9\u0001l^"), 0);
            Invalid = new LagBackMode(SocketClient.ALLATORIxDEMO("oOrKcBj"), 1);
            TrollHack = new LagBackMode(BufferRing.ALLATORIxDEMO(")<\u0015%\u0011\u001c\u0001}A"), 2);
            ToVoid = new LagBackMode(SocketClient.ALLATORIxDEMO("uk|`Bj"), 3);
            Normal = new LagBackMode(BufferRing.ALLATORIxDEMO("\u0007\u0012&\rF"), 4);
            Rotation = new LagBackMode(SocketClient.ALLATORIxDEMO("QIUe^fD`"), 5);
            Fly = new LagBackMode(BufferRing.ALLATORIxDEMO("&rS"), 6);
            Tongyiqianweng = new LagBackMode(SocketClient.ALLATORIxDEMO("{eCo\\irO@j]jEi"), 7);
            $VALUES = LagBackMode.$values();
        }

        private static /* synthetic */ LagBackMode[] $values() {
            LagBackMode[] arrlagBackMode = new LagBackMode[8];
            arrlagBackMode[0] = Smart;
            arrlagBackMode[1] = Invalid;
            arrlagBackMode[2] = TrollHack;
            arrlagBackMode[3] = ToVoid;
            arrlagBackMode[4] = Normal;
            arrlagBackMode[5] = Rotation;
            arrlagBackMode[6] = Fly;
            arrlagBackMode[7] = Tongyiqianweng;
            return arrlagBackMode;
        }

        public static LagBackMode valueOf(String a) {
            return Enum.valueOf(LagBackMode.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ LagBackMode() {
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

        public static LagBackMode[] values() {
            return (LagBackMode[])$VALUES.clone();
        }
    }

}
