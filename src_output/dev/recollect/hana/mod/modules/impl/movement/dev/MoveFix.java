/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.JumpEvent;
import dev.recollect.hana.api.events.impl.KeyboardInputEvent;
import dev.recollect.hana.api.events.impl.TravelEvent;
import dev.recollect.hana.api.events.impl.UpdateVelocityEvent;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import dev.recollect.hana.mod.modules.impl.render.FreeCam;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.user.User;
import java.util.function.Predicate;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class MoveFix
extends Module {
    public static float fixPitch;
    public EnumSetting<UpdateMode> updateMode;
    private float prevYaw;
    public static float fixRotation;
    private float prevPitch;
    private final BooleanSetting travel;
    public static MoveFix INSTANCE;
    public final BooleanSetting grim;

    @EventHandler
    public void onPlayerMove(UpdateVelocityEvent updateVelocityEvent) {
        UpdateVelocityEvent a = updateVelocityEvent;
        MoveFix a2 = this;
        if (!a2.grim.getValue() || a2.travel.getValue()) {
            return;
        }
        if (MoveFix.mc.field_1724.method_3144()) {
            return;
        }
        Object object = a;
        ((Event)object).cancel();
        ((UpdateVelocityEvent)object).setVelocity(MoveFix.movementInputToVelocity(((UpdateVelocityEvent)object).getMovementInput(), a.getSpeed(), fixRotation));
    }

    @EventHandler
    public void onJump(JumpEvent jumpEvent) {
        JumpEvent a = jumpEvent;
        MoveFix a2 = this;
        if (!a2.grim.getValue()) {
            return;
        }
        if (MoveFix.mc.field_1724.method_3144()) {
            return;
        }
        if (a.isPre()) {
            MoveFix moveFix = a2;
            moveFix.prevYaw = MoveFix.mc.field_1724.method_36454();
            moveFix.prevPitch = MoveFix.mc.field_1724.method_36455();
            MoveFix.mc.field_1724.method_36456(fixRotation);
            MoveFix.mc.field_1724.method_36457(fixPitch);
            return;
        }
        MoveFix.mc.field_1724.method_36456(a2.prevYaw);
        MoveFix.mc.field_1724.method_36457(a2.prevPitch);
    }

    public MoveFix() {
        MoveFix a;
        MoveFix moveFix = a;
        super(MathUtil.ALLATORIxDEMO("5(-\r2\u0010\u001d"), Module.Category.Movement);
        MoveFix moveFix2 = a;
        moveFix2.updateMode = moveFix.add(new EnumSetting<UpdateMode>(CrystalUtil.ALLATORIxDEMO("g2E0v\u0017`2X)"), UpdateMode.UpdateMouse));
        moveFix.grim = moveFix.add(new BooleanSetting(MathUtil.ALLATORIxDEMO("/\u0006\u0010\b"), true)).setParent();
        moveFix.travel = moveFix.add(new BooleanSetting(CrystalUtil.ALLATORIxDEMO("V\u0000L+Y "), false, a.grim::isOpen));
        MoveFix moveFix3 = a;
        moveFix3.setChinese(MathUtil.ALLATORIxDEMO("\u7993\u52dc\u4f97\u5968"));
        INSTANCE = moveFix3;
    }

    @EventHandler(priority=-999)
    public void onKeyInput(KeyboardInputEvent a3) {
        MoveFix a22;
        MoveFix moveFix = a22;
        if (!moveFix.grim.getValue()) {
            return;
        }
        if (HoleSnap.INSTANCE.isOn()) {
            return;
        }
        if (MoveFix.mc.field_1724.method_3144() || FreeCam.INSTANCE.isOn()) {
            return;
        }
        float a3 = MoveFix.mc.field_1724.field_3913.field_3905;
        float f = MoveFix.mc.field_1724.field_3913.field_3907;
        float a22 = (MoveFix.mc.field_1724.method_36454() - fixRotation) * 0.017453292f;
        float f2 = class_3532.method_15362((float)a22);
        a22 = class_3532.method_15374((float)a22);
        MoveFix.mc.field_1724.field_3913.field_3907 = Math.round(f * f2 - a3 * a22);
        MoveFix.mc.field_1724.field_3913.field_3905 = Math.round(a3 * f2 + f * a22);
    }

    private static /* synthetic */ class_243 movementInputToVelocity(class_243 class_2432, float f, float f2) {
        double d;
        float a;
        class_243 class_2433;
        float f3;
        float a22 = f;
        class_243 a3 = class_2432;
        double d2 = a3.method_1027();
        if (d < 1.0E-7) {
            return class_243.field_1353;
        }
        if (d2 > 1.0) {
            class_2433 = a3.method_1029();
            f3 = a22;
        } else {
            class_2433 = a3;
            f3 = a22;
        }
        class_243 a22 = class_2433.method_1021((double)f3);
        float f4 = class_3532.method_15374((float)(a * 0.017453292f));
        a = class_3532.method_15362((float)(a * 0.017453292f));
        return new class_243(a22.field_1352 * (double)a - a22.field_1350 * (double)f4, a22.field_1351, a22.field_1350 * (double)a + a22.field_1352 * (double)f4);
    }

    @EventHandler
    public void travel(TravelEvent travelEvent) {
        TravelEvent a = travelEvent;
        MoveFix a2 = this;
        if (!a2.grim.getValue() || !a2.travel.getValue()) {
            return;
        }
        if (MoveFix.mc.field_1724.method_3144()) {
            return;
        }
        if (a.isPre()) {
            MoveFix moveFix = a2;
            moveFix.prevYaw = MoveFix.mc.field_1724.method_36454();
            moveFix.prevPitch = MoveFix.mc.field_1724.method_36455();
            MoveFix.mc.field_1724.method_36456(fixRotation);
            MoveFix.mc.field_1724.method_36457(fixPitch);
            return;
        }
        MoveFix.mc.field_1724.method_36456(a2.prevYaw);
        MoveFix.mc.field_1724.method_36457(a2.prevPitch);
    }

    public static final class UpdateMode
    extends Enum<UpdateMode> {
        private static final /* synthetic */ UpdateMode[] $VALUES;
        public static final /* enum */ UpdateMode UpdateMouse;
        public static final /* enum */ UpdateMode MovementPacket;
        public static final /* enum */ UpdateMode All;

        /*
         * Exception decompiling
         */
        private /* synthetic */ UpdateMode() {
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

        public static UpdateMode valueOf(String a) {
            return Enum.valueOf(UpdateMode.class, a);
        }

        public static UpdateMode[] values() {
            return (UpdateMode[])$VALUES.clone();
        }

        static {
            MovementPacket = new UpdateMode(User.ALLATORIxDEMO("c]MBGSljp]H\\OB"), 0);
            UpdateMouse = new UpdateMode(ProjectionUtils.ALLATORIxDEMO("#Q\u0003h;N O\u0013R\u0002"), 1);
            All = new UpdateMode(User.ALLATORIxDEMO("vFZ"), 2);
            $VALUES = UpdateMode.$values();
        }

        private static /* synthetic */ UpdateMode[] $values() {
            UpdateMode[] arrupdateMode = new UpdateMode[3];
            arrupdateMode[0] = MovementPacket;
            arrupdateMode[1] = UpdateMouse;
            arrupdateMode[2] = All;
            return arrupdateMode;
        }
    }

}
