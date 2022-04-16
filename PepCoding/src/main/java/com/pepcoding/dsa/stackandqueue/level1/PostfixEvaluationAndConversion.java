package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixEvaluationAndConversion {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Integer> st1=new Stack<>();//eva
		Stack<String> st2=new Stack<>();//infix
		Stack<String> st3=new Stack<>();//post
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch>='0'&& ch<='9') {
				st1.push(ch-'0');
				st2.push(ch+"");
				st3.push(ch+"");
			}
			else {
				int op2=st1.pop();
				int op1=st1.pop();
				int res=solve(op1, op2, ch);
				st1.push(res);
				
				String o2=st2.pop();
				String o1=st2.pop();
				String r="("+o1+ch+o2+")";
				st2.push(r);
				
				String p2=st3.pop();
				String p1=st3.pop();
				String re=ch+p1+p2;
				st3.push(re);
				
				
			}
		}
		System.out.println(st1.pop());
		System.out.println(st2.pop());
		System.out.println(st3.pop());
	}

	public static int solve(int op1, int op2, char oprtr) {
		if (oprtr == '+')
			return op1 + op2;
		else if (oprtr == '-')
			return op1 - op2;
		else if (oprtr == '*')
			return op1 * op2;
		else
			return op1 / op2;

	}
}
