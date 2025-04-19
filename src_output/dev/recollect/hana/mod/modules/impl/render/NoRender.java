/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1542
 *  net.minecraft.class_1667
 *  net.minecraft.class_1681
 *  net.minecraft.class_1683
 *  net.minecraft.class_1686
 *  net.minecraft.class_2596
 *  net.minecraft.class_310
 *  net.minecraft.class_3937
 *  net.minecraft.class_4587
 *  net.minecraft.class_5904
 *  net.minecraft.class_638
 *  net.minecraft.class_677
 *  net.minecraft.class_677$class_678
 *  net.minecraft.class_677$class_681
 *  net.minecraft.class_691
 *  net.minecraft.class_700
 *  net.minecraft.class_703
 *  net.minecraft.class_711
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.ParticleEvent;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1667;
import net.minecraft.class_1681;
import net.minecraft.class_1683;
import net.minecraft.class_1686;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_3937;
import net.minecraft.class_4587;
import net.minecraft.class_5904;
import net.minecraft.class_638;
import net.minecraft.class_677;
import net.minecraft.class_691;
import net.minecraft.class_700;
import net.minecraft.class_703;
import net.minecraft.class_711;

public class NoRender
extends Module {
    public final BooleanSetting darkness;
    public final BooleanSetting fireworks;
    public static NoRender INSTANCE;
    public final BooleanSetting waterOverlay;
    public final BooleanSetting campFire;
    public final BooleanSetting xp;
    public final BooleanSetting blindness;
    public final BooleanSetting item;
    public final BooleanSetting hurtCam;
    public final BooleanSetting nausea;
    public final BooleanSetting armor;
    public final BooleanSetting elderGuardian;
    public final BooleanSetting arrows;
    public final BooleanSetting invisible;
    public final BooleanSetting fog;
    public final BooleanSetting totem;
    public final BooleanSetting antiTitle;
    public final BooleanSetting fireOverlay;
    public final BooleanSetting blockOverlay;
    public final BooleanSetting effect;
    public final BooleanSetting portal;
    public final BooleanSetting potions;
    public final BooleanSetting weather;
    public final BooleanSetting explosions;
    public final BooleanSetting fireEntity;
    public final BooleanSetting eggs;
    public final BooleanSetting antiPlayerCollision;

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        NoRender a2 = this;
        if (a.getPacket() instanceof class_5904 && a2.antiTitle.getValue()) {
            a.setCancelled(true);
        }
    }

    @EventHandler
    public void onParticle(ParticleEvent.AddParticle addParticle) {
        ParticleEvent.AddParticle a = addParticle;
        NoRender a2 = this;
        if (a2.elderGuardian.getValue() && a.particle instanceof class_700) {
            a.setCancelled(true);
            return;
        }
        if (a2.explosions.getValue() && a.particle instanceof class_691) {
            a.setCancelled(true);
            return;
        }
        if (a2.campFire.getValue() && a.particle instanceof class_3937) {
            a.setCancelled(true);
            return;
        }
        if (a2.fireworks.getValue() && (a.particle instanceof class_677.class_681 || a.particle instanceof class_677.class_678)) {
            a.setCancelled(true);
            return;
        }
        if (a2.effect.getValue() && a.particle instanceof class_711) {
            a.cancel();
        }
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a3 = f;
        NoRender a2 = this;
        for (class_1297 a3 : NoRender.mc.field_1687.method_18112()) {
            if (a3 instanceof class_1686 && a2.potions.getValue()) {
                NoRender.mc.field_1687.method_2945(a3.method_5628(), class_1297.class_5529.field_26998);
            }
            if (a3 instanceof class_1683 && a2.xp.getValue()) {
                NoRender.mc.field_1687.method_2945(a3.method_5628(), class_1297.class_5529.field_26998);
            }
            if (a3 instanceof class_1667 && a2.arrows.getValue()) {
                NoRender.mc.field_1687.method_2945(a3.method_5628(), class_1297.class_5529.field_26998);
            }
            if (a3 instanceof class_1681 && a2.eggs.getValue()) {
                NoRender.mc.field_1687.method_2945(a3.method_5628(), class_1297.class_5529.field_26998);
            }
            if (!(a3 instanceof class_1542) || !a2.item.getValue()) continue;
            NoRender.mc.field_1687.method_2945(a3.method_5628(), class_1297.class_5529.field_26998);
        }
    }

    public NoRender() {
        NoRender a;
        NoRender noRender = a;
        NoRender noRender2 = a;
        super(BackgroundInfo.ALLATORIxDEMO("\u0015#\u000e./2nn"), Module.Category.Render);
        NoRender noRender3 = a;
        noRender3.weather = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("AF}VuPx"), true));
        noRender2.invisible = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u00025:58(4gy"), false));
        noRender2.potions = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("FLhKr[y"), true));
        noRender2.xp = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("SL"), true));
        noRender2.arrows = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("bnPrBy"), false));
        noRender2.eggs = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u00041lo"), false));
        noRender2.item = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("kiPg"), false));
        noRender2.armor = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\n3;dn"), false));
        noRender2.hurtCam = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("^VnV^Tg"), true));
        noRender2.fireOverlay = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("X59>\u0003*.3:je"), true));
        noRender2.waterOverlay = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("BKVx[YUyPqTs"), true));
        noRender2.blockOverlay = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("Kr3(0\u0003*.3:je"), true));
        noRender2.portal = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("ssPiTf"), true));
        noRender2.totem = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u001f.\"nq"), true));
        noRender2.nausea = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("m}WnPk"), true));
        noRender2.blindness = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\t7%2//3xo"), true));
        noRender2.fog = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("[Zm"), false));
        noRender2.darkness = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u001f-. /3xo"), true));
        noRender2.fireEntity = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("gs]WedtGo"), true));
        noRender2.antiTitle = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u001f(\"gy"), false));
        noRender2.antiPlayerCollision = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("fDvlOP^FzOuQtZd"), true));
        noRender2.effect = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u0019-'3hh"), true));
        noRender2.elderGuardian = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("ncBnFtTd"), false));
        noRender2.explosions = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u00193+ 38(9eo"), true));
        noRender2.campFire = noRender2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("jwNldtGo"), false));
        noRender2.fireworks = noRender2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\r2>9<.$`o"), false));
        noRender.setChinese(HoleUtils.ALLATORIxDEMO("\u6c83\u6714\u660b\u7930"));
        noRender.setDescription(BackgroundInfo.ALLATORIxDEMO("\u001494:.=##g&<w,\u0014\u001a??\u000b\u0011)4{-?\"p7($`q2k>*:.\"\"x2"));
        INSTANCE = noRender;
    }
}
