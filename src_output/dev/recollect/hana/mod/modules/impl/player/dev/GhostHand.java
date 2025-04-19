/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;

public class GhostHand
extends Module {
    public static GhostHand INSTANCE;
    public boolean isActive;

    @Override
    public void onDisable() {
        a.isActive = false;
    }

    public boolean canWork() {
        GhostHand a;
        return a.isOn() && !GhostHand.mc.field_1690.field_1904.method_1434() && !GhostHand.mc.field_1690.field_1832.method_1434();
    }

    public GhostHand() {
        GhostHand a;
        GhostHand ghostHand = a;
        super(ObsidianHelper.ALLATORIxDEMO("\u0014l\u0000^2j(F'"), Module.Category.Player);
        INSTANCE = ghostHand;
    }
}
