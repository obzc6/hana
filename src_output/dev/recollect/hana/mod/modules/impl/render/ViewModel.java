/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1799
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 *  net.minecraft.class_759
 *  net.minecraft.class_7833
 *  net.minecraft.class_898
 *  org.joml.Quaternionf
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.HeldItemRendererEvent;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.asm.accessors.IHeldItemRenderer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;
import net.minecraft.class_759;
import net.minecraft.class_7833;
import net.minecraft.class_898;
import org.joml.Quaternionf;

public class ViewModel
extends Module {
    public final SliderSetting slowAnimationVal;
    public final SliderSetting scaleMainX;
    public final BooleanSetting slowAnimation;
    public final SliderSetting scaleMainY;
    public final SliderSetting rotationMainY;
    public final SliderSetting eatX;
    public final SliderSetting rotationOffY;
    public final SliderSetting scaleOffY;
    public static ViewModel INSTANCE;
    public final SliderSetting scaleMainZ;
    public final SliderSetting positionMainY;
    public final SliderSetting positionOffY;
    public final BooleanSetting swingAnimation;
    public final SliderSetting positionMainX;
    public final SliderSetting scaleOffX;
    public final SliderSetting positionMainZ;
    public final SliderSetting rotationMainX;
    public final SliderSetting rotationOffX;
    public final SliderSetting rotationMainZ;
    public final SliderSetting rotationOffZ;
    public final BooleanSetting offhandSwap;
    public final BooleanSetting mainhandSwap;
    public final SliderSetting positionOffZ;
    public final SliderSetting eatY;
    public final SliderSetting positionOffX;
    public final BooleanSetting eatAnimation;
    public final SliderSetting scaleOffZ;

    @EventHandler
    private /* synthetic */ void onHeldItemRender(HeldItemRendererEvent heldItemRendererEvent) {
        HeldItemRendererEvent a = heldItemRendererEvent;
        ViewModel a2 = this;
        if (a.getHand() == class_1268.field_5808) {
            Object object = a;
            ((HeldItemRendererEvent)object).getStack().method_46416(a2.positionMainX.getValueFloat(), a2.positionMainY.getValueFloat(), a2.positionMainZ.getValueFloat());
            ((HeldItemRendererEvent)object).getStack().method_22905(a2.scaleMainX.getValueFloat(), a2.scaleMainY.getValueFloat(), a2.scaleMainZ.getValueFloat());
            ((HeldItemRendererEvent)object).getStack().method_22907(class_7833.field_40714.rotationDegrees(a2.rotationMainX.getValueFloat()));
            ((HeldItemRendererEvent)object).getStack().method_22907(class_7833.field_40716.rotationDegrees(a2.rotationMainY.getValueFloat()));
            ((HeldItemRendererEvent)object).getStack().method_22907(class_7833.field_40718.rotationDegrees(a2.rotationMainZ.getValueFloat()));
            return;
        }
        Object object = a;
        ((HeldItemRendererEvent)object).getStack().method_46416(a2.positionOffX.getValueFloat(), a2.positionOffY.getValueFloat(), a2.positionOffZ.getValueFloat());
        ((HeldItemRendererEvent)object).getStack().method_22905(a2.scaleOffX.getValueFloat(), a2.scaleOffY.getValueFloat(), a2.scaleOffZ.getValueFloat());
        ((HeldItemRendererEvent)object).getStack().method_22907(class_7833.field_40714.rotationDegrees(a2.rotationOffX.getValueFloat()));
        ((HeldItemRendererEvent)object).getStack().method_22907(class_7833.field_40716.rotationDegrees(a2.rotationOffY.getValueFloat()));
        ((HeldItemRendererEvent)object).getStack().method_22907(class_7833.field_40718.rotationDegrees(a2.rotationOffZ.getValueFloat()));
    }

    public ViewModel() {
        ViewModel a;
        ViewModel viewModel = a;
        ViewModel viewModel2 = a;
        super(User.ALLATORIxDEMO("HIY\\zERFS"), Module.Category.Render);
        ViewModel viewModel3 = a;
        viewModel3.swingAnimation = viewModel2.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("sh\u0019!B[LtH{Ln\u001d#"), false));
        viewModel2.eatAnimation = viewModel2.add(new BooleanSetting(User.ALLATORIxDEMO("}Ev_NUFV^_LQ"), false));
        viewModel2.mainhandSwap = viewModel2.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("=.LtJ|K~kp\u0013="), true));
        viewModel2.offhandSwap = viewModel2.add(new BooleanSetting(User.ALLATORIxDEMO("kdxH]ESyABO"), true));
        viewModel2.scaleMainX = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("vyCq@WYn\u001c\u0015"), 1.0, 0.10000000149011612, 5.0, 0.01));
        viewModel2.scaleMainY = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("Q}APNzK_Mf"), 1.0, 0.10000000149011612, 5.0, 0.01));
        viewModel2.scaleMainZ = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("vyCq@WYn\u001c\u0017"), 1.0, 0.10000000149011612, 5.0, 0.01));
        viewModel2.positionMainX = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("fWWkjISEzK_Mg"), 0.0, -3.0, 3.0, 0.01));
        viewModel2.positionMainY = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("O\u001f<LnKrKWYn\u001c\u0014"), 0.0, -3.0, 3.0, 0.01));
        viewModel2.positionMainZ = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("fWWkjISEzK_Me"), 0.0, -3.0, 3.0, 0.01));
        viewModel2.rotationMainX = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("M\u001f;DnKrKWYn\u001c\u0015"), 0.0, -180.0, 180.0, 0.01));
        viewModel2.rotationMainY = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("dWPcjISEzK_Mf"), 0.0, -180.0, 180.0, 0.01));
        viewModel2.rotationMainZ = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("M\u001f;DnKrKWYn\u001c\u0017"), 0.0, -180.0, 180.0, 0.01));
        viewModel2.scaleOffX = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("MC]GRePEg"), 1.0, 0.10000000149011612, 5.0, 0.01));
        viewModel2.scaleOffY = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("IA|Iwa\u0014\u0014"), 1.0, 0.10000000149011612, 5.0, 0.01));
        viewModel2.scaleOffZ = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("MC]GRePEe"), 1.0, 0.10000000149011612, 5.0, 0.01));
        viewModel2.positionOffX = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("  VsVtJtwa\u0014\u0015"), 0.0, -3.0, 3.0, 0.01));
        viewModel2.positionOffY = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("hKqwTUDYePEf"), 0.0, -3.0, 3.0, 0.01));
        viewModel2.positionOffZ = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("  VsVtJtwa\u0014\u0017"), 0.0, -3.0, 3.0, 0.01));
        viewModel2.rotationOffX = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("jKvTUDYePEg"), 0.0, -180.0, 180.0, 0.01));
        viewModel2.rotationOffY = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("\" Q{VtJtwa\u0014\u0014"), 0.0, -180.0, 180.0, 0.01));
        viewModel2.rotationOffZ = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("jKvTUDYePEe"), 0.0, -180.0, 180.0, 0.01));
        viewModel2.slowAnimation = viewModel2.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("L\u001c R[LtH{Ln\u001d#"), true));
        viewModel2.slowAnimationVal = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("MLS\\aKZVZ"), 6, 1, 50));
        viewModel2.eatX = viewModel2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("}f\u0006\u0015"), 1.0, -1.0, 2.0, 0.01));
        viewModel.eatY = viewModel2.add(new SliderSetting(User.ALLATORIxDEMO("oWWf"), 1.0, -1.0, 2.0, 0.01));
        viewModel.setChinese(BlockUpUtil.ALLATORIxDEMO("\u6273\u90ef\u664c\u7977"));
        INSTANCE = viewModel;
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        ViewModel a2 = this;
        if (!a2.mainhandSwap.getValue() && ((IHeldItemRenderer)mc.method_1561().method_43336()).getEquippedProgressMainHand() <= 1.0f) {
            ((IHeldItemRenderer)mc.method_1561().method_43336()).setEquippedProgressMainHand(1.0f);
            ((IHeldItemRenderer)mc.method_1561().method_43336()).setItemStackMainHand(ViewModel.mc.field_1724.method_6047());
        }
        if (!a2.offhandSwap.getValue() && ((IHeldItemRenderer)mc.method_1561().method_43336()).getEquippedProgressOffHand() <= 1.0f) {
            ((IHeldItemRenderer)mc.method_1561().method_43336()).setEquippedProgressOffHand(1.0f);
            ((IHeldItemRenderer)mc.method_1561().method_43336()).setItemStackOffHand(ViewModel.mc.field_1724.method_6079());
        }
    }
}
