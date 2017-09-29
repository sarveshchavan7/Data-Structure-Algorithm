package com.sarvesh.binarysearch_algo;

public class BinarySearch {

	// Find the first occurrence of element in the sorted array using binary
	// search
	public int firstOccurrence(int a[], int x) {
		int low = 0;
		int high = a.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				result = mid;
				high = mid - 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	// Find the last occurrence of element in the sorted array using binary
	// search
	public int lastOccurrence(int a[], int x) {
		int low = 0;
		int high = a.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				result = mid;
				low = mid + 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	// Find the count of the duplicate number in sorted array
	int countDuplicateNo(int a[], int x) {
		int firstOccurrence = firstOccurrence(a, x);
		int lastOccurrence = lastOccurrence(a, x);
		return (lastOccurrence - firstOccurrence) + 1;
	}

	// How many times is the circular sorted array rotated
	int countRotation(int a[]) {
		int low = 0;
		int high = a.length - 1;
		int N = high;

		while (low <= high) {
			int mid = (low + high) / 2;
			// array has not been rotated at all
			if (a[low] <= a[high]) {
				return low;
			}
			int next = (mid + 1) % N;
			int prev = (mid + N - 1) % N;
			// We get the pivot point so return index
			if (a[prev] > a[mid] && a[mid] < a[next]) {
				return mid;
			}
			// Ignore the search space which is sorted because pivot point will
			// not lie there
			if (a[low] < a[mid]) {
				low = mid + 1;
			} else /* if (a[mid + 1] < a[high]) */ {
				high = mid - 1;
			}
		}
		return 0;
	}

	// Find the element in the circular sorted array
	int findElement(int a[], int x) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			//If we found the element simply return the index
			if (a[mid] == x) {
				return mid;
			}
			// Check for the sorted half
			else if (a[mid] < a[high]) {
				if (x > a[mid] && x <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (a[low] < a[mid]) {
				if (x >= a[low] && x < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}else{
				return -1;
			}
		}
		return -1;
	}

	// Find the element in the array Time complexity-O(n)
	// Array is sorted in ascending order (Recursive solution)
	public int binarySearchAlgo(int a[], int low, int high, int x) {
		int mid = (low + high) / 2;
		// If mid is x simply return the value
		if (a[mid] == x) {
			return mid;
		}
		// If we didn't find any element simply return -1
		if (low == high) {
			return -1;
		}
		// If mid element value is less then x go search higher(right) indices
		if (a[mid] < x) {
			return binarySearchAlgo(a, mid + 1, high, x);
		}
		// If mid element value is less then x go search lower(left) indices
		else /* if (a[mid] > x) */ {
			return binarySearchAlgo(a, low, mid - 1, x);
		}

	}

	// Find the element in the array Time complexity-O(n)
	// Using Iteration
	public int binarySearchAlgo(int a[], int x) {
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				return mid;
			}
			if (x > a[mid]) {
				low = mid + 1;
			} else /* if(a[mid] < x) */ {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// sorted array
		int a[] = { 2, 3, 5, 6, 9, 10 };
		BinarySearch bs = new BinarySearch();
		int indexOne = bs.binarySearchAlgo(a, 0, a.length - 1, 11);
		System.out.println(indexOne);

		int indexTwo = bs.binarySearchAlgo(a, 11);
		System.out.println(indexTwo);

		int array[] = { 0, 3, 10, 10, 10, 10, 20, 25, 26 };
		int firstOccurrence = bs.firstOccurrence(array, 10);
		int lastOccurrence = bs.lastOccurrence(array, 10);
		System.out.println("First Occurrence " + firstOccurrence + " Last Occurrence " + lastOccurrence);

		int count = bs.countDuplicateNo(array, 10);
		System.out.println("Duplicate No " + count);

		int arratTwo[] = { 11, 20, 25, 30, 40, 45, 10 };
		int countRotation = bs.countRotation(arratTwo);
		System.out.println("count rotation " + countRotation);
		
		int arrayThree[]={8,9,10,11,12,3,4,5};
		int index = bs.findElement(arrayThree,9);
		System.out.println("Element found at "+index);
	}

}
