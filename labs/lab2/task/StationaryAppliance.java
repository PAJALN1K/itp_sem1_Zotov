package task;

public class StationaryAppliance extends Appliance {
    private static int count = 0;
    private String room;

    public StationaryAppliance(int priceVal, String brandName, String modelName, String roomInstance) {
        super(priceVal, brandName, modelName);
        setRoom(roomInstance);
        count += 1;
    }

    public StationaryAppliance() {
        this(0, "USSR", "M1234", "Footer");
        count += 1;
    }

    @Override
    public void presentation() {
        super.presentation();
        System.out.println("It is located in \"" + room + "\" room.");
    }

    public void printCount() {
        System.out.println("\nCount of stationary appliances is now equal to " + getCount());
    }

    public String getRoom() {
        return room;
    }

    public int getCount() {
        return count;
    }

    public void setRoom(String roomInstance) {
        String s1 = roomInstance.replaceAll("[!#%&\"()*+-/<>=_?.,~`@№]", "");
        if (roomInstance.equals(s1)) room = roomInstance;
        else System.out.println("Error! Invalid symbols during setting room.");
    }

    public void setCount(int val) {
        if (val >= 0) count = val;
        else System.out.println("Error! Invalid value during setting stationary appliance count.");
    }
}
