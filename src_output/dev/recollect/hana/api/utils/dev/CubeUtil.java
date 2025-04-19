/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.joml.Quaternionf
 */
package dev.recollect.hana.api.utils.dev;

import org.joml.Quaternionf;

public class CubeUtil {
    public static int[][] cubeSideTransforms;
    public static int[][] cubeSides;
    public static Quaternionf[] cubeletStatus;
    public static int[][][] cubletLookup;

    public CubeUtil() {
        CubeUtil a;
    }

    static {
        Quaternionf[] arrquaternionf = new Quaternionf[26];
        arrquaternionf[0] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[1] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[2] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[3] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[4] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[5] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[6] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[7] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[8] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[9] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[10] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[11] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[12] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[13] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[14] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[15] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[16] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[17] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[18] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[19] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[20] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[21] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[22] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[23] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[24] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        arrquaternionf[25] = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        cubeletStatus = arrquaternionf;
        int[][][] arrarrn = new int[3][][];
        int[][] arrarrn2 = new int[3][];
        int[] arrn = new int[3];
        arrn[0] = 17;
        arrn[1] = 9;
        arrn[2] = 0;
        arrarrn2[0] = arrn;
        int[] arrn2 = new int[3];
        arrn2[0] = 20;
        arrn2[1] = 16;
        arrn2[2] = 3;
        arrarrn2[1] = arrn2;
        int[] arrn3 = new int[3];
        arrn3[0] = 23;
        arrn3[1] = 15;
        arrn3[2] = 6;
        arrarrn2[2] = arrn3;
        arrarrn[0] = arrarrn2;
        int[][] arrarrn3 = new int[3][];
        int[] arrn4 = new int[3];
        arrn4[0] = 18;
        arrn4[1] = 10;
        arrn4[2] = 1;
        arrarrn3[0] = arrn4;
        int[] arrn5 = new int[3];
        arrn5[0] = 21;
        arrn5[1] = -1;
        arrn5[2] = 4;
        arrarrn3[1] = arrn5;
        int[] arrn6 = new int[3];
        arrn6[0] = 24;
        arrn6[1] = 14;
        arrn6[2] = 7;
        arrarrn3[2] = arrn6;
        arrarrn[1] = arrarrn3;
        int[][] arrarrn4 = new int[3][];
        int[] arrn7 = new int[3];
        arrn7[0] = 19;
        arrn7[1] = 11;
        arrn7[2] = 2;
        arrarrn4[0] = arrn7;
        int[] arrn8 = new int[3];
        arrn8[0] = 22;
        arrn8[1] = 12;
        arrn8[2] = 5;
        arrarrn4[1] = arrn8;
        int[] arrn9 = new int[3];
        arrn9[0] = 25;
        arrn9[1] = 13;
        arrn9[2] = 8;
        arrarrn4[2] = arrn9;
        arrarrn[2] = arrarrn4;
        cubletLookup = arrarrn;
        int[][] arrarrn5 = new int[6][];
        int[] arrn10 = new int[9];
        arrn10[0] = 0;
        arrn10[1] = 1;
        arrn10[2] = 2;
        arrn10[3] = 3;
        arrn10[4] = 4;
        arrn10[5] = 5;
        arrn10[6] = 6;
        arrn10[7] = 7;
        arrn10[8] = 8;
        arrarrn5[0] = arrn10;
        int[] arrn11 = new int[9];
        arrn11[0] = 19;
        arrn11[1] = 18;
        arrn11[2] = 17;
        arrn11[3] = 22;
        arrn11[4] = 21;
        arrn11[5] = 20;
        arrn11[6] = 25;
        arrn11[7] = 24;
        arrn11[8] = 23;
        arrarrn5[1] = arrn11;
        int[] arrn12 = new int[9];
        arrn12[0] = 0;
        arrn12[1] = 1;
        arrn12[2] = 2;
        arrn12[3] = 9;
        arrn12[4] = 10;
        arrn12[5] = 11;
        arrn12[6] = 17;
        arrn12[7] = 18;
        arrn12[8] = 19;
        arrarrn5[2] = arrn12;
        int[] arrn13 = new int[9];
        arrn13[0] = 23;
        arrn13[1] = 24;
        arrn13[2] = 25;
        arrn13[3] = 15;
        arrn13[4] = 14;
        arrn13[5] = 13;
        arrn13[6] = 6;
        arrn13[7] = 7;
        arrn13[8] = 8;
        arrarrn5[3] = arrn13;
        int[] arrn14 = new int[9];
        arrn14[0] = 17;
        arrn14[1] = 9;
        arrn14[2] = 0;
        arrn14[3] = 20;
        arrn14[4] = 16;
        arrn14[5] = 3;
        arrn14[6] = 23;
        arrn14[7] = 15;
        arrn14[8] = 6;
        arrarrn5[4] = arrn14;
        int[] arrn15 = new int[9];
        arrn15[0] = 2;
        arrn15[1] = 11;
        arrn15[2] = 19;
        arrn15[3] = 5;
        arrn15[4] = 12;
        arrn15[5] = 22;
        arrn15[6] = 8;
        arrn15[7] = 13;
        arrn15[8] = 25;
        arrarrn5[5] = arrn15;
        cubeSides = arrarrn5;
        int[][] arrarrn6 = new int[6][];
        int[] arrn16 = new int[3];
        arrn16[0] = 0;
        arrn16[1] = 0;
        arrn16[2] = 1;
        arrarrn6[0] = arrn16;
        int[] arrn17 = new int[3];
        arrn17[0] = 0;
        arrn17[1] = 0;
        arrn17[2] = -1;
        arrarrn6[1] = arrn17;
        int[] arrn18 = new int[3];
        arrn18[0] = 0;
        arrn18[1] = 1;
        arrn18[2] = 0;
        arrarrn6[2] = arrn18;
        int[] arrn19 = new int[3];
        arrn19[0] = 0;
        arrn19[1] = -1;
        arrn19[2] = 0;
        arrarrn6[3] = arrn19;
        int[] arrn20 = new int[3];
        arrn20[0] = -1;
        arrn20[1] = 0;
        arrn20[2] = 0;
        arrarrn6[4] = arrn20;
        int[] arrn21 = new int[3];
        arrn21[0] = 1;
        arrn21[1] = 0;
        arrn21[2] = 0;
        arrarrn6[5] = arrn21;
        cubeSideTransforms = arrarrn6;
    }

    public static double easeInOutCubic(double a) {
        if (a < 0.5) {
            return 4.0 * a * a * a;
        }
        return 1.0 - Math.pow(-2.0 * a + 2.0, 3.0) / 2.0;
    }
}
