package com.sarvesh.D_Stack;

public class evaluateThePostFix {

	public boolean isOperator(String value) {
		if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") || value.equals("^")) {
			return true;
		} else {
			return false;
		}
	}

	public String performOperation(String value, Object a1, Object a2) {
		String x = (String) a1;
		int intValueX = Integer.parseInt(x);
		String y = (String) a2;
		int intValueY = Integer.parseInt(y);
		if (value.equals("+")) {
			int z = intValueY+intValueX;
			return Integer.toString(z);
		}else if(value.equals("-")){
			int z = intValueY-intValueX;
			return Integer.toString(z);
		}else if(value.equals("*")){
			int z = intValueY*intValueX;
			return Integer.toString(z);
		}else if(value.equals("/")){
			int z = intValueY/intValueX;
			return Integer.toString(z);
		}else{
			int z = intValueY^intValueX;
			return Integer.toString(z);
		}
	}

	public void evaluatePostFix(String a[]) {
		Stack_l s = new Stack_l();
		for (int i = 0; i < a.length; i++) {
			if (isOperator(a[i])) {
				Object pop1 = s.pop();
				Object pop2 = s.pop();
				String finalValue = performOperation(a[i], pop1, pop2);
				s.push(finalValue);
			} else {
				s.push(a[i]);
			}
		}
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	public static void main(String args[]){
		evaluateThePostFix e = new evaluateThePostFix();
		String array[]={"2","3","+","5","6","+","*"};
		e.evaluatePostFix(array);
	}
}
