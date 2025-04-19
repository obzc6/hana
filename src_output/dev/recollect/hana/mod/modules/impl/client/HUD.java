/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_124
 *  net.minecraft.class_1291
 *  net.minecraft.class_1292
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_5321
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_8921
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.managers.ServerManager;
import dev.recollect.hana.api.managers.SpeedManager;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.gui.nullpoint.elements.ArmorHUD;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.video.Renderer;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.class_1041;
import net.minecraft.class_124;
import net.minecraft.class_1291;
import net.minecraft.class_1292;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_5321;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_8921;
import org.jetbrains.annotations.NotNull;

public class HUD
extends Module {
    public static HUD INSTANCE = new HUD();
    private final SliderSetting waterMarkY;
    private final BooleanSetting potiontext;
    private final BooleanSetting pvphud;
    private final BooleanSetting time;
    private final StringSetting greeterText;
    public final SliderSetting offset;
    private final ColorSetting color;
    private final BooleanSetting lag;
    private final SliderSetting updatedelay;
    private final SliderSetting saturation;
    public final BooleanSetting armor;
    public final StringSetting watermarkString;
    private final EnumSetting colorMode;
    private final Timer timer;
    private final BooleanSetting grayColors;
    private final BooleanSetting fps;
    private final SliderSetting rainbowDelay;
    private final BooleanSetting health;
    private final BooleanSetting textRadar;
    private int counter;
    private final EnumSetting<GreeterMode> greeterMode;
    public final BooleanSetting lowerCase;
    private final BooleanSetting renderingUp;
    private final BooleanSetting watermark;
    private final BooleanSetting greeterNameColor;
    private final BooleanSetting speed;
    private final EnumSetting<Page> page;
    private final BooleanSetting idWatermark;
    private final BooleanSetting tps;
    private final BooleanSetting potionColor;
    public final SliderSetting lagTime;
    private Map<String, Integer> players;
    private final BooleanSetting coords;
    private final BooleanSetting greeter;
    private final BooleanSetting potions;
    private final BooleanSetting watermarkShort;
    public final BooleanSetting tabGui;
    int pulseProgress;
    private final BooleanSetting sync;
    private final SliderSetting pulseSpeed;
    int progress;
    private final BooleanSetting watermarkVerColor;
    private final BooleanSetting ping;
    private final BooleanSetting direction;
    private final SliderSetting rainbowSpeed;
    private final BooleanSetting totemtext;
    public final SliderSetting pvphudoffset;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawpvphud(class_332 class_3322, int n) {
        void a;
        int a2;
        HUD hUD = this;
        double d = (double)mc.method_22683().method_4480() / 4.0;
        double d2 = (double)mc.method_22683().method_4507() / 4.0 + (double)a2;
        Objects.requireNonNull(HUD.mc.field_1772);
        a2 = 9 + 1;
        String string = "Totem " + String.valueOf((Object)class_124.field_1068) + InventoryUtil.getItemCount(class_1802.field_8288);
        Object a32 = "Potion " + String.valueOf((Object)class_124.field_1068) + InventoryUtil.getPotCount(class_1294.field_5907);
        ArrayList arrayList = new ArrayList(HUD.mc.field_1724.method_6026());
        if (hUD.totemtext.getValue()) {
            HUD hUD2 = hUD;
            a.method_25303(HUD.mc.field_1772, string, (int)(d - (double)(HUD.mc.field_1772.method_1727(string) / 2)), (int)d2, hUD2.getColor(hUD2.counter));
            ++hUD.counter;
            d2 += (double)a2;
        }
        if (hUD.potiontext.getValue()) {
            HUD hUD3 = hUD;
            a.method_25303(HUD.mc.field_1772, (String)a32, (int)(d - (double)(HUD.mc.field_1772.method_1727((String)a32) / 2)), (int)d2, hUD3.getColor(hUD3.counter));
            ++hUD.counter;
            d2 += (double)a2;
        }
        for (Object a32 : arrayList) {
            if (a32.method_5579() != class_1294.field_5907 || a32.method_5578() + 1 <= 1) continue;
            a32 = hUD.getColoredPotionTimeString((class_1293)a32);
            a32 = "PotionTime " + String.valueOf((Object)class_124.field_1068) + (String)a32;
            if (!hUD.potiontext.getValue()) continue;
            HUD hUD4 = hUD;
            a.method_25303(HUD.mc.field_1772, (String)a32, (int)(d - (double)(HUD.mc.field_1772.method_1727((String)a32) / 2)), (int)d2, hUD4.getColor(hUD4.counter));
            ++hUD.counter;
            d2 += (double)a2;
        }
    }

    private /* synthetic */ int getColor(int n) {
        int a = n;
        HUD a2 = this;
        if (a2.colorMode.getValue() != ColorMode.Custom) {
            return a2.rainbow(a).getRGB();
        }
        if (a2.sync.getValue()) {
            return UIModule.INSTANCE.color.getValue().getRGB();
        }
        return a2.color.getValue().getRGB();
    }

    private /* synthetic */ String getColoredPotionTimeString(class_1293 class_12932) {
        HUD a = class_12932;
        HUD a2 = this;
        return class_1292.method_5577((class_1293)a, (float)1.0f, (float)HUD.mc.field_1687.method_54719().method_54748()).getString();
    }

    private /* synthetic */ void drawWelcomer(class_332 a) {
        Object a2;
        Object object;
        HUD hUD = a2;
        int n = mc.method_22683().method_4486();
        a2 = hUD.greeterNameColor.getValue() ? String.valueOf((Object)class_124.field_1068) : "";
        Object object2 = object = hUD.lowerCase.getValue() ? NCPRaytracer.ALLATORIxDEMO("g \u0006@cSt\u0003 ").toLowerCase() : FPSManager.ALLATORIxDEMO("+s\u001cw\u001dq\u001f'M");
        if (hUD.greeterMode.getValue() == GreeterMode.PLAYER) {
            if (hUD.greeter.getValue()) {
                object = (String)object + (String)a2 + mc.method_1548().method_1676();
            }
            HUD hUD2 = hUD;
            a.method_25303(HUD.mc.field_1772, (String)object + "\u00a70 :')", (int)((float)n / 2.0f - (float)HUD.mc.field_1772.method_1727((String)object) / 2.0f + 2.0f), 2, hUD2.getColor(hUD2.counter));
            ++hUD.counter;
            return;
        }
        HUD hUD3 = hUD;
        a2 = hUD3.greeterText.getValue();
        if (hUD3.greeter.getValue()) {
            a2 = hUD.greeterText.getValue();
        }
        Object object3 = a2;
        HUD hUD4 = hUD;
        a.method_25303(HUD.mc.field_1772, (String)object3, (int)((float)n / 2.0f - (float)HUD.mc.field_1772.method_1727((String)object3) / 2.0f + 2.0f), 2, hUD4.getColor(hUD4.counter));
        ++hUD.counter;
    }

    private /* synthetic */ String getColoredPotionString(class_1293 class_12932) {
        HUD a = class_12932;
        HUD a2 = this;
        return a.method_5579().method_5560().getString() + " " + (a.method_5578() + 1) + " \u00a7f" + class_1292.method_5577((class_1293)a, (float)1.0f, (float)HUD.mc.field_1687.method_54719().method_54748()).getString();
    }

    public static float round2(double a) {
        return new BigDecimal(a).setScale(1, RoundingMode.HALF_UP).floatValue();
    }

    public HUD() {
        HUD a;
        HUD hUD = a;
        super(NCPRaytracer.ALLATORIxDEMO("YzD"), FPSManager.ALLATORIxDEMO("yO85\u0016|\u0013q\u001fy\u0005~K3CP BjR5eZ\u0003eQc\u0015\u000e\"O"), Module.Category.Client);
        HUD hUD2 = a;
        hUD2.page = hUD.add(new EnumSetting<Page>(NCPRaytracer.ALLATORIxDEMO("npHe"), Page.GLOBAL));
        hUD.armor = hUD.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("7\u0006(S"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.GLOBAL;
        }));
        a.tabGui = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("wm\\VZi"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.GLOBAL;
        }));
        a.lagTime = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("=q\u0011Y\u0002*D"), 1000, 0, 2000, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.GLOBAL;
        }));
        a.lowerCase = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("|*\u001dF~}p\\e"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.GLOBAL;
        }));
        a.grayColors = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("J\u0019&X"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.GLOBAL;
        }));
        a.renderingUp = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("xz^!\u000fQePvzp"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.GLOBAL;
        }));
        a.watermark = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("!v\u0005u\u0004`\n5J"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }).setParent());
        a.offset = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("ljXbJt"), 8.0, 0.0, 300.0, -1.0, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.watermark.isOpen() && a2.page.getValue() == Page.ELEMENTS;
        }));
        a.watermarkString = a.add(new StringSetting(FPSManager.ALLATORIxDEMO("Y\u000e?U"), NCPRaytracer.ALLATORIxDEMO("\u2763D_N\u2740"), object -> {
            Object a = object;
            HUD a2 = this;
            return a2.watermark.isOpen() && a2.page.getValue() == Page.ELEMENTS;
        }));
        a.watermarkShort = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("\"x\u0019\u001f\"O"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.watermark.isOpen() && a2.page.getValue() == Page.ELEMENTS;
        }));
        a.watermarkVerColor = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("\u0013\u000fQOQ}@r"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.watermark.isOpen() && a2.page.getValue() == Page.ELEMENTS;
        }));
        a.waterMarkY = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("X\u0013d\f/U"), 2, 2, 12, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.watermark.isOpen();
        }));
        a.idWatermark = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("c{g$\u001eF~Sp]k"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.textRadar = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("\"r\td$l\u000f&S"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }).setParent());
        a.updatedelay = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("oT$\u001eFH[}Ny"), 5, 0, 1000, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.textRadar.isOpen();
        }));
        a.health = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("X\u0013l\u00073I"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.textRadar.isOpen();
        }));
        a.coords = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("qjYvD,\u0005M$fHu)"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.direction = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("2~\u0003u\u0015y\u0002(O"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.lag = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("f~W\u000b\u0005WeXxJr"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.greeter = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("@\u0014|\u0015b\u0006\"S"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }).setParent());
        a.greeterMode = a.add(new EnumSetting<GreeterMode>(NCPRaytracer.ALLATORIxDEMO("s~Ke"), GreeterMode.PLAYER, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.greeter.isOpen();
        }));
        a.greeterNameColor = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("8v\u001cu5b\u0007(S"), true, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.greeter.isOpen() && a2.greeterMode.getValue() == GreeterMode.PLAYER && a2.page.getValue() == Page.ELEMENTS;
        }));
        a.greeterText = a.add(new StringSetting(NCPRaytracer.ALLATORIxDEMO("ROsS*\u0007F~jtWt"), FPSManager.ALLATORIxDEMO("X0\u0005z\u001bo\t5\u00108Z\\t\u001dtVo\u0017x\u001ahK3^A2\f#\u001d<*W0D7\u0019q\u0014o\u00023R"), object -> {
            Object a = object;
            HUD a2 = this;
            return a2.greeter.isOpen() && a2.greeterMode.getValue() == GreeterMode.CUSTOM && a2.page.getValue() == Page.ELEMENTS;
        }));
        a.potions = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO(":LxW~As"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }).setParent());
        a.potionColor = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("s\u0002~\u001e~5b\u0007(S"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.potions.isOpen();
        }));
        a.pvphud = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("sZnYZd"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }).setParent());
        a.pvphudoffset = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("\u0015u@>B5_\u0010k\u0018\"U"), 8.0, 0.0, 100.0, -1.0, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.pvphud.isOpen();
        }));
        a.totemtext = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("d*\u001eFajtWt"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.pvphud.isOpen();
        }));
        a.potiontext = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("@\u0019c\u0018\u0018Y\u000e?U"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS && a2.pvphud.isOpen();
        }));
        a.ping = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("nxAg"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.speed = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("%}\u000e\"E"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.tps = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("ES"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.fps = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("-\u0017r"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.time = a.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("jxBe"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.ELEMENTS;
        }));
        a.colorMode = a.add(new EnumSetting<ColorMode>(FPSManager.ALLATORIxDEMO("5x\u001d\u0004@\u0004#D"), ColorMode.Pulse, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.rainbowSpeed = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("WKv^'\u0005T_NtJd"), 200, 1, 400, object -> {
            Object a = object;
            HUD a2 = this;
            return (a2.colorMode.getValue() == ColorMode.Rainbow || a2.colorMode.getValue() == ColorMode.PulseRainbow) && a2.page.getValue() == Page.Color;
        }));
        a.saturation = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("C\u0017c\u0004b\u0017y\u0002(O"), 130.0, 1.0, 255.0, object -> {
            Object a = object;
            HUD a2 = this;
            return (a2.colorMode.getValue() == ColorMode.Rainbow || a2.colorMode.getValue() == ColorMode.PulseRainbow) && a2.page.getValue() == Page.Color;
        }));
        a.pulseSpeed = a.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("OE)\u0019F_NtJd"), 100, 1, 400, object -> {
            Object a = object;
            HUD a2 = this;
            return (a2.colorMode.getValue() == ColorMode.Pulse || a2.colorMode.getValue() == ColorMode.PulseRainbow) && a2.page.getValue() == Page.Color;
        }));
        a.rainbowDelay = a.add(new SliderSetting(FPSManager.ALLATORIxDEMO("2h\u0007&X"), 350, 0, 600, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.colorMode.getValue() == ColorMode.Rainbow && a2.page.getValue() == Page.Color;
        }));
        a.color = a.add(new ColorSetting(NCPRaytracer.ALLATORIxDEMO("OQ}@r"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            HUD a2 = this;
            return a2.colorMode.getValue() != ColorMode.Rainbow && a2.page.getValue() == Page.Color;
        }));
        a.sync = a.add(new BooleanSetting(FPSManager.ALLATORIxDEMO("^\u0012)B"), false, object -> {
            Object a = object;
            HUD a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        HUD hUD3 = a;
        HUD hUD4 = a;
        HUD hUD5 = a;
        hUD5.timer = new Timer();
        hUD5.players = new HashMap<String, Integer>();
        hUD4.counter = 20;
        hUD4.progress = 0;
        hUD3.pulseProgress = 0;
        hUD3.setChinese(NCPRaytracer.ALLATORIxDEMO("\u7563\u9762"));
        INSTANCE = hUD3;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void drawTextRadar(class_332 class_3322, int n) {
        int a = n;
        HUD a2 = this;
        if (!a2.players.isEmpty()) {
            Objects.requireNonNull(HUD.mc.field_1772);
            a = 9 + 7 + a;
            Iterator<Map.Entry<String, Integer>> iterator = a2.players.entrySet().iterator();
            Iterator<Map.Entry<String, Integer>> iterator2 = iterator;
            while (iterator2.hasNext()) {
                void a3;
                String string = iterator.next().getKey() + " ";
                Objects.requireNonNull(HUD.mc.field_1772);
                int n2 = 9 + 1;
                HUD hUD = a2;
                a3.method_25303(HUD.mc.field_1772, string, 2, a, hUD.getColor(hUD.counter));
                ++a2.counter;
                a += n2;
                iterator2 = iterator;
            }
        }
    }

    private /* synthetic */ Map<String, Integer> getTextRadarMap() {
        HUD a;
        HUD hUD = a;
        Map<String, Integer> map = new HashMap<String, Integer>();
        DecimalFormat decimalFormat = new DecimalFormat(NCPRaytracer.ALLATORIxDEMO("2\u0001#"));
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = HUD.mc.field_1687.method_18456().iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                StringBuilder stringBuilder2;
                a = (class_1657)iterator.next();
                if (a.method_5767()) continue block0;
                if (a.method_5477().equals((Object)HUD.mc.field_1724.method_5477())) {
                    iterator2 = iterator;
                    continue;
                }
                int n = (int)HUD.mc.field_1724.method_5739((class_1297)a);
                String string = decimalFormat.format(n);
                if (n >= 25) {
                    StringBuilder stringBuilder3 = stringBuilder;
                    stringBuilder2 = stringBuilder3;
                    stringBuilder3.append((Object)class_124.field_1060);
                } else if (n > 10) {
                    StringBuilder stringBuilder4 = stringBuilder;
                    stringBuilder2 = stringBuilder4;
                    stringBuilder4.append((Object)class_124.field_1054);
                } else {
                    StringBuilder stringBuilder5 = stringBuilder;
                    stringBuilder2 = stringBuilder5;
                    stringBuilder5.append((Object)class_124.field_1061);
                }
                stringBuilder2.append(string);
                map.put((String)(hUD.health.getValue() ? String.valueOf((Object)hUD.getHealthColor((class_1657)a)) + String.valueOf(HUD.round2(a.method_6067() + a.method_6032())) + " " : "") + String.valueOf((Object)(Hana.FRIEND.isFriend((class_1657)a) ? class_124.field_1075 : class_124.field_1070)) + a.method_5477().getString() + " " + String.valueOf((Object)class_124.field_1068) + "[" + String.valueOf((Object)class_124.field_1070) + String.valueOf(stringBuilder) + "m" + String.valueOf((Object)class_124.field_1068) + "] " + String.valueOf((Object)class_124.field_1060), (int)HUD.mc.field_1724.method_5739((class_1297)a));
                stringBuilder.setLength(0);
                iterator2 = iterator;
            }
            break;
        } while (true);
        if (!map.isEmpty()) {
            map = MathUtil.sortByValue(map, false);
        }
        return map;
    }

    private /* synthetic */ class_124 getHealthColor(@NotNull class_1657 class_16572) {
        HUD hUD = hUD2;
        HUD hUD2 = class_16572;
        HUD a = hUD;
        int this2 = (int)((float)((int)hUD2.method_6032()) + hUD2.method_6067());
        if (this2 <= 15 && this2 > 7) {
            return class_124.field_1054;
        }
        if (this2 > 15) {
            return class_124.field_1060;
        }
        return class_124.field_1061;
    }

    private /* synthetic */ Color rainbow(int n) {
        HUD a;
        int a2 = n;
        HUD hUD = a = this;
        double d = Math.ceil(((double)hUD.progress + (double)a2 * a.rainbowDelay.getValue()) / 20.0);
        if (hUD.colorMode.getValue() == ColorMode.Pulse) {
            if (a.sync.getValue()) {
                return a.pulseColor(UIModule.INSTANCE.color.getValue(), a2);
            }
            HUD hUD2 = a;
            return hUD2.pulseColor(hUD2.color.getValue(), a2);
        }
        if (a.colorMode.getValue() == ColorMode.Rainbow) {
            return Color.getHSBColor((float)(d % 360.0 / 360.0), a.saturation.getValueFloat() / 255.0f, 1.0f);
        }
        return a.pulseColor(Color.getHSBColor((float)(d % 360.0 / 360.0), a.saturation.getValueFloat() / 255.0f, 1.0f), a2);
    }

    private /* synthetic */ Color pulseColor(Color a, int a22) {
        float[] a3;
        float[] arrf = a3;
        a3 = new float[3];
        Color.RGBtoHSB(a.getRed(), a.getGreen(), a.getBlue(), a3);
        float a22 = Math.abs(((float)((long)arrf.pulseProgress % 2000L) / Float.intBitsToFloat(Float.floatToIntBits(0.0013786979f) ^ 2127476077) + (float)a22 / 14.0f * Float.intBitsToFloat(Float.floatToIntBits(0.09192204f) ^ 2109489567)) % Float.intBitsToFloat(Float.floatToIntBits(0.7858098f) ^ 2135501525) - Float.intBitsToFloat(Float.floatToIntBits(6.46708f) ^ 2135880274));
        a22 = Float.intBitsToFloat(Float.floatToIntBits(18.996923f) ^ 2123889075) + Float.intBitsToFloat(Float.floatToIntBits(2.7958195f) ^ 2134044341) * a22;
        a3[2] = a22 % Float.intBitsToFloat(Float.floatToIntBits(0.8992331f) ^ 2137404452);
        return ColorUtil.injectAlpha(new Color(Color.HSBtoRGB(a3[0], a3[1], a3[2])), a.getAlpha());
    }

    private /* synthetic */ void drawLagOMeter(class_332 a) {
        Object a2;
        HUD hUD = a2;
        int n = mc.method_22683().method_4486();
        if (Hana.SERVER.isServerNotResponding()) {
            Object object = a2 = "\u00a74" + (hUD.lowerCase.getValue() ? NCPRaytracer.ALLATORIxDEMO("\u0016\u000fzQbZ\"D}\u0001iKxW,\u0004D,X~] ").toLowerCase() : FPSManager.ALLATORIxDEMO("K\u001b|\u001eP!8\u0017mXZ1S5u\u0014jKz\u0015yM")) + MathUtil.round((float)Hana.SERVER.serverRespondingTime() / 1000.0f, 1) + "s.";
            HUD hUD2 = hUD;
            a.method_25303(HUD.mc.field_1772, (String)object, (int)((float)n / 2.0f - (float)HUD.mc.field_1772.method_1727((String)object) / 2.0f + 2.0f), 20, hUD2.getColor(hUD2.counter));
            ++hUD.counter;
        }
    }

    private /* synthetic */ String getFacingDirectionShort() {
        HUD a22;
        HUD hUD = a22;
        int a22 = Hana.ROTATE.getYaw4D();
        if (a22 == 0) {
            return FPSManager.ALLATORIxDEMO("#FWB");
        }
        if (a22 == 1) {
            return NCPRaytracer.ALLATORIxDEMO("\u0016<w)");
        }
        if (a22 == 2) {
            return FPSManager.ALLATORIxDEMO("#@WB");
        }
        if (a22 == 3) {
            return NCPRaytracer.ALLATORIxDEMO("\u0016:w)");
        }
        return FPSManager.ALLATORIxDEMO("f#p\u0013\u001elC#E");
    }

    @Override
    public void onRender2D(class_332 a, float a42222) {
        String string;
        String string2;
        class_1293 class_12932;
        Object object;
        String string3;
        int n;
        String a42222;
        Object a222;
        Object object2;
        boolean bl;
        Object object3;
        HUD hUD = a222;
        if (HUD.nullCheck()) {
            return;
        }
        hUD.counter = 20;
        int n2 = mc.method_22683().method_4486();
        int n3 = mc.method_22683().method_4502();
        if (hUD.armor.getValue()) {
            Hana.GUI.armorHud.draw(a, a42222, null);
        }
        if (hUD.pvphud.getValue()) {
            HUD hUD2 = hUD;
            hUD2.drawpvphud(a, hUD2.pvphudoffset.getValueInt());
        }
        if (hUD.textRadar.getValue()) {
            HUD hUD3 = hUD;
            hUD3.drawTextRadar(a, hUD3.watermark.getValue() ? (int)(hUD.waterMarkY.getValue() + 2.0) : 2);
        }
        if (hUD.watermark.getValue()) {
            String a42222 = hUD.watermarkString.getValue() + " ";
            string = hUD.watermarkVerColor.getValue() ? FPSManager.ALLATORIxDEMO("\u009a=") : "";
            a222 = string + (hUD.watermarkShort.getValue() ? "" : NCPRaytracer.ALLATORIxDEMO("\u0000\\DfEs\\ \tW[WD-"));
            HUD hUD4 = hUD;
            a.method_25303(HUD.mc.field_1772, a42222.toLowerCase() + (String)(hUD.lowerCase.getValue() ? a222 : a222), hUD.offset.getValueInt(), 2 + hUD.offset.getValueInt(), hUD4.getColor(hUD4.counter));
            ++hUD.counter;
        }
        if (hUD.idWatermark.getValue()) {
            String a42222 = FPSManager.ALLATORIxDEMO("9|\u0015}9g\u0004.CI{");
            string = NCPRaytracer.ALLATORIxDEMO("\u0000\\DfEs\\ \tW[WD-");
            float a222 = (float)mc.method_22683().method_4502() / 2.0f - 30.0f;
            HUD hUD5 = hUD;
            a.method_25303(HUD.mc.field_1772, a42222 + string, 2, (int)a222, hUD5.getColor(hUD5.counter));
            ++hUD.counter;
        }
        String string4 = a42222 = hUD.grayColors.getValue() ? FPSManager.ALLATORIxDEMO("\u009al") : "";
        int n4 = HUD.mc.field_1755 instanceof class_408 && hUD.renderingUp.getValue() ? 13 : (n = hUD.renderingUp.getValue() ? -2 : 0);
        if (hUD.renderingUp.getValue()) {
            if (hUD.potions.getValue()) {
                a222 = new ArrayList(HUD.mc.field_1724.method_6026());
                Object object4 = object2 = a222.iterator();
                while (object4.hasNext()) {
                    int n5;
                    class_12932 = (class_1293)object2.next();
                    n += 10;
                    string2 = hUD.getColoredPotionString(class_12932);
                    if (hUD.potionColor.getValue()) {
                        n5 = class_12932.method_5579().method_5556();
                    } else {
                        HUD hUD6 = hUD;
                        n5 = hUD6.getColor(hUD6.counter);
                    }
                    a.method_25303(HUD.mc.field_1772, string2.toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(string2.toLowerCase()) : HUD.mc.field_1772.method_1727(string2)) - 2, n3 - 2 - n, n5);
                    ++hUD.counter;
                    object4 = object2;
                }
            }
            if (hUD.speed.getValue()) {
                a222 = a42222 + "GrimSpeed \u00a7f" + Hana.SPEED.getSpeedKpH() + " km/h";
                HUD hUD7 = hUD;
                a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n3 - 2 - (n += 10), hUD7.getColor(hUD7.counter));
                ++hUD.counter;
            }
            if (hUD.time.getValue()) {
                a222 = a42222 + "Time \u00a7f" + new SimpleDateFormat(NCPRaytracer.ALLATORIxDEMO("K6S|\u000fa")).format(new Date());
                HUD hUD8 = hUD;
                a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n3 - 2 - (n += 10), hUD8.getColor(hUD8.counter));
                ++hUD.counter;
            }
            if (hUD.tps.getValue()) {
                a222 = a42222 + "TPS \u00a7f" + Hana.SERVER.getTPS();
                HUD hUD9 = hUD;
                a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n3 - 2 - (n += 10), hUD9.getColor(hUD9.counter));
                ++hUD.counter;
            }
            a222 = a42222 + "FPS \u00a7f" + Hana.FPS.getFps();
            object2 = a42222 + "Ping \u00a7f" + Hana.SERVER.getPing();
            if (HUD.mc.field_1772.method_1727((String)object2) > HUD.mc.field_1772.method_1727((String)a222)) {
                if (hUD.ping.getValue()) {
                    HUD hUD10 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)object2).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)object2).toLowerCase()) : HUD.mc.field_1772.method_1727((String)object2)) - 2, n3 - 2 - (n += 10), hUD10.getColor(hUD10.counter));
                    ++hUD.counter;
                }
                if (hUD.fps.getValue()) {
                    HUD hUD11 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n3 - 2 - (n += 10), hUD11.getColor(hUD11.counter));
                }
            } else {
                if (hUD.fps.getValue()) {
                    HUD hUD12 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n3 - 2 - (n += 10), hUD12.getColor(hUD12.counter));
                    ++hUD.counter;
                }
                if (hUD.ping.getValue()) {
                    HUD hUD13 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)object2).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)object2).toLowerCase()) : HUD.mc.field_1772.method_1727((String)object2)) - 2, n3 - 2 - (n += 10), hUD13.getColor(hUD13.counter));
                }
            }
        } else {
            if (hUD.potions.getValue()) {
                a222 = new ArrayList(HUD.mc.field_1724.method_6026());
                Object object5 = object2 = a222.iterator();
                while (object5.hasNext()) {
                    int n6;
                    class_12932 = (class_1293)object2.next();
                    string2 = hUD.getColoredPotionString(class_12932);
                    int n7 = 2 + n * 10;
                    ++n;
                    if (hUD.potionColor.getValue()) {
                        n6 = class_12932.method_5579().method_5556();
                    } else {
                        HUD hUD14 = hUD;
                        n6 = hUD14.getColor(hUD14.counter);
                    }
                    a.method_25303(HUD.mc.field_1772, string2.toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(string2.toLowerCase()) : HUD.mc.field_1772.method_1727(string2)) - 2, n7, n6);
                    ++hUD.counter;
                    object5 = object2;
                }
            }
            if (hUD.speed.getValue()) {
                a222 = a42222 + "GrimSpeed \u00a7f" + Hana.SPEED.getSpeedKpH() + " km/h";
                int n8 = 2 + n * 10;
                ++n;
                HUD hUD15 = hUD;
                a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n8, hUD15.getColor(hUD15.counter));
                ++hUD.counter;
            }
            if (hUD.time.getValue()) {
                a222 = a42222 + "Time \u00a7f" + new SimpleDateFormat(FPSManager.ALLATORIxDEMO("cW&@\u001d:")).format(new Date());
                int n9 = 2 + n * 10;
                ++n;
                HUD hUD16 = hUD;
                a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n9, hUD16.getColor(hUD16.counter));
                ++hUD.counter;
            }
            if (hUD.tps.getValue()) {
                a222 = a42222 + "TPS \u00a7f" + Hana.SERVER.getTPS();
                int n10 = 2 + n * 10;
                ++n;
                HUD hUD17 = hUD;
                a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n10, hUD17.getColor(hUD17.counter));
                ++hUD.counter;
            }
            a222 = a42222 + "FPS \u00a7f" + Hana.FPS.getFps();
            object2 = a42222 + "Ping \u00a7f" + Hana.SERVER.getPing();
            if (HUD.mc.field_1772.method_1727((String)object2) > HUD.mc.field_1772.method_1727((String)a222)) {
                if (hUD.ping.getValue()) {
                    int n11 = 2 + n * 10;
                    ++n;
                    HUD hUD18 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)object2).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)object2).toLowerCase()) : HUD.mc.field_1772.method_1727((String)object2)) - 2, n11, hUD18.getColor(hUD18.counter));
                    ++hUD.counter;
                }
                if (hUD.fps.getValue()) {
                    int n12 = 2 + n * 10;
                    ++n;
                    HUD hUD19 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n12, hUD19.getColor(hUD19.counter));
                }
            } else {
                if (hUD.fps.getValue()) {
                    int n13 = 2 + n * 10;
                    ++n;
                    HUD hUD20 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)a222).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)a222).toLowerCase()) : HUD.mc.field_1772.method_1727((String)a222)) - 2, n13, hUD20.getColor(hUD20.counter));
                    ++hUD.counter;
                }
                if (hUD.ping.getValue()) {
                    int n14 = 2 + n * 10;
                    ++n;
                    HUD hUD21 = hUD;
                    a.method_25303(HUD.mc.field_1772, ((String)object2).toLowerCase(), (hUD.lowerCase.getValue() ? n2 : n2) - (hUD.lowerCase.getValue() ? HUD.mc.field_1772.method_1727(((String)object2).toLowerCase()) : HUD.mc.field_1772.method_1727((String)object2)) - 2, n14, hUD21.getColor(hUD21.counter));
                }
            }
        }
        boolean a222 = HUD.mc.field_1687.method_27983().equals((Object)class_1937.field_25180);
        int n15 = (int)HUD.mc.field_1724.method_23317();
        int n16 = (int)HUD.mc.field_1724.method_23318();
        int n17 = (int)HUD.mc.field_1724.method_23321();
        float a42222 = !a222 ? 0.125f : 8.0f;
        n2 = (int)(HUD.mc.field_1724.method_23317() * (double)a42222);
        int a42222 = (int)(HUD.mc.field_1724.method_23321() * (double)a42222);
        int n18 = (int)class_3532.method_15393((float)HUD.mc.field_1724.method_36454());
        int n19 = hUD.coords.getValue() ? 0 : 11;
        int n20 = n = HUD.mc.field_1755 instanceof class_408 ? 14 : 0;
        if (hUD.lowerCase.getValue()) {
            string3 = NCPRaytracer.ALLATORIxDEMO("TgK\u0015 ").toLowerCase();
            bl = a222;
        } else {
            string3 = FPSManager.ALLATORIxDEMO("5\u0012w\u0007{");
            bl = a222;
        }
        String a42222 = string3 + "\u00a7f" + (bl ? n15 + ", " + n16 + ", " + n17 + "\u00a77 [\u00a7f" + n2 + ", " + a42222 + "\u00a77]\u00a7f" : n15 + ", " + n16 + ", " + n17 + "\u00a77 [\u00a7f" + n2 + ", " + a42222 + "\u00a77]");
        Object object6 = object = hUD.direction.getValue() ? Hana.ROTATE.getDirection4D(false) : "";
        if (hUD.direction.getValue()) {
            String string5;
            int n21;
            if (hUD.lowerCase.getValue()) {
                string5 = NCPRaytracer.ALLATORIxDEMO("U_f\u0015 ").toLowerCase();
                n21 = n18;
            } else {
                string5 = FPSManager.ALLATORIxDEMO("4*Z\u0007{");
                n21 = n18;
            }
            object3 = string5 + "\u00a7f" + n21;
        } else {
            object3 = "";
        }
        String a222 = object3;
        Object object7 = hUD.coords.getValue() ? a42222 : "";
        n += 10;
        if (HUD.mc.field_1755 instanceof class_408 && hUD.direction.getValue()) {
            String string6;
            int n22;
            a222 = "";
            if (hUD.lowerCase.getValue()) {
                string6 = NCPRaytracer.ALLATORIxDEMO("U_f\u0015 ").toLowerCase();
                n22 = n18;
            } else {
                string6 = FPSManager.ALLATORIxDEMO("4*Z\u0007{");
                n22 = n18;
            }
            object = string6 + "\u00a7f" + n22 + "\u00a77 " + hUD.getFacingDirectionShort();
        }
        HUD hUD22 = hUD;
        a.method_25303(HUD.mc.field_1772, (String)object, 2, n3 - n - 11 + n19, hUD22.getColor(hUD22.counter));
        ++hUD.counter;
        HUD hUD23 = hUD;
        a.method_25303(HUD.mc.field_1772, a222, 2, n3 - n - 22 + n19, hUD23.getColor(hUD23.counter));
        ++hUD.counter;
        HUD hUD24 = hUD;
        a.method_25303(HUD.mc.field_1772, (String)object7, 2, n3 - n, hUD24.getColor(hUD24.counter));
        ++hUD.counter;
        if (hUD.greeter.getValue()) {
            hUD.drawWelcomer(a);
        }
        if (hUD.lag.getValue()) {
            hUD.drawLagOMeter(a);
        }
    }

    @Override
    public void onUpdate() {
        HUD a;
        HUD hUD = a;
        if (hUD.timer.passed(hUD.updatedelay.getValue())) {
            HUD hUD2 = a;
            hUD2.players = hUD2.getTextRadarMap();
            hUD2.timer.reset();
        }
        HUD hUD3 = a;
        hUD3.progress -= a.rainbowSpeed.getValueInt();
        hUD3.pulseProgress -= a.pulseSpeed.getValueInt();
    }

    private static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page GLOBAL;
        public static final /* enum */ Page ELEMENTS;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Color;

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Page() {
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

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        static {
            ELEMENTS = new Page(TipUtils.ALLATORIxDEMO("\u0003%\u0004#\u0019=Bj"), 0);
            GLOBAL = new Page(NCPRaytracer.ALLATORIxDEMO("MiCaOm"), 1);
            Color = new Page(TipUtils.ALLATORIxDEMO("-3\u001fyK"), 2);
            $VALUES = Page.$values();
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[3];
            arrpage[0] = ELEMENTS;
            arrpage[1] = GLOBAL;
            arrpage[2] = Color;
            return arrpage;
        }
    }

    private static final class GreeterMode
    extends Enum<GreeterMode> {
        private static final /* synthetic */ GreeterMode[] $VALUES;
        public static final /* enum */ GreeterMode CUSTOM;
        public static final /* enum */ GreeterMode PLAYER;

        /*
         * Exception decompiling
         */
        private /* synthetic */ GreeterMode() {
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

        public static GreeterMode valueOf(String a) {
            return Enum.valueOf(GreeterMode.class, a);
        }

        private static /* synthetic */ GreeterMode[] $values() {
            GreeterMode[] arrgreeterMode = new GreeterMode[2];
            arrgreeterMode[0] = PLAYER;
            arrgreeterMode[1] = CUSTOM;
            return arrgreeterMode;
        }

        public static GreeterMode[] values() {
            return (GreeterMode[])$VALUES.clone();
        }

        static {
            PLAYER = new GreeterMode(ProjectionUtils.ALLATORIxDEMO("{!a?d5"), 0);
            CUSTOM = new GreeterMode(Renderer.ALLATORIxDEMO("^5S)\u0005z"), 1);
            $VALUES = GreeterMode.$values();
        }
    }

    private static final class ColorMode
    extends Enum<ColorMode> {
        public static final /* enum */ ColorMode Rainbow;
        private static final /* synthetic */ ColorMode[] $VALUES;
        public static final /* enum */ ColorMode Pulse;
        public static final /* enum */ ColorMode Custom;
        public static final /* enum */ ColorMode PulseRainbow;

        private static /* synthetic */ ColorMode[] $values() {
            ColorMode[] arrcolorMode = new ColorMode[4];
            arrcolorMode[0] = Custom;
            arrcolorMode[1] = Pulse;
            arrcolorMode[2] = Rainbow;
            arrcolorMode[3] = PulseRainbow;
            return arrcolorMode;
        }

        static {
            Custom = new ColorMode(FPSManager.ALLATORIxDEMO("S\u0003~\u001f(L"), 0);
            Pulse = new ColorMode(ColorUtil.ALLATORIxDEMO("K5jy)"), 1);
            Rainbow = new ColorMode(FPSManager.ALLATORIxDEMO("#q\u001fc\t(V"), 2);
            PulseRainbow = new ColorMode(ColorUtil.ALLATORIxDEMO("\bk1h?N<r.de;"), 3);
            $VALUES = ColorMode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ ColorMode() {
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

        public static ColorMode[] values() {
            return (ColorMode[])$VALUES.clone();
        }

        public static ColorMode valueOf(String a) {
            return Enum.valueOf(ColorMode.class, a);
        }
    }

}
