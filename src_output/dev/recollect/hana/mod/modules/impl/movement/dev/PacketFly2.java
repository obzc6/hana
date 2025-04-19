/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ConcurrentSet
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2793
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_310
 *  net.minecraft.class_434
 *  net.minecraft.class_437
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import io.netty.util.internal.ConcurrentSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2793;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import net.minecraft.class_310;
import net.minecraft.class_434;
import net.minecraft.class_437;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class PacketFly2
extends Module {
    public final EnumSetting<Type> type;
    public final BooleanSetting xzJitter;
    public int zoomTimer;
    public final BooleanSetting zeroY;
    public final Map<Integer, TimeVec> posLooks;
    public final SliderSetting conceal;
    public final EnumSetting<Mode> mode;
    public final BooleanSetting zeroTeleport;
    public final Set<class_2596<?>> playerPackets;
    public final SliderSetting sendTeleport;
    public float lastFactor;
    public final SliderSetting ySpeed;
    public final BooleanSetting yJitter;
    public final SliderSetting factor;
    public final SliderSetting xzSpeed;
    public final EnumSetting<Phase> phase;
    public class_243 vecDelServer;
    public final BooleanSetting zeroSpeed;
    public final BooleanSetting elytra;
    public final BooleanSetting antiKick;
    public final AtomicInteger teleportID;
    public final SliderSetting zoomer;
    public final SliderSetting invalids;
    public final SliderSetting invalidY;
    public final BooleanSetting bbOffset;
    public final SliderSetting concealY;
    public final BooleanSetting noRotation;
    public boolean zoomies;
    public final BooleanSetting noMovePacket;
    public int packetCounter;

    /*
     * WARNING - void declaration
     */
    public void sendPackets(double d, double d2, double d3, boolean bl) {
        void a;
        void a2;
        void a222;
        void a3;
        PacketFly2 packetFly2 = this;
        class_243 a222 = new class_243((double)a222, (double)a2, (double)a3);
        PacketFly2 a4 = PacketFly2.mc.field_1724.method_19538().method_1019(a222);
        packetFly2.vecDelServer = a4;
        class_243 class_2432 = packetFly2.type.getValue().createOutOfBounds((class_243)a4, packetFly2.invalidY.getValueInt());
        packetFly2.sendCPacket((class_2596<?>)new class_2828.class_2829(((class_243)a4).field_1352, ((class_243)a4).field_1351, ((class_243)a4).field_1350, PacketFly2.mc.field_1724.method_24828()));
        if (!mc.method_1542()) {
            int n = a2 = 0;
            while ((double)n < packetFly2.invalids.getValue()) {
                PacketFly2 packetFly22 = packetFly2;
                packetFly22.sendCPacket((class_2596<?>)new class_2828.class_2829(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, PacketFly2.mc.field_1724.method_24828()));
                class_2432 = packetFly22.type.getValue().createOutOfBounds(class_2432, packetFly2.invalidY.getValueInt());
                n = ++a2;
            }
        }
        if (a != false && (packetFly2.zeroTeleport.getValue() || packetFly2.teleportID.get() != 0)) {
            int n = a2 = 0;
            while ((double)n < packetFly2.sendTeleport.getValue()) {
                packetFly2.sendConfirmTeleport((class_243)a4);
                n = ++a2;
            }
        }
        if (packetFly2.elytra.getValue()) {
            mc.method_1562().method_52787((class_2596)new class_2848((class_1297)PacketFly2.mc.field_1724, class_2848.class_2849.field_12982));
        }
    }

    @Override
    public void onEnable() {
        PacketFly2 a;
        a.clearValues();
        if (PacketFly2.mc.field_1724 == null) {
            a.disable();
        }
    }

    @EventHandler
    public void invoke(MoveEvent moveEvent) {
        MoveEvent a = moveEvent;
        PacketFly2 a2 = this;
        if (a2.phase.getValue() == Phase.Semi || a2.isPlayerCollisionBoundingBoxEmpty()) {
            PacketFly2.mc.field_1724.field_5960 = true;
        }
        if (a2.mode.getValue() != Mode.Compatibility && (a2.mode.getValue() == Mode.Setback || a2.teleportID.get() != 0)) {
            PacketFly2 packetFly2;
            if (a2.zeroSpeed.getValue()) {
                packetFly2 = a2;
                Object object = a;
                a.setX(0.0);
                ((MoveEvent)object).setY(0.0);
                ((MoveEvent)object).setZ(0.0);
            } else {
                Object object = a;
                ((MoveEvent)object).setX(MovementUtil.getMotionX());
                ((MoveEvent)object).setY(MovementUtil.getMotionY());
                ((MoveEvent)object).setZ(MovementUtil.getMotionZ());
                packetFly2 = a2;
            }
            if (packetFly2.zeroY.getValue()) {
                a.setY(0.0);
            }
        }
    }

    public void sendCPacket(class_2596<?> class_25962) {
        class_2596<?> a = class_25962;
        class_2596<?> a2 = this;
        a2.playerPackets.add(a);
        mc.method_1562().method_52787(a);
    }

    public void clearValues() {
        PacketFly2 a;
        PacketFly2 packetFly2 = a;
        a.lastFactor = 1.0f;
        a.packetCounter = 0;
        a.teleportID.set(0);
        packetFly2.playerPackets.clear();
        packetFly2.posLooks.clear();
        packetFly2.vecDelServer = null;
    }

    public PacketFly2() {
        PacketFly2 a;
        PacketFly2 packetFly2 = a;
        super(GaussianKernel.ALLATORIxDEMO("\u0017(1/'\u000b\u001a\n:&0\u0010cd"), Module.Category.Movement);
        PacketFly2 packetFly22 = a;
        packetFly22.mode = packetFly2.add(new EnumSetting<Mode>(BaseChildSettings.ALLATORIxDEMO("w!\u0014a"), Mode.Factor));
        packetFly2.factor = packetFly2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0017\"'\"`o"), 1.0, 0.0, 10.0));
        packetFly2.phase = packetFly2.add(new EnumSetting<Phase>(BaseChildSettings.ALLATORIxDEMO("\u0003R/\u0003a"), Phase.Full));
        packetFly2.type = packetFly2.add(new EnumSetting<Type>(GaussianKernel.ALLATORIxDEMO("\u0010/x"), Type.Up));
        packetFly2.antiKick = packetFly2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("a:S:q'\u0013o"), true));
        packetFly2.noRotation = packetFly2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u00074)\u0006%\"0?`s"), false));
        packetFly2.noMovePacket = packetFly2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("<ij<V1w2Y%\u0015p"), false));
        packetFly2.bbOffset = packetFly2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u00199D\u001e%\"%ji"), false));
        packetFly2.invalidY = packetFly2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("5f\u0004gK:Dyh5\\=\u0015p"), 1337, 0, 1337));
        packetFly2.invalids = packetFly2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("2\u0007'\"(?kn"), 1, 0, 10));
        packetFly2.sendTeleport = packetFly2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("t1K6J!\u0002p"), 1, 0, 10));
        packetFly2.concealY = packetFly2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0015\"D"), 0.0, -256.0, 256.0));
        packetFly2.conceal = packetFly2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("1+j&L N#V'\u0015v"), 1.0, 0.0, 2.0));
        packetFly2.ySpeed = packetFly2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0001g\u0004.\u0017\u001d83(?jo"), 1.0, 0.0, 2.0));
        packetFly2.xzSpeed = packetFly2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("$'(+j&L N#V'\u0015v"), 1.0, 0.0, 2.0));
        packetFly2.elytra = packetFly2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0014/=\"}|"), false));
        packetFly2.xzJitter = packetFly2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u0019I S6Hc(^"), false));
        packetFly2.yJitter = packetFly2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("1\u0000%7!$\"D"), false));
        packetFly2.zeroSpeed = packetFly2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("}6R;\n\u0000J+\u0015`"), false));
        packetFly2.zeroY = packetFly2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u000b&69\"D"), false));
        packetFly2.zeroTeleport = packetFly2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("R\u0017tH~t1K6J!\u0002p"), true));
        packetFly2.zoomer = packetFly2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("3>,)?jn"), 3, 0, 10));
        packetFly2.posLooks = new ConcurrentHashMap<Integer, TimeVec>();
        packetFly2.playerPackets = new ConcurrentSet();
        packetFly2.teleportID = new AtomicInteger();
        a.zoomTimer = 0;
        a.setChinese(BaseChildSettings.ALLATORIxDEMO("\u5931\u664c\u4e80\u539f\u5375\u98da"));
    }

    @Override
    public void onUpdate() {
        PacketFly2 a2;
        a2.posLooks.entrySet().removeIf(a -> System.currentTimeMillis() - ((TimeVec)((Object)((Object)a.getValue()))).getTime() > TimeUnit.SECONDS.toMillis(30L));
    }

    public void sendConfirmTeleport(class_243 a) {
        PacketFly2 a22;
        PacketFly2 packetFly2;
        PacketFly2 packetFly22 = packetFly2 = a22;
        int a22 = packetFly22.teleportID.incrementAndGet();
        mc.method_1562().method_52787((class_2596)new class_2793(a22));
        packetFly22.posLooks.put(a22, new TimeVec(a));
    }

    @EventHandler
    public void invoke(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a222 = updateWalkingEvent;
        PacketFly2 a = this;
        if (a222.isPre() && a.mode.getValue() != Mode.Compatibility) {
            double d;
            int n;
            PacketFly2 packetFly2;
            MovementUtil.setMotionX(0.0);
            MovementUtil.setMotionY(0.0);
            MovementUtil.setMotionZ(0.0);
            if (a.mode.getValue() != Mode.Setback && a.teleportID.get() == 0) {
                if (a.checkPackets(6)) {
                    a.sendPackets(0.0, 0.0, 0.0, true);
                }
                return;
            }
            boolean a222 = a.isPlayerCollisionBoundingBoxEmpty();
            if (PacketFly2.mc.field_1724.field_3913.field_3904 && (a222 || !MovementUtil.isMoving())) {
                if (a.antiKick.getValue() && !a222) {
                    PacketFly2 packetFly22 = a;
                    d = packetFly22.checkPackets(packetFly22.mode.getValue() == Mode.Setback ? 10 : 20) ? -0.032 : 0.062;
                    packetFly2 = a;
                } else {
                    d = a.yJitter.getValue() && a.zoomies ? 0.061 : 0.062;
                    packetFly2 = a;
                }
            } else if (PacketFly2.mc.field_1724.field_3913.field_3903) {
                d = a.yJitter.getValue() && a.zoomies ? -0.061 : -0.062;
                packetFly2 = a;
            } else {
                d = !a222 ? (a.checkPackets(4) ? (a.antiKick.getValue() ? -0.04 : 0.0) : 0.0) : 0.0;
                packetFly2 = a;
            }
            if (packetFly2.phase.getValue() == Phase.Full && a222 && MovementUtil.isMoving() && d != 0.0) {
                d /= 2.5;
            }
            double d2 = a.xzJitter.getValue() && a.zoomies ? 0.25 : 0.26;
            double d3 = a.xzJitter.getValue() && a.zoomies ? 0.03 : 0.031;
            double[] a222 = MovementUtil.directionSpeed(a.phase.getValue() == Phase.Full && a222 ? d3 : d2);
            if (a.mode.getValue() == Mode.Increment) {
                if ((double)a.lastFactor >= a.factor.getValue()) {
                    a.lastFactor = 1.0f;
                } else {
                    float f;
                    a.lastFactor += 1.0f;
                    if ((double)f > a.factor.getValue()) {
                        a.lastFactor = a.factor.getValueFloat();
                    }
                }
            } else {
                a.lastFactor = a.factor.getValueFloat();
            }
            int n2 = n = 1;
            do {
                float f = a.mode.getValue() == Mode.Factor || a.mode.getValue() == Mode.Slow || a.mode.getValue() == Mode.Increment ? a.lastFactor : 1.0f;
                if (!((float)n2 <= f)) break;
                d2 = PacketFly2.mc.field_1724.method_23318() < a.concealY.getValue() && MovementUtil.isMoving() ? a.conceal.getValue() : 1.0;
                double[] arrd = a222;
                MovementUtil.setMotionX(arrd[0] * (double)n * d2 * a.xzSpeed.getValue());
                MovementUtil.setMotionY(d * (double)n * a.ySpeed.getValue());
                PacketFly2 packetFly23 = a;
                MovementUtil.setMotionZ(arrd[1] * (double)n * d2 * packetFly23.xzSpeed.getValue());
                packetFly23.sendPackets(MovementUtil.getMotionX(), MovementUtil.getMotionY(), MovementUtil.getMotionZ(), a.mode.getValue() != Mode.Setback);
                n2 = ++n;
            } while (true);
            PacketFly2 packetFly24 = a;
            ++packetFly24.zoomTimer;
            if ((double)packetFly24.zoomTimer > a.zoomer.getValue()) {
                a.zoomies = !a.zoomies;
                a.zoomTimer = 0;
            }
        }
    }

    @Override
    public void onLogin() {
        PacketFly2 a;
        PacketFly2 packetFly2 = a;
        packetFly2.disable();
        packetFly2.clearValues();
    }

    public boolean checkPackets(int n) {
        int a = n;
        PacketFly2 a2 = this;
        if (++a2.packetCounter >= a) {
            a2.packetCounter = 0;
            return true;
        }
        return false;
    }

    @Override
    public String getInfo() {
        PacketFly2 a;
        return a.mode.getValue().toString();
    }

    public boolean isPlayerCollisionBoundingBoxEmpty() {
        PacketFly2 a;
        double d;
        double d2 = d = a.bbOffset.getValue() ? -0.0625 : 0.0;
        return PacketFly2.mc.field_1687.method_39454((class_1297)PacketFly2.mc.field_1724, PacketFly2.mc.field_1724.method_5829().method_1009(d2, d2, d2));
    }

    @EventHandler
    public void onPacket(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        PacketFly2 a2 = this;
        Object t = a.getPacket();
        if (t instanceof class_2828) {
            class_2828 class_28282 = (class_2828)t;
            if (a2.mode.getValue() != Mode.Compatibility && !a2.playerPackets.remove(a.getPacket())) {
                if (class_28282 instanceof class_2828.class_2831 && !a2.noRotation.getValue()) {
                    return;
                }
                if (!a2.noMovePacket.getValue()) {
                    return;
                }
                a.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void invoke(PacketEvent.Receive a) {
        Object a2;
        PacketFly2 packetFly2 = a2;
        if (PacketFly2.nullCheck()) {
            return;
        }
        if (packetFly2.mode.getValue() == Mode.Compatibility) {
            return;
        }
        a2 = a.getPacket();
        if (a2 instanceof class_2708) {
            class_2708 class_27082 = (class_2708)a2;
            if (PacketFly2.mc.field_1724.method_5805() && packetFly2.mode.getValue() != Mode.Setback && packetFly2.mode.getValue() != Mode.Slow && !(PacketFly2.mc.field_1755 instanceof class_434) && (a2 = packetFly2.posLooks.remove(class_27082.method_11737())) != null && ((TimeVec)a2).field_1352 == class_27082.method_11734() && ((TimeVec)a2).field_1351 == class_27082.method_11735() && ((TimeVec)a2).field_1350 == class_27082.method_11738()) {
                a.setCancelled(true);
                return;
            }
            packetFly2.teleportID.set(class_27082.method_11737());
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Fast;
        public static final /* enum */ Mode Factor;
        public static final /* enum */ Mode Increment;
        public static final /* enum */ Mode Compatibility;
        public static final /* enum */ Mode Slow;
        public static final /* enum */ Mode Setback;

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[6];
            arrmode[0] = Setback;
            arrmode[1] = Fast;
            arrmode[2] = Factor;
            arrmode[3] = Slow;
            arrmode[4] = Increment;
            arrmode[5] = Compatibility;
            return arrmode;
        }

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

        static {
            Setback = new Mode(BackgroundInfo.ALLATORIxDEMO("\u001f9?#7hw"), 0);
            Fast = new Mode(TipUtils.ALLATORIxDEMO("\u001a\u0012eM"), 1);
            Factor = new Mode(BackgroundInfo.ALLATORIxDEMO("\u001a*\"\"dn"), 2);
            Slow = new Mode(TipUtils.ALLATORIxDEMO("\u000f\u001fyN"), 3);
            Increment = new Mode(BackgroundInfo.ALLATORIxDEMO("\u00025/..,3eh"), 4);
            Compatibility = new Mode(TipUtils.ALLATORIxDEMO("'+\u00061\u000f2\u0000#\u00070\u001ab@"), 5);
            $VALUES = Mode.$values();
        }
    }

    public static final class Phase
    extends Enum<Phase> {
        private static final /* synthetic */ Phase[] $VALUES;
        public static final /* enum */ Phase Off = new Phase(SocketClient.ALLATORIxDEMO("WMh"), 0);
        public static final /* enum */ Phase Full;
        public static final /* enum */ Phase Semi;

        public static Phase[] values() {
            return (Phase[])$VALUES.clone();
        }

        public static Phase valueOf(String a) {
            return Enum.valueOf(Phase.class, a);
        }

        private static /* synthetic */ Phase[] $values() {
            Phase[] arrphase = new Phase[3];
            arrphase[0] = Off;
            arrphase[1] = Semi;
            arrphase[2] = Full;
            return arrphase;
        }

        static {
            Semi = new Phase(Vec3.ALLATORIxDEMO("]\u0001u\u001b"), 1);
            Full = new Phase(SocketClient.ALLATORIxDEMO("{mGb"), 2);
            $VALUES = Phase.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Phase() {
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

    public static abstract class Type
    extends Enum<Type> {
        public static final /* enum */ Type Switch;
        public static final /* enum */ Type Down;
        public static final /* enum */ Type X;
        private static final /* synthetic */ Type[] $VALUES;
        public static final /* enum */ Type Z;
        public static final /* enum */ Type XZ;
        public static final /* enum */ Type Up;
        public static final /* enum */ Type Preserve;

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        private static /* synthetic */ Type[] $values() {
            Type[] arrtype = new Type[7];
            arrtype[0] = Down;
            arrtype[1] = Up;
            arrtype[2] = Preserve;
            arrtype[3] = Switch;
            arrtype[4] = X;
            arrtype[5] = Z;
            arrtype[6] = XZ;
            return arrtype;
        }

        public static Type valueOf(String a) {
            return Enum.valueOf(Type.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Type() {
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

        public abstract class_243 createOutOfBounds(class_243 var1, int var2);

        static {
            Down = new Type(Setting.ALLATORIxDEMO("B*;a"), 0){
                {
                    int a = n;
                    1 var2_4 = this;
                }

                /*
                 * WARNING - void declaration
                 */
                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    void a;
                    int a2 = n;
                    1 a3 = this;
                    return a.method_1031(0.0, (double)(-a2), 0.0);
                }
            };
            Up = new Type(BaseChildSettings.ALLATORIxDEMO("%t"), 1){

                /*
                 * WARNING - void declaration
                 */
                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    void a;
                    int a2 = n;
                    2 a3 = this;
                    return a.method_1031(0.0, (double)a2, 0.0);
                }
                {
                    int a = n;
                    2 var2_4 = this;
                }
            };
            Preserve = new Type(Setting.ALLATORIxDEMO("L-~+c7:j"), 2){
                private final Random random;

                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    3 a = class_2432;
                    3 a2 = this;
                    return a.method_1031((double)a2.randomInt(), 0.0, (double)a2.randomInt());
                }

                private /* synthetic */ int randomInt() {
                    3 a22;
                    3 var1_2;
                    3 v0 = var1_2 = a22;
                    int a22 = v0.random.nextInt(29000000);
                    if (v0.random.nextBoolean()) {
                        return a22;
                    }
                    return -a22;
                }
                {
                    int a = n;
                    3 var2_4 = this;
                    3 v0 = var2_4;
                    v0.random = new Random();
                }
            };
            Switch = new Type(BaseChildSettings.ALLATORIxDEMO("t$S:\u0013l"), 3){
                private final Random random;

                /*
                 * WARNING - void declaration
                 */
                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    void a;
                    int a2 = n;
                    4 a3 = this;
                    if (a3.random.nextBoolean()) {
                        return a.method_1031(0.0, (double)(-a2), 0.0);
                    }
                    return a.method_1031(0.0, (double)a2, 0.0);
                }
                {
                    int a = n;
                    4 var2_4 = this;
                    4 v0 = var2_4;
                    v0.random = new Random();
                }
            };
            X = new Type(Setting.ALLATORIxDEMO("W"), 4){
                {
                    int a = n;
                    5 var2_4 = this;
                }

                /*
                 * WARNING - void declaration
                 */
                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    void a;
                    int a2 = n;
                    5 a3 = this;
                    return a.method_1031((double)a2, 0.0, 0.0);
                }
            };
            Z = new Type(BaseChildSettings.ALLATORIxDEMO("^"), 5){
                {
                    int a = n;
                    6 var2_4 = this;
                }

                /*
                 * WARNING - void declaration
                 */
                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    void a;
                    int a2 = n;
                    6 a3 = this;
                    return a.method_1031(0.0, 0.0, (double)a2);
                }
            };
            XZ = new Type(Setting.ALLATORIxDEMO("\u0014U"), 6){

                /*
                 * WARNING - void declaration
                 */
                @Override
                public class_243 createOutOfBounds(class_243 class_2432, int n) {
                    void a;
                    int a2 = n;
                    7 a3 = this;
                    return a.method_1031((double)a2, 0.0, (double)a2);
                }
                {
                    int a = n;
                    7 var2_4 = this;
                }
            };
            $VALUES = Type.$values();
        }

    }

    public static class TimeVec
    extends class_243 {
        private final long time;

        public TimeVec(double a, double a2, double a3, long a4) {
            super(a, a2, a3);
            TimeVec a5;
            a5.time = a4;
        }

        public long getTime() {
            TimeVec a;
            return a.time;
        }

        public TimeVec(class_243 class_2432) {
            TimeVec a = class_2432;
            TimeVec a2 = this;
            a2(a.field_1352, a.field_1351, a.field_1350, System.currentTimeMillis());
        }
    }

}
