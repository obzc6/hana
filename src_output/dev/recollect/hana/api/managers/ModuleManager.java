/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.Render3DEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.ExtraModule;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.AntiCheat;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.client.HUD;
import dev.recollect.hana.mod.modules.impl.client.IRC;
import dev.recollect.hana.mod.modules.impl.client.Indicator;
import dev.recollect.hana.mod.modules.impl.client.ModuleList;
import dev.recollect.hana.mod.modules.impl.client.OnlyNPIRC;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.client.dev.Cape;
import dev.recollect.hana.mod.modules.impl.client.dev.FontSetting;
import dev.recollect.hana.mod.modules.impl.client.dev.HealthBar;
import dev.recollect.hana.mod.modules.impl.client.dev.ItemsCount;
import dev.recollect.hana.mod.modules.impl.client.dev.ModuleListTest;
import dev.recollect.hana.mod.modules.impl.client.dev.Notify;
import dev.recollect.hana.mod.modules.impl.client.dev.ServerApply;
import dev.recollect.hana.mod.modules.impl.client.dev.TargetHud;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAssist;
import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.AntiPiston;
import dev.recollect.hana.mod.modules.impl.combat.AntiRegear;
import dev.recollect.hana.mod.modules.impl.combat.AntiWeakness;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.combat.AutoAnchor;
import dev.recollect.hana.mod.modules.impl.combat.AutoArmor;
import dev.recollect.hana.mod.modules.impl.combat.AutoBurrow;
import dev.recollect.hana.mod.modules.impl.combat.AutoCity;
import dev.recollect.hana.mod.modules.impl.combat.AutoCrystal;
import dev.recollect.hana.mod.modules.impl.combat.AutoEXP;
import dev.recollect.hana.mod.modules.impl.combat.AutoPot;
import dev.recollect.hana.mod.modules.impl.combat.AutoRegear;
import dev.recollect.hana.mod.modules.impl.combat.AutoTotem;
import dev.recollect.hana.mod.modules.impl.combat.AutoTrap;
import dev.recollect.hana.mod.modules.impl.combat.BedAura;
import dev.recollect.hana.mod.modules.impl.combat.Blocker;
import dev.recollect.hana.mod.modules.impl.combat.Burrow;
import dev.recollect.hana.mod.modules.impl.combat.Criticals;
import dev.recollect.hana.mod.modules.impl.combat.HoleFiller;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.combat.PistonCrystal;
import dev.recollect.hana.mod.modules.impl.combat.Quiver;
import dev.recollect.hana.mod.modules.impl.combat.Reach;
import dev.recollect.hana.mod.modules.impl.combat.SelfFill;
import dev.recollect.hana.mod.modules.impl.combat.SelfTrap;
import dev.recollect.hana.mod.modules.impl.combat.SilentDouble;
import dev.recollect.hana.mod.modules.impl.combat.Surround;
import dev.recollect.hana.mod.modules.impl.combat.TPAura;
import dev.recollect.hana.mod.modules.impl.combat.WebAura;
import dev.recollect.hana.mod.modules.impl.combat.WebCleaner;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.AlienCrystalBase;
import dev.recollect.hana.mod.modules.impl.combat.dev.AntiBurrow;
import dev.recollect.hana.mod.modules.impl.combat.dev.AntiCev;
import dev.recollect.hana.mod.modules.impl.combat.dev.AntiCrawl;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoCev;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoCityPlus;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoCrystalBase;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoOldBurrow;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoPush;
import dev.recollect.hana.mod.modules.impl.combat.dev.AutoWebPuls;
import dev.recollect.hana.mod.modules.impl.combat.dev.BurrowTest;
import dev.recollect.hana.mod.modules.impl.combat.dev.ExtraOldTrap;
import dev.recollect.hana.mod.modules.impl.combat.dev.HoleKickTest;
import dev.recollect.hana.mod.modules.impl.combat.dev.OffHand;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldBurrow;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldTrap;
import dev.recollect.hana.mod.modules.impl.combat.dev.PullCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.PushCleaner;
import dev.recollect.hana.mod.modules.impl.combat.dev.SuperWeb;
import dev.recollect.hana.mod.modules.impl.combat.dev.Superknockback;
import dev.recollect.hana.mod.modules.impl.combat.dev.TPAutoCrystal;
import dev.recollect.hana.mod.modules.impl.combat.dev.Testweb;
import dev.recollect.hana.mod.modules.impl.combat.dev.TriggerBot;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaCrystalBase;
import dev.recollect.hana.mod.modules.impl.exploit.AntiHunger;
import dev.recollect.hana.mod.modules.impl.exploit.AutoDupe;
import dev.recollect.hana.mod.modules.impl.exploit.Blink;
import dev.recollect.hana.mod.modules.impl.exploit.BowBomb;
import dev.recollect.hana.mod.modules.impl.exploit.FakeLag;
import dev.recollect.hana.mod.modules.impl.exploit.ForceSync;
import dev.recollect.hana.mod.modules.impl.exploit.Godmode;
import dev.recollect.hana.mod.modules.impl.exploit.HitboxDesync;
import dev.recollect.hana.mod.modules.impl.exploit.MineTweak;
import dev.recollect.hana.mod.modules.impl.exploit.PacketControl;
import dev.recollect.hana.mod.modules.impl.exploit.RaytraceBypass;
import dev.recollect.hana.mod.modules.impl.exploit.ServerLagger;
import dev.recollect.hana.mod.modules.impl.exploit.dev.AntiBowBomb;
import dev.recollect.hana.mod.modules.impl.exploit.dev.AntiDMG;
import dev.recollect.hana.mod.modules.impl.exploit.dev.AutoAbuse;
import dev.recollect.hana.mod.modules.impl.exploit.dev.BoxExtend;
import dev.recollect.hana.mod.modules.impl.exploit.dev.ChorusExploit;
import dev.recollect.hana.mod.modules.impl.exploit.dev.FakePearl;
import dev.recollect.hana.mod.modules.impl.exploit.dev.HnadSync;
import dev.recollect.hana.mod.modules.impl.exploit.dev.NCPTeleport;
import dev.recollect.hana.mod.modules.impl.exploit.dev.NoBadEffects;
import dev.recollect.hana.mod.modules.impl.exploit.dev.Phase;
import dev.recollect.hana.mod.modules.impl.exploit.dev.PingSpoof;
import dev.recollect.hana.mod.modules.impl.exploit.dev.PortalGod;
import dev.recollect.hana.mod.modules.impl.exploit.dev.StashFinder;
import dev.recollect.hana.mod.modules.impl.exploit.dev.TeleportWeb;
import dev.recollect.hana.mod.modules.impl.exploit.dev.WallClip;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AntiSpam;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoEZ;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoPearl;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoReconnect;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoSpam;
import dev.recollect.hana.mod.modules.impl.miscellaneous.BaseFinder;
import dev.recollect.hana.mod.modules.impl.miscellaneous.BedCrafter;
import dev.recollect.hana.mod.modules.impl.miscellaneous.ChatEncrypter;
import dev.recollect.hana.mod.modules.impl.miscellaneous.ChatSuffix;
import dev.recollect.hana.mod.modules.impl.miscellaneous.ExceptionPatcher;
import dev.recollect.hana.mod.modules.impl.miscellaneous.FakePlayer;
import dev.recollect.hana.mod.modules.impl.miscellaneous.MCF;
import dev.recollect.hana.mod.modules.impl.miscellaneous.MCP;
import dev.recollect.hana.mod.modules.impl.miscellaneous.NoServerRP;
import dev.recollect.hana.mod.modules.impl.miscellaneous.NoSoundLag;
import dev.recollect.hana.mod.modules.impl.miscellaneous.Ping;
import dev.recollect.hana.mod.modules.impl.miscellaneous.PopCounter;
import dev.recollect.hana.mod.modules.impl.miscellaneous.PortalGui;
import dev.recollect.hana.mod.modules.impl.miscellaneous.ShulkerViewer;
import dev.recollect.hana.mod.modules.impl.miscellaneous.SilentDisconnect;
import dev.recollect.hana.mod.modules.impl.miscellaneous.Timer;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AntiBookBan;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AntiNCPMiss;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AutoEat;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AutoFish;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AutoLog;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.AutoQueue;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.PearlMark;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.PearlPhase;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.SideMask;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.TimerBypass;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.Tips;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.TrueDurability;
import dev.recollect.hana.mod.modules.impl.miscellaneous.dev.testNCPRay;
import dev.recollect.hana.mod.modules.impl.movement.AntiVoid;
import dev.recollect.hana.mod.modules.impl.movement.AutoWalk;
import dev.recollect.hana.mod.modules.impl.movement.BlockStrafe;
import dev.recollect.hana.mod.modules.impl.movement.BoatFly;
import dev.recollect.hana.mod.modules.impl.movement.BugClip;
import dev.recollect.hana.mod.modules.impl.movement.ElytraFly;
import dev.recollect.hana.mod.modules.impl.movement.ElytraFlyBypass;
import dev.recollect.hana.mod.modules.impl.movement.ElytraFlyPlus;
import dev.recollect.hana.mod.modules.impl.movement.FastFall;
import dev.recollect.hana.mod.modules.impl.movement.FastWeb;
import dev.recollect.hana.mod.modules.impl.movement.Flight;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import dev.recollect.hana.mod.modules.impl.movement.InventoryMove;
import dev.recollect.hana.mod.modules.impl.movement.NoFall;
import dev.recollect.hana.mod.modules.impl.movement.NoSlow;
import dev.recollect.hana.mod.modules.impl.movement.PacketElytra;
import dev.recollect.hana.mod.modules.impl.movement.PacketFly;
import dev.recollect.hana.mod.modules.impl.movement.SafeWalk;
import dev.recollect.hana.mod.modules.impl.movement.Scaffold;
import dev.recollect.hana.mod.modules.impl.movement.Speed;
import dev.recollect.hana.mod.modules.impl.movement.Sprint;
import dev.recollect.hana.mod.modules.impl.movement.Step;
import dev.recollect.hana.mod.modules.impl.movement.Strafe;
import dev.recollect.hana.mod.modules.impl.movement.TickShift;
import dev.recollect.hana.mod.modules.impl.movement.Velocity;
import dev.recollect.hana.mod.modules.impl.movement.dev.BlockUp;
import dev.recollect.hana.mod.modules.impl.movement.dev.BurrowHelper;
import dev.recollect.hana.mod.modules.impl.movement.dev.DamageFlyTest;
import dev.recollect.hana.mod.modules.impl.movement.dev.EntityControl;
import dev.recollect.hana.mod.modules.impl.movement.dev.FastSwim;
import dev.recollect.hana.mod.modules.impl.movement.dev.Flatten;
import dev.recollect.hana.mod.modules.impl.movement.dev.Glide;
import dev.recollect.hana.mod.modules.impl.movement.dev.GlidePuls;
import dev.recollect.hana.mod.modules.impl.movement.dev.GrimSpeed;
import dev.recollect.hana.mod.modules.impl.movement.dev.HoleSnapPlus;
import dev.recollect.hana.mod.modules.impl.movement.dev.Jesus;
import dev.recollect.hana.mod.modules.impl.movement.dev.MoveFix;
import dev.recollect.hana.mod.modules.impl.movement.dev.NewStep;
import dev.recollect.hana.mod.modules.impl.movement.dev.NoJumpDelay;
import dev.recollect.hana.mod.modules.impl.movement.dev.OldVClip;
import dev.recollect.hana.mod.modules.impl.movement.dev.PacketFly2;
import dev.recollect.hana.mod.modules.impl.movement.dev.Sneak;
import dev.recollect.hana.mod.modules.impl.movement.dev.Spider;
import dev.recollect.hana.mod.modules.impl.movement.dev.SprintPlus;
import dev.recollect.hana.mod.modules.impl.movement.dev.StrafeFix;
import dev.recollect.hana.mod.modules.impl.movement.dev.TimerDash;
import dev.recollect.hana.mod.modules.impl.movement.dev.VClip;
import dev.recollect.hana.mod.modules.impl.movement.dev.WebClimb;
import dev.recollect.hana.mod.modules.impl.player.AutoRespawn;
import dev.recollect.hana.mod.modules.impl.player.FakeGamemode;
import dev.recollect.hana.mod.modules.impl.player.FastUse;
import dev.recollect.hana.mod.modules.impl.player.NoRotateSet;
import dev.recollect.hana.mod.modules.impl.player.NoSwap;
import dev.recollect.hana.mod.modules.impl.player.PacketEat;
import dev.recollect.hana.mod.modules.impl.player.Replenish;
import dev.recollect.hana.mod.modules.impl.player.SpeedMine;
import dev.recollect.hana.mod.modules.impl.player.SpinBot;
import dev.recollect.hana.mod.modules.impl.player.XCarry;
import dev.recollect.hana.mod.modules.impl.player.dev.AutoTool;
import dev.recollect.hana.mod.modules.impl.player.dev.ChestStealer;
import dev.recollect.hana.mod.modules.impl.player.dev.Fucker;
import dev.recollect.hana.mod.modules.impl.player.dev.GhostHand;
import dev.recollect.hana.mod.modules.impl.player.dev.InventorySorter;
import dev.recollect.hana.mod.modules.impl.player.dev.NoInteract;
import dev.recollect.hana.mod.modules.impl.player.dev.RotateBypass;
import dev.recollect.hana.mod.modules.impl.player.dev.SmartEat;
import dev.recollect.hana.mod.modules.impl.player.dev.YawLock;
import dev.recollect.hana.mod.modules.impl.render.Ambience;
import dev.recollect.hana.mod.modules.impl.render.AnimSample;
import dev.recollect.hana.mod.modules.impl.render.AspectRatio;
import dev.recollect.hana.mod.modules.impl.render.BlockHighLight;
import dev.recollect.hana.mod.modules.impl.render.BlockerESP;
import dev.recollect.hana.mod.modules.impl.render.BreakESP;
import dev.recollect.hana.mod.modules.impl.render.CameraClip;
import dev.recollect.hana.mod.modules.impl.render.Crosshair;
import dev.recollect.hana.mod.modules.impl.render.CrystalChams;
import dev.recollect.hana.mod.modules.impl.render.CrystalPlaceESP;
import dev.recollect.hana.mod.modules.impl.render.CustomFov;
import dev.recollect.hana.mod.modules.impl.render.DesyncESP;
import dev.recollect.hana.mod.modules.impl.render.ESP;
import dev.recollect.hana.mod.modules.impl.render.FreeCam;
import dev.recollect.hana.mod.modules.impl.render.HitMarker;
import dev.recollect.hana.mod.modules.impl.render.HoleESP;
import dev.recollect.hana.mod.modules.impl.render.HotbarAnimation;
import dev.recollect.hana.mod.modules.impl.render.LogoutSpots;
import dev.recollect.hana.mod.modules.impl.render.NameTags;
import dev.recollect.hana.mod.modules.impl.render.NoInterp;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.impl.render.PlaceRender;
import dev.recollect.hana.mod.modules.impl.render.PopChams;
import dev.recollect.hana.mod.modules.impl.render.Shader;
import dev.recollect.hana.mod.modules.impl.render.SwingModifer;
import dev.recollect.hana.mod.modules.impl.render.TotemAnimation;
import dev.recollect.hana.mod.modules.impl.render.TotemParticle;
import dev.recollect.hana.mod.modules.impl.render.Trajectories;
import dev.recollect.hana.mod.modules.impl.render.TwoDESP;
import dev.recollect.hana.mod.modules.impl.render.ViewModel;
import dev.recollect.hana.mod.modules.impl.render.Zoom;
import dev.recollect.hana.mod.modules.impl.render.dev.AutoDrawDistance;
import dev.recollect.hana.mod.modules.impl.render.dev.BAHalo;
import dev.recollect.hana.mod.modules.impl.render.dev.BlinkDetect;
import dev.recollect.hana.mod.modules.impl.render.dev.BoomHit;
import dev.recollect.hana.mod.modules.impl.render.dev.CircleModule;
import dev.recollect.hana.mod.modules.impl.render.dev.CrystalRenderer;
import dev.recollect.hana.mod.modules.impl.render.dev.CustomWeather;
import dev.recollect.hana.mod.modules.impl.render.dev.DamageTint;
import dev.recollect.hana.mod.modules.impl.render.dev.ExplosionSpawn;
import dev.recollect.hana.mod.modules.impl.render.dev.ForceSneak;
import dev.recollect.hana.mod.modules.impl.render.dev.ItemTag;
import dev.recollect.hana.mod.modules.impl.render.dev.KillEffects;
import dev.recollect.hana.mod.modules.impl.render.dev.NoBackground;
import dev.recollect.hana.mod.modules.impl.render.dev.NoTerrainScreen;
import dev.recollect.hana.mod.modules.impl.render.dev.PearlPredict;
import dev.recollect.hana.mod.modules.impl.render.dev.PlayerRadar;
import dev.recollect.hana.mod.modules.impl.render.dev.Sakura;
import dev.recollect.hana.mod.modules.impl.render.dev.TNTExplosionTimer;
import dev.recollect.hana.mod.modules.impl.render.dev.Tracers;
import dev.recollect.hana.mod.modules.impl.render.dev.XRay;
import dev.recollect.hana.mod.modules.impl.render.freelook.FreeLook;
import dev.recollect.hana.mod.modules.impl.render.skybox.Skybox;
import dev.recollect.hana.mod.modules.impl.vanilla.VAnchorAura;
import dev.recollect.hana.mod.modules.impl.vanilla.VAutoCity;
import dev.recollect.hana.mod.modules.impl.vanilla.VSpeedMine;
import dev.recollect.hana.mod.modules.impl.vanilla.VWebAura;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;

