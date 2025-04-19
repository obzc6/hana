/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.Pair
 *  it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.ServerConnectBeginEvent;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair;
import net.minecraft.class_639;
import net.minecraft.class_642;

public class AutoReconnect
extends Module {
    public static AutoReconnect INSTANCE;
    public Pair<class_639, class_642> lastServerConnection;
    public final SliderSetting delay;

    @EventHandler
    private /* synthetic */ void onGameJoined(ServerConnectBeginEvent serverConnectBeginEvent) {
        AutoReconnect a;
        ServerConnectBeginEvent a2 = serverConnectBeginEvent;
        AutoReconnect autoReconnect = a = this;
        autoReconnect.lastServerConnection = new ObjectObjectImmutablePair((Object)a2.getAddress(), (Object)a2.getInfo());
    }

    public AutoReconnect() {
        AutoReconnect a;
        AutoReconnect autoReconnect = a;
        super(GaussianKernel.ALLATORIxDEMO("\r'4<\u00136\"7$0)*/"), Module.Category.Misc);
        autoReconnect.delay = a.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\tn'}%"), 3, 0, 20));
        autoReconnect.setChinese(GaussianKernel.ALLATORIxDEMO("\u81b4\u52e4\u9184\u800f"));
        INSTANCE = autoReconnect;
    }
}
