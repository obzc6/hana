/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2818
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.mod.modules.impl.exploit.MineTweak;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1937.class})
public abstract class MixinWorld {
    @Inject(method={"getBlockState"}, at={@At(value="HEAD")}, cancellable=true)
    public void blockStateHook(class_2338 pos, CallbackInfoReturnable<class_2680> cir) {
        if (Wrapper.mc.field_1687 != null && Wrapper.mc.field_1687.method_24794(pos)) {
            class_2680 tempState;
            class_2818 worldChunk;
            if (CombatUtil.terrainIgnore || CombatUtil.modifyPos != null) {
                class_2818 worldChunk2 = Wrapper.mc.field_1687.method_8497(pos.method_10263() >> 4, pos.method_10260() >> 4);
                class_2680 tempState2 = worldChunk2.method_8320(pos);
                if (CombatUtil.modifyPos != null && pos.equals((Object)CombatUtil.modifyPos)) {
                    cir.setReturnValue((Object)CombatUtil.modifyBlockState);
                    return;
                }
                if (CombatUtil.terrainIgnore) {
                    if (tempState2.method_26204() == class_2246.field_10540 || tempState2.method_26204() == class_2246.field_9987 || tempState2.method_26204() == class_2246.field_10443 || tempState2.method_26204() == class_2246.field_23152 || tempState2.method_26204() == class_2246.field_22108) {
                        return;
                    }
                    cir.setReturnValue((Object)class_2246.field_10124.method_9564());
                }
            } else if (MineTweak.INSTANCE.isActive && (tempState = (worldChunk = Wrapper.mc.field_1687.method_8497(pos.method_10263() >> 4, pos.method_10260() >> 4)).method_8320(pos)).method_26204() == class_2246.field_9987) {
                cir.setReturnValue((Object)class_2246.field_10124.method_9564());
            }
        }
    }
}
