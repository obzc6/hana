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
 *  net.minecraft.class_2189
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_2404
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_310
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_4770
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.xibao.SnowAnimation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
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
import net.minecraft.class_2189;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_2404;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4770;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class SelfFill
extends Module {
    private final SliderSetting offAuto;
    public final EnumSetting<FakeJumpMode> Jump;
    private final BooleanSetting inventory;
    private final BooleanSetting BypassAu;
    public final EnumSetting<Page> page;
    private final SliderSetting offTo;
    public final BooleanSetting helper;
    private final BooleanSetting fakeMove;
    private final SliderSetting smartUp;
    private final BooleanSetting sound;
    private final List<class_2338> placePos;
    private final BooleanSetting wait;
    private final BooleanSetting breakCrystal;
    private final BooleanSetting OnGround;
    private final SliderSetting smartDown;
    private final BooleanSetting BypassTo;
    private final EnumSetting<RotateMode> rotate;
    private final SliderSetting smartDistance;
    private final SliderSetting blocksPer;
    private final BooleanSetting center;
    private final BooleanSetting antiLag;
    private final BooleanSetting packetPlace;
    private final BooleanSetting self;
    private final BooleanSetting ScannerY;
    private final SliderSetting AACOff;
    private final BooleanSetting enderChest;
    public final EnumSetting<Mode> Packet;
    private final BooleanSetting Bypass;
    private final BooleanSetting headFill;
    private final SliderSetting off;
    private int progress;
    private final BooleanSetting tick;
    private final SliderSetting offAu;
    private final BooleanSetting noSelfPos;
    private final SliderSetting smartX;

    private /* synthetic */ boolean canGoto(class_2338 class_23382) {
        SelfFill a = class_23382;
        SelfFill a2 = this;
        if (SelfFill.mc.field_1687 != null) {
            return SelfFill.mc.field_1687.method_22347((class_2338)a) && SelfFill.mc.field_1687.method_22347(a.method_10084());
        }
        return false;
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

    public SelfFill() {
        SelfFill a;
        SelfFill selfFill = a;
        super(Start.ALLATORIxDEMO("x`@dwv\u00179"), Module.Category.Exploit);
        SelfFill selfFill2 = a;
        selfFill2.page = selfFill.add(new EnumSetting<Page>(TimeHelper.ALLATORIxDEMO("m\u001e\u0010P"), Page.Misc));
        selfFill.OnGround = selfFill.add(new BooleanSetting(Start.ALLATORIxDEMO("dkkp^j\u00151"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.antiLag = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("$N\u0016T3\u0016R"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.noSelfPos = a.add(new BooleanSetting(Start.ALLATORIxDEMO("LDVInWO\u0014&"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.breakCrystal = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("7EE\u0003L&R\u001bN\u000b\u0016Y"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.wait = a.add(new BooleanSetting(Start.ALLATORIxDEMO("f~\u0012!"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.headFill = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("o\u0000A\u0006{\u0016\u001bY"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        a.rotate = a.add(new EnumSetting<RotateMode>(Start.ALLATORIxDEMO("~m_dXg|p\u001f0"), RotateMode.Bypass, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.RotateBypass;
        }));
        a.fakeMove = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("a\u0004K\u0007p\u0010\u0001P"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Move;
        }).setParent());
        a.center = a.add(new BooleanSetting(Start.ALLATORIxDEMO("\u0016@nDrog_k\u001e'"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Move && a2.fakeMove.isOpen();
        }));
        a.Packet = a.add(new EnumSetting<Mode>(TimeHelper.ALLATORIxDEMO(")A\u0005p\u0010\u0013P"), Mode.Au, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Packet;
        }));
        a.smartX = a.add(new SliderSetting(Start.ALLATORIxDEMO("VAcCk#\u000f"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Smart;
        }));
        a.smartUp = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("6M\u0003O\u000b\"E"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Smart;
        }));
        a.smartDown = a.add(new SliderSetting(Start.ALLATORIxDEMO("QFd^vup\f;"), 3.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Smart;
        }));
        a.smartDistance = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("4\u0018VR\u0016c\fS\u0016\\\u0011\u0014P"), 2.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Smart;
        }));
        a.off = a.add(new SliderSetting(Start.ALLATORIxDEMO("bK`cVP\u001d3"), 2.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Invalid;
        }));
        a.Bypass = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("n+b\u001bM\u001e\u0004F"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Invalid;
        }));
        a.offAu = a.add(new SliderSetting(Start.ALLATORIxDEMO("jP`cVP\u001d3"), 2.0, 0.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Au;
        }));
        a.BypassAu = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("f0b\u001bM\u001e\u0004F"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Au;
        }));
        a.offTo = a.add(new SliderSetting(Start.ALLATORIxDEMO("}A`cVP\u001d3"), 108.0, 0.0, 109.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.ToVoid;
        }));
        a.BypassTo = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("q!b\u001bM\u001e\u0004F"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.ToVoid;
        }));
        a.self = a.add(new BooleanSetting(Start.ALLATORIxDEMO("VInWS\u001a2"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Nu;
        }));
        a.offAuto = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("l\u0003Z0\u0011S"), 1.0, -1.0, 2.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Auto;
        }));
        a.ScannerY = a.add(new BooleanSetting(Start.ALLATORIxDEMO("VOc_q\u001e'"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Scanner;
        }));
        a.tick = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("1I\u0001V3\u0016R"), false, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Scanner;
        }));
        a.AACOff = a.add(new SliderSetting(Start.ALLATORIxDEMO("CjF`cVP\u001d3"), 2.0, -10.0, 10.0, 0.1, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.Packet.getValue() == Mode.Scanner;
        }));
        a.Jump = a.add(new EnumSetting<FakeJumpMode>(TimeHelper.ALLATORIxDEMO(")A\u0005p\u0010\u0013P"), FakeJumpMode.Normal, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.FakeJump;
        }));
        a.blocksPer = a.add(new SliderSetting(Start.ALLATORIxDEMO("@GjOiBO\u001e'"), 4.0, 1.0, 9.0, 1.0, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Place;
        }));
        a.enderChest = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("e\fC\u0000R!U\u001a\u0004A"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Place;
        }));
        a.inventory = a.add(new BooleanSetting(Start.ALLATORIxDEMO("N\u0017!Il_j^{bh\u001a%"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Place;
        }));
        a.helper = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("h\u0007Q\u000f\u0012G"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Place;
        }));
        a.packetPlace = a.add(new BooleanSetting(Start.ALLATORIxDEMO("\u0007Ma@`XR]~\u00180"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Place;
        }));
        a.sound = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("1R\n\u0019Q"), true, object -> {
            Object a = object;
            SelfFill a2 = this;
            return a2.page.getValue() == Page.Place;
        }));
        a.progress = 0;
        a.placePos = new ArrayList<class_2338>();
        a.setChinese(Start.ALLATORIxDEMO("\u5bb8\u5177\u568f\u814f"));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ void FakeJump(UpdateWalkingEvent a) {
        block89 : {
            block85 : {
                block90 : {
                    block84 : {
                        block83 : {
                            block82 : {
                                block88 : {
                                    block81 : {
                                        block80 : {
                                            block79 : {
                                                var2_2 = a;
                                                switch (var2_2.Jump.getValue().ordinal()) {
                                                    case 0: {
                                                        while (false) {
                                                        }
                                                        var20_3 = 0;
                                                        if (SelfFill.mc.field_1724 != null) {
                                                            var20_3 = SelfFill.mc.field_1724.method_31548().field_7545;
                                                        }
                                                        if ((var18_6 = var2_2.getBlock()) == -1) {
                                                            CommandManager.sendChatMessage("\u00a7e[?] \u00a7c\u00a7oObsidian" + (var2_2.enderChest.getValue() != false ? TimeHelper.ALLATORIxDEMO("Oi\u0000g$N=L\u0003J\u000f") : "") + "?");
                                                            var2_2.disable();
                                                            return;
                                                        }
                                                        v0 = var2_2;
                                                        v0.progress = 0;
                                                        v0.placePos.clear();
                                                        var4_9 = CombatSetting.getOffset();
                                                        var6_12 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_9, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() + var4_9);
                                                        var7_15 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_9, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() + var4_9);
                                                        var8_18 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_9, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() - var4_9);
                                                        var9_21 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_9, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() - var4_9);
                                                        var10_24 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_9, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() + var4_9);
                                                        var11_27 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_9, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() + var4_9);
                                                        var12_30 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_9, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() - var4_9);
                                                        var13_33 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_9, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() - var4_9);
                                                        var14_36 = EntityUtil.getPlayerPos(true);
                                                        var15_39 = false;
                                                        if (!(v0.canPlace(var6_12) || var2_2.canPlace(var7_15) || var2_2.canPlace(var8_18) || var2_2.canPlace(var9_21))) {
                                                            var15_39 = true;
                                                            if (!(var2_2.headFill.getValue() && (var2_2.canPlace(var10_24) || var2_2.canPlace(var11_27) || var2_2.canPlace(var12_30) || var2_2.canPlace(var13_33)))) {
                                                                if (var2_2.wait.getValue() != false) return;
                                                                var2_2.disable();
                                                                return;
                                                            }
                                                        }
                                                        var16_42 = false;
                                                        var17_45 = EntityUtil.getPlayerPos(true).method_10086(2);
                                                        v1 = var3_48 = var2_2.rotate.getValue() == RotateMode.Normal;
                                                        v2 = var3_48;
                                                        CombatUtil.attackCrystal(var6_12, v2, false);
                                                        CombatUtil.attackCrystal(var7_15, v2, false);
                                                        CombatUtil.attackCrystal(var8_18, v1, false);
                                                        CombatUtil.attackCrystal(var9_21, v1, false);
                                                        if (!SelfFill.mc.field_1724.method_24828()) {
                                                            return;
                                                        }
                                                        if (!var15_39 && !SelfFill.mc.field_1724.method_18276() && !var2_2.Trapped(var17_45) && !var2_2.Trapped(var17_45.method_10069(1, 0, 0)) && !var2_2.Trapped(var17_45.method_10069(-1, 0, 0)) && !var2_2.Trapped(var17_45.method_10069(0, 0, 1)) && !var2_2.Trapped(var17_45.method_10069(0, 0, -1)) && !var2_2.Trapped(var17_45.method_10069(1, 0, -1)) && !var2_2.Trapped(var17_45.method_10069(-1, 0, -1)) && !var2_2.Trapped(var17_45.method_10069(1, 0, 1)) && !var2_2.Trapped(var17_45.method_10069(-1, 0, 1))) ** GOTO lbl58
                                                        var16_42 = true;
                                                        if (!var2_2.fakeMove.getValue()) {
                                                            if (var2_2.wait.getValue() != false) return;
                                                            var2_2.disable();
                                                            return;
                                                        }
                                                        var19_51 = false;
                                                        a = var14_36;
                                                        if (!(!var2_2.checkSelf((class_2338)a) || BlockUtil.canReplace((class_2338)a) || var2_2.headFill.getValue() && BlockUtil.canReplace(a.method_10084()))) {
                                                            var2_2.gotoPos((class_2338)a);
                                                        } else {
                                                            var21_55 = class_2350.values();
                                                            var22_59 = var21_55.length;
                                                            v3 = var23_62 = 0;
                                                            break;
lbl58: // 1 sources:
                                                            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 0.4199999868869781, SelfFill.mc.field_1724.method_23321(), false));
                                                            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 0.7531999805212017, SelfFill.mc.field_1724.method_23321(), false));
                                                            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 0.9999957640154541, SelfFill.mc.field_1724.method_23321(), false));
                                                            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 1.1661092609382138, SelfFill.mc.field_1724.method_23321(), false));
                                                        }
