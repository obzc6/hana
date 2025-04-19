/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands.impl;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.MusicManager;
import dev.recollect.hana.mod.commands.impl.PlaySongCommand;

class PlaySongCommand.1
implements MusicManager.Callback<String> {
    final /* synthetic */ PlaySongCommand this$0;

    @Override
    public void onSuccess(String string) {
        String a = string;
        PlaySongCommand.1 a2 = this;
        CommandManager.sendChatMessage("Playing song with URL: " + (String)a);
    }

    @Override
    public void onError(String string) {
        String a = string;
        PlaySongCommand.1 a2 = this;
        CommandManager.sendChatMessage("Error playing song: " + (String)a);
    }

    PlaySongCommand.1(PlaySongCommand playSongCommand) {
        PlaySongCommand a = playSongCommand;
        PlaySongCommand.1 a2 = this;
        a2.this$0 = a;
    }
}
