package com.sarvesh.sorting_algo;

public class MergeSort {

	public void mergeSort(int a[], int n) {
		int mid = n / 2;
		if (n < 2) {
			return;
		}
		int left[] = new int[mid];
		int right[] = new int[n - mid];

		for (int i = 0; i < left.length; i++) {
			left[i] = a[i];
		}
		for (int j = mid; j < n; j++) {
			right[j - mid] = a[j];
		}
		mergeSort(left, left.length);
		mergeSort(right, right.length);
		merge(a, left, right);
	}

	public void merge(int[] a, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				a[k] = left[i];
				i += 1;
			} else {
				a[k] = right[j];
				j += 1;
			}
			k += 1;
		}
		while(i<left.length){
			a[k]=left[i];
			i += 1;
			k += 1;
		}
		while(j<right.length){
			a[k]=right[j];
			j += 1;
			k += 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();
		int a[] = { 2, 17, 4, 11, 5, 3, 6 };
		ms.mergeSort(a, a.length);
		for(int i = 0 ; i <a.length;i++){
			System.out.print(a[i]+"->");
		}
	}

}
