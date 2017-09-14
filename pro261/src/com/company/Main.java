package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 5;
        int[][] edges = new int[3][5];
        edges[0][1] = 1;
        edges[0][2] = 1;
        edges[1][2] = 1;
        edges[2][3] = 1;
        edges[2][4] = 1;

        boolean test;
        test = validTree(n, edges);


    }


    static public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            if (n < 2) {
                return true;
            } else {
                return false;
            }
        }
        //In this case, we don't know the size of edges.
        //BFS
        for (int i = 0; i < n; i++) {
            boolean flag = bfs(n, edges, i);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    static boolean bfs(int n, int[][] edges, int root) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(new int[] {root, Integer.MAX_VALUE});
        visited[root] = true;

        //Each node need to know its parent.
        int totalRow = edges.length;
        int totalCol = edges[0].length;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] array = queue.poll();
                int node = array[0];
                int parent = array[1];
                //find all the children of this node
                //when row = temp
                for (int i = 0; i < n; i++) {
                    //check whether node and i are connected
                    boolean connected = false;
                    if (node < totalRow && i < totalCol && edges[node][i] == 1) {
                        connected = true;
                    } else if (i < totalRow && node < totalCol && edges[i][node] == 1) {
                        connected = true;
                    }

                    if (connected) {
                        if (visited[i]) {
                            if (i == parent) {
                                continue;
                            } else {
                                return false;
                            }
                        } else {
                            visited[i] = true;
                            queue.add(new int[] {i, node});
                        }
                    }
                }
            }

        }
        return true;
    }
}
