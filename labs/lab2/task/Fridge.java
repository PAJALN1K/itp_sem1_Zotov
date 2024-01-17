package task;

public class Fridge extends StationaryAppliance {
    private boolean freezerAvailability;

    public Fridge(int priceVal, String brandName, String modelName, String roomInstance, boolean freezerAvailabilityVal) {
        super(priceVal, brandName, modelName, roomInstance);
        freezerAvailability = freezerAvailabilityVal;
    }

    public Fridge() {
        this(0, "USSR", "M1234", "Footer", true);
    }

    @Override
    public void presentation() {
        System.out.println("\nThis is a dishwasher " + super.getModel() + " of " + getBrand() + " brand.");
        System.out.println("Its initial price is " + super.getPrice() + " rubles.");
        System.out.println("It is located in \"" + super.getRoom() + "\" room.");
        if (freezerAvailability) System.out.println("It has a freezer.");
        else System.out.println("It doesn't have a freezer");
    }

    public void cleanFreezer() {
        if (freezerAvailability) System.out.println("\nThe freezer is now cleaned!");
        else System.out.println("\nThere is no freezer to be cleaned!");
    }

    public boolean getFreezerAvailability() {
        return freezerAvailability;
    }

    public void setFreezerAvailability(boolean sentence) {
        freezerAvailability = sentence;
    }
}
