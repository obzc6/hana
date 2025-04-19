/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.DeathEvent;
import dev.recollect.hana.api.events.impl.TotemEvent;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.managers.PopManager;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.video.Renderer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseSettings;

public class AutoEZ
extends Module {
    private final String[] reb;
    private final BooleanSetting kill;
    private final EnumSetting<MessageMode> killMsgMode;
    private static String[] kouzi = new String[0];
    private final StringSetting custom;
    private final Random r;
    private final EnumSetting<MessageMode> popMsgMode;
    private int lastNum;
    private final SliderSetting range;
    private final StringSetting popcustom;
    private final BooleanSetting pop;

    static {
        kouzi = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Hana.class.getClassLoader().getResourceAsStream(Renderer.ALLATORIxDEMO("\u000bu\u0012g\t.\t2C"))), StandardCharsets.UTF_8)).lines().toList().toArray(new String[0]);
    }

    public AutoEZ() {
        AutoEZ a;
        AutoEZ autoEZ = a;
        super(Renderer.ALLATORIxDEMO("\\\u0015t\u0012\u000fm"), Module.Category.Misc);
        autoEZ.r = new Random();
        autoEZ.range = a.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("Q}GdS"), 10, 1, 30));
        autoEZ.kill = autoEZ.add(new BooleanSetting(Renderer.ALLATORIxDEMO("k\u0014&["), true).setParent());
        autoEZ.killMsgMode = autoEZ.add(new EnumSetting<MessageMode>(BaseSettings.ALLATORIxDEMO("uEdQFgS"), MessageMode.Rebirth, object -> {
            Object a = object;
            AutoEZ a2 = this;
            return a2.kill.isOpen();
        }));
        a.custom = a.add(new StringSetting(Renderer.ALLATORIxDEMO("^\u0015s\t%Z"), BaseSettings.ALLATORIxDEMO("t\u001e.tHH9\bhZbeLq\u0013"), object -> {
            Object a = object;
            AutoEZ a2 = this;
            return a2.killMsgMode.getValue() == MessageMode.Custom && a2.kill.isOpen();
        }));
        AutoEZ autoEZ2 = a;
        autoEZ2.pop = autoEZ2.add(new BooleanSetting(Renderer.ALLATORIxDEMO("\r%G"), true).setParent());
        autoEZ2.popMsgMode = autoEZ2.add(new EnumSetting<MessageMode>(BaseSettings.ALLATORIxDEMO("uEdQFgS"), MessageMode.Rebirth, object -> {
            Object a = object;
            AutoEZ a2 = this;
            return a2.pop.isOpen();
        }));
        a.popcustom = a.add(new StringSetting(Renderer.ALLATORIxDEMO("^\u0015s\t%Z"), BaseSettings.ALLATORIxDEMO("\u0013s@xSz\u0005g8]Ci\r=BlhLn\u0013"), object -> {
            Object a = object;
            AutoEZ a2 = this;
            return a2.popMsgMode.getValue() == MessageMode.Custom && a2.pop.isOpen();
        }));
        String[] arrstring = new String[2];
        arrstring[0] = Renderer.ALLATORIxDEMO("=\u0015t\u0004l\rhB1'r\nm\u0019cZ8^\u0015\u001ad\u001ei\u000fo\u000e\u0011a|6+Zq\f\u0004i7i\u0013!\u001a");
        arrstring[1] = BaseSettings.ALLATORIxDEMO("R\u0012 ]sDm\n2hj_fYlPcLZ^lW$\u0016HEuFz\u0013bABY9\bhZbeLq\u0013");
        a.reb = arrstring;
        a.setChinese(Renderer.ALLATORIxDEMO("\u81ea\u52d5\u5678\u8b8a"));
    }

    @EventHandler
    public void onTotem(TotemEvent a) {
        AutoEZ autoEZ;
        block11 : {
            block10 : {
                AutoEZ a2;
                autoEZ = a2;
                if (a.getPlayer().method_5739((class_1297)AutoEZ.mc.field_1724) > (float)autoEZ.range.getValueInt() || a.getPlayer() == AutoEZ.mc.field_1724) break block10;
                if (!FriendManager.isFriend(a.getPlayer().method_5477().getString())) break block11;
            }
            return;
        }
        if (autoEZ.pop.getValue() && autoEZ.popMsgMode.getValue() == MessageMode.Rebirth) {
            int a2 = autoEZ.r.nextInt(0, autoEZ.reb.length);
            if (a2 == autoEZ.lastNum) {
                a2 = a2 < autoEZ.reb.length - 1 ? a2 + 1 : 0;
            }
            AutoEZ autoEZ2 = autoEZ;
            autoEZ2.lastNum = a2;
            autoEZ2.send(autoEZ2.reb[a2].replaceAll(Renderer.ALLATORIxDEMO(">\u0016l\u001ch\tkA"), a.getPlayer().method_5477().getString()));
        }
        if (autoEZ.pop.getValue() && autoEZ.popMsgMode.getValue() == MessageMode.NEW) {
            int a2 = Hana.POP.popContainer.getOrDefault(a.getPlayer().method_5477().getString(), 0);
            autoEZ.send(BaseSettings.ALLATORIxDEMO("\u0010pYaAhE'\u7ae3\u713f\u8fee\u6d38\u776c\uff18\u4efco\u00182\u4e9e\bXvY}[&\u4e36\u56d7\u817d\uff37").replaceAll(Renderer.ALLATORIxDEMO(">\u0016l\u001ch\tkA"), a.getPlayer().method_5477().getString()).replaceAll(BaseSettings.ALLATORIxDEMO("=BlhLn\u0013"), String.valueOf(a2)));
        }
        if (autoEZ.pop.getValue() && autoEZ.popMsgMode.getValue() == MessageMode.Kouzi) {
            int a2 = autoEZ.r.nextInt(0, kouzi.length);
            if (a2 == autoEZ.lastNum) {
                a2 = a2 < kouzi.length - 1 ? a2 + 1 : 0;
            }
            autoEZ.lastNum = a2;
            autoEZ.send(kouzi[a2].replaceAll(Renderer.ALLATORIxDEMO(">\u0016l\u001ch\tkA"), a.getPlayer().method_5477().getString()));
        }
        if (autoEZ.pop.getValue() && autoEZ.popMsgMode.getValue() == MessageMode.Custom) {
            int a2 = Hana.POP.popContainer.getOrDefault(a.getPlayer().method_5477().getString(), 0);
            AutoEZ autoEZ3 = autoEZ;
            autoEZ3.send(autoEZ3.popcustom.getValue().replaceAll(BaseSettings.ALLATORIxDEMO("\bhZbeLq\u0013"), a.getPlayer().method_5477().getString()).replaceAll(Renderer.ALLATORIxDEMO("Ct\u0012e\ttA"), String.valueOf(a2)));
        }
        if (autoEZ.pop.getValue() && autoEZ.popMsgMode.getValue() == MessageMode.lag) {
            int a2 = Hana.POP.popContainer.getOrDefault(a.getPlayer().method_5477().getString(), 0);
            autoEZ.send(BaseSettings.ALLATORIxDEMO("\u012d\u0218\u0334\u0401\u053d\u0608\u072b\u081e\u0976\u0a43\u0b31\u0e04\u0f35\u1000\u1128\u121d\u1334\u1401\u1576\u1643\u1735\u1800\u1931\u1a04\u1b2b\u1c1e\u1d3b\u1e0e\u1f3d)\u2134\u2201\u2334\u2401\u2539\u270c\u2836\u2903\u2a3d\u2b08\u2c37\u2d02\u2e2d\u2f18\u302b\u311e\u3276\u3343\u3419\u352c\u362d\u3718\u382c\u3919\u3a37\u3b02\u3c1d\u3d28\u3e02\u3f37\u4037\u4102\u4236\u4303\u440c\u4539\u4637\u4702\u482c\u4919\u4a3d\u4b08\u4c35\u4d00\u4e3c\u4f09\u503d\u5108\u522e\u531b\u5476\u5543\u562a\u571f\u583d\u5908\u5a3b\u5b0e\u5c37\u5d02\u5e34\u5f01\u6034\u6101\u623d\u6308\u643b\u650e\u662c\u6719\u6876\u6943\u6a30\u6b05\u6c39\u6d0c\u6e36\u6f03\u7039\u710c\u7276\u7343\u7435\u7500\u7637\u7702\u783c\u7909\u7a76\u7b43\u7c35\u7d00\u7e37\u7f02\u803c\u8109\u822d\u8318\u8434\u8501\u863d\u8708\u882b\u891e\u8a76\u8b43\u8c31\u8d04\u8e35\u8f00\u9028\u911d\u9234\u9301\u9476\u9543\u9635\u9700\u9831\u9904\u9a2b\u9b1e\u9c3b\u9d0e\u9e3d\u9f08\ua034\ua101\ua234\ua301\ua439\ua50c\ua636\ua703\ua83d\ua908\uaa37\uab02\uac2d\uad18\uae2b\uaf1e\ub076\ub143\ub219\ub32c\ub42d\ub518\ub62c\ub719\ub837\ub902\uba1d\ubb28\ubc02\ubd37").replaceAll(Renderer.ALLATORIxDEMO(">\u0016l\u001ch\tkA"), a.getPlayer().method_5477().getString()).replaceAll(BaseSettings.ALLATORIxDEMO("=BlhLn\u0013"), String.valueOf(a2)));
        }
    }

    private /* synthetic */ void send(String string) {
        String a = string;
        AutoEZ a2 = this;
        AutoEZ.mc.field_1724.field_3944.method_45729(a);
    }

    @Override
    public String getInfo() {
        AutoEZ a;
        return a.killMsgMode.getValue().name();
    }

    @EventHandler
    public void onDeath(DeathEvent a) {
        AutoEZ autoEZ;
        block10 : {
            block9 : {
                AutoEZ a2;
                autoEZ = a2;
                if (a.getPlayer().method_5739((class_1297)AutoEZ.mc.field_1724) > (float)autoEZ.range.getValueInt() || a.getPlayer() == AutoEZ.mc.field_1724) break block9;
                if (!FriendManager.isFriend(a.getPlayer().method_5477().getString())) break block10;
            }
            return;
        }
        if (autoEZ.kill.getValue() && autoEZ.killMsgMode.getValue() == MessageMode.Rebirth) {
            int a2 = autoEZ.r.nextInt(0, autoEZ.reb.length);
            if (a2 == autoEZ.lastNum) {
                a2 = a2 < autoEZ.reb.length - 1 ? a2 + 1 : 0;
            }
            AutoEZ autoEZ2 = autoEZ;
            autoEZ2.lastNum = a2;
            autoEZ2.send(autoEZ2.reb[a2].replaceAll(BaseSettings.ALLATORIxDEMO("\bhZbeLq\u0013"), a.getPlayer().method_5477().getString()));
        }
        if (autoEZ.kill.getValue() && autoEZ.killMsgMode.getValue() == MessageMode.NEW) {
            int a2 = Hana.POP.popContainer.getOrDefault(a.getPlayer().method_5477().getString(), 0);
            autoEZ.send(Renderer.ALLATORIxDEMO("\u4ea3\u757b\u81f7\u5384\u8c06\u659a\u6b6c\uff75\u9046\u61d2\u769c\uff69=\u0015y\tc\u0002cI\u5733\u0016n\f'_.HA-lY \u4e57\u56e5\u8118\u4ed4\u5442\u5ddc\u65b3\u6cce\u4e68\u60b2\u4ef5\u5298\uff41\u8bb8\u627d\u4ef9\u4e68\u8d77\u60c1\u5fe9\u4eb7").replaceAll(BaseSettings.ALLATORIxDEMO("\bhZbeLq\u0013"), a.getPlayer().method_5477().getString()).replaceAll(Renderer.ALLATORIxDEMO("Ia\u0007t\u0018qD"), String.valueOf(a2)));
        }
        if (autoEZ.kill.getValue() && autoEZ.killMsgMode.getValue() == MessageMode.Kouzi) {
            int a2 = autoEZ.r.nextInt(0, kouzi.length);
            if (a2 == autoEZ.lastNum) {
                a2 = a2 < kouzi.length - 1 ? a2 + 1 : 0;
            }
            autoEZ.lastNum = a2;
            autoEZ.send(kouzi[a2].replaceAll(BaseSettings.ALLATORIxDEMO("\bhZbeLq\u0013"), a.getPlayer().method_5477().getString()));
        }
        if (autoEZ.kill.getValue() && autoEZ.killMsgMode.getValue() == MessageMode.Custom) {
            int a2 = Hana.POP.popContainer.getOrDefault(a.getPlayer().method_5477().getString(), 0);
            AutoEZ autoEZ3 = autoEZ;
            autoEZ3.send(autoEZ3.custom.getValue().replaceAll(Renderer.ALLATORIxDEMO("4\u001cy\ty\u0018nD"), a.getPlayer().method_5477().getString()).replaceAll(BaseSettings.ALLATORIxDEMO("=BlhLn\u0013"), String.valueOf(a2)));
        }
    }

    @Override
    public void onEnable() {
        a.lastNum = -1;
    }

    public static final class MessageMode
    extends Enum<MessageMode> {
        public static final /* enum */ MessageMode NEW;
        public static final /* enum */ MessageMode Kouzi;
        private static final /* synthetic */ MessageMode[] $VALUES;
        public static final /* enum */ MessageMode Rebirth;
        public static final /* enum */ MessageMode lag;
        public static final /* enum */ MessageMode Custom;

        /*
         * Exception decompiling
         */
        private /* synthetic */ MessageMode() {
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
            Kouzi = new MessageMode(HoleUtils.ALLATORIxDEMO("\\LiXt"), 0);
            Rebirth = new MessageMode(Hole.ALLATORIxDEMO("R\u001be\nh]8"), 1);
            NEW = new MessageMode(HoleUtils.ALLATORIxDEMO("RgJ"), 2);
            Custom = new MessageMode(Hole.ALLATORIxDEMO("=r\u0010nF="), 3);
            lag = new MessageMode(HoleUtils.ALLATORIxDEMO("pCz"), 4);
            $VALUES = MessageMode.$values();
        }

        private static /* synthetic */ MessageMode[] $values() {
            MessageMode[] arrmessageMode = new MessageMode[5];
            arrmessageMode[0] = Kouzi;
            arrmessageMode[1] = Rebirth;
            arrmessageMode[2] = NEW;
            arrmessageMode[3] = Custom;
            arrmessageMode[4] = lag;
            return arrmessageMode;
        }

        public static MessageMode valueOf(String a) {
            return Enum.valueOf(MessageMode.class, a);
        }

        public static MessageMode[] values() {
            return (MessageMode[])$VALUES.clone();
        }
    }

}
