/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.MusicManager;
import java.io.PrintStream;

class MusicManager.2
implements MusicManager.Callback<String> {
    final /* synthetic */ MusicManager this$0;

    @Override
    public void onError(String string) {
        String a = string;
        MusicManager.2 a2 = this;
        System.out.println("\u9519\u8bef: " + (String)a);
    }

    MusicManager.2(MusicManager musicManager) {
        MusicManager a = musicManager;
        MusicManager.2 a2 = this;
        a2.this$0 = a;
    }

    @Override
    public void onSuccess(String string) {
        String a = string;
        MusicManager.2 a2 = this;
        a2.this$0.playAudioFromUrl(a);
    }
}
