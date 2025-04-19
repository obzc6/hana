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
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.combat.dev.ExtraOldTrap;
import dev.recollect.hana.mod.modules.settings.Placement;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
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
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameConverter;

public class OldTrap
extends Module {
    private final BooleanSetting head;
    private final BooleanSetting onlyHole;
    public final BooleanSetting render;
    public final ColorSetting color;
    final Timer timer;
    int progress;
    private final BooleanSetting selfGround;
    private final BooleanSetting checkMine;
    private final ArrayList<class_2338> placeList;
    private final BooleanSetting inventory;
    private final BooleanSetting headAnchor;
    private final SliderSetting multiPlace;
    private final BooleanSetting chest;
    private final BooleanSetting antiStep;
    private final BooleanSetting onlyBreaking;
    private final BooleanSetting onlyGround;
    private final BooleanSetting down;
    public final SliderSetting delay;
    private final BooleanSetting rotate;
    private final BooleanSetting usingPause;
    private final SliderSetting range;
    private final BooleanSetting helper;
    private final SliderSetting placeRange;
    public final BooleanSetting pre;
    private final BooleanSetting legs;
    public class_1657 target;
    public final BooleanSetting box;
    private final BooleanSetting legAnchor;
    private final ArrayList<class_2338> trapList;
    private final EnumSetting targetMod;
    public final BooleanSetting sync;
    private final BooleanSetting extend;
    public final SliderSetting fadeTime;
    private final BooleanSetting chestUp;
    private final BooleanSetting autoDisable;
    private final BooleanSetting breakCrystal;
    private final BooleanSetting onlyBreak;
    public final BooleanSetting outline;
    private final BooleanSetting headExtend;
    public static OldTrap INSTANCE;

    public OldTrap() {
        OldTrap a;
        OldTrap oldTrap = a;
        super(Setting.ALLATORIxDEMO("\u0010w<R7-"), OLEPOSSUtils.ALLATORIxDEMO("S\u0018\u0007c=N,N\u000bv\"]$\u00028Aa\u000fu^:HuO&Ro\u0004"), Module.Category.Combat);
        oldTrap.timer = new Timer();
        oldTrap.rotate = a.add(new BooleanSetting(Setting.ALLATORIxDEMO("I7r$8j"), true));
        oldTrap.multiPlace = oldTrap.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0018_>Y<z$Va\u0018"), 1, 1, 8));
        oldTrap.autoDisable = oldTrap.add(new BooleanSetting(Setting.ALLATORIxDEMO("Ln,s\u001br+g' j"), true));
        oldTrap.range = oldTrap.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("x)Ye\u0018"), 1.0, 0.0, 8.0));
        oldTrap.targetMod = oldTrap.add(new EnumSetting<TargetMode>(Setting.ALLATORIxDEMO("O9n8~,K*(j"), TargetMode.Single));
        oldTrap.checkMine = oldTrap.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("i:H6A\u0005^l\u0018"), true));
        oldTrap.helper = oldTrap.add(new BooleanSetting(Setting.ALLATORIxDEMO("S=j5)}"), true));
        oldTrap.inventory = oldTrap.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("zn\t0D&B'S\u001b@c\r"), true));
        oldTrap.extend = oldTrap.add(new BooleanSetting(Setting.ALLATORIxDEMO("^ r \"k"), true));
        oldTrap.antiStep = oldTrap.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0013C!C\u001bCg\r"), true));
        oldTrap.onlyBreak = oldTrap.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u0017r3b\u001at -d"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.antiStep.getValue();
        }));
        OldTrap oldTrap2 = a;
        oldTrap2.head = oldTrap2.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0000Rc\u0019"), true));
        oldTrap2.headExtend = oldTrap2.add(new BooleanSetting(Setting.ALLATORIxDEMO("S=};^ r \"k"), true));
        oldTrap2.headAnchor = oldTrap2.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u001dO3I\u0014D+_m\u000f"), true));
        oldTrap2.chestUp = oldTrap2.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u001cs=u1\u0019"), true));
        oldTrap2.onlyBreaking = oldTrap2.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("O\u00119S\u0010_0K#^l\u001a"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.chestUp.getValue();
        }));
        OldTrap oldTrap3 = a;
        oldTrap3.chest = oldTrap3.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u001bn ?{"), true));
        oldTrap3.onlyGround = oldTrap3.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u001aD>T\u0012X'Bl\u0019"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.chest.getValue();
        }));
        OldTrap oldTrap4 = a;
        oldTrap4.legs = oldTrap4.add(new BooleanSetting(Setting.ALLATORIxDEMO("J +|"), true));
        oldTrap4.legAnchor = oldTrap4.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("f7J\u0014D+_m\u000f"), true));
        oldTrap4.down = oldTrap4.add(new BooleanSetting(Setting.ALLATORIxDEMO("B*;a"), true));
        oldTrap4.onlyHole = oldTrap4.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u001dC9S\u0000Xn\u0018"), true));
        oldTrap4.breakCrystal = oldTrap4.add(new BooleanSetting(Setting.ALLATORIxDEMO("\f~9w\u001ci!u1-c"), true));
        oldTrap4.usingPause = oldTrap4.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0000Y;C2z)Bq\u0018"), true));
        oldTrap4.delay = oldTrap4.add(new SliderSetting(Setting.ALLATORIxDEMO("\u001cc)-v"), 0, 0, 500));
        oldTrap4.placeRange = oldTrap4.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0005F3N0x)Ye\u0018"), 1.0, 0.0, 6.0));
        oldTrap4.selfGround = oldTrap4.add(new BooleanSetting(Setting.ALLATORIxDEMO("H=p9\\*i0\"k"), true));
        oldTrap4.render = oldTrap4.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0007O&Sg\u000f"), true));
        oldTrap4.box = oldTrap4.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u0007#w"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.render.getValue();
        }));
        a.outline = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("b ^$^l\u0018"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.render.getValue();
        }));
        a.color = a.add(new ColorSetting(Setting.ALLATORIxDEMO("\u001bi)#}"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.render.getValue();
        }));
        a.fadeTime = a.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u0014L1O\u001c^o\u0018"), 0, 0, 5000, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.render.getValue();
        }));
        a.pre = a.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u0015>j"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.render.getValue();
        }));
        a.sync = a.add(new BooleanSetting(OLEPOSSUtils.ALLATORIxDEMO("\u001bNl\u001e"), true, object -> {
            Object a = object;
            OldTrap a2 = this;
            return a2.render.getValue();
        }));
        OldTrap oldTrap5 = a;
        OldTrap oldTrap6 = a;
        oldTrap6.progress = 0;
        oldTrap6.trapList = new ArrayList();
        oldTrap5.placeList = new ArrayList();
        oldTrap5.setChinese(Setting.ALLATORIxDEMO("N:y\u76dc\u81ec\u52ed\u56b8\u4eb5"));
        INSTANCE = oldTrap5;
    }

    private /* synthetic */ boolean checkEntity(class_2338 class_23382) {
        Object a = class_23382;
        OldTrap a2 = this;
        if (OldTrap.mc.field_1724.method_5829().method_994(new class_238((class_2338)a))) {
            return false;
        }
        a = OldTrap.mc.field_1687.method_18467(class_1657.class, new class_238((class_2338)a)).iterator();
        while (a.hasNext()) {
            if (!((class_1297)a.next()).method_5805()) continue;
            return true;
        }
        return false;
    }

    public class_2338 getHelper(class_2338 a, class_2350 a2) {
        int n;
        OldTrap a3;
        OldTrap oldTrap = a3;
        if (!oldTrap.helper.getValue()) {
            return null;
        }
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a3 = arrclass_2350[n];
            if (a3 != a2 && (!oldTrap.checkMine.getValue() || !BlockUtil.isMining(a.method_10093((class_2350)a3))) && BlockUtil.isStrictDirection(a.method_10093((class_2350)a3), a3.method_10153(), true) && BlockUtil.canPlace(a.method_10093((class_2350)a3))) {
                return a.method_10093((class_2350)a3);
            }
            n3 = ++n;
        }
        return null;
    }

    private /* synthetic */ void trapTarget(class_1657 class_16572) {
        OldTrap a = class_16572;
        OldTrap a2 = this;
        if (a2.onlyHole.getValue() && !BlockUtil.isHole(EntityUtil.getEntityPos((class_1297)a))) {
            return;
        }
        a2.doTrap(EntityUtil.getEntityPos((class_1297)a, true));
    }

    private /* synthetic */ void placeBlock(class_2338 class_23382) {
        OldTrap oldTrap;
        OldTrap a = class_23382;
        OldTrap a2 = this;
        if (a2.pre.getValue()) {
            ExtraOldTrap.addBlock((class_2338)a);
        }
        if (BlockUtil.isMining((class_2338)a)) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a, 6.0, a2.breakCrystal.getValue())) {
            return;
        }
        if (!((double)a2.progress < a2.multiPlace.getValue())) {
            return;
        }
        if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(a.method_46558()))) > a2.placeRange.getValue()) {
            return;
        }
        int n = OldTrap.mc.field_1724.method_31548().field_7545;
        int n2 = a2.getBlock();
        if (n2 == -1) {
            return;
        }
        if (a2.placeList.contains(a)) {
            return;
        }
        if (!a2.pre.getValue()) {
            ExtraOldTrap.addBlock((class_2338)a);
        }
        OldTrap oldTrap2 = a2;
        oldTrap2.placeList.add((class_2338)a);
        OldTrap oldTrap3 = a2;
        OldTrap oldTrap4 = a;
        CombatUtil.attackCrystal((class_2338)oldTrap4, a2.rotate.getValue(), a2.usingPause.getValue());
        oldTrap3.doSwap(n2);
        BlockUtil.placeBlock((class_2338)oldTrap4, oldTrap3.rotate.getValue());
        OldTrap oldTrap5 = a2;
        if (oldTrap2.inventory.getValue()) {
            oldTrap5.doSwap(n2);
            EntityUtil.syncInventory();
            oldTrap = a2;
        } else {
            oldTrap5.doSwap(n);
            oldTrap = a2;
        }
        oldTrap.timer.reset();
        ++a2.progress;
    }

    private /* synthetic */ void placeAnchor(class_2338 class_23382, boolean bl) {
        int a;
        OldTrap oldTrap;
        OldTrap a2 = class_23382;
        OldTrap a3 = this;
        if (a3.pre.getValue()) {
            ExtraOldTrap.addBlock((class_2338)a2);
        }
        if (BlockUtil.isMining((class_2338)a2)) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a2, 6.0, a3.breakCrystal.getValue())) {
            return;
        }
        if (!((double)a3.progress < a3.multiPlace.getValue())) {
            return;
        }
        if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(a2.method_46558()))) > a3.placeRange.getValue()) {
            return;
        }
        int n = OldTrap.mc.field_1724.method_31548().field_7545;
        int n2 = a = a != 0 && a3.getAnchor() != -1 ? a3.getAnchor() : a3.getBlock();
        if (a == -1) {
            return;
        }
        if (a3.placeList.contains(a2)) {
            return;
        }
        if (!a3.pre.getValue()) {
            ExtraOldTrap.addBlock((class_2338)a2);
        }
        OldTrap oldTrap2 = a3;
        oldTrap2.placeList.add((class_2338)a2);
        OldTrap oldTrap3 = a3;
        OldTrap oldTrap4 = a2;
        CombatUtil.attackCrystal((class_2338)oldTrap4, a3.rotate.getValue(), a3.usingPause.getValue());
        oldTrap3.doSwap(a);
        BlockUtil.placeBlock((class_2338)oldTrap4, oldTrap3.rotate.getValue());
        OldTrap oldTrap5 = a3;
        if (oldTrap2.inventory.getValue()) {
            oldTrap5.doSwap(a);
            EntityUtil.syncInventory();
            oldTrap = a3;
        } else {
            oldTrap5.doSwap(n);
            oldTrap = a3;
        }
        oldTrap.timer.reset();
        ++a3.progress;
    }

    private /* synthetic */ int getAnchor() {
        OldTrap a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_23152);
        }
        return InventoryUtil.findBlock(class_2246.field_23152);
    }

    @Override
    public String getInfo() {
        OldTrap a;
        if (a.target != null) {
            return a.target.method_5477().getString();
        }
        return null;
    }

    private /* synthetic */ int getBlock() {
        OldTrap a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    @Override
    public void onUpdate() {
        Object a;
        OldTrap oldTrap = a;
        if (OldTrap.nullCheck()) {
            return;
        }
        OldTrap oldTrap2 = oldTrap;
        oldTrap2.trapList.clear();
        oldTrap2.placeList.clear();
        oldTrap2.progress = 0;
        if (oldTrap.selfGround.getValue() && !OldTrap.mc.field_1724.method_24828()) {
            oldTrap.target = null;
            return;
        }
        if (oldTrap.usingPause.getValue() && EntityUtil.isUsing()) {
            oldTrap.target = null;
            return;
        }
        OldTrap oldTrap3 = oldTrap;
        if (!oldTrap3.timer.passedMs((long)oldTrap3.delay.getValue())) {
            return;
        }
        if (oldTrap.targetMod.getValue() == TargetMode.Single) {
            OldTrap oldTrap4 = oldTrap;
            oldTrap4.target = CombatUtil.getClosestEnemy(oldTrap4.range.getValue());
            if (oldTrap4.target == null) {
                if (oldTrap.autoDisable.getValue()) {
                    oldTrap.disable();
                }
                return;
            }
            OldTrap oldTrap5 = oldTrap;
            oldTrap5.trapTarget(oldTrap5.target);
            return;
        }
        if (oldTrap.targetMod.getValue() == TargetMode.Multi) {
            boolean bl = false;
            Object object = a = CombatUtil.getEnemies(oldTrap.range.getValue()).iterator();
            while (object.hasNext()) {
                class_1657 class_16572 = (class_1657)a.next();
                bl = true;
                object = a;
                OldTrap oldTrap6 = oldTrap;
                oldTrap6.target = class_16572;
                oldTrap6.trapTarget(oldTrap6.target);
            }
            if (!bl) {
                if (oldTrap.autoDisable.getValue()) {
                    oldTrap.disable();
                }
                oldTrap.target = null;
            }
        }
    }

    public class_2338 getHelper(class_2338 a) {
        OldTrap a2;
        int n;
        OldTrap oldTrap = a2;
        if (!oldTrap.helper.getValue()) {
            return null;
        }
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if (!(oldTrap.checkMine.getValue() && BlockUtil.isMining(a.method_10093((class_2350)a2)) || CombatSetting.INSTANCE.placement.getValue() == Placement.Strict && !BlockUtil.isStrictDirection(a.method_10093((class_2350)a2), a2.method_10153(), true) || !BlockUtil.canPlace(a.method_10093((class_2350)a2)))) {
                return a.method_10093((class_2350)a2);
            }
            n3 = ++n;
        }
        return null;
    }

    private /* synthetic */ void doTrap(class_2338 a) {
        class_2338 class_23382;
        int n;
        int n2;
        Object object;
        Object object2;
        Object object3;
        Object[] arrobject;
        class_2350 a2;
        int n3;
        class_2350 class_23502 = a2;
        if (class_23502.trapList.contains((Object)a)) {
            return;
        }
        class_2350 class_23503 = class_23502;
        class_23503.trapList.add(a);
        if (class_23503.legs.getValue()) {
            arrobject = class_2350.values();
            n = arrobject.length;
            int n4 = n2 = 0;
            while (n4 < n) {
                object2 = arrobject[n2];
                if (object2 != class_2350.field_11033 && object2 != class_2350.field_11036) {
                    class_2350 class_23504 = a2 = a.method_10093(object2);
                    class_23502.placeAnchor((class_2338)class_23504, class_23502.legAnchor.getValue());
                    if (BlockUtil.getPlaceSide((class_2338)class_23504) == null && BlockUtil.clientCanPlace((class_2338)a2) && class_23502.getHelper((class_2338)a2) != null) {
                        class_2350 class_23505 = class_23502;
                        class_23505.placeBlock(class_23505.getHelper((class_2338)a2));
                    }
                }
                n4 = ++n2;
            }
        }
        if (class_23502.headExtend.getValue()) {
            int[] arrn = new int[3];
            arrn[0] = 1;
            arrn[1] = 0;
            arrn[2] = -1;
            arrobject = arrn;
            n = arrn.length;
            int n5 = n2 = 0;
            while (n5 < n) {
                int n6 = arrobject[n2];
                class_2350 class_23506 = new int[3];
                class_23506[0] = 1;
                class_23506[1] = 0;
                class_23506[2] = -1;
                a2 = class_23506;
                object3 = ((class_2338)class_23506).length;
                int n7 = n3 = 0;
                while (n7 < object3) {
                    object = a2[n3];
                    class_23382 = a.method_10069((int)object, 0, n6);
                    if (class_23502.checkEntity(new class_2338((class_2382)class_23382))) {
                        class_2350 class_23507 = class_23502;
                        class_23507.placeAnchor(class_23382.method_10086(2), class_23507.headAnchor.getValue());
                    }
                    n7 = ++n3;
                }
                n5 = ++n2;
            }
        }
        if (class_23502.head.getValue() && BlockUtil.clientCanPlace(a.method_10086(2))) {
            class_2350 class_23508;
            block48 : {
                if (BlockUtil.getPlaceSide(a.method_10086(2)) == null) {
                    boolean bl = true;
                    if (class_23502.getHelper(a.method_10086(2)) != null) {
                        class_2350 class_23509 = class_23502;
                        class_23509.placeBlock(class_23509.getHelper(a.method_10086(2)));
                        bl = false;
                    }
                    if (bl) {
                        int n8;
                        boolean bl2;
                        class_2350[] arrclass_2350;
                        block46 : {
                            arrclass_2350 = class_2350.values();
                            n2 = arrclass_2350.length;
                            int n9 = n8 = 0;
                            while (n9 < n2) {
                                class_2338 class_23383;
                                a2 = arrclass_2350[n8];
                                if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036 && BlockUtil.clientCanPlace((class_23383 = a.method_10093(a2).method_10084()).method_10084(), false) && BlockUtil.canPlace(class_23383)) {
                                    class_23502.placeBlock(class_23383);
                                    bl2 = bl = false;
                                    break block46;
                                }
                                n9 = ++n8;
                            }
                            bl2 = bl;
                        }
                        if (bl2) {
                            boolean bl3;
                            block47 : {
                                arrclass_2350 = class_2350.values();
                                n2 = arrclass_2350.length;
                                int n10 = n8 = 0;
                                while (n10 < n2) {
                                    a2 = arrclass_2350[n8];
                                    if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                                        class_2338 class_23384 = a.method_10093(a2).method_10084();
                                        object3 = (Object)class_23384;
                                        if (BlockUtil.clientCanPlace(class_23384.method_10084(), false) && BlockUtil.getPlaceSide((class_2338)object3) == null && BlockUtil.clientCanPlace((class_2338)object3) && class_23502.getHelper((class_2338)object3) != null) {
                                            class_2350 class_235010 = class_23502;
                                            class_235010.placeBlock(class_235010.getHelper((class_2338)object3));
                                            bl3 = bl = false;
                                            break block47;
                                        }
                                    }
                                    n10 = ++n8;
                                }
                                bl3 = bl;
                            }
                            if (bl3) {
                                arrclass_2350 = class_2350.values();
                                n2 = arrclass_2350.length;
                                int n11 = n8 = 0;
                                while (n11 < n2) {
                                    a2 = arrclass_2350[n8];
                                    if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                                        class_2338 class_23385 = a.method_10093(a2).method_10084();
                                        object3 = (Object)class_23385;
                                        if (BlockUtil.clientCanPlace(class_23385.method_10084(), false) && BlockUtil.getPlaceSide((class_2338)object3) == null && BlockUtil.clientCanPlace((class_2338)object3, false) && class_23502.getHelper((class_2338)object3) != null && BlockUtil.getPlaceSide(object3.method_10074()) == null && BlockUtil.clientCanPlace(object3.method_10074(), false) && class_23502.getHelper(object3.method_10074()) != null) {
                                            class_2350 class_235011 = class_23502;
                                            class_23508 = class_235011;
                                            class_235011.placeBlock(class_235011.getHelper(object3.method_10074()));
                                            break block48;
                                        }
                                    }
                                    n11 = ++n8;
                                }
                            }
                        }
                    }
                }
                class_23508 = class_23502;
            }
            class_23508.placeAnchor(a.method_10086(2), class_23502.headAnchor.getValue());
        }
        if (class_23502.antiStep.getValue() && (BlockUtil.isMining(a.method_10086(2)) || !class_23502.onlyBreak.getValue())) {
            if (BlockUtil.getPlaceSide(a.method_10086(3)) == null && BlockUtil.clientCanPlace(a.method_10086(3)) && class_23502.getHelper(a.method_10086(3), class_2350.field_11033) != null) {
                class_2350 class_235012 = class_23502;
                class_235012.placeBlock(class_235012.getHelper(a.method_10086(3)));
            }
            class_23502.placeBlock(a.method_10086(3));
        }
        if (class_23502.down.getValue()) {
            int[] arrn = arrobject = a.method_10074();
            class_23502.placeBlock((class_2338)arrn);
            if (BlockUtil.getPlaceSide((class_2338)arrn) == null && BlockUtil.clientCanPlace((class_2338)arrobject) && class_23502.getHelper((class_2338)arrobject) != null) {
                class_2350 class_235013 = class_23502;
                class_235013.placeBlock(class_235013.getHelper((class_2338)arrobject));
            }
        }
        if (class_23502.chestUp.getValue()) {
            arrobject = class_2350.values();
            n = arrobject.length;
            int n12 = n2 = 0;
            while (n12 < n) {
                int n13 = arrobject[n2];
                if (n13 != class_2350.field_11033 && n13 != class_2350.field_11036) {
                    a2 = a.method_10093((class_2350)n13).method_10086(2);
                    if (!class_23502.onlyBreaking.getValue() || BlockUtil.isMining(a.method_10086(2))) {
                        class_23502.placeBlock((class_2338)a2);
                        if (BlockUtil.getPlaceSide((class_2338)a2) == null && BlockUtil.clientCanPlace((class_2338)a2)) {
                            if (class_23502.getHelper((class_2338)a2) != null) {
                                class_2350 class_235014 = class_23502;
                                class_235014.placeBlock(class_235014.getHelper((class_2338)a2));
                            } else if (BlockUtil.getPlaceSide(a2.method_10074()) == null && BlockUtil.clientCanPlace(a2.method_10074()) && class_23502.getHelper(a2.method_10074()) != null) {
                                class_2350 class_235015 = class_23502;
                                class_235015.placeBlock(class_235015.getHelper(a2.method_10074()));
                            }
                        }
                    }
                }
                n12 = ++n2;
            }
        }
        if (class_23502.chest.getValue() && (!class_23502.onlyGround.getValue() || class_23502.target.method_24828())) {
            arrobject = class_2350.values();
            n = arrobject.length;
            int n14 = n2 = 0;
            while (n14 < n) {
                int n15 = arrobject[n2];
                if (n15 != class_2350.field_11033 && n15 != class_2350.field_11036) {
                    class_2350 class_235016 = a2 = a.method_10093((class_2350)n15).method_10084();
                    class_23502.placeBlock((class_2338)class_235016);
                    if (BlockUtil.getPlaceSide((class_2338)class_235016) == null && BlockUtil.clientCanPlace((class_2338)a2)) {
                        if (class_23502.getHelper((class_2338)a2) != null) {
                            class_2350 class_235017 = class_23502;
                            class_235017.placeBlock(class_235017.getHelper((class_2338)a2));
                        } else if (BlockUtil.getPlaceSide(a2.method_10074()) == null && BlockUtil.clientCanPlace(a2.method_10074()) && class_23502.getHelper(a2.method_10074()) != null) {
                            class_2350 class_235018 = class_23502;
                            class_235018.placeBlock(class_235018.getHelper(a2.method_10074()));
                        }
                    }
                }
                n14 = ++n2;
            }
        }
        if (class_23502.extend.getValue()) {
            int[] arrn = new int[3];
            arrn[0] = 1;
            arrn[1] = 0;
            arrn[2] = -1;
            arrobject = arrn;
            n = arrn.length;
            int n16 = n2 = 0;
            while (n16 < n) {
                object2 = arrobject[n2];
                class_2350 class_235019 = new int[3];
                class_235019[0] = 1;
                class_235019[1] = 0;
                class_235019[2] = -1;
                a2 = class_235019;
                int n17 = ((int[])class_235019).length;
                int n18 = n3 = 0;
                while (n18 < n17) {
                    object = a2[n3];
                    class_23382 = a.method_10069((int)object2, 0, (int)object);
                    if (class_23502.checkEntity(new class_2338((class_2382)class_23382))) {
                        class_23502.doTrap(class_23382);
                    }
                    n18 = ++n3;
                }
                n16 = ++n2;
            }
        }
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        OldTrap a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, OldTrap.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    public static final class TargetMode
    extends Enum<TargetMode> {
        public static final /* enum */ TargetMode Multi;
        public static final /* enum */ TargetMode Single;
        private static final /* synthetic */ TargetMode[] $VALUES;

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

        public static TargetMode valueOf(String a) {
            return Enum.valueOf(TargetMode.class, a);
        }

        private static /* synthetic */ TargetMode[] $values() {
            TargetMode[] arrtargetMode = new TargetMode[2];
            arrtargetMode[0] = Single;
            arrtargetMode[1] = Multi;
            return arrtargetMode;
        }

        public static TargetMode[] values() {
            return (TargetMode[])$VALUES.clone();
        }

        static {
            Single = new TargetMode(FrameConverter.ALLATORIxDEMO("!x\u0001kI#"), 0);
            Multi = new TargetMode(Snow.ALLATORIxDEMO("\u0017p=p9"), 1);
            $VALUES = TargetMode.$values();
        }
    }

}