lbl62: // 5 sources:
                                                        do {
                                                            v4 = var2_2;
                                                            v4.doSwap(var18_6);
                                                            if (v4.rotate.getValue() == RotateMode.Bypass) {
                                                                a.cancelRotate();
                                                                EntityUtil.sendYawAndPitch(Hana.ROTATE.rotateYaw, 90.0f);
                                                            }
                                                            if (!SelfFill.mc.field_1724.method_24828()) {
                                                                return;
                                                            }
                                                            if (var2_2.helper.getValue()) {
                                                                var2_2.placeBlock(var14_36.method_10074(), var3_48);
                                                            }
                                                            v5 = var2_2;
                                                            v5.placeBlock(var14_36, var3_48);
                                                            if (v5.helper.getValue()) {
                                                                var2_2.placeBlock(var6_12.method_10074(), var3_48);
                                                            }
                                                            v6 = var2_2;
                                                            v6.placeBlock(var6_12, var3_48);
                                                            if (v6.helper.getValue()) {
                                                                var2_2.placeBlock(var7_15.method_10074(), var3_48);
                                                            }
                                                            v7 = var2_2;
                                                            v7.placeBlock(var7_15, var3_48);
                                                            if (v7.helper.getValue()) {
                                                                var2_2.placeBlock(var8_18.method_10074(), var3_48);
                                                            }
                                                            v8 = var2_2;
                                                            v8.placeBlock(var8_18, var3_48);
                                                            if (v8.helper.getValue()) {
                                                                var2_2.placeBlock(var9_21.method_10074(), var3_48);
                                                            }
                                                            v9 = var2_2;
                                                            v9.placeBlock(var9_21, var3_48);
                                                            if (v9.headFill.getValue() && var16_42) {
                                                                v10 = var2_2;
                                                                v11 = var3_48;
                                                                var2_2.placeBlock(var10_24, var3_48);
                                                                var2_2.placeBlock(var11_27, v11);
                                                                v10.placeBlock(var12_30, v11);
                                                                v10.placeBlock(var13_33, var3_48);
                                                            }
                                                            v12 = var2_2;
                                                            if (var2_2.inventory.getValue()) {
                                                                v12.doSwap(var18_6);
                                                                EntityUtil.syncInventory();
                                                                return;
                                                            }
                                                            v12.doSwap(var20_3);
                                                            return;
                                                            break;
                                                        } while (true);
                                                    }
                                                    case 2: {
                                                        var20_4 = 0;
                                                        if (SelfFill.mc.field_1724 != null) {
                                                            var20_4 = SelfFill.mc.field_1724.method_31548().field_7545;
                                                        }
                                                        if ((var18_7 = var2_2.getBlock()) == -1) {
                                                            CommandManager.sendChatMessage("\u00a7e[?] \u00a7c\u00a7oObsidian" + (var2_2.enderChest.getValue() != false ? Start.ALLATORIxDEMO("/e`kDB]@cFo") : "") + "?");
                                                            var2_2.disable();
                                                            return;
                                                        }
                                                        v13 = var2_2;
                                                        v13.progress = 0;
                                                        v13.placePos.clear();
                                                        var4_10 = CombatSetting.getOffset();
                                                        var6_13 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_10, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() + var4_10);
                                                        var7_16 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_10, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() + var4_10);
                                                        var8_19 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_10, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() - var4_10);
                                                        var9_22 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_10, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() - var4_10);
                                                        var10_25 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_10, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() + var4_10);
                                                        var11_28 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_10, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() + var4_10);
                                                        var12_31 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_10, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() - var4_10);
                                                        var13_34 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_10, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() - var4_10);
                                                        var14_37 = EntityUtil.getPlayerPos(true);
                                                        var15_40 = false;
                                                        if (!(v13.canPlace(var6_13) || var2_2.canPlace(var7_16) || var2_2.canPlace(var8_19) || var2_2.canPlace(var9_22))) {
                                                            var15_40 = true;
                                                            if (!(var2_2.headFill.getValue() && (var2_2.canPlace(var10_25) || var2_2.canPlace(var11_28) || var2_2.canPlace(var12_31) || var2_2.canPlace(var13_34)))) {
                                                                if (var2_2.wait.getValue() != false) return;
                                                                var2_2.disable();
                                                                return;
                                                            }
                                                        }
                                                        var16_43 = false;
                                                        var17_46 = EntityUtil.getPlayerPos(true).method_10086(2);
                                                        v14 = var3_49 = var2_2.rotate.getValue() == RotateMode.Normal;
                                                        v15 = var3_49;
                                                        CombatUtil.attackCrystal(var6_13, v15, false);
                                                        CombatUtil.attackCrystal(var7_16, v15, false);
                                                        CombatUtil.attackCrystal(var8_19, v14, false);
                                                        CombatUtil.attackCrystal(var9_22, v14, false);
                                                        if (!SelfFill.mc.field_1724.method_24828()) {
                                                            return;
                                                        }
                                                        if (!var15_40 && !SelfFill.mc.field_1724.method_18276() && !var2_2.Trapped(var17_46) && !var2_2.Trapped(var17_46.method_10069(1, 0, 0)) && !var2_2.Trapped(var17_46.method_10069(-1, 0, 0)) && !var2_2.Trapped(var17_46.method_10069(0, 0, 1)) && !var2_2.Trapped(var17_46.method_10069(0, 0, -1)) && !var2_2.Trapped(var17_46.method_10069(1, 0, -1)) && !var2_2.Trapped(var17_46.method_10069(-1, 0, -1)) && !var2_2.Trapped(var17_46.method_10069(1, 0, 1)) && !var2_2.Trapped(var17_46.method_10069(-1, 0, 1))) ** GOTO lbl157
                                                        var16_43 = true;
                                                        if (!var2_2.fakeMove.getValue()) {
                                                            if (var2_2.wait.getValue() != false) return;
                                                            var2_2.disable();
                                                            return;
                                                        }
                                                        var19_52 = false;
                                                        a = var14_37;
                                                        if (!var2_2.checkSelf((class_2338)a) || BlockUtil.canReplace((class_2338)a) || var2_2.headFill.getValue() && BlockUtil.canReplace(a.method_10084())) ** GOTO lbl153
                                                        var2_2.gotoPos((class_2338)a);
                                                        ** GOTO lbl161
