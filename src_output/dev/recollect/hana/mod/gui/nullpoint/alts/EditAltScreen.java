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
 *  net.minecraft.class_4286
 *  net.minecraft.class_437
 */
package dev.recollect.hana.mod.gui.nullpoint.alts;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.AltManager;
import dev.recollect.hana.mod.gui.nullpoint.alts.AltScreen;
import dev.recollect.hana.socket.network.client.SocketClient;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_4286;
import net.minecraft.class_437;
import org.bytedeco.javacv.BaseChildSettings;

public class EditAltScreen
extends class_437 {
    private class_342 textFieldAltUsername;
    private final AltScreen parent;
    private class_4185 buttonSaveAlt;
    private final Alt alt;
    private class_4286 toggleMicrosoft;

    public void method_25426() {
        EditAltScreen a;
        super.method_25426();
        EditAltScreen editAltScreen = a;
        a.textFieldAltUsername = new class_342(editAltScreen.field_22793, editAltScreen.field_22789 / 2 - 100, a.field_22790 / 2 - 76, 200, 20, class_2561.method_30163((String)SocketClient.ALLATORIxDEMO("hfH|Y.eoM`")));
        a.textFieldAltUsername.method_1852(a.alt == null ? "" : a.alt.getEmail());
        EditAltScreen editAltScreen2 = a;
        editAltScreen2.method_37063((class_364)a.textFieldAltUsername);
        editAltScreen2.buttonSaveAlt = class_4185.method_46430((class_2561)class_2561.method_30163((String)BaseChildSettings.ALLATORIxDEMO("(n\fk\\I\u0014x")), class_41852 -> {
            EditAltScreen a = class_41852;
            EditAltScreen a2 = this;
            a2.onButtonAltEditPressed();
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 24, 200, 20).method_46431();
        editAltScreen2.method_37063((class_364)editAltScreen2.buttonSaveAlt);
        EditAltScreen editAltScreen3 = a;
        editAltScreen3.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)SocketClient.ALLATORIxDEMO("hoEmEi")), class_41852 -> {
            EditAltScreen a = class_41852;
            EditAltScreen a2 = this;
            a2.onButtonCancelPressed();
        }).method_46434(a.field_22789 / 2 - 100, a.field_22790 / 2 + 46, 200, 20).method_46431());
    }

    private /* synthetic */ void onButtonAltEditPressed() {
        EditAltScreen a;
        EditAltScreen editAltScreen = a;
        a.alt.setEmail(editAltScreen.textFieldAltUsername.method_1882());
        Hana.ALT.saveAlts();
        editAltScreen.parent.refreshAltList();
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        void a3;
        EditAltScreen a4 = class_3322;
        EditAltScreen a5 = this;
        EditAltScreen editAltScreen = a4;
        editAltScreen.method_25300(a5.field_22793, BaseChildSettings.ALLATORIxDEMO("n;S:\u0006\u0013M!O,\u0004\bm[N\u001ej\u0018v\u0014z"), a5.field_22789 / 2, 20, 16777215);
        editAltScreen.method_25303(a5.field_22793, SocketClient.ALLATORIxDEMO("]O|Y`JcE?"), a5.field_22789 / 2 - 100, a5.field_22790 / 2 - 90, 16777215);
        super.method_25394((class_332)a4, (int)a3, (int)a, (float)a2);
    }

    /*
     * WARNING - void declaration
     */
    public EditAltScreen(AltScreen altScreen, Alt alt) {
        EditAltScreen a;
        void a2;
        Object a3 = alt;
        EditAltScreen editAltScreen = a = this;
        super(class_2561.method_30163((String)BaseChildSettings.ALLATORIxDEMO("GK'\u0000\u0019F=[)\u0015v")));
        editAltScreen.parent = a2;
        editAltScreen.alt = a3;
    }

    public void onButtonCancelPressed() {
        EditAltScreen a;
        EditAltScreen editAltScreen = a;
        editAltScreen.field_22787.method_1507((class_437)editAltScreen.parent);
    }
}
