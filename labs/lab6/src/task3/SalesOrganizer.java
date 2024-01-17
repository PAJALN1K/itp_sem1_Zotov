package src.task3;

import java.util.ArrayList;

public class SalesOrganizer {
    private ArrayList<Product> saledProductsCollection;

    public SalesOrganizer() {
        this.saledProductsCollection = new ArrayList<>();
    }

    public void addToCollection(Product product) {
        saledProductsCollection.add(product);
    }

    public void printSaledProducts() {
        StringBuilder result = new StringBuilder();
        result.append("=====================================\n");
        result.append("List of products: \n");
        for (int i = 0; i < saledProductsCollection.size(); i++) {
            Product product = saledProductsCollection.get(i);
            StringBuilder productFormat = new StringBuilder();
            productFormat.append(String.format("№%s", i+1));
            productFormat.append(String.format("\tName: %s\n", product.getName()));
            productFormat.append(String.format("\tPrice: %s\n", product.getPrice()));
            productFormat.append(String.format("\tNumber of sales:: %s\n", product.getNumberOfSales()));
            result.append(productFormat);
        }
        result.append("=====================================\n\n");
        System.out.println(result);
    }

    public int totalPrice() {
        int result = 0;
        for (Product product: saledProductsCollection) {
            result += product.getPrice() * product.getNumberOfSales();
        }
        return result;
    }

    public String mostPopularProduct() {
        Product maxProduct = null;
        int mostNumber = 0;
        for (Product product: saledProductsCollection) {
            if (product.getNumberOfSales() > mostNumber) {
                mostNumber = product.getNumberOfSales();
                maxProduct = product;
            }
        }
        return maxProduct.getName();
    }
}
