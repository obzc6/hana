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
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import org.bytedeco.javacv.BaseSettings;

public class DirectLoginAltScreen
extends class_437 {
    private final class_437 parent;
    private class_342 textFieldAltUsername;

    private /* synthetic */ void onButtonLoginPressed() {
        DirectLoginAltScreen a;
        Hana.ALT.loginCracked(a.textFieldAltUsername.method_1882());
        DirectLoginAltScreen directLoginAltScreen = a;
        directLoginAltScreen.field_22787.method_1507(directLoginAltScreen.parent);
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        void a3;
        DirectLoginAltScreen a4 = class_3322;
        DirectLoginAltScreen a5 = this;
        DirectLoginAltScreen directLoginAltScreen = a4;
        DirectLoginAltScreen directLoginAltScreen2 = a5;
        directLoginAltScreen.method_25300(directLoginAltScreen2.field_22793, directLoginAltScreen2.field_22785.getString(), a5.field_22789 / 2, 20, 16777215);
        directLoginAltScreen.method_25303(a5.field_22793, BaseSettings.ALLATORIxDEMO("hv~ZH/~mY{RhZg"), a5.field_22789 / 2 - 100, a5.field_22790 / 2 - 90, 16777215);
        DirectLoginAltScreen directLoginAltScreen3 = a5;
        directLoginAltScreen3.textFieldAltUsername.method_25394((class_332)a4, (int)a2, (int)a, (float)a3);
        super.method_25394((class_332)a4, (int)a2, (int)a, (float)a3);
    }

    public void method_25426() {
        DirectLoginAltScreen a;
        DirectLoginAltScreen directLoginAltScreen;
        DirectLoginAltScreen directLoginAltScreen2 = directLoginAltScreen = a;
        super.method_25426();
        DirectLoginAltScreen directLoginAltScreen3 = directLoginAltScreen;
        directLoginAltScreen2.textFieldAltUsername = new class_342(directLoginAltScreen3.field_22793, directLoginAltScreen3.field_22789 / 2 - 100, directLoginAltScreen.field_22790 / 2 - 76, 200, 20, class_2561.method_30163((String)HoleUtils.ALLATORIxDEMO("auAoP=l|Ds")));
        directLoginAltScreen2.method_37063((class_364)directLoginAltScreen.textFieldAltUsername);
        a = class_4185.method_46430((class_2561)class_2561.method_30163((String)BaseSettings.ALLATORIxDEMO("ESn^l")), class_41852 -> {
            DirectLoginAltScreen a = class_41852;
            DirectLoginAltScreen a2 = this;
            a2.onButtonLoginPressed();
        }).method_46434(directLoginAltScreen.field_22789 / 2 - 100, directLoginAltScreen.field_22790 / 2 + 24, 200, 20).method_46431();
        directLoginAltScreen.method_37063((class_364)a);
        DirectLoginAltScreen directLoginAltScreen4 = directLoginAltScreen;
        directLoginAltScreen4.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)HoleUtils.ALLATORIxDEMO("a|L~Lz")), class_41852 -> {
            DirectLoginAltScreen a;
            DirectLoginAltScreen a2 = class_41852;
            DirectLoginAltScreen directLoginAltScreen = a = this;
            directLoginAltScreen.field_22787.method_1507(directLoginAltScreen.parent);
        }).method_46434(directLoginAltScreen.field_22789 / 2 - 100, directLoginAltScreen.field_22790 / 2 + 46, 200, 20).method_46431());
    }

    protected DirectLoginAltScreen(class_437 class_4372) {
        DirectLoginAltScreen a = class_4372;
        DirectLoginAltScreen a2 = this;
        super(class_2561.method_30163((String)BaseSettings.ALLATORIxDEMO("NVHjHj\u001cESn^l")));
        a2.parent = a;
    }
}
