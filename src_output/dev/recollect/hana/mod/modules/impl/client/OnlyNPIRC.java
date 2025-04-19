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
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.NpSocketManager;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.socket.network.packet.Packet;
import dev.recollect.hana.socket.network.packet.impl.info.GameInfoPacket;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_746;

public class OnlyNPIRC
extends Module {
    public final EnumSetting<type> tp;
    public static OnlyNPIRC INSTANCE;
    private String lastName;

    public void reset() {
        a.lastName = null;
    }

    @Override
    public void onEnable() {
        OnlyNPIRC a;
        a.reset();
    }

    @Override
    public void onDisable() {
        OnlyNPIRC a;
        a.reset();
        if (Hana.NPIRC.getClient().isConnected()) {
            Hana.NPIRC.getClient().disconnect();
        }
    }

    @Override
    public void onUpdate() {
        String a;
        OnlyNPIRC onlyNPIRC = a;
        a = String.valueOf((Object)OnlyNPIRC.mc.field_1724.method_5477());
        if (Hana.NPIRC.getClient().isConnected()) {
            if (onlyNPIRC.lastName == null || !onlyNPIRC.lastName.equals(a)) {
                Hana.NPIRC.send(new GameInfoPacket(a, mc.method_1548().method_1674(), mc.method_1548().method_1675(), System.currentTimeMillis()));
                onlyNPIRC.lastName = a;
                return;
            }
        } else if (!Hana.NPIRC.getClient().isConnecting()) {
            // empty if block
        }
    }

    public OnlyNPIRC() {
        OnlyNPIRC a;
        OnlyNPIRC onlyNPIRC = a;
        super(MathUtil.ALLATORIxDEMO("\u001c?!1\u001a\u0003\u0006\u0010\u001d"), Snow.ALLATORIxDEMO("\u000fnjvddr-_c{}4foOlr/buc\rHFTFQ^SN_"), Module.Category.Client);
        onlyNPIRC.tp = a.add(new EnumSetting<type>(MathUtil.ALLATORIxDEMO("\u000762;"), type.Notify));
        onlyNPIRC.setChinese(Snow.ALLATORIxDEMO("dq\u0011srh"));
        INSTANCE = onlyNPIRC;
    }

    public static final class type
    extends Enum<type> {
        public static final /* enum */ type Notify = new type(ObsidianHelper.ALLATORIxDEMO("{1H>O;"), 0);
        public static final /* enum */ type Chat = new type(BackgroundInfo.ALLATORIxDEMO("\u0002>jh"), 1);
        private static final /* synthetic */ type[] $VALUES;

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

        static {
            $VALUES = type.$values();
        }

        public static type valueOf(String a) {
            return Enum.valueOf(type.class, a);
        }

        private static /* synthetic */ type[] $values() {
            type[] arrtype = new type[2];
            arrtype[0] = Notify;
            arrtype[1] = Chat;
            return arrtype;
        }

        public static type[] values() {
            return (type[])$VALUES.clone();
        }
    }

}
