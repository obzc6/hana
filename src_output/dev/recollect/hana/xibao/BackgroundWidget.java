/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_6379
 *  net.minecraft.class_6379$class_6380
 *  net.minecraft.class_6382
 */
package dev.recollect.hana.xibao;

import dev.recollect.hana.xibao.SnowAnimation;
import dev.recollect.hana.xibao.XibaoPlusPlusConfig;
import dev.recollect.hana.xibao.XibaoType;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import net.minecraft.class_1041;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_6379;
import net.minecraft.class_6382;

public class BackgroundWidget
implements class_4068,
class_364,
class_6379 {
    public class_6379.class_6380 method_37018() {
        return class_6379.class_6380.field_33784;
    }

    public boolean method_25370() {
        return false;
    }

    public void method_37020(class_6382 class_63822) {
        BackgroundWidget a = class_63822;
        BackgroundWidget a2 = this;
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        int a = n;
        BackgroundWidget a2 = this;
        class_1041 class_10412 = class_310.method_1551().method_22683();
        int a3 = class_10412.method_4486();
        a = class_10412.method_4502();
        if (XibaoPlusPlusConfig.showPicture) {
            RenderHelper.renderStretchTexture(a3, a, 225, XibaoPlusPlusConfig.type.background);
        }
        if (XibaoPlusPlusConfig.displaySnow || XibaoPlusPlusConfig.tempSnow) {
            SnowAnimation.INSTANCE.tick(a3, a, XibaoPlusPlusConfig.type.snows);
        }
    }

    public void method_25365(boolean bl) {
        boolean a = bl;
        BackgroundWidget a2 = this;
    }

    public BackgroundWidget() {
        BackgroundWidget a;
    }
}
