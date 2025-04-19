/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_276
 *  net.minecraft.class_279
 *  net.minecraft.class_283
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.interfaces.IShaderEffect;
import dev.recollect.hana.asm.accessors.IPostProcessShader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_283;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_279.class})
public class MixinShaderEffect
implements IShaderEffect {
    @Unique
    private final List<String> fakedBufferNames = new ArrayList<String>();
    @Shadow
    @Final
    private Map<String, class_276> field_1495;
    @Shadow
    @Final
    private List<class_283> field_1497;

    @Override
    public void nullpoint_nextgen_master$addFakeTargetHook(String name, class_276 buffer) {
        class_276 previousFramebuffer = this.field_1495.get(name);
        if (previousFramebuffer == buffer) {
            return;
        }
        if (previousFramebuffer != null) {
            for (class_283 pass : this.field_1497) {
                if (pass.field_1536 == previousFramebuffer) {
                    ((IPostProcessShader)pass).setInput(buffer);
                }
                if (pass.field_1538 != previousFramebuffer) continue;
                ((IPostProcessShader)pass).setOutput(buffer);
            }
            this.field_1495.remove(name);
            this.fakedBufferNames.remove(name);
        }
        this.field_1495.put(name, buffer);
        this.fakedBufferNames.add(name);
    }

    @Inject(method={"close"}, at={@At(value="HEAD")})
    void deleteFakeBuffersHook(CallbackInfo ci) {
        for (String fakedBufferName : this.fakedBufferNames) {
            this.field_1495.remove(fakedBufferName);
        }
    }
}
