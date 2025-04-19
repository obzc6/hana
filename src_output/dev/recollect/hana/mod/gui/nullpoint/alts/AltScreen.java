/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_350
 *  net.minecraft.class_350$class_351
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_437
 */
package dev.recollect.hana.mod.gui.nullpoint.alts;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.AltManager;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.mod.gui.nullpoint.alts.AddAltScreen;
import dev.recollect.hana.mod.gui.nullpoint.alts.AltSelectionList;
import dev.recollect.hana.mod.gui.nullpoint.alts.DirectLoginAltScreen;
import dev.recollect.hana.mod.gui.nullpoint.alts.EditAltScreen;
import dev.recollect.hana.mod.gui.nullpoint.alts.TokenLoginScreen;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_350;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;

public class AltScreen
extends class_437 {
    private AltSelectionList altListSelector;
    private final class_437 parentScreen;
    private class_4185 editButton;
    private class_4185 deleteButton;

    public void method_25426() {
        AltScreen a;
        AltScreen altScreen = a;
        super.method_25426();
        AltScreen altScreen2 = a;
        AltScreen altScreen3 = a;
        a.altListSelector = new AltSelectionList(altScreen3, altScreen2.field_22787, altScreen2.field_22789, altScreen3.field_22790, 32, a.field_22790 - 64);
        a.altListSelector.updateAlts();
        altScreen.method_37063((class_364)altScreen.altListSelector);
        altScreen.deleteButton = class_4185.method_46430((class_2561)class_2561.method_30163((String)NpSocketClient.ALLATORIxDEMO("O.v?y(-\fj2")), class_41852 -> {
            AltScreen a = class_41852;
            AltScreen a2 = this;
            a2.deleteSelected();
        }).method_46434(a.field_22789 / 2 - 154, a.field_22790 - 28, 100, 20).method_46431();
        AltScreen altScreen4 = a;
        a.deleteButton.field_22763 = false;
        altScreen4.method_37063((class_364)altScreen4.deleteButton);
        altScreen4.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)BOEntityUtils.ALLATORIxDEMO("XWdC6vy]t_")), class_41852 -> {
            AltScreen a = class_41852;
            AltScreen a2 = this;
            a2.field_22787.method_1507((class_437)new TokenLoginScreen(a2));
        }).method_46434(a.field_22789 / 2 - 154, a.field_22790 - 52, 100, 20).method_46431());
        AltScreen altScreen5 = a;
        altScreen5.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)NpSocketClient.ALLATORIxDEMO("\u0012y.y.-\u0001b*o(")), class_41852 -> {
            AltScreen a = class_41852;
            AltScreen a2 = this;
            a2.field_22787.method_1507((class_437)new DirectLoginAltScreen(a2));
        }).method_46434(a.field_22789 / 2 - 50, a.field_22790 - 52, 100, 20).method_46431());
        AltScreen altScreen6 = a;
        altScreen6.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)BOEntityUtils.ALLATORIxDEMO("lr^6{qE")), class_41852 -> {
            AltScreen a = class_41852;
            AltScreen a2 = this;
            a2.field_22787.method_1507((class_437)new AddAltScreen(a2));
        }).method_46434(a.field_22789 / 2 + 54, a.field_22790 - 52, 100, 20).method_46431());
        AltScreen altScreen7 = a;
        altScreen7.method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_30163((String)NpSocketClient.ALLATORIxDEMO("N,c.c*")), class_41852 -> {
            AltScreen a;
            AltScreen a2 = class_41852;
            AltScreen altScreen = a = this;
            altScreen.field_22787.method_1507(altScreen.parentScreen);
        }).method_46434(a.field_22789 / 2 + 54, a.field_22790 - 28, 100, 20).method_46431());
        a.editButton = class_4185.method_46430((class_2561)class_2561.method_30163((String)BOEntityUtils.ALLATORIxDEMO("DIN6{qE")), class_41852 -> {
            AltScreen a = class_41852;
            AltScreen a2 = this;
            a2.editSelected();
        }).method_46434(a.field_22789 / 2 - 50, a.field_22790 - 28, 100, 20).method_46431();
        AltScreen altScreen8 = a;
        altScreen8.editButton.field_22763 = false;
        altScreen8.method_37063((class_364)altScreen8.editButton);
    }

    public void loginToSelected() {
        Object a;
        AltScreen altScreen = a;
        a = (AltSelectionList.Entry)altScreen.altListSelector.method_25334();
        if (a == null) {
            return;
        }
        a = ((AltSelectionList.NormalEntry)((Object)a)).getAltData();
        Hana.ALT.loginCracked(((Alt)a).getEmail());
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        AltScreen a3;
        void a4;
        void a5;
        float f2 = f;
        AltScreen altScreen = a3 = this;
        void v1 = a5;
        void v2 = a2;
        a3.altListSelector.method_25394((class_332)a5, (int)v2, (int)a, (float)a4);
        super.method_25394((class_332)v1, (int)v2, (int)a, (float)a4);
        v1.method_25300(altScreen.field_22793, "Currently Logged Into: " + class_310.method_1551().method_1548().method_1676(), a3.field_22789 / 2, 20, 16777215);
    }

    protected void setEdittable() {
        AltScreen a;
        AltScreen altScreen = a;
        altScreen.editButton.field_22763 = true;
        altScreen.deleteButton.field_22763 = true;
    }

    public void refreshAltList() {
        AltScreen a;
        a.field_22787.method_1507((class_437)new AltScreen(a.parentScreen));
    }

    public AltScreen(class_437 class_4372) {
        AltScreen a = class_4372;
        AltScreen a2 = this;
        super(class_2561.method_30163((String)BOEntityUtils.ALLATORIxDEMO("M|H!`wTw]xC")));
        a2.parentScreen = a;
    }

    public void deleteSelected() {
        Object a;
        AltScreen altScreen = a;
        a = ((AltSelectionList.NormalEntry)altScreen.altListSelector.method_25334()).getAltData();
        if (a == null) {
            return;
        }
        Hana.ALT.removeAlt((Alt)a);
        altScreen.refreshAltList();
    }

    public void method_25419() {
        AltScreen a;
        AltScreen altScreen = a;
        altScreen.field_22787.method_1507(altScreen.parentScreen);
    }

    public void editSelected() {
        Object a;
        AltScreen altScreen = a;
        a = ((AltSelectionList.NormalEntry)altScreen.altListSelector.method_25334()).getAltData();
        if (a == null) {
            return;
        }
        altScreen.field_22787.method_1507((class_437)new EditAltScreen(altScreen, (Alt)a));
    }

    public void setSelected(AltSelectionList.Entry entry) {
        AltScreen a;
        Object a2 = entry;
        AltScreen altScreen = a = this;
        altScreen.altListSelector.setSelected((AltSelectionList.Entry)((Object)a2));
        altScreen.setEdittable();
    }
}
