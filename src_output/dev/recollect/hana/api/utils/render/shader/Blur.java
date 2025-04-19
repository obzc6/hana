/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ladysnake.satin.api.managed.ManagedShaderEffect
 *  ladysnake.satin.api.managed.ShaderEffectManager
 *  ladysnake.satin.api.managed.uniform.Uniform1f
 *  net.minecraft.class_2960
 */
package dev.recollect.hana.api.utils.render.shader;

import dev.recollect.hana.api.utils.dev.hole.Hole;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import ladysnake.satin.api.managed.uniform.Uniform1f;
import net.minecraft.class_2960;
import org.bytedeco.javacv.BaseSettings;

public class Blur {
    private static final Uniform1f blurProgress;
    private static final ManagedShaderEffect blur;
    private static final Uniform1f blurRadius;

    public Blur() {
        Blur a;
    }

    public static void blur(float f, float f2) {
        float a = f2;
        float a2 = f;
        blurProgress.set(1.0f);
        blurRadius.set(a);
        blur.render(a2);
    }

    static {
        blur = ShaderEffectManager.getInstance().manage(new class_2960(BaseSettings.ALLATORIxDEMO("N`]mNl\u0004mZpBp\u0017k\\lYVBp( w[G.FjDp")));
        blurProgress = blur.findUniform1f(Hole.ALLATORIxDEMO(")r\u0011`\u0011Z#"));
        blurRadius = blur.findUniform1f(BaseSettings.ALLATORIxDEMO("gaHp^m"));
    }
}
