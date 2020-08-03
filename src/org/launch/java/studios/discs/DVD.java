package org.launch.java.studios.discs;

public class DVD extends BaseDisc {

    double capacityMultiplier;

    public DVD() {
        super(570, 1600, 4700, 1, "DVD", false);
        this.capacityMultiplier = 1;
    }

    public DVD(double speedAtCenter, double speedAtEdge, double capacity, double speedMultiplier, String diskType, boolean rewritable) {
        super(speedAtCenter, speedAtEdge, capacity, speedMultiplier, diskType, rewritable);
        this.capacityMultiplier = 1;
    }

    public DVD(double speedAtCenter, double speedAtEdge, double capacity, double speedMultiplier, double capacityMultiplier, String diskType, boolean rewritable) {
        super(speedAtCenter, speedAtEdge, capacity, speedMultiplier, diskType, rewritable);
        this.capacityMultiplier = capacityMultiplier;
    }

    @Override
    public double getCapacity() {
        return capacity * capacityMultiplier;
    }

}