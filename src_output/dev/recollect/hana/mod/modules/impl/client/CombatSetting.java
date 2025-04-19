/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Placement;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;

public class CombatSetting
extends Module {
    public final SliderSetting boxSize;
    public final BooleanSetting packetPlace;
    public final BooleanSetting rotateSync;
    public static CombatSetting INSTANCE;
    public final SliderSetting tp;
    public final BooleanSetting invSwapBypass;
    public final BooleanSetting attackRotate;
    public final BooleanSetting debug;
    public final BooleanSetting randomPitch;
    public final EnumSetting<Placement> placement;
    public final SliderSetting rotateTime;
    public final BooleanSetting inventorySync;
    public final BooleanSetting lowVersion;
    public final BooleanSetting rotations;
    public final BooleanSetting obsMode;
    public final EnumSetting<SwingSide> swingMode;
    public final BooleanSetting test;
    public final SliderSetting attackDelay;

    @Override
    public boolean isOn() {
        return true;
    }

    public CombatSetting() {
        CombatSetting a;
        CombatSetting combatSetting = a;
        CombatSetting combatSetting2 = a;
        super(FadeUtils.ALLATORIxDEMO("pV\u0005\u000e\\\u001fi\tI\u0005IU\r"), Module.Category.Client);
        CombatSetting combatSetting3 = a;
        combatSetting3.invSwapBypass = combatSetting2.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("^`WLG~@@TuKP"), true));
        combatSetting2.lowVersion = combatSetting2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("@\u000e\nX"), false));
        combatSetting2.rotateSync = combatSetting2.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("M_kQvHVSb@"), true));
        combatSetting2.packetPlace = combatSetting2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("8\r^\u0000_\u0018m\u001dAX\u000f"), true));
        combatSetting2.randomPitch = combatSetting2.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("s~^{_o}l^oK"), false));
        combatSetting2.rotations = combatSetting2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("`Q\u0007\u001bo\u0004N\rI\u0018OU\u0019"), true));
        combatSetting2.attackRotate = combatSetting2.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("OUkQ|[PBqKxF"), false));
        combatSetting2.placement = combatSetting2.add(new EnumSetting<Placement>(FadeUtils.ALLATORIxDEMO("m\u0007[\u000fX\u001cEU\u001e"), Placement.Vanilla));
        combatSetting2.rotateTime = combatSetting2.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("M_kQvHQCaF"), 0.5, 0.0, 1.0, 0.01));
        combatSetting2.attackDelay = combatSetting2.add(new SliderSetting(FadeUtils.ALLATORIxDEMO(")\u0018I\nY\u0007y\u0014LZ\u0013"), 0.2, 0.0, 1.0, 0.01));
        combatSetting2.tp = combatSetting2.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("Xs"), 50.0, 0.0, 300.0, 0.01));
        combatSetting2.test = combatSetting2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("%EH\u001e"), true));
        combatSetting2.boxSize = combatSetting2.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("rmUVCvF"), 0.6, 0.0, 1.0, 0.01));
        combatSetting2.inventorySync = combatSetting2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("zW\u001e\tS\u001fU\u001eD\"YU\t"), false));
        combatSetting2.swingMode = combatSetting2.add(new EnumSetting<SwingSide>(NCPRaytracer.ALLATORIxDEMO("chYlJHEhF"), SwingSide.Server));
        combatSetting2.obsMode = combatSetting2.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("r)i?X\u0003V^\u0018"), false));
        combatSetting.debug = combatSetting2.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("|rlTxugSg]qCcM"), true));
        combatSetting.setChinese(FadeUtils.ALLATORIxDEMO("\u6269\u65b7\u8b85\u7f04"));
        INSTANCE = combatSetting;
    }

    @Override
    public void enable() {
        a.state = true;
    }

    public static double getOffset() {
        if (INSTANCE != null) {
            return CombatSetting.INSTANCE.boxSize.getValue() / 2.0;
        }
        return 0.3;
    }

    @Override
    public void disable() {
        a.state = true;
    }
}
