/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1536
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2663
 *  net.minecraft.class_2664
 *  net.minecraft.class_2743
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.asm.accessors.IEntityVelocityUpdateS2CPacket;
import dev.recollect.hana.asm.accessors.IExplosionS2CPacket;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.xibao.SnowAnimation;
import net.minecraft.class_1297;
import net.minecraft.class_1536;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2663;
import net.minecraft.class_2664;
import net.minecraft.class_2743;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class Velocity
extends Module {
    private double motionZ;
    private final SliderSetting vertical;
    public final BooleanSetting waterPush;
    public final BooleanSetting entityPush;
    private final SliderSetting horizontal;
    public final BooleanSetting noExplosions;
    public static Velocity INSTANCE;
    private double motionX;
    private final EnumSetting<Mode> mode;
    public final BooleanSetting blockPush;

    @Override
    public String getInfo() {
        Velocity a;
        return "H" + a.horizontal.getValueInt() + ".0%,V" + a.vertical.getValueInt() + ".0%";
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onReceivePacket(PacketEvent.Receive a) {
        var2_2 = a;
        if (Velocity.nullCheck()) {
            return;
        }
        v0 = var2_2;
        var4_3 = v0.horizontal.getValueFloat() / 100.0f;
        var3_4 = v0.vertical.getValueFloat() / 100.0f;
        var6_5 = a.getPacket();
        if (var6_5 instanceof class_2663) {
            a = (class_2663)var6_5;
            a = (class_2663)a.getPacket();
            if (a.method_11470() == 31 && (var6_6 = a.method_11469((class_1937)Velocity.mc.field_1687)) instanceof class_1536 && (var5_9 = (class_1536)var6_6).method_26957() == Velocity.mc.field_1724) {
                a.setCancelled(true);
            }
        }
        if (a.getPacket() instanceof class_2664) {
            v1 = a = (IExplosionS2CPacket)a.getPacket();
            v1.setX(v1.getX() * var4_3);
            v1.setY(v1.getY() * var3_4);
            v1.setZ(v1.getZ() * var4_3);
            if (var2_2.noExplosions.getValue() == false) return;
            a.cancel();
            return;
        }
        if (var2_2.mode.getValue() != Mode.Simple || !((var5_10 = a.getPacket()) instanceof class_2743) || (a = (class_2743)var5_10).method_11818() != Velocity.mc.field_1724.method_5628()) ** GOTO lbl29
        if (var2_2.horizontal.getValue() == 0.0 && var2_2.vertical.getValue() == 0.0) {
            v2 = var2_2;
            a.cancel();
        } else {
            ((IEntityVelocityUpdateS2CPacket)a).setX((int)((float)a.method_11815() * var4_3));
            ((IEntityVelocityUpdateS2CPacket)a).setY((int)((float)a.method_11816() * var3_4));
            ((IEntityVelocityUpdateS2CPacket)a).setZ((int)((float)a.method_11819() * var4_3));
lbl29: // 2 sources:
            v2 = var2_2;
        }
        if (v2.mode.getValue() == Mode.AACZero && (var5_12 = a.getPacket()) instanceof class_2743) {
            a = (class_2743)var5_12;
            if (Velocity.mc.field_1724.field_6235 > 0) {
                var5_13 = Velocity.mc.field_1724.method_23318() - 0.56;
                Velocity.mc.field_1724.method_23327(Velocity.mc.field_1724.method_23317(), var5_13, Velocity.mc.field_1724.method_23321());
                a.cancel();
            }
        }
        if (var2_2.mode.getValue() != Mode.AACPull) return;
        var5_14 = a.getPacket();
        if (var5_14 instanceof class_2743 == false) return;
        a = (class_2743)var5_14;
        var5_15 = Velocity.mc.field_1724.method_18798();
        if (Velocity.mc.field_1724.field_6235 == 9) {
            v3 = var2_2;
            v3.motionX = var5_15.field_1352;
            v3.motionZ = var5_15.field_1350;
            return;
        }
        if (Velocity.mc.field_1724.field_6235 != 4) return;
        var6_8 = new class_243(-var2_2.motionX * 0.45, var5_15.field_1351, -var2_2.motionZ * 0.45);
        Velocity.mc.field_1724.method_18799(var6_8);
        a.cancel();
    }

    public Velocity() {
        Velocity a;
        Velocity velocity = a;
        Velocity velocity2 = a;
        Velocity velocity3 = a;
        super(NpSocketClient.ALLATORIxDEMO("].m.5e("), Module.Category.Movement);
        Velocity velocity4 = a;
        velocity4.mode = velocity3.add(new EnumSetting<Mode>(BufferRing.ALLATORIxDEMO("\u0019\u000fzO"), Mode.Simple));
        velocity3.horizontal = velocity3.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("O(y\"{.r(p="), 0.0, 0.0, 100.0, 1.0));
        velocity3.vertical = velocity3.add(new SliderSetting(BufferRing.ALLATORIxDEMO("\u0018\u001f;\t=\u0003F"), 0.0, 0.0, 100.0, 1.0));
        velocity3.waterPush = velocity3.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("\u0010j?d3L)b9"), true));
        velocity3.entityPush = velocity3.add(new BooleanSetting(BufferRing.ALLATORIxDEMO("\f\u0013:\u0013=\u0004\u0004\u0015mB"), true));
        velocity3.blockPush = velocity3.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("\u0005g$b*L)b9"), true));
        velocity3.noExplosions = velocity3.add(new BooleanSetting(BufferRing.ALLATORIxDEMO("RG\f\u0005>\u0016&\u000e=\u000fpY"), true));
        velocity2.motionX = 0.0;
        velocity2.motionZ = 0.0;
        velocity.setChinese(NpSocketClient.ALLATORIxDEMO("\u65bc\u51ea\u9051"));
        velocity.setDescription(BufferRing.ALLATORIxDEMO("';\u0018\"\u00057\u0019o\b\"\u0013!\u0019\"\u001f5\u0003u\u0004"));
        INSTANCE = velocity;
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Simple = new Mode(SocketClient.ALLATORIxDEMO("rmGGk"), 0);
        public static final /* enum */ Mode AACPull = new Mode(SnowAnimation.ALLATORIxDEMO("\u000er.h\u0013U\u000b"), 1);
        public static final /* enum */ Mode AACZero = new Mode(SocketClient.ALLATORIxDEMO("g`GpjYa"), 2);
        private static final /* synthetic */ Mode[] $VALUES;

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
            arrmode[0] = Simple;
            arrmode[1] = AACPull;
            arrmode[2] = AACZero;
            return arrmode;
        }

        static {
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }
    }

}
