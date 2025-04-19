/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.xibao.Snow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendCommand
extends Command {
    /*
     * WARNING - void declaration
     */
    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        void a22322;
        Object a = list;
        FriendCommand a3 = this;
        if (a22322 == true) {
            ArrayList<String> arrayList = a;
            String a22322 = ((String)arrayList.get(arrayList.size() - 1)).toLowerCase();
            a = new ArrayList<String>();
            for (String arrstring2 : List.of(CameraState.ALLATORIxDEMO("_<P"), Snow.ALLATORIxDEMO("bb`"), CameraState.ALLATORIxDEMO(">W+@"), Snow.ALLATORIxDEMO("{hubx"))) {
                if (!a22322.equalsIgnoreCase(Hana.PREFIX + "friend") && !arrstring2.toLowerCase().startsWith(a22322)) continue;
                a.add(arrstring2);
            }
            int n2 = a.size();
            String[] arrstring = new String[n2];
            int a22322 = 0;
            Object object = a = a.iterator();
            while (object.hasNext()) {
                String string = (String)a.next();
                object = a;
                arrstring[a22322++] = string;
            }
            return arrstring;
        }
        return null;
    }

    public FriendCommand() {
        super(CameraState.ALLATORIxDEMO(";C;[6P"), Snow.ALLATORIxDEMO("]`z%d{dcih"), CameraState.ALLATORIxDEMO("\u000eW0P)\u000f\"Ya\u001b\u000e9\"K&M\u0004\u0015.\u001e\u0003U\u001bw|[4Q\f\u001d\u0006_3S=i"));
        FriendCommand a;
    }

    @Override
    public void runCommand(String[] arrstring) {
        String[] a = arrstring;
        String[] a2 = this;
        if (a.length == 0) {
            a2.sendUsage();
            return;
        }
        if (a[0].equals(Snow.ALLATORIxDEMO("{hubx"))) {
            FriendManager.friendList.clear();
            CommandManager.sendChatMessage(CameraState.ALLATORIxDEMO("\u00ebA\u000b\u2226O^\u00ddt\bP<\\7Q!\u001e4]\fgs\u00984Z>I}C7M=@"));
            return;
        }
        if (a[0].equals(Snow.ALLATORIxDEMO("aotx"))) {
            if (FriendManager.friendList.isEmpty()) {
                CommandManager.sendChatMessage(CameraState.ALLATORIxDEMO("\u00b5\u001b!7\u0013\u0002\u00f2[\u001fG;[6P\f3?V\"Iq\u009a8T?N,M"));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = true;
            Iterator<String> iterator = FriendManager.friendList.iterator();
            Iterator<String> iterator2 = iterator;
            while (iterator2.hasNext()) {
                String string = iterator.next();
                if (!bl) {
                    stringBuilder.append(Snow.ALLATORIxDEMO("+,"));
                }
                stringBuilder.append(string);
                bl = false;
                iterator2 = iterator;
            }
            CommandManager.sendChatMessage("\u00a7e[~] \u00a7bFriends\u00a7e:\u00a7a" + String.valueOf(stringBuilder));
            return;
        }
        if (a[0].equals(CameraState.ALLATORIxDEMO("_<P"))) {
            if (a.length == 2) {
                Hana.FRIEND.addFriend(a[1]);
                CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7b" + a[1] + (FriendManager.isFriend(a[1]) ? Snow.ALLATORIxDEMO("&\u00aalnf\u0000Iib`%hwklcbbh") : CameraState.ALLATORIxDEMO("u\u009e:]3MxV\u001av=\u001f$S7O4T<Z=P")));
                return;
            }
            a2.sendUsage();
            return;
        }
        if (a[0].equals(Snow.ALLATORIxDEMO("bb`"))) {
            if (a.length == 2) {
                FriendManager.removeFriend(a[1]);
                CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7b" + a[1] + (FriendManager.isFriend(a[1]) ? CameraState.ALLATORIxDEMO("y\u00923V9G_q6Z?\u001d7O4T<Z=P") : Snow.ALLATORIxDEMO("*\u00a6eelu'nENb'{khwklcbbh")));
                return;
            }
            a2.sendUsage();
            return;
        }
        if (a.length == 1) {
            CommandManager.sendChatMessage("\u00a7a[\u221a] \u00a7b" + a[0] + (FriendManager.isFriend(a[0]) ? CameraState.ALLATORIxDEMO("_\u00b42V\"\u001d7O4T<Z=P") : Snow.ALLATORIxDEMO("&\u00a0oIXb z%hwklcbbh")));
            return;
        }
        a2.sendUsage();
    }
}
