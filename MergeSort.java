public class MergeSort {

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int nLeft = left.length;
        int nRight = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nLeft && j < nRight) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < nLeft) {
            arr[k++] = left[i++];
        }

        while (j < nRight) {
            arr[k++] = right[j++];
        }
    }
}
