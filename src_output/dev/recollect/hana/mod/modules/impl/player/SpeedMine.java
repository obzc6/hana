/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1661
 *  net.minecraft.class_1739
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2828
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_490
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.ClickBlockEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IPlayerMoveC2SPacket;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1739;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2828;
import net.minecraft.class_2846;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_490;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class SpeedMine
extends Module {
    public final ColorSetting color;
    public final BooleanSetting preferWeb;
    private final EnumSetting<FadeUtils.Quad> quad;
    private final BooleanSetting wait;
    private final BooleanSetting outline;
    public final BooleanSetting preferHead;
    private final SliderSetting maxBreak;
    private final FadeUtils animationTime;
    public static SpeedMine INSTANCE;
    private final Timer placeTimer;
    private final BooleanSetting endSwing;
    public final BindSetting obsidian;
    private final SliderSetting crystalDamage;
    private final SliderSetting placeDelay;
    private final BooleanSetting spamPlace;
    private final BooleanSetting text;
    private final SliderSetting time;
    private final BooleanSetting onlyHeadBomber;
    private final Timer delayTimer;
    public final SliderSetting range;
    public final ColorSetting endboxColor;
    public static double progress;
    private final BooleanSetting onlyGround;
    private final BooleanSetting box;
    static DecimalFormat df;
    private final Timer mineTimer;
    private final BooleanSetting instant;
    public final BooleanSetting farCancel;
    private final SliderSetting damage;
    private final BooleanSetting waitPlace;
    private final BooleanSetting afterBreak;
    private final BooleanSetting bold;
    public static class_2338 breakPos;
    private final BooleanSetting text2;
    private final BooleanSetting doubleBreak;
    private final BooleanSetting cancelPacket;
    private final FadeUtils secondAnim;
    private final BindSetting enderChest;
    private final BooleanSetting usingPause;
    private final SliderSetting lineWidth;
    private final BooleanSetting checkDamage;
    int lastSlot;
    public static double secondProgress;
    public static boolean sendGroundPacket;
    private final BooleanSetting switchReset;
    public final Timer secondTimer;
    private int breakNumber;
    public final BooleanSetting ghostHand;
    private final SliderSetting bypassTime;
    private final BooleanSetting autoColor;
    private boolean startMine;
    public final BooleanSetting hotBar;
    public final ColorSetting endColor;
    private final SliderSetting delay;
    private final BooleanSetting bypassGround;
    public final ColorSetting doubleColor;
    public static final List<class_2248> godBlocks;
    private final BooleanSetting rotate;
    private final BooleanSetting mineAir;
    private final BooleanSetting swing;
    private final BooleanSetting checkGround;
    public static class_2338 secondPos;
    public final BooleanSetting crystal;

    /*
     * WARNING - void declaration
     */
    public final double getBreakTime(class_2338 class_23382, int n, double d) {
        void a;
        void a2;
        int a3 = n;
        SpeedMine a4 = this;
        return (double)(1.0f / a4.getBlockStrength((class_2338)a, SpeedMine.mc.field_1724.method_31548().method_5438(a3)) / 20.0f * 1000.0f) * a2;
    }

    private static /* synthetic */ void faceVector(class_243 a, RotateEvent a2) {
        float[] arrf = a;
        a = EntityUtil.getLegitRotations((class_243)arrf);
        a2.setRotation(a[0], a[1]);
    }

    public void mine(class_2338 class_23382) {
        SpeedMine a = class_23382;
        SpeedMine a2 = this;
        if (SpeedMine.nullCheck() || SpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        if (a2.isOff()) {
            return;
        }
        if (godBlocks.contains((Object)SpeedMine.mc.field_1687.method_8320((class_2338)a).method_26204())) {
            return;
        }
        if (a.equals((Object)breakPos)) {
            return;
        }
        if (breakPos != null && a2.preferWeb.getValue() && BlockUtil.getBlock(breakPos) == class_2246.field_10343) {
            return;
        }
        if (breakPos != null && a2.preferHead.getValue() && EntityUtil.getPlayerPos(true).method_10084().equals((Object)breakPos)) {
            return;
        }
        breakPos = a;
        a2.mineTimer.reset();
        a2.animationTime.reset();
        a2.startMine();
    }

    /*
     * WARNING - void declaration
     */
    public final double getBreakTime(class_2338 class_23382, int n) {
        void a;
        SpeedMine a2;
        int a3 = n;
        SpeedMine speedMine = a2 = this;
        return speedMine.getBreakTime((class_2338)a, a3, speedMine.damage.getValue());
    }

    /*
     * Exception decompiling
     */
    public float getDigSpeed(class_2680 var1_2, class_1799 var2_3) {
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

    public SpeedMine() {
        SpeedMine a;
        SpeedMine speedMine = a;
        super(ProjectionUtils.ALLATORIxDEMO("p\u0007j$H\u001fg\u0005O\u0002"), Module.Category.Player);
        SpeedMine speedMine2 = a;
        speedMine2.delay = speedMine.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("Q\u0010~\u001f`"), 50.0, 0.0, 500.0, 1.0));
        speedMine.damage = speedMine.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("i\nG\rF\u0002"), 0.699999988079071, 0.0, 2.0, 0.01));
        speedMine.range = speedMine.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("G\u0014|\u0019|"), 6.0, 3.0, 10.0, 0.1));
        speedMine.maxBreak = speedMine.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("D.U)X\t@\f"), 3.0, 0.0, 20.0, 1.0));
        speedMine.preferWeb = speedMine.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("H$T\u0014p\u0007E\u001b{"), true));
        speedMine.preferHead = speedMine.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("p\u0014l)H\u0019b\t@\u0003"), true));
        speedMine.instant = speedMine.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("x\u001cf\u0001s\u0010m"), false));
        speedMine.cancelPacket = speedMine.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("b\u0006N\u0005l#}\nI\u0007D\u0013"), false));
        speedMine.wait = speedMine.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\"s\u0017m"), true, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return !a2.instant.getValue();
        }));
        a.mineAir = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\u0002D\u0005O-H\u0015"), true, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.wait.getValue();
        }));
        SpeedMine speedMine3 = a;
        speedMine3.farCancel = speedMine3.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("^7C1t\u001bq\u001bu"), false));
        speedMine3.hotBar = speedMine3.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("h\t}-L\u0019y\u001b@\u0017"), false));
        speedMine3.ghostHand = speedMine3.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("_>^\u0001a=s\u0010}"), true));
        speedMine3.checkGround = speedMine3.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("$H\u0003j$j\u0019E\u0019O\u0003"), true));
        speedMine3.onlyGround = speedMine3.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("0v:H5g\u001ag\u0010}"), true));
        speedMine3.doubleBreak = speedMine3.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("#O\u0013k#H)X\t@\f"), true));
        speedMine3.usingPause = speedMine3.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("*k?_\u0015E\u0014g\r|"), false));
        speedMine3.swing = speedMine3.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("8]\u0005O\u0000"), true));
        speedMine3.endSwing = speedMine3.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\u0013_\u0016F\u0002{\u0010~"), false));
        speedMine3.bypassGround = speedMine3.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("c\u001eP\u0007z<j\u0019E\u0019O\u0003"), true));
        speedMine3.bypassTime = speedMine3.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("=a&P\u0001f!{\u0013|"), 400, 0, 2000, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.bypassGround.getValue();
        }));
        SpeedMine speedMine4 = a;
        speedMine4.rotate = speedMine4.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\u0004^\rU\u0002"), true));
        speedMine4.time = speedMine4.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("!{\u0013|"), 100, 0, 2000, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.rotate.getValue();
        }));
        SpeedMine speedMine5 = a;
        speedMine5.switchReset = speedMine5.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("4W\u000f},E9O\u001fD\u0013"), false));
        speedMine5.crystal = speedMine5.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("r\u0000l\u0006f\u001fu"), false).setParent());
        speedMine5.onlyHeadBomber = speedMine5.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("n\tM\u001eh\u0003h+o\u0004G\u000eD\u0015"), false, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.waitPlace = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("O7X\u0006E\u0019s\u001d|"), false, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.spamPlace = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("5y.@;F\rB\u0002"), false, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.afterBreak = a.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO(">~\"T\u0000W\u0007w\u001fr"), true, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.checkDamage = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("e\u0002U\u0002C\u0012Y=B\fX\tR\u0014"), true, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.crystal.isOpen();
        }));
        a.crystalDamage = a.add(new SliderSetting(PacketBuffer.ALLATORIxDEMO("\u0006C\u001dr\u0007w\rj"), 0.699999988079071, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.crystal.isOpen() && a2.checkDamage.getValue();
        }));
        SpeedMine speedMine6 = a;
        speedMine6.obsidian = speedMine6.add(new BindSetting(ProjectionUtils.ALLATORIxDEMO("F-^\u0002N\u0005@\t"), -1));
        speedMine6.enderChest = speedMine6.add(new BindSetting(PacketBuffer.ALLATORIxDEMO(":v2T\u0000V\u001dw\rm"), -1));
        speedMine6.placeDelay = speedMine6.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("p\nh,H/O\u0000@\u001e"), 100, 0, 1000));
        speedMine6.quad = speedMine6.add(new EnumSetting<FadeUtils.Quad>(PacketBuffer.ALLATORIxDEMO("$g\u001f}"), FadeUtils.Quad.In));
        speedMine6.autoColor = speedMine6.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("'|;B(E\u0000N\u0015"), true));
        speedMine6.color = speedMine6.add(new ColorSetting(PacketBuffer.ALLATORIxDEMO("V\u001a~\u0011k"), new Color(255, 255, 255, 100)));
        speedMine6.endColor = speedMine6.add(new ColorSetting(ProjectionUtils.ALLATORIxDEMO("L!I(E\u0000N\u0015"), new Color(25, 255, 50, 100))).injectBoolean(false);
        speedMine6.endboxColor = speedMine6.add(new ColorSetting(PacketBuffer.ALLATORIxDEMO("\\\u0011|\u0014^\nV\u001a~\u0011k"), new Color(25, 255, 50, 100), object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.endColor.booleanValue;
        }));
        a.doubleColor = a.add(new ColorSetting(ProjectionUtils.ALLATORIxDEMO("#O\u0013k#H(E\u0000N\u0015"), new Color(88, 94, 255, 100), object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.doubleBreak.getValue();
        }));
        SpeedMine speedMine7 = a;
        speedMine7.bold = speedMine7.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("7}\u0012}"), false)).setParent();
        speedMine7.lineWidth = speedMine7.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("*`!H<C\bU\u000f"), 4, 1, 5, object -> {
            Object a = object;
            SpeedMine a2 = this;
            return a2.bold.isOpen();
        }));
        SpeedMine speedMine8 = a;
        SpeedMine speedMine9 = a;
        SpeedMine speedMine10 = a;
        SpeedMine speedMine11 = a;
        SpeedMine speedMine12 = a;
        SpeedMine speedMine13 = a;
        speedMine13.text = speedMine13.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("!w\u0006m"), true));
        speedMine13.text2 = speedMine13.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("d\t|-A\u000e~\tY\u0013"), true));
        speedMine13.box = speedMine13.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("P\u0011a"), true));
        speedMine12.outline = speedMine13.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\u0000X\u001fF\u0005O\u0002"), true));
        speedMine11.lastSlot = -1;
        speedMine12.mineTimer = new Timer();
        speedMine11.animationTime = new FadeUtils(1000L);
        speedMine11.secondAnim = new FadeUtils(1000L);
        speedMine10.startMine = false;
        speedMine9.breakNumber = 0;
        speedMine10.secondTimer = new Timer();
        speedMine9.delayTimer = new Timer();
        speedMine8.placeTimer = new Timer();
        speedMine8.setChinese(PacketBuffer.ALLATORIxDEMO("\u53a4\u5317\u6368\u6381"));
        INSTANCE = speedMine8;
    }

    @Override
    public String getInfo() {
        SpeedMine a;
        if (a.instant.getValue()) {
            return ProjectionUtils.ALLATORIxDEMO("\u0006C\u0018^\rO\u0013");
        }
        return PacketBuffer.ALLATORIxDEMO("p\u0010z\u0007f\u001b}");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void update() {
        block57 : {
            var2_6 = a;
            if (SpeedMine.nullCheck()) {
                return;
            }
            if (SpeedMine.mc.field_1724.method_29504()) {
                SpeedMine.secondPos = null;
            }
            if (SpeedMine.secondPos != null && var2_6.secondTimer.passed(var2_6.getBreakTime(SpeedMine.secondPos, SpeedMine.mc.field_1724.method_31548().field_7545, 1.3))) {
                SpeedMine.secondPos = null;
            }
            if (SpeedMine.secondPos != null && var2_6.isAir(SpeedMine.secondPos)) {
                SpeedMine.secondPos = null;
            }
            if (SpeedMine.mc.field_1724.method_7337()) {
                v0 = var2_6;
                v0.startMine = false;
                v0.breakNumber = 0;
                SpeedMine.breakPos = null;
                return;
            }
            if (SpeedMine.breakPos == null) {
                v1 = var2_6;
                v1.breakNumber = 0;
                v1.startMine = false;
                return;
            }
            if (var2_6.isAir(SpeedMine.breakPos)) {
                var2_6.breakNumber = 0;
            }
            if ((double)var2_6.breakNumber > var2_6.maxBreak.getValue() - 1.0 && var2_6.maxBreak.getValue() > 0.0 || !var2_6.wait.getValue() && var2_6.isAir(SpeedMine.breakPos) && !var2_6.instant.getValue()) {
                if (SpeedMine.breakPos.equals((Object)SpeedMine.secondPos)) {
                    SpeedMine.secondPos = null;
                }
                var2_6.startMine = false;
                var2_6.breakNumber = false ? 1 : 0;
                SpeedMine.breakPos = null;
                return;
            }
            if (SpeedMine.godBlocks.contains((Object)SpeedMine.mc.field_1687.method_8320(SpeedMine.breakPos).method_26204())) {
                SpeedMine.breakPos = null;
                var2_6.startMine = false;
                return;
            }
            if (var2_6.usingPause.getValue() && EntityUtil.isUsing()) {
                return;
            }
            if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(SpeedMine.breakPos.method_46558()))) > var2_6.range.getValue()) {
                if (var2_6.farCancel.getValue() == false) return;
                v2 = var2_6;
                v2.startMine = false;
                v2.breakNumber = 0;
                SpeedMine.breakPos = null;
                return;
            }
            if (SpeedMine.breakPos.equals((Object)AnchorAura.INSTANCE.currentPos)) {
                return;
            }
            if (!(var2_6.hotBar.getValue() || SpeedMine.mc.field_1755 == null || SpeedMine.mc.field_1755 instanceof class_408 || SpeedMine.mc.field_1755 instanceof class_490 || SpeedMine.mc.field_1755 instanceof ClickGuiScreen)) {
                return;
            }
            var1_7 = var2_6.getTool(SpeedMine.breakPos);
            if (var1_7 == -1) {
                var1_7 = SpeedMine.mc.field_1724.method_31548().field_7545;
            }
            if (var2_6.isAir(SpeedMine.breakPos)) {
                if (var2_6.shouldCrystal()) {
                    a = class_2350.values();
                    var3_8 = a.length;
                    v3 = var4_10 = 0;
                    while (v3 < var3_8) {
                        var5_15 = a[var4_10];
                        CombatUtil.attackCrystal(SpeedMine.breakPos.method_10093(var5_15), var2_6.rotate.getValue(), true);
                        v3 = ++var4_10;
                    }
                }
                v4 = var2_6;
                if (v4.placeTimer.passedMs(v4.placeDelay.getValue()) && BlockUtil.canPlace(SpeedMine.breakPos) && SpeedMine.mc.field_1755 == null) {
                    if (var2_6.enderChest.isPressed()) {
                        a = var2_6.findBlock(class_2246.field_10443);
                        if (a != -1) {
                            var3_8 = SpeedMine.mc.field_1724.method_31548().field_7545;
                            v5 = var2_6;
                            v6 = a;
                            v5.doSwap(v6, v6);
                            BlockUtil.placeBlock(SpeedMine.breakPos, var2_6.rotate.getValue(), true);
                            v5.doSwap(var3_8, a);
                            v5.placeTimer.reset();
                        }
                    } else if (var2_6.obsidian.isPressed() && (a = var2_6.findBlock(class_2246.field_10540)) != -1) {
                        var3_8 = 0;
                        if (var2_6.shouldCrystal()) {
                            for (class_2350 var5_15 : SpeedMine.mc.field_1687.method_18467(class_1297.class, new class_238(SpeedMine.breakPos.method_10084()))) {
                                if (!(var5_15 instanceof class_1511)) continue;
                                v7 = var3_8 = 1;
                                break;
                            }
                        } else {
                            v7 = var3_8;
                        }
                        if (v7 == 0 || var2_6.spamPlace.getValue()) {
                            var4_12 = SpeedMine.mc.field_1724.method_31548().field_7545;
                            v8 = var2_6;
                            v9 = a;
                            v8.doSwap(v9, v9);
                            BlockUtil.placeBlock(SpeedMine.breakPos, var2_6.rotate.getValue(), true);
                            v8.doSwap(var4_12, a);
                            v8.placeTimer.reset();
                        }
                    }
                }
                v10 = var2_6;
                var2_6.breakNumber = 0;
            } else {
                if (SpeedMine.canPlaceCrystal(SpeedMine.breakPos.method_10084(), true)) {
                    if (var2_6.waitPlace.getValue()) {
                        a = class_2350.values();
                        var3_8 = a.length;
                        v11 = var4_13 = 0;
                        while (v11 < var3_8) {
                            var5_15 = a[var4_13];
                            if (SpeedMine.breakPos.method_10093(var5_15).equals((Object)HanaAura.crystalPos)) {
                                if (!HanaAura.INSTANCE.canPlaceCrystal(HanaAura.crystalPos, false, false)) break;
                                return;
                            }
                            v11 = ++var4_13;
                        }
                    }
                    if (var2_6.shouldCrystal()) {
                        v12 = var2_6;
                        if (v12.placeTimer.passedMs(v12.placeDelay.getValue())) {
                            if (var2_6.checkDamage.getValue()) {
                                if ((double)var2_6.mineTimer.getPassedTimeMs() / var2_6.getBreakTime(SpeedMine.breakPos, var1_7) >= var2_6.crystalDamage.getValue() && (a = var2_6.findCrystal()) != -1) {
                                    var3_8 = SpeedMine.mc.field_1724.method_31548().field_7545;
                                    v13 = var2_6;
                                    v14 = var2_6;
                                    v15 = a;
                                    v14.doSwap(v15, v15);
                                    BlockUtil.placeCrystal(SpeedMine.breakPos.method_10084(), var2_6.rotate.getValue());
                                    v13.doSwap(var3_8, a);
                                    v14.placeTimer.reset();
                                    if (v13.waitPlace.getValue()) {
                                        return;
                                    }
                                }
                            } else {
                                a = var2_6.findCrystal();
                                if (a != -1) {
                                    var3_8 = SpeedMine.mc.field_1724.method_31548().field_7545;
                                    v16 = var2_6;
                                    v17 = var2_6;
                                    v18 = a;
                                    v17.doSwap(v18, v18);
                                    BlockUtil.placeCrystal(SpeedMine.breakPos.method_10084(), var2_6.rotate.getValue());
                                    v16.doSwap(var3_8, a);
                                    v17.placeTimer.reset();
                                    if (v16.waitPlace.getValue()) {
                                        return;
                                    }
                                }
                            }
                        } else if (var2_6.startMine) {
                            return;
                        }
                    }
                }
                v10 = var2_6;
            }
            if (!v10.delayTimer.passedMs((long)var2_6.delay.getValue())) {
                return;
            }
            if (!var2_6.startMine) break block57;
            if (var2_6.isAir(SpeedMine.breakPos)) {
                return;
            }
            if (var2_6.onlyGround.getValue() && !SpeedMine.mc.field_1724.method_24828()) {
                return;
            }
            if (var2_6.mineTimer.passedMs((long)var2_6.getBreakTime(SpeedMine.breakPos, var1_7)) == false) return;
            a = SpeedMine.mc.field_1724.method_31548().field_7545;
            if (var2_6.hotBar.getValue()) {
                v19 = var3_8 = var1_7 != a ? 1 : 0;
            } else {
                if (var1_7 < 9) {
                    var1_7 += 36;
                }
                v19 = var3_8 = a + 36 != var1_7 ? 1 : 0;
            }
            if (v19 == 0) ** GOTO lbl162
            v20 = var1_7;
            if (var2_6.hotBar.getValue()) {
                InventoryUtil.switchToSlot(v20);
                v21 = var2_6;
            } else {
                InventoryUtil.inventorySwap(v20, SpeedMine.mc.field_1724.method_31548().field_7545);
lbl162: // 2 sources:
                v21 = var2_6;
            }
            if (v21.rotate.getValue()) {
                EntityUtil.facePosSide(SpeedMine.breakPos, BlockUtil.getClickSide(SpeedMine.breakPos));
            }
            if (var2_6.endSwing.getValue()) {
                EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
            }
            SpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, SpeedMine.breakPos, BlockUtil.getClickSide(SpeedMine.breakPos)));
            if (var3_8 == 0 || !var2_6.ghostHand.getValue()) ** GOTO lbl175
            if (var2_6.hotBar.getValue()) {
                InventoryUtil.switchToSlot(a);
                v22 = var2_6;
            } else {
                InventoryUtil.inventorySwap(var1_7, SpeedMine.mc.field_1724.method_31548().field_7545);
                EntityUtil.syncInventory();
lbl175: // 2 sources:
                v22 = var2_6;
            }
            ++v22.breakNumber;
            v23 = var2_6;
            v23.delayTimer.reset();
            if (v23.afterBreak.getValue() == false) return;
            if (var2_6.shouldCrystal() == false) return;
            var4_14 = class_2350.values();
            var5_16 = var4_14.length;
            v24 = a = 0;
            while (v24 < var5_16) {
                var3_9 = var4_14[a];
                CombatUtil.attackCrystal(SpeedMine.breakPos.method_10093(var3_9), var2_6.rotate.getValue(), true);
                v24 = ++a;
            }
            return;
        }
        if (!var2_6.mineAir.getValue() && var2_6.isAir(SpeedMine.breakPos)) {
            return;
        }
        v25 = var2_6;
        v26 = var2_6;
        v25.animationTime.setLength((long)v26.getBreakTime(SpeedMine.breakPos, var1_7));
        v26.mineTimer.reset();
        if (v25.swing.getValue()) {
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
        SpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, SpeedMine.breakPos, BlockUtil.getClickSide(SpeedMine.breakPos)));
        var2_6.delayTimer.reset();
    }

    public static boolean canPlaceCrystal(class_2338 a, boolean a2) {
        class_2338 class_23382 = a;
        class_2338 class_23383 = class_23382.method_10074();
        a = class_23383.method_10084();
        return !(BlockUtil.getBlock(class_23383) != class_2246.field_9987 && BlockUtil.getBlock(class_23383) != class_2246.field_10540 || BlockUtil.getClickSideStrict(class_23383) == null || !SpeedMine.noEntity(a, a2) || !SpeedMine.noEntity(a.method_10084(), a2) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a.method_10084()) != class_2246.field_10124);
    }

    /*
     * WARNING - void declaration
     */
    public static void facePosFacing(class_2338 class_23382, class_2350 class_23502, RotateEvent rotateEvent) {
        void a;
        class_2338 a2 = class_23502;
        class_2338 a3 = class_23382;
        SpeedMine.faceVector(a3.method_46558().method_1019(new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5)), (RotateEvent)a);
    }

    /*
     * WARNING - void declaration
     */
    public int getTool(class_2338 class_23382) {
        void a;
        SpeedMine speedMine = this;
        if (speedMine.hotBar.getValue()) {
            int a2;
            int n = -1;
            float f = 1.0f;
            int n2 = a2 = 0;
            while (n2 < 9) {
                float f2;
                float f3;
                class_1799 class_17992 = SpeedMine.mc.field_1724.method_31548().method_5438(a2);
                if (class_17992 != class_1799.field_8037 && (f2 = (float)class_1890.method_8225((class_1887)class_1893.field_9131, (class_1799)class_17992)) + (f3 = class_17992.method_7924(SpeedMine.mc.field_1687.method_8320((class_2338)a))) > f) {
                    f = f2 + f3;
                    n = a2;
                }
                n2 = ++a2;
            }
            return n;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        float f = 1.0f;
        for (Map.Entry entry : InventoryUtil.getInventoryAndHotbarSlots().entrySet()) {
            float f4;
            float f5;
            if (((class_1799)entry.getValue()).method_7909() instanceof class_1739 || !((f5 = (float)class_1890.method_8225((class_1887)class_1893.field_9131, (class_1799)((class_1799)entry.getValue()))) + (f4 = ((class_1799)entry.getValue()).method_7924(SpeedMine.mc.field_1687.method_8320((class_2338)a))) > f)) continue;
            f = f5 + f4;
            atomicInteger.set((Integer)entry.getKey());
        }
        return atomicInteger.get();
    }

    @Override
    public void onDisable() {
        a.startMine = false;
        breakPos = null;
    }

    private /* synthetic */ int findBlock(class_2248 class_22482) {
        SpeedMine a = class_22482;
        SpeedMine a2 = this;
        if (!a2.hotBar.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean noEntity(class_2338 a, boolean a2) {
        Object object = a;
        a = SpeedMine.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)object)).iterator();
        block0 : do {
            Object object2 = a;
            while (object2.hasNext()) {
                class_1297 class_12972 = (class_1297)a.next();
                if (class_12972 instanceof class_1542 && a2) continue block0;
                if (!(class_12972 instanceof class_1531) || !CombatSetting.INSTANCE.obsMode.getValue()) return false;
                object2 = a;
            }
            break;
        } while (true);
        return true;
    }

    private /* synthetic */ boolean isAir(class_2338 class_23382) {
        SpeedMine a = class_23382;
        SpeedMine a2 = this;
        return SpeedMine.mc.field_1687.method_22347((class_2338)a) || BlockUtil.getBlock((class_2338)a) == class_2246.field_10036 && BlockUtil.hasCrystal((class_2338)a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void doSwap(int n, int n2) {
        int a = n2;
        SpeedMine a2 = this;
        if (a2.hotBar.getValue()) {
            void a3;
            InventoryUtil.switchToSlot((int)a3);
            return;
        }
        InventoryUtil.inventorySwap(a, SpeedMine.mc.field_1724.method_31548().field_7545);
    }

    @Override
    public void onLogin() {
        a.startMine = false;
        breakPos = null;
        secondPos = null;
    }

    @EventHandler
    public void onAttackBlock(ClickBlockEvent clickBlockEvent) {
        ClickBlockEvent a = clickBlockEvent;
        SpeedMine a2 = this;
        if (SpeedMine.nullCheck() || SpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        a.cancel();
        if (godBlocks.contains((Object)SpeedMine.mc.field_1687.method_8320(a.getBlockPos()).method_26204())) {
            return;
        }
        if (a.getBlockPos().equals((Object)breakPos)) {
            return;
        }
        breakPos = a.getBlockPos();
        a2.mineTimer.reset();
        a2.animationTime.reset();
        if (godBlocks.contains((Object)SpeedMine.mc.field_1687.method_8320(a.getBlockPos()).method_26204())) {
            return;
        }
        if (breakPos != null && a2.preferHead.getValue() && EntityUtil.getPlayerPos(true).method_10084().equals((Object)breakPos)) {
            return;
        }
        a2.startMine();
    }

    /*
     * WARNING - void declaration
     */
    public float getBlockStrength(class_2338 class_23382, class_1799 class_17992) {
        void a;
        void a2;
        float f;
        SpeedMine speedMine = this;
        class_2680 class_26802 = SpeedMine.mc.field_1687.method_8320((class_2338)a);
        float a3 = class_26802.method_26214((class_1922)SpeedMine.mc.field_1687, (class_2338)a);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!speedMine.canBreak((class_2338)a)) {
            return speedMine.getDigSpeed(class_26802, (class_1799)a2) / a3 / 100.0f;
        }
        return speedMine.getDigSpeed(class_26802, (class_1799)a2) / a3 / 30.0f;
    }

    static {
        class_2248[] arrclass_2248 = new class_2248[10];
        arrclass_2248[0] = class_2246.field_10525;
        arrclass_2248[1] = class_2246.field_27098;
        arrclass_2248[2] = class_2246.field_10164;
        arrclass_2248[3] = class_2246.field_27097;
        arrclass_2248[4] = class_2246.field_10382;
        arrclass_2248[5] = class_2246.field_9987;
        arrclass_2248[6] = class_2246.field_10499;
        arrclass_2248[7] = class_2246.field_10027;
        arrclass_2248[8] = class_2246.field_10316;
        arrclass_2248[9] = class_2246.field_10398;
        godBlocks = Arrays.asList(arrclass_2248);
        progress = 0.0;
        secondProgress = 0.0;
        sendGroundPacket = false;
        df = new DecimalFormat(ProjectionUtils.ALLATORIxDEMO("\\\u000fW"));
    }

    private /* synthetic */ boolean shouldCrystal() {
        SpeedMine a;
        return a.crystal.getValue() && (!a.onlyHeadBomber.getValue() || a.obsidian.isPressed());
    }

    private /* synthetic */ int findCrystal() {
        SpeedMine a;
        if (!a.hotBar.getValue()) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return InventoryUtil.findItem(class_1802.field_8301);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a4 = f;
        SpeedMine a2 = this;
        a2.update();
        if (!SpeedMine.mc.field_1724.method_7337()) {
            double d;
            void a3;
            double d2;
            if (secondPos != null) {
                SpeedMine speedMine;
                int a4 = a2.getTool(secondPos);
                if (a4 == -1) {
                    a4 = SpeedMine.mc.field_1724.method_31548().field_7545;
                }
                SpeedMine speedMine2 = a2;
                d = speedMine2.getBreakTime(secondPos, a4);
                secondProgress = (double)speedMine2.secondTimer.getPassedTimeMs() / d;
                if (speedMine2.isAir(secondPos)) {
                    secondPos = null;
                    return;
                }
                d2 = secondProgress > 1.0 ? 1.0 : secondProgress;
                SpeedMine speedMine3 = a2;
                double d3 = (1.0 - speedMine3.secondAnim.getQuad(speedMine3.quad.getValue())) * 0.5;
                if (!a2.bold.getValue()) {
                    double d4 = d3;
                    SpeedMine speedMine4 = a2;
                    speedMine = speedMine4;
                    Render3DUtil.draw3DBox((class_4587)a3, new class_238(secondPos).method_1002(d4, d4, d4).method_1002(-d3, -d3, -d3), ColorUtil.injectAlpha(speedMine4.doubleColor.getValue(), (int)((double)a2.doubleColor.getValue().getAlpha() * d2)), a2.outline.getValue(), a2.box.getValue());
                } else {
                    double d5 = d3;
                    Render3DUtil.drawLine(new class_238(secondPos).method_1002(d5, d5, d5).method_1002(-d3, -d3, -d3), ColorUtil.injectAlpha(a2.doubleColor.getValue(), (int)((double)a2.doubleColor.getValue().getAlpha() * d2)), a2.lineWidth.getValueInt());
                    double d6 = d3;
                    SpeedMine speedMine5 = a2;
                    speedMine = speedMine5;
                    Render3DUtil.drawFill((class_4587)a3, new class_238(secondPos).method_1002(d6, d6, d6).method_1002(-d3, -d3, -d3), ColorUtil.injectAlpha(speedMine5.doubleColor.getValue(), (int)((double)a2.doubleColor.getValue().getAlpha() * d2)));
                }
                if (speedMine.text2.getValue()) {
                    if (a2.isAir(secondPos)) {
                        Render3DUtil.drawText3D(ProjectionUtils.ALLATORIxDEMO("\u0018L\u0002^\u0005O\u0000"), secondPos.method_46558(), -1);
                    } else if ((double)((int)a2.secondTimer.getPassedTimeMs()) < d) {
                        Render3DUtil.drawText3D("Double:" + df.format(d2 * 100.0) + "%", secondPos.method_46558(), -1);
                    } else {
                        Render3DUtil.drawText3D(PacketBuffer.ALLATORIxDEMO("C%E<N<"), secondPos.method_46558(), -1);
                    }
                }
            } else {
                secondProgress = 0.0;
            }
            if (breakPos != null) {
                SpeedMine speedMine;
                double d7;
                int n = a2.getTool(breakPos);
                Object a4 = n;
                if (n == -1) {
                    a4 = SpeedMine.mc.field_1724.method_31548().field_7545;
                }
                SpeedMine speedMine6 = a2;
                d = speedMine6.getBreakTime(breakPos, (int)a4);
                progress = (double)speedMine6.mineTimer.getPassedTimeMs() / d;
                speedMine6.animationTime.setLength((long)a2.getBreakTime(breakPos, (int)a4));
                SpeedMine speedMine7 = a2;
                d2 = (1.0 - speedMine7.animationTime.getQuad(speedMine7.quad.getValue())) * 0.5;
                Color color = a2.color.getValue();
                double d8 = d7 = progress > 1.0 ? 1.0 : progress;
                if (!a2.bold.getValue()) {
                    SpeedMine speedMine8;
                    Color color2;
                    double d9 = d2;
                    if (a2.autoColor.getValue()) {
                        color2 = new Color((int)(255.0 * d7), (int)(255.0 * d7), 0);
                        speedMine8 = a2;
                    } else if (!a2.endColor.booleanValue) {
                        color2 = color;
                        speedMine8 = a2;
                    } else if (d7 >= 1.0) {
                        color2 = a2.endColor.getValue();
                        speedMine8 = a2;
                    } else {
                        color2 = color;
                        speedMine8 = a2;
                    }
                    Render3DUtil.draw3DBox((class_4587)a3, new class_238(breakPos).method_1002(d9, d9, d9).method_1002(-d2, -d2, -d2), ColorUtil.injectAlpha(color2, (int)(!speedMine8.endColor.booleanValue ? (double)color.getAlpha() * d7 : (d7 >= 1.0 ? (double)a2.endColor.getValue().getAlpha() * d7 : (double)color.getAlpha() * d7))), a2.outline.getValue(), a2.box.getValue());
                    speedMine = a2;
                } else {
                    Color color3;
                    SpeedMine speedMine9;
                    Color color4;
                    SpeedMine speedMine10;
                    double d10 = d2;
                    if (a2.autoColor.getValue()) {
                        color3 = new Color((int)(255.0 * d7), (int)(255.0 * d7), 0);
                        speedMine9 = a2;
                    } else if (!a2.endColor.booleanValue) {
                        color3 = color;
                        speedMine9 = a2;
                    } else if (d7 >= 1.0) {
                        color3 = a2.endboxColor.getValue();
                        speedMine9 = a2;
                    } else {
                        color3 = color;
                        speedMine9 = a2;
                    }
                    Render3DUtil.drawLine(new class_238(breakPos).method_1002(d10, d10, d10).method_1002(-d2, -d2, -d2), ColorUtil.injectAlpha(color3, (int)(!speedMine9.endColor.booleanValue ? (double)color.getAlpha() * d7 : (d7 >= 1.0 ? (double)a2.endColor.getValue().getAlpha() * d7 : (double)color.getAlpha() * d7))), a2.lineWidth.getValueInt());
                    double d11 = d2;
                    if (a2.autoColor.getValue()) {
                        color4 = new Color((int)(255.0 * d7), (int)(255.0 * d7), 0);
                        speedMine10 = a2;
                    } else if (!a2.endColor.booleanValue) {
                        color4 = color;
                        speedMine10 = a2;
                    } else if (d7 >= 1.0) {
                        color4 = a2.endColor.getValue();
                        speedMine10 = a2;
                    } else {
                        color4 = color;
                        speedMine10 = a2;
                    }
                    Render3DUtil.drawFill((class_4587)a3, new class_238(breakPos).method_1002(d11, d11, d11).method_1002(-d2, -d2, -d2), ColorUtil.injectAlpha(color4, (int)(!speedMine10.endColor.booleanValue ? (double)color.getAlpha() * d7 : (d7 >= 1.0 ? (double)a2.endColor.getValue().getAlpha() * d7 : (double)color.getAlpha() * d7))));
                    speedMine = a2;
                }
                if (!speedMine.text.getValue()) return;
                if (a2.isAir(breakPos)) {
                    Render3DUtil.drawText3D(ProjectionUtils.ALLATORIxDEMO("\u0018L\u0002^\u0005O\u0000"), breakPos.method_46558(), -1);
                    return;
                }
                if ((double)((int)a2.mineTimer.getPassedTimeMs()) < d) {
                    Render3DUtil.drawText3D("Main:" + df.format(progress * 100.0) + "%", breakPos.method_46558(), -1);
                    return;
                }
                Render3DUtil.drawText3D(PacketBuffer.ALLATORIxDEMO("C%E<N<"), breakPos.method_46558(), -1);
                return;
            }
            progress = 0.0;
            return;
        }
        progress = 0.0;
        secondProgress = 0.0;
    }

    private /* synthetic */ void startMine() {
        SpeedMine a2;
        SpeedMine speedMine = a2;
        if (speedMine.rotate.getValue()) {
            a2 = BlockUtil.getClickSide(breakPos).method_10163();
            EntityUtil.faceVector(breakPos.method_46558().method_1019(new class_243((double)a2.method_10263() * 0.5, (double)a2.method_10264() * 0.5, (double)a2.method_10260() * 0.5)));
        }
        SpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, breakPos, BlockUtil.getClickSide(breakPos)));
        if (speedMine.doubleBreak.getValue()) {
            if (secondPos == null || speedMine.isAir(secondPos)) {
                int a2 = speedMine.getTool(breakPos);
                if (a2 == -1) {
                    a2 = SpeedMine.mc.field_1724.method_31548().field_7545;
                }
                SpeedMine speedMine2 = speedMine;
                double d = speedMine2.getBreakTime(breakPos, a2, 1.0);
                speedMine2.secondAnim.reset();
                SpeedMine speedMine3 = speedMine;
                speedMine3.secondAnim.setLength((long)d);
                speedMine3.secondTimer.reset();
                secondPos = breakPos;
            }
            SpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, breakPos, BlockUtil.getClickSide(breakPos)));
            SpeedMine.mc.field_1724.field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, breakPos, BlockUtil.getClickSide(breakPos)));
        }
        if (speedMine.swing.getValue()) {
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
        speedMine.breakNumber = 0;
    }

    public float getDestroySpeed(class_2680 a, class_1799 a2) {
        SpeedMine a222;
        SpeedMine speedMine = a222;
        float a222 = 1.0f;
        if (a2 != null && !a2.method_7960()) {
            a222 *= a2.method_7924(a);
        }
        return a222;
    }

    @EventHandler(priority=-100)
    public void onRotate(RotateEvent a) {
        SpeedMine a22;
        SpeedMine speedMine = a22;
        if (SpeedMine.nullCheck() || SpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        if (speedMine.onlyGround.getValue() && !SpeedMine.mc.field_1724.method_24828()) {
            return;
        }
        if (speedMine.rotate.getValue() && breakPos != null && !speedMine.isAir(breakPos) && speedMine.time.getValue() > 0.0) {
            double d;
            if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(breakPos.method_46558()))) > speedMine.range.getValue()) {
                return;
            }
            int a22 = speedMine.getTool(breakPos);
            if (a22 == -1) {
                a22 = SpeedMine.mc.field_1724.method_31548().field_7545;
            }
            if ((d = speedMine.getBreakTime(breakPos, a22) - speedMine.time.getValue()) <= 0.0 || speedMine.mineTimer.passedMs((long)d)) {
                SpeedMine.facePosFacing(breakPos, BlockUtil.getClickSide(breakPos), a);
            }
        }
    }

    @EventHandler(priority=-200)
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        SpeedMine a2 = this;
        if (SpeedMine.nullCheck() || SpeedMine.mc.field_1724.method_7337()) {
            return;
        }
        if (a.getPacket() instanceof class_2828) {
            if (a2.bypassGround.getValue() && breakPos != null && !a2.isAir(breakPos) && a2.bypassTime.getValue() > 0.0 && class_3532.method_15355((float)((float)breakPos.method_46558().method_1025(EntityUtil.getEyesPos()))) <= a2.range.getValueFloat() + 2.0f) {
                double d;
                int n = a2.getTool(breakPos);
                if (n == -1) {
                    n = SpeedMine.mc.field_1724.method_31548().field_7545;
                }
                if ((d = a2.getBreakTime(breakPos, n) - a2.bypassTime.getValue()) <= 0.0 || a2.mineTimer.passedMs((long)d)) {
                    sendGroundPacket = true;
                    ((IPlayerMoveC2SPacket)a.getPacket()).setOnGround(true);
                    return;
                }
            } else {
                sendGroundPacket = false;
            }
            return;
        }
        Object t = a.getPacket();
        if (t instanceof class_2868) {
            class_2868 class_28682 = (class_2868)t;
            if (class_28682.method_12442() != a2.lastSlot) {
                a2.lastSlot = class_28682.method_12442();
                if (a2.switchReset.getValue()) {
                    a2.startMine = false;
                    a2.mineTimer.reset();
                    a2.animationTime.reset();
                }
            }
            return;
        }
        if (!(a.getPacket() instanceof class_2846)) {
            return;
        }
        if (((class_2846)a.getPacket()).method_12363() == class_2846.class_2847.field_12968) {
            if (breakPos == null || !((class_2846)a.getPacket()).method_12362().equals((Object)breakPos)) {
                if (a2.cancelPacket.getValue()) {
                    a.cancel();
                }
                return;
            }
            a2.startMine = true;
            return;
        }
        if (((class_2846)a.getPacket()).method_12363() == class_2846.class_2847.field_12973) {
            if (breakPos == null || !((class_2846)a.getPacket()).method_12362().equals((Object)breakPos)) {
                if (a2.cancelPacket.getValue()) {
                    a.cancel();
                }
                return;
            }
            if (!a2.instant.getValue()) {
                a2.startMine = false;
            }
        }
    }

    @Override
    public void onUpdate() {
        SpeedMine a;
        a.update();
    }

    private /* synthetic */ boolean canBreak(class_2338 class_23382) {
        SpeedMine a = class_23382;
        SpeedMine a2 = this;
        return SpeedMine.mc.field_1687.method_8320((class_2338)a).method_26204().method_36555() != -1.0f;
    }
}
