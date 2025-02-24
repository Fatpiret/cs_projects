package maxDigits;
import java.util.Arrays;

public class MaxDigits {
	private static void sort(int arr[]) {
	    for(int i = 1; i < arr.length; i++) {
	        for(int j = i; j > 0; j--) {
	           //provide code that completes the insertion sort.
	           //Don't forget to stop the code at the appropriate time
	           //to keep with the best case efficiency
	        	

	        		int res = ((Comparable<Integer>) arr[j]).compareTo(arr[j - 1]);

	        		if (res < 0) {

	        		swap(arr, j, j - 1);

	        		} else {

	        		break;
	        		}}}
	    
	}

	private static void swap(int arr[], int idx1, int idx2) {
	    int temp = arr[idx1];
	    arr[idx1] = arr[idx2];
	    arr[idx2] = temp;
	}

	public static void main(String args[]) {
	    int nums[] = {33, 50, 24, 43, 10, 30, 18};
	    sort(nums);
	    System.out.println(Arrays.toString(nums)); //should print [1, 2, 3, 4, 5]
	}}