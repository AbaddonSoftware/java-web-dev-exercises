package exercises.technology;

import java.util.ArrayList;
import java.util.List;

public class Laptop extends Computer{
    private double screenSize;
    private List<String> operatingSystems;
    private double batteryLifeInHours;

    public Laptop(String manufacturer, String processorType, double processorSpeedInMHZ, ArrayList<String> operatingSystems, double screenSize, double batteryLifeInHours) {
        super(manufacturer, processorType, processorSpeedInMHZ);
        this.screenSize = screenSize;
        this.batteryLifeInHours = batteryLifeInHours;
        this.operatingSystems = operatingSystems;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public void addOperatingSystem(String operatingSystem) {
        this.operatingSystems.add(operatingSystem);
    }

    public double getBatteryLifeInHours() {
        return batteryLifeInHours;
    }

    public void setBatteryLifeInHours(double batteryLifeInHours) {
        this.batteryLifeInHours = batteryLifeInHours;
    }
}
