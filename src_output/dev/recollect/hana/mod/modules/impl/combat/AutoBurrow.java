/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_4050
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.MeteorExplosionUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Burrow;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.packet.Packet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4050;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoBurrow
extends Module {
    public BooleanSetting mcheck;
    public BooleanSetting mself;
    public final HashMap<class_1657, Double> playerSpeeds;
    public static AutoBurrow INSTANCE;
    public static Timer delay;
    public SliderSetting speed;
    private final SliderSetting breakMinSelf;
    private final SliderSetting predictTicks;
    private final SliderSetting Delay;
    private final SliderSetting cRange;
    private final BooleanSetting terrainIgnore;
    public BooleanSetting ccheck;
    public BooleanSetting pause;

    @Override
    public void onUpdate() {
        block10 : {
            block12 : {
                AutoBurrow a;
                block11 : {
                    if (AutoBurrow.nullCheck()) {
                        return;
                    }
                    if (!delay.passed((long)a.Delay.getValue())) {
                        return;
                    }
                    if (a.pause.getValue() && AutoBurrow.mc.field_1724.method_6115()) {
                        return;
                    }
                    if (AutoBurrow.mc.field_1690.field_1903.method_1434()) {
                        return;
                    }
                    if (!AutoBurrow.canbur()) {
                        return;
                    }
                    if (!AutoBurrow.mc.field_1724.method_24828() || !(a.getPlayerSpeed((class_1657)AutoBurrow.mc.field_1724) < (double)a.speed.getValueInt())) break block10;
                    if (!a.ccheck.getValue() || !a.mcheck.getValue()) break block11;
                    if (a.findcrystal()) break block12;
                    AutoBurrow autoBurrow = a;
                    if (!autoBurrow.checkmine(autoBurrow.mself.getValue())) break block10;
                    break block12;
                }
                if (a.ccheck.getValue() && !a.findcrystal()) break block10;
                if (!a.mcheck.getValue()) break block12;
                AutoBurrow autoBurrow = a;
                if (!autoBurrow.checkmine(autoBurrow.mself.getValue())) break block10;
            }
            if (Burrow.INSTANCE.isOn()) {
                return;
            }
            Burrow.INSTANCE.enable();
            delay.reset();
        }
    }

    private static /* synthetic */ boolean canbur() {
        BlockPosX blockPosX = new BlockPosX(AutoBurrow.mc.field_1724.method_23317() + 0.3, AutoBurrow.mc.field_1724.method_23318() + 0.5, AutoBurrow.mc.field_1724.method_23321() + 0.3);
        BlockPosX blockPosX2 = new BlockPosX(AutoBurrow.mc.field_1724.method_23317() - 0.3, AutoBurrow.mc.field_1724.method_23318() + 0.5, AutoBurrow.mc.field_1724.method_23321() + 0.3);
        BlockPosX blockPosX3 = new BlockPosX(AutoBurrow.mc.field_1724.method_23317() + 0.3, AutoBurrow.mc.field_1724.method_23318() + 0.5, AutoBurrow.mc.field_1724.method_23321() - 0.3);
        BlockPosX blockPosX4 = new BlockPosX(AutoBurrow.mc.field_1724.method_23317() - 0.3, AutoBurrow.mc.field_1724.method_23318() + 0.5, AutoBurrow.mc.field_1724.method_23321() - 0.3);
        EntityUtil.getPlayerPos(true);
        return Burrow.INSTANCE.canPlace(blockPosX) || Burrow.INSTANCE.canPlace(blockPosX2) || Burrow.INSTANCE.canPlace(blockPosX3) || Burrow.INSTANCE.canPlace(blockPosX4);
    }

    public double turnIntoKpH(double a) {
        return (double)class_3532.method_15355((float)((float)a)) * 71.2729367892;
    }

    /*
     * Exception decompiling
     */
    public boolean checkmine(boolean a) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 1[WHILELOOP]
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

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_243 class_2432, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        void a3;
        AutoBurrow autoBurrow = this;
        if (autoBurrow.terrainIgnore.getValue()) {
            CombatUtil.terrainIgnore = true;
        }
        float a4 = 0.0f;
        a4 = (float)MeteorExplosionUtil.crystalDamage((class_1657)a3, (class_243)a2, (class_1657)a);
        CombatUtil.terrainIgnore = false;
        return a4;
    }

    public double getPlayerSpeed(class_1657 class_16572) {
        AutoBurrow a = class_16572;
        AutoBurrow a2 = this;
        if (a2.playerSpeeds.get(a) == null) {
            return 0.0;
        }
        AutoBurrow autoBurrow = a2;
        return autoBurrow.turnIntoKpH(autoBurrow.playerSpeeds.get(a));
    }

    static {
        delay = new Timer();
    }

    public boolean findcrystal() {
        Object a;
        AutoBurrow autoBurrow = a;
        PlayerAndPredict playerAndPredict = new PlayerAndPredict(autoBurrow, (class_1657)AutoBurrow.mc.field_1724);
        Object object = a = AutoBurrow.mc.field_1687.method_18112().iterator();
        while (object.hasNext()) {
            class_1297 class_12972 = (class_1297)a.next();
            if (!(class_12972 instanceof class_1511)) {
                object = a;
                continue;
            }
            if (EntityUtil.getEyesPos().method_1022(class_12972.method_19538()) > autoBurrow.cRange.getValue()) {
                object = a;
                continue;
            }
            PlayerAndPredict playerAndPredict2 = playerAndPredict;
            if ((double)autoBurrow.calculateDamage(class_12972.method_19538(), playerAndPredict2.player, playerAndPredict2.predict) < autoBurrow.breakMinSelf.getValue()) {
                object = a;
                continue;
            }
            return true;
        }
        return false;
    }

    public AutoBurrow() {
        AutoBurrow a;
        AutoBurrow autoBurrow = a;
        super(FadeUtils.ALLATORIxDEMO("-H\u001fU.H\u0003RT\u001d"), Module.Category.Combat);
        AutoBurrow autoBurrow2 = a;
        autoBurrow2.Delay = autoBurrow.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("_%jk5"), 100, 0, 1000));
        autoBurrow.pause = autoBurrow.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO(";[\u0019N\u0014eZ\u001e"), true));
        autoBurrow.speed = autoBurrow.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u0017}%H0co("), 8, 0, 20));
        autoBurrow.ccheck = autoBurrow.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("z\u0000\t^\u0000y\u001eD\u0002TZ\u0006"), true).setParent());
        autoBurrow.cRange = autoBurrow.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("I!hm)"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoBurrow a2 = this;
            return a2.ccheck.isOpen();
        }));
        a.breakMinSelf = a.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("\u0019_\rV\"EW\f"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoBurrow a2 = this;
            return a2.ccheck.isOpen();
        }));
        AutoBurrow autoBurrow3 = a;
        autoBurrow3.mcheck = autoBurrow3.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("X2y>p\rod)"), true).setParent());
        autoBurrow3.mself = autoBurrow3.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("\"EW\f"), true, object -> {
            Object a = object;
            AutoBurrow a2 = this;
            return a2.mcheck.isOpen();
        }));
        AutoBurrow autoBurrow4 = a;
        AutoBurrow autoBurrow5 = a;
        autoBurrow5.predictTicks = autoBurrow5.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("X<83)O)ea?"), 4, 0, 10));
        autoBurrow5.terrainIgnore = autoBurrow5.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("w\\\u001a\u001e\\\u0002T%Z\u001fOI\u000f"), true));
        autoBurrow4.playerSpeeds = new HashMap();
        autoBurrow4.setChinese(ColorUtil.ALLATORIxDEMO("\u81aa\u52ae\u57c1\u8156"));
        INSTANCE = autoBurrow4;
    }

    public class PlayerAndPredict {
        class_1657 predict;
        final /* synthetic */ AutoBurrow this$0;
        class_1657 player;

        public PlayerAndPredict(AutoBurrow autoBurrow, class_1657 class_16572) {
            Iterator a;
            PlayerAndPredict a2 = class_16572;
            PlayerAndPredict a3 = this;
            a3.this$0 = a;
            a3.player = a2;
            if (((AutoBurrow)a).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a3;
                playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(SocketClient.ALLATORIxDEMO("\u000f*[}-\r\u00141\u0002;\u0005!\u001f#\t-<\u0018\r3\u001c9(\u0016\n/\u001c;\u001c<\u001f4\u001b>\n/")), Packet.ALLATORIxDEMO("NKOiaLk}pMz@`\r=\u0010")), (AutoBurrow)((Object)a)){
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ AutoBurrow val$this$0;

                    public boolean method_7325() {
                        return false;
                    }
                    {
                        void a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        Object a6;
                        1 v0 = object2;
                        Object object2 = object;
                        object = v0;
                        object.this$1 = a5;
                        object.val$this$0 = a6;
                        super((class_1937)a4, (class_2338)a3, (float)a2, (GameProfile)a);
                    }

                    public boolean method_7337() {
                        return false;
                    }
                };
                a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, AutoBurrow.INSTANCE.predictTicks.getValueInt(), true)));
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