lbl153: // 1 sources:
                                                        var21_56 = class_2350.values();
                                                        var22_60 = var21_56.length;
                                                        v16 = var23_63 = 0;
                                                        break block88;
lbl157: // 1 sources:
                                                        SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 0.41999998688698, SelfFill.mc.field_1724.method_23321(), false));
                                                        SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 0.75319998052119, SelfFill.mc.field_1724.method_23321(), false));
                                                        SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 1.00133597911214, SelfFill.mc.field_1724.method_23321(), false));
                                                        SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(SelfFill.mc.field_1724.method_23317(), SelfFill.mc.field_1724.method_23318() + 1.15610926093821, SelfFill.mc.field_1724.method_23321(), false));
lbl161: // 5 sources:
                                                        do {
                                                            v17 = var2_2;
                                                            v17.doSwap(var18_7);
                                                            if (v17.rotate.getValue() == RotateMode.Bypass) {
                                                                a.cancelRotate();
                                                                EntityUtil.sendYawAndPitch(Hana.ROTATE.rotateYaw, 90.0f);
                                                            }
                                                            if (!SelfFill.mc.field_1724.method_24828()) {
                                                                return;
                                                            }
                                                            if (var2_2.helper.getValue()) {
                                                                var2_2.placeBlock(var14_37.method_10074(), var3_49);
                                                            }
                                                            v18 = var2_2;
                                                            v18.placeBlock(var14_37, var3_49);
                                                            if (v18.helper.getValue()) {
                                                                var2_2.placeBlock(var6_13.method_10074(), var3_49);
                                                            }
                                                            v19 = var2_2;
                                                            v19.placeBlock(var6_13, var3_49);
                                                            if (v19.helper.getValue()) {
                                                                var2_2.placeBlock(var7_16.method_10074(), var3_49);
                                                            }
                                                            v20 = var2_2;
                                                            v20.placeBlock(var7_16, var3_49);
                                                            if (v20.helper.getValue()) {
                                                                var2_2.placeBlock(var8_19.method_10074(), var3_49);
                                                            }
                                                            v21 = var2_2;
                                                            v21.placeBlock(var8_19, var3_49);
                                                            if (v21.helper.getValue()) {
                                                                var2_2.placeBlock(var9_22.method_10074(), var3_49);
                                                            }
                                                            v22 = var2_2;
                                                            v22.placeBlock(var9_22, var3_49);
                                                            if (v22.headFill.getValue() && var16_43) {
                                                                v23 = var2_2;
                                                                v24 = var3_49;
                                                                var2_2.placeBlock(var10_25, var3_49);
                                                                var2_2.placeBlock(var11_28, v24);
                                                                v23.placeBlock(var12_31, v24);
                                                                v23.placeBlock(var13_34, var3_49);
                                                            }
                                                            v25 = var2_2;
                                                            if (var2_2.inventory.getValue()) {
                                                                v25.doSwap(var18_7);
                                                                EntityUtil.syncInventory();
                                                                return;
                                                            }
                                                            v25.doSwap(var20_4);
                                                            return;
                                                            break;
                                                        } while (true);
                                                    }
                                                    case 1: {
                                                        var20_5 = 0;
                                                        if (SelfFill.mc.field_1724 != null) {
                                                            var20_5 = SelfFill.mc.field_1724.method_31548().field_7545;
                                                        }
                                                        if ((var18_8 = var2_2.getBlock()) == -1) {
                                                            CommandManager.sendChatMessage("\u00a7e[?] \u00a7c\u00a7oObsidian" + (var2_2.enderChest.getValue() != false ? TimeHelper.ALLATORIxDEMO("Oi\u0000g$N=L\u0003J\u000f") : "") + "?");
                                                            var2_2.disable();
                                                            return;
                                                        }
                                                        v26 = var2_2;
                                                        v26.progress = 0;
                                                        v26.placePos.clear();
                                                        var4_11 = CombatSetting.getOffset();
                                                        var6_14 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_11, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() + var4_11);
                                                        var7_17 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_11, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() + var4_11);
                                                        var8_20 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_11, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() - var4_11);
                                                        var9_23 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_11, SelfFill.mc.field_1724.method_23318() + 0.5, SelfFill.mc.field_1724.method_23321() - var4_11);
                                                        var10_26 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_11, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() + var4_11);
                                                        var11_29 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_11, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() + var4_11);
                                                        var12_32 = new BlockPosX(SelfFill.mc.field_1724.method_23317() + var4_11, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() - var4_11);
                                                        var13_35 = new BlockPosX(SelfFill.mc.field_1724.method_23317() - var4_11, SelfFill.mc.field_1724.method_23318() + 1.5, SelfFill.mc.field_1724.method_23321() - var4_11);
                                                        var14_38 = EntityUtil.getPlayerPos(true);
                                                        var15_41 = false;
                                                        if (!(v26.canPlace(var6_14) || var2_2.canPlace(var7_17) || var2_2.canPlace(var8_20) || var2_2.canPlace(var9_23))) {
                                                            var15_41 = true;
                                                            if (!(var2_2.headFill.getValue() && (var2_2.canPlace(var10_26) || var2_2.canPlace(var11_29) || var2_2.canPlace(var12_32) || var2_2.canPlace(var13_35)))) {
                                                                if (var2_2.wait.getValue() != false) return;
                                                                var2_2.disable();
                                                                return;
                                                            }
                                                        }
                                                        var16_44 = false;
                                                        var17_47 = EntityUtil.getPlayerPos(true).method_10086(2);
                                                        v27 = var3_50 = var2_2.rotate.getValue() == RotateMode.Normal;
                                                        v28 = var3_50;
                                                        CombatUtil.attackCrystal(var6_14, v28, false);
                                                        CombatUtil.attackCrystal(var7_17, v28, false);
                                                        CombatUtil.attackCrystal(var8_20, v27, false);
                                                        CombatUtil.attackCrystal(var9_23, v27, false);
                                                        if (!SelfFill.mc.field_1724.method_24828()) {
                                                            return;
                                                        }
                                                        if (!var15_41 && !SelfFill.mc.field_1724.method_18276() && !var2_2.Trapped(var17_47) && !var2_2.Trapped(var17_47.method_10069(1, 0, 0)) && !var2_2.Trapped(var17_47.method_10069(-1, 0, 0)) && !var2_2.Trapped(var17_47.method_10069(0, 0, 1)) && !var2_2.Trapped(var17_47.method_10069(0, 0, -1)) && !var2_2.Trapped(var17_47.method_10069(1, 0, -1)) && !var2_2.Trapped(var17_47.method_10069(-1, 0, -1)) && !var2_2.Trapped(var17_47.method_10069(1, 0, 1)) && !var2_2.Trapped(var17_47.method_10069(-1, 0, 1))) ** GOTO lbl256
                                                        var16_44 = true;
                                                        if (!var2_2.fakeMove.getValue()) {
                                                            if (var2_2.wait.getValue() != false) return;
                                                            var2_2.disable();
                                                            return;
                                                        }
                                                        var19_53 = false;
                                                        a = var14_38;
                                                        if (!var2_2.checkSelf((class_2338)a) || BlockUtil.canReplace((class_2338)a) || var2_2.headFill.getValue() && BlockUtil.canReplace(a.method_10084())) ** GOTO lbl252
                                                        var2_2.gotoPos((class_2338)a);
                                                        break block89;
