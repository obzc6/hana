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
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

@Beta
public class AnchorAssist
extends Module {
    private final BooleanSetting rotate;
    private final BooleanSetting usingPause;
    private final SliderSetting delay;
    private final SliderSetting range;
    public static AnchorAssist INSTANCE;
    class_2338 foundPos;
    private final SliderSetting minDamage;
    private final BooleanSetting inventory;
    private final BooleanSetting checkMine;
    private final Timer timer;

    @Override
    public String getInfo() {
        AnchorAssist a;
        if (a.foundPos != null) {
            return GaussianKernel.ALLATORIxDEMO("\u00141*>5'<");
        }
        return null;
    }

    @Override
    public void onUpdate() {
        AnchorAssist anchorAssist;
        Object object;
        AnchorAssist a322;
        AnchorAssist anchorAssist2 = anchorAssist = a322;
        anchorAssist2.foundPos = null;
        int n = anchorAssist2.findBlock(class_2246.field_23152);
        int a322 = anchorAssist2.findBlock(class_2246.field_10171);
        int n2 = AnchorAssist.mc.field_1724.method_31548().field_7545;
        if (n == -1) {
            return;
        }
        if (a322 == -1) {
            return;
        }
        if (AnchorAssist.mc.field_1724.method_5715()) {
            return;
        }
        if (anchorAssist.usingPause.getValue() && AnchorAssist.mc.field_1724.method_6115()) {
            return;
        }
        AnchorAssist anchorAssist3 = anchorAssist;
        if (!anchorAssist3.timer.passed((long)(anchorAssist3.delay.getValueFloat() * 1000.0f))) {
            return;
        }
        anchorAssist.timer.reset();
        AnchorAssist anchorAssist4 = anchorAssist;
        double d = anchorAssist4.minDamage.getValue();
        class_2338 a322 = new ArrayList();
        Iterator<Object> iterator = CombatUtil.getEnemies(anchorAssist4.range.getValue()).iterator();
        Iterator<class_1657> iterator2 = iterator;
        while (iterator2.hasNext()) {
            object = iterator.next();
            iterator2 = iterator;
            a322.add(new AnchorAura.PlayerAndPredict((class_1657)object));
        }
        iterator = a322.iterator();
        block1 : do {
            Iterator<Object> iterator3 = iterator;
            while (iterator3.hasNext()) {
                int n3;
                object = (AnchorAura.PlayerAndPredict)iterator.next();
                a322 = EntityUtil.getEntityPos((class_1297)object.player, true).method_10086(2);
                if (AnchorAssist.mc.field_1687.method_8320(a322).method_26204() == class_2246.field_23152) {
                    iterator3 = iterator;
                    continue;
                }
                if (BlockUtil.clientCanPlace(a322, true)) {
                    double d2;
                    Object object2 = object;
                    double d3 = AnchorAura.INSTANCE.getAnchorDamage(a322, object2.player, object2.predict);
                    if (d2 >= d) {
                        d = d3;
                        anchorAssist.foundPos = a322;
                    }
                }
                class_2350[] arrclass_2350 = class_2350.values();
                int n4 = arrclass_2350.length;
                int n5 = n3 = 0;
                do {
                    if (n5 >= n4) continue block1;
                    class_2350 class_23502 = arrclass_2350[n3];
                    if (class_23502 != class_2350.field_11036 && class_23502 != class_2350.field_11033 && BlockUtil.clientCanPlace(a322.method_10093(class_23502), false)) {
                        double d4;
                        Object object3 = object;
                        double d5 = AnchorAura.INSTANCE.getAnchorDamage(a322.method_10093(class_23502), object3.player, object3.predict);
                        if (d4 >= d) {
                            d = d5;
                            anchorAssist.foundPos = a322.method_10093(class_23502);
                        }
                    }
                    n5 = ++n3;
                } while (true);
            }
            break;
        } while (true);
        if (anchorAssist.foundPos != null && BlockUtil.getPlaceSide(anchorAssist.foundPos, AnchorAura.INSTANCE.range.getValue()) == null) {
            AnchorAssist anchorAssist5 = anchorAssist;
            iterator = anchorAssist5.getHelper(anchorAssist5.foundPos);
            if (iterator != null) {
                AnchorAssist anchorAssist6 = anchorAssist;
                anchorAssist6.doSwap(n);
                BlockUtil.placeBlock(iterator, anchorAssist6.rotate.getValue());
                AnchorAssist anchorAssist7 = anchorAssist;
                if (anchorAssist6.inventory.getValue()) {
                    anchorAssist7.doSwap(n);
                    EntityUtil.syncInventory();
                    return;
                }
                anchorAssist7.doSwap(n2);
            }
        }
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AnchorAssist a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AnchorAssist.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public int findBlock(class_2248 class_22482) {
        AnchorAssist a = class_22482;
        AnchorAssist a2 = this;
        if (a2.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot((class_2248)a);
        }
        return InventoryUtil.findBlock((class_2248)a);
    }

    public class_2338 getHelper(class_2338 a) {
        int n;
        AnchorAssist a2;
        AnchorAssist anchorAssist = a2;
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if ((!anchorAssist.checkMine.getValue() || !BlockUtil.isMining(a.method_10093((class_2350)a2))) && BlockUtil.isStrictDirection(a.method_10093((class_2350)a2), a2.method_10153(), true) && BlockUtil.canPlace(a.method_10093((class_2350)a2))) {
                return a.method_10093((class_2350)a2);
            }
            n3 = ++n;
        }
        return null;
    }

    public AnchorAssist() {
        AnchorAssist a;
        AnchorAssist anchorAssist = a;
        AnchorAssist anchorAssist2 = a;
        super(OnlineUserInfo.ALLATORIxDEMO("@\u0018P,\\6h-@-G7"), Module.Category.Combat);
        AnchorAssist anchorAssist3 = a;
        anchorAssist3.rotate = anchorAssist2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0006):==>"), true));
        anchorAssist2.inventory = anchorAssist2.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\fo\u0000V*G+['`3U3"), true));
        anchorAssist2.usingPause = anchorAssist2.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u001b/'23\u0016/):>"), true));
        anchorAssist2.checkMine = anchorAssist2.add(new BooleanSetting(OnlineUserInfo.ALLATORIxDEMO("\u0007[!J5~-Z&"), false));
        anchorAssist2.range = anchorAssist2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO(":/.)9 \u0014/2.>"), 5.0, 0.0, 6.0, 0.1).setSuffix(OnlineUserInfo.ALLATORIxDEMO(".")));
        anchorAssist2.minDamage = anchorAssist2.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0011'2\u0010'#=.>"), 6.0, 0.0, 36.0, 0.1));
        anchorAssist2.delay = anchorAssist2.add(new SliderSetting(OnlineUserInfo.ALLATORIxDEMO("\u001aV(U:"), 0.0, 0.0, 0.5, 0.01).setSuffix(GaussianKernel.ALLATORIxDEMO("(")));
        anchorAssist.timer = new Timer();
        anchorAssist.setChinese(OnlineUserInfo.ALLATORIxDEMO("\u8fdb\u529a\u9189\u752b\u9559"));
        INSTANCE = anchorAssist;
    }
}
