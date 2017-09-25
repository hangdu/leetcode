package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> test;
        test = verticalOrder(root);
    }

    static class Element {
        TreeNode node;
        int index;
        public Element(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //BFS is needed
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));
        while (!queue.isEmpty()) {
            Element temp = queue.poll();
            int index = temp.index;
            if (map.containsKey(index)) {
                map.get(index).add(temp.node.val);
            } else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(temp.node.val);
                map.put(index, list1);
            }

            if (index < min) {
                min = index;
            }
            if (index > max) {
                max = index;
            }

            if (temp.node.left != null) {
                queue.add(new Element(temp.node.left, temp.index-1));
            }

            if (temp.node.right != null) {
                queue.add(new Element(temp.node.right, temp.index+1));
            }
        }

        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}
