/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1927
 *  net.minecraft.class_1927$class_4179
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_2824
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Pair;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ExplosionUtil;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import dev.recollect.hana.xibao.Snow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_2824;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class PushCleaner
extends Module {
    private float lastYaw;
    private final Timer delayTimer;
    BooleanSetting random;
    BooleanSetting burOnly;
    BooleanSetting onBreak;
    SliderSetting maxSelfDmg;
    public static final Timer placeTimer = new Timer();
    BooleanSetting rotate;
    BooleanSetting yawStep;
    public final Timer lastBreakTimer;
    SliderSetting updateDelay;
    SliderSetting placeDelay;
    private float lastPitch;
    BooleanSetting packet;
    BooleanSetting checkLook;
    SliderSetting wallRange;
    SliderSetting steps;
    public class_243 directionVec;
    BooleanSetting checkRedstone;
    SliderSetting placeRange;
    EnumSetting<SwingSide> swingMode;
    EnumSetting<SwapMode> autoSwap;
    EnumSetting<Page> page;
    BooleanSetting checkFeetPush;
    BooleanSetting eatingPause;
    SliderSetting breakDelay;
    SliderSetting fov;

    public List<class_2338> getRedStonePos() {
        PushCleaner a;
        int n;
        PushCleaner pushCleaner = a;
        class_2338[] arrclass_2338 = new BlockPosX(PushCleaner.mc.field_1724.method_23317() + 0.3, PushCleaner.mc.field_1724.method_23318() + 0.5, PushCleaner.mc.field_1724.method_23321() + 0.3);
        BlockPosX blockPosX = new BlockPosX(PushCleaner.mc.field_1724.method_23317() - 0.3, PushCleaner.mc.field_1724.method_23318() + 0.5, PushCleaner.mc.field_1724.method_23321() + 0.3);
        BlockPosX blockPosX2 = new BlockPosX(PushCleaner.mc.field_1724.method_23317() + 0.3, PushCleaner.mc.field_1724.method_23318() + 0.5, PushCleaner.mc.field_1724.method_23321() - 0.3);
        BlockPosX blockPosX3 = new BlockPosX(PushCleaner.mc.field_1724.method_23317() - 0.3, PushCleaner.mc.field_1724.method_23318() + 0.5, PushCleaner.mc.field_1724.method_23321() - 0.3);
        class_2350[] arrclass_2350 = EntityUtil.getPlayerPos(true);
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        class_2338[] arrclass_23382 = new class_2338[5];
        arrclass_23382[0] = arrclass_2350;
        arrclass_23382[1] = arrclass_2338;
        arrclass_23382[2] = blockPosX;
        arrclass_23382[3] = blockPosX2;
        arrclass_23382[4] = blockPosX3;
        arrclass_2338 = arrclass_23382;
        int n2 = arrclass_23382.length;
        int n3 = n = 0;
        while (n3 < n2) {
            int n4;
            blockPosX3 = arrclass_2338[n];
            arrclass_2350 = class_2350.values();
            int n5 = arrclass_2350.length;
            int n6 = n4 = 0;
            while (n6 < n5) {
                class_2350 class_23502 = arrclass_2350[n4];
                if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && !pushCleaner.checkSelf((class_2338)(class_23502 = blockPosX3.method_10093(class_23502)))) {
                    int n7;
                    int[] arrn = new int[2];
                    arrn[0] = 0;
                    arrn[1] = 1;
                    int[] arrn2 = arrn;
                    int n8 = arrn.length;
                    int n9 = n7 = 0;
                    while (n9 < n8) {
                        int n10 = arrn2[n7];
                        if (n10 != 0 || pushCleaner.checkFeetPush.getValue()) {
                            class_2338 class_23382 = class_23502.method_10086(n10);
                            if (BlockUtil.getBlock(class_23382) instanceof class_2665) {
                                arrayList.add(class_23382);
                            }
                            if (pushCleaner.checkRedstone.getValue() && BlockUtil.isAir(class_23382)) {
                                int n11;
                                class_2350[] arrclass_23502 = class_2350.values();
                                int n12 = arrclass_23502.length;
                                int n13 = n11 = 0;
                                while (n13 < n12) {
                                    a = arrclass_23502[n11];
                                    if (a != class_2350.field_11036 && a != class_2350.field_11033 && !pushCleaner.checkSelf((class_2338)(a = class_23382.method_10093((class_2350)a))) && !arrayList.contains(a) && BlockUtil.getBlock((class_2338)a) == class_2246.field_10002) {
                                        arrayList.add((class_2338)a);
                                    }
                                    n13 = ++n11;
                                }
                            }
                        }
                        n9 = ++n7;
                    }
                }
                n6 = ++n4;
            }
            n3 = ++n;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private /* synthetic */ boolean checkSelf(class_2338 class_23382) {
        PushCleaner a = class_23382;
        PushCleaner a2 = this;
        return PushCleaner.mc.field_1724.method_5829().method_994(new class_238((class_2338)a));
    }

    private /* synthetic */ int getCrystal() {
        PushCleaner a;
        if (a.autoSwap.getValue() == SwapMode.Silent || a.autoSwap.getValue() == SwapMode.Normal) {
            return InventoryUtil.findItem(class_1802.field_8301);
        }
        if (a.autoSwap.getValue() == SwapMode.Inventory) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return -1;
    }

    public boolean behindWall(class_2338 class_23382) {
        PushCleaner a = class_23382;
        PushCleaner a2 = this;
        class_243 class_2432 = CombatSetting.INSTANCE.lowVersion.getValue() ? new class_243((double)a.method_10263() + 0.5, (double)a.method_10264(), (double)a.method_10260() + 0.5) : new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        class_2432 = PushCleaner.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), class_2432, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)PushCleaner.mc.field_1724));
        if (class_2432 == null || class_2432.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return PushCleaner.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > a2.wallRange.getValue();
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        void a2;
        class_2338 a3;
        PushCleaner pushCleaner = this;
        a3 = a3.method_10074();
        PushCleaner a4 = a3.method_10084();
        return !(BlockUtil.getBlock(a3) != class_2246.field_9987 && BlockUtil.getBlock(a3) != class_2246.field_10540 || BlockUtil.getClickSideStrict(a3) == null || pushCleaner.hasEntityBlockCrystal((class_2338)a4, (boolean)a2, (boolean)a) || pushCleaner.hasEntityBlockCrystal(a4.method_10084(), (boolean)a2, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10124 && (!pushCleaner.hasEntityBlockCrystal((class_2338)a4, false, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a4.method_10084()) != class_2246.field_10124);
    }

    private /* synthetic */ void doPlace(class_2338 a) {
        PushCleaner a22;
        PushCleaner pushCleaner = a22;
        if (!(PushCleaner.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || PushCleaner.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) || pushCleaner.findCrystal())) {
            return;
        }
        if (!pushCleaner.canTouch(a.method_10074())) {
            return;
        }
        class_2338 class_23382 = a.method_10074();
        a22 = BlockUtil.getClickSide(class_23382);
        a22 = class_23382.method_46558().method_1031((double)a22.method_10163().method_10263() * 0.5, (double)a22.method_10163().method_10264() * 0.5, (double)a22.method_10163().method_10260() * 0.5);
        if (pushCleaner.rotate.getValue() && !pushCleaner.faceVector((class_243)a22)) {
            return;
        }
        if (!placeTimer.passedMs((long)pushCleaner.placeDelay.getValue())) {
            return;
        }
        placeTimer.reset();
        if (PushCleaner.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || PushCleaner.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301)) {
            pushCleaner.placeCrystal(a);
            return;
        }
        if (pushCleaner.findCrystal()) {
            int a22 = PushCleaner.mc.field_1724.method_31548().field_7545;
            int n = pushCleaner.getCrystal();
            if (n == -1) {
                return;
            }
            PushCleaner pushCleaner2 = pushCleaner;
            pushCleaner2.doSwap(n);
            pushCleaner2.placeCrystal(a);
            if (pushCleaner.autoSwap.getValue() == SwapMode.Silent) {
                pushCleaner.doSwap(a22);
                return;
            }
            if (pushCleaner.autoSwap.getValue() == SwapMode.Inventory) {
                pushCleaner.doSwap(n);
                EntityUtil.syncInventory();
            }
        }
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.rotate.getValue() && arrf.yawStep.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.steps.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            if (arrf2.random.getValue() && new Random().nextBoolean()) {
                float[] arrf3 = arrf;
                arrf.lastPitch = Math.min(new Random().nextFloat() * 2.0f + arrf.lastPitch, 90.0f);
            }
            RotateEvent rotateEvent = a;
            float[] arrf4 = arrf;
            rotateEvent.setYaw(arrf4.lastYaw);
            rotateEvent.setPitch(arrf4.lastPitch);
            return;
        }
        float[] arrf5 = arrf;
        arrf5.lastYaw = Hana.ROTATE.lastYaw;
        arrf5.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ boolean findCrystal() {
        PushCleaner a;
        if (a.autoSwap.getValue() == SwapMode.Off) {
            return false;
        }
        return a.getCrystal() != -1;
    }

    /*
     * WARNING - void declaration
     */
    public void tryMergeStack(List<Pair<class_1799, class_2338>> list, class_1799 class_17992, class_2338 class_23382) {
        void a;
        void a2;
        void a3;
        int a4;
        PushCleaner pushCleaner = this;
        int n = a4 = 0;
        while (n < a2.size()) {
            Pair pair = (Pair)a2.get(a4);
            class_1799 class_17993 = (class_1799)pair.getFirst();
            if (class_1542.method_24017((class_1799)class_17993, (class_1799)a3)) {
                a2.set(a4, Pair.of((Object)class_1542.method_24018((class_1799)class_17993, (class_1799)a3, (int)16), (Object)((class_2338)pair.getSecond())));
                if (a3.method_7960()) {
                    return;
                }
            }
            n = ++a4;
        }
        a2.add(Pair.of((Object)a3, (Object)a));
    }

    public float getExposure(class_243 a, class_2338 a2) {
        PushCleaner a3;
        PushCleaner pushCleaner = a3;
        a3 = new class_238(a2);
        double d = 1.0 / ((((class_238)a3).field_1320 - ((class_238)a3).field_1323) * 2.0 + 1.0);
        double d2 = 1.0 / ((((class_238)a3).field_1325 - ((class_238)a3).field_1322) * 2.0 + 1.0);
        double d3 = 1.0 / ((((class_238)a3).field_1324 - ((class_238)a3).field_1321) * 2.0 + 1.0);
        double d4 = (1.0 - Math.floor(1.0 / d) * d) / 2.0;
        double d5 = (1.0 - Math.floor(1.0 / d3) * d3) / 2.0;
        if (!(d < 0.0 || d2 < 0.0 || d3 < 0.0)) {
            double d6;
            int n = 0;
            int n2 = 0;
            double d7 = d6 = 0.0;
            while (d7 <= 1.0) {
                double d8;
                double d9 = d8 = 0.0;
                while (d9 <= 1.0) {
                    double d10;
                    double d11 = d10 = 0.0;
                    while (d11 <= 1.0) {
                        double d12;
                        double d13;
                        double d14 = class_3532.method_16436((double)d6, (double)((class_238)a3).field_1323, (double)((class_238)a3).field_1320);
                        class_243 class_2432 = new class_243(d14 + d4, d13 = class_3532.method_16436((double)d8, (double)((class_238)a3).field_1322, (double)((class_238)a3).field_1325), (d12 = class_3532.method_16436((double)d10, (double)((class_238)a3).field_1321, (double)((class_238)a3).field_1324)) + d5);
                        if (PushCleaner.mc.field_1687.method_17742(new class_3959(class_2432, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)new PlayerAndPredict((PushCleaner)pushCleaner, (class_2338)a2).predict)).method_17783() == class_239.class_240.field_1333) {
                            ++n;
                        }
                        ++n2;
                        d11 = d10 + d3;
                    }
                    d9 = d8 + d2;
                }
                d7 = d6 + d;
            }
            return (float)n / (float)n2;
        }
        return 0.0f;
    }

    private /* synthetic */ boolean canTouch(class_2338 a) {
        PushCleaner a2;
        PushCleaner pushCleaner = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(PushCleaner.mc.field_1724.method_33571()) <= pushCleaner.placeRange.getValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onUpdate() {
        PushCleaner a;
        PushCleaner pushCleaner = a;
        if (PushCleaner.nullCheck()) {
            return;
        }
        if (pushCleaner.burOnly.getValue() && !EntityUtil.isInsideBlock()) {
            return;
        }
        if (pushCleaner.eatingPause.getValue() && PushCleaner.mc.field_1724.method_6115()) {
            return;
        }
        PushCleaner pushCleaner2 = pushCleaner;
        if (!pushCleaner2.delayTimer.passedMs((long)pushCleaner2.updateDelay.getValue())) {
            return;
        }
        pushCleaner.delayTimer.reset();
        List<class_2338> list = pushCleaner.getRedStonePos();
        if (list == null) {
            return;
        }
        if (EntityUtil.isInsideBlock() || !pushCleaner.burOnly.getValue()) {
            Iterator<class_2338> iterator;
            Iterator<class_2338> iterator2 = iterator = BlockUtil.getSphere(pushCleaner.placeRange.getValueFloat()).iterator();
            while (iterator2.hasNext()) {
                class_2338 class_23382;
                a = iterator.next();
                if ((double)class_23382.method_10264() - PushCleaner.mc.field_1724.method_23318() > 2.0) {
                    iterator2 = iterator;
                    continue;
                }
                if (!pushCleaner.canTouch(a.method_10074())) {
                    iterator2 = iterator;
                    continue;
                }
                if (!pushCleaner.canPlaceCrystal((class_2338)a, true, false)) {
                    iterator2 = iterator;
                    continue;
                }
                if (!pushCleaner.canExplodeReach((class_2338)a, list.get(0), 6.0f)) {
                    iterator2 = iterator;
                    continue;
                }
                if ((double)ExplosionUtil.calculateDamage(a.method_10263(), a.method_10264(), a.method_10260(), (class_1297)PushCleaner.mc.field_1724, (class_1297)PushCleaner.mc.field_1724, 6.0f) > pushCleaner.maxSelfDmg.getValue()) {
                    iterator2 = iterator;
                    continue;
                }
                PushCleaner pushCleaner3 = pushCleaner;
                PushCleaner pushCleaner4 = a;
                pushCleaner3.doPlace((class_2338)pushCleaner4);
                pushCleaner3.doBreak((class_2338)pushCleaner4);
                iterator2 = iterator;
            }
        }
        list.clear();
    }

    /*
     * WARNING - void declaration
     */
    public boolean willBlockBeDestroyedByExplosion(class_1937 class_19372, class_2338 class_23382, class_2338 class_23383, float f) {
        float f2;
        void a42;
        void a;
        void a322;
        PushCleaner a22 = class_19372;
        PushCleaner a5 = this;
        class_1927 a322 = new class_1927((class_1937)a22, null, (double)a42.method_10263(), (double)a42.method_10264(), (double)a42.method_10260(), (float)a322, false, class_1927.class_4179.field_18687);
        a22 = a22.method_8320((class_2338)a);
        float a322 = 2.0f * a322.method_55107();
        double d = (double)class_3532.method_15355((float)((float)a42.method_10262((class_2382)a))) / (double)a322;
        float a22 = a5.getExposure(a42.method_46558(), (class_2338)a);
        float a42 = a22.method_26204().method_9520();
        a22 = (float)((1.0 - d) * (double)a22);
        if (f2 > a42) {
            CommandManager.sendChatMessage(String.valueOf(a22));
        }
        return (double)a22 > (double)a42 * 3.5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean canExplodeReach(class_2338 class_23382, class_2338 class_23383, float f) {
        class_243 a;
        double d;
        Object a2 = class_23383;
        PushCleaner a3 = this;
        if (a.method_10264() > a2.method_10264()) {
            return false;
        }
        a = new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 0.5, (double)a.method_10260() + 0.5);
        a2 = new class_243((double)a2.method_10263() + 0.5, (double)a2.method_10264() + 0.5, (double)a2.method_10260() + 0.5);
        class_243 class_2432 = a2.method_1020(a).method_1029();
        double d2 = a.method_1022((class_243)a2);
        double d3 = 0.5;
        double d4 = d = 0.0;
        while (d4 < d2) {
            void a4;
            a2 = a.method_1019(class_2432.method_1021(d));
            a2 = new BlockPosX((class_243)a2);
            if (!(a2 = PushCleaner.mc.field_1687.method_8320((class_2338)a2)).method_26215() && a2.method_26204().method_9520() > a4) {
                return false;
            }
            d4 = d + d3;
        }
        return true;
    }

    public boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.yawStep.getValue()) {
            EntityUtil.faceVector((class_243)a);
            return true;
        }
        a2.directionVec = a;
        a = EntityUtil.getLegitRotations((class_243)a);
        if (Math.abs(class_3532.method_15393((float)(arrf[0] - a2.lastYaw))) < a2.fov.getValueFloat() && Math.abs(class_3532.method_15393((float)(a[1] - a2.lastPitch))) < a2.fov.getValueFloat()) {
            if (a2.packet.getValue()) {
                EntityUtil.sendYawAndPitch(a[0], a[1]);
            }
            return true;
        }
        return !a2.checkLook.getValue();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean hasEntityBlockCrystal(class_2338 var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        a = PushCleaner.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = a;
            while (v0.hasNext() != false) {
                a = (class_1297)a.next();
                if (!a.method_5805() || a != false && a instanceof class_1542) ** GOTO lbl-1000
                if (a instanceof class_1531 && CombatSetting.INSTANCE.obsMode.getValue()) {
                    v0 = a;
                    continue;
                }
                if (a instanceof class_1511 == false) return true;
                if (a == false) {
                    return true;
                }
                if (PushCleaner.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(PushCleaner.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return true;
                v0 = a;
            }
            return false;
            break;
        } while (true);
    }

    public void placeCrystal(class_2338 a) {
        PushCleaner a22;
        PushCleaner pushCleaner = a22;
        boolean a22 = PushCleaner.mc.field_1724.method_6079().method_7909() == class_1802.field_8301;
        class_2338 class_23382 = a.method_10074();
        BlockUtil.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), false, a22 ? class_1268.field_5810 : class_1268.field_5808, SwingSide.All);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        PushCleaner a3 = this;
        if (a2 < 0.01f) {
            a2 = 0.01f;
        }
        if (a2 > 1.0f) {
            a2 = 1.0f;
        }
        if (a2 < 1.0f && a != null) {
            float f2;
            void v2;
            float f3 = a3.lastYaw;
            float f4 = class_3532.method_15393((float)(a[0] - f3));
            if (Math.abs(f2) > 90.0f * a2) {
                float f5 = f4;
                a[0] = f3 + f5 * (90.0f * a2 / Math.abs(f5));
            }
            f3 = a3.lastPitch;
            f4 = a[1] - f3;
            if (Math.abs((float)v2) > 90.0f * a2) {
                float f6 = f4;
                a[1] = f3 + f6 * (90.0f * a2 / Math.abs(f6));
            }
        }
        float[] arrf2 = new float[2];
        arrf2[0] = a[0];
        arrf2[1] = a[1];
        return arrf2;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        PushCleaner a2 = this;
        if (a2.autoSwap.getValue() == SwapMode.Silent || a2.autoSwap.getValue() == SwapMode.Normal) {
            InventoryUtil.switchToSlot(a);
            return;
        }
        if (a2.autoSwap.getValue() == SwapMode.Inventory) {
            InventoryUtil.inventorySwap(a, PushCleaner.mc.field_1724.method_31548().field_7545);
        }
    }

    private /* synthetic */ void doBreak(class_2338 class_23382) {
        Object a = class_23382;
        PushCleaner a2 = this;
        a2.lastBreakTimer.reset();
        if (!CombatUtil.breakTimer.passedMs((long)a2.breakDelay.getValue())) {
            return;
        }
        if ((a = PushCleaner.mc.field_1687.method_18467(class_1511.class, new class_238((double)a.method_10263(), (double)a.method_10264(), (double)a.method_10260(), (double)(a.method_10263() + 1), (double)(a.method_10264() + 2), (double)(a.method_10260() + 1))).iterator()).hasNext()) {
            a = (class_1511)a.next();
            if (a2.rotate.getValue() && a2.onBreak.getValue() && !a2.faceVector(a.method_19538().method_1031(0.0, 0.25, 0.0))) {
                return;
            }
            CombatUtil.breakTimer.reset();
            PushCleaner.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34206((class_1297)a, (boolean)PushCleaner.mc.field_1724.method_5715()));
            EntityUtil.swingHand(class_1268.field_5808, a2.swingMode.getValue());
            return;
        }
    }

    @Override
    public void onEnable() {
        PushCleaner a;
        a.lastYaw = Hana.ROTATE.lastYaw;
        a.lastPitch = Hana.ROTATE.lastPitch;
        a.lastBreakTimer.reset();
    }

    public PushCleaner() {
        PushCleaner a;
        PushCleaner pushCleaner = a;
        super(NCPRaytracer.ALLATORIxDEMO("x{RbfiOoO|D"), dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("<L\u0002dt`\"e5bj5g+s"), Module.Category.Combat);
        PushCleaner pushCleaner2 = a;
        pushCleaner2.page = pushCleaner.add(new EnumSetting<Page>(NCPRaytracer.ALLATORIxDEMO("^@~S"), Page.General));
        pushCleaner.eatingPause = pushCleaner.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u001ce$i:h\u000be%`\""), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.burOnly = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("gpXAOuO"), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.checkRedstone = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("5e<g;R1k\bp?}\""), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.checkFeetPush = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("DoMmJL@`^^Tj^"), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("T<a7j\te>t\""), 6, 1, 10, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(NCPRaytracer.ALLATORIxDEMO("[")));
        a.wallRange = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0007a8c\te>t\""), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(NCPRaytracer.ALLATORIxDEMO("[")));
        a.maxSelfDmg = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("I1x\u0007j7b\u0014^\u0000"), 3, 0, 36, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeDelay = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("^MkF`nkMxO"), 300, 0, 1000, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("~4")));
        a.breakDelay = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("LSoDnnkMxO"), 0, 0, 1000, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("~4")));
        a.updateDelay = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("}~EkQ`nkMxO"), 250, 0, 1000, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("~4")));
        a.autoSwap = a.add(new EnumSetting<SwapMode>(NCPRaytracer.ALLATORIxDEMO("KPqE]VxF"), SwapMode.Off, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\bs9} "), SwingSide.Server, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("WEz@mS"), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.onBreak = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u001ba\u0019v5r,"), false, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("|d]]U|F"), false, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\bp5c4"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("WK`Ev["), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("_:g;v3"), false, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("bb@fABNv]"), true, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0016|1"), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            PushCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        PushCleaner pushCleaner3 = a;
        a.lastBreakTimer = new Timer();
        pushCleaner3.lastYaw = 0.0f;
        pushCleaner3.lastPitch = 0.0f;
        a.directionVec = null;
        a.delayTimer = new Timer();
        a.setChinese(NCPRaytracer.ALLATORIxDEMO("\u6e0b\u7427\u6d22\u5868"));
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Rotate;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            return arrpage;
        }

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
            General = new Page(FrameFilter.ALLATORIxDEMO("d&| f&z"), 0);
            Rotate = new Page(OnlineUserInfo.ALLATORIxDEMO("s9S1Q7"), 1);
            $VALUES = Page.$values();
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }
    }

    public static final class SwapMode
    extends Enum<SwapMode> {
        public static final /* enum */ SwapMode Inventory;
        public static final /* enum */ SwapMode Off;
        private static final /* synthetic */ SwapMode[] $VALUES;
        public static final /* enum */ SwapMode Silent;
        public static final /* enum */ SwapMode Normal;

        public static SwapMode[] values() {
            return (SwapMode[])$VALUES.clone();
        }

        private static /* synthetic */ SwapMode[] $values() {
            SwapMode[] arrswapMode = new SwapMode[4];
            arrswapMode[0] = Off;
            arrswapMode[1] = Normal;
            arrswapMode[2] = Silent;
            arrswapMode[3] = Inventory;
            return arrswapMode;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ SwapMode() {
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
            Off = new SwapMode(Setting.ALLATORIxDEMO("\n*i"), 0);
            Normal = new SwapMode(Snow.ALLATORIxDEMO("Bhuaga"), 1);
            Silent = new SwapMode(Setting.ALLATORIxDEMO("H1j \"{"), 2);
            Inventory = new SwapMode(Snow.ALLATORIxDEMO("Q@Siisctt"), 3);
            $VALUES = SwapMode.$values();
        }

        public static SwapMode valueOf(String a) {
            return Enum.valueOf(SwapMode.class, a);
        }
    }

    public class PlayerAndPredict {
        final class_1657 predict;
        final /* synthetic */ PushCleaner this$0;

        /*
         * WARNING - void declaration
         */
        public PlayerAndPredict(PushCleaner pushCleaner, class_2338 class_23382) {
            void a;
            PlayerAndPredict a2;
            PlayerAndPredict a3 = class_23382;
            PlayerAndPredict playerAndPredict = a2 = this;
            playerAndPredict.this$0 = a;
            PlayerAndPredict playerAndPredict2 = a2;
            a2.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a3.method_10074(), 0.0f, new GameProfile(UUID.fromString(PacketBuffer.ALLATORIxDEMO("_8\u000ejx\u001aA&W,P6J4\\:i\u000fX$I.}\u0001_8I,I+J#N)_8")), Tab.ALLATORIxDEMO("U\u0014w\u00153Z{)f\u001ff\u0018kBk\u0002")), (PushCleaner)a){
                final /* synthetic */ PushCleaner val$this$0;
                final /* synthetic */ PlayerAndPredict this$1;

                public boolean method_7337() {
                    return false;
                }

                public boolean method_7325() {
                    return false;
                }
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
                    object.this$1 = a4;
                    object.val$this$0 = a;
                    super((class_1937)a5, (class_2338)a3, (float)a6, (GameProfile)a2);
                }
            };
            playerAndPredict.predict.method_33574(a3.method_46558().method_1031(0.0, -1.0, 0.0));
            playerAndPredict.predict.method_6033(20.0f);
            playerAndPredict.predict.method_24830(true);
        }

    }

}
