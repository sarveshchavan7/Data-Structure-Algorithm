package com.sarvesh.binarysearch;

public class BinarySearch {

	//Find the first occurrence of element in the circulated sorted array using binary search
	
	//Find the last occurrence of element in the circulated sorted array using binary search 
	
	//Find the count of the duplicate number in sorted array
	
	//How many times is the circular sorted array rotated
	
	//Find the element in the circular sorted array
	
	//Find the element in the array  Time complexity-O(n)
	//Array is sorted in ascending order (Recursive solution)
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

	//Find the element in the array  Time complexity-O(n)
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

	}

}
