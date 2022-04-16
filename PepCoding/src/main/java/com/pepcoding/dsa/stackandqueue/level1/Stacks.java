 package com.pepcoding.dsa.stackandqueue.level1;

import java.util.Stack;

public class Stacks {
	public static void main(String[]  args) {
		Stack<Integer> st=new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		System.out.println(st);
		
		System.out.println(st.peek());
		
		while(st.size()!=0) {
			System.out.println(st.pop());
		}
		
	}

}
