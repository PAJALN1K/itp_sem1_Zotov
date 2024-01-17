package src.task3;

public class Task3 {
    public static void main(String[] names, int[] prices, int[] numbersOfSales) {
        SalesOrganizer salesOrganizer = new SalesOrganizer();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int price = prices[i];
            int numberOfSales = numbersOfSales[i];

            Product product = new Product(name, price, numberOfSales);

            salesOrganizer.addToCollection(product);
        }

        salesOrganizer.printSaledProducts();

        System.out.println("The most popular product is: " + salesOrganizer.mostPopularProduct());

        System.out.println("Total price is: " + salesOrganizer.totalPrice());
    }
}
