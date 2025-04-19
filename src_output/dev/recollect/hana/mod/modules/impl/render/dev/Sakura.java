/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2400
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.video.Renderer;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2400;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Sakura
extends Module {
    private long lastParticleTime;
    public static Sakura INSTANCE;
    private final class_310 mc;

    public Sakura() {
        Sakura a;
        Sakura sakura = a;
        super(Renderer.ALLATORIxDEMO("N\u0001k\b8V"), Module.Category.Render);
        a.mc = class_310.method_1551();
        sakura.lastParticleTime = 0L;
        sakura.setChinese(CameraState.ALLATORIxDEMO("\u6a6c\u8280"));
        INSTANCE = sakura;
    }

    @Override
    public void onDisable() {
        a.lastParticleTime = System.currentTimeMillis();
    }

    @EventHandler
    public void onRender3D(Render3DEvent render3DEvent) {
        Render3DEvent a = render3DEvent;
        Sakura a2 = this;
        if (System.currentTimeMillis() - a2.lastParticleTime > 200L) {
            a2.generateParticles();
            a2.lastParticleTime = System.currentTimeMillis();
        }
    }

    private /* synthetic */ void generateParticles() {
        Sakura sakura = this;
        if (sakura.mc.field_1724 != null) {
            int a;
            Sakura sakura2 = sakura;
            double d = sakura2.mc.field_1724.method_23317();
            double d2 = sakura2.mc.field_1724.method_23318();
            double d3 = sakura2.mc.field_1724.method_23321();
            int n = a = 0;
            while (n < 10) {
                double d4 = (Math.random() - 0.5) * 10.0;
                double d5 = Math.random() * 5.0;
                double d6 = (Math.random() - 0.5) * 10.0;
                d4 = d + d4;
                d5 = d2 + d5;
                d6 = d3 + d6;
                sakura.mc.field_1687.method_8406((class_2394)class_2398.field_43379, d4, d5, d6, 0.0, -0.1, 0.0);
                n = ++a;
            }
        }
    }

    @Override
    public void onEnable() {
        a.lastParticleTime = System.currentTimeMillis();
    }
}
