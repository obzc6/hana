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
package dev.recollect.hana.mod.modules.impl.combat.dev;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.MeteorExplosionUtil;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldBurrow;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.ClientInfo;
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

public class AutoOldBurrow
extends Module {
    private final SliderSetting breakMinSelf;
    private final SliderSetting predictTicks;
    public BooleanSetting pause;
    public SliderSetting speed;
    public BooleanSetting mcheck;
    public static Timer delay = new Timer();
    public static AutoOldBurrow INSTANCE;
    private final BooleanSetting terrainIgnore;
    public final HashMap<class_1657, Double> playerSpeeds;
    public BooleanSetting mself;
    public BooleanSetting ccheck;
    private final SliderSetting Delay;
    private final SliderSetting cRange;

    /*
     * WARNING - void declaration
     */
    public float calculateDamage(class_243 class_2432, class_1657 class_16572, class_1657 class_16573) {
        void a;
        void a2;
        void a3;
        AutoOldBurrow autoOldBurrow = this;
        if (autoOldBurrow.terrainIgnore.getValue()) {
            CombatUtil.terrainIgnore = true;
        }
        float a4 = 0.0f;
        a4 = (float)MeteorExplosionUtil.crystalDamage((class_1657)a3, (class_243)a2, (class_1657)a);
        CombatUtil.terrainIgnore = false;
        return a4;
    }

    public double turnIntoKpH(double a) {
        return (double)class_3532.method_15355((float)((float)a)) * 71.2729367892;
    }

    private static /* synthetic */ boolean canbur() {
        BlockPosX blockPosX = new BlockPosX(AutoOldBurrow.mc.field_1724.method_23317() + 0.3, AutoOldBurrow.mc.field_1724.method_23318() + 0.5, AutoOldBurrow.mc.field_1724.method_23321() + 0.3);
        BlockPosX blockPosX2 = new BlockPosX(AutoOldBurrow.mc.field_1724.method_23317() - 0.3, AutoOldBurrow.mc.field_1724.method_23318() + 0.5, AutoOldBurrow.mc.field_1724.method_23321() + 0.3);
        BlockPosX blockPosX3 = new BlockPosX(AutoOldBurrow.mc.field_1724.method_23317() + 0.3, AutoOldBurrow.mc.field_1724.method_23318() + 0.5, AutoOldBurrow.mc.field_1724.method_23321() - 0.3);
        BlockPosX blockPosX4 = new BlockPosX(AutoOldBurrow.mc.field_1724.method_23317() - 0.3, AutoOldBurrow.mc.field_1724.method_23318() + 0.5, AutoOldBurrow.mc.field_1724.method_23321() - 0.3);
        EntityUtil.getPlayerPos(true);
        return OldBurrow.INSTANCE.canPlace(blockPosX) || OldBurrow.INSTANCE.canPlace(blockPosX2) || OldBurrow.INSTANCE.canPlace(blockPosX3) || OldBurrow.INSTANCE.canPlace(blockPosX4);
    }

    @Override
    public void onUpdate() {
        block10 : {
            block12 : {
                AutoOldBurrow a;
                block11 : {
                    if (AutoOldBurrow.nullCheck()) {
                        return;
                    }
                    if (!delay.passed((long)a.Delay.getValue())) {
                        return;
                    }
                    if (a.pause.getValue() && AutoOldBurrow.mc.field_1724.method_6115()) {
                        return;
                    }
                    if (AutoOldBurrow.mc.field_1690.field_1903.method_1434()) {
                        return;
                    }
                    if (!AutoOldBurrow.canbur()) {
                        return;
                    }
                    if (!AutoOldBurrow.mc.field_1724.method_24828() || !(a.getPlayerSpeed((class_1657)AutoOldBurrow.mc.field_1724) < (double)a.speed.getValueInt())) break block10;
                    if (!a.ccheck.getValue() || !a.mcheck.getValue()) break block11;
                    if (a.findcrystal()) break block12;
                    AutoOldBurrow autoOldBurrow = a;
                    if (!autoOldBurrow.checkmine(autoOldBurrow.mself.getValue())) break block10;
                    break block12;
                }
                if (a.ccheck.getValue() && !a.findcrystal()) break block10;
                if (!a.mcheck.getValue()) break block12;
                AutoOldBurrow autoOldBurrow = a;
                if (!autoOldBurrow.checkmine(autoOldBurrow.mself.getValue())) break block10;
            }
            if (OldBurrow.INSTANCE.isOn()) {
                return;
            }
            OldBurrow.INSTANCE.enable();
            delay.reset();
        }
    }

    public boolean findcrystal() {
        Object a;
        AutoOldBurrow autoOldBurrow = a;
        PlayerAndPredict playerAndPredict = new PlayerAndPredict(autoOldBurrow, (class_1657)AutoOldBurrow.mc.field_1724);
        Object object = a = AutoOldBurrow.mc.field_1687.method_18112().iterator();
        while (object.hasNext()) {
            class_1297 class_12972 = (class_1297)a.next();
            if (!(class_12972 instanceof class_1511)) {
                object = a;
                continue;
            }
            if (EntityUtil.getEyesPos().method_1022(class_12972.method_19538()) > autoOldBurrow.cRange.getValue()) {
                object = a;
                continue;
            }
            PlayerAndPredict playerAndPredict2 = playerAndPredict;
            if ((double)autoOldBurrow.calculateDamage(class_12972.method_19538(), playerAndPredict2.player, playerAndPredict2.predict) < autoOldBurrow.breakMinSelf.getValue()) {
                object = a;
                continue;
            }
            return true;
        }
        return false;
    }

    public double getPlayerSpeed(class_1657 class_16572) {
        AutoOldBurrow a = class_16572;
        AutoOldBurrow a2 = this;
        if (a2.playerSpeeds.get(a) == null) {
            return 0.0;
        }
        AutoOldBurrow autoOldBurrow = a2;
        return autoOldBurrow.turnIntoKpH(autoOldBurrow.playerSpeeds.get(a));
    }

    public AutoOldBurrow() {
        AutoOldBurrow a;
        AutoOldBurrow autoOldBurrow = a;
        super(FadeUtils.ALLATORIxDEMO("bL\u001c\u0003r\u0007^.H\u0003RT\u001d"), Module.Category.Combat);
        AutoOldBurrow autoOldBurrow2 = a;
        autoOldBurrow2.Delay = autoOldBurrow.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\n{?5`"), 100, 0, 1000));
        autoOldBurrow.pause = autoOldBurrow.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO(";[\u0019N\u0014eZ\u001e"), true));
        autoOldBurrow.speed = autoOldBurrow.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("I({\u001dn61}"), 8, 0, 20));
        autoOldBurrow.ccheck = autoOldBurrow.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("z\u0000\t^\u0000y\u001eD\u0002TZ\u0006"), true).setParent());
        autoOldBurrow.cRange = autoOldBurrow.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u001c=3|"), 5.0, 0.0, 6.0, object -> {
            Object a = object;
            AutoOldBurrow a2 = this;
            return a2.ccheck.isOpen();
        }));
        a.breakMinSelf = a.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("\u0019_\rV\"EW\f"), 12.0, 0.0, 36.0, object -> {
            Object a = object;
            AutoOldBurrow a2 = this;
            return a2.ccheck.isOpen();
        }));
        AutoOldBurrow autoOldBurrow3 = a;
        autoOldBurrow3.mcheck = autoOldBurrow3.add(new BooleanSetting(ClientInfo.ALLATORIxDEMO("\rl,`%S::|"), true).setParent());
        autoOldBurrow3.mself = autoOldBurrow3.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("\"EW\f"), true, object -> {
            Object a = object;
            AutoOldBurrow a2 = this;
            return a2.mcheck.isOpen();
        }));
        AutoOldBurrow autoOldBurrow4 = a;
        AutoOldBurrow autoOldBurrow5 = a;
        autoOldBurrow5.predictTicks = autoOldBurrow5.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("\u0006if*m*w\u001aw0?j"), 4, 0, 10));
        autoOldBurrow5.terrainIgnore = autoOldBurrow5.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("w\\\u001a\u001e\\\u0002T%Z\u001fOI\u000f"), true));
        autoOldBurrow4.playerSpeeds = new HashMap();
        autoOldBurrow4.setChinese(ClientInfo.ALLATORIxDEMO("\u81bc\u52b3Q+f\u76cdA;l!;n"));
        INSTANCE = autoOldBurrow4;
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

    public class PlayerAndPredict {
        final /* synthetic */ AutoOldBurrow this$0;
        class_1657 player;
        class_1657 predict;

        public PlayerAndPredict(AutoOldBurrow autoOldBurrow, class_1657 class_16572) {
            Iterator a;
            PlayerAndPredict a2 = class_16572;
            PlayerAndPredict a3 = this;
            a3.this$0 = a;
            a3.player = a2;
            if (((AutoOldBurrow)a).predictTicks.getValueFloat() > 0.0f) {
                PlayerAndPredict playerAndPredict = a3;
                playerAndPredict.predict = new class_1657(a3, (class_1937)Wrapper.mc.field_1687, a2.method_24515(), a2.method_36454(), new GameProfile(UUID.fromString(BlockUpUtil.ALLATORIxDEMO("\u001f \u000f3>\u0004\u0014+\u0005&.\u0010\n,\u001c\"\u001b%\b,\u0019&\u000e*Fy\u0012/\u0014.\u001d,\u000e1B}")), WebUtils.ALLATORIxDEMO("\tb+co,'_:i:n747t")), (AutoOldBurrow)((Object)a)){
                    final /* synthetic */ PlayerAndPredict this$1;
                    final /* synthetic */ AutoOldBurrow val$this$0;
                    {
                        Object a;
                        void a2;
                        void a3;
                        void a4;
                        void a5;
                        void a6;
                        1 v0 = object2;
                        Object object2 = object;
                        object = v0;
                        object.this$1 = a2;
                        object.val$this$0 = a;
                        super((class_1937)a5, (class_2338)a4, (float)a6, (GameProfile)a3);
                    }

                    public boolean method_7337() {
                        return false;
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a3.predict.method_33574(a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, AutoOldBurrow.INSTANCE.predictTicks.getValueInt(), true)));
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
