import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// //System.out.println(Arrays.toString(createSortedArray(10)));

		// //System.out.println(Arrays.toString(createReverseSortedArray(10)));

		// //System.out.println(Arrays.toString(createRandomArray(10, 1, 1000)));

		int inputLength1 = 10;
		int inputLength2 = 10000;
		int inputLength3 = 100000;
		int inputLength4 = 1000000;
		int inputLength5 = 10000000;


		/*
		 * Array input lenght = 10
		 */

		// // sorted
		// callMethod("sorted", inputLength1);

		// // reverse sorted
		// callMethod("reverseSorted", inputLength1);

		// // sorted, one unsorted
		// callMethod("sortedUnsortedElement", inputLength1);

		// // reverse sorted, one unsorted
		// callMethod("reverseSortedUnsortedElement", inputLength1);

		// // random array
		// callMethod("random", inputLength1);

		// // array with identical element
		// callMethod("indenticalElements", inputLength1);

		// // random with value range
		// callMethod("valueRange", inputLength1);

		/*
		 * Array input lenght = 10000
		 */

		// sorted
		// callMethod("sorted", inputLength2);

		// // reverse sorted
		// callMethod("reverseSorted", inputLength2);

		// // sorted, one unsorted
		// callMethod("sortedUnsortedElement", inputLength2);

		// // reverse sorted, one unsorted
		// callMethod("reverseSortedUnsortedElement", inputLength2);

		// // random array
		// callMethod("random", inputLength2);

		// // array with identical element
		// callMethod("indenticalElements", inputLength2);

		// // random with value range
		// callMethod("valueRange", inputLength2);

		// /*
		//  * Array input lenght = 100000
		//  */

		// sorted
		callMethod("sorted", inputLength3);

		// reverse sorted
		callMethod("reverseSorted", inputLength3);

		// sorted, one unsorted
		callMethod("sortedUnsortedElement", inputLength3);

		// reverse sorted, one unsorted
		callMethod("reverseSortedUnsortedElement", inputLength3);

		// random array
		callMethod("random", inputLength3);

		// array with identical element
		callMethod("indenticalElements", inputLength3);

		// random with value range
		callMethod("valueRange", inputLength3);

		// /*
		//  * Array input lenght = 1000000
		//  */

		// //sorted
		// callMethod("sorted", inputLength4);

		// // reverse sorted
		// callMethod("reverseSorted", inputLength4);

		// // sorted, one unsorted
		// callMethod("sortedUnsortedElement", inputLength4);

		// // reverse sorted, one unsorted
		// callMethod("reverseSortedUnsortedElement", inputLength4);

		// // random array
		// callMethod("random", inputLength4);

		// // array with identical element
		// callMethod("indenticalElements", inputLength4);

		// // random with value range
		// callMethod("valueRange", inputLength4);

		// /*
		//  * Array input lenght = 10000000
		//  */

		// // sorted
		// callMethod("sorted", inputLength5);

		// // reverse sorted
		// callMethod("reverseSorted", inputLength5);

		// // sorted, one unsorted
		// callMethod("sortedUnsortedElement", inputLength5);

		// // reverse sorted, one unsorted
		// callMethod("reverseSortedUnsortedElement", inputLength5);

		// // random array
		// callMethod("random", inputLength5);

		// // array with identical element
		// callMethod("indenticalElements", inputLength5);

		// // random with value range
		// callMethod("valueRange", inputLength5);
	}

	public static void callMethod(String sortVariant, int inputLength){

		int[] array;

		// initialising Arrays

		switch(sortVariant){
			case "sorted":
				array = createSortedArray(inputLength);

				callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
				callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
				callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
				callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);

			break;

			case "reverseSorted":
				array = createReverseSortedArray(inputLength);

				callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
				callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
				callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
				callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);
			break;

			case "sortedUnsortedElement":
				array = createSortedArrayWithOneUnsortedElement(inputLength);

				callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
				callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
				callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
				callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);
			break;

			case "reverseSortedUnsortedElement":
				array = createReverseSortedArrayWithOneUnsortedElement(inputLength);

				callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
				callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
				callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
				callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);
			break;

			case "random":
				array = createRandomArray(inputLength, 0, inputLength);

				callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
				callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
				callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
				callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);
			break;

			// identical elements
			case "indenticalElements":
			array = createArrayWithIdenticalElements(inputLength, 0, inputLength);

			callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
			callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
			callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
			callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);
			break;

			// identical elements
			case "valueRange":
				array = createArrayWithValueRange(inputLength, 0, inputLength);

				callAndMeasureMergeSort(array.clone(), sortVariant, inputLength);
				callAndMeasureRadomizedQuicksort(array.clone(), sortVariant, inputLength);
				callAndMeasureCountingSort(array.clone(), sortVariant, inputLength);
				callAndMeasureHeapSort(array.clone(), sortVariant, inputLength);
				break;

			default:
			System.out.println("Error: wrong sorting variant!");
		}
	}

	public static void callAndMeasureMergeSort(int[]A, String sortVariant, int inputLength){
		try {
			long startTime = System.currentTimeMillis();
		
			mergeSort(A, 0, A.length-1);
	
			long endTime = System.currentTimeMillis();
			long executionTime = (endTime - startTime);
	
			printResults(sortVariant, "MergeSort", ""+executionTime, inputLength);
		} catch (StackOverflowError e) {
			printResults(sortVariant, "MergeSort", ""+e, inputLength);
		}

	}
	
	public static void callAndMeasureRadomizedQuicksort(int[]A, String sortVariant, int inputLength){

		try {
			long startTime = System.currentTimeMillis();
		
			randomizedQuicksort(A, 0, A.length-1);
	
			long endTime = System.currentTimeMillis();
			long executionTime = (endTime - startTime);
	
			printResults(sortVariant, "RandomizedQuicksort", ""+executionTime, inputLength);
		} catch (StackOverflowError e) {
			printResults(sortVariant, "RandomizedQuicksort", ""+e, inputLength);
			//System.out.println(e);
		}

	}
	
	public static void callAndMeasureCountingSort(int[]A, String sortVariant, int inputLength){

		int[] B = new int [A.length];
		
		int k = 0;
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] > k) {
				k = A[i];
			}
		}
		

		try {
			long startTime = System.currentTimeMillis();

			countingSort(A, B, k);
	
			long endTime = System.currentTimeMillis();
			long executionTime = (endTime - startTime);
	
			printResults(sortVariant, "CountingSort", ""+executionTime, inputLength);
		} catch (StackOverflowError e) {
			printResults(sortVariant, "CountingSort", ""+e, inputLength);
		}
	}
	
	public static void callAndMeasureHeapSort(int[]A, String sortVariant, int inputLength){

		try {
			long startTime = System.currentTimeMillis();
		
			heapSort(A);
	
			long endTime = System.currentTimeMillis();
			long executionTime = (endTime - startTime);
	
			printResults(sortVariant, "HeapSort", ""+executionTime, inputLength);
		} catch (StackOverflowError e) {
			printResults(sortVariant, "HeapSort", ""+e, inputLength);
		}

	}

	// Printing results to the console

	public static void printResults(String sortVariant, String sortingAlgorithm, String executionTime, int inputLength){
		System.out.println("\n" + "+++++++++++++++++++++++++++++" + "\n");

		System.out.println(
			"Sorting Variant: " + sortVariant + "\n" +
			"Sorting Algorithm: " + sortingAlgorithm + "\n" +
			"Execution Time (in ms) : " + executionTime + "\n" +
			"Input Length: " + inputLength
		);

		System.out.println("\n" + "+++++++++++++++++++++++++++++" + "\n");
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

	public static int[] createReverseSortedArrayWithOneUnsortedElement(int length){
		int[] array = new int [length];

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

	public static int[] createArrayWithIdenticalElements(int length, int minRandom, int maxRandom){
		int[] array = new int[length];

		return array;
	}

	public static int[] createArrayWithValueRange(int length, int minRandom, int maxRandom){
		int[] array = new int[length];

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

		// return A;
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
			//System.out.println(A[j] + " <= " + x);
			//System.exit(0);

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
			//System.out.println("P: " + p + " R: " + r);
			int q = partition(A, p, r);

			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
		return A;
	}

	public static int randomizedPartition(int[] A, int p, int r) {

		// int i = randomize(p, r);
		int i = (int) (Math.random() * A.length);

		// //System.out.println(i);

		int tmp = A[i];
		// //System.out.println(A[r]);
		A[i] = A[r];
		A[r] = tmp;

		// //System.out.println(A[r]);

		return partition(A, p, r);
	}

	public static void randomizedQuicksort(int[] A, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(A, p, r);

			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
//		//System.out.println(Arrays.toString(A));
		// return A;
	}

	// Counting Sort

	public static void countingSort(int[] A, int[] B, int k) {

		int[] C = new int[k + 1];
//		//System.out.println(B.length);

		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;
		}

		//System.out.println(Arrays.toString(C));

		for (int i = 1; i <= k; i++) {
//			//System.out.println(C[i-1] + "+" + C[i]);
			C[i] = C[i] + C[i - 1];
		}

		//System.out.println(Arrays.toString(C));
//		//System.out.println(A.length);

		int[] result = new int[A.length + 1];

		for (int j = A.length - 1; j >= 0; j--) {
			// //System.out.println(A[j]);
//			//System.out.println(B[C[A[j]]] + " = " + A[j]);

			result[C[A[j]]] = A[j];

			C[A[j]] = C[A[j]] - 1;
		}

		for (int i = 1; i < result.length; i++) {

			B[i - 1] = result[i];
		}

		// return B;
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

		// return A;
	}

}
