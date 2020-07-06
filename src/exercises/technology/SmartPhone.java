package exercises.technology;

public class SmartPhone extends Computer{
    private String operatingSystem;
    private boolean isTouchScreen;


    public SmartPhone(String manufacturer, String processorType, double processorSpeedInMHZ, String operatingSystem, boolean isTouchScreen) {
        super(manufacturer, processorType, processorSpeedInMHZ);
        this.operatingSystem = operatingSystem;
        this.isTouchScreen = isTouchScreen;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean isTouchScreen() {
        return isTouchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        isTouchScreen = touchScreen;
    }
}
