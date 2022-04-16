package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinStacksConstantSpace {
	public static class MinStack {
		Stack<Integer> allData;
		int minData;

		public MinStack() {
			allData = new Stack<>();
		}

		int size() {
			return allData.size();
		}

		void push(int val) {
			if (allData.size() == 0) {
				allData.push(val);
				minData = val;
			} else {
				if (val < minData) {
					allData.push(val + val - minData);//detection,storing a fake smaller value
					minData = val;	// original value stored in min				
				} else
					allData.push(val);
			}
		}

		int pop() {
			if (allData.size() == 0) {
				System.out.println("Stack undeflow");
				return -1;
			} else {
				if (allData.peek() < minData) {
					int orignal=minData; 
					minData=minData+minData-allData.pop();
					return orignal;
				} else
					return allData.pop();
			}
		}

		int top() {
			if (allData.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			} else {
				if (allData.peek() < minData) {
					return minData;
				} else
					return allData.peek();
			}
		}

		int min() {
			if (allData.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			} else {
				return minData;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MinStack st = new MinStack();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("push")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push(val);
			} else if (str.startsWith("pop")) {
				int val = st.pop();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("top")) {
				int val = st.top();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(st.size());
			} else if (str.startsWith("min")) {
				int val = st.min();
				if (val != -1) {
					System.out.println(val);
				}
			}
			str = br.readLine();
		}
	}
}
