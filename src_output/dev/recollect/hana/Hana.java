/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 */
package dev.recollect.hana;

import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.IListener;
import dev.recollect.hana.api.events.eventbus.LambdaListener;
import dev.recollect.hana.api.managers.AltManager;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.MineManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.managers.MusicManager;
import dev.recollect.hana.api.managers.PopManager;
import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.managers.ServerManager;
import dev.recollect.hana.api.managers.ShaderManager;
import dev.recollect.hana.api.managers.SpeedManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.managers.XrayManager;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.skid.Wink;
import dev.recollect.hana.socket.network.NpSocketManager;
import dev.recollect.hana.socket.network.SocketManager;
import dev.recollect.hana.xibao.XibaoPlusPlusConfig;
import java.io.PrintStream;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import net.fabricmc.api.ModInitializer;

public final class Hana
implements ModInitializer {
    public static final String LOG_NAME = "HanaClient";
    public static final String VERSION = "-RecollectWink-";
    public static String PREFIX = ";";
    public static final EventBus EVENT_BUS = new EventBus();
    public static ModuleManager MODULE;
    public static CommandManager COMMAND;
    public static AltManager ALT;
    public static GuiManager GUI;
    public static ConfigManager CONFIG;
    public static RotateManager ROTATE;
    public static MineManager BREAK;
    public static PopManager POP;
    public static SpeedManager SPEED;
    public static FriendManager FRIEND;
    public static TimerManager TIMER;
    public static ShaderManager SHADER;
    public static FPSManager FPS;
    public static SocketManager IRC;
    public static NpSocketManager NPIRC;
    public static ServerManager SERVER;
    public static XrayManager XRAY;
    public static MusicManager MUSIC;
    public static boolean loaded;
    public static boolean isdev;

    public void onInitialize() {
        try {
            Hana.load();
            XibaoPlusPlusConfig.loadConfig();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update() {
        String currentPlayerID = Wink.getCurrentPlayerID();
        MODULE.onUpdate();
        GUI.update();
        POP.update();
    }

    public static void load() {
        System.out.println("[HanaClient] Initializing MusicManager");
        System.out.println("[HanaClient] Initializing VideoPlayer");
        System.out.println("[HanaClient] Starting Client");
        System.out.println("[HanaClient] Register eventbus");
        EVENT_BUS.registerLambdaFactory("dev.recollect.hana", (lookupInMethod, klass) -> (MethodHandles.Lookup)lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        System.out.println("[HanaClient] Reading Settings");
        CONFIG = new ConfigManager();
        PREFIX = CONFIG.getString("prefix", ";");
        System.out.println("[HanaClient] Initializing Modules");
        MODULE = new ModuleManager();
        System.out.println("[HanaClient] Initializing Commands");
        COMMAND = new CommandManager();
        System.out.println("[HanaClient] Initializing GUI");
        GUI = new GuiManager();
        System.out.println("[HanaClient] Loading Alts");
        ALT = new AltManager();
        System.out.println("[HanaClient] Loading Friends");
        FRIEND = new FriendManager();
        System.out.println("[HanaClient] Loading RunManager");
        ROTATE = new RotateManager();
        System.out.println("[HanaClient] Loading BreakManager");
        BREAK = new MineManager();
        System.out.println("[HanaClient] Loading PopManager ");
        POP = new PopManager();
        System.out.println("[HanaClient] Loading TimerManager");
        TIMER = new TimerManager();
        System.out.println("[HanaClient] Loading ShaderManager");
        SHADER = new ShaderManager();
        System.out.println("[HanaClient] Loading FPSManager");
        FPS = new FPSManager();
        System.out.println("[HanaClient] Loading ServerManager");
        SERVER = new ServerManager();
        System.out.println("[HanaClient] Loading SpeedManager");
        SPEED = new SpeedManager();
        System.out.println("[HanaClient] Loading IRC");
        XRAY = new XrayManager();
        System.out.println("[HanaClient] Loading XRAY");
        IRC = new SocketManager();
        if (isdev) {
            System.out.println("[HanaClient] Loading NPIRC");
            NPIRC = new NpSocketManager();
        }
        System.out.println("[HanaClient] Loading Settings");
        CONFIG.loadSettings();
        System.out.println("[HanaClient] Initialized and ready to play!");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (loaded) {
                Hana.save();
            }
        }));
        loaded = true;
    }

    public static void unload() {
        loaded = false;
        if (HanaAura.thread != null && HanaAura.thread.isAlive()) {
            HanaAura.thread.stop();
        }
        System.out.println("[HanaClient] Unloading..");
        Hana.EVENT_BUS.listenerMap.clear();
        ConfigManager.resetModule();
        CONFIG = null;
        MODULE = null;
        COMMAND = null;
        GUI = null;
        ALT = null;
        FRIEND = null;
        ROTATE = null;
        POP = null;
        TIMER = null;
        XRAY = null;
        System.out.println("[HanaClient] Unloading success!");
    }

    public static void save() {
        System.out.println("[HanaClient] Saving...");
        CONFIG.saveSettings();
        FRIEND.saveFriends();
        ALT.saveAlts();
        XRAY.save();
        System.out.println("[HanaClient] Saving success!");
    }

    static {
        loaded = false;
        isdev = true;
    }

    public static final class clientType
    extends Enum<clientType> {
        public static final /* enum */ clientType Dev = new clientType();
        public static final /* enum */ clientType Beta = new clientType();
        public static final /* enum */ clientType Release = new clientType();
        private static final /* synthetic */ clientType[] $VALUES;

        public static clientType[] values() {
            return (clientType[])$VALUES.clone();
        }

        public static clientType valueOf(String name) {
            return Enum.valueOf(clientType.class, name);
        }

        private static /* synthetic */ clientType[] $values() {
            return new clientType[]{Dev, Beta, Release};
        }

        static {
            $VALUES = clientType.$values();
        }
    }

}
