/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2885
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 *  org.joml.Vector3f
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import dev.recollect.hana.video.FileUtil;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_746;
import org.joml.Vector3f;

public class RotateBypass
extends Module {
    public final Timer timer;
    public class_243 vec;
    private final BooleanSetting packet;
    private final SliderSetting rotateTimer;

    @EventHandler
    public final void onMotion(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        RotateBypass a2 = this;
        if (!RotateBypass.nullCheck()) {
            RotateBypass rotateBypass = a2;
            if (!rotateBypass.timer.passedMs(rotateBypass.rotateTimer.getValue()) && a2.vec != null) {
                RotateBypass rotateBypass2 = a2;
                rotateBypass2.faceVector(rotateBypass2.vec, a);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void sendPlayerRot(float f, float f2, boolean bl) {
        void a;
        boolean a2 = bl;
        float a3 = f;
        mc.method_1562().method_52787((class_2596)new class_2828.class_2831(a3, (float)a, a2));
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        RotateBypass a2 = this;
        if (a.getPacket() instanceof class_2885) {
            class_243 class_2432 = new class_243((double)((class_2885)a.getPacket()).method_12543().method_17780().method_10163().method_10263() * 0.5, (double)((class_2885)a.getPacket()).method_12543().method_17780().method_10163().method_10264() * 0.5, (double)((class_2885)a.getPacket()).method_12543().method_17780().method_10163().method_10260() * 0.5);
            a2.faceVector(new class_243(((class_2885)a.getPacket()).method_12543().method_17784().method_46409()).method_1031(0.5, 0.5, 0.5).method_1019(class_2432));
        }
    }

    public RotateBypass() {
        RotateBypass a;
        RotateBypass rotateBypass = a;
        super(FileUtil.ALLATORIxDEMO("e7x\u0002q\u000fV\u0002v\bu\u001a"), Module.Category.Player);
        RotateBypass rotateBypass2 = a;
        rotateBypass2.rotateTimer = rotateBypass.add(new SliderSetting(User.ALLATORIxDEMO("dEKBZWhIQE"), 300, 0, 1000));
        rotateBypass.packet = rotateBypass.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("D\u001ae\u0002c\u001d"), false));
        rotateBypass.timer = new Timer();
    }

    public void faceVector(class_243 class_2432) {
        float[] a;
        float[] a2 = class_2432;
        float[] arrf = a = this;
        arrf.vec = a2;
        arrf.timer.reset();
        a2 = EntityUtil.getLegitRotations((class_243)a2);
        if (arrf.packet.getValue()) {
            RotateBypass.sendPlayerRot(a2[0], a2[1], RotateBypass.mc.field_1724.method_24828());
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void faceVector(class_243 class_2432, RotateEvent rotateEvent) {
        void a;
        float[] a2 = class_2432;
        float[] a3 = this;
        a2 = EntityUtil.getLegitRotations((class_243)a2);
        a.setRotation(a2[0], a2[1]);
    }
}
