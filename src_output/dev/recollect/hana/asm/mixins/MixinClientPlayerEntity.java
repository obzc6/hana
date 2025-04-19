/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1104
 *  net.minecraft.class_1297
 *  net.minecraft.class_1313
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_2833
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2851
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_437
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_7172
 *  net.minecraft.class_742
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.exploit.ForceSync;
import dev.recollect.hana.mod.modules.impl.exploit.PacketControl;
import dev.recollect.hana.mod.modules.impl.miscellaneous.PortalGui;
import dev.recollect.hana.mod.modules.impl.movement.NoSlow;
import dev.recollect.hana.mod.modules.impl.movement.Velocity;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.List;
import java.util.Random;
import net.minecraft.class_1104;
import net.minecraft.class_1297;
import net.minecraft.class_1313;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_2833;
import net.minecraft.class_2848;
import net.minecraft.class_2851;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_437;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_7172;
import net.minecraft.class_742;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_746.class})
public abstract class MixinClientPlayerEntity
extends class_742 {
    @Shadow
    @Final
    private List<class_1104> field_3933;
    @Shadow
    public class_744 field_3913;
    @Shadow
    private boolean field_3927;
    @Final
    @Shadow
    public class_634 field_3944;
    @Shadow
    private double field_3926;
    @Shadow
    private double field_3940;
    @Shadow
    private double field_3924;
    @Shadow
    private float field_3941;
    @Shadow
    private float field_3925;
    @Shadow
    private boolean field_3920;
    @Shadow
    private boolean field_3936;
    @Final
    @Shadow
    protected class_310 field_3937;
    @Shadow
    private int field_3923;

    public MixinClientPlayerEntity(class_638 world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(method={"pushOutOfBlocks"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPushOutOfBlocksHook(double x, double d, CallbackInfo info) {
        if (Velocity.INSTANCE.isOn() && Velocity.INSTANCE.blockPush.getValue()) {
            info.cancel();
        }
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"), require=0)
    private boolean tickMovementHook(class_746 player) {
        if (NoSlow.INSTANCE.isOn()) {
            return false;
        }
        return player.method_6115();
    }

    @Redirect(method={"updateNausea"}, at=@At(value="FIELD", target="Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;"))
    private class_437 updateNauseaGetCurrentScreenProxy(class_310 client) {
        if (PortalGui.INSTANCE.isOn()) {
            return null;
        }
        return client.field_1755;
    }

    @Inject(method={"move"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/AbstractClientPlayerEntity;move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V")}, cancellable=true)
    public void onMoveHook(class_1313 movementType, class_243 movement, CallbackInfo ci) {
        MoveEvent event = new MoveEvent(movement.field_1352, movement.field_1351, movement.field_1350);
        Hana.EVENT_BUS.post(event);
        ci.cancel();
        if (!event.isCancelled()) {
            super.method_5784(movementType, new class_243(event.getX(), event.getY(), event.getZ()));
        }
    }

    @Shadow
    private void method_46742() {
    }

    @Shadow
    private void method_3136() {
    }

    @Shadow
    protected boolean method_3134() {
        return false;
    }

    @Shadow
    public abstract float method_5695(float var1);

    @Inject(method={"sendMovementPackets"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendMovementPacketsHook(CallbackInfo ci) {
        UpdateWalkingEvent updateEvent;
        ci.cancel();
        RotateManager.lastEvent = updateEvent = new UpdateWalkingEvent(Event.Stage.Pre);
        Hana.EVENT_BUS.post(updateEvent);
        this.method_46742();
        boolean bl = this.method_5715();
        if (bl != this.field_3936) {
            class_2848.class_2849 mode = bl ? class_2848.class_2849.field_12979 : class_2848.class_2849.field_12984;
            this.field_3944.method_52787((class_2596)new class_2848((class_1297)this, mode));
            this.field_3936 = bl;
        }
        if (this.method_3134()) {
            boolean bl3;
            double d = this.method_23317() - this.field_3926;
            double e = this.method_23318() - this.field_3940;
            double f = this.method_23321() - this.field_3924;
            float yaw = this.method_36454();
            float pitch = this.method_36455();
            RotateEvent rotateEvent = new RotateEvent(yaw, pitch);
            Hana.EVENT_BUS.post(rotateEvent);
            if (rotateEvent.isModified() && CombatSetting.INSTANCE.randomPitch.getValue() && new Random().nextBoolean() && new Random().nextBoolean()) {
                rotateEvent.setPitch(Math.min(new Random().nextFloat() * 2.0f + rotateEvent.getPitch(), 90.0f));
            }
            yaw = rotateEvent.getYaw();
            pitch = rotateEvent.getPitch();
            Hana.ROTATE.rotateYaw = yaw;
            Hana.ROTATE.rotatePitch = pitch;
            double g = yaw - Hana.ROTATE.lastYaw;
            double h = pitch - Hana.ROTATE.lastPitch;
            ++this.field_3923;
            boolean bl2 = class_3532.method_41190((double)d, (double)e, (double)f) > class_3532.method_33723((double)2.0E-4) || this.field_3923 >= 20 || ForceSync.INSTANCE.isOn() && ForceSync.INSTANCE.position.getValue();
            boolean bl4 = bl3 = (g != 0.0 || h != 0.0 || ForceSync.INSTANCE.isOn() && ForceSync.INSTANCE.rotate.getValue()) && !updateEvent.isCancelRotate();
            if (PacketControl.INSTANCE.isOn()) {
                bl3 = PacketControl.INSTANCE.full;
            }
            if (this.method_5765()) {
                class_243 vec3d = this.method_18798();
                this.field_3944.method_52787((class_2596)new class_2828.class_2830(vec3d.field_1352, -999.0, vec3d.field_1350, yaw, pitch, this.method_24828()));
                bl2 = false;
            } else if (bl2 && bl3) {
                this.field_3944.method_52787((class_2596)new class_2828.class_2830(this.method_23317(), this.method_23318(), this.method_23321(), yaw, pitch, this.method_24828()));
            } else if (bl2) {
                this.field_3944.method_52787((class_2596)new class_2828.class_2829(this.method_23317(), this.method_23318(), this.method_23321(), this.method_24828()));
            } else if (bl3) {
                this.field_3944.method_52787((class_2596)new class_2828.class_2831(yaw, pitch, this.method_24828()));
            } else if (this.field_3920 != this.method_24828()) {
                this.field_3944.method_52787((class_2596)new class_2828.class_5911(this.method_24828()));
            }
            if (bl2) {
                this.field_3926 = this.method_23317();
                this.field_3940 = this.method_23318();
                this.field_3924 = this.method_23321();
                this.field_3923 = 0;
            }
            if (bl3) {
                this.field_3941 = yaw;
                this.field_3925 = pitch;
            }
            this.field_3920 = this.method_24828();
            this.field_3927 = (Boolean)this.field_3937.field_1690.method_42423().method_41753();
        }
        Hana.EVENT_BUS.post(new UpdateWalkingEvent(Event.Stage.Post));
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void tickHook(CallbackInfo ci) {
        ci.cancel();
        if (this.method_37908().method_33598(this.method_31477(), this.method_31479())) {
            super.method_5773();
            if (this.method_5765()) {
                UpdateWalkingEvent updateEvent;
                RotateManager.lastEvent = updateEvent = new UpdateWalkingEvent(Event.Stage.Pre);
                Hana.EVENT_BUS.post(updateEvent);
                if (!updateEvent.isCancelRotate()) {
                    float yaw = this.method_36454();
                    float pitch = this.method_36455();
                    RotateEvent rotateEvent = new RotateEvent(yaw, pitch);
                    Hana.EVENT_BUS.post(rotateEvent);
                    if (rotateEvent.isModified() && CombatSetting.INSTANCE.randomPitch.getValue() && new Random().nextBoolean() && new Random().nextBoolean()) {
                        rotateEvent.setPitch(Math.min(new Random().nextFloat() * 2.0f + rotateEvent.getPitch(), 90.0f));
                    }
                    yaw = rotateEvent.getYaw();
                    pitch = rotateEvent.getPitch();
                    Hana.ROTATE.rotateYaw = yaw;
                    Hana.ROTATE.rotatePitch = pitch;
                    this.field_3944.method_52787((class_2596)new class_2828.class_2831(yaw, pitch, this.method_24828()));
                }
                Hana.EVENT_BUS.post(new UpdateWalkingEvent(Event.Stage.Post));
                this.field_3944.method_52787((class_2596)new class_2851(this.field_6212, this.field_6250, this.field_3913.field_3904, this.field_3913.field_3903));
                class_1297 entity = this.method_5668();
                if (entity != this && entity.method_5787()) {
                    this.field_3944.method_52787((class_2596)new class_2833(entity));
                    this.method_46742();
                }
            } else {
                this.method_3136();
            }
            for (class_1104 clientPlayerTickable : this.field_3933) {
                clientPlayerTickable.method_4756();
            }
        }
    }
}
