package task;

public class VacuumCleaner extends MobileAppliance {
    private int containerVolume;
    private int litterVolume;

    public VacuumCleaner(int priceVal, String brandName, String modelName, boolean autonomyVal, int vol1, int vol2) {
        super(priceVal, brandName, modelName, autonomyVal);
        containerVolume = vol1;
        litterVolume = vol2;
    }

    public VacuumCleaner() {
        this(0, "USSR", "M1234", false, 0, 0);
    }

    @Override
    public void presentation() {
        System.out.println("\nThis is a vacuum cleaner " + super.getModel() + " of " + getBrand() + " brand.");
        System.out.println("Its initial price is " + super.getPrice() + " rubles.");
        if (super.getAutonomy()) System.out.println("Can work without permanent connection to the power supply.");
        else System.out.println("Must be connected to the power supply.");
        System.out.println("It can contain " + containerVolume + " litres of litter.");
        System.out.println("It now contains " + litterVolume + ".");
    }

    @Override
    public void move() {
        if (super.getAutonomy()) System.out.println("\nThe vacuum cleaner was moved.");
        else System.out.println("\nCannot move the vacuum cleaner: it isn't autonomous.");
    }

    @Override
    public void move(String roomInstance) {
        if (super.getAutonomy()) System.out.println("The vacuum cleaner was moved to " + roomInstance + ".");
        else System.out.println("Cannot move the vacuum cleaner: it isn't autonomous.");
    }

    public void cleanContainer() {
        litterVolume = 0;
        System.out.println("\nThe container is now clear!");
    }

    public int getContainerVolume() {
        return containerVolume;
    }

    public int getLitterVolume() {
        return litterVolume;
    }

    public void setContainerVolume(int vol) {
        containerVolume = vol;
    }

    public void setLitterVolume(int vol) {
        litterVolume = vol;
    }
}
