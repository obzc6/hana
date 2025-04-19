/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1132
 *  net.minecraft.class_1268
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  net.minecraft.class_4093
 *  net.minecraft.class_542
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_642
 *  net.minecraft.class_702
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ServerManager;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.exploit.MineTweak;
import net.minecraft.class_1132;
import net.minecraft.class_1268;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_239;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_4093;
import net.minecraft.class_542;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_642;
import net.minecraft.class_702;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_310.class})
public abstract class MixinMinecraftClient
extends class_4093<Runnable> {
    @Shadow
    private class_1132 field_1766;
    @Shadow
    public int field_1771;
    @Shadow
    public class_746 field_1724;
    @Shadow
    public class_239 field_1765;
    @Shadow
    public class_636 field_1761;
    @Final
    @Shadow
    public class_702 field_1713;
    @Shadow
    public class_638 field_1687;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    void postWindowInit(class_542 args, CallbackInfo ci) {
        try {
            FontRenderers.Arial = FontRenderers.createArial(15.0f);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Shadow
    public class_634 method_1562() {
        return null;
    }

    @Shadow
    public class_642 method_1558() {
        return null;
    }

    @Overwrite
    private String method_24287() {
        if (CombatSetting.INSTANCE == null) {
            return "FlawLess: Loading..";
        }
        StringBuilder stringBuilder = new StringBuilder("Hana");
        return stringBuilder.toString();
    }

    @Inject(method={"handleBlockBreaking"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleBlockBreaking(boolean breaking, CallbackInfo ci) {
        if (this.field_1771 <= 0 && this.field_1724.method_6115() && MineTweak.INSTANCE.multiTask()) {
            if (breaking && this.field_1765 != null && this.field_1765.method_17783() == class_239.class_240.field_1332) {
                class_2350 direction;
                class_3965 blockHitResult = (class_3965)this.field_1765;
                class_2338 blockPos = blockHitResult.method_17777();
                if (!this.field_1687.method_8320(blockPos).method_26215() && this.field_1761.method_2902(blockPos, direction = blockHitResult.method_17780())) {
                    this.field_1713.method_3054(blockPos, direction);
                    this.field_1724.method_6104(class_1268.field_5808);
                }
            } else {
                this.field_1761.method_2925();
            }
            ci.cancel();
        }
    }

    public MixinMinecraftClient(String string) {
        super(string);
    }

    @Inject(at={@At(value="TAIL")}, method={"tick()V"})
    public void tickTail(CallbackInfo info) {
        Hana.SERVER.run();
        if (this.field_1687 != null) {
            Hana.update();
        }
    }
}
