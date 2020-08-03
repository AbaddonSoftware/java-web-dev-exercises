package org.launch.java.studios.discs;


public class CD extends BaseDisc {

    public CD() {
        super(200, 500, 732, 1, "CD", false);
    }

    public CD(double speedAtCenter, double speedAtEdge, double capacity, double speedMultiplier, String diskType, boolean isRewritable) {
        super(speedAtCenter, speedAtEdge, capacity, speedMultiplier, diskType, isRewritable);
    }

}