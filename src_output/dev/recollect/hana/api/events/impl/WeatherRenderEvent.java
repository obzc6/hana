/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_765
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_765;

public class WeatherRenderEvent
extends Event {
    private static final WeatherRenderEvent INSTANCE = new WeatherRenderEvent();
    public class_765 lightmapTextureManager;
    public float tickDelta;
    public double cameraX;
    public double cameraY;
    public double cameraZ;

    public WeatherRenderEvent() {
        super(Event.Stage.Pre);
    }

    public static WeatherRenderEvent get(class_765 lightmapTextureManager, float tickDelta, double cameraX, double cameraY, double cameraZ) {
        INSTANCE.setCancelled(false);
        WeatherRenderEvent.INSTANCE.lightmapTextureManager = lightmapTextureManager;
        WeatherRenderEvent.INSTANCE.tickDelta = tickDelta;
        WeatherRenderEvent.INSTANCE.cameraX = cameraX;
        WeatherRenderEvent.INSTANCE.cameraY = cameraY;
        WeatherRenderEvent.INSTANCE.cameraZ = cameraZ;
        return INSTANCE;
    }

    public class_765 getLightmapTextureManager() {
        return this.lightmapTextureManager;
    }

    public float getTickDelta() {
        return this.tickDelta;
    }

    public double getCameraX() {
        return this.cameraX;
    }

    public double getCameraY() {
        return this.cameraY;
    }

    public double getCameraZ() {
        return this.cameraZ;
    }
}
