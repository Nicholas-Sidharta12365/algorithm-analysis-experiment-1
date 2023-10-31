import java.util.Stack;

public class TwoPivotBlockQuickSort {

    public static int[] twoPivotBlockPartitioning(int[] array, int start, int end, int block_size) {
        if (end <= start) {
            return new int[]{start, start};
        }
        int pivot1 = array[start];
        int pivot2 = array[end];

        if (pivot1 > pivot2) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            pivot1 = array[start];
            pivot2 = array[end];
        }

        int[] block = new int[block_size];
        int i = start + 1, j = start + 1, k = start + 1;
        int nump = 0, numq = 0;

        while (k < end) {
            int t = Math.min(block_size, end - k);
            for (int c = 0; c < t; c++) {
                block[numq] = c;
                numq += (pivot2 >= array[k + c]) ? 1 : 0;
            }
            for (int c = 0; c < numq; c++) {
                int temp = array[j + c];
                array[j + c] = array[k + block[c]];
                array[k + block[c]] = temp;
            }
            k += t;
            for (int c = 0; c < numq; c++) {
                block[nump] = c;
                nump += (pivot1 > array[j + c]) ? 1 : 0;
            }
            for (int c = 0; c < nump; c++) {
                int temp = array[i];
                array[i] = array[j + block[c]];
                array[j + block[c]] = temp;
                i++;
            }
            j += numq;
            nump = 0;
            numq = 0;
        }

        int temp = array[i - 1];
        array[i - 1] = array[start];
        array[start] = temp;

        temp = array[j];
        array[j] = array[end];
        array[end] = temp;

        return new int[]{i - 1, j};
    }

    public static void twoPivotBlockQuicksort(int[] array, int start, int end) {
        if (array.length == 0) {
            return;
        }

        int blockSize = (int) Math.pow(2, (int) Math.floor(Math.log(array.length) / 3) + 2);

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, end});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            start = range[0];
            end = range[1];
            if (start < end) {
                int[] pivots = twoPivotBlockPartitioning(array, start, end, blockSize);
                stack.push(new int[]{start, pivots[0] - 1});
                stack.push(new int[]{pivots[0] + 1, pivots[1] - 1});
                stack.push(new int[]{pivots[1] + 1, end});
            }
        }
    }
}
