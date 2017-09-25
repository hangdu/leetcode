package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] edges = new int[3][2];
        edges[0][0] = 3;
        edges[0][1] = 4;

        edges[1][0] = 2;
        edges[1][1] = 3;

        edges[2][0] = 1;
        edges[2][1] = 2;

//        edges[3][0] = 8;
//        edges[3][1] = 7;
//
//        edges[4][0] = 5;
//        edges[4][1] = 7;
//
//        edges[5][0] = 8;
//        edges[5][1] = 9;
//
//        edges[6][0] = 2;
//        edges[6][1] = 4;
//
//        edges[7][0] = 3;
//        edges[7][1] = 7;
//
//        edges[8][0] = 1;
//        edges[8][1] = 5;
//
//        edges[9][0] = 4;
//        edges[9][1] = 7;

        int[] test;
        test = findRedundantConnection(edges);
    }


    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) return edge;
            else parent[find(parent, f)] = find(parent, t);
        }

        return new int[2];
    }

    private static int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }
        return parent[f];
    }

}
