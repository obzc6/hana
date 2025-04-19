/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;

public class ForceSneak
extends Module {
    public static ForceSneak INSTANCE;

    public ForceSneak() {
        ForceSneak a;
        ForceSneak forceSneak = a;
        super(ColorUtil.ALLATORIxDEMO("\u001bt(8H.ck'"), Module.Category.Render);
        forceSneak.setChinese(RenderHelper.ALLATORIxDEMO("\u5f4d\u523e\u6f61\u880e"));
        INSTANCE = forceSneak;
    }
}
