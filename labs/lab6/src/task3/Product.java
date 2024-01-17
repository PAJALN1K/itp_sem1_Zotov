package src.task3;

public class Product {
    private String name;
    private int price;
    private int numberOfSales;

    public Product(String name, int price, int numberOfSales) {
        this.name = name;
        this.price = price;
        this.numberOfSales = numberOfSales;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }
}
