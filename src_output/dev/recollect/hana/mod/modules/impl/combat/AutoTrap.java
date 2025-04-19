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
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.Placement;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class AutoTrap
extends Module {
    private final BooleanSetting head;
    public final BooleanSetting pre;
    public final SliderSetting fadeTime;
    private final BooleanSetting legAnchor;
    int progress;
    private final BooleanSetting breakCrystal;
    public final BooleanSetting sync;
    private final BooleanSetting checkMine;
    private final BooleanSetting headExtend;
    private final BooleanSetting onlyBreaking;
    public final BooleanSetting outline;
    private final BooleanSetting selfGround;
    private final BooleanSetting headAnchor;
    public final BooleanSetting box;
    public static AutoTrap INSTANCE;
    private final BooleanSetting onlyBreak;
    private final BooleanSetting rotate;
    private final BooleanSetting onlyGround;
    private final ArrayList<class_2338> trapList;
    public final BooleanSetting render;
    final Timer timer;
    private final BooleanSetting autoDisable;
    private final BooleanSetting helper;
    private final BooleanSetting legs;
    private final EnumSetting<TargetMode> targetMod;
    private final BooleanSetting chestUp;
    private final ArrayList<class_2338> placeList;
    private final BooleanSetting down;
    private final BooleanSetting onlyHole;
    public final SliderSetting delay;
    public final ColorSetting color;
    private final BooleanSetting usingPause;
    public class_1657 target;
    private final BooleanSetting chest;
    private final SliderSetting blocksPer;
    private final SliderSetting placeRange;
    private final SliderSetting range;
    private final BooleanSetting inventory;
    private final BooleanSetting antiStep;
    private final BooleanSetting extend;

    @Override
    public String getInfo() {
        AutoTrap a;
        if (a.target != null) {
            return a.target.method_5477().getString();
        }
        return null;
    }

    private /* synthetic */ int getAnchor() {
        AutoTrap a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_23152);
        }
        return InventoryUtil.findBlock(class_2246.field_23152);
    }

    private /* synthetic */ int getBlock() {
        AutoTrap a;
        if (a.inventory.getValue()) {
            return InventoryUtil.findBlockInventorySlot(class_2246.field_10540);
        }
        return InventoryUtil.findBlock(class_2246.field_10540);
    }

    private /* synthetic */ void doTrap(class_2338 a) {
        class_2338 class_23382;
        Object object;
        Object object2;
        int n;
        Object object3;
        Object[] arrobject;
        class_2350 a2;
        int n2;
        int n3;
        class_2350 class_23502 = a2;
        if (class_23502.trapList.contains((Object)a)) {
            return;
        }
        class_2350 class_23503 = class_23502;
        class_23503.trapList.add(a);
        if (class_23503.legs.getValue()) {
            arrobject = class_2350.values();
            n2 = arrobject.length;
            int n4 = n3 = 0;
            while (n4 < n2) {
                object2 = arrobject[n3];
                if (object2 != class_2350.field_11033 && object2 != class_2350.field_11036) {
                    class_2350 class_23504 = a2 = a.method_10093(object2);
                    class_23502.tryPlaceBlock((class_2338)class_23504, class_23502.legAnchor.getValue());
                    if (BlockUtil.getPlaceSide((class_2338)class_23504) == null && BlockUtil.clientCanPlace((class_2338)a2, class_23502.breakCrystal.getValue()) && class_23502.getHelper((class_2338)a2) != null) {
                        class_2350 class_23505 = class_23502;
                        class_23505.tryPlaceObsidian(class_23505.getHelper((class_2338)a2));
                    }
                }
                n4 = ++n3;
            }
        }
        if (class_23502.headExtend.getValue()) {
            int[] arrn = new int[3];
            arrn[0] = 1;
            arrn[1] = 0;
            arrn[2] = -1;
            arrobject = arrn;
            n2 = arrn.length;
            int n5 = n3 = 0;
            while (n5 < n2) {
                int n6 = arrobject[n3];
                class_2350 class_23506 = new int[3];
                class_23506[0] = 1;
                class_23506[1] = 0;
                class_23506[2] = -1;
                a2 = class_23506;
                object3 = ((class_2338)class_23506).length;
                int n7 = n = 0;
                while (n7 < object3) {
                    object = a2[n];
                    class_23382 = a.method_10069((int)object, 0, n6);
                    if (class_23502.checkEntity(new class_2338((class_2382)class_23382))) {
                        class_2350 class_23507 = class_23502;
                        class_23507.tryPlaceBlock(class_23382.method_10086(2), class_23507.headAnchor.getValue());
                    }
                    n7 = ++n;
                }
                n5 = ++n3;
            }
        }
        if (class_23502.head.getValue() && BlockUtil.clientCanPlace(a.method_10086(2), class_23502.breakCrystal.getValue())) {
            class_2350 class_23508;
            block48 : {
                if (BlockUtil.getPlaceSide(a.method_10086(2)) == null) {
                    class_2350 class_23509 = class_23502;
                    boolean bl = class_23509.helper.getValue();
                    if (class_23509.getHelper(a.method_10086(2)) != null) {
                        class_2350 class_235010 = class_23502;
                        class_235010.tryPlaceObsidian(class_235010.getHelper(a.method_10086(2)));
                        bl = false;
                    }
                    if (bl) {
                        int n8;
                        boolean bl2;
                        class_2350[] arrclass_2350;
                        block46 : {
                            arrclass_2350 = class_2350.values();
                            n3 = arrclass_2350.length;
                            int n9 = n8 = 0;
                            while (n9 < n3) {
                                class_2338 class_23383;
                                a2 = arrclass_2350[n8];
                                if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036 && BlockUtil.clientCanPlace((class_23383 = a.method_10093(a2).method_10084()).method_10084(), class_23502.breakCrystal.getValue()) && BlockUtil.canPlace(class_23383, class_23502.placeRange.getValue(), class_23502.breakCrystal.getValue())) {
                                    class_23502.tryPlaceObsidian(class_23383);
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
                                n3 = arrclass_2350.length;
                                int n10 = n8 = 0;
                                while (n10 < n3) {
                                    a2 = arrclass_2350[n8];
                                    if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                                        class_2338 class_23384 = a.method_10093(a2).method_10084();
                                        object3 = (Object)class_23384;
                                        if (BlockUtil.clientCanPlace(class_23384.method_10084(), class_23502.breakCrystal.getValue()) && BlockUtil.getPlaceSide((class_2338)object3) == null && BlockUtil.clientCanPlace((class_2338)object3, class_23502.breakCrystal.getValue()) && class_23502.getHelper((class_2338)object3) != null) {
                                            class_2350 class_235011 = class_23502;
                                            class_235011.tryPlaceObsidian(class_235011.getHelper((class_2338)object3));
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
                                n3 = arrclass_2350.length;
                                int n11 = n8 = 0;
                                while (n11 < n3) {
                                    a2 = arrclass_2350[n8];
                                    if (a2 != class_2350.field_11033 && a2 != class_2350.field_11036) {
                                        class_2338 class_23385 = a.method_10093(a2).method_10084();
                                        object3 = (Object)class_23385;
                                        if (BlockUtil.clientCanPlace(class_23385.method_10084(), class_23502.breakCrystal.getValue()) && BlockUtil.getPlaceSide((class_2338)object3) == null && BlockUtil.clientCanPlace((class_2338)object3, class_23502.breakCrystal.getValue()) && class_23502.getHelper((class_2338)object3) != null && BlockUtil.getPlaceSide(object3.method_10074()) == null && BlockUtil.clientCanPlace(object3.method_10074(), class_23502.breakCrystal.getValue()) && class_23502.getHelper(object3.method_10074()) != null) {
                                            class_2350 class_235012 = class_23502;
                                            class_23508 = class_235012;
                                            class_235012.tryPlaceObsidian(class_235012.getHelper(object3.method_10074()));
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
            class_23508.tryPlaceBlock(a.method_10086(2), class_23502.headAnchor.getValue());
        }
        if (class_23502.antiStep.getValue() && (BlockUtil.isMining(a.method_10086(2)) || !class_23502.onlyBreak.getValue())) {
            if (BlockUtil.getPlaceSide(a.method_10086(3)) == null && BlockUtil.clientCanPlace(a.method_10086(3), class_23502.breakCrystal.getValue()) && class_23502.getHelper(a.method_10086(3), class_2350.field_11033) != null) {
                class_2350 class_235013 = class_23502;
                class_235013.tryPlaceObsidian(class_235013.getHelper(a.method_10086(3)));
            }
            class_23502.tryPlaceObsidian(a.method_10086(3));
        }
        if (class_23502.down.getValue()) {
            int[] arrn = arrobject = a.method_10074();
            class_23502.tryPlaceObsidian((class_2338)arrn);
            if (BlockUtil.getPlaceSide((class_2338)arrn) == null && BlockUtil.clientCanPlace((class_2338)arrobject, class_23502.breakCrystal.getValue()) && class_23502.getHelper((class_2338)arrobject) != null) {
                class_2350 class_235014 = class_23502;
                class_235014.tryPlaceObsidian(class_235014.getHelper((class_2338)arrobject));
            }
        }
        if (class_23502.chestUp.getValue()) {
            arrobject = class_2350.values();
            n2 = arrobject.length;
            int n12 = n3 = 0;
            while (n12 < n2) {
                int n13 = arrobject[n3];
                if (n13 != class_2350.field_11033 && n13 != class_2350.field_11036) {
                    a2 = a.method_10093((class_2350)n13).method_10086(2);
                    if (!class_23502.onlyBreaking.getValue() || BlockUtil.isMining(a.method_10086(2))) {
                        class_23502.tryPlaceObsidian((class_2338)a2);
                        if (BlockUtil.getPlaceSide((class_2338)a2) == null && BlockUtil.clientCanPlace((class_2338)a2, class_23502.breakCrystal.getValue())) {
                            if (class_23502.getHelper((class_2338)a2) != null) {
                                class_2350 class_235015 = class_23502;
                                class_235015.tryPlaceObsidian(class_235015.getHelper((class_2338)a2));
                            } else if (BlockUtil.getPlaceSide(a2.method_10074()) == null && BlockUtil.clientCanPlace(a2.method_10074(), class_23502.breakCrystal.getValue()) && class_23502.getHelper(a2.method_10074()) != null) {
                                class_2350 class_235016 = class_23502;
                                class_235016.tryPlaceObsidian(class_235016.getHelper(a2.method_10074()));
                            }
                        }
                    }
                }
                n12 = ++n3;
            }
        }
        if (class_23502.chest.getValue() && (!class_23502.onlyGround.getValue() || class_23502.target.method_24828())) {
            arrobject = class_2350.values();
            n2 = arrobject.length;
            int n14 = n3 = 0;
            while (n14 < n2) {
                int n15 = arrobject[n3];
                if (n15 != class_2350.field_11033 && n15 != class_2350.field_11036) {
                    class_2350 class_235017 = a2 = a.method_10093((class_2350)n15).method_10084();
                    class_23502.tryPlaceObsidian((class_2338)class_235017);
                    if (BlockUtil.getPlaceSide((class_2338)class_235017) == null && BlockUtil.clientCanPlace((class_2338)a2, class_23502.breakCrystal.getValue())) {
                        if (class_23502.getHelper((class_2338)a2) != null) {
                            class_2350 class_235018 = class_23502;
                            class_235018.tryPlaceObsidian(class_235018.getHelper((class_2338)a2));
                        } else if (BlockUtil.getPlaceSide(a2.method_10074()) == null && BlockUtil.clientCanPlace(a2.method_10074(), class_23502.breakCrystal.getValue()) && class_23502.getHelper(a2.method_10074()) != null) {
                            class_2350 class_235019 = class_23502;
                            class_235019.tryPlaceObsidian(class_235019.getHelper(a2.method_10074()));
                        }
                    }
                }
                n14 = ++n3;
            }
        }
        if (class_23502.extend.getValue()) {
            int[] arrn = new int[3];
            arrn[0] = 1;
            arrn[1] = 0;
            arrn[2] = -1;
            arrobject = arrn;
            n2 = arrn.length;
            int n16 = n3 = 0;
            while (n16 < n2) {
                object2 = arrobject[n3];
                class_2350 class_235020 = new int[3];
                class_235020[0] = 1;
                class_235020[1] = 0;
                class_235020[2] = -1;
                a2 = class_235020;
                int n17 = ((int[])class_235020).length;
                int n18 = n = 0;
                while (n18 < n17) {
                    object = a2[n];
                    class_23382 = a.method_10069((int)object2, 0, (int)object);
                    if (class_23502.checkEntity(new class_2338((class_2382)class_23382))) {
                        class_23502.doTrap(class_23382);
                    }
                    n18 = ++n;
                }
                n16 = ++n3;
            }
        }
    }

    public AutoTrap() {
        AutoTrap a;
        AutoTrap autoTrap = a;
        super(TimeHelper.ALLATORIxDEMO("f\u0010T\ri\r\u0016E"), SocketClient.ALLATORIxDEMO("`qWiAh[cY~\f)v\nOl[o\u0001prZ\u001c|AoSb"), Module.Category.Combat);
        autoTrap.timer = new Timer();
        autoTrap.rotate = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("r\rI\u001e\u0003P"), true));
        autoTrap.blocksPer = autoTrap.add(new SliderSetting(SocketClient.ALLATORIxDEMO("FvP_r\\Z[i"), 1, 1, 8));
        autoTrap.autoDisable = autoTrap.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("vU\u0016H!I\u0011\\\u001d\u001bP"), true));
        autoTrap.range = autoTrap.add(new SliderSetting(SocketClient.ALLATORIxDEMO("KNdY~"), 5.0, 1.0, 8.0).setSuffix(TimeHelper.ALLATORIxDEMO("X")));
        autoTrap.targetMod = autoTrap.add(new EnumSetting<TargetMode>(SocketClient.ALLATORIxDEMO("uehXYmbeZ~"), TargetMode.Single));
        autoTrap.checkMine = autoTrap.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("1RT\u0007D\u0011m\u000bS\u0016\u0019R"), false));
        autoTrap.helper = autoTrap.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("t|Cz[i"), true));
        autoTrap.inventory = autoTrap.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("2\u001bAE\fS\nR\u001bn\b\u0016E"), true));
        autoTrap.extend = autoTrap.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("ya[oP"), true));
        autoTrap.antiStep = autoTrap.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("f\u000bT\u000bn\u000b\u0012E"), false));
        autoTrap.onlyBreak = autoTrap.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("KtSE[]o_p"), false, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.antiStep.getValue();
        }));
        AutoTrap autoTrap2 = a;
        autoTrap2.head = autoTrap2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("u\u001a\u0016Q"), true));
        autoTrap2.headExtend = autoTrap2.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("ia{[ya[oP"), true));
        autoTrap2.headAnchor = autoTrap2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("h\u0007F\u0001a\f^\u0017\u0018G"), true));
        autoTrap2.chestUp = autoTrap2.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("|T|\\~kk"), true));
        autoTrap2.onlyBreaking = autoTrap2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO(":YL\u001be\u0017E\u0003V\u0016\u0019R"), false, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.chestUp.getValue();
        }));
        AutoTrap autoTrap3 = a;
        autoTrap3.chest = autoTrap3.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("ZGoMo"), true));
        autoTrap3.onlyGround = autoTrap3.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("o\fK\u001cg\u0010R\n\u0019Q"), false, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.chest.getValue();
        }));
        AutoTrap autoTrap4 = a;
        autoTrap4.legs = autoTrap4.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("coYh"), false));
        autoTrap4.legAnchor = autoTrap4.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO(".B\u0002a\f^\u0017\u0018G"), true));
        autoTrap4.down = autoTrap4.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("keIu"), false));
        autoTrap4.onlyHole = autoTrap4.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("h\u000bL\u001bu\u0010\u001bP"), false));
        autoTrap4.breakCrystal = autoTrap4.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("[]o_p"), true));
        autoTrap4.usingPause = autoTrap4.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("u\u0011N\u000bG2\\\n\u0004P"), true));
        autoTrap4.delay = autoTrap4.add(new SliderSetting(SocketClient.ALLATORIxDEMO("]Jf_b"), 100, 0, 500).setSuffix(TimeHelper.ALLATORIxDEMO("\u001aF")));
        autoTrap4.placeRange = autoTrap4.add(new SliderSetting(SocketClient.ALLATORIxDEMO("qh{\\YKNdY~"), 4.0, 1.0, 6.0).setSuffix(TimeHelper.ALLATORIxDEMO("X")));
        autoTrap4.selfGround = autoTrap4.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("ravY{k@P"), true));
        autoTrap4.render = autoTrap4.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("r\u0007S\u001b\u0012G"), true));
        autoTrap4.box = autoTrap4.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("HQc"), true, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.render.getValue();
        }));
        a.outline = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("*U\u0016Q\u0016\u0019P"), false, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.render.getValue();
        }));
        a.color = a.add(new ColorSetting(SocketClient.ALLATORIxDEMO("Z@fQi"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.render.getValue();
        }));
        a.fadeTime = a.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("a\u0004D\u0007i\u0016\u001aP"), 500, 0, 5000, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.render.getValue();
        }).setSuffix(SocketClient.ALLATORIxDEMO("Sh")));
        a.pre = a.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("/\u0005P"), false, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.render.getValue();
        }));
        a.sync = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("|sPx"), true, object -> {
            Object a = object;
            AutoTrap a2 = this;
            return a2.render.getValue();
        }));
        AutoTrap autoTrap5 = a;
        AutoTrap autoTrap6 = a;
        autoTrap6.progress = 0;
        autoTrap6.trapList = new ArrayList();
        autoTrap5.placeList = new ArrayList();
        autoTrap5.setChinese(TimeHelper.ALLATORIxDEMO("\u81d7\u52d7\u5683\u4e8f"));
        INSTANCE = autoTrap5;
        Hana.EVENT_BUS.subscribe(new AutoTrapRender(a));
    }

    private /* synthetic */ void tryPlaceObsidian(class_2338 class_23382) {
        AutoTrap autoTrap;
        AutoTrap a = class_23382;
        AutoTrap a2 = this;
        if (a2.pre.getValue()) {
            AutoTrapRender.addBlock((class_2338)a);
        }
        if (a2.placeList.contains(a)) {
            return;
        }
        if (BlockUtil.isMining((class_2338)a)) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a, 6.0, a2.breakCrystal.getValue())) {
            return;
        }
        if (!((double)a2.progress < a2.blocksPer.getValue())) {
            return;
        }
        if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(a.method_46558()))) > a2.placeRange.getValue()) {
            return;
        }
        int n = AutoTrap.mc.field_1724.method_31548().field_7545;
        int n2 = a2.getBlock();
        if (n2 == -1) {
            return;
        }
        if (!a2.pre.getValue()) {
            AutoTrapRender.addBlock((class_2338)a);
        }
        AutoTrap autoTrap2 = a2;
        autoTrap2.placeList.add((class_2338)a);
        AutoTrap autoTrap3 = a2;
        AutoTrap autoTrap4 = a;
        CombatUtil.attackCrystal((class_2338)autoTrap4, a2.rotate.getValue(), a2.usingPause.getValue());
        autoTrap3.doSwap(n2);
        BlockUtil.placeBlock((class_2338)autoTrap4, autoTrap3.rotate.getValue());
        AutoTrap autoTrap5 = a2;
        if (autoTrap2.inventory.getValue()) {
            autoTrap5.doSwap(n2);
            EntityUtil.syncInventory();
            autoTrap = a2;
        } else {
            autoTrap5.doSwap(n);
            autoTrap = a2;
        }
        autoTrap.timer.reset();
        ++a2.progress;
    }

    private /* synthetic */ void trapTarget(class_1657 class_16572) {
        AutoTrap a = class_16572;
        AutoTrap a2 = this;
        if (a2.onlyHole.getValue() && !BlockUtil.isHole(EntityUtil.getEntityPos((class_1297)a))) {
            return;
        }
        a2.doTrap(EntityUtil.getEntityPos((class_1297)a, true));
    }

    public class_2338 getHelper(class_2338 a, class_2350 a2) {
        AutoTrap a3;
        int n;
        AutoTrap autoTrap = a3;
        if (!autoTrap.helper.getValue()) {
            return null;
        }
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a3 = arrclass_2350[n];
            if (a3 != a2 && (!autoTrap.checkMine.getValue() || !BlockUtil.isMining(a.method_10093((class_2350)a3))) && BlockUtil.isStrictDirection(a.method_10093((class_2350)a3), a3.method_10153(), true) && BlockUtil.canPlace(a.method_10093((class_2350)a3), autoTrap.placeRange.getValue(), autoTrap.breakCrystal.getValue())) {
                return a.method_10093((class_2350)a3);
            }
            n3 = ++n;
        }
        return null;
    }

    public class_2338 getHelper(class_2338 a) {
        int n;
        AutoTrap a2;
        AutoTrap autoTrap = a2;
        if (!autoTrap.helper.getValue()) {
            return null;
        }
        class_2350[] arrclass_2350 = class_2350.values();
        int n2 = arrclass_2350.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrclass_2350[n];
            if (!(autoTrap.checkMine.getValue() && BlockUtil.isMining(a.method_10093((class_2350)a2)) || CombatSetting.INSTANCE.placement.getValue() == Placement.Strict && !BlockUtil.isStrictDirection(a.method_10093((class_2350)a2), a2.method_10153(), true) || !BlockUtil.canPlace(a.method_10093((class_2350)a2), autoTrap.placeRange.getValue(), autoTrap.breakCrystal.getValue()))) {
                return a.method_10093((class_2350)a2);
            }
            n3 = ++n;
        }
        return null;
    }

    private /* synthetic */ void tryPlaceBlock(class_2338 class_23382, boolean bl) {
        int a;
        AutoTrap autoTrap;
        AutoTrap a2 = class_23382;
        AutoTrap a3 = this;
        if (a3.pre.getValue()) {
            AutoTrapRender.addBlock((class_2338)a2);
        }
        if (a3.placeList.contains(a2)) {
            return;
        }
        if (BlockUtil.isMining((class_2338)a2)) {
            return;
        }
        if (!BlockUtil.canPlace((class_2338)a2, 6.0, a3.breakCrystal.getValue())) {
            return;
        }
        if (!((double)a3.progress < a3.blocksPer.getValue())) {
            return;
        }
        if ((double)class_3532.method_15355((float)((float)EntityUtil.getEyesPos().method_1025(a2.method_46558()))) > a3.placeRange.getValue()) {
            return;
        }
        int n = AutoTrap.mc.field_1724.method_31548().field_7545;
        int n2 = a = a != 0 && a3.getAnchor() != -1 ? a3.getAnchor() : a3.getBlock();
        if (a == -1) {
            return;
        }
        if (!a3.pre.getValue()) {
            AutoTrapRender.addBlock((class_2338)a2);
        }
        AutoTrap autoTrap2 = a3;
        autoTrap2.placeList.add((class_2338)a2);
        AutoTrap autoTrap3 = a3;
        AutoTrap autoTrap4 = a2;
        CombatUtil.attackCrystal((class_2338)autoTrap4, a3.rotate.getValue(), a3.usingPause.getValue());
        autoTrap3.doSwap(a);
        BlockUtil.placeBlock((class_2338)autoTrap4, autoTrap3.rotate.getValue());
        AutoTrap autoTrap5 = a3;
        if (autoTrap2.inventory.getValue()) {
            autoTrap5.doSwap(a);
            EntityUtil.syncInventory();
            autoTrap = a3;
        } else {
            autoTrap5.doSwap(n);
            autoTrap = a3;
        }
        autoTrap.timer.reset();
        ++a3.progress;
    }

    private /* synthetic */ boolean checkEntity(class_2338 class_23382) {
        Object a = class_23382;
        AutoTrap a2 = this;
        if (AutoTrap.mc.field_1724.method_5829().method_994(new class_238((class_2338)a))) {
            return false;
        }
        a = AutoTrap.mc.field_1687.method_18467(class_1657.class, new class_238((class_2338)a)).iterator();
        while (a.hasNext()) {
            if (!((class_1297)a.next()).method_5805()) continue;
            return true;
        }
        return false;
    }

    private /* synthetic */ void doSwap(int n) {
        int a = n;
        AutoTrap a2 = this;
        if (a2.inventory.getValue()) {
            InventoryUtil.inventorySwap(a, AutoTrap.mc.field_1724.method_31548().field_7545);
            return;
        }
        InventoryUtil.switchToSlot(a);
    }

    @Override
    public void onUpdate() {
        Object a;
        AutoTrap autoTrap = a;
        if (AutoTrap.nullCheck()) {
            return;
        }
        AutoTrap autoTrap2 = autoTrap;
        autoTrap2.trapList.clear();
        autoTrap2.placeList.clear();
        autoTrap2.progress = 0;
        if (autoTrap.selfGround.getValue() && !AutoTrap.mc.field_1724.method_24828()) {
            autoTrap.target = null;
            return;
        }
        if (autoTrap.usingPause.getValue() && EntityUtil.isUsing()) {
            autoTrap.target = null;
            return;
        }
        AutoTrap autoTrap3 = autoTrap;
        if (!autoTrap3.timer.passedMs((long)autoTrap3.delay.getValue())) {
            return;
        }
        if (autoTrap.targetMod.getValue() == TargetMode.Single) {
            AutoTrap autoTrap4 = autoTrap;
            autoTrap4.target = CombatUtil.getClosestEnemy(autoTrap4.range.getValue());
            if (autoTrap4.target == null) {
                if (autoTrap.autoDisable.getValue()) {
                    autoTrap.disable();
                }
                return;
            }
            AutoTrap autoTrap5 = autoTrap;
            autoTrap5.trapTarget(autoTrap5.target);
            return;
        }
        if (autoTrap.targetMod.getValue() == TargetMode.Multi) {
            boolean bl = false;
            Object object = a = CombatUtil.getEnemies(autoTrap.range.getValue()).iterator();
            while (object.hasNext()) {
                class_1657 class_16572 = (class_1657)a.next();
                bl = true;
                object = a;
                AutoTrap autoTrap6 = autoTrap;
                autoTrap6.target = class_16572;
                autoTrap6.trapTarget(autoTrap6.target);
            }
            if (!bl) {
                if (autoTrap.autoDisable.getValue()) {
                    autoTrap.disable();
                }
                autoTrap.target = null;
            }
        }
    }

    public static final class TargetMode
    extends Enum<TargetMode> {
        public static final /* enum */ TargetMode Multi;
        public static final /* enum */ TargetMode Single;
        private static final /* synthetic */ TargetMode[] $VALUES;

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

        static {
            Single = new TargetMode(BufferRing.ALLATORIxDEMO("\u001a\u0014:\u0007rO"), 0);
            Multi = new TargetMode(TimerManager.ALLATORIxDEMO("\u0006\u0011:Zu"), 1);
            $VALUES = TargetMode.$values();
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
    }

    public class AutoTrapRender {
        public static final HashMap<class_2338, placePosition> PlaceMap = new HashMap();
        final /* synthetic */ AutoTrap this$0;

        @EventHandler
        public void onRender3D(Render3DEvent a) {
            placePosition a2;
            Iterator<placePosition> iterator;
            AutoTrapRender autoTrapRender = a2;
            if (!autoTrapRender.this$0.render.getValue()) {
                return;
            }
            if (PlaceMap.isEmpty()) {
                return;
            }
            boolean bl = true;
            Iterator<placePosition> iterator2 = iterator = PlaceMap.values().iterator();
            while (iterator2.hasNext()) {
                a2 = iterator.next();
                if (!BlockUtil.clientCanPlace(a2.pos, true)) {
                    a2.isAir = false;
                }
                if (!a2.timer.passedMs((long)(autoTrapRender.this$0.delay.getValue() + 100.0)) && a2.isAir) {
                    a2.firstFade.reset();
                }
                if (a2.firstFade.getQuad(FadeUtils.Quad.In2) == 1.0) {
                    iterator2 = iterator;
                    continue;
                }
                bl = false;
                iterator2 = iterator;
                AutoTrapRender autoTrapRender2 = autoTrapRender;
                autoTrapRender2.drawBlock(a2.pos, (double)autoTrapRender2.this$0.color.getValue().getAlpha() * (1.0 - a2.firstFade.getQuad(FadeUtils.Quad.In2)), a2.posColor, a.getMatrixStack());
            }
            if (bl) {
                PlaceMap.clear();
            }
        }

        public AutoTrapRender(AutoTrap autoTrap) {
            AutoTrap a = autoTrap;
            AutoTrapRender a2 = this;
            a2.this$0 = a;
        }

        public static void addBlock(class_2338 a) {
            if (BlockUtil.clientCanPlace(a, true) && !PlaceMap.containsKey((Object)a)) {
                class_2338 class_23382 = a;
                class_2338 class_23383 = a;
                PlaceMap.put(class_23383, new placePosition(class_23383));
            }
        }

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ void drawBlock(class_2338 class_23382, double d, Color color, class_4587 class_45872) {
            Color a;
            void a2;
            void a3;
            void a4;
            AutoTrapRender autoTrapRender = color2;
            Color color2 = color;
            AutoTrapRender a5 = autoTrapRender;
            if (a5.this$0.sync.getValue()) {
                a = AutoTrap.INSTANCE.color.getValue();
            }
            Render3DUtil.draw3DBox((class_4587)a4, new class_238((class_2338)a3), ColorUtil.injectAlpha(a, (int)a2), a5.this$0.outline.getValue(), a5.this$0.box.getValue());
        }

        public static class placePosition {
            public boolean isAir;
            public final Timer timer;
            public final class_2338 pos;
            public final Color posColor;
            public final FadeUtils firstFade;

            public placePosition(class_2338 class_23382) {
                placePosition a;
                placePosition a2 = class_23382;
                placePosition placePosition2 = a = this;
                placePosition placePosition3 = a;
                placePosition2.firstFade = new FadeUtils((long)AutoTrap.INSTANCE.fadeTime.getValue());
                placePosition2.pos = a2;
                placePosition2.posColor = AutoTrap.INSTANCE.color.getValue();
                a.timer = new Timer();
                a.isAir = true;
                a.timer.reset();
            }
        }

    }

}
