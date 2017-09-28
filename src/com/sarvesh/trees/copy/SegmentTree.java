package com.sarvesh.trees.copy;

/*
 * Segment Tree -min segment tree/max segment tree
 * 
 * In array - left child -  2*i+1
 *			  right child - 2*i+2
 *			  parent  = (i-1)/2		 
 *
 * overlap hint - tree interval should be inside the given interval
 * 		  eg - suppose tree interval (0,5) and given interval is (0,4)
 * 			   so if the tree interval(0,5) does not lies inside the given interval(0,4) in this case it does'nt lies
 * 			   then it's a partial overlap that mean in other words 0,4 does't not totally overlap(partial overlap) on (0,5)	
 * 	 			(0,5)=(low,high) and (0,4)=(qlow,qhigh)
 * 				so our low and high should lies inside of qlow and qhigh
 * 
 * searching in seg tree - in worst case we will go in 4 dept so time complexity is 4logn =O(logn) 
 * 
 * 
 */
public class SegmentTree {
	int[] seg = new int[7];
	int[] input = { 4, -1, 2, 1 };

	SegmentTree() {

	}

	void createMinSegTree(int[] input, int[] seg, int low, int high, int pos) {
		if (low == high) {
			seg[pos] = input[high];
			return;
		}
		int mid = (low + high) / 2;
		createMinSegTree(input, seg, low, mid, 2 * pos + 1);
		createMinSegTree(input, seg, mid + 1, high, 2 * pos + 2);
		seg[pos] = min(seg[2 * pos + 1], seg[2 * pos + 2]);
		return;
	}

	int min(int a, int b) {
		return (a < b ? a : b);
	}

	int rangeMiniumQueryUtils(int qlow, int qhigh, int low, int high, int index) {
		// Total overlap return the value at he index
		if (qlow <= low && qhigh >= high) {
			return seg[index];
		}
		// Not at all overlap return the max value
		else if (low > qhigh || high < qlow) {
			return Integer.MAX_VALUE;
		}
		// It's a partial over lap go in both the directions

		else {
			int mid = (low + high) / 2;
			int valueOne = rangeMiniumQueryUtils(qlow, qhigh, low, mid, 2 * index + 1);
			int valueTwo = rangeMiniumQueryUtils(qlow, qhigh, mid + 1, high, 2 * index + 2);
			return min(valueTwo, valueOne);
		}
	}

	int rangeMiniumQuery(int qlow, int qhigh) {
		int low = 0;
		int high = input.length - 1;
		int index = 0;
		int minValue = rangeMiniumQueryUtils(qlow, qhigh, low, high, index);
		return minValue;
	}

	// updating seg tree with out lazy tree
	void updateSegmentTreeRange(int qlow, int qhigh, int delta) {
		int low = 0;
		int high = input.length - 1;
		int index = 0;
		updateSegmentTreeRangeUtil(qlow, qhigh, low, high, index, delta);
	}

	int updateSegmentTreeRangeUtil(int qlow, int qhigh, int low, int high, int index, int delta) {

		if (qlow <= low && qhigh >= high) {

			if (low == high) {
				return seg[index] += delta;
			}
		}

		if (low > qhigh || high < qlow) {
			return Integer.MAX_VALUE;
		}

		int mid = (low + high) / 2;
		/* 1 */ int valueOne = updateSegmentTreeRangeUtil(qlow, qhigh, low, mid, 2 * index + 1, delta);
		/* 2 */ int valueTwo = updateSegmentTreeRangeUtil(qlow, qhigh, mid + 1, high, 2 * index + 2, delta);
		return seg[index] = min(valueOne, valueTwo);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SegmentTree st = new SegmentTree();
		st.createMinSegTree(st.input, st.seg, 0, st.input.length - 1, 0);
		for (int i = 0; i < st.seg.length; i++) {
			System.out.print(st.seg[i] + " -> ");
		}

		int value = st.rangeMiniumQuery(1, 3);
		System.out.println("\nMin is " + value);

		st.updateSegmentTreeRange(1, 3, 1);

		for (int i = 0; i < st.seg.length; i++) {
			System.out.print(st.seg[i] + " -> ");
		}

	}

}
