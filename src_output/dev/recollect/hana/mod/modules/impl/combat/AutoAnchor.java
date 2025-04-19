/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.combat.ExplosionUtil;
import dev.recollect.hana.api.utils.combat.MeteorExplosionUtil;
import dev.recollect.hana.api.utils.combat.OyveyExplosionUtil;
import dev.recollect.hana.api.utils.combat.ThunderExplosionUtil;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.socket.network.client.SocketClient;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class AutoAnchor
extends Module {
    private final EnumSetting<Aura.TargetESP> mode;
    double fade;
    private final BooleanSetting checkLook;
    private final BooleanSetting random;
    private final BooleanSetting mineSpam;
    private final BooleanSetting inSpam;
    public final SliderSetting targetRange;
    private final SliderSetting maxSelfDamage;
    private final BooleanSetting packet;
    final BooleanSetting render;
    private final BooleanSetting usingPause;
    private final EnumSetting<CalcMode> calcMode;
    public double lastDamage;
    private final BooleanSetting rotate;
    static class_243 placeVec3d;
    public class_2338 tempPos;
    private final SliderSetting steps;
    private final SliderSetting placeDelay;
    public final SliderSetting predictTicks;
    private final BooleanSetting yawStep;
    private final ColorSetting color;
    private float lastYaw;
    private final BooleanSetting spamPlace;
    public final SliderSetting headDamage;
    public final SliderSetting range;
    final SliderSetting startFadeTime;
    public class_243 directionVec;
    private final SliderSetting calcDelay;
    public static AutoAnchor INSTANCE;
    public class_2338 currentPos;
    private final SliderSetting fov;
    final Timer noPosTimer;
    private final BooleanSetting spam;
    final BooleanSetting shrink;
    public final EnumSetting<Page> page;
    final SliderSetting sliderSpeed;
    private final SliderSetting minPrefer;
    private float lastPitch;
    static class_243 curVec3d;
    final ColorSetting box;
    private final BooleanSetting light;
    private final Timer calcTimer;
    private final ArrayList<class_2338> chargeList;
    public final SliderSetting minDamage;
    final SliderSetting fadeSpeed;
    private final BooleanSetting breakCrystal;
    private final BooleanSetting terrainIgnore;
    public class_1657 displayTarget;
    private final Timer updateTimer;
    private final SliderSetting updateDelay;
    private final Timer delayTimer;
    private final BooleanSetting noSuicide;
    final ColorSetting fill;
    private final SliderSetting spamDelay;
    private final EnumSetting<SwingSide> swingMode;
    public final SliderSetting breakMin;

    @Override
    public void onDisable() {
        AutoAnchor a;
        AutoAnchor autoAnchor = a;
        autoAnchor.currentPos = null;
        autoAnchor.tempPos = null;
    }

    public AutoAnchor() {
        AutoAnchor a;
        AutoAnchor autoAnchor = a;
        super(Hole.ALLATORIxDEMO("?r\ro?i\u0000rF\""), Module.Category.Combat);
        AutoAnchor autoAnchor2 = a;
        autoAnchor2.page = autoAnchor.add(new EnumSetting<Page>(SocketClient.ALLATORIxDEMO("qe[|"), Page.General));
        autoAnchor.light = autoAnchor.add(new BooleanSetting(Hole.ALLATORIxDEMO("K\n}A$"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.range = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("Q@j[|"), 5.0, 0.0, 6.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Hole.ALLATORIxDEMO("=")));
        a.targetRange = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("~AwJmRQ@j[|"), 8.0, 0.0, 16.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(Hole.ALLATORIxDEMO("=")));
        a.breakCrystal = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("MXEdFKTzRp]u"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.spam = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("0jH="), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setParent());
        a.mineSpam = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("okAqkjOmR~"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General && a2.spam.isOpen();
        }));
        a.spamPlace = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("%{Z$"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setParent());
        a.inSpam = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("XBEk~xGnLmR~"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General && a2.spamPlace.isOpen();
        }));
        a.usingPause = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("+t\u0010n\u0019W\u0002oZ5"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.swingMode = a.add(new EnumSetting<SwingSide>(SocketClient.ALLATORIxDEMO("PVmR~"), SwingSide.Server, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }));
        a.placeDelay = a.add(new SliderSetting(Hole.ALLATORIxDEMO("C\u0006vH)"), 100.0, 0.0, 500.0, 1.0, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(SocketClient.ALLATORIxDEMO("Qj")));
        a.spamDelay = a.add(new SliderSetting(Hole.ALLATORIxDEMO("T\ta\u0013C\u0006vH)"), 200.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(SocketClient.ALLATORIxDEMO("Qj")));
        a.calcDelay = a.add(new SliderSetting(Hole.ALLATORIxDEMO("D\u0018l\u001dC\u0006vH)"), 200.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(SocketClient.ALLATORIxDEMO("Qj")));
        a.updateDelay = a.add(new SliderSetting(Hole.ALLATORIxDEMO("\u0007\u000ec\u0018t\u001bC\u0006vH)"), 50, 0, 1000, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.General;
        }).setSuffix(SocketClient.ALLATORIxDEMO("Qj")));
        a.rotate = a.add(new BooleanSetting(Hole.ALLATORIxDEMO(",h\u0017{]5"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Rotate;
        }).setParent());
        a.yawStep = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("QGtrpYi"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.rotate.isOpen() && a2.page.getValue() == Page.Rotate;
        }));
        a.steps = a.add(new SliderSetting(Hole.ALLATORIxDEMO("T\u0017Y#"), 0.30000001192092896, 0.10000000149011612, 1.0, 0.01, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.packet = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("vbBoYm"), false, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.random = a.add(new BooleanSetting(Hole.ALLATORIxDEMO(",f\r~F="), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.checkLook = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("FEmEhmkSr"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.fov = a.add(new SliderSetting(Hole.ALLATORIxDEMO("\\F&"), 5.0, 0.0, 30.0, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.rotate.isOpen() && a2.yawStep.getValue() && a2.checkLook.getValue() && a2.page.getValue() == Page.Rotate;
        }));
        a.calcMode = a.add(new EnumSetting<CalcMode>(SocketClient.ALLATORIxDEMO("niJ`lkX|"), CalcMode.Meteor, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.noSuicide = a.add(new BooleanSetting(Hole.ALLATORIxDEMO("I\u0016S\u000bn\u0000sM5"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.terrainIgnore = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("PjXRdDfodOkN|"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }));
        a.minDamage = a.add(new SliderSetting(Hole.ALLATORIxDEMO("W@>"), 4.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(SocketClient.ALLATORIxDEMO("`Q~")));
        a.breakMin = a.add(new SliderSetting(Hole.ALLATORIxDEMO("n*\u000ek\u0016s\u0017h\rW@>"), 4.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(SocketClient.ALLATORIxDEMO("`Q~")));
        a.headDamage = a.add(new SliderSetting(Hole.ALLATORIxDEMO("A\u0016r\u001db+H4"), 7.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(SocketClient.ALLATORIxDEMO("`Q~")));
        a.minPrefer = a.add(new SliderSetting(Hole.ALLATORIxDEMO(".u\u0006|L\""), 7.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(SocketClient.ALLATORIxDEMO("`Q~")));
        a.maxSelfDamage = a.add(new SliderSetting(Hole.ALLATORIxDEMO("M\u001f0E6"), 8.0, 0.0, 36.0, 0.1, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(SocketClient.ALLATORIxDEMO("`Q~")));
        a.predictTicks = a.add(new SliderSetting(Hole.ALLATORIxDEMO("P\fb\u0007sJ$"), 2.0, 0.0, 50.0, 1.0, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Calc;
        }).setSuffix(SocketClient.ALLATORIxDEMO("wHgWj")));
        a.mode = a.add(new EnumSetting<Aura.TargetESP>(Hole.ALLATORIxDEMO("S\u0018r\u0019b\u0017_z\u0000"), Aura.TargetESP.Jello, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.color = a.add(new ColorSetting(SocketClient.ALLATORIxDEMO("~AwJmR@NhSk"), new Color(255, 255, 255, 250), object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.render = a.add(new BooleanSetting(Hole.ALLATORIxDEMO(",b\r~L\""), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render;
        }));
        a.shrink = a.add(new BooleanSetting(SocketClient.ALLATORIxDEMO("ukSmRr"), true, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.box = a.add(new ColorSetting(Hole.ALLATORIxDEMO("XF("), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.fill = a.add(new ColorSetting(SocketClient.ALLATORIxDEMO("gmPu"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).injectBoolean(true));
        a.sliderSpeed = a.add(new SliderSetting(Hole.ALLATORIxDEMO("\u0001\u0012n\u001de\fT\u0013L4"), 0.2, 0.0, 1.0, 0.01, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        a.startFadeTime = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("VYiTwgeX|"), 0.3, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }).setSuffix(Hole.ALLATORIxDEMO("#")));
        a.fadeSpeed = a.add(new SliderSetting(SocketClient.ALLATORIxDEMO("CLlCPQaY}"), 0.2, 0.01, 1.0, 0.01, object -> {
            Object a = object;
            AutoAnchor a2 = this;
            return a2.page.getValue() == Page.Render && a2.render.getValue();
        }));
        AutoAnchor autoAnchor3 = a;
        AutoAnchor autoAnchor4 = a;
        AutoAnchor autoAnchor5 = a;
        AutoAnchor autoAnchor6 = a;
        a.updateTimer = new Timer();
        autoAnchor6.delayTimer = new Timer();
        autoAnchor6.calcTimer = new Timer();
        autoAnchor6.directionVec = null;
        autoAnchor5.lastYaw = 0.0f;
        autoAnchor4.lastPitch = 0.0f;
        autoAnchor5.chargeList = new ArrayList();
        autoAnchor4.noPosTimer = new Timer();
        autoAnchor3.fade = 0.0;
        autoAnchor3.setChinese(Hole.ALLATORIxDEMO("\u81ed\u52cb\u91d7\u7536\u954a"));
        INSTANCE = autoAnchor3;
        Hana.EVENT_BUS.subscribe(new AnchorRender(a));
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

    @Override
    public void onEnable() {
        AutoAnchor a;
        AutoAnchor autoAnchor = a;
        autoAnchor.lastYaw = Hana.ROTATE.lastYaw;
        autoAnchor.lastPitch = Hana.ROTATE.lastPitch;
    }

    /*
     * Exception decompiling
     */
    public void anchor() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 2[WHILELOOP]
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

    /*
     * WARNING - void declaration
     */
    public void clickBlock(class_2338 class_23382, class_2350 class_23502, boolean bl, int n) {
        void a;
        void a2;
        void a3;
        AutoAnchor a4 = class_23382;
        AutoAnchor a5 = this;
        class_243 class_2432 = new class_243((double)a4.method_10263() + 0.5 + (double)a3.method_10163().method_10263() * 0.5, (double)a4.method_10264() + 0.5 + (double)a3.method_10163().method_10264() * 0.5, (double)a4.method_10260() + 0.5 + (double)a3.method_10163().method_10260() * 0.5);
        if (a != false && !a5.faceVector(class_2432)) {
            return;
        }
        InventoryUtil.switchToSlot((int)a2);
        EntityUtil.swingHand(class_1268.field_5808, a5.swingMode.getValue());
        a4 = new class_3965(class_2432, (class_2350)a3, (class_2338)a4, false);
        AutoAnchor.mc.field_1724.field_3944.method_52787((class_2596)new class_2885(class_1268.field_5808, (class_3965)a4, BlockUtil.getWorldActionId(AutoAnchor.mc.field_1687)));
    }

    /*
     * WARNING - void declaration
     */
    public double getAnchorDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573) {
        AutoAnchor a = class_16573;
        AutoAnchor a2 = this;
        if (a2.terrainIgnore.getValue()) {
            CombatUtil.terrainIgnore = true;
        }
        double d = 0.0;
        switch (a2.calcMode.getValue().ordinal()) {
            case 1: {
                void a3;
                void a4;
                d = MeteorExplosionUtil.anchorDamage((class_1657)a4, (class_2338)a3, (class_1657)a);
                break;
            }
            case 2: {
                void a3;
                void a4;
                d = ThunderExplosionUtil.anchorDamage((class_2338)a3, (class_1657)a4, (class_1657)a);
                break;
            }
            case 0: {
                void a3;
                void a4;
                while (false) {
                }
                d = OyveyExplosionUtil.anchorDamage((class_2338)a3, (class_1657)a4, (class_1657)a);
                break;
            }
            case 3: {
                void a3;
                void a4;
                d = ExplosionUtil.anchorDamage((class_2338)a3, (class_1657)a4, (class_1657)a);
            }
        }
        CombatUtil.terrainIgnore = false;
        return d;
    }

    @Override
    public void onUpdate() {
        AutoAnchor a;
        a.update();
    }

    public void update() {
        AutoAnchor a;
        if (AutoAnchor.nullCheck()) {
            return;
        }
        AutoAnchor autoAnchor = a;
        autoAnchor.anchor();
        autoAnchor.currentPos = autoAnchor.tempPos;
    }

    @EventHandler
    public void onRotate(RotateEvent a) {
        float[] a2;
        float[] arrf = a2;
        if (arrf.currentPos != null && arrf.yawStep.getValue() && arrf.directionVec != null) {
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

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ float[] injectStep(float[] arrf, float f) {
        void a;
        float a2 = f;
        AutoAnchor a3 = this;
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
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        AutoAnchor a2 = this;
        a2.update();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        AutoAnchor a2 = this;
        a2.update();
        if (AutoAnchor.INSTANCE.displayTarget != null && AutoAnchor.INSTANCE.currentPos != null) {
            void a3;
            Aura.doRender((class_4587)a3, a, (class_1297)AutoAnchor.INSTANCE.displayTarget, a2.color.getValue(), a2.mode.getValue());
        }
    }

    /*
     * WARNING - void declaration
     */
    public void placeBlock(class_2338 class_23382, boolean bl, int n) {
        class_2350 a;
        void a2;
        void a3;
        void a4;
        class_2350 class_23502 = this;
        if (BlockUtil.airPlace()) {
            int n2;
            a = class_2350.values();
            int n3 = ((class_2350[])a).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                class_2350 class_23503 = a[n2];
                if (AutoAnchor.mc.field_1687.method_22347(a3.method_10093(class_23503))) {
                    class_23502.clickBlock((class_2338)a3, class_23503, (boolean)a4, (int)a2);
                    return;
                }
                n4 = ++n2;
            }
        }
        if ((a = BlockUtil.getPlaceSide((class_2338)a3)) == null) {
            return;
        }
        BlockUtil.placedPos.add((class_2338)a3);
        class_23502.clickBlock(a3.method_10093(a), a.method_10153(), (boolean)a4, (int)a2);
    }

    @Override
    public String getInfo() {
        AutoAnchor a;
        if (a.displayTarget != null && a.currentPos != null) {
            return a.displayTarget.method_5477().getString();
        }
        return null;
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Rotate;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page General;
        public static final /* enum */ Page Calc;
        public static final /* enum */ Page Render;

        static {
            General = new Page(BufferRing.ALLATORIxDEMO("=,\u00131\u0012F"), 0);
            Calc = new Page(PacketBuffer.ALLATORIxDEMO("?z\u0012z"), 1);
            Rotate = new Page(BufferRing.ALLATORIxDEMO("\u001b\u0012 \u0001jO"), 2);
            Render = new Page(PacketBuffer.ALLATORIxDEMO("(x\u0012\u001bk"), 3);
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[4];
            arrpage[0] = General;
            arrpage[1] = Calc;
            arrpage[2] = Rotate;
            arrpage[3] = Render;
            return arrpage;
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
    }

    public static final class CalcMode
    extends Enum<CalcMode> {
        private static final /* synthetic */ CalcMode[] $VALUES;
        public static final /* enum */ CalcMode Meteor;
        public static final /* enum */ CalcMode Oyvey;
        public static final /* enum */ CalcMode Thunder;
        public static final /* enum */ CalcMode Edit;

        private static /* synthetic */ CalcMode[] $values() {
            CalcMode[] arrcalcMode = new CalcMode[4];
            arrcalcMode[0] = Oyvey;
            arrcalcMode[1] = Meteor;
            arrcalcMode[2] = Thunder;
            arrcalcMode[3] = Edit;
            return arrcalcMode;
        }

        public static CalcMode valueOf(String a) {
            return Enum.valueOf(CalcMode.class, a);
        }

        public static CalcMode[] values() {
            return (CalcMode[])$VALUES.clone();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ CalcMode() {
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
            Oyvey = new CalcMode(OLEPOSSUtils.ALLATORIxDEMO("e1Ag\u0004"), 0);
            Meteor = new CalcMode(Alt.ALLATORIxDEMO("U'g,}:"), 1);
            Thunder = new CalcMode(OLEPOSSUtils.ALLATORIxDEMO("y=_&Sg\u000f"), 2);
            Edit = new CalcMode(Alt.ALLATORIxDEMO("V-{<"), 3);
            $VALUES = CalcMode.$values();
        }
    }

    public class AnchorRender {
        final /* synthetic */ AutoAnchor this$0;

        public AnchorRender(AutoAnchor autoAnchor) {
            AutoAnchor a = autoAnchor;
            AnchorRender a2 = this;
            a2.this$0 = a;
        }

        @EventHandler
        public void onRender3D(Render3DEvent a) {
            AnchorRender anchorRender;
            AnchorRender anchorRender2;
            AnchorRender a2;
            AnchorRender anchorRender3 = a2;
            if (anchorRender3.this$0.currentPos != null) {
                anchorRender3.this$0.noPosTimer.reset();
                placeVec3d = anchorRender3.this$0.currentPos.method_46558();
            }
            if (placeVec3d == null) {
                return;
            }
            if (anchorRender3.this$0.fadeSpeed.getValue() >= 1.0) {
                anchorRender3.this$0.fade = anchorRender3.this$0.noPosTimer.passedMs((long)(anchorRender3.this$0.startFadeTime.getValue() * 1000.0)) ? 0.0 : 0.5;
                anchorRender = anchorRender3;
            } else {
                double d;
                AnchorRender anchorRender4;
                if (anchorRender3.this$0.noPosTimer.passedMs((long)(anchorRender3.this$0.startFadeTime.getValue() * 1000.0))) {
                    d = 0.0;
                    anchorRender4 = anchorRender3;
                } else {
                    d = 0.5;
                    anchorRender4 = anchorRender3;
                }
                anchorRender3.this$0.fade = AnimateUtil.animate(anchorRender3.this$0.fade, d, anchorRender4.this$0.fadeSpeed.getValue() / 10.0);
                anchorRender = anchorRender3;
            }
            if (anchorRender.this$0.fade == 0.0) {
                curVec3d = null;
                return;
            }
            if (curVec3d == null || anchorRender3.this$0.sliderSpeed.getValue() >= 1.0) {
                curVec3d = placeVec3d;
                anchorRender2 = anchorRender3;
            } else {
                curVec3d = new class_243(AnimateUtil.animate(AutoAnchor.curVec3d.field_1352, AutoAnchor.placeVec3d.field_1352, anchorRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoAnchor.curVec3d.field_1351, AutoAnchor.placeVec3d.field_1351, anchorRender3.this$0.sliderSpeed.getValue() / 10.0), AnimateUtil.animate(AutoAnchor.curVec3d.field_1350, AutoAnchor.placeVec3d.field_1350, anchorRender3.this$0.sliderSpeed.getValue() / 10.0));
                anchorRender2 = anchorRender3;
            }
            if (anchorRender2.this$0.render.getValue()) {
                Render3DEvent render3DEvent;
                AnchorRender anchorRender5 = a2 = new class_238(curVec3d, curVec3d);
                if (anchorRender3.this$0.shrink.getValue()) {
                    a2 = anchorRender5.method_1014(anchorRender3.this$0.fade);
                    render3DEvent = a;
                } else {
                    a2 = anchorRender5.method_1014(0.5);
                    render3DEvent = a;
                }
                a = render3DEvent.getMatrixStack();
                if (anchorRender3.this$0.fill.booleanValue) {
                    Render3DUtil.drawFill((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.fill.getValue(), (int)((double)anchorRender3.this$0.fill.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)));
                }
                if (anchorRender3.this$0.box.booleanValue) {
                    Render3DUtil.drawBox((class_4587)a, (class_238)a2, ColorUtil.injectAlpha(anchorRender3.this$0.box.getValue(), (int)((double)anchorRender3.this$0.box.getValue().getAlpha() * anchorRender3.this$0.fade * 2.0)));
                }
            }
        }
    }

    public static class PlayerAndPredict {
        public final class_1657 predict;
        public final class_1657 player;

        public PlayerAndPredict(class_1657 class_16572) {
            PlayerAndPredict a = class_16572;
            PlayerAndPredict a2 = this;
            a2.player = a;
            if (AutoAnchor.INSTANCE.predictTicks.getValueFloat() > 0.0f) {
                Iterator iterator;
                PlayerAndPredict playerAndPredict = a2;
                playerAndPredict.predict = new class_1657(a2, (class_1937)Wrapper.mc.field_1687, a.method_24515(), a.method_36454(), new GameProfile(UUID.fromString(ColorUtil.ALLATORIxDEMO("g!w2F\u0005l*}'V\u0011r-d#c$p-a'v+>xj.l/e-v0:|")), NpSocketClient.ALLATORIxDEMO("\\>]\u001cs9y\bb8h5rx/e"))){
                    final /* synthetic */ PlayerAndPredict this$0;

                    public boolean method_7337() {
                        return false;
                    }
                    {
                        void a;
                        void a2;
                        1 a3;
                        void a4;
                        void a5;
                        1 v0 = this_;
                        1 this_ = gameProfile;
                        1 a6 = v0;
                        a6.this$0 = a2;
                        super((class_1937)a5, (class_2338)a, (float)a4, (GameProfile)a3);
                    }

                    public boolean method_7325() {
                        return false;
                    }
                };
                a2.predict.method_33574(a.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a, AutoAnchor.INSTANCE.predictTicks.getValueInt(), true)));
                playerAndPredict.predict.method_6033(a.method_6032());
                playerAndPredict.predict.field_6014 = ((class_1657)a).field_6014;
                playerAndPredict.predict.field_5969 = ((class_1657)a).field_5969;
                playerAndPredict.predict.field_6036 = ((class_1657)a).field_6036;
                playerAndPredict.predict.method_24830(a.method_24828());
                PlayerAndPredict playerAndPredict2 = a;
                playerAndPredict.predict.method_31548().method_7377(playerAndPredict2.method_31548());
                playerAndPredict.predict.method_18380(a.method_18376());
                Iterator iterator2 = iterator = playerAndPredict2.method_6026().iterator();
                while (iterator2.hasNext()) {
                    class_1293 class_12932 = (class_1293)iterator.next();
                    iterator2 = iterator;
                    a2.predict.method_6092(class_12932);
                }
            } else {
                a2.predict = a;
            }
        }

    }

}
