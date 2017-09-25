package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
//
        int test;
        test = longestConsecutive(root);
    }

    public static int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = helper(root, root.val-1, 0, 0);
        return res;
    }


    //What do you want to return?
    //return the maximum level contains pre node
    static int helper(TreeNode root, int pre, int level, int res) {
        if (root == null) {
            res = Math.max(res, level);
            return res;
        }

        //compare root.val and pre
        if (root.val == pre + 1) {
            int temp1 =  helper(root.left, root.val, level+1, res);
            int temp2 = helper(root.right, root.val, level+1, res);
            return Math.max(temp1, temp2);
        } else {
            res = Math.max(res, level);
            int temp1 = Integer.MIN_VALUE;
            int temp2 = Integer.MIN_VALUE;
            if (root.left != null) {
                temp1 = helper(root.left, root.val, 1, res);
            }
            if (root.right != null) {
                temp2 = helper(root.right, root.val, 1, res);
            }
            int temp = Math.max(temp1, temp2);
            return Math.max(res, temp);
        }
    }
}
