package com.sarvesh.sorting_algo;

public class BubbleSort {

	public void bubbleSort(int a[]) {
		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					//swapping
					int temp = a[i+1];
					a[i+1]= a[i];
					a[i]=temp;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 7, 4, 1, 5, 3 };
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "->");
		}
	}

}
