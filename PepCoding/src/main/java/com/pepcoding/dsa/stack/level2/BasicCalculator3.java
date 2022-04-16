package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BasicCalculator3 {
	 // basic calculator 3
    private static int evaluate(int val1, int val2, char op) {
        if(op == '*') {
            return val1 * val2;
        } else if(op == '/') {
            return val1 / val2;
        } else if(op == '+') {
            return val1 + val2;
        } else if(op == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }

    private static int priority(char op) {
        if(op == '/' || op =='*') {
            return 2; 
        } else if(op == '+' || op =='-') {
            return 1;
        } else {
            return 0;
        }
    }
    
    
    // infix evaluation
    private static int infixEval(String exp) {
        Stack<Integer> vstack = new Stack<>(); // value stack
        Stack<Character> ostack = new Stack<>(); // operator stack
  
        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch == ' ') {
                continue;
            } else if(ch >= '0' && ch <= '9') {
                int j = i;
                StringBuilder n = new StringBuilder();
                while(j < exp.length() && exp.charAt(j) >='0' && exp.charAt(j) <= '9') {
                    n.append(exp.charAt(j));
                    j++;
                }
                i = j - 1;
                if(n.toString().equals("2147483648") == true) {
                    vstack.push(-2147483648);
                } else {
                    vstack.push(Integer.parseInt(n.toString()));
                }
            } else if(ch =='(') {
                ostack.push(ch);
            } else if(ch == ')') {
                while(ostack.peek() != '(') {
                    char op = ostack.pop();
                    int v2 = vstack.pop();
                    int v1 = vstack.pop();

                    // res = val1 operator val2
                    int res = evaluate(v1, v2, op);
                    vstack.push(res);
                }
                ostack.pop(); // this pop is for opening bracket
            } else {
                // ch = operators
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)) {
                    char op = ostack.pop();
                    int v2 = vstack.pop();
                    int v1 = vstack.pop();

                    // res = val1 operator val2
                    int res = evaluate(v1, v2, op);
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }

        while(ostack.size() > 0) {
            char op = ostack.pop();
            int v2 = vstack.pop();
            int v1 = vstack.pop();

            // res = val1 operator val2
            int res = evaluate(v1, v2, op);
            vstack.push(res);
        }
        return vstack.peek();
    }

    public static int calculate(String s) {
        // Write your code here
        return infixEval(s);
    }



  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}
