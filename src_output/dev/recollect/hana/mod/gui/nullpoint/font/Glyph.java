/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import dev.recollect.hana.mod.gui.nullpoint.font.GlyphMap;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class Glyph
extends Record {
    private final int v;
    private final char value;
    private final int u;
    private final GlyphMap owner;
    private final int height;
    private final int width;

    public GlyphMap owner() {
        Glyph a;
        return a.owner;
    }

    @Override
    public final String toString() {
        Glyph a;
        return ObjectMethods.bootstrap(new MethodHandle[]{Glyph.class, "u;v;width;height;value;owner", }