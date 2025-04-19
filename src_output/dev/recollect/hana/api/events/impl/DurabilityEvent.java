/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class DurabilityEvent
extends Event {
    private int damage;

    public DurabilityEvent(int damage) {
        super(Event.Stage.Pre);
        this.damage = damage;
    }

    public int getItemDamage() {
        return Math.max(0, this.damage);
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
