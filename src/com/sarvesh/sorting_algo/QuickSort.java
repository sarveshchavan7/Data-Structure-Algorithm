package com.sarvesh.sorting_algo;

public class QuickSort {

	public void quickSortAlgo(int a[],int startIndex,int endIndex){
		if(startIndex<endIndex){
			int pIndex = partition(a,startIndex,endIndex);
			quickSortAlgo(a,startIndex,pIndex-1);
			quickSortAlgo(a,pIndex+1,endIndex);
		}
	}
	
	
	public int partition(int a[],int startIndex,int endIndex) {
		int pivot = a[endIndex];
		int pIndex = startIndex;
		for (int i = startIndex; i <=endIndex; i++) {
			if (a[i] < pivot) {
				// swapping
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				// increment pIndex
				pIndex +=1;
			}
		}
		int temp = a[endIndex];
		a[endIndex] = a[pIndex];
		a[pIndex] = temp;

		return pIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 7, 2, 3, 1, 5, 6, 4 };
		QuickSort qs = new QuickSort();
		qs.quickSortAlgo(a,0,a.length-1);
		for(int i = 0 ; i < a.length ; i++){
			System.out.print(a[i]+"->");
		}
	}

}
