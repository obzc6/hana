/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.path;

import dev.recollect.hana.api.utils.path.AStarCustomPathFinder;
import dev.recollect.hana.api.utils.path.Vec3;
import java.util.ArrayList;

private static class AStarCustomPathFinder.Hub {
    private double squareDistanceToFromTarget;
    private ArrayList<Vec3> path;
    private Vec3 loc;
    private double cost;
    private double totalCost;
    private AStarCustomPathFinder.Hub parent;

    public void setLoc(Vec3 vec3) {
        Vec3 a = vec3;
        AStarCustomPathFinder.Hub a2 = this;
        a2.loc = a;
    }

    /*
     * WARNING - void declaration
     */
    public AStarCustomPathFinder.Hub(Vec3 vec3, AStarCustomPathFinder.Hub hub, ArrayList<Vec3> arrayList, double d, double d2, double d3) {
        void a;
        void a2;
        void a3;
        void a4;
        AStarCustomPathFinder.Hub a5;
        void a6;
        ArrayList<Vec3> a7 = arrayList;
        AStarCustomPathFinder.Hub hub2 = a5 = this;
        AStarCustomPathFinder.Hub hub3 = a5;
        AStarCustomPathFinder.Hub hub4 = a5;
        hub4.loc = a;
        hub4.parent = a6;
        hub3.path = a7;
        hub3.squareDistanceToFromTarget = a2;
        hub2.cost = a4;
        hub2.totalCost = a3;
    }

    public double getCost() {
        AStarCustomPathFinder.Hub a;
        return a.cost;
    }

    public double getSquareDistanceToFromTarget() {
        AStarCustomPathFinder.Hub a;
        return a.squareDistanceToFromTarget;
    }

    public ArrayList<Vec3> getPath() {
        AStarCustomPathFinder.Hub a;
        return a.path;
    }

    public double getTotalCost() {
        AStarCustomPathFinder.Hub a;
        return a.totalCost;
    }

    public void setCost(double a) {
        a.cost = a;
    }

    public AStarCustomPathFinder.Hub getParent() {
        AStarCustomPathFinder.Hub a;
        return a.parent;
    }

    public Vec3 getLoc() {
        AStarCustomPathFinder.Hub a;
        return a.loc;
    }

    public void setSquareDistanceToFromTarget(double a) {
        a.squareDistanceToFromTarget = a;
    }

    public void setPath(ArrayList<Vec3> arrayList) {
        ArrayList<Vec3> a = arrayList;
        AStarCustomPathFinder.Hub a2 = this;
        a2.path = a;
    }

    public void setTotalCost(double a) {
        a.totalCost = a;
    }

    public void setParent(AStarCustomPathFinder.Hub hub) {
        AStarCustomPathFinder.Hub a = hub;
        AStarCustomPathFinder.Hub a2 = this;
        a2.parent = a;
    }
}
