/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderer;
import dev.recollect.hana.mod.gui.nullpoint.font.Glyph;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

static final class FontRenderer.DrawEntry
extends Record {
    private final Glyph toDraw;
    private final float b;
    private final float g;
    private final float r;
    private final float atY;
    private final float atX;

    @Override
    public final String toString() {
        FontRenderer.DrawEntry a;
        return ObjectMethods.bootstrap(new MethodHandle[]{FontRenderer.DrawEntry.class, "atX;atY;r;g;b;toDraw", }