package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementOnRight {
	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int[] nge = ngr(a);
		display(nge);
	}

	// ========================
    // next greater--first method
    // ========================
    // ngr -> next greater on right
    private static int[] ngr(int[] arr) {
        Stack<Integer> st = new Stack<>();
        // push index in stack
        int[] res = new int[arr.length];
        st.push(0);
        for(int i = 1; i < arr.length; i++) {
            while(st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] =arr[i];
            }
            st.push(i);
        }
        while(st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }
    //---second method
  private static int[] ngr1(int[] arr) {
       	Stack<Integer> st = new Stack<>();
		// -a+
		int[] res = new int[arr.length];
		st.push(arr[arr.length-1]);
		res[arr.length-1]=-1;
		
		for (int i = arr.length-2; i >=0; i--) {
			while (st.size() > 0 &&  arr[i]>=st.peek() ) {
				st.pop();
			}
			if(st.size()==0)
				res[i]=-1;
			else
				res[i]=st.peek();
			
			st.push(arr[i]);
		}
		return res;
	
    }

}