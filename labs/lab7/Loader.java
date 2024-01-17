public class Loader extends Thread {
    private Truck truck;
    public Loader(String name, Truck truck) {
        this.setName(name);
        this.truck = truck;
    }
    public void run() {
        int dwPeekIndex = truck.getDepartureWarehouse().getPeekIndex();
        int awPeekIndex = truck.getArrivalWarehouse().getPeekIndex();
        int threadNum = getName().charAt(7) - '0';

        for (int i = 0; i < (truck.getPeekIndex()+1) / 3; i++) {
            truck.loadFromDepartureWarehouse(this, dwPeekIndex, threadNum, i);

            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        truck.printResults(this, threadNum);

        for (int i = 0; i < (truck.getPeekIndex()+1) / 3; i++) {
            truck.loadToArrivalWarehouse(this, awPeekIndex, threadNum, i);

            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
