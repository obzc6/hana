/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.skid;

import dev.recollect.hana.skid.LaunchWrapper;
import java.io.PrintStream;
import java.util.Arrays;

public class Start {
    public static void main(String[] a) {
        System.out.println("\n################################################\n#                                              #\n#        ## #   #    ## ### ### ##  ###        #\n#       # # #   #   # #  #  # # # #  #         #\n#       ### #   #   ###  #  # # ##   #         #\n#       # # ### ### # #  #  ### # # ###        #\n#                                              #\n# Obfuscation by Allatori Obfuscator v9.1 DEMO #\n#                                              #\n#           http://www.allatori.com            #\n#                                              #\n################################################\n");
        LaunchWrapper.main(Start.concat(new String[0], a));
    }

    public Start() {
        Start a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ 5;
        4 << 3;
        int n4 = (3 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    public static <T> T[] concat(T[] a, T[] a2) {
        T[] arrT;
        T[] arrT2 = arrT = a;
        a = Arrays.copyOf(arrT2, arrT2.length + a2.length);
        System.arraycopy(a2, 0, a, arrT.length, a2.length);
        return a;
    }
}
