package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    static public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int parent1 = find(parent, edge[0]);
            int parent2 = find(parent, edge[1]);
            if (parent1 == parent2) {
                return false;
            }

            //union
            parent[parent1] = parent2;
        }

        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int find(int[] parent, int node) {
        if (node == parent[node]) {
            return node;
        }
        return find(parent, parent[node]);
    }
}
