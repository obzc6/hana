/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Splitter
 *  net.minecraft.class_310
 *  org.apache.commons.io.IOUtils
 */
package dev.recollect.hana.api.managers;

import com.google.common.base.Splitter;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.elements.ArmorHUD;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_310;
import org.apache.commons.io.IOUtils;
import org.bytedeco.javacv.FrameFilter;

public class ConfigManager
implements Wrapper {
    public static File options = new File(ConfigManager.mc.field_1697, Snow.ALLATORIxDEMO("ln@D]f}rkfj|(yin"));
    private final Hashtable<String, String> settings = new Hashtable();

    public ConfigManager() {
        ConfigManager a;
        a.readSettings();
    }

    public static boolean isInteger(String a) {
        return Pattern.compile(Snow.ALLATORIxDEMO("\\R -_6_SbP;>")).matcher(a).matches();
    }

    public boolean getBoolean(String string) {
        String a = string;
        ConfigManager a2 = this;
        return Boolean.parseBoolean(a2.settings.get(a));
    }

    /*
     * WARNING - void declaration
     */
    public int getInt(String string, int n) {
        Object a = string;
        ConfigManager a2 = this;
        if ((a = a2.settings.get(a)) == null || !ConfigManager.isInteger((String)a)) {
            void a3;
            return (int)a3;
        }
        return Integer.parseInt((String)a);
    }

    /*
     * WARNING - void declaration
     */
    public float getFloat(String string, float f) {
        Object a = string;
        ConfigManager a2 = this;
        if ((a = a2.settings.get(a)) == null || !ConfigManager.isFloat((String)a)) {
            void a3;
            return (float)a3;
        }
        return Float.parseFloat((String)a);
    }

    public static void resetModule() {
        Iterator<Module> iterator;
        Iterator<Module> iterator2 = iterator = Hana.MODULE.modules.iterator();
        while (iterator2.hasNext()) {
            iterator.next().setState(false);
            iterator2 = iterator;
        }
    }

    public static boolean isFloat(String a) {
        String string = a;
        a = FrameFilter.ALLATORIxDEMO("\u0012Fn9\u0018+\u001c&}8\f*Ps^k}1u@o=\u0010\u0000I4\u0013hOsFs?|Il?o%");
        return string.matches(a);
    }

    /*
     * WARNING - void declaration
     */
    public boolean getBoolean(String string, boolean bl) {
        void a;
        String a2 = string;
        ConfigManager a3 = this;
        if (a3.settings.get(a2) != null) {
            return Boolean.parseBoolean(a3.settings.get(a2));
        }
        return (boolean)a;
    }

    public void readSettings() {
        Iterator a2;
        Splitter splitter;
        ConfigManager configManager;
        block7 : {
            configManager = a2;
            splitter = Splitter.on((char)':');
            if (options.exists()) break block7;
            return;
        }
        for (String string : IOUtils.readLines((InputStream)new FileInputStream(options), (Charset)StandardCharsets.UTF_8)) {
            try {
                a2 = splitter.limit(2).split((CharSequence)string).iterator();
                configManager.settings.put((String)a2.next(), (String)a2.next());
            }
            catch (Exception a2) {
                try {
                    System.out.println("Skipping bad option: " + string);
                }
                catch (Exception exception) {
                    System.out.println(FrameFilter.ALLATORIxDEMO("\u001e\\&x1B=ii3\u0015mmZ-t(p/:1{OR,s(=0w1`.x7r"));
                    break;
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public String getString(String string, String string2) {
        String a = string;
        ConfigManager a2 = this;
        if (a2.settings.get(a) == null) {
            void a3;
            return a3;
        }
        return a2.settings.get(a);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void saveSettings() {
        Object a;
        ConfigManager configManager = a;
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(options), StandardCharsets.UTF_8));
            printWriter.println("prefix:" + Hana.PREFIX);
            Iterator<Object> iterator = Hana.GUI.tabs.iterator();
            Iterator<Object> iterator2 = iterator;
            while (iterator2.hasNext()) {
                ClickGuiTab object = iterator.next();
                printWriter.println(object.getTitle() + "_x:" + object.getX());
                printWriter.println(object.getTitle() + "_y:" + object.getY());
                iterator2 = iterator;
            }
            printWriter.println("armor_x:" + Hana.GUI.armorHud.getX());
            printWriter.println("armor_y:" + Hana.GUI.armorHud.getY());
            for (Module module : Hana.MODULE.modules) {
                for (Setting setting : module.getSettings()) {
                    if (setting instanceof BooleanSetting) {
                        a = (BooleanSetting)setting;
                        printWriter.println(((Setting)a).getLine() + ":" + ((BooleanSetting)a).getValue());
                        continue;
                    }
                    Setting setting2 = setting;
                    if (setting instanceof SliderSetting) {
                        a = (SliderSetting)setting2;
                        printWriter.println(((Setting)a).getLine() + ":" + ((SliderSetting)a).getValue());
                        continue;
                    }
                    Setting setting3 = setting;
                    if (setting2 instanceof BindSetting) {
                        a = (BindSetting)setting3;
                        printWriter.println(((Setting)a).getLine() + ":" + ((BindSetting)a).getKey());
                        printWriter.println(((Setting)a).getLine() + "_hold:" + ((BindSetting)a).isHoldEnable());
                        continue;
                    }
                    Setting setting4 = setting;
                    if (setting3 instanceof EnumSetting) {
                        a = (EnumSetting)setting4;
                        printWriter.println(((Setting)a).getLine() + ":" + ((Enum)((EnumSetting)a).getValue()).name());
                        continue;
                    }
                    if (setting4 instanceof ColorSetting) {
                        a = (ColorSetting)setting;
                        printWriter.println(((Setting)a).getLine() + ":" + ((ColorSetting)a).getValue().getRGB());
                        printWriter.println(((Setting)a).getLine() + "Rainbow:" + ((ColorSetting)a).isRainbow);
                        if (!((ColorSetting)a).injectBoolean) continue;
                        printWriter.println(((Setting)a).getLine() + "Boolean:" + ((ColorSetting)a).booleanValue);
                        continue;
                    }
                    if (!(setting instanceof StringSetting)) continue;
                    setting = (StringSetting)setting;
                    printWriter.println(setting.getLine() + ":" + ((StringSetting)setting).getValue());
                }
                printWriter.println(module.getName() + "_state:" + module.isOn());
            }
            IOUtils.closeQuietly((Writer)printWriter);
            return;
        }
        catch (Exception exception) {
            System.out.println(Snow.ALLATORIxDEMO("_GgcpY|r((Tv,Aloikn!p`\u000eVch&qlp{ocvi"));
            return;
        }
        finally {
            IOUtils.closeQuietly(printWriter);
        }
    }

    public void loadSettings() {
        Object a;
        Iterator<Module> iterator;
        ConfigManager configManager = a;
        Iterator<Module> iterator2 = iterator = Hana.MODULE.modules.iterator();
        while (iterator2.hasNext()) {
            Module module = iterator.next();
            Object object = module.getSettings().iterator();
            while (object.hasNext()) {
                ((Setting)a.next()).loadSetting();
                object = a;
            }
            module.setState(Hana.CONFIG.getBoolean(module.getName() + "_state", false));
            iterator2 = iterator;
        }
    }

    public String getString(String string) {
        String a = string;
        ConfigManager a2 = this;
        return a2.settings.get(a);
    }
}
