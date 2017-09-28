package com.company;

public class Main {
    //Sometimes it is okay to have some member variable
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);

        int test;
        test = largestBSTSubtree(root);

    }

    static int max = 1;
    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //return int[]
        //first elemet: If it is BST, it means the size.  If it is not BST, value is -1.
        //second element means smallest val
        //third element means largerst val
        int[] res = helper(root);
        return max;
    }

    static int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] temp1 = helper(root.left);
        int[] temp2 = helper(root.right);

        if (temp1[0] != -1 && temp2[0] != -1 && root.val > temp1[2] && root.val < temp2[1]) {
            int size = 1+temp1[0]+temp2[0];
            max = Math.max(max, size);

            int leftVal = temp1[1];
            int rightVal = temp2[2];
            if (temp1[0] == 0) {
                leftVal = root.val;
            }
            if (temp2[0] == 0) {
                rightVal = root.val;
            }
            return new int[] {size, leftVal, rightVal};
        } else {
            return new int[] {-1, 0, 0};
        }
    }
}
