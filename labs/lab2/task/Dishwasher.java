package task;

public class Dishwasher extends StationaryAppliance {
    private int platesLots;
    private int employedLots;

    public Dishwasher(int priceVal, String brandName, String modelName, String roomInstance, int lots1, int lots2) {
        super(priceVal, brandName, modelName, roomInstance);
        platesLots = lots1;
        employedLots = lots2;
    }

    public Dishwasher() {
        this(0, "USSR", "M1234", "Footer", 10, 0);
    }

    @Override
    public void presentation() {
        System.out.println("\nThis is a dishwasher " + super.getModel() + " of " + getBrand() + " brand.");
        System.out.println("Its initial price is " + super.getPrice() + " rubles.");
        System.out.println("It is located in \"" + super.getRoom() + "\" room.");
        System.out.println("It can contain " + platesLots + " plates.");
        System.out.println("It now contains " + employedLots + ".");
    }

    public void washAllPlates() {
        employedLots = 0;
        System.out.println("\nAll plates are now washed!");
    }

    public int getPlatesLots() {
        return platesLots;
    }

    public int getEmployedLots() {
        return employedLots;
    }

    public void setPlatesLots(int val) {
        if (val > 0) platesLots = val;
        else if (val == 0) System.out.println("\nA dishwasher must be able to wash at least 1 plate!");
        else System.out.println("\nError! A number of plates lots cannot be negative!");
    }

    public void setEmployedLots(int val) {
        if (val >= 0) employedLots = val;
        else System.out.println("\nError! A number of employed plates lots cannot be negative!");
    }
}
