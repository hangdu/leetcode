package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int parent1 = find(parent, edge[0]);
            int parent2 = find(parent, edge[1]);

            if (parent1 == parent2) {
                continue;
            }
            //make a union
            parent[parent1] = parent2;
        }

        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                res++;
            }
        }
        return res;
    }

    int find(int[] parent, int node) {
        if (node == parent[node]) {
            return node;
        }

        return find(parent, parent[node]);
    }
}
