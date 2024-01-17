package task;

public abstract class Appliance {
    private int price;
    private String brand;
    private String model;

    public Appliance(int priceVal, String brandName, String modelName) {
        setPrice(priceVal);
        brand = brandName;
        model = modelName;
    }

    public Appliance() {
        this(0, "USSR", "M1234");
    }

    public void presentation() {
        System.out.println("\nThis is an appliance " + model + " of " + brand + " brand.");
        System.out.println("Its initial price is " + price + " rubles.");
    }

    public void buy(int money) {
        if (money < price) {
            System.out.println("\nNot enough money!");
        }
        else {
            System.out.println("\nAn appliance " + model + " has been bought.");
        }
    }

    public void isBrandPopular() {
        String[] popularBrands = new String[3];
        popularBrands[0] = "Bosch";
        popularBrands[1] = "Samsung";
        popularBrands[2] = "LG";

        boolean flag = true;
        for (String brandI: popularBrands) {
            if (brandI.equals(brand)) {
                System.out.println("\nThe brand of this appliance is popular!");
                flag = false;
            }
            if (brandI.equals("LG") && flag) {
                System.out.println("\nThe brand of this appliance isn't popular!");
            }
        }
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setPrice(int priceVal) {
        if (priceVal >= 0) price = priceVal;
        else System.out.println("\nError! Price cannot be a negative number!");
    }

    public void setBrand(String brandName) {
        brand = brandName;
    }

    public void setModel(String modelName) {
        model = modelName;
    }
}
