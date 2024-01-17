public class ArraySum {
    public static int arraySum(int[] array) {
        int arraySum = 0;
        ZotThreadV1 thread1 = new ZotThreadV1(array, 0, array.length / 2, arraySum);
        ZotThreadV1 thread2 = new ZotThreadV1(array, array.length / 2, array.length, arraySum);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return thread1.getSum() + thread2.getSum();
    }
}
