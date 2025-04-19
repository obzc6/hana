/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.SendMessageEvent;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;

public class ChatSuffix
extends Module {
    public static final String jeezSuffix = " | Jeez\u029c\u1d00ck/1.4";
    public static final String moonSuffix = "\u263d\ud835\udd10\ud835\udd2c\ud835\udd2c\ud835\udd2b";
    public static final String mioSuffix = "\u22c6 \u1d0d\u026a\u1d0f";
    public static final String AshSuffix = "\ud83d\udd25\u2090\u209b\u2095";
    public static final String m7thh4ckSuffix = " | \ud835\udcc27\ud835\udcc9\ud835\udcbd\ud835\udcbd4\ud835\udcb8\ud835\udcc0-$";
    public static ChatSuffix INSTANCE;
    public static final String nullPointSuffix = "\ud835\udd2b\ud835\udd32\ud835\udd29\ud835\udd29\ud835\udd2d\ud835\udd2c\ud835\udd26\ud835\udd2b\ud835\udd31";
    public static final String scannerSuffix = " | Scanner \u029c\u1d00\u1d04\u1d0b";
    public final BooleanSetting green;
    public static final String melonSuffix = "\ud835\udd10\ud835\udd22\ud835\udd29\ud835\udd2c\ud835\udd2b\ud835\udd05\ud835\udd22\ud835\udd31\ud835\udd1e";
    private final StringSetting message;

    @EventHandler
    public void onSendMessage(SendMessageEvent a) {
        Object a2;
        ChatSuffix chatSuffix = a2;
        if (ChatSuffix.nullCheck() || a.isCancelled()) {
            return;
        }
        a2 = a.message;
        if (((String)a2).startsWith(HoleUtils.ALLATORIxDEMO("/")) || ((String)a2).startsWith("!") || ((String)a2).endsWith(chatSuffix.message.getValue())) {
            return;
        }
        String string = chatSuffix.message.getValue();
        a.message = a2 = (String)a2 + " " + string;
    }

    public ChatSuffix() {
        ChatSuffix a;
        ChatSuffix chatSuffix = a;
        ChatSuffix chatSuffix2 = a;
        super(MathUtil.ALLATORIxDEMO("7\u0000\u0006\u000f4\u000e\u000e\u0012\u0010\u001d"), Module.Category.Misc);
        ChatSuffix chatSuffix3 = a;
        chatSuffix3.message = chatSuffix2.add(new StringSetting(HoleUtils.ALLATORIxDEMO("@n^tQd"), MathUtil.ALLATORIxDEMO("\u27273\t\u001a\u0018\u2725")));
        chatSuffix.green = chatSuffix2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("Y\\tZn"), false));
        chatSuffix.setChinese(MathUtil.ALLATORIxDEMO("\u8022\u595d\u5477\u7f65"));
        INSTANCE = chatSuffix;
    }

    public String getSuffix() {
        return null;
    }
}
