/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_7439
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.SendMessageEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.asm.accessors.IGameMessageS2CPacket;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.miscellaneous.ChatSuffix;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import java.util.Base64;
import java.util.Objects;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_7439;

public class ChatEncrypter
extends Module {
    private final StringSetting prefix;
    private final BooleanSetting decrypt;
    private final BindSetting openbind;
    private final StringSetting key;
    public static ChatEncrypter INSTANCE;
    public final BooleanSetting encrypt;
    private boolean b;

    @Override
    public void onUpdate() {
        ChatEncrypter a;
        if (a.openbind.getKey() == -1) {
            return;
        }
        if (a.openbind.isPressed() && !a.b) {
            ChatEncrypter chatEncrypter;
            ChatEncrypter chatEncrypter2 = a;
            chatEncrypter2.encrypt.setValue(!chatEncrypter2.encrypt.getValue());
            if (a.encrypt.getValue()) {
                CommandManager.sendChatMessage(GameInfo.ALLATORIxDEMO("\u00aa}_*Le\u0000\u00b4m\u00b9i@gar-Pgrjyc"));
                chatEncrypter = a;
            } else {
                CommandManager.sendChatMessage(CrystalUtil.ALLATORIxDEMO("\u00d0I\u0007\u0006\b\u0010\u00e7b\u00d6E\u001eN$W$Q(\u0014\u0001^#S(F2"));
                chatEncrypter = a;
            }
            chatEncrypter.b = true;
        }
        if (!a.openbind.isPressed()) {
            a.b = false;
        }
    }

    public static String encrypt(String a3, String a2) {
        int n;
        String string = a3;
        a2 = a2.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = n = 0;
        while (n2 < string.length()) {
            int n3;
            char a3 = string.charAt(n);
            char[] arrc = a2;
            int n4 = arrc.length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                char c = arrc[n3];
                a3 = (char)(a3 ^ c);
                n5 = ++n3;
            }
            stringBuilder.append(a3);
            n2 = ++n;
        }
        return stringBuilder.toString();
    }

    @EventHandler
    public void onSendMessage(SendMessageEvent sendMessageEvent) {
        SendMessageEvent a = sendMessageEvent;
        ChatEncrypter a2 = this;
        if (ChatEncrypter.nullCheck() || a.isCancel()) {
            return;
        }
        if (!a2.encrypt.getValue()) {
            return;
        }
        if (ChatSuffix.INSTANCE.isOn() && ChatSuffix.INSTANCE.green.getValue()) {
            a.message = ">_" + a2.prefix.getValue() + "_" + Base64.getEncoder().encodeToString(ChatEncrypter.encrypt(a.message, a2.key.getValue()).getBytes());
            return;
        }
        a.message = "_" + a2.prefix.getValue() + "_" + Base64.getEncoder().encodeToString(ChatEncrypter.encrypt(a.message, a2.key.getValue()).getBytes());
    }

    public static String decrypt(String a3, String a2) {
        int n;
        String string = a3;
        a2 = a2.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = n = 0;
        while (n2 < string.length()) {
            int n3;
            char a3 = string.charAt(n);
            char[] arrc = a2;
            int n4 = arrc.length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                char c = arrc[n3];
                a3 = (char)(a3 ^ c);
                n5 = ++n3;
            }
            stringBuilder.append(a3);
            n2 = ++n;
        }
        return stringBuilder.toString();
    }

    @EventHandler
    private /* synthetic */ void PacketReceive(PacketEvent.Receive a) {
        Object a2;
        ChatEncrypter chatEncrypter = a2;
        if (ChatEncrypter.nullCheck()) {
            return;
        }
        if (!chatEncrypter.decrypt.getValue()) {
            return;
        }
        a2 = a.getPacket();
        if (a2 instanceof class_7439) {
            if (((String[])(a2 = ((class_7439)a2).comp_763().getString().split(GameInfo.ALLATORIxDEMO("H")))).length < 2) {
                return;
            }
            if (Objects.equals(a2[1], chatEncrypter.prefix.getValue())) {
                ((IGameMessageS2CPacket)a.getPacket()).setContent(class_2561.method_30163((String)("\u00a7(" + a2[0] + " " + ChatEncrypter.decrypt(new String(Base64.getDecoder().decode(a2[2])), chatEncrypter.key.getValue()))));
            }
        }
    }

    public ChatEncrypter() {
        ChatEncrypter a;
        ChatEncrypter chatEncrypter = a;
        ChatEncrypter chatEncrypter2 = a;
        super(GameInfo.ALLATORIxDEMO("EgvpYcv{hhtje"), Module.Category.Misc);
        a.b = false;
        ChatEncrypter chatEncrypter3 = a;
        chatEncrypter3.prefix = chatEncrypter2.add(new StringSetting(CrystalUtil.ALLATORIxDEMO("`2D7_>"), GameInfo.ALLATORIxDEMO("Ea~dg}y[hnc")));
        chatEncrypter2.key = chatEncrypter2.add(new StringSetting(CrystalUtil.ALLATORIxDEMO("\u001as\u001f"), "114514"));
        chatEncrypter2.encrypt = chatEncrypter2.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Pgrjyc"), true).setParent());
        chatEncrypter2.openbind = chatEncrypter2.add(new BindSetting(CrystalUtil.ALLATORIxDEMO("\u0015W2X\u0003S.F=@4c8X\""), -1));
        chatEncrypter.decrypt = chatEncrypter2.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("Qlrjyc"), true));
        chatEncrypter.setChinese(CrystalUtil.ALLATORIxDEMO("\u806b\u5978\u5296\u5b80"));
        INSTANCE = chatEncrypter;
    }
}
