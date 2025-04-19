/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_338
 *  net.minecraft.class_342
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_437
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 *  net.minecraft.class_757
 */
package dev.recollect.hana.skid;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import dev.recollect.hana.xibao.SnowAnimation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_338;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import net.minecraft.class_757;

@Environment(value=EnvType.CLIENT)
public class PasswordScreen
extends class_437 {
    private static final class_2960 TEXTURE = new class_2960(OnlineUserInfo.ALLATORIxDEMO("M3@8"), SnowAnimation.ALLATORIxDEMO("\u0016Z\u0018\u0004\u0005R\u001e]\u0007W\u0014k\u000eL\u0002\\\u0015\\\t\u0017\u0017\\\u000b"));
    private final String correctPassword = "114514";
    private class_342 passwordField;

    protected void renderBackground(class_332 class_3322) {
        PasswordScreen a;
        PasswordScreen a2 = class_3322;
        PasswordScreen passwordScreen = a = this;
        a2.method_25296(0, 0, passwordScreen.field_22789, passwordScreen.field_22790, -5592406, -4473925);
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        void a3;
        PasswordScreen a4 = class_3322;
        PasswordScreen a5 = this;
        a5.renderBackground((class_332)a4);
        RenderSystem.setShader(class_757::method_34542);
        RenderSystem.setShaderTexture((int)0, (class_2960)TEXTURE);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        PasswordScreen passwordScreen = a5;
        PasswordScreen passwordScreen2 = a4;
        passwordScreen2.method_25302(TEXTURE, a5.field_22789 / 2 - 128, a5.field_22790 / 2 - 128, 0, 0, 256, 256);
        passwordScreen.passwordField.method_25394((class_332)a4, (int)a3, (int)a2, (float)a);
        PasswordScreen passwordScreen3 = a5;
        passwordScreen2.method_35720(passwordScreen.field_22793, (class_5481)a5.field_22785, a5.field_22789 / 2 - passwordScreen3.field_22793.method_27525((class_5348)passwordScreen3.field_22785) / 2, a5.field_22790 / 2 - 60, 16777215);
        super.method_25394((class_332)a4, (int)a3, (int)a2, (float)a);
    }

    public PasswordScreen(class_2561 class_25612) {
        PasswordScreen a = class_25612;
        PasswordScreen a2 = this;
        super((class_2561)a);
        a2.correctPassword = "114514";
        if (a == null) {
            throw new IllegalArgumentException(SnowAnimation.ALLATORIxDEMO("\u001cG\u0001KP[\u0007a?P\u0015\u000e\u0012\\GW\u0012^\u0000"));
        }
    }

    protected void method_25426() {
        PasswordScreen a;
        PasswordScreen passwordScreen = a;
        PasswordScreen passwordScreen2 = a;
        a.passwordField = new class_342(passwordScreen2.field_22793, passwordScreen2.field_22789 / 2 - 100, a.field_22790 / 2 - 10, 200, 20, class_2561.method_30163((String)OnlineUserInfo.ALLATORIxDEMO("b$V!R=\\=")));
        a.passwordField.method_1880(32);
        a.passwordField.method_1888(true);
        passwordScreen.method_25429((class_364)passwordScreen.passwordField);
        passwordScreen.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)SnowAnimation.ALLATORIxDEMO("j\u0012[\n[\u0018")), class_41852 -> {
            PasswordScreen a = class_41852;
            PasswordScreen a2 = this;
            if (a2.passwordField.method_1882().equals("114514")) {
                if (a2.field_22787 != null) {
                    a2.field_22787.method_1507(null);
                    return;
                }
            } else if (a2.field_22787 != null) {
                a2.field_22787.field_1705.method_1743().method_1812(class_2561.method_30163((String)SnowAnimation.ALLATORIxDEMO("<]\u000eA\u0002J\u0003l%\u001f\u0011O\u0003J\u0010V\u0015VM")));
            }
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 20, 200, 20).method_46431());
        PasswordScreen passwordScreen3 = a;
        passwordScreen3.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)OnlineUserInfo.ALLATORIxDEMO("`*G-")), class_41852 -> {
            PasswordScreen a = class_41852;
            PasswordScreen a2 = this;
            if (a2.field_22787 != null) {
                a2.field_22787.close();
            }
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 50, 200, 20).method_46431());
    }
}
