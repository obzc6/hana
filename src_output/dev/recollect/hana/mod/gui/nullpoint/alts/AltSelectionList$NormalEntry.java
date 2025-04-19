/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_6379
 */
package dev.recollect.hana.mod.gui.nullpoint.alts;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.mod.gui.nullpoint.alts.AltScreen;
import dev.recollect.hana.mod.gui.nullpoint.alts.AltSelectionList;
import java.awt.Color;
import java.util.Collections;
import java.util.List;
import net.minecraft.class_156;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_6379;

public class AltSelectionList.NormalEntry
extends AltSelectionList.Entry {
    private final Alt alt;
    private final class_310 mc;
    private long lastClickTime;
    private final AltScreen owner;
    final /* synthetic */ AltSelectionList this$0;

    public Alt getAltData() {
        AltSelectionList.NormalEntry a;
        return a.alt;
    }

    public List<? extends class_6379> method_37025() {
        return Collections.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    public void method_25343(class_332 class_3322, int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, float f) {
        void a;
        void a2;
        void a3;
        int a4 = n2;
        AltSelectionList.NormalEntry a5 = this;
        if (a3 != false) {
            void a6;
            void a7;
            void v0 = a;
            a2.method_25294((int)v0, a4, (int)(v0 + a7), a4 + a6, new Color(255, 255, 255, 100).getRGB());
        }
        class_327 a8 = a5.mc.field_1772;
        a2.method_25303(a8, "Username: " + a5.alt.getEmail(), (int)(a + 32 + 3), a4 + 2, 16777215);
        a2.method_25303(a8, "Username: " + a5.alt.getEmail(), (int)(a + 32 + 3), a4 + 2, 16777215);
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25402(double d, double d2, int n) {
        void a;
        void v0;
        int n2 = n;
        AltSelectionList.NormalEntry a2 = this;
        a -= (double)a2.this$0.method_25342();
        if (v0 <= 32.0 && a < 32.0 && a > 16.0) {
            AltSelectionList.NormalEntry normalEntry = a2;
            a2.owner.setSelected(normalEntry);
            normalEntry.owner.loginToSelected();
            return true;
        }
        a2.owner.setSelected(a2);
        if (class_156.method_658() - a2.lastClickTime < 250L) {
            a2.owner.loginToSelected();
        }
        a2.lastClickTime = class_156.method_658();
        return false;
    }

    /*
     * WARNING - void declaration
     */
    protected AltSelectionList.NormalEntry(AltSelectionList altSelectionList, AltScreen altScreen, Alt alt) {
        AltSelectionList.NormalEntry a;
        void a2;
        void a3;
        Object a4 = alt;
        AltSelectionList.NormalEntry normalEntry = a = this;
        a.this$0 = a3;
        normalEntry.owner = a2;
        normalEntry.alt = a4;
        normalEntry.mc = class_310.method_1551();
    }

    public List<? extends class_364> method_25396() {
        return Collections.emptyList();
    }
}
