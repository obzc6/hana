/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1743
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1829
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2815
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_7202
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.entity;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IClientWorld;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.Iterator;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2815;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_7202;
import net.minecraft.class_746;

public class EntityUtil
implements Wrapper {
    public static boolean rotating = false;

    public static void sendYawAndPitch(float f, float f2) {
        float a = f2;
        float a2 = f;
        EntityUtil.sendLook((class_2828)new class_2828.class_2831(a2, a, EntityUtil.mc.field_1724.method_24828()));
    }

    public static void syncInventory() {
        if (CombatSetting.INSTANCE.inventorySync.getValue()) {
            EntityUtil.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(EntityUtil.mc.field_1724.field_7512.field_7763));
        }
    }

    public static boolean canSee(class_2338 class_23382, class_2350 class_23502) {
        class_2338 a = class_23502;
        class_2338 a2 = class_23382;
        a = a2.method_46558().method_1031((double)a.method_10163().method_10263() * 0.5, (double)a.method_10163().method_10264() * 0.5, (double)a.method_10163().method_10260() * 0.5);
        a = EntityUtil.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), (class_243)a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)EntityUtil.mc.field_1724));
        return a == null || a.method_17783() == class_239.class_240.field_1333;
    }

    public static class_2338 getPlayerPos() {
        return new BlockPosX(EntityUtil.mc.field_1724.method_19538());
    }

    public static class_2338 getEntityPos(class_1297 class_12972, boolean bl) {
        boolean a = bl;
        class_1297 a2 = class_12972;
        return new BlockPosX(a2.method_19538(), a);
    }

    public static void facePosSide(class_2338 class_23382, class_2350 class_23502) {
        class_2338 a = class_23502;
        class_2338 a2 = class_23382;
        EntityUtil.faceVector(a2.method_46558().method_1019(new class_243((double)a.method_10163().method_10263() * 0.5, (double)a.method_10163().method_10264() * 0.5, (double)a.method_10163().method_10260() * 0.5)));
    }

    public static float[] getLegitRotations(class_243 a2) {
        class_243 class_2432 = a2;
        a2 = EntityUtil.getEyesPos();
        class_243 class_2433 = class_2432;
        double d = class_2433.field_1352 - a2.field_1352;
        double d2 = class_2433.field_1351 - a2.field_1351;
        double d3 = class_2433.field_1350 - a2.field_1350;
        double d4 = d;
        double d5 = d3;
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        float a2 = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f = (float)(-Math.toDegrees(Math.atan2(d2, d6)));
        float[] arrf = new float[2];
        arrf[0] = EntityUtil.mc.field_1724.method_36454() + class_3532.method_15393((float)(a2 - EntityUtil.mc.field_1724.method_36454()));
        arrf[1] = EntityUtil.mc.field_1724.method_36455() + class_3532.method_15393((float)(f - EntityUtil.mc.field_1724.method_36455()));
        return arrf;
    }

    static class_7202 getUpdateManager(class_638 a) {
        return ((IClientWorld)a).acquirePendingUpdateManager();
    }

    public static class_243 getEyesPos() {
        return EntityUtil.mc.field_1724.method_33571();
    }

    /*
     * Exception decompiling
     */
    public static void swingHand(class_1268 a, SwingSide a) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[DOLOOP]], but top level block is 1[CASE]
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

    public static boolean isArmorLow(class_1657 a, int a2) {
        Iterator iterator;
        class_1657 class_16572 = a;
        Iterator iterator2 = iterator = class_16572.method_5661().iterator();
        while (iterator2.hasNext()) {
            a = (class_1799)iterator.next();
            if (a == null || a.method_7960()) {
                return true;
            }
            if (EntityUtil.getDamagePercent((class_1799)a) >= a2) {
                iterator2 = iterator;
                continue;
            }
            return true;
        }
        return false;
    }

    public static void faceVectorNoStay(class_243 a) {
        float[] arrf = a;
        a = EntityUtil.getLegitRotations((class_243)arrf);
        if (a[0] == Hana.ROTATE.lastYaw && a[1] == Hana.ROTATE.lastPitch) {
            return;
        }
        EntityUtil.sendLook((class_2828)new class_2828.class_2831(a[0], a[1], EntityUtil.mc.field_1724.method_24828()));
    }

    public static boolean isElytraFlying() {
        return EntityUtil.mc.field_1724.method_6128();
    }

    public static boolean isHoldingWeapon(class_1657 a) {
        return a.method_6047().method_7909() instanceof class_1829 || a.method_6047().method_7909() instanceof class_1743;
    }

    public EntityUtil() {
        EntityUtil a;
    }

    public static class_2338 getPlayerPos(boolean a) {
        return new BlockPosX(EntityUtil.mc.field_1724.method_19538(), a);
    }

    public static boolean isUsing() {
        return EntityUtil.mc.field_1724.method_6115();
    }

    public static boolean isInsideBlock() {
        if (BlockUtil.getBlock(EntityUtil.getPlayerPos(true)) == class_2246.field_10443) {
            return true;
        }
        return EntityUtil.mc.field_1687.method_39454((class_1297)EntityUtil.mc.field_1724, EntityUtil.mc.field_1724.method_5829());
    }

    public static int getWorldActionId(class_638 a2) {
        class_638 class_6382 = a2;
        class_7202 class_72022 = EntityUtil.getUpdateManager(class_6382);
        int a2 = class_72022.method_41942();
        class_72022.close();
        return a2;
    }

    public static void sendLook(class_2828 a) {
        if (!a.method_36172() || a.method_12271(114514.0f) == Hana.ROTATE.lastYaw && a.method_12270(114514.0f) == Hana.ROTATE.lastPitch) {
            return;
        }
        rotating = true;
        Hana.ROTATE.setRotation(a.method_12271(0.0f), a.method_12270(0.0f), true);
        EntityUtil.mc.field_1724.field_3944.method_52787((class_2596)a);
        rotating = false;
    }

    public static boolean isInWeb() {
        int n;
        class_238 class_2383 = EntityUtil.mc.field_1724.method_5829();
        class_2338 class_23382 = class_2338.method_49638((class_2374)EntityUtil.mc.field_1724.method_19538());
        int n2 = n = class_23382.method_10263() - 2;
        while (n2 <= class_23382.method_10263() + 2) {
            int n3 = class_23382.method_10264() - 1;
            while (n3 <= class_23382.method_10264() + 4) {
                int n4;
                int n5 = class_23382.method_10260() - 2;
                while (n5 <= class_23382.method_10260() + 2) {
                    int n6;
                    class_2338 class_23383 = new class_2338(n, n4, n6);
                    if (class_2383.method_994(new class_238(class_23383)) && EntityUtil.mc.field_1687.method_8320(class_23383).method_26204() == class_2246.field_10343) {
                        return true;
                    }
                    n5 = ++n6;
                }
                n3 = ++n4;
            }
            n2 = ++n;
        }
        return false;
    }

    public static class_2338 getEntityPos(class_1297 a) {
        return new BlockPosX(a.method_19538());
    }

    public static int getDamagePercent(class_1799 a) {
        return (int)((double)(a.method_7936() - a.method_7919()) / Math.max(0.1, (double)a.method_7936()) * 100.0);
    }

    public static void facePosSideNoStay(class_2338 class_23382, class_2350 class_23502) {
        class_2338 a = class_23502;
        class_2338 a2 = class_23382;
        EntityUtil.faceVectorNoStay(a2.method_46558().method_1019(new class_243((double)a.method_10163().method_10263() * 0.5, (double)a.method_10163().method_10264() * 0.5, (double)a.method_10163().method_10260() * 0.5)));
    }

    public static float getHealth(class_1297 a) {
        class_1297 class_12972 = a;
        if (class_12972.method_5709()) {
            a = (class_1309)class_12972;
            return a.method_6032() + a.method_6067();
        }
        return 0.0f;
    }

    public static void faceVector(class_243 a) {
        float[] arrf = a;
        RotateManager.ROTATE_TIMER.reset();
        RotateManager.directionVec = arrf;
        a = EntityUtil.getLegitRotations(RotateManager.directionVec);
        if (a[0] == Hana.ROTATE.lastYaw && a[1] == Hana.ROTATE.lastPitch) {
            return;
        }
        EntityUtil.sendLook((class_2828)new class_2828.class_2831(a[0], a[1], EntityUtil.mc.field_1724.method_24828()));
    }

}
