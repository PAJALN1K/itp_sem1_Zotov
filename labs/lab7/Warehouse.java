import java.util.*;

public class Warehouse {
    private Product[] productList;
    private int capacity;
    private int peekIndex;

    public Warehouse(int capacity) {
        setCapacity(capacity);
        setEmptyProductList(capacity);
    };

    public void fillWarehouse(int productsNumber, int minWeight, int maxWeight) {
        for (int i = 0; i < productsNumber; i++) {
            Random r = new Random();
            Product productI = new Product(r.nextInt(minWeight-1, maxWeight)+1);
            productList[i] = productI;
        }
        peekIndex = productsNumber - 1;
    }

    public void printProductList(String openingString) {
        int count = 0;
        System.out.println(openingString);
        System.out.print("{ ");
        for (Product product: productList) {
            if (product != null) System.out.print(String.format("%s ", product));
            else break;
            count++;
            if (count % 10 == 0) System.out.println();
        }
        System.out.println("}");
    }


    public Product[] getProductList() {
        return productList;
    }

    public int getPeekIndex() {
        return peekIndex;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEmptyProductList(int capacity) {
        this.productList = new Product[capacity];
    }
}
