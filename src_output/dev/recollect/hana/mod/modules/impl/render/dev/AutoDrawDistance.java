/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Platform
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.ints.IntListIterator
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_7172
 *  net.minecraft.class_7172$class_7174
 *  net.minecraft.class_7172$class_7178
 *  net.minecraft.class_7172$class_7277
 *  net.minecraft.class_7172$class_7303
 *  net.minecraft.class_746
 *  net.minecraft.class_761
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.sun.jna.Platform;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.asm.mixins.GameOptionsAccessor;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import java.util.function.Consumer;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_7172;
import net.minecraft.class_746;
import net.minecraft.class_761;
import org.bytedeco.javacv.BufferRing;

public class AutoDrawDistance
extends Module {
    private final SliderSetting minDistance;
    private int justIncreased;
    private final BooleanSetting verbose;
    private final SliderSetting sweetSpotDelay;
    private final BooleanSetting reportFPS;
    private int timer;
    private final SliderSetting fpsTarget;
    private final IntArrayList fpsData;
    private final SliderSetting maxDistance;
    private boolean sweetSpot;
    private int sweetSpotCounter;

    public AutoDrawDistance() {
        AutoDrawDistance a;
        AutoDrawDistance autoDrawDistance = a;
        AutoDrawDistance autoDrawDistance2 = a;
        AutoDrawDistance autoDrawDistance3 = a;
        AutoDrawDistance autoDrawDistance4 = a;
        super(BufferRing.ALLATORIxDEMO("\u0002\u00021\u001eXZ(\n\n\u0013:\t5\u000e}O"), Module.Category.Render);
        autoDrawDistance4.timer = 0;
        autoDrawDistance4.justIncreased = 0;
        autoDrawDistance3.sweetSpotCounter = 0;
        autoDrawDistance3.sweetSpot = false;
        autoDrawDistance2.fpsData = new IntArrayList();
        autoDrawDistance2.fpsTarget = a.add(new SliderSetting(HoleUtils.ALLATORIxDEMO("JVj}wV|Gi"), 60.0, 30.0, 240.0, 5.0));
        autoDrawDistance2.minDistance = autoDrawDistance2.add(new SliderSetting(BufferRing.ALLATORIxDEMO("e \u0013\n\u0013:\t5\u000e}O"), 4.0, 2.0, 8.0, 1.0));
        autoDrawDistance2.maxDistance = autoDrawDistance2.add(new SliderSetting(HoleUtils.ALLATORIxDEMO("FRtbpZbEuAx"), 12.0, 10.0, 32.0, 1.0));
        autoDrawDistance2.sweetSpotDelay = autoDrawDistance2.add(new SliderSetting(BufferRing.ALLATORIxDEMO("\u0016\u0006yM=.>\u0015=91\fS"), 420.0, 20.0, 1000.0, 10.0));
        autoDrawDistance2.verbose = autoDrawDistance2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("RAyWz"), false));
        autoDrawDistance.reportFPS = autoDrawDistance.add(new BooleanSetting(BufferRing.ALLATORIxDEMO("/+\n&\u000f &nY"), false));
        autoDrawDistance.setChinese(HoleUtils.ALLATORIxDEMO("\u81c3\u52be\u7efc\u522d\u8dff\u79a6"));
    }

    @Override
    public void onDisable() {
        AutoDrawDistance a;
        AutoDrawDistance autoDrawDistance = a;
        autoDrawDistance.sweetSpotCounter = 0;
        autoDrawDistance.timer = 0;
    }

    private /* synthetic */ void updateDrawDistance(int a2) {
        AutoDrawDistance a322;
        AutoDrawDistance autoDrawDistance = a322;
        boolean a322 = Platform.is64Bit() && Runtime.getRuntime().maxMemory() >= 1000000000L;
        class_7172 a322 = new class_7172(BufferRing.ALLATORIxDEMO("=\u00165\u001c8\r\u0017~;\u0018=\u00031\u0012\u0005\u001c=\u000e\"\u0019&\u0014"), class_7172.method_42399(), (class_25612, n) -> {
            Object a = n;
            class_2561 a2 = class_25612;
            Object[] arrobject = new Object[1];
            arrobject[0] = a;
            return class_315.method_41783((class_2561)a2, (class_2561)class_2561.method_43469((String)BufferRing.ALLATORIxDEMO(";\u00105\u001c!\u00140Y&\u0019q^{W"), (Object[])arrobject));
        }, (class_7172.class_7178)new class_7172.class_7174(2, a322 ? 32 : 16), (Object)a2, a -> class_310.method_1551().field_1769.method_3292());
        ((GameOptionsAccessor)AutoDrawDistance.mc.field_1690).setViewDistance((class_7172<Integer>)a322);
        AutoDrawDistance.mc.field_1690.method_1643();
        if (autoDrawDistance.verbose.getValue() && AutoDrawDistance.mc.field_1724 != null) {
            CommandManager.sendChatMessage("\u00a77Updated view distance to\u00a78: \u00a72" + a2 + "\u00a77.");
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void tryLowerDrawDistanceDynamic(int n, int n2) {
        void a;
        int a2 = n2;
        AutoDrawDistance a3 = this;
        if (a2 <= 0) {
            return;
        }
        if ((double)(a - a2) < a3.minDistance.getValue()) {
            a3.tryLowerDrawDistanceDynamic((int)a, a2 - 1);
            return;
        }
        a3.updateDrawDistance((int)(a - a2));
    }

    @Override
    public void onUpdate() {
        AutoDrawDistance autoDrawDistance;
        AutoDrawDistance a2;
        AutoDrawDistance autoDrawDistance2 = a2;
        if (autoDrawDistance2.fpsData.size() > 500) {
            autoDrawDistance2.fpsData.clear();
        }
        if (autoDrawDistance2.timer >= 65535) {
            autoDrawDistance2.timer = 0;
        }
        if (autoDrawDistance2.sweetSpot) {
            AutoDrawDistance autoDrawDistance3 = autoDrawDistance2;
            autoDrawDistance = autoDrawDistance3;
            ++autoDrawDistance3.sweetSpotCounter;
        } else {
            autoDrawDistance = autoDrawDistance2;
            autoDrawDistance2.sweetSpotCounter = 0;
        }
        if ((double)autoDrawDistance.sweetSpotCounter >= autoDrawDistance2.sweetSpotDelay.getValue()) {
            AutoDrawDistance autoDrawDistance4 = autoDrawDistance2;
            autoDrawDistance4.sweetSpot = false;
            autoDrawDistance4.sweetSpotCounter = 0;
        }
        int n = mc.method_47599();
        AutoDrawDistance autoDrawDistance5 = autoDrawDistance2;
        autoDrawDistance2.fpsData.add(n);
        ++autoDrawDistance5.timer;
        if (autoDrawDistance5.timer % 10 == 0) {
            int n2;
            IntListIterator intListIterator;
            n = (Integer)AutoDrawDistance.mc.field_1690.method_42503().method_41753();
            int a2 = 0;
            IntListIterator intListIterator2 = intListIterator = autoDrawDistance2.fpsData.iterator();
            while (intListIterator2.hasNext()) {
                n2 = (Integer)intListIterator.next();
                a2 += n2;
                intListIterator2 = intListIterator;
            }
            a2 /= autoDrawDistance2.fpsData.size();
            int n3 = 5;
            if (autoDrawDistance2.justIncreased > 0) {
                if (autoDrawDistance2.justIncreased >= 3 && (double)a2 >= autoDrawDistance2.fpsTarget.getValue() - (double)n3) {
                    autoDrawDistance2.sweetSpot = true;
                    autoDrawDistance2.justIncreased = 0;
                    autoDrawDistance2.sweetSpotCounter = 0;
                    if (autoDrawDistance2.verbose.getValue() && AutoDrawDistance.mc.field_1724 != null) {
                        if (autoDrawDistance2.reportFPS.getValue()) {
                            CommandManager.sendChatMessage("\u00a77Average FPS\u00a78: \u00a72" + a2);
                        }
                        CommandManager.sendChatMessage(HoleUtils.ALLATORIxDEMO("\u00ab\u001fRmHPxC}\u0010n#\u009b\u001cbCnVx\u0006jYyP\u00bc\u001a<"));
                        return;
                    }
                } else {
                    ++autoDrawDistance2.justIncreased;
                }
                return;
            }
            if (autoDrawDistance2.sweetSpot && (double)a2 >= autoDrawDistance2.fpsTarget.getValue() - (double)n3) {
                return;
            }
            if ((double)a2 >= autoDrawDistance2.fpsTarget.getValue() - (double)n3) {
                if ((double)n >= autoDrawDistance2.maxDistance.getValue()) {
                    return;
                }
                AutoDrawDistance autoDrawDistance6 = autoDrawDistance2;
                ++autoDrawDistance6.justIncreased;
                autoDrawDistance6.fpsData.clear();
                if (autoDrawDistance6.verbose.getValue() && autoDrawDistance2.reportFPS.getValue() && AutoDrawDistance.mc.field_1724 != null) {
                    CommandManager.sendChatMessage("\u00a77Average FPS\u00a78: \u00a72" + a2);
                }
                autoDrawDistance2.updateDrawDistance(n + 1);
                return;
            }
            n2 = autoDrawDistance2.fpsTarget.getValueInt();
            if (n2 - a2 <= n3) {
                return;
            }
            if ((double)n <= autoDrawDistance2.minDistance.getValue()) {
                return;
            }
            if (autoDrawDistance2.verbose.getValue() && autoDrawDistance2.reportFPS.getValue() && AutoDrawDistance.mc.field_1724 != null) {
                CommandManager.sendChatMessage("\u00a77Average FPS\u00a78: \u00a72" + a2);
            }
            AutoDrawDistance autoDrawDistance7 = autoDrawDistance2;
            autoDrawDistance7.fpsData.clear();
            if (autoDrawDistance7.timer < 250) {
                return;
            }
            if ((a2 = n2 - a2) <= 15) {
                autoDrawDistance2.tryLowerDrawDistanceDynamic(n, 2);
                return;
            }
            if (a2 <= 30) {
                autoDrawDistance2.tryLowerDrawDistanceDynamic(n, 4);
                return;
            }
            if (a2 <= 40) {
                autoDrawDistance2.tryLowerDrawDistanceDynamic(n, 6);
                return;
            }
            if (a2 <= 50) {
                autoDrawDistance2.tryLowerDrawDistanceDynamic(n, 8);
                return;
            }
            if (a2 <= 60) {
                autoDrawDistance2.tryLowerDrawDistanceDynamic(n, 10);
            }
        }
    }
}
