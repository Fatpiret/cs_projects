package mergeSort;

public class MergeSort {
	public static void sort(Comparable[] arr) { //object to comparable
        Comparable[] temp = new Comparable[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

	private static void mergeSort(Comparable[] arr, Comparable[] temp, int first, int last) {
        if (first >= last) {
            return;
        }

        int mid = first + (last - first) / 2;
        mergeSort(arr, temp, first, mid);
        mergeSort(arr, temp, mid + 1, last);
        merge(arr, temp, first, mid, last);
    }

    private static void merge(Comparable[] arr, Comparable[] temp, int first, int mid, int last) {
        	int beginHalf1 = first;
    		int endHalf1 = mid;
    		int beginHalf2 = mid + 1;
    		int endHalf2 = last;
    		int index = beginHalf1; 
    		while(beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2) {
    			if (arr[beginHalf1].compareTo(arr[beginHalf2]) <= 0) {
    				temp[index] = arr[beginHalf1];
    				beginHalf1++;
    			} else {
    			temp[index] = arr[beginHalf2];
    			beginHalf2++;
    			}
    			index ++;
    			}
    		  
    		while(beginHalf1 <= endHalf1) {
    			temp[index] = arr[beginHalf1];
    			index ++;
    			beginHalf1++;
    			}
    			while(beginHalf2 <= endHalf2) {
    			temp[index] = arr[beginHalf2];
    			index++;
    			beginHalf2++;
    			}
    			for(int i = 0, j = first; i <= (last - first); i++, j++) {
    				arr[j] = temp[i];
    			}
    			}
    }