lbl252: // 1 sources:
                                                        var21_57 = class_2350.values();
                                                        var22_61 = var21_57.length;
                                                        v29 = var23_64 = 0;
                                                        break block90;
lbl256: // 1 sources:
                                                        var19_54 = var14_38;
                                                        a = new LinkedList<E>();
                                                        var21_58 = var2_2.getVec3dDirection(var19_54);
                                                        a.add(new class_243(SelfFill.mc.field_1724.method_23317() + var21_58.field_1352 * 0.42132, SelfFill.mc.field_1724.method_23318() + 0.12160004615784, SelfFill.mc.field_1724.method_23321() + var21_58.field_1350 * 0.42132));
                                                        a.add(new class_243(SelfFill.mc.field_1724.method_23317() + var21_58.field_1352 * 0.95, SelfFill.mc.field_1724.method_23318() + 0.200000047683716, SelfFill.mc.field_1724.method_23321() + var21_58.field_1350 * 0.95));
                                                        a.add(new class_243(SelfFill.mc.field_1724.method_23317() + var21_58.field_1352 * 1.03, SelfFill.mc.field_1724.method_23318() + 0.200000047683716, SelfFill.mc.field_1724.method_23321() + var21_58.field_1350 * 1.03));
                                                        a.add(new class_243(SelfFill.mc.field_1724.method_23317() + var21_58.field_1352 * 1.0933, SelfFill.mc.field_1724.method_23318() + 0.12160004615784, SelfFill.mc.field_1724.method_23321() + var21_58.field_1350 * 1.0933));
                                                        break block89;
                                                    }
                                                }
                                                while (v3 < var22_59) {
                                                    var24_65 = var21_55[var23_62];
                                                    if (!(var24_65 == class_2350.field_11036 || var24_65 == class_2350.field_11033 || !var2_2.checkSelf((class_2338)(a = var14_36.method_10093(var24_65))) || BlockUtil.canReplace((class_2338)a) || var2_2.headFill.getValue() && BlockUtil.canReplace(a.method_10084()))) {
                                                        var2_2.gotoPos((class_2338)a);
                                                        v30 = var19_51 = true;
                                                        break block79;
                                                    }
                                                    v3 = ++var23_62;
                                                }
                                                v30 = var19_51;
                                            }
                                            if (v30) ** GOTO lbl62
                                            var21_55 = class_2350.values();
                                            var22_59 = var21_55.length;
                                            v31 = var23_62 = 0;
                                            while (v31 < var22_59) {
                                                var24_65 = var21_55[var23_62];
                                                if (var24_65 != class_2350.field_11036 && var24_65 != class_2350.field_11033 && var2_2.checkSelf((class_2338)(a = var14_36.method_10093(var24_65)))) {
                                                    var2_2.gotoPos((class_2338)a);
                                                    v32 = var19_51 = true;
                                                    break block80;
                                                }
                                                v31 = ++var23_62;
                                            }
                                            v32 = var19_51;
                                        }
                                        if (v32) ** GOTO lbl62
                                        if (!var2_2.center.getValue()) {
                                            return;
                                        }
                                        var21_55 = class_2350.values();
                                        var22_59 = var21_55.length;
                                        v33 = var23_62 = 0;
                                        while (v33 < var22_59) {
                                            var24_65 = var21_55[var23_62];
                                            if (var24_65 != class_2350.field_11036 && var24_65 != class_2350.field_11033 && var2_2.canGoto((class_2338)(a = var14_36.method_10093(var24_65)))) {
                                                var2_2.gotoPos((class_2338)a);
                                                v34 = var19_51 = true;
                                                break block81;
                                            }
                                            v33 = ++var23_62;
                                        }
                                        v34 = var19_51;
                                    }
                                    ** while (v34)
