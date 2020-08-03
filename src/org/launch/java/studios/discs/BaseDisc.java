package org.launch.java.studios.discs;


public class BaseDisc implements OpticalDisc {
    double speedAtCenter;
    double speedAtEdge;
    double capacity;
    double speedMultiplier;
    String diskType;
    boolean rewritable;
    
    public BaseDisc(double speedAtCenter, double speedAtEdge, double capacity, double speedMultiplier, String diskType, boolean rewritable) {
        this.speedAtCenter = speedAtCenter;
        this.speedAtEdge = speedAtEdge;
        this.capacity = capacity;
        this.rewritable = rewritable;
        this.diskType = diskType;
        this.speedMultiplier = speedMultiplier;
    }

    @Override
	public String spinDisc() {
        return String.format("The %s disc is spinning at %s - %s RPM", diskType, prettify(speedAtCenter * speedMultiplier), prettify(speedAtEdge * speedMultiplier));
    }
    
    @Override
	public String stopDisc() {
        return String.format("the %s disc has stopped spinning", diskType);
    }
    
    public double getSpeedAtCenter() {
        return speedAtCenter * speedMultiplier;
    }

    public double getSpeedAtEdge() {
        return speedAtEdge * speedMultiplier;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean isRewritable() {
        return rewritable;
    }

    public void setRewritable(boolean rewritable) {
        this.rewritable = rewritable;
    }

    public static String prettify(double aNumber) {
        return aNumber % 1 == 0 ? String.format("%.0f", aNumber) : String.format("%.2f", aNumber);
    }

}