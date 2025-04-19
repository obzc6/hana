/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1320
 *  net.minecraft.class_1429
 *  net.minecraft.class_1621
 *  net.minecraft.class_1646
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1829
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_5134
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.CircleUtil;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.asm.accessors.ILivingEntity;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Criticals;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.video.FileUtil;
import java.awt.Color;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1320;
import net.minecraft.class_1429;
import net.minecraft.class_1621;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1829;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_5134;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Aura
extends Module {
    private final EnumSetting<TargetESP> mode;
    public final BooleanSetting Villagers;
    private final ColorSetting color;
    private float lastPitch;
    private final EnumSetting<SwingSide> swingMode;
    int attackTicks;
    public class_243 directionVec;
    private final FadeUtils fadeOut;
    private double currentRotation;
    private float lastYaw;
    private final SliderSetting circleSize;
    private final BooleanSetting ghost;
    private final RadiusUtils radiusUtils;
    private final EnumSetting<TargetMode> targetMode;
    private final ColorSetting circleColor;
    public final BooleanSetting Animals;
    public boolean sweeping;
    private final SliderSetting wallRange;
    private final FadeUtils fadeIn;
    public final BooleanSetting Mobs;
    public static Aura INSTANCE;
    private final SliderSetting fov;
    private final FadeUtils rotationFade;
    private final BooleanSetting weaponOnly;
    private final BooleanSetting newRotate;
    public final BooleanSetting Slimes;
    public static class_1297 target;
    private final BooleanSetting xuanzhuan;
    private final SliderSetting cooldown;
    public final SliderSetting range;
    private final BooleanSetting whileEating;
    public final EnumSetting<Page> page;
    private final BooleanSetting checkLook;
    private final SliderSetting yawStep;
    public final BooleanSetting Players;
    private final Timer tick;
    private final Timer ghostTimer;
    private final BooleanSetting rotate;
    public final EnumSetting<Mode> drawMode;
    private final EnumSetting<Cooldown> cd;

    /*
     * Exception decompiling
     */
    public static void doRender(class_4587 var0, float var1_1, class_1297 var2_2, Color var3_3, TargetESP var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 1[CASE]
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
    public String getInfo() {
        if (target == null) {
            return null;
        }
        return target.method_5477().getString();
    }

    private /* synthetic */ class_1297 getTarget() {
        Aura a;
        Aura aura = a;
        Aura aura2 = null;
        double d = aura.range.getValue();
        double d2 = 36.0;
        Iterator iterator = Aura.mc.field_1687.method_18112().iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = (class_1297)iterator.next();
                if (!aura.isEnemy((class_1297)a)) {
                    iterator2 = iterator;
                    continue;
                }
                if (!Aura.mc.field_1724.method_6057((class_1297)a) && (double)Aura.mc.field_1724.method_5739((class_1297)a) > aura.wallRange.getValue()) {
                    iterator2 = iterator;
                    continue;
                }
                if (!CombatUtil.isValid((class_1297)a, aura.range.getValue())) {
                    iterator2 = iterator;
                    continue;
                }
                if (aura2 == null) {
                    aura2 = a;
                    d = Aura.mc.field_1724.method_5739((class_1297)a);
                    d2 = EntityUtil.getHealth((class_1297)a);
                    continue block0;
                }
                if (aura2 instanceof class_1657 && EntityUtil.isArmorLow((class_1657)a, 10)) {
                    aura2 = a;
                    return aura2;
                }
                if (aura.targetMode.getValue() == TargetMode.HEALTH && (double)EntityUtil.getHealth((class_1297)a) < d2) {
                    aura2 = a;
                    d2 = EntityUtil.getHealth((class_1297)aura2);
                    iterator2 = iterator;
                    continue;
                }
                if (aura.targetMode.getValue() != TargetMode.DISTANCE || !((double)Aura.mc.field_1724.method_5739((class_1297)a) < d)) continue block0;
                aura2 = a;
                d = Aura.mc.field_1724.method_5739((class_1297)a);
                continue block0;
            }
            break;
        } while (true);
        return aura2;
    }

    @Override
    public void onEnable() {
        Aura a;
        Aura aura = a;
        aura.radiusUtils.reset();
        aura.fadeIn.reset();
        a.rotationFade.reset();
        a.currentRotation = 0.0;
    }

    public boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.newRotate.getValue()) {
            EntityUtil.faceVectorNoStay((class_243)a);
            return true;
        }
        a2.directionVec = a;
        a = EntityUtil.getLegitRotations((class_243)a);
        if (Math.abs(class_3532.method_15393((float)(arrf[0] - a2.lastYaw))) < a2.fov.getValueFloat() && Math.abs(class_3532.method_15393((float)(a[1] - a2.lastPitch))) < a2.fov.getValueFloat()) {
            EntityUtil.sendYawAndPitch(a[0], a[true]);
            return true;
        }
        return !a2.checkLook.getValue();
    }

    private /* synthetic */ boolean isEnemy(class_1297 class_12972) {
        Aura a = class_12972;
        Aura a2 = this;
        if (a instanceof class_1621 && a2.Slimes.getValue()) {
            return true;
        }
        if (a instanceof class_1657 && a2.Players.getValue()) {
            return true;
        }
        if (a instanceof class_1646 && a2.Villagers.getValue()) {
            return true;
        }
        if (!(a instanceof class_1646) && a instanceof class_1308 && a2.Mobs.getValue()) {
            return true;
        }
        return a instanceof class_1429 && a2.Animals.getValue();
    }

    @Override
    public void onDisable() {
        Aura a;
        a.fadeOut.reset();
    }

    public Aura() {
        Aura a;
        Aura aura = a;
        super(FadeUtils.ALLATORIxDEMO(" S\u0000Q0UI\u000b"), Start.ALLATORIxDEMO("KEk\n&oY\u0010n[x]o\u000b$\fkE%^cUv\u000e&"), Module.Category.Combat);
        Aura aura2 = a;
        aura2.page = aura.add(new EnumSetting<Page>(FadeUtils.ALLATORIxDEMO("!A\\\u000f"), Page.General));
        aura.range = aura.add(new SliderSetting(Start.ALLATORIxDEMO("PPq\u001c0"), 6.0, 0.10000000149011612, 7.0, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.ghost = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("7B\\\r\u001cT\u0005].D\u0001AH\u0019"), false, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        Aura aura3 = a;
        aura3.cd = aura3.add(new EnumSetting<Cooldown>(Start.ALLATORIxDEMO(":8CnOj[l|p\u001f0"), Cooldown.Delay));
        aura3.cooldown = aura3.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("(U\u0003Q\u0015OL\u0004"), 1.100000023841858, 0.0, 1.2000000476837158, 0.01, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.wallRange = a.add(new SliderSetting(Start.ALLATORIxDEMO("UJi@PPq\u001c0"), 6.0, 0.10000000149011612, 7.0, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.whileEating = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO(";U\u0002V\th\u0002IU\r"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.weaponOnly = a.add(new BooleanSetting(Start.ALLATORIxDEMO("{gJuCl~q\u0017,"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(FadeUtils.ALLATORIxDEMO("n\u0006IU\r"), SwingSide.Server, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(Start.ALLATORIxDEMO("~mE~\u000f0"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("s\u000eM>R\u0005AO\u000f"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(Start.ALLATORIxDEMO("\\Mubk\u001e%"), 0.30000001192092896, 0.10000000149011612, 1.0, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("~\u0003_\u000fV=OT\u0001"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(Start.ALLATORIxDEMO("Y\u0014#"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.targetMode = a.add(new EnumSetting<TargetMode>(FadeUtils.ALLATORIxDEMO("*T\u001dT^\u0018"), TargetMode.DISTANCE, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Players = a.add(new BooleanSetting(Start.ALLATORIxDEMO("U@cHz\t&"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Mobs = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("<OY\u0019"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Animals = a.add(new BooleanSetting(Start.ALLATORIxDEMO("DBk\\~\u0017&"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Villagers = a.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("k\u0002V\u0000\\\u0016EI\u0019"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Slimes = a.add(new BooleanSetting(Start.ALLATORIxDEMO("nXr\u001e&"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.mode = a.add(new EnumSetting<TargetESP>(FadeUtils.ALLATORIxDEMO("i\nH\u000bX\u0005eh:"), TargetESP.Jello, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(Start.ALLATORIxDEMO("\u0003MpL`XA^s\u0014'"), new Color(255, 255, 255, 250), object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.circleSize = a.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("+\u0005O\bV\t\u001d\"IA\u000f"), 1.0, 0.5, 6.0, 0.1, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.circleColor = a.add(new ColorSetting(Start.ALLATORIxDEMO(":>^aG`\fA^s\u0014'"), new Color(255, 0, 0, 255), object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.drawMode = a.add(new EnumSetting<Mode>(FadeUtils.ALLATORIxDEMO("<O_\u000f"), Mode.Star, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.xuanzhuan = a.add(new BooleanSetting(Start.ALLATORIxDEMO("+8Xc_`okC|\u00170"), true, object -> {
            Object a = object;
            Aura a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        Aura aura4 = a;
        Aura aura5 = a;
        Aura aura6 = a;
        Aura aura7 = a;
        Aura aura8 = a;
        a.radiusUtils = new RadiusUtils(a.circleSize.getValue(), 1000L);
        aura8.fadeIn = new FadeUtils(1000L);
        aura8.fadeOut = new FadeUtils(1000L);
        aura8.rotationFade = new FadeUtils(1000L);
        aura7.currentRotation = 180.0;
        aura6.directionVec = null;
        aura7.ghostTimer = new Timer();
        aura6.tick = new Timer();
        aura5.lastYaw = 0.0f;
        aura5.lastPitch = 0.0f;
        aura4.sweeping = false;
        aura4.setChinese(FadeUtils.ALLATORIxDEMO("\u6731\u620e\u5172\u73c5"));
        INSTANCE = aura4;
    }

    private /* synthetic */ boolean check() {
        Aura a22;
        Aura aura;
        Aura aura2 = aura = a22;
        int a22 = aura2.attackTicks;
        if (aura2.cd.getValue() == Cooldown.Vanilla) {
            a22 = ((ILivingEntity)Aura.mc.field_1724).getLastAttackedTicks();
        }
        if (!((double)Math.max((float)a22 / Aura.getAttackCooldownProgressPerTick(), 0.0f) >= aura.cooldown.getValue())) {
            return false;
        }
        if (aura.ghost.getValue()) {
            if (!aura.ghostTimer.passedMs(600L)) {
                return false;
            }
            if (InventoryUtil.findClassInventorySlot(class_1829.class) == -1) {
                return false;
            }
        }
        return aura.whileEating.getValue() || !Aura.mc.field_1724.method_6115();
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        Aura a3 = this;
        if (a2 < 0.1f) {
            a2 = 0.1f;
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

    @EventHandler(priority=98)
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (target != null && arrf.newRotate.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.yawStep.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            RotateEvent rotateEvent = a;
            rotateEvent.setYaw(arrf.lastYaw);
            rotateEvent.setPitch(arrf.lastPitch);
            return;
        }
        float[] arrf3 = arrf;
        arrf3.lastYaw = Hana.ROTATE.lastYaw;
        arrf3.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ void doAura() {
        Aura a22;
        Aura aura = a22;
        if (!aura.check()) {
            return;
        }
        if (aura.rotate.getValue() && !aura.faceVector(target.method_19538().method_1031(0.0, 1.5, 0.0))) {
            return;
        }
        int a22 = InventoryUtil.findItemInventorySlot(class_1802.field_22022);
        if (aura.ghost.getValue()) {
            aura.sweeping = true;
            InventoryUtil.inventorySwap(a22, Aura.mc.field_1724.method_31548().field_7545);
        }
        Aura aura2 = aura;
        aura2.ghostTimer.reset();
        if (!aura2.ghost.getValue() && Criticals.INSTANCE.isOn()) {
            Criticals.INSTANCE.doCrit();
        }
        Aura.mc.field_1761.method_2918((class_1657)Aura.mc.field_1724, target);
        EntityUtil.swingHand(class_1268.field_5808, aura.swingMode.getValue());
        if (aura.ghost.getValue()) {
            InventoryUtil.inventorySwap(a22, Aura.mc.field_1724.method_31548().field_7545);
            aura.sweeping = false;
        }
        aura.attackTicks = 0;
    }

    public static float getAttackCooldownProgressPerTick() {
        return (float)(1.0 / Aura.mc.field_1724.method_26825(class_5134.field_23723) * 20.0);
    }

    @Override
    public void onUpdate() {
        Aura a;
        if (a.tick.passed(50L)) {
            Aura aura = a;
            ++aura.attackTicks;
            aura.tick.reset();
        }
        if (a.weaponOnly.getValue() && !EntityUtil.isHoldingWeapon((class_1657)Aura.mc.field_1724)) {
            target = null;
            return;
        }
        target = a.getTarget();
        if (target == null) {
            return;
        }
        if (a.check()) {
            a.doAura();
        }
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        Object a3;
        Aura aura = a3;
        if (aura.tick.passed(50L)) {
            Aura aura2 = aura;
            ++aura2.attackTicks;
            aura2.tick.reset();
        }
        if (target != null) {
            Aura.doRender(a, a22, target, aura.color.getValue(), aura.mode.getValue());
        }
        class_310 a22 = class_310.method_1551();
        if (a22.field_1724 == null) {
            return;
        }
        a22 = a22.field_1724;
        Aura aura3 = aura;
        a3 = aura3.circleColor.getValue();
        if (aura3.circleSize.getValue() != aura.radiusUtils.getTargetRadius()) {
            Aura aura4 = aura;
            aura4.radiusUtils.setTargetRadius(aura4.circleSize.getValue());
        }
        double d = aura.isOn() ? aura.fadeIn.ease(FadeUtils.Ease.In) : aura.fadeOut.ease(FadeUtils.Ease.Out);
        int n = (int)((double)((Color)a3).getAlpha() * d);
        a3 = new Color(((Color)a3).getRed(), ((Color)a3).getGreen(), ((Color)a3).getBlue(), n);
        Aura aura5 = aura;
        float f = (float)aura5.radiusUtils.getCurrentRadius();
        if (aura5.xuanzhuan.getValue()) {
            Aura aura6 = aura;
            aura6.currentRotation += aura.rotationFade.ease(FadeUtils.Ease.Out) * 360.0;
            if (aura6.rotationFade.isEnd()) {
                aura.currentRotation = (aura.currentRotation % 360.0 + 360.0) % 360.0;
            }
        }
        CircleUtil.drawCircle2D(a, (class_1297)a22, (Color)a3, f, aura.currentRotation);
        if (aura.drawMode.getValue() == Mode.Circle) {
            CircleUtil.drawCircle(a, (class_1297)a22, (Color)a3, f, aura.currentRotation);
        }
        if (aura.drawMode.getValue() == Mode.Circle2D) {
            CircleUtil.drawCircle2D(a, (class_1297)a22, (Color)a3, f, aura.currentRotation);
        }
        if (aura.drawMode.getValue() == Mode.Star) {
            float f2 = f;
            CircleUtil.drawStar2D(a, (class_1297)a22, (Color)a3, f2, f2, aura.currentRotation);
        }
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Target;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Render;
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page General;

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        static {
            General = new Page(OLEPOSSUtils.ALLATORIxDEMO("j0D-Ec\u0011"), 0);
            Rotate = new Page(BOEntityUtils.ALLATORIxDEMO("@Q`Yb_"), 1);
            Target = new Page(OLEPOSSUtils.ALLATORIxDEMO("\u0001K:Pg\t"), 2);
            Render = new Page(BOEntityUtils.ALLATORIxDEMO("@[z\\sH"), 3);
            $VALUES = Page.$values();
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

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[4];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            arrpage[2] = Target;
            arrpage[3] = Render;
            return arrpage;
        }
    }

    public static final class Cooldown
    extends Enum<Cooldown> {
        public static final /* enum */ Cooldown Delay;
        public static final /* enum */ Cooldown Vanilla;
        private static final /* synthetic */ Cooldown[] $VALUES;

        public static Cooldown valueOf(String a) {
            return Enum.valueOf(Cooldown.class, a);
        }

        static {
            Vanilla = new Cooldown(WebUtils.ALLATORIxDEMO("K2t'kh,"), 0);
            Delay = new Cooldown(FileUtil.ALLATORIxDEMO("1g\u0001z\r"), 1);
            $VALUES = Cooldown.$values();
        }

        public static Cooldown[] values() {
            return (Cooldown[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Cooldown() {
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

        private static /* synthetic */ Cooldown[] $values() {
            Cooldown[] arrcooldown = new Cooldown[2];
            arrcooldown[0] = Vanilla;
            arrcooldown[1] = Delay;
            return arrcooldown;
        }
    }

    private static final class TargetMode
    extends Enum<TargetMode> {
        private static final /* synthetic */ TargetMode[] $VALUES;
        public static final /* enum */ TargetMode HEALTH;
        public static final /* enum */ TargetMode DISTANCE;

        /*
         * Exception decompiling
         */
        private /* synthetic */ TargetMode() {
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

        public static TargetMode[] values() {
            return (TargetMode[])$VALUES.clone();
        }

        static {
            DISTANCE = new TargetMode(CameraState.ALLATORIxDEMO("5T\u0000k\u0019z\u001ap"), 0);
            HEALTH = new TargetMode(CrystalUtil.ALLATORIxDEMO("c\u001ea\u001cu\u0019"), 1);
            $VALUES = TargetMode.$values();
        }

        private static /* synthetic */ TargetMode[] $values() {
            TargetMode[] arrtargetMode = new TargetMode[2];
            arrtargetMode[0] = DISTANCE;
            arrtargetMode[1] = HEALTH;
            return arrtargetMode;
        }

        public static TargetMode valueOf(String a) {
            return Enum.valueOf(TargetMode.class, a);
        }
    }

    public static final class TargetESP
    extends Enum<TargetESP> {
        public static final /* enum */ TargetESP Box = new TargetESP(CrystalUtil.ALLATORIxDEMO("%{\u001c"), 0);
        private static final /* synthetic */ TargetESP[] $VALUES;
        public static final /* enum */ TargetESP Jello = new TargetESP(Timer.ALLATORIxDEMO("~AE\u0002\f"), 1);
        public static final /* enum */ TargetESP None = new TargetESP(CrystalUtil.ALLATORIxDEMO("Y\bz\u0001"), 2);

        public static TargetESP valueOf(String a) {
            return Enum.valueOf(TargetESP.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ TargetESP() {
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

        private static /* synthetic */ TargetESP[] $values() {
            TargetESP[] arrtargetESP = new TargetESP[3];
            arrtargetESP[0] = Box;
            arrtargetESP[1] = Jello;
            arrtargetESP[2] = None;
            return arrtargetESP;
        }

        static {
            $VALUES = TargetESP.$values();
        }

        public static TargetESP[] values() {
            return (TargetESP[])$VALUES.clone();
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Star = new Mode(MathUtil.ALLATORIxDEMO("6\r\u0005\n"), 0);
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Circle2D = new Mode(ColorUtil.ALLATORIxDEMO("\u0019u/x,c8\b"), 1);
        public static final /* enum */ Mode Circle = new Mode(MathUtil.ALLATORIxDEMO("-\u001b\u0017\u001a\b\u001d"), 2);

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
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

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = Star;
            arrmode[1] = Circle2D;
            arrmode[2] = Circle;
            return arrmode;
        }

        static {
            $VALUES = Mode.$values();
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }
    }

}
