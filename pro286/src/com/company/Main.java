package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] rooms = new int[4][4];
        int INF = Integer.MAX_VALUE;
        int[] p0 = {INF, -1,  0,  INF};
        int[] p1 = {INF, INF, INF,  -1};
        int[] p2 = {INF,  -1, INF,  -1};
        int[] p3 = {0,  -1, INF, INF};
        rooms[0] = p0;
        rooms[1] = p1;
        rooms[2] = p2;
        rooms[3] = p3;
        wallsAndGates(rooms);


    }

    public static void wallsAndGates(int[][] rooms) {
        //BFS
//        -1 - A wall or an obstacle.
//        0 - A gate
//        INF - Infinity means an empty room.
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int currow = cur[0];
                int curcol = cur[1];

                int row;
                int col;

                //up
                row = currow-1;
                col = curcol;
                if (row >= 0) {
                    if (rooms[row][col] == Integer.MAX_VALUE && !visited[row][col]) {
                        visited[row][col] = true;
                        rooms[row][col] = level;
                        queue.add(new int[] {row, col});
                    }
                }

                //down
                row = currow+1;
                if (row < m) {
                    if (rooms[row][col] == Integer.MAX_VALUE && !visited[row][col]) {
                        visited[row][col] = true;
                        rooms[row][col] = level;
                        queue.add(new int[] {row, col});
                    }
                }

                //left
                row = currow;
                col = curcol-1;
                if (col >= 0) {
                    if (rooms[row][col] == Integer.MAX_VALUE && !visited[row][col]) {
                        visited[row][col] = true;
                        rooms[row][col] = level;
                        queue.add(new int[] {row, col});
                    }
                }

                //right
                row = currow;
                col = curcol + 1;
                if (col < n) {
                    if (rooms[row][col] == Integer.MAX_VALUE && !visited[row][col]) {
                        visited[row][col] = true;
                        rooms[row][col] = level;
                        queue.add(new int[] {row, col});
                    }
                }
            }
            level++;
        }

    }
}
