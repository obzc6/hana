/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_898;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class BAHalo
extends Module {
    private final SliderSetting animation;
    private final EnumSetting<Mode> mode;
    boolean isReversing;
    private final BooleanSetting showInFirstPerson;

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        BAHalo a = class_45872;
        BAHalo a2 = this;
        if (a2.mode.getValue() == Mode.Shiroko) {
            a2.drawShirokoHalo((class_4587)a);
            return;
        }
        if (a2.mode.getValue() == Mode.Hoshino) {
            a2.drawHoshinoHalo();
            return;
        }
        if (a2.mode.getValue() == Mode.Aris) {
            a2.drawArisHalo();
            return;
        }
        if (a2.mode.getValue() == Mode.Yuuka) {
            a2.drawYuukaHalo();
            return;
        }
        if (a2.mode.getValue() == Mode.Natsu) {
            a2.drawNatsuHalo();
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawRectangle(float f, float f2, float f3, float f4, float f5, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        float f6 = f4;
        BAHalo a7 = this;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(a6 - 0.05f), (float)(a4 - 0.15f), (float)0.0f);
        if (a2 != false) {
            GL11.glLineWidth((float)(a * a7.getExtraWidth()));
            GL11.glBegin((int)6);
            GL11.glVertex2f((float)(-a5 / 2.0f), (float)(-a3 / 2.0f));
            GL11.glVertex2f((float)(a5 / 2.0f), (float)(-a3 / 2.0f));
            GL11.glVertex2f((float)(a5 / 2.0f), (float)(a3 / 2.0f));
            GL11.glVertex2f((float)(-a5 / 2.0f), (float)(a3 / 2.0f));
            GL11.glEnd();
        } else {
            GL11.glLineWidth((float)(a * a7.getExtraWidth()));
            GL11.glBegin((int)2);
            GL11.glVertex2f((float)(-a5 / 2.0f), (float)(-a3 / 2.0f));
            GL11.glVertex2f((float)(a5 / 2.0f), (float)(-a3 / 2.0f));
            GL11.glVertex2f((float)(a5 / 2.0f), (float)(a3 / 2.0f));
            GL11.glVertex2f((float)(-a5 / 2.0f), (float)(a3 / 2.0f));
            GL11.glEnd();
        }
        GL11.glPopMatrix();
    }

    public BAHalo() {
        BAHalo a;
        BAHalo bAHalo = a;
        super(TipUtils.ALLATORIxDEMO("\u0003/\u0014\u0012zV"), Module.Category.Render);
        BAHalo bAHalo2 = a;
        bAHalo2.mode = bAHalo.add(new EnumSetting<Mode>(NCPRaytracer.ALLATORIxDEMO("_~PcMj_"), Mode.Shiroko));
        bAHalo.showInFirstPerson = bAHalo.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("RR3\u001d2I\u0011\u000b.\u0000yW"), true));
        bAHalo.animation = bAHalo.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("dMegDsAkE"), 0.0, 0.0, 0.1));
        a.isReversing = false;
        a.setChinese(TipUtils.ALLATORIxDEMO("\u855b\u84b3\u683f\u683b\u515f\u7396"));
    }

    public void drawArisHalo() {
        BAHalo a22;
        BAHalo bAHalo = a22;
        if (bAHalo.animation.getValue() == 0.0) {
            bAHalo.isReversing = false;
        }
        if (bAHalo.animation.getValue() == 0.1) {
            bAHalo.isReversing = true;
        }
        float a22 = BAHalo.mc.field_1724.method_17682() + 0.25f + (float)bAHalo.animation.getValue();
        GL11.glPushMatrix();
        GL11.glTranslated((double)(BAHalo.mc.field_1724.field_6014 + (BAHalo.mc.field_1724.method_23317() - BAHalo.mc.field_1724.field_6014) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10216()), (double)(BAHalo.mc.field_1724.field_6036 + (BAHalo.mc.field_1724.method_23318() - BAHalo.mc.field_1724.field_6036) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10214() + (double)a22), (double)(BAHalo.mc.field_1724.field_5969 + (BAHalo.mc.field_1724.method_23321() - BAHalo.mc.field_1724.field_5969) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10215()));
        RenderSystem.enableBlend();
        GL11.glEnable((int)2848);
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        GL11.glBlendFunc((int)770, (int)771);
        RenderSystem.setShaderColor((float)161.0f, (float)253.0f, (float)228.0f, (float)220.0f);
        GL11.glRotatef((float)(-BAHalo.mc.field_1724.method_36454()), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        BAHalo bAHalo2 = bAHalo;
        BAHalo bAHalo3 = bAHalo;
        bAHalo.drawRectangle(0.2f, 0.02f, 0.26f, 0.26f, 4.0f, false);
        bAHalo3.drawRectangle(0.2f, 0.3f, 0.4f, 0.4f, 6.0f, false);
        bAHalo3.drawRectangle(-0.09f, 0.21f, 0.35f, 0.35f, 5.0f, false);
        bAHalo2.drawRectangle(-0.13f, 0.45f, 0.15f, 0.05f, 4.0f, false);
        bAHalo2.drawRectangle(0.12f, 0.49f, 0.1f, 0.0f, 6.0f, false);
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public void drawYuukaHalo() {
        BAHalo a22;
        BAHalo bAHalo = a22;
        if (bAHalo.animation.getValue() == 0.0) {
            bAHalo.isReversing = false;
        }
        if (bAHalo.animation.getValue() == 0.1) {
            bAHalo.isReversing = true;
        }
        float a22 = BAHalo.mc.field_1724.method_17682() + 0.25f + (float)bAHalo.animation.getValue();
        GL11.glPushMatrix();
        GL11.glTranslated((double)(BAHalo.mc.field_1724.field_6014 + (BAHalo.mc.field_1724.method_23317() - BAHalo.mc.field_1724.field_6014) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10216()), (double)(BAHalo.mc.field_1724.field_6036 + (BAHalo.mc.field_1724.method_23318() - BAHalo.mc.field_1724.field_6036) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10214() + (double)a22), (double)(BAHalo.mc.field_1724.field_5969 + (BAHalo.mc.field_1724.method_23321() - BAHalo.mc.field_1724.field_5969) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10215()));
        RenderSystem.enableBlend();
        GL11.glEnable((int)2848);
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glRotatef((float)(-BAHalo.mc.field_1724.method_36454()), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        RenderSystem.setShaderColor((float)80.0f, (float)150.0f, (float)180.0f, (float)250.0f);
        GL11.glLineWidth((float)(2.0f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)3);
        int n = a22 = 0;
        while (n <= 360) {
            float f = (float)Math.cos(Math.toRadians(a22)) * 0.292f;
            float f2 = (float)Math.sin(Math.toRadians(a22));
            GL11.glVertex2f((float)f, (float)(f2 * 0.292f));
            n = a22 += 5;
        }
        GL11.glEnd();
        RenderSystem.setShaderColor((float)30.0f, (float)30.0f, (float)30.0f, (float)200.0f);
        GL11.glLineWidth((float)(6.0f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)3);
        int n2 = a22 = 0;
        while (n2 <= 360) {
            float f = (float)Math.cos(Math.toRadians(a22)) * 0.3f;
            float f3 = (float)Math.sin(Math.toRadians(a22));
            GL11.glVertex2f((float)f, (float)(f3 * 0.3f));
            n2 = a22 += 5;
        }
        GL11.glEnd();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public void drawShirokoHalo(class_4587 a) {
        BAHalo a22;
        BAHalo bAHalo = a22;
        if (bAHalo.animation.getValue() == 0.0) {
            bAHalo.isReversing = false;
        }
        if (bAHalo.animation.getValue() == 0.1) {
            bAHalo.isReversing = true;
        }
        float a22 = BAHalo.mc.field_1724.method_17682() + 0.25f + (float)bAHalo.animation.getValue();
        a.method_22903();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShaderColor((float)(0 + (int)(bAHalo.animation.getValue() * 1800.0)), (float)((int)(230.0 + bAHalo.animation.getValue() * 200.0)), (float)250.0f, (float)220.0f);
        RenderSystem.setShader(class_757::method_34539);
        class_2872.method_1328(class_293.class_5596.field_27380, class_290.field_1592);
        double d = BAHalo.mc.field_1724.field_6014 + (BAHalo.mc.field_1724.method_23317() - BAHalo.mc.field_1724.field_6014) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10216();
        double d2 = BAHalo.mc.field_1724.field_6036 + (BAHalo.mc.field_1724.method_23318() - BAHalo.mc.field_1724.field_6036) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10214() + (double)a22;
        double d3 = BAHalo.mc.field_1724.field_5969 + (BAHalo.mc.field_1724.method_23321() - BAHalo.mc.field_1724.field_5969) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10215();
        int n = a22 = 0;
        while (n <= 360) {
            float f = (float)(d + Math.cos(Math.toRadians(a22)) * 0.18000000715255737 * (BAHalo.mc.field_1724.method_5829().field_1320 - BAHalo.mc.field_1724.method_5829().field_1323 + (BAHalo.mc.field_1724.method_5829().field_1324 - BAHalo.mc.field_1724.method_5829().field_1321)) * 0.5);
            double d4 = Math.sin(Math.toRadians(a22)) * 0.18000000715255737 * (BAHalo.mc.field_1724.method_5829().field_1320 - BAHalo.mc.field_1724.method_5829().field_1323 + (BAHalo.mc.field_1724.method_5829().field_1324 - BAHalo.mc.field_1724.method_5829().field_1321)) * 0.5;
            class_2872.method_22918(a.method_23760().method_23761(), f, (float)d2, (float)(d3 + d4));
            n = a22 += 5;
        }
        class_2892.method_1350();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        a.method_22909();
        RenderSystem.setShaderColor((float)(0 + (int)(bAHalo.animation.getValue() * 1800.0)), (float)((int)(230.0 + bAHalo.animation.getValue() * 200.0)), (float)250.0f, (float)220.0f);
        a22 = BAHalo.mc.field_1724.method_36454();
    }

    public void drawNatsuHalo() {
        BAHalo a22;
        BAHalo bAHalo = a22;
        if (bAHalo.animation.getValue() == 0.0) {
            bAHalo.isReversing = false;
        }
        if (bAHalo.animation.getValue() == 0.1) {
            bAHalo.isReversing = true;
        }
        float a22 = BAHalo.mc.field_1724.method_17682() + 0.25f + (float)bAHalo.animation.getValue();
        GL11.glPushMatrix();
        GL11.glTranslated((double)(BAHalo.mc.field_1724.field_6014 + (BAHalo.mc.field_1724.method_23317() - BAHalo.mc.field_1724.field_6014) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10216()), (double)(BAHalo.mc.field_1724.field_6036 + (BAHalo.mc.field_1724.method_23318() - BAHalo.mc.field_1724.field_6036) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10214() + (double)a22), (double)(BAHalo.mc.field_1724.field_5969 + (BAHalo.mc.field_1724.method_23321() - BAHalo.mc.field_1724.field_5969) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10215()));
        RenderSystem.enableBlend();
        GL11.glEnable((int)2848);
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        GL11.glBlendFunc((int)770, (int)771);
        RenderSystem.setShaderColor((float)254.0f, (float)200.0f, (float)200.0f, (float)240.0f);
        GL11.glRotatef((float)(-BAHalo.mc.field_1724.method_36454()), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glLineWidth((float)(3.5f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)3);
        int n = a22 = 0;
        while (n <= 360) {
            float f = (float)Math.cos(Math.toRadians(a22)) * 0.3f;
            float f2 = (float)Math.sin(Math.toRadians(a22));
            GL11.glVertex2f((float)f, (float)(f2 * 0.3f));
            n = a22 += 5;
        }
        GL11.glEnd();
        GL11.glBegin((int)3);
        int n2 = a22 = 0;
        while (n2 <= 360) {
            float f = (float)Math.toRadians(a22);
            float f3 = (float)Math.cos(f) * 0.15f;
            float f4 = (float)Math.sin(f) * 0.15f;
            GL11.glVertex2f((float)f3, (float)f4);
            if (a22 % 90 == 0) {
                float f5 = 0.05f;
                float f6 = 0.05f;
                GL11.glVertex2f((float)(f3 + (float)Math.cos(f) * f5), (float)(f4 + (float)Math.sin(f) * f5));
                GL11.glVertex2f((float)f3, (float)f4);
                GL11.glVertex2f((float)(f3 - (float)Math.cos(f) * f6), (float)(f4 - (float)Math.sin(f) * f6));
                GL11.glVertex2f((float)f3, (float)f4);
            }
            n2 = a22 += 5;
        }
        GL11.glEnd();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public void drawReisaHalo() {
        BAHalo a22;
        BAHalo bAHalo = a22;
        if (bAHalo.animation.getValue() == 0.0) {
            bAHalo.isReversing = false;
        }
        if (bAHalo.animation.getValue() == 0.1) {
            bAHalo.isReversing = true;
        }
        float a22 = BAHalo.mc.field_1724.method_17682() + 0.25f + (float)bAHalo.animation.getValue();
        GL11.glPushMatrix();
        GL11.glTranslated((double)(BAHalo.mc.field_1724.field_6014 + (BAHalo.mc.field_1724.method_23317() - BAHalo.mc.field_1724.field_6014) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10216()), (double)(BAHalo.mc.field_1724.field_6036 + (BAHalo.mc.field_1724.method_23318() - BAHalo.mc.field_1724.field_6036) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10214() + (double)a22), (double)(BAHalo.mc.field_1724.field_5969 + (BAHalo.mc.field_1724.method_23321() - BAHalo.mc.field_1724.field_5969) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10215()));
        RenderSystem.enableBlend();
        GL11.glEnable((int)2848);
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glRotatef((float)(-BAHalo.mc.field_1724.method_36454()), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        RenderSystem.setShaderColor((float)200.0f, (float)200.0f, (float)250.0f, (float)220.0f);
        BAHalo bAHalo2 = bAHalo;
        bAHalo2.drawStar(0.0f, 0.0f, 0.3f);
        GL11.glPushMatrix();
        GL11.glRotatef((float)36.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        bAHalo2.drawStar(0.0f, 0.0f, 0.15f);
        GL11.glPopMatrix();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public void drawHoshinoHalo() {
        BAHalo a22;
        float f;
        float f2;
        float f3;
        BAHalo bAHalo = a22;
        if (bAHalo.animation.getValue() == 0.0) {
            bAHalo.isReversing = false;
        }
        if (bAHalo.animation.getValue() == 0.1) {
            bAHalo.isReversing = true;
        }
        float a22 = BAHalo.mc.field_1724.method_17682() + 0.25f + (float)bAHalo.animation.getValue();
        float f4 = 0.035f;
        float f5 = 0.18f;
        float f6 = 0.08f;
        GL11.glPushMatrix();
        GL11.glTranslated((double)(BAHalo.mc.field_1724.field_6014 + (BAHalo.mc.field_1724.method_23317() - BAHalo.mc.field_1724.field_6014) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10216()), (double)(BAHalo.mc.field_1724.field_6036 + (BAHalo.mc.field_1724.method_23318() - BAHalo.mc.field_1724.field_6036) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10214() + (double)a22), (double)(BAHalo.mc.field_1724.field_5969 + (BAHalo.mc.field_1724.method_23321() - BAHalo.mc.field_1724.field_5969) * (double)mc.method_1488() - BAHalo.mc.method_1561().field_4686.method_19326().method_10215()));
        RenderSystem.enableBlend();
        GL11.glEnable((int)2848);
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        GL11.glBlendFunc((int)770, (int)771);
        RenderSystem.setShaderColor((float)237.0f, (float)(110 + (int)(bAHalo.animation.getValue() * 600.0)), (float)183.0f, (float)220.0f);
        GL11.glRotatef((float)(-BAHalo.mc.field_1724.method_36454()), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glLineWidth((float)(4.0f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)3);
        int n = a22 = 0;
        while (n <= 360) {
            float f7 = (float)Math.cos(Math.toRadians(a22)) * 0.13f;
            float f8 = (float)Math.sin(Math.toRadians(a22));
            GL11.glVertex2f((float)f7, (float)(f8 * 0.13f));
            n = a22 += 5;
        }
        GL11.glEnd();
        GL11.glTranslated((double)0.0, (double)0.0, (double)(-f4));
        GL11.glLineWidth((float)(2.5f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)3);
        int n2 = a22 = 0;
        while (n2 <= 360) {
            f3 = (float)Math.toRadians(a22);
            f2 = (float)Math.cos(f3) * 0.2f;
            f = (float)Math.sin(f3) * 0.2f;
            GL11.glVertex2f((float)f2, (float)f);
            n2 = a22 += 5;
        }
        GL11.glEnd();
        GL11.glTranslated((double)0.0, (double)0.0, (double)(-f4));
        GL11.glLineWidth((float)(4.0f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)3);
        int n3 = a22 = 15;
        while (n3 <= 165) {
            f3 = (float)Math.toRadians(a22);
            f2 = (float)Math.cos(f3) * 0.27f;
            f = (float)Math.sin(f3) * 0.27f;
            GL11.glVertex2f((float)f2, (float)f);
            n3 = a22 += 5;
        }
        GL11.glEnd();
        GL11.glBegin((int)3);
        int n4 = a22 = 195;
        while (n4 <= 345) {
            f3 = (float)Math.toRadians(a22);
            f2 = (float)Math.cos(f3) * 0.27f;
            f = (float)Math.sin(f3) * 0.27f;
            GL11.glVertex2f((float)f2, (float)f);
            n4 = a22 += 5;
        }
        GL11.glEnd();
        GL11.glLineWidth((float)(4.0f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)1);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(0.0)) * 0.27f), (float)((float)Math.sin(Math.toRadians(0.0)) * 0.27f), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(0.0)) * (0.27f + f5)), (float)((float)Math.sin(Math.toRadians(0.0)) * (0.27f + f5)), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(180.0)) * 0.27f), (float)((float)Math.sin(Math.toRadians(180.0)) * 0.27f), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(180.0)) * (0.27f + f5)), (float)((float)Math.sin(Math.toRadians(180.0)) * (0.27f + f5)), (float)0.0f);
        GL11.glEnd();
        GL11.glLineWidth((float)(4.0f * bAHalo.getExtraWidth()));
        GL11.glBegin((int)1);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(15.0)) * 0.268f), (float)((float)Math.sin(Math.toRadians(15.0)) * 0.27f), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(15.0)) * (0.27f + f6)), (float)((float)Math.sin(Math.toRadians(12.0)) * (0.27f + f6)), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(165.0)) * 0.268f), (float)((float)Math.sin(Math.toRadians(165.0)) * 0.27f), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(165.0)) * (0.27f + f6)), (float)((float)Math.sin(Math.toRadians(168.0)) * (0.27f + f6)), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(195.0)) * 0.268f), (float)((float)Math.sin(Math.toRadians(195.0)) * 0.27f), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(195.0)) * (0.27f + f6)), (float)((float)Math.sin(Math.toRadians(192.0)) * (0.27f + f6)), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(345.0)) * 0.268f), (float)((float)Math.sin(Math.toRadians(345.0)) * 0.27f), (float)0.0f);
        GL11.glVertex3f((float)((float)Math.cos(Math.toRadians(345.0)) * (0.27f + f6)), (float)((float)Math.sin(Math.toRadians(348.0)) * (0.27f + f6)), (float)0.0f);
        GL11.glEnd();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public float getExtraWidth() {
        return 1.0f;
    }

    @Override
    public String getInfo() {
        BAHalo a;
        return a.mode.getName();
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawStar(float f, float f2, float f3) {
        int a;
        void a2;
        int n;
        BAHalo bAHalo = this;
        float[] arrf = new float[10];
        int n2 = n = 0;
        while (n2 < 10) {
            int n3 = n++;
            arrf[n3] = (float)Math.toRadians((double)n3 * 360.0 / 10.0);
            n2 = n;
        }
        float[] arrf2 = new float[20];
        void var6_9 = a2 * 0.4f;
        int n4 = a = 0;
        while (n4 < 10) {
            void a3;
            void a4;
            float f4 = arrf[a];
            void var9_11 = a % 2 == 0 ? a2 : var6_9;
            float[] arrf3 = arrf2;
            arrf3[a * 2] = a4 + (float)Math.cos(f4) * var9_11;
            int n5 = a * 2 + 1;
            arrf3[n5] = a3 + (float)Math.sin(f4) * var9_11;
            n4 = ++a;
        }
        GL11.glBegin((int)3);
        int n6 = a = 0;
        while (n6 < 10) {
            int n7 = a;
            float[] arrf4 = arrf2;
            GL11.glVertex2f((float)arrf2[n7 * 2], (float)arrf4[a * 2 + 1]);
            int n8 = (a + 2) % 10 * 2 + 1;
            GL11.glVertex2f((float)arrf4[(n7 + 2) % 10 * 2], (float)arrf2[n8]);
            n6 = ++a;
        }
        GL11.glVertex2f((float)arrf2[0], (float)arrf2[1]);
        GL11.glEnd();
    }

    private static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Hoshino;
        public static final /* enum */ Mode Shiroko;
        public static final /* enum */ Mode Aris;
        public static final /* enum */ Mode Yuuka;
        public static final /* enum */ Mode Natsu;
        private static final /* synthetic */ Mode[] $VALUES;

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            Shiroko = new Mode(TipUtils.ALLATORIxDEMO(":)\u0007.\u001c}V"), 0);
            Hoshino = new Mode(NpSocketClient.ALLATORIxDEMO("-h4d%c\""), 1);
            Aris = new Mode(TipUtils.ALLATORIxDEMO("\u001d\u0001J"), 2);
            Yuuka = new Mode(NpSocketClient.ALLATORIxDEMO("\u001ey9f,"), 3);
            Natsu = new Mode(TipUtils.ALLATORIxDEMO(" =\u0007eL"), 4);
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Mode() {
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

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[5];
            arrmode[0] = Shiroko;
            arrmode[1] = Hoshino;
            arrmode[2] = Aris;
            arrmode[3] = Yuuka;
            arrmode[4] = Natsu;
            return arrmode;
        }
    }

}
