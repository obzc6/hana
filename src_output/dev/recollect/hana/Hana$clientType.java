/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana;

import dev.recollect.hana.Hana;

public static final class Hana.clientType
extends Enum<Hana.clientType> {
    public static final /* enum */ Hana.clientType Dev = new Hana.clientType();
    public static final /* enum */ Hana.clientType Beta = new Hana.clientType();
    public static final /* enum */ Hana.clientType Release = new Hana.clientType();
    private static final /* synthetic */ Hana.clientType[] $VALUES;

    public static Hana.clientType[] values() {
        return (Hana.clientType[])$VALUES.clone();
    }

    public static Hana.clientType valueOf(String name) {
        return Enum.valueOf(Hana.clientType.class, name);
    }

    private static /* synthetic */ Hana.clientType[] $values() {
        return new Hana.clientType[]{Dev, Beta, Release};
    }

    static {
        $VALUES = Hana.clientType.$values();
    }
}
