/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class MouseInputEvent
extends Event {
    private final int button;
    private final boolean isPressed;

    public MouseInputEvent(int button, boolean isPressed) {
        super(Event.Stage.Post);
        this.button = button;
        this.isPressed = isPressed;
    }

    public int getButton() {
        return this.button;
    }

    public boolean isPressed() {
        return this.isPressed;
    }
}
