package task;

public class MobileAppliance extends Appliance {
    private boolean autonomy;

    public MobileAppliance(int priceVal, String brandName, String modelName, boolean autonomyVal) {
        super(priceVal, brandName, modelName);
        autonomy = autonomyVal;
    }

    public MobileAppliance() {
        this(0, "USSR", "M1234", false);
    }

    @Override
    public void presentation() {
        super.presentation();
        if (autonomy) System.out.println("Can work without permanent connection to the power supply.");
        else System.out.println("Must be connected to the power supply.");
    }

    public void move() {
        if (autonomy) System.out.println("The appliance was moved.");
        else System.out.println("Cannot move the appliance: it isn't autonomous.");
    }

    public void move(String roomInstance) {
        if (autonomy) System.out.println("The appliance was moved to " + roomInstance + ".");
        else System.out.println("Cannot move the appliance: it isn't autonomous.");
    }

    public boolean getAutonomy() {
        return autonomy;
    }
    public void setAutonomy(boolean sentence) {
        autonomy = sentence;
    }
}
