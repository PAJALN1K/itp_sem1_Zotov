public class ZotThreadV1 extends Thread {
    private int[] array;
    private int firstBound;
    private int lastBound;
    private int sum;

    public ZotThreadV1(int[] array, int firstBound, int lastBound, int sum) {
        this.array = array;
        this.firstBound = firstBound;
        this.lastBound = lastBound;
        this.sum = sum;
    }

    public void run() {
        for (int i = firstBound; i < lastBound; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
