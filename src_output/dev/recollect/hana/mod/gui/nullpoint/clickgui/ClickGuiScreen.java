/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1041
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.NewSnow;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_1041;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.bytedeco.javacv.FrameFilter;

public class ClickGuiScreen
extends class_437
implements Wrapper {
    public static boolean MOUSE_BUTTON_5;
    public int xPlus;
    public static boolean clicked;
    public static boolean hoverClicked;
    private final class_2960 little;
    public static boolean MOUSE_BUTTON_4;
    private final class_2960 madcat;
    private final class_2960 gun;
    public static boolean rightClicked;
    private final ArrayList<Snow> snow;
    private final ArrayList<NewSnow> newsnow;
    public Timer byd;

    public void method_25419() {
        ClickGuiScreen a;
        super.method_25419();
        rightClicked = false;
        hoverClicked = false;
        MOUSE_BUTTON_4 = false;
        MOUSE_BUTTON_5 = false;
        clicked = false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25402(double d, double d2, int n) {
        ClickGuiScreen clickGuiScreen;
        void a;
        void a2;
        void a3;
        int n2 = n;
        ClickGuiScreen a4 = this;
        if (a == false) {
            hoverClicked = false;
            clicked = true;
            clickGuiScreen = a4;
        } else if (a == true) {
            rightClicked = true;
            clickGuiScreen = a4;
        } else if (a == 3) {
            MOUSE_BUTTON_4 = true;
            clickGuiScreen = a4;
        } else {
            if (a == 4) {
                MOUSE_BUTTON_5 = true;
            }
            clickGuiScreen = a4;
        }
        return super.method_25402((double)a3, (double)a2, (int)a);
    }

    public void method_49589() {
        ClickGuiScreen a;
        int n;
        Object object;
        ClickGuiScreen clickGuiScreen;
        ClickGuiScreen clickGuiScreen2 = clickGuiScreen = a;
        super.method_49589();
        clickGuiScreen2.snow.clear();
        Random random = new Random();
        int n2 = n = 0;
        while (n2 < 100) {
            int n3 = a = 0;
            while (n3 < 3) {
                object = new Snow(25 * n, a * -50, random.nextInt(3) + 1, random.nextInt(2) + 1);
                clickGuiScreen.snow.add((Snow)object);
                n3 = ++a;
            }
            n2 = ++n;
        }
        clickGuiScreen.newsnow.clear();
        int n4 = n = 0;
        while (n4 < 100) {
            int n5 = a = 0;
            while (n5 < 3) {
                object = 25 * n;
                int n6 = a * -50;
                Random random2 = random;
                int n7 = random2.nextInt(3) + 1;
                int n8 = random2.nextInt(3) - 1;
                int n9 = random2.nextInt(2) + 1;
                NewSnow newSnow = new NewSnow((int)object, n6, n7, n9, n8);
                clickGuiScreen.newsnow.add(newSnow);
                n5 = ++a;
            }
            n4 = ++n;
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25401(double d, double d2, double d3, double d4) {
        Object a;
        void a2;
        void a3;
        void a4;
        void a5;
        ClickGuiScreen clickGuiScreen = this;
        Object object = a = Hana.GUI.tabs.iterator();
        while (object.hasNext()) {
            Tab tab = (Tab)a.next();
            object = a;
            Tab tab2 = tab;
            tab2.setY((int)((double)tab2.getY() + a3 * 30.0));
        }
        return super.method_25401((double)a5, (double)a2, (double)a4, (double)a3);
    }

    private static /* synthetic */ void lambda$render$1(class_332 class_3322, NewSnow newSnow) {
        NewSnow a = newSnow;
        class_332 a2 = class_3322;
        a.drawNewSnow(a2);
    }

    static {
        clicked = false;
        rightClicked = false;
        hoverClicked = false;
        MOUSE_BUTTON_4 = false;
        MOUSE_BUTTON_5 = false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25406(double d, double d2, int n) {
        ClickGuiScreen clickGuiScreen;
        void a;
        void a2;
        void a3;
        int n2 = n;
        ClickGuiScreen a4 = this;
        if (a == false) {
            clicked = false;
            hoverClicked = false;
            clickGuiScreen = a4;
        } else if (a == true) {
            rightClicked = false;
            clickGuiScreen = a4;
        } else if (a == 3) {
            MOUSE_BUTTON_4 = false;
            clickGuiScreen = a4;
        } else {
            if (a == 4) {
                MOUSE_BUTTON_5 = false;
            }
            clickGuiScreen = a4;
        }
        return super.method_25406((double)a3, (double)a2, (int)a);
    }

    public boolean method_25421() {
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25404(int n, int n2, int n3) {
        void a;
        void a2;
        int a3 = n;
        ClickGuiScreen a4 = this;
        Hana.MODULE.modules.forEach(module -> {
            Module a2 = module;
            int a3 = a3;
            a2.getSettings().stream().filter(a -> a instanceof StringSetting).map(a -> (StringSetting)a).filter(StringSetting::isListening).forEach(stringSetting -> {
                StringSetting a = stringSetting;
                int a2 = a3;
                a.keyType(a2);
            });
        });
        return super.method_25404(a3, (int)a2, (int)a);
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        void a3;
        ClickGuiScreen a4 = class_3322;
        ClickGuiScreen a5 = this;
        super.method_25394((class_332)a4, (int)a3, (int)a, (float)a2);
        if (UIModule.INSTANCE.snow.getValue()) {
            a5.snow.forEach(arg_0 -> ClickGuiScreen.lambda$render$0((class_332)a4, arg_0));
        }
        if (UIModule.INSTANCE.newsnow.getValue()) {
            a5.newsnow.forEach(arg_0 -> ClickGuiScreen.lambda$render$1((class_332)a4, arg_0));
        }
        Hana.GUI.draw((int)a3, (int)a, (class_332)a4, (float)a2);
        if (a5.byd.passedMs(1L) && a5.xPlus <= 200) {
            ClickGuiScreen clickGuiScreen = a5;
            clickGuiScreen.xPlus += 4;
            clickGuiScreen.byd.reset();
        }
        if (UIModule.INSTANCE.showBYD.getValue()) {
            RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
            if (UIModule.INSTANCE.bydMode.getValue() == UIModule.BYDMode.gun) {
                a4.method_25290(a5.gun, mc.method_22683().method_4486() - a5.xPlus, mc.method_22683().method_4502() - 260, 0.0f, 0.0f, 220, 220, 220, 220);
            }
            if (UIModule.INSTANCE.bydMode.getValue() == UIModule.BYDMode.madcat) {
                a4.method_25290(a5.madcat, mc.method_22683().method_4486() - a5.xPlus, mc.method_22683().method_4502() - 260, 0.0f, 0.0f, 220, 220, 220, 220);
            }
            if (UIModule.INSTANCE.bydMode.getValue() == UIModule.BYDMode.little) {
                a4.method_25290(a5.little, mc.method_22683().method_4486() - a5.xPlus, mc.method_22683().method_4502() - 260, 0.0f, 0.0f, 220, 220, 220, 220);
            }
        }
    }

    private static /* synthetic */ void lambda$render$0(class_332 class_3322, Snow snow) {
        Snow a = snow;
        class_332 a2 = class_3322;
        a.drawSnow(a2);
    }

    public ClickGuiScreen() {
        ClickGuiScreen a;
        ClickGuiScreen clickGuiScreen = a;
        ClickGuiScreen clickGuiScreen2 = a;
        super(class_2561.method_30163((String)FrameFilter.ALLATORIxDEMO("\u0013m.u,Q9t")));
        ClickGuiScreen clickGuiScreen3 = a;
        a.snow = new ArrayList();
        clickGuiScreen3.newsnow = new ArrayList();
        clickGuiScreen2.byd = new Timer();
        clickGuiScreen.xPlus = 0;
        clickGuiScreen2.gun = new class_2960(TimerManager.ALLATORIxDEMO("\f7@}"), FrameFilter.ALLATORIxDEMO("f2xif\"z"));
        clickGuiScreen.madcat = new class_2960(TimerManager.ALLATORIxDEMO("\f7@}"), FrameFilter.ALLATORIxDEMO(",q4b&bif\"z"));
        clickGuiScreen.little = new class_2960(TimerManager.ALLATORIxDEMO("\f7@}"), FrameFilter.ALLATORIxDEMO("-y$u+sif\"z"));
    }
}
