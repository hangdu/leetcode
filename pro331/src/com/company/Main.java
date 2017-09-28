package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }



    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) {
            return false;
        }
        String[] array = preorder.split(",");
        Stack<Character> stack = new Stack();
        int count = 0;
        //'1'represent some number
        //'#' represent null node
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[0].equals("#")) {
                    return false;
                }

                stack.push('1');
                continue;
            }

            if (array[i].equals("#")) {
                if (stack.peek() == '#') {
                    if (stack.size() < 2) {
                        return false;
                    }
                    stack.pop();
                    stack.pop();
                    count++;

                    if (count % 2 == 0) {
                        //pop out root
                        if (stack.size() == 0) {
                            return false;
                        }

                        stack.pop();
                    }
                } else {
                    stack.push('#');
                }
            } else {
                stack.push('1');
            }
        }

        return stack.isEmpty();

    }
}
