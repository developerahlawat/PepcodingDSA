package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation {
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();

	    System.out.println(infix(exp));
	 }
	
	public static int infix(String str) {
		Stack<Integer> st1=new Stack<>();//operands
		Stack<Character> st2=new Stack<>();//operators
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch>='0' && ch<='9')
				st1.push(ch-'0');
			else if(ch=='(')
				st2.push(ch);
			else if(ch==')') {
				while(st2.peek()!='(') {
					char oprtr=st2.pop();
					int op2=st1.pop();
					int op1=st1.pop();
					int res=solve(op1,op2,oprtr);
					st1.push(res);
				}
				//finally pop the opening bracket
				st2.pop();
			}else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				while(st2.size()>0 && precedence(st2.peek())>=precedence(ch)) {
					char oprtr=st2.pop();
					int op2=st1.pop();
					int op1=st1.pop();
					int res=solve(op1,op2,oprtr);
					st1.push(res);
				}
				//
				st2.push(ch);
			}
			
		}
		while(st2.size()!=0) {
			char oprtr=st2.pop();
			int op2=st1.pop();
			int op1=st1.pop();
			int res=solve(op1,op2,oprtr);
			st1.push(res);
		}
		return st1.peek();
	}
	
	public static int solve(int op1,int op2,char oprtr) {
		if(oprtr=='+') 
			return op1+op2;			
		else if(oprtr=='-')
			return op1-op2;
		else if(oprtr=='*')
			return op1*op2;
		else 
			return op1/op2;
		
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
