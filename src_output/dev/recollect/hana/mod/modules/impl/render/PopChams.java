/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.platform.GlStateManager$class_4534
 *  com.mojang.blaze3d.platform.GlStateManager$class_4535
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_3300
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5599
 *  net.minecraft.class_5601
 *  net.minecraft.class_5602
 *  net.minecraft.class_5617
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_572
 *  net.minecraft.class_591
 *  net.minecraft.class_630
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_759
 *  net.minecraft.class_776
 *  net.minecraft.class_7833
 *  net.minecraft.class_8080
 *  net.minecraft.class_898
 *  net.minecraft.class_918
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.render;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.TotemEvent;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.ClientInfo;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_3300;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5599;
import net.minecraft.class_5601;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_572;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_759;
import net.minecraft.class_776;
import net.minecraft.class_7833;
import net.minecraft.class_8080;
import net.minecraft.class_898;
import net.minecraft.class_918;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;

public final class PopChams
extends Module {
    private final ColorSetting color;
    private final SliderSetting alphaSpeed;
    private final SliderSetting riseSpeed;
    private final CopyOnWriteArrayList<Person> popList;
    public static PopChams INSTANCE;

    @Override
    public void onUpdate() {
        PopChams a;
        a.popList.forEach(person -> {
            Person a = person;
            PopChams a2 = this;
            a.update(a2.popList);
        });
    }

    private static /* synthetic */ void prepareScale(class_4587 a) {
        class_4587 class_45872 = a;
        a.method_22905(-1.0f, -1.0f, 1.0f);
        class_45872.method_22905(1.6f, 1.8f, 1.6f);
        class_45872.method_46416(0.0f, -1.501f, 0.0f);
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        PopChams a = class_45872;
        PopChams a2 = this;
        RenderSystem.depthMask((boolean)false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        a2.popList.forEach(arg_0 -> a2.lambda$onRender3D$1((class_4587)a, arg_0));
        RenderSystem.disableBlend();
        RenderSystem.depthMask((boolean)true);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void renderEntity(class_4587 class_45872, Person person, class_572<class_1657> class_5722, int n) {
        void a;
        void a2;
        void a3;
        Object a4 = person;
        PopChams a5 = this;
        Object object = a4;
        double d = ((Person)object).player.method_23317() - PopChams.mc.method_1561().field_4686.method_19326().method_10216();
        Object object2 = a4;
        double d2 = ((Person)object).player.method_23318() - PopChams.mc.method_1561().field_4686.method_19326().method_10214() + (double)((Person)object2).yOffset;
        double d3 = ((Person)object2).player.method_23321() - PopChams.mc.method_1561().field_4686.method_19326().method_10215();
        void v2 = a3;
        v2.method_22903();
        v2.method_46416((float)d, (float)d2, (float)d3);
        v2.method_22907(class_7833.field_40716.rotation(MathUtil.rad(180.0f - a4.player.field_6283)));
        PopChams.prepareScale((class_4587)a3);
        void v3 = a;
        Object object3 = a4;
        v3.method_17086((class_1309)((Person)object3).player, object3.player.field_42108.method_48569(), a4.player.field_42108.method_48566(), mc.method_1488());
        v3.method_17087((class_1309)((Person)a4).player, a4.player.field_42108.method_48569(), a4.player.field_42108.method_48566(), (float)a4.player.field_6012, a4.player.field_6241 - a4.player.field_6283, ((Person)a4).player.method_36455());
        RenderSystem.enableBlend();
        GL11.glDisable((int)2929);
        a4 = class_289.method_1348();
        class_287 class_2872 = a4.method_1349();
        RenderSystem.blendFuncSeparate((GlStateManager.class_4535)GlStateManager.class_4535.SRC_ALPHA, (GlStateManager.class_4534)GlStateManager.class_4534.ONE_MINUS_SRC_ALPHA, (GlStateManager.class_4535)GlStateManager.class_4535.ONE, (GlStateManager.class_4534)GlStateManager.class_4534.ZERO);
        RenderSystem.setShader(class_757::method_34540);
        class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        a.method_2828((class_4587)a3, (class_4588)class_2872, 10, 0, (float)a5.color.getValue().getRed() / 255.0f, (float)a5.color.getValue().getGreen() / 255.0f, (float)a5.color.getValue().getBlue() / 255.0f, (float)a2 / 255.0f);
        a4.method_1350();
        RenderSystem.disableBlend();
        GL11.glEnable((int)2929);
        a3.method_22909();
    }

    @EventHandler
    private /* synthetic */ void onTotemPop(TotemEvent totemEvent) {
        TotemEvent a = totemEvent;
        PopChams a2 = this;
        if (a.getPlayer().equals((Object)PopChams.mc.field_1724) || PopChams.mc.field_1687 == null) {
            return;
        }
        class_1657 class_16572 = new class_1657(a2, (class_1937)PopChams.mc.field_1687, class_2338.field_10980, a.getPlayer().field_6283, new GameProfile(a.getPlayer().method_5667(), a.getPlayer().method_5477().getString())){
            final /* synthetic */ PopChams this$0;

            public boolean method_7325() {
                return false;
            }

            public boolean method_7337() {
                return false;
            }
            {
                void a;
                void a2;
                1 a3;
                void a4;
                void a5;
                1 v0 = this_;
                1 this_ = gameProfile;
                1 a6 = v0;
                a6.this$0 = a5;
                super((class_1937)a2, (class_2338)a, (float)a4, (GameProfile)a3);
            }
        };
        Object object = a;
        class_1657 class_16573 = class_16572;
        Object object2 = a;
        class_16572.method_5719((class_1297)((TotemEvent)object2).getPlayer());
        class_16573.field_6283 = object2.getPlayer().field_6283;
        class_16573.field_6241 = a.getPlayer().field_6241;
        class_16572.field_6251 = object.getPlayer().field_6251;
        class_16572.field_6279 = object.getPlayer().field_6279;
        class_16572.method_5660(a.getPlayer().method_5715());
        class_16572.field_42108.method_48567(a.getPlayer().field_42108.method_48566());
        class_16572.field_42108.field_42111 = a.getPlayer().field_42108.method_48569();
        a2.popList.add(new Person(a2, class_16572));
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void lambda$onRender3D$1(class_4587 class_45872, Person person) {
        void a;
        Person a2 = person;
        PopChams a3 = this;
        Object object = a2;
        object.modelPlayer.field_3482.field_3665 = false;
        object.modelPlayer.field_3479.field_3665 = false;
        object.modelPlayer.field_3484.field_3665 = false;
        object.modelPlayer.field_3486.field_3665 = false;
        object.modelPlayer.field_3483.field_3665 = false;
        object.modelPlayer.field_3394.field_3665 = false;
        Object object2 = a2;
        a3.renderEntity((class_4587)a, (Person)object2, (class_572<class_1657>)a2.modelPlayer, ((Person)object2).getAlpha());
    }

    public PopChams() {
        PopChams a;
        PopChams popChams = a;
        PopChams popChams2 = a;
        super(ClientInfo.ALLATORIxDEMO("T&s\rv29j"), Module.Category.Render);
        PopChams popChams3 = a;
        popChams3.color = popChams2.add(new ColorSetting(Snow.ALLATORIxDEMO("Jaii"), new Color(255, 255, 255)));
        popChams2.alphaSpeed = popChams2.add(new SliderSetting(ClientInfo.ALLATORIxDEMO("B\"t!b\u001dn61}"), 0.2, 0.0, 1.0, 0.01));
        popChams2.riseSpeed = popChams2.add(new SliderSetting(Snow.ALLATORIxDEMO("ybsgZ~`u"), 0.05, 0.0, 5.0, 0.01));
        popChams.popList = new CopyOnWriteArrayList();
        popChams.setChinese(ClientInfo.ALLATORIxDEMO("\u56e0\u812d\u666a\u7923"));
        INSTANCE = popChams;
    }

    private class Person {
        private int alpha;
        private float yOffset;
        final /* synthetic */ PopChams this$0;
        private final class_1657 player;
        private final float moveSpeed;
        private final class_591<class_1657> modelPlayer;

        public void update(CopyOnWriteArrayList<Person> copyOnWriteArrayList) {
            CopyOnWriteArrayList<Person> a = copyOnWriteArrayList;
            Person a2 = this;
            if (a2.alpha <= 0) {
                a.remove(a2);
                Person person = a2;
                person.player.method_5768();
                person.player.method_5650(class_1297.class_5529.field_26998);
                person.player.method_36209();
                return;
            }
            if (a2.yOffset < 2.0f) {
                a2.yOffset += a2.moveSpeed;
            }
            a2.alpha = (int)(AnimateUtil.animate(a2.alpha, 0.0, a2.this$0.alphaSpeed.getValue()) - 0.2);
        }

        public int getAlpha() {
            Person a;
            return (int)MathUtil.clamp(a.alpha, 0.0f, 255.0f);
        }

        /*
         * WARNING - void declaration
         */
        public Person(PopChams object, class_1657 class_16572) {
            void a;
            Object a2 = object;
            object = this;
            ((Person)object).this$0 = a2;
            object();
            ((Person)object).player = a;
            Object object2 = object;
            ((Person)object).modelPlayer = new class_591(new class_5617.class_5618(Wrapper.mc.method_1561(), Wrapper.mc.method_1480(), Wrapper.mc.method_1541(), Wrapper.mc.method_1561().method_43336(), Wrapper.mc.method_1478(), Wrapper.mc.method_31974(), Wrapper.mc.field_1772).method_32167(class_5602.field_27577), false);
            ((Person)object).modelPlayer.method_2838().method_41924(new Vector3f(-0.3f, -0.3f, -0.3f));
            ((Person)object).alpha = ((PopChams)a2).color.getValue().getAlpha();
            ((Person)object).moveSpeed = (float)PopChams.INSTANCE.riseSpeed.getValue();
        }
    }

}