lbl311: // 1 sources:
                                    if (var2_2.wait.getValue() != false) return;
                                    var2_2.disable();
                                    return;
                                }
                                while (v16 < var22_60) {
                                    var24_66 = var21_56[var23_63];
                                    if (!(var24_66 == class_2350.field_11036 || var24_66 == class_2350.field_11033 || !var2_2.checkSelf((class_2338)(a = var14_37.method_10093(var24_66))) || BlockUtil.canReplace((class_2338)a) || var2_2.headFill.getValue() && BlockUtil.canReplace(a.method_10084()))) {
                                        var2_2.gotoPos((class_2338)a);
                                        v35 = var19_52 = true;
                                        break block82;
                                    }
                                    v16 = ++var23_63;
                                }
                                v35 = var19_52;
                            }
                            if (v35) ** GOTO lbl161
                            var21_56 = class_2350.values();
                            var22_60 = var21_56.length;
                            v36 = var23_63 = 0;
                            while (v36 < var22_60) {
                                var24_66 = var21_56[var23_63];
                                if (var24_66 != class_2350.field_11036 && var24_66 != class_2350.field_11033 && var2_2.checkSelf((class_2338)(a = var14_37.method_10093(var24_66)))) {
                                    var2_2.gotoPos((class_2338)a);
                                    v37 = var19_52 = true;
                                    break block83;
                                }
                                v36 = ++var23_63;
                            }
                            v37 = var19_52;
                        }
                        if (v37) ** GOTO lbl161
                        if (!var2_2.center.getValue()) {
                            return;
                        }
                        var21_56 = class_2350.values();
                        var22_60 = var21_56.length;
                        v38 = var23_63 = 0;
                        while (v38 < var22_60) {
                            var24_66 = var21_56[var23_63];
                            if (var24_66 != class_2350.field_11036 && var24_66 != class_2350.field_11033 && var2_2.canGoto((class_2338)(a = var14_37.method_10093(var24_66)))) {
                                var2_2.gotoPos((class_2338)a);
                                v39 = var19_52 = true;
                                break block84;
                            }
                            v38 = ++var23_63;
                        }
                        v39 = var19_52;
                    }
                    ** while (v39)
