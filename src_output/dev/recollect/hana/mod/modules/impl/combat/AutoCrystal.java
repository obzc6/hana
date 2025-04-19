/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2371
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2824
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.combat.BedAura;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2824;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;
import org.bytedeco.javacv.BufferRing;

public class AutoCrystal
extends Module {
    public float tempDamage;
    private final SliderSetting switchCooldown;
    private final BooleanSetting onBreak;
    private final SliderSetting lineWidth;
    final Timer noPosTimer;
    private final EnumSetting<SwingSide> swingMode;
    private final SliderSetting minDamage;
    private int lastHotbar;
    private final BooleanSetting checkLook;
    private final SliderSetting forceMaxHealth;
    private final BooleanSetting breakRemove;
    private final SliderSetting fov;
    private float lastYaw;
    public static AutoCrystal INSTANCE;
    private final BooleanSetting rotate;
    private final BooleanSetting packet;
    static class_243 placeVec3d;
    private final BooleanSetting lite;
    private final SliderSetting wallRange;
    private final EnumSetting<SwapMode> autoSwap;
    private final BooleanSetting useThread;
    private final BooleanSetting preferAnchor;
    private final ColorSetting color;
    public static class_2338 crystalPos;
    private float lastPitch;
    private final SliderSetting armorBreakerDamage;
    private final SliderSetting forceMin;
    public float lastDamage;
    final BooleanSetting render;
    private final BooleanSetting antiSurround;
    private final BooleanSetting Break;
    static class_243 curVec3d;
    private final BooleanSetting random;
    public static class_2338 tempPos;
    private final BooleanSetting armorBreaker;
    private final BooleanSetting terrainIgnore;
    private final SliderSetting updateDelay;
    private final SliderSetting range;
    private final EnumSetting<Aura.TargetESP> mode;
    private final Timer switchTimer;
    private final SliderSetting maxDurable;
    private final SliderSetting steps;
    final SliderSetting startFadeTime;
    private final SliderSetting breakDelay;
    final ColorSetting box;
    private final SliderSetting slowMinDamage;
    private final BooleanSetting slowPlace;
    public static Thread thread;
    private final SliderSetting targetRange;
    private final SliderSetting noSuicide;
    private final SliderSetting placeDelay;
    final ColorSetting text;
    public class_1657 displayTarget;
    private final EnumSetting<AnchorAura.CalcMode> calcMode;
    private final BooleanSetting bold;
    private final BooleanSetting doCrystal;
    private final SliderSetting hurtTime;
    private final SliderSetting predictTicks;
    final SliderSetting sliderSpeed;
    private final SliderSetting maxSelf;
    public final Timer lastBreakTimer;
    private final EnumSetting<Page> page;
    final ColorSetting fill;
    private final BooleanSetting place;
    final SliderSetting fadeSpeed;
    private final Timer delayTimer;
    private final BooleanSetting forcePlace;
    private final BooleanSetting eatingPause;
    public class_243 directionVec;
    private final BooleanSetting smart;
    private final BooleanSetting yawStep;
    private final SliderSetting slowDelay;
    final BooleanSetting shrink;
    public static final Timer placeTimer;
    private final BooleanSetting breakOnlyHasCrystal;
    private final BooleanSetting spam;
    private final SliderSetting antiSurroundMax;
    double fade;

    @Override
    public void onEnable() {
        AutoCrystal a;
        a.lastYaw = Hana.ROTATE.lastYaw;
        a.lastPitch = Hana.ROTATE.lastPitch;
        a.lastBreakTimer.reset();
    }

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        AutoCrystal a3 = class_23382;
        AutoCrystal a4 = this;
        return a4.calculateDamage(new class_243((double)a3.method_10263() + 0.5, (double)a3.method_10264(), (double)a3.method_10260() + 0.5), (class_1657)a2, (class_1657)a);
    }

    /*
     * Exception decompiling
     */
    public float calculateDamage(class_243 var1_1, class_1657 var2_2, class_1657 var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[DOLOOP]], but top level block is 1[CASE]
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

    private /* synthetic */ boolean canTouch(class_2338 a) {
        AutoCrystal a2;
        AutoCrystal autoCrystal = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(AutoCrystal.mc.field_1724.method_33571()) <= autoCrystal.range.getValue()) {
                return true;
            }
        }
        return false;
    }

    private /* synthetic */ void doBreak(class_2338 class_23382) {
        AutoCrystal a;
        AutoCrystal a2 = class_23382;
        AutoCrystal autoCrystal = a = this;
        autoCrystal.lastBreakTimer.reset();
        if (!autoCrystal.Break.getValue()) {
            return;
        }
        if (!CombatUtil.breakTimer.passedMs((long)a.breakDelay.getValue())) {
            return;
        }
        class_1511 class_15112 = AutoCrystal.mc.field_1687.method_18467(class_1511.class, new class_238((double)a2.method_10263(), (double)a2.method_10264(), (double)a2.method_10260(), (double)(a2.method_10263() + 1), (double)(a2.method_10264() + 2), (double)(a2.method_10260() + 1))).iterator();
        if (class_15112.hasNext()) {
            class_15112 = (class_1511)class_15112.next();
            if (a.rotate.getValue() && a.onBreak.getValue() && !a.faceVector(class_15112.method_19538().method_1031(0.0, 0.25, 0.0))) {
                return;
            }
            CombatUtil.breakTimer.reset();
            AutoCrystal.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34206((class_1297)class_15112, (boolean)AutoCrystal.mc.field_1724.method_5715()));
            EntityUtil.swingHand(class_1268.field_5808, a.swingMode.getValue());
            if (a.breakRemove.getValue()) {
                AutoCrystal.mc.field_1687.method_2945(class_15112.method_5628(), class_1297.class_5529.field_26998);
            }
            AutoCrystal autoCrystal2 = a;
            if (autoCrystal2.tempDamage >= autoCrystal2.minDamage.getValueFloat() && a.spam.getValue()) {
                a.doPlace((class_2338)a2);
                return;
            }
        }
    }

    public static boolean liteCheck(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2432;
        class_243 a2 = class_2433;
        return !AutoCrystal.canSee(a, a2) && !AutoCrystal.canSee(a, a2.method_1031(0.0, 1.8, 0.0));
    }

    @Override
    public String getInfo() {
        AutoCrystal a;
        if (a.displayTarget != null && a.lastDamage > 0.0f) {
            return a.displayTarget.method_5477().getString() + ", " + new DecimalFormat(FPSManager.ALLATORIxDEMO("I8@")).format(a.lastDamage);
        }
        return null;
    }

    public void doCrystal(class_2338 class_23382) {
        AutoCrystal a = this;
        AutoCrystal a2 = class_23382;
        if (a.canPlaceCrystal((class_2338)a2, false, true)) {
            if (AutoCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || AutoCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) || a.findCrystal()) {
                a.doPlace((class_2338)a2);
                return;
            }
        } else {
            a.doBreak((class_2338)a2);
        }
    }

    public AutoCrystal() {
        AutoCrystal a;
        AutoCrystal autoCrystal = a;
        super(ColorUtil.ALLATORIxDEMO("\u000f(o5_/b3rk "), FPSManager.ALLATORIxDEMO("B\u0013n\u0004#D"), Module.Category.Combat);
        AutoCrystal autoCrystal2 = a;
        autoCrystal2.page = autoCrystal.add(new EnumSetting<Page>(ColorUtil.ALLATORIxDEMO("\u0010gm)"), Page.General));
        autoCrystal.preferAnchor = autoCrystal.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("#7Fv\u0013e\\Q\u0018n\u0003(S"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(ColorUtil.ALLATORIxDEMO("H7od+"), SwingSide.Server, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.eatingPause = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("fq\u0002~\u001fw&l\u001e4D"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.switchCooldown = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u001d*r.5K!sy)"), 100, 0, 1000, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FPSManager.ALLATORIxDEMO("*R")));
        a.targetRange = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u001a<i=y)I!hm)"), 12.0, 0.0, 20.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FPSManager.ALLATORIxDEMO("L")));
        a.updateDelay = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u001b-;h8_%jk5"), 50, 0, 1000, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FPSManager.ALLATORIxDEMO("*R")));
        a.wallRange = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("L;p1I!hm)"), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(FPSManager.ALLATORIxDEMO("L")));
        a.rotate = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u000ft4g~)"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.onBreak = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO(">~4\u000e&J"), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("E<l\u0013ro<"), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("%y\u000e7R"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u000fz.be!"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("@\u0017n\u0000\"U"), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("X2y>p\fie'"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("-(W"), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.minDamage = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("Kc\""), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(FPSManager.ALLATORIxDEMO("\u000f*F")));
        a.maxSelf = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u0013cf*"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(FPSManager.ALLATORIxDEMO("\u000f*F")));
        a.range = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("I!hm)"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(FPSManager.ALLATORIxDEMO("L")));
        a.noSuicide = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("U5O(r#on)"), 3.0, 0.0, 10.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setSuffix(FPSManager.ALLATORIxDEMO("\u000f*F")));
        a.place = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("K,gi)"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setParent());
        a.placeDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("@\u001av\u0012u2h\u0007&X"), 300, 0, 1000, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }).setSuffix(ColorUtil.ALLATORIxDEMO("g?")));
        a.autoSwap = a.add(new EnumSetting<SwapMode>(FPSManager.ALLATORIxDEMO("V\u0004d\u0019^\u001c&Q"), SwapMode.Off, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.spam = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u0013vk!"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.place.isOpen();
        }));
        a.Break = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("4\u000e&J"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact;
        }).setParent());
        a.breakDelay = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u001fi?}6_%jk5"), 300, 0, 1000, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }).setSuffix(FPSManager.ALLATORIxDEMO("*R")));
        a.breakOnlyHasCrystal = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u0017pd7\u0015z)_/b3rk "), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }));
        a.breakRemove = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("B\u0013`\u00041D"), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Interact && a2.Break.isOpen();
        }));
        a.mode = a.add(new EnumSetting<Aura.TargetESP>(ColorUtil.ALLATORIxDEMO("O;n:~4CY\u001c"), Aura.TargetESP.Jello, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(FPSManager.ALLATORIxDEMO("wq\u0004p\u0014d5b\u0007(S"), new Color(255, 255, 255, 250), object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.text = a.add(new ColorSetting(ColorUtil.ALLATORIxDEMO("\u0014cr8"), new Color(-1), object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }).injectBoolean(true));
        a.render = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("B\u0013c\u000f\"S"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.shrink = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u000es2od'"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new ColorSetting(FPSManager.ALLATORIxDEMO(")(Y"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.bold = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u0002if("), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.box.booleanValue;
        })).setParent();
        a.lineWidth = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO(":~\u001fu!d\u000f3I"), 4, 1, 5, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.bold.isOpen() && a2.box.booleanValue;
        }));
        a.fill = a.add(new ColorSetting(ColorUtil.ALLATORIxDEMO("\u0006of "), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.sliderSpeed = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("p|\u001fs\u0014b%}\u000e\"E"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("H.}/o\u0006gn)"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setSuffix(FPSManager.ALLATORIxDEMO("R")));
        a.fadeSpeed = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("];x8H0co("), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.smart = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("%`\n5U"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.useThread = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("N)y\ts2ck("), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.doCrystal = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("0$Os2x2b\u000f~\u001f&M"), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.lite = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\fo~)"), false, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.calcMode = a.add(new EnumSetting<AnchorAura.CalcMode>(FPSManager.ALLATORIxDEMO("T\u0010|\u0015@\u0004#D"), AnchorAura.CalcMode.OyVey, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.predictTicks = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("L/~$oi8"), 4, 0, 10, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(FPSManager.ALLATORIxDEMO("\u0002d\b,R")));
        a.terrainIgnore = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("Jm</z3r\u0014|.ix)"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.antiSurround = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("\u0004Md\u001fD\u0004b\u0004b\u001e)E"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.antiSurroundMax = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("L2y3W/qo>"), 5.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.antiSurround.isOpen();
        }).setSuffix(FPSManager.ALLATORIxDEMO("\u000f*F")));
        a.slowPlace = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("H4v%i8"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.slowDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("\u0011J}\u0013x\u0004d2h\u0007&X"), 600, 0, 2000, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.slowPlace.isOpen();
        }).setSuffix(ColorUtil.ALLATORIxDEMO("g?")));
        a.slowMinDamage = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("D\u001fz\u0014\u0003y&.O"), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.slowPlace.isOpen();
        }).setSuffix(ColorUtil.ALLATORIxDEMO("bg+")));
        a.forcePlace = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("V\u0019e\u0012u&a\n$D"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.forceMaxHealth = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("W5k8i\u0014nk\""), 7, 0, 36, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(FPSManager.ALLATORIxDEMO("x\u0013l\u00073I")));
        a.forceMin = a.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u001cs/x%Kc\""), 1.5, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.forcePlace.isOpen();
        }).setSuffix(FPSManager.ALLATORIxDEMO("\u000f*F")));
        a.armorBreaker = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("I<0t(^/~!mo>"), true, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }).setParent());
        a.maxDurable = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("]\u0017o5e\u0004l\t+D"), 8, 0, 100, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(ColorUtil.ALLATORIxDEMO("i")));
        a.armorBreakerDamage = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("R\u0004r\u0010{\u0013&.O"), 3.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc && a2.armorBreaker.isOpen();
        }).setSuffix(ColorUtil.ALLATORIxDEMO("bg+")));
        a.hurtTime = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("_\u0004b\u0002Y\u0002*D"), 10.0, 0.0, 10.0, 1.0, object -> {
            Object a = object;
            AutoCrystal a2 = this;
            return a2.page.getValue() == Page.Misc;
        }));
        AutoCrystal autoCrystal3 = a;
        AutoCrystal autoCrystal4 = a;
        AutoCrystal autoCrystal5 = a;
        AutoCrystal autoCrystal6 = a;
        autoCrystal6.switchTimer = new Timer();
        autoCrystal6.delayTimer = new Timer();
        autoCrystal6.lastBreakTimer = new Timer();
        autoCrystal6.noPosTimer = new Timer();
        autoCrystal5.lastYaw = 0.0f;
        autoCrystal5.lastPitch = 0.0f;
        autoCrystal4.lastHotbar = -1;
        autoCrystal4.directionVec = null;
        autoCrystal3.fade = 0.0;
        autoCrystal3.setChinese(ColorUtil.ALLATORIxDEMO("\u81aa\u52ae\u6c3e\u663a"));
        INSTANCE = autoCrystal3;
        Hana.EVENT_BUS.subscribe(new CrystalRender(a));
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.rotate.getValue() && arrf.yawStep.getValue() && arrf.directionVec != null && !arrf.noPosTimer.passed(1000L)) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.steps.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            if (arrf2.random.getValue() && new Random().nextBoolean()) {
                float[] arrf3 = arrf;
                arrf.lastPitch = Math.min(new Random().nextFloat() * 2.0f + arrf.lastPitch, 90.0f);
            }
            RotateEvent rotateEvent = a;
            float[] arrf4 = arrf;
            rotateEvent.setYaw(arrf4.lastYaw);
            rotateEvent.setPitch(arrf4.lastPitch);
            return;
        }
        float[] arrf5 = arrf;
        arrf5.lastYaw = Hana.ROTATE.lastYaw;
        arrf5.lastPitch = Hana.ROTATE.lastPitch;
    }

    public void placeCrystal(class_2338 a) {
        class_1268 class_12682;
        AutoCrystal autoCrystal;
        AutoCrystal a22;
        AutoCrystal autoCrystal2 = a22;
        boolean a22 = AutoCrystal.mc.field_1724.method_6079().method_7909() == class_1802.field_8301;
        class_2338 class_23382 = a.method_10074();
        if (a22) {
            class_12682 = class_1268.field_5810;
            autoCrystal = autoCrystal2;
        } else {
            class_12682 = class_1268.field_5808;
            autoCrystal = autoCrystal2;
        }
        BlockUtil.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), false, class_12682, autoCrystal.swingMode.getValue());
    }

    public boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.yawStep.getValue()) {
            EntityUtil.faceVector((class_243)a);
            return true;
        }
        a2.directionVec = a;
        a = EntityUtil.getLegitRotations((class_243)a);
        if (Math.abs(class_3532.method_15393((float)(arrf[0] - a2.lastYaw))) < a2.fov.getValueFloat() && Math.abs(class_3532.method_15393((float)(a[1] - a2.lastPitch))) < a2.fov.getValueFloat()) {
            if (a2.packet.getValue()) {
                EntityUtil.sendYawAndPitch(a[0], a[1]);
            }
            return true;
        }
        return !a2.checkLook.getValue();
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoCrystal a2 = this;
        if (a2.autoSwap.getValue() == SwapMode.Silent || a2.autoSwap.getValue() == SwapMode.Normal) {
            InventoryUtil.switchToSlot(a);
            return;
        }
        if (a2.autoSwap.getValue() == SwapMode.Inventory) {
            InventoryUtil.inventorySwap(a, AutoCrystal.mc.field_1724.method_31548().field_7545);
        }
    }

    public boolean findCrystal() {
        AutoCrystal a;
        if (a.autoSwap.getValue() == SwapMode.Off) {
            return false;
        }
        return a.getCrystal() != -1;
    }

    private /* synthetic */ void update() {
        Iterator a;
        AutoCrystal autoCrystal;
        AutoCrystal autoCrystal2 = a;
        if (AutoCrystal.nullCheck()) {
            return;
        }
        AutoCrystal autoCrystal3 = autoCrystal2;
        if (!autoCrystal3.delayTimer.passedMs((long)autoCrystal3.updateDelay.getValue())) {
            return;
        }
        if (autoCrystal2.eatingPause.getValue() && EntityUtil.isUsing()) {
            autoCrystal2.lastBreakTimer.reset();
            tempPos = null;
            return;
        }
        if (autoCrystal2.preferAnchor.getValue() && AnchorAura.INSTANCE.currentPos != null) {
            autoCrystal2.lastBreakTimer.reset();
            tempPos = null;
            return;
        }
        if (autoCrystal2.breakOnlyHasCrystal.getValue() && !AutoCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) && !AutoCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) && !autoCrystal2.findCrystal()) {
            autoCrystal2.lastBreakTimer.reset();
            tempPos = null;
            return;
        }
        AutoCrystal autoCrystal4 = autoCrystal2;
        if (!autoCrystal4.switchTimer.passedMs((long)autoCrystal4.switchCooldown.getValue())) {
            return;
        }
        autoCrystal2.delayTimer.reset();
        tempPos = null;
        autoCrystal2.tempDamage = 0.0f;
        class_2338 class_23382 = new ArrayList();
        Object object = CombatUtil.getEnemies(autoCrystal2.targetRange.getValue()).iterator();
        while (object.hasNext()) {
            a = object.next();
            if (((class_1657)a).field_6235 > autoCrystal2.hurtTime.getValueInt()) continue;
            class_23382.add(new PlayerAndPredict(autoCrystal2, (class_1657)a));
        }
        object = new PlayerAndPredict(autoCrystal2, (class_1657)AutoCrystal.mc.field_1724);
        AutoCrystal autoCrystal5 = autoCrystal2;
        if (class_23382.isEmpty()) {
            autoCrystal5.lastBreakTimer.reset();
            autoCrystal = autoCrystal2;
        } else {
            Object object2;
            int n;
            Object object3;
            Object object4;
            a = BlockUtil.getSphere((float)autoCrystal5.range.getValue() + 1.0f).iterator();
            block1 : do {
                Iterator iterator = a;
                while (iterator.hasNext()) {
                    Object object5 = (class_2338)a.next();
                    if (autoCrystal2.behindWall((class_2338)object5)) {
                        iterator = a;
                        continue;
                    }
                    if (AutoCrystal.mc.field_1724.method_19538().method_1022(object5.method_46558().method_1031(0.0, -0.5, 0.0)) > autoCrystal2.range.getValue()) {
                        iterator = a;
                        continue;
                    }
                    if (!autoCrystal2.canTouch(object5.method_10074())) {
                        iterator = a;
                        continue;
                    }
                    if (!autoCrystal2.canPlaceCrystal((class_2338)object5, true, false)) {
                        iterator = a;
                        continue;
                    }
                    object3 = class_23382.iterator();
                    block3 : do {
                        Object object6 = object3;
                        do {
                            if (!object6.hasNext()) continue block1;
                            object4 = (PlayerAndPredict)object3.next();
                            if (autoCrystal2.lite.getValue() && AutoCrystal.liteCheck(object5.method_46558().method_1031(0.0, -0.5, 0.0), object4.predict.method_19538())) {
                                object6 = object3;
                                continue;
                            }
                            Object object7 = object4;
                            n = (int)autoCrystal2.calculateDamage((class_2338)object5, object7.player, object7.predict);
                            if (tempPos != null && !(n > autoCrystal2.tempDamage)) continue block3;
                            Object object8 = object;
                            float f = autoCrystal2.calculateDamage((class_2338)object5, ((PlayerAndPredict)object8).player, ((PlayerAndPredict)object8).predict);
                            object2 = f;
                            if ((double)f > autoCrystal2.maxSelf.getValue()) {
                                object6 = object3;
                                continue;
                            }
                            if (autoCrystal2.noSuicide.getValue() > 0.0 && (double)object2 > (double)(AutoCrystal.mc.field_1724.method_6032() + AutoCrystal.mc.field_1724.method_6067()) - autoCrystal2.noSuicide.getValue()) {
                                object6 = object3;
                                continue;
                            }
                            if (!(n < EntityUtil.getHealth((class_1297)object4.player))) break;
                            if ((double)n < autoCrystal2.getDamage(object4.player)) {
                                object6 = object3;
                                continue;
                            }
                            if (!autoCrystal2.smart.getValue()) break;
                            if (autoCrystal2.getDamage(object4.player) == autoCrystal2.forceMin.getValue()) {
                                if (!((double)n < (double)object2 - 2.5)) break;
                                object6 = object3;
                                continue;
                            }
                            if (!(n < object2)) break;
                            object6 = object3;
                        } while (true);
                        autoCrystal2.displayTarget = object4.player;
                        tempPos = object5;
                        autoCrystal2.tempDamage = n;
                    } while (true);
                }
                break;
            } while (true);
            if (autoCrystal2.antiSurround.getValue() && SpeedMine.breakPos != null && SpeedMine.progress >= 0.9 && !BlockUtil.hasEntity(SpeedMine.breakPos, false)) {
                AutoCrystal autoCrystal6 = autoCrystal2;
                if (autoCrystal6.tempDamage <= autoCrystal6.antiSurroundMax.getValueFloat()) {
                    for (Object object5 : class_23382) {
                        object3 = class_2350.values();
                        object4 = ((class_2350[])object3).length;
                        int n2 = n = 0;
                        while (n2 < object4) {
                            object2 = object3[n];
                            if (object2 != class_2350.field_11033 && object2 != class_2350.field_11036 && (class_23382 = new BlockPosX(object5.player.method_19538().method_1031(0.0, 0.5, 0.0)).method_10093((class_2350)object2)).equals((Object)SpeedMine.breakPos)) {
                                int n3;
                                if (autoCrystal2.canPlaceCrystal(class_23382.method_10093((class_2350)object2), false, false)) {
                                    float f;
                                    Object object9 = object;
                                    float f2 = autoCrystal2.calculateDamage(class_23382.method_10093((class_2350)object2), ((PlayerAndPredict)object9).player, ((PlayerAndPredict)object9).predict);
                                    if (!(!((double)f < autoCrystal2.maxSelf.getValue()) || autoCrystal2.noSuicide.getValue() > 0.0 && (double)f2 > (double)(AutoCrystal.mc.field_1724.method_6032() + AutoCrystal.mc.field_1724.method_6067()) - autoCrystal2.noSuicide.getValue())) {
                                        tempPos = class_23382.method_10093((class_2350)object2);
                                        if (autoCrystal2.doCrystal.getValue() && tempPos != null) {
                                            autoCrystal2.doCrystal(tempPos);
                                        }
                                        return;
                                    }
                                }
                                class_2350[] arrclass_2350 = class_2350.values();
                                int n4 = arrclass_2350.length;
                                int n5 = n3 = 0;
                                while (n5 < n4) {
                                    class_2350 class_23502 = arrclass_2350[n3];
                                    if (class_23502 != class_2350.field_11033 && class_23502 != object2 && autoCrystal2.canPlaceCrystal(class_23382.method_10093(class_23502), false, false)) {
                                        float f;
                                        Object object10 = object;
                                        float f3 = autoCrystal2.calculateDamage(class_23382.method_10093(class_23502), ((PlayerAndPredict)object10).player, ((PlayerAndPredict)object10).predict);
                                        if (!(!((double)f < autoCrystal2.maxSelf.getValue()) || autoCrystal2.noSuicide.getValue() > 0.0 && (double)f3 > (double)(AutoCrystal.mc.field_1724.method_6032() + AutoCrystal.mc.field_1724.method_6067()) - autoCrystal2.noSuicide.getValue())) {
                                            tempPos = class_23382.method_10093(class_23502);
                                            if (autoCrystal2.doCrystal.getValue() && tempPos != null) {
                                                autoCrystal2.doCrystal(tempPos);
                                            }
                                            return;
                                        }
                                    }
                                    n5 = ++n3;
                                }
                            }
                            n2 = ++n;
                        }
                    }
                }
            }
            autoCrystal = autoCrystal2;
        }
        if (autoCrystal.doCrystal.getValue() && tempPos != null) {
            autoCrystal2.doCrystal(tempPos);
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        void a2;
        class_2338 a3;
        AutoCrystal autoCrystal = this;
        a3 = a3.method_10074();
        AutoCrystal a4 = a3.method_10084();
        return !(BlockUtil.getBlock(a3) != class_2246.field_9987 && BlockUtil.getBlock(a3) != class_2246.field_10540 || BlockUtil.getClickSideStrict(a3) == null || autoCrystal.hasEntityBlockCrystal((class_2338)a4, (boolean)a2, (boolean)a) || autoCrystal.hasEntityBlockCrystal(a4.method_10084(), (boolean)a2, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10124 && (!autoCrystal.hasEntityBlockCrystal((class_2338)a4, false, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a4.method_10084()) != class_2246.field_10124);
    }

    public boolean behindWall(class_2338 class_23382) {
        AutoCrystal a = class_23382;
        AutoCrystal a2 = this;
        class_243 class_2432 = CombatSetting.INSTANCE.lowVersion.getValue() ? new class_243((double)a.method_10263() + 0.5, (double)a.method_10264(), (double)a.method_10260() + 0.5) : new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        class_2432 = AutoCrystal.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), class_2432, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoCrystal.mc.field_1724));
        if (class_2432 == null || class_2432.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return AutoCrystal.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > a2.wallRange.getValue();
    }

    @Override
    public void onUpdate() {
        AutoCrystal a2;
        AutoCrystal autoCrystal = a2;
        if (autoCrystal.useThread.getValue()) {
            if (thread == null || !thread.isAlive()) {
                thread = new Thread(() -> {
                    AutoCrystal a;
                    while (INSTANCE.isOn() && a.useThread.getValue()) {
                        a.updateCrystalPos();
                    }
                    crystalPos = null;
                    tempPos = null;
                });
                try {
                    thread.start();
                }
                catch (Exception a2) {
                    a2.printStackTrace();
                }
            }
        } else {
            autoCrystal.updateCrystalPos();
        }
        if (crystalPos != null) {
            autoCrystal.doCrystal(crystalPos);
        }
    }

    private /* synthetic */ int getCrystal() {
        AutoCrystal a;
        if (a.autoSwap.getValue() == SwapMode.Silent || a.autoSwap.getValue() == SwapMode.Normal) {
            return InventoryUtil.findItem(class_1802.field_8301);
        }
        if (a.autoSwap.getValue() == SwapMode.Inventory) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean hasEntityBlockCrystal(class_2338 var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        a = AutoCrystal.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = a;
            while (v0.hasNext() != false) {
                a = (class_1297)a.next();
                if (!a.method_5805() || a != false && a instanceof class_1542) ** GOTO lbl-1000
                if (a instanceof class_1531 && CombatSetting.INSTANCE.obsMode.getValue()) {
                    v0 = a;
                    continue;
                }
                if (a instanceof class_1511 == false) return true;
                if (a == false) {
                    return true;
                }
                if (AutoCrystal.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(AutoCrystal.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return true;
                v0 = a;
            }
            return false;
            break;
        } while (true);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        AutoCrystal a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
        if (crystalPos != null) {
            a2.doCrystal(crystalPos);
        }
        if (AutoCrystal.INSTANCE.displayTarget != null && !AutoCrystal.INSTANCE.noPosTimer.passedMs(500L)) {
            void a3;
            Aura.doRender((class_4587)a3, a, (class_1297)AutoCrystal.INSTANCE.displayTarget, a2.color.getValue(), a2.mode.getValue());
        }
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AutoCrystal a2 = this;
        if (!a2.useThread.getValue()) {
            a2.updateCrystalPos();
        }
        if (crystalPos != null) {
            a2.doCrystal(crystalPos);
        }
    }

    private /* synthetic */ double getDamage(class_1657 class_16572) {
        Object a = class_16572;
        AutoCrystal a2 = this;
        if (!SpeedMine.INSTANCE.obsidian.isPressed() && a2.slowPlace.getValue()) {
            AutoCrystal autoCrystal = a2;
            if (autoCrystal.lastBreakTimer.passedMs((long)autoCrystal.slowDelay.getValue()) && (!BedAura.INSTANCE.isOn() || BedAura.INSTANCE.getBed() == -1)) {
                return a2.slowMinDamage.getValue();
            }
        }
        if (a2.forcePlace.getValue() && (double)EntityUtil.getHealth((class_1297)a) <= a2.forceMaxHealth.getValue() && !SpeedMine.INSTANCE.obsidian.isPressed()) {
            return a2.forceMin.getValue();
        }
        if (a2.armorBreaker.getValue()) {
            Object object = a = a.method_31548().field_7548.iterator();
            while (object.hasNext()) {
                class_1799 class_17992 = (class_1799)a.next();
                if (class_17992.method_7960()) {
                    object = a;
                    continue;
                }
                if ((double)EntityUtil.getDamagePercent(class_17992) > a2.maxDurable.getValue()) {
                    object = a;
                    continue;
                }
                return a2.armorBreakerDamage.getValue();
            }
        }
        return a2.minDamage.getValue();
    }

    static {
        placeTimer = new Timer();
    }

    public static boolean canSee(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return (a = AutoCrystal.mc.field_1687.method_17742(new class_3959(a2, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)AutoCrystal.mc.field_1724))) == null || a.method_17783() == class_239.class_240.field_1333;
    }

    @Override
    public void onDisable() {
        crystalPos = null;
        tempPos = null;
    }

    private /* synthetic */ void updateCrystalPos() {
        AutoCrystal a;
        AutoCrystal autoCrystal = a;
        autoCrystal.update();
        autoCrystal.lastDamage = autoCrystal.tempDamage;
        crystalPos = tempPos;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        AutoCrystal a3 = this;
        if (a2 < 0.01f) {
            a2 = 0.01f;
        }
        if (a2 > 1.0f) {
            a2 = 1.0f;
        }
        if (a2 < 1.0f && a != null) {
            float f2;
            void v2;
            float f3 = a3.lastYaw;
            float f4 = class_3532.method_15393((float)(a[0] - f3));
            if (Math.abs(f2) > 90.0f * a2) {
                float f5 = f4;
                a[0] = f3 + f5 * (90.0f * a2 / Math.abs(f5));
            }
            f3 = a3.lastPitch;
            f4 = a[1] - f3;
            if (Math.abs((float)v2) > 90.0f * a2) {
                float f6 = f4;
                a[1] = f3 + f6 * (90.0f * a2 / Math.abs(f6));
            }
        }
        float[] arrf2 = new float[2];
        arrf2[0] = a[0];
        arrf2[1] = a[1];
        return arrf2;
    }

    private /* synthetic */ void doPlace(class_2338 a) {
        AutoCrystal a22;
        AutoCrystal autoCrystal = a22;
        if (!autoCrystal.place.getValue()) {
            return;
        }
        if (!(AutoCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || AutoCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) || autoCrystal.findCrystal())) {
            return;
        }
        if (!autoCrystal.canTouch(a.method_10074())) {
            return;
        }
        class_2338 class_23382 = a.method_10074();
        a22 = BlockUtil.getClickSide(class_23382);
        a22 = class_23382.method_46558().method_1031((double)a22.method_10163().method_10263() * 0.5, (double)a22.method_10163().method_10264() * 0.5, (double)a22.method_10163().method_10260() * 0.5);
        if (autoCrystal.rotate.getValue() && !autoCrystal.faceVector((class_243)a22)) {
            return;
        }
        if (!placeTimer.passedMs((long)autoCrystal.placeDelay.getValue())) {
            return;
        }
        placeTimer.reset();
        if (AutoCrystal.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || AutoCrystal.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301)) {
            autoCrystal.placeCrystal(a);
            return;
        }
        if (autoCrystal.findCrystal()) {
            int a22 = AutoCrystal.mc.field_1724.method_31548().field_7545;
            int n = autoCrystal.getCrystal();
            if (n == -1) {
                return;
            }
            AutoCrystal autoCrystal2 = autoCrystal;
            autoCrystal2.doSwap(n);
            autoCrystal2.placeCrystal(a);
            if (autoCrystal.autoSwap.getValue() == SwapMode.Silent) {
                autoCrystal.doSwap(a22);
                return;
            }
            if (autoCrystal.autoSwap.getValue() == SwapMode.Inventory) {
                autoCrystal.doSwap(n);
                EntityUtil.syncInventory();
            }
        }
    }

    @EventHandler(priority=-199)
    public void onPacketSend(PacketEvent.Send send) {
        Object a = send;
        AutoCrystal a2 = this;
        if (((Event)a).isCancelled()) {
            return;
        }
        Object t = ((PacketEvent)a).getPacket();
        if (t instanceof class_2868 && (a = (class_2868)t).method_12442() != a2.lastHotbar) {
            a2.lastHotbar = a.method_12442();
            a2.switchTimer.reset();
        }
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Interact;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Render;
        public static final /* enum */ Page Misc;
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page General;

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

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[6];
            arrpage[0] = General;
            arrpage[1] = Interact;
            arrpage[2] = Misc;
            arrpage[3] = Rotate;
            arrpage[4] = Calc;
            arrpage[5] = Render;
            return arrpage;
        }

        static {
            General = new Page(BaseChildSettings.ALLATORIxDEMO("\u0013B=_<\u0011h"), 0);
            Interact = new Page(RenderHelper.ALLATORIxDEMO("$|\u001ep\u0005i^6"), 1);
            Misc = new Page(BaseChildSettings.ALLATORIxDEMO("w'\u0003g"), 2);
            Rotate = new Page(RenderHelper.ALLATORIxDEMO("8z\u0003iI'"), 3);
            Calc = new Page(BaseChildSettings.ALLATORIxDEMO("y/\u001cg"), 4);
            Render = new Page(RenderHelper.ALLATORIxDEMO("8p\u0019lX0"), 5);
            $VALUES = Page.$values();
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }
    }

    public static final class SwapMode
    extends Enum<SwapMode> {
        public static final /* enum */ SwapMode Silent;
        public static final /* enum */ SwapMode Off;
        public static final /* enum */ SwapMode Normal;
        private static final /* synthetic */ SwapMode[] $VALUES;
        public static final /* enum */ SwapMode Inventory;

        public static SwapMode[] values() {
            return (SwapMode[])$VALUES.clone();
        }

        static {
            Off = new SwapMode(GaussianFilter.ALLATORIxDEMO("q~\u0012"), 0);
            Normal = new SwapMode(User.ALLATORIxDEMO("nSYZKZ"), 1);
            Silent = new SwapMode(GaussianFilter.ALLATORIxDEMO("\u001cJ>[v\u0000"), 2);
            Inventory = new SwapMode(User.ALLATORIxDEMO("jlhER_XXO"), 3);
            $VALUES = SwapMode.$values();
        }

        public static SwapMode valueOf(String a) {
            return Enum.valueOf(SwapMode.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ SwapMode() {
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

        private static /* synthetic */ SwapMode[] $values() {
            SwapMode[] arrswapMode = new SwapMode[4];
            arrswapMode[0] = Off;
            arrswapMode[1] = Normal;
            arrswapMode[2] = Silent;
            arrswapMode[3] = Inventory;
            return arrswapMode;
        }
    }

    public class CrystalRender {
        final /* synthetic */ AutoCrystal this$0;

        public CrystalRender(AutoCrystal autoCrystal) {
            AutoCrystal a = autoCrystal;
            CrystalRender a2 = this;
            a2.this$0 = a;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @EventHandler
        public void onRender3D(Render3DEvent a) {
            var2_2 = a;
            if (AutoCrystal.crystalPos != null) {
                var2_2.this$0.noPosTimer.reset();
                AutoCrystal.placeVec3d = AutoCrystal.crystalPos.method_10074().method_46558();
            }
            if (AutoCrystal.placeVec3d == null) {
                return;
            }
            if (var2_2.this$0.fadeSpeed.getValue() >= 1.0) {
                var2_2.this$0.fade = var2_2.this$0.noPosTimer.passedMs((long)(var2_2.this$0.startFadeTime.getValue() * 1000.0)) != false ? 0.0 : 0.5;
                v0 = var2_2;
            } else {
                if (var2_2.this$0.noPosTimer.passedMs((long)(var2_2.this$0.startFadeTime.getValue() * 1000.0))) {
                    v1 = 0.0;
                    v2 = var2_2;
                } else {
                    v1 = 0.5;
                    v2 = var2_2;
                }
                var2_2.this$0.fade = AnimateUtil.animate(var2_2.this$0.fade, v1, v2.this$0.fadeSpeed.getValue() / 10.0);
                v0 = var2_2;
            }
            if (v0.this$0.fade == 0.0) {
                AutoCrystal.curVec3d = null;
                return;
            }
            if (AutoCrystal.curVec3d == null || var2_2.this$0.sliderSpeed.getValue() >= 1.0) {
                AutoCrystal.curVec3d = AutoCrystal.placeVec3d;
                v3 = var2_2;
            } else {
                AutoCrystal.curVec3d = new class_243(AnimateUtil.animate(AutoCrystal.curVec3d.field_1352, AutoCrystal.placeVec3d.field_1352, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoCrystal.curVec3d.field_1351, AutoCrystal.placeVec3d.field_1351, var2_2.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoCrystal.curVec3d.field_1350, AutoCrystal.placeVec3d.field_1350, var2_2.this$0.sliderSpeed.getValue() / 10.0));
                v3 = var2_2;
            }
            if (!v3.this$0.render.getValue()) ** GOTO lbl47
            v4 = a = new class_238(AutoCrystal.curVec3d, AutoCrystal.curVec3d);
            if (var2_2.this$0.shrink.getValue()) {
                a = v4.method_1014(var2_2.this$0.fade);
                v5 = a;
            } else {
                a = v4.method_1014(0.5);
                v5 = a;
            }
            a = v5.getMatrixStack();
            if (var2_2.this$0.fill.booleanValue) {
                Render3DUtil.drawFill((class_4587)a, (class_238)a, ColorUtil.injectAlpha(var2_2.this$0.fill.getValue(), (int)((double)var2_2.this$0.fill.getValue().getAlpha() * var2_2.this$0.fade * 2.0)));
            }
            if (!var2_2.this$0.box.booleanValue) ** GOTO lbl47
            if (!var2_2.this$0.bold.getValue()) {
                v6 = var2_2;
                v7 = v6;
                Render3DUtil.drawBox((class_4587)a, (class_238)a, ColorUtil.injectAlpha(v6.this$0.box.getValue(), (int)((double)var2_2.this$0.box.getValue().getAlpha() * var2_2.this$0.fade * 2.0)));
            } else {
                Render3DUtil.drawLine((class_238)a, ColorUtil.injectAlpha(var2_2.this$0.box.getValue(), (int)((double)var2_2.this$0.box.getValue().getAlpha() * var2_2.this$0.fade * 2.0)), var2_2.this$0.lineWidth.getValueInt());
lbl47: // 3 sources:
                v7 = var2_2;
            }
            if (v7.this$0.text.booleanValue == false) return;
            if (!(var2_2.this$0.lastDamage > 0.0f)) return;
            v8 = new Object[1];
            v8[0] = Float.valueOf(var2_2.this$0.lastDamage);
            Render3DUtil.drawText3D(String.format(BufferRing.ALLATORIxDEMO("6\tV6"), v8), AutoCrystal.curVec3d, var2_2.this$0.text.getValue());
        }
    }

    public class PlayerAndPredict {
        final /* synthetic */ AutoCrystal this$0;
        final class_1657 player;
        final class_1657 predict;

        public PlayerAndPredict(AutoCrystal autoCrystal, class_1657 class_16572) {
            Iterator a;
            PlayerAndPredict a2 = class_16572;
            PlayerAndPredict a3 = this;
            a3.this$0 = a;
            a3.player = a2;
            if (((AutoCrystal)a).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a3;
                playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(Snow.ALLATORIxDEMO(";ot#\u0002S;o-e*0}&s\u0013F\"m3g\u0007H%q3e3b0j4`%q")), Animation.ALLATORIxDEMO("wnvLXiRXIhCeY(\u00045")), (AutoCrystal)((Object)a)){
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ AutoCrystal val$this$0;

                    public boolean method_7337() {
                        return false;
                    }
                    {
                        void a;
                        void a2;
                        void a3;
                        void a4;
                        Object a5;
                        void a6;
                        1 v0 = object2;
                        Object object2 = object;
                        object = v0;
                        object.this$1 = a6;
                        object.val$this$0 = a5;
                        super((class_1937)a4, (class_2338)a3, (float)a2, (GameProfile)a);
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, AutoCrystal.INSTANCE.predictTicks.getValueInt(), true)));
                playerAndPredict.predict.method_6033(a2.method_6032());
                playerAndPredict.predict.field_6014 = ((class_1657)a2).field_6014;
                playerAndPredict.predict.field_5969 = ((class_1657)a2).field_5969;
                playerAndPredict.predict.field_6036 = ((class_1657)a2).field_6036;
                playerAndPredict.predict.method_24830(a2.method_24828());
                PlayerAndPredict playerAndPredict2 = a2;
                playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
                playerAndPredict.predict.method_18380(a2.method_18376());
                Iterator iterator = a = playerAndPredict2.method_6026().iterator();
                while (iterator.hasNext()) {
                    class_1293 class_12932 = (class_1293)a.next();
                    iterator = a;
                    a3.predict.method_6092(class_12932);
                }
            } else {
                a3.predict = a2;
            }
        }

    }

}
