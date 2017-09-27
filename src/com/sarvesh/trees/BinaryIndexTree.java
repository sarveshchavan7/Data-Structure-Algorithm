package com.sarvesh.trees;

/* 
 * 	Fenwick tree or binary index tree	
 * 
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 * 
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)
 * 
 *	Binary number  - For the odd number end of the bit is 1 or for even number the end of bit is zero
 * 
 *  trick to get the binary number of any decimal number--
 *    decimal 39              128 64 32 16 8 4 2 1
 *     39 - 32 = 7             0   0  1  0 0 1 1 1 ---> binary representation of 39 
 *     7 - 4 = 3
 *     3-2=1
 *     1-1=0                          
 *  
 * 2's compliment of binary numb =  flip all bits + 1 = negative of that number
 *             eg = 0001         =        1110+1      = 1111 (negative one)
 *             
 *
 *  getParent - Method 1. just flip right most set bit
 *  			Method 2. step 1) 2's compliment i.e flip all the bit's + 1
 *  					  step 2) And it with the original number
 *  					  step 3) Subb from the original number
 *  
 *  getNext - Method 2.   step 1) 2's compliment i.e flip all the bit's + 1
 *  					  step 2) And it with the original number
 *  					  step 3) add it to the original number	            
 */

public class BinaryIndexTree {

	
	 /**
     * Creating tree is like updating Fenwick tree for every value in array
     */
	public int[] getBinaryIndexArray(int[] inputArray) {
		int[] binaryIndexArray = new int[inputArray.length + 1];
		binaryIndexArray[0] = 0;
		for (int i = 0; i < binaryIndexArray.length - 1; i++) {
			updateBinaryIndexTree(binaryIndexArray, i + 1, inputArray[i]);
		}
		return binaryIndexArray;

	}

	void updateBinaryIndexTree(int[] binaryIndexArray, int index, int val) {
		while (index < binaryIndexArray.length) {
			binaryIndexArray[index] += val;
			index = getNext(index);
		}

	}

	int getSum(int[] binaryIndexArray,int index) {
		index = index+1;
		int sum=0;
		while (index > 0) {
			sum+=binaryIndexArray[index];
			index=getParent(index);
		}
		return sum;
	}

	public int getNext(int index) {
		return index + (index & -index);
	}

	public int getParent(int index){
		return index-(index & -index);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryIndexTree bit = new BinaryIndexTree();
		System.out.println("prinitng");
		int[] inputArray = { 3, 2, -1, 6, 0, 4, -3, 3, 7, 2, 3 };
		int[] binaryIndexArray = bit.getBinaryIndexArray(inputArray);

		// printing binaryIndexArray
		for (int i = 0; i < binaryIndexArray.length; i++) {
			System.out.print(binaryIndexArray[i] + "->");
		}
		
		int sum = bit.getSum(binaryIndexArray, 3);
		System.out.println("\n"+sum);

	}

}