lbl356: // 1 sources:
                    if (var2_2.wait.getValue() != false) return;
                    var2_2.disable();
                    return;
                }
                while (v29 < var22_61) {
                    var24_67 = var21_57[var23_64];
                    if (!(var24_67 == class_2350.field_11036 || var24_67 == class_2350.field_11033 || !var2_2.checkSelf((class_2338)(a = var14_38.method_10093(var24_67))) || BlockUtil.canReplace((class_2338)a) || var2_2.headFill.getValue() && BlockUtil.canReplace(a.method_10084()))) {
                        var2_2.gotoPos((class_2338)a);
                        v40 = var19_53 = true;
                        break block85;
                    }
                    v29 = ++var23_64;
                }
                v40 = var19_53;
            }
            if (!v40) {
                block86 : {
                    var21_57 = class_2350.values();
                    var22_61 = var21_57.length;
                    v41 = var23_64 = 0;
                    while (v41 < var22_61) {
                        var24_67 = var21_57[var23_64];
                        if (var24_67 != class_2350.field_11036 && var24_67 != class_2350.field_11033 && var2_2.checkSelf((class_2338)(a = var14_38.method_10093(var24_67)))) {
                            var2_2.gotoPos((class_2338)a);
                            v42 = var19_53 = true;
                            break block86;
                        }
                        v41 = ++var23_64;
                    }
                    v42 = var19_53;
                }
                if (!v42) {
                    block87 : {
                        if (!var2_2.center.getValue()) {
                            return;
                        }
                        var21_57 = class_2350.values();
                        var22_61 = var21_57.length;
                        v43 = var23_64 = 0;
                        while (v43 < var22_61) {
                            var24_67 = var21_57[var23_64];
                            if (var24_67 != class_2350.field_11036 && var24_67 != class_2350.field_11033 && var2_2.canGoto((class_2338)(a = var14_38.method_10093(var24_67)))) {
                                var2_2.gotoPos((class_2338)a);
                                v44 = var19_53 = true;
                                break block87;
                            }
                            v43 = ++var23_64;
                        }
                        v44 = var19_53;
                    }
                    if (!v44) {
                        if (var2_2.wait.getValue() != false) return;
                        var2_2.disable();
                        return;
                    }
                }
            }
        }
        v45 = var2_2;
        v45.doSwap(var18_8);
        if (v45.rotate.getValue() == RotateMode.Bypass) {
            a.cancelRotate();
            EntityUtil.sendYawAndPitch(Hana.ROTATE.rotateYaw, 90.0f);
        }
        if (!SelfFill.mc.field_1724.method_24828()) {
            return;
        }
        if (var2_2.helper.getValue()) {
            var2_2.placeBlock(var14_38.method_10074(), var3_50);
        }
        v46 = var2_2;
        v46.placeBlock(var14_38, var3_50);
        if (v46.helper.getValue()) {
            var2_2.placeBlock(var6_14.method_10074(), var3_50);
        }
        v47 = var2_2;
        v47.placeBlock(var6_14, var3_50);
        if (v47.helper.getValue()) {
            var2_2.placeBlock(var7_17.method_10074(), var3_50);
        }
        v48 = var2_2;
        v48.placeBlock(var7_17, var3_50);
        if (v48.helper.getValue()) {
            var2_2.placeBlock(var8_20.method_10074(), var3_50);
        }
        v49 = var2_2;
        v49.placeBlock(var8_20, var3_50);
        if (v49.helper.getValue()) {
            var2_2.placeBlock(var9_23.method_10074(), var3_50);
        }
        v50 = var2_2;
        v50.placeBlock(var9_23, var3_50);
        if (v50.headFill.getValue() && var16_44) {
            v51 = var2_2;
            v52 = var3_50;
            var2_2.placeBlock(var10_26, var3_50);
            var2_2.placeBlock(var11_29, v52);
            v51.placeBlock(var12_32, v52);
            v51.placeBlock(var13_35, var3_50);
        }
        v53 = var2_2;
        if (var2_2.inventory.getValue()) {
            v53.doSwap(var18_8);
            EntityUtil.syncInventory();
            return;
        }
        v53.doSwap(var20_5);
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        SelfFill a;
        UpdateWalkingEvent a2 = updateWalkingEvent;
        SelfFill selfFill = a = this;
        SelfFill selfFill2 = a;
        selfFill2.Misc(a2);
        selfFill.FakeJump(a2);
        selfFill2.LagMode();
        selfFill.disable();
    }

    private /* synthetic */ void Misc(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        SelfFill a2 = this;
        if (a2.OnGround.getValue() && SelfFill.mc.field_1724 != null && (!SelfFill.mc.field_1724.method_24828() || HoleKick.isInWeb((class_1657)SelfFill.mc.field_1724) || a.isPost())) {
            return;
        }
        if (a2.antiLag.getValue() && !BlockUtil.getState(EntityUtil.getPlayerPos(true).method_10074()).method_51366()) {
            return;
        }
        if (a2.antiLag.getValue() && SelfFill.mc.field_1724 != null) {
            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2831(-180.0f, -89.0f, false));
            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2831(180.0f, 89.0f, false));
        }
    }

    private /* synthetic */ boolean checkSelf(class_2338 class_23382) {
        SelfFill a = class_23382;
        SelfFill a2 = this;
        if (SelfFill.mc.field_1724 != null) {
            return SelfFill.mc.field_1724.method_5829().method_994(new class_238((class_2338)a));
        }
        return false;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        SelfFill a2 = this;
        if (a2.inventory.getValue()) {
            if (SelfFill.mc.field_1724 != null) {
                InventoryUtil.inventorySwap(a, SelfFill.mc.field_1724.method_31548().field_7545);
                return;
            }
        } else {
            InventoryUtil.switchToSlot(a);
        }
    }

    public static class_2338 getPlayerPosFloored(class_243 a, double a2) {
        return new class_2338((int)Math.floor(a.field_1352), (int)Math.floor(a.field_1351 + a2), (int)Math.floor(a.field_1350));
    }

    public double sendPackets() {
        SelfFill a;
        SelfFill selfFill = a;
        if (SelfFill.mc.field_1724 != null && SelfFill.solid(selfFill.playerPos((class_1657)SelfFill.mc.field_1724).method_35830(2))) {
            return 0.0;
        }
        if (SelfFill.mc.field_1724 != null && SelfFill.solid(selfFill.playerPos((class_1657)SelfFill.mc.field_1724).method_35830(3))) {
            return 1.2;
        }
        int n = a = 4;
        while (n < 5) {
            if (SelfFill.solid(selfFill.playerPos((class_1657)SelfFill.mc.field_1724).method_35830(a))) {
                return 2.2 + (double)a - 4.0;
            }
            n = ++a;
        }
        int n2 = a = 6;
        while (n2 < 7) {
            if (SelfFill.solid(selfFill.playerPos((class_1657)SelfFill.mc.field_1724).method_35830(a))) {
                return 3.1 + (double)a - 6.0;
            }
            n2 = ++a;
        }
        return 8.0;
    }

    public static class_2338 getPlayerPos(class_1657 a) {
        return new class_2338((int)Math.floor(a.method_23317()), (int)Math.floor(a.method_23318()), (int)Math.floor(a.method_23321()));
    }

    public static boolean solid(class_2338 a) {
        class_2338 class_23382 = a;
        a = null;
        if (SelfFill.mc.field_1687 != null) {
            a = SelfFill.mc.field_1687.method_8320(class_23382).method_26204();
        }
        return !(a instanceof class_4770) && !(a instanceof class_2404) && !(a instanceof class_2189);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void placeBlock(class_2338 class_23382, boolean bl) {
        SelfFill a = this;
        SelfFill a2 = class_23382;
        if (a.canPlace((class_2338)a2) && !a.placePos.contains(a2)) {
            SelfFill selfFill = a;
            if (selfFill.progress < selfFill.blocksPer.getValueInt()) {
                void a3;
                SelfFill selfFill2 = a2;
                a.placePos.add((class_2338)selfFill2);
                ++a.progress;
                class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)selfFill2);
                if (class_23502 == null) {
                    return;
                }
                BlockUtil.placedPos.add((class_2338)a2);
                if (a.sound.getValue() && SelfFill.mc.field_1687 != null) {
                    SelfFill.mc.field_1687.method_8396((class_1657)SelfFill.mc.field_1724, (class_2338)a2, class_3417.field_14574, class_3419.field_15245, 1.0f, 0.8f);
                }
                BlockUtil.clickBlock(a2.method_10093(class_23502), class_23502.method_10153(), (boolean)a3, a.packetPlace.getValue());
            }
        }
    }

    public static class_2338 getPlayerPosFloored() {
        if (SelfFill.mc.field_1724 != null) {
            return new class_2338((int)Math.floor(SelfFill.mc.field_1724.method_23317()), (int)Math.floor(SelfFill.mc.field_1724.method_23318()), (int)Math.floor(SelfFill.mc.field_1724.method_23321()));
        }
        return null;
    }

    private /* synthetic */ class_2338 playerPos(class_1657 class_16572) {
        SelfFill a = class_16572;
        SelfFill a2 = this;
        return new class_2338((int)Math.floor(a.method_23317()), (int)Math.round(a.method_23318()), (int)Math.floor(a.method_23321()));
    }

    public static class_2338 getPlayerPosFloored(class_1297 a) {
        return new class_2338((int)Math.floor(a.method_23317()), (int)Math.floor(a.method_23318()), (int)Math.floor(a.method_23321()));
    }

    public class_243 getVec3dDirection(class_2338 a) {
        class_243 a2;
        class_243 class_2432 = a2;
        class_2338 class_23382 = null;
        if (SelfFill.mc.field_1724 != null) {
            class_23382 = SelfFill.mc.field_1724.method_24515();
        }
        a2 = a.method_46558();
        a2 = SelfFill.mc.field_1724.method_19538().method_1020(a2);
        class_243 class_2433 = class_243.field_1353;
        if (Math.abs(a2.field_1352) >= Math.abs(a2.field_1350) && Math.abs(a2.field_1352) > 0.2) {
            if (a2.field_1352 > 0.0) {
                class_2433 = new class_243(0.8 - a2.field_1352, 0.0, 0.0);
                return class_2433;
            }
            class_2433 = new class_243(-0.8 - a2.field_1352, 0.0, 0.0);
            return class_2433;
        }
        if (Math.abs(a2.field_1350) >= Math.abs(a2.field_1352) && Math.abs(a2.field_1350) > 0.2) {
            class_243 class_2434;
            if (a2.field_1350 > 0.0) {
                class_2434 = new class_243(0.0, 0.0, 0.8 - a2.field_1350);
                class_2433 = class_2434;
                return class_2434;
            }
            class_2434 = new class_243(0.0, 0.0, -0.8 - a2.field_1350);
            class_2433 = class_2434;
            return class_2434;
        }
        if (a.equals((Object)class_23382)) {
            int n;
            a = new ArrayList();
            a2 = class_2350.values();
            int n2 = ((class_2350[])a2).length;
            int n3 = n = 0;
            while (n3 < n2) {
                class_243 class_2435 = a2[n];
                if (class_2435 != class_2350.field_11036 && class_2435 != class_2350.field_11033 && !SelfFill.solid(class_23382.method_10093((class_2350)class_2435)) && !SelfFill.solid(class_23382.method_10093((class_2350)class_2435).method_10093(class_2350.field_11036))) {
                    a.add(class_2435);
                }
                n3 = ++n;
            }
            a2 = class_243.field_1353;
            class_243[] arrclass_243 = new class_243[1];
            class_243[] arrclass_2432 = new class_243[1];
            a.sort((class_23503, class_23504) -> {
                void a;
                void a2;
                void a3;
                class_243[] a4;
                class_2350 class_23505 = arrclass_243;
                arrclass_243 = class_23504;
                class_2350 a5 = class_23505;
                a5[0] = a3.method_1019(new class_243((double)a2.method_10148(), (double)a2.method_10164(), (double)a2.method_10165()).method_1021(0.5));
                a[0] = a3.method_1019(new class_243((double)a4.method_10148(), (double)a4.method_10164(), (double)a4.method_10165()).method_1021(0.5));
                return (int)(Math.sqrt(SelfFill.mc.field_1724.method_5649(a5[0].field_1352, SelfFill.mc.field_1724.method_23318(), a5[0].field_1350)) - Math.sqrt(SelfFill.mc.field_1724.method_5649(a[0].field_1352, SelfFill.mc.field_1724.method_23318(), a[0].field_1350)));
            });
            if (a.size() > 0) {
                class_2433 = new class_243((double)((class_2350)a.get(0)).method_10148(), (double)((class_2350)a.get(0)).method_10164(), (double)((class_2350)a.get(0)).method_10165());
            }
        }
        return class_2433;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void sendPlayerPacket(double d, double d2, double d3, boolean bl) {
        boolean bl2 = bl;
        SelfFill a = this;
        if (SelfFill.mc.field_1724 != null) {
            void a2;
            void a3;
            void a4;
            void a5;
            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829((double)a4, (double)a3, (double)a2, (boolean)a5));
        }
    }

    class_2382 getClip() {
        SelfFill a;
        SelfFill selfFill = a;
        a = null;
        if (SelfFill.mc.field_1724 != null) {
            a = SelfFill.getPlayerPosFloored((class_1297)SelfFill.mc.field_1724);
        }
        if (a != null && selfFill.isSelfBurrowClipPos(a.method_10069(0, 2, 0))) {
            return new class_2382(0, 2, 0);
        }
        if (a != null && selfFill.isSelfBurrowClipPos(a.method_10069(1, 1, 0))) {
            return new class_2382(1, 1, 0);
        }
        if (a != null && selfFill.isSelfBurrowClipPos(a.method_10069(-1, 1, 0))) {
            return new class_2382(-1, 1, 0);
        }
        if (a != null && selfFill.isSelfBurrowClipPos(a.method_10069(0, 1, 1))) {
            return new class_2382(0, 1, 1);
        }
        if (a != null && selfFill.isSelfBurrowClipPos(a.method_10069(0, 1, -1))) {
            return new class_2382(0, 1, -1);
        }
        return new class_2382(0, 2, 0);
    }

    private /* synthetic */ void gotoPos(class_2338 class_23382) {
        SelfFill a = class_23382;
        SelfFill a2 = this;
        if (a2.rotate.getValue() == RotateMode.None) {
            if (SelfFill.mc.field_1724 != null) {
                SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829((double)a.method_10263() + 0.5, SelfFill.mc.field_1724.method_23318() + 0.2, (double)a.method_10260() + 0.5, false));
                return;
            }
        } else if (SelfFill.mc.field_1724 != null) {
            SelfFill.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2830((double)a.method_10263() + 0.5, SelfFill.mc.field_1724.method_23318() + 0.2, (double)a.method_10260() + 0.5, Hana.ROTATE.rotateYaw, 90.0f, false));
        }
    }

    public static class_2338 getFlooredPosition(class_1297 a) {
        return new class_2338((int)Math.floor(a.method_23317()), (int)Math.round(a.method_23318()), (int)Math.floor(a.method_23321()));
    }

    public double auto() {
        SelfFill a;
        SelfFill selfFill = a;
        if (SelfFill.mc.field_1724 != null && SelfFill.solid(selfFill.playerPos((class_1657)SelfFill.mc.field_1724).method_35830(3))) {
            return 1.2;
        }
        int n = a = 4;
        while (n < 6) {
            if (SelfFill.solid(selfFill.playerPos((class_1657)SelfFill.mc.field_1724).method_35830(a))) {
                return 2.2 + (double)a - 4.0;
            }
            n = ++a;
        }
        return 8.0;
    }

    boolean isSelfBurrowClipPos(class_2338 class_23382) {
        SelfFill a = class_23382;
        SelfFill a2 = this;
        if (SelfFill.mc.field_1687 != null) {
            return !SelfFill.mc.field_1687.method_8320((class_2338)a).method_51367() && !SelfFill.mc.field_1687.method_8320(a.method_10069(0, 1, 0)).method_51367();
        }
        return false;
    }

    private /* synthetic */ boolean Trapped(class_2338 class_23382) {
        SelfFill a = class_23382;
        SelfFill a2 = this;
        if (SelfFill.mc.field_1687 != null) {
            return SelfFill.mc.field_1687.method_39454((class_1297)SelfFill.mc.field_1724, new class_238((class_2338)a)) && a2.checkSelf(a.method_10087(2));
        }
        return false;
    }

    private /* synthetic */ int getBlock() {
        SelfFill a;
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

    public static class_2338 getPlayerPosFloored(class_1297 a, double a2) {
        return new class_2338((int)Math.floor(a.method_23317()), (int)Math.floor(a.method_23318() + a2), (int)Math.floor(a.method_23321()));
    }

    /*
     * Exception decompiling
     */
    public void LagMode() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [14[DOLOOP]], but top level block is 6[CASE]
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
        SelfFill a2;
        SelfFill selfFill = a2;
        if (SelfFill.mc.field_1687 == null) return false;
        a = SelfFill.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do {
            Object object = a;
            while (object.hasNext()) {
                a2 = (class_1297)a.next();
                if (a2 == SelfFill.mc.field_1724) {
                    object = a;
                    continue;
                }
                if (!a2.method_5805() || a2 instanceof class_1542 || a2 instanceof class_1303 || a2 instanceof class_1683 || a2 instanceof class_1667 || a2 instanceof class_1511 && selfFill.breakCrystal.getValue()) continue block0;
                if (!(a2 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return true;
                object = a;
            }
            break;
        } while (true);
        return false;
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page RotateBypass;
        public static final /* enum */ Page Move;
        public static final /* enum */ Page FakeJump;
        public static final /* enum */ Page Packet;
        public static final /* enum */ Page Place;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Misc;

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[6];
            arrpage[0] = Packet;
            arrpage[1] = Place;
            arrpage[2] = Misc;
            arrpage[3] = RotateBypass;
            arrpage[4] = Move;
            arrpage[5] = FakeJump;
            return arrpage;
        }

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

        static {
            Packet = new Page(TipUtils.ALLATORIxDEMO("\u0011\u000f?\u0018sM"), 0);
            Place = new Page(Packet.ALLATORIxDEMO("lq[|]"), 1);
            Misc = new Page(TipUtils.ALLATORIxDEMO("\u0011\u001aeZ"), 2);
            RotateBypass = new Page(Packet.ALLATORIxDEMO("D^*\u0018^hYEm[lK"), 3);
            Move = new Page(TipUtils.ALLATORIxDEMO("\u0011\u001c`\\"), 4);
            FakeJump = new Page(Packet.ALLATORIxDEMO("llpYWOrH"), 5);
            $VALUES = Page.$values();
        }
    }

    private static final class RotateMode
    extends Enum<RotateMode> {
        public static final /* enum */ RotateMode Bypass = new RotateMode(Packet.ALLATORIxDEMO("WKnXlK"), 0);
        private static final /* synthetic */ RotateMode[] $VALUES;
        public static final /* enum */ RotateMode None;
        public static final /* enum */ RotateMode Normal;

        public static RotateMode[] values() {
            return (RotateMode[])$VALUES.clone();
        }

        static {
            Normal = new RotateMode(RadiusUtils.ALLATORIxDEMO("z\u000f[\u0010\u0002["), 1);
            None = new RotateMode(Packet.ALLATORIxDEMO("PVq]"), 2);
            $VALUES = RotateMode.$values();
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

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Nu;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Smart;
        public static final /* enum */ Mode Xin;
        public static final /* enum */ Mode Scanner;
        public static final /* enum */ Mode ToVoid;
        public static final /* enum */ Mode Auto;
        public static final /* enum */ Mode Au;
        public static final /* enum */ Mode Invalid;

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[8];
            arrmode[0] = Xin;
            arrmode[1] = Auto;
            arrmode[2] = Scanner;
            arrmode[3] = Nu;
            arrmode[4] = Au;
            arrmode[5] = Invalid;
            arrmode[6] = Smart;
            arrmode[7] = ToVoid;
            return arrmode;
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        static {
            Xin = new Mode(Snow.ALLATORIxDEMO("\tm>"), 0);
            Auto = new Mode(FrameFilter.ALLATORIxDEMO("\u0007b3y"), 1);
            Scanner = new Mode(Snow.ALLATORIxDEMO("+m;k?a\""), 2);
            Nu = new Mode(FrameFilter.ALLATORIxDEMO("\tc"), 3);
            Au = new Mode(Snow.ALLATORIxDEMO("E%"), 4);
            Invalid = new Mode(FrameFilter.ALLATORIxDEMO("w#j'{.r"), 5);
            Smart = new Mode(Snow.ALLATORIxDEMO("\th0v$"), 6);
            ToVoid = new Mode(FrameFilter.ALLATORIxDEMO("\u0019s\u0010x.r"), 7);
            $VALUES = Mode.$values();
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Mode() {
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
    }

    private static final class FakeJumpMode
    extends Enum<FakeJumpMode> {
        public static final /* enum */ FakeJumpMode M7;
        public static final /* enum */ FakeJumpMode Normal;
        private static final /* synthetic */ FakeJumpMode[] $VALUES;
        public static final /* enum */ FakeJumpMode NullPoint;

        public static FakeJumpMode[] values() {
            return (FakeJumpMode[])$VALUES.clone();
        }

        public static FakeJumpMode valueOf(String a) {
            return Enum.valueOf(FakeJumpMode.class, a);
        }

        private static /* synthetic */ FakeJumpMode[] $values() {
            FakeJumpMode[] arrfakeJumpMode = new FakeJumpMode[3];
            arrfakeJumpMode[0] = NullPoint;
            arrfakeJumpMode[1] = M7;
            arrfakeJumpMode[2] = Normal;
            return arrfakeJumpMode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ FakeJumpMode() {
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

        static {
            NullPoint = new FakeJumpMode(UserInfo.ALLATORIxDEMO("\u0019:\u0006\u0001\u0018\t*\t6"), 0);
            M7 = new FakeJumpMode(SnowAnimation.ALLATORIxDEMO("tP"), 1);
            Normal = new FakeJumpMode(UserInfo.ALLATORIxDEMO("#'\u0014.\u0006."), 2);
            $VALUES = FakeJumpMode.$values();
        }
    }

}
