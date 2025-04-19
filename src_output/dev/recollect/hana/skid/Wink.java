/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.skid;

import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class Wink {
    public static final Set<String> ALLOWED_PLAYERS;

    public Wink() {
        Wink a;
    }

    public static String getCurrentPlayerID() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 != null) {
            return class_3102.field_1724.method_5477().getString();
        }
        return CrystalUtil.ALLATORIxDEMO("6C6D5X1");
    }

    static {
        String[] arrstring = new String[26];
        arrstring[0] = Hole.ALLATORIxDEMO("&h\u0018m\u0012k\u001cc\nX4sG;");
        arrstring[1] = CrystalUtil.ALLATORIxDEMO("\u4ece\u5b78\u82ee");
        arrstring[2] = Hole.ALLATORIxDEMO("&h\u0018m\u0012k\u001cc\nX4H;");
        arrstring[3] = CrystalUtil.ALLATORIxDEMO("8C?\u0006vv\u0000Y\u4e6b}3A4");
        arrstring[4] = Hole.ALLATORIxDEMO("&h\u0018m\u0012k\u001cc\n\u4e314H;");
        arrstring[5] = CrystalUtil.ALLATORIxDEMO("f1^<N55]{\f^)b;A;");
        arrstring[6] = Hole.ALLATORIxDEMO("?j\u000fX0{D1");
        arrstring[7] = CrystalUtil.ALLATORIxDEMO("\u001d\u001f\u001ff");
        arrstring[8] = Hole.ALLATORIxDEMO(" .lh");
        arrstring[9] = CrystalUtil.ALLATORIxDEMO("\u624c\u6605h\u001f(");
        arrstring[10] = Hole.ALLATORIxDEMO("A\f~\nt\u001fk\u76e7\u5c15\u5e2c\u54b5");
        arrstring[11] = CrystalUtil.ALLATORIxDEMO("\u001b\nYi");
        arrstring[12] = Hole.ALLATORIxDEMO("T\u0017o\tU\u0002sG)");
        arrstring[13] = CrystalUtil.ALLATORIxDEMO("\u0014uo");
        arrstring[14] = Hole.ALLATORIxDEMO("\u6364\u7236\u0014sG;");
        arrstring[15] = CrystalUtil.ALLATORIxDEMO("W|\rI$u\ny\u000f");
        arrstring[16] = Hole.ALLATORIxDEMO("?h\bj\u0017j\u0010b\u000b\n{G7");
        arrstring[17] = CrystalUtil.ALLATORIxDEMO("7H/X3I>");
        arrstring[18] = Hole.ALLATORIxDEMO("O,N?I;Sh\u001e");
        arrstring[19] = CrystalUtil.ALLATORIxDEMO("\u0011\u0004tr.D1F?]\u0000");
        arrstring[20] = Hole.ALLATORIxDEMO("Pl]\u000f");
        arrstring[21] = CrystalUtil.ALLATORIxDEMO("`R@-F?@/");
        arrstring[22] = Hole.ALLATORIxDEMO("\u5207\u4eb7{^1");
        arrstring[23] = CrystalUtil.ALLATORIxDEMO("\u4e13\u4e49\u4e97\u76d9\u8dfb\u8125\u5c20\u53a8");
        arrstring[24] = Hole.ALLATORIxDEMO("A\u0016vE\u845c");
        arrstring[25] = CrystalUtil.ALLATORIxDEMO("c\"\u0013ig\u0002A\u0002d#N\u0000");
        ALLOWED_PLAYERS = new HashSet<String>(Arrays.asList(arrstring));
    }

    public static void closeGame() {
        class_310.method_1551().method_1592();
    }
}
