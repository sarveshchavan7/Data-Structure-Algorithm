package com.sarvesh.basicInterviewQ;

public class BasicInterviewQue {
	// Reverse a String in place
	public void reverseString(String a[]) {
		for (int i = 0, j = a.length - 1; i < j; i++, j--) {
			String temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	// Reverse a number and also take care of negative numbers
	public int reverseInt(int a) {
		int x = a;
		int rem=0;
		int prev=0;
		while (x > 0) {
			rem = x%10;
			x = x / 10;
			prev =prev*10+rem;
		}
		return prev;
	}

	// given a set of numbers print the next number in the sequence

	public static void main(String args[]) {
		String a[] = { "S", "A", "R", "V", "E", "S", "H" };
		BasicInterviewQue b = new BasicInterviewQue();
		b.reverseString(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "->");
		}
		
		int x = b.reverseInt(532108);
		System.out.println(x);
	}
}