public class ModuleManager
implements Wrapper {
    public final ArrayList<Module> modules;
    public ArrayList<ExtraModule> extraModules;
    public static Mod lastLoadMod;
    public final HashMap<Module.Category, Integer> categoryModules;

    public void addExtraModule(ExtraModule extraModule) {
        Wrapper a = extraModule;
        ModuleManager a2 = this;
        a2.extraModules.add((ExtraModule)a);
    }

    public ModuleManager() {
        ModuleManager a;
        ModuleManager moduleManager = a;
        ModuleManager moduleManager2 = a;
        moduleManager.modules = new ArrayList();
        moduleManager2.extraModules = new ArrayList();
        moduleManager.categoryModules = new HashMap();
        moduleManager.addExtraModule(new ExtraOldTrap());
        moduleManager.addModule(new testNCPRay());
        moduleManager.addModule(new SuperWeb());
        moduleManager.addModule(new PlayerRadar());
        moduleManager.addModule(new BurrowHelper());
        moduleManager.addModule(new HoleSnapPlus());
        moduleManager.addModule(new TimerDash());
        moduleManager.addModule(new NCPTeleport());
        moduleManager.addModule(new HoleKickTest());
        moduleManager.addModule(new DamageTint());
        moduleManager.addModule(new AutoDrawDistance());
        moduleManager.addModule(new SmartEat());
        moduleManager.addModule(new PushCleaner());
        moduleManager.addModule(new AntiCev());
        moduleManager.addModule(new HealthBar());
        moduleManager.addModule(new BAHalo());
        moduleManager.addModule(new TargetHud());
        moduleManager.addModule(new Flatten());
        moduleManager.addModule(new NewStep());
        moduleManager.addModule(new RotateBypass());
        moduleManager.addModule(new AutoPush());
        moduleManager.addModule(new ItemsCount());
        moduleManager.addModule(new ModuleListTest());
        moduleManager.addModule(new BlockUp());
        moduleManager.addModule(new ChorusExploit());
        moduleManager.addModule(new AutoQueue());
        moduleManager.addModule(new AutoWebPuls());
        moduleManager.addModule(new AntiBurrow());
        moduleManager.addModule(new AntiDMG());
        moduleManager.addModule(new Glide());
        moduleManager.addModule(new AutoTool());
        moduleManager.addModule(new AntiCrawl());
        moduleManager.addModule(new AutoCityPlus());
        moduleManager.addModule(new PullCrystal());
        moduleManager.addModule(new VClip());
        moduleManager.addModule(new ForceSneak());
        moduleManager.addModule(new OldBurrow());
        moduleManager.addModule(new AutoOldBurrow());
        moduleManager.addModule(new AnimSample());
        moduleManager.addModule(new Testweb());
        moduleManager.addModule(new OffHand());
        moduleManager.addModule(new Fucker());
        moduleManager.addModule(new PearlPhase());
        moduleManager.addModule(new FontSetting());
        moduleManager.addModule(new ServerApply());
        moduleManager.addModule(new NoTerrainScreen());
        moduleManager.addModule(new PortalGod());
        moduleManager.addModule(new ChestStealer());
        moduleManager.addModule(new BurrowTest());
        moduleManager.addModule(new Cape());
        moduleManager.addModule(new GlidePuls());
        moduleManager.addModule(new NoBadEffects());
        moduleManager.addModule(new TPAutoCrystal());
        moduleManager.addModule(new TeleportWeb());
        moduleManager.addModule(new TNTExplosionTimer());
        moduleManager.addModule(new StashFinder());
        moduleManager.addModule(new AntiNCPMiss());
        moduleManager.addModule(new TimerBypass());
        moduleManager.addModule(new DamageFlyTest());
        moduleManager.addModule(new OldVClip());
        moduleManager.addModule(new Sakura());
        moduleManager.addModule(new CustomWeather());
        moduleManager.addModule(new CircleModule());
        moduleManager.addModule(new BlinkDetect());
        moduleManager.addModule(new Tracers());
        moduleManager.addModule(new BoomHit());
        moduleManager.addModule(new XRay());
        moduleManager.addModule(new OldTrap());
        moduleManager.addModule(new CrystalRenderer());
        moduleManager.addModule(new HanaCrystalBase());
        moduleManager.addModule(new AutoCrystalBase());
        moduleManager.addModule(new AlienCrystalBase());
        moduleManager.addModule(new FakePearl());
        moduleManager.addModule(new PearlMark());
        moduleManager.addModule(new ItemTag());
        moduleManager.addModule(new TrueDurability());
        moduleManager.addModule(new PearlPredict());
        moduleManager.addModule(new KillEffects());
        moduleManager.addModule(new NoBackground());
        moduleManager.addModule(new MoveFix());
        moduleManager.addModule(new HanaAura());
        moduleManager.addModule(new YawLock());
        moduleManager.addModule(new ExplosionSpawn());
        moduleManager.addModule(new AlienCrystal());
        moduleManager.addModule(new WebClimb());
        moduleManager.addModule(new TriggerBot());
        moduleManager.addModule(new Sneak());
        moduleManager.addModule(new Spider());
        moduleManager.addModule(new SideMask());
        moduleManager.addModule(new GrimSpeed());
        moduleManager.addModule(new WallClip());
        moduleManager.addModule(new PingSpoof());
        moduleManager.addModule(new AntiBookBan());
        moduleManager.addModule(new Jesus());
        moduleManager.addModule(new FastSwim());
        moduleManager.addModule(new AutoEat());
        moduleManager.addModule(new Tips());
        moduleManager.addModule(new SprintPlus());
        moduleManager.addModule(new GhostHand());
        moduleManager.addModule(new StrafeFix());
        moduleManager.addModule(new PacketFly2());
        moduleManager.addModule(new HnadSync());
        moduleManager.addModule(new NoInteract());
        moduleManager.addModule(new BoxExtend());
        moduleManager.addModule(new AutoFish());
        moduleManager.addModule(new AutoLog());
        moduleManager.addModule(new NoJumpDelay());
        moduleManager.addModule(new Phase());
        moduleManager.addModule(new AutoCev());
        moduleManager.addModule(new AntiBowBomb());
        moduleManager.addModule(new InventorySorter());
        moduleManager.addModule(new Superknockback());
        moduleManager.addModule(new AutoAbuse());
        moduleManager.addModule(new Godmode());
        moduleManager.addModule(new FakeGamemode());
        moduleManager.addModule(new BoatFly());
        moduleManager.addModule(new Flight());
        moduleManager.addModule(new MineTweak());
        moduleManager.addModule(new AutoRespawn());
        moduleManager.addModule(new AutoAnchor());
        moduleManager.addModule(new AutoArmor());
        moduleManager.addModule(new HoleFiller());
        moduleManager.addModule(new FastWeb());
        moduleManager.addModule(new WebCleaner());
        moduleManager.addModule(new PacketElytra());
        moduleManager.addModule(new BugClip());
        moduleManager.addModule(new AutoPearl());
        moduleManager.addModule(new WebAura());
        moduleManager.addModule(new XCarry());
        moduleManager.addModule(new HoleESP());
        moduleManager.addModule(new ElytraFly());
        moduleManager.addModule(new PlaceRender());
        moduleManager.addModule(new BowBomb());
        moduleManager.addModule(new SilentDouble());
        moduleManager.addModule(new AntiWeakness());
        moduleManager.addModule(new AutoEZ());
        moduleManager.addModule(new AntiSpam());
        moduleManager.addModule(new ChatEncrypter());
        moduleManager.addModule(new ElytraFlyBypass());
        moduleManager.addModule(new ElytraFlyPlus());
        moduleManager.addModule(new PacketFly());
        moduleManager.addModule(new AutoSpam());
        moduleManager.addModule(new AutoCity());
        moduleManager.addModule(new EntityControl());
        moduleManager.addModule(new AutoDupe());
        moduleManager.addModule(new SilentDisconnect());
        moduleManager.addModule(new HoleSnap());
        moduleManager.addModule(new NoServerRP());
        moduleManager.addModule(new PacketEat());
        moduleManager.addModule(new Step());
        moduleManager.addModule(new Shader());
        moduleManager.addModule(new ServerLagger());
        ModuleManager moduleManager3 = a;
        moduleManager3.addModule(new Strafe());
        moduleManager3.addModule(new AutoBurrow());
        moduleManager3.addModule(new Zoom());
        moduleManager3.addModule(new Scaffold());
        moduleManager3.addModule(new BedAura());
        moduleManager3.addModule(new DesyncESP());
        moduleManager3.addModule(new RaytraceBypass());
        moduleManager3.addModule(new CrystalChams());
        moduleManager3.addModule(new NoRender());
        moduleManager3.addModule(new FastUse());
        moduleManager3.addModule(new ModuleList());
        moduleManager3.addModule(new Reach());
        moduleManager3.addModule(new HotbarAnimation());
        moduleManager3.addModule(new PopCounter());
        moduleManager3.addModule(new SpeedMine());
        moduleManager3.addModule(new UIModule());
        moduleManager3.addModule(new CameraClip());
        moduleManager3.addModule(new CustomFov());
        moduleManager3.addModule(new ChatSuffix());
        moduleManager3.addModule(new FastFall());
        moduleManager3.addModule(new AutoTrap());
        moduleManager3.addModule(new AspectRatio());
        moduleManager3.addModule(new PacketControl());
        moduleManager3.addModule(new BlockHighLight());
        moduleManager3.addModule(new BlockerESP());
        moduleManager3.addModule(new Blocker());
        moduleManager3.addModule(new HUD());
        moduleManager3.addModule(new IRC());
        moduleManager3.addModule(new PopChams());
        moduleManager3.addModule(new Burrow());
        moduleManager3.addModule(new AutoCrystal());
        moduleManager3.addModule(new Sprint());
        moduleManager3.addModule(new TickShift());
        moduleManager3.addModule(new AutoEXP());
        moduleManager3.addModule(new AntiPiston());
        moduleManager3.addModule(new AntiRegear());
        moduleManager3.addModule(new Blink());
        moduleManager3.addModule(new NameTags());
        moduleManager3.addModule(new HoleKick());
        moduleManager3.addModule(new NoSwap());
        moduleManager3.addModule(new Velocity());
        moduleManager3.addModule(new VAnchorAura());
        moduleManager3.addModule(new VSpeedMine());
        moduleManager3.addModule(new VAutoCity());
        moduleManager3.addModule(new VWebAura());
        moduleManager3.addModule(new Trajectories());
        moduleManager3.addModule(new AntiHunger());
        moduleManager3.addModule(new LogoutSpots());
        moduleManager3.addModule(new PortalGui());
        moduleManager3.addModule(new CombatSetting());
        moduleManager3.addModule(new SelfTrap());
        moduleManager3.addModule(new NoInterp());
        moduleManager3.addModule(new AntiVoid());
        moduleManager3.addModule(new HitMarker());
        moduleManager3.addModule(new TotemAnimation());
        moduleManager3.addModule(new Crosshair());
        moduleManager3.addModule(new Indicator());
        moduleManager3.addModule(new Speed());
        moduleManager3.addModule(new ExceptionPatcher());
        moduleManager3.addModule(new ViewModel());
        moduleManager3.addModule(new AnchorAssist());
        moduleManager3.addModule(new SelfFill());
        moduleManager3.addModule(new SwingModifer());
        moduleManager3.addModule(new NoSoundLag());
        moduleManager3.addModule(new CrystalPlaceESP());
        moduleManager3.addModule(new InventoryMove());
        moduleManager3.addModule(new FakePlayer());
        moduleManager3.addModule(new FreeCam());
        moduleManager3.addModule(new Ping());
        moduleManager3.addModule(new AntiCheat());
        moduleManager3.addModule(new Surround());
        moduleManager3.addModule(new Aura());
        moduleManager3.addModule(new TPAura());
        moduleManager3.addModule(new ESP());
        moduleManager3.addModule(new Criticals());
        moduleManager3.addModule(new ShulkerViewer());
        moduleManager3.addModule(new AutoReconnect());
        moduleManager3.addModule(new AutoTotem());
        moduleManager3.addModule(new Quiver());
        moduleManager3.addModule(new AutoWalk());
        moduleManager3.addModule(new SpinBot());
        moduleManager3.addModule(new AutoRegear());
        moduleManager3.addModule(new PistonCrystal());
        moduleManager3.addModule(new SafeWalk());
        moduleManager3.addModule(new MCF());
        moduleManager3.addModule(new Ambience());
        moduleManager3.addModule(new AnchorAura());
        moduleManager3.addModule(new Skybox());
        moduleManager3.addModule(new NoSlow());
        moduleManager3.addModule(new ForceSync());
        moduleManager3.addModule(new NoFall());
        moduleManager3.addModule(new NoRotateSet());
        moduleManager3.addModule(new MCP());
        moduleManager3.addModule(new ChatSetting());
        moduleManager3.addModule(new BlockStrafe());
        moduleManager3.addModule(new BedCrafter());
        moduleManager3.addModule(new Timer());
        moduleManager3.addModule(new BaseFinder());
        moduleManager3.addModule(new TotemParticle());
        moduleManager3.addModule(new AutoPot());
        moduleManager3.addModule(new TwoDESP());
        moduleManager3.addModule(new BreakESP());
        moduleManager3.addModule(new FakeLag());
        moduleManager3.addModule(new FreeLook());
        moduleManager3.addModule(new HitboxDesync());
        moduleManager3.addModule(new Replenish());
        moduleManager3.addModule(new Notify());
        if (Hana.isdev) {
            a.addModule(new OnlyNPIRC());
        }
        a.modules.sort(Comparator.comparing(Mod::getName));
    }

    private static /* synthetic */ void lambda$render2D$13(class_332 class_3322, Module module) {
        Module a = module;
        class_332 a2 = class_3322;
        a.onRender2D(a2, class_310.method_1551().method_1488());
    }

    public void render3D(class_4587 class_45872) {
        ModuleManager a = class_45872;
        ModuleManager a2 = this;
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)2929);
        a.method_22903();
        a2.modules.stream().filter(Module::isOn).forEach(arg_0 -> ModuleManager.lambda$render3D$14((class_4587)a, arg_0));
        Hana.EVENT_BUS.post(new Render3DEvent((class_4587)a, mc.method_1488()));
        a.method_22909();
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        Iterator<ExtraModule> iterator = a2.extraModules.iterator();
        Iterator<ExtraModule> iterator2 = iterator;
        while (iterator2.hasNext()) {
            iterator.next().onRender3D((class_4587)a, class_310.method_1551().method_1488());
            iterator2 = iterator;
        }
    }

    public void onKeyReleased(int n) {
        int a = n;
        ModuleManager a2 = this;
        if (a == -1 || a == 0) {
            return;
        }
        a2.modules.forEach(module -> {
            Module a2 = module;
            int a3 = a;
            if (a2.getBind().getKey() == a3 && a2.getBind().isHoldEnable() && a2.getBind().hold) {
                a2.toggle();
                a2.getBind().hold = false;
            }
            a2.getSettings().stream().filter(a -> a instanceof BindSetting).map(a -> (BindSetting)a).filter(bindSetting -> {
                BindSetting a = bindSetting;
                int a2 = a3;
                return a.getKey() == a2;
            }).forEach(a -> a.setPressed(false));
        });
    }

    public void disableAll() {
        Object a;
        ModuleManager moduleManager = a;
        Object object = a = moduleManager.modules.iterator();
        while (object.hasNext()) {
            ((Module)a.next()).disable();
            object = a;
        }
    }

    private static /* synthetic */ void lambda$render3D$14(class_4587 class_45872, Module module) {
        Module a = module;
        class_4587 a2 = class_45872;
        a.onRender3D(a2, mc.method_1488());
    }

    public Module getModuleByName(String a) {
        Object a2;
        ModuleManager moduleManager = a2;
        for (Module module : moduleManager.modules) {
            if (!module.getName().equalsIgnoreCase(a)) continue;
            return module;
        }
        return null;
    }

    public void onKeyPressed(int n) {
        int a = n;
        ModuleManager a2 = this;
        if (a == -1 || a == 0 || ModuleManager.mc.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        a2.modules.forEach(module -> {
            Module a2 = module;
            int a3 = a;
            if (a2.getBind().getKey() == a3 && ModuleManager.mc.field_1755 == null) {
                a2.toggle();
                a2.getBind().hold = true;
            }
            a2.getSettings().stream().filter(a -> a instanceof BindSetting).map(a -> (BindSetting)a).filter(bindSetting -> {
                BindSetting a = bindSetting;
                int a2 = a3;
                return a.getKey() == a2;
            }).forEach(a -> a.setPressed(true));
        });
    }

    public boolean setBind(int a) {
        AtomicBoolean a2;
        ModuleManager moduleManager = a2;
        if (a == -1 || a == 0) {
            return false;
        }
        a2 = new AtomicBoolean(false);
        moduleManager.modules.forEach(a3 -> {
            int n = a;
            for (Setting a4 : ((Module)a3).getSettings()) {
                if (!(a4 instanceof BindSetting) || !((BindSetting)(a4 = (BindSetting)a4)).isListening()) continue;
                Setting setting = a4;
                ((BindSetting)setting).setKey(n);
                ((BindSetting)setting).setListening(false);
                if (((BindSetting)setting).getBind().equals(FadeUtils.ALLATORIxDEMO("%um5a!"))) {
                    ((BindSetting)a4).setKey(-1);
                }
                a2.set(true);
            }
        });
        return a2.get();
    }

    public void onLogin() {
        ModuleManager a;
        a.modules.stream().filter(Module::isOn).forEach(Module::onLogin);
    }

    public void onThread() {
        ModuleManager a;
        a.modules.stream().filter(Module::isOn).forEach(a2 -> {
            Module module = a2;
            try {
                module.onLogin();
                return;
            }
            catch (Exception a2) {
                a2.printStackTrace();
                if (CombatSetting.INSTANCE.debug.getValue()) {
                    CommandManager.sendChatMessage("\u00a74[" + module.getName() + "] An error has occurred:" + a2.getMessage());
                }
                return;
            }
        });
    }

    public void onLogout() {
        ModuleManager a;
        a.modules.stream().filter(Module::isOn).forEach(Module::onLogout);
    }

    public void onUpdate() {
        ModuleManager a;
        a.modules.stream().filter(Module::isOn).forEach(a2 -> {
            Module module = a2;
            try {
                module.onUpdate();
                return;
            }
            catch (Exception a2) {
                Exception exception = a2;
                exception.printStackTrace();
                CommandManager.sendChatMessage("\u00a74[!] " + exception.getMessage());
                return;
            }
        });
    }

    public void render2D(class_332 class_3322) {
        ModuleManager a = class_3322;
        ModuleManager a2 = this;
        a2.modules.stream().filter(Module::isOn).forEach(arg_0 -> ModuleManager.lambda$render2D$13((class_332)a, arg_0));
    }

    public void addModule(Module module) {
        Wrapper a = module;
        ModuleManager a2 = this;
        Wrapper wrapper = a;
        ModuleManager moduleManager = a2;
        ((Module)wrapper).add(((Module)wrapper).getBind());
        moduleManager.modules.add((Module)a);
        moduleManager.categoryModules.put(((Module)a).getCategory(), a2.categoryModules.getOrDefault((Object)((Module)a).getCategory(), 0) + 1);
    }
}
