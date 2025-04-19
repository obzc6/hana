/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1011
 *  net.minecraft.class_1043
 *  net.minecraft.class_1060
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_640
 */
package dev.recollect.hana.api.utils.dev;

import com.mojang.authlib.GameProfile;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1060;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_640;

public final class ThunderUtility {
    public static List<String> changeLog = new ArrayList<String>();

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ void lambda$solveName$0(String string, AtomicReference atomicReference, class_640 class_6402) {
        String a = string;
        String a2 = class_6402;
        if (a.contains(a2.method_2966().getName())) {
            void a3;
            a3.set(a2.method_2966().getName());
        }
    }

    public ThunderUtility() {
        ThunderUtility a;
    }

    public static class_2960 getCustomImg(String a) throws IOException {
        return Wrapper.mc.method_1531().method_4617("th-" + a + "-" + (int)MathUtil.random(0.0f, 1000.0f), new class_1043(class_1011.method_4309((InputStream)new FileInputStream("/" + a + ".png"))));
    }

    public static String solveName(String a) {
        String string = a;
        a = new AtomicReference<String>(OnlineUserInfo.ALLATORIxDEMO("\u0005h\nm\u0017\t\u001bf\u0011v\u001c"));
        Wrapper.mc.method_1562().method_45732().forEach(arg_0 -> ThunderUtility.lambda$solveName$0(string, (AtomicReference)a, arg_0));
        return (String)((AtomicReference)a).get();
    }

    public static void parseChangeLog() {
        try {
            String string;
            URL uRL = new URL(Alt.ALLATORIxDEMO("|:w)*90jd-nmq%-kc.r.{6:ll,f7jjx.iq\tb}}g:.\u000f\u0011QF\u001ap!g\rm*f)l1\r\u001bk8p#~\rq#--v "));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
            while ((string = bufferedReader.readLine()) != null) {
                changeLog.add(string.trim());
            }
        }
        catch (Exception exception) {
            changeLog.add(OnlineUserInfo.ALLATORIxDEMO("k7T,I<h<BrB$g\u0011]-N~I)[1Fc\u0003f"));
        }
    }
}
