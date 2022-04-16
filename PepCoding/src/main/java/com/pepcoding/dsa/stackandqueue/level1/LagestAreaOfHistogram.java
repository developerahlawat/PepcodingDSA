package com.pepcoding.dsa.stackandqueue.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LagestAreaOfHistogram {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] nsr =new int[n];
		int[] nsl=new int[n];
		
		Stack<Integer> st=new Stack<>();
		for(int i=arr.length-1;i>=0;i--) {
			//pop all smaller elements
			while(st.size()>0 && arr[st.peek()]>=arr[i]) {
				st.pop();
			}
			//update ans
			if(st.size()==0)
				nsr[i]=arr.length;
			else
				nsr[i]=st.peek();
			
			//push curr index in the stack
			st.push(i);
		}
		
		st=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			//pop all smaller elements
			while(st.size()>0 && arr[st.peek()]>=arr[i]) {
				st.pop();
			}
			//update ans
			if(st.size()==0)
				nsl[i]=-1;
			else
				nsl[i]=st.peek();
			
			//push curr index in the stack
			st.push(i);
		}
		
		int ans=0;
		for(int i=0;i<arr.length;i++)
			ans=Math.max(ans, arr[i]*(nsr[i]-nsl[i]-1));
		
		System.out.println(ans);
		
	}
}
