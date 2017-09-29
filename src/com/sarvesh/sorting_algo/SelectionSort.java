package com.sarvesh.sorting_algo;

public class SelectionSort {

	public void selectionSortAlgo(int[] a) {

		for (int i = 0; i < a.length-2; i++) {
			int minValueIndex = i;
			for (int j = i; j < a.length-1; j++) {
				if (a[j] < a[minValueIndex]) {
					minValueIndex = j;
				}
			}
			int temp = a[minValueIndex];
			a[minValueIndex] = a[i];
			a[i] = temp;
		}
	}

	public static void main(String args[]) {
		int a[] = { 3, 5, 0, 2, 7, 6, 9 };
		SelectionSort ss = new SelectionSort();
		ss.selectionSortAlgo(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "->");
		}

	}

}
