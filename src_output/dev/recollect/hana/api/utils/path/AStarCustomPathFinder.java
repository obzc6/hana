/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2266
 *  net.minecraft.class_2281
 *  net.minecraft.class_2336
 *  net.minecraft.class_2338
 *  net.minecraft.class_2354
 *  net.minecraft.class_2389
 *  net.minecraft.class_2482
 *  net.minecraft.class_2484
 *  net.minecraft.class_2506
 *  net.minecraft.class_2510
 *  net.minecraft.class_2533
 *  net.minecraft.class_2544
 *  net.minecraft.class_2665
 *  net.minecraft.class_2667
 *  net.minecraft.class_2671
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_4971
 *  net.minecraft.class_4970$class_4971$class_3752
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.utils.path;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.path.Vec3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import net.minecraft.class_2248;
import net.minecraft.class_2266;
import net.minecraft.class_2281;
import net.minecraft.class_2336;
import net.minecraft.class_2338;
import net.minecraft.class_2354;
import net.minecraft.class_2389;
import net.minecraft.class_2482;
import net.minecraft.class_2484;
import net.minecraft.class_2506;
import net.minecraft.class_2510;
import net.minecraft.class_2533;
import net.minecraft.class_2544;
import net.minecraft.class_2665;
import net.minecraft.class_2667;
import net.minecraft.class_2671;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_4970;
import net.minecraft.class_638;

