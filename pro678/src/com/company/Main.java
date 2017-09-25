package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean test;
        test = checkValidString("(*))");
    }

    public static boolean checkValidString(String s) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() == 1) {
            if (s.charAt(0) == '*') {
                return true;
            }else {
                return false;
            }
        }
        Stack<Character> stack = new Stack();
        return helper(s, stack, 0, s.charAt(0));
    }

    static boolean helper(String s, Stack<Character> stack, int start, char cur) {

        if (start == s.length()) {
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        if (s.length() - start < stack.size()) {
            return false;
        }

        if (cur == ')') {
            if (stack.isEmpty()) {
                return false;
            }

            char temp = stack.pop();
            if (temp == ')') {
                stack.push(temp);
                return false;
            } else {
                boolean flag = helper(s, stack, start+1, (start+1 < s.length())?s.charAt(start+1):'0');
                if (flag) {
                    return true;
                } else {
                    stack.push(temp);
                    return false;
                }
            }
        } else if (cur == '(') {
            stack.push(cur);
            boolean flag = helper(s, stack, 1+start, (start+1 < s.length())?s.charAt(start+1):'0');
            if (flag) {
                return true;
            } else {
                stack.pop();
                return false;
            }

        } else {
            //it is *
            //case1:regard c as empty
            boolean flag1 = helper(s, stack, 1+start, (start+1 < s.length())?s.charAt(start+1):'0');
            if (flag1) {
                return true;
            }

            boolean flag2 = helper(s, stack, start, '(');
            if (flag2) {
                return true;
            }

            boolean flag3 = helper(s, stack, start, ')');
            return flag3;
        }
    }
}
