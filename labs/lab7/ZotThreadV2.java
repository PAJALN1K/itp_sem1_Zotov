public class ZotThreadV2 extends Thread {
    private int[] array;
    private int maxElement;

    public ZotThreadV2(int[] array) {
        this.array = array;
        this.maxElement = Integer.MIN_VALUE;
    }

    public void run() {
        for (int element: array) {
            if (element > maxElement) maxElement = element;
        }
    }

    public int getMaxElement() {
        return maxElement;
    }
}
