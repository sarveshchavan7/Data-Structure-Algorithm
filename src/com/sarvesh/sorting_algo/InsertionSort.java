package com.sarvesh.sorting_algo;

public class InsertionSort {

	public void insertionSortAlgo(int a[]) {

		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int hole = i;
			while (hole > 0 && temp < a[hole - 1]) {
				a[hole] = a[hole - 1];
				hole = hole - 1;
			}
			a[hole] = temp;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={7,3,2,5,6};
		InsertionSort is = new InsertionSort();
		is.insertionSortAlgo(a);
		for(int i = 0 ; i <a.length;i++){
			System.out.print(a[i]+"->");
		}
		
	}

}
