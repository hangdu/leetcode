package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] grid = new int[1][3];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 0;

        int test;
        test = shortestDistance(grid);

    }

    public static int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, int[][]> map = new HashMap<>();
        for (int i = 0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int key = i * n + j;
                    int[][] matrix = new int[m][n];
                    map.put(key, matrix);
                }
            }
        }

        for (int key : map.keySet()) {
            helper(key, map.get(key), grid);
        }

        int p = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !map.containsKey(i*n+j)) {
                    boolean flag = true;
                    int sum = 0;
                    for (int key : map.keySet()) {
                        int val = map.get(key)[i][j];
                        if (val == -1 || val == 0) {
                            flag = false;
                            break;
                        } else {
                            sum+=val;
                        }
                    }
                    if (flag) {
                        if (sum < p) {
                            p = sum;
                        }
                    }
                }

            }
        }

        if (p == Integer.MAX_VALUE) {
            return -1;
        }
        return p;
    }

    static void helper(int key, int[][] matrix, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startRow = key / n;
        int startCol = key % n;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        visited[startRow][startCol] = true;
        //-1 means this position is not the final answer
        matrix[startRow][startCol] = -1;

        queue.add(new int[] {startRow, startCol});
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();

                int curRow = temp[0];
                int curCol = temp[1];

                int row;
                int col;

                //up
                row = curRow-1;
                col = curCol;
                if (row >= 0 && !visited[row][col]) {
                    if (grid[row][col] == 0) {
                        matrix[row][col] = level;
                        queue.add(new int[] {row, col});
                    } else {
                        matrix[row][col] = -1;
                    }
                    visited[row][col] = true;
                }

                //down
                row = curRow + 1;
                if (row < m && !visited[row][col]) {
                    if (grid[row][col] == 0) {
                        matrix[row][col] = level;
                        queue.add(new int[] {row, col});
                    } else {
                        matrix[row][col] = -1;
                    }
                    visited[row][col] = true;
                }

                //left
                row = curRow;
                col = curCol-1;
                if (col >= 0 && !visited[row][col]) {
                    if (grid[row][col] == 0) {
                        matrix[row][col] = level;
                        queue.add(new int[] {row, col});
                    } else {
                        matrix[row][col] = -1;
                    }
                    visited[row][col] = true;
                }

                //right
                col = curCol + 1;
                if (col < n && !visited[row][col]) {
                    if (grid[row][col] == 0) {
                        matrix[row][col] = level;
                        queue.add(new int[] {row, col});
                    } else {
                        matrix[row][col] = -1;
                    }
                    visited[row][col] = true;
                }
            }
            level++;
        }

    }
}
