import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(createSortedArray(10)));

		System.out.println(Arrays.toString(createReverseSortedArray(10)));

		System.out.println(Arrays.toString(createRandomArray(10, 1, 1000)));
		
		long quicksortStartTime = System.currentTimeMillis();
		
		// **** Sorting ALgorithm here ****
		
		long quicksortEndTime = System.currentTimeMillis();

		long quicksortDuration = (quicksortEndTime - quicksortStartTime);
		
		System.out.println("Quicksort | Duration in ms: " + quicksortDuration);
	}
	
	// Generating Arrays

	public static int[] createSortedArray(int length) {

		int[] array = new int[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		return array;

	}

	public static int[] createReverseSortedArray(int length) {
		int[] array = new int[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = length - i;
		}

		return array;
	}

	public static int[] createSortedArrayWithOneUnsortedElement(int length) {
		int[] array = createSortedArray(length);

		Random r = new Random();

		int randomIndex = r.nextInt(length - 0) + 0;

		int temp = array[randomIndex];

		array[randomIndex] = array[0];

		array[0] = temp;

		return array;
	}

	public static int[] createRandomArray(int length, int minRandom, int maxRandom) {
		int[] array = new int[length];

		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(maxRandom - minRandom) + minRandom;
		}

		return array;
	}

	// Sorting algorithms
	
	// MergeSort
	
	public static void mergeSort(int[] A, int start, int end){
	    if(start < end){
	        int mid = ( start + end ) / 2;
	        mergeSort(A, start, mid);
	        mergeSort(A, mid + 1, end);
	        merge(A, start, mid, end);
	    }
	}

	public static void merge(int[] A, int start, int mid, int end){

	    int[] leftArray = new int[mid - start + 2];
	    int[] rightArray = new int[end - mid + 1];
	    
	    for(int i = start; i <= mid; i++ ) {
	    	leftArray[i - start] = A[i];
	    }
	        
	    
	    for (int i = mid + 1; i <= end; i++ ) {
	    	rightArray[i - mid - 1] = A[i];
	    }
	        

	    leftArray[mid - start + 1] = Integer.MAX_VALUE;
	    rightArray[end - mid] = Integer.MAX_VALUE;

	    int leftIndex = 0, rightIndex = 0;

	    for (int k = start; k <= end; k++){
	        if(leftArray[leftIndex] <= rightArray[rightIndex]) {
	        	A[k] = leftArray[leftIndex++];
	        }
	            
	        else {
	        	A[k] = rightArray[rightIndex++];
	        }
	            
	    }   
	}

	// randomized QuickSort
	
	public static int partition(int[] A, int p, int r) {

		int x = A[r]; // Set Pivot to the last element

		int i = p - 1; // index set to 0 - 1 => -1

		for (int j = p; j < r; j++) {
			System.out.println(A[j] + " <= " + x);
			System.exit(0);

			if (A[j] <= x) { // checking if Elements are smaller or equal to the pivot

				i = i + 1;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}

		int tmp = A[i + 1];

		A[i + 1] = A[r];
		A[r] = tmp;

		return i + 1;
	}

	public static int[] quicksort(int[] A, int p, int r) {
		if (p < r) {
			System.out.println("P: " + p + " R: " + r);
			int q = partition(A, p, r);

			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
		return A;
	}

	public static int randomizedPartition(int[] A, int p, int r) {

		// int i = randomize(p, r);
		int i = (int) (Math.random() * A.length);

		// System.out.println(i);

		int tmp = A[i];
		// System.out.println(A[r]);
		A[i] = A[r];
		A[r] = tmp;

		// System.out.println(A[r]);

		return partition(A, p, r);
	}

	public static int[] randomizedQuicksort(int[] A, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(A, p, r);

			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
//		System.out.println(Arrays.toString(A));
		return A;
	}

	// Counting Sort

	public static int[] countingSort(int[] A, int[] B, int k) {

		int[] C = new int[k + 1];
//		System.out.println(B.length);

		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;
		}

		System.out.println(Arrays.toString(C));

		for (int i = 1; i <= k; i++) {
//			System.out.println(C[i-1] + "+" + C[i]);
			C[i] = C[i] + C[i - 1];
		}

		System.out.println(Arrays.toString(C));
//		System.out.println(A.length);

		int[] result = new int[12];

		for (int j = A.length - 1; j >= 1; j--) {
			// System.out.println(A[j]);
//			System.out.println(B[C[A[j]]] + " = " + A[j]);

			result[C[A[j]]] = A[j];

			C[A[j]] = C[A[j]] - 1;
		}

		for (int i = 1; i < result.length; i++) {

			B[i - 1] = result[i];
		}

		return B;
	}
	
	// HeapSort

	public static void maxHeapify(int[] A, int heapSize, int i) {

		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;

		if (l < heapSize && A[l] > A[largest]) {
			largest = l;
		}

		if (r < heapSize && A[r] > A[largest]) {
			largest = r;
		}

		if (largest != i) {

			int temp = A[i];

			A[i] = A[largest];
			A[largest] = temp;

			maxHeapify(A, heapSize, largest);
		}

	}

	public static void buildMaxHeap(int[] A, int heapSize) {

		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			maxHeapify(A, heapSize, i);
		}
	}

	public static void heapSort(int[] A) {

		int heapSize = A.length;

		buildMaxHeap(A, heapSize);

		for (int i = heapSize - 1; i >= 0; i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;

			maxHeapify(A, i, 0);
		}
	}

}
