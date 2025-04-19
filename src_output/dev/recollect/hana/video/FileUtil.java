/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.IOUtils
 */
package dev.recollect.hana.video;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

public class FileUtil {
    public static void unpackFile(File a3, String a2) {
        File file = a3;
        try {
            a3 = new FileOutputStream(file);
            IOUtils.copy((InputStream)Objects.requireNonNull(FileUtil.class.getClassLoader().getResourceAsStream(a2)), (OutputStream)a3);
            ((FileOutputStream)a3).close();
            return;
        }
        catch (FileNotFoundException a3) {
            a3.printStackTrace();
            return;
        }
        catch (IOException a3) {
            a3.printStackTrace();
            return;
        }
    }

    public static String readInputStream(InputStream a2) {
        InputStream inputStream = a2;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String string;
            a2 = new BufferedReader(new InputStreamReader(inputStream));
            while ((string = ((BufferedReader)a2).readLine()) != null) {
                stringBuilder.append(string).append('\n');
            }
        }
        catch (Exception a2) {
            a2.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String readFile(File a2) {
        File file = a2;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String string;
            a2 = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)a2));
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append('\n');
            }
        }
        catch (Exception a2) {
            a2.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public FileUtil() {
        FileUtil a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ 5;
        3 << 3 ^ (3 ^ 5);
        int n4 = 3 << 3 ^ 2;
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
}
