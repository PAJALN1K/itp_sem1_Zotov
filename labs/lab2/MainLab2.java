import task.*;

public class MainLab2 {
    public static void main(String[] s) {
        StationaryAppliance app1 = new StationaryAppliance(500, "Lenovo", "L1000", "Boys' room");
        app1.presentation();
        app1.printCount();

        Fridge app2 = new Fridge(2000, "Bosch", "B50", "Kitchen", true);
        app2.presentation();
        app2.printCount();
        app2.cleanFreezer();

        MobileAppliance app3 = new MobileAppliance(1500, "SEGA", "PS Vita", true);
        app3.presentation();
        app3.move();
        app3.move("Boys' room");
        app3.isBrandPopular();
    }
}
