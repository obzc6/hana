/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class AutoSpam
extends Module {
    private final Random r;
    private final StringSetting custom;
    Timer timer;
    private final BooleanSetting heavy;
    private final SliderSetting delay;
    private static String[] kouzi = new String[0];
    private final BooleanSetting tell;
    private int lastNum;

    @Override
    public String getInfo() {
        AutoSpam a;
        return a.custom.getValue();
    }

    public AutoSpam() {
        AutoSpam a;
        AutoSpam autoSpam = a;
        super(NpSocketClient.ALLATORIxDEMO("z\u000el7Z9d("), Module.Category.Misc);
        autoSpam.r = new Random();
        autoSpam.custom = a.add(new StringSetting(Hole.ALLATORIxDEMO("-{D5"), NpSocketClient.ALLATORIxDEMO("d&V\u000by-g%d6")));
        autoSpam.delay = autoSpam.add(new SliderSetting(Hole.ALLATORIxDEMO("C\u0006vH)"), 1500, 0, 10000));
        autoSpam.heavy = autoSpam.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("\u0010l(s<"), false));
        a.tell = autoSpam.add(new BooleanSetting(Hole.ALLATORIxDEMO("7E<"), true));
        a.timer = new Timer();
        a.setChinese(NpSocketClient.ALLATORIxDEMO("\u81e3\u52e1\u5232\u5c0a"));
    }

    @Override
    public void onEnable() {
        AutoSpam a;
        a.timer.reset();
    }

    @Override
    public void onUpdate() {
        Object a2;
        AutoSpam autoSpam = a2;
        if (AutoSpam.nullCheck()) {
            return;
        }
        a2 = null;
        a2 = autoSpam.heavy.getValue() ? new BufferedReader(new InputStreamReader(Objects.requireNonNull(Hana.class.getClassLoader().getResourceAsStream(Hole.ALLATORIxDEMO("\fq\u0006p\u001f=Mn\n"))), StandardCharsets.UTF_8)) : new BufferedReader(new InputStreamReader(Objects.requireNonNull(Hana.class.getClassLoader().getResourceAsStream(NpSocketClient.ALLATORIxDEMO(",T\u000eb1'=}1"))), StandardCharsets.UTF_8));
        kouzi = ((BufferedReader)a2).lines().toList().toArray(new String[0]);
        AutoSpam autoSpam2 = autoSpam;
        if (autoSpam2.timer.passedMs(autoSpam2.delay.getValue())) {
            AutoSpam autoSpam3 = autoSpam;
            autoSpam3.timer.reset();
            int a2 = autoSpam3.r.nextInt(0, kouzi.length);
            if (a2 == autoSpam.lastNum) {
                a2 = a2 < kouzi.length - 1 ? a2 + 1 : 0;
            }
            AutoSpam autoSpam4 = autoSpam;
            autoSpam4.lastNum = a2;
            autoSpam4.send((String)(autoSpam4.tell.getValue() ? autoSpam.custom.getValue() + " " : "") + kouzi[a2] + (autoSpam.tell.getValue() ? "" : autoSpam.custom.getValue()));
        }
    }

    private /* synthetic */ void send(String string) {
        String a = string;
        AutoSpam a2 = this;
        if (a2.tell.getValue()) {
            AutoSpam.mc.field_1724.field_3944.method_45730("tell " + (String)a);
            return;
        }
        AutoSpam.mc.field_1724.field_3944.method_45729(a);
    }
}
