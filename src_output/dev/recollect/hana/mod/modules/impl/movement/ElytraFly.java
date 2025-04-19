/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1313
 *  net.minecraft.class_1656
 *  net.minecraft.class_1770
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_634
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.TravelEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.Renderer;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1313;
import net.minecraft.class_1656;
import net.minecraft.class_1770;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2848;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_634;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class ElytraFly
extends Module {
    private final BooleanSetting sprint;
    public final SliderSetting speed;
    private final SliderSetting boost;
    private final BooleanSetting firework;
    private final BooleanSetting instantFly;
    public static ElytraFly INSTANCE;
    private final BooleanSetting boostTimer;
    private final SliderSetting sneakDownSpeed;
    public final SliderSetting maxSpeed;
    private final Timer instantFlyTimer;
    public final EnumSetting<Mode> mode;
    private boolean hasElytra;
    public final BooleanSetting noDrag;
    public final SliderSetting upPitch;
    public final SliderSetting downFactor;
    public final Timer fireworkTimer;
    private final SliderSetting pitch;
    private final SliderSetting timeout;
    private boolean hasTouchedGround;
    private final Timer strictTimer;
    public final BooleanSetting speedLimit;
    public final BooleanSetting autoJump;
    private final SliderSetting delay;
    public final SliderSetting upFactor;

    @Override
    public String getInfo() {
        return TipUtils.ALLATORIxDEMO("\r)\u0007:\u0013(\u0004");
    }

    private /* synthetic */ void setX(double a) {
        MovementUtil.setMotionX(a);
    }

    private /* synthetic */ void boost() {
        ElytraFly a2;
        ElytraFly elytraFly = a2;
        if (elytraFly.hasElytra) {
            if (!ElytraFly.mc.field_1724.method_6128()) {
                return;
            }
            float a2 = (float)Math.toRadians(ElytraFly.mc.field_1724.method_36454());
            if (ElytraFly.mc.field_1690.field_1894.method_1434()) {
                ElytraFly.mc.field_1724.method_5762((double)(-class_3532.method_15374((float)a2) * elytraFly.boost.getValueFloat() / 10.0f), 0.0, (double)(class_3532.method_15362((float)a2) * elytraFly.boost.getValueFloat() / 10.0f));
            }
        }
    }

    @Override
    public void onDisable() {
        Hana.TIMER.reset();
        a.hasElytra = false;
        if (ElytraFly.mc.field_1724 != null) {
            if (!ElytraFly.mc.field_1724.method_7337()) {
                ElytraFly.mc.field_1724.method_31549().field_7478 = false;
            }
            ElytraFly.mc.field_1724.method_31549().field_7479 = false;
        }
    }

    protected final class_243 getRotationVector(float f, float f2) {
        float a;
        float a2 = f;
        ElytraFly a3 = this;
        a = -a * 0.017453292f;
        float f3 = class_3532.method_15362((float)a);
        a = class_3532.method_15374((float)a);
        float f4 = class_3532.method_15362((float)(a2 *= 0.017453292f));
        a2 = class_3532.method_15374((float)a2);
        return new class_243((double)(a * f4), (double)(-a2), (double)(f3 * f4));
    }

    @Override
    public void onEnable() {
        if (ElytraFly.mc.field_1724 != null) {
            if (!ElytraFly.mc.field_1724.method_7337()) {
                ElytraFly.mc.field_1724.method_31549().field_7478 = false;
            }
            ElytraFly.mc.field_1724.method_31549().field_7479 = false;
        }
        a.hasElytra = false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onMove(TravelEvent a) {
        var2_2 = a;
        if (ElytraFly.nullCheck() != false) return;
        if (var2_2.hasElytra == false) return;
        if (!ElytraFly.mc.field_1724.method_6128()) {
            return;
        }
        v0 = var2_2;
        a = v0.getRotationVec(ElytraFly.mc.method_1488());
        var3_3 = Math.sqrt(a.field_1352 * a.field_1352 + a.field_1350 * a.field_1350);
        var5_4 = Math.sqrt(v0.getX() * var2_2.getX() + var2_2.getZ() * var2_2.getZ());
        if (ElytraFly.mc.field_1690.field_1832.method_1434()) {
            v1 = var2_2;
            v1.setY(-v1.sneakDownSpeed.getValue());
        } else if (!ElytraFly.mc.field_1724.field_3913.field_3904) {
            v2 = var2_2;
            v2.setY(-3.0E-14 * v2.downFactor.getValue());
        }
        if (!ElytraFly.mc.field_1724.field_3913.field_3904) ** GOTO lbl30
        if (var5_4 > var2_2.upFactor.getValue() / var2_2.upFactor.getMaximum()) {
            var7_5 = var5_4 * 0.01325;
            v3 = var3_3;
            v4 = var2_2;
            v4.setY(v4.getY() + var7_5 * 3.2);
            v4.setX(v4.getX() - a.field_1352 * var7_5 / var3_3);
            v4.setZ(v4.getZ() - a.field_1350 * var7_5 / var3_3);
        } else {
            v5 = var2_2;
            var7_6 = MovementUtil.directionSpeed(v5.speed.getValue());
            v5.setX(var7_6[0]);
            v5.setZ(var7_6[1]);
lbl30: // 2 sources:
            v3 = var3_3;
        }
        if (v3 > 0.0) {
            v6 = var2_2;
            v6.setX(v6.getX() + (a.field_1352 / var3_3 * var5_4 - var2_2.getX()) * 0.1);
            v6.setZ(v6.getZ() + (a.field_1350 / var3_3 * var5_4 - var2_2.getZ()) * 0.1);
        }
        if (!ElytraFly.mc.field_1724.field_3913.field_3904) {
            v7 = var2_2;
            var7_7 = MovementUtil.directionSpeed(v7.speed.getValue());
            v7.setX(var7_7[0]);
            v7.setZ(var7_7[1]);
        }
        if (!var2_2.noDrag.getValue()) {
            v8 = var2_2;
            v8.setY(v8.getY() * 0.9900000095367432);
            v8.setX(v8.getX() * 0.9800000190734863);
            v8.setZ(v8.getZ() * 0.9900000095367432);
        }
        v9 = var2_2;
        var7_5 = Math.sqrt(v9.getX() * var2_2.getX() + var2_2.getZ() * var2_2.getZ());
        if (v9.speedLimit.getValue() && var7_5 > var2_2.maxSpeed.getValue()) {
            v10 = var2_2;
            v11 = var2_2;
            v11.setX(v10.getX() * v11.maxSpeed.getValue() / var7_5);
            v10.setZ(v10.getZ() * var2_2.maxSpeed.getValue() / var7_5);
        }
        a.cancel();
        ElytraFly.mc.field_1724.method_5784(class_1313.field_6308, ElytraFly.mc.field_1724.method_18798());
    }

    public final class_243 getRotationVec(float f) {
        ElytraFly a;
        float a2 = f;
        ElytraFly elytraFly = a = this;
        return elytraFly.getRotationVector(-elytraFly.upPitch.getValueFloat(), ElytraFly.mc.field_1724.method_5705(a2));
    }

    private /* synthetic */ void setY(double a) {
        MovementUtil.setMotionY(a);
    }

    private /* synthetic */ void setZ(double a) {
        MovementUtil.setMotionZ(a);
    }

    public ElytraFly() {
        ElytraFly a;
        ElytraFly elytraFly = a;
        super(TipUtils.ALLATORIxDEMO("+*\u00105\u001c=5z@"), Module.Category.Movement);
        ElytraFly elytraFly2 = a;
        elytraFly2.mode = elytraFly.add(new EnumSetting<Mode>(Renderer.ALLATORIxDEMO("M\u0012.R"), Mode.Control));
        elytraFly.instantFly = elytraFly.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("\b\u00005\u001d \u0000(5z@"), true));
        elytraFly.upPitch = elytraFly.add(new SliderSetting(Renderer.ALLATORIxDEMO("2m0i\t)_"), 0.0, 0.0, 90.0));
        elytraFly.upFactor = elytraFly.add(new SliderSetting(TipUtils.ALLATORIxDEMO("\u0013\u0019\u0007\u000f?\u0007yK"), 1.0, 0.0, 10.0));
        elytraFly.downFactor = elytraFly.add(new SliderSetting(Renderer.ALLATORIxDEMO("Y\u000fm\t[\u0001c\t%E"), 1.0, 0.0, 10.0));
        elytraFly.speed = elytraFly.add(new SliderSetting(TipUtils.ALLATORIxDEMO(")4\u0000,=,\u0016s]"), 1.0, 0.10000000149011612, 10.0));
        elytraFly.sneakDownSpeed = elytraFly.add(new SliderSetting(Renderer.ALLATORIxDEMO("$u\u0010s3p\u0018/S"), 1.0, 0.10000000149011612, 10.0));
        elytraFly.boostTimer = elytraFly.add(new BooleanSetting(TipUtils.ALLATORIxDEMO(":5\u001esK"), true));
        elytraFly.speedLimit = elytraFly.add(new BooleanSetting(Renderer.ALLATORIxDEMO("N\u0010\u0002y,i\u0010#C"), true));
        elytraFly.maxSpeed = elytraFly.add(new SliderSetting(TipUtils.ALLATORIxDEMO("\u000b\b9=,\u0016s]"), 2.5, 0.10000000149011612, 10.0, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return a2.speedLimit.getValue();
        }));
        ElytraFly elytraFly3 = a;
        elytraFly3.noDrag = elytraFly3.add(new BooleanSetting(Renderer.ALLATORIxDEMO("S\u000fD\u000f+P"), false));
        elytraFly3.timeout = elytraFly3.add(new SliderSetting(TipUtils.ALLATORIxDEMO("=(\u00039\u001ccM"), 0.5, 0.10000000149011612, 1.0));
        elytraFly3.boost = elytraFly3.add(new SliderSetting(Renderer.ALLATORIxDEMO("\"o\u00129C"), 1.0, 0.10000000149011612, 4.0, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return a2.mode.getValue() == Mode.Boost;
        }));
        a.delay = a.add(new SliderSetting(TipUtils.ALLATORIxDEMO("*9\u001fw@"), 1000.0, 0.0, 20000.0, 50.0, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return !a2.mode.is(Mode.Bounce);
        }));
        a.pitch = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("0i\t)_"), 88.0, -90.0, 90.0, 0.1, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return a2.mode.is(Mode.Bounce);
        }));
        a.sprint = a.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("\u0012\u001e4\u0000/\u001a\f\u001fcJ"), true, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return a2.mode.is(Mode.Bounce);
        }));
        a.autoJump = a.add(new BooleanSetting(Renderer.ALLATORIxDEMO("[\u0012i\u000fJ\b'G"), true, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return a2.mode.is(Mode.Bounce);
        }));
        a.firework = a.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("\u0000\u00003\u000b+\u001cdR"), false, object -> {
            Object a = object;
            ElytraFly a2 = this;
            return !a2.mode.is(Mode.Bounce);
        }));
        ElytraFly elytraFly4 = a;
        ElytraFly elytraFly5 = a;
        elytraFly5.hasElytra = false;
        elytraFly5.instantFlyTimer = new Timer();
        elytraFly5.strictTimer = new Timer();
        elytraFly5.fireworkTimer = new Timer();
        elytraFly4.hasTouchedGround = false;
        elytraFly4.setChinese(Renderer.ALLATORIxDEMO("\u9798\u7fb8\u9894\u887b"));
        INSTANCE = elytraFly4;
    }

    @Override
    public void onUpdate() {
        ElytraFly elytraFly;
        ElytraFly elytraFly2;
        block9 : {
            Object a;
            elytraFly = a;
            if (ElytraFly.nullCheck()) {
                return;
            }
            if (ElytraFly.mc.field_1724.method_24828()) {
                elytraFly.hasTouchedGround = true;
            }
            Object object = a = ElytraFly.mc.field_1724.method_5661().iterator();
            while (object.hasNext()) {
                if (((class_1799)a.next()).method_7909() instanceof class_1770) {
                    elytraFly2 = elytraFly;
                    elytraFly.hasElytra = true;
                    break block9;
                }
                elytraFly.hasElytra = false;
                object = a;
            }
            elytraFly2 = elytraFly;
        }
        if (elytraFly2.strictTimer.passedMs(1500L) && !elytraFly.strictTimer.passedMs(2000L) || EntityUtil.isElytraFlying() && (double)Hana.TIMER.get() == 0.3) {
            Hana.TIMER.reset();
        }
        if (!ElytraFly.mc.field_1724.method_6128()) {
            if (elytraFly.hasTouchedGround && elytraFly.boostTimer.getValue() && !ElytraFly.mc.field_1724.method_24828()) {
                Hana.TIMER.set(0.3f);
            }
            if (!ElytraFly.mc.field_1724.method_24828() && elytraFly.instantFly.getValue() && ElytraFly.mc.field_1724.method_18798().method_10214() < 0.0) {
                if (!elytraFly.instantFlyTimer.passedMs((long)(1000.0 * elytraFly.timeout.getValue()))) {
                    return;
                }
                elytraFly.instantFlyTimer.reset();
                ElytraFly.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)ElytraFly.mc.field_1724, class_2848.class_2849.field_12982));
                elytraFly.hasTouchedGround = false;
                elytraFly.strictTimer.reset();
            }
        }
    }

    private /* synthetic */ double getY() {
        return MovementUtil.getMotionY();
    }

    private /* synthetic */ double getZ() {
        return MovementUtil.getMotionZ();
    }

    private /* synthetic */ double getX() {
        return MovementUtil.getMotionX();
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Freeze;
        public static final /* enum */ Mode Control;
        public static final /* enum */ Mode Boost;
        public static final /* enum */ Mode Bounce;
        public static final /* enum */ Mode None;
        private static final /* synthetic */ Mode[] $VALUES;

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[5];
            arrmode[0] = Control;
            arrmode[1] = Boost;
            arrmode[2] = Bounce;
            arrmode[3] = Freeze;
            arrmode[4] = None;
            return arrmode;
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
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

        static {
            Control = new Mode(TimerManager.ALLATORIxDEMO("\u000f\u0016%\u0010$Ap"), 0);
            Boost = new Mode(GaussianKernel.ALLATORIxDEMO("\u00026$+>"), 1);
            Bounce = new Mode(TimerManager.ALLATORIxDEMO(";$\u00118My"), 2);
            Freeze = new Mode(GaussianKernel.ALLATORIxDEMO("\u00142<.\"/"), 3);
            None = new Mode(TimerManager.ALLATORIxDEMO("*9@y"), 4);
            $VALUES = Mode.$values();
        }
    }

}
