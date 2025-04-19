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
import dev.recollect.hana.api.utils.render.LogoDrawer;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import java.awt.Color;
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

public class Isolation
extends class_437 {
    float zoomMulti;
    private static final class_2960 moon;
    private static final class_2960 sky;
    private static final class_2960 exit;
    float zoomSingle;
    private static final class_2960 multi;
    float zoomSetting;
    float zoomExit;
    private static final class_2960 pillar;
    private static final class_2960 station;
    private static final class_2960 single;
    private static final class_2960 setting;

    /*
     * WARNING - void declaration
     */
    public boolean method_25402(double d, double d2, int n) {
        void a;
        void a2;
        void a3;
        Isolation isolation;
        Isolation isolation2 = isolation = this;
        float f = (float)isolation2.field_22789 / 2.0f;
        int a4 = isolation2.field_22790 / 12;
        int n2 = isolation2.field_22789 / 4 + 15;
        int n3 = (isolation2.field_22790 - a4) / 2;
        int n4 = (int)((f - (float)(4 * a4)) / 5.0f);
        if (a == false) {
            if (isolation.isMouseHoveringRect((float)n2, (float)n3, a4, (double)a3, (double)a2)) {
                isolation.field_22787.method_1507((class_437)new class_526((class_437)isolation));
            }
            if (isolation.isMouseHoveringRect((float)(n2 += (int)((double)a4 + 0.2 * (double)a4 + (double)n4)), (float)n3, a4, (double)a3, (double)a2)) {
                if (!Wrapper.mc.field_1690.field_21840) {
                    Wrapper.mc.field_1690.field_21840 = true;
                    Wrapper.mc.field_1690.method_1640();
                }
                class_500 class_5002 = new class_500((class_437)isolation);
                Wrapper.mc.method_1507((class_437)class_5002);
            }
            if (isolation.isMouseHoveringRect((float)(n2 += (int)((double)a4 + 0.2 * (double)a4 + (double)n4)), (float)n3, a4, (double)a3, (double)a2)) {
                Wrapper.mc.method_1507((class_437)new class_429((class_437)isolation, Wrapper.mc.field_1690));
            }
            if (isolation.isMouseHoveringRect((float)(n2 += (int)((double)a4 + 0.2 * (double)a4 + (double)n4)), (float)n3, a4, (double)a3, (double)a2)) {
                Wrapper.mc.method_1490();
            }
        }
        return super.method_25402((double)a3, (double)a2, (int)a);
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
        Isolation a6 = this;
        return (float)a5 >= a3 && (float)a4 >= a && (float)a5 <= a3 + (float)a2 && (float)a4 <= a + (float)a2;
    }

    /*
     * WARNING - void declaration
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        int n3;
        void a;
        float f2;
        Isolation isolation;
        int a2;
        class_4587 a3;
        Isolation isolation2;
        int n4;
        block23 : {
            block22 : {
                double d;
                block21 : {
                    int n5;
                    void a4;
                    Isolation isolation3;
                    void a5;
                    block20 : {
                        block19 : {
                            block18 : {
                                Isolation isolation4;
                                block17 : {
                                    block16 : {
                                        block15 : {
                                            Isolation isolation5;
                                            block14 : {
                                                block13 : {
                                                    block12 : {
                                                        isolation = this;
                                                        void v0 = a;
                                                        LogoDrawer.draw((class_332)v0, isolation.field_22789 / 4, isolation.field_22790 / 4, 1.0f);
                                                        Isolation isolation6 = isolation;
                                                        v0.method_25302(moon, 50, 15, 0, 0, isolation6.field_22789, isolation6.field_22790);
                                                        Isolation isolation7 = isolation;
                                                        Isolation isolation8 = isolation;
                                                        v0.method_25291(sky, 0, 0, 0, 0.0f, 0.0f, isolation7.field_22789, isolation7.field_22790, isolation8.field_22789, isolation8.field_22790);
                                                        Isolation isolation9 = isolation;
                                                        Isolation isolation10 = isolation;
                                                        v0.method_25291(station, (int)((a5 - isolation.field_22789) / 48), 30 + (a4 - isolation.field_22790 / 2) / 80, 0, 0.0f, 0.0f, isolation9.field_22789, isolation9.field_22790, isolation10.field_22789, isolation10.field_22790);
                                                        a3 = v0.method_51448();
                                                        RenderSystem.defaultBlendFunc();
                                                        Isolation isolation11 = isolation;
                                                        Isolation isolation12 = isolation;
                                                        float f3 = (float)isolation12.field_22789 / 2.0f;
                                                        a2 = isolation12.field_22790 / 12;
                                                        f2 = 1.2f;
                                                        n3 = isolation11.field_22789 / 4 + 25;
                                                        n4 = (isolation11.field_22790 - a2) / 2;
                                                        n5 = (int)((f3 - (float)(4 * a2)) / 5.0f);
                                                        d = 0.06;
                                                        (float)(1 - Math.abs((int)(a4 - isolation.field_22790 / 2)) / isolation.field_22790) / 255.0f;
                                                        a3.method_22903();
                                                        if (!isolation11.isMouseHoveringRect((float)n3, (float)n4, a2, (int)a5, (int)a4)) break block12;
                                                        if (!(isolation.zoomSingle < f2)) break block13;
                                                        Isolation isolation13 = isolation;
                                                        isolation5 = isolation13;
                                                        isolation13.zoomSingle = (float)((double)isolation13.zoomSingle + d);
                                                        break block14;
                                                    }
                                                    if ((double)isolation.zoomSingle > 1.0) {
                                                        isolation.zoomSingle = (float)((double)isolation.zoomSingle - d);
                                                    }
                                                }
                                                isolation5 = isolation;
                                            }
                                            if (isolation5.zoomSingle > 1.0f) {
                                                class_4587 class_45872 = a3;
                                                a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
                                                class_45872.method_22905(isolation.zoomSingle, isolation.zoomSingle, 1.0f);
                                                class_45872.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
                                            }
                                            RenderSystem.setShaderTexture((int)0, (class_2960)single);
                                            RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
                                            RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
                                            class_4587 class_45873 = a3;
                                            int n6 = a2;
                                            a.method_25291(single, n3, n4, 0, 0.0f, 0.0f, n6, n6, n6, n6);
                                            class_45873.method_22909();
                                            class_45873.method_22903();
                                            if (isolation.zoomSingle > 1.0f) {
                                                class_4587 class_45874 = a3;
                                                a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
                                                class_45874.method_22905(isolation.zoomSingle, isolation.zoomSingle, 1.0f);
                                                class_45874.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
                                                TextUtil.drawStringWithScale((class_332)a, ObsidianHelper.ALLATORIxDEMO("s\"C!T6U\"B1G;"), (float)(n3 + a2 / 2) - TextUtil.getWidth(Tab.ALLATORIxDEMO("j3:P?U%Z>E7C")), (float)n4 + (float)a2 + 1.0f, new Color(255, 255, 255, 255).getRGB(), 2.0f);
                                            }
                                            a3.method_22909();
                                            a3.method_22903();
                                            if (!isolation.isMouseHoveringRect((float)(n3 += (int)((double)a2 + 0.2 * (double)a2 + (double)n5)), (float)n4, a2, (int)a5, (int)a4)) break block15;
                                            if (!(isolation.zoomMulti < f2)) break block16;
                                            Isolation isolation14 = isolation;
                                            isolation4 = isolation14;
                                            isolation14.zoomMulti = (float)((double)isolation14.zoomMulti + d);
                                            break block17;
                                        }
                                        if ((double)isolation.zoomMulti > 1.0) {
                                            isolation.zoomMulti = (float)((double)isolation.zoomMulti - d);
                                        }
                                    }
                                    isolation4 = isolation;
                                }
                                if (isolation4.zoomMulti > 1.0f) {
                                    class_4587 class_45875 = a3;
                                    a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
                                    class_45875.method_22905(Math.min(f2, isolation.zoomMulti), Math.min(f2, isolation.zoomMulti), 1.0f);
                                    class_45875.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
                                }
                                RenderSystem.setShaderTexture((int)0, (class_2960)multi);
                                RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
                                RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
                                class_4587 class_45876 = a3;
                                int n7 = a2;
                                a.method_25291(multi, n3, n4, 0, 0.0f, 0.0f, n7, n7, n7, n7);
                                class_45876.method_22909();
                                class_45876.method_22903();
                                if (isolation.zoomMulti > 1.0f) {
                                    class_4587 class_45877 = a3;
                                    a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
                                    class_45877.method_22905(isolation.zoomMulti, isolation.zoomMulti, 1.0f);
                                    class_45877.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
                                    TextUtil.drawStringWithScale((class_332)a, ObsidianHelper.ALLATORIxDEMO("\u0006X*L:U\"B1G;"), (float)(n3 + a2 / 2) - TextUtil.getWidth(Tab.ALLATORIxDEMO("\u0017!['Y%Z>E7C")), (float)n4 + (float)a2 + 1.0f, new Color(255, 255, 255, 255).getRGB(), 2.0f);
                                }
                                a3.method_22909();
                                a3.method_22903();
                                if (!isolation.isMouseHoveringRect((float)(n3 += (int)((double)a2 + 0.2 * (double)a2 + (double)n5)), (float)n4, a2, (int)a5, (int)a4)) break block18;
                                if (!(isolation.zoomSetting < f2)) break block19;
                                Isolation isolation15 = isolation;
                                isolation3 = isolation15;
                                isolation15.zoomSetting = (float)((double)isolation15.zoomSetting + d);
                                break block20;
                            }
                            if ((double)isolation.zoomSetting > 1.0) {
                                isolation.zoomSetting = (float)((double)isolation.zoomSetting - d);
                            }
                        }
                        isolation3 = isolation;
                    }
                    if (isolation3.zoomSetting > 1.0f) {
                        class_4587 class_45878 = a3;
                        a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
                        class_45878.method_22905(Math.min(f2, isolation.zoomSetting), Math.min(f2, isolation.zoomSetting), 1.0f);
                        class_45878.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
                    }
                    RenderSystem.setShaderTexture((int)0, (class_2960)setting);
                    RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
                    RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
                    class_4587 class_45879 = a3;
                    int n8 = a2;
                    a.method_25291(setting, n3, n4, 0, 0.0f, 0.0f, n8, n8, n8, n8);
                    class_45879.method_22909();
                    class_45879.method_22903();
                    if (isolation.zoomSetting > 1.0f) {
                        class_4587 class_458710 = a3;
                        a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
                        class_458710.method_22905(isolation.zoomSetting, isolation.zoomSetting, 1.0f);
                        class_458710.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
                        TextUtil.drawStringWithScale((class_332)a, ObsidianHelper.ALLATORIxDEMO("\u0000@:W!L."), (float)(n3 + a2 / 2) - TextUtil.getWidth(Tab.ALLATORIxDEMO("c0B+U<V")), (float)n4 + (float)a2 + 1.0f, new Color(255, 255, 255, 255).getRGB(), 2.0f);
                    }
                    a3.method_22909();
                    a3.method_22903();
                    if (!isolation.isMouseHoveringRect((float)(n3 += (int)((double)a2 + 0.2 * (double)a2 + (double)n5)), (float)n4, a2, (int)a5, (int)a4)) break block21;
                    if (!(isolation.zoomExit < f2)) break block22;
                    Isolation isolation16 = isolation;
                    isolation2 = isolation16;
                    isolation16.zoomExit = (float)((double)isolation16.zoomExit + d);
                    break block23;
                }
                if ((double)isolation.zoomExit > 1.0) {
                    isolation.zoomExit = (float)((double)isolation.zoomExit - d);
                }
            }
            isolation2 = isolation;
        }
        if (isolation2.zoomExit > 1.0f) {
            class_4587 class_458711 = a3;
            a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
            class_458711.method_22905(Math.min(f2, isolation.zoomExit), Math.min(f2, isolation.zoomExit), 1.0f);
            class_458711.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
        }
        RenderSystem.setShaderTexture((int)0, (class_2960)exit);
        RenderSystem.texParameter((int)3553, (int)10241, (int)9729);
        RenderSystem.texParameter((int)3553, (int)10240, (int)9729);
        class_4587 class_458712 = a3;
        int n9 = a2;
        a.method_25291(exit, n3, n4, 0, 0.0f, 0.0f, n9, n9, n9, n9);
        class_458712.method_22909();
        class_458712.method_22903();
        if (isolation.zoomExit > 1.0f) {
            class_4587 class_458713 = a3;
            a3.method_46416((float)(n3 + a2), (float)(n4 + a2), 0.0f);
            class_458713.method_22905(isolation.zoomExit, isolation.zoomExit, 1.0f);
            class_458713.method_46416((float)(-(n3 + a2)), (float)(-(n4 + a2)), 0.0f);
            TextUtil.drawStringWithScale((class_332)a, ObsidianHelper.ALLATORIxDEMO("f0K="), (float)(n3 + a2 / 2) - TextUtil.getWidth(Tab.ALLATORIxDEMO("\u001aD;E")) - 2.0f, (float)n4 + (float)a2 + 1.0f, new Color(255, 255, 255, 255).getRGB(), 2.0f);
        }
        a3.method_22909();
        RenderSystem.disableBlend();
    }

    static {
        sky = new class_2960(ObsidianHelper.ALLATORIxDEMO("\u0007L;O)T\"B(\u0017 N7\r8L."));
        station = new class_2960(Tab.ALLATORIxDEMO("\u0005z\u0005d\n.Pj\b%\u001a{\r|\u0002`\u0002<\u00016\\"));
        pillar = new class_2960(ObsidianHelper.ALLATORIxDEMO("\u000bzj\u0002^ J'Nd]/T?D<\r8L."));
        moon = new class_2960(Tab.ALLATORIxDEMO("a\u00185Ud\u0012c\u0006aCe\u0004`\u0002<\u00016\\"));
        setting = new class_2960(ObsidianHelper.ALLATORIxDEMO(";\u0011fi\u000fK=L&\u000f8H2L:K)\r8L."));
        exit = new class_2960(Tab.ALLATORIxDEMO("a\u00185Ud\u0012c\u0006aCm\u0013f\u0018<\u00016\\"));
        single = new class_2960(ObsidianHelper.ALLATORIxDEMO("\u000bzj\u0002^ J'Nd^/V4I+\r8L."));
        multi = new class_2960(Tab.ALLATORIxDEMO("\u0003{\u00046Xq\u000fe\u0007 \u0001}\u0007{\u0005<\u00016\\"));
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
        Isolation a6 = this;
        return a4 >= (double)a3 && a >= (double)a2 && a4 <= (double)(a3 + (float)a5) && a <= (double)(a2 + (float)a5);
    }

    public Isolation() {
        Isolation a;
        Isolation isolation = a;
        Isolation isolation2 = a;
        super((class_2561)class_2561.method_43471((String)Tab.ALLATORIxDEMO("\ns\u0003}\r}\u0005zE)Z}\tm\u0005!\u0018{\u00054^")));
        isolation2.zoomSingle = 1.0f;
        isolation2.zoomMulti = 1.0f;
        isolation.zoomSetting = 1.0f;
        isolation.zoomExit = 1.0f;
    }
}
