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
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.AltManager;
import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.gui.nullpoint.alts.AltScreen;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;

public class AddAltScreen
extends class_437 {
    private class_342 textFieldAltUsername;
    private final AltScreen parent;

    public void method_25426() {
        AddAltScreen a;
        AddAltScreen addAltScreen = a;
        super.method_25426();
        AddAltScreen addAltScreen2 = a;
        a.textFieldAltUsername = new class_342(addAltScreen2.field_22793, addAltScreen2.field_22789 / 2 - 100, a.field_22790 / 2 - 76, 200, 20, class_2561.method_30163((String)BetterDynamicAnimation.ALLATORIxDEMO("a~AdP6lwDx")));
        a.textFieldAltUsername.method_1852("");
        addAltScreen.method_37063((class_364)addAltScreen.textFieldAltUsername);
        addAltScreen.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)Vec3.ALLATORIxDEMO("$|\u001683\r")), class_41852 -> {
            AddAltScreen a = class_41852;
            AddAltScreen a2 = this;
            a2.onButtonAltAddPressed();
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 24, 200, 20).method_46431());
        AddAltScreen addAltScreen3 = a;
        addAltScreen3.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)BetterDynamicAnimation.ALLATORIxDEMO("awLuLq")), class_41852 -> {
            AddAltScreen a = class_41852;
            AddAltScreen a2 = this;
            a2.onButtonCancelPressed();
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 46, 200, 20).method_46431());
    }

    private /* synthetic */ void onButtonAltAddPressed() {
        Object a;
        AddAltScreen addAltScreen = a;
        a = new Alt(addAltScreen.textFieldAltUsername.method_1882());
        Hana.ALT.addAlt((Alt)a);
        addAltScreen.parent.refreshAltList();
    }

    public AddAltScreen(AltScreen altScreen) {
        class_437 a = altScreen;
        AddAltScreen a2 = this;
        super(class_2561.method_30163((String)Vec3.ALLATORIxDEMO("\u0005r\u0000/(y\u001cy\u0015v\u000b")));
        a2.parent = a;
    }

    public void onButtonCancelPressed() {
        AddAltScreen a;
        AddAltScreen addAltScreen = a;
        addAltScreen.field_22787.method_1507((class_437)addAltScreen.parent);
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        void a3;
        AddAltScreen a4 = class_3322;
        AddAltScreen a5 = this;
        AddAltScreen addAltScreen = a4;
        AddAltScreen addAltScreen2 = a5;
        a4.method_25300(a5.field_22793, Vec3.ALLATORIxDEMO("2}\u0017\u001c\u0017}\u000fl\u0011@%j\u0011/${\u0011w\u0007}\r"), a5.field_22789 / 2, 20, 16777215);
        addAltScreen.method_25300(addAltScreen2.field_22793, BetterDynamicAnimation.ALLATORIxDEMO("EFdPxC{L'"), a5.field_22789 / 2 - 100, a5.field_22790 / 2 - 90, 16777215);
        super.method_25394((class_332)addAltScreen, (int)a, (int)a2, (float)a3);
    }
}
