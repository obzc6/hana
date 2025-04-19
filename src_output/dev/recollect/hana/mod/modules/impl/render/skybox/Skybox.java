/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.impl.client.rendering.DimensionRenderingRegistryImpl
 *  net.minecraft.class_1937
 *  net.minecraft.class_5321
 */
package dev.recollect.hana.mod.modules.impl.render.skybox;

import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.skybox.CustomSkyRenderer;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Map;
import net.fabricmc.fabric.impl.client.rendering.DimensionRenderingRegistryImpl;
import net.minecraft.class_1937;
import net.minecraft.class_5321;

@Beta
public class Skybox
extends Module {
    public final ColorSetting color5;
    public static final CustomSkyRenderer skyRenderer = new CustomSkyRenderer();
    public final ColorSetting color2;
    public final ColorSetting color4;
    public final ColorSetting color3;
    final BooleanSetting stars;
    public static Skybox INSTANCE;
    public final ColorSetting color;

    @Override
    public void onDisable() {
        Object a22;
        Skybox skybox = a22;
        try {
            Map map;
            Object object = a22 = DimensionRenderingRegistryImpl.class.getDeclaredField(Tab.ALLATORIxDEMO("\u0012D5J$B*@\"X,Q3"));
            ((Field)object).setAccessible(true);
            Map map2 = map = (Map)((Field)object).get(null);
            map.remove((Object)class_1937.field_25179, skyRenderer);
            map2.remove((Object)class_1937.field_25180, skyRenderer);
            map2.remove((Object)class_1937.field_25181, skyRenderer);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }

    @Override
    public void onEnable() {
        Object a22;
        Skybox skybox = a22;
        try {
            Map map;
            Object object = a22 = DimensionRenderingRegistryImpl.class.getDeclaredField(Timer.ALLATORIxDEMO("`^Aaatrvzntgk"));
            ((Field)object).setAccessible(true);
            Map map2 = map = (Map)((Field)object).get(null);
            map.putIfAbsent(class_1937.field_25179, skyRenderer);
            map2.putIfAbsent(class_1937.field_25180, skyRenderer);
            map2.putIfAbsent(class_1937.field_25181, skyRenderer);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }

    public Skybox() {
        Skybox a;
        Skybox skybox = a;
        Skybox skybox2 = a;
        super(Tab.ALLATORIxDEMO("\\\u0007k\u00137C"), Timer.ALLATORIxDEMO("f\u0019\u0012M[S\u0013J_]K\u0001\u001b"), Module.Category.Render);
        Skybox skybox3 = a;
        skybox3.color = skybox2.add(new ColorSetting(Tab.ALLATORIxDEMO("/}\u001d7I"), new Color(0.77f, 0.31f, 0.73f)));
        skybox2.color2 = skybox2.add(new ColorSetting(Timer.ALLATORIxDEMO("z[HF\u001cQ"), new Color(0.77f, 0.31f, 0.73f)));
        skybox2.color3 = skybox2.add(new ColorSetting(Tab.ALLATORIxDEMO("L\u0003~\u001e*\b"), new Color(0.77f, 0.31f, 0.73f)));
        skybox2.color4 = skybox2.add(new ColorSetting(Timer.ALLATORIxDEMO("z[HF\u001cW"), new Color(0.77f, 0.31f, 0.73f)));
        skybox2.color5 = skybox2.add(new ColorSetting(Tab.ALLATORIxDEMO("L\u0003~\u001e*\u000e"), new Color(255, 255, 255)));
        skybox.stars = skybox2.add(new BooleanSetting(Timer.ALLATORIxDEMO("gPH\u001c\u0010"), true));
        skybox.setChinese(Tab.ALLATORIxDEMO("\u593b\u7a0b\u768a\u5b6b"));
        INSTANCE = skybox;
    }
}