public class AStarCustomPathFinder
implements Wrapper {
    private final Vec3 startVec3;
    private final ArrayList<Hub> hubs;
    private static final Vec3[] flatCardinalDirections;
    private final Vec3 endVec3;
    private final ArrayList<Hub> hubsToWork;
    private ArrayList<Vec3> path;

    static {
        Vec3[] arrvec3 = new Vec3[4];
        arrvec3[0] = new Vec3(1.0, 0.0, 0.0);
        arrvec3[1] = new Vec3(-1.0, 0.0, 0.0);
        arrvec3[2] = new Vec3(0.0, 0.0, 1.0);
        arrvec3[3] = new Vec3(0.0, 0.0, -1.0);
        flatCardinalDirections = arrvec3;
    }

    private static /* synthetic */ boolean isSafeToWalkOn(class_2338 a) {
        return !(AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2354) && !(AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2544);
    }

    private static /* synthetic */ boolean isBlockSolid(class_2338 a) {
        return AStarCustomPathFinder.mc.field_1687.method_8320((class_2338)a).field_23166 != null && AStarCustomPathFinder.mc.field_1687.method_8320((class_2338)a).field_23166.field_20337 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2482 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2510 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2266 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2281 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2336 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2484 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2389 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2354 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2544 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2506 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2665 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2667 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2671 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2506 || AStarCustomPathFinder.mc.field_1687.method_8320(a).method_26204() instanceof class_2533;
    }

    public ArrayList<Vec3> getPath() {
        AStarCustomPathFinder a;
        return a.path;
    }

    public Hub isHubExisting(Vec3 a) {
        Object a2;
        AStarCustomPathFinder aStarCustomPathFinder = a2;
        Iterator<Hub> iterator = aStarCustomPathFinder.hubs.iterator();
        do {
            if (iterator.hasNext()) continue;
            iterator = aStarCustomPathFinder.hubsToWork.iterator();
            do {
                if (iterator.hasNext()) continue;
                return null;
            } while (((Hub)(a2 = iterator.next())).getLoc().getX() != a.getX() || ((Hub)a2).getLoc().getY() != a.getY() || ((Hub)a2).getLoc().getZ() != a.getZ());
            return a2;
        } while (((Hub)(a2 = iterator.next())).getLoc().getX() != a.getX() || ((Hub)a2).getLoc().getY() != a.getY() || ((Hub)a2).getLoc().getZ() != a.getZ());
        return a2;
    }

    public void compute() {
        AStarCustomPathFinder a;
        a.compute(1000, 4);
    }

    public static boolean checkPositionValidity(Vec3 vec3, boolean bl) {
        boolean a = bl;
        Vec3 a2 = vec3;
        return AStarCustomPathFinder.checkPositionValidity((int)a2.getX(), (int)a2.getY(), (int)a2.getZ(), a);
    }

    /*
     * WARNING - void declaration
     */
    public boolean addHub(Hub hub, Vec3 vec3, double d) {
        void a;
        void a2;
        Vec3 a3 = vec3;
        AStarCustomPathFinder a4 = this;
        Hub hub2 = a4.isHubExisting(a3);
        void var6_5 = a2;
        if (a != null) {
            var6_5 = a2 + a.getTotalCost();
        }
        if (hub2 == null) {
            double d2 = 9.0;
            if (a3.getX() == a4.endVec3.getX() && a3.getY() == a4.endVec3.getY() && a3.getZ() == a4.endVec3.getZ() || a3.squareDistanceTo(a4.endVec3) <= d2) {
                a4.path.clear();
                a4.path = a.getPath();
                a4.path.add(a3);
                return true;
            }
            ArrayList<Vec3> arrayList = new ArrayList<Vec3>(a.getPath());
            arrayList.add(a3);
            Object object = a3;
            a4.hubsToWork.add(new Hub((Vec3)object, (Hub)a, arrayList, ((Vec3)object).squareDistanceTo(a4.endVec3), (double)a2, (double)var6_5));
        } else if (hub2.getCost() > a2) {
            ArrayList<Vec3> arrayList = new ArrayList<Vec3>(a.getPath());
            arrayList.add(a3);
            Hub hub3 = hub2;
            Hub hub4 = hub2;
            Hub hub5 = hub2;
            hub5.setLoc(a3);
            hub5.setParent((Hub)a);
            hub4.setPath(arrayList);
            hub4.setSquareDistanceToFromTarget(a3.squareDistanceTo(a4.endVec3));
            hub3.setCost((double)a2);
            hub3.setTotalCost((double)var6_5);
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public AStarCustomPathFinder(Vec3 vec3, Vec3 vec32) {
        void a;
        Vec3 a2 = vec32;
        AStarCustomPathFinder a3 = this;
        AStarCustomPathFinder aStarCustomPathFinder = a3;
        a3.hubs = new ArrayList();
        aStarCustomPathFinder.hubsToWork = new ArrayList();
        a3.path = new ArrayList();
        a3.startVec3 = a.addVector(0.0, 0.0, 0.0).floor();
        a3.endVec3 = a2.addVector(0.0, 0.0, 0.0).floor();
    }

    public void compute(int a, int a2) {
        AStarCustomPathFinder aStarCustomPathFinder;
        AStarCustomPathFinder aStarCustomPathFinder2;
        block7 : {
            AStarCustomPathFinder a322;
            AStarCustomPathFinder aStarCustomPathFinder3 = aStarCustomPathFinder = a322;
            aStarCustomPathFinder3.path.clear();
            aStarCustomPathFinder3.hubsToWork.clear();
            ArrayList<Vec3> arrayList = new ArrayList<Vec3>();
            arrayList.add(aStarCustomPathFinder.startVec3);
            AStarCustomPathFinder aStarCustomPathFinder4 = aStarCustomPathFinder;
            aStarCustomPathFinder.hubsToWork.add(new Hub(aStarCustomPathFinder.startVec3, null, arrayList, aStarCustomPathFinder4.startVec3.squareDistanceTo(aStarCustomPathFinder4.endVec3), 0.0, 0.0));
            int n = 0;
            int n2 = n;
            while (n2 < a) {
                AStarCustomPathFinder aStarCustomPathFinder5 = aStarCustomPathFinder;
                aStarCustomPathFinder5.hubsToWork.sort(new CompareHub());
                int n3 = 0;
                if (aStarCustomPathFinder5.hubsToWork.size() == 0) {
                    aStarCustomPathFinder2 = aStarCustomPathFinder;
                    break block7;
                }
                for (Hub a322 : new ArrayList<Hub>(aStarCustomPathFinder.hubsToWork)) {
                    int n4;
                    if (++n3 > a2) break;
                    aStarCustomPathFinder.hubsToWork.remove(a322);
                    aStarCustomPathFinder.hubs.add(a322);
                    Object object = flatCardinalDirections;
                    int n5 = ((Vec3[])object).length;
                    int n6 = n4 = 0;
                    while (n6 < n5) {
                        Vec3 vec3 = object[n4];
                        vec3 = a322.getLoc().add(vec3).floor();
                        if (AStarCustomPathFinder.checkPositionValidity(vec3, false) && aStarCustomPathFinder.addHub(a322, vec3, 0.0)) {
                            aStarCustomPathFinder2 = aStarCustomPathFinder;
                            break block7;
                        }
                        n6 = ++n4;
                    }
                    object = a322.getLoc().addVector(0.0, 1.0, 0.0).floor();
                    if (AStarCustomPathFinder.checkPositionValidity((Vec3)object, false) && aStarCustomPathFinder.addHub(a322, (Vec3)object, 0.0)) {
                        aStarCustomPathFinder2 = aStarCustomPathFinder;
                    } else {
                        Vec3 vec3 = a322.getLoc().addVector(0.0, -1.0, 0.0).floor();
                        if (!AStarCustomPathFinder.checkPositionValidity(vec3, false) || !aStarCustomPathFinder.addHub(a322, vec3, 0.0)) continue;
                        aStarCustomPathFinder2 = aStarCustomPathFinder;
                    }
                    break block7;
                }
                n2 = ++n;
            }
            aStarCustomPathFinder2 = aStarCustomPathFinder;
        }
        aStarCustomPathFinder2.hubs.sort(new CompareHub());
        aStarCustomPathFinder.path = aStarCustomPathFinder.hubs.get(0).getPath();
    }

    /*
     * WARNING - void declaration
     */
    public static boolean checkPositionValidity(int n, int n2, int n3, boolean bl) {
        void a;
        void a2;
        int a222 = n2;
        int a3 = n;
        class_2338 class_23382 = new class_2338(a3, a222, (int)a2);
        class_2338 class_23383 = new class_2338(a3, a222 + 1, (int)a2);
        class_2338 a222 = new class_2338(a3, a222 - 1, (int)a2);
        return !AStarCustomPathFinder.isBlockSolid(class_23382) && !AStarCustomPathFinder.isBlockSolid(class_23383) && (AStarCustomPathFinder.isBlockSolid(a222) || a == false) && AStarCustomPathFinder.isSafeToWalkOn(a222);
    }

    private static class Hub {
        private double squareDistanceToFromTarget;
        private ArrayList<Vec3> path;
        private Vec3 loc;
        private double cost;
        private double totalCost;
        private Hub parent;

        public void setLoc(Vec3 vec3) {
            Vec3 a = vec3;
            Hub a2 = this;
            a2.loc = a;
        }

        /*
         * WARNING - void declaration
         */
        public Hub(Vec3 vec3, Hub hub, ArrayList<Vec3> arrayList, double d, double d2, double d3) {
            void a;
            void a2;
            void a3;
            void a4;
            Hub a5;
            void a6;
            ArrayList<Vec3> a7 = arrayList;
            Hub hub2 = a5 = this;
            Hub hub3 = a5;
            Hub hub4 = a5;
            hub4.loc = a2;
            hub4.parent = a4;
            hub3.path = a7;
            hub3.squareDistanceToFromTarget = a;
            hub2.cost = a6;
            hub2.totalCost = a3;
        }

        public double getCost() {
            Hub a;
            return a.cost;
        }

        public double getSquareDistanceToFromTarget() {
            Hub a;
            return a.squareDistanceToFromTarget;
        }

        public ArrayList<Vec3> getPath() {
            Hub a;
            return a.path;
        }

        public double getTotalCost() {
            Hub a;
            return a.totalCost;
        }

        public void setCost(double a) {
            a.cost = a;
        }

        public Hub getParent() {
            Hub a;
            return a.parent;
        }

        public Vec3 getLoc() {
            Hub a;
            return a.loc;
        }

        public void setSquareDistanceToFromTarget(double a) {
            a.squareDistanceToFromTarget = a;
        }

        public void setPath(ArrayList<Vec3> arrayList) {
            ArrayList<Vec3> a = arrayList;
            Hub a2 = this;
            a2.path = a;
        }

        public void setTotalCost(double a) {
            a.totalCost = a;
        }

        public void setParent(Hub hub) {
            Hub a = hub;
            Hub a2 = this;
            a2.parent = a;
        }
    }

    public static class CompareHub
    implements Comparator<Hub> {
        /*
         * WARNING - void declaration
         */
        @Override
        public int compare(Hub hub, Hub hub2) {
            void a;
            Hub a2 = hub2;
            CompareHub a3 = this;
            return (int)(a.getSquareDistanceToFromTarget() + a.getTotalCost() - (a2.getSquareDistanceToFromTarget() + a2.getTotalCost()));
        }

        public CompareHub() {
            CompareHub a;
        }
    }

}
