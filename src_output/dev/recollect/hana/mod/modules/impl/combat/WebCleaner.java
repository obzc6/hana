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
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
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
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Pair;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ExplosionUtil;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.packet.Packet;
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
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
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

public class WebCleaner
extends Module {
    BooleanSetting eatingPause;
    private float lastYaw;
    public static final Timer placeTimer = new Timer();
    SliderSetting breakDelay;
    BooleanSetting random;
    SliderSetting wallRange;
    SliderSetting placeRange;
    BooleanSetting rotate;
    private final Timer delayTimer;
    SliderSetting maxSelfDmg;
    SliderSetting noBurMin;
    BooleanSetting packet;
    SliderSetting updateDelay;
    BooleanSetting checkLook;
    SliderSetting placeDelay;
    SliderSetting burMin;
    BooleanSetting onBreak;
    EnumSetting<SwapMode> autoSwap;
    SliderSetting fov;
    BooleanSetting burOnly;
    private float lastPitch;
    public class_243 directionVec;
    public final Timer lastBreakTimer;
    SliderSetting steps;
    EnumSetting<SwingSide> swingMode;
    EnumSetting<Page> page;
    BooleanSetting yawStep;

    @Override
    public void onEnable() {
        WebCleaner a;
        a.lastYaw = Hana.ROTATE.lastYaw;
        a.lastPitch = Hana.ROTATE.lastPitch;
        a.lastBreakTimer.reset();
    }

    public void placeCrystal(class_2338 a) {
        WebCleaner a22;
        WebCleaner webCleaner = a22;
        boolean a22 = WebCleaner.mc.field_1724.method_6079().method_7909() == class_1802.field_8301;
        class_2338 class_23382 = a.method_10074();
        BlockUtil.clickBlock(class_23382, BlockUtil.getClickSide(class_23382), false, a22 ? class_1268.field_5810 : class_1268.field_5808, SwingSide.All);
    }

    private /* synthetic */ boolean findCrystal() {
        WebCleaner a;
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
        WebCleaner webCleaner = this;
        int n = a4 = 0;
        while (n < a2.size()) {
            Pair pair = (Pair)a2.get(a4);
            class_1799 class_17993 = (class_1799)pair.getFirst();
            if (class_1542.method_24017((class_1799)class_17993, (class_1799)a)) {
                a2.set(a4, Pair.of((Object)class_1542.method_24018((class_1799)class_17993, (class_1799)a, (int)16), (Object)((class_2338)pair.getSecond())));
                if (a.method_7960()) {
                    return;
                }
            }
            n = ++a4;
        }
        a2.add(Pair.of((Object)a, (Object)a3));
    }

    private /* synthetic */ int getCrystal() {
        WebCleaner a;
        if (a.autoSwap.getValue() == SwapMode.Silent || a.autoSwap.getValue() == SwapMode.Normal) {
            return InventoryUtil.findItem(class_1802.field_8301);
        }
        if (a.autoSwap.getValue() == SwapMode.Inventory) {
            return InventoryUtil.findItemInventorySlot(class_1802.field_8301);
        }
        return -1;
    }

    private /* synthetic */ void doPlace(class_2338 a) {
        WebCleaner a22;
        WebCleaner webCleaner = a22;
        if (!(WebCleaner.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || WebCleaner.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301) || webCleaner.findCrystal())) {
            return;
        }
        if (!webCleaner.canTouch(a.method_10074())) {
            return;
        }
        class_2338 class_23382 = a.method_10074();
        a22 = BlockUtil.getClickSide(class_23382);
        a22 = class_23382.method_46558().method_1031((double)a22.method_10163().method_10263() * 0.5, (double)a22.method_10163().method_10264() * 0.5, (double)a22.method_10163().method_10260() * 0.5);
        if (webCleaner.rotate.getValue() && !webCleaner.faceVector((class_243)a22)) {
            return;
        }
        if (!placeTimer.passedMs((long)webCleaner.placeDelay.getValue())) {
            return;
        }
        placeTimer.reset();
        if (WebCleaner.mc.field_1724.method_6047().method_7909().equals((Object)class_1802.field_8301) || WebCleaner.mc.field_1724.method_6079().method_7909().equals((Object)class_1802.field_8301)) {
            webCleaner.placeCrystal(a);
            return;
        }
        if (webCleaner.findCrystal()) {
            int a22 = WebCleaner.mc.field_1724.method_31548().field_7545;
            int n = webCleaner.getCrystal();
            if (n == -1) {
                return;
            }
            WebCleaner webCleaner2 = webCleaner;
            webCleaner2.doSwap(n);
            webCleaner2.placeCrystal(a);
            if (webCleaner.autoSwap.getValue() == SwapMode.Silent) {
                webCleaner.doSwap(a22);
                return;
            }
            if (webCleaner.autoSwap.getValue() == SwapMode.Inventory) {
                webCleaner.doSwap(n);
                EntityUtil.syncInventory();
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean canPlaceCrystal(class_2338 class_23382, boolean bl, boolean bl2) {
        void a;
        void a2;
        class_2338 a3;
        WebCleaner webCleaner = this;
        a3 = a3.method_10074();
        WebCleaner a4 = a3.method_10084();
        return !(BlockUtil.getBlock(a3) != class_2246.field_9987 && BlockUtil.getBlock(a3) != class_2246.field_10540 || BlockUtil.getClickSideStrict(a3) == null || webCleaner.hasEntityBlockCrystal((class_2338)a4, (boolean)a2, (boolean)a) || webCleaner.hasEntityBlockCrystal(a4.method_10084(), (boolean)a2, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10124 && (!webCleaner.hasEntityBlockCrystal((class_2338)a4, false, (boolean)a) || BlockUtil.getBlock((class_2338)a4) != class_2246.field_10036) || CombatSetting.INSTANCE.lowVersion.getValue() && BlockUtil.getBlock(a4.method_10084()) != class_2246.field_10124);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean hasEntityBlockCrystal(class_2338 var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        a = WebCleaner.mc.field_1687.method_18467(class_1297.class, new class_238((class_2338)a)).iterator();
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
                if (WebCleaner.mc.field_1724.method_6057((class_1297)a)) continue block0;
                if (!(WebCleaner.mc.field_1724.method_33571().method_1022(a.method_19538()) <= var4_4.wallRange.getValue())) return true;
                v0 = a;
            }
            return false;
            break;
        } while (true);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        WebCleaner a3 = this;
        if (a2 < 0.01f) {
            a2 = 0.01f;
        }
        if (a2 > 1.0f) {
            a2 = 1.0f;
        }
        if (a2 < 1.0f && a != null) {
            void v2;
            float f2;
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

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        WebCleaner a2 = this;
        if (a2.autoSwap.getValue() == SwapMode.Silent || a2.autoSwap.getValue() == SwapMode.Normal) {
            InventoryUtil.switchToSlot(a);
            return;
        }
        if (a2.autoSwap.getValue() == SwapMode.Inventory) {
            InventoryUtil.inventorySwap(a, WebCleaner.mc.field_1724.method_31548().field_7545);
        }
    }

    public WebCleaner() {
        WebCleaner a;
        WebCleaner webCleaner = a;
        super(Packet.ALLATORIxDEMO("H]yxV~Vm]"), BlockUpUtil.ALLATORIxDEMO("_o\u0004&\bhGs_r]j\u0013\""), Module.Category.Combat);
        WebCleaner webCleaner2 = a;
        webCleaner2.page = webCleaner.add(new EnumSetting<Page>(Packet.ALLATORIxDEMO("OYoJ"), Page.General));
        webCleaner.eatingPause = webCleaner.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("\nDnKsBJYr\u0001("), true, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.burOnly = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("~aAPVdV"), true, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.burMin = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("XWohsVP\u0017/"), 6, 1, 8, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Packet.ALLATORIxDEMO("B")));
        a.noBurMin = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("!JXWohsVP\u0017/"), 3, 1, 8, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Packet.ALLATORIxDEMO("B")));
        a.placeRange = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("uvC~@HYi\u0015("), 6, 1, 10, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Packet.ALLATORIxDEMO("B")));
        a.wallRange = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("MCqIHYi\u0015("), 6.0, 0.0, 6.0, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Packet.ALLATORIxDEMO("B")));
        a.maxSelfDmg = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("h{ZN@v^C?\n"), 3, 0, 36, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeDelay = a.add(new SliderSetting(Packet.ALLATORIxDEMO("OTz_qwzTiV"), 300, 0, 1000, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(BlockUpUtil.ALLATORIxDEMO("\u001f>")));
        a.breakDelay = a.add(new SliderSetting(Packet.ALLATORIxDEMO("]J~]wzTiV"), 0, 0, 1000, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(BlockUpUtil.ALLATORIxDEMO("\u001f>")));
        a.updateDelay = a.add(new SliderSetting(Packet.ALLATORIxDEMO("do\\zHqwzTiV"), 250, 0, 1000, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(BlockUpUtil.ALLATORIxDEMO("\u001f>")));
        a.autoSwap = a.add(new EnumSetting<SwapMode>(Packet.ALLATORIxDEMO("ZI`\\LOi_"), SwapMode.Off, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(BlockUpUtil.ALLATORIxDEMO("IOn\u001c*"), SwingSide.Server, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("F\\kY|J"), true, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.onBreak = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("RKXJb\u0013&"), false, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("euDLLm_"), false, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("ILb\u0002>"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("FRq\\gB"), true, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("u{[l\u00179"), false, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("{sYwXSWgD"), true, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("A\u001d;"), 30.0, 0.0, 90.0, object -> {
            Object a = object;
            WebCleaner a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        WebCleaner webCleaner3 = a;
        a.lastBreakTimer = new Timer();
        webCleaner3.lastYaw = 0.0f;
        webCleaner3.lastPitch = 0.0f;
        a.directionVec = null;
        a.delayTimer = new Timer();
        a.setChinese(Packet.ALLATORIxDEMO("\u872b\u86c4\u7f69\u6e0d\u7429"));
    }

    public float getExposure(class_243 a, class_2338 a2) {
        WebCleaner a3;
        WebCleaner webCleaner = a3;
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
                        if (WebCleaner.mc.field_1687.method_17742(new class_3959(class_2432, a, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)new PlayerAndPredict((WebCleaner)webCleaner, (class_2338)a2).predict)).method_17783() == class_239.class_240.field_1333) {
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

    public List<class_2338> getWebPos(class_1657 a) {
        int n;
        WebCleaner a22;
        WebCleaner webCleaner = a22;
        class_243 class_2432 = a.method_19538();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        float[] arrf = new float[3];
        arrf[0] = 0.0f;
        arrf[1] = 0.3f;
        arrf[2] = -0.3f;
        float[] arrf2 = arrf;
        int n2 = arrf.length;
        int n3 = n = 0;
        while (n3 < n2) {
            int n4;
            float f = arrf2[n];
            float[] arrf3 = new float[3];
            arrf3[0] = 0.0f;
            arrf3[1] = 0.3f;
            arrf3[2] = -0.3f;
            float[] arrf4 = arrf3;
            int n5 = arrf3.length;
            int n6 = n4 = 0;
            while (n6 < n5) {
                int n7;
                float f2 = arrf4[n4];
                int[] arrn = new int[3];
                arrn[0] = 0;
                arrn[1] = 1;
                arrn[2] = 2;
                int[] arrn2 = arrn;
                int n8 = arrn.length;
                int n9 = n7 = 0;
                while (n9 < n8) {
                    int a22 = arrn2[n7];
                    a22 = new BlockPosX(class_2432.method_10216() + (double)f, class_2432.method_10214(), class_2432.method_10215() + (double)f2).method_10086(a22);
                    if (HoleKick.isTargetHere((class_2338)a22, (class_1297)a) && WebCleaner.mc.field_1687.method_8320((class_2338)a22).method_26204() == class_2246.field_10343) {
                        arrayList.add((class_2338)a22);
                    }
                    n9 = ++n7;
                }
                n6 = ++n4;
            }
            n3 = ++n;
        }
        return arrayList;
    }

    private /* synthetic */ void doBreak(class_2338 class_23382) {
        Object a = class_23382;
        WebCleaner a2 = this;
        a2.lastBreakTimer.reset();
        if (!CombatUtil.breakTimer.passedMs((long)a2.breakDelay.getValue())) {
            return;
        }
        if ((a = WebCleaner.mc.field_1687.method_18467(class_1511.class, new class_238((double)a.method_10263(), (double)a.method_10264(), (double)a.method_10260(), (double)(a.method_10263() + 1), (double)(a.method_10264() + 2), (double)(a.method_10260() + 1))).iterator()).hasNext()) {
            a = (class_1511)a.next();
            if (a2.rotate.getValue() && a2.onBreak.getValue() && !a2.faceVector(a.method_19538().method_1031(0.0, 0.25, 0.0))) {
                return;
            }
            CombatUtil.breakTimer.reset();
            WebCleaner.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34206((class_1297)a, (boolean)WebCleaner.mc.field_1724.method_5715()));
            EntityUtil.swingHand(class_1268.field_5808, a2.swingMode.getValue());
            return;
        }
    }

    @Override
    public void onUpdate() {
        WebCleaner a;
        WebCleaner webCleaner = a;
        if (WebCleaner.nullCheck()) {
            return;
        }
        if (webCleaner.burOnly.getValue() && !EntityUtil.isInsideBlock()) {
            return;
        }
        if (webCleaner.eatingPause.getValue() && WebCleaner.mc.field_1724.method_6115()) {
            return;
        }
        WebCleaner webCleaner2 = webCleaner;
        if (!webCleaner2.delayTimer.passedMs((long)webCleaner2.updateDelay.getValue())) {
            return;
        }
        if (!HoleKick.isInWeb((class_1657)WebCleaner.mc.field_1724)) {
            return;
        }
        webCleaner.delayTimer.reset();
        List<class_2338> list = webCleaner.getWebPos((class_1657)WebCleaner.mc.field_1724);
        if (EntityUtil.isInsideBlock() && (double)list.size() >= webCleaner.burMin.getValue() || !EntityUtil.isInsideBlock() && (double)list.size() >= webCleaner.noBurMin.getValue()) {
            Iterator<class_2338> iterator;
            Iterator<class_2338> iterator2 = iterator = BlockUtil.getSphere(webCleaner.placeRange.getValueFloat()).iterator();
            while (iterator2.hasNext()) {
                a = iterator.next();
                if (!HoleKick.isInWeb((class_1657)WebCleaner.mc.field_1724)) {
                    list.clear();
                    return;
                }
                if ((double)a.method_10264() - WebCleaner.mc.field_1724.method_23318() > 2.0) {
                    iterator2 = iterator;
                    continue;
                }
                if (!webCleaner.canTouch(a.method_10074())) {
                    iterator2 = iterator;
                    continue;
                }
                if (!webCleaner.canPlaceCrystal((class_2338)a, true, false)) {
                    iterator2 = iterator;
                    continue;
                }
                if (!webCleaner.willBlockBeDestroyedByExplosion((class_1937)WebCleaner.mc.field_1687, list.get(0), (class_2338)a, 6.0f)) {
                    iterator2 = iterator;
                    continue;
                }
                if ((double)ExplosionUtil.calculateDamage(a.method_10263(), a.method_10264(), a.method_10260(), (class_1297)WebCleaner.mc.field_1724, (class_1297)WebCleaner.mc.field_1724, 6.0f) > webCleaner.maxSelfDmg.getValue()) {
                    iterator2 = iterator;
                    continue;
                }
                WebCleaner webCleaner3 = webCleaner;
                WebCleaner webCleaner4 = a;
                webCleaner3.doPlace((class_2338)webCleaner4);
                webCleaner3.doBreak((class_2338)webCleaner4);
                iterator2 = iterator;
            }
        }
        list.clear();
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

    public boolean behindWall(class_2338 class_23382) {
        WebCleaner a = class_23382;
        WebCleaner a2 = this;
        class_243 class_2432 = CombatSetting.INSTANCE.lowVersion.getValue() ? new class_243((double)a.method_10263() + 0.5, (double)a.method_10264(), (double)a.method_10260() + 0.5) : new class_243((double)a.method_10263() + 0.5, (double)a.method_10264() + 1.7, (double)a.method_10260() + 0.5);
        class_2432 = WebCleaner.mc.field_1687.method_17742(new class_3959(EntityUtil.getEyesPos(), class_2432, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)WebCleaner.mc.field_1724));
        if (class_2432 == null || class_2432.method_17783() == class_239.class_240.field_1333) {
            return false;
        }
        return WebCleaner.mc.field_1724.method_33571().method_1022(a.method_46558().method_1031(0.0, -0.5, 0.0)) > a2.wallRange.getValue();
    }

    /*
     * WARNING - void declaration
     */
    public boolean willBlockBeDestroyedByExplosion(class_1937 class_19372, class_2338 class_23382, class_2338 class_23383, float f) {
        void a;
        float f2;
        void a322;
        void a42;
        WebCleaner a22 = class_19372;
        WebCleaner a5 = this;
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

    private /* synthetic */ boolean canTouch(class_2338 a) {
        WebCleaner a2;
        WebCleaner webCleaner = a2;
        a2 = BlockUtil.getClickSideStrict(a);
        if (a2 != null) {
            class_243 class_2432 = new class_243((double)a2.method_10163().method_10263() * 0.5, (double)a2.method_10163().method_10264() * 0.5, (double)a2.method_10163().method_10260() * 0.5);
            if (a.method_46558().method_1019(class_2432).method_1022(WebCleaner.mc.field_1724.method_33571()) <= webCleaner.placeRange.getValue()) {
                return true;
            }
        }
        return false;
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Rotate;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;

        static {
            General = new Page(GaussianKernel.ALLATORIxDEMO("89 ?:9&"), 0);
            Rotate = new Page(CameraState.ALLATORIxDEMO("\u000f^/V-P"), 1);
            $VALUES = Page.$values();
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
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

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[2];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            return arrpage;
        }
    }

    public static final class SwapMode
    extends Enum<SwapMode> {
        public static final /* enum */ SwapMode Off = new SwapMode(Snow.ALLATORIxDEMO("\u001eb6"), 0);
        public static final /* enum */ SwapMode Silent;
        public static final /* enum */ SwapMode Inventory;
        public static final /* enum */ SwapMode Normal;
        private static final /* synthetic */ SwapMode[] $VALUES;

        public static SwapMode valueOf(String a) {
            return Enum.valueOf(SwapMode.class, a);
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

        private static /* synthetic */ SwapMode[] $values() {
            SwapMode[] arrswapMode = new SwapMode[4];
            arrswapMode[0] = Off;
            arrswapMode[1] = Normal;
            arrswapMode[2] = Silent;
            arrswapMode[3] = Inventory;
            return arrswapMode;
        }

        static {
            Normal = new SwapMode(FrameFilter.ALLATORIxDEMO("\u0003s4z&z"), 1);
            Silent = new SwapMode(Snow.ALLATORIxDEMO("]3i4j$"), 2);
            Inventory = new SwapMode(FrameFilter.ALLATORIxDEMO("J\u0001H(r2x5o"), 3);
            $VALUES = SwapMode.$values();
        }

        public static SwapMode[] values() {
            return (SwapMode[])$VALUES.clone();
        }
    }

    public class PlayerAndPredict {
        final /* synthetic */ WebCleaner this$0;
        final class_1657 predict;

        /*
         * WARNING - void declaration
         */
        public PlayerAndPredict(WebCleaner webCleaner, class_2338 class_23382) {
            void a;
            PlayerAndPredict a2;
            PlayerAndPredict a3 = class_23382;
            PlayerAndPredict playerAndPredict = a2 = this;
            playerAndPredict.this$0 = a;
            PlayerAndPredict playerAndPredict2 = a2;
            a2.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a3.method_10074(), 0.0f, new GameProfile(UUID.fromString(Animation.ALLATORIxDEMO("\u0007<Vn \u001e\u0019\"\u000f(\b2\u00120\u0004>1\u000b\u0000 \u0011*%\u0005\u0007<\u0011(\u0011/\u0012'\u0016-\u0007<")), ProjectionUtils.ALLATORIxDEMO("p\u0014q6_\u0013U\"N\u0012D\u001f^R\u0003O")), (WebCleaner)a){
                final /* synthetic */ WebCleaner val$this$0;
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
                    object.this$1 = a2;
                    object.val$this$0 = a;
                    super((class_1937)a4, (class_2338)a3, (float)a6, (GameProfile)a5);
                }
            };
            playerAndPredict.predict.method_33574(a3.method_46558().method_1031(0.0, -1.0, 0.0));
            playerAndPredict.predict.method_6033(20.0f);
            playerAndPredict.predict.method_24830(true);
        }

    }

}
