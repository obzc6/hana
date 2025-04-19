/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_2596
 *  net.minecraft.class_2761
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_761
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_2596;
import net.minecraft.class_2761;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_761;

public class Ambience
extends Module {
    long oldTime;
    public final BooleanSetting customLuminance;
    public final BooleanSetting forceOverworld;
    private final SliderSetting time;
    public final ColorSetting worldColor;
    public final SliderSetting luminance;
    public final BooleanSetting customTime;
    public static Ambience INSTANCE;
    public final SliderSetting fogStart;
    public final SliderSetting fogEnd;
    public final BooleanSetting fogDistance;
    public final ColorSetting fog;
    public final ColorSetting cloud;
    public final ColorSetting dimensionColor;
    public final ColorSetting sky;
    public final BooleanSetting fullBright;

    @Override
    public void onUpdate() {
        Ambience a;
        if (a.fullBright.getValue()) {
            Ambience.mc.field_1724.method_6092(new class_1293(class_1294.field_5925, 100000, 0));
        }
        if (a.customTime.getValue()) {
            Ambience.mc.field_1687.method_8435((long)a.time.getValue());
        }
    }

    @Override
    public void onDisable() {
        Ambience a;
        if (Ambience.nullCheck()) {
            return;
        }
        Ambience.mc.field_1724.method_6016(class_1294.field_5925);
        Ambience.mc.field_1687.method_8435(a.oldTime);
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        Ambience a2 = this;
        if (a.getPacket() instanceof class_2761) {
            a2.oldTime = ((class_2761)a.getPacket()).method_11871();
            a.cancel();
        }
    }

    @Override
    public void onEnable() {
        if (Ambience.nullCheck()) {
            return;
        }
        a.oldTime = Ambience.mc.field_1687.method_8532();
    }

    public Ambience() {
        Ambience a;
        Ambience ambience = a;
        super(RadiusUtils.ALLATORIxDEMO("r\nV\tL\u0013\u0000R"), RenderHelper.ALLATORIxDEMO("\\\u0013jK/\u00075\f\b|\u0012f^'"), Module.Category.Render);
        Ambience ambience2 = a;
        ambience2.worldColor = ambience.add(new ColorSetting(RadiusUtils.ALLATORIxDEMO("c\u000fA\u000bP#F\u0011\fE"), new Color(-1, true)).injectBoolean(true));
        ambience.customTime = ambience.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO(")`\u001ef\u0005x#aP'"), false).setParent());
        ambience.time = ambience.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("}\u0014\u000eR"), 0, 0, 24000, object -> {
            Object a = object;
            Ambience a2 = this;
            return a2.customTime.isOpen();
        }));
        Ambience ambience3 = a;
        ambience3.fog = ambience3.add(new ColorSetting(RenderHelper.ALLATORIxDEMO("+}\rV\u0018dR0"), new Color(13401557)).injectBoolean(false));
        ambience3.sky = ambience3.add(new ColorSetting(RadiusUtils.ALLATORIxDEMO("`\fM#F\u0011\fE"), new Color(0)).injectBoolean(false));
        ambience3.cloud = ambience3.add(new ColorSetting(RenderHelper.ALLATORIxDEMO(")y\u0002g\u000eV\u0018dR0"), new Color(0)).injectBoolean(false));
        ambience3.dimensionColor = ambience3.add(new ColorSetting(RadiusUtils.ALLATORIxDEMO("|\u0005\fPZ\u0013Z\bZ#F\u0011\fE"), new Color(0)).injectBoolean(false));
        ambience3.fogDistance = ambience3.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("\u0006\u0005r){\u0019a\u0016f^'"), false).setParent());
        ambience3.fogStart = ambience3.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("u\bS3]\u001c\u0011C"), 50, 0, 1000, object -> {
            Object a = object;
            Ambience a2 = this;
            return a2.fogDistance.isOpen();
        }));
        a.fogEnd = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO(",z\u0010MS&"), 100, 0, 1000, object -> {
            Object a = object;
            Ambience a2 = this;
            return a2.fogDistance.isOpen();
        }));
        Ambience ambience4 = a;
        ambience4.fullBright = ambience4.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("r\u0015_\u000bv\u0012@\u001a\u000bC"), false));
        ambience4.forceOverworld = ambience4.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO(" vM#\u000fZ\u001bw\u0018b\u0018zQ&"), false));
        ambience4.customLuminance = ambience4.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO(")M\u001f\u0015ZY,F\n]\u000eH\u0013\u0000R"), false).setParent().injectTask(() -> {
            if (!Ambience.nullCheck()) {
                Ambience.mc.field_1769.method_3279();
            }
        }));
        a.luminance = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("Y\u0018\u0003{\u0016f^'"), 15, 0, 15, object -> {
            Object a = object;
            Ambience a2 = this;
            return a2.customLuminance.isOpen();
        }).injectTask(() -> {
            Ambience a;
            if (!Ambience.nullCheck() && a.customLuminance.getValue()) {
                Ambience.mc.field_1769.method_3279();
            }
        }));
        Ambience ambience5 = a;
        ambience5.setChinese(RadiusUtils.ALLATORIxDEMO("\u73cc\u58b4"));
        INSTANCE = ambience5;
    }
}
