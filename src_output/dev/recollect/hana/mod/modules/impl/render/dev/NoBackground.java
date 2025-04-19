/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_465;
import org.lwjgl.opengl.GL11;

public class NoBackground
extends Module {
    private float[] originalClearColor;
    private boolean isEnabled = false;

    @Override
    public void onRender2D(class_332 class_3322, float f) {
        float a4 = f;
        NoBackground a2 = this;
        if (a2.isEnabled) {
            class_465 a3;
            class_437 a4 = class_310.method_1551().field_1755;
            class_465 class_4652 = a3 = a4 instanceof class_465 ? (class_465)a4 : null;
            if (a3 != null) {
                GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
                GL11.glClear((int)16384);
            }
        }
    }

    private /* synthetic */ void saveOriginalClearColor() {
        float[] arrf = new float[4];
        arrf[0] = 0.0f;
        arrf[1] = 0.0f;
        arrf[2] = 0.0f;
        arrf[3] = 0.5f;
        a.originalClearColor = arrf;
    }

    @Override
    public void onDisable() {
        NoBackground a;
        a.isEnabled = false;
        a.restoreOriginalClearColor();
    }

    private /* synthetic */ void restoreOriginalClearColor() {
        NoBackground a;
        GL11.glClearColor((float)a.originalClearColor[0], (float)a.originalClearColor[1], (float)a.originalClearColor[2], (float)a.originalClearColor[3]);
    }

    public NoBackground() {
        super(TimeHelper.ALLATORIxDEMO(";Xb\u0003D\u000eG\u0010R\n\u0019Q"), Tab.ALLATORIxDEMO("Q\u0005x\u0019>N/\u0018c\r6\u0017k\n#Lf\u0018v\u000elKf\bn@q\u0011.Na\u0015#\u0017x\u0016&\u000bG;l\u0004M)`Dl\b{\u000bo\u0016{\u0005pJ|\u0002(\bp\u0000<Mf\u0002oK{\rp\u001d=\u0015"), Module.Category.Render);
        NoBackground a;
        float[] arrf = new float[4];
        arrf[0] = 0.0f;
        arrf[1] = 0.0f;
        arrf[2] = 0.0f;
        arrf[3] = 0.5f;
        a.originalClearColor = arrf;
        a.setChinese(TimeHelper.ALLATORIxDEMO("\u6c9c\u6776\u80bb\u665a"));
    }

    @Override
    public void onEnable() {
        NoBackground a;
        a.isEnabled = true;
        a.saveOriginalClearColor();
    }
}
