/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.MusicManager;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.mod.commands.Command;
import dev.recollect.hana.skid.Start;
import java.util.List;

@Deprecated
public class PlaySongCommand
extends Command {
    public PlaySongCommand() {
        super(Start.ALLATORIxDEMO("[iM{Bp\u00152"), TimerManager.ALLATORIxDEMO("!/\u001f5\u0007fM>\n$\u0010+Y)\u001dvgX"), Start.ALLATORIxDEMO("\u0017vClVV\u001fk"));
        PlaySongCommand a;
    }

    @Override
    public String[] getAutocorrect(int n, List<String> list) {
        List<String> a = list;
        PlaySongCommand a2 = this;
        return new String[0];
    }

    @Override
    public void runCommand(String[] arrstring) {
        Object a = arrstring;
        String[] a2 = this;
        if (((String[])a).length < 1) {
            a2.sendUsage();
            return;
        }
        Hana.MUSIC.playSong((String)(a = a[0]), new MusicManager.Callback<String>((PlaySongCommand)a2){
            final /* synthetic */ PlaySongCommand this$0;

            @Override
            public void onSuccess(String string) {
                String a = string;
                1 a2 = this;
                CommandManager.sendChatMessage("Playing song with URL: " + (String)a);
            }

            @Override
            public void onError(String string) {
                String a = string;
                1 a2 = this;
                CommandManager.sendChatMessage("Error playing song: " + (String)a);
            }
            {
                PlaySongCommand a = playSongCommand;
                1 a2 = this;
                a2.this$0 = a;
            }
        });
    }

    @Override
    public void sendUsage() {
        CommandManager.sendChatMessage(TimerManager.ALLATORIxDEMO("\u00eb\u0015\u001er<_\u00ea\u001b\u001a\u000e.\u0016&Dl\u00d3#X!\u0019&\u0007?\u001b(\"W_\"\u001e-\u0010\f\u0011y"));
    }

}
