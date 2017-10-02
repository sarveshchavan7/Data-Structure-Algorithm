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
		int rem = 0;
		int prev = 0;
		while (x > 0) {
			rem = x % 10;
			x = x / 10;
			prev = prev * 10 + rem;
		}
		return prev;
	}

	// given a set of numbers print the next number in the sequence

	// Power set
	// Find all the subsets of a given set

	// Return max occurring char in an input string
	// so if we have test the max occurring char is t
	// The idea is to travel each char and count the number of times it occur
	// and store the count using hashing
	// if there are more then two element occurring exactly same time then
	// return the first char(if we want to return the last char then just use <=
	// in if of the last for loop)
	public char getMaxOccurringChar(String str) {
		int len = str.length();
		int ASCII_SIZE = 256;
		int count[] = new int[ASCII_SIZE];
		for (int i = 0; i < len; i++) {
			count[str.charAt(i)]++;
		}
		int max = -1;
		char result = ' ';
		for (int i = 0; i < len; i++) {
			if (max <= count[str.charAt(i)]) {
				max = count[str.charAt(i)];
				result = str.charAt(i);
			}
		}
		return result;
	}

	//fibonacci using recursion - each number is the sum of two preceding no
	public void fibonacci(int x, int y, int curr, int n) {
		if (n < x) {
			return;
		}
		System.out.print(x + "->");
		x = y;
		y = curr;
		curr = x + y;
		fibonacci(x, y, curr, n);
	}

	public static void main(String args[]) {
		String a[] = { "S", "A", "R", "V", "E", "S", "H" };
		BasicInterviewQue b = new BasicInterviewQue();
		b.reverseString(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "->");
		}

		int x1 = b.reverseInt(532108);
		System.out.println(x1);
		String mam = "mamaiyi";
		char no = b.getMaxOccurringChar(mam);
		System.out.println(no);
		int x = 0;
		int y = 1;
		int curr = x+y;
		System.out.println();
		b.fibonacci(x, y, curr, 21);
	}
}
