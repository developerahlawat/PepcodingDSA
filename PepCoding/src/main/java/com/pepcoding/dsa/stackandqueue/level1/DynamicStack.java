package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.pepcoding.dsa.stackandqueue.level1.NormalStack.CustomStack;

public class DynamicStack {
	public static class CustomStack {
		int[] data;
		int tos;

		public CustomStack(int cap) {
			data = new int[cap];
			tos = -1;
		}

		int size() {
			return tos+1;
		}

		void display() {
			for (int i = tos; i >=0; i--) {
				System.out.print(data[i]+"");
				
			}
			System.out.println();
		}

		void push(int val) {
			if (tos == data.length - 1) {
				int[] oa=data;
				data=new int[2* oa.length];
				for (int i = 0; i < oa.length; i++) {
					data[i]=oa[i];
				}
			}
			tos++;
			data[tos] = val;
		}

		int pop() {
			if (tos == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			int rv = data[tos];
			tos--;
			return rv;
		}

		int top() {
			if (tos == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			int rv = data[tos];
			return rv;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		CustomStack st = new CustomStack(n);

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
			} else if (str.startsWith("display")) {
				st.display();
			}
			str = br.readLine();
		}
	}
}
