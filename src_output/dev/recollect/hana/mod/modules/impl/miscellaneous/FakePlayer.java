/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1282
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2663
 *  net.minecraft.class_2664
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_745
 *  net.minecraft.class_746
 *  net.minecraft.class_8109
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.PopManager;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import java.util.UUID;
import net.minecraft.class_1268;
import net.minecraft.class_1282;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2663;
import net.minecraft.class_2664;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_745;
import net.minecraft.class_746;
import net.minecraft.class_8109;

public class FakePlayer
extends Module {
    public static class_745 fakePlayer;
    private final BooleanSetting gApple;
    public static FakePlayer INSTANCE;
    private final BooleanSetting damage;
    private final StringSetting name;
    int pops;
    private final Timer timer;
    private final BooleanSetting autoTotem;
    private final SliderSetting speed;

    public FakePlayer() {
        FakePlayer a;
        FakePlayer fakePlayer = a;
        FakePlayer fakePlayer2 = a;
        FakePlayer fakePlayer3 = a;
        super(Vec3.ALLATORIxDEMO("W\u001aw\u0013T\u0002y\u000bj\u0017"), Module.Category.Misc);
        FakePlayer fakePlayer4 = a;
        fakePlayer4.name = fakePlayer3.add(new StringSetting(FPSManager.ALLATORIxDEMO("C\n*D"), Vec3.ALLATORIxDEMO("O\u001ba\u000e")));
        fakePlayer3.damage = fakePlayer3.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("T\u0017`\n D"), true));
        fakePlayer3.autoTotem = fakePlayer3.add(new BooleanSetting(Vec3.ALLATORIxDEMO(":i\u0002k:w\u0006j\b"), true));
        fakePlayer3.gApple = fakePlayer3.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("W7}\u001b+D"), true));
        fakePlayer2.speed = fakePlayer3.add(new SliderSetting(Vec3.ALLATORIxDEMO("6s\u0000a=h\u0017j\u0001"), 0.0, 0.0, 2.55, 0.01));
        fakePlayer2.timer = new Timer();
        fakePlayer2.pops = 0;
        fakePlayer.setDescription(FPSManager.ALLATORIxDEMO("5l\u001b|\u0003eEq\u001dr\u0001|\u0017t\u000e5\u000f"));
        fakePlayer.setChinese(Vec3.ALLATORIxDEMO("\u5035\u73a6\u5bd3"));
        INSTANCE = fakePlayer;
    }

    @Override
    public void onDisable() {
        if (fakePlayer == null) {
            return;
        }
        fakePlayer.method_5768();
        fakePlayer.method_31745(class_1297.class_5529.field_26998);
        fakePlayer.method_36209();
        fakePlayer = null;
    }

    @Override
    public String getInfo() {
        FakePlayer a;
        return a.name.getValue();
    }

    private /* synthetic */ boolean isInWeb(class_1297 class_12972) {
        FakePlayer a = class_12972;
        FakePlayer a2 = this;
        return FakePlayer.mc.field_1687.method_8320(new class_2338((class_2382)a.method_24515())).method_26204() == class_2246.field_10343;
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive receive) {
        Object a3 = receive;
        FakePlayer a2 = this;
        if (a2.damage.getValue() && fakePlayer != null && FakePlayer.fakePlayer.field_6235 == 0) {
            Object t;
            if (a2.autoTotem.getValue() && fakePlayer.method_6079().method_7909() != class_1802.field_8288) {
                fakePlayer.method_6122(class_1268.field_5810, new class_1799((class_1935)class_1802.field_8288));
            }
            if ((t = ((PacketEvent)a3).getPacket()) instanceof class_2664) {
                a3 = (class_2664)t;
                class_243 class_2432 = new class_243(a3.method_11475(), a3.method_11477(), a3.method_11478());
                if (class_3532.method_15355((float)((float)class_2432.method_1025(fakePlayer.method_19538()))) > 10.0f) {
                    return;
                }
                float f = BlockUtil.getBlock(new BlockPosX(a3.method_11475(), a3.method_11477(), a3.method_11478())) == class_2246.field_23152 ? (float)AnchorAura.INSTANCE.getAnchorDamage(new BlockPosX(a3.method_11475(), a3.method_11477(), a3.method_11478()), (class_1657)fakePlayer, (class_1657)fakePlayer) : HanaAura.INSTANCE.calculateDamage(new class_243(a3.method_11475(), a3.method_11477(), a3.method_11478()), (class_1657)fakePlayer, (class_1657)fakePlayer);
                fakePlayer.method_48922(FakePlayer.mc.field_1687.method_48963().method_48830());
                if (fakePlayer.method_6067() >= f) {
                    fakePlayer.method_6073(fakePlayer.method_6067() - f);
                } else {
                    float a3 = f - fakePlayer.method_6067();
                    fakePlayer.method_6073(0.0f);
                    fakePlayer.method_6033(fakePlayer.method_6032() - a3);
                }
            }
            if (fakePlayer.method_29504() && fakePlayer.method_6095(FakePlayer.mc.field_1687.method_48963().method_48830())) {
                fakePlayer.method_6033(10.0f);
                new class_2663((class_1297)fakePlayer, 35).method_11471((class_2602)FakePlayer.mc.field_1724.field_3944);
            }
        }
    }

    @Override
    public void onUpdate() {
        FakePlayer a;
        FakePlayer fakePlayer = this;
        if (FakePlayer.fakePlayer == null || FakePlayer.fakePlayer.method_29504() || FakePlayer.fakePlayer.field_17892 != FakePlayer.mc.field_1687) {
            fakePlayer.disable();
            return;
        }
        FakePlayer.fakePlayer.method_6092(new class_1293(class_1294.field_5924, 9999, 2));
        FakePlayer.fakePlayer.method_6092(new class_1293(class_1294.field_5898, 9999, 4));
        if (fakePlayer.gApple.getValue() && fakePlayer.timer.passedMs(4000L)) {
            FakePlayer.fakePlayer.method_6092(new class_1293(class_1294.field_5907, 9999, 1));
            fakePlayer.timer.reset();
            FakePlayer.fakePlayer.method_6073(16.0f);
        }
        if (fakePlayer.autoTotem.getValue() && FakePlayer.fakePlayer.method_6079().method_7909() != class_1802.field_8288) {
            Hana.POP.onTotemPop((class_1657)FakePlayer.fakePlayer);
            FakePlayer.fakePlayer.method_6122(class_1268.field_5810, new class_1799((class_1935)class_1802.field_8288));
        }
        if (FakePlayer.fakePlayer.method_29504() && FakePlayer.fakePlayer.method_6095(FakePlayer.mc.field_1687.method_48963().method_48830())) {
            FakePlayer.fakePlayer.method_6033(10.0f);
            new class_2663((class_1297)FakePlayer.fakePlayer, 35).method_11471((class_2602)FakePlayer.mc.field_1724.field_3944);
        }
        FakePlayer fakePlayer2 = fakePlayer;
        double d = fakePlayer2.speed.getValue();
        if (fakePlayer2.isInWeb((class_1297)FakePlayer.fakePlayer)) {
            d /= 3.0;
        }
        double d2 = Math.toRadians(FakePlayer.fakePlayer.method_36454());
        double d3 = -Math.sin(d2) * d;
        d = Math.cos(d2) * d;
        class_243 class_2432 = FakePlayer.fakePlayer.method_19538().method_1031(d3, 0.0, d);
        class_2338 class_23382 = class_2338.method_49638((class_2374)class_2432);
        if (!FakePlayer.mc.field_1687.method_8320(class_23382).method_26212((class_1922)FakePlayer.mc.field_1687, class_23382)) {
            FakePlayer.fakePlayer.method_5641(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, FakePlayer.fakePlayer.method_36454(), FakePlayer.fakePlayer.method_36455());
        }
        if ((a = FakePlayer.mc.field_1687.method_17742(new class_3959(new class_243(FakePlayer.fakePlayer.method_23317(), FakePlayer.fakePlayer.method_23318() - 0.5, FakePlayer.fakePlayer.method_23321()), new class_243(FakePlayer.fakePlayer.method_23317(), FakePlayer.fakePlayer.method_23318() - 2.0, FakePlayer.fakePlayer.method_23321()), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)FakePlayer.fakePlayer))).method_17783() == class_239.class_240.field_1332) {
            d = a.method_17784().field_1351 + 1.0;
            if (FakePlayer.fakePlayer.method_23318() < d) {
                FakePlayer.fakePlayer.method_5641(FakePlayer.fakePlayer.method_23317(), d, FakePlayer.fakePlayer.method_23321(), FakePlayer.fakePlayer.method_36454(), FakePlayer.fakePlayer.method_36455());
            }
        }
        FakePlayer.fakePlayer.method_5641(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, FakePlayer.fakePlayer.method_36454(), FakePlayer.fakePlayer.method_36455());
    }

    @Override
    public void onEnable() {
        FakePlayer a;
        a.pops = 0;
        if (FakePlayer.nullCheck()) {
            a.disable();
            return;
        }
        fakePlayer = new class_745(FakePlayer.mc.field_1687, new GameProfile(UUID.fromString(FPSManager.ALLATORIxDEMO("\u000eh,K#@*L\u0004y#E.S6P*L&[ F!\\\nl!G.H-K#E,J")), a.name.getValue()));
        fakePlayer.method_31548().method_7377(FakePlayer.mc.field_1724.method_31548());
        FakePlayer.mc.field_1687.method_53875((class_1297)fakePlayer);
        fakePlayer.method_5719((class_1297)FakePlayer.mc.field_1724);
        FakePlayer.fakePlayer.field_6283 = FakePlayer.mc.field_1724.field_6283;
        FakePlayer.fakePlayer.field_6241 = FakePlayer.mc.field_1724.field_6241;
        fakePlayer.method_6092(new class_1293(class_1294.field_5924, 9999, 2));
        fakePlayer.method_6092(new class_1293(class_1294.field_5898, 9999, 4));
        fakePlayer.method_6092(new class_1293(class_1294.field_5907, 9999, 1));
    }
}
