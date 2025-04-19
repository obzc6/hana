/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_342
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_437
 */
package dev.recollect.hana.mod.gui.nullpoint.alts;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.AltManager;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.settings.Setting;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;

public class TokenLoginScreen
extends class_437 {
    private class_342 textFieldAltToken;
    private final class_437 parent;
    private class_342 textFieldAltUID;
    private class_342 textFieldAltName;

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        void a3;
        TokenLoginScreen a4 = class_3322;
        TokenLoginScreen a5 = this;
        TokenLoginScreen tokenLoginScreen = a4;
        TokenLoginScreen tokenLoginScreen2 = a5;
        tokenLoginScreen.method_25300(tokenLoginScreen2.field_22793, tokenLoginScreen2.field_22785.getString(), a5.field_22789 / 2, 20, 16777215);
        tokenLoginScreen.method_25303(a5.field_22793, Setting.ALLATORIxDEMO("+.w\"vaV$c#k"), a5.field_22789 / 2 - 100, a5.field_22790 / 2 - 90, 16777215);
        a4.method_25303(a5.field_22793, RadiusUtils.ALLATORIxDEMO("*U\u001cY\u001c\u001a1e y"), a5.field_22789 / 2 - 100, a5.field_22790 / 2 - 50, 16777215);
        a4.method_25303(a5.field_22793, Setting.ALLATORIxDEMO("\u0005m3a3\"\u0005i+`"), a5.field_22789 / 2 - 100, a5.field_22790 / 2 - 10, 16777215);
        TokenLoginScreen tokenLoginScreen3 = a5;
        TokenLoginScreen tokenLoginScreen4 = a5;
        tokenLoginScreen4.textFieldAltName.method_25394((class_332)a4, (int)a, (int)a3, (float)a2);
        tokenLoginScreen4.textFieldAltToken.method_25394((class_332)a4, (int)a, (int)a3, (float)a2);
        tokenLoginScreen3.textFieldAltUID.method_25394((class_332)a4, (int)a, (int)a3, (float)a2);
        super.method_25394((class_332)a4, (int)a, (int)a3, (float)a2);
    }

    public void method_25426() {
        TokenLoginScreen a;
        TokenLoginScreen tokenLoginScreen = a;
        super.method_25426();
        TokenLoginScreen tokenLoginScreen2 = a;
        a.textFieldAltName = new class_342(a.field_22793, a.field_22789 / 2 - 100, a.field_22790 / 2 + 4, 200, 20, class_2561.method_30163((String)RadiusUtils.ALLATORIxDEMO("*U\u001cY\u001b\u001d!Z\u0006Z")));
        tokenLoginScreen.method_37063((class_364)tokenLoginScreen.textFieldAltName);
        TokenLoginScreen tokenLoginScreen3 = a;
        a.textFieldAltToken = new class_342(a.field_22793, a.field_22789 / 2 - 100, a.field_22790 / 2 - 76, 200, 20, class_2561.method_30163((String)Setting.ALLATORIxDEMO("+.w\"vfQ/h!i")));
        tokenLoginScreen3.textFieldAltToken.method_1880(Integer.MAX_VALUE);
        tokenLoginScreen3.method_37063((class_364)tokenLoginScreen3.textFieldAltToken);
        TokenLoginScreen tokenLoginScreen4 = a;
        a.textFieldAltUID = new class_342(a.field_22793, a.field_22789 / 2 - 100, a.field_22790 / 2 - 36, 200, 20, class_2561.method_30163((String)RadiusUtils.ALLATORIxDEMO("~\u0006H\fOOn\"{")));
        tokenLoginScreen4.textFieldAltUID.method_1880(Integer.MAX_VALUE);
        tokenLoginScreen4.method_37063((class_364)tokenLoginScreen4.textFieldAltUID);
        tokenLoginScreen.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)Setting.ALLATORIxDEMO("I/d-i")), class_41852 -> {
            TokenLoginScreen a = class_41852;
            TokenLoginScreen a2 = this;
            a2.onButtonLoginPressed();
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 24 + 8, 200, 20).method_46431());
        TokenLoginScreen tokenLoginScreen5 = a;
        tokenLoginScreen5.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)RadiusUtils.ALLATORIxDEMO("*\\\u0001X\u000eS")), class_41852 -> {
            TokenLoginScreen a;
            TokenLoginScreen a2 = class_41852;
            TokenLoginScreen tokenLoginScreen = a = this;
            tokenLoginScreen.field_22787.method_1507(tokenLoginScreen.parent);
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 46 + 8, 200, 20).method_46431());
    }

    protected TokenLoginScreen(class_437 class_4372) {
        TokenLoginScreen a = class_4372;
        TokenLoginScreen a2 = this;
        super(class_2561.method_30163((String)Setting.ALLATORIxDEMO("Yt3y1;\u0014i\"%a")));
        a2.parent = a;
    }

    private /* synthetic */ void onButtonLoginPressed() {
        TokenLoginScreen a;
        Hana.ALT.loginToken(a.textFieldAltName.method_1882(), a.textFieldAltToken.method_1882(), a.textFieldAltUID.method_1882());
        TokenLoginScreen tokenLoginScreen = a;
        tokenLoginScreen.field_22787.method_1507(tokenLoginScreen.parent);
    }
}
