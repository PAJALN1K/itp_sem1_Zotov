public class MatrixMax {
    public static int matrixMax(int[][] matrix) {
        ZotThreadV2[] threadsArray = new ZotThreadV2[matrix.length];
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < threadsArray.length; i++) {
            threadsArray[i] = new ZotThreadV2(matrix[i]);
            threadsArray[i].start();
        }
        try {
            for (ZotThreadV2 thread: threadsArray) thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (ZotThreadV2 thread: threadsArray) {
            if (thread.getMaxElement() > maxElement) maxElement = thread.getMaxElement();
        }

        return maxElement;
    }
}
