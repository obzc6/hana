/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_350
 *  net.minecraft.class_350$class_351
 *  net.minecraft.class_364
 *  net.minecraft.class_4265
 *  net.minecraft.class_4265$class_4266
 *  net.minecraft.class_6379
 *  org.jetbrains.annotations.Nullable
 */
package dev.recollect.hana.mod.gui.nullpoint.alts;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.managers.AltManager;
import dev.recollect.hana.mod.gui.nullpoint.alts.AltScreen;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_156;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_350;
import net.minecraft.class_364;
import net.minecraft.class_4265;
import net.minecraft.class_6379;
import org.jetbrains.annotations.Nullable;

public class AltSelectionList
extends class_4265<Entry> {
    private final AltScreen owner;
    private final List<NormalEntry> altList;

    /*
     * WARNING - void declaration
     */
    public AltSelectionList(AltScreen altScreen, class_310 class_3102, int n, int n2, int n3, int n4) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        int n5 = n4;
        AltSelectionList a7 = this;
        super((class_310)a4, (int)a2, (int)a5, (int)a, (int)a6);
        AltSelectionList altSelectionList = a7;
        a7.altList = new ArrayList<NormalEntry>();
        a7.owner = a3;
    }

    public void setSelected(@Nullable Entry entry) {
        AltSelectionList altSelectionList = object;
        Object object = entry;
        AltSelectionList a = altSelectionList;
        super.method_25313((class_350.class_351)object);
    }

    private /* synthetic */ void setList() {
        AltSelectionList a;
        a.altList.forEach(class_3512 -> {
            AltSelectionList a = class_3512;
            AltSelectionList a2 = a;
            a2.method_25321((class_350.class_351)a);
        });
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25404(int n, int n2, int n3) {
        void a;
        void a2;
        void a3;
        AltSelectionList altSelectionList = this;
        Object a4 = (Entry)altSelectionList.method_25334();
        return a4 != null && a4.method_25404((int)a, (int)a3, (int)a2) || super.method_25404((int)a, (int)a3, (int)a2);
    }

    public void updateAlts() {
        Object a;
        Iterator<Alt> iterator;
        AltSelectionList altSelectionList = a;
        altSelectionList.method_25339();
        Iterator<Alt> iterator2 = iterator = Hana.ALT.getAlts().iterator();
        while (iterator2.hasNext()) {
            a = iterator.next();
            AltSelectionList altSelectionList2 = altSelectionList;
            a = new NormalEntry(altSelectionList2, altSelectionList2.owner, (Alt)a);
            iterator2 = iterator;
            altSelectionList.altList.add((NormalEntry)((Object)a));
        }
        altSelectionList.setList();
    }

    public class NormalEntry
    extends Entry {
        private final Alt alt;
        private final class_310 mc;
        private long lastClickTime;
        private final AltScreen owner;
        final /* synthetic */ AltSelectionList this$0;

        public Alt getAltData() {
            NormalEntry a;
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
            NormalEntry a5 = this;
            if (a2 != false) {
                void a6;
                void a7;
                void v0 = a;
                a3.method_25294((int)v0, a4, (int)(v0 + a7), a4 + a6, new Color(255, 255, 255, 100).getRGB());
            }
            class_327 a8 = a5.mc.field_1772;
            a3.method_25303(a8, "Username: " + a5.alt.getEmail(), (int)(a + 32 + 3), a4 + 2, 16777215);
            a3.method_25303(a8, "Username: " + a5.alt.getEmail(), (int)(a + 32 + 3), a4 + 2, 16777215);
        }

        /*
         * WARNING - void declaration
         */
        public boolean method_25402(double d, double d2, int n) {
            void v0;
            void a;
            int n2 = n;
            NormalEntry a2 = this;
            a -= (double)a2.this$0.method_25342();
            if (v0 <= 32.0 && a < 32.0 && a > 16.0) {
                NormalEntry normalEntry = a2;
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
        protected NormalEntry(AltSelectionList altSelectionList, AltScreen altScreen, Alt alt) {
            void a;
            NormalEntry a2;
            void a3;
            Object a4 = alt;
            NormalEntry normalEntry = a2 = this;
            a2.this$0 = a;
            normalEntry.owner = a3;
            normalEntry.alt = a4;
            normalEntry.mc = class_310.method_1551();
        }

        public List<? extends class_364> method_25396() {
            return Collections.emptyList();
        }
    }

    public static abstract class Entry
    extends class_4265.class_4266<Entry> {
        public Entry() {
            Entry a;
        }
    }

}
