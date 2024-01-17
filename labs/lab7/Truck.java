import static java.lang.Thread.sleep;

public class Truck {
    private Product[] loadBox;
    private int capacity;
    private Warehouse departureWarehouse;
    private Warehouse arrivalWarehouse;
    private int peekIndex;
    private boolean isLoaderChiefReady;

    public Truck(int minValue, Warehouse departureWarehouse, Warehouse arrivalWarehouse) {
        this.setNullLoadBox(minValue);
        this.capacity = 0;
        this.setDepartureWarehouse(departureWarehouse);
        this.setArrivalWarehouse(arrivalWarehouse);
        this.isLoaderChiefReady = false;
    }

    public synchronized void loadFromDepartureWarehouse(Loader loader, int dwPeekIndex, int threadNum, int i) {
        try {
            loader.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println(String.format("%s: %s ", loader.getName(), i));

        Product pocket = departureWarehouse.getProductList()[dwPeekIndex - (i * 3 + (threadNum-1))];

        if (pocket != null && capacity + pocket.getWeight() <= 150) {
            int weight = pocket.getWeight();

            System.out.println(String.format(
                    "%s: product with weight %s was loaded from the departure warehouse to the loadbox.",
                    loader.getName(),
                    weight
            ));
            departureWarehouse.getProductList()[dwPeekIndex - (i * 3 + (threadNum-1))] = null;
            loadBox[i * 3 + (threadNum-1)] = pocket;
            capacity += weight;
        }
    }

    public synchronized void loadToArrivalWarehouse(Loader loader, int awPeekIndex, int threadNum, int i) {
        try {
            loader.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        Product pocket = loadBox[i * 3 + (threadNum-1)];

        if (pocket != null) {
            int weight = pocket.getWeight();

            System.out.println(String.format(
                    "%s: product with weight %s was loaded from the loadbox to the arrival warehouse.",
                    loader.getName(),
                    weight
            ));
            arrivalWarehouse.getProductList()[awPeekIndex+1 + i * 3 + (threadNum-1)] = pocket;
            loadBox[i * 3 + (threadNum-1)] = null;
            capacity -= weight;
        }
    }

    public synchronized void printResults(Loader loader, int threadNum) {
        if (threadNum == 1) {
            try { sleep(2000); }
            catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println("\nThe load box is now full:");
            printLoadBox();
            try { sleep(1400); }
            catch (InterruptedException e) { e.printStackTrace(); }

            getDepartureWarehouse().printProductList("\nThe departure warehouse in the end:");
            try { sleep(2000); }
            catch (InterruptedException e) { e.printStackTrace(); }

            getArrivalWarehouse().printProductList("\n\nThe arrival warehouse at first:");
            try { sleep(2000); }
            catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println("Load begins...");
            isLoaderChiefReady = true;
            notifyAll();
        }

        else {
            while (!isLoaderChiefReady) {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public void printLoadBox() {
        System.out.print("{ ");
        for (Product product: loadBox) {
            if (product != null) System.out.print(String.format("%s ", product.toString()));
            else System.out.print("null ");
        }
        System.out.println("}");
    }

    public void setNullLoadBox(int capacity) {
        if (capacity > 150 || capacity < 0) {
            System.out.println("Error: incorrect value!");
            System.exit(-1);
        }
        else {
            this.loadBox = new Product[capacity];
            this.peekIndex = capacity-1;
        }
    }

    public int getPeekIndex() {
        return peekIndex;
    }

    public Warehouse getDepartureWarehouse() {
        return this.departureWarehouse;
    }

    public Warehouse getArrivalWarehouse() {
        return this.arrivalWarehouse;
    }

    public void setDepartureWarehouse(Warehouse departureWarehouse) {
        this.departureWarehouse = departureWarehouse;
    }

    public void setArrivalWarehouse(Warehouse arrivalWarehouse) {
        this.arrivalWarehouse = arrivalWarehouse;
    }
}
