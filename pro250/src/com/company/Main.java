package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(5);

        int test;
        test = countUnivalSubtrees(root);
    }

    public static int countUnivalSubtrees(TreeNode root) {
    //recursively return int[]
        //The first value means whether this node is univalTree.
        //The second value means count of univalSubtrees
        if (root == null) {
            return 0;
        }

        int[] res = helper(root);
        return res[1];
    }

    static int[] helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new int[] {1,1};
        }

        int[] temp1 = helper(root.left);
        int[] temp2 = helper(root.right);

        if (temp1 == null) {
            //only consider right childer
            if (temp2[0] == 1) {
                if (root.val == root.right.val) {
                    return new int[] {1, 1 + temp2[1]};
                } else {
                    return new int[] {0, temp2[1]};
                }
            } else {
                return new int[] {0, temp2[1]};
            }
        }

        if (temp2 == null) {
            //only consider left tree
            if (temp1[0] == 1) {
                if (root.val == root.left.val) {
                    return new int[] {1, 1 + temp1[1]};
                } else {
                    return new int[] {0, temp1[1]};
                }
            } else {
                return new int[] {0, temp1[1]};
            }

        }

        if (temp1[0] == 1 && temp2[0] == 1 && root.val == root.left.val && root.val == root.right.val) {
            return new int[] {1, 1+temp1[1]+temp2[1]};
        } else {
            return new int[] {0, temp1[1] + temp2[1]};
        }
    }
}
