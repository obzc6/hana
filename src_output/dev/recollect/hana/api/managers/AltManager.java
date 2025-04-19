/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  net.minecraft.class_320$class_321
 *  org.apache.commons.io.IOUtils
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.asm.accessors.IMinecraftClient;
import dev.recollect.hana.socket.network.info.ClientInfo;
import dev.recollect.hana.socket.network.user.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.class_310;
import net.minecraft.class_320;
import org.apache.commons.io.IOUtils;

public class AltManager
implements Wrapper {
    private final ArrayList<Alt> alts = new ArrayList();

    public ArrayList<Alt> getAlts() {
        AltManager a;
        return a.alts;
    }

    public void readAlts() {
        File a22;
        AltManager altManager = a22;
        try {
            a22 = new File(AltManager.mc.field_1697, ClientInfo.ALLATORIxDEMO("*j(o\u001cJ\nr80'a "));
            if (!a22.exists()) {
                throw new IOException(User.ALLATORIxDEMO("dWBW\u0001SAF\bRECSE\u001d\u0000\"\u0012{~G\u001fUHv>B]@Y\u000eSD@Y\u0018\u0013\u000f"));
            }
            for (String string : IOUtils.readLines((InputStream)new FileInputStream(a22), (Charset)StandardCharsets.UTF_8)) {
                altManager.alts.add(new Alt(string));
            }
        }
        catch (IOException a22) {
            a22.printStackTrace();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void loginToken(String string, String string2, String string3) {
        String a22 = string;
        AltManager a = this;
        try {
            void a3;
            void a4;
            ((IMinecraftClient)mc).setSession(new class_320(a22, UUID.fromString((String)a4), (String)a3, Optional.empty(), Optional.empty(), class_320.class_321.field_1988));
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }

    public void saveAlts() {
        Object a;
        AltManager altManager = a;
        a = null;
        try {
            File file = new File(AltManager.mc.field_1697, ClientInfo.ALLATORIxDEMO(".}?n\u001dJ\nr80'a "));
            System.out.println(User.ALLATORIxDEMO("gh\u0000\u0013oQOV^IvC\u000ea@KG\\O\u0014kZIR"));
            a = new PrintWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(file), StandardCharsets.UTF_8));
            for (Alt alt : altManager.alts) {
                ((PrintWriter)a).println(alt.getEmail());
            }
        }
        catch (Exception exception) {
            System.out.println(ClientInfo.ALLATORIxDEMO("E\u001bF\u0004j\u0005h n(y\u001d/\u0004y<u1ofh>/1J\u0010ck?m'"));
        }
        ((PrintWriter)a).close();
    }

    public void loginCracked(String string) {
        String a22 = string;
        AltManager a = this;
        try {
            ((IMinecraftClient)mc).setSession(new class_320(a22, UUID.fromString(User.ALLATORIxDEMO("\u0018\u0004\u0010\u000f\u001d\u0004\u001e\u0002\u0007\u0007\u000f\u0012\b\rTI= \u000e\t\r\u001143\u0018\u0004\u0016\b\u0018\u0001\u0010\u0002\u001c\u0000\r\u0011")), "", Optional.empty(), Optional.empty(), class_320.class_321.field_1988));
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }

    public void addAlt(Alt alt) {
        Alt a = alt;
        AltManager a2 = this;
        a2.alts.add(a);
    }

    public AltManager() {
        AltManager a;
        a.readAlts();
    }

    public void removeAlt(Alt alt) {
        Alt a = alt;
        AltManager a2 = this;
        a2.alts.remove(a);
    }
}
