package quickSort;
public class QuickSort {

    public static void sort(Object arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Object arr[], int first, int last) {
        if (first < last) {
            int pivotIndex = partition(arr, first, last);
            quickSort(arr, first, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, last);
        }
    }

    private static int partition(Object arr[], int first, int last) {
        Object pivot = arr[last];
        int i = first - 1;
        for (int j = first; j <= last - 1; j++) {
            if (((Comparable) arr[j]).compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, last);
        return i + 1;
    }

    private static void swap(Object arr[], int idx1, int idx2) {
        Object temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private static void sortFirstMiddleLast(Object arr[], int first, int mid, int last) {
        if (((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
            swap(arr, first, mid);
        }
        if (((Comparable) arr[mid]).compareTo(arr[last]) > 0) {
            swap(arr, mid, last);
        }
        if (((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
            swap(arr, first, mid);
        }
    }

    private static void insertionSort(Object arr[], int first, int last) {
        for (int i = first; i <= last; i++) {
            for (int j = i; j > first; j--) {
                int res = ((Comparable) arr[j]).compareTo(arr[j - 1]);
                if (res < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}