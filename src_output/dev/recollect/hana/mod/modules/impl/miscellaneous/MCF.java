/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_3966
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_124;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3966;

public class MCF
extends Module {
    public static MCF INSTANCE;
    boolean click;

    @Override
    public void onUpdate() {
        if (MCF.nullCheck()) {
            return;
        }
        if (MCF.mc.field_1729.method_35707()) {
            MCF a;
            if (!a.click) {
                a.onClick();
            }
            a.click = true;
            return;
        }
        a.click = false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ void onClick() {
        var1_1 = a;
        a = MCF.mc.field_1765;
        if (a == null || a.method_17783() != class_239.class_240.field_1331 || !(a instanceof class_3966) || !((var2_2 = ((class_3966)a).method_17782()) instanceof class_1657)) ** GOTO lbl14
        a = (class_1657)var2_2;
        if (FriendManager.isFriend(a.method_5477().getString())) {
            FriendManager.removeFriend(a.method_5477().getString());
            CommandManager.sendChatMessage(String.valueOf((Object)class_124.field_1061) + a.method_5477().getString() + String.valueOf((Object)class_124.field_1061) + " has been unfriended.");
            v0 = var1_1;
        } else {
            Hana.FRIEND.addFriend(a.method_5477().getString());
            CommandManager.sendChatMessage(String.valueOf((Object)class_124.field_1075) + a.method_5477().getString() + String.valueOf((Object)class_124.field_1060) + " has been friended.");
lbl14: // 2 sources:
            v0 = var1_1;
        }
        v0.click = true;
    }

    public MCF() {
        MCF a;
        MCF mCF = a;
        super(TimeHelper.ALLATORIxDEMO("24s"), Module.Category.Misc);
        mCF.click = false;
        mCF.setChinese(FadeUtils.ALLATORIxDEMO("\u4e5c\u950e\u5946\u53a1"));
        INSTANCE = mCF;
    }
}
