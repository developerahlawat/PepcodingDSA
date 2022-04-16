package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixConversion {
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();

	    infix(exp);
	 }
	
	public static void infix(String str) {
		Stack<String> st1=new Stack<>();//prefix
		Stack<String> st2=new Stack<>();//postfix
		Stack<Character> st3=new Stack<>();//operators
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch>='a' && ch<='z') {
				st1.push(ch+"");
				st2.push(ch+"");
			}
			else if(ch=='(')
				st3.push(ch);
			else if(ch==')') {
				while(st3.peek()!='(') {
					char oprtr=st3.pop();
					String op2=st1.pop();
					String op1=st1.pop();
					st1.push(oprtr+op1+op2);					

					String o2=st2.pop();
					String o1=st2.pop();
					st2.push(o1+o2+oprtr);
				}
				//finally pop the opening bracket
				st3.pop();
			}else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				while(st3.size()>0 && precedence(st3.peek())>=precedence(ch)) {
					char oprtr=st3.pop();
					String op2=st1.pop();
					String op1=st1.pop();
					st1.push(oprtr+op1+op2);					

					String o2=st2.pop();
					String o1=st2.pop();
					st2.push(o1+o2+oprtr);
				}
				//
				st3.push(ch);
			}
			
		}
		while(st3.size()!=0) {
			char oprtr=st3.pop();
			String op2=st1.pop();
			String op1=st1.pop();
			st1.push(oprtr+op1+op2);					

			String o2=st2.pop();
			String o1=st2.pop();
			st2.push(o1+o2+oprtr);
		}

		System.out.println(st2.peek());
		System.out.println(st1.peek());

	}
	
	
	public static int precedence(char ch) {
		if(ch=='*'|| ch=='/')
			return 2;
		else if(ch=='+'||ch=='-')
			return 1;
		else
			return 0;
	}
}
