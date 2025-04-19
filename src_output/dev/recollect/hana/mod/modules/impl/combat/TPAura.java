/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1320
 *  net.minecraft.class_1429
 *  net.minecraft.class_1621
 *  net.minecraft.class_1646
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_4048
 *  net.minecraft.class_4587
 *  net.minecraft.class_5134
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.google.common.collect.Lists;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.PathUtils;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.asm.accessors.IEntity;
import dev.recollect.hana.asm.accessors.ILivingEntity;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1320;
import net.minecraft.class_1429;
import net.minecraft.class_1621;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_4048;
import net.minecraft.class_4587;
import net.minecraft.class_5134;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class TPAura
extends Module {
    private final BooleanSetting test;
    int attackTicks;
    public static boolean attacking = false;
    public final BooleanSetting Players;
    private final Timer tick;
    private final BooleanSetting whileEating;
    private final EnumSetting<TargetMode> targetMode;
    public final BooleanSetting Villagers;
    public final BooleanSetting Slimes;
    private final EnumSetting<Aura.Cooldown> cd;
    private ArrayList<Vec3> lastPath;
    public final SliderSetting range;
    public final BooleanSetting Animals;
    private final BooleanSetting cc;
    private final EnumSetting<SwingSide> swingMode;
    private final SliderSetting cooldown;
    public static class_1309 target;
    public final BooleanSetting Mobs;
    private final BooleanSetting weaponOnly;
    public static TPAura INSTANCE;
    public final EnumSetting<Page> page;

    @Override
    public void onUpdate() {
        TPAura a;
        if (a.tick.passed(50L)) {
            TPAura tPAura = a;
            ++tPAura.attackTicks;
            tPAura.tick.reset();
        }
        if (a.weaponOnly.getValue() && !EntityUtil.isHoldingWeapon((class_1657)TPAura.mc.field_1724)) {
            target = null;
            return;
        }
        target = a.getTarget();
        if (target == null) {
            return;
        }
        if (a.auraReady()) {
            a.doTPHit(target);
            return;
        }
        target = null;
    }

    public static float getAttackCooldownProgressPerTick() {
        return (float)(1.0 / TPAura.mc.field_1724.method_26825(class_5134.field_23723) * 20.0);
    }

    private /* synthetic */ class_1309 getTarget() {
        TPAura a;
        TPAura tPAura = a;
        TPAura tPAura2 = null;
        double d = tPAura.range.getValue();
        double d2 = 36.0;
        Iterator iterator = TPAura.mc.field_1687.method_18112().iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                a = (class_1297)iterator.next();
                if (!(a instanceof class_1309)) continue block0;
                if (!tPAura.isEnemy((class_1297)(a = (class_1309)a))) {
                    iterator2 = iterator;
                    continue;
                }
                if (!CombatUtil.isValid((class_1297)a, tPAura.range.getValue())) {
                    iterator2 = iterator;
                    continue;
                }
                if (tPAura2 == null) {
                    tPAura2 = a;
                    d = TPAura.mc.field_1724.method_5739((class_1297)a);
                    d2 = EntityUtil.getHealth((class_1297)a);
                    continue block0;
                }
                if (tPAura2 instanceof class_1657 && EntityUtil.isArmorLow((class_1657)a, 10)) {
                    tPAura2 = a;
                    return tPAura2;
                }
                if (tPAura.targetMode.getValue() == TargetMode.HEALTH && (double)EntityUtil.getHealth((class_1297)a) < d2) {
                    tPAura2 = a;
                    d2 = EntityUtil.getHealth((class_1297)tPAura2);
                    iterator2 = iterator;
                    continue;
                }
                if (tPAura.targetMode.getValue() != TargetMode.DISTANCE || !((double)TPAura.mc.field_1724.method_5739((class_1297)a) < d)) continue block0;
                tPAura2 = a;
                d = TPAura.mc.field_1724.method_5739((class_1297)a);
                continue block0;
            }
            break;
        } while (true);
        return tPAura2;
    }

    private /* synthetic */ boolean isEnemy(class_1297 class_12972) {
        TPAura a = class_12972;
        TPAura a2 = this;
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

    public TPAura() {
        TPAura a;
        TPAura tPAura = a;
        super(BlockUpUtil.ALLATORIxDEMO("qJyr\u0000,"), ProjectionUtils.ALLATORIxDEMO(" _\u0019H\fM\u0013\u0005\u0013\\\u0017\u0013Ib%4;kcC\u0016R\u0019P\u0010"), Module.Category.Combat);
        TPAura tPAura2 = a;
        tPAura2.page = tPAura.add(new EnumSetting<Page>(BlockUpUtil.ALLATORIxDEMO("hf\u0015("), Page.General));
        tPAura.range = tPAura.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("%W\u001eB\u0006"), 60.0, 0.10000000149011612, 250.0, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.cooldown = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("arJv\\h\u0005#"), 1.100000023841858, 0.0, 1.2000000476837158, 0.01, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        TPAura tPAura3 = a;
        tPAura3.cd = tPAura3.add(new EnumSetting<Aura.Cooldown>(ProjectionUtils.ALLATORIxDEMO("S9{>a,F\u0019{\u001fA\u0006"), Aura.Cooldown.Delay));
        tPAura3.whileEating = tPAura3.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("rrKq@OKn\u001c*"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.cc = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("#f?C\u0005"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.test = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("NrRC|lb\u00019"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.weaponOnly = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("C7d3^\u0019y\u001eI\u001a"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(BlockUpUtil.ALLATORIxDEMO("IOn\u001c*"), SwingSide.Server, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetMode = a.add(new EnumSetting<TargetMode>(ProjectionUtils.ALLATORIxDEMO("w\u001eZ\u0004@\u0011"), TargetMode.DISTANCE, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Players = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("MI{Ab\u0000>"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Mobs = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("{\u001fG\u0010"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Animals = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("\\KsUf\u001e>"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Villagers = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\u0004l/]\u0016Q\u0015W\u0010"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.Slimes = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("vvQj\u0017>"), true, object -> {
            Object a = object;
            TPAura a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        TPAura tPAura4 = a;
        tPAura4.tick = new Timer();
        tPAura4.setChinese(ProjectionUtils.ALLATORIxDEMO("\u4f16\u9071\u6765\u624d"));
        INSTANCE = tPAura4;
    }

    private /* synthetic */ boolean auraReady() {
        TPAura tPAura;
        TPAura a22;
        TPAura tPAura2 = tPAura = a22;
        int a22 = tPAura2.attackTicks;
        if (tPAura2.cd.getValue() == Aura.Cooldown.Vanilla) {
            a22 = ((ILivingEntity)TPAura.mc.field_1724).getLastAttackedTicks();
        }
        if (!((double)Math.max((float)a22 / TPAura.getAttackCooldownProgressPerTick(), 0.0f) >= tPAura.cooldown.getValue())) {
            return false;
        }
        return tPAura.whileEating.getValue() || !TPAura.mc.field_1724.method_6115();
    }

    private /* synthetic */ void doTPHit(class_1309 class_13092) {
        Object a2 = class_13092;
        TPAura a3 = this;
        attacking = true;
        a2 = PathUtils.computePath((class_1309)TPAura.mc.field_1724, (class_1309)a2);
        TPAura tPAura = a3;
        tPAura.lastPath = new ArrayList(a2);
        a2.forEach(a -> TPAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(a.getX(), a.getY(), a.getZ(), false)));
        TPAura.mc.field_1761.method_2918((class_1657)TPAura.mc.field_1724, (class_1297)target);
        EntityUtil.swingHand(class_1268.field_5808, a3.swingMode.getValue());
        a2 = Lists.reverse((List)a2);
        a2.forEach(a -> TPAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(a.getX(), a.getY(), a.getZ(), false)));
        if (a3.test.getValue()) {
            TPAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, -0.354844, 0.0, false));
            TPAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, 0.325488, 0.0, false));
            TPAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, -0.15441, 0.0, false));
            TPAura.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(0.0, -0.15444, 0.0, false));
        }
        attacking = false;
        a3.attackTicks = 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        TPAura a2 = this;
        if (a2.tick.passed(50L)) {
            TPAura tPAura = a2;
            ++tPAura.attackTicks;
            tPAura.tick.reset();
        }
        if (a2.lastPath != null) {
            Iterator<Vec3> iterator = a = a2.lastPath.iterator();
            while (iterator.hasNext()) {
                void a3;
                Vec3 vec3 = a.next();
                Render3DUtil.draw3DBox((class_4587)a3, ((IEntity)TPAura.mc.field_1724).getDimensions().method_30757(vec3.mc()), new Color(255, 255, 255, 150), true, true);
                iterator = a;
            }
        }
    }

    public static final class Page
    extends Enum<Page> {
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General = new Page(BetterDynamicAnimation.ALLATORIxDEMO("dC|EfCz"), 0);
        public static final /* enum */ Page Target = new Page(BOEntityUtils.ALLATORIxDEMO("F_f_sN"), 1);

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

        static {
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Target;
            return arrpage;
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }
    }

    private static final class TargetMode
    extends Enum<TargetMode> {
        private static final /* synthetic */ TargetMode[] $VALUES;
        public static final /* enum */ TargetMode HEALTH;
        public static final /* enum */ TargetMode DISTANCE;

        public static TargetMode valueOf(String a) {
            return Enum.valueOf(TargetMode.class, a);
        }

        static {
            DISTANCE = new TargetMode(GameInfo.ALLATORIxDEMO("taA^XO[E"), 0);
            HEALTH = new TargetMode(SocketClient.ALLATORIxDEMO("iAkCF"), 1);
            $VALUES = TargetMode.$values();
        }

        private static /* synthetic */ TargetMode[] $values() {
            TargetMode[] arrtargetMode = new TargetMode[2];
            arrtargetMode[0] = DISTANCE;
            arrtargetMode[1] = HEALTH;
            return arrtargetMode;
        }

        public static TargetMode[] values() {
            return (TargetMode[])$VALUES.clone();
        }

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
    }

}
