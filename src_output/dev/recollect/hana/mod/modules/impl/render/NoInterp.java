/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.SnowAnimation;

@Beta
public class NoInterp
extends Module {
    public static NoInterp INSTANCE;

    public NoInterp() {
        NoInterp a;
        NoInterp noInterp = a;
        super(SnowAnimation.ALLATORIxDEMO("f\u0019p\tZ\u0015^\u0002"), Module.Category.Render);
        noInterp.setChinese(Vec3.ALLATORIxDEMO("\u6cae\u676c\u63df\u505b"));
        INSTANCE = noInterp;
    }
}
