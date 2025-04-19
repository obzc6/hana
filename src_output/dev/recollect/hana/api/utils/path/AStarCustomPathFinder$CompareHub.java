/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.path;

import dev.recollect.hana.api.utils.path.AStarCustomPathFinder;
import java.util.Comparator;

public static class AStarCustomPathFinder.CompareHub
implements Comparator<AStarCustomPathFinder.Hub> {
    /*
     * WARNING - void declaration
     */
    @Override
    public int compare(AStarCustomPathFinder.Hub hub, AStarCustomPathFinder.Hub hub2) {
        void a;
        AStarCustomPathFinder.Hub a2 = hub2;
        AStarCustomPathFinder.CompareHub a3 = this;
        return (int)(a.getSquareDistanceToFromTarget() + a.getTotalCost() - (a2.getSquareDistanceToFromTarget() + a2.getTotalCost()));
    }

    public AStarCustomPathFinder.CompareHub() {
        AStarCustomPathFinder.CompareHub a;
    }
}
