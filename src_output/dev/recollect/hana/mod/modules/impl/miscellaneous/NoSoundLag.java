/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PlaySoundEvent;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import java.util.ArrayList;
import net.minecraft.class_1113;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import org.bytedeco.javacv.BaseSettings;

public class NoSoundLag
extends Module {
    static final ArrayList<class_3414> armor = new ArrayList();
    private final BooleanSetting attack;
    public static NoSoundLag INSTANCE;
    private final BooleanSetting equip;
    private final BooleanSetting explode;

    @EventHandler
    public void onPlaySound(PlaySoundEvent playSoundEvent) {
        PlaySoundEvent a = playSoundEvent;
        NoSoundLag a2 = this;
        if (a2.equip.getValue()) {
            for (class_3414 class_34142 : armor) {
                if (a.sound.method_4775() != class_34142.method_14833()) continue;
                a.cancel();
                return;
            }
        }
        if (a2.explode.getValue() && a.sound.method_4775() == class_3417.field_15152.method_14833()) {
            a.cancel();
            return;
        }
        if (a2.attack.getValue() && (a.sound.method_4775() == class_3417.field_14625.method_14833() || a.sound.method_4775() == class_3417.field_14840.method_14833())) {
            a.cancel();
            return;
        }
    }

    static {
        armor.add(class_3417.field_21866);
        armor.add(class_3417.field_14684);
        armor.add(class_3417.field_15191);
        armor.add(class_3417.field_14966);
        armor.add(class_3417.field_15103);
        armor.add(class_3417.field_14761);
        armor.add(class_3417.field_14862);
        armor.add(class_3417.field_14581);
        armor.add(class_3417.field_14883);
    }

    public NoSoundLag() {
        NoSoundLag a;
        NoSoundLag noSoundLag = a;
        NoSoundLag noSoundLag2 = a;
        super(BaseSettings.ALLATORIxDEMO("ymng`N\\A_l"), Module.Category.Misc);
        NoSoundLag noSoundLag3 = a;
        noSoundLag3.equip = noSoundLag2.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("4`\u0012w%u\u000bh\u0015k"), true));
        noSoundLag2.explode = noSoundLag2.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("MmPTbZn"), true));
        noSoundLag.attack = noSoundLag2.add(new BooleanSetting(PacketBuffer.ALLATORIxDEMO("\u0016D\u000e|\u001fp"), true));
        noSoundLag.setChinese(BaseSettings.ALLATORIxDEMO("\u6c81\u6731\u58fd\u97cd\u536a"));
        INSTANCE = noSoundLag;
    }
}
