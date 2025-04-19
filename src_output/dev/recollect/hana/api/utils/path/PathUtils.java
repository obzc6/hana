/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2261
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2551
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.path;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.path.AStarCustomPathFinder;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.class_1309;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2261;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2551;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class PathUtils
implements Wrapper {
    public static ArrayList<Vec3> computePath(class_243 a) {
        return PathUtils.computePath(new Vec3(PathUtils.mc.field_1724.method_23317(), PathUtils.mc.field_1724.method_23318(), PathUtils.mc.field_1724.method_23321()), new Vec3(a.field_1352, a.field_1351, a.field_1350));
    }

    public static ArrayList<Vec3> computePath(Vec3 a, Vec3 a22) {
        Iterator<Vec3> iterator;
        Vec3 vec3 = a;
        if (!PathUtils.canPassThrough(new BlockPosX(vec3.mc()))) {
            vec3 = vec3.addVector(0.0, 1.0, 0.0);
        }
        Object object = a22 = new AStarCustomPathFinder(vec3, (Vec3)a22);
        ((AStarCustomPathFinder)object).compute();
        int a22 = 0;
        Vec3 vec32 = null;
        Vec3 vec33 = null;
        ArrayList<Vec3> arrayList = new ArrayList<Vec3>();
        ArrayList<Vec3> arrayList2 = ((AStarCustomPathFinder)object).getPath();
        Iterator<Vec3> iterator2 = iterator = arrayList2.iterator();
        while (iterator2.hasNext()) {
            a = iterator.next();
            if (a22 != 0 && a22 != arrayList2.size() - 1) {
                boolean bl;
                block12 : {
                    boolean bl2 = true;
                    if (a.squareDistanceTo(vec33) > CombatSetting.INSTANCE.tp.getValue()) {
                        bl = bl2 = false;
                    } else {
                        Vec3 vec34 = vec33;
                        double d = Math.min(vec34.getX(), a.getX());
                        double d2 = Math.min(vec34.getY(), a.getY());
                        double d3 = Math.min(vec34.getZ(), a.getZ());
                        double d4 = Math.max(vec34.getX(), a.getX());
                        double d5 = Math.max(vec34.getY(), a.getY());
                        double d6 = Math.max(vec34.getZ(), a.getZ());
                        int n = (int)d;
                        while ((double)n <= d4) {
                            int n2;
                            int n3 = (int)d2;
                            while ((double)n3 <= d5) {
                                int n4;
                                int n5 = (int)d3;
                                while ((double)n5 <= d6) {
                                    int n6;
                                    if (!AStarCustomPathFinder.checkPositionValidity(n2, n4, n6, false)) {
                                        bl = bl2 = false;
                                        break block12;
                                    }
                                    n5 = ++n6;
                                }
                                n3 = ++n4;
                            }
                            n = ++n2;
                        }
                        bl = bl2;
                    }
                }
                if (!bl) {
                    arrayList.add(vec32.addVector(0.5, 0.0, 0.5));
                    vec33 = vec32;
                }
            } else {
                if (vec32 != null) {
                    arrayList.add(vec32.addVector(0.5, 0.0, 0.5));
                }
                arrayList.add(a.addVector(0.5, 0.0, 0.5));
                vec33 = a;
            }
            ++a22;
            vec32 = a;
            iterator2 = iterator;
        }
        return arrayList;
    }

    public static ArrayList<Vec3> computePath(class_1309 class_13092, class_1309 class_13093) {
        class_1309 a = class_13093;
        class_1309 a2 = class_13092;
        return PathUtils.computePath(new Vec3(a2.method_23317(), a2.method_23318(), a2.method_23321()), new Vec3(a.method_23317(), a.method_23318(), a.method_23321()));
    }

    private static /* synthetic */ boolean canPassThrough(class_2338 a) {
        class_2338 class_23382 = a;
        a = PathUtils.mc.field_1687.method_8320(new class_2338(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260())).method_26204();
        return a == class_2246.field_10124 || a instanceof class_2261 || a == class_2246.field_10597 || a == class_2246.field_9983 || a == class_2246.field_10382 || a == class_2246.field_27097 || a instanceof class_2551;
    }

    public PathUtils() {
        PathUtils a;
    }
}
