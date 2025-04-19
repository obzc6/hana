/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_332
 *  net.minecraft.class_429
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_500
 *  net.minecraft.class_526
 */
package dev.recollect.hana.mod.gui.nullpoint.mainmenu;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.LogoDrawer;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import java.awt.Color;
import java.io.PrintStream;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_332;
import net.minecraft.class_429;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_500;
import net.minecraft.class_526;

public class Epsilon
extends class_437 {
    float zoomSingle;
    private static final class_2960 exit;
    private static final class_2960 single;
    float zoomMulti;
    private static final class_2960 station;
    private static final class_2960 multi;
    float zoomSetting;
    float zoomExit;
    private static final class_2960 sky;
    private static final class_2960 pillar;
    private static final class_2960 setting;
    private static final class_2960 moon;

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        int n3;
        Epsilon epsilon;
        Epsilon epsilon2;
        int n4;
        float f2;
        class_4587 a;
        int a2;
        void a3;
        block19 : {
            block18 : {
                double d;
                block17 : {
                    void a4;
                    Epsilon epsilon3;
                    void a5;
                    int n5;
                    block16 : {
                        block15 : {
                            block14 : {
                                Epsilon epsilon4;
                                block13 : {
                                    block12 : {
                                        block11 : {
                                            Epsilon epsilon5;
                                            block10 : {
                                                block9 : {
                                                    block8 : {
                                                        epsilon2 = this;
                                                        void v0 = a3;
                                                        LogoDrawer.draw((class_332)v0, epsilon2.field_22789 / 4, epsilon2.field_22790 / 4, 1.0f);
                                                        Epsilon epsilon6 = epsilon2;
                                                        v0.method_25302(moon, 50, 15, 0, 0, epsilon6.field_22789, epsilon6.field_22790);
                                                        Epsilon epsilon7 = epsilon2;
                                                        Epsilon epsilon8 = epsilon2;
                                                        v0.method_25291(sky, 0, 0, 0, 0.0f, 0.0f, epsilon7.field_22789, epsilon7.field_22790, epsilon8.field_22789, epsilon8.field_22790);
                                                        Epsilon epsilon9 = epsilon2;
                                                        Epsilon epsilon10 = epsilon2;
                                                        v0.method_25291(station, (int)((a4 - epsilon2.field_22789) / 64), 0, 0, 0.0f, 0.0f, epsilon9.field_22789, epsilon9.field_22790, epsilon10.field_22789, epsilon10.field_22790);
                                                        Epsilon epsilon11 = epsilon2;
                                                        Epsilon epsilon12 = epsilon2;
                                                        v0.method_25291(pillar, (int)((a4 - epsilon2.field_22789) / 64), 0, 0, 0.0f, 0.0f, epsilon11.field_22789, epsilon11.field_22790, epsilon12.field_22789, epsilon12.field_22790);
                                                        a = v0.method_51448();
                                                        Epsilon epsilon13 = epsilon2;
                                                        Epsilon epsilon14 = epsilon2;
                                                        float f3 = (float)epsilon14.field_22789 / 2.0f;
                                                        a2 = epsilon14.field_22790 / 12;
                                                        f2 = 1.2f;
                                                        n4 = epsilon13.field_22789 / 4;
                                                        n3 = (epsilon13.field_22790 - a2) / 2;
                                                        n5 = (int)((f3 - (float)(4 * a2)) / 5.0f);
                                                        d = 0.06;
                                                        (float)(1 - Math.abs((int)(a5 - epsilon2.field_22790 / 2)) / epsilon2.field_22790) / 255.0f;
                                                        a.method_22903();
                                                        if (!epsilon13.isMouseHoveringRect((float)n4, (float)n3, a2, (int)a4, (int)a5)) break block8;
                                                        if (!(epsilon2.zoomSingle < f2)) break block9;
                                                        Epsilon epsilon15 = epsilon2;
                                                        epsilon5 = epsilon15;
                                                        epsilon15.zoomSingle = (float)((double)epsilon15.zoomSingle + d);
                                                        break block10;
                                                    }
                                                    if ((double)epsilon2.zoomSingle > 1.0) {
                                                        epsilon2.zoomSingle = (float)((double)epsilon2.zoomSingle - d);
                                                    }
                                                }
                                                epsilon5 = epsilon2;
                                            }
                                            if (epsilon5.zoomSingle > 1.0f) {
                                                System.out.println(PacketBuffer.ALLATORIxDEMO("\u0004y\u001at\u0019w"));
                                                class_4587 class_45872 = a;
                                                a.method_46416((float)(n4 + a2), (float)(n3 + a2), 0.0f);
                                                class_45872.method_22905(epsilon2.zoomSingle, epsilon2.zoomSingle, 1.0f);
                                                class_45872.method_46416((float)(-(n4 + a2)), (float)(-(n3 + a2)), 0.0f);
                                            }
                                            RenderSystem.setShaderTexture((int)0, (class_2960)single);
                                            RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
                                            RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
                                            class_4587 class_45873 = a;
                                            Render2DUtil.drawRound(class_45873, n4, n3, FontRenderers.Arial.getWidth(MathUtil.ALLATORIxDEMO("\"\u0004\u001c\t\u0004\u0011\u001d\u001d\u000f\u000b\n\u0001")), FontRenderers.Arial.getFontHeight(), 4.0f, new Color(255, 255, 255, 120));
                                            FontRenderers.Arial.drawString(a3.method_51448(), PacketBuffer.ALLATORIxDEMO("8e\u0006h\u001ep\u0007|\u0015j\u0010`"), n4, n3, 16777215);
                                            class_45873.method_22909();
                                            class_45873.method_22903();
                                            if (!epsilon2.isMouseHoveringRect((float)(n4 += (int)((double)a2 + 0.2 * (double)a2 + (double)n5)), (float)n3, a2, (int)a4, (int)a5)) break block11;
                                            if (!(epsilon2.zoomMulti < f2)) break block12;
                                            Epsilon epsilon16 = epsilon2;
                                            epsilon4 = epsilon16;
                                            epsilon16.zoomMulti = (float)((double)epsilon16.zoomMulti + d);
                                            break block13;
                                        }
                                        if ((double)epsilon2.zoomMulti > 1.0) {
                                            epsilon2.zoomMulti = (float)((double)epsilon2.zoomMulti - d);
                                        }
                                    }
                                    epsilon4 = epsilon2;
                                }
                                if (epsilon4.zoomMulti > 1.0f) {
                                    System.out.println(MathUtil.ALLATORIxDEMO("\u001c\u001b\u001b\u0003\u0007"));
                                    class_4587 class_45874 = a;
                                    a.method_46416((float)(n4 + a2), (float)(n3 + a2), 0.0f);
                                    class_45874.method_22905(Math.min(f2, epsilon2.zoomMulti), Math.min(f2, epsilon2.zoomMulti), 1.0f);
                                    class_45874.method_46416((float)(-(n4 + a2)), (float)(-(n3 + a2)), 0.0f);
                                }
                                RenderSystem.setShaderTexture((int)0, (class_2960)multi);
                                RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
                                RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
                                class_4587 class_45875 = a;
                                int n6 = a2;
                                a3.method_25291(multi, n4, n3, 0, 0.0f, 0.0f, n6, n6, n6, n6);
                                class_45875.method_22909();
                                class_45875.method_22903();
                                if (!epsilon2.isMouseHoveringRect((float)(n4 += (int)((double)a2 + 0.2 * (double)a2 + (double)n5)), (float)n3, a2, (int)a4, (int)a5)) break block14;
                                if (!(epsilon2.zoomSetting < f2)) break block15;
                                Epsilon epsilon17 = epsilon2;
                                epsilon3 = epsilon17;
                                epsilon17.zoomSetting = (float)((double)epsilon17.zoomSetting + d);
                                break block16;
                            }
                            if ((double)epsilon2.zoomSetting > 1.0) {
                                epsilon2.zoomSetting = (float)((double)epsilon2.zoomSetting - d);
                            }
                        }
                        epsilon3 = epsilon2;
                    }
                    if (epsilon3.zoomSetting > 1.0f) {
                        class_4587 class_45876 = a;
                        a.method_46416((float)(n4 + a2), (float)(n3 + a2), 0.0f);
                        class_45876.method_22905(Math.min(f2, epsilon2.zoomSetting), Math.min(f2, epsilon2.zoomSetting), 1.0f);
                        class_45876.method_46416((float)(-(n4 + a2)), (float)(-(n3 + a2)), 0.0f);
                    }
                    RenderSystem.setShaderTexture((int)0, (class_2960)setting);
                    RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
                    RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
                    class_4587 class_45877 = a;
                    int n7 = a2;
                    a3.method_25291(setting, n4, n3, 0, 0.0f, 0.0f, n7, n7, n7, n7);
                    class_45877.method_22909();
                    class_45877.method_22903();
                    if (!epsilon2.isMouseHoveringRect((float)(n4 += (int)((double)a2 + 0.2 * (double)a2 + (double)n5)), (float)n3, a2, (int)a4, (int)a5)) break block17;
                    if (!(epsilon2.zoomExit < f2)) break block18;
                    Epsilon epsilon18 = epsilon2;
                    epsilon = epsilon18;
                    epsilon18.zoomExit = (float)((double)epsilon18.zoomExit + d);
                    break block19;
                }
                if ((double)epsilon2.zoomExit > 1.0) {
                    epsilon2.zoomExit = (float)((double)epsilon2.zoomExit - d);
                }
            }
            epsilon = epsilon2;
        }
        if (epsilon.zoomExit > 1.0f) {
            class_4587 class_45878 = a;
            a.method_46416((float)(n4 + a2), (float)(n3 + a2), 0.0f);
            class_45878.method_22905(Math.min(f2, epsilon2.zoomExit), Math.min(f2, epsilon2.zoomExit), 1.0f);
            class_45878.method_46416((float)(-(n4 + a2)), (float)(-(n3 + a2)), 0.0f);
        }
        RenderSystem.setShaderTexture((int)0, (class_2960)exit);
        RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
        RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
        int n8 = a2;
        a3.method_25291(exit, n4, n3, 0, 0.0f, 0.0f, n8, n8, n8, n8);
        a.method_22909();
    }

    /*
     * WARNING - void declaration
     */
    public boolean isMouseHoveringRect(float f, float f2, int n, int n2, int n3) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n4 = n3;
        Epsilon a6 = this;
        return (float)a5 >= a2 && (float)a >= a4 && (float)a5 <= a2 + (float)a3 && (float)a <= a4 + (float)a3;
    }

    static {
        sky = new class_2960(PacketBuffer.ALLATORIxDEMO("`F=2X\u001fe\u0007a]f\u001ciZc\u001bu"));
        station = new class_2960(MathUtil.ALLATORIxDEMO("\u0011\u001c\u001c\u0018\t[Z+6^\u001e\u0006\u000f\u001c\u001d\u0002\u001f@\u0002\u0001\u0014"));
        pillar = new class_2960(PacketBuffer.ALLATORIxDEMO("\u001ca\u0001eT&7V\u0005#\u0018f\u001ey\u0016bZc\u001bu"));
        moon = new class_2960(MathUtil.ALLATORIxDEMO("\u001d\u001b@_%,\u0018\u0002\u001cA\u0005\u001b\u0002\u001f@\u0002\u0001\u0014"));
        setting = new class_2960(PacketBuffer.ALLATORIxDEMO("p\u0006}\u0002hA;1WD\r{\u0006|\u0019wZc\u001bu"));
        exit = new class_2960(MathUtil.ALLATORIxDEMO("\u001d\u001b@_%,\u0018\u0002\u001cA\r\f\u0004\u0005@\u0002\u0001\u0014"));
        single = new class_2960(PacketBuffer.ALLATORIxDEMO("\u001ca\u0001eT&7V\u0005#\u001bf\u001cr\u001buZc\u001bu"));
        multi = new class_2960(MathUtil.ALLATORIxDEMO("\u001a\u0007\u0007CR01\u001e\u0003]\u0003\u001d\u0018\u0019\u0018@\u0002\u0001\u0014"));
    }

    /*
     * WARNING - void declaration
     */
    public boolean method_25402(double d, double d2, int n) {
        Epsilon epsilon;
        void a;
        void a2;
        void a3;
        Epsilon epsilon2 = epsilon = this;
        float f = (float)epsilon2.field_22789 / 2.0f;
        int a4 = epsilon2.field_22790 / 12;
        int n2 = epsilon2.field_22789 / 4;
        int n3 = (epsilon2.field_22790 - a4) / 2;
        int n4 = (int)((f - (float)(4 * a4)) / 5.0f);
        if (a3 == false) {
            if (epsilon.isMouseHoveringRect((float)n2, (float)n3, a4, (double)a, (double)a2)) {
                epsilon.field_22787.method_1507((class_437)new class_526((class_437)epsilon));
            }
            if (epsilon.isMouseHoveringRect((float)(n2 += (int)((double)a4 + 0.2 * (double)a4 + (double)n4)), (float)n3, a4, (double)a, (double)a2)) {
                if (!Wrapper.mc.field_1690.field_21840) {
                    Wrapper.mc.field_1690.field_21840 = true;
                    Wrapper.mc.field_1690.method_1640();
                }
                class_500 class_5002 = new class_500((class_437)epsilon);
                Wrapper.mc.method_1507((class_437)class_5002);
            }
            if (epsilon.isMouseHoveringRect((float)(n2 += (int)((double)a4 + 0.2 * (double)a4 + (double)n4)), (float)n3, a4, (double)a, (double)a2)) {
                Wrapper.mc.method_1507((class_437)new class_429((class_437)epsilon, Wrapper.mc.field_1690));
            }
            if (epsilon.isMouseHoveringRect((float)(n2 += (int)((double)a4 + 0.2 * (double)a4 + (double)n4)), (float)n3, a4, (double)a, (double)a2)) {
                Wrapper.mc.method_1490();
            }
        }
        return super.method_25402((double)a, (double)a2, (int)a3);
    }

    public Epsilon() {
        Epsilon a;
        Epsilon epsilon = a;
        Epsilon epsilon2 = a;
        super((class_2561)class_2561.method_43471((String)MathUtil.ALLATORIxDEMO("\u0016\u000e\u0001\u0006\t[\\6v\u0002\u000e\u0000\u000b\r\u001aC\u0005\u0007\u0006\u0003\u0016")));
        epsilon2.zoomSingle = 1.0f;
        epsilon2.zoomMulti = 1.0f;
        epsilon.zoomSetting = 1.0f;
        epsilon.zoomExit = 1.0f;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isMouseHoveringRect(float f, float f2, int n, double d, double d2) {
        void a;
        void a2;
        void a3;
        void a4;
        int a5 = n;
        Epsilon a6 = this;
        return a2 >= (double)a && a4 >= (double)a3 && a2 <= (double)(a + (float)a5) && a4 <= (double)(a3 + (float)a5);
    }
}
