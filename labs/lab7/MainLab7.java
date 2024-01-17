public class MainLab7 {
    public static void main(String[] args) {
        System.out.println("=====Task 1: Array sum=====");
        System.out.println(ArraySum.arraySum(new int[] {1, 2, 3, 4, 5}));
        System.out.println(ArraySum.arraySum(new int[] {65, 22, 43, 14, 25, 10}));
        System.out.println(ArraySum.arraySum(new int[] {31, 21, 32, 48, 52}));

        System.out.println("\n=====Task 2: Matrix max=====");
        System.out.println(MatrixMax.matrixMax(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 29, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        }));
        System.out.println(MatrixMax.matrixMax(new int[][] {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        }));

        System.out.println("\n=====Task 3: Loaders and warehouses (multithread)=====");
        task3();
    }

    public static void task3() {
        final int MIN_WEIGHT = 25;
        final int MULTITHREAD_NUM = (((150 / MIN_WEIGHT) / 3) * 3) + ((MIN_WEIGHT % 3 + 2) / 3);

        Warehouse warehouse1 = new Warehouse(40);
        warehouse1.fillWarehouse(MULTITHREAD_NUM * 2, MIN_WEIGHT, 45);
        Warehouse warehouse2 = new Warehouse(30);
        warehouse2.fillWarehouse(MULTITHREAD_NUM * 2, MIN_WEIGHT, 45);

        Truck truck = new Truck(MULTITHREAD_NUM, warehouse1, warehouse2);

        Loader loader1 = new Loader("Loader 1", truck);
        Loader loader2 = new Loader("Loader 2", truck);
        Loader loader3 = new Loader("Loader 3", truck);

        truck.getDepartureWarehouse().printProductList("The departure warehouse at first:");

        loader1.start();
        loader2.start();
        loader3.start();

        try {
            loader1.join();
            loader2.join();
            loader3.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nThe load box is now empty. All of the products have been successfully delivered!");
        truck.getArrivalWarehouse().printProductList("\nThe arrival warehouse in the end:");
    }
}
