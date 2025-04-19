/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.Renderer;
import java.util.ArrayList;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoCev
extends Module {
    private final BooleanSetting ground;
    private class_1657 target;
    private final BooleanSetting bevel;
    private final SliderSetting breakRange;
    private final SliderSetting delay;
    private final BooleanSetting inventory;
    private final BooleanSetting top;
    private final Timer timer;
    private final BooleanSetting rotate;
    public static AutoCev INSTANCE;
    private final SliderSetting targetRange;

    public AutoCev() {
        AutoCev a;
        AutoCev autoCev = a;
        AutoCev autoCev2 = a;
        super(Renderer.ALLATORIxDEMO("&h\u0014o>/A"), Module.Category.Combat);
        AutoCev autoCev3 = a;
        autoCev3.targetRange = autoCev2.add(new SliderSetting(CameraState.ALLATORIxDEMO("q)V4Z\u000bA8[-C"), 5.0, 0.0, 8.0, 0.1));
        autoCev2.breakRange = autoCev2.add(new SliderSetting(Renderer.ALLATORIxDEMO("_\u0012\u0006v2a\u0013-R"), 5.0, 0.0, 8.0, 0.1));
        autoCev2.delay = autoCev2.add(new SliderSetting(CameraState.ALLATORIxDEMO("W<Y+_"), 100, 0, 500).setSuffix(Renderer.ALLATORIxDEMO("'D")));
        autoCev2.rotate = autoCev2.add(new BooleanSetting(CameraState.ALLATORIxDEMO("-|-T>C"), true));
        autoCev2.ground = autoCev2.add(new BooleanSetting(Renderer.ALLATORIxDEMO("Z\u0012o\b$S"), true));
        autoCev2.inventory = autoCev2.add(new BooleanSetting(CameraState.ALLATORIxDEMO("X'S-J'P\rj\nB+V"), true));
        autoCev2.top = autoCev2.add(new BooleanSetting(Renderer.ALLATORIxDEMO(")%G"), false));
        a.bevel = a.add(new BooleanSetting(CameraState.ALLATORIxDEMO("Q<C/J"), true));
        a.target = null;
        autoCev.timer = new Timer();
        autoCev.setChinese(Renderer.ALLATORIxDEMO("\u81ea\u52d5\u70f2\u5903"));
        INSTANCE = autoCev;
    }

    private /* synthetic */ int getBlock() {
        AutoCev a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoCev a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AutoCev.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ class_2248 getBlock(class_2338 class_23382) {
        AutoCev a = class_23382;
        AutoCev a2 = this;
        return AutoCev.mc.field_1687.method_8320((class_2338)a).method_26204();
    }

    private /* synthetic */ void placeBlock(class_2338 class_23382) {
        AutoCev a = class_23382;
        AutoCev a2 = this;
        int n = a2.getBlock();
        if (n == -1) {
            return;
        }
        int n2 = AutoCev.mc.field_1724.method_31548().field_7545;
        if (BlockUtil.canPlace((class_2338)a)) {
            class_2350 class_23502 = BlockUtil.getPlaceSide((class_2338)a);
            if (class_23502 == null) {
                if (BlockUtil.airPlace()) {
                    AutoCev autoCev = a2;
                    autoCev.doSwap(n);
                    BlockUtil.placedPos.add((class_2338)a);
                    BlockUtil.clickBlock((class_2338)a, class_2350.field_11033, a2.rotate.getValue());
                    if (autoCev.inventory.getValue()) {
                        a2.doSwap(n);
                        EntityUtil.syncInventory();
                        return;
                    }
                    a2.doSwap(n2);
                }
                return;
            }
            AutoCev autoCev = a2;
            autoCev.doSwap(n);
            BlockUtil.placedPos.add((class_2338)a);
            BlockUtil.clickBlock(a.method_10093(class_23502), class_23502.method_10153(), a2.rotate.getValue());
            AutoCev autoCev2 = a2;
            if (autoCev.inventory.getValue()) {
                autoCev2.doSwap(n);
                EntityUtil.syncInventory();
                return;
            }
            autoCev2.doSwap(n2);
        }
    }

    public static boolean canPlaceCrystal(class_2338 a) {
        return AutoCev.mc.field_1687.method_22347(a) && !BlockUtil.hasEntityBlockCrystal(a, false) && !BlockUtil.hasEntityBlockCrystal(a.method_10084(), false) && (!CombatSetting.INSTANCE.lowVersion.getValue() || AutoCev.mc.field_1687.method_22347(a.method_10084()));
    }

    @Override
    public String getInfo() {
        AutoCev a;
        if (a.target != null) {
            return a.target.method_5477().getString();
        }
        return null;
    }

    @Override
    public void onUpdate() {
        AutoCev a;
        AutoCev autoCev = a;
        if (autoCev.ground.getValue() && !AutoCev.mc.field_1724.method_24828()) {
            return;
        }
        SpeedMine.INSTANCE.crystal.setValue(true);
        autoCev.target = CombatUtil.getClosestEnemy(autoCev.targetRange.getValue());
        if (autoCev.target != null) {
            int n;
            int n2;
            class_2350 class_23502;
            class_2350[] arrclass_2350;
            class_2338 class_23382 = EntityUtil.getEntityPos((class_1297)autoCev.target);
            if (SpeedMine.breakPos != null) {
                arrclass_2350 = class_2350.values();
                n2 = arrclass_2350.length;
                int n3 = n = 0;
                while (n3 < n2) {
                    class_23502 = arrclass_2350[n];
                    if (class_23502 != class_2350.field_11033 && !(class_23502 == class_2350.field_11036 ? !autoCev.top.getValue() : !autoCev.bevel.getValue())) {
                        class_2338 class_23383;
                        a = class_23382.method_10086(1).method_10093(class_23502);
                        if (!(class_23383.method_10084().method_46558().method_1022(AutoCev.mc.field_1724.method_19538()) > autoCev.breakRange.getValue()) && SpeedMine.breakPos.equals((Object)class_23382.method_10086(1).method_10093(class_23502))) {
                            if (AutoCev.canPlaceCrystal(class_23382.method_10086(2).method_10093(class_23502))) {
                                if (AutoCev.mc.field_1687.method_22347((class_2338)a)) {
                                    if (BlockUtil.canPlace((class_2338)a)) {
                                        AutoCev autoCev2 = autoCev;
                                        if (!autoCev2.timer.passedMs(autoCev2.delay.getValue())) {
                                            return;
                                        }
                                        AutoCev autoCev3 = autoCev;
                                        autoCev3.placeBlock((class_2338)a);
                                        autoCev3.timer.reset();
                                        return;
                                    }
                                } else if (autoCev.getBlock((class_2338)a) == class_2246.field_10540) {
                                    SpeedMine.INSTANCE.mine((class_2338)a);
                                    autoCev.timer.reset();
                                    return;
                                }
                            } else if (BlockUtil.hasCrystal(class_23382.method_10086(2).method_10093(class_23502))) {
                                if (AutoCev.mc.field_1687.method_22347((class_2338)a)) {
                                    return;
                                }
                                if (autoCev.getBlock((class_2338)a) == class_2246.field_10540) {
                                    SpeedMine.INSTANCE.mine((class_2338)a);
                                    autoCev.timer.reset();
                                    return;
                                }
                            }
                        }
                    }
                    n3 = ++n;
                }
            }
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n4 = n = 0;
            while (n4 < n2) {
                class_23502 = arrclass_2350[n];
                if (class_23502 != class_2350.field_11033 && !(class_23502 == class_2350.field_11036 ? !autoCev.top.getValue() : !autoCev.bevel.getValue())) {
                    class_2338 class_23384;
                    a = class_23382.method_10086(1).method_10093(class_23502);
                    if (!(class_23384.method_10084().method_46558().method_1022(AutoCev.mc.field_1724.method_19538()) > autoCev.breakRange.getValue())) {
                        if (AutoCev.canPlaceCrystal(class_23382.method_10086(2).method_10093(class_23502))) {
                            if (AutoCev.mc.field_1687.method_22347((class_2338)a)) {
                                if (BlockUtil.canPlace((class_2338)a)) {
                                    AutoCev autoCev4 = autoCev;
                                    if (!autoCev4.timer.passedMs(autoCev4.delay.getValue())) {
                                        return;
                                    }
                                    AutoCev autoCev5 = autoCev;
                                    autoCev5.placeBlock((class_2338)a);
                                    autoCev5.timer.reset();
                                    return;
                                }
                            } else if (autoCev.getBlock((class_2338)a) == class_2246.field_10540) {
                                SpeedMine.INSTANCE.mine((class_2338)a);
                                autoCev.timer.reset();
                                return;
                            }
                        } else if (BlockUtil.hasCrystal(class_23382.method_10086(2).method_10093(class_23502))) {
                            if (AutoCev.mc.field_1687.method_22347((class_2338)a)) {
                                return;
                            }
                            if (autoCev.getBlock((class_2338)a) == class_2246.field_10540) {
                                SpeedMine.INSTANCE.mine((class_2338)a);
                                autoCev.timer.reset();
                                return;
                            }
                        }
                    }
                }
                n4 = ++n;
            }
        }
    }
}
