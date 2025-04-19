/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package dev.recollect.hana.api.utils.world;

import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class BlockPosX
extends class_2338 {
    /*
     * WARNING - void declaration
     */
    public BlockPosX(class_243 class_2432, boolean bl) {
        void a;
        BlockPosX a2 = class_2432;
        BlockPosX a3 = this;
        a3(((class_243)a2).field_1352, ((class_243)a2).field_1351, ((class_243)a2).field_1350, (boolean)a);
    }

    public BlockPosX(double a, double a2, double a3) {
        super(class_3532.method_15357((double)a), class_3532.method_15357((double)a2), class_3532.method_15357((double)a3));
        BlockPosX a4;
    }

    public BlockPosX(class_243 class_2432) {
        BlockPosX a = class_2432;
        BlockPosX a2 = this;
        a2(((class_243)a).field_1352, ((class_243)a).field_1351, ((class_243)a).field_1350);
    }

    /*
     * WARNING - void declaration
     */
    public BlockPosX(double d, double d2, double d3, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        boolean bl2 = bl;
        BlockPosX a5 = this;
        a5((double)a3, (double)(a + (a2 != false ? 0.3 : 0.0)), (double)a4);
    }
}
