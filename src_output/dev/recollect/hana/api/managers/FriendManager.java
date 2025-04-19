/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.class_1657
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  org.apache.commons.io.IOUtils
 */
package dev.recollect.hana.api.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.MathUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import org.apache.commons.io.IOUtils;

public class FriendManager
implements Wrapper {
    public static final ArrayList<String> friendList = new ArrayList();

    public void friend(String string) {
        String a = string;
        FriendManager a2 = this;
        if (friendList.contains(a)) {
            friendList.remove(a);
            return;
        }
        friendList.add(a);
    }

    public void loadFriends() throws IOException {
        Path a;
        FriendManager friendManager = a;
        a = Paths.get(MathUtil.ALLATORIxDEMO("\u001b\u0004\u0017-\u000f\u0006\u000e\u0006\u0016\u000e\u0018\u0015T\u000e\u000b\u001c\u0001"), new String[0]);
        if (!Files.exists(a, new LinkOption[0])) {
            return;
        }
        friendManager.loadPath(a);
    }

    public static void removeFriend(String a) {
        friendList.remove(a);
    }

    private /* synthetic */ void loadFile(JsonObject a) {
        FriendManager a22;
        FriendManager friendManager = a22;
        a = a.entrySet().iterator();
        while (a.hasNext()) {
            a22 = (JsonElement)((Map.Entry)a.next()).getValue();
            try {
                friendManager.addFriend(a22.getAsString());
            }
            catch (Exception a22) {
                a22.printStackTrace();
            }
        }
    }

    public boolean isFriend(class_1657 class_16572) {
        FriendManager a = class_16572;
        FriendManager a2 = this;
        return FriendManager.isFriend(a.method_5477().getString());
    }

    public FriendManager() {
        FriendManager a;
        FriendManager friendManager = a;
        friendManager.readFriends();
    }

    public void saveFriends() {
        Object a;
        FriendManager friendManager = a;
        a = null;
        try {
            File file = new File(FriendManager.mc.field_1697, FPSManager.ALLATORIxDEMO("t\u001bQ8T\u000bb\u001fy\u0014s\u00023\u000fr\u0018"));
            System.out.println(MathUtil.ALLATORIxDEMO("h\u000f:\u001d\u000e+\u0018\r\u001d\u0001\u00078Y\u001f1\u0016\u0015\u0001\u0014@:\u0014\u0013\u0001\u0016\u0017\u001c"));
            a = new PrintWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(file), StandardCharsets.UTF_8));
            for (String string : friendList) {
                ((PrintWriter)a).println(string);
            }
        }
        catch (Exception exception) {
            System.out.println(FPSManager.ALLATORIxDEMO("%v\u0019r\u001bVML\rq\u0012j\r<\u000ePyx\ff\u0013<\u001ce\u0018x\u0015n\u001f"));
        }
        ((PrintWriter)a).close();
    }

    public void addFriend(String string) {
        String a = string;
        FriendManager a2 = this;
        if (!friendList.contains(a)) {
            friendList.add(a);
        }
    }

    private /* synthetic */ void loadPath(Path path) throws IOException {
        Object object;
        Object a = path;
        FriendManager a2 = this;
        a = Files.newInputStream((Path)a, new OpenOption[0]);
        try {
            a2.loadFile(new JsonParser().parse((Reader)new InputStreamReader((InputStream)a)).getAsJsonObject());
            object = a;
        }
        catch (IllegalStateException illegalStateException) {
            object = a;
            a2.loadFile(new JsonObject());
        }
        ((InputStream)object).close();
    }

    public void saveFriendsOld() throws IOException {
        Path a;
        FriendManager friendManager = a;
        a = Paths.get(FPSManager.ALLATORIxDEMO("\u0005q\u0018}%q\u0003t\u001ed\bE~\u0000r\u0015"), new String[0]);
        if (!Files.exists(a, new LinkOption[0])) {
            Files.createFile(a, new FileAttribute[0]);
        }
        String string = new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement)friendManager.writeFriends());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(a, new OpenOption[0])));
        bufferedWriter.write(string);
        bufferedWriter.close();
    }

    public static boolean isFriend(String a) {
        return friendList.contains(a) || FPSManager.ALLATORIxDEMO("X\t\\6g\u0001u\u0015h%@\u0018s\u0010").equals(a) || MathUtil.ALLATORIxDEMO("\u4eec\u5b24\u82de").equals(a);
    }

    public JsonObject writeFriends() {
        Object a;
        FriendManager friendManager = a;
        JsonObject jsonObject = new JsonObject();
        JsonParser jsonParser = new JsonParser();
        for (String string : friendList) {
            try {
                jsonObject.add(string.replace(MathUtil.ALLATORIxDEMO("O"), FPSManager.ALLATORIxDEMO("3")), jsonParser.parse(string.replace(MathUtil.ALLATORIxDEMO("O"), FPSManager.ALLATORIxDEMO("3"))));
            }
            catch (Exception exception) {}
        }
        return jsonObject;
    }

    public void readFriends() {
        File a22;
        FriendManager friendManager = a22;
        try {
            a22 = new File(FriendManager.mc.field_1697, FPSManager.ALLATORIxDEMO("u\u001aQ8T\u000bb\u001fy\u0014s\u00023\u000fr\u0018"));
            if (!a22.exists()) {
                throw new IOException(MathUtil.ALLATORIxDEMO(":\u0006\u001f\u0005\\\b\u0015\u0010X\u0015\u0000\u0007\u0000K\u0012g\u0018\u001c\u001a\u0004\u0010D\u0016\u0000\u0007E\u0015#1\u0004\\\t\u0001\t\u0019\b\u001e\u0017V]A"));
            }
            for (String string : IOUtils.readLines((InputStream)new FileInputStream(a22), (Charset)StandardCharsets.UTF_8)) {
                friendManager.addFriend(string);
            }
        }
        catch (IOException a22) {
            a22.printStackTrace();
        }
    }
}
