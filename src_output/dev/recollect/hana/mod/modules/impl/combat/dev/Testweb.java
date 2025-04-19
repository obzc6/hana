/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2848;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseSettings;

public class Testweb
extends Module {
    public static boolean place;
    private float lastPitch;
    public final SliderSetting targetRange;
    private final BooleanSetting usingPause;
    public final SliderSetting blocksPer;
    private final BooleanSetting detectMining;
    private final BooleanSetting inventorySwap;
    private final Timer timer;
    private final BooleanSetting extend;
    public static boolean ignore;
    public final SliderSetting placeRange;
    public class_243 directionVec;
    public final EnumSetting<Page> page;
    private final BooleanSetting noHole;
    private final BooleanSetting leg;
    private final BooleanSetting noMine;
    public final SliderSetting predictTicks;
    private final BooleanSetting checkLook;
    private final SliderSetting fov;
    private final BooleanSetting newRotate;
    private final SliderSetting yawStep;
    public static boolean force;
    private float lastYaw;
    private final BooleanSetting extendFace;
    private final BooleanSetting rotate;
    public final SliderSetting multiPlace;
    private final BooleanSetting checkMine;
    private final BooleanSetting packet;
    int progress;
    private final BooleanSetting down;
    private final ArrayList<class_2338> pos;
    public final SliderSetting placeDelay;
    public static Testweb INSTANCE;

    /*
     * WARNING - void declaration
     */
    public boolean placeBlock(class_2338 class_23382, boolean bl, int n) {
        void a;
        class_2350 a2;
        void a3;
        void a4;
        class_2350 class_23502 = this;
        if (BlockUtil.airPlace()) {
            int n2;
            a2 = class_2350.values();
            int n3 = ((class_2350[])a2).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                class_2350 class_23503 = a2[n2];
                if (Testweb.mc.field_1687.method_22347(a3.method_10093(class_23503))) {
                    return class_23502.clickBlock((class_2338)a3, class_23503, (boolean)a4, (int)a);
                }
                n4 = ++n2;
            }
        }
        if ((a2 = BlockUtil.getPlaceSide((class_2338)a3)) == null) {
            return false;
        }
        class_243 class_2432 = new class_243((double)a3.method_10263() + 0.5 + (double)a2.method_10163().method_10263() * 0.5, (double)a3.method_10264() + 0.5 + (double)a2.method_10163().method_10264() * 0.5, (double)a3.method_10260() + 0.5 + (double)a2.method_10163().method_10260() * 0.5);
        class_3965 class_39652 = new class_3965(class_2432, a2, (class_2338)a3, false);
        BlockUtil.placedPos.add((class_2338)a3);
        boolean bl2 = false;
        if (Testweb.mc.field_1724 != null) {
            bl2 = Testweb.mc.field_1724.method_5624();
        }
        boolean bl3 = false;
        if (Testweb.mc.field_1687 != null) {
            boolean bl4 = bl3 = Testweb.needSneak(Testweb.mc.field_1687.method_8320(class_39652.method_17777()).method_26204()) && !Testweb.mc.field_1724.method_5715();
        }
        if (bl2) {
            Testweb.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)Testweb.mc.field_1724, class_2848.class_2849.field_12985));
        }
        if (bl3) {
            Testweb.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)Testweb.mc.field_1724, class_2848.class_2849.field_12979));
        }
        class_23502.clickBlock(a3.method_10093(a2), a2.method_10153(), (boolean)a4, (int)a);
        if (bl3) {
            Testweb.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)Testweb.mc.field_1724, class_2848.class_2849.field_12984));
        }
        if (bl2) {
            Testweb.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)Testweb.mc.field_1724, class_2848.class_2849.field_12981));
        }
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        return true;
    }

    private /* synthetic */ int getWebSlot() {
        Testweb a;
        if (a.inventorySwap.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10343);
        }
        return InventoryUtil.findBlock(class_2246.field_10343);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent a) {
        var3_2 = a;
        if (a.isPost() != false) return;
        v0 = var3_2;
        if (!v0.timer.passedMs(v0.placeDelay.getValueInt())) {
            return;
        }
        v1 = var3_2;
        var3_2.pos.clear();
        v1.progress = 0;
        v1.directionVec = null;
        if (var3_2.getWebSlot() == -1) {
            return;
        }
        if (var3_2.usingPause.getValue() && Testweb.mc.field_1724.method_6115()) {
            return;
        }
        a = CombatUtil.getEnemies(var3_2.targetRange.getValue()).iterator();
        block0 : do lbl-1000: // 5 sources:
        {
            block23 : {
                v2 = a;
                block1 : while (v2.hasNext() != false) {
                    block22 : {
                        block21 : {
                            var11_11 = a.next();
                            v3 = var3_2;
                            a = v3.predictPlayerPosition(var11_11, v3.predictTicks.getValue());
                            if (!(!v3.leg.getValue() || var3_2.noHole.getValue() && BlockUtil.isHole(EntityUtil.getEntityPos((class_1297)var11_11, true)))) {
                                var3_2.placeWeb(new BlockPosX(a.method_10216(), a.method_10214(), a.method_10215()));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214(), a.method_10215() + 0.2));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214(), a.method_10215() - 0.2));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214(), a.method_10215() + 0.2));
                                v2 = a;
                                continue;
                            }
                            if (var3_2.down.getValue()) {
                                var3_2.placeWeb(new BlockPosX(a.method_10216(), a.method_10214() - 0.8, a.method_10215()));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.1, a.method_10214() - 0.3, a.method_10215() + 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.1, a.method_10214() - 0.3, a.method_10215() + 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.1, a.method_10214() - 0.3, a.method_10215() - 0.1));
                                var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.1, a.method_10214() - 0.3, a.method_10215() - 0.1));
                            }
                            var4_4 = false;
                            if (!var3_2.extend.getValue() && !var3_2.extendFace.getValue()) ** GOTO lbl-1000
                            v4 = new float[3];
                            v4[0] = 0.0f;
                            v4[1] = 0.3f;
                            v4[2] = -0.3f;
                            var5_5 = v4;
                            var6_6 = v4.length;
                            v5 = var7_7 = 0;
                            do {
                                if (v5 < var6_6) {
                                    var8_8 = var5_5[var7_7];
                                    v6 = new float[3];
                                    v6[0] = 0.0f;
                                    v6[1] = 0.3f;
                                    v6[2] = -0.3f;
                                    var9_9 = v6;
                                    var10_10 = v6.length;
                                    v7 = var2_3 = 0;
                                } else {
                                    if (var4_4) {
                                        v2 = a;
                                        continue block1;
                                    }
                                    if (var3_2.extend.getValue()) {
                                        v8 = new float[3];
                                        v8[0] = 0.0f;
                                        v8[1] = 0.3f;
                                        v8[2] = -0.3f;
                                        var5_5 = v8;
                                        var6_6 = v8.length;
                                        v9 = var7_7 = 0;
                                        break;
                                    }
                                    break block21;
                                }
                                while (v7 < var10_10) {
                                    var12_12 = var9_9[var2_3];
                                    v10 = new float[3];
                                    v10[0] = 0.0f;
                                    v10[1] = 1.0f;
                                    v10[2] = -1.0f;
                                    var13_14 = v10;
                                    var14_17 = v10.length;
                                    v11 = var15_18 = 0;
                                    while (v11 < var14_17) {
                                        var16_20 = var13_14[var15_18];
                                        var16_19 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214() + (double)var16_20, a.method_10215() + (double)var12_12);
                                        v12 = var3_2;
                                        v12.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214() + 1.5, a.method_10215() + 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214() + 1.5, a.method_10215() + 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() - 0.2, a.method_10214() + 1.5, a.method_10215() - 0.2));
                                        var3_2.placeWeb(new BlockPosX(a.method_10216() + 0.2, a.method_10214() + 1.5, a.method_10215() - 0.2));
                                        if (v12.isTargetHere(var16_19, var11_11) && Testweb.mc.field_1687.method_8320((class_2338)var16_19).method_26204() == class_2246.field_10343 && !BlockUtil.isMining(var16_19)) {
                                            var4_4 = true;
                                        }
                                        v11 = ++var15_18;
                                    }
                                    v7 = ++var2_3;
                                }
                                v5 = ++var7_7;
                            } while (true);
                            while (v9 < var6_6) {
                                var8_8 = var5_5[var7_7];
                                v13 = new float[3];
                                v13[0] = 0.0f;
                                v13[1] = 0.3f;
                                v13[2] = -0.3f;
                                var9_9 = v13;
                                var10_10 = v13.length;
                                v14 = var2_3 = 0;
                                while (v14 < var10_10) {
                                    var12_12 = var9_9[var2_3];
                                    var13_15 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214(), a.method_10215() + (double)var12_12);
                                    if (!var13_15.equals((Object)new BlockPosX(a.method_10216(), a.method_10214(), a.method_10215())) && var3_2.isTargetHere(var13_15, var11_11) && var3_2.placeWeb(var13_15)) {
                                        v15 = var4_4 = true;
                                        break block22;
                                    }
                                    v14 = ++var2_3;
                                }
                                v9 = ++var7_7;
                            }
                        }
                        v15 = var4_4;
                    }
                    if (v15) {
                        v2 = a;
                        continue;
                    }
                    break block23;
                }
                return;
            }
            if (!var3_2.extendFace.getValue()) ** GOTO lbl-1000
            v16 = new float[3];
            v16[0] = 0.0f;
            v16[1] = 0.3f;
            v16[2] = -0.3f;
            var5_5 = v16;
            var6_6 = v16.length;
            v17 = var7_7 = 0;
            do {
                if (v17 >= var6_6) ** GOTO lbl-1000
                var8_8 = var5_5[var7_7];
                v18 = new float[3];
                v18[0] = 0.0f;
                v18[1] = 0.3f;
                v18[2] = -0.3f;
                var9_9 = v18;
                var10_10 = v18.length;
                v19 = var2_3 = 0;
                while (v19 < var10_10) {
                    var12_12 = var9_9[var2_3];
                    var13_16 = new BlockPosX(a.method_10216() + (double)var8_8, a.method_10214() + 1.1, a.method_10215() + (double)var12_12);
                    if (var3_2.isTargetHere(var13_16, var11_11) && var3_2.placeWeb(var13_16)) continue block0;
                    v19 = ++var2_3;
                }
                v17 = ++var7_7;
            } while (true);
            break;
        } while (true);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        Testweb a3 = this;
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

    public Testweb() {
        Testweb a;
        Testweb testweb = a;
        super(Start.ALLATORIxDEMO("\u0013CuERI`ez\b!"), Module.Category.Combat);
        Testweb testweb2 = a;
        testweb2.page = testweb.add(new EnumSetting<Page>(GameInfo.ALLATORIxDEMO("Haxb"), Page.General));
        testweb.placeDelay = testweb.add(new SliderSetting(Start.ALLATORIxDEMO("|nJfIFTs\u001a,"), 50, 0, 500, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.blocksPer = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Te~iykPzu"), 2, 1, 10, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.multiPlace = a.add(new SliderSetting(Start.ALLATORIxDEMO("awGqER]~\u00180"), 2, 1, 10, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.predictTicks = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Hrkr`r~Fqctt"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.detectMining = a.add(new BooleanSetting(Start.ALLATORIxDEMO("=2XgHqak_v\u00152"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.extend = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Ojleqc"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.extendFace = a.add(new BooleanSetting(Start.ALLATORIxDEMO("iz_`Bfw~\u00180"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.leg = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Lz`"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.down = a.add(new BooleanSetting(Start.ALLATORIxDEMO("up\f;"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noHole = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("D}Posb"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.inventorySwap = a.add(new BooleanSetting(Start.ALLATORIxDEMO("@\u0017!Il_j^{bh\u001a%"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.usingPause = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("[e`mByulb"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeRange = a.add(new SliderSetting(Start.ALLATORIxDEMO("|nJfIPPq\u001c0"), 5.0, 0.0, 6.0, 0.1, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.targetRange = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Todnt~@ynxb"), 8.0, 0.0, 8.0, 0.1, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.checkMine = a.add(new BooleanSetting(Start.ALLATORIxDEMO("AC`Oi|v\u00150"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.noMine = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("D}Uiqb"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.rotate = a.add(new BooleanSetting(Start.ALLATORIxDEMO("~mE~\u000f0"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.newRotate = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("XlfX}lakb"), false, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.yawStep = a.add(new SliderSetting(Start.ALLATORIxDEMO("\\Mubk\u001e%"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.009999999776482582, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Zs{kzs"), false, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(Start.ALLATORIxDEMO("AC`Oi}p\u0014>"), true, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Fpq"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            Testweb a2 = this;
            return a2.rotate.isOpen() && a2.newRotate.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        Testweb testweb3 = a;
        Testweb testweb4 = a;
        Testweb testweb5 = a;
        a.timer = new Timer();
        testweb5.directionVec = null;
        testweb5.lastYaw = 0.0f;
        testweb4.lastPitch = 0.0f;
        testweb4.progress = 0;
        testweb3.pos = new ArrayList();
        testweb3.setChinese(Start.ALLATORIxDEMO("\u4e27\u65bb\u4f66\u7f6b\u6512\u871a\u86ea\u7f4e\u6d30\u8b80"));
        INSTANCE = testweb3;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ class_243 predictPlayerPosition(class_1657 class_16572, double d) {
        void a;
        void a2;
        Testweb testweb = this;
        void v0 = a;
        class_243 class_2432 = v0.method_19538();
        Testweb a3 = v0.method_18798();
        boolean bl = v0.method_24828() && a.method_18798().field_1351 == 0.0;
        double d2 = 0.42;
        double d3 = 0.08;
        if (bl) {
            a3 = new class_243(((class_243)a3).field_1352, d2, ((class_243)a3).field_1350);
        }
        return new class_243(class_2432.field_1352 + ((class_243)a3).field_1352 * a2, class_2432.field_1351 + ((class_243)a3).field_1351 * a2 - 0.5 * d3 * a2 * a2, class_2432.field_1350 + ((class_243)a3).field_1350 * a2);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isTargetHere(class_2338 class_23382, class_1657 class_16572) {
        void a;
        Testweb a2 = class_16572;
        Testweb a3 = this;
        return new class_238((class_2338)a).method_994(a2.method_5829());
    }

    @Override
    public String getInfo() {
        Testweb a;
        if (a.pos.isEmpty()) {
            return null;
        }
        return GameInfo.ALLATORIxDEMO("Afca{vg1)");
    }

    @Override
    public void onDisable() {
        force = false;
    }

    @EventHandler(priority=98)
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.newRotate.getValue() && arrf.directionVec != null) {
            float[] arrf2 = arrf;
            a2 = arrf2.injectStep(EntityUtil.getLegitRotations(arrf2.directionVec), arrf.yawStep.getValueFloat());
            arrf.lastYaw = a2[0];
            arrf2.lastPitch = a2[1];
            RotateEvent rotateEvent = a;
            rotateEvent.setYaw(arrf.lastYaw);
            rotateEvent.setPitch(arrf.lastPitch);
            return;
        }
        float[] arrf3 = arrf;
        arrf3.lastYaw = Hana.ROTATE.lastYaw;
        arrf3.lastPitch = Hana.ROTATE.lastPitch;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        Testweb a2 = this;
        if (a2.inventorySwap.getValue()) {
            InventoryUtil.inventorySwap(a, Testweb.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public static boolean needSneak(class_2248 a) {
        return BlockUtil.shiftBlocks.contains((Object)a);
    }

    static {
        force = false;
        ignore = false;
        place = false;
    }

    private /* synthetic */ boolean faceVector(class_243 class_2432) {
        float[] arrf;
        float[] a = class_2432;
        float[] a2 = this;
        if (!a2.newRotate.getValue()) {
            RotateManager.lastEvent.cancelRotate();
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

    private /* synthetic */ boolean placeWeb(class_2338 class_23382) {
        Testweb a = class_23382;
        Testweb a2 = this;
        if (a2.pos.contains(a)) {
            return false;
        }
        Testweb testweb = a2;
        testweb.pos.add((class_2338)a);
        if (testweb.progress >= a2.multiPlace.getValueInt()) {
            return false;
        }
        if (a2.getWebSlot() == -1) {
            return false;
        }
        if (a2.checkMine.getValue() && (Hana.BREAK.isMining((class_2338)a) || !a2.noMine.getValue() && a.equals((Object)SpeedMine.breakPos))) {
            return false;
        }
        if (BlockUtil.getPlaceSide((class_2338)a, a2.placeRange.getValue()) != null && Testweb.mc.field_1687.method_22347((class_2338)a)) {
            int n = a2.getWebSlot();
            Testweb testweb2 = a2;
            if (!testweb2.placeBlock((class_2338)a, testweb2.rotate.getValue(), n)) {
                return false;
            }
            if (a2.noMine.getValue() && a.equals((Object)SpeedMine.breakPos)) {
                SpeedMine.breakPos = null;
            }
            Testweb testweb3 = a2;
            ++testweb3.progress;
            testweb3.timer.reset();
            place = false;
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        int a;
        void a2;
        void a3;
        Testweb a4 = class_23382;
        Testweb a5 = this;
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a != 0 && !a5.faceVector(class_2432)) {
            return false;
        }
        a = Testweb.mc.field_1724.method_31548().field_7545;
        a5.doSwap((int)a2);
        EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a3, (class_2338)a4, false);
        Testweb.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(Testweb.mc.field_1687)));
        if (a5.inventorySwap.getValue()) {
            a5.doSwap((int)a2);
            EntityUtil.syncInventory();
        } else {
            a5.doSwap(a);
        }
        return true;
    }

    public static final class Page
    extends Enum<Page> {
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Rotate;
        public static final /* enum */ Page General;
        public static final /* enum */ Page WebPredictor;

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

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[3];
            arrpage[0] = General;
            arrpage[1] = Rotate;
            arrpage[2] = WebPredictor;
            return arrpage;
        }

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        static {
            General = new Page(Timer.ALLATORIxDEMO("t\\ZA[\u000f\u000f"), 0);
            Rotate = new Page(BaseSettings.ALLATORIxDEMO("jbJjHl"), 1);
            WebPredictor = new Page(Timer.ALLATORIxDEMO("kT[dLV]]G]\u0001\u0011"), 2);
            $VALUES = Page.$values();
        }
    }

}
