/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3675
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.awt.Color;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_4587;
import org.bytedeco.javacv.FrameFilter;

public class BindComponent
extends Component {
    boolean hover;
    private final BindSetting bind;

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        Object a;
        void a2;
        int a3;
        BindComponent bindComponent;
        int a4;
        BindComponent bindComponent2 = this;
        if (a3 != 0) {
            bindComponent2.bind.setListening(false);
        }
        BindComponent bindComponent3 = bindComponent2;
        int a5 = bindComponent3.parent.getX();
        int a6 = bindComponent3.parent.getY();
        bindComponent3.currentOffset = BindComponent.animate(bindComponent3.currentOffset, a4);
        if (a3 != 0 && Math.abs(bindComponent2.currentOffset - (double)a4) <= 0.5) {
            return false;
        }
        BindComponent bindComponent4 = bindComponent2;
        a4 = (int)((double)bindComponent2.parent.getY() + bindComponent4.currentOffset - 2.0);
        a3 = bindComponent4.parent.getWidth();
        class_4587 class_45872 = a2.method_51448();
        if (bindComponent2.hover && bindComponent2.bind.getName().equals(NpSocketClient.ALLATORIxDEMO("\ry%")) && class_3675.method_15987((long)mc.method_22683().method_4490(), (int)340)) {
            a = "Hold " + (bindComponent2.bind.isHoldEnable() ? FrameFilter.ALLATORIxDEMO("\u00eb|\u0019i") : NpSocketClient.ALLATORIxDEMO("\u00eae\tz:"));
            bindComponent = bindComponent2;
        } else {
            BindComponent bindComponent5 = bindComponent2;
            if (bindComponent2.bind.isListening()) {
                a = bindComponent5.bind.getName() + ": Press Key..";
                bindComponent = bindComponent2;
            } else {
                a = bindComponent5.bind.getName() + ": " + bindComponent2.bind.getBind();
                bindComponent = bindComponent2;
            }
        }
        if (bindComponent.hover) {
            Render2DUtil.drawRect(class_45872, (float)a5 + 1.0f, (float)a4 + 1.0f, (float)a3 - 3.0f, (float)bindComponent2.defaultHeight - 1.0f, UIModule.INSTANCE.shColor.getValue());
        }
        TextUtil.drawString((class_332)a2, (String)a, (double)(a5 + 4), (double)((float)((double)a6 + bindComponent2.getTextOffsetY() + bindComponent2.currentOffset) - 2.0f), 16777215);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public BindComponent(ClickGuiTab clickGuiTab, BindSetting bindSetting) {
        BindComponent a;
        void a2;
        BindSetting a3 = bindSetting;
        BindComponent bindComponent = a = this;
        a.hover = false;
        bindComponent.bind = a3;
        bindComponent.parent = a2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void update(int n, double d, double d2, boolean bl) {
        BindComponent bindComponent = this;
        if (GuiManager.currentGrabbed == null && bindComponent.isVisible()) {
            void a;
            void a2;
            void a3;
            BindComponent bindComponent2 = bindComponent;
            int n2 = bindComponent2.parent.getX();
            int a4 = bindComponent2.parent.getY();
            int n3 = bindComponent2.parent.getWidth();
            if (GuiManager.currentGrabbed == null && bindComponent.isVisible() && a >= (double)(n2 + 1) && a <= (double)(n2 + n3 - 1) && a2 >= (double)(a4 + a3) && a2 <= (double)(a4 + a3 + bindComponent.defaultHeight - 2)) {
                void a5;
                bindComponent.hover = true;
                if (a5 == false) return;
                ClickGuiScreen.clicked = false;
                if (bindComponent.bind.getName().equals(FrameFilter.ALLATORIxDEMO("V3~")) && class_3675.method_15987((long)mc.method_22683().method_4490(), (int)340)) {
                    BindComponent bindComponent3 = bindComponent;
                    bindComponent3.bind.setHoldEnable(!bindComponent3.bind.isHoldEnable());
                    return;
                }
                BindComponent bindComponent4 = bindComponent;
                bindComponent4.bind.setListening(!bindComponent4.bind.isListening());
                return;
            }
            bindComponent.hover = false;
            return;
        }
        bindComponent.hover = false;
    }
}
