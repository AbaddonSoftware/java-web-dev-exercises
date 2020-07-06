package exercises.technology;

public class Computer extends AbstractEntity{
    private String manufacturer;
    private String processorType;
    private double processorSpeedInMHZ;

    public Computer(String manufacturer, String processorType, double processorSpeedInMHZ) {
        super();
        this.manufacturer = manufacturer;
        this.processorType = processorType;
        this.processorSpeedInMHZ = processorSpeedInMHZ;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public double getProcessorSpeedInMHZ() {
        return processorSpeedInMHZ;
    }

    public void setProcessorSpeedInMHZ(double processorSpeedInMHZ) {
        this.processorSpeedInMHZ = processorSpeedInMHZ;
    }

    public double getProcessorSpeedInGHZ() {
        return processorSpeedInMHZ * .001;
    }


}
