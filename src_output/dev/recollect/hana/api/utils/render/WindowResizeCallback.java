/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.Event
 *  net.fabricmc.fabric.api.event.EventFactory
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 */
package dev.recollect.hana.api.utils.render;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.class_1041;
import net.minecraft.class_310;

public interface WindowResizeCallback {
    public static final Event<WindowResizeCallback> EVENT = EventFactory.createArrayBacked(WindowResizeCallback.class, a -> (a2, a3) -> {
        WindowResizeCallback[] arrwindowResizeCallback;
        WindowResizeCallback[] arrwindowResizeCallback2 = arrwindowResizeCallback = a;
        int n = arrwindowResizeCallback2.length;
        int n2 = a = 0;
        while (n2 < n) {
            WindowResizeCallback windowResizeCallback = arrwindowResizeCallback2[a];
            windowResizeCallback.onResized(a2, a3);
            n2 = ++a;
        }
    });

    public void onResized(class_310 var1, class_1041 var2);
}
