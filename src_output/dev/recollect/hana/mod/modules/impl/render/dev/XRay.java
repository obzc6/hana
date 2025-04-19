/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_310
 *  net.minecraft.class_761
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.XrayManager;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.socket.network.client.SocketClient;
import net.minecraft.class_2248;
import net.minecraft.class_310;
import net.minecraft.class_761;
import org.bytedeco.javacv.BaseSettings;

public class XRay
extends Module {
    public static XRay INSTANCE;

    public XRay() {
        XRay a;
        XRay xRay = a;
        super(SocketClient.ALLATORIxDEMO("wXVk"), Module.Category.Render);
        xRay.setChinese(BaseSettings.ALLATORIxDEMO("`\u5144\u902f\u89d3"));
        INSTANCE = xRay;
    }

    @Override
    public void onEnable() {
        XRay.mc.field_1730 = false;
        XRay.mc.field_1769.method_3279();
    }

    public boolean isCheckableOre(class_2248 class_22482) {
        XRay a = class_22482;
        XRay a2 = this;
        return Hana.XRAY.inWhitelist(a.method_9539());
    }

    @Override
    public void onDisable() {
        XRay.mc.field_1730 = true;
        XRay.mc.field_1769.method_3279();
    }
}
