/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.user.User;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.awt.Color;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class DamageTint
extends Module {
    public DamageTint() {
        DamageTint a;
        DamageTint damageTint = a;
        super(RenderHelper.ALLATORIxDEMO(".t\u0000s\rp#aS6"), Module.Category.Render);
        damageTint.setChinese(User.ALLATORIxDEMO("\u4f05\u5b8e\u8249\u8c24"));
    }

    @Override
    public void onRender2D(class_332 a, float a2) {
        Color a3;
        DamageTint damageTint = a3;
        a2 = 1.0f - MathUtil.clamp(DamageTint.mc.field_1724.method_6032(), 0.0f, 12.0f) / 12.0f;
        a3 = new Color(16711680, true);
        if (a2 < 1.0f) {
            Object object = a3;
            Render2DUtil.draw2DGradientRect(a.method_51448(), 0.0f, 0.0f, mc.method_22683().method_4486(), mc.method_22683().method_4502(), Render2DUtil.injectAlpha(a3, (int)(a2 * 170.0f)), (Color)object, Render2DUtil.injectAlpha(a3, (int)(a2 * 170.0f)), (Color)object);
        }
    }
}
