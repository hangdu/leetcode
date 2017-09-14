package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {6,2,4};
        boolean test;
        test = verifyPreorder(nums);
    }


    public static boolean verifyPreorder(int[] preorder) {
        if (preorder.length < 2) {
            return true;
        }

        boolean flag = helper(preorder, 0, preorder.length-1);
        return flag;
    }

    static boolean helper(int[] preorder, int start, int end) {
        //root left right
        if (start >= end || start + 1 == end) {
            return true;
        }

        int root = preorder[start];
        int i = start+1;
        for(; i <= end; i++) {
            if (preorder[i] > root) {
                break;
            }
        }

        //validate from index i to end, all the element must > root
        for (int j = i; j <= end; j++) {
            if (preorder[j] < root) {
                return false;
            }
        }

        return helper(preorder, start+1, i-1) && helper(preorder, i, end);
    }
}
