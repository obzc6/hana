/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2665
 *  net.minecraft.class_2680
 *  net.minecraft.class_2753
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2665;
import net.minecraft.class_2680;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameConverter;

public class AntiPiston
extends Module {
    public static AntiPiston INSTANCE;
    public final BooleanSetting trap;
    public final BooleanSetting packet;
    private final BooleanSetting onlyBurrow;
    private final BooleanSetting usingPause;
    public final BooleanSetting rotate;
    public final BooleanSetting helper;
    private final BooleanSetting whenDouble;
    private final BooleanSetting inventory;

    public AntiPiston() {
        AntiPiston a;
        AntiPiston antiPiston = a;
        super(FrameConverter.ALLATORIxDEMO("3\u0001\"x\u001cxJ("), ColorUtil.ALLATORIxDEMO("\ti\u0005R}h\"m&&,u?r(>4h.s3;+oi'"), Module.Category.Combat);
        AntiPiston antiPiston2 = a;
        antiPiston2.rotate = antiPiston.add(new BooleanSetting(FrameConverter.ALLATORIxDEMO(" ~\u001bmQ#"), true));
        antiPiston.packet = antiPiston.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\rz#mo8"), true));
        antiPiston.helper = antiPiston.add(new BooleanSetting(FrameConverter.ALLATORIxDEMO(":t\u0003|@4"), true));
        antiPiston.trap = antiPiston.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u0014tk<"), true).setParent());
        antiPiston.usingPause = antiPiston.add(new BooleanSetting(FrameConverter.ALLATORIxDEMO("'b\u001cx\u0015A\u000eyV#"), true));
        antiPiston.onlyBurrow = antiPiston.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("\u0012u6e\u001fn2te;"), true, object -> {
            Object a = object;
            AntiPiston a2 = this;
            return a2.trap.isOpen();
        }).setParent());
        a.whenDouble = a.add(new BooleanSetting(FrameConverter.ALLATORIxDEMO("%y\u0010x6~\u001anI#"), true, object -> {
            Object a = object;
            AntiPiston a2 = this;
            return a2.onlyBurrow.isOpen();
        }));
        AntiPiston antiPiston3 = a;
        antiPiston3.inventory = a.add(new BooleanSetting(ColorUtil.ALLATORIxDEMO("Uf88u.s/b\u0013qk<"), true));
        antiPiston3.setChinese(FrameConverter.ALLATORIxDEMO("\u53c1\u6d1e\u5818"));
        INSTANCE = antiPiston3;
    }

    private /* synthetic */ void placeBlock(class_2338 a) {
        AntiPiston a22;
        AntiPiston antiPiston = a22;
        if (!AntiPiston.canPlace(a)) {
            return;
        }
        int n = AntiPiston.mc.field_1724.method_31548().field_7545;
        int a22 = antiPiston.findBlock(class_2246.field_10540);
        if (a22 == -1) {
            return;
        }
        AntiPiston antiPiston2 = antiPiston;
        antiPiston2.doSwap(a22);
        BlockUtil.placeBlock(a, antiPiston2.rotate.getValue(), antiPiston.packet.getValue());
        AntiPiston antiPiston3 = antiPiston;
        if (antiPiston.inventory.getValue()) {
            antiPiston3.doSwap(a22);
            EntityUtil.syncInventory();
            return;
        }
        antiPiston3.doSwap(n);
    }

    @Override
    public void onUpdate() {
        AntiPiston a;
        if (!AntiPiston.mc.field_1724.method_24828()) {
            return;
        }
        if (a.usingPause.getValue() && AntiPiston.mc.field_1724.method_6115()) {
            return;
        }
        a.block();
    }

    private /* synthetic */ class_2248 getBlock(class_2338 class_23382) {
        AntiPiston a = class_23382;
        AntiPiston a2 = this;
        return AntiPiston.mc.field_1687.method_8320((class_2338)a).method_26204();
    }

    public int findBlock(class_2248 class_22482) {
        AntiPiston a = class_22482;
        AntiPiston a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AntiPiston a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AntiPiston.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    private /* synthetic */ void block() {
        int n;
        AntiPiston a;
        int n2;
        class_2350 class_23502;
        class_2350[] arrclass_2350;
        AntiPiston antiPiston = a;
        a = EntityUtil.getPlayerPos();
        if (antiPiston.getBlock(a.method_10086(2)) == class_2246.field_10540 || antiPiston.getBlock(a.method_10086(2)) == class_2246.field_9987) {
            return;
        }
        int n3 = 0;
        if (antiPiston.whenDouble.getValue()) {
            arrclass_2350 = class_2350.values();
            n2 = arrclass_2350.length;
            int n4 = n = 0;
            while (n4 < n2) {
                class_23502 = arrclass_2350[n];
                if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036 && antiPiston.getBlock(a.method_10093(class_23502).method_10084()) instanceof class_2665 && ((class_2350)AntiPiston.mc.field_1687.method_8320(a.method_10093(class_23502).method_10084()).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23502) {
                    ++n3;
                }
                n4 = ++n;
            }
        }
        arrclass_2350 = class_2350.values();
        n2 = arrclass_2350.length;
        int n5 = n = 0;
        while (n5 < n2) {
            class_23502 = arrclass_2350[n];
            if (class_23502 != class_2350.field_11033 && class_23502 != class_2350.field_11036 && antiPiston.getBlock(a.method_10093(class_23502).method_10084()) instanceof class_2665 && ((class_2350)AntiPiston.mc.field_1687.method_8320(a.method_10093(class_23502).method_10084()).method_11654((class_2769)class_2318.field_10927)).method_10153() == class_23502) {
                AntiPiston antiPiston2;
                block13 : {
                    AntiPiston antiPiston3 = antiPiston;
                    antiPiston3.placeBlock(a.method_10084().method_10079(class_23502, -1));
                    if (antiPiston3.trap.getValue() && (antiPiston.getBlock((class_2338)a) != class_2246.field_10124 || !antiPiston.onlyBurrow.getValue() || n3 >= 2)) {
                        antiPiston.placeBlock(a.method_10086(2));
                        if (!BlockUtil.canPlace(a.method_10086(2))) {
                            int n6;
                            class_2350[] arrclass_23502 = class_2350.values();
                            int n7 = arrclass_23502.length;
                            int n8 = n6 = 0;
                            while (n8 < n7) {
                                class_2350 class_23503 = arrclass_23502[n6];
                                if (AntiPiston.canPlace(a.method_10093(class_23503).method_10086(2))) {
                                    antiPiston.placeBlock(a.method_10093(class_23503).method_10086(2));
                                    antiPiston2 = a;
                                    break block13;
                                }
                                n8 = ++n6;
                            }
                        }
                    }
                    antiPiston2 = a;
                }
                if (!BlockUtil.canPlace(antiPiston2.method_10084().method_10079(class_23502, -1)) && antiPiston.helper.getValue()) {
                    AntiPiston antiPiston4 = antiPiston;
                    if (BlockUtil.canPlace(a.method_10079(class_23502, -1))) {
                        antiPiston4.placeBlock(a.method_10079(class_23502, -1));
                    } else {
                        antiPiston4.placeBlock(a.method_10079(class_23502, -1).method_10074());
                    }
                }
            }
            n5 = ++n;
        }
    }

    public static boolean canPlace(class_2338 a) {
        if (!BlockUtil.canBlockFacing(a)) {
            return false;
        }
        if (!BlockUtil.canReplace(a)) {
            return false;
        }
        return !BlockUtil.hasEntity(a, false);
    }
}
