/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.socket.network.info.ClientInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

@Deprecated
public class MusicManager
implements Wrapper {
    private static final String API_BASE_URL = "http://182.43.27.152:3000";
    private Clip clip;

    private /* synthetic */ void playAudioFromUrl(String string) {
        String a = string;
        MusicManager a2 = this;
        if (a == null || a.isEmpty()) {
            System.out.println(BlockUpUtil.ALLATORIxDEMO("\u6709\u80e1\u8396\u53c8\u6b55\u66d4kSl\u301d"));
            return;
        }
        new Thread(() -> {
            Object a22 = a;
            MusicManager a = this;
            try {
                a22 = AudioSystem.getAudioInputStream(new URL((String)a22));
                MusicManager musicManager = a;
                musicManager.clip = AudioSystem.getClip();
                musicManager.clip.open((AudioInputStream)a22);
                musicManager.clip.start();
                return;
            }
            catch (IOException | LineUnavailableException | UnsupportedAudioFileException a22) {
                a22.printStackTrace();
                System.out.println("\u64ad\u653e\u97f3\u9891\u5931\u8d25: " + a22.getMessage());
                return;
            }
        }).start();
    }

    public void resumeSong() {
        MusicManager a;
        if (a.clip != null && !a.clip.isRunning()) {
            a.clip.start();
        }
    }

    private /* synthetic */ void lambda$getUserRadios$2(String a4, Callback a2) {
        block5 : {
            StringBuilder stringBuilder;
            BufferedReader bufferedReader;
            String[] a3;
            MusicManager musicManager = a3;
            try {
                String string;
                a4 = "http://182.43.27.152:3000/user/audio?uid=" + (String)a4;
                a3 = (HttpURLConnection)new URL((String)a4).openConnection();
                a3.setRequestMethod(BlockUpUtil.ALLATORIxDEMO("\u0010;\u0015"));
                bufferedReader = new BufferedReader(new InputStreamReader(a3.getInputStream()));
                stringBuilder = new StringBuilder();
                BufferedReader bufferedReader2 = bufferedReader;
                while ((string = bufferedReader2.readLine()) != null) {
                    bufferedReader2 = bufferedReader;
                    stringBuilder.append(string);
                }
            }
            catch (IOException a4) {
                IOException iOException = a4;
                iOException.printStackTrace();
                a2.onError("\u83b7\u53d6\u7528\u6237\u7535\u53f0\u5931\u8d25: " + iOException.getMessage());
                return;
            }
            bufferedReader.close();
            a3.disconnect();
            a3 = musicManager.parseUserRadios(stringBuilder.toString());
            if (a3 == null || a3.length <= 0) break block5;
            a2.onSuccess(a3);
            return;
        }
        a2.onError(ClientInfo.ALLATORIxDEMO("\u675f\u6275\u5276\u7ed7\u5bd9\u752b\u6279L\f\u769d\u7561\u53be\u6573\u6336\u3017"));
    }

    public void stopSong() {
        MusicManager a;
        if (a.clip != null && a.clip.isRunning()) {
            MusicManager musicManager = a;
            musicManager.clip.stop();
            musicManager.clip.close();
        }
    }

    private /* synthetic */ String extractJsonValue(String[] a, String a2) {
        MusicManager a3;
        MusicManager musicManager = a3;
        int n = a.length;
        int n2 = a3 = 0;
        while (n2 < n) {
            String string = a[a3];
            if (string.startsWith(a2 + ":")) {
                return string.substring(a2.length() + 1);
            }
            n2 = ++a3;
        }
        return null;
    }

    public MusicManager() {
        MusicManager a;
    }

    private /* synthetic */ String parseSongUrl(String a) {
        MusicManager a22;
        MusicManager musicManager = a22;
        int a22 = a.indexOf(ClientInfo.ALLATORIxDEMO("/$^\u0006yw<\u0010"));
        if (a22 == -1) {
            return null;
        }
        a22 = a.indexOf(BlockUpUtil.ALLATORIxDEMO("6lTR#\u001a="), a22);
        if (a22 == -1) {
            return null;
        }
        int n = a.indexOf(ClientInfo.ALLATORIxDEMO("i"), a22 + 7);
        if (n == -1) {
            return null;
        }
        return a.substring(a22 + 7, n);
    }

    private /* synthetic */ void lambda$getSongUrl$0(String a4, Callback a2) {
        block5 : {
            Object a3;
            StringBuilder stringBuilder;
            BufferedReader bufferedReader;
            MusicManager musicManager = a3;
            try {
                String string;
                a4 = "http://182.43.27.152:3000/song/url?id=" + (String)a4;
                a3 = (HttpURLConnection)new URL((String)a4).openConnection();
                ((HttpURLConnection)a3).setRequestMethod(BlockUpUtil.ALLATORIxDEMO("\u00109\u0017"));
                bufferedReader = new BufferedReader(new InputStreamReader(((URLConnection)a3).getInputStream()));
                stringBuilder = new StringBuilder();
                BufferedReader bufferedReader2 = bufferedReader;
                while ((string = bufferedReader2.readLine()) != null) {
                    bufferedReader2 = bufferedReader;
                    stringBuilder.append(string);
                }
            }
            catch (IOException a4) {
                IOException iOException = a4;
                iOException.printStackTrace();
                a2.onError("\u83b7\u53d6\u6b4c\u66f2URL\u5931\u8d25: " + iOException.getMessage());
                return;
            }
            bufferedReader.close();
            ((HttpURLConnection)a3).disconnect();
            a3 = musicManager.parseSongUrl(stringBuilder.toString());
            if (a3 == null) break block5;
            a2.onSuccess(a3);
            return;
        }
        a2.onError(ClientInfo.ALLATORIxDEMO("\u6763\u6273\u5270\u7ee6\u5be8\u6b54\u66a7O\u000f\u76ca\u6573\u6334\u3015"));
    }

    private /* synthetic */ void lambda$getRadioSongs$3(String a4, Callback a2) {
        block5 : {
            StringBuilder stringBuilder;
            BufferedReader bufferedReader;
            String[] a3;
            MusicManager musicManager = a3;
            try {
                String string;
                a4 = "http://182.43.27.152:3000/dj/program?rid=" + (String)a4;
                a3 = (HttpURLConnection)new URL((String)a4).openConnection();
                a3.setRequestMethod(BlockUpUtil.ALLATORIxDEMO("\u0010:\u0014"));
                bufferedReader = new BufferedReader(new InputStreamReader(a3.getInputStream()));
                stringBuilder = new StringBuilder();
                BufferedReader bufferedReader2 = bufferedReader;
                while ((string = bufferedReader2.readLine()) != null) {
                    bufferedReader2 = bufferedReader;
                    stringBuilder.append(string);
                }
            }
            catch (IOException a4) {
                IOException iOException = a4;
                iOException.printStackTrace();
                a2.onError("\u83b7\u53d6\u7535\u53f0\u6b4c\u66f2\u5931\u8d25: " + iOException.getMessage());
                return;
            }
            bufferedReader.close();
            a3.disconnect();
            a3 = musicManager.parseRadioSongs(stringBuilder.toString());
            if (a3 == null || a3.length <= 0) break block5;
            a2.onSuccess(a3);
            return;
        }
        a2.onError(ClientInfo.ALLATORIxDEMO("\u6762\u6247\u5244\u7edc\u5bd2\u7531\u53b9D\u0004\u769d\u6b18\u66bc\u6573\u6337\u3016"));
    }

    private /* synthetic */ String[] parseRadioSongs(String a) {
        MusicManager a22;
        MusicManager musicManager = a22;
        int n = a.indexOf(BlockUpUtil.ALLATORIxDEMO("\u0001lmODnCpX6\u0005["));
        if (n == -1) {
            return new String[0];
        }
        int a22 = a.indexOf(ClientInfo.ALLATORIxDEMO("\t"), n);
        if (a22 == -1) {
            return new String[0];
        }
        a = a.substring(n + 12, a22).split(BlockUpUtil.ALLATORIxDEMO("AV8c{"));
        String[] arrstring = new String[a.length];
        int n2 = a22 = 0;
        while (n2 < a.length) {
            Object object = a[a22].replaceAll(ClientInfo.ALLATORIxDEMO("\u0012v=;\t"), "").split(BlockUpUtil.ALLATORIxDEMO(","));
            MusicManager musicManager2 = musicManager;
            String string = musicManager2.extractJsonValue((String[])object, ClientInfo.ALLATORIxDEMO("c!t1"));
            object = musicManager2.extractJsonValue((String[])object, BlockUpUtil.ALLATORIxDEMO("N}Ksx{Qg"));
            arrstring[a22] = string != null && object != null ? string + " (ID: " + (String)object + ")" : ClientInfo.ALLATORIxDEMO("\u6727\u77a5\u6b55\u66a6");
            n2 = ++a22;
        }
        return arrstring;
    }

    /*
     * WARNING - void declaration
     */
    public void getSongUrl(String string, Callback<String> callback) {
        void a;
        Callback<String> a2 = callback;
        MusicManager a3 = this;
        new Thread(() -> a3.lambda$getSongUrl$0((String)a, a2)).start();
    }

    /*
     * WARNING - void declaration
     */
    public void getUserRadios(String string, Callback<String[]> callback) {
        void a;
        Callback<String[]> a2 = callback;
        MusicManager a3 = this;
        new Thread(() -> a3.lambda$getUserRadios$2((String)a, a2)).start();
    }

    /*
     * WARNING - void declaration
     */
    public void getRadioSongs(String string, Callback<String[]> callback) {
        void a;
        Callback<String[]> a2 = callback;
        MusicManager a3 = this;
        new Thread(() -> a3.lambda$getRadioSongs$3((String)a, a2)).start();
    }

    private /* synthetic */ String[] parseUserRadios(String a) {
        MusicManager a22;
        MusicManager musicManager = a22;
        int n = a.indexOf(BlockUpUtil.ALLATORIxDEMO("<EG@IsLuP>\u0005["));
        if (n == -1) {
            return new String[0];
        }
        int a22 = a.indexOf(ClientInfo.ALLATORIxDEMO("\t"), n);
        if (a22 == -1) {
            return new String[0];
        }
        a = a.substring(n + 11, a22).split(BlockUpUtil.ALLATORIxDEMO("F^0c{"));
        String[] arrstring = new String[a.length];
        int n2 = a22 = 0;
        while (n2 < a.length) {
            Object object = a[a22].replaceAll(ClientInfo.ALLATORIxDEMO("\u0015~5;\t"), "").split(BlockUpUtil.ALLATORIxDEMO(","));
            MusicManager musicManager2 = musicManager;
            String string = musicManager2.extractJsonValue((String[])object, ClientInfo.ALLATORIxDEMO("k)t1"));
            object = musicManager2.extractJsonValue((String[])object, BlockUpUtil.ALLATORIxDEMO("Vd"));
            arrstring[a22] = string != null && object != null ? string + " (ID: " + (String)object + ")" : ClientInfo.ALLATORIxDEMO("\u672f\u77ad\u752c\u53a4");
            n2 = ++a22;
        }
        return arrstring;
    }

    public void pauseSong() {
        MusicManager a;
        if (a.clip != null && a.clip.isRunning()) {
            a.clip.stop();
        }
    }

    public void playSong(String string, Callback<String> callback) {
        String a = string;
        MusicManager a2 = this;
        a2.getSongUrl(a, new Callback<String>(a2){
            final /* synthetic */ MusicManager this$0;

            @Override
            public void onSuccess(String string) {
                String a = string;
                1 a2 = this;
                a2.this$0.playAudioFromUrl(a);
            }

            @Override
            public void onError(String string) {
                String a = string;
                1 a2 = this;
                System.out.println("\u9519\u8bef: " + (String)a);
            }
            {
                MusicManager a = musicManager;
                1 a2 = this;
                a2.this$0 = a;
            }
        });
    }

    public void playRadioSong(String string) {
        String a = string;
        MusicManager a2 = this;
        a2.getSongUrl(a, new Callback<String>(a2){
            final /* synthetic */ MusicManager this$0;

            @Override
            public void onError(String string) {
                String a = string;
                2 a2 = this;
                System.out.println("\u9519\u8bef: " + (String)a);
            }
            {
                MusicManager a = musicManager;
                2 a2 = this;
                a2.this$0 = a;
            }

            @Override
            public void onSuccess(String string) {
                String a = string;
                2 a2 = this;
                a2.this$0.playAudioFromUrl(a);
            }
        });
    }

    public static interface Callback<T> {
        public void onSuccess(T var1);

        public void onError(String var1);
    }

}
