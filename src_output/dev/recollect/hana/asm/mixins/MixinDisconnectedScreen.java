/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.Pair
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_412
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_4241
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_419
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 *  net.minecraft.class_8021
 *  net.minecraft.class_8667
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoReconnect;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_4185;
import net.minecraft.class_419;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_8021;
import net.minecraft.class_8667;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={class_419.class})
public abstract class MixinDisconnectedScreen
extends class_437 {
    @Shadow
    @Final
    private class_8667 field_44552;
    @Unique
    private class_4185 reconnectBtn;
    @Unique
    private double time;

    protected MixinDisconnectedScreen(class_2561 title) {
        super(title);
        this.time = AutoReconnect.INSTANCE.delay.getValueInt() * 20;
    }

    @Inject(method={"init"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/widget/DirectionalLayoutWidget;refreshPositions()V", shift=At.Shift.BEFORE)}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void addButtons(CallbackInfo ci, class_4185 buttonWidget) {
        AutoReconnect autoReconnect = AutoReconnect.INSTANCE;
        if (autoReconnect.lastServerConnection != null) {
            this.reconnectBtn = new class_4185.class_7840((class_2561)class_2561.method_43470((String)this.getText()), button -> this.tryConnecting()).method_46431();
            this.field_44552.method_52736((class_8021)this.reconnectBtn);
            this.field_44552.method_52736((class_8021)new class_4185.class_7840((class_2561)class_2561.method_43470((String)"Toggle Auto Reconnect"), button -> {
                autoReconnect.toggle();
                this.reconnectBtn.method_25355((class_2561)class_2561.method_43470((String)this.getText()));
                this.time = autoReconnect.delay.getValueInt() * 20;
            }).method_46431());
        }
    }

    public void method_25393() {
        AutoReconnect autoReconnect = AutoReconnect.INSTANCE;
        if (!autoReconnect.isOn() || autoReconnect.lastServerConnection == null) {
            return;
        }
        if (this.time <= 0.0) {
            this.tryConnecting();
        } else {
            this.time -= 1.0;
            if (this.reconnectBtn != null) {
                this.reconnectBtn.method_25355((class_2561)class_2561.method_43470((String)this.getText()));
            }
        }
    }

    @Unique
    private String getText() {
        Object reconnectText = "Reconnect";
        if (AutoReconnect.INSTANCE.isOn()) {
            reconnectText = (String)reconnectText + " " + String.format("(%.1f)", this.time / 20.0);
        }
        return reconnectText;
    }

    @Unique
    private void tryConnecting() {
        Pair<class_639, class_642> lastServer = AutoReconnect.INSTANCE.lastServerConnection;
        class_412.method_36877((class_437)new class_442(), (class_310)class_310.method_1551(), (class_639)((class_639)lastServer.left()), (class_642)((class_642)lastServer.right()), (boolean)false);
    }
}
