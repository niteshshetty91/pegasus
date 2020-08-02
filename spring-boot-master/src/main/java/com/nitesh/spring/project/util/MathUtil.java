package com.nitesh.spring.project.util;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class MathUtil {

	public static void main(String args[]) {


		//String exp ="(6-5)";
		String exp = "(2+4+4+6)*5+3+4/2*6/3-7+((3-1)+4)"; 
		//String exp = "2+4+4+6*5+3+4/2*6/3-7+((3-1)+4)"; 
		//String exp = "8-7+(((3-1))-(4/2))"; 

		//00String exp = "16*5+3+4/2*6/3-7+2+4"; 

		//String exp = "(2+4)*5"; 
		evaluate(exp);

		//System.out.println(isOperatorString("+"));

		//System.out.println(isNumericString("0"));
	}

	public static String evaluate(String exp) {

		ArrayBlockingQueue<String> s = prepare(exp);

		//String prevNumber="0";
		String currOperator = "";
		String total="0";

		while(!s.isEmpty()) {

			String token = s.remove();

			if(isOperatorString(token)) {
				currOperator=token;

			}else if(isNumericString(token)) {

				if(!currOperator.equalsIgnoreCase("")) {

					total = calculate(total,currOperator,token);

				}else {
					total=token;
				}

			}else {

				total = calculate(total,currOperator,evaluate(token));


			}

		}
		System.out.println("Final Output "+total);
		return total;
	}

	private static String calculate(String total, String currOperator, String num) {

		double doubleTotal=Double.parseDouble(total);
		double doubleNum=Double.parseDouble(num);

		if(currOperator.equalsIgnoreCase("+")||currOperator.equalsIgnoreCase("")) {

			doubleTotal = doubleTotal + doubleNum;

		}else if(currOperator.equalsIgnoreCase("-")) {

			doubleTotal = doubleTotal - doubleNum;

		}else if(currOperator.equalsIgnoreCase("/")) {

			doubleTotal = doubleTotal / doubleNum;

		}else if(currOperator.equalsIgnoreCase("*")) {

			doubleTotal = doubleTotal * doubleNum;

		}

		String total1=String.valueOf(doubleTotal);

		return total1;

	}

	private static ArrayBlockingQueue<String> prepare(String exp) {

		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);

		char c[] = exp.toCharArray();


		boolean subExpFlag=false;	
		boolean numericFlag=false;	

		int bracketCnt = 0;


		String subExp = new String("");
		String numExp = new String("");

		for(int i=0;i<c.length;i++) {

			char ch = c[i];

			if(ch == '(') {

				if(subExpFlag==false) {
					subExp=new String("");
					subExpFlag=true;
					++bracketCnt;
					continue;
				}


			}else if(ch == ')') {

				--bracketCnt;

				if(bracketCnt==0) {

					queue.add(subExp);
					subExp=new String("");
					subExpFlag=false;
					continue;

				}

			}else if(subExpFlag){

				subExp=subExp+ch;

			}else if(isOperatorChar(ch)) {

				if(numericFlag==true) {

					queue.add(numExp);
					numericFlag=false;
					numExp= new String("");
				}

				queue.add(""+ch);

			}else if(isNumericChar(ch)) {

				numericFlag=true;	
				numExp=numExp+ch;


			}

			if(i==(c.length-1)) {
				queue.add(numExp);
			}

		}

		System.out.println(queue);

		return queue;
	}

	private static boolean isOperatorChar(char c) {

		if(c=='+' || c=='-' || c=='/' || c=='*' || c== '%') {
			return true;	
		}else {
			return false;
		}
	}

	private static boolean isOperatorString(String c) {

		if(c.equalsIgnoreCase("+") || c.equalsIgnoreCase("-") || c.equalsIgnoreCase("/") || c.equalsIgnoreCase("*") || c.equalsIgnoreCase("%")) {
			return true;	
		}else {
			return false;
		}
	}



	private static boolean isNumericChar(char c) {

		if(c=='0' || c=='1' || c=='2' || c=='3' ||c=='4' ||c=='5' ||c=='6' ||c=='7' ||c=='8' ||c=='9') {
			return true;
		}else {
			return false;
		}
	}

	private static boolean isNumericString(String c) {

		//String regex = "[0-9]+";
		//String regex = "\\d+";

		if(c.matches("\\d+")) {
			return true;
		}else {
			return false;
		}
	}


}